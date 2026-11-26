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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.validation.SchemaFactory;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests the converters of the XML columns, and the XSDs beside the classes bound to them, without a database.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class XmlAttributeConverters_Test {

    private static Stream<Arguments> getXsdArguments() {
        return Stream.of(
                Arguments.of(Customerinfo.class, "customer.xsd"),
                Arguments.of(Product.class, "product.xsd"),
                Arguments.of(PurchaseOrder.class, "porder.xsd"),
                Arguments.of(Supplierinfo.class, "supplier.xsd")
        );
    }

    @DisplayName("each XSD sits beside its bound class, and is a schema")
    @MethodSource("getXsdArguments")
    @ParameterizedTest
    void xsd_(final Class<?> bound, final String name) throws Exception {
        final var resource = bound.getResource(name);
        assertThat(resource).as("%s beside %s", name, bound).isNotNull();
        assertThat(SchemaFactory.newDefaultInstance().newSchema(resource)).isNotNull();
    }

    @DisplayName("a document reads back equal from the text it converts to")
    @Test
    void customerinfo_RoundTrips_() {
        final var converter = new CustomerinfoStringAttributeConverter();
        final var info = converter.convertToEntityAttribute(
                "<customerinfo Cid=\"1000\"><name>Kathy Smith</name></customerinfo>");
        assertThat(info.getName()).isEqualTo("Kathy Smith");
        assertThat(converter.convertToEntityAttribute(converter.convertToDatabaseColumn(info)))
                .isEqualTo(info);
    }

    @DisplayName("malformed text is not converted")
    @Test
    void customerinfo_Malformed_() {
        final var converter = new CustomerinfoStringAttributeConverter();
        assertThatThrownBy(() -> converter.convertToEntityAttribute("<customerinfo Cid=\"1000\">"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("null converts to null, both ways")
    @Test
    void null_() {
        final var converter = new CustomerinfoStringAttributeConverter();
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }
}

