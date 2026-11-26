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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Random values for what the randomizers set themselves: the identifiers, whose setters are not
 * public, so Podam leaves them out, and the values a column constrains beyond its type.
 * <p>
 * A string is of exactly the length asked for, so that a {@code CHAR} column, which pads, reads
 * back the same value.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
final class __Randomizer_Utils {

    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final String DIGITS = "0123456789";

    private static String of(final String characters, final int length) {
        final var random = ThreadLocalRandom.current();
        final var builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(characters.charAt(random.nextInt(characters.length())));
        }
        return builder.toString();
    }

    /**
     * Returns a new string of upper-case letters and digits.
     *
     * @param length the length of the string.
     * @return a new string of {@code length} upper-case letters and digits.
     */
    static String string(final int length) {
        return of(ALPHANUMERIC, length);
    }

    /**
     * Returns a new string of digits.
     *
     * @param length the length of the string.
     * @return a new string of {@code length} digits.
     */
    static String digits(final int length) {
        return of(DIGITS, length);
    }

    static Short positiveShort() {
        return (short) ThreadLocalRandom.current().nextInt(1, Short.MAX_VALUE);
    }

    static Integer positiveInt() {
        return ThreadLocalRandom.current().nextInt(1, Integer.MAX_VALUE);
    }

    static Long positiveLong() {
        return ThreadLocalRandom.current().nextLong(1L, Long.MAX_VALUE);
    }

    /**
     * Returns a new date between 2000-01-01 and 2030-12-31.
     *
     * @return a new date.
     */
    static LocalDate localDate() {
        final var start = LocalDate.of(2000, 1, 1);
        return start.plusDays(ThreadLocalRandom.current().nextLong(
                ChronoUnit.DAYS.between(start, LocalDate.of(2031, 1, 1))));
    }

    /**
     * Returns a new date-time, to the microsecond, which a {@code TIMESTAMP} column keeps.
     *
     * @return a new date-time.
     */
    static LocalDateTime localDateTime() {
        return localDate().atStartOfDay()
                .plus(ThreadLocalRandom.current().nextLong(86_400_000_000L), ChronoUnit.MICROS);
    }

    private __Randomizer_Utils() {
        throw new AssertionError("instantiation is not allowed");
    }
}

