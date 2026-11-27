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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedVprojact;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * An entity of the {@value #TABLE_NAME} view, which declares the identifier {@link MappedVprojact}
 * leaves out, an {@link EmbeddedId @EmbeddedId} of {@link VprojactId}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Vprojact.TABLE_NAME)
public class Vprojact
        extends MappedVprojact {

    /**
     * The name of the attribute of the identifier, an {@link EmbeddedId @EmbeddedId} of
     * {@link VprojactId}. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ID = "id";

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_PROJNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_PROJNO =
            ATTRIBUTE_NAME_ID + "." + VprojactId.ATTRIBUTE_NAME_PROJNO;

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_ACTNO} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_ACTNO =
            ATTRIBUTE_NAME_ID + "." + VprojactId.ATTRIBUTE_NAME_ACTNO;

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_ACSTDATE} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_ACSTDATE =
            ATTRIBUTE_NAME_ID + "." + VprojactId.ATTRIBUTE_NAME_ACSTDATE;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Vprojact() {
        super();
    }
    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "id=" + id +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_ID}, the identifier.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Vprojact that)) {
            return false;
        }
        return Objects.equals(getId(), that.getId());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_ID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
    // ------------------------------------------------------------------------------------------ id

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     */
    public VprojactId getId() {
        return id;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ID} attribute with the specified value.
     *
     * @param id new value for {@value #ATTRIBUTE_NAME_ID} attribute.
     */
    protected void setId(final VprojactId id) {
        this.id = id;
    }

    // ---------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    @EmbeddedId
    private VprojactId id;
}
