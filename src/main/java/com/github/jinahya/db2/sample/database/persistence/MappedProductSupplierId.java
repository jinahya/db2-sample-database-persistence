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

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * A superclass for the identifier of the {@value MappedProductSupplier#TABLE_NAME} table -- the key of {@value
 * MappedProductSupplier#COLUMN_NAME_PID}, {@value MappedProductSupplier#COLUMN_NAME_SID}.
 * <p>
 * An entity extending {@link MappedProductSupplier} names a concrete subclass of this class with {@link
 * jakarta.persistence.IdClass @IdClass}; the attributes here have the names and the types of the {@link
 * jakarta.persistence.Id @Id} attributes there.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedProductSupplier
 */
public abstract class MappedProductSupplierId implements Serializable {

    /**
     * The serial version UID of this class. The value is {@value}.
     */
    private static final long serialVersionUID = 1L;

    // ------------------------------------------------------------------------------------------------------------- PID

    /**
     * The name of the attribute which maps the {@value MappedProductSupplier#COLUMN_NAME_PID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PID = MappedProductSupplier.ATTRIBUTE_NAME_PID;

    // ------------------------------------------------------------------------------------------------------------- SID

    /**
     * The name of the attribute which maps the {@value MappedProductSupplier#COLUMN_NAME_SID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SID = MappedProductSupplier.ATTRIBUTE_NAME_SID;

    // ------------------------------------------------------------------------------------------ STATIC_FACTORY_METHODS

    /**
     * Creates a new instance of a subclass, with the specified values.
     *
     * @param <T> the type of the identifier.
     * @param instantiator a supplier of a new, empty instance of {@code T}.
     * @param pid a value for the {@value #ATTRIBUTE_NAME_PID} attribute.
     * @param sid a value for the {@value #ATTRIBUTE_NAME_SID} attribute.
     * @return the instance supplied by {@code instantiator}, with its attributes set.
     * @throws NullPointerException if {@code instantiator} is {@code null}, or it supplies {@code null}.
     */
    protected static <T extends MappedProductSupplierId> T of(
            final Supplier<? extends T> instantiator,
            final String pid,
            final String sid) {
        Objects.requireNonNull(instantiator, "instantiator is null");
        final var instance = Objects.requireNonNull(instantiator.get(), "instantiator.get() is null");
        instance.setPid(pid);
        instance.setSid(sid);
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedProductSupplierId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "pid=" + pid +
               ",sid=" + sid +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PID} and {@value #ATTRIBUTE_NAME_SID}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedProductSupplierId that)) {
            return false;
        }
        return Objects.equals(getPid(), that.getPid())
               && Objects.equals(getSid(), that.getSid());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PID} and {@value #ATTRIBUTE_NAME_SID}, consistent with {@link
     * #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getPid(), getSid());
    }

    // ------------------------------------------------------------------------------------------------------------- pid

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PID} attribute.
     */
    @Nonnull
    public String getPid() {
        return pid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PID} attribute with the specified value.
     *
     * @param pid new value for {@value #ATTRIBUTE_NAME_PID} attribute.
     */
    protected void setPid(@Nonnull final String pid) {
        this.pid = pid;
    }

    // ------------------------------------------------------------------------------------------------------------- sid

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SID} attribute.
     */
    @Nonnull
    public String getSid() {
        return sid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SID} attribute with the specified value.
     *
     * @param sid new value for {@value #ATTRIBUTE_NAME_SID} attribute.
     */
    protected void setSid(@Nonnull final String sid) {
        this.sid = sid;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String pid;

    // -----------------------------------------------------------------------------------------------------------------
    private String sid;
}
