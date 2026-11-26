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
import java.util.concurrent.ThreadLocalRandom;

/**
 * Randomizes a new {@link Employee}, whose identifier it sets itself, within the lengths of its
 * columns, since Podam does not reach its setters, which are not public. It leaves out the
 * associations, which its persister sets, and the foreign key columns, mapped read-only.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class Employee_Randomizer
        extends PodamObjectRandomizer<Employee> {

    Employee_Randomizer() {
        super(Employee.class, List.of(
                "workdeptDepartment",
                Employee.ATTRIBUTE_NAME_EMPNO,
                Employee.ATTRIBUTE_NAME_WORKDEPT
        ));
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public Employee get() {
        final var instance = super.get();
        instance.setEmpno(__Randomizer_Utils.string(6));
        // EMPLOYEE checks PHONENO BETWEEN '0000' AND '9999'
        instance.setPhoneno(__Randomizer_Utils.digits(4));
        // M male, F female; see Employee#ATTRIBUTE_REGEXP_SEX
        instance.setSex(ThreadLocalRandom.current().nextBoolean() ? "M" : "F");
        return instance;
    }
}

