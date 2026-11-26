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
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static com.github.jinahya.db2.sample.database.persistence.___PersistenceIT_Utils.applyEntityManagerFactory;
import static com.github.jinahya.persistence.util.JinahyaEntityManagerFactoryUtils.applyEntityManager;
import static com.github.jinahya.persistence.util.JinahyaEntityManagerUtils.applyInTransactionAndRollback;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class Patient_PersistenceIT
        extends _Entity_PersistenceIT<Patient, Integer> {

    // the embedding of a patient, read by SQL, past the persistence context
    private static float[] embedding(final EntityManager entityManager, final Integer patientId) {
        final var text = (String) entityManager
                .createNativeQuery("SELECT EMBEDDING FROM PATIENTS WHERE PATIENT_ID = ?1")
                .setParameter(1, patientId)
                .getSingleResult();
        return new VectorStringAttributeConverter().convertToEntityAttribute(text);
    }

    // ---------------------------------------------------------------------------------------------
    Patient_PersistenceIT() {
        super(Patient.class, Integer.class);
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    protected void randomEntityInstanceSelected__(final EntityManagerFactory entityManagerFactory,
                                                  final EntityManager entityManager,
                                                  final Patient entityInstance) {
        super.randomEntityInstanceSelected__(entityManagerFactory, entityManager, entityInstance);
        final var embedding = entityInstance.getEmbedding();
        if (embedding != null) {
            assertThat(embedding).hasSize(Patient.COLUMN_DIMENSION_EMBEDDING);
            assertThat(embedding(entityManager, entityInstance.getPatientId()))
                    .as("the embedding of %s, read by SQL", entityInstance.getPatientId())
                    .isEqualTo(embedding);
        }
    }

    // ---------------------------------------------------------------------------------------------
    // changes the embedding of a patient which has one, flushes, and checks what SQL reads back
    private void changeEmbedding(final UnaryOperator<Patient> change, final boolean expected) {
        applyEntityManagerFactory(emf -> applyEntityManager(
                emf,
                m -> applyInTransactionAndRollback(m, em -> {
                    final var found = em.createQuery(
                                    "SELECT p FROM Patient p WHERE p.embedding IS NOT NULL",
                                    Patient.class)
                            .setMaxResults(1)
                            .getResultList();
                    assumeTrue(!found.isEmpty(), "no patient with an embedding is installed");
                    final var patient = found.getFirst();
                    final var before = patient.getEmbedding();
                    final var after = change.apply(patient).getEmbedding();
                    em.flush();
                    final var read = embedding(em, patient.getPatientId());
                    log.debug("embedding of {}: {}..., changed to {}..., read back {}...",
                              patient.getPatientId(), before[0], after[0], read[0]);
                    assertThat(read)
                            .as("the embedding read back, after the change is flushed")
                            .isEqualTo(expected ? after : before);
                    return null;
                })
        ));
    }

    @DisplayName("an embedding replaced with a new vector is updated")
    @Disabled("not an entity: no Patient is loaded or merged by an entity manager")
    @Test
    void embedding_Replaced_Updated() {
        changeEmbedding(p -> {
            p.setEmbedding(__Randomizer_Utils.vector(Patient.COLUMN_DIMENSION_EMBEDDING));
            return p;
        }, true);
    }

    @DisplayName("an embedding changed in the array its getter returns is not updated")
    @Disabled("not an entity: no Patient is loaded or merged by an entity manager")
    @Test
    void embedding_ChangedInReturnedArray_NotUpdated() {
        changeEmbedding(p -> {
            final var embedding = p.getEmbedding();
            embedding[0] = embedding[0] + 1.0f; // a copy
            return p;
        }, false);
    }

    @DisplayName("an embedding changed in a copy and set back is updated")
    @Disabled("not an entity: no Patient is loaded or merged by an entity manager")
    @Test
    void embedding_ChangedAndSet_Updated() {
        changeEmbedding(p -> {
            final var embedding = p.getEmbedding();
            embedding[0] = embedding[0] + 1.0f;
            p.setEmbedding(embedding);
            return p;
        }, true);
    }

    // ---------------------------------------------------------------------------------------------
    @Disabled("not an entity: the table has no key, and Patient is persisted by no entity manager")
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
        selectRandomRow__(Patient.TABLE_NAME, Patient::new);
    }
}
