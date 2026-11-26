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
 * A mapped superclass which holds the mappings of the {@value MappedInventory#TABLE_NAME} table,
 * the inventory of the products.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedInventory {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "INVENTORY";

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

    // ------------------------------------------------------------------------------------ QUANTITY

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_QUANTITY} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_QUANTITY = "QUANTITY";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_QUANTITY} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_QUANTITY = "quantity";

    // ------------------------------------------------------------------------------------ LOCATION

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_LOCATION} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_LOCATION = "LOCATION";

    /**
     * The length of the {@value #COLUMN_NAME_LOCATION} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_LOCATION = 128;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_LOCATION} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_LOCATION = "location";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_LOCATION} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_LOCATION = COLUMN_LENGTH_LOCATION;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedInventory() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "pid=" + pid +
               ",quantity=" + quantity +
               ",location=" + location +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PID} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedInventory that)) {
            return false;
        }
        return Objects.equals(getPid(), that.getPid());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getPid());
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

    // ------------------------------------------------------------------------------------ quantity

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_QUANTITY} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_QUANTITY} attribute.
     */
    @Nullable
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_QUANTITY} attribute with the specified
     * value.
     *
     * @param quantity new value for {@value #ATTRIBUTE_NAME_QUANTITY} attribute.
     */
    public void setQuantity(@Nullable final Integer quantity) {
        this.quantity = quantity;
    }

    // ------------------------------------------------------------------------------------ location

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     */
    @Nullable
    public String getLocation() {
        return location;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_LOCATION} attribute with the specified
     * value.
     *
     * @param location new value for {@value #ATTRIBUTE_NAME_LOCATION} attribute.
     */
    public void setLocation(@Nullable final String location) {
        this.location = location;
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
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_QUANTITY,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer quantity;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_LOCATION)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LOCATION,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_LOCATION
    )
    private String location;
}
