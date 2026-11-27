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
@Table(name = Department.TABLE_NAME)
public class Department
        extends MappedDepartment {

    // --------------------------------------------------------------------------------------- MGRNO

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MGRNO} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_MANAGER = "manager";

    // ------------------------------------------------------------------------------------ ADMRDEPT

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ADMRDEPT} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ADMINISTRATIVE_DEPARTMENT = "administrativeDepartment";

    // ----------------------------------------------------------------------------------- EMPLOYEES

    /**
     * The name of the attribute which maps the employees who work in this department. The value is
     * {@value}.
     *
     * @see Employee#ATTRIBUTE_NAME_WORKDEPT_DEPARTMENT
     */
    public static final String ATTRIBUTE_NAME_EMPLOYEES = "employees";

    // -------------------------------------------------------------------- ADMINISTERED_DEPARTMENTS

    /**
     * The name of the attribute which maps the departments which this department administers. The
     * value is {@value}.
     *
     * @see Department#ATTRIBUTE_NAME_ADMINISTRATIVE_DEPARTMENT
     */
    public static final String ATTRIBUTE_NAME_ADMINISTERED_DEPARTMENTS = "administeredDepartments";

    // ------------------------------------------------------------------------------------ PROJECTS

    /**
     * The name of the attribute which maps the projects for which this department is responsible.
     * The value is {@value}.
     *
     * @see Project#ATTRIBUTE_NAME_DEPARTMENT
     */
    public static final String ATTRIBUTE_NAME_PROJECTS = "projects";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Department() {
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
    public Employee getManager() {
        return manager;
    }

    /**
     * Replaces the manager with the specified value.
     *
     * @param manager new value for the manager.
     */
    public void setManager(final Employee manager) {
        this.manager = manager;
        setMgrno(Optional.ofNullable(manager).map(Employee::getEmpno).orElse(null));
    }

    // ---------------------------------------------------------------------------------- department

    /**
     * Returns the administering department.
     *
     * @return the administering department.
     */
    public Department getAdministrativeDepartment() {
        return administrativeDepartment;
    }

    /**
     * Replaces the administering department with the specified value.
     *
     * @param administrativeDepartment new value for the administering department.
     */
    public void setAdministrativeDepartment(final Department administrativeDepartment) {
        this.administrativeDepartment = administrativeDepartment;
        setAdmrdept(Optional.ofNullable(administrativeDepartment)
                            .map(Department::getDeptno)
                            .orElse(null));
    }

    // ----------------------------------------------------------------------------------- employees

    /**
     * Returns the employees who work in this department.
     *
     * @return the employees who work in this department.
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Replaces the employees who work in this department with the specified value.
     *
     * @param employees new value for the employees who work in this department.
     */
    public void setEmployees(final List<Employee> employees) {
        this.employees = employees;
    }

    // --------------------------------------------------------------------- administeredDepartments

    /**
     * Returns the departments which this department administers.
     *
     * @return the departments which this department administers.
     */
    public List<Department> getAdministeredDepartments() {
        return administeredDepartments;
    }

    /**
     * Replaces the departments which this department administers with the specified value.
     *
     * @param administeredDepartments new value for the departments which this department
     * administers.
     */
    public void setAdministeredDepartments(final List<Department> administeredDepartments) {
        this.administeredDepartments = administeredDepartments;
    }

    // ------------------------------------------------------------------------------------ projects

    /**
     * Returns the projects for which this department is responsible.
     *
     * @return the projects for which this department is responsible.
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Replaces the projects for which this department is responsible with the specified value.
     *
     * @param projects new value for the projects for which this department is responsible.
     */
    public void setProjects(final List<Project> projects) {
        this.projects = projects;
    }

    // ---------------------------------------------------------------------------------------------
    @Nullable
    @Valid
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = Department.COLUMN_NAME_MGRNO,
                referencedColumnName = Employee.COLUMN_NAME_EMPNO,
                nullable = true,
                insertable = true,
                updatable = true
    )
    private Employee manager;

    // ---------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Department.COLUMN_NAME_ADMRDEPT,
                referencedColumnName = Department.COLUMN_NAME_DEPTNO,
                nullable = false,
                insertable = true,
                updatable = true
    )
    private Department administrativeDepartment;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Employee.ATTRIBUTE_NAME_WORKDEPT_DEPARTMENT,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Employee> employees;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Department.ATTRIBUTE_NAME_ADMINISTRATIVE_DEPARTMENT,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Department> administeredDepartments;

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Project.ATTRIBUTE_NAME_DEPARTMENT,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Project> projects;
}
