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

/**
 * Persists a new {@link EmpPhoto}, after a new {@link Employee} whose number it takes.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class EmpPhoto_Persister
        extends AbstractEntityPersister<EmpPhoto> {

    EmpPhoto_Persister() {
        super(EmpPhoto.class);
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public EmpPhoto apply(final EntityManager entityManager, final EmpPhoto entityInstance) {
        final var employee = newPersistedInstanceOf(entityManager, Employee.class);
        entityManager.flush();
        entityInstance.setEmployee(employee);
        return super.apply(entityManager, entityInstance);
    }
}

