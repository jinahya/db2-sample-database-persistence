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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedProject;
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
@Table(name = Project.TABLE_NAME)
public class Project
        extends MappedProject {

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Project() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * @param projno {@inheritDoc}
     * @implNote Widened to {@code public}: the identifier is assigned, not generated, so
     *         whoever creates an instance sets it.
     */
    @Override
    public void setProjno(final String projno) {
        super.setProjno(projno);
    }

    // ---------------------------------------------------------------------------- deptnoDepartment

    /**
     * Returns the department responsible.
     *
     * @return the department responsible.
     */
    public Department getDeptnoDepartment() {
        return deptnoDepartment;
    }

    /**
     * Replaces the department responsible with the specified value.
     *
     * @param deptnoDepartment new value for the department responsible.
     */
    public void setDeptnoDepartment(final Department deptnoDepartment) {
        this.deptnoDepartment = deptnoDepartment;
        setDeptno(Optional.ofNullable(deptnoDepartment).map(Department::getDeptno).orElse(null));
    }

    // ----------------------------------------------------------------------------- respempEmployee

    /**
     * Returns the employee responsible.
     *
     * @return the employee responsible.
     */
    public Employee getRespempEmployee() {
        return respempEmployee;
    }

    /**
     * Replaces the employee responsible with the specified value.
     *
     * @param respempEmployee new value for the employee responsible.
     */
    public void setRespempEmployee(final Employee respempEmployee) {
        this.respempEmployee = respempEmployee;
        setRespemp(Optional.ofNullable(respempEmployee).map(Employee::getEmpno).orElse(null));
    }

    // ------------------------------------------------------------------------------ majprojProject

    /**
     * Returns the major project.
     *
     * @return the major project.
     */
    public Project getMajprojProject() {
        return majprojProject;
    }

    /**
     * Replaces the major project with the specified value.
     *
     * @param majprojProject new value for the major project.
     */
    public void setMajprojProject(final Project majprojProject) {
        this.majprojProject = majprojProject;
        setMajproj(Optional.ofNullable(majprojProject).map(Project::getProjno).orElse(null));
    }

    // ---------------------------------------------------------------------------------------------
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Project.COLUMN_NAME_DEPTNO,
                referencedColumnName = Department.COLUMN_NAME_DEPTNO,
                nullable = false,
                insertable = true,
                updatable = true)
    private Department deptnoDepartment;

    // ---------------------------------------------------------------------------------------------
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Project.COLUMN_NAME_RESPEMP,
                referencedColumnName = Employee.COLUMN_NAME_EMPNO,
                nullable = false,
                insertable = true,
                updatable = true)
    private Employee respempEmployee;

    // ---------------------------------------------------------------------------------------------
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = Project.COLUMN_NAME_MAJPROJ,
                referencedColumnName = Project.COLUMN_NAME_PROJNO,
                nullable = true,
                insertable = true,
                updatable = true)
    private Project majprojProject;
}
