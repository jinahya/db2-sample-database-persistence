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
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedMlblogsQuestion#TABLE_NAME}
 * table, the questions of a vector search example.
 * <p>
 * <strong>The table declares no primary key.</strong> The column
 * {@value MappedMlblogsQuestion#COLUMN_NAME_QUESTION}, not {@code null} in every row the sample
 * database is created with, is mapped as the identifier, which an entity needs; nothing in the
 * database keeps that so.
 * <p>
 * The column {@code EMBEDDING}, a {@code VECTOR}, is not mapped; Jakarta Persistence has no mapping
 * for it.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedMlblogsQuestion {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "MLBLOGS_QUESTIONS";

    // -------------------------------------------------------------------------------------------------------- QUESTION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_QUESTION} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_QUESTION = "QUESTION";

    /**
     * Whether the {@value #COLUMN_NAME_QUESTION} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_QUESTION = true;

    /**
     * The length of the {@value #COLUMN_NAME_QUESTION} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_QUESTION = 1024;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_QUESTION} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_QUESTION = "question";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_QUESTION} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_QUESTION = COLUMN_LENGTH_QUESTION;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedMlblogsQuestion() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "question=" + question +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_QUESTION} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedMlblogsQuestion that)) {
            return false;
        }
        return Objects.equals(getQuestion(), that.getQuestion());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_QUESTION}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getQuestion());
    }

    // -------------------------------------------------------------------------------------------------------- question

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_QUESTION} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_QUESTION} attribute.
     */
    @Nonnull
    public String getQuestion() {
        return question;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_QUESTION} attribute with the specified
     * value.
     *
     * @param question new value for {@value #ATTRIBUTE_NAME_QUESTION} attribute.
     */
    protected void setQuestion(@Nonnull final String question) {
        this.question = question;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_QUESTION)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_QUESTION,
            nullable = COLUMN_NULLABLE_QUESTION,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_QUESTION
    )
    private String question;
}
