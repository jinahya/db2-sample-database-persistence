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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Optional;

/**
 * Reads a value, by its index, from a row of a native query, which a provider hands over as an
 * {@code Object[]}.
 * <p>
 * Without a result mapping, the type of each value is the provider's and the driver's to choose: a
 * {@code SMALLINT} may come as a {@link Short} or an {@link Integer}, a {@code TIME} as a
 * {@link java.sql.Time} or a {@link LocalTime}, a {@code CHAR(1)} as a {@link Character}. Each
 * method takes what either provider gives, and returns the type of the attribute.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
final class __Row_Utils {

    private static Object value(final Object[] row, final int index) {
        Objects.requireNonNull(row, "row is null");
        return row[Objects.checkIndex(index, row.length)];
    }

    private static IllegalArgumentException unexpected(final Object value, final int index) {
        return new IllegalArgumentException(
                "unexpected value at " + index + ": " + value + " (" + value.getClass() + ")");
    }

    /**
     * Returns the value at the specified index as a string.
     *
     * @param row   the row.
     * @param index the index of the value.
     * @return the value as a string; {@code null} when it is {@code null}.
     */
    static String string(final Object[] row, final int index) {
        return Optional.ofNullable(value(row, index)).map(Object::toString).orElse(null);
    }

    /**
     * Returns the value at the specified index as an integer.
     *
     * @param row   the row.
     * @param index the index of the value.
     * @return the value as an integer; {@code null} when it is {@code null}.
     */
    static Integer integer(final Object[] row, final int index) {
        final var value = value(row, index);
        if (value == null) {
            return null;
        }
        if (value instanceof Number number) {
            return Math.toIntExact(number.longValue());
        }
        throw unexpected(value, index);
    }

    /**
     * Returns the value at the specified index as a big decimal.
     *
     * @param row   the row.
     * @param index the index of the value.
     * @return the value as a big decimal; {@code null} when it is {@code null}.
     */
    static BigDecimal bigDecimal(final Object[] row, final int index) {
        final var value = value(row, index);
        return switch (value) {
            case null -> null;
            case BigDecimal decimal -> decimal;
            case BigInteger integer -> new BigDecimal(integer);
            case Number number -> new BigDecimal(number.toString());
            default -> throw unexpected(value, index);
        };
    }

    /**
     * Returns the value at the specified index as a local date.
     *
     * @param row   the row.
     * @param index the index of the value.
     * @return the value as a local date; {@code null} when it is {@code null}.
     */
    static LocalDate localDate(final Object[] row, final int index) {
        final var value = value(row, index);
        return switch (value) {
            case null -> null;
            case LocalDate date -> date;
            case java.sql.Date date -> date.toLocalDate();
            case java.sql.Timestamp timestamp -> timestamp.toLocalDateTime().toLocalDate();
            default -> throw unexpected(value, index);
        };
    }

    /**
     * Returns the value at the specified index as a local time.
     *
     * @param row   the row.
     * @param index the index of the value.
     * @return the value as a local time; {@code null} when it is {@code null}.
     */
    static LocalTime localTime(final Object[] row, final int index) {
        final var value = value(row, index);
        return switch (value) {
            case null -> null;
            case LocalTime time -> time;
            case java.sql.Time time -> time.toLocalTime();
            default -> throw unexpected(value, index);
        };
    }

    /**
     * Returns the value at the specified index as a local date-time.
     *
     * @param row   the row.
     * @param index the index of the value.
     * @return the value as a local date-time; {@code null} when it is {@code null}.
     */
    static LocalDateTime localDateTime(final Object[] row, final int index) {
        final var value = value(row, index);
        return switch (value) {
            case null -> null;
            case LocalDateTime dateTime -> dateTime;
            case java.sql.Timestamp timestamp -> timestamp.toLocalDateTime();
            default -> throw unexpected(value, index);
        };
    }

    /**
     * Returns the value at the specified index, the string form of a {@code VECTOR}, as a
     * {@code float[]}.
     *
     * @param row   the row.
     * @param index the index of the value.
     * @return the value as a {@code float[]}; {@code null} when it is {@code null}.
     * @see VectorStringAttributeConverter
     */
    static float[] vector(final Object[] row, final int index) {
        final var value = value(row, index);
        return switch (value) {
            case null -> null;
            case String text -> new VectorStringAttributeConverter().convertToEntityAttribute(text);
            default -> throw unexpected(value, index);
        };
    }

    // ---------------------------------------------------------------------------------------------

    private __Row_Utils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
