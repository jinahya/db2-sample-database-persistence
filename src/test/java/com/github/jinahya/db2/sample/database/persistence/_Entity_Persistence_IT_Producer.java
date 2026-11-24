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
 * Produces an entity manager factory, and entity managers, of the integration-test persistence unit, on the SAMPLE database of the Db2 from docker-compose.yml.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@ApplicationScoped
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class _Entity_Persistence_IT_Producer {

    /**
     * The name of the persistence unit. The value is {@value}.
     */
    static final String PERSISTENCE_UNIT_NAME = "sample-it";

    private static final System.Logger logger = System.getLogger(MethodHandles.lookup().lookupClass().getName());

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * A qualifier for what this producer produces.
     */
    @Documented
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
    public @interface __ItPU {

        /**
         * The literal of the qualifier.
         */
        final class Literal extends AnnotationLiteral<__ItPU> implements __ItPU {

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

    _Entity_Persistence_IT_Producer() {
        super();
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Produces
    @__ItPU
    @ApplicationScoped
    protected EntityManagerFactory produceEntityManagerFactory() {
        logger.log(System.Logger.Level.DEBUG, "creating a factory of {0}", PERSISTENCE_UNIT_NAME);
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

    protected void disposeEntityManagerFactory(@Disposes @__ItPU final EntityManagerFactory entityManagerFactory) {
        if (entityManagerFactory.isOpen()) {
            logger.log(System.Logger.Level.DEBUG, "closing {0}", entityManagerFactory);
            entityManagerFactory.close();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Produces
    @__ItPU
    @Dependent
    protected EntityManager produceEntityManager(@__ItPU final EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    protected void disposeEntityManager(@Disposes @__ItPU final EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
