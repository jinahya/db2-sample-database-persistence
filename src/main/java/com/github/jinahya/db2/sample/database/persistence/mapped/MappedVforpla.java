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
 * A mapped superclass which holds the mappings of the {@value MappedVforpla#TABLE_NAME} view, the
 * projects with their responsible employees, for planning.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * The view joins {@code EMPPROJACT} only to repeat each project once per row there, so the rows of
 * a project are duplicates of one another; the instances of a project a query returns are one and
 * the same.
 * <p>
 * <strong>A view has no key.</strong> The column {@value MappedVforpla#COLUMN_NAME_PROJNO}, unique
 * and not {@code null} in every row the sample database is created with, is mapped as the
 * identifier, which an entity needs; nothing in the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVforpla {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VFORPLA";

    // ---------------------------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNO = "PROJNO";

    /**
     * Whether the {@value #COLUMN_NAME_PROJNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROJNO = false;

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

    // -------------------------------------------------------------------------------------------------------- PROJNAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJNAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PROJNAME = "PROJNAME";

    /**
     * Whether the {@value #COLUMN_NAME_PROJNAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROJNAME = false;

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

    // --------------------------------------------------------------------------------------------------------- RESPEMP

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESPEMP} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESPEMP = "RESPEMP";

    /**
     * Whether the {@value #COLUMN_NAME_RESPEMP} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESPEMP = false;

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

    // --------------------------------------------------------------------------------------------------------- PROJDEP

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJDEP} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PROJDEP = "PROJDEP";

    /**
     * Whether the {@value #COLUMN_NAME_PROJDEP} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROJDEP = false;

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

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVforpla() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "projno=" + projno +
               ",projname=" + projname +
               ",respemp=" + respemp +
               ",projdep=" + projdep +
               ",frstinit=" + frstinit +
               ",midinit=" + midinit +
               ",lastname=" + lastname +
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
        if (!(obj instanceof MappedVforpla that)) {
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

    // ---------------------------------------------------------------------------------------------------------- projno

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

    // -------------------------------------------------------------------------------------------------------- projname

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

    // --------------------------------------------------------------------------------------------------------- respemp

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

    // --------------------------------------------------------------------------------------------------------- projdep

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

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNO,
            nullable = COLUMN_NULLABLE_PROJNO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PROJNO
    )
    private String projno;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNAME,
            nullable = COLUMN_NULLABLE_PROJNAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PROJNAME
    )
    private String projname;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESPEMP)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESPEMP,
            nullable = COLUMN_NULLABLE_RESPEMP,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESPEMP
    )
    private String respemp;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJDEP)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJDEP,
            nullable = COLUMN_NULLABLE_PROJDEP,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PROJDEP
    )
    private String projdep;

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
}
