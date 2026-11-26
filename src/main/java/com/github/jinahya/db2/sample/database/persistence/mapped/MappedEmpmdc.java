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
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

/**
 * A mapped superclass which holds the mappings of the {@value MappedEmpmdc#TABLE_NAME} table, the
 * employees, by department and division, for multidimensional clustering.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key
 * by its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedEmpmdc {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "EMPMDC";

    // --------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMPNO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPNO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = "empno";

    // ---------------------------------------------------------------------------------------- DEPT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DEPT} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DEPT = "DEPT";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPT} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT = "dept";

    // ----------------------------------------------------------------------------------------- DIV

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_DIV} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_DIV = "DIV";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DIV} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_DIV = "div";

    // --------------------------------------------------------------------------------- SELECT_LIST

    /**
     * The columns of {@value #TABLE_NAME}, in their order, as the select list of a native query
     * whose rows an extending class is built from. The value is {@value}.
     */
    public static final String SELECT_LIST =
            COLUMN_NAME_EMPNO + ", "
            + COLUMN_NAME_DEPT + ", "
            + COLUMN_NAME_DIV;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedEmpmdc() {
        super();
    }

    /**
     * Creates a new instance with the specified values, in the order of {@link #SELECT_LIST}.
     *
     * @param empno a value for the {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     * @param dept  a value for the {@value #ATTRIBUTE_NAME_DEPT} attribute.
     * @param div   a value for the {@value #ATTRIBUTE_NAME_DIV} attribute.
     */
    protected MappedEmpmdc(
            final Integer empno,
            final Integer dept,
            final Integer div) {
        this();
        this.empno = empno;
        this.dept = dept;
        this.div = div;
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "empno=" + empno +
               ",dept=" + dept +
               ",div=" + div +
               '}';
    }

    // --------------------------------------------------------------------------------------- empno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    @Nonnull
    public Integer getEmpno() {
        return empno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute with the specified value.
     *
     * @param empno new value for {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    protected void setEmpno(@Nonnull final Integer empno) {
        this.empno = empno;
    }

    // ---------------------------------------------------------------------------------------- dept

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPT} attribute.
     */
    @Nullable
    public Integer getDept() {
        return dept;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPT} attribute with the specified value.
     *
     * @param dept new value for {@value #ATTRIBUTE_NAME_DEPT} attribute.
     */
    public void setDept(@Nullable final Integer dept) {
        this.dept = dept;
    }

    // ----------------------------------------------------------------------------------------- div

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DIV} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DIV} attribute.
     */
    @Nullable
    public Integer getDiv() {
        return div;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DIV} attribute with the specified value.
     *
     * @param div new value for {@value #ATTRIBUTE_NAME_DIV} attribute.
     */
    public void setDiv(@Nullable final Integer div) {
        this.div = div;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPNO,
            nullable = true,
            insertable = true,
            updatable = false
    )
    private Integer empno;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPT,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer dept;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DIV,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer div;
}
