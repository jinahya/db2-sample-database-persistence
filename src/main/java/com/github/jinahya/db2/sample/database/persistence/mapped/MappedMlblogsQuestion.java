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
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Optional;

/**
 * A mapped superclass which holds the mappings of the {@value MappedMlblogsQuestion#TABLE_NAME}
 * table, the questions of a vector search example.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key
 * by its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 * <p>
 * The {@value MappedMlblogsQuestion#COLUMN_NAME_EMBEDDING} column, a {@code VECTOR(1024, FLOAT32)},
 * maps to a {@code float[]} through {@link VectorStringAttributeConverter}, by the string form in
 * which Db2 hands a vector to an application.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedMlblogsQuestion {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "MLBLOGS_QUESTIONS";

    // ------------------------------------------------------------------------------------ QUESTION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_QUESTION} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_QUESTION = "QUESTION";

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

    // ----------------------------------------------------------------------------------- EMBEDDING

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMBEDDING} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_EMBEDDING = "EMBEDDING";

    /**
     * The dimension of the {@value #COLUMN_NAME_EMBEDDING} column, a {@code VECTOR(1024, FLOAT32)}.
     * The value is {@value}.
     */
    public static final int COLUMN_DIMENSION_EMBEDDING = 1024;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMBEDDING} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMBEDDING = "embedding";

    /**
     * The size of the {@value #ATTRIBUTE_NAME_EMBEDDING} attribute. The value is {@value}.
     */
    public static final int SIZE_EMBEDDING = COLUMN_DIMENSION_EMBEDDING;

    // --------------------------------------------------------------------------------- SELECT_LIST

    /**
     * The columns of {@value #TABLE_NAME}, in their order, as the select list of a native query
     * whose rows an extending class is built from. The value is {@value}.
     */
    public static final String SELECT_LIST =
            COLUMN_NAME_QUESTION + ", "
            + COLUMN_NAME_EMBEDDING;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedMlblogsQuestion() {
        super();
    }

    /**
     * Creates a new instance with the specified values, in the order of {@link #SELECT_LIST}.
     *
     * @param question  a value for the {@value #ATTRIBUTE_NAME_QUESTION} attribute.
     * @param embedding a value for the {@value #ATTRIBUTE_NAME_EMBEDDING} attribute.
     */
    protected MappedMlblogsQuestion(
            final String question,
            final float[] embedding) {
        this();
        this.question = question;
        this.embedding = Optional.ofNullable(embedding).map(float[]::clone).orElse(null);
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "question=" + question +
               '}';
    }

    // ------------------------------------------------------------------------------------ question

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

    // ----------------------------------------------------------------------------------- embedding

    /**
     * Returns a copy of current value of {@value #ATTRIBUTE_NAME_EMBEDDING} attribute.
     *
     * @return a copy of current value of {@value #ATTRIBUTE_NAME_EMBEDDING} attribute; {@code null}
     *         when it is {@code null}.
     * @implNote A copy is returned, and a copy is kept by {@link #setEmbedding(float[])},
     *         so that the value changes only through the setter; EclipseLink does not see a change
     *         made to the elements of a converted array.
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

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_QUESTION)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_QUESTION,
            nullable = true,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_QUESTION
    )
    private String question;

    // ---------------------------------------------------------------------------------------------
    @Size(min = SIZE_EMBEDDING, max = SIZE_EMBEDDING)
    @Convert(converter = VectorStringAttributeConverter.class)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMBEDDING,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_DIMENSION_EMBEDDING * 16 + 1 // just for H2
            )
    private float[] embedding;
}
