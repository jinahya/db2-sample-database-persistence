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

import com.github.jinahya.db2.sample.database.persistence.ProductStringAttributeConverter;
import com.github.jinahya.db2.sample.database.persistence.xml.product.Product;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
 * A mapped superclass which holds the mappings of the {@value MappedProduct#TABLE_NAME} table, the
 * products, each with an XML description.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedProduct {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "PRODUCT";

    // ----------------------------------------------------------------------------------------- PID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PID} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PID = "PID";

    /**
     * Whether the {@value #COLUMN_NAME_PID} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PID = false;

    /**
     * The length of the {@value #COLUMN_NAME_PID} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PID = 10;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PID = "pid";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PID} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PID = COLUMN_LENGTH_PID;

    // ---------------------------------------------------------------------------------------- NAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_NAME} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_NAME = "NAME";

    /**
     * Whether the {@value #COLUMN_NAME_NAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_NAME = true;

    /**
     * The length of the {@value #COLUMN_NAME_NAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_NAME = 128;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_NAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_NAME = "name";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_NAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_NAME = COLUMN_LENGTH_NAME;

    // --------------------------------------------------------------------------------------- PRICE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PRICE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PRICE = "PRICE";

    /**
     * Whether the {@value #COLUMN_NAME_PRICE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PRICE = true;

    /**
     * The precision of the {@value #COLUMN_NAME_PRICE} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_PRICE = 30;

    /**
     * The scale of the {@value #COLUMN_NAME_PRICE} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_PRICE = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PRICE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PRICE = "price";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_PRICE} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_INTEGER_PRICE = COLUMN_PRECISION_PRICE - COLUMN_SCALE_PRICE;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_PRICE} attribute. The
     * value is {@value}.
     */
    public static final int DIGITS_FRACTION_PRICE = COLUMN_SCALE_PRICE;

    // ---------------------------------------------------------------------------------- PROMOPRICE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PROMOPRICE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PROMOPRICE = "PROMOPRICE";

    /**
     * Whether the {@value #COLUMN_NAME_PROMOPRICE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROMOPRICE = true;

    /**
     * The precision of the {@value #COLUMN_NAME_PROMOPRICE} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_PROMOPRICE = 30;

    /**
     * The scale of the {@value #COLUMN_NAME_PROMOPRICE} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_PROMOPRICE = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROMOPRICE} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROMOPRICE = "promoprice";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_PROMOPRICE} attribute.
     * The value is {@value}.
     */
    public static final int DIGITS_INTEGER_PROMOPRICE =
            COLUMN_PRECISION_PROMOPRICE - COLUMN_SCALE_PROMOPRICE;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_PROMOPRICE} attribute.
     * The value is {@value}.
     */
    public static final int DIGITS_FRACTION_PROMOPRICE = COLUMN_SCALE_PROMOPRICE;

    // ---------------------------------------------------------------------------------- PROMOSTART

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PROMOSTART} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PROMOSTART = "PROMOSTART";

    /**
     * Whether the {@value #COLUMN_NAME_PROMOSTART} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROMOSTART = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROMOSTART} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROMOSTART = "promostart";

    // ------------------------------------------------------------------------------------ PROMOEND

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PROMOEND} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PROMOEND = "PROMOEND";

    /**
     * Whether the {@value #COLUMN_NAME_PROMOEND} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROMOEND = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROMOEND} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROMOEND = "promoend";

    // --------------------------------------------------------------------------------- DESCRIPTION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DESCRIPTION} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_DESCRIPTION = "DESCRIPTION";

    /**
     * Whether the {@value #COLUMN_NAME_DESCRIPTION} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DESCRIPTION = true;

    /**
     * The length of the {@value #COLUMN_NAME_DESCRIPTION} column, for a schema a provider
     * generates. The value is {@value}.
     * <p>
     * Db2's {@code XML} has no length; without one, a generated schema makes the column a
     * {@code VARCHAR} of the provider's default length, too short for a document.
     */
    public static final int COLUMN_LENGTH_DESCRIPTION = 1048576;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DESCRIPTION} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_DESCRIPTION = "description";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedProduct() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "pid=" + pid +
               ",name=" + name +
               ",price=" + price +
               ",promoprice=" + promoprice +
               ",promostart=" + promostart +
               ",promoend=" + promoend +
               ",description=" + description +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PID} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedProduct that)) {
            return false;
        }
        return Objects.equals(getPid(), that.getPid());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getPid());
    }

    // ----------------------------------------------------------------------------------------- pid

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PID} attribute.
     */
    @Nonnull
    public String getPid() {
        return pid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PID} attribute with the specified value.
     *
     * @param pid new value for {@value #ATTRIBUTE_NAME_PID} attribute.
     */
    protected void setPid(@Nonnull final String pid) {
        this.pid = pid;
    }

    // ---------------------------------------------------------------------------------------- name

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_NAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_NAME} attribute.
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_NAME} attribute with the specified value.
     *
     * @param name new value for {@value #ATTRIBUTE_NAME_NAME} attribute.
     */
    public void setName(@Nullable final String name) {
        this.name = name;
    }

    // --------------------------------------------------------------------------------------- price

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PRICE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PRICE} attribute.
     */
    @Nullable
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PRICE} attribute with the specified value.
     *
     * @param price new value for {@value #ATTRIBUTE_NAME_PRICE} attribute.
     */
    public void setPrice(@Nullable final BigDecimal price) {
        this.price = price;
    }

    // ---------------------------------------------------------------------------------- promoprice

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROMOPRICE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROMOPRICE} attribute.
     */
    @Nullable
    public BigDecimal getPromoprice() {
        return promoprice;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROMOPRICE} attribute with the specified
     * value.
     *
     * @param promoprice new value for {@value #ATTRIBUTE_NAME_PROMOPRICE} attribute.
     */
    public void setPromoprice(@Nullable final BigDecimal promoprice) {
        this.promoprice = promoprice;
    }

    // ---------------------------------------------------------------------------------- promostart

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROMOSTART} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROMOSTART} attribute.
     */
    @Nullable
    public LocalDate getPromostart() {
        return promostart;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROMOSTART} attribute with the specified
     * value.
     *
     * @param promostart new value for {@value #ATTRIBUTE_NAME_PROMOSTART} attribute.
     */
    public void setPromostart(@Nullable final LocalDate promostart) {
        this.promostart = promostart;
    }

    // ------------------------------------------------------------------------------------ promoend

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROMOEND} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROMOEND} attribute.
     */
    @Nullable
    public LocalDate getPromoend() {
        return promoend;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROMOEND} attribute with the specified
     * value.
     *
     * @param promoend new value for {@value #ATTRIBUTE_NAME_PROMOEND} attribute.
     */
    public void setPromoend(@Nullable final LocalDate promoend) {
        this.promoend = promoend;
    }

    // --------------------------------------------------------------------------------- description

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DESCRIPTION} attribute; the column is an
     * XML, bound to {@link Product}.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DESCRIPTION} attribute.
     */
    @Nullable
    public Product getDescription() {
        return description;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DESCRIPTION} attribute with the specified
     * value.
     *
     * @param description new value for {@value #ATTRIBUTE_NAME_DESCRIPTION} attribute.
     */
    public void setDescription(@Nullable final Product description) {
        this.description = description;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PID)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PID,
            nullable = COLUMN_NULLABLE_PID,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PID
    )
    private String pid;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_NAME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_NAME,
            nullable = COLUMN_NULLABLE_NAME,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_NAME
    )
    private String name;

    // ---------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_PRICE, fraction = DIGITS_FRACTION_PRICE)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PRICE,
            nullable = COLUMN_NULLABLE_PRICE,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_PRICE,
            scale = COLUMN_SCALE_PRICE
    )
    private BigDecimal price;

    // ---------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_PROMOPRICE, fraction = DIGITS_FRACTION_PROMOPRICE)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROMOPRICE,
            nullable = COLUMN_NULLABLE_PROMOPRICE,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_PROMOPRICE,
            scale = COLUMN_SCALE_PROMOPRICE
    )
    private BigDecimal promoprice;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROMOSTART,
            nullable = COLUMN_NULLABLE_PROMOSTART,
            insertable = true,
            updatable = true
    )
    private LocalDate promostart;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROMOEND,
            nullable = COLUMN_NULLABLE_PROMOEND,
            insertable = true,
            updatable = true
    )
    private LocalDate promoend;

    // ---------------------------------------------------------------------------------------------
    @Convert(converter = ProductStringAttributeConverter.class)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DESCRIPTION,
            nullable = COLUMN_NULLABLE_DESCRIPTION,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_DESCRIPTION
    )
    private Product description;
}
