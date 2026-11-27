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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedProduct;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Product.TABLE_NAME)
public class Product
        extends MappedProduct {

    // ---------------------------------------------------------------------------- PRODUCTSUPPLIERS

    /**
     * The name of the attribute which maps the suppliers of this product. The value is {@value}.
     *
     * @see Productsupplier#ATTRIBUTE_NAME_PRODUCT
     */
    public static final String ATTRIBUTE_NAME_PRODUCTSUPPLIERS = "productsuppliers";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Product() {
        super();
    }

    // ---------------------------------------------------------------------------- productsuppliers

    /**
     * Returns the suppliers of this product.
     *
     * @return the suppliers of this product.
     */
    public List<Productsupplier> getProductsuppliers() {
        return productsuppliers;
    }

    /**
     * Replaces the suppliers of this product with the specified value.
     *
     * @param productsuppliers new value for the suppliers of this product.
     */
    public void setProductsuppliers(final List<Productsupplier> productsuppliers) {
        this.productsuppliers = productsuppliers;
    }

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Productsupplier.ATTRIBUTE_NAME_PRODUCT,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Productsupplier> productsuppliers;
}
