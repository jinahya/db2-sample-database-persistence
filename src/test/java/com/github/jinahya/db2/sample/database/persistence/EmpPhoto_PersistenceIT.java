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

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class EmpPhoto_PersistenceIT
        extends _Entity_PersistenceIT<EmpPhoto, EmpPhotoId> {

    // the format name of the picture, by its own content (bmp, for PHOTO_FORMAT bitmap)
    private static String formatName(final byte[] picture) throws IOException {
        try (var input = ImageIO.createImageInputStream(new ByteArrayInputStream(picture))) {
            final var readers = ImageIO.getImageReaders(input);
            assertThat(readers.hasNext()).as("an image reader for the picture").isTrue();
            return readers.next().getFormatName();
        }
    }

    // ---------------------------------------------------------------------------------------------
    EmpPhoto_PersistenceIT() {
        super(EmpPhoto.class, EmpPhotoId.class);
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    protected void randomEntityInstanceSelected__(final EntityManagerFactory entityManagerFactory,
                                                  final EntityManager entityManager,
                                                  final EmpPhoto entityInstance) {
        super.randomEntityInstanceSelected__(entityManagerFactory, entityManager, entityInstance);
        try {
            photo(entityInstance);
        } catch (final IOException ioe) {
            throw new UncheckedIOException("failed to check the photo of " + entityInstance, ioe);
        }
    }

    private void photo(final EmpPhoto entityInstance) throws IOException {
        final var empno = entityInstance.getEmpno();
        final var photoFormat = entityInstance.getPhotoFormat();
        final var picture = entityInstance.getPicture();
        if (picture == null) {
            log.debug("no picture: {}", entityInstance);
            return;
        }
        // reads the picture with each image reader
        {
            // the readers that can decode the picture, by its own content; PHOTO_FORMAT is not
            // looked at
            try (var probe = ImageIO.createImageInputStream(new ByteArrayInputStream(picture))) {
                final var readers = ImageIO.getImageReaders(probe);
                assertThat(readers.hasNext())
                        .as("image readers for the picture of %s, of %s", empno, photoFormat)
                        .isTrue();
                while (readers.hasNext()) {
                    final var reader = readers.next();
                    try (var input = ImageIO.createImageInputStream(
                            new ByteArrayInputStream(picture))) {
                        reader.setInput(input, true, true);
                        final var read = reader.read(0);
                        log.debug("picture of {}, of {}, read by {} as {}: {}x{}", empno,
                                  photoFormat, reader, reader.getFormatName(), read.getWidth(),
                                  read.getHeight());
                        assertThat(read.getWidth()).isPositive();
                        assertThat(read.getHeight()).isPositive();
                    } finally {
                        reader.dispose();
                    }
                }
            }
        }
        // example: writes the image back with each image writer of the format
        {
            final var image = ImageIO.read(new ByteArrayInputStream(picture));
            final var formatName = formatName(picture);
            var index = 0;
            for (final var writers = ImageIO.getImageWritersByFormatName(formatName);
                 writers.hasNext();
                 index++) {
                final var writer = writers.next();
                final var written = Path.of(
                        "target",
                        empno.strip() + "_picture_written_" + index + "." + formatName
                );
                try (var output = ImageIO.createImageOutputStream(written.toFile())) {
                    writer.setOutput(output);
                    writer.write(image);
                } finally {
                    writer.dispose();
                }
                log.debug("picture of {} written by {} to {}", empno, writer,
                          written.toAbsolutePath());
                final var reread = ImageIO.read(written.toFile());
                assertThat(reread).isNotNull();
                assertThat(reread.getWidth()).isEqualTo(image.getWidth());
                assertThat(reread.getHeight()).isEqualTo(image.getHeight());
            }
        }
        {
            final var path = Path.of(
                    "target",
                    empno.strip() + "_picture." + formatName(picture).toLowerCase()
            );
            Files.write(path, picture);
            log.debug("picture saved to {}", path.toAbsolutePath());
        }
    }
}
