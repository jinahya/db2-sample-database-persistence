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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedDepartment;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Department.TABLE_NAME)
public class Department
        extends MappedDepartment {

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Department() {
        super();
    }

    /**
     * Creates a new instance with the specified identifier, which is assigned, not generated.
     *
     * @param deptno a value for the {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     */
    public Department(final String deptno) {
        super(deptno);
    }

    // ------------------------------------------------------------------------------------ employee

    /**
     * Returns the manager.
     *
     * @return the manager.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Replaces the manager with the specified value.
     *
     * @param employee new value for the manager.
     */
    public void setEmployee(final Employee employee) {
        this.employee = employee;
        setMgrno(Optional.ofNullable(employee).map(Employee::getEmpno).orElse(null));
    }

    // ---------------------------------------------------------------------------------- department

    /**
     * Returns the administering department.
     *
     * @return the administering department.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Replaces the administering department with the specified value.
     *
     * @param department new value for the administering department.
     */
    public void setDepartment(final Department department) {
        this.department = department;
        setAdmrdept(Optional.ofNullable(department)
                    .map(Department::getDeptno)
                    .orElse(null));
    }

    // ---------------------------------------------------------------------------------------------
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = Department.COLUMN_NAME_MGRNO,
                referencedColumnName = Employee.COLUMN_NAME_EMPNO,
                nullable = true,
                insertable = true,
                updatable = true
    )
    private Employee employee;

    // ---------------------------------------------------------------------------------------------
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Department.COLUMN_NAME_ADMRDEPT,
                referencedColumnName = Department.COLUMN_NAME_DEPTNO,
                nullable = false,
                insertable = true,
                updatable = true
    )
    private Department department;
}
