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
 * A mapped superclass which holds the mappings of the {@value MappedVdepmg1#TABLE_NAME} view, the
 * departments with their managers.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * <strong>A view has no key.</strong> The column {@value MappedVdepmg1#COLUMN_NAME_DEPTNO}, unique
 * and not {@code null} in every row the sample database is created with, is mapped as the
 * identifier, which an entity needs; nothing in the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVdepmg1 {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VDEPMG1";

    // ---------------------------------------------------------------------------------------------------------- DEPTNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPTNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DEPTNO = "DEPTNO";

    /**
     * Whether the {@value #COLUMN_NAME_DEPTNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPTNO = false;

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
    public static final boolean COLUMN_NULLABLE_DEPTNAME = false;

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

    // ----------------------------------------------------------------------------------------------------------- MGRNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_MGRNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_MGRNO = "MGRNO";

    /**
     * Whether the {@value #COLUMN_NAME_MGRNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_MGRNO = true;

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

    // -------------------------------------------------------------------------------------------------------- FIRSTNME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_FIRSTNME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_FIRSTNME = "FIRSTNME";

    /**
     * Whether the {@value #COLUMN_NAME_FIRSTNME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_FIRSTNME = true;

    /**
     * The length of the {@value #COLUMN_NAME_FIRSTNME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_FIRSTNME = 12;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_FIRSTNME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_FIRSTNME = "firstnme";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_FIRSTNME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_FIRSTNME = COLUMN_LENGTH_FIRSTNME;

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
    public static final boolean COLUMN_NULLABLE_LASTNAME = true;

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

    // -------------------------------------------------------------------------------------------------------- ADMRDEPT

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_ADMRDEPT} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_ADMRDEPT = "ADMRDEPT";

    /**
     * Whether the {@value #COLUMN_NAME_ADMRDEPT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ADMRDEPT = false;

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

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVdepmg1() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "deptno=" + deptno +
               ",deptname=" + deptname +
               ",mgrno=" + mgrno +
               ",firstnme=" + firstnme +
               ",midinit=" + midinit +
               ",lastname=" + lastname +
               ",admrdept=" + admrdept +
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
        if (!(obj instanceof MappedVdepmg1 that)) {
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

    // ---------------------------------------------------------------------------------------------------------- deptno

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

    // -------------------------------------------------------------------------------------------------------- deptname

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
    protected void setDeptname(@Nonnull final String deptname) {
        this.deptname = deptname;
    }

    // ----------------------------------------------------------------------------------------------------------- mgrno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MGRNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MGRNO} attribute.
     */
    @Nullable
    public String getMgrno() {
        return mgrno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MGRNO} attribute with the specified value.
     *
     * @param mgrno new value for {@value #ATTRIBUTE_NAME_MGRNO} attribute.
     */
    protected void setMgrno(@Nullable final String mgrno) {
        this.mgrno = mgrno;
    }

    // -------------------------------------------------------------------------------------------------------- firstnme

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     */
    @Nullable
    public String getFirstnme() {
        return firstnme;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute with the specified
     * value.
     *
     * @param firstnme new value for {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     */
    protected void setFirstnme(@Nullable final String firstnme) {
        this.firstnme = firstnme;
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
    @Nullable
    public String getLastname() {
        return lastname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute with the specified
     * value.
     *
     * @param lastname new value for {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     */
    protected void setLastname(@Nullable final String lastname) {
        this.lastname = lastname;
    }

    // -------------------------------------------------------------------------------------------------------- admrdept

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ADMRDEPT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ADMRDEPT} attribute.
     */
    @Nonnull
    public String getAdmrdept() {
        return admrdept;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ADMRDEPT} attribute with the specified
     * value.
     *
     * @param admrdept new value for {@value #ATTRIBUTE_NAME_ADMRDEPT} attribute.
     */
    protected void setAdmrdept(@Nonnull final String admrdept) {
        this.admrdept = admrdept;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPTNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNO,
            nullable = COLUMN_NULLABLE_DEPTNO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_DEPTNO
    )
    private String deptno;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPTNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPTNAME,
            nullable = COLUMN_NULLABLE_DEPTNAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPTNAME
    )
    private String deptname;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_MGRNO)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MGRNO,
            nullable = COLUMN_NULLABLE_MGRNO,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_MGRNO
    )
    private String mgrno;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_FIRSTNME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_FIRSTNME,
            nullable = COLUMN_NULLABLE_FIRSTNME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_FIRSTNME
    )
    private String firstnme;

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
    @Size(max = SIZE_MAX_LASTNAME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LASTNAME,
            nullable = COLUMN_NULLABLE_LASTNAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_LASTNAME
    )
    private String lastname;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_ADMRDEPT)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ADMRDEPT,
            nullable = COLUMN_NULLABLE_ADMRDEPT,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_ADMRDEPT
    )
    private String admrdept;
}
