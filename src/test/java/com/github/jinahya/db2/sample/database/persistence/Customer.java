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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedCustomer;
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
@Table(name = Customer.TABLE_NAME)
public class Customer
        extends MappedCustomer {

    // ------------------------------------------------------------------------------ PURCHASEORDERS

    /**
     * The name of the attribute which maps the purchase orders of this customer. The value is
     * {@value}.
     *
     * @see Purchaseorder#ATTRIBUTE_NAME_CUSTOMER
     */
    public static final String ATTRIBUTE_NAME_PURCHASEORDERS = "purchaseorders";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Customer() {
        super();
    }

    // ------------------------------------------------------------------------------ purchaseorders

    /**
     * Returns the purchase orders of this customer.
     *
     * @return the purchase orders of this customer.
     */
    public List<Purchaseorder> getPurchaseorders() {
        return purchaseorders;
    }

    /**
     * Replaces the purchase orders of this customer with the specified value.
     *
     * @param purchaseorders new value for the purchase orders of this customer.
     */
    public void setPurchaseorders(final List<Purchaseorder> purchaseorders) {
        this.purchaseorders = purchaseorders;
    }

    // ---------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = Purchaseorder.ATTRIBUTE_NAME_CUSTOMER,
               fetch = FetchType.LAZY,
               cascade = {
               },
               orphanRemoval = false
    )
    private List<@Valid @NotNull Purchaseorder> purchaseorders;
}
