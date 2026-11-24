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
 * A mapped superclass which holds the mappings of the {@value MappedMlblogsAnswer#TABLE_NAME} table, the answers of a
 * vector search example.
 * <p>
 * Some answers appear in more than one row, with the same embedding; the instances of an answer a query returns are one
 * and the same.
 * <p>
 * <strong>The table declares no primary key.</strong> The column {@value MappedMlblogsAnswer#COLUMN_NAME_ANSWER}, not
 * {@code null} in every row the sample database is created with, is mapped as the identifier, which an entity needs;
 * nothing in the database keeps that so.
 * <p>
 * The column {@code EMBEDDING}, a {@code VECTOR}, is not mapped; Jakarta Persistence has no mapping for it.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedMlblogsAnswer {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "MLBLOGS_ANSWERS";

    // ---------------------------------------------------------------------------------------------------------- ANSWER

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ANSWER} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_ANSWER = "ANSWER";

    /**
     * Whether the {@value #COLUMN_NAME_ANSWER} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ANSWER = true;

    /**
     * The length of the {@value #COLUMN_NAME_ANSWER} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_ANSWER = 1024;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ANSWER} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ANSWER = "answer";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_ANSWER} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_ANSWER = COLUMN_LENGTH_ANSWER;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedMlblogsAnswer() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "answer=" + answer +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_ANSWER} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedMlblogsAnswer that)) {
            return false;
        }
        return Objects.equals(getAnswer(), that.getAnswer());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_ANSWER}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getAnswer());
    }

    // ---------------------------------------------------------------------------------------------------------- answer

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ANSWER} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ANSWER} attribute.
     */
    @Nonnull
    public String getAnswer() {
        return answer;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ANSWER} attribute with the specified value.
     *
     * @param answer new value for {@value #ATTRIBUTE_NAME_ANSWER} attribute.
     */
    protected void setAnswer(@Nonnull final String answer) {
        this.answer = answer;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_ANSWER)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ANSWER,
            nullable = COLUMN_NULLABLE_ANSWER,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_ANSWER
    )
    private String answer;
}
