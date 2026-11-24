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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedSale#TABLE_NAME} table, the
 * sales.
 * <p>
 * <strong>The table declares no primary key.</strong> The columns
 * {@value MappedSale#COLUMN_NAME_SALES_DATE}, {@value
 * MappedSale#COLUMN_NAME_SALES_PERSON}, {@value MappedSale#COLUMN_NAME_REGION}, unique and not
 * {@code null} in every row the sample database is created with, are mapped as the identifier,
 * which an entity needs; nothing in the database keeps that so.
 * <p>
 * The identifier is mapped with an {@link jakarta.persistence.IdClass @IdClass}: an extending
 * entity names a subclass of {@link MappedSaleId} with {@code @IdClass} and inherits the
 * {@link Id @Id} attributes from here.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedSaleId
 */
@MappedSuperclass
public abstract class MappedSale {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "SALES";

    // ------------------------------------------------------------------------------------------------------ SALES_DATE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SALES_DATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_SALES_DATE = "SALES_DATE";

    /**
     * Whether the {@value #COLUMN_NAME_SALES_DATE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SALES_DATE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SALES_DATE} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALES_DATE = "salesDate";

    // ---------------------------------------------------------------------------------------------------- SALES_PERSON

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_SALES_PERSON = "SALES_PERSON";

    /**
     * Whether the {@value #COLUMN_NAME_SALES_PERSON} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SALES_PERSON = true;

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

    // ---------------------------------------------------------------------------------------------------------- REGION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_REGION} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_REGION = "REGION";

    /**
     * Whether the {@value #COLUMN_NAME_REGION} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_REGION = true;

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

    // ----------------------------------------------------------------------------------------------------------- SALES

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SALES} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_SALES = "SALES";

    /**
     * Whether the {@value #COLUMN_NAME_SALES} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SALES = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SALES} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALES = "sales";

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedSale() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "salesDate=" + salesDate +
               ",salesPerson=" + salesPerson +
               ",region=" + region +
               ",sales=" + sales +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_SALES_DATE} and
     *         {@value #ATTRIBUTE_NAME_SALES_PERSON} and {@value #ATTRIBUTE_NAME_REGION} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedSale that)) {
            return false;
        }
        return Objects.equals(getSalesDate(), that.getSalesDate())
               && Objects.equals(getSalesPerson(), that.getSalesPerson())
               && Objects.equals(getRegion(), that.getRegion());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_SALES_DATE} and
     *         {@value #ATTRIBUTE_NAME_SALES_PERSON} and {@value #ATTRIBUTE_NAME_REGION}, consistent
     *         with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getSalesDate(), getSalesPerson(), getRegion());
    }

    // ------------------------------------------------------------------------------------------------------- salesDate

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

    // ----------------------------------------------------------------------------------------------------- salesPerson

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

    // ---------------------------------------------------------------------------------------------------------- region

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

    // ----------------------------------------------------------------------------------------------------------- sales

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

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SALES_DATE,
            nullable = COLUMN_NULLABLE_SALES_DATE,
            insertable = true,
            updatable = false
    )
    private LocalDate salesDate;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_SALES_PERSON)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SALES_PERSON,
            nullable = COLUMN_NULLABLE_SALES_PERSON,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_SALES_PERSON
    )
    private String salesPerson;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_REGION)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_REGION,
            nullable = COLUMN_NULLABLE_REGION,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_REGION
    )
    private String region;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SALES,
            nullable = COLUMN_NULLABLE_SALES,
            insertable = true,
            updatable = true
    )
    private Integer sales;
}
