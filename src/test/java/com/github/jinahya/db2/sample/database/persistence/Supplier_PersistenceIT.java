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

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;

import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.marshal;
import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.name;
import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.parse;
import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.save;
import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.serialized;
import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.validate;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class Supplier_PersistenceIT
        extends _Entity_PersistenceIT<Supplier, String> {

    Supplier_PersistenceIT() {
        super(Supplier.class, String.class);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void randomEntityInstanceSelected__(final EntityManagerFactory entityManagerFactory,
                                                  final EntityManager entityManager,
                                                  final Supplier entityInstance) {
        super.randomEntityInstanceSelected__(entityManagerFactory, entityManager, entityInstance);
        addr(entityManager, entityInstance);
    }

    /**
     * Reads the {@code ADDR} document of the specified instance as stored, parses it,
     * validates it against its schema, and saves it; then marshals the attribute bound to the
     * schema, validating it again, and saves that as well.
     *
     * @param entityManager  the entity manager which selected the instance.
     * @param entityInstance the instance.
     */
    private void addr(final EntityManager entityManager, final Supplier entityInstance) {
        final var name = name(Supplier.TABLE_NAME, entityInstance.getSid(),
                              Supplier.COLUMN_NAME_ADDR);
        final var schema = XmlSchemaUtils.supplierinfo();
        {
            final var serialized = serialized(
                    entityManager, Supplier.TABLE_NAME, Supplier.COLUMN_NAME_ADDR,
                    Supplier.COLUMN_NAME_SID, entityInstance.getSid());
            if (serialized == null) {
                log.debug("no addr: {}", entityInstance);
                return;
            }
            final var document = validate(schema, parse(serialized));
            final var path = save(document, name + ".xml");
            log.debug("addr saved to {}", path.toAbsolutePath());
        }
        {
            final var bound = entityInstance.getAddr();
            assertThat(bound).isNotNull();
            final var path = marshal(bound, schema, name + "_JAXB.xml");
            log.debug("addr marshalled to {}", path.toAbsolutePath());
        }
    }
}
