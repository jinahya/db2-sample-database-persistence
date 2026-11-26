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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedVempprojactId;
import java.time.LocalDate;

/**
 * The identifier class of {@link Vempprojact}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class VempprojactId
        extends MappedVempprojactId {

    private static final long serialVersionUID = 1L;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public VempprojactId() {
        super();
    }

    /**
     * {@inheritDoc}
     *
     * @param empno {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setEmpno(final String empno) {
        super.setEmpno(empno);
    }

    /**
     * {@inheritDoc}
     *
     * @param projno {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setProjno(final String projno) {
        super.setProjno(projno);
    }

    /**
     * {@inheritDoc}
     *
     * @param actno {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setActno(final Short actno) {
        super.setActno(actno);
    }

    /**
     * {@inheritDoc}
     *
     * @param emstdate {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setEmstdate(final LocalDate emstdate) {
        super.setEmstdate(emstdate);
    }
}
