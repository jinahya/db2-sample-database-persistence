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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedVpstrde1;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * The identifier of the {@value MappedVpstrde1#TABLE_NAME} view, the key of
 * {@value MappedVpstrde1#COLUMN_NAME_PROJ1NO}, {@value MappedVpstrde1#COLUMN_NAME_PROJ2NO}.
 * <p>
 * It is an {@link Embeddable @Embeddable}, so that an entity extending {@link MappedVpstrde1} may
 * name it either with {@link jakarta.persistence.IdClass @IdClass}, whose attributes have the names
 * and the types of the {@link jakarta.persistence.Id @Id} attributes there, or as the type of an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId}, which the column mappings here serve.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVpstrde1
 */
@Embeddable
public class Vpstrde1Id {

    // ------------------------------------------------------------------------------------- PROJ1NO

    /**
     * The name of the attribute which maps the {@value MappedVpstrde1#COLUMN_NAME_PROJ1NO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ1NO = "proj1no";

    // ------------------------------------------------------------------------------------- PROJ2NO

    /**
     * The name of the attribute which maps the {@value MappedVpstrde1#COLUMN_NAME_PROJ2NO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ2NO = "proj2no";

    // ---------------------------------------------------------------------- STATIC_FACTORY_METHODS

    /**
     * Returns a new instance with the specified values.
     *
     * @param proj1no a value for the {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     * @param proj2no a value for the {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     * @return a new instance with the specified values.
     */
    public static Vpstrde1Id of(final String proj1no, final String proj2no) {
        final var instance = new Vpstrde1Id();
        instance.setProj1no(proj1no);
        instance.setProj2no(proj2no);
        return instance;
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Vpstrde1Id() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

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
        if (!(obj instanceof Vpstrde1Id that)) {
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

    // ------------------------------------------------------------------------------------- proj1no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     */
    public String getProj1no() {
        return proj1no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJ1NO} attribute with the specified
     * value.
     *
     * @param proj1no new value for {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     */
    protected void setProj1no(final String proj1no) {
        this.proj1no = proj1no;
    }

    // ------------------------------------------------------------------------------------- proj2no

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     */
    public String getProj2no() {
        return proj2no;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJ2NO} attribute with the specified
     * value.
     *
     * @param proj2no new value for {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     */
    protected void setProj2no(final String proj2no) {
        this.proj2no = proj2no;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_PROJ1NO} attribute.
     */
    @Size(max = MappedVpstrde1.SIZE_MAX_PROJ1NO)
    @NotNull
    @Column(name = MappedVpstrde1.COLUMN_NAME_PROJ1NO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedVpstrde1.COLUMN_LENGTH_PROJ1NO
    )
    private String proj1no;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_PROJ2NO} attribute.
     */
    @Size(max = MappedVpstrde1.SIZE_MAX_PROJ2NO)
    @NotNull
    @Column(name = MappedVpstrde1.COLUMN_NAME_PROJ2NO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedVpstrde1.COLUMN_LENGTH_PROJ2NO
    )
    private String proj2no;
}
