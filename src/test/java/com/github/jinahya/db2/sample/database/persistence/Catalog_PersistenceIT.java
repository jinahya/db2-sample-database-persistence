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

import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.name;
import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.parse;
import static com.github.jinahya.db2.sample.database.persistence.___Xml_TestUtils.save;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class Catalog_PersistenceIT
        extends _Entity_PersistenceIT<Catalog, String> {

    Catalog_PersistenceIT() {
        super(Catalog.class, String.class);
    }

    // ---------------------------------------------------------------------------------------------

    @Override
    protected void randomEntityInstanceSelected__(final EntityManagerFactory entityManagerFactory,
                                                  final EntityManager entityManager,
                                                  final Catalog entityInstance) {
        super.randomEntityInstanceSelected__(entityManagerFactory, entityManager, entityInstance);
        catlog(entityManager, entityInstance);
    }

    /**
     * Parses the {@code CATLOG} of the specified instance, if any, as an XML document, and saves
     * it. The column has no registered schema, so the document is not validated.
     *
     * @param entityManager  the entity manager which selected the instance.
     * @param entityInstance the instance.
     */
    private void catlog(final EntityManager entityManager, final Catalog entityInstance) {
        final var text = entityInstance.getCatlog();
        if (text == null) {
            log.debug("no catlog: {}", entityInstance);
            return;
        }
        final var name = name(Catalog.TABLE_NAME, entityInstance.getName(),
                              Catalog.COLUMN_NAME_CATLOG);
        final var path = save(parse(text), name + ".xml");
        log.debug("catlog saved to {}", path.toAbsolutePath());
    }
}
