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

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Table;
import jakarta.persistence.metamodel.EntityType;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.math.BigInteger;
import java.util.function.Function;

import static com.github.jinahya.db2.sample.database.persistence._Entity_Persistence_IT_Producer.__ItPU;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests the mappings against the {@code SAMPLE} database of the Db2 from
 * {@code compose.yaml}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@AddBeanClasses(_Entity_Persistence_IT_Producer.class)
@EnableAutoWeld
class PersistenceUnit_IT {

    @DisplayName("every entity counts the rows of its table, and loads a page of them")
    @Test
    void everyEntity_CountsAndLoads_() {
        for (final EntityType<?> e : entityManagerFactory.getMetamodel().getEntities()) {
            final var table = e.getJavaType().getAnnotation(Table.class).name();
            final var expected =
                    ((Number) entityManager.createNativeQuery("SELECT COUNT(*) FROM " + table)
                            .getSingleResult()).longValue();
            final var actual =
                    entityManager.createQuery("SELECT COUNT(e) FROM " + e.getName() + " e",
                                              Long.class)
                            .getSingleResult();
            assertThat(actual).as("row count of %s", e.getName()).isEqualTo(expected);
            final var page = entityManager.createQuery("SELECT e FROM " + e.getName() + " e",
                                                       e.getJavaType())
                    .setFirstResult(1)
                    .setMaxResults(3)
                    .getResultList();
            assertThat(page).as("a page of %s", e.getName())
                    .hasSize((int) Math.min(3L, Math.max(0L, expected - 1L)));
            page.forEach(v -> assertThat(v.toString()).isNotBlank());
            entityManager.clear();
        }
    }

    @DisplayName("Employee: a page in order, and the department an employee works in")
    @Test
    void employee_() {
        final var page = entityManager
                .createQuery("SELECT e FROM Employee e ORDER BY e.empno", Employee.class)
                .setFirstResult(5)
                .setMaxResults(5)
                .getResultList();
        assertThat(page).extracting(Employee::getEmpno)
                .containsExactly("000070", "000090", "000100", "000110", "000120");
        final var haas = entityManager.find(Employee.class, "000010");
        assertThat(haas.getLastname()).isEqualTo("HAAS");
        assertThat(haas.getWorkdeptDepartment().getDeptname()).isEqualTo(
                "SPIFFY COMPUTER SERVICE DIV.");
    }

    @DisplayName("every XML column reads into the class bound to its XSD")
    @Test
    void xml_() {
        entityManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList()
                .forEach(c -> {
                    assertThat(c.getInfo().getCid()).as("info of %s", c.getCid())
                            .isEqualTo(BigInteger.valueOf(c.getCid()));
                    assertThat(c.getHistory()).as("history of %s", c.getCid()).isNull();
                });
        entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList()
                .forEach(p -> assertThat(p.getDescription().getPid())
                        .as("description of %s", p.getPid()).isEqualTo(p.getPid()));
        entityManager.createQuery("SELECT o FROM Purchaseorder o", Purchaseorder.class)
                .getResultList()
                .forEach(o -> assertThat(o.getPorder().getPoNum())
                        .as("porder of %s", o.getPoid()).isEqualTo(String.valueOf(o.getPoid())));
        entityManager.createQuery("SELECT s FROM Supplier s", Supplier.class).getResultList()
                .forEach(s -> assertThat(s.getAddr().getSid())
                        .as("addr of %s", s.getSid()).isEqualTo(s.getSid()));
    }

    @DisplayName("every stored document is valid against the schema of its column")
    @Test
    void xml_ValidAgainstXsd_() throws Exception {
        final var customer = XmlSchemaUtils.customerinfo().newValidator();
        final var product = XmlSchemaUtils.product().newValidator();
        final var porder = XmlSchemaUtils.purchaseOrder().newValidator();
        final var supplier = XmlSchemaUtils.supplierinfo().newValidator();
        for (final var c : entityManager.createQuery("SELECT c FROM Customer c", Customer.class)
                .getResultList()) {
            customer.validate(source(new CustomerinfoStringAttributeConverter()
                                             .convertToDatabaseColumn(c.getInfo())));
        }
        for (final var p : entityManager.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList()) {
            product.validate(source(new ProductStringAttributeConverter()
                                            .convertToDatabaseColumn(p.getDescription())));
        }
        for (final var o : entityManager.createQuery("SELECT o FROM Purchaseorder o",
                                                     Purchaseorder.class).getResultList()) {
            porder.validate(source(new PurchaseOrderStringAttributeConverter()
                                           .convertToDatabaseColumn(o.getPorder())));
        }
        for (final var s : entityManager.createQuery("SELECT s FROM Supplier s", Supplier.class)
                .getResultList()) {
            supplier.validate(source(new SupplierinfoStringAttributeConverter()
                                             .convertToDatabaseColumn(s.getAddr())));
        }
    }

    @DisplayName("a random Customer inserts, and its XML column reads back equal")
    @Test
    void customer_Inserts_() {
        final var customer = new Customer_Randomizer().get();
        customer.setCid(9999L);
        final var found = insertAndFind(customer, Customer.class, customer.getCid());
        assertThat(found.getInfo()).isNotNull().isEqualTo(customer.getInfo());
    }

    @DisplayName("a random Product inserts, and its XML column reads back equal")
    @Test
    void product_Inserts_() {
        final var product = new Product_Randomizer().get();
        product.setPid("TEST-00001");
        final var found = insertAndFind(product, Product.class, product.getPid());
        assertThat(found.getDescription()).isNotNull().isEqualTo(product.getDescription());
    }

    @DisplayName("a random Purchaseorder inserts, and its XML column reads back equal")
    @Test
    void purchaseOrder_Inserts_() {
        final var purchaseOrder = new Purchaseorder_Randomizer().get();
        purchaseOrder.setPoid(9999L);
        final var found = insertAndFind(purchaseOrder, Purchaseorder.class,
                                        purchaseOrder.getPoid());
        assertThat(found.getPorder()).isNotNull().isEqualTo(purchaseOrder.getPorder());
    }

    @DisplayName("a random Supplier inserts, and its XML column reads back equal")
    @Test
    void supplier_Inserts_() {
        final var supplier = new Supplier_Randomizer().get();
        supplier.setSid("TEST-001");
        final var found = insertAndFind(supplier, Supplier.class, supplier.getSid());
        assertThat(found.getAddr()).isNotNull().isEqualTo(supplier.getAddr());
    }

    @DisplayName("LOB columns read as bytes and as strings")
    @Test
    void lob_() {
        entityManager.createQuery("SELECT p FROM EmpPhoto p", EmpPhoto.class).getResultList()
                .forEach(p -> assertThat(p.getPicture()).as("picture of %s", p.getId().getEmpno())
                        .isNotEmpty());
        entityManager.createQuery("SELECT r FROM EmpResume r", EmpResume.class).getResultList()
                .forEach(r -> assertThat(r.getResume()).as("resume of %s", r.getId().getEmpno())
                        .contains("Resume"));
    }

    @DisplayName("an @EmbeddedId entity finds by its id, and its @MapsId association resolves")
    @Test
    void embeddedId_() {
        final var photo = entityManager.find(EmpPhoto.class,
                                             EmpPhotoId.of("000130", "bitmap"));
        assertThat(photo).isNotNull();
        assertThat(photo.getEmployee().getLastname()).isEqualTo("QUINTANA");
    }

    // ---------------------------------------------------------------------------------------------
    // persists the specified entity, flushes, clears, and finds it again; all rolled back
    private <T> T insertAndFind(final T entity, final Class<T> type, final Object id) {
        return applyInTransactionAndRollback(em -> {
            em.persist(entity);
            em.flush();
            em.clear();
            final var found = em.find(type, id);
            assertThat(found).as("%s found by %s", type.getSimpleName(), id).isNotNull();
            return found;
        });
    }

    private static Source source(final String text) {
        return new StreamSource(new StringReader(text));
    }

    private <R> R applyInTransactionAndRollback(
            final Function<? super EntityManager, ? extends R> function) {
        final var transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            return function.apply(entityManager);
        } finally {
            transaction.rollback();
        }
    }

    // ---------------------------------------------------------------------------------------------
    @__ItPU
    @Inject
    private EntityManagerFactory entityManagerFactory;

    @__ItPU
    @Inject
    private EntityManager entityManager;
}
