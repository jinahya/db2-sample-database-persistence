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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedAct;
import com.github.jinahya.db2.sample.database.persistence.mapped.MappedEmpprojact;
import com.github.jinahya.db2.sample.database.persistence.mapped.MappedEmployee;
import com.github.jinahya.db2.sample.database.persistence.mapped.MappedProject;
import jakarta.annotation.Nullable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;

import java.util.Optional;

/**
 * A row of the {@value #TABLE_NAME} table; not an entity, since it has no key, but a class built
 * from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class Empprojact
        extends MappedEmpprojact {

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Empprojact() {
        super();
    }

    /**
     * Creates a new instance from the specified row of a native query which selects
     * {@link #SELECT_LIST}, in its order.
     *
     * @param row the row; an array of 6 values.
     */
    public Empprojact(final Object[] row) {
        super(
                __Row_Utils.string(row, 0),
                __Row_Utils.string(row, 1),
                __Row_Utils.integer(row, 2),
                __Row_Utils.bigDecimal(row, 3),
                __Row_Utils.localDate(row, 4),
                __Row_Utils.localDate(row, 5)
        );
    }

    // --------------------------------------------------------------------------- java.lang.Objecct

    // ------------------------------------------------------------------------------------ employee
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(final Employee employee) {
        this.employee = employee;
        setEmpno(
                Optional.ofNullable(this.employee).map(MappedEmployee::getEmpno).orElse(null)
        );
    }

    // ------------------------------------------------------------------------------------- project
    public Project getProject() {
        return project;
    }

    public void setProject(final Project project) {
        this.project = project;
        setProjno(
                Optional.ofNullable(this.project).map(MappedProject::getProjno).orElse(null)
        );
    }

    // ----------------------------------------------------------------------------------------- act
    public Act getAct() {
        return act;
    }

    public void setAct(final Act act) {
        this.act = act;
        setActno(
                Optional.ofNullable(this.act).map(MappedAct::getActno).orElse(null)
        );
    }

    // ---------------------------------------------------------------------------------------------
    // nullable: this class is built from the rows of a native query, which set no association
    @Nullable
    @Valid
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_EMPNO, nullable = false, insertable = false, updatable = false)
    private Employee employee;

    // ---------------------------------------------------------------------------------------------
    // nullable: this class is built from the rows of a native query, which set no association
    @Nullable
    @Valid
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_PROJNO, nullable = false, insertable = false, updatable = false)
    private Project project;

    // ---------------------------------------------------------------------------------------------
    // nullable: this class is built from the rows of a native query, which set no association
    @Nullable
    @Valid
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_ACTNO, nullable = false, insertable = false, updatable = false)
    private Act act;
}
