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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedSaleId;
import java.time.LocalDate;

/**
 * The identifier class of {@link Sale}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class SaleId
        extends MappedSaleId {

    private static final long serialVersionUID = 1L;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public SaleId() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * @param salesDate {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setSalesDate(final LocalDate salesDate) {
        super.setSalesDate(salesDate);
    }

    /**
     * {@inheritDoc}
     *
     * @param salesPerson {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setSalesPerson(final String salesPerson) {
        super.setSalesPerson(salesPerson);
    }

    /**
     * {@inheritDoc}
     *
     * @param region {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setRegion(final String region) {
        super.setRegion(region);
    }
}
