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
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;
import java.util.Optional;

/**
 * An entity of the {@value #TABLE_NAME} table, which declares the identifier
 * {@link MappedEmpPhoto} leaves out, an {@link EmbeddedId @EmbeddedId} of {@link EmpPhotoId}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = EmpPhoto.TABLE_NAME)
public class EmpPhoto
        extends MappedEmpPhoto {

    /**
     * The name of the attribute of the identifier, an {@link EmbeddedId @EmbeddedId} of
     * {@link EmpPhotoId}. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ID = "id";

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_EMPNO} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_EMPNO =
            ATTRIBUTE_NAME_ID + "." + EmpPhotoId.ATTRIBUTE_NAME_EMPNO;

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_PHOTO_FORMAT}
     * column. The value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_PHOTO_FORMAT =
            ATTRIBUTE_NAME_ID + "." + EmpPhotoId.ATTRIBUTE_NAME_PHOTO_FORMAT;

    // --------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPNO} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPLOYEE = "employee";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected EmpPhoto() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "id=" + id +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_ID}, the identifier.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof EmpPhoto that)) {
            return false;
        }
        return Objects.equals(getId(), that.getId());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_ID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }

    // ------------------------------------------------------------------------------------------ id

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     */
    public EmpPhotoId getId() {
        return id;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Replaces the photo format of the identifier with the specified value; an identifier is
     * created when there is none.
     *
     * @param photoFormat new value for the photo format of the identifier.
     */
    protected void setPhotoFormat(final String photoFormat) {
        id = Optional.ofNullable(id)
                .map(v -> v.withPhotoFormat(photoFormat))
                .orElseGet(() -> EmpPhotoId.from(employee, photoFormat));
    }

    // ------------------------------------------------------------------------------------ employee

    /**
     * Returns the employee.
     *
     * @return the employee.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Replaces the employee with the specified value.
     *
     * @param employee new value for the employee.
     * @implNote The association maps the employee number of the identifier
     *         ({@link jakarta.persistence.MapsId @MapsId}), which the provider sets from it when
     *         this instance is persisted; this sets it as well, so that the identifier is complete
     *         before then.
     */
    public void setEmployee(final Employee employee) {
        this.employee = employee;
        id = Optional.ofNullable(id)
                .map(v -> v.withEmployee(this.employee))
                .orElseGet(() -> EmpPhotoId.from(this.employee, null));
    }

    // ---------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    @EmbeddedId
    private EmpPhotoId id;

    // ---------------------------------------------------------------------------------------------
    // maps the employee number of the identifier, which the provider derives from it
    @Valid
    @NotNull
    @MapsId(EmpPhotoId.ATTRIBUTE_NAME_EMPNO)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = EmpPhoto.COLUMN_NAME_EMPNO,
                referencedColumnName = Employee.COLUMN_NAME_EMPNO,
                nullable = false,
                insertable = true,
                updatable = false
    )
    private Employee employee;
}
