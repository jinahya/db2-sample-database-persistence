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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedVastrde2;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * An entity of the {@value #TABLE_NAME} view, which declares the identifier {@link MappedVastrde2}
 * leaves out, with {@link Vastrde2Id} as its {@link IdClass @IdClass}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@IdClass(Vastrde2Id.class)
@Table(name = Vastrde2.TABLE_NAME)
public class Vastrde2
        extends MappedVastrde2 {

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_DEPT1NO} column, a part of the
     * identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT1NO = Vastrde2Id.ATTRIBUTE_NAME_DEPT1NO;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMP2NO} column, a part of the
     * identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP2NO = Vastrde2Id.ATTRIBUTE_NAME_EMP2NO;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Vastrde2() {
        super();
    }
    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "dept1no=" + dept1no +
               ",emp2no=" + emp2no +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_DEPT1NO} and
     *         {@value #ATTRIBUTE_NAME_EMP2NO}, the identifier.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Vastrde2 that)) {
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
    public String getDept1no() {
        return dept1no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPT1NO} attribute with the specified
     * value.
     *
     * @param dept1no new value for {@value #ATTRIBUTE_NAME_DEPT1NO} attribute.
     */
    protected void setDept1no(final String dept1no) {
        this.dept1no = dept1no;
    }

    // -------------------------------------------------------------------------------------- emp2no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMP2NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMP2NO} attribute.
     */
    public String getEmp2no() {
        return emp2no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMP2NO} attribute with the specified
     * value.
     *
     * @param emp2no new value for {@value #ATTRIBUTE_NAME_EMP2NO} attribute.
     */
    protected void setEmp2no(final String emp2no) {
        this.emp2no = emp2no;
    }

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_DEPT1NO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_DEPT1NO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_DEPT1NO
    )
    private String dept1no;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_EMP2NO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMP2NO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMP2NO
    )
    private String emp2no;
}
