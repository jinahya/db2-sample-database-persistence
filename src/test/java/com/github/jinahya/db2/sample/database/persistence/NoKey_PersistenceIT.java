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

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static com.github.jinahya.db2.sample.database.persistence.___PersistenceIT_Utils.applyEntityManagerFactory;
import static com.github.jinahya.persistence.util.JinahyaEntityManagerFactoryUtils.applyEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Reads every row of each table and view with no key, which is no entity, through a native query of
 * its {@code SELECT_LIST}, and builds an instance of its class from each row.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
@Slf4j
class NoKey_PersistenceIT {

    private static Arguments arguments(final Class<?> type, final String table,
                                       final String selectList,
                                       final Function<Object[], ?> constructor) {
        return Arguments.of(type.getSimpleName(), table, selectList, constructor);
    }

    private static Stream<Arguments> getArgumentsStream() {
        return Stream.of(
                arguments(Adefusr.class, Adefusr.TABLE_NAME, Adefusr.SELECT_LIST, Adefusr::new),
                arguments(ClSched.class, ClSched.TABLE_NAME, ClSched.SELECT_LIST, ClSched::new),
                arguments(Empmdc.class, Empmdc.TABLE_NAME, Empmdc.SELECT_LIST, Empmdc::new),
                arguments(Empprojact.class, Empprojact.TABLE_NAME, Empprojact.SELECT_LIST,
                          Empprojact::new),
                arguments(InTray.class, InTray.TABLE_NAME, InTray.SELECT_LIST, InTray::new),
                arguments(MlblogsAnswer.class, MlblogsAnswer.TABLE_NAME, MlblogsAnswer.SELECT_LIST,
                          MlblogsAnswer::new),
                arguments(MlblogsQuestion.class, MlblogsQuestion.TABLE_NAME,
                          MlblogsQuestion.SELECT_LIST, MlblogsQuestion::new),
                arguments(Org.class, Org.TABLE_NAME, Org.SELECT_LIST, Org::new),
                arguments(Patient.class, Patient.TABLE_NAME, Patient.SELECT_LIST, Patient::new),
                arguments(Sale.class, Sale.TABLE_NAME, Sale.SELECT_LIST, Sale::new),
                arguments(Staff.class, Staff.TABLE_NAME, Staff.SELECT_LIST, Staff::new),
                arguments(Staffg.class, Staffg.TABLE_NAME, Staffg.SELECT_LIST, Staffg::new),
                arguments(Vempprojact.class, Vempprojact.TABLE_NAME, Vempprojact.SELECT_LIST,
                          Vempprojact::new),
                arguments(Vforpla.class, Vforpla.TABLE_NAME, Vforpla.SELECT_LIST, Vforpla::new),
                arguments(Vstafac2.class, Vstafac2.TABLE_NAME, Vstafac2.SELECT_LIST,
                          Vstafac2::new)
        );
    }

    @DisplayName("every row reads, through a native query, into a valid instance")
    @MethodSource("getArgumentsStream")
    @ParameterizedTest(name = "[{index}] {0}")
    void rows_(final String name, final String table, final String selectList,
               final Function<Object[], ?> constructor) {
        applyEntityManagerFactory(emf -> applyEntityManager(emf, em -> {
            final var count = ((Number) em.createNativeQuery("SELECT COUNT(*) FROM " + table)
                    .getSingleResult()).longValue();
            final var rows = em.createNativeQuery("SELECT " + selectList + " FROM " + table)
                    .getResultList();
            assertThat(rows).as("rows of %s", table).hasSize(Math.toIntExact(count));
            for (final var row : rows) {
                final var instance = constructor.apply((Object[]) row);
                ___Validation_TestUtils.assertValid(instance);
                log.debug("{}: {}", name, instance);
            }
            return null;
        }));
    }
}
