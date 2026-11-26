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

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts a {@code float[]} attribute to the string form of a {@code VECTOR(n, FLOAT32)} column,
 * and back.
 * <p>
 * Db2 stores a vector in binary, but uses its string form when interacting with applications: the
 * IBM Data Server Driver for JDBC reports a {@code VECTOR} column as a {@code VARCHAR}, reads it
 * with {@code getString}, and binds a {@code VARCHAR} parameter to it with {@code setString}; it
 * does not read or bind a {@code VECTOR} as a {@code byte[]} or a {@code float[]}. The string form
 * is a comma-separated list of the coordinates, delimited by square brackets, such as
 * {@code [0.123,-0.456,0.789]}.
 * <p>
 * The database normalizes the text it is given, so the text read back is not the text written;
 * every {@code float} which Db2 accepts, written with {@link Float#toString(float)}, is read back
 * to the same value. Db2 rejects {@code NaN}, the infinities, the subnormal values and
 * {@link Float#MAX_VALUE}, and a vector whose length is not the dimension of the column; it reads
 * {@code -0.0} back as {@code 0.0}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Converter(autoApply = false)
public class VectorStringAttributeConverter
        implements AttributeConverter<float[], String> {

    /**
     * Creates a new instance.
     */
    public VectorStringAttributeConverter() {
        super();
    }

    @Override
    public String convertToDatabaseColumn(final float[] attribute) {
        if (attribute == null) {
            return null;
        }
        final var builder = new StringBuilder(attribute.length * 16 + 2).append('[');
        for (int i = 0; i < attribute.length; i++) {
            if (i > 0) {
                builder.append(',');
            }
            builder.append(attribute[i]);
        }
        return builder.append(']').toString();
    }

    @Override
    public float[] convertToEntityAttribute(final String dbData) {
        if (dbData == null) {
            return null;
        }
        final var stripped = dbData.strip();
        if (!stripped.startsWith("[") || !stripped.endsWith("]")) {
            throw new IllegalArgumentException("not the string form of a vector: " + dbData);
        }
        final var coordinates = stripped.substring(1, stripped.length() - 1).strip();
        if (coordinates.isEmpty()) {
            return new float[0];
        }
        final var tokens = coordinates.split(",");
        final var attribute = new float[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            attribute[i] = Float.parseFloat(tokens[i].strip());
        }
        return attribute;
    }
}

