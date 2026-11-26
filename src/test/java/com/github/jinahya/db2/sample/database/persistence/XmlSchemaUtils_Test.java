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
import org.xml.sax.SAXParseException;

import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import java.io.StringReader;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests {@link XmlSchemaUtils}, without a database.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
class XmlSchemaUtils_Test {

    private static Stream<Arguments> getSchemaArguments() {
        return Stream.of(
                Arguments.of(Customerinfo.class, "customer.xsd",
                             (Supplier<Schema>) XmlSchemaUtils::customerinfo),
                Arguments.of(Product.class, "product.xsd",
                             (Supplier<Schema>) XmlSchemaUtils::product),
                Arguments.of(PurchaseOrder.class, "porder.xsd",
                             (Supplier<Schema>) XmlSchemaUtils::purchaseOrder),
                Arguments.of(Supplierinfo.class, "supplier.xsd",
                             (Supplier<Schema>) XmlSchemaUtils::supplierinfo)
        );
    }

    @DisplayName("each XSD sits beside its bound class, and its schema is loaded once")
    @MethodSource("getSchemaArguments")
    @ParameterizedTest
    void schema_(final Class<?> boundClass, final String name, final Supplier<Schema> accessor) {
        assertThat(boundClass.getResource(name)).as("%s beside %s", name, boundClass).isNotNull();
        final var schema = accessor.get();
        assertThat(schema).isNotNull()
                .isSameAs(accessor.get())
                .isSameAs(XmlSchemaUtils.of(boundClass));
    }

    @DisplayName("a class bound to no schema here is rejected")
    @Test
    void of_Unbound_() {
        assertThatThrownBy(() -> XmlSchemaUtils.of(String.class))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("a valid document passes the schema, and one without a required element fails")
    @Test
    void customerinfo_Validates_() {
        final var valid = """
                <customerinfo Cid="1000"><name>Kathy Smith</name>\
                <addr country="Canada"><street>5 Rosewood</street><city>Toronto</city>\
                <prov-state>Ontario</prov-state><pcode-zip>M6W 1E6</pcode-zip></addr>\
                </customerinfo>""";
        assertThatCode(() -> XmlSchemaUtils.customerinfo().newValidator()
                .validate(new StreamSource(new StringReader(valid))))
                .doesNotThrowAnyException();
        // customer.xsd requires an addr
        final var invalid = "<customerinfo Cid=\"1000\"><name>Kathy Smith</name></customerinfo>";
        assertThatThrownBy(() -> XmlSchemaUtils.customerinfo().newValidator()
                .validate(new StreamSource(new StringReader(invalid))))
                .isInstanceOf(SAXParseException.class);
    }
}

