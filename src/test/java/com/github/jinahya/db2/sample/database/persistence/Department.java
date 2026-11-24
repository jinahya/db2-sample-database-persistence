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

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Department.TABLE_NAME)
public class Department extends MappedDepartment {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Department() {
        super();
    }

    // ---------------------------------------------------------------------------------------------- admrdeptDepartment

    /**
     * Returns the administering department.
     *
     * @return the administering department.
     */
    public Department getAdmrdeptDepartment() {
        return admrdeptDepartment;
    }

    /**
     * Replaces the administering department with the specified value.
     *
     * @param admrdeptDepartment new value for the administering department.
     */
    public void setAdmrdeptDepartment(final Department admrdeptDepartment) {
        this.admrdeptDepartment = admrdeptDepartment;
    }

    // --------------------------------------------------------------------------------------------------- mgrnoEmployee

    /**
     * Returns the manager.
     *
     * @return the manager.
     */
    public Employee getMgrnoEmployee() {
        return mgrnoEmployee;
    }

    /**
     * Replaces the manager with the specified value.
     *
     * @param mgrnoEmployee new value for the manager.
     */
    public void setMgrnoEmployee(final Employee mgrnoEmployee) {
        this.mgrnoEmployee = mgrnoEmployee;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Department.COLUMN_NAME_ADMRDEPT,
                referencedColumnName = Department.COLUMN_NAME_DEPTNO)
    private Department admrdeptDepartment;

    // -----------------------------------------------------------------------------------------------------------------
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = Department.COLUMN_NAME_MGRNO,
                referencedColumnName = Employee.COLUMN_NAME_EMPNO)
    private Employee mgrnoEmployee;
}
