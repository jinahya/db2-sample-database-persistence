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
 * A mapped superclass which holds the mappings of the {@value MappedVphone#TABLE_NAME} view, the
 * phone list of the employees, with their departments.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * <strong>A view has no key.</strong> The column {@value MappedVphone#COLUMN_NAME_EMPLOYEENUMBER},
 * unique and not {@code null} in every row the sample database is created with, is mapped as the
 * identifier, which an entity needs; nothing in the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVphone {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VPHONE";

    // -------------------------------------------------------------------------------------------------------- LASTNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_LASTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_LASTNAME = "LASTNAME";

    /**
     * Whether the {@value #COLUMN_NAME_LASTNAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_LASTNAME = false;

    /**
     * The length of the {@value #COLUMN_NAME_LASTNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_LASTNAME = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_LASTNAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_LASTNAME = "lastname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_LASTNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_LASTNAME = COLUMN_LENGTH_LASTNAME;

    // ------------------------------------------------------------------------------------------------------- FIRSTNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_FIRSTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_FIRSTNAME = "FIRSTNAME";

    /**
     * Whether the {@value #COLUMN_NAME_FIRSTNAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_FIRSTNAME = false;

    /**
     * The length of the {@value #COLUMN_NAME_FIRSTNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_FIRSTNAME = 12;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_FIRSTNAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_FIRSTNAME = "firstname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_FIRSTNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_FIRSTNAME = COLUMN_LENGTH_FIRSTNAME;

    // --------------------------------------------------------------------------------------------------- MIDDLEINITIAL

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_MIDDLEINITIAL} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_MIDDLEINITIAL = "MIDDLEINITIAL";

    /**
     * Whether the {@value #COLUMN_NAME_MIDDLEINITIAL} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_MIDDLEINITIAL = true;

    /**
     * The length of the {@value #COLUMN_NAME_MIDDLEINITIAL} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_MIDDLEINITIAL = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MIDDLEINITIAL} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_MIDDLEINITIAL = "middleinitial";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_MIDDLEINITIAL} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_MIDDLEINITIAL = COLUMN_LENGTH_MIDDLEINITIAL;

    // ----------------------------------------------------------------------------------------------------- PHONENUMBER

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PHONENUMBER = "PHONENUMBER";

    /**
     * Whether the {@value #COLUMN_NAME_PHONENUMBER} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PHONENUMBER = false;

    /**
     * The length of the {@value #COLUMN_NAME_PHONENUMBER} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PHONENUMBER = 4;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PHONENUMBER} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PHONENUMBER = "phonenumber";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_PHONENUMBER = COLUMN_LENGTH_PHONENUMBER;

    // -------------------------------------------------------------------------------------------------- EMPLOYEENUMBER

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMPLOYEENUMBER} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_EMPLOYEENUMBER = "EMPLOYEENUMBER";

    /**
     * Whether the {@value #COLUMN_NAME_EMPLOYEENUMBER} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMPLOYEENUMBER = false;

    /**
     * The length of the {@value #COLUMN_NAME_EMPLOYEENUMBER} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMPLOYEENUMBER = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPLOYEENUMBER} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPLOYEENUMBER = "employeenumber";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMPLOYEENUMBER} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_EMPLOYEENUMBER = COLUMN_LENGTH_EMPLOYEENUMBER;

    // ------------------------------------------------------------------------------------------------------ DEPTNUMBER

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPTNUMBER} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNUMBER = "DEPTNUMBER";

    /**
     * Whether the {@value #COLUMN_NAME_DEPTNUMBER} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPTNUMBER = false;

    /**
     * The length of the {@value #COLUMN_NAME_DEPTNUMBER} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPTNUMBER = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNUMBER} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPTNUMBER = "deptnumber";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPTNUMBER} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_DEPTNUMBER = COLUMN_LENGTH_DEPTNUMBER;

    // -------------------------------------------------------------------------------------------------------- DEPTNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNAME = "DEPTNAME";

    /**
     * Whether the {@value #COLUMN_NAME_DEPTNAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPTNAME = false;

    /**
     * The length of the {@value #COLUMN_NAME_DEPTNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPTNAME = 36;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPTNAME = "deptname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPTNAME = COLUMN_LENGTH_DEPTNAME;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVphone() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "lastname=" + lastname +
               ",firstname=" + firstname +
               ",middleinitial=" + middleinitial +
               ",phonenumber=" + phonenumber +
               ",employeenumber=" + employeenumber +
               ",deptnumber=" + deptnumber +
               ",deptname=" + deptname +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPLOYEENUMBER} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVphone that)) {
            return false;
        }
        return Objects.equals(getEmployeenumber(), that.getEmployeenumber());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_EMPLOYEENUMBER}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getEmployeenumber());
    }

    // -------------------------------------------------------------------------------------------------------- lastname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     */
    @Nonnull
    public String getLastname() {
        return lastname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute with the specified
     * value.
     *
     * @param lastname new value for {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     */
    protected void setLastname(@Nonnull final String lastname) {
        this.lastname = lastname;
    }

    // ------------------------------------------------------------------------------------------------------- firstname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_FIRSTNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_FIRSTNAME} attribute.
     */
    @Nonnull
    public String getFirstname() {
        return firstname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_FIRSTNAME} attribute with the specified
     * value.
     *
     * @param firstname new value for {@value #ATTRIBUTE_NAME_FIRSTNAME} attribute.
     */
    protected void setFirstname(@Nonnull final String firstname) {
        this.firstname = firstname;
    }

    // --------------------------------------------------------------------------------------------------- middleinitial

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MIDDLEINITIAL} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MIDDLEINITIAL} attribute.
     */
    @Nullable
    public String getMiddleinitial() {
        return middleinitial;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MIDDLEINITIAL} attribute with the specified
     * value.
     *
     * @param middleinitial new value for {@value #ATTRIBUTE_NAME_MIDDLEINITIAL} attribute.
     */
    protected void setMiddleinitial(@Nullable final String middleinitial) {
        this.middleinitial = middleinitial;
    }

    // ----------------------------------------------------------------------------------------------------- phonenumber

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute.
     */
    @Nonnull
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute with the specified
     * value.
     *
     * @param phonenumber new value for {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute.
     */
    protected void setPhonenumber(@Nonnull final String phonenumber) {
        this.phonenumber = phonenumber;
    }

    // -------------------------------------------------------------------------------------------------- employeenumber

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMPLOYEENUMBER} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMPLOYEENUMBER} attribute.
     */
    @Nonnull
    public String getEmployeenumber() {
        return employeenumber;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPLOYEENUMBER} attribute with the
     * specified value.
     *
     * @param employeenumber new value for {@value #ATTRIBUTE_NAME_EMPLOYEENUMBER} attribute.
     */
    protected void setEmployeenumber(@Nonnull final String employeenumber) {
        this.employeenumber = employeenumber;
    }

    // ------------------------------------------------------------------------------------------------------ deptnumber

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNUMBER} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNUMBER} attribute.
     */
    @Nonnull
    public String getDeptnumber() {
        return deptnumber;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNUMBER} attribute with the specified
     * value.
     *
     * @param deptnumber new value for {@value #ATTRIBUTE_NAME_DEPTNUMBER} attribute.
     */
    protected void setDeptnumber(@Nonnull final String deptnumber) {
        this.deptnumber = deptnumber;
    }

    // -------------------------------------------------------------------------------------------------------- deptname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     */
    @Nonnull
    public String getDeptname() {
        return deptname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute with the specified
     * value.
     *
     * @param deptname new value for {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     */
    protected void setDeptname(@Nonnull final String deptname) {
        this.deptname = deptname;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_LASTNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LASTNAME,
            nullable = COLUMN_NULLABLE_LASTNAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_LASTNAME
    )
    private String lastname;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_FIRSTNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_FIRSTNAME,
            nullable = COLUMN_NULLABLE_FIRSTNAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_FIRSTNAME
    )
    private String firstname;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_MIDDLEINITIAL)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MIDDLEINITIAL,
            nullable = COLUMN_NULLABLE_MIDDLEINITIAL,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_MIDDLEINITIAL
    )
    private String middleinitial;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PHONENUMBER)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PHONENUMBER,
            nullable = COLUMN_NULLABLE_PHONENUMBER,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PHONENUMBER
    )
    private String phonenumber;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMPLOYEENUMBER)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPLOYEENUMBER,
            nullable = COLUMN_NULLABLE_EMPLOYEENUMBER,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMPLOYEENUMBER
    )
    private String employeenumber;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPTNUMBER)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNUMBER,
            nullable = COLUMN_NULLABLE_DEPTNUMBER,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPTNUMBER
    )
    private String deptnumber;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPTNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNAME,
            nullable = COLUMN_NULLABLE_DEPTNAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPTNAME
    )
    private String deptname;
}
