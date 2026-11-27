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

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class EmpResume_PersistenceIT
        extends _Entity_PersistenceIT<EmpResume, EmpResumeId> {

    EmpResume_PersistenceIT() {
        super(EmpResume.class, EmpResumeId.class);
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    protected void randomEntityInstanceSelected__(final EntityManagerFactory entityManagerFactory,
                                                  final EntityManager entityManager,
                                                  final EmpResume entityInstance) {
        super.randomEntityInstanceSelected__(entityManagerFactory, entityManager, entityInstance);
        try {
            resume(entityInstance);
        } catch (final IOException ioe) {
            throw new UncheckedIOException("failed to save the resume of " + entityInstance, ioe);
        }
    }

    // saves the resume to target, with its RESUME_FORMAT (ascii, html) as the file extension
    private void resume(final EmpResume entityInstance) throws IOException {
        final var id = entityInstance.getId();
        final var resume = entityInstance.getResume();
        if (resume == null) {
            log.debug("no resume: {}", entityInstance);
            return;
        }
        final var path = Path.of(
                "target",
                id.getEmpno().strip() + "_resume." + id.getResumeFormat().strip().toLowerCase()
        );
        Files.writeString(path, resume, StandardCharsets.UTF_8);
        log.debug("resume saved to {}", path.toAbsolutePath());
        assertThat(Files.readString(path, StandardCharsets.UTF_8)).isEqualTo(resume);
    }
}

