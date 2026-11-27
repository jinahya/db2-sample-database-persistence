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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedInventory;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Inventory.TABLE_NAME)
public class Inventory
        extends MappedInventory {

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Inventory() {
        super();
    }

    // ------------------------------------------------------------------------------------- product

    /**
     * Returns the product of this inventory.
     *
     * @return the product of this inventory.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Replaces the product of this inventory with the specified value, and the
     * {@value #ATTRIBUTE_NAME_PID} attribute with its product id.
     *
     * @param product new value for the product.
     * @implNote The association is read-only over the column of the identifier, which the
     *         {@value #ATTRIBUTE_NAME_PID} attribute writes; this keeps the two in step.
     */
    public void setProduct(final Product product) {
        this.product = product;
        setPid(Optional.ofNullable(product).map(Product::getPid).orElse(null));
    }

    // ---------------------------------------------------------------------------------------------
    // the table declares no foreign key; PID names a product, as the column says, and every
    // installed row's does. Read-only: the identifier's column is written by the pid attribute
    @Valid
    @NotNull
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Inventory.COLUMN_NAME_PID,
                referencedColumnName = Product.COLUMN_NAME_PID,
                nullable = false,
                insertable = false,
                updatable = false
    )
    private Product product;

}
