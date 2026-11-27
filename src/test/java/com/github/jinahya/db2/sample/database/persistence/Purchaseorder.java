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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedPurchaseorder;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

import java.util.Optional;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Purchaseorder.TABLE_NAME)
public class Purchaseorder
        extends MappedPurchaseorder {

    // -------------------------------------------------------------------------------------- CUSTID

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_CUSTID} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_CUSTOMER = "customer";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Purchaseorder() {
        super();
    }

    // ------------------------------------------------------------------------------ custidCustomer

    /**
     * Returns the customer.
     *
     * @return the customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Replaces the customer with the specified value.
     *
     * @param customer new value for the customer.
     */
    public void setCustomer(final Customer customer) {
        this.customer = customer;
        setCustid(Optional.ofNullable(customer).map(Customer::getCid).orElse(null));
    }

    // ---------------------------------------------------------------------------------------------
    @Nullable
    @Valid
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = Purchaseorder.COLUMN_NAME_CUSTID,
                referencedColumnName = Customer.COLUMN_NAME_CID,
                nullable = true,
                insertable = true,
                updatable = true
    )
    private Customer customer;
}
