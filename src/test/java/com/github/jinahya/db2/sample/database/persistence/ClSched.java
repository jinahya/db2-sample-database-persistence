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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedClSched;

/**
 * A row of the {@value #TABLE_NAME} table; not an entity, since it has no key, but a class built
 * from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class ClSched
        extends MappedClSched {

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public ClSched() {
        super();
    }

    /**
     * Creates a new instance from the specified row of a native query which selects
     * {@link #SELECT_LIST}, in its order.
     *
     * @param row the row; an array of 4 values.
     */
    public ClSched(final Object[] row) {
        super(
                __Row_Utils.string(row, 0),
                __Row_Utils.integer(row, 1),
                __Row_Utils.localTime(row, 2),
                __Row_Utils.localTime(row, 3)
        );
    }

    /**
     * {@inheritDoc}
     *
     * @param classCode {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever creates an instance sets it.
     */
    @Override
    public void setClassCode(final String classCode) {
        super.setClassCode(classCode);
    }
}
