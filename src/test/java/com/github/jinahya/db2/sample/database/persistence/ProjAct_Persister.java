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

import com.github.jinahya.persistence.test.util.AbstractEntityPersister;
import jakarta.persistence.EntityManager;
import static com.github.jinahya.persistence.test.util.EntityPersisterUtils.newPersistedInstanceOf;

import static com.github.jinahya.persistence.test.util.EntityPersisterUtils.newPersistedInstanceOf;

/**
 * Persists a new {@link ProjAct}, after a new {@link Project} whose number it takes.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class ProjAct_Persister
        extends AbstractEntityPersister<ProjAct> {

    ProjAct_Persister() {
        super(ProjAct.class);
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public ProjAct apply(final EntityManager entityManager, final ProjAct entityInstance) {
        final var project = newPersistedInstanceOf(entityManager, Project.class);
        entityManager.flush();
        entityInstance.setProjno(project.getProjno());
        return super.apply(entityManager, entityInstance);
    }
}

