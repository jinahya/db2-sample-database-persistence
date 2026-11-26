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

import com.github.jinahya.db2.sample.database.persistence.PurchaseOrderStringAttributeConverter;
import com.github.jinahya.db2.sample.database.persistence.xml.porder.PurchaseOrder;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedPurchaseOrder#TABLE_NAME}
 * table, the purchase orders, each with an XML document.
 * <p>
 * The foreign key column {@value MappedPurchaseOrder#COLUMN_NAME_CUSTID} is mapped read-only
 * ({@code insertable = false, updatable = false}), with a {@code protected} getter and no setter,
 * for {@link #toString()} and for queries. How the relationship behind it is mapped is the
 * extending entity's decision, so the extending entity also owns the writable mapping, by an
 * association's {@link jakarta.persistence.JoinColumn @JoinColumn}. <strong>An extending entity
 * which maps it not never writes it.</strong> For the same reason it is constrained {@code NotNull}
 * here, even where the column is {@code NOT NULL}: the attribute stays {@code null} until a load,
 * and the association is what is constrained.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedPurchaseOrder {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "PURCHASEORDER";

    // ---------------------------------------------------------------------------------------- POID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_POID} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_POID = "POID";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_POID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_POID = "poid";

    // -------------------------------------------------------------------------------------- STATUS

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_STATUS} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_STATUS = "STATUS";

    /**
     * The length of the {@value #COLUMN_NAME_STATUS} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_STATUS = 10;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_STATUS} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_STATUS = "status";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_STATUS} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_STATUS = COLUMN_LENGTH_STATUS;

    // -------------------------------------------------------------------------------------- CUSTID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_CUSTID} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_CUSTID = "CUSTID";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_CUSTID} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_CUSTID = "custid";

    // ----------------------------------------------------------------------------------- ORDERDATE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_ORDERDATE} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_ORDERDATE = "ORDERDATE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ORDERDATE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_ORDERDATE = "orderdate";

    // -------------------------------------------------------------------------------------- PORDER

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PORDER} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_PORDER = "PORDER";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PORDER} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_PORDER = "porder";

    // ------------------------------------------------------------------------------------ COMMENTS

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_COMMENTS} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_COMMENTS = "COMMENTS";

    /**
     * The length of the {@value #COLUMN_NAME_COMMENTS} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_COMMENTS = 1000;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_COMMENTS} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_COMMENTS = "comments";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_COMMENTS} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_COMMENTS = COLUMN_LENGTH_COMMENTS;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedPurchaseOrder() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "poid=" + poid +
               ",status=" + status +
               ",custid=" + custid +
               ",orderdate=" + orderdate +
               ",porder=" + porder +
               ",comments=" + comments +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_POID} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedPurchaseOrder that)) {
            return false;
        }
        return Objects.equals(getPoid(), that.getPoid());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_POID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getPoid());
    }

    // ---------------------------------------------------------------------------------------- poid

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_POID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_POID} attribute.
     */
    @Nonnull
    public Long getPoid() {
        return poid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_POID} attribute with the specified value.
     *
     * @param poid new value for {@value #ATTRIBUTE_NAME_POID} attribute.
     */
    protected void setPoid(@Nonnull final Long poid) {
        this.poid = poid;
    }

    // -------------------------------------------------------------------------------------- status

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_STATUS} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_STATUS} attribute.
     */
    @Nonnull
    public String getStatus() {
        return status;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_STATUS} attribute with the specified
     * value.
     *
     * @param status new value for {@value #ATTRIBUTE_NAME_STATUS} attribute.
     */
    public void setStatus(@Nonnull final String status) {
        this.status = status;
    }

    // -------------------------------------------------------------------------------------- custid

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_CUSTID} attribute with the specified
     * value.
     *
     * @param custid new value for {@value #ATTRIBUTE_NAME_CUSTID} attribute.
     * @apiNote The column is mapped read-only here, and written through the association of
     *         an extending entity, whose setter calls this, so that this attribute stays consistent
     *         with the association.
     */
    protected void setCustid(@Nullable final Long custid) {
        this.custid = custid;
    }

    // ----------------------------------------------------------------------------------- orderdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ORDERDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ORDERDATE} attribute.
     */
    @Nullable
    public LocalDate getOrderdate() {
        return orderdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ORDERDATE} attribute with the specified
     * value.
     *
     * @param orderdate new value for {@value #ATTRIBUTE_NAME_ORDERDATE} attribute.
     */
    public void setOrderdate(@Nullable final LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    // -------------------------------------------------------------------------------------- porder

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PORDER} attribute; the column is an XML,
     * bound to {@link PurchaseOrder}.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PORDER} attribute.
     */
    @Nullable
    public PurchaseOrder getPorder() {
        return porder;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PORDER} attribute with the specified
     * value.
     *
     * @param porder new value for {@value #ATTRIBUTE_NAME_PORDER} attribute.
     */
    public void setPorder(@Nullable final PurchaseOrder porder) {
        this.porder = porder;
    }

    // ------------------------------------------------------------------------------------ comments

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_COMMENTS} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_COMMENTS} attribute.
     */
    @Nullable
    public String getComments() {
        return comments;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_COMMENTS} attribute with the specified
     * value.
     *
     * @param comments new value for {@value #ATTRIBUTE_NAME_COMMENTS} attribute.
     */
    public void setComments(@Nullable final String comments) {
        this.comments = comments;
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_POID,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Long poid;

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_STATUS)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_STATUS,
            nullable = false,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_STATUS
    )
    private String status;

    // ---------------------------------------------------------------------------------------------
    // read-only: the extending entity owns the writable mapping of this column; see the class
    // documentation
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_CUSTID,
            nullable = true,
            insertable = false,
            updatable = false
    )
    private Long custid;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ORDERDATE,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private LocalDate orderdate;

    // ---------------------------------------------------------------------------------------------
    @Convert(converter = PurchaseOrderStringAttributeConverter.class)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PORDER,
            nullable = true,
            insertable = true,
            updatable = true,
            length = 1048576 // just for H2
            )
    private PurchaseOrder porder;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_COMMENTS)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_COMMENTS,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_COMMENTS
    )
    private String comments;
}
