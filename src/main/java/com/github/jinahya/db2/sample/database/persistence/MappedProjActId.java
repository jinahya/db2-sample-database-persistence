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
import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * A superclass for the identifier of the {@value MappedProjAct#TABLE_NAME} table -- the key of
 * {@value MappedProjAct#COLUMN_NAME_PROJNO}, {@value MappedProjAct#COLUMN_NAME_ACTNO},
 * {@value MappedProjAct#COLUMN_NAME_ACSTDATE}.
 * <p>
 * An entity extending {@link MappedProjAct} names a concrete subclass of this class with
 * {@link jakarta.persistence.IdClass @IdClass}; the attributes here have the names and the types of
 * the {@link jakarta.persistence.Id @Id} attributes there.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedProjAct
 */
public abstract class MappedProjActId
        implements Serializable {

    /**
     * The serial version UID of this class. The value is {@value}.
     */
    private static final long serialVersionUID = 1L;

    // ---------------------------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the attribute which maps the {@value MappedProjAct#COLUMN_NAME_PROJNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNO = MappedProjAct.ATTRIBUTE_NAME_PROJNO;

    // ----------------------------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the attribute which maps the {@value MappedProjAct#COLUMN_NAME_ACTNO} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = MappedProjAct.ATTRIBUTE_NAME_ACTNO;

    // -------------------------------------------------------------------------------------------------------- ACSTDATE

    /**
     * The name of the attribute which maps the {@value MappedProjAct#COLUMN_NAME_ACSTDATE} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACSTDATE = MappedProjAct.ATTRIBUTE_NAME_ACSTDATE;

    // ------------------------------------------------------------------------------------------
    // STATIC_FACTORY_METHODS

    /**
     * Creates a new instance of a subclass, with the specified values.
     *
     * @param <T>          the type of the identifier.
     * @param instantiator a supplier of a new, empty instance of {@code T}.
     * @param projno       a value for the {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     * @param actno        a value for the {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     * @param acstdate     a value for the {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     * @return the instance supplied by {@code instantiator}, with its attributes set.
     * @throws NullPointerException if {@code instantiator} is {@code null}, or it supplies
     *                              {@code null}.
     */
    protected static <T extends MappedProjActId> T of(
            final Supplier<? extends T> instantiator,
            final String projno,
            final Short actno,
            final LocalDate acstdate) {
        Objects.requireNonNull(instantiator, "instantiator is null");
        final var instance =
                Objects.requireNonNull(instantiator.get(), "instantiator.get() is null");
        instance.setProjno(projno);
        instance.setActno(actno);
        instance.setAcstdate(acstdate);
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedProjActId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "projno=" + projno +
               ",actno=" + actno +
               ",acstdate=" + acstdate +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PROJNO} and
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_ACSTDATE}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedProjActId that)) {
            return false;
        }
        return Objects.equals(getProjno(), that.getProjno())
               && Objects.equals(getActno(), that.getActno())
               && Objects.equals(getAcstdate(), that.getAcstdate());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PROJNO} and
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_ACSTDATE}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getProjno(), getActno(), getAcstdate());
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

    // ----------------------------------------------------------------------------------------------------------- actno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    @Nonnull
    public Short getActno() {
        return actno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute with the specified value.
     *
     * @param actno new value for {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    protected void setActno(@Nonnull final Short actno) {
        this.actno = actno;
    }

    // -------------------------------------------------------------------------------------------------------- acstdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     */
    @Nonnull
    public LocalDate getAcstdate() {
        return acstdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute with the specified
     * value.
     *
     * @param acstdate new value for {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     */
    protected void setAcstdate(@Nonnull final LocalDate acstdate) {
        this.acstdate = acstdate;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String projno;

    // -----------------------------------------------------------------------------------------------------------------
    private Short actno;

    // -----------------------------------------------------------------------------------------------------------------
    private LocalDate acstdate;
}
