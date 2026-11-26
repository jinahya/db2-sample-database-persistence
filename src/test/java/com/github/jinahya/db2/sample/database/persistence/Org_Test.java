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
import org.junit.jupiter.api.Test;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class Org_Test
        extends _Entity_Test<Org, Integer> {

    Org_Test() {
        super(Org.class, Integer.class);
    }

    // ----------------------------------------------------------------------------- equals/hashCode
    @Disabled("no key: Org inherits equals/hashCode from Object, its identity")
    @Test
    @Override
    public void equals_verify_() {
        super.equals_verify_();
    }
}

