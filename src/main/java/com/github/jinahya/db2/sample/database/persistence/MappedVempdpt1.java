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
 * A mapped superclass which holds the mappings of the {@value MappedVempdpt1#TABLE_NAME} view, the
 * employees with their departments.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and
 * the setters are not public; an extending entity is for reading. The identifier's columns stay
 * insertable since EclipseLink requires an {@link Id @Id} mapping to be writable.
 * <p>
 * <strong>A view has no key.</strong> The column {@value MappedVempdpt1#COLUMN_NAME_EMPNO}, unique
 * and not {@code null}
 * in every row the sample database is created with, is mapped as the identifier, which an entity
 * needs; nothing in the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVempdpt1 {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VEMPDPT1";

    // ---------------------------------------------------------------------------------------------------------- DEPTNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPTNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNO = "DEPTNO";

    /**
     * Whether the {@value #COLUMN_NAME_DEPTNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPTNO = true;

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

    // -------------------------------------------------------------------------------------------------------- DEPTNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNAME = "DEPTNAME";

    /**
     * Whether the {@value #COLUMN_NAME_DEPTNAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPTNAME = true;

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

    // ----------------------------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMPNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    /**
     * Whether the {@value #COLUMN_NAME_EMPNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMPNO = false;

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

    // -------------------------------------------------------------------------------------------------------- FRSTINIT

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_FRSTINIT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_FRSTINIT = "FRSTINIT";

    /**
     * Whether the {@value #COLUMN_NAME_FRSTINIT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_FRSTINIT = false;

    /**
     * The length of the {@value #COLUMN_NAME_FRSTINIT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_FRSTINIT = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_FRSTINIT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_FRSTINIT = "frstinit";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_FRSTINIT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_FRSTINIT = COLUMN_LENGTH_FRSTINIT;

    // --------------------------------------------------------------------------------------------------------- MIDINIT

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_MIDINIT} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_MIDINIT = "MIDINIT";

    /**
     * Whether the {@value #COLUMN_NAME_MIDINIT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_MIDINIT = true;

    /**
     * The length of the {@value #COLUMN_NAME_MIDINIT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_MIDINIT = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MIDINIT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_MIDINIT = "midinit";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_MIDINIT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_MIDINIT = COLUMN_LENGTH_MIDINIT;

    // -------------------------------------------------------------------------------------------------------- LASTNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_LASTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_LASTNAME = "LASTNAME";

    /**
     * Whether the {@value #COLUMN_NAME_LASTNAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_LASTNAME = false;

    /**
     * The length of the {@value #COLUMN_NAME_LASTNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_LASTNAME = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_LASTNAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_LASTNAME = "lastname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_LASTNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_LASTNAME = COLUMN_LENGTH_LASTNAME;

    // -------------------------------------------------------------------------------------------------------- WORKDEPT

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_WORKDEPT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_WORKDEPT = "WORKDEPT";

    /**
     * Whether the {@value #COLUMN_NAME_WORKDEPT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_WORKDEPT = true;

    /**
     * The length of the {@value #COLUMN_NAME_WORKDEPT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_WORKDEPT = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_WORKDEPT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_WORKDEPT = "workdept";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_WORKDEPT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_WORKDEPT = COLUMN_LENGTH_WORKDEPT;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVempdpt1() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "deptno=" + deptno +
               ",deptname=" + deptname +
               ",empno=" + empno +
               ",frstinit=" + frstinit +
               ",midinit=" + midinit +
               ",lastname=" + lastname +
               ",workdept=" + workdept +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPNO} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVempdpt1 that)) {
            return false;
        }
        return Objects.equals(getEmpno(), that.getEmpno());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_EMPNO}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getEmpno());
    }

    // ---------------------------------------------------------------------------------------------------------- deptno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     */
    @Nullable
    public String getDeptno() {
        return deptno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNO} attribute with the specified
     * value.
     *
     * @param deptno new value for {@value #ATTRIBUTE_NAME_DEPTNO} attribute.
     */
    protected void setDeptno(@Nullable final String deptno) {
        this.deptno = deptno;
    }

    // -------------------------------------------------------------------------------------------------------- deptname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     */
    @Nullable
    public String getDeptname() {
        return deptname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPTNAME} attribute with the specified
     * value.
     *
     * @param deptname new value for {@value #ATTRIBUTE_NAME_DEPTNAME} attribute.
     */
    protected void setDeptname(@Nullable final String deptname) {
        this.deptname = deptname;
    }

    // ----------------------------------------------------------------------------------------------------------- empno

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

    // -------------------------------------------------------------------------------------------------------- frstinit

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_FRSTINIT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_FRSTINIT} attribute.
     */
    @Nonnull
    public String getFrstinit() {
        return frstinit;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_FRSTINIT} attribute with the specified
     * value.
     *
     * @param frstinit new value for {@value #ATTRIBUTE_NAME_FRSTINIT} attribute.
     */
    protected void setFrstinit(@Nonnull final String frstinit) {
        this.frstinit = frstinit;
    }

    // --------------------------------------------------------------------------------------------------------- midinit

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     */
    @Nullable
    public String getMidinit() {
        return midinit;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute with the specified
     * value.
     *
     * @param midinit new value for {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     */
    protected void setMidinit(@Nullable final String midinit) {
        this.midinit = midinit;
    }

    // -------------------------------------------------------------------------------------------------------- lastname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     */
    @Nonnull
    public String getLastname() {
        return lastname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute with the specified
     * value.
     *
     * @param lastname new value for {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     */
    protected void setLastname(@Nonnull final String lastname) {
        this.lastname = lastname;
    }

    // -------------------------------------------------------------------------------------------------------- workdept

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_WORKDEPT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_WORKDEPT} attribute.
     */
    @Nullable
    public String getWorkdept() {
        return workdept;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_WORKDEPT} attribute with the specified
     * value.
     *
     * @param workdept new value for {@value #ATTRIBUTE_NAME_WORKDEPT} attribute.
     */
    protected void setWorkdept(@Nullable final String workdept) {
        this.workdept = workdept;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_DEPTNO)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNO,
            nullable = COLUMN_NULLABLE_DEPTNO,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPTNO
    )
    private String deptno;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_DEPTNAME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNAME,
            nullable = COLUMN_NULLABLE_DEPTNAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPTNAME
    )
    private String deptname;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMPNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPNO,
            nullable = COLUMN_NULLABLE_EMPNO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_FRSTINIT)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_FRSTINIT,
            nullable = COLUMN_NULLABLE_FRSTINIT,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_FRSTINIT
    )
    private String frstinit;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_MIDINIT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MIDINIT,
            nullable = COLUMN_NULLABLE_MIDINIT,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_MIDINIT
    )
    private String midinit;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_LASTNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LASTNAME,
            nullable = COLUMN_NULLABLE_LASTNAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_LASTNAME
    )
    private String lastname;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_WORKDEPT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_WORKDEPT,
            nullable = COLUMN_NULLABLE_WORKDEPT,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_WORKDEPT
    )
    private String workdept;
}
