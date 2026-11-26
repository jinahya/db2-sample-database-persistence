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

import com.github.jinahya.db2.sample.database.persistence.VectorStringAttributeConverter;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Optional;

/**
 * A mapped superclass which holds the mappings of the {@value MappedMlblogsAnswer#TABLE_NAME}
 * table, the answers of a vector search example.
 * <p>
 * Some answers appear in more than one row, with the same embedding; the instances of an answer a
 * query returns are one and the same.
 * <p>
 * <strong>The table declares no primary key.</strong> The column
 * {@value MappedMlblogsAnswer#COLUMN_NAME_ANSWER}, not {@code null} in every row the sample
 * database is created with, is mapped as the identifier, which an entity needs; nothing in the
 * database keeps that so.
 * <p>
 * The {@value MappedMlblogsAnswer#COLUMN_NAME_EMBEDDING} column, a {@code VECTOR(1024, FLOAT32)}, maps to
 * a {@code float[]} through {@link VectorStringAttributeConverter}, by the string form in which
 * Db2 hands a vector to an application.
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
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ANSWER} attribute maps. The
     * value is {@value}.
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
     * The name of the attribute which maps the {@value #COLUMN_NAME_ANSWER} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ANSWER = "answer";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_ANSWER} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_ANSWER = COLUMN_LENGTH_ANSWER;

    // ------------------------------------------------------------------------------------------------------- EMBEDDING

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMBEDDING} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_EMBEDDING = "EMBEDDING";

    /**
     * Whether the {@value #COLUMN_NAME_EMBEDDING} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMBEDDING = true;

    /**
     * The dimension of the {@value #COLUMN_NAME_EMBEDDING} column, a {@code VECTOR(1024, FLOAT32)}.
     * The value is {@value}.
     */
    public static final int COLUMN_DIMENSION_EMBEDDING = 1024;

    /**
     * The length of the string form of the {@value #COLUMN_NAME_EMBEDDING} column, which a
     * generated schema gives the column; {@code VECTOR_SERIALIZE} makes it {@code d * 16 + 1}
     * for a {@code FLOAT32} vector of {@code d} dimensions. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMBEDDING = COLUMN_DIMENSION_EMBEDDING * 16 + 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMBEDDING} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMBEDDING = "embedding";

    /**
     * The size of the {@value #ATTRIBUTE_NAME_EMBEDDING} attribute. The value is {@value}.
     */
    public static final int SIZE_EMBEDDING = COLUMN_DIMENSION_EMBEDDING;

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
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_ANSWER}, consistent with
     *         {@link #equals(Object)}.
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
     * Replaces current value of {@value #ATTRIBUTE_NAME_ANSWER} attribute with the specified
     * value.
     *
     * @param answer new value for {@value #ATTRIBUTE_NAME_ANSWER} attribute.
     */
    protected void setAnswer(@Nonnull final String answer) {
        this.answer = answer;
    }

    // ------------------------------------------------------------------------------------------------------- embedding

    /**
     * Returns a copy of current value of {@value #ATTRIBUTE_NAME_EMBEDDING} attribute.
     *
     * @return a copy of current value of {@value #ATTRIBUTE_NAME_EMBEDDING} attribute; {@code null}
     *         when it is {@code null}.
     * @implNote A copy is returned, and a copy is kept by {@link #setEmbedding(float[])}, so that
     *         the value changes only through the setter; EclipseLink does not see a change made
     *         to the elements of a converted array.
     */
    @Nullable
    public float[] getEmbedding() {
        return Optional.ofNullable(embedding).map(float[]::clone).orElse(null);
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMBEDDING} attribute with a copy of the
     * specified value.
     *
     * @param embedding new value for {@value #ATTRIBUTE_NAME_EMBEDDING} attribute.
     */
    public void setEmbedding(@Nullable final float[] embedding) {
        this.embedding = Optional.ofNullable(embedding).map(float[]::clone).orElse(null);
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

    // -----------------------------------------------------------------------------------------------------------------
    @Size(min = SIZE_EMBEDDING, max = SIZE_EMBEDDING)
    @Convert(converter = VectorStringAttributeConverter.class)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMBEDDING,
            nullable = COLUMN_NULLABLE_EMBEDDING,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_EMBEDDING
    )
    private float[] embedding;
}
