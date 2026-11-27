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
 * Randomizes a new {@link Project}, whose identifier it sets itself, within the lengths of its
 * columns, since Podam does not reach its setters, which are not public. It leaves out the
 * associations, which its persister sets, and the foreign key columns, mapped read-only.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class Project_Randomizer
        extends PodamObjectRandomizer<Project> {

    Project_Randomizer() {
        super(Project.class, List.of(
                Project.ATTRIBUTE_NAME_SUBPROJECTS,
                Project.ATTRIBUTE_NAME_PROJACTS,
                Project.ATTRIBUTE_NAME_DEPARTMENT,
                Project.ATTRIBUTE_NAME_RESPONSIBLE_EMPLOYEE,
                Project.ATTRIBUTE_NAME_MAJOR_PROJECT,
                Project.ATTRIBUTE_NAME_PROJNO,
                Project.ATTRIBUTE_NAME_DEPTNO,
                Project.ATTRIBUTE_NAME_RESPEMP,
                Project.ATTRIBUTE_NAME_MAJPROJ
        ));
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public Project get() {
        final var instance = super.get();
        instance.setProjno(__Randomizer_Utils.string(6));
        return instance;
    }
}

