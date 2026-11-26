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

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedDepartment#TABLE_NAME} table,
 * the departments.
 * <p>
 * The foreign key columns {@value MappedDepartment#COLUMN_NAME_MGRNO},
 * {@value MappedDepartment#COLUMN_NAME_ADMRDEPT} are mapped read-only
 * ({@code insertable = false, updatable = false}), with a {@code protected} getter and no setter,
 * for {@link #toString()} and for queries. How the relationship behind each is mapped is the
 * extending entity's decision, so the extending entity also owns the writable mapping, by an
 * association's {@link jakarta.persistence.JoinColumn @JoinColumn}. <strong>An extending entity
 * which maps none never writes them.</strong> For the same reason none of them is constrained
 * {@code NotNull} here, even where the column is {@code NOT NULL}: the attribute stays {@code null}
 * until a load, and the association is what is constrained.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedDepartment {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "DEPARTMENT";

    // -------------------------------------------------------------------------------------- DEPTNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DEPTNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNO = "DEPTNO";

    /**
     * The length of the {@value #COLUMN_NAME_DEPTNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPTNO = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPTNO = "deptno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPTNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPTNO = COLUMN_LENGTH_DEPTNO;

    // ------------------------------------------------------------------------------------ DEPTNAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNAME = "DEPTNAME";

    /**
     * The length of the {@value #COLUMN_NAME_DEPTNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPTNAME = 36;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPTNAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPTNAME = "deptname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPTNAME = COLUMN_LENGTH_DEPTNAME;

    // --------------------------------------------------------------------------------------- MGRNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_MGRNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_MGRNO = "MGRNO";

    /**
     * The length of the {@value #COLUMN_NAME_MGRNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_MGRNO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MGRNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_MGRNO = "mgrno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_MGRNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_MGRNO = COLUMN_LENGTH_MGRNO;

    // ------------------------------------------------------------------------------------ ADMRDEPT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ADMRDEPT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_ADMRDEPT = "ADMRDEPT";

    /**
     * The length of the {@value #COLUMN_NAME_ADMRDEPT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_ADMRDEPT = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ADMRDEPT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ADMRDEPT = "admrdept";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_ADMRDEPT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_ADMRDEPT = COLUMN_LENGTH_ADMRDEPT;

    // ------------------------------------------------------------------------------------ LOCATION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_LOCATION} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_LOCATION = "LOCATION";

    /**
     * The length of the {@value #COLUMN_NAME_LOCATION} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_LOCATION = 16;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_LOCATION} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_LOCATION = "location";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_LOCATION} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_LOCATION = COLUMN_LENGTH_LOCATION;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedDepartment() {
        super();
    }

    /**
     * Creates a new instance with the specified value of the {@value #ATTRIBUTE_NAME_DEPTNO}
     * attribute, the identifier, which is assigned, not generated.
     *
     * @param deptno a value for the {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     */
    protected MappedDepartment(final String deptno) {
        this();
        setDeptno(deptno);
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "deptno=" + deptno +
               ",deptname=" + deptname +
               ",mgrno=" + mgrno +
               ",admrdept=" + admrdept +
               ",location=" + location +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_DEPTNO} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedDepartment that)) {
            return false;
        }
        return Objects.equals(getDeptno(), that.getDeptno());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_DEPTNO}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getDeptno());
    }

    // -------------------------------------------------------------------------------------- deptno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     */
    @Nonnull
    public String getDeptno() {
        return deptno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute with the specified
     * value.
     *
     * @param deptno new value for {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     */
    protected void setDeptno(@Nonnull final String deptno) {
        this.deptno = deptno;
    }

    // ------------------------------------------------------------------------------------ deptname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     */
    @Nonnull
    public String getDeptname() {
        return deptname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute with the specified
     * value.
     *
     * @param deptname new value for {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     */
    public void setDeptname(@Nonnull final String deptname) {
        this.deptname = deptname;
    }

    // ------------------------------------------------------------------------------------ location

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     */
    @Nullable
    public String getLocation() {
        return location;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute with the specified
     * value.
     *
     * @param location new value for {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     */
    public void setLocation(@Nullable final String location) {
        this.location = location;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPTNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_DEPTNO
    )
    private String deptno;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPTNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNAME,
            nullable = false,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_DEPTNAME
    )
    private String deptname;

    // ---------------------------------------------------------------------------------------------
    // read-only: the extending entity owns the writable mapping of this column; see the class
    // documentation
    @Size(max = SIZE_MAX_MGRNO)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MGRNO,
            nullable = true,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_MGRNO
    )
    private String mgrno;

    // ---------------------------------------------------------------------------------------------
    // read-only: the extending entity owns the writable mapping of this column; see the class
    // documentation
    @Size(max = SIZE_MAX_ADMRDEPT)
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ADMRDEPT,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_ADMRDEPT
    )
    private String admrdept;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_LOCATION)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LOCATION,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_LOCATION
    )
    private String location;
}
