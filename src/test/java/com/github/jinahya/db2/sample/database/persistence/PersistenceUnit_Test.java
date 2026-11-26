package com.github.jinahya.db2.sample.database.persistence;

/*-
 * #%L
 * db2-sample-database-persistence
 * %%
 * Copyright (C) 2026 Jinahya, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.metamodel.EntityType;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static com.github.jinahya.db2.sample.database.persistence._Entity_Persistence_Test_Producer.__TestPU;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the unit-test persistence unit: an in-memory H2 database, in DB2 mode, whose schema the
 * provider generates from the mappings.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@AddBeanClasses(_Entity_Persistence_Test_Producer.class)
@EnableAutoWeld
class PersistenceUnit_Test {

    @DisplayName("the persistence unit bootstraps")
    @Test
    void entityManagerFactory_IsOpen_() {
        assertThat(entityManagerFactory.isOpen()).isTrue();
    }

    @DisplayName("every table and view with a key is an entity with an id")
    @Test
    void metamodel_HasEveryEntityWithAnId_() {
        final var entities = entityManagerFactory.getMetamodel().getEntities();
        assertThat(entities)
                .as("entity types of %s", _Entity_Persistence_Test_Producer.PERSISTENCE_UNIT_NAME)
                .hasSize(30)
                .allSatisfy(e -> assertThat(
                        e.hasSingleIdAttribute() || !e.getIdClassAttributes().isEmpty())
                        .as("%s has an id", e.getName())
                        .isTrue());
    }

    @DisplayName("the schema generated from the mappings is queryable")
    @Test
    void generatedSchema_IsQueryable_() {
        for (final EntityType<?> e : entityManagerFactory.getMetamodel().getEntities()) {
            final var count = applyInTransactionAndRollback(
                    em -> em.createQuery("SELECT COUNT(e) FROM " + e.getName() + " e", Long.class)
                            .getSingleResult());
            assertThat(count).as("row count of %s", e.getName()).isZero();
        }
    }

    @DisplayName("an entity with an @IdClass, and a read-only association in it, round-trips")
    @Test
    void empPhoto_RoundTrips_() {
        applyInTransactionAndRollback(em -> {
            final var employee = new Employee();
            employee.setEmpno("000010");
            employee.setFirstnme("CHRISTINE");
            employee.setLastname("HAAS");
            employee.setEdlevel(18);
            em.persist(employee);
            final var photo = new EmpPhoto();
            photo.setEmployee(employee);
            photo.setPhotoFormat("png");
            photo.setPicture(new byte[]{1, 2, 3});
            em.persist(photo);
            em.flush();
            em.clear();
            final var found =
                    em.find(EmpPhoto.class, EmpPhotoId.of("000010", "png"));
            assertThat(found).isNotNull();
            assertThat(found.getPicture()).containsExactly(1, 2, 3);
            assertThat(found.getEmployee().getLastname()).isEqualTo("HAAS");
            return null;
        });
    }

    @DisplayName("an entity with a writable association persists its foreign key")
    @Test
    void employee_PersistsWorkdept_() {
        applyInTransactionAndRollback(em -> {
            final var department = new Department("A00");
            department.setDeptname("SPIFFY COMPUTER SERVICE DIV.");
            department.setAdministrativeDepartment(department);
            em.persist(department);
            final var employee = new Employee();
            employee.setEmpno("000010");
            employee.setFirstnme("CHRISTINE");
            employee.setLastname("HAAS");
            employee.setEdlevel(18);
            employee.setWorkdeptDepartment(department);
            em.persist(employee);
            em.flush();
            em.clear();
            final var found = em.find(Employee.class, "000010");
            assertThat(found.getWorkdept()).isEqualTo("A00");
            assertThat(found.getWorkdeptDepartment().getDeptname()).isEqualTo(
                    "SPIFFY COMPUTER SERVICE DIV.");
            return null;
        });
    }

    // ---------------------------------------------------------------------------------------------
    private <R> R applyInTransactionAndRollback(
            final Function<? super EntityManager, ? extends R> function) {
        final var transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            return function.apply(entityManager);
        } finally {
            transaction.rollback();
        }
    }

    // ---------------------------------------------------------------------------------------------
    @__TestPU
    @Inject
    private EntityManagerFactory entityManagerFactory;

    @__TestPU
    @Inject
    private EntityManager entityManager;
}
