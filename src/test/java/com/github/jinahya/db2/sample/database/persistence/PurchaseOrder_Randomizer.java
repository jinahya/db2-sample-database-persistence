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

import com.github.jinahya.object.randomizer.PodamObjectRandomizer;

import java.util.List;

/**
 * Randomizes a new {@link PurchaseOrder}, its {@code XML} column included; left out are the
 * identifier, which the test sets, and the customer, a foreign key mapped read-only and the
 * association which owns it.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class PurchaseOrder_Randomizer
        extends PodamObjectRandomizer<PurchaseOrder> {

    PurchaseOrder_Randomizer() {
        super(PurchaseOrder.class, List.of(
                PurchaseOrder.ATTRIBUTE_NAME_POID,
                PurchaseOrder.ATTRIBUTE_NAME_CUSTID,
                "custidCustomer"
        ));
    }
}

