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
 * A mapped superclass which holds the mappings of the {@value MappedVprojre1#TABLE_NAME} view, the
 * projects with their responsible employees.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * <strong>A view has no key.</strong> The column {@value MappedVprojre1#COLUMN_NAME_PROJNO},
 * unique and not {@code null} in every row the sample database is created with, is mapped as the
 * identifier, which an entity needs; nothing in the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVprojre1 {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VPROJRE1";

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNO = "PROJNO";

    /**
     * The length of the {@value #COLUMN_NAME_PROJNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJNO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNO = "projno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJNO = COLUMN_LENGTH_PROJNO;

    // ------------------------------------------------------------------------------------ PROJNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNAME = "PROJNAME";

    /**
     * The length of the {@value #COLUMN_NAME_PROJNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJNAME = 24;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJNAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNAME = "projname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJNAME = COLUMN_LENGTH_PROJNAME;

    // ------------------------------------------------------------------------------------- PROJDEP

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJDEP} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PROJDEP = "PROJDEP";

    /**
     * The length of the {@value #COLUMN_NAME_PROJDEP} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJDEP = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJDEP} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJDEP = "projdep";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJDEP} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJDEP = COLUMN_LENGTH_PROJDEP;

    // ------------------------------------------------------------------------------------- RESPEMP

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESPEMP} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESPEMP = "RESPEMP";

    /**
     * The length of the {@value #COLUMN_NAME_RESPEMP} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESPEMP = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESPEMP} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESPEMP = "respemp";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESPEMP} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESPEMP = COLUMN_LENGTH_RESPEMP;

    // ------------------------------------------------------------------------------------ FIRSTNME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_FIRSTNME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_FIRSTNME = "FIRSTNME";

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

    // ------------------------------------------------------------------------------------- MIDINIT

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_MIDINIT} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_MIDINIT = "MIDINIT";

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

    // ------------------------------------------------------------------------------------ LASTNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_LASTNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_LASTNAME = "LASTNAME";

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

    // ------------------------------------------------------------------------------------- MAJPROJ

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_MAJPROJ} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_MAJPROJ = "MAJPROJ";

    /**
     * The length of the {@value #COLUMN_NAME_MAJPROJ} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_MAJPROJ = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MAJPROJ} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_MAJPROJ = "majproj";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_MAJPROJ} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_MAJPROJ = COLUMN_LENGTH_MAJPROJ;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVprojre1() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "projno=" + projno +
               ",projname=" + projname +
               ",projdep=" + projdep +
               ",respemp=" + respemp +
               ",firstnme=" + firstnme +
               ",midinit=" + midinit +
               ",lastname=" + lastname +
               ",majproj=" + majproj +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PROJNO} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVprojre1 that)) {
            return false;
        }
        return Objects.equals(getProjno(), that.getProjno());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PROJNO}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getProjno());
    }

    // -------------------------------------------------------------------------------------- projno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     */
    @Nonnull
    public String getProjno() {
        return projno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute with the specified
     * value.
     *
     * @param projno new value for {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     */
    protected void setProjno(@Nonnull final String projno) {
        this.projno = projno;
    }

    // ------------------------------------------------------------------------------------ projname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJNAME} attribute.
     */
    @Nonnull
    public String getProjname() {
        return projname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJNAME} attribute with the specified
     * value.
     *
     * @param projname new value for {@value #ATTRIBUTE_NAME_PROJNAME} attribute.
     */
    protected void setProjname(@Nonnull final String projname) {
        this.projname = projname;
    }

    // ------------------------------------------------------------------------------------- projdep

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJDEP} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJDEP} attribute.
     */
    @Nonnull
    public String getProjdep() {
        return projdep;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJDEP} attribute with the specified
     * value.
     *
     * @param projdep new value for {@value #ATTRIBUTE_NAME_PROJDEP} attribute.
     */
    protected void setProjdep(@Nonnull final String projdep) {
        this.projdep = projdep;
    }

    // ------------------------------------------------------------------------------------- respemp

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESPEMP} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESPEMP} attribute.
     */
    @Nonnull
    public String getRespemp() {
        return respemp;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESPEMP} attribute with the specified
     * value.
     *
     * @param respemp new value for {@value #ATTRIBUTE_NAME_RESPEMP} attribute.
     */
    protected void setRespemp(@Nonnull final String respemp) {
        this.respemp = respemp;
    }

    // ------------------------------------------------------------------------------------ firstnme

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     */
    @Nonnull
    public String getFirstnme() {
        return firstnme;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute with the specified
     * value.
     *
     * @param firstnme new value for {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     */
    protected void setFirstnme(@Nonnull final String firstnme) {
        this.firstnme = firstnme;
    }

    // ------------------------------------------------------------------------------------- midinit

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

    // ------------------------------------------------------------------------------------ lastname

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

    // ------------------------------------------------------------------------------------- majproj

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MAJPROJ} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MAJPROJ} attribute.
     */
    @Nullable
    public String getMajproj() {
        return majproj;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MAJPROJ} attribute with the specified
     * value.
     *
     * @param majproj new value for {@value #ATTRIBUTE_NAME_MAJPROJ} attribute.
     */
    protected void setMajproj(@Nullable final String majproj) {
        this.majproj = majproj;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PROJNO
    )
    private String projno;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNAME,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PROJNAME
    )
    private String projname;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJDEP)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJDEP,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PROJDEP
    )
    private String projdep;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESPEMP)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESPEMP,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESPEMP
    )
    private String respemp;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_FIRSTNME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_FIRSTNME,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_FIRSTNME
    )
    private String firstnme;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_MIDINIT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MIDINIT,
            nullable = true,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_MIDINIT
    )
    private String midinit;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_LASTNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LASTNAME,
            nullable = false,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_LASTNAME
    )
    private String lastname;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_MAJPROJ)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MAJPROJ,
            nullable = true,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_MAJPROJ
    )
    private String majproj;
}
