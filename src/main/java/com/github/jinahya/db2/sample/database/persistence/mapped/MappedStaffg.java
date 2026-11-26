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
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * A mapped superclass which holds the mappings of the {@value MappedStaffg#TABLE_NAME} table, the
 * staff, in graphic (double-byte) strings.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key by
 * its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedStaffg {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "STAFFG";

    // ------------------------------------------------------------------------------------------ ID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ID} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ID = "ID";

    /**
     * Whether the {@value #COLUMN_NAME_ID} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ID = false;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ID = "id";

    // ---------------------------------------------------------------------------------------- NAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_NAME} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_NAME = "NAME";

    /**
     * Whether the {@value #COLUMN_NAME_NAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_NAME = true;

    /**
     * The length of the {@value #COLUMN_NAME_NAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_NAME = 9;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_NAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_NAME = "name";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_NAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_NAME = COLUMN_LENGTH_NAME;

    // ---------------------------------------------------------------------------------------- DEPT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DEPT} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DEPT = "DEPT";

    /**
     * Whether the {@value #COLUMN_NAME_DEPT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPT = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT = "dept";

    // ----------------------------------------------------------------------------------------- JOB

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_JOB} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_JOB = "JOB";

    /**
     * Whether the {@value #COLUMN_NAME_JOB} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_JOB = true;

    /**
     * The length of the {@value #COLUMN_NAME_JOB} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_JOB = 5;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_JOB} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_JOB = "job";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_JOB} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_JOB = COLUMN_LENGTH_JOB;

    // --------------------------------------------------------------------------------------- YEARS

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_YEARS} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_YEARS = "YEARS";

    /**
     * Whether the {@value #COLUMN_NAME_YEARS} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_YEARS = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_YEARS} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_YEARS = "years";

    /**
     * The minimum value of the {@value #ATTRIBUTE_NAME_YEARS} attribute. The value is {@value}.
     *
     * @implNote "Years of service", as the documentation of the {@code SAMPLE} database describes
     *         the column; the database does not enforce it.
     */
    public static final int ATTRIBUTE_MIN_YEARS = 0;

    // -------------------------------------------------------------------------------------- SALARY

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SALARY} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_SALARY = "SALARY";

    /**
     * Whether the {@value #COLUMN_NAME_SALARY} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SALARY = true;

    /**
     * The precision of the {@value #COLUMN_NAME_SALARY} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_SALARY = 9;

    /**
     * The scale of the {@value #COLUMN_NAME_SALARY} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_SALARY = 0;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SALARY} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALARY = "salary";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_SALARY} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_INTEGER_SALARY = COLUMN_PRECISION_SALARY - COLUMN_SCALE_SALARY;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_SALARY} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_FRACTION_SALARY = COLUMN_SCALE_SALARY;

    /**
     * The minimum value of the {@value #ATTRIBUTE_NAME_SALARY} attribute. The value is {@value}.
     *
     * @implNote "Current salary", as the documentation of the {@code SAMPLE} database describes the
     *         column; the database does not enforce it.
     */
    public static final String ATTRIBUTE_DECIMAL_MIN_SALARY = "0";

    // ---------------------------------------------------------------------------------------- COMM

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_COMM} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_COMM = "COMM";

    /**
     * Whether the {@value #COLUMN_NAME_COMM} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_COMM = true;

    /**
     * The precision of the {@value #COLUMN_NAME_COMM} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_COMM = 9;

    /**
     * The scale of the {@value #COLUMN_NAME_COMM} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_COMM = 0;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_COMM} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_COMM = "comm";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_COMM} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_INTEGER_COMM = COLUMN_PRECISION_COMM - COLUMN_SCALE_COMM;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_COMM} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_FRACTION_COMM = COLUMN_SCALE_COMM;

    /**
     * The minimum value of the {@value #ATTRIBUTE_NAME_COMM} attribute. The value is {@value}.
     *
     * @implNote "Commission", as the documentation of the {@code SAMPLE} database describes the
     *         column; the database does not enforce it.
     */
    public static final String ATTRIBUTE_DECIMAL_MIN_COMM = "0";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedStaffg() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "id=" + id +
               ",name=" + name +
               ",dept=" + dept +
               ",job=" + job +
               ",years=" + years +
               ",salary=" + salary +
               ",comm=" + comm +
               '}';
    }

    // ------------------------------------------------------------------------------------------ id

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     */
    @Nonnull
    public Integer getId() {
        return id;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ID} attribute with the specified value.
     *
     * @param id new value for {@value #ATTRIBUTE_NAME_ID} attribute.
     */
    protected void setId(@Nonnull final Integer id) {
        this.id = id;
    }

    // ---------------------------------------------------------------------------------------- name

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_NAME} attribute, from a VARGRAPHIC column.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_NAME} attribute.
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_NAME} attribute with the specified value.
     *
     * @param name new value for {@value #ATTRIBUTE_NAME_NAME} attribute.
     */
    public void setName(@Nullable final String name) {
        this.name = name;
    }

    // ---------------------------------------------------------------------------------------- dept

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPT} attribute.
     */
    @Nullable
    public Integer getDept() {
        return dept;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPT} attribute with the specified value.
     *
     * @param dept new value for {@value #ATTRIBUTE_NAME_DEPT} attribute.
     */
    public void setDept(@Nullable final Integer dept) {
        this.dept = dept;
    }

    // ----------------------------------------------------------------------------------------- job

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_JOB} attribute, from a GRAPHIC column.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_JOB} attribute.
     */
    @Nullable
    public String getJob() {
        return job;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_JOB} attribute with the specified value.
     *
     * @param job new value for {@value #ATTRIBUTE_NAME_JOB} attribute.
     */
    public void setJob(@Nullable final String job) {
        this.job = job;
    }

    // --------------------------------------------------------------------------------------- years

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_YEARS} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_YEARS} attribute.
     */
    @Nullable
    public Integer getYears() {
        return years;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_YEARS} attribute with the specified value.
     *
     * @param years new value for {@value #ATTRIBUTE_NAME_YEARS} attribute.
     */
    public void setYears(@Nullable final Integer years) {
        this.years = years;
    }

    // -------------------------------------------------------------------------------------- salary

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SALARY} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SALARY} attribute.
     */
    @Nullable
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SALARY} attribute with the specified
     * value.
     *
     * @param salary new value for {@value #ATTRIBUTE_NAME_SALARY} attribute.
     */
    public void setSalary(@Nullable final BigDecimal salary) {
        this.salary = salary;
    }

    // ---------------------------------------------------------------------------------------- comm

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_COMM} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_COMM} attribute.
     */
    @Nullable
    public BigDecimal getComm() {
        return comm;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_COMM} attribute with the specified value.
     *
     * @param comm new value for {@value #ATTRIBUTE_NAME_COMM} attribute.
     */
    public void setComm(@Nullable final BigDecimal comm) {
        this.comm = comm;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Max(Db2Constants.SMALLINT_MAX)
    @Min(Db2Constants.SMALLINT_MIN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ID,
            nullable = COLUMN_NULLABLE_ID,
            insertable = true,
            updatable = false
    )
    private Integer id;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_NAME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_NAME,
            nullable = COLUMN_NULLABLE_NAME,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_NAME
    )
    private String name;

    // ---------------------------------------------------------------------------------------------
    @Max(Db2Constants.SMALLINT_MAX)
    @Min(Db2Constants.SMALLINT_MIN)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPT,
            nullable = COLUMN_NULLABLE_DEPT,
            insertable = true,
            updatable = true
    )
    private Integer dept;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_JOB)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_JOB,
            nullable = COLUMN_NULLABLE_JOB,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_JOB
    )
    private String job;

    // ---------------------------------------------------------------------------------------------
    @Min(ATTRIBUTE_MIN_YEARS)
    @Max(Db2Constants.SMALLINT_MAX)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_YEARS,
            nullable = COLUMN_NULLABLE_YEARS,
            insertable = true,
            updatable = true
    )
    private Integer years;

    // ---------------------------------------------------------------------------------------------
    @DecimalMin(ATTRIBUTE_DECIMAL_MIN_SALARY)
    @Digits(integer = DIGITS_INTEGER_SALARY, fraction = DIGITS_FRACTION_SALARY)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SALARY,
            nullable = COLUMN_NULLABLE_SALARY,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_SALARY,
            scale = COLUMN_SCALE_SALARY
    )
    private BigDecimal salary;

    // ---------------------------------------------------------------------------------------------
    @DecimalMin(ATTRIBUTE_DECIMAL_MIN_COMM)
    @Digits(integer = DIGITS_INTEGER_COMM, fraction = DIGITS_FRACTION_COMM)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_COMM,
            nullable = COLUMN_NULLABLE_COMM,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_COMM,
            scale = COLUMN_SCALE_COMM
    )
    private BigDecimal comm;
}
