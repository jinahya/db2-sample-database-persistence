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
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Helpers which read, parse, validate and save the documents of the {@code XML} columns.
 * <p>
 * Each file is saved in {@code target}, named {@code <TABLE>_<ID>_<COLUMN>.xml} for the document as
 * stored, and {@code <TABLE>_<ID>_<COLUMN>_JAXB.xml} for the document marshalled from the attribute
 * bound to the column's schema.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
public final class ___Xml_TestUtils {

    /**
     * Returns the base name, {@code <TABLE>_<ID>_<COLUMN>}, of the files saved for the specified
     * column of the row of the specified id.
     *
     * @param table  the name of the table.
     * @param id     the identifier of the row.
     * @param column the name of the column.
     * @return the base name of the files.
     */
    public static String name(final String table, final Object id, final String column) {
        return table + "_" + String.valueOf(id).strip() + "_" + column;
    }

    /**
     * Reads the document stored in the specified column of the row of the specified id, as the
     * database serializes it, not as an attribute converter writes it back.
     *
     * @param entityManager the entity manager to read with.
     * @param table         the name of the table.
     * @param column        the name of the {@code XML} column.
     * @param idColumn      the name of the identifier column.
     * @param id            the identifier of the row.
     * @return the document stored in the column; {@code null} when the column is {@code null}.
     * @implNote The document is serialized as a {@code VARCHAR}, not a {@code CLOB}, which
     *         the driver closes before the query returns it; the longest in the sample is 458
     *         characters.
     */
    public static String serialized(final EntityManager entityManager, final String table,
                                    final String column, final String idColumn,
                                    final Object id) {
        Objects.requireNonNull(entityManager, "entityManager is null");
        return (String) entityManager.createNativeQuery(
                        "SELECT XMLSERIALIZE(" + column + " AS VARCHAR(32672))" +
                        " FROM " + table +
                        " WHERE " + idColumn + " = ?1")
                .setParameter(1, id)
                .getSingleResult();
    }

    /**
     * Parses the specified text as an XML document, namespace-aware, refusing a document type
     * declaration.
     *
     * @param text the text to parse.
     * @return the document parsed from the {@code text}.
     */
    public static Document parse(final String text) {
        Objects.requireNonNull(text, "text is null");
        final Document document;
        try {
            final var factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            document = factory.newDocumentBuilder().parse(new InputSource(new StringReader(text)));
        } catch (final ParserConfigurationException | SAXException | IOException e) {
            throw new AssertionError("failed to parse " + text, e);
        }
        assertThat(document.getDocumentElement()).isNotNull();
        return document;
    }

    /**
     * Validates the specified document against the specified schema.
     *
     * @param schema   the schema to validate against.
     * @param document the document to validate.
     * @return the {@code document}.
     */
    public static Document validate(final Schema schema, final Document document) {
        Objects.requireNonNull(schema, "schema is null");
        Objects.requireNonNull(document, "document is null");
        try {
            schema.newValidator().validate(new DOMSource(document));
        } catch (final SAXException | IOException e) {
            throw new AssertionError("not valid against the schema: " + document, e);
        }
        return document;
    }

    /**
     * Saves the specified document, indented, in UTF-8, to the specified file of {@code target}.
     *
     * @param document the document to save.
     * @param name     the name of the file.
     * @return the path of the file.
     */
    public static Path save(final Document document, final String name) {
        Objects.requireNonNull(document, "document is null");
        final var path = Path.of("target", Objects.requireNonNull(name, "name is null"));
        try {
            final var factory = TransformerFactory.newInstance();
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            final var transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, StandardCharsets.UTF_8.name());
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            try (var output = Files.newOutputStream(path)) {
                transformer.transform(new DOMSource(document), new StreamResult(output));
            }
        } catch (final TransformerException | IOException e) {
            throw new AssertionError("failed to save to " + path, e);
        }
        return path;
    }

    /**
     * Marshals the specified bound object, validating it against the specified schema as it goes,
     * and saves it, formatted, in UTF-8, to the specified file of {@code target}.
     *
     * @param bound  the object, of a class bound to the {@code schema}, to marshal.
     * @param schema the schema to validate against.
     * @param name   the name of the file.
     * @return the path of the file.
     */
    public static Path marshal(final Object bound, final Schema schema, final String name) {
        Objects.requireNonNull(bound, "bound is null");
        Objects.requireNonNull(schema, "schema is null");
        final var path = Path.of("target", Objects.requireNonNull(name, "name is null"));
        try {
            final var marshaller = JAXBContext.newInstance(bound.getClass()).createMarshaller();
            marshaller.setSchema(schema);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, StandardCharsets.UTF_8.name());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (var output = Files.newOutputStream(path)) {
                marshaller.marshal(bound, output);
            }
        } catch (final JAXBException | IOException e) {
            throw new AssertionError("failed to marshal " + bound + " to " + path, e);
        }
        return path;
    }

    // ---------------------------------------------------------------------------------------------

    private ___Xml_TestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
