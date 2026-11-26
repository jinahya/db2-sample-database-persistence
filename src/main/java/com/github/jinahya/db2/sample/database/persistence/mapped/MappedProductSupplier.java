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
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedProductSupplier#TABLE_NAME}
 * table, the suppliers of the products.
 * <p>
 * The primary key is composite, of {@value MappedProductSupplier#COLUMN_NAME_PID},
 * {@value MappedProductSupplier#COLUMN_NAME_SID}, mapped with an
 * {@link jakarta.persistence.IdClass @IdClass}: an extending entity names a subclass of
 * {@link MappedProductSupplierId} with {@code @IdClass} and inherits the {@link Id @Id} attributes
 * from here.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedProductSupplierId
 */
@MappedSuperclass
public abstract class MappedProductSupplier {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "PRODUCTSUPPLIER";

    // ----------------------------------------------------------------------------------------- PID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PID} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PID = "PID";

    /**
     * The length of the {@value #COLUMN_NAME_PID} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PID = 10;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PID = "pid";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PID} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PID = COLUMN_LENGTH_PID;

    // ----------------------------------------------------------------------------------------- SID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SID} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_SID = "SID";

    /**
     * The length of the {@value #COLUMN_NAME_SID} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_SID = 10;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_SID = "sid";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_SID} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_SID = COLUMN_LENGTH_SID;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedProductSupplier() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

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
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PID} and
     *         {@value #ATTRIBUTE_NAME_SID} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedProductSupplier that)) {
            return false;
        }
        return Objects.equals(getPid(), that.getPid())
               && Objects.equals(getSid(), that.getSid());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PID} and
     *         {@value #ATTRIBUTE_NAME_SID}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getPid(), getSid());
    }

    // ----------------------------------------------------------------------------------------- pid

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

    // ----------------------------------------------------------------------------------------- sid

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

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_PID)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PID,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PID
    )
    private String pid;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_SID)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SID,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_SID
    )
    private String sid;
}
