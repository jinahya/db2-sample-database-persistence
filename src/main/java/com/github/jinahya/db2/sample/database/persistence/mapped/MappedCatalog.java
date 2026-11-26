package com.github.jinahya.db2.sample.database.persistence.mapped;

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

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedCatalog#TABLE_NAME} table, the
 * XML catalogs.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedCatalog {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "CATALOG";

    // ------------------------------------------------------------------------------------------------------------ NAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_NAME} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_NAME = "NAME";

    /**
     * Whether the {@value #COLUMN_NAME_NAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_NAME = false;

    /**
     * The length of the {@value #COLUMN_NAME_NAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_NAME = 128;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_NAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_NAME = "name";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_NAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_NAME = COLUMN_LENGTH_NAME;

    // ---------------------------------------------------------------------------------------------------------- CATLOG

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_CATLOG} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_CATLOG = "CATLOG";

    /**
     * Whether the {@value #COLUMN_NAME_CATLOG} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_CATLOG = true;

    /**
     * The length of the {@value #COLUMN_NAME_CATLOG} column, for a schema a provider generates. The
     * value is {@value}.
     * <p>
     * Db2's {@code XML} has no length; without one, a generated schema makes the column a
     * {@code VARCHAR} of the provider's default length, too short for a document.
     */
    public static final int COLUMN_LENGTH_CATLOG = 1048576;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_CATLOG} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_CATLOG = "catlog";

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedCatalog() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "name=" + name +
               ",catlog=" + (catlog == null ? null : catlog.length() + " char(s)") +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_NAME} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedCatalog that)) {
            return false;
        }
        return Objects.equals(getName(), that.getName());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_NAME}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getName());
    }

    // ------------------------------------------------------------------------------------------------------------ name

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_NAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_NAME} attribute.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_NAME} attribute with the specified value.
     *
     * @param name new value for {@value #ATTRIBUTE_NAME_NAME} attribute.
     */
    protected void setName(@Nonnull final String name) {
        this.name = name;
    }

    // ---------------------------------------------------------------------------------------------------------- catlog

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_CATLOG} attribute, serialized; the column is
     * an XML.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_CATLOG} attribute.
     */
    @Nullable
    public String getCatlog() {
        return catlog;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_CATLOG} attribute with the specified
     * value.
     *
     * @param catlog new value for {@value #ATTRIBUTE_NAME_CATLOG} attribute.
     */
    public void setCatlog(@Nullable final String catlog) {
        this.catlog = catlog;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_NAME)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_NAME,
            nullable = COLUMN_NULLABLE_NAME,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_NAME
    )
    private String name;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_CATLOG,
            nullable = COLUMN_NULLABLE_CATLOG,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_CATLOG
    )
    private String catlog;
}
