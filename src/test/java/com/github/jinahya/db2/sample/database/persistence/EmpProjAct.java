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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedEmpProjAct;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@IdClass(EmpProjActId.class)
@Table(name = EmpProjAct.TABLE_NAME)
public class EmpProjAct
        extends MappedEmpProjAct {

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public EmpProjAct() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * @param empno {@inheritDoc}
     * @implNote Widened to {@code public}: the identifier is assigned, not generated, so
     *         whoever creates an instance sets it.
     */
    @Override
    public void setEmpno(final String empno) {
        super.setEmpno(empno);
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

    /**
     * {@inheritDoc}
     *
     * @param actno {@inheritDoc}
     * @implNote Widened to {@code public}: the identifier is assigned, not generated, so
     *         whoever creates an instance sets it.
     */
    @Override
    public void setActno(final Integer actno) {
        super.setActno(actno);
    }

    /**
     * {@inheritDoc}
     *
     * @param emstdate {@inheritDoc}
     * @implNote Widened to {@code public}: the identifier is assigned, not generated, so
     *         whoever creates an instance sets it.
     */
    @Override
    public void setEmstdate(final LocalDate emstdate) {
        super.setEmstdate(emstdate);
    }

    // ------------------------------------------------------------------------------------- projAct

    /**
     * Returns the activity of the project.
     *
     * @return the activity of the project.
     */
    public ProjAct getProjAct() {
        return projAct;
    }

    // ---------------------------------------------------------------------------------------------
    // read-only: the column(s) are part of the identifier, which the superclass writes
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = EmpProjAct.COLUMN_NAME_PROJNO,
                        referencedColumnName = ProjAct.COLUMN_NAME_PROJNO,
                        insertable = false, updatable = false),
            @JoinColumn(name = EmpProjAct.COLUMN_NAME_ACTNO,
                        referencedColumnName = ProjAct.COLUMN_NAME_ACTNO,
                        insertable = false, updatable = false),
            @JoinColumn(name = EmpProjAct.COLUMN_NAME_EMSTDATE,
                        referencedColumnName = ProjAct.COLUMN_NAME_ACSTDATE,
                        insertable = false, updatable = false)
    })
    private ProjAct projAct;
}
