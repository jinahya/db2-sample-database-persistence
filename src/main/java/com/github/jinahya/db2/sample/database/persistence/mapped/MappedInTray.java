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
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

/**
 * A mapped superclass which holds the mappings of the {@value MappedInTray#TABLE_NAME} table, the
 * received notes.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key
 * by its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedInTray {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "IN_TRAY";

    // ------------------------------------------------------------------------------------ RECEIVED

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_RECEIVED} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_RECEIVED = "RECEIVED";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RECEIVED} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RECEIVED = "received";

    // -------------------------------------------------------------------------------------- SOURCE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SOURCE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_SOURCE = "SOURCE";

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

    // ------------------------------------------------------------------------------------- SUBJECT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SUBJECT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_SUBJECT = "SUBJECT";

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

    // ----------------------------------------------------------------------------------- NOTE_TEXT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_NOTE_TEXT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_NOTE_TEXT = "NOTE_TEXT";

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

    // --------------------------------------------------------------------------------- SELECT_LIST

    /**
     * The columns of {@value #TABLE_NAME}, in their order, as the select list of a native query
     * whose rows an extending class is built from. The value is {@value}.
     */
    public static final String SELECT_LIST =
            COLUMN_NAME_RECEIVED + ", "
            + COLUMN_NAME_SOURCE + ", "
            + COLUMN_NAME_SUBJECT + ", "
            + COLUMN_NAME_NOTE_TEXT;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedInTray() {
        super();
    }

    /**
     * Creates a new instance with the specified values, in the order of {@link #SELECT_LIST}.
     *
     * @param received a value for the {@value #ATTRIBUTE_NAME_RECEIVED} attribute.
     * @param source   a value for the {@value #ATTRIBUTE_NAME_SOURCE} attribute.
     * @param subject  a value for the {@value #ATTRIBUTE_NAME_SUBJECT} attribute.
     * @param noteText a value for the {@value #ATTRIBUTE_NAME_NOTE_TEXT} attribute.
     */
    protected MappedInTray(
            final LocalDateTime received,
            final String source,
            final String subject,
            final String noteText) {
        this();
        this.received = received;
        this.source = source;
        this.subject = subject;
        this.noteText = noteText;
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "received=" + received +
               ",source=" + source +
               ",subject=" + subject +
               ",noteText=" + noteText +
               '}';
    }

    // ------------------------------------------------------------------------------------ received

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

    // -------------------------------------------------------------------------------------- source

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

    // ------------------------------------------------------------------------------------- subject

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

    // ------------------------------------------------------------------------------------ noteText

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

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RECEIVED,
            nullable = true,
            insertable = true,
            updatable = false
    )
    private LocalDateTime received;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_SOURCE)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SOURCE,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_SOURCE
    )
    private String source;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_SUBJECT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SUBJECT,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_SUBJECT
    )
    private String subject;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_NOTE_TEXT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_NOTE_TEXT,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_NOTE_TEXT
    )
    private String noteText;
}
