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

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * A superclass for the identifier of the {@value MappedSale#TABLE_NAME} table -- the logical, not declared, key of
 * {@value MappedSale#COLUMN_NAME_SALES_DATE}, {@value MappedSale#COLUMN_NAME_SALES_PERSON}, {@value
 * MappedSale#COLUMN_NAME_REGION}.
 * <p>
 * An entity extending {@link MappedSale} names a concrete subclass of this class with {@link
 * jakarta.persistence.IdClass @IdClass}; the attributes here have the names and the types of the {@link
 * jakarta.persistence.Id @Id} attributes there.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedSale
 */
public abstract class MappedSaleId implements Serializable {

    /**
     * The serial version UID of this class. The value is {@value}.
     */
    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------------------------------------------ SALES_DATE

    /**
     * The name of the attribute which maps the {@value MappedSale#COLUMN_NAME_SALES_DATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALES_DATE = MappedSale.ATTRIBUTE_NAME_SALES_DATE;

    // ---------------------------------------------------------------------------------------------------- SALES_PERSON

    /**
     * The name of the attribute which maps the {@value MappedSale#COLUMN_NAME_SALES_PERSON} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALES_PERSON = MappedSale.ATTRIBUTE_NAME_SALES_PERSON;

    // ---------------------------------------------------------------------------------------------------------- REGION

    /**
     * The name of the attribute which maps the {@value MappedSale#COLUMN_NAME_REGION} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_REGION = MappedSale.ATTRIBUTE_NAME_REGION;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    /**
     * Creates a new instance of a subclass, with the specified values.
     *
     * @param <T> the type of the identifier.
     * @param instantiator a supplier of a new, empty instance of {@code T}.
     * @param salesDate a value for the {@value #ATTRIBUTE_NAME_SALES_DATE} attribute.
     * @param salesPerson a value for the {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute.
     * @param region a value for the {@value #ATTRIBUTE_NAME_REGION} attribute.
     * @return the instance supplied by {@code instantiator}, with its attributes set.
     * @throws NullPointerException if {@code instantiator} is {@code null}, or it supplies {@code null}.
     */
    protected static <T extends MappedSaleId> T of(
            final Supplier<? extends T> instantiator,
            final LocalDate salesDate,
            final String salesPerson,
            final String region) {
        Objects.requireNonNull(instantiator, "instantiator is null");
        final var instance = Objects.requireNonNull(instantiator.get(), "instantiator.get() is null");
        instance.setSalesDate(salesDate);
        instance.setSalesPerson(salesPerson);
        instance.setRegion(region);
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedSaleId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "salesDate=" + salesDate +
               ",salesPerson=" + salesPerson +
               ",region=" + region +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_SALES_DATE} and {@value #ATTRIBUTE_NAME_SALES_PERSON} and
     * {@value #ATTRIBUTE_NAME_REGION}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedSaleId that)) {
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
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_SALES_DATE} and {@value #ATTRIBUTE_NAME_SALES_PERSON} and
     * {@value #ATTRIBUTE_NAME_REGION}, consistent with {@link #equals(Object)}.
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
     * Replaces current value of {@value #ATTRIBUTE_NAME_SALES_DATE} attribute with the specified value.
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
     * Replaces current value of {@value #ATTRIBUTE_NAME_SALES_PERSON} attribute with the specified value.
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
     * Replaces current value of {@value #ATTRIBUTE_NAME_REGION} attribute with the specified value.
     *
     * @param region new value for {@value #ATTRIBUTE_NAME_REGION} attribute.
     */
    protected void setRegion(@Nonnull final String region) {
        this.region = region;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private LocalDate salesDate;

    // -----------------------------------------------------------------------------------------------------------------
    private String salesPerson;

    // -----------------------------------------------------------------------------------------------------------------
    private String region;
}
