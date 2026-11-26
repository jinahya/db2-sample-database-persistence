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
 * Randomizes a new {@link Department}, created with a random identifier, which has no public
 * setter, and the values Podam gives the other columns, within their lengths. It leaves out the
 * associations, which its persister sets, and the foreign key columns, mapped read-only.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class Department_Randomizer
        extends PodamObjectRandomizer<Department> {

    Department_Randomizer() {
        super(Department.class, List.of(
                "admrdeptDepartment",
                "mgrnoEmployee",
                Department.ATTRIBUTE_NAME_DEPTNO,
                Department.ATTRIBUTE_NAME_MGRNO,
                Department.ATTRIBUTE_NAME_ADMRDEPT
        ));
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public Department get() {
        final var randomized = super.get();
        final var instance = new Department(__Randomizer_Utils.string(3));
        instance.setDeptname(randomized.getDeptname());
        instance.setLocation(randomized.getLocation());
        return instance;
    }
}

