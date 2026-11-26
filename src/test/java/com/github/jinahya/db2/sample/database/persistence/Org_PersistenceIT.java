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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class Org_PersistenceIT
        extends _Entity_PersistenceIT<Org, Integer> {

    Org_PersistenceIT() {
        super(Org.class, Integer.class);
    }

    // ---------------------------------------------------------------------------------------------
    @Disabled("not an entity: the table has no key, and Org is persisted by no entity manager")
    @Override
    @Test
    protected void persistRandomizedEntityInstance__() {
        // empty
    }

    // ---------------------------------------------------------------------------------------------
    @DisplayName("a randomly selected installed row, read through a native query, is valid")
    @Override
    @Test
    protected void selectRandomEntityInstance__() {
        selectRandomRow__(Org.TABLE_NAME, Org::new);
    }
}
