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
 * A superclass for the identifier of the {@value MappedVpstrde1#TABLE_NAME} view -- the logical,
 * not declared, key of {@value MappedVpstrde1#COLUMN_NAME_PROJ1NO},
 * {@value MappedVpstrde1#COLUMN_NAME_PROJ2NO}.
 * <p>
 * An entity extending {@link MappedVpstrde1} names a concrete subclass of this class with
 * {@link jakarta.persistence.IdClass @IdClass}; the attributes here have the names and the types of
 * the {@link jakarta.persistence.Id @Id} attributes there.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVpstrde1
 */
public abstract class MappedVpstrde1Id
        implements Serializable {

    /**
     * The serial version UID of this class. The value is {@value}.
     */
    private static final long serialVersionUID = 1L;

    // --------------------------------------------------------------------------------------------------------- PROJ1NO

    /**
     * The name of the attribute which maps the {@value MappedVpstrde1#COLUMN_NAME_PROJ1NO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ1NO = MappedVpstrde1.ATTRIBUTE_NAME_PROJ1NO;

    // --------------------------------------------------------------------------------------------------------- PROJ2NO

    /**
     * The name of the attribute which maps the {@value MappedVpstrde1#COLUMN_NAME_PROJ2NO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ2NO = MappedVpstrde1.ATTRIBUTE_NAME_PROJ2NO;

    // ------------------------------------------------------------------------------------------
    // STATIC_FACTORY_METHODS

    /**
     * Creates a new instance of a subclass, with the specified values.
     *
     * @param <T>          the type of the identifier.
     * @param instantiator a supplier of a new, empty instance of {@code T}.
     * @param proj1no      a value for the {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     * @param proj2no      a value for the {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     * @return the instance supplied by {@code instantiator}, with its attributes set.
     * @throws NullPointerException if {@code instantiator} is {@code null}, or it supplies
     *                              {@code null}.
     */
    protected static <T extends MappedVpstrde1Id> T of(
            final Supplier<? extends T> instantiator,
            final String proj1no,
            final String proj2no) {
        Objects.requireNonNull(instantiator, "instantiator is null");
        final var instance =
                Objects.requireNonNull(instantiator.get(), "instantiator.get() is null");
        instance.setProj1no(proj1no);
        instance.setProj2no(proj2no);
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVpstrde1Id() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "proj1no=" + proj1no +
               ",proj2no=" + proj2no +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PROJ1NO} and
     *         {@value #ATTRIBUTE_NAME_PROJ2NO}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVpstrde1Id that)) {
            return false;
        }
        return Objects.equals(getProj1no(), that.getProj1no())
               && Objects.equals(getProj2no(), that.getProj2no());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PROJ1NO} and
     *         {@value #ATTRIBUTE_NAME_PROJ2NO}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getProj1no(), getProj2no());
    }

    // --------------------------------------------------------------------------------------------------------- proj1no

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

    // --------------------------------------------------------------------------------------------------------- proj2no

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

    // -----------------------------------------------------------------------------------------------------------------
    private String proj1no;

    // -----------------------------------------------------------------------------------------------------------------
    private String proj2no;
}
