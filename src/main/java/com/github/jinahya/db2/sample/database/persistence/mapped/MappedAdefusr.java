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
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedAdefusr#TABLE_NAME}
 * materialized query table, the number of employees in each work department.
 * <p>
 * <strong>The table is mapped read-only.</strong> It is a materialized query table which the
 * database maintains ({@code REFRESH IMMEDIATE MAINTAINED BY SYSTEM}); no column is updatable, none
 * but the identifier's is insertable, and the setters are not public. The identifier's column stays
 * insertable since EclipseLink requires an {@link Id @Id} mapping to be writable.
 * <p>
 * It is defined as
 * {@code SELECT WORKDEPT, COUNT(*) AS NO_OF_EMPLOYEES FROM EMPLOYEE GROUP BY WORKDEPT}.
 * <p>
 * <strong>The table declares no primary key.</strong> The column
 * {@value MappedAdefusr#COLUMN_NAME_WORKDEPT}, unique and not {@code null} in every row the sample
 * database is created with, is mapped as the identifier, which an entity needs; nothing in the
 * database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedAdefusr {

    /**
     * The name of the database materialized query table to which this class maps. The value is
     * {@value}.
     */
    public static final String TABLE_NAME = "ADEFUSR";

    // ------------------------------------------------------------------------------------ WORKDEPT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_WORKDEPT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_WORKDEPT = "WORKDEPT";

    /**
     * Whether the {@value #COLUMN_NAME_WORKDEPT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_WORKDEPT = true;

    /**
     * The length of the {@value #COLUMN_NAME_WORKDEPT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_WORKDEPT = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_WORKDEPT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_WORKDEPT = "workdept";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_WORKDEPT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_WORKDEPT = COLUMN_LENGTH_WORKDEPT;

    // ----------------------------------------------------------------------------- NO_OF_EMPLOYEES

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_NO_OF_EMPLOYEES} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_NO_OF_EMPLOYEES = "NO_OF_EMPLOYEES";

    /**
     * Whether the {@value #COLUMN_NAME_NO_OF_EMPLOYEES} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_NO_OF_EMPLOYEES = false;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_NO_OF_EMPLOYEES} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_NO_OF_EMPLOYEES = "noOfEmployees";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedAdefusr() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "workdept=" + workdept +
               ",noOfEmployees=" + noOfEmployees +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_WORKDEPT} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedAdefusr that)) {
            return false;
        }
        return Objects.equals(getWorkdept(), that.getWorkdept());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_WORKDEPT}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getWorkdept());
    }

    // ------------------------------------------------------------------------------------ workdept

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_WORKDEPT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_WORKDEPT} attribute.
     */
    @Nonnull
    public String getWorkdept() {
        return workdept;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_WORKDEPT} attribute with the specified
     * value.
     *
     * @param workdept new value for {@value #ATTRIBUTE_NAME_WORKDEPT} attribute.
     */
    protected void setWorkdept(@Nonnull final String workdept) {
        this.workdept = workdept;
    }

    // ------------------------------------------------------------------------------- noOfEmployees

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_NO_OF_EMPLOYEES} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_NO_OF_EMPLOYEES} attribute.
     */
    @Nonnull
    public Integer getNoOfEmployees() {
        return noOfEmployees;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_NO_OF_EMPLOYEES} attribute with the
     * specified value.
     *
     * @param noOfEmployees new value for {@value #ATTRIBUTE_NAME_NO_OF_EMPLOYEES} attribute.
     */
    protected void setNoOfEmployees(@Nonnull final Integer noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_WORKDEPT)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_WORKDEPT,
            nullable = COLUMN_NULLABLE_WORKDEPT,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_WORKDEPT
    )
    private String workdept;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_NO_OF_EMPLOYEES,
            nullable = COLUMN_NULLABLE_NO_OF_EMPLOYEES,
            insertable = false,
            updatable = false
    )
    private Integer noOfEmployees;
}
