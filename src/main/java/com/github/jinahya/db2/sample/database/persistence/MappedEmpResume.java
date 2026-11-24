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

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedEmpResume#TABLE_NAME} table,
 * the resumes of the employees.
 * <p>
 * The primary key is composite, of {@value MappedEmpResume#COLUMN_NAME_EMPNO},
 * {@value MappedEmpResume#COLUMN_NAME_RESUME_FORMAT}, mapped with an
 * {@link jakarta.persistence.IdClass @IdClass}: an extending entity names a subclass of
 * {@link MappedEmpResumeId} with {@code @IdClass} and inherits the {@link Id @Id} attributes from
 * here.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedEmpResumeId
 */
@MappedSuperclass
public abstract class MappedEmpResume {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "EMP_RESUME";

    // ----------------------------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMPNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    /**
     * Whether the {@value #COLUMN_NAME_EMPNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMPNO = false;

    /**
     * The length of the {@value #COLUMN_NAME_EMPNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMPNO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = "empno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMPNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMPNO = COLUMN_LENGTH_EMPNO;

    // --------------------------------------------------------------------------------------------------- RESUME_FORMAT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_RESUME_FORMAT = "RESUME_FORMAT";

    /**
     * Whether the {@value #COLUMN_NAME_RESUME_FORMAT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESUME_FORMAT = false;

    /**
     * The length of the {@value #COLUMN_NAME_RESUME_FORMAT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESUME_FORMAT = 10;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESUME_FORMAT} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESUME_FORMAT = "resumeFormat";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESUME_FORMAT} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_RESUME_FORMAT = COLUMN_LENGTH_RESUME_FORMAT;

    // ---------------------------------------------------------------------------------------------------------- RESUME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_RESUME} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESUME = "RESUME";

    /**
     * Whether the {@value #COLUMN_NAME_RESUME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESUME = true;

    /**
     * The length of the {@value #COLUMN_NAME_RESUME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESUME = 5120;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESUME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESUME = "resume";

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedEmpResume() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "empno=" + empno +
               ",resumeFormat=" + resumeFormat +
               ",resume=" + (resume == null ? null : resume.length() + " char(s)") +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPNO} and
     *         {@value #ATTRIBUTE_NAME_RESUME_FORMAT} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedEmpResume that)) {
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

    // ----------------------------------------------------------------------------------------------------------- empno

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

    // ---------------------------------------------------------------------------------------------------- resumeFormat

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

    // ---------------------------------------------------------------------------------------------------------- resume

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESUME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESUME} attribute.
     */
    @Nullable
    public String getResume() {
        return resume;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESUME} attribute with the specified
     * value.
     *
     * @param resume new value for {@value #ATTRIBUTE_NAME_RESUME} attribute.
     */
    public void setResume(@Nullable final String resume) {
        this.resume = resume;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMPNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPNO,
            nullable = COLUMN_NULLABLE_EMPNO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESUME_FORMAT)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESUME_FORMAT,
            nullable = COLUMN_NULLABLE_RESUME_FORMAT,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_RESUME_FORMAT
    )
    private String resumeFormat;

    // -----------------------------------------------------------------------------------------------------------------
    @Lob
    @Basic(optional = true, fetch = FetchType.LAZY)
    @Column(name = COLUMN_NAME_RESUME,
            nullable = COLUMN_NULLABLE_RESUME,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_RESUME
    )
    private String resume;
}
