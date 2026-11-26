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
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedAct#TABLE_NAME} table, the
 * activities.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedAct {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "ACT";

    // ----------------------------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ACTNO} attribute maps. The
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

    // ---------------------------------------------------------------------------------------------------------- ACTKWD

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ACTKWD} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ACTKWD = "ACTKWD";

    /**
     * Whether the {@value #COLUMN_NAME_ACTKWD} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ACTKWD = false;

    /**
     * The length of the {@value #COLUMN_NAME_ACTKWD} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_ACTKWD = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACTKWD} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTKWD = "actkwd";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_ACTKWD} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_ACTKWD = COLUMN_LENGTH_ACTKWD;

    // --------------------------------------------------------------------------------------------------------- ACTDESC

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ACTDESC} attribute maps.
     * The value is {@value}.
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

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedAct() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "actno=" + actno +
               ",actkwd=" + actkwd +
               ",actdesc=" + actdesc +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_ACTNO} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedAct that)) {
            return false;
        }
        return Objects.equals(getActno(), that.getActno());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_ACTNO}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getActno());
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

    // ---------------------------------------------------------------------------------------------------------- actkwd

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACTKWD} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACTKWD} attribute.
     */
    @Nonnull
    public String getActkwd() {
        return actkwd;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACTKWD} attribute with the specified
     * value.
     *
     * @param actkwd new value for {@value #ATTRIBUTE_NAME_ACTKWD} attribute.
     */
    public void setActkwd(@Nonnull final String actkwd) {
        this.actkwd = actkwd;
    }

    // --------------------------------------------------------------------------------------------------------- actdesc

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
    public void setActdesc(@Nonnull final String actdesc) {
        this.actdesc = actdesc;
    }

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
    @Nonnull
    @Size(max = SIZE_MAX_ACTKWD)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACTKWD,
            nullable = COLUMN_NULLABLE_ACTKWD,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_ACTKWD
    )
    private String actkwd;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_ACTDESC)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACTDESC,
            nullable = COLUMN_NULLABLE_ACTDESC,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_ACTDESC
    )
    private String actdesc;
}
