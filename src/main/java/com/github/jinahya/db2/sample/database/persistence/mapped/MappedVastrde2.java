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
 * A mapped superclass which holds the mappings of the {@value MappedVastrde2#TABLE_NAME} view, the
 * departments, each with its manager and an employee who works in it.
 * <p>
 * <strong>The view is mapped read-only.</strong> No column is updatable, none but the identifier's
 * is insertable, and the setters are not public; an extending entity is for reading. The
 * identifier's columns stay insertable since EclipseLink requires an {@link Id @Id} mapping to be
 * writable.
 * <p>
 * <strong>A view has no key.</strong> The columns {@value MappedVastrde2#COLUMN_NAME_DEPT1NO},
 * {@value MappedVastrde2#COLUMN_NAME_EMP2NO}, unique and not {@code null} in every row the sample
 * database is created with, are mapped as the identifier, which an entity needs; nothing in the
 * database keeps that so.
 * <p>
 * The identifier is mapped with an {@link jakarta.persistence.IdClass @IdClass}: an extending
 * entity names a subclass of {@link MappedVastrde2Id} with {@code @IdClass} and inherits the
 * {@link Id @Id} attributes from here.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVastrde2Id
 */
@MappedSuperclass
public abstract class MappedVastrde2 {

    /**
     * The name of the database view to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "VASTRDE2";

    // ------------------------------------------------------------------------------------- DEPT1NO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPT1NO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DEPT1NO = "DEPT1NO";

    /**
     * Whether the {@value #COLUMN_NAME_DEPT1NO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPT1NO = false;

    /**
     * The length of the {@value #COLUMN_NAME_DEPT1NO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPT1NO = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPT1NO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT1NO = "dept1no";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPT1NO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPT1NO = COLUMN_LENGTH_DEPT1NO;

    // ------------------------------------------------------------------------------------ DEPT1NAM

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPT1NAM} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPT1NAM = "DEPT1NAM";

    /**
     * Whether the {@value #COLUMN_NAME_DEPT1NAM} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPT1NAM = false;

    /**
     * The length of the {@value #COLUMN_NAME_DEPT1NAM} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPT1NAM = 36;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPT1NAM} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT1NAM = "dept1nam";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPT1NAM} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPT1NAM = COLUMN_LENGTH_DEPT1NAM;

    // -------------------------------------------------------------------------------------- EMP1NO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMP1NO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMP1NO = "EMP1NO";

    /**
     * Whether the {@value #COLUMN_NAME_EMP1NO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMP1NO = true;

    /**
     * The length of the {@value #COLUMN_NAME_EMP1NO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMP1NO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP1NO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP1NO = "emp1no";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMP1NO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMP1NO = COLUMN_LENGTH_EMP1NO;

    // -------------------------------------------------------------------------------------- EMP1FN

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMP1FN} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMP1FN = "EMP1FN";

    /**
     * Whether the {@value #COLUMN_NAME_EMP1FN} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMP1FN = true;

    /**
     * The length of the {@value #COLUMN_NAME_EMP1FN} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMP1FN = 12;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP1FN} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP1FN = "emp1fn";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMP1FN} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMP1FN = COLUMN_LENGTH_EMP1FN;

    // -------------------------------------------------------------------------------------- EMP1MI

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMP1MI} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMP1MI = "EMP1MI";

    /**
     * Whether the {@value #COLUMN_NAME_EMP1MI} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMP1MI = true;

    /**
     * The length of the {@value #COLUMN_NAME_EMP1MI} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMP1MI = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP1MI} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP1MI = "emp1mi";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMP1MI} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMP1MI = COLUMN_LENGTH_EMP1MI;

    // -------------------------------------------------------------------------------------- EMP1LN

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMP1LN} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMP1LN = "EMP1LN";

    /**
     * Whether the {@value #COLUMN_NAME_EMP1LN} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMP1LN = true;

    /**
     * The length of the {@value #COLUMN_NAME_EMP1LN} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMP1LN = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP1LN} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP1LN = "emp1ln";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMP1LN} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMP1LN = COLUMN_LENGTH_EMP1LN;

    // --------------------------------------------------------------------------------------- TYPE2

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_TYPE2} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_TYPE2 = "TYPE2";

    /**
     * Whether the {@value #COLUMN_NAME_TYPE2} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_TYPE2 = false;

    /**
     * The length of the {@value #COLUMN_NAME_TYPE2} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_TYPE2 = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_TYPE2} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_TYPE2 = "type2";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_TYPE2} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_TYPE2 = COLUMN_LENGTH_TYPE2;

    // ------------------------------------------------------------------------------------- DEPT2NO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPT2NO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DEPT2NO = "DEPT2NO";

    /**
     * Whether the {@value #COLUMN_NAME_DEPT2NO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPT2NO = false;

    /**
     * The length of the {@value #COLUMN_NAME_DEPT2NO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPT2NO = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPT2NO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT2NO = "dept2no";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPT2NO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPT2NO = COLUMN_LENGTH_DEPT2NO;

    // ------------------------------------------------------------------------------------ DEPT2NAM

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_DEPT2NAM} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_DEPT2NAM = "DEPT2NAM";

    /**
     * Whether the {@value #COLUMN_NAME_DEPT2NAM} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_DEPT2NAM = false;

    /**
     * The length of the {@value #COLUMN_NAME_DEPT2NAM} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_DEPT2NAM = 36;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPT2NAM} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT2NAM = "dept2nam";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_DEPT2NAM} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_DEPT2NAM = COLUMN_LENGTH_DEPT2NAM;

    // -------------------------------------------------------------------------------------- EMP2NO

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMP2NO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMP2NO = "EMP2NO";

    /**
     * Whether the {@value #COLUMN_NAME_EMP2NO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMP2NO = false;

    /**
     * The length of the {@value #COLUMN_NAME_EMP2NO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMP2NO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP2NO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP2NO = "emp2no";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMP2NO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMP2NO = COLUMN_LENGTH_EMP2NO;

    // -------------------------------------------------------------------------------------- EMP2FN

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMP2FN} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMP2FN = "EMP2FN";

    /**
     * Whether the {@value #COLUMN_NAME_EMP2FN} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMP2FN = false;

    /**
     * The length of the {@value #COLUMN_NAME_EMP2FN} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMP2FN = 12;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP2FN} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP2FN = "emp2fn";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMP2FN} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMP2FN = COLUMN_LENGTH_EMP2FN;

    // -------------------------------------------------------------------------------------- EMP2MI

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMP2MI} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMP2MI = "EMP2MI";

    /**
     * Whether the {@value #COLUMN_NAME_EMP2MI} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMP2MI = true;

    /**
     * The length of the {@value #COLUMN_NAME_EMP2MI} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMP2MI = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP2MI} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP2MI = "emp2mi";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMP2MI} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMP2MI = COLUMN_LENGTH_EMP2MI;

    // -------------------------------------------------------------------------------------- EMP2LN

    /**
     * The name of the view column to which the {@value #ATTRIBUTE_NAME_EMP2LN} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMP2LN = "EMP2LN";

    /**
     * Whether the {@value #COLUMN_NAME_EMP2LN} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMP2LN = false;

    /**
     * The length of the {@value #COLUMN_NAME_EMP2LN} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMP2LN = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP2LN} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP2LN = "emp2ln";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMP2LN} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMP2LN = COLUMN_LENGTH_EMP2LN;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVastrde2() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "dept1no=" + dept1no +
               ",dept1nam=" + dept1nam +
               ",emp1no=" + emp1no +
               ",emp1fn=" + emp1fn +
               ",emp1mi=" + emp1mi +
               ",emp1ln=" + emp1ln +
               ",type2=" + type2 +
               ",dept2no=" + dept2no +
               ",dept2nam=" + dept2nam +
               ",emp2no=" + emp2no +
               ",emp2fn=" + emp2fn +
               ",emp2mi=" + emp2mi +
               ",emp2ln=" + emp2ln +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_DEPT1NO} and
     *         {@value #ATTRIBUTE_NAME_EMP2NO} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVastrde2 that)) {
            return false;
        }
        return Objects.equals(getDept1no(), that.getDept1no())
               && Objects.equals(getEmp2no(), that.getEmp2no());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_DEPT1NO} and
     *         {@value #ATTRIBUTE_NAME_EMP2NO}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getDept1no(), getEmp2no());
    }

    // ------------------------------------------------------------------------------------- dept1no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPT1NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPT1NO} attribute.
     */
    @Nonnull
    public String getDept1no() {
        return dept1no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPT1NO} attribute with the specified
     * value.
     *
     * @param dept1no new value for {@value #ATTRIBUTE_NAME_DEPT1NO} attribute.
     */
    protected void setDept1no(@Nonnull final String dept1no) {
        this.dept1no = dept1no;
    }

    // ------------------------------------------------------------------------------------ dept1nam

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPT1NAM} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPT1NAM} attribute.
     */
    @Nonnull
    public String getDept1nam() {
        return dept1nam;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPT1NAM} attribute with the specified
     * value.
     *
     * @param dept1nam new value for {@value #ATTRIBUTE_NAME_DEPT1NAM} attribute.
     */
    protected void setDept1nam(@Nonnull final String dept1nam) {
        this.dept1nam = dept1nam;
    }

    // -------------------------------------------------------------------------------------- emp1no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP1NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP1NO} attribute.
     */
    @Nullable
    public String getEmp1no() {
        return emp1no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP1NO} attribute with the specified
     * value.
     *
     * @param emp1no new value for {@value #ATTRIBUTE_NAME_EMP1NO} attribute.
     */
    protected void setEmp1no(@Nullable final String emp1no) {
        this.emp1no = emp1no;
    }

    // -------------------------------------------------------------------------------------- emp1fn

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP1FN} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP1FN} attribute.
     */
    @Nullable
    public String getEmp1fn() {
        return emp1fn;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP1FN} attribute with the specified
     * value.
     *
     * @param emp1fn new value for {@value #ATTRIBUTE_NAME_EMP1FN} attribute.
     */
    protected void setEmp1fn(@Nullable final String emp1fn) {
        this.emp1fn = emp1fn;
    }

    // -------------------------------------------------------------------------------------- emp1mi

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP1MI} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP1MI} attribute.
     */
    @Nullable
    public String getEmp1mi() {
        return emp1mi;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP1MI} attribute with the specified
     * value.
     *
     * @param emp1mi new value for {@value #ATTRIBUTE_NAME_EMP1MI} attribute.
     */
    protected void setEmp1mi(@Nullable final String emp1mi) {
        this.emp1mi = emp1mi;
    }

    // -------------------------------------------------------------------------------------- emp1ln

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP1LN} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP1LN} attribute.
     */
    @Nullable
    public String getEmp1ln() {
        return emp1ln;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP1LN} attribute with the specified
     * value.
     *
     * @param emp1ln new value for {@value #ATTRIBUTE_NAME_EMP1LN} attribute.
     */
    protected void setEmp1ln(@Nullable final String emp1ln) {
        this.emp1ln = emp1ln;
    }

    // --------------------------------------------------------------------------------------- type2

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_TYPE2} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_TYPE2} attribute.
     */
    @Nonnull
    public String getType2() {
        return type2;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_TYPE2} attribute with the specified value.
     *
     * @param type2 new value for {@value #ATTRIBUTE_NAME_TYPE2} attribute.
     */
    protected void setType2(@Nonnull final String type2) {
        this.type2 = type2;
    }

    // ------------------------------------------------------------------------------------- dept2no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPT2NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPT2NO} attribute.
     */
    @Nonnull
    public String getDept2no() {
        return dept2no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPT2NO} attribute with the specified
     * value.
     *
     * @param dept2no new value for {@value #ATTRIBUTE_NAME_DEPT2NO} attribute.
     */
    protected void setDept2no(@Nonnull final String dept2no) {
        this.dept2no = dept2no;
    }

    // ------------------------------------------------------------------------------------ dept2nam

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPT2NAM} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPT2NAM} attribute.
     */
    @Nonnull
    public String getDept2nam() {
        return dept2nam;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPT2NAM} attribute with the specified
     * value.
     *
     * @param dept2nam new value for {@value #ATTRIBUTE_NAME_DEPT2NAM} attribute.
     */
    protected void setDept2nam(@Nonnull final String dept2nam) {
        this.dept2nam = dept2nam;
    }

    // -------------------------------------------------------------------------------------- emp2no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP2NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP2NO} attribute.
     */
    @Nonnull
    public String getEmp2no() {
        return emp2no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP2NO} attribute with the specified
     * value.
     *
     * @param emp2no new value for {@value #ATTRIBUTE_NAME_EMP2NO} attribute.
     */
    protected void setEmp2no(@Nonnull final String emp2no) {
        this.emp2no = emp2no;
    }

    // -------------------------------------------------------------------------------------- emp2fn

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP2FN} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP2FN} attribute.
     */
    @Nonnull
    public String getEmp2fn() {
        return emp2fn;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP2FN} attribute with the specified
     * value.
     *
     * @param emp2fn new value for {@value #ATTRIBUTE_NAME_EMP2FN} attribute.
     */
    protected void setEmp2fn(@Nonnull final String emp2fn) {
        this.emp2fn = emp2fn;
    }

    // -------------------------------------------------------------------------------------- emp2mi

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP2MI} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP2MI} attribute.
     */
    @Nullable
    public String getEmp2mi() {
        return emp2mi;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP2MI} attribute with the specified
     * value.
     *
     * @param emp2mi new value for {@value #ATTRIBUTE_NAME_EMP2MI} attribute.
     */
    protected void setEmp2mi(@Nullable final String emp2mi) {
        this.emp2mi = emp2mi;
    }

    // -------------------------------------------------------------------------------------- emp2ln

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP2LN} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP2LN} attribute.
     */
    @Nonnull
    public String getEmp2ln() {
        return emp2ln;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP2LN} attribute with the specified
     * value.
     *
     * @param emp2ln new value for {@value #ATTRIBUTE_NAME_EMP2LN} attribute.
     */
    protected void setEmp2ln(@Nonnull final String emp2ln) {
        this.emp2ln = emp2ln;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPT1NO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPT1NO,
            nullable = COLUMN_NULLABLE_DEPT1NO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_DEPT1NO
    )
    private String dept1no;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPT1NAM)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPT1NAM,
            nullable = COLUMN_NULLABLE_DEPT1NAM,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPT1NAM
    )
    private String dept1nam;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_EMP1NO)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP1NO,
            nullable = COLUMN_NULLABLE_EMP1NO,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_EMP1NO
    )
    private String emp1no;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_EMP1FN)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP1FN,
            nullable = COLUMN_NULLABLE_EMP1FN,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_EMP1FN
    )
    private String emp1fn;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_EMP1MI)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP1MI,
            nullable = COLUMN_NULLABLE_EMP1MI,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_EMP1MI
    )
    private String emp1mi;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_EMP1LN)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP1LN,
            nullable = COLUMN_NULLABLE_EMP1LN,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_EMP1LN
    )
    private String emp1ln;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_TYPE2)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_TYPE2,
            nullable = COLUMN_NULLABLE_TYPE2,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_TYPE2
    )
    private String type2;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPT2NO)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPT2NO,
            nullable = COLUMN_NULLABLE_DEPT2NO,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPT2NO
    )
    private String dept2no;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_DEPT2NAM)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPT2NAM,
            nullable = COLUMN_NULLABLE_DEPT2NAM,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_DEPT2NAM
    )
    private String dept2nam;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMP2NO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP2NO,
            nullable = COLUMN_NULLABLE_EMP2NO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMP2NO
    )
    private String emp2no;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMP2FN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP2FN,
            nullable = COLUMN_NULLABLE_EMP2FN,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_EMP2FN
    )
    private String emp2fn;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_EMP2MI)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP2MI,
            nullable = COLUMN_NULLABLE_EMP2MI,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_EMP2MI
    )
    private String emp2mi;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMP2LN)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP2LN,
            nullable = COLUMN_NULLABLE_EMP2LN,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_EMP2LN
    )
    private String emp2ln;
}
