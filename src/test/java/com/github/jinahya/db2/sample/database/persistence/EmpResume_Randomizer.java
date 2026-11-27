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

import com.github.jinahya.object.randomizer.PodamObjectRandomizer;

import java.util.List;

/**
 * Randomizes a new {@link EmpResume}, whose identifier it sets itself, within the lengths of its
 * columns, since Podam does not reach its setters, which are not public. It leaves out the
 * associations, which its persister sets.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class EmpResume_Randomizer
        extends PodamObjectRandomizer<EmpResume> {

    EmpResume_Randomizer() {
        super(EmpResume.class, List.of(
                EmpResume.ATTRIBUTE_NAME_EMPLOYEE,
                EmpResume.ATTRIBUTE_NAME_ID
        ));
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public EmpResume get() {
        final var instance = super.get();
        // the employee number is the employee's, which the persister sets
        instance.setResumeFormat(__Randomizer_Utils.string(10));
        return instance;
    }
}

