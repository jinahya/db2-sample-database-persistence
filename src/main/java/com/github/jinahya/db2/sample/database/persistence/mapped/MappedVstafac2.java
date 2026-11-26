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
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A mapped superclass which holds the mappings of the {@value MappedVstafac2#TABLE_NAME} view, the
 * employees on the activities of the projects, with their names.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is insertable or updatable, and the
 * setters are not public; an extending class is for reading.
 * <p>
 * <strong>A view has no key</strong>, and this one selects from {@code EMPPROJACT}, which has none
 * either; the class maps no identifier, so an extending class is not an entity, and is built from
 * the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVstafac2 {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VSTAFAC2";

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJNO} attribute maps. The
     * value is {@value}.
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
     * Whether the {@value #COLUMN_NAME_ACTNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ACTNO = false;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACTNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = "actno";

    // ------------------------------------------------------------------------------------- ACTDESC

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ACTDESC} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ACTDESC = "ACTDESC";

    /**
     * Whether the {@value #COLUMN_NAME_ACTDESC} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ACTDESC = false;

    /**
     * The length of the {@value #COLUMN_NAME_ACTDESC} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_ACTDESC = 20;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACTDESC} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTDESC = "actdesc";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_ACTDESC} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_ACTDESC = COLUMN_LENGTH_ACTDESC;

    // --------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMPNO} attribute maps. The
     * value is {@value}.
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
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = "empno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMPNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMPNO = COLUMN_LENGTH_EMPNO;

    // ------------------------------------------------------------------------------------ FIRSTNME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_FIRSTNME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_FIRSTNME = "FIRSTNME";

    /**
     * Whether the {@value #COLUMN_NAME_FIRSTNME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_FIRSTNME = false;

    /**
     * The length of the {@value #COLUMN_NAME_FIRSTNME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_FIRSTNME = 12;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_FIRSTNME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_FIRSTNME = "firstnme";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_FIRSTNME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_FIRSTNME = COLUMN_LENGTH_FIRSTNME;

    // ------------------------------------------------------------------------------------- MIDINIT

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_MIDINIT} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_MIDINIT = "MIDINIT";

    /**
     * Whether the {@value #COLUMN_NAME_MIDINIT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_MIDINIT = true;

    /**
     * The length of the {@value #COLUMN_NAME_MIDINIT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_MIDINIT = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MIDINIT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_MIDINIT = "midinit";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_MIDINIT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_MIDINIT = COLUMN_LENGTH_MIDINIT;

    // ------------------------------------------------------------------------------------ LASTNAME

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

    // ------------------------------------------------------------------------------------- EMPTIME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMPTIME} attribute maps. The
     * value is {@value}.
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

    // -------------------------------------------------------------------------------------- STDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_STDATE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_STDATE = "STDATE";

    /**
     * Whether the {@value #COLUMN_NAME_STDATE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_STDATE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_STDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_STDATE = "stdate";

    // -------------------------------------------------------------------------------------- ENDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ENDATE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ENDATE = "ENDATE";

    /**
     * Whether the {@value #COLUMN_NAME_ENDATE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ENDATE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ENDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ENDATE = "endate";

    // ---------------------------------------------------------------------------------------- TYPE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_TYPE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_TYPE = "TYPE";

    /**
     * Whether the {@value #COLUMN_NAME_TYPE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_TYPE = false;

    /**
     * The length of the {@value #COLUMN_NAME_TYPE} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_TYPE = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_TYPE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_TYPE = "type";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_TYPE} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_TYPE = COLUMN_LENGTH_TYPE;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVstafac2() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "projno=" + projno +
               ",actno=" + actno +
               ",actdesc=" + actdesc +
               ",empno=" + empno +
               ",firstnme=" + firstnme +
               ",midinit=" + midinit +
               ",lastname=" + lastname +
               ",emptime=" + emptime +
               ",stdate=" + stdate +
               ",endate=" + endate +
               ",type=" + type +
               '}';
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

    // ------------------------------------------------------------------------------------- actdesc

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACTDESC} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACTDESC} attribute.
     */
    @Nonnull
    public String getActdesc() {
        return actdesc;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACTDESC} attribute with the specified
     * value.
     *
     * @param actdesc new value for {@value #ATTRIBUTE_NAME_ACTDESC} attribute.
     */
    protected void setActdesc(@Nonnull final String actdesc) {
        this.actdesc = actdesc;
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

    // ------------------------------------------------------------------------------------ firstnme

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     */
    @Nonnull
    public String getFirstnme() {
        return firstnme;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute with the specified
     * value.
     *
     * @param firstnme new value for {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     */
    protected void setFirstnme(@Nonnull final String firstnme) {
        this.firstnme = firstnme;
    }

    // ------------------------------------------------------------------------------------- midinit

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     */
    @Nullable
    public String getMidinit() {
        return midinit;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute with the specified
     * value.
     *
     * @param midinit new value for {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     */
    protected void setMidinit(@Nullable final String midinit) {
        this.midinit = midinit;
    }

    // ------------------------------------------------------------------------------------ lastname

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
    protected void setEmptime(@Nullable final BigDecimal emptime) {
        this.emptime = emptime;
    }

    // -------------------------------------------------------------------------------------- stdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_STDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_STDATE} attribute.
     */
    @Nonnull
    public LocalDate getStdate() {
        return stdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_STDATE} attribute with the specified
     * value.
     *
     * @param stdate new value for {@value #ATTRIBUTE_NAME_STDATE} attribute.
     */
    protected void setStdate(@Nonnull final LocalDate stdate) {
        this.stdate = stdate;
    }

    // -------------------------------------------------------------------------------------- endate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ENDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ENDATE} attribute.
     */
    @Nullable
    public LocalDate getEndate() {
        return endate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ENDATE} attribute with the specified
     * value.
     *
     * @param endate new value for {@value #ATTRIBUTE_NAME_ENDATE} attribute.
     */
    protected void setEndate(@Nullable final LocalDate endate) {
        this.endate = endate;
    }

    // ---------------------------------------------------------------------------------------- type

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_TYPE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_TYPE} attribute.
     */
    @Nonnull
    public String getType() {
        return type;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_TYPE} attribute with the specified value.
     *
     * @param type new value for {@value #ATTRIBUTE_NAME_TYPE} attribute.
     */
    protected void setType(@Nonnull final String type) {
        this.type = type;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJNO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNO,
            nullable = COLUMN_NULLABLE_PROJNO,
            insertable = false,
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
            nullable = COLUMN_NULLABLE_ACTNO,
            insertable = false,
            updatable = false
    )
    private Integer actno;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_ACTDESC)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACTDESC,
            nullable = COLUMN_NULLABLE_ACTDESC,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_ACTDESC
    )
    private String actdesc;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMPNO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPNO,
            nullable = COLUMN_NULLABLE_EMPNO,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_FIRSTNME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_FIRSTNME,
            nullable = COLUMN_NULLABLE_FIRSTNME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_FIRSTNME
    )
    private String firstnme;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_MIDINIT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MIDINIT,
            nullable = COLUMN_NULLABLE_MIDINIT,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_MIDINIT
    )
    private String midinit;

    // ---------------------------------------------------------------------------------------------
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

    // ---------------------------------------------------------------------------------------------
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

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_STDATE,
            nullable = COLUMN_NULLABLE_STDATE,
            insertable = false,
            updatable = false
    )
    private LocalDate stdate;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ENDATE,
            nullable = COLUMN_NULLABLE_ENDATE,
            insertable = false,
            updatable = false
    )
    private LocalDate endate;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_TYPE)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_TYPE,
            nullable = COLUMN_NULLABLE_TYPE,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_TYPE
    )
    private String type;
}
