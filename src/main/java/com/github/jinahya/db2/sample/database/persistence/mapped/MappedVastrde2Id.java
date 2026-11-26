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

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * A superclass for the identifier of the {@value MappedVastrde2#TABLE_NAME} view -- the logical,
 * not declared, key of {@value MappedVastrde2#COLUMN_NAME_DEPT1NO},
 * {@value MappedVastrde2#COLUMN_NAME_EMP2NO}.
 * <p>
 * An entity extending {@link MappedVastrde2} names a concrete subclass of this class with
 * {@link jakarta.persistence.IdClass @IdClass}; the attributes here have the names and the types of
 * the {@link jakarta.persistence.Id @Id} attributes there.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVastrde2
 */
public abstract class MappedVastrde2Id
        implements Serializable {

    /**
     * The serial version UID of this class. The value is {@value}.
     */
    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------------------------- DEPT1NO

    /**
     * The name of the attribute which maps the {@value MappedVastrde2#COLUMN_NAME_DEPT1NO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_DEPT1NO = MappedVastrde2.ATTRIBUTE_NAME_DEPT1NO;

    // -------------------------------------------------------------------------------------- EMP2NO

    /**
     * The name of the attribute which maps the {@value MappedVastrde2#COLUMN_NAME_EMP2NO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMP2NO = MappedVastrde2.ATTRIBUTE_NAME_EMP2NO;

    // ---------------------------------------------------------------------------------------------
    // STATIC_FACTORY_METHODS

    /**
     * Creates a new instance of a subclass, with the specified values.
     *
     * @param <T>          the type of the identifier.
     * @param instantiator a supplier of a new, empty instance of {@code T}.
     * @param dept1no      a value for the {@value #ATTRIBUTE_NAME_DEPT1NO} attribute.
     * @param emp2no       a value for the {@value #ATTRIBUTE_NAME_EMP2NO} attribute.
     * @return the instance supplied by {@code instantiator}, with its attributes set.
     * @throws NullPointerException if {@code instantiator} is {@code null}, or it supplies
     *                              {@code null}.
     */
    protected static <T extends MappedVastrde2Id> T of(
            final Supplier<? extends T> instantiator,
            final String dept1no,
            final String emp2no) {
        Objects.requireNonNull(instantiator, "instantiator is null");
        final var instance =
                Objects.requireNonNull(instantiator.get(), "instantiator.get() is null");
        instance.setDept1no(dept1no);
        instance.setEmp2no(emp2no);
        return instance;
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVastrde2Id() {
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
     *         {@value #ATTRIBUTE_NAME_EMP2NO}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVastrde2Id that)) {
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

    // ---------------------------------------------------------------------------------------------
    private String dept1no;

    // ---------------------------------------------------------------------------------------------
    private String emp2no;
}
