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
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.EntityType;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.jinahya.db2.sample.database.persistence._Entity_Persistence_IT_Producer.__ItPU;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the mappings against the {@code SAMPLE} database of the Db2 from {@code docker-compose.yml}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@AddBeanClasses(_Entity_Persistence_IT_Producer.class)
@EnableAutoWeld
class PersistenceUnit_IT {

    @DisplayName("every entity counts the rows of its table, and loads a page of them")
    @Test
    void everyEntity_CountsAndLoads_() {
        for (final EntityType<?> e : entityManagerFactory.getMetamodel().getEntities()) {
            final var table = e.getJavaType().getAnnotation(Table.class).name();
            final var expected = ((Number) entityManager.createNativeQuery("SELECT COUNT(*) FROM " + table)
                    .getSingleResult()).longValue();
            final var actual = entityManager.createQuery("SELECT COUNT(e) FROM " + e.getName() + " e", Long.class)
                    .getSingleResult();
            assertThat(actual).as("row count of %s", e.getName()).isEqualTo(expected);
            final var page = entityManager.createQuery("SELECT e FROM " + e.getName() + " e", e.getJavaType())
                    .setFirstResult(1)
                    .setMaxResults(3)
                    .getResultList();
            assertThat(page).as("a page of %s", e.getName()).hasSize((int) Math.min(3L, Math.max(0L, expected - 1L)));
            page.forEach(v -> assertThat(v.toString()).isNotBlank());
            entityManager.clear();
        }
    }

    @DisplayName("Employee: a page in order, and the department an employee works in")
    @Test
    void employee_() {
        final var page = entityManager
                .createQuery("SELECT e FROM Employee e ORDER BY e.empno", Employee.class)
                .setFirstResult(5)
                .setMaxResults(5)
                .getResultList();
        assertThat(page).extracting(Employee::getEmpno)
                .containsExactly("000070", "000090", "000100", "000110", "000120");
        final var haas = entityManager.find(Employee.class, "000010");
        assertThat(haas.getLastname()).isEqualTo("HAAS");
        assertThat(haas.getWorkdeptDepartment().getDeptname()).isEqualTo("SPIFFY COMPUTER SERVICE DIV.");
    }

    @DisplayName("XML columns read as strings")
    @Test
    void xml_() {
        entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList()
                .forEach(c -> assertThat(c.getInfo()).as("info of %s", c.getCid()).contains("customerinfo"));
        entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList()
                .forEach(p -> assertThat(p.getDescription()).as("description of %s", p.getPid()).contains("product"));
    }

    @DisplayName("LOB columns read as bytes and as strings")
    @Test
    void lob_() {
        entityManager.createQuery("SELECT p FROM EmpPhoto p", EmpPhoto.class).getResultList()
                .forEach(p -> assertThat(p.getPicture()).as("picture of %s", p.getEmpno()).isNotEmpty());
        entityManager.createQuery("SELECT r FROM EmpResume r", EmpResume.class).getResultList()
                .forEach(r -> assertThat(r.getResume()).as("resume of %s", r.getEmpno()).contains("Resume"));
    }

    @DisplayName("an @IdClass entity finds by its id, and its composite association resolves")
    @Test
    void idClass_() {
        final var photo = entityManager.find(EmpPhoto.class, MappedEmpPhotoId.of(EmpPhotoId::new, "000130", "bitmap"));
        assertThat(photo).isNotNull();
        assertThat(photo.getEmployee().getLastname()).isEqualTo("QUINTANA");
        entityManager.createQuery("SELECT e FROM EmpProjAct e", EmpProjAct.class).getResultList()
                .forEach(e -> assertThat(e.getProjAct()).as("projAct of %s", e).isNotNull());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @__ItPU
    @Inject
    private EntityManagerFactory entityManagerFactory;

    @__ItPU
    @Inject
    private EntityManager entityManager;
}
