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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedEmployee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class EmpResumeId_Test
        extends _NonEntity_Test<EmpResumeId> {

    EmpResumeId_Test() {
        super(EmpResumeId.class);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Tests {@link EmpResumeId#of(String, String)}.
     */
    @DisplayName("of(empno, resumeFormat)")
    @Nested
    class OfTest {

        /**
         * Verifies that {@link EmpResumeId#of(String, String) of} returns an instance of the
         * specified values.
         */
        @Test
        void __() {
            final var instance = EmpResumeId.of("V0", "V1");
            assertThat(instance).isNotNull().satisfies(v -> {
                assertThat(v.getEmpno()).isEqualTo("V0");
                assertThat(v.getResumeFormat()).isEqualTo("V1");
            });
        }

        /**
         * Verifies that {@link EmpResumeId#of(String, String) of} takes {@code null} values as they
         * are.
         */
        @Test
        void __null() {
            final var instance = EmpResumeId.of(null, null);
            assertThat(instance).isNotNull().satisfies(v -> {
                assertThat(v.getEmpno()).isNull();
                assertThat(v.getResumeFormat()).isNull();
            });
        }
    }

    /**
     * Tests {@link EmpResumeId#from(MappedEmployee, String)}.
     */
    @DisplayName("from(employee, resumeFormat)")
    @Nested
    class FromEmployeeResumeFormatTest {

        /**
         * Verifies that {@link EmpResumeId#from(MappedEmployee, String) from} returns an instance
         * of the employee's number and the resume format.
         */
        @Test
        void __() {
            final var employee = mock(Employee.class);
            doReturn("000130").when(employee).getEmpno();
            final var instance = EmpResumeId.from(employee, "ascii");
            assertThat(instance).isNotNull().satisfies(v -> {
                assertThat(v.getEmpno()).isEqualTo("000130");
                assertThat(v.getResumeFormat()).isEqualTo("ascii");
            });
        }

        /**
         * Verifies that {@link EmpResumeId#from(MappedEmployee, String) from} gives a {@code null}
         * employee number for a {@code null} employee.
         */
        @Test
        void __null() {
            final var instance = EmpResumeId.from(null, null);
            assertThat(instance).isNotNull().satisfies(v -> {
                assertThat(v.getEmpno()).isNull();
                assertThat(v.getResumeFormat()).isNull();
            });
        }
    }
}
