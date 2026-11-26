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

import com.github.jinahya.db2.sample.database.persistence.xml.supplier.Supplierinfo;
import com.github.jinahya.persistence.more.converter.jakartaxmlbind.JaxbAttributeConverter;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

/**
 * Converts a {@link Supplierinfo} attribute to the text of the {@code SUPPLIERS.ADDR} column, an
 * {@code XML}, and back.
 * <p>
 * The class is bound to {@code supplier.xsd}, whose root element is {@code supplierinfo}, in the
 * {@code http://posample.org} namespace.
 * <p>
 * The class declares {@link AttributeConverter} again, with its types, though its superclass
 * implements it already; EclipseLink takes the column type from an {@link AttributeConverter} the
 * converter class itself declares, and without it binds the attribute, not the text, to the
 * column.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Converter(autoApply = false)
public class SupplierinfoStringAttributeConverter
        extends JaxbAttributeConverter.OfString<Supplierinfo>
        implements AttributeConverter<Supplierinfo, String> {

    // the classes of the schema, through its ObjectFactory
    private static final class ContextHolder {

        private static final JAXBContext CONTEXT;

        static {
            try {
                CONTEXT = JAXBContext.newInstance(
                        com.github.jinahya.db2.sample.database.persistence.xml.supplier.ObjectFactory.class);
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
    public SupplierinfoStringAttributeConverter() {
        super(Supplierinfo.class);
    }

    @Override
    protected JAXBContext context() {
        return ContextHolder.CONTEXT;
    }
}

