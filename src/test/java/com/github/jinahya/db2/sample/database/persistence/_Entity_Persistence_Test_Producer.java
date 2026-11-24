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

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.inject.Qualifier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.invoke.MethodHandles;

/**
 * Produces an entity manager factory, and entity managers, of the unit-test persistence unit, on an in-memory H2 database in DB2 mode whose schema the provider generates.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@ApplicationScoped
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class _Entity_Persistence_Test_Producer {

    /**
     * The name of the persistence unit. The value is {@value}.
     */
    static final String PERSISTENCE_UNIT_NAME = "sample-test";

    private static final System.Logger logger = System.getLogger(MethodHandles.lookup().lookupClass().getName());

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A qualifier for what this producer produces.
     */
    @Documented
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
    public @interface __TestPU {

        /**
         * The literal of the qualifier.
         */
        final class Literal extends AnnotationLiteral<__TestPU> implements __TestPU {

            /**
             * The single instance.
             */
            public static final Literal INSTANCE = new Literal();

            private static final long serialVersionUID = 1L;

            private Literal() {
                super();
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    _Entity_Persistence_Test_Producer() {
        super();
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Produces
    @__TestPU
    @ApplicationScoped
    protected EntityManagerFactory produceEntityManagerFactory() {
        logger.log(System.Logger.Level.DEBUG, "creating a factory of {0}", PERSISTENCE_UNIT_NAME);
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    protected void disposeEntityManagerFactory(@Disposes @__TestPU final EntityManagerFactory entityManagerFactory) {
        if (entityManagerFactory.isOpen()) {
            logger.log(System.Logger.Level.DEBUG, "closing {0}", entityManagerFactory);
            entityManagerFactory.close();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Produces
    @__TestPU
    @Dependent
    protected EntityManager produceEntityManager(@__TestPU final EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    protected void disposeEntityManager(@Disposes @__TestPU final EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
