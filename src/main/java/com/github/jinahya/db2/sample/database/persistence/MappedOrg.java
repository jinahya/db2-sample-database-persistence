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
 * A mapped superclass which holds the mappings of the {@value MappedOrg#TABLE_NAME} table, the
 * organization.
 * <p>
 * <strong>The table declares no primary key.</strong> The column
 * {@value MappedOrg#COLUMN_NAME_DEPTNUMB}, unique and not {@code null} in every row the sample
 * database is created with, is mapped as the identifier, which an entity needs; nothing in the
 * database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedOrg {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "ORG";

    // -------------------------------------------------------------------------------------------------------- DEPTNUMB

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNUMB = "DEPTNUMB";

    /**
     * Whether the {@value #COLUMN_NAME_DEPTNUMB} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPTNUMB = false;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNUMB} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPTNUMB = "deptnumb";

    // -------------------------------------------------------------------------------------------------------- DEPTNAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNAME = "DEPTNAME";

    /**
     * Whether the {@value #COLUMN_NAME_DEPTNAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPTNAME = true;

    /**
     * The length of the {@value #COLUMN_NAME_DEPTNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPTNAME = 14;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPTNAME = "deptname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPTNAME = COLUMN_LENGTH_DEPTNAME;

    // --------------------------------------------------------------------------------------------------------- MANAGER

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_MANAGER} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_MANAGER = "MANAGER";

    /**
     * Whether the {@value #COLUMN_NAME_MANAGER} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_MANAGER = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MANAGER} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_MANAGER = "manager";

    // -------------------------------------------------------------------------------------------------------- DIVISION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DIVISION} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DIVISION = "DIVISION";

    /**
     * Whether the {@value #COLUMN_NAME_DIVISION} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DIVISION = true;

    /**
     * The length of the {@value #COLUMN_NAME_DIVISION} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DIVISION = 10;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DIVISION} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DIVISION = "division";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DIVISION} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DIVISION = COLUMN_LENGTH_DIVISION;

    // -------------------------------------------------------------------------------------------------------- LOCATION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_LOCATION} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_LOCATION = "LOCATION";

    /**
     * Whether the {@value #COLUMN_NAME_LOCATION} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_LOCATION = true;

    /**
     * The length of the {@value #COLUMN_NAME_LOCATION} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_LOCATION = 13;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_LOCATION} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_LOCATION = "location";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_LOCATION} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_LOCATION = COLUMN_LENGTH_LOCATION;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedOrg() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "deptnumb=" + deptnumb +
               ",deptname=" + deptname +
               ",manager=" + manager +
               ",division=" + division +
               ",location=" + location +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_DEPTNUMB} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedOrg that)) {
            return false;
        }
        return Objects.equals(getDeptnumb(), that.getDeptnumb());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_DEPTNUMB}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getDeptnumb());
    }

    // -------------------------------------------------------------------------------------------------------- deptnumb

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute.
     */
    @Nonnull
    public Short getDeptnumb() {
        return deptnumb;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute with the specified
     * value.
     *
     * @param deptnumb new value for {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute.
     */
    protected void setDeptnumb(@Nonnull final Short deptnumb) {
        this.deptnumb = deptnumb;
    }

    // -------------------------------------------------------------------------------------------------------- deptname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     */
    @Nullable
    public String getDeptname() {
        return deptname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute with the specified
     * value.
     *
     * @param deptname new value for {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     */
    public void setDeptname(@Nullable final String deptname) {
        this.deptname = deptname;
    }

    // --------------------------------------------------------------------------------------------------------- manager

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MANAGER} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MANAGER} attribute.
     */
    @Nullable
    public Short getManager() {
        return manager;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MANAGER} attribute with the specified
     * value.
     *
     * @param manager new value for {@value #ATTRIBUTE_NAME_MANAGER} attribute.
     */
    public void setManager(@Nullable final Short manager) {
        this.manager = manager;
    }

    // -------------------------------------------------------------------------------------------------------- division

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DIVISION} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DIVISION} attribute.
     */
    @Nullable
    public String getDivision() {
        return division;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DIVISION} attribute with the specified
     * value.
     *
     * @param division new value for {@value #ATTRIBUTE_NAME_DIVISION} attribute.
     */
    public void setDivision(@Nullable final String division) {
        this.division = division;
    }

    // -------------------------------------------------------------------------------------------------------- location

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     */
    @Nullable
    public String getLocation() {
        return location;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute with the specified
     * value.
     *
     * @param location new value for {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     */
    public void setLocation(@Nullable final String location) {
        this.location = location;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNUMB,
            nullable = COLUMN_NULLABLE_DEPTNUMB,
            insertable = true,
            updatable = false
    )
    private Short deptnumb;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_DEPTNAME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNAME,
            nullable = COLUMN_NULLABLE_DEPTNAME,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_DEPTNAME
    )
    private String deptname;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MANAGER,
            nullable = COLUMN_NULLABLE_MANAGER,
            insertable = true,
            updatable = true
    )
    private Short manager;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_DIVISION)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DIVISION,
            nullable = COLUMN_NULLABLE_DIVISION,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_DIVISION
    )
    private String division;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_LOCATION)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LOCATION,
            nullable = COLUMN_NULLABLE_LOCATION,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_LOCATION
    )
    private String location;
}
