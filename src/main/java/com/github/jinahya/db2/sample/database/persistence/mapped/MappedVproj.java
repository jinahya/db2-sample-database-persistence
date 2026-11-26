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
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedVproj#TABLE_NAME} view, the
 * projects.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * <strong>A view has no key.</strong> The column {@value MappedVproj#COLUMN_NAME_PROJNO}, unique
 * and not {@code null} in every row the sample database is created with, is mapped as the
 * identifier, which an entity needs; nothing in the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVproj {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VPROJ";

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

    // ------------------------------------------------------------------------------------ PROJNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNAME = "PROJNAME";

    /**
     * The length of the {@value #COLUMN_NAME_PROJNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJNAME = 24;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJNAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNAME = "projname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJNAME = COLUMN_LENGTH_PROJNAME;

    // -------------------------------------------------------------------------------------- DEPTNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPTNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNO = "DEPTNO";

    /**
     * The length of the {@value #COLUMN_NAME_DEPTNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPTNO = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPTNO = "deptno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPTNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPTNO = COLUMN_LENGTH_DEPTNO;

    // ------------------------------------------------------------------------------------- RESPEMP

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESPEMP} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESPEMP = "RESPEMP";

    /**
     * The length of the {@value #COLUMN_NAME_RESPEMP} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESPEMP = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESPEMP} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESPEMP = "respemp";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESPEMP} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESPEMP = COLUMN_LENGTH_RESPEMP;

    // ------------------------------------------------------------------------------------- PRSTAFF

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PRSTAFF} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PRSTAFF = "PRSTAFF";

    /**
     * The precision of the {@value #COLUMN_NAME_PRSTAFF} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_PRSTAFF = 5;

    /**
     * The scale of the {@value #COLUMN_NAME_PRSTAFF} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_PRSTAFF = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PRSTAFF} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PRSTAFF = "prstaff";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_PRSTAFF} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_INTEGER_PRSTAFF =
            COLUMN_PRECISION_PRSTAFF - COLUMN_SCALE_PRSTAFF;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_PRSTAFF} attribute.
     * The value is {@value}.
     */
    public static final int DIGITS_FRACTION_PRSTAFF = COLUMN_SCALE_PRSTAFF;

    // ------------------------------------------------------------------------------------ PRSTDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PRSTDATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PRSTDATE = "PRSTDATE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PRSTDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PRSTDATE = "prstdate";

    // ------------------------------------------------------------------------------------ PRENDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PRENDATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PRENDATE = "PRENDATE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PRENDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PRENDATE = "prendate";

    // ------------------------------------------------------------------------------------- MAJPROJ

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_MAJPROJ} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_MAJPROJ = "MAJPROJ";

    /**
     * The length of the {@value #COLUMN_NAME_MAJPROJ} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_MAJPROJ = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MAJPROJ} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_MAJPROJ = "majproj";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_MAJPROJ} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_MAJPROJ = COLUMN_LENGTH_MAJPROJ;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVproj() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "projno=" + projno +
               ",projname=" + projname +
               ",deptno=" + deptno +
               ",respemp=" + respemp +
               ",prstaff=" + prstaff +
               ",prstdate=" + prstdate +
               ",prendate=" + prendate +
               ",majproj=" + majproj +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PROJNO} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVproj that)) {
            return false;
        }
        return Objects.equals(getProjno(), that.getProjno());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PROJNO}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getProjno());
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

    // ------------------------------------------------------------------------------------ projname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJNAME} attribute.
     */
    @Nonnull
    public String getProjname() {
        return projname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJNAME} attribute with the specified
     * value.
     *
     * @param projname new value for {@value #ATTRIBUTE_NAME_PROJNAME} attribute.
     */
    protected void setProjname(@Nonnull final String projname) {
        this.projname = projname;
    }

    // -------------------------------------------------------------------------------------- deptno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     */
    @Nonnull
    public String getDeptno() {
        return deptno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute with the specified
     * value.
     *
     * @param deptno new value for {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     */
    protected void setDeptno(@Nonnull final String deptno) {
        this.deptno = deptno;
    }

    // ------------------------------------------------------------------------------------- respemp

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESPEMP} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESPEMP} attribute.
     */
    @Nonnull
    public String getRespemp() {
        return respemp;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESPEMP} attribute with the specified
     * value.
     *
     * @param respemp new value for {@value #ATTRIBUTE_NAME_RESPEMP} attribute.
     */
    protected void setRespemp(@Nonnull final String respemp) {
        this.respemp = respemp;
    }

    // ------------------------------------------------------------------------------------- prstaff

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PRSTAFF} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PRSTAFF} attribute.
     */
    @Nullable
    public BigDecimal getPrstaff() {
        return prstaff;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PRSTAFF} attribute with the specified
     * value.
     *
     * @param prstaff new value for {@value #ATTRIBUTE_NAME_PRSTAFF} attribute.
     */
    protected void setPrstaff(@Nullable final BigDecimal prstaff) {
        this.prstaff = prstaff;
    }

    // ------------------------------------------------------------------------------------ prstdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PRSTDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PRSTDATE} attribute.
     */
    @Nullable
    public LocalDate getPrstdate() {
        return prstdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PRSTDATE} attribute with the specified
     * value.
     *
     * @param prstdate new value for {@value #ATTRIBUTE_NAME_PRSTDATE} attribute.
     */
    protected void setPrstdate(@Nullable final LocalDate prstdate) {
        this.prstdate = prstdate;
    }

    // ------------------------------------------------------------------------------------ prendate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PRENDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PRENDATE} attribute.
     */
    @Nullable
    public LocalDate getPrendate() {
        return prendate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PRENDATE} attribute with the specified
     * value.
     *
     * @param prendate new value for {@value #ATTRIBUTE_NAME_PRENDATE} attribute.
     */
    protected void setPrendate(@Nullable final LocalDate prendate) {
        this.prendate = prendate;
    }

    // ------------------------------------------------------------------------------------- majproj

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MAJPROJ} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MAJPROJ} attribute.
     */
    @Nullable
    public String getMajproj() {
        return majproj;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MAJPROJ} attribute with the specified
     * value.
     *
     * @param majproj new value for {@value #ATTRIBUTE_NAME_MAJPROJ} attribute.
     */
    protected void setMajproj(@Nullable final String majproj) {
        this.majproj = majproj;
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
    @Size(max = SIZE_MAX_PROJNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNAME,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PROJNAME
    )
    private String projname;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPTNO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNO,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPTNO
    )
    private String deptno;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESPEMP)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESPEMP,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESPEMP
    )
    private String respemp;

    // ---------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_PRSTAFF, fraction = DIGITS_FRACTION_PRSTAFF)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PRSTAFF,
            nullable = true,
            insertable = false,
            updatable = false,
            precision = COLUMN_PRECISION_PRSTAFF,
            scale = COLUMN_SCALE_PRSTAFF
    )
    private BigDecimal prstaff;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PRSTDATE,
            nullable = true,
            insertable = false,
            updatable = false
    )
    private LocalDate prstdate;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PRENDATE,
            nullable = true,
            insertable = false,
            updatable = false
    )
    private LocalDate prendate;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_MAJPROJ)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MAJPROJ,
            nullable = true,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_MAJPROJ
    )
    private String majproj;
}
