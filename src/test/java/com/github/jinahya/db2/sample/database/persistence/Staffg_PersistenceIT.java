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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
@Disabled("not an entity: the table has no key; Staffg is built from the rows of a native query")
class Staffg_PersistenceIT
        extends _Entity_PersistenceIT<Staffg, Integer> {

    Staffg_PersistenceIT() {
        super(Staffg.class, Integer.class);
    }
}

