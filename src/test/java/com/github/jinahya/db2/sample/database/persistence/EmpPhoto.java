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
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Optional;

/**
 * An entity of the {@value #TABLE_NAME} table, which declares the identifier {@link MappedEmpPhoto}
 * leaves out, with {@link EmpPhotoId} as its {@link IdClass @IdClass}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@IdClass(EmpPhotoId.class)
@Table(name = EmpPhoto.TABLE_NAME)
public class EmpPhoto
        extends MappedEmpPhoto {

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPNO} column, a part of the
     * identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = EmpPhotoId.ATTRIBUTE_NAME_EMPNO;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PHOTO_FORMAT} column, a part of
     * the identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PHOTO_FORMAT = EmpPhotoId.ATTRIBUTE_NAME_PHOTO_FORMAT;

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
     *         {@value #ATTRIBUTE_NAME_PHOTO_FORMAT}, the identifier.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof EmpPhoto that)) {
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
    public String getEmpno() {
        return empno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute with the specified value.
     *
     * @param empno new value for {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     * @apiNote This method is not public: the column is written through
     *         {@link #setEmployee(Employee)}, which calls this.
     */
    protected void setEmpno(final String empno) {
        this.empno = empno;
    }

    // --------------------------------------------------------------------------------- photoFormat

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute.
     */
    public String getPhotoFormat() {
        return photoFormat;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute with the specified
     * value.
     *
     * @param photoFormat new value for {@value #ATTRIBUTE_NAME_PHOTO_FORMAT} attribute.
     */
    public void setPhotoFormat(final String photoFormat) {
        this.photoFormat = photoFormat;
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
     * Replaces the employee with the specified value, and the {@value #ATTRIBUTE_NAME_EMPNO}
     * attribute, the part of the identifier which writes the same column, with its employee
     * number.
     *
     * @param employee new value for the employee.
     */
    public void setEmployee(final Employee employee) {
        this.employee = employee;
        setEmpno(Optional.ofNullable(employee).map(Employee::getEmpno).orElse(null));
    }

    // ---------------------------------------------------------------------------------------------
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
    // read-only: the column is part of the identifier, which empno writes
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = EmpPhoto.COLUMN_NAME_EMPNO,
                referencedColumnName = Employee.COLUMN_NAME_EMPNO,
                nullable = false,
                insertable = false,
                updatable = false
    )
    private Employee employee;
}
