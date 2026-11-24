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
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedVempprojact#TABLE_NAME} view, the employees on
 * activities of projects.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's is insertable, and
 * the setters are not public; an extending entity is for reading. The identifier's columns stay insertable since
 * EclipseLink requires an {@link Id @Id} mapping to be writable.
 * <p>
 * <strong>A view has no key.</strong> The columns {@value MappedVempprojact#COLUMN_NAME_EMPNO},
 * {@value MappedVempprojact#COLUMN_NAME_PROJNO}, {@value MappedVempprojact#COLUMN_NAME_ACTNO},
 * {@value MappedVempprojact#COLUMN_NAME_EMSTDATE}, unique and not {@code null} in every row the sample database is
 * created with, are mapped as the identifier, which an entity needs; nothing in the database keeps that so.
 * <p>
 * The identifier is mapped with an {@link jakarta.persistence.IdClass @IdClass}: an extending entity names a subclass
 * of {@link MappedVempprojactId} with {@code @IdClass} and inherits the {@link Id @Id} attributes from here.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVempprojactId
 */
@MappedSuperclass
public abstract class MappedVempprojact {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VEMPPROJACT";

    // ----------------------------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMPNO} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    /**
     * Whether the {@value #COLUMN_NAME_EMPNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMPNO = false;

    /**
     * The length of the {@value #COLUMN_NAME_EMPNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMPNO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPNO} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = "empno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMPNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMPNO = COLUMN_LENGTH_EMPNO;

    // ---------------------------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJNO} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNO = "PROJNO";

    /**
     * Whether the {@value #COLUMN_NAME_PROJNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROJNO = false;

    /**
     * The length of the {@value #COLUMN_NAME_PROJNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJNO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJNO} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNO = "projno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJNO = COLUMN_LENGTH_PROJNO;

    // ----------------------------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ACTNO} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_ACTNO = "ACTNO";

    /**
     * Whether the {@value #COLUMN_NAME_ACTNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ACTNO = false;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACTNO} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = "actno";

    // --------------------------------------------------------------------------------------------------------- EMPTIME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMPTIME} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_EMPTIME = "EMPTIME";

    /**
     * Whether the {@value #COLUMN_NAME_EMPTIME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMPTIME = true;

    /**
     * The precision of the {@value #COLUMN_NAME_EMPTIME} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_EMPTIME = 5;

    /**
     * The scale of the {@value #COLUMN_NAME_EMPTIME} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_EMPTIME = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPTIME} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPTIME = "emptime";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_EMPTIME} attribute. The value is {@value}.
     */
    public static final int DIGITS_INTEGER_EMPTIME = COLUMN_PRECISION_EMPTIME - COLUMN_SCALE_EMPTIME;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_EMPTIME} attribute. The value is {@value}.
     */
    public static final int DIGITS_FRACTION_EMPTIME = COLUMN_SCALE_EMPTIME;

    // -------------------------------------------------------------------------------------------------------- EMSTDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMSTDATE} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_EMSTDATE = "EMSTDATE";

    /**
     * Whether the {@value #COLUMN_NAME_EMSTDATE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMSTDATE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMSTDATE} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMSTDATE = "emstdate";

    // -------------------------------------------------------------------------------------------------------- EMENDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMENDATE} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_EMENDATE = "EMENDATE";

    /**
     * Whether the {@value #COLUMN_NAME_EMENDATE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMENDATE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMENDATE} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMENDATE = "emendate";

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVempprojact() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

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

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPNO} and {@value #ATTRIBUTE_NAME_PROJNO} and
     * {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_EMSTDATE} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVempprojact that)) {
            return false;
        }
        return Objects.equals(getEmpno(), that.getEmpno())
               && Objects.equals(getProjno(), that.getProjno())
               && Objects.equals(getActno(), that.getActno())
               && Objects.equals(getEmstdate(), that.getEmstdate());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_EMPNO} and {@value #ATTRIBUTE_NAME_PROJNO} and
     * {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_EMSTDATE}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getEmpno(), getProjno(), getActno(), getEmstdate());
    }

    // ----------------------------------------------------------------------------------------------------------- empno

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

    // ---------------------------------------------------------------------------------------------------------- projno

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
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute with the specified value.
     *
     * @param projno new value for {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     */
    protected void setProjno(@Nonnull final String projno) {
        this.projno = projno;
    }

    // ----------------------------------------------------------------------------------------------------------- actno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    @Nonnull
    public Short getActno() {
        return actno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute with the specified value.
     *
     * @param actno new value for {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    protected void setActno(@Nonnull final Short actno) {
        this.actno = actno;
    }

    // --------------------------------------------------------------------------------------------------------- emptime

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
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPTIME} attribute with the specified value.
     *
     * @param emptime new value for {@value #ATTRIBUTE_NAME_EMPTIME} attribute.
     */
    protected void setEmptime(@Nullable final BigDecimal emptime) {
        this.emptime = emptime;
    }

    // -------------------------------------------------------------------------------------------------------- emstdate

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
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMSTDATE} attribute with the specified value.
     *
     * @param emstdate new value for {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     */
    protected void setEmstdate(@Nonnull final LocalDate emstdate) {
        this.emstdate = emstdate;
    }

    // -------------------------------------------------------------------------------------------------------- emendate

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
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMENDATE} attribute with the specified value.
     *
     * @param emendate new value for {@value #ATTRIBUTE_NAME_EMENDATE} attribute.
     */
    protected void setEmendate(@Nullable final LocalDate emendate) {
        this.emendate = emendate;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMPNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPNO,
            nullable = COLUMN_NULLABLE_EMPNO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNO,
            nullable = COLUMN_NULLABLE_PROJNO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PROJNO
    )
    private String projno;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACTNO,
            nullable = COLUMN_NULLABLE_ACTNO,
            insertable = true,
            updatable = false
    )
    private Short actno;

    // -----------------------------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_EMPTIME, fraction = DIGITS_FRACTION_EMPTIME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPTIME,
            nullable = COLUMN_NULLABLE_EMPTIME,
            insertable = false,
            updatable = false,
            precision = COLUMN_PRECISION_EMPTIME,
            scale = COLUMN_SCALE_EMPTIME
    )
    private BigDecimal emptime;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMSTDATE,
            nullable = COLUMN_NULLABLE_EMSTDATE,
            insertable = true,
            updatable = false
    )
    private LocalDate emstdate;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMENDATE,
            nullable = COLUMN_NULLABLE_EMENDATE,
            insertable = false,
            updatable = false
    )
    private LocalDate emendate;
}
