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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.jinahya.db2.sample.database.persistence.___PersistenceIT_Utils.applyEntityManagerFactory;
import static com.github.jinahya.persistence.util.JinahyaEntityManagerFactoryUtils.applyEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class Department_PersistenceIT
        extends _Entity_PersistenceIT<Department, String> {

    Department_PersistenceIT() {
        super(Department.class, String.class);
    }

    // ---------------------------------------------------------------------------- self-referencing

    /**
     * The department which administers every other one, at the top of the hierarchy, and which
     * administers itself. The value is {@value}.
     */
    private static final String DEPTNO_ROOT = "A00";

    @DisplayName("A00 administers itself: its department is the very same instance")
    @Test
    void department_IsItself_A00() {
        applyEntityManagerFactory(emf -> applyEntityManager(emf, em -> {
            final var root = em.find(Department.class, DEPTNO_ROOT);
            assertThat(root).isNotNull();
            assertThat(root.getAdministrativeDepartment())
                    .isNotNull()
                    .isSameAs(root);
            return null;
        }));
    }

    @DisplayName("A00 is the only department which administers itself")
    @Test
    void department_IsItself_OnlyA00() {
        applyEntityManagerFactory(emf -> applyEntityManager(emf, em -> {
            final var selected = em.createQuery(
                            "SELECT d FROM Department d WHERE d.administrativeDepartment = d",
                            Department.class)
                    .getResultList();
            assertThat(selected)
                    .extracting(Department::getDeptno)
                    .containsExactly(DEPTNO_ROOT);
            return null;
        }));
    }

    @DisplayName("a department A00 administers has A00, the same instance, as its department")
    @Test
    void department_IsRoot_B01() {
        applyEntityManagerFactory(emf -> applyEntityManager(emf, em -> {
            final var root = em.find(Department.class, DEPTNO_ROOT);
            final var child = em.find(Department.class, "B01");
            assertThat(child).isNotNull();
            assertThat(child.getAdministrativeDepartment()).isSameAs(root);
            return null;
        }));
    }
}

