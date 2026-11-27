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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedProductsupplier;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Optional;

/**
 * An entity of the {@value #TABLE_NAME} table, which declares the identifier
 * {@link MappedProductsupplier} leaves out, an {@link EmbeddedId @EmbeddedId} of
 * {@link ProductsupplierId}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Productsupplier.TABLE_NAME)
public class Productsupplier
        extends MappedProductsupplier {

    /**
     * The name of the attribute of the identifier, an {@link EmbeddedId @EmbeddedId} of
     * {@link ProductsupplierId}. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ID = "id";

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_PID} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_PID =
            ATTRIBUTE_NAME_ID + "." + ProductsupplierId.ATTRIBUTE_NAME_PID;

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_SID} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_SID =
            ATTRIBUTE_NAME_ID + "." + ProductsupplierId.ATTRIBUTE_NAME_SID;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Productsupplier() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "id=" + id +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_ID}, the identifier.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Productsupplier that)) {
            return false;
        }
        return Objects.equals(getId(), that.getId());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_ID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }
    // ------------------------------------------------------------------------------------------ id

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     */
    public ProductsupplierId getId() {
        return id;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ID} attribute with the specified value.
     *
     * @param id new value for {@value #ATTRIBUTE_NAME_ID} attribute.
     */
    protected void setId(final ProductsupplierId id) {
        this.id = id;
    }

    // ------------------------------------------------------------------------------------- product

    /**
     * Returns the product.
     *
     * @return the product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Replaces the product with the specified value.
     *
     * @param product new value for the product.
     * @implNote The association maps the product id of the identifier
     *         ({@link jakarta.persistence.MapsId @MapsId}), which the provider sets from it when
     *         this instance is persisted; this sets it as well, so that the identifier is complete
     *         before then.
     */
    public void setProduct(final Product product) {
        this.product = product;
        id = Optional.ofNullable(id)
                .map(v -> v.withProduct(this.product))
                .orElseGet(() -> ProductsupplierId.from(this.product, this.supplier));
    }

    // ------------------------------------------------------------------------------------ supplier

    /**
     * Returns the supplier.
     *
     * @return the supplier.
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Replaces the supplier with the specified value.
     *
     * @param supplier new value for the supplier.
     * @implNote The association maps the supplier id of the identifier
     *         ({@link jakarta.persistence.MapsId @MapsId}), which the provider sets from it when
     *         this instance is persisted; this sets it as well, so that the identifier is complete
     *         before then.
     */
    public void setSupplier(final Supplier supplier) {
        this.supplier = supplier;
        id = Optional.ofNullable(id)
                .map(v -> v.withSupplier(this.supplier))
                .orElseGet(() -> ProductsupplierId.from(this.product, this.supplier));
    }

    // ---------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    @EmbeddedId
    private ProductsupplierId id;

    // ---------------------------------------------------------------------------------------------
    // the table declares no foreign key; PID names a product, as the table's name and the column
    // say, and every installed row's does. Maps the product id of the identifier, which the
    // provider derives from it
    @Valid
    @NotNull
    @MapsId(ProductsupplierId.ATTRIBUTE_NAME_PID)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Productsupplier.COLUMN_NAME_PID,
                referencedColumnName = Product.COLUMN_NAME_PID,
                nullable = false,
                insertable = true,
                updatable = false
    )
    private Product product;

    // ---------------------------------------------------------------------------------------------
    // the table declares no foreign key; SID names a supplier, as the table's name and the column
    // say, and every installed row's does. Maps the supplier id of the identifier, which the
    // provider derives from it
    @Valid
    @NotNull
    @MapsId(ProductsupplierId.ATTRIBUTE_NAME_SID)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Productsupplier.COLUMN_NAME_SID,
                referencedColumnName = Supplier.COLUMN_NAME_SID,
                nullable = false,
                insertable = true,
                updatable = false
    )
    private Supplier supplier;
}
