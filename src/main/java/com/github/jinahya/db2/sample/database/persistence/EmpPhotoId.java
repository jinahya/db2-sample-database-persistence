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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedEmpPhoto;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

/**
 * The identifier of the {@value MappedEmpPhoto#TABLE_NAME} table, the key of
 * {@value MappedEmpPhoto#COLUMN_NAME_EMPNO} and {@value MappedEmpPhoto#COLUMN_NAME_PHOTO_FORMAT}.
 * <p>
 * It is an {@link Embeddable @Embeddable}, so that an entity extending {@link MappedEmpPhoto} may
 * name it either with {@link jakarta.persistence.IdClass @IdClass}, whose attributes have the names
 * and the types of the {@link jakarta.persistence.Id @Id} attributes there, or as the type of an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId}, which the column mappings here serve.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedEmpPhoto
 */
@Embeddable
public class EmpPhotoId {

    // --------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the attribute which maps the {@value MappedEmpPhoto#COLUMN_NAME_EMPNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = "empno";

    // -------------------------------------------------------------------------------- PHOTO_FORMAT

    /**
     * The name of the attribute which maps the {@value MappedEmpPhoto#COLUMN_NAME_PHOTO_FORMAT}
     * column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PHOTO_FORMAT = "photoFormat";

    // ---------------------------------------------------------------------- STATIC_FACTORY_METHODS

    /**
     * Returns a new instance with the specified values.
     *
     * @param empno       a value for the {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     * @param photoFormat a value for the {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute.
     * @return a new instance with {@code empno} and {@code photoFormat}.
     */
    public static EmpPhotoId of(final String empno, final String photoFormat) {
        final var instance = new EmpPhotoId();
        instance.setEmpno(empno);
        instance.setPhotoFormat(photoFormat);
        return instance;
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public EmpPhotoId() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "empno=" + empno +
               ",photoFormat=" + photoFormat +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPNO} and
     *         {@value #ATTRIBUTE_NAME_PHOTO_FORMAT}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof EmpPhotoId that)) {
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

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    @Column(name = MappedEmpPhoto.COLUMN_NAME_EMPNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedEmpPhoto.COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute.
     */
    @Column(name = MappedEmpPhoto.COLUMN_NAME_PHOTO_FORMAT,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedEmpPhoto.COLUMN_LENGTH_PHOTO_FORMAT
    )
    private String photoFormat;
}
