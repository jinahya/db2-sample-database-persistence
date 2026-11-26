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
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A mapped superclass which holds the mappings of the {@value MappedEmpProjAct#TABLE_NAME} table,
 * the employees on activities of projects.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key
 * by
 * its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedEmpProjAct {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "EMPPROJACT";

    // --------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMPNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    /**
     * The length of the {@value #COLUMN_NAME_EMPNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMPNO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = "empno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMPNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMPNO = COLUMN_LENGTH_EMPNO;

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PROJNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNO = "PROJNO";

    /**
     * The length of the {@value #COLUMN_NAME_PROJNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJNO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNO = "projno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJNO = COLUMN_LENGTH_PROJNO;

    // --------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ACTNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ACTNO = "ACTNO";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACTNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = "actno";

    // ------------------------------------------------------------------------------------- EMPTIME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMPTIME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_EMPTIME = "EMPTIME";

    /**
     * The precision of the {@value #COLUMN_NAME_EMPTIME} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_EMPTIME = 5;

    /**
     * The scale of the {@value #COLUMN_NAME_EMPTIME} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_EMPTIME = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPTIME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPTIME = "emptime";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_EMPTIME} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_INTEGER_EMPTIME =
            COLUMN_PRECISION_EMPTIME - COLUMN_SCALE_EMPTIME;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_EMPTIME} attribute.
     * The value is {@value}.
     */
    public static final int DIGITS_FRACTION_EMPTIME = COLUMN_SCALE_EMPTIME;

    /**
     * The maximum value of the {@value #ATTRIBUTE_NAME_EMPTIME} attribute. The value is {@value}.
     *
     * @implNote "Proportion of employee's time spent on project", as the documentation of
     *         the {@code SAMPLE} database describes the column; the database does not enforce it.
     */
    public static final String ATTRIBUTE_DECIMAL_MAX_EMPTIME = "1";

    /**
     * The minimum value of the {@value #ATTRIBUTE_NAME_EMPTIME} attribute. The value is {@value}.
     *
     * @implNote "Proportion of employee's time spent on project", as the documentation of
     *         the {@code SAMPLE} database describes the column; the database does not enforce it.
     */
    public static final String ATTRIBUTE_DECIMAL_MIN_EMPTIME = "0";

    // ------------------------------------------------------------------------------------ EMSTDATE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMSTDATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_EMSTDATE = "EMSTDATE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMSTDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMSTDATE = "emstdate";

    // ------------------------------------------------------------------------------------ EMENDATE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMENDATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_EMENDATE = "EMENDATE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMENDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMENDATE = "emendate";

    // --------------------------------------------------------------------------------- SELECT_LIST

    /**
     * The columns of {@value #TABLE_NAME}, in their order, as the select list of a native query
     * whose rows an extending class is built from. The value is {@value}.
     */
    public static final String SELECT_LIST =
            COLUMN_NAME_EMPNO + ", "
            + COLUMN_NAME_PROJNO + ", "
            + COLUMN_NAME_ACTNO + ", "
            + COLUMN_NAME_EMPTIME + ", "
            + COLUMN_NAME_EMSTDATE + ", "
            + COLUMN_NAME_EMENDATE;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedEmpProjAct() {
        super();
    }

    /**
     * Creates a new instance with the specified values, in the order of {@link #SELECT_LIST}.
     *
     * @param empno    a value for the {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     * @param projno   a value for the {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     * @param actno    a value for the {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     * @param emptime  a value for the {@value #ATTRIBUTE_NAME_EMPTIME} attribute.
     * @param emstdate a value for the {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     * @param emendate a value for the {@value #ATTRIBUTE_NAME_EMENDATE} attribute.
     */
    protected MappedEmpProjAct(
            final String empno,
            final String projno,
            final Integer actno,
            final BigDecimal emptime,
            final LocalDate emstdate,
            final LocalDate emendate) {
        this();
        this.empno = empno;
        this.projno = projno;
        this.actno = actno;
        this.emptime = emptime;
        this.emstdate = emstdate;
        this.emendate = emendate;
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "empno=" + empno +
               ",projno=" + projno +
               ",actno=" + actno +
               ",emptime=" + emptime +
               ",emstdate=" + emstdate +
               ",emendate=" + emendate +
               '}';
    }

    // --------------------------------------------------------------------------------------- empno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    @Nonnull
    public String getEmpno() {
        return empno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute with the specified value.
     *
     * @param empno new value for {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    protected void setEmpno(@Nonnull final String empno) {
        this.empno = empno;
    }

    // -------------------------------------------------------------------------------------- projno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     */
    @Nonnull
    public String getProjno() {
        return projno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute with the specified
     * value.
     *
     * @param projno new value for {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     */
    protected void setProjno(@Nonnull final String projno) {
        this.projno = projno;
    }

    // --------------------------------------------------------------------------------------- actno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    @Nonnull
    public Integer getActno() {
        return actno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute with the specified value.
     *
     * @param actno new value for {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    protected void setActno(@Nonnull final Integer actno) {
        this.actno = actno;
    }

    // ------------------------------------------------------------------------------------- emptime

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMPTIME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMPTIME} attribute.
     */
    @Nullable
    public BigDecimal getEmptime() {
        return emptime;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPTIME} attribute with the specified
     * value.
     *
     * @param emptime new value for {@value #ATTRIBUTE_NAME_EMPTIME} attribute.
     */
    public void setEmptime(@Nullable final BigDecimal emptime) {
        this.emptime = emptime;
    }

    // ------------------------------------------------------------------------------------ emstdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     */
    @Nonnull
    public LocalDate getEmstdate() {
        return emstdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMSTDATE} attribute with the specified
     * value.
     *
     * @param emstdate new value for {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     */
    protected void setEmstdate(@Nonnull final LocalDate emstdate) {
        this.emstdate = emstdate;
    }

    // ------------------------------------------------------------------------------------ emendate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMENDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMENDATE} attribute.
     */
    @Nullable
    public LocalDate getEmendate() {
        return emendate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMENDATE} attribute with the specified
     * value.
     *
     * @param emendate new value for {@value #ATTRIBUTE_NAME_EMENDATE} attribute.
     */
    public void setEmendate(@Nullable final LocalDate emendate) {
        this.emendate = emendate;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMPNO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJNO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PROJNO
    )
    private String projno;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Max(Db2Constants.SMALLINT_MAX)
    @Min(Db2Constants.SMALLINT_MIN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACTNO,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Integer actno;

    // ---------------------------------------------------------------------------------------------
    @DecimalMax(ATTRIBUTE_DECIMAL_MAX_EMPTIME)
    @DecimalMin(ATTRIBUTE_DECIMAL_MIN_EMPTIME)
    @Digits(integer = DIGITS_INTEGER_EMPTIME, fraction = DIGITS_FRACTION_EMPTIME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPTIME,
            nullable = true,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_EMPTIME,
            scale = COLUMN_SCALE_EMPTIME
    )
    private BigDecimal emptime;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMSTDATE,
            nullable = true,
            insertable = true,
            updatable = false
    )
    private LocalDate emstdate;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMENDATE,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private LocalDate emendate;
}
