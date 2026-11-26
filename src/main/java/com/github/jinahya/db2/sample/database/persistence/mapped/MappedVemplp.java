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
 * A mapped superclass which holds the mappings of the {@value MappedVemplp#TABLE_NAME} view, the
 * phone numbers of the employees.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * <strong>A view has no key.</strong> The column {@value MappedVemplp#COLUMN_NAME_EMPLOYEENUMBER},
 * unique and not {@code null} in every row the sample database is created with, is mapped as the
 * identifier, which an entity needs; nothing in the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVemplp {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VEMPLP";

    // ------------------------------------------------------------------------------ EMPLOYEENUMBER

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

    // --------------------------------------------------------------------------------- PHONENUMBER

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PHONENUMBER = "PHONENUMBER";

    /**
     * Whether the {@value #COLUMN_NAME_PHONENUMBER} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PHONENUMBER = true;

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

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVemplp() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "employeenumber=" + employeenumber +
               ",phonenumber=" + phonenumber +
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
        if (!(obj instanceof MappedVemplp that)) {
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

    // ------------------------------------------------------------------------------ employeenumber

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

    // --------------------------------------------------------------------------------- phonenumber

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute.
     */
    @Nullable
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute with the specified
     * value.
     *
     * @param phonenumber new value for {@value #ATTRIBUTE_NAME_PHONENUMBER} attribute.
     */
    protected void setPhonenumber(@Nullable final String phonenumber) {
        this.phonenumber = phonenumber;
    }

    // ---------------------------------------------------------------------------------------------
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

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_PHONENUMBER)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PHONENUMBER,
            nullable = COLUMN_NULLABLE_PHONENUMBER,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PHONENUMBER
    )
    private String phonenumber;
}
