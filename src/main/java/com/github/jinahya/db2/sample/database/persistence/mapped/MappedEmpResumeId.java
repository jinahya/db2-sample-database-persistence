package com.github.jinahya.db2.sample.database.persistence.mapped;

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

import jakarta.annotation.Nonnull;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * A superclass for the identifier of the {@value MappedEmpResume#TABLE_NAME} table -- the key of
 * {@value MappedEmpResume#COLUMN_NAME_EMPNO}, {@value MappedEmpResume#COLUMN_NAME_RESUME_FORMAT}.
 * <p>
 * An entity extending {@link MappedEmpResume} names a concrete subclass of this class with
 * {@link jakarta.persistence.IdClass @IdClass}; the attributes here have the names and the types of
 * the {@link jakarta.persistence.Id @Id} attributes there.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedEmpResume
 */
public abstract class MappedEmpResumeId
        implements Serializable {

    /**
     * The serial version UID of this class. The value is {@value}.
     */
    private static final long serialVersionUID = 1L;

    // --------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the attribute which maps the {@value MappedEmpResume#COLUMN_NAME_EMPNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = MappedEmpResume.ATTRIBUTE_NAME_EMPNO;

    // ------------------------------------------------------------------------------- RESUME_FORMAT

    /**
     * The name of the attribute which maps the {@value MappedEmpResume#COLUMN_NAME_RESUME_FORMAT}
     * column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESUME_FORMAT =
            MappedEmpResume.ATTRIBUTE_NAME_RESUME_FORMAT;

    // ---------------------------------------------------------------------------------------------
    // STATIC_FACTORY_METHODS

    /**
     * Creates a new instance of a subclass, with the specified values.
     *
     * @param <T>          the type of the identifier.
     * @param instantiator a supplier of a new, empty instance of {@code T}.
     * @param empno        a value for the {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     * @param resumeFormat a value for the {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     * @return the instance supplied by {@code instantiator}, with its attributes set.
     * @throws NullPointerException if {@code instantiator} is {@code null}, or it supplies
     *                              {@code null}.
     */
    protected static <T extends MappedEmpResumeId> T of(
            final Supplier<? extends T> instantiator,
            final String empno,
            final String resumeFormat) {
        Objects.requireNonNull(instantiator, "instantiator is null");
        final var instance =
                Objects.requireNonNull(instantiator.get(), "instantiator.get() is null");
        instance.setEmpno(empno);
        instance.setResumeFormat(resumeFormat);
        return instance;
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedEmpResumeId() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "empno=" + empno +
               ",resumeFormat=" + resumeFormat +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPNO} and
     *         {@value #ATTRIBUTE_NAME_RESUME_FORMAT}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedEmpResumeId that)) {
            return false;
        }
        return Objects.equals(getEmpno(), that.getEmpno())
               && Objects.equals(getResumeFormat(), that.getResumeFormat());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_EMPNO} and
     *         {@value #ATTRIBUTE_NAME_RESUME_FORMAT}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getEmpno(), getResumeFormat());
    }

    // --------------------------------------------------------------------------------------- empno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    @Nonnull
    public String getEmpno() {
        return empno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute with the specified value.
     *
     * @param empno new value for {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    protected void setEmpno(@Nonnull final String empno) {
        this.empno = empno;
    }

    // -------------------------------------------------------------------------------- resumeFormat

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     */
    @Nonnull
    public String getResumeFormat() {
        return resumeFormat;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute with the specified
     * value.
     *
     * @param resumeFormat new value for {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     */
    protected void setResumeFormat(@Nonnull final String resumeFormat) {
        this.resumeFormat = resumeFormat;
    }

    // ---------------------------------------------------------------------------------------------
    private String empno;

    // ---------------------------------------------------------------------------------------------
    private String resumeFormat;
}
