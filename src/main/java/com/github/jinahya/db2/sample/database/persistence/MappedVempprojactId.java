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
 * A superclass for the identifier of the {@value MappedVempprojact#TABLE_NAME} view -- the logical,
 * not declared, key of {@value MappedVempprojact#COLUMN_NAME_EMPNO},
 * {@value MappedVempprojact#COLUMN_NAME_PROJNO}, {@value MappedVempprojact#COLUMN_NAME_ACTNO},
 * {@value MappedVempprojact#COLUMN_NAME_EMSTDATE}.
 * <p>
 * An entity extending {@link MappedVempprojact} names a concrete subclass of this class with
 * {@link jakarta.persistence.IdClass @IdClass}; the attributes here have the names and the types of
 * the {@link jakarta.persistence.Id @Id} attributes there.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVempprojact
 */
public abstract class MappedVempprojactId
        implements Serializable {

    /**
     * The serial version UID of this class. The value is {@value}.
     */
    private static final long serialVersionUID = 1L;

    // ----------------------------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the attribute which maps the {@value MappedVempprojact#COLUMN_NAME_EMPNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = MappedVempprojact.ATTRIBUTE_NAME_EMPNO;

    // ---------------------------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the attribute which maps the {@value MappedVempprojact#COLUMN_NAME_PROJNO}
     * column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNO = MappedVempprojact.ATTRIBUTE_NAME_PROJNO;

    // ----------------------------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the attribute which maps the {@value MappedVempprojact#COLUMN_NAME_ACTNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = MappedVempprojact.ATTRIBUTE_NAME_ACTNO;

    // -------------------------------------------------------------------------------------------------------- EMSTDATE

    /**
     * The name of the attribute which maps the {@value MappedVempprojact#COLUMN_NAME_EMSTDATE}
     * column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMSTDATE = MappedVempprojact.ATTRIBUTE_NAME_EMSTDATE;

    // ------------------------------------------------------------------------------------------
    // STATIC_FACTORY_METHODS

    /**
     * Creates a new instance of a subclass, with the specified values.
     *
     * @param <T>          the type of the identifier.
     * @param instantiator a supplier of a new, empty instance of {@code T}.
     * @param empno        a value for the {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     * @param projno       a value for the {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     * @param actno        a value for the {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     * @param emstdate     a value for the {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     * @return the instance supplied by {@code instantiator}, with its attributes set.
     * @throws NullPointerException if {@code instantiator} is {@code null}, or it supplies
     *                              {@code null}.
     */
    protected static <T extends MappedVempprojactId> T of(
            final Supplier<? extends T> instantiator,
            final String empno,
            final String projno,
            final Short actno,
            final LocalDate emstdate) {
        Objects.requireNonNull(instantiator, "instantiator is null");
        final var instance =
                Objects.requireNonNull(instantiator.get(), "instantiator.get() is null");
        instance.setEmpno(empno);
        instance.setProjno(projno);
        instance.setActno(actno);
        instance.setEmstdate(emstdate);
        return instance;
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedVempprojactId() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "empno=" + empno +
               ",projno=" + projno +
               ",actno=" + actno +
               ",emstdate=" + emstdate +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPNO} and
     *         {@value #ATTRIBUTE_NAME_PROJNO} and {@value #ATTRIBUTE_NAME_ACTNO} and
     *         {@value #ATTRIBUTE_NAME_EMSTDATE}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedVempprojactId that)) {
            return false;
        }
        return Objects.equals(getEmpno(), that.getEmpno())
               && Objects.equals(getProjno(), that.getProjno())
               && Objects.equals(getActno(), that.getActno())
               && Objects.equals(getEmstdate(), that.getEmstdate());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_EMPNO} and
     *         {@value #ATTRIBUTE_NAME_PROJNO} and {@value #ATTRIBUTE_NAME_ACTNO} and
     *         {@value #ATTRIBUTE_NAME_EMSTDATE}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getEmpno(), getProjno(), getActno(), getEmstdate());
    }

    // ----------------------------------------------------------------------------------------------------------- empno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    @Nonnull
    public String getEmpno() {
        return empno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute with the specified value.
     *
     * @param empno new value for {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    protected void setEmpno(@Nonnull final String empno) {
        this.empno = empno;
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

    // -------------------------------------------------------------------------------------------------------- emstdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     */
    @Nonnull
    public LocalDate getEmstdate() {
        return emstdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMSTDATE} attribute with the specified
     * value.
     *
     * @param emstdate new value for {@value #ATTRIBUTE_NAME_EMSTDATE} attribute.
     */
    protected void setEmstdate(@Nonnull final LocalDate emstdate) {
        this.emstdate = emstdate;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private String empno;

    // -----------------------------------------------------------------------------------------------------------------
    private String projno;

    // -----------------------------------------------------------------------------------------------------------------
    private Short actno;

    // -----------------------------------------------------------------------------------------------------------------
    private LocalDate emstdate;
}
