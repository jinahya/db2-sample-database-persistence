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
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedSupplier#TABLE_NAME} table, the
 * suppliers, each with an XML address.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedSupplier {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "SUPPLIERS";

    // ------------------------------------------------------------------------------------------------------------- SID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SID} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_SID = "SID";

    /**
     * Whether the {@value #COLUMN_NAME_SID} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SID = false;

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

    // ------------------------------------------------------------------------------------------------------------ ADDR

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ADDR} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_ADDR = "ADDR";

    /**
     * Whether the {@value #COLUMN_NAME_ADDR} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_ADDR = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ADDR} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ADDR = "addr";

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedSupplier() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "sid=" + sid +
               ",addr=" + (addr == null ? null : addr.length() + " char(s)") +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_SID} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedSupplier that)) {
            return false;
        }
        return Objects.equals(getSid(), that.getSid());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_SID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getSid());
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

    // ------------------------------------------------------------------------------------------------------------ addr

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ADDR} attribute, serialized; the column is
     * an XML.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ADDR} attribute.
     */
    @Nullable
    public String getAddr() {
        return addr;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ADDR} attribute with the specified value.
     *
     * @param addr new value for {@value #ATTRIBUTE_NAME_ADDR} attribute.
     */
    public void setAddr(@Nullable final String addr) {
        this.addr = addr;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_SID)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SID,
            nullable = COLUMN_NULLABLE_SID,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_SID
    )
    private String sid;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ADDR,
            nullable = COLUMN_NULLABLE_ADDR,
            insertable = true,
            updatable = true
    )
    private String addr;
}
