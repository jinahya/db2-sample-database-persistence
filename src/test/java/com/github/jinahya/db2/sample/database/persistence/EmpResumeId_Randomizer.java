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
 * Randomizes a new {@link EmpResumeId}, each of whose values it sets, since its setters are not
 * public.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class EmpResumeId_Randomizer
        extends PodamObjectRandomizer<EmpResumeId> {

    EmpResumeId_Randomizer() {
        super(EmpResumeId.class, List.of(
        ));
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public EmpResumeId get() {
        final var instance = new EmpResumeId();
        instance.setEmpno(__Randomizer_Utils.string(10));
        instance.setResumeFormat(__Randomizer_Utils.string(10));
        return instance;
    }
}

