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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedProduct;
import com.github.jinahya.db2.sample.database.persistence.mapped.MappedProductsupplier;
import com.github.jinahya.db2.sample.database.persistence.mapped.MappedSupplier;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Optional;

/**
 * The identifier of the {@value MappedProductsupplier#TABLE_NAME} table, the key of
 * {@value MappedProductsupplier#COLUMN_NAME_PID}, {@value MappedProductsupplier#COLUMN_NAME_SID}.
 * <p>
 * It is an {@link Embeddable @Embeddable}, so that an entity extending
 * {@link MappedProductsupplier} may name it either with
 * {@link jakarta.persistence.IdClass @IdClass}, whose attributes have the names and the types of
 * the {@link jakarta.persistence.Id @Id} attributes there, or as the type of an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId}, which the column mappings here serve.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedProductsupplier
 */
@Embeddable
public class ProductsupplierId {

    // ----------------------------------------------------------------------------------------- PID

    /**
     * The name of the attribute which maps the {@value MappedProductsupplier#COLUMN_NAME_PID}
     * column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PID = "pid";

    // ----------------------------------------------------------------------------------------- SID

    /**
     * The name of the attribute which maps the {@value MappedProductsupplier#COLUMN_NAME_SID}
     * column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_SID = "sid";

    // ---------------------------------------------------------------------- STATIC_FACTORY_METHODS

    /**
     * Returns a new instance with the specified values.
     *
     * @param pid a value for the {@value #ATTRIBUTE_NAME_PID} attribute.
     * @param sid a value for the {@value #ATTRIBUTE_NAME_SID} attribute.
     * @return a new instance with the specified values.
     */
    public static ProductsupplierId of(final String pid, final String sid) {
        return new ProductsupplierId().withPid(pid).withSid(sid);
    }

    /**
     * Returns a new instance with the product id of the specified product, and the supplier id of
     * the specified supplier.
     *
     * @param product  the product whose product id is the {@value #ATTRIBUTE_NAME_PID} attribute;
     *                 {@code null} for none.
     * @param supplier the supplier whose supplier id is the {@value #ATTRIBUTE_NAME_SID} attribute;
     *                 {@code null} for none.
     * @return a new instance with the product id of {@code product} and the supplier id of
     *         {@code supplier}.
     */
    public static ProductsupplierId from(final MappedProduct product,
                                         final MappedSupplier supplier) {
        return of(
                Optional.ofNullable(product).map(MappedProduct::getPid).orElse(null),
                Optional.ofNullable(supplier).map(MappedSupplier::getSid).orElse(null)
        );
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public ProductsupplierId() {
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
     *         {@value #ATTRIBUTE_NAME_SID}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof ProductsupplierId that)) {
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
    public String getPid() {
        return pid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PID} attribute with the specified value.
     *
     * @param pid new value for {@value #ATTRIBUTE_NAME_PID} attribute.
     */
    protected void setPid(final String pid) {
        this.pid = pid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PID} attribute with the specified value,
     * and returns this instance.
     *
     * @param pid new value for {@value #ATTRIBUTE_NAME_PID} attribute.
     * @return this instance.
     */
    ProductsupplierId withPid(final String pid) {
        setPid(pid);
        return this;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PID} attribute with the product id of the
     * specified product, and returns this instance.
     *
     * @param product the product whose product id is the {@value #ATTRIBUTE_NAME_PID} attribute;
     *        {@code null} for none.
     * @return this instance.
     */
    ProductsupplierId withProduct(@Nullable final MappedProduct product) {
        return withPid(
                Optional.ofNullable(product)
                        .map(MappedProduct::getPid)
                        .orElse(null)
        );
    }

    // ----------------------------------------------------------------------------------------- sid

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SID} attribute.
     */
    public String getSid() {
        return sid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SID} attribute with the specified value.
     *
     * @param sid new value for {@value #ATTRIBUTE_NAME_SID} attribute.
     */
    protected void setSid(final String sid) {
        this.sid = sid;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SID} attribute with the specified value,
     * and returns this instance.
     *
     * @param sid new value for {@value #ATTRIBUTE_NAME_SID} attribute.
     * @return this instance.
     */
    ProductsupplierId withSid(final String sid) {
        setSid(sid);
        return this;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SID} attribute with the supplier id of the
     * specified supplier, and returns this instance.
     *
     * @param supplier the supplier whose supplier id is the {@value #ATTRIBUTE_NAME_SID} attribute;
     *        {@code null} for none.
     * @return this instance.
     */
    ProductsupplierId withSupplier(@Nullable final MappedSupplier supplier) {
        return withSid(
                Optional.ofNullable(supplier)
                        .map(MappedSupplier::getSid)
                        .orElse(null)
        );
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_PID} attribute.
     */
    @Size(max = MappedProductsupplier.SIZE_MAX_PID)
    @NotNull
    @Column(name = MappedProductsupplier.COLUMN_NAME_PID,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedProductsupplier.COLUMN_LENGTH_PID
    )
    private String pid;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_SID} attribute.
     */
    @Size(max = MappedProductsupplier.SIZE_MAX_SID)
    @NotNull
    @Column(name = MappedProductsupplier.COLUMN_NAME_SID,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedProductsupplier.COLUMN_LENGTH_SID
    )
    private String sid;
}
