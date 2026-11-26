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
 * A mapped superclass which holds the mappings of the {@value MappedVpstrde2#TABLE_NAME} view, the
 * projects which have no subproject, each paired with itself, and their responsible employees.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * <strong>A view has no key.</strong> The column {@value MappedVpstrde2#COLUMN_NAME_PROJ1NO},
 * unique and not {@code null} in every row the sample database is created with, is mapped as the
 * identifier, which an entity needs; nothing in the database keeps that so.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedVpstrde2 {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VPSTRDE2";

    // ------------------------------------------------------------------------------------- PROJ1NO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJ1NO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PROJ1NO = "PROJ1NO";

    /**
     * Whether the {@value #COLUMN_NAME_PROJ1NO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROJ1NO = false;

    /**
     * The length of the {@value #COLUMN_NAME_PROJ1NO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJ1NO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJ1NO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ1NO = "proj1no";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJ1NO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJ1NO = COLUMN_LENGTH_PROJ1NO;

    // ----------------------------------------------------------------------------------- PROJ1NAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJ1NAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PROJ1NAME = "PROJ1NAME";

    /**
     * Whether the {@value #COLUMN_NAME_PROJ1NAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROJ1NAME = false;

    /**
     * The length of the {@value #COLUMN_NAME_PROJ1NAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJ1NAME = 24;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJ1NAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ1NAME = "proj1name";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJ1NAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJ1NAME = COLUMN_LENGTH_PROJ1NAME;

    // ------------------------------------------------------------------------------------- RESP1NO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESP1NO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESP1NO = "RESP1NO";

    /**
     * Whether the {@value #COLUMN_NAME_RESP1NO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESP1NO = false;

    /**
     * The length of the {@value #COLUMN_NAME_RESP1NO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESP1NO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESP1NO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESP1NO = "resp1no";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESP1NO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESP1NO = COLUMN_LENGTH_RESP1NO;

    // ------------------------------------------------------------------------------------- RESP1FN

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESP1FN} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESP1FN = "RESP1FN";

    /**
     * Whether the {@value #COLUMN_NAME_RESP1FN} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESP1FN = false;

    /**
     * The length of the {@value #COLUMN_NAME_RESP1FN} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESP1FN = 12;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESP1FN} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESP1FN = "resp1fn";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESP1FN} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESP1FN = COLUMN_LENGTH_RESP1FN;

    // ------------------------------------------------------------------------------------- RESP1MI

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESP1MI} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESP1MI = "RESP1MI";

    /**
     * Whether the {@value #COLUMN_NAME_RESP1MI} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESP1MI = true;

    /**
     * The length of the {@value #COLUMN_NAME_RESP1MI} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESP1MI = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESP1MI} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESP1MI = "resp1mi";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESP1MI} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESP1MI = COLUMN_LENGTH_RESP1MI;

    // ------------------------------------------------------------------------------------- RESP1LN

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESP1LN} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESP1LN = "RESP1LN";

    /**
     * Whether the {@value #COLUMN_NAME_RESP1LN} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESP1LN = false;

    /**
     * The length of the {@value #COLUMN_NAME_RESP1LN} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESP1LN = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESP1LN} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESP1LN = "resp1ln";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESP1LN} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESP1LN = COLUMN_LENGTH_RESP1LN;

    // ------------------------------------------------------------------------------------- PROJ2NO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJ2NO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PROJ2NO = "PROJ2NO";

    /**
     * Whether the {@value #COLUMN_NAME_PROJ2NO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROJ2NO = false;

    /**
     * The length of the {@value #COLUMN_NAME_PROJ2NO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJ2NO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJ2NO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ2NO = "proj2no";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJ2NO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJ2NO = COLUMN_LENGTH_PROJ2NO;

    // ----------------------------------------------------------------------------------- PROJ2NAME

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_PROJ2NAME} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PROJ2NAME = "PROJ2NAME";

    /**
     * Whether the {@value #COLUMN_NAME_PROJ2NAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PROJ2NAME = false;

    /**
     * The length of the {@value #COLUMN_NAME_PROJ2NAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PROJ2NAME = 24;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJ2NAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ2NAME = "proj2name";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PROJ2NAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PROJ2NAME = COLUMN_LENGTH_PROJ2NAME;

    // ------------------------------------------------------------------------------------- RESP2NO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESP2NO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESP2NO = "RESP2NO";

    /**
     * Whether the {@value #COLUMN_NAME_RESP2NO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESP2NO = false;

    /**
     * The length of the {@value #COLUMN_NAME_RESP2NO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESP2NO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESP2NO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESP2NO = "resp2no";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESP2NO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESP2NO = COLUMN_LENGTH_RESP2NO;

    // ------------------------------------------------------------------------------------- RESP2FN

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESP2FN} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESP2FN = "RESP2FN";

    /**
     * Whether the {@value #COLUMN_NAME_RESP2FN} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESP2FN = false;

    /**
     * The length of the {@value #COLUMN_NAME_RESP2FN} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESP2FN = 12;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESP2FN} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESP2FN = "resp2fn";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESP2FN} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESP2FN = COLUMN_LENGTH_RESP2FN;

    // ------------------------------------------------------------------------------------- RESP2MI

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESP2MI} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESP2MI = "RESP2MI";

    /**
     * Whether the {@value #COLUMN_NAME_RESP2MI} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESP2MI = true;

    /**
     * The length of the {@value #COLUMN_NAME_RESP2MI} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESP2MI = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESP2MI} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESP2MI = "resp2mi";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESP2MI} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESP2MI = COLUMN_LENGTH_RESP2MI;

    // ------------------------------------------------------------------------------------- RESP2LN

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_RESP2LN} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_RESP2LN = "RESP2LN";

    /**
     * Whether the {@value #COLUMN_NAME_RESP2LN} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_RESP2LN = false;

    /**
     * The length of the {@value #COLUMN_NAME_RESP2LN} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_RESP2LN = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_RESP2LN} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_RESP2LN = "resp2ln";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_RESP2LN} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_RESP2LN = COLUMN_LENGTH_RESP2LN;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVpstrde2() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "proj1no=" + proj1no +
               ",proj1name=" + proj1name +
               ",resp1no=" + resp1no +
               ",resp1fn=" + resp1fn +
               ",resp1mi=" + resp1mi +
               ",resp1ln=" + resp1ln +
               ",proj2no=" + proj2no +
               ",proj2name=" + proj2name +
               ",resp2no=" + resp2no +
               ",resp2fn=" + resp2fn +
               ",resp2mi=" + resp2mi +
               ",resp2ln=" + resp2ln +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PROJ1NO} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVpstrde2 that)) {
            return false;
        }
        return Objects.equals(getProj1no(), that.getProj1no());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PROJ1NO}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getProj1no());
    }

    // ------------------------------------------------------------------------------------- proj1no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     */
    @Nonnull
    public String getProj1no() {
        return proj1no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJ1NO} attribute with the specified
     * value.
     *
     * @param proj1no new value for {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     */
    protected void setProj1no(@Nonnull final String proj1no) {
        this.proj1no = proj1no;
    }

    // ----------------------------------------------------------------------------------- proj1name

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJ1NAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJ1NAME} attribute.
     */
    @Nonnull
    public String getProj1name() {
        return proj1name;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJ1NAME} attribute with the specified
     * value.
     *
     * @param proj1name new value for {@value #ATTRIBUTE_NAME_PROJ1NAME} attribute.
     */
    protected void setProj1name(@Nonnull final String proj1name) {
        this.proj1name = proj1name;
    }

    // ------------------------------------------------------------------------------------- resp1no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESP1NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESP1NO} attribute.
     */
    @Nonnull
    public String getResp1no() {
        return resp1no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESP1NO} attribute with the specified
     * value.
     *
     * @param resp1no new value for {@value #ATTRIBUTE_NAME_RESP1NO} attribute.
     */
    protected void setResp1no(@Nonnull final String resp1no) {
        this.resp1no = resp1no;
    }

    // ------------------------------------------------------------------------------------- resp1fn

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESP1FN} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESP1FN} attribute.
     */
    @Nonnull
    public String getResp1fn() {
        return resp1fn;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESP1FN} attribute with the specified
     * value.
     *
     * @param resp1fn new value for {@value #ATTRIBUTE_NAME_RESP1FN} attribute.
     */
    protected void setResp1fn(@Nonnull final String resp1fn) {
        this.resp1fn = resp1fn;
    }

    // ------------------------------------------------------------------------------------- resp1mi

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESP1MI} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESP1MI} attribute.
     */
    @Nullable
    public String getResp1mi() {
        return resp1mi;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESP1MI} attribute with the specified
     * value.
     *
     * @param resp1mi new value for {@value #ATTRIBUTE_NAME_RESP1MI} attribute.
     */
    protected void setResp1mi(@Nullable final String resp1mi) {
        this.resp1mi = resp1mi;
    }

    // ------------------------------------------------------------------------------------- resp1ln

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESP1LN} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESP1LN} attribute.
     */
    @Nonnull
    public String getResp1ln() {
        return resp1ln;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESP1LN} attribute with the specified
     * value.
     *
     * @param resp1ln new value for {@value #ATTRIBUTE_NAME_RESP1LN} attribute.
     */
    protected void setResp1ln(@Nonnull final String resp1ln) {
        this.resp1ln = resp1ln;
    }

    // ------------------------------------------------------------------------------------- proj2no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     */
    @Nonnull
    public String getProj2no() {
        return proj2no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJ2NO} attribute with the specified
     * value.
     *
     * @param proj2no new value for {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     */
    protected void setProj2no(@Nonnull final String proj2no) {
        this.proj2no = proj2no;
    }

    // ----------------------------------------------------------------------------------- proj2name

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJ2NAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJ2NAME} attribute.
     */
    @Nonnull
    public String getProj2name() {
        return proj2name;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJ2NAME} attribute with the specified
     * value.
     *
     * @param proj2name new value for {@value #ATTRIBUTE_NAME_PROJ2NAME} attribute.
     */
    protected void setProj2name(@Nonnull final String proj2name) {
        this.proj2name = proj2name;
    }

    // ------------------------------------------------------------------------------------- resp2no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESP2NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESP2NO} attribute.
     */
    @Nonnull
    public String getResp2no() {
        return resp2no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESP2NO} attribute with the specified
     * value.
     *
     * @param resp2no new value for {@value #ATTRIBUTE_NAME_RESP2NO} attribute.
     */
    protected void setResp2no(@Nonnull final String resp2no) {
        this.resp2no = resp2no;
    }

    // ------------------------------------------------------------------------------------- resp2fn

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESP2FN} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESP2FN} attribute.
     */
    @Nonnull
    public String getResp2fn() {
        return resp2fn;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESP2FN} attribute with the specified
     * value.
     *
     * @param resp2fn new value for {@value #ATTRIBUTE_NAME_RESP2FN} attribute.
     */
    protected void setResp2fn(@Nonnull final String resp2fn) {
        this.resp2fn = resp2fn;
    }

    // ------------------------------------------------------------------------------------- resp2mi

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESP2MI} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESP2MI} attribute.
     */
    @Nullable
    public String getResp2mi() {
        return resp2mi;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESP2MI} attribute with the specified
     * value.
     *
     * @param resp2mi new value for {@value #ATTRIBUTE_NAME_RESP2MI} attribute.
     */
    protected void setResp2mi(@Nullable final String resp2mi) {
        this.resp2mi = resp2mi;
    }

    // ------------------------------------------------------------------------------------- resp2ln

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_RESP2LN} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_RESP2LN} attribute.
     */
    @Nonnull
    public String getResp2ln() {
        return resp2ln;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_RESP2LN} attribute with the specified
     * value.
     *
     * @param resp2ln new value for {@value #ATTRIBUTE_NAME_RESP2LN} attribute.
     */
    protected void setResp2ln(@Nonnull final String resp2ln) {
        this.resp2ln = resp2ln;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJ1NO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJ1NO,
            nullable = COLUMN_NULLABLE_PROJ1NO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PROJ1NO
    )
    private String proj1no;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJ1NAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJ1NAME,
            nullable = COLUMN_NULLABLE_PROJ1NAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PROJ1NAME
    )
    private String proj1name;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESP1NO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESP1NO,
            nullable = COLUMN_NULLABLE_RESP1NO,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESP1NO
    )
    private String resp1no;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESP1FN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESP1FN,
            nullable = COLUMN_NULLABLE_RESP1FN,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESP1FN
    )
    private String resp1fn;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_RESP1MI)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESP1MI,
            nullable = COLUMN_NULLABLE_RESP1MI,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESP1MI
    )
    private String resp1mi;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESP1LN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESP1LN,
            nullable = COLUMN_NULLABLE_RESP1LN,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESP1LN
    )
    private String resp1ln;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJ2NO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJ2NO,
            nullable = COLUMN_NULLABLE_PROJ2NO,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PROJ2NO
    )
    private String proj2no;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PROJ2NAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJ2NAME,
            nullable = COLUMN_NULLABLE_PROJ2NAME,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_PROJ2NAME
    )
    private String proj2name;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESP2NO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESP2NO,
            nullable = COLUMN_NULLABLE_RESP2NO,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESP2NO
    )
    private String resp2no;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESP2FN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESP2FN,
            nullable = COLUMN_NULLABLE_RESP2FN,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESP2FN
    )
    private String resp2fn;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_RESP2MI)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESP2MI,
            nullable = COLUMN_NULLABLE_RESP2MI,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESP2MI
    )
    private String resp2mi;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_RESP2LN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_RESP2LN,
            nullable = COLUMN_NULLABLE_RESP2LN,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_RESP2LN
    )
    private String resp2ln;
}
