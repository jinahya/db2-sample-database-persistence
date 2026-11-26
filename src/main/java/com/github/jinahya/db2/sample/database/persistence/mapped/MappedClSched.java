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

import java.time.LocalTime;
import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedClSched#TABLE_NAME} table, the
 * class schedules.
 * <p>
 * <strong>The table declares no primary key.</strong> The column
 * {@value MappedClSched#COLUMN_NAME_CLASS_CODE}, unique and not {@code null} in every row the
 * sample database is created with, is mapped as the identifier, which an entity needs; nothing in
 * the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedClSched {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "CL_SCHED";

    // ------------------------------------------------------------------------------------------------------ CLASS_CODE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_CLASS_CODE = "CLASS_CODE";

    /**
     * Whether the {@value #COLUMN_NAME_CLASS_CODE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_CLASS_CODE = true;

    /**
     * The length of the {@value #COLUMN_NAME_CLASS_CODE} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_CLASS_CODE = 7;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_CLASS_CODE} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_CLASS_CODE = "classCode";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_CLASS_CODE = COLUMN_LENGTH_CLASS_CODE;

    // ------------------------------------------------------------------------------------------------------------- DAY

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DAY} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DAY = "DAY";

    /**
     * Whether the {@value #COLUMN_NAME_DAY} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DAY = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DAY} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DAY = "day";

    // -------------------------------------------------------------------------------------------------------- STARTING

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_STARTING} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_STARTING = "STARTING";

    /**
     * Whether the {@value #COLUMN_NAME_STARTING} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_STARTING = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_STARTING} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_STARTING = "starting";

    // ---------------------------------------------------------------------------------------------------------- ENDING

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ENDING} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ENDING = "ENDING";

    /**
     * Whether the {@value #COLUMN_NAME_ENDING} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ENDING = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ENDING} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ENDING = "ending";

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedClSched() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "classCode=" + classCode +
               ",day=" + day +
               ",starting=" + starting +
               ",ending=" + ending +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_CLASS_CODE} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedClSched that)) {
            return false;
        }
        return Objects.equals(getClassCode(), that.getClassCode());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_CLASS_CODE}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getClassCode());
    }

    // ------------------------------------------------------------------------------------------------------- classCode

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute.
     */
    @Nonnull
    public String getClassCode() {
        return classCode;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute with the specified
     * value.
     *
     * @param classCode new value for {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute.
     */
    protected void setClassCode(@Nonnull final String classCode) {
        this.classCode = classCode;
    }

    // ------------------------------------------------------------------------------------------------------------- day

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DAY} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DAY} attribute.
     */
    @Nullable
    public Short getDay() {
        return day;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DAY} attribute with the specified value.
     *
     * @param day new value for {@value #ATTRIBUTE_NAME_DAY} attribute.
     */
    public void setDay(@Nullable final Short day) {
        this.day = day;
    }

    // -------------------------------------------------------------------------------------------------------- starting

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_STARTING} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_STARTING} attribute.
     */
    @Nullable
    public LocalTime getStarting() {
        return starting;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_STARTING} attribute with the specified
     * value.
     *
     * @param starting new value for {@value #ATTRIBUTE_NAME_STARTING} attribute.
     */
    public void setStarting(@Nullable final LocalTime starting) {
        this.starting = starting;
    }

    // ---------------------------------------------------------------------------------------------------------- ending

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ENDING} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ENDING} attribute.
     */
    @Nullable
    public LocalTime getEnding() {
        return ending;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ENDING} attribute with the specified
     * value.
     *
     * @param ending new value for {@value #ATTRIBUTE_NAME_ENDING} attribute.
     */
    public void setEnding(@Nullable final LocalTime ending) {
        this.ending = ending;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_CLASS_CODE)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_CLASS_CODE,
            nullable = COLUMN_NULLABLE_CLASS_CODE,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_CLASS_CODE
    )
    private String classCode;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DAY,
            nullable = COLUMN_NULLABLE_DAY,
            insertable = true,
            updatable = true
    )
    private Short day;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_STARTING,
            nullable = COLUMN_NULLABLE_STARTING,
            insertable = true,
            updatable = true
    )
    private LocalTime starting;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ENDING,
            nullable = COLUMN_NULLABLE_ENDING,
            insertable = true,
            updatable = true
    )
    private LocalTime ending;
}
