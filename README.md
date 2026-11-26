# db2-sample-database-persistence

Jakarta Persistence mappings for the [IBM Db2 `SAMPLE` database](https://www.ibm.com/docs/en/db2/11.5.x?topic=samples-sample-database)
(schema `DB2INST1`).

Sibling of [postgresql-demodb-persistence](https://github.com/jinahya/postgresql-demodb-persistence) and
[oracle-sample-schemas-persistence-mapped](https://github.com/jinahya/oracle-sample-schemas-persistence-mapped).

## What is in it

| | |
| --- | --- |
| `src/main` | one `@MappedSuperclass` per table and view, `Mapped<Table>`, plus a `Mapped<Table>Id` per composite key |
| `src/test` | an `@Entity` extending each, with the declared foreign keys as associations; and, per entity, as in the sibling projects: `<Entity>_Test` (`toString`, `equals`/`hashCode` with EqualsVerifier, accessors), `<Entity>_PersistenceTest` (on H2), `<Entity>_PersistenceIT` (on Db2), and, for each table, `<Entity>_Randomizer` (Podam) and `<Entity>_Persister`, which persists what the entity references first; each id class has a `_Test` and a `_Randomizer` |

All 26 tables and all 18 views are mapped. The views, and `ADEFUSR`, a materialized query table the database
maintains, are mapped read-only: no column is updatable, and none but the identifier's is insertable, which
EclipseLink requires. The `VECTOR` columns (`MLBLOGS_ANSWERS.EMBEDDING`, `MLBLOGS_QUESTIONS.EMBEDDING`,
`PATIENTS.EMBEDDING`) are not mapped. The five aliases (`DEPT`, `EMP`, ...) need no mapping of their own.

A view has no key; each is mapped by a column, or a set of columns, which is unique and not `null` in the data
(`VEMP.EMPNO`, `VPROJACT` by project, activity and start date, ...). `VFORPLA` and `MLBLOGS_ANSWERS` hold rows which
are exact duplicates of one another, so a query returns the same instance for each of them.

Twelve tables declare no primary key; each is mapped by a column, or a set of columns, which is unique and not `null` in
the data `db2sampl` loads (`ORG.DEPTNUMB`, `STAFF.ID`, `SALES` by date, person and region, ...). Nothing in the
database keeps that so; each class says which.

A foreign key column is mapped read-only in the superclass; the entity owns its writable mapping, as an association.
`XML` columns with a registered schema map to classes bound to it (see below), the others to `String`; `BLOB` maps to
`byte[]` and `CLOB` to `String`.

### XML columns

Six columns are `XML`. The four whose schema Db2 registers map to classes which Jakarta XML Binding's `xjc` generates,
at build time, from that XSD, through an `AttributeConverter` which extends `JaxbAttributeConverter.OfString` of
[jinahya-persistence](https://github.com/jinahya/jinahya-persistence). The other two stay `String`.

| Column | Rows (not `null`) | Registered schema | XSD | Root element | Namespace | Attribute type | Converter |
| --- | --- | --- | --- | --- | --- | --- | --- |
| `CUSTOMER.INFO` | 6 (6) | `DB2INST1.CUSTOMER` | `customer.xsd` | `customerinfo` | none | `xml.customer.Customerinfo` | `CustomerinfoStringAttributeConverter` |
| `CUSTOMER.HISTORY` | 6 (0) | none | | | | `String` | |
| `PRODUCT.DESCRIPTION` | 4 (4) | `DB2INST1.PRODUCT` | `product.xsd` | `product` | none | `xml.product.Product` | `ProductStringAttributeConverter` |
| `PURCHASEORDER.PORDER` | 6 (6) | `DB2INST1.PORDER` | `porder.xsd` | `PurchaseOrder` | none | `xml.porder.PurchaseOrder` | `PurchaseOrderStringAttributeConverter` |
| `SUPPLIERS.ADDR` | 2 (2) | `DB2INST1.SUPPLIER` | `supplier.xsd` | `supplierinfo` | `http://posample.org` | `xml.supplier.Supplierinfo` | `SupplierinfoStringAttributeConverter` |
| `CATALOG.CATLOG` | 0 (0) | none | | | | `String` | |

* **The XSDs.** Copied unchanged from `/opt/ibm/db2/V12.1/samples/db2sampl/` of the image, they are in
  `src/main/resources`, each in the package of its classes, and ship in the jar, so that a downstream project can
  validate against them (`Customerinfo.class.getResource("customer.xsd")`). The packages are opened. IBM's terms are in
  `NOTICE.txt` beside them. `addr.xsd`, also in the image, describes the `addr` element of `customerinfo` and
  `supplierinfo`, not a column, and is left out.
* **Registered schemas only.** The four XSDs are the ones registered in the database's XML schema repository
  (`SYSCAT.XSROBJECTS`), and every document stored in their columns was validated against them when `db2sampl` loaded
  the data (`XMLXSROBJECTID`). `PersistenceUnit_IT` validates each of them again against the XSD on the class path.
* **`history.xsd` and `catalog.xsd` are left out.** The image also has them, for `CUSTOMER.HISTORY` and
  `CATALOG.CATLOG`, but Db2 registers neither, no sample uses either, and neither column holds a document;
  `history.xsd` is not even a valid schema (its global element carries `minOccurs` and `maxOccurs`). Both columns map
  to `String`.
* **The database does not enforce the schemas.** No table has a check constraint (`IS VALIDATED ACCORDING TO`), so a
  write is only checked for being well-formed, and a document written through an entity is stored with no schema
  recorded against it. The bound classes do not validate either; a downstream project which needs it validates
  against the XSDs.
* **Value equality.** The classes are generated with `-Xequals` and `-XhashCode` (`jaxb-plugins-runtime`), so that a
  provider sees an unchanged document as unchanged rather than dirty.
* **Both providers.** The converters are listed in `persistence.xml`, which EclipseLink requires. Each also declares
  `AttributeConverter<T, String>` itself, though `OfString` implements it already: EclipseLink takes the column type
  from the interface the converter class declares, and without it binds the attribute, not its text, on insert.

## The database

```shell
$ docker compose up -d
$ docker logs -f db2-sample-database-persistence    # wait for "(*) Setup has completed."
```

Brings up `icr.io/db2_community/db2` on `localhost:50000`, as `db2inst1` / `abcD1234!`, with the `SAMPLE` database
created on first start (`SAMPLEDB=true`). The image is `linux/amd64` only; on Apple Silicon it runs emulated and the
first start takes a few minutes. Data lives in the `database` volume; `docker compose down -v` throws it away.

The compose file also runs the [Db2 Data Management Console](https://www.ibm.com/docs/en/db2-data-mgr-console) at
https://localhost:11080/console (`admin` / `abcD1234!`), which keeps its own repository in a database of its own.

```shell
$ docker exec -it db2-sample-database-persistence su - db2inst1 -c 'db2 connect to sample && db2 "select * from employee"'
```

## Building

Two persistence providers, one profile each; `jakarta-ee-11-hibernate-orm` is active by default. Building the tests
needs JDK 25 or newer.

```shell
$ ./_mvn_jakarta_ee_11_test_hibernate-orm.sh              # unit tests, H2 in DB2 mode
$ ./_mvn_jakarta_ee_11_test_eclipselink.sh
$ ./_mvn_jakarta_ee_11_verify_hibernate-orm.sh            # + integration tests, against the database above
$ ./_mvn_jakarta_ee_11_verify_eclipselink.sh
$ ./_mvn_jakarta_ee_11_verify_notests_hibernate-orm.sh    # no database needed
$ ./_mvn_jakarta_ee_11_verify_notests_eclipselink.sh
```
