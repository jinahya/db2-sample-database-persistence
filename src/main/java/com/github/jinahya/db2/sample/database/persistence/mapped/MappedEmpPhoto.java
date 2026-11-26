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
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedEmpPhoto#TABLE_NAME} table, the
 * photos of the employees.
 * <p>
 * The primary key is composite, of {@value MappedEmpPhoto#COLUMN_NAME_EMPNO},
 * {@value MappedEmpPhoto#COLUMN_NAME_PHOTO_FORMAT}, mapped with an
 * {@link jakarta.persistence.IdClass @IdClass}: an extending entity names a subclass of
 * {@link MappedEmpPhotoId} with {@code @IdClass} and inherits the {@link Id @Id} attributes from
 * here.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedEmpPhotoId
 */
@MappedSuperclass
public abstract class MappedEmpPhoto {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "EMP_PHOTO";

    // --------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMPNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

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

    // -------------------------------------------------------------------------------- PHOTO_FORMAT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_PHOTO_FORMAT = "PHOTO_FORMAT";

    /**
     * The length of the {@value #COLUMN_NAME_PHOTO_FORMAT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PHOTO_FORMAT = 10;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PHOTO_FORMAT} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PHOTO_FORMAT = "photoFormat";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_PHOTO_FORMAT = COLUMN_LENGTH_PHOTO_FORMAT;

    // ------------------------------------------------------------------------------------- PICTURE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PICTURE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PICTURE = "PICTURE";

    /**
     * The length of the {@value #COLUMN_NAME_PICTURE} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PICTURE = 102400;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PICTURE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PICTURE = "picture";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedEmpPhoto() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "empno=" + empno +
               ",photoFormat=" + photoFormat +
               ",picture=" + (picture == null ? null : picture.length + " byte(s)") +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPNO} and
     *         {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedEmpPhoto that)) {
            return false;
        }
        return Objects.equals(getEmpno(), that.getEmpno())
               && Objects.equals(getPhotoFormat(), that.getPhotoFormat());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_EMPNO} and
     *         {@value #ATTRIBUTE_NAME_PHOTO_FORMAT}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getEmpno(), getPhotoFormat());
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

    // --------------------------------------------------------------------------------- photoFormat

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute.
     */
    @Nonnull
    public String getPhotoFormat() {
        return photoFormat;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute with the specified
     * value.
     *
     * @param photoFormat new value for {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute.
     */
    protected void setPhotoFormat(@Nonnull final String photoFormat) {
        this.photoFormat = photoFormat;
    }

    // ------------------------------------------------------------------------------------- picture

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PICTURE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PICTURE} attribute.
     */
    @Nullable
    public byte[] getPicture() {
        return picture;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PICTURE} attribute with the specified
     * value.
     *
     * @param picture new value for {@value #ATTRIBUTE_NAME_PICTURE} attribute.
     */
    public void setPicture(@Nullable final byte[] picture) {
        this.picture = picture;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMPNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PHOTO_FORMAT)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PHOTO_FORMAT,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PHOTO_FORMAT
    )
    private String photoFormat;

    // ---------------------------------------------------------------------------------------------
    @Lob
    @Basic(optional = true, fetch = FetchType.LAZY)
    @Column(name = COLUMN_NAME_PICTURE,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_PICTURE
    )
    private byte[] picture;
}
