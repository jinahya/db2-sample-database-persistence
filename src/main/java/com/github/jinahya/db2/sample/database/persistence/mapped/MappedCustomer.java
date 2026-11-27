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

import com.github.jinahya.db2.sample.database.persistence.CustomerinfoStringAttributeConverter;
import com.github.jinahya.db2.sample.database.persistence.xml.customer.Customerinfo;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedCustomer#TABLE_NAME} table, the
 * customers, each with an XML document of information and one of history.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedCustomer {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "CUSTOMER";

    // ----------------------------------------------------------------------------------------- CID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_CID} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_CID = "CID";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_CID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_CID = "cid";

    // ---------------------------------------------------------------------------------------- INFO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_INFO} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_INFO = "INFO";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_INFO} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_INFO = "info";

    // ------------------------------------------------------------------------------------- HISTORY

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_HISTORY} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_HISTORY = "HISTORY";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_HISTORY} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_HISTORY = "history";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedCustomer() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "cid=" + cid +
               ",info=" + info +
               ",history=" + (history == null ? null : history.length() + " char(s)") +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_CID} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedCustomer that)) {
            return false;
        }
        return Objects.equals(getCid(), that.getCid());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_CID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getCid());
    }

    // ----------------------------------------------------------------------------------------- cid

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_CID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_CID} attribute.
     */
    @Nonnull
    public Long getCid() {
        return cid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_CID} attribute with the specified value.
     *
     * @param cid new value for {@value #ATTRIBUTE_NAME_CID} attribute.
     */
    public void setCid(@Nonnull final Long cid) {
        this.cid = cid;
    }

    // ---------------------------------------------------------------------------------------- info

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_INFO} attribute; the column is an XML, bound
     * to {@link Customerinfo}.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_INFO} attribute.
     */
    @Nullable
    public Customerinfo getInfo() {
        return info;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_INFO} attribute with the specified value.
     *
     * @param info new value for {@value #ATTRIBUTE_NAME_INFO} attribute.
     */
    public void setInfo(@Nullable final Customerinfo info) {
        this.info = info;
    }

    // ------------------------------------------------------------------------------------- history

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_HISTORY} attribute, serialized; the column
     * is an XML.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_HISTORY} attribute.
     */
    @Nullable
    public String getHistory() {
        return history;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_HISTORY} attribute with the specified
     * value.
     *
     * @param history new value for {@value #ATTRIBUTE_NAME_HISTORY} attribute.
     */
    public void setHistory(@Nullable final String history) {
        this.history = history;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_CID,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Long cid;

    // ---------------------------------------------------------------------------------------------
    @Convert(converter = CustomerinfoStringAttributeConverter.class)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_INFO,
            nullable = true,
            insertable = true,
            updatable = true,
            length = 1048576 // just for H2
            )
    private Customerinfo info;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_HISTORY,
            nullable = true,
            insertable = true,
            updatable = true,
            length = 1048576 // just for H2
            )
    private String history;
}
