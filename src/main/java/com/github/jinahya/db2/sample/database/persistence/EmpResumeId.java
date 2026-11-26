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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedEmpResume;
import com.github.jinahya.db2.sample.database.persistence.mapped.MappedEmployee;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Optional;

/**
 * The identifier of the {@value MappedEmpResume#TABLE_NAME} table, the key of
 * {@value MappedEmpResume#COLUMN_NAME_EMPNO}, {@value MappedEmpResume#COLUMN_NAME_RESUME_FORMAT}.
 * <p>
 * It is an {@link Embeddable @Embeddable}, so that an entity extending {@link MappedEmpResume} may
 * name it either with {@link jakarta.persistence.IdClass @IdClass}, whose attributes have the names
 * and the types of the {@link jakarta.persistence.Id @Id} attributes there, or as the type of an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId}, which the column mappings here serve.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedEmpResume
 */
@Embeddable
public class EmpResumeId {

    // --------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the attribute which maps the {@value MappedEmpResume#COLUMN_NAME_EMPNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = "empno";

    // ------------------------------------------------------------------------------- RESUME_FORMAT

    /**
     * The name of the attribute which maps the {@value MappedEmpResume#COLUMN_NAME_RESUME_FORMAT}
     * column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESUME_FORMAT = "resumeFormat";

    // ---------------------------------------------------------------------- STATIC_FACTORY_METHODS

    /**
     * Returns a new instance with the specified values.
     *
     * @param empno        a value for the {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     * @param resumeFormat a value for the {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     * @return a new instance with the specified values.
     */
    public static EmpResumeId of(final String empno, final String resumeFormat) {
        final var instance = new EmpResumeId();
        instance.setEmpno(empno);
        instance.setResumeFormat(resumeFormat);
        return instance;
    }

    /**
     * Returns a new instance with the employee number of the specified employee, and the specified
     * resume format.
     *
     * @param employee     the employee whose employee number is the {@value #ATTRIBUTE_NAME_EMPNO}
     *                     attribute; {@code null} for none.
     * @param resumeFormat a value for the {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     * @return a new instance with the employee number of {@code employee} and
     *         {@code resumeFormat}.
     */
    public static EmpResumeId from(final MappedEmployee employee, final String resumeFormat) {
        return of(Optional.ofNullable(employee).map(MappedEmployee::getEmpno).orElse(null),
                  resumeFormat);
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public EmpResumeId() {
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
        if (!(obj instanceof EmpResumeId that)) {
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
    public String getEmpno() {
        return empno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute with the specified value.
     *
     * @param empno new value for {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    protected void setEmpno(final String empno) {
        this.empno = empno;
    }

    // -------------------------------------------------------------------------------- resumeFormat

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     */
    public String getResumeFormat() {
        return resumeFormat;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute with the specified
     * value.
     *
     * @param resumeFormat new value for {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     */
    protected void setResumeFormat(final String resumeFormat) {
        this.resumeFormat = resumeFormat;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    @Size(max = MappedEmpResume.SIZE_MAX_EMPNO)
    @NotNull
    @Column(name = MappedEmpResume.COLUMN_NAME_EMPNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedEmpResume.COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute.
     */
    @Size(max = MappedEmpResume.SIZE_MAX_RESUME_FORMAT)
    @NotNull
    @Column(name = MappedEmpResume.COLUMN_NAME_RESUME_FORMAT,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedEmpResume.COLUMN_LENGTH_RESUME_FORMAT
    )
    private String resumeFormat;
}
