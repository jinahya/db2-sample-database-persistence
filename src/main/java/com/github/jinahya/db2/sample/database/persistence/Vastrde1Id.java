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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedVastrde1;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * The identifier of the {@value MappedVastrde1#TABLE_NAME} view, the key of
 * {@value MappedVastrde1#COLUMN_NAME_DEPT1NO}, {@value MappedVastrde1#COLUMN_NAME_DEPT2NO}.
 * <p>
 * It is an {@link Embeddable @Embeddable}, so that an entity extending {@link MappedVastrde1} may
 * name it either with {@link jakarta.persistence.IdClass @IdClass}, whose attributes have the names
 * and the types of the {@link jakarta.persistence.Id @Id} attributes there, or as the type of an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId}, which the column mappings here serve.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVastrde1
 */
@Embeddable
public class Vastrde1Id {

    // ------------------------------------------------------------------------------------- DEPT1NO

    /**
     * The name of the attribute which maps the {@value MappedVastrde1#COLUMN_NAME_DEPT1NO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT1NO = "dept1no";

    // ------------------------------------------------------------------------------------- DEPT2NO

    /**
     * The name of the attribute which maps the {@value MappedVastrde1#COLUMN_NAME_DEPT2NO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT2NO = "dept2no";

    // ---------------------------------------------------------------------- STATIC_FACTORY_METHODS

    /**
     * Returns a new instance with the specified values.
     *
     * @param dept1no a value for the {@value #ATTRIBUTE_NAME_DEPT1NO} attribute.
     * @param dept2no a value for the {@value #ATTRIBUTE_NAME_DEPT2NO} attribute.
     * @return a new instance with the specified values.
     */
    public static Vastrde1Id of(final String dept1no, final String dept2no) {
        final var instance = new Vastrde1Id();
        instance.setDept1no(dept1no);
        instance.setDept2no(dept2no);
        return instance;
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Vastrde1Id() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "dept1no=" + dept1no +
               ",dept2no=" + dept2no +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_DEPT1NO} and
     *         {@value #ATTRIBUTE_NAME_DEPT2NO}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Vastrde1Id that)) {
            return false;
        }
        return Objects.equals(getDept1no(), that.getDept1no())
               && Objects.equals(getDept2no(), that.getDept2no());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_DEPT1NO} and
     *         {@value #ATTRIBUTE_NAME_DEPT2NO}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getDept1no(), getDept2no());
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

    // ------------------------------------------------------------------------------------- dept2no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_DEPT2NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_DEPT2NO} attribute.
     */
    public String getDept2no() {
        return dept2no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_DEPT2NO} attribute with the specified
     * value.
     *
     * @param dept2no new value for {@value #ATTRIBUTE_NAME_DEPT2NO} attribute.
     */
    protected void setDept2no(final String dept2no) {
        this.dept2no = dept2no;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_DEPT1NO} attribute.
     */
    @Size(max = MappedVastrde1.SIZE_MAX_DEPT1NO)
    @NotNull
    @Column(name = MappedVastrde1.COLUMN_NAME_DEPT1NO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedVastrde1.COLUMN_LENGTH_DEPT1NO
    )
    private String dept1no;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_DEPT2NO} attribute.
     */
    @Size(max = MappedVastrde1.SIZE_MAX_DEPT2NO)
    @NotNull
    @Column(name = MappedVastrde1.COLUMN_NAME_DEPT2NO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedVastrde1.COLUMN_LENGTH_DEPT2NO
    )
    private String dept2no;
}
