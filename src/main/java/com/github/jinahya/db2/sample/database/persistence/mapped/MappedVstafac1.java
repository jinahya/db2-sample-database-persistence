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

import com.github.jinahya.db2.sample.database.persistence.Vstafac1Id;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A mapped superclass which holds the mappings of the {@value MappedVstafac1#TABLE_NAME} view, the
 * staffing of the activities of the projects.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an
 * {@link jakarta.persistence.Id @Id} mapping to be writable.
 * <p>
 * <strong>A view has no key.</strong> The columns {@value MappedVstafac1#COLUMN_NAME_PROJNO},
 * {@value MappedVstafac1#COLUMN_NAME_ACTNO}, {@value MappedVstafac1#COLUMN_NAME_STDATE}, unique and
 * not {@code null} in every row the sample database is created with, are its identifier, which an
 * entity needs, though nothing in the database keeps them so. This class does not map it: an
 * extending entity declares it, either as {@link jakarta.persistence.Id @Id} attributes with
 * {@link Vstafac1Id} as its {@link jakarta.persistence.IdClass @IdClass}, or as an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId} of {@link Vstafac1Id}, and with it its
 * {@code equals} and {@code hashCode}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see Vstafac1Id
 */
@MappedSuperclass
public abstract class MappedVstafac1 {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VSTAFAC1";

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the view column to which the {@value Vstafac1Id#ATTRIBUTE_NAME_PROJNO} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNO = "PROJNO";

    /**
     * The length of the {@value #COLUMN_NAME_PROJNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJNO = 6;

    /**
     * The maximum size of the {@value Vstafac1Id#ATTRIBUTE_NAME_PROJNO} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_PROJNO = COLUMN_LENGTH_PROJNO;

    // --------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the view column to which the {@value Vstafac1Id#ATTRIBUTE_NAME_ACTNO} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_ACTNO = "ACTNO";

    // ------------------------------------------------------------------------------------- ACTDESC

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ACTDESC} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ACTDESC = "ACTDESC";

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
     * The length of the {@value #COLUMN_NAME_EMPNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMPNO = 1;

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
     * The length of the {@value #COLUMN_NAME_FIRSTNME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_FIRSTNME = 1;

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
     * The length of the {@value #COLUMN_NAME_LASTNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_LASTNAME = 1;

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
     * The name of the view column to which the {@value Vstafac1Id#ATTRIBUTE_NAME_STDATE} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_STDATE = "STDATE";

    // -------------------------------------------------------------------------------------- ENDATE

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ENDATE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ENDATE = "ENDATE";

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
    protected MappedVstafac1() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "actdesc=" + actdesc +
               ",empno=" + empno +
               ",firstnme=" + firstnme +
               ",midinit=" + midinit +
               ",lastname=" + lastname +
               ",emptime=" + emptime +
               ",endate=" + endate +
               ",type=" + type +
               '}';
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
    @Nonnull
    public String getMidinit() {
        return midinit;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute with the specified
     * value.
     *
     * @param midinit new value for {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     */
    protected void setMidinit(@Nonnull final String midinit) {
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
    @Size(max = SIZE_MAX_ACTDESC)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACTDESC,
            nullable = false,
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
            nullable = false,
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
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_FIRSTNME
    )
    private String firstnme;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_MIDINIT)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MIDINIT,
            nullable = false,
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
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_LASTNAME
    )
    private String lastname;

    // ---------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_EMPTIME, fraction = DIGITS_FRACTION_EMPTIME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPTIME,
            nullable = true,
            insertable = false,
            updatable = false,
            precision = COLUMN_PRECISION_EMPTIME,
            scale = COLUMN_SCALE_EMPTIME
    )
    private BigDecimal emptime;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ENDATE,
            nullable = true,
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
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_TYPE
    )
    private String type;
}
