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

/**
 * Jakarta Persistence mappings for the {@code SAMPLE} database of IBM Db2, as mapped superclasses
 * which a consumer extends with entities of its own.
 * <p>
 * The persistence and validation APIs appear in the mapped superclasses' public signatures, so a
 * reader of this module reads them too. So do the nullness annotations of
 * {@code jakarta.annotation}, but that one is also static: they are not needed at run time.
 * <p>
 * The package is opened, not only exported, because a persistence provider and a validation
 * provider reach the mapped superclasses' private fields reflectively; neither can be named here,
 * since the provider is the consumer's choice.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
module com.github.jinahya.db2.sample.database.persistence {

    requires static transitive jakarta.annotation;
    requires transitive jakarta.persistence;
    requires transitive jakarta.validation;
    // the XML columns: the bound classes, and the converters, which extend JaxbAttributeConverter
    requires transitive jakarta.xml.bind;
    requires transitive com.github.jinahya.persistence.more;
    // the bound classes implement its Equals and HashCode
    requires transitive org.jvnet.jaxb.plugins.runtime;

    exports com.github.jinahya.db2.sample.database.persistence;
    exports com.github.jinahya.db2.sample.database.persistence.mapped;
    exports com.github.jinahya.db2.sample.database.persistence.xml.customer;
    exports com.github.jinahya.db2.sample.database.persistence.xml.product;
    exports com.github.jinahya.db2.sample.database.persistence.xml.porder;
    exports com.github.jinahya.db2.sample.database.persistence.xml.supplier;

    opens com.github.jinahya.db2.sample.database.persistence;
    opens com.github.jinahya.db2.sample.database.persistence.mapped;
    // to Jakarta XML Binding, and for the XSD each holds
    opens com.github.jinahya.db2.sample.database.persistence.xml.customer;
    opens com.github.jinahya.db2.sample.database.persistence.xml.product;
    opens com.github.jinahya.db2.sample.database.persistence.xml.porder;
    opens com.github.jinahya.db2.sample.database.persistence.xml.supplier;
}
