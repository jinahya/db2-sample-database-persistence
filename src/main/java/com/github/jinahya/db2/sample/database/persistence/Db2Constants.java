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

/**
 * Constants of the Db2 data types.
 * <p>
 * A column narrower than 32 bits, such as a {@code SMALLINT}, maps to an {@link Integer}, not to
 * a {@link Short}; its range is kept with {@code @Min} and {@code @Max} of these constants.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://www.ibm.com/docs/en/db2/12.1.x?topic=list-numbers">Numbers</a>
 */
public final class Db2Constants {

    // ------------------------------------------------------------------------------------ SMALLINT

    /**
     * The minimum value of the {@code SMALLINT} type, a signed 16-bit integer. The value is
     * {@value}.
     *
     * @see <a href="https://www.ibm.com/docs/en/db2/12.1.x?topic=list-numbers">Numbers</a>
     */
    public static final int SMALLINT_MIN = Short.MIN_VALUE;

    /**
     * The maximum value of the {@code SMALLINT} type, a signed 16-bit integer. The value is
     * {@value}.
     *
     * @see <a href="https://www.ibm.com/docs/en/db2/12.1.x?topic=list-numbers">Numbers</a>
     */
    public static final int SMALLINT_MAX = Short.MAX_VALUE;

    // ---------------------------------------------------------------------------------------------

    private Db2Constants() {
        throw new AssertionError("instantiation is not allowed");
    }
}
