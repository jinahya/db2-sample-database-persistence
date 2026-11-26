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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedSale;

import java.time.LocalDate;

/**
 * A row of the {@value #TABLE_NAME} table; not an entity, since it has no key, but a class built
 * from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class Sale
        extends MappedSale {

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Sale() {
        super();
    }

    /**
     * Creates a new instance from the specified row of a native query which selects
     * {@link #SELECT_LIST}, in its order.
     *
     * @param row the row; an array of 4 values.
     */
    public Sale(final Object[] row) {
        super(
                __Row_Utils.localDate(row, 0),
                __Row_Utils.string(row, 1),
                __Row_Utils.string(row, 2),
                __Row_Utils.integer(row, 3)
        );
    }

    /**
     * {@inheritDoc}
     *
     * @param salesDate {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever creates an instance sets it.
     */
    @Override
    public void setSalesDate(final LocalDate salesDate) {
        super.setSalesDate(salesDate);
    }

    /**
     * {@inheritDoc}
     *
     * @param salesPerson {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever creates an instance sets it.
     */
    @Override
    public void setSalesPerson(final String salesPerson) {
        super.setSalesPerson(salesPerson);
    }

    /**
     * {@inheritDoc}
     *
     * @param region {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever creates an instance sets it.
     */
    @Override
    public void setRegion(final String region) {
        super.setRegion(region);
    }
}
