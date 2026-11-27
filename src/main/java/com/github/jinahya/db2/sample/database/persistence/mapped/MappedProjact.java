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

import com.github.jinahya.db2.sample.database.persistence.ProjactId;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A mapped superclass which holds the mappings of the {@value MappedProjact#TABLE_NAME} table, the
 * activities of the projects.
 * <p>
 * The primary key is composite, of {@value MappedProjact#COLUMN_NAME_PROJNO},
 * {@value MappedProjact#COLUMN_NAME_ACTNO}, {@value MappedProjact#COLUMN_NAME_ACSTDATE}, which this
 * class does not map: an extending entity declares it, either as {@link jakarta.persistence.Id @Id}
 * attributes with {@link ProjactId} as its {@link jakarta.persistence.IdClass @IdClass}, or as an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId} of {@link ProjactId}, and with it its
 * {@code equals} and {@code hashCode}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see ProjactId
 */
@MappedSuperclass
public abstract class MappedProjact {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "PROJACT";

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the table column to which the {@value ProjactId#ATTRIBUTE_NAME_PROJNO} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNO = "PROJNO";

    /**
     * The length of the {@value #COLUMN_NAME_PROJNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJNO = 6;

    /**
     * The maximum size of the {@value ProjactId#ATTRIBUTE_NAME_PROJNO} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_PROJNO = COLUMN_LENGTH_PROJNO;

    // --------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the table column to which the {@value ProjactId#ATTRIBUTE_NAME_ACTNO} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_ACTNO = "ACTNO";

    // ------------------------------------------------------------------------------------- ACSTAFF

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ACSTAFF} attribute maps.
     * The value is {@value}.
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
     * The name of the table column to which the {@value ProjactId#ATTRIBUTE_NAME_ACSTDATE}
     * attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_ACSTDATE = "ACSTDATE";

    // ------------------------------------------------------------------------------------ ACENDATE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ACENDATE} attribute maps.
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
    protected MappedProjact() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "acstaff=" + acstaff +
               ",acendate=" + acendate +
               '}';
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
    public void setAcstaff(@Nullable final BigDecimal acstaff) {
        this.acstaff = acstaff;
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
    public void setAcendate(@Nullable final LocalDate acendate) {
        this.acendate = acendate;
    }

    // ---------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_ACSTAFF, fraction = DIGITS_FRACTION_ACSTAFF)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACSTAFF,
            nullable = true,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_ACSTAFF,
            scale = COLUMN_SCALE_ACSTAFF
    )
    private BigDecimal acstaff;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACENDATE,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private LocalDate acendate;
}
