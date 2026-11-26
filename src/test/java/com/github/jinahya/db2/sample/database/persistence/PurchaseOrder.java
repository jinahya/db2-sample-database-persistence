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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedPurchaseOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * An entity of the {@value #TABLE_NAME} table.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = PurchaseOrder.TABLE_NAME)
public class PurchaseOrder
        extends MappedPurchaseOrder {

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public PurchaseOrder() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * @param poid {@inheritDoc}
     * @implNote Widened to {@code public}: the identifier is assigned, not generated, so
     *         whoever creates an instance sets it.
     */
    @Override
    public void setPoid(final Long poid) {
        super.setPoid(poid);
    }

    // ------------------------------------------------------------------------------ custidCustomer

    /**
     * Returns the customer.
     *
     * @return the customer.
     */
    public Customer getCustidCustomer() {
        return custidCustomer;
    }

    /**
     * Replaces the customer with the specified value.
     *
     * @param custidCustomer new value for the customer.
     */
    public void setCustidCustomer(final Customer custidCustomer) {
        this.custidCustomer = custidCustomer;
    }

    // ---------------------------------------------------------------------------------------------
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = PurchaseOrder.COLUMN_NAME_CUSTID,
                referencedColumnName = Customer.COLUMN_NAME_CID)
    private Customer custidCustomer;
}
