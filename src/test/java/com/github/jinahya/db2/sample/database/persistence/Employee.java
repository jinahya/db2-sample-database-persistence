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
@Table(name = Employee.TABLE_NAME)
public class Employee
        extends MappedEmployee {

    // ------------------------------------------------------------------------------------ WORKDEPT

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_WORKDEPT} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_WORKDEPT_DEPARTMENT = "workdeptDepartment";

    // ------------------------------------------------------------------------- MANAGED_DEPARTMENTS

    /**
     * The name of the attribute which maps the departments which this employee manages. The value
     * is {@value}.
     *
     * @see Department#ATTRIBUTE_NAME_MANAGER
     */
    public static final String ATTRIBUTE_NAME_MANAGED_DEPARTMENTS = "managedDepartments";

    // ------------------------------------------------------------------------ RESPONSIBLE_PROJECTS

    /**
     * The name of the attribute which maps the projects for which this employee is responsible. The
     * value is {@value}.
     *
     * @see Project#ATTRIBUTE_NAME_RESPONSIBLE_EMPLOYEE
     */
    public static final String ATTRIBUTE_NAME_RESPONSIBLE_PROJECTS = "responsibleProjects";

    // ---------------------------------------------------------------------------------- EMP_PHOTOS

    /**
     * The name of the attribute which maps the photos of this employee. The value is {@value}.
     *
     * @see EmpPhoto#ATTRIBUTE_NAME_EMPLOYEE
     */
    public static final String ATTRIBUTE_NAME_EMP_PHOTOS = "empPhotos";

    // --------------------------------------------------------------------------------- EMP_RESUMES

    /**
     * The name of the attribute which maps the resumes of this employee. The value is {@value}.
     *
     * @see EmpResume#ATTRIBUTE_NAME_EMPLOYEE
     */
    public static final String ATTRIBUTE_NAME_EMP_RESUMES = "empResumes";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Employee() {
        super();
    }

    // -------------------------------------------------------------------------- workdeptDepartment

    /**
     * Returns the department the employee works in.
     *
     * @return the department the employee works in.
     */
    public Department getWorkdeptDepartment() {
        return workdeptDepartment;
    }

    /**
     * Replaces the department the employee works in with the specified value.
     *
     * @param workdeptDepartment new value for the department the employee works in.
     */
    public void setWorkdeptDepartment(final Department workdeptDepartment) {
        this.workdeptDepartment = workdeptDepartment;
        setWorkdept(
                Optional.ofNullable(workdeptDepartment)
                        .map(Department::getDeptno)
                        .orElse(null)
        );
    }

    // -------------------------------------------------------------------------- managedDepartments

    /**
     * Returns the departments which this employee manages.
     *
     * @return the departments which this employee manages.
     */
    public List<Department> getManagedDepartments() {
        return managedDepartments;
    }

    /**
     * Replaces the departments which this employee manages with the specified value.
     *
     * @param managedDepartments new value for the departments which this employee manages.
     */
    public void setManagedDepartments(final List<Department> managedDepartments) {
        this.managedDepartments = managedDepartments;
    }

    // ------------------------------------------------------------------------- responsibleProjects

    /**
     * Returns the projects for which this employee is responsible.
     *
     * @return the projects for which this employee is responsible.
     */
    public List<Project> getResponsibleProjects() {
        return responsibleProjects;
    }

    /**
     * Replaces the projects for which this employee is responsible with the specified value.
     *
     * @param responsibleProjects new value for the projects for which this employee is responsible.
     */
    public void setResponsibleProjects(final List<Project> responsibleProjects) {
        this.responsibleProjects = responsibleProjects;
    }

    // ----------------------------------------------------------------------------------- empPhotos

    /**
     * Returns the photos of this employee.
     *
     * @return the photos of this employee.
     */
    public List<EmpPhoto> getEmpPhotos() {
        return empPhotos;
    }

    /**
     * Replaces the photos of this employee with the specified value.
     *
     * @param empPhotos new value for the photos of this employee.
     */
    public void setEmpPhotos(final List<EmpPhoto> empPhotos) {
        this.empPhotos = empPhotos;
    }

    // ---------------------------------------------------------------------------------- empResumes

    /**
     * Returns the resumes of this employee.
     *
     * @return the resumes of this employee.
     */
    public List<EmpResume> getEmpResumes() {
        return empResumes;
    }

    /**
     * Replaces the resumes of this employee with the specified value.
     *
     * @param empResumes new value for the resumes of this employee.
     */
    public void setEmpResumes(final List<EmpResume> empResumes) {
        this.empResumes = empResumes;
    }

    // ---------------------------------------------------------------------------------------------
    @Nullable
    @Valid
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = Employee.COLUMN_NAME_WORKDEPT,
                referencedColumnName = Department.COLUMN_NAME_DEPTNO,
                nullable = true,
                insertable = true,
                updatable = true
    )
    private Department workdeptDepartment;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Department.ATTRIBUTE_NAME_MANAGER,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Department> managedDepartments;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Project.ATTRIBUTE_NAME_RESPONSIBLE_EMPLOYEE,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Project> responsibleProjects;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = EmpPhoto.ATTRIBUTE_NAME_EMPLOYEE,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull EmpPhoto> empPhotos;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = EmpResume.ATTRIBUTE_NAME_EMPLOYEE,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull EmpResume> empResumes;
}
