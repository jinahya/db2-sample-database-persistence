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

import com.github.jinahya.db2.sample.database.persistence.ProductSupplierId;
import jakarta.persistence.MappedSuperclass;

/**
 * A mapped superclass which holds the mappings of the {@value MappedProductSupplier#TABLE_NAME}
 * table, the suppliers of the products.
 * <p>
 * The primary key is composite, of {@value MappedProductSupplier#COLUMN_NAME_PID},
 * {@value MappedProductSupplier#COLUMN_NAME_SID}, which this class does not map: an extending
 * entity declares it, either as {@link jakarta.persistence.Id @Id} attributes with
 * {@link ProductSupplierId} as its {@link jakarta.persistence.IdClass @IdClass}, or as an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId} of {@link ProductSupplierId}, and with it its
 * {@code equals} and {@code hashCode}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see ProductSupplierId
 */
@MappedSuperclass
public abstract class MappedProductSupplier {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "PRODUCTSUPPLIER";

    // ----------------------------------------------------------------------------------------- PID

    /**
     * The name of the table column to which the {@value ProductSupplierId#ATTRIBUTE_NAME_PID}
     * attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_PID = "PID";

    /**
     * The length of the {@value #COLUMN_NAME_PID} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PID = 10;

    /**
     * The maximum size of the {@value ProductSupplierId#ATTRIBUTE_NAME_PID} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_PID = COLUMN_LENGTH_PID;

    // ----------------------------------------------------------------------------------------- SID

    /**
     * The name of the table column to which the {@value ProductSupplierId#ATTRIBUTE_NAME_SID}
     * attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_SID = "SID";

    /**
     * The length of the {@value #COLUMN_NAME_SID} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_SID = 10;

    /**
     * The maximum size of the {@value ProductSupplierId#ATTRIBUTE_NAME_SID} attribute. The value is
     * {@value}.
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
               '}';
    }
}
