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

import com.github.jinahya.db2.sample.database.persistence.Db2Constants;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * A mapped superclass which holds the mappings of the {@value MappedOrg#TABLE_NAME} table, the
 * organization.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key
 * by
 * its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedOrg {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "ORG";

    // ------------------------------------------------------------------------------------ DEPTNUMB

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNUMB = "DEPTNUMB";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNUMB} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPTNUMB = "deptnumb";

    // ------------------------------------------------------------------------------------ DEPTNAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNAME = "DEPTNAME";

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

    // ------------------------------------------------------------------------------------- MANAGER

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_MANAGER} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_MANAGER = "MANAGER";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MANAGER} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_MANAGER = "manager";

    // ------------------------------------------------------------------------------------ DIVISION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DIVISION} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DIVISION = "DIVISION";

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

    // ------------------------------------------------------------------------------------ LOCATION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_LOCATION} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_LOCATION = "LOCATION";

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

    // --------------------------------------------------------------------------------- SELECT_LIST

    /**
     * The columns of {@value #TABLE_NAME}, in their order, as the select list of a native query
     * whose rows an extending class is built from. The value is {@value}.
     */
    public static final String SELECT_LIST =
            COLUMN_NAME_DEPTNUMB + ", "
            + COLUMN_NAME_DEPTNAME + ", "
            + COLUMN_NAME_MANAGER + ", "
            + COLUMN_NAME_DIVISION + ", "
            + COLUMN_NAME_LOCATION;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedOrg() {
        super();
    }

    /**
     * Creates a new instance with the specified values, in the order of {@link #SELECT_LIST}.
     *
     * @param deptnumb a value for the {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute.
     * @param deptname a value for the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     * @param manager  a value for the {@value #ATTRIBUTE_NAME_MANAGER} attribute.
     * @param division a value for the {@value #ATTRIBUTE_NAME_DIVISION} attribute.
     * @param location a value for the {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     */
    protected MappedOrg(
            final Integer deptnumb,
            final String deptname,
            final Integer manager,
            final String division,
            final String location) {
        this();
        this.deptnumb = deptnumb;
        this.deptname = deptname;
        this.manager = manager;
        this.division = division;
        this.location = location;
    }

    // ---------------------------------------------------------------------------- java.lang.Object

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

    // ------------------------------------------------------------------------------------ deptnumb

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute.
     */
    @Nonnull
    public Integer getDeptnumb() {
        return deptnumb;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute with the specified
     * value.
     *
     * @param deptnumb new value for {@value #ATTRIBUTE_NAME_DEPTNUMB} attribute.
     */
    protected void setDeptnumb(@Nonnull final Integer deptnumb) {
        this.deptnumb = deptnumb;
    }

    // ------------------------------------------------------------------------------------ deptname

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

    // ------------------------------------------------------------------------------------- manager

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MANAGER} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MANAGER} attribute.
     */
    @Nullable
    public Integer getManager() {
        return manager;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MANAGER} attribute with the specified
     * value.
     *
     * @param manager new value for {@value #ATTRIBUTE_NAME_MANAGER} attribute.
     */
    public void setManager(@Nullable final Integer manager) {
        this.manager = manager;
    }

    // ------------------------------------------------------------------------------------ division

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

    // ------------------------------------------------------------------------------------ location

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

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Max(Db2Constants.SMALLINT_MAX)
    @Min(Db2Constants.SMALLINT_MIN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNUMB,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Integer deptnumb;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_DEPTNAME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNAME,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_DEPTNAME
    )
    private String deptname;

    // ---------------------------------------------------------------------------------------------
    @Max(Db2Constants.SMALLINT_MAX)
    @Min(Db2Constants.SMALLINT_MIN)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MANAGER,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer manager;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_DIVISION)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DIVISION,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_DIVISION
    )
    private String division;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_LOCATION)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LOCATION,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_LOCATION
    )
    private String location;
}
