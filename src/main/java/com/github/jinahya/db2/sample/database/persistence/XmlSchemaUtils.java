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

import com.github.jinahya.db2.sample.database.persistence.xml.customer.Customerinfo;
import com.github.jinahya.db2.sample.database.persistence.xml.porder.PurchaseOrder;
import com.github.jinahya.db2.sample.database.persistence.xml.product.Product;
import com.github.jinahya.db2.sample.database.persistence.xml.supplier.Supplierinfo;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.util.Map;
import java.util.Objects;

/**
 * Utilities for the schemas of the {@code XML} columns, each loaded once from the XSD which sits
 * beside the classes bound to it.
 * <p>
 * A {@link Schema} is immutable and thread-safe, so the instance each method returns is shared;
 * create a {@link javax.xml.validation.Validator}, which is neither, from it for each use.
 * <pre>{@code
 * XmlSchemaUtils.customerinfo().newValidator().validate(new StreamSource(new StringReader(text)));
 * }</pre>
 * Db2 does not enforce these schemas when a document is written, and the bound classes do not
 * validate either; this is for whoever needs to.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
public final class XmlSchemaUtils {

    // the XSD beside each bound class, which Db2 registers for the column
    private static final Map<Class<?>, String> NAMES = Map.of(
            Customerinfo.class, "customer.xsd",
            Product.class, "product.xsd",
            PurchaseOrder.class, "porder.xsd",
            Supplierinfo.class, "supplier.xsd"
    );

    // a schema is costly to load; one per bound class, loaded when it is first asked for
    private static final ClassValue<Schema> SCHEMAS = new ClassValue<>() {
        @Override
        protected Schema computeValue(final Class<?> type) {
            final var name = NAMES.get(type);
            final var resource = type.getResource(name);
            if (resource == null) {
                throw new IllegalStateException("no " + name + " beside " + type);
            }
            final var factory = SchemaFactory.newDefaultInstance();
            try {
                factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
                // none of the XSDs imports or includes another
                factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
                factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
                return factory.newSchema(resource);
            } catch (final SAXException se) {
                throw new IllegalStateException("failed to load " + resource, se);
            }
        }
    };

    // ---------------------------------------------------------------------------------------------

    /**
     * Returns the schema of the specified class bound to it.
     *
     * @param boundClass the class bound to the schema; one of {@link Customerinfo},
     *                   {@link Product}, {@link PurchaseOrder} and {@link Supplierinfo}.
     * @return the schema of {@code boundClass}.
     * @throws IllegalArgumentException if {@code boundClass} is not bound to a schema here.
     */
    public static Schema of(final Class<?> boundClass) {
        Objects.requireNonNull(boundClass, "boundClass is null");
        if (!NAMES.containsKey(boundClass)) {
            throw new IllegalArgumentException("no schema for " + boundClass);
        }
        return SCHEMAS.get(boundClass);
    }

    /**
     * Returns the schema of the {@code CUSTOMER.INFO} column, {@code customer.xsd}.
     *
     * @return the schema of the {@code CUSTOMER.INFO} column.
     */
    public static Schema customerinfo() {
        return of(Customerinfo.class);
    }

    /**
     * Returns the schema of the {@code PRODUCT.DESCRIPTION} column, {@code product.xsd}.
     *
     * @return the schema of the {@code PRODUCT.DESCRIPTION} column.
     */
    public static Schema product() {
        return of(Product.class);
    }

    /**
     * Returns the schema of the {@code PURCHASEORDER.PORDER} column, {@code porder.xsd}.
     *
     * @return the schema of the {@code PURCHASEORDER.PORDER} column.
     */
    public static Schema purchaseOrder() {
        return of(PurchaseOrder.class);
    }

    /**
     * Returns the schema of the {@code SUPPLIERS.ADDR} column, {@code supplier.xsd}.
     *
     * @return the schema of the {@code SUPPLIERS.ADDR} column.
     */
    public static Schema supplierinfo() {
        return of(Supplierinfo.class);
    }

    // ---------------------------------------------------------------------------------------------
    private XmlSchemaUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}

