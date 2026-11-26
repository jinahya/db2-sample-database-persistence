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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedVastrde2Id;

/**
 * The identifier class of {@link Vastrde2}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class Vastrde2Id
        extends MappedVastrde2Id {

    private static final long serialVersionUID = 1L;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Vastrde2Id() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * @param dept1no {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setDept1no(final String dept1no) {
        super.setDept1no(dept1no);
    }

    /**
     * {@inheritDoc}
     *
     * @param emp2no {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setEmp2no(final String emp2no) {
        super.setEmp2no(emp2no);
    }
}
