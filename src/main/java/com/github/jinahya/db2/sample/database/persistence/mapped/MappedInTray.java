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
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedInTray#TABLE_NAME} table, the
 * received notes.
 * <p>
 * <strong>The table declares no primary key.</strong> The column
 * {@value MappedInTray#COLUMN_NAME_RECEIVED}, unique and not {@code null} in every row the sample
 * database is created with, is mapped as the identifier, which an entity needs; nothing in the
 * database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedInTray {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "IN_TRAY";

    // -------------------------------------------------------------------------------------------------------- RECEIVED

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_RECEIVED} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_RECEIVED = "RECEIVED";

    /**
     * Whether the {@value #COLUMN_NAME_RECEIVED} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RECEIVED = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RECEIVED} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RECEIVED = "received";

    // ---------------------------------------------------------------------------------------------------------- SOURCE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SOURCE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_SOURCE = "SOURCE";

    /**
     * Whether the {@value #COLUMN_NAME_SOURCE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SOURCE = true;

    /**
     * The length of the {@value #COLUMN_NAME_SOURCE} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_SOURCE = 8;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SOURCE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SOURCE = "source";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_SOURCE} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_SOURCE = COLUMN_LENGTH_SOURCE;

    // --------------------------------------------------------------------------------------------------------- SUBJECT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SUBJECT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_SUBJECT = "SUBJECT";

    /**
     * Whether the {@value #COLUMN_NAME_SUBJECT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SUBJECT = true;

    /**
     * The length of the {@value #COLUMN_NAME_SUBJECT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_SUBJECT = 64;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SUBJECT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SUBJECT = "subject";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_SUBJECT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_SUBJECT = COLUMN_LENGTH_SUBJECT;

    // ------------------------------------------------------------------------------------------------------- NOTE_TEXT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_NOTE_TEXT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_NOTE_TEXT = "NOTE_TEXT";

    /**
     * Whether the {@value #COLUMN_NAME_NOTE_TEXT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_NOTE_TEXT = true;

    /**
     * The length of the {@value #COLUMN_NAME_NOTE_TEXT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_NOTE_TEXT = 3000;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_NOTE_TEXT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_NOTE_TEXT = "noteText";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_NOTE_TEXT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_NOTE_TEXT = COLUMN_LENGTH_NOTE_TEXT;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedInTray() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "received=" + received +
               ",source=" + source +
               ",subject=" + subject +
               ",noteText=" + noteText +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_RECEIVED} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedInTray that)) {
            return false;
        }
        return Objects.equals(getReceived(), that.getReceived());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_RECEIVED}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getReceived());
    }

    // -------------------------------------------------------------------------------------------------------- received

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RECEIVED} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RECEIVED} attribute.
     */
    @Nonnull
    public LocalDateTime getReceived() {
        return received;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RECEIVED} attribute with the specified
     * value.
     *
     * @param received new value for {@value #ATTRIBUTE_NAME_RECEIVED} attribute.
     */
    protected void setReceived(@Nonnull final LocalDateTime received) {
        this.received = received;
    }

    // ---------------------------------------------------------------------------------------------------------- source

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SOURCE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SOURCE} attribute.
     */
    @Nullable
    public String getSource() {
        return source;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SOURCE} attribute with the specified
     * value.
     *
     * @param source new value for {@value #ATTRIBUTE_NAME_SOURCE} attribute.
     */
    public void setSource(@Nullable final String source) {
        this.source = source;
    }

    // --------------------------------------------------------------------------------------------------------- subject

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SUBJECT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SUBJECT} attribute.
     */
    @Nullable
    public String getSubject() {
        return subject;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SUBJECT} attribute with the specified
     * value.
     *
     * @param subject new value for {@value #ATTRIBUTE_NAME_SUBJECT} attribute.
     */
    public void setSubject(@Nullable final String subject) {
        this.subject = subject;
    }

    // -------------------------------------------------------------------------------------------------------- noteText

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_NOTE_TEXT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_NOTE_TEXT} attribute.
     */
    @Nullable
    public String getNoteText() {
        return noteText;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_NOTE_TEXT} attribute with the specified
     * value.
     *
     * @param noteText new value for {@value #ATTRIBUTE_NAME_NOTE_TEXT} attribute.
     */
    public void setNoteText(@Nullable final String noteText) {
        this.noteText = noteText;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RECEIVED,
            nullable = COLUMN_NULLABLE_RECEIVED,
            insertable = true,
            updatable = false
    )
    private LocalDateTime received;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_SOURCE)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SOURCE,
            nullable = COLUMN_NULLABLE_SOURCE,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_SOURCE
    )
    private String source;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_SUBJECT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SUBJECT,
            nullable = COLUMN_NULLABLE_SUBJECT,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_SUBJECT
    )
    private String subject;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_NOTE_TEXT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_NOTE_TEXT,
            nullable = COLUMN_NULLABLE_NOTE_TEXT,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_NOTE_TEXT
    )
    private String noteText;
}
