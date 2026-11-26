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
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedVprojact#TABLE_NAME} view, the
 * activities of the projects.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * <strong>A view has no key.</strong> The columns {@value MappedVprojact#COLUMN_NAME_PROJNO},
 * {@value MappedVprojact#COLUMN_NAME_ACTNO}, {@value MappedVprojact#COLUMN_NAME_ACSTDATE}, unique
 * and not {@code null} in every row the sample database is created with, are mapped as the
 * identifier, which an entity needs; nothing in the database keeps that so.
 * <p>
 * The identifier is mapped with an {@link jakarta.persistence.IdClass @IdClass}: an extending
 * entity names a subclass of {@link MappedVprojactId} with {@code @IdClass} and inherits the
 * {@link Id @Id} attributes from here.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVprojactId
 */
@MappedSuperclass
public abstract class MappedVprojact {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VPROJACT";

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJNO} attribute maps. The
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
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ACTNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ACTNO = "ACTNO";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACTNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = "actno";

    // ------------------------------------------------------------------------------------- ACSTAFF

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ACSTAFF} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ACSTAFF = "ACSTAFF";

    /**
     * The precision of the {@value #COLUMN_NAME_ACSTAFF} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_ACSTAFF = 5;

    /**
     * The scale of the {@value #COLUMN_NAME_ACSTAFF} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_ACSTAFF = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACSTAFF} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACSTAFF = "acstaff";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_ACSTAFF} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_INTEGER_ACSTAFF =
            COLUMN_PRECISION_ACSTAFF - COLUMN_SCALE_ACSTAFF;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_ACSTAFF} attribute.
     * The value is {@value}.
     */
    public static final int DIGITS_FRACTION_ACSTAFF = COLUMN_SCALE_ACSTAFF;

    // ------------------------------------------------------------------------------------ ACSTDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ACSTDATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_ACSTDATE = "ACSTDATE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACSTDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACSTDATE = "acstdate";

    // ------------------------------------------------------------------------------------ ACENDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ACENDATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_ACENDATE = "ACENDATE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACENDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACENDATE = "acendate";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVprojact() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "projno=" + projno +
               ",actno=" + actno +
               ",acstaff=" + acstaff +
               ",acstdate=" + acstdate +
               ",acendate=" + acendate +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PROJNO} and
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_ACSTDATE} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVprojact that)) {
            return false;
        }
        return Objects.equals(getProjno(), that.getProjno())
               && Objects.equals(getActno(), that.getActno())
               && Objects.equals(getAcstdate(), that.getAcstdate());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PROJNO} and
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_ACSTDATE}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getProjno(), getActno(), getAcstdate());
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

    // ------------------------------------------------------------------------------------- acstaff

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACSTAFF} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACSTAFF} attribute.
     */
    @Nullable
    public BigDecimal getAcstaff() {
        return acstaff;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACSTAFF} attribute with the specified
     * value.
     *
     * @param acstaff new value for {@value #ATTRIBUTE_NAME_ACSTAFF} attribute.
     */
    protected void setAcstaff(@Nullable final BigDecimal acstaff) {
        this.acstaff = acstaff;
    }

    // ------------------------------------------------------------------------------------ acstdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     */
    @Nonnull
    public LocalDate getAcstdate() {
        return acstdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute with the specified
     * value.
     *
     * @param acstdate new value for {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     */
    protected void setAcstdate(@Nonnull final LocalDate acstdate) {
        this.acstdate = acstdate;
    }

    // ------------------------------------------------------------------------------------ acendate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACENDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACENDATE} attribute.
     */
    @Nullable
    public LocalDate getAcendate() {
        return acendate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACENDATE} attribute with the specified
     * value.
     *
     * @param acendate new value for {@value #ATTRIBUTE_NAME_ACENDATE} attribute.
     */
    protected void setAcendate(@Nullable final LocalDate acendate) {
        this.acendate = acendate;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJNO)
    @NotNull
    @Id
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
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACTNO,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Integer actno;

    // ---------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_ACSTAFF, fraction = DIGITS_FRACTION_ACSTAFF)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACSTAFF,
            nullable = true,
            insertable = false,
            updatable = false,
            precision = COLUMN_PRECISION_ACSTAFF,
            scale = COLUMN_SCALE_ACSTAFF
    )
    private BigDecimal acstaff;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACSTDATE,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private LocalDate acstdate;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACENDATE,
            nullable = true,
            insertable = false,
            updatable = false
    )
    private LocalDate acendate;
}
