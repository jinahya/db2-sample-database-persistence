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
 * An entity of the {@value #TABLE_NAME} view, which declares the identifier {@link MappedVpstrde1}
 * leaves out, with {@link Vpstrde1Id} as its {@link IdClass @IdClass}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@IdClass(Vpstrde1Id.class)
@Table(name = Vpstrde1.TABLE_NAME)
public class Vpstrde1
        extends MappedVpstrde1 {

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJ1NO} column, a part of the
     * identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ1NO = Vpstrde1Id.ATTRIBUTE_NAME_PROJ1NO;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJ2NO} column, a part of the
     * identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJ2NO = Vpstrde1Id.ATTRIBUTE_NAME_PROJ2NO;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Vpstrde1() {
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
     *         {@value #ATTRIBUTE_NAME_PROJ2NO}, the identifier.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Vpstrde1 that)) {
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
    @Size(max = SIZE_MAX_PROJ1NO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJ1NO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PROJ1NO
    )
    private String proj1no;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_PROJ2NO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJ2NO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PROJ2NO
    )
    private String proj2no;
}
