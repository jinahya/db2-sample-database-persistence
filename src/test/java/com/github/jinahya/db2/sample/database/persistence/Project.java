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
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
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

    // -------------------------------------------------------------------------------------- DEPTNO

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNO} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPARTMENT = "department";

    // ------------------------------------------------------------------------------------- RESPEMP

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESPEMP} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESPONSIBLE_EMPLOYEE = "responsibleEmployee";

    // ------------------------------------------------------------------------------------- MAJPROJ

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MAJPROJ} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_MAJOR_PROJECT = "majorProject";

    // --------------------------------------------------------------------------------- SUBPROJECTS

    /**
     * The name of the attribute which maps the subprojects of this project. The value is {@value}.
     *
     * @see Project#ATTRIBUTE_NAME_MAJOR_PROJECT
     */
    public static final String ATTRIBUTE_NAME_SUBPROJECTS = "subprojects";

    // ------------------------------------------------------------------------------------ PROJACTS

    /**
     * The name of the attribute which maps the activities of this project. The value is {@value}.
     *
     * @see Projact#ATTRIBUTE_NAME_PROJECT
     */
    public static final String ATTRIBUTE_NAME_PROJACTS = "projacts";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Project() {
        super();
    }

    // ---------------------------------------------------------------------------------- department

    /**
     * Returns the department responsible.
     *
     * @return the department responsible.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Replaces the department responsible with the specified value.
     *
     * @param department new value for the department responsible.
     */
    public void setDepartment(final Department department) {
        this.department = department;
        setDeptno(Optional.ofNullable(department).map(Department::getDeptno).orElse(null));
    }

    // ------------------------------------------------------------------------- responsibleEmployee

    /**
     * Returns the employee responsible.
     *
     * @return the employee responsible.
     */
    public Employee getResponsibleEmployee() {
        return responsibleEmployee;
    }

    /**
     * Replaces the employee responsible with the specified value.
     *
     * @param respempEmployee new value for the employee responsible.
     */
    public void setResponsibleEmployee(final Employee respempEmployee) {
        this.responsibleEmployee = respempEmployee;
        setRespemp(Optional.ofNullable(respempEmployee).map(Employee::getEmpno).orElse(null));
    }

    // -------------------------------------------------------------------------------- majorProject

    /**
     * Returns the major project.
     *
     * @return the major project.
     */
    public Project getMajorProject() {
        return majorProject;
    }

    /**
     * Replaces the major project with the specified value.
     *
     * @param majprojProject new value for the major project.
     */
    public void setMajorProject(final Project majprojProject) {
        this.majorProject = majprojProject;
        setMajproj(Optional.ofNullable(majprojProject).map(Project::getProjno).orElse(null));
    }

    // --------------------------------------------------------------------------------- subprojects

    /**
     * Returns the subprojects of this project.
     *
     * @return the subprojects of this project.
     */
    public List<Project> getSubprojects() {
        return subprojects;
    }

    /**
     * Replaces the subprojects of this project with the specified value.
     *
     * @param subprojects new value for the subprojects of this project.
     */
    public void setSubprojects(final List<Project> subprojects) {
        this.subprojects = subprojects;
    }

    // ------------------------------------------------------------------------------------ projacts

    /**
     * Returns the activities of this project.
     *
     * @return the activities of this project.
     */
    public List<Projact> getProjacts() {
        return projacts;
    }

    /**
     * Replaces the activities of this project with the specified value.
     *
     * @param projacts new value for the activities of this project.
     */
    public void setProjacts(final List<Projact> projacts) {
        this.projacts = projacts;
    }

    // ---------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Project.COLUMN_NAME_DEPTNO,
                referencedColumnName = Department.COLUMN_NAME_DEPTNO,
                nullable = false,
                insertable = true,
                updatable = true
    )
    private Department department;

    // ---------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Project.COLUMN_NAME_RESPEMP,
                referencedColumnName = Employee.COLUMN_NAME_EMPNO,
                nullable = false,
                insertable = true,
                updatable = true
    )
    private Employee responsibleEmployee;

    // ---------------------------------------------------------------------------------------------
    @Nullable
    @Valid
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = Project.COLUMN_NAME_MAJPROJ,
                referencedColumnName = Project.COLUMN_NAME_PROJNO,
                nullable = true,
                insertable = true,
                updatable = true
    )
    private Project majorProject;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Project.ATTRIBUTE_NAME_MAJOR_PROJECT,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Project> subprojects;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Projact.ATTRIBUTE_NAME_PROJECT,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Projact> projacts;
}
