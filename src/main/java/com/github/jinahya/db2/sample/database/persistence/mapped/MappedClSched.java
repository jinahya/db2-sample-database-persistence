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
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;

/**
 * A mapped superclass which holds the mappings of the {@value MappedClSched#TABLE_NAME} table, the
 * class schedules.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key
 * by its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedClSched {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "CL_SCHED";

    // ---------------------------------------------------------------------------------- CLASS_CODE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_CLASS_CODE = "CLASS_CODE";

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

    // ----------------------------------------------------------------------------------------- DAY

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DAY} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DAY = "DAY";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DAY} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DAY = "day";

    /**
     * The minimum value of the {@value #ATTRIBUTE_NAME_DAY} attribute. The value is {@value}.
     *
     * @implNote The column is a day number of a four-day schedule, as the documentation of
     *         the {@code SAMPLE} database describes it; the database does not enforce it, with no
     *         check constraint, and the installed rows hold {@code 1} to {@code 4}.
     */
    public static final int ATTRIBUTE_MIN_DAY = 1;

    /**
     * The maximum value of the {@value #ATTRIBUTE_NAME_DAY} attribute. The value is {@value}.
     *
     * @implNote The column is a day number of a four-day schedule, as the documentation of
     *         the {@code SAMPLE} database describes it; the database does not enforce it, with no
     *         check constraint, and the installed rows hold {@code 1} to {@code 4}.
     */
    public static final int ATTRIBUTE_MAX_DAY = 4;

    // ------------------------------------------------------------------------------------ STARTING

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_STARTING} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_STARTING = "STARTING";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_STARTING} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_STARTING = "starting";

    // -------------------------------------------------------------------------------------- ENDING

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ENDING} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ENDING = "ENDING";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ENDING} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ENDING = "ending";

    // --------------------------------------------------------------------------------- SELECT_LIST

    /**
     * The columns of {@value #TABLE_NAME}, in their order, as the select list of a native query
     * whose rows an extending class is built from. The value is {@value}.
     */
    public static final String SELECT_LIST =
            COLUMN_NAME_CLASS_CODE + ", "
            + COLUMN_NAME_DAY + ", "
            + COLUMN_NAME_STARTING + ", "
            + COLUMN_NAME_ENDING;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedClSched() {
        super();
    }

    /**
     * Creates a new instance with the specified values, in the order of {@link #SELECT_LIST}.
     *
     * @param classCode a value for the {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute.
     * @param day       a value for the {@value #ATTRIBUTE_NAME_DAY} attribute.
     * @param starting  a value for the {@value #ATTRIBUTE_NAME_STARTING} attribute.
     * @param ending    a value for the {@value #ATTRIBUTE_NAME_ENDING} attribute.
     */
    protected MappedClSched(
            final String classCode,
            final Integer day,
            final LocalTime starting,
            final LocalTime ending) {
        this();
        this.classCode = classCode;
        this.day = day;
        this.starting = starting;
        this.ending = ending;
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "classCode=" + classCode +
               ",day=" + day +
               ",starting=" + starting +
               ",ending=" + ending +
               '}';
    }

    // ----------------------------------------------------------------------------------- classCode

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_CLASS_CODE} attribute.
     * <p>
     * The documentation of the {@code SAMPLE} database describes the
     * {@value #COLUMN_NAME_CLASS_CODE} column as "Class Code (room:teacher)".
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
    public void setClassCode(@Nonnull final String classCode) {
        this.classCode = classCode;
    }

    // ----------------------------------------------------------------------------------------- day

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DAY} attribute.
     * <p>
     * The documentation of the {@code SAMPLE} database describes the {@value #COLUMN_NAME_DAY}
     * column as "Day # of 4 day schedule".
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DAY} attribute.
     */
    @Nullable
    public Integer getDay() {
        return day;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DAY} attribute with the specified value.
     *
     * @param day new value for {@value #ATTRIBUTE_NAME_DAY} attribute.
     */
    public void setDay(@Nullable final Integer day) {
        this.day = day;
    }

    // ------------------------------------------------------------------------------------ starting

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_STARTING} attribute.
     * <p>
     * The documentation of the {@code SAMPLE} database describes the {@value #COLUMN_NAME_STARTING}
     * column as "Class Start Time".
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

    // -------------------------------------------------------------------------------------- ending

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ENDING} attribute.
     * <p>
     * The documentation of the {@code SAMPLE} database describes the {@value #COLUMN_NAME_ENDING}
     * column as "Class End Time".
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

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_CLASS_CODE)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_CLASS_CODE,
            nullable = true,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_CLASS_CODE
    )
    private String classCode;

    // ---------------------------------------------------------------------------------------------
    // the day of a four-day schedule; not enforced by the database
    @Max(ATTRIBUTE_MAX_DAY)
    @Min(ATTRIBUTE_MIN_DAY)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DAY,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer day;

    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_STARTING,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private LocalTime starting;

    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ENDING,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private LocalTime ending;
}
