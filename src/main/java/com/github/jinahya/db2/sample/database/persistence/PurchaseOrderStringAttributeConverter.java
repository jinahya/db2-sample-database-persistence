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

import com.github.jinahya.db2.sample.database.persistence.xml.porder.PurchaseOrder;
import com.github.jinahya.persistence.more.converter.jakartaxmlbind.JaxbAttributeConverter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

/**
 * Converts a {@link PurchaseOrder} attribute to the text of the {@code PURCHASEORDER.PORDER} column, an {@code XML}, and back.
 * <p>
 * The class is bound to {@code porder.xsd}, whose root element is {@code PurchaseOrder}, in no namespace.
 * <p>
 * The class declares {@link AttributeConverter} again, with its types, though its superclass implements it already;
 * EclipseLink takes the column type from an {@link AttributeConverter} the converter class itself declares, and
 * without it binds the attribute, not the text, to the column.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Converter(autoApply = false)
public class PurchaseOrderStringAttributeConverter
        extends JaxbAttributeConverter.OfString<PurchaseOrder>
        implements AttributeConverter<PurchaseOrder, String> {

    // the classes of the schema, through its ObjectFactory
    private static final class ContextHolder {

        private static final JAXBContext CONTEXT;

        static {
            try {
                CONTEXT = JAXBContext.newInstance(com.github.jinahya.db2.sample.database.persistence.xml.porder.ObjectFactory.class);
            } catch (final JAXBException e) {
                throw new ExceptionInInitializerError(e);
            }
        }

        private ContextHolder() {
            throw new AssertionError("instantiation is not allowed");
        }
    }

    /**
     * Creates a new instance.
     */
    public PurchaseOrderStringAttributeConverter() {
        super(PurchaseOrder.class);
    }

    @Override
    protected JAXBContext context() {
        return ContextHolder.CONTEXT;
    }
}

