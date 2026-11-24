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
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@IdClass(ProjActId.class)
@Table(name = ProjAct.TABLE_NAME)
public class ProjAct extends MappedProjAct {

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public ProjAct() {
        super();
    }

    // --------------------------------------------------------------------------------------------------------- project

    /**
     * Returns the project.
     *
     * @return the project.
     */
    public Project getProject() {
        return project;
    }

    // -----------------------------------------------------------------------------------------------------------------
    // read-only: the column(s) are part of the identifier, which the superclass writes
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ProjAct.COLUMN_NAME_PROJNO,
                referencedColumnName = Project.COLUMN_NAME_PROJNO,
                insertable = false, updatable = false)
    private Project project;
}
