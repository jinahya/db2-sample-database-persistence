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
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Act.TABLE_NAME)
public class Act
        extends MappedAct {

    // ------------------------------------------------------------------------------------ PROJACTS

    /**
     * The name of the attribute which maps the projects of this activity. The value is {@value}.
     *
     * @see Projact#ATTRIBUTE_NAME_ACT
     */
    public static final String ATTRIBUTE_NAME_PROJACTS = "projacts";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Act() {
        super();
    }

    // ------------------------------------------------------------------------------------ projacts

    /**
     * Returns the projects of this activity.
     *
     * @return the projects of this activity.
     */
    public List<Projact> getProjacts() {
        return projacts;
    }

    /**
     * Replaces the projects of this activity with the specified value.
     *
     * @param projacts new value for the projects of this activity.
     */
    public void setProjacts(final List<Projact> projacts) {
        this.projacts = projacts;
    }

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Projact.ATTRIBUTE_NAME_ACT,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Projact> projacts;
}
