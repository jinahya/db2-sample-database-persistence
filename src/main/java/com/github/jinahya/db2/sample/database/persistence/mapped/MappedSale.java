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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * A mapped superclass which holds the mappings of the {@value MappedSale#TABLE_NAME} table, the
 * sales.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key
 * by
 * its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedSale {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "SALES";

    // ---------------------------------------------------------------------------------- SALES_DATE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SALES_DATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_SALES_DATE = "SALES_DATE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SALES_DATE} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALES_DATE = "salesDate";

    // -------------------------------------------------------------------------------- SALES_PERSON

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_SALES_PERSON = "SALES_PERSON";

    /**
     * The length of the {@value #COLUMN_NAME_SALES_PERSON} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_SALES_PERSON = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SALES_PERSON} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALES_PERSON = "salesPerson";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_SALES_PERSON = COLUMN_LENGTH_SALES_PERSON;

    // -------------------------------------------------------------------------------------- REGION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_REGION} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_REGION = "REGION";

    /**
     * The length of the {@value #COLUMN_NAME_REGION} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_REGION = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_REGION} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_REGION = "region";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_REGION} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_REGION = COLUMN_LENGTH_REGION;

    // --------------------------------------------------------------------------------------- SALES

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SALES} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_SALES = "SALES";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SALES} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALES = "sales";

    /**
     * The minimum value of the {@value #ATTRIBUTE_NAME_SALES} attribute. The value is {@value}.
     *
     * @implNote "Number of sales", as the documentation of the {@code SAMPLE} database
     *         describes the column; the database does not enforce it.
     */
    public static final int ATTRIBUTE_MIN_SALES = 0;

    // --------------------------------------------------------------------------------- SELECT_LIST

    /**
     * The columns of {@value #TABLE_NAME}, in their order, as the select list of a native query
     * whose rows an extending class is built from. The value is {@value}.
     */
    public static final String SELECT_LIST =
            COLUMN_NAME_SALES_DATE + ", "
            + COLUMN_NAME_SALES_PERSON + ", "
            + COLUMN_NAME_REGION + ", "
            + COLUMN_NAME_SALES;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedSale() {
        super();
    }

    /**
     * Creates a new instance with the specified values, in the order of {@link #SELECT_LIST}.
     *
     * @param salesDate   a value for the {@value #ATTRIBUTE_NAME_SALES_DATE} attribute.
     * @param salesPerson a value for the {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute.
     * @param region      a value for the {@value #ATTRIBUTE_NAME_REGION} attribute.
     * @param sales       a value for the {@value #ATTRIBUTE_NAME_SALES} attribute.
     */
    protected MappedSale(
            final LocalDate salesDate,
            final String salesPerson,
            final String region,
            final Integer sales) {
        this();
        this.salesDate = salesDate;
        this.salesPerson = salesPerson;
        this.region = region;
        this.sales = sales;
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "salesDate=" + salesDate +
               ",salesPerson=" + salesPerson +
               ",region=" + region +
               ",sales=" + sales +
               '}';
    }

    // ----------------------------------------------------------------------------------- salesDate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SALES_DATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SALES_DATE} attribute.
     */
    @Nonnull
    public LocalDate getSalesDate() {
        return salesDate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SALES_DATE} attribute with the specified
     * value.
     *
     * @param salesDate new value for {@value #ATTRIBUTE_NAME_SALES_DATE} attribute.
     */
    protected void setSalesDate(@Nonnull final LocalDate salesDate) {
        this.salesDate = salesDate;
    }

    // --------------------------------------------------------------------------------- salesPerson

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute.
     */
    @Nonnull
    public String getSalesPerson() {
        return salesPerson;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute with the specified
     * value.
     *
     * @param salesPerson new value for {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute.
     */
    protected void setSalesPerson(@Nonnull final String salesPerson) {
        this.salesPerson = salesPerson;
    }

    // -------------------------------------------------------------------------------------- region

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_REGION} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_REGION} attribute.
     */
    @Nonnull
    public String getRegion() {
        return region;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_REGION} attribute with the specified
     * value.
     *
     * @param region new value for {@value #ATTRIBUTE_NAME_REGION} attribute.
     */
    protected void setRegion(@Nonnull final String region) {
        this.region = region;
    }

    // --------------------------------------------------------------------------------------- sales

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SALES} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SALES} attribute.
     */
    @Nullable
    public Integer getSales() {
        return sales;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SALES} attribute with the specified value.
     *
     * @param sales new value for {@value #ATTRIBUTE_NAME_SALES} attribute.
     */
    public void setSales(@Nullable final Integer sales) {
        this.sales = sales;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SALES_DATE,
            nullable = true,
            insertable = true,
            updatable = false
    )
    private LocalDate salesDate;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_SALES_PERSON)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SALES_PERSON,
            nullable = true,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_SALES_PERSON
    )
    private String salesPerson;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_REGION)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_REGION,
            nullable = true,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_REGION
    )
    private String region;

    // ---------------------------------------------------------------------------------------------
    @Min(ATTRIBUTE_MIN_SALES)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SALES,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer sales;
}
