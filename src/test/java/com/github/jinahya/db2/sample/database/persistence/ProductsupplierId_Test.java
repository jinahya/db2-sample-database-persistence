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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class ProductsupplierId_Test
        extends _NonEntity_Test<ProductsupplierId> {

    ProductsupplierId_Test() {
        super(ProductsupplierId.class);
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Tests {@link ProductsupplierId#of(String, String)}.
     */
    @DisplayName("of(pid, sid)")
    @Nested
    class OfTest {

        /**
         * Verifies that {@link ProductsupplierId#of(String, String) of} returns an instance of the
         * specified values.
         */
        @Test
        void __() {
            final var instance = ProductsupplierId.of("V0", "V1");
            assertThat(instance).isNotNull().satisfies(v -> {
                assertThat(v.getPid()).isEqualTo("V0");
                assertThat(v.getSid()).isEqualTo("V1");
            });
        }

        /**
         * Verifies that {@link ProductsupplierId#of(String, String) of} takes {@code null} values
         * as they are.
         */
        @Test
        void __null() {
            final var instance = ProductsupplierId.of(null, null);
            assertThat(instance).isNotNull().satisfies(v -> {
                assertThat(v.getPid()).isNull();
                assertThat(v.getSid()).isNull();
            });
        }
    }
}
