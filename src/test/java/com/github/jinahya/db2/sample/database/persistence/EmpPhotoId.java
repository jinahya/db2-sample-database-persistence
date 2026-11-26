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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedEmpPhotoId;

/**
 * The identifier class of {@link EmpPhoto}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public class EmpPhotoId
        extends MappedEmpPhotoId {

    private static final long serialVersionUID = 1L;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public EmpPhotoId() {
        super();
    }

    /**
     * Returns a new instance of the specified values.
     *
     * @param empno       a value for the {@code empno} attribute.
     * @param photoFormat a value for the {@code photoFormat} attribute.
     * @return a new instance of {@code empno} and {@code photoFormat}.
     */
    public static EmpPhotoId of(final String empno, final String photoFormat) {
        return MappedEmpPhotoId.of(EmpPhotoId::new, empno, photoFormat);
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
     * @param photoFormat {@inheritDoc}
     * @implNote Widened to {@code public}, so that whoever needs an identifier builds one.
     */
    @Override
    public void setPhotoFormat(final String photoFormat) {
        super.setPhotoFormat(photoFormat);
    }
}
