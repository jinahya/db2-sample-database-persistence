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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedVpstrde1Id;

/**
 * The identifier class of {@link Vpstrde1}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class Vpstrde1Id
        extends MappedVpstrde1Id {

    private static final long serialVersionUID = 1L;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Vpstrde1Id() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * @param proj1no {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setProj1no(final String proj1no) {
        super.setProj1no(proj1no);
    }

    /**
     * {@inheritDoc}
     *
     * @param proj2no {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setProj2no(final String proj2no) {
        super.setProj2no(proj2no);
    }
}
