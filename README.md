# db2-sample-database-persistence

Jakarta Persistence mappings for the [IBM Db2 `SAMPLE` database](https://www.ibm.com/docs/en/db2/12.1.x?topic=samples-sample-database)
(schema `DB2INST1`).

Sibling of [postgresql-demodb-persistence](https://github.com/jinahya/postgresql-demodb-persistence) and
[oracle-sample-schemas-persistence-mapped](https://github.com/jinahya/oracle-sample-schemas-persistence-mapped).

## What is in it

| | |
| --- | --- |
| `src/main` | one `@MappedSuperclass` per table and view, `Mapped<Table>`, plus a `Mapped<Table>Id` per composite key |
| `src/test` | an `@Entity` extending each, but for the fifteen with no key (below), with the declared foreign keys as associations, and four which no foreign key declares (below); and, per entity, as in the sibling projects: `<Entity>_Test` (`toString`, `equals`/`hashCode` with EqualsVerifier, accessors), `<Entity>_PersistenceTest` (on H2), `<Entity>_PersistenceIT` (on Db2), and, for each table, `<Entity>_Randomizer` (Podam) and `<Entity>_Persister`, which persists what the entity references first; each id class has a `_Test` and a `_Randomizer` |

All 26 tables and all 18 views are mapped. The views, and `ADEFUSR`, a materialized query table the database
maintains, are mapped read-only: no column is updatable, and none but the identifier's is insertable, which
EclipseLink requires. The `VECTOR` columns map to `float[]` (see below). The five aliases (`DEPT`, `EMP`, ...) need
no mapping of their own.

Twelve tables declare no primary key, and a view has none. A view whose definition carries the key of what it selects
from is an entity, by that key; the twelve tables, and the three views which select from a table with no key, have
none, and are plain classes, built from the rows of a native query. See
[Tables and views with no key](#tables-and-views-with-no-key).

A foreign key column is mapped read-only in the superclass; the entity owns its writable mapping, as an association.
Four associations have no declared foreign key under them: `PRODUCTSUPPLIER`'s `PID` and `SID`, `INVENTORY`'s `PID`,
and `PROJACT`'s `ACTNO`, which name a product, a supplier and an activity by the tables' names and columns, and do so
in every installed row; the database declares no foreign key among the XML tables but `PURCHASEORDER`'s to `CUSTOMER`,
and `PROJACT`'s only to `PROJECT`.
The tables with a composite key whose columns name other rows, `EMP_PHOTO`, `EMP_RESUME`, `PROJACT` and
`PRODUCTSUPPLIER`, map it as an `@EmbeddedId`, each column which names another row by a `@MapsId` association; the
id class's `from` builds an identifier from the entities it names. `Inventory` maps its product read-only over `PID`,
its identifier, which `setProduct` keeps in step.
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
  validate against them: `XmlSchemaUtils` loads each once, as a shared `Schema`
  (`XmlSchemaUtils.customerinfo().newValidator()`). The packages are opened. IBM's terms are in
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

### VECTOR columns

Three columns are `VECTOR(n, FLOAT32)`, the embeddings of a vector search example: `MLBLOGS_QUESTIONS.EMBEDDING` and
`MLBLOGS_ANSWERS.EMBEDDING` (`1024`), of the text in the same row, and `PATIENTS.EMBEDDING` (`768`). Each maps to a
`float[]` through `VectorStringAttributeConverter`, an `AttributeConverter<float[], String>`.

* **The string form.** Db2 stores a vector in binary, but hands it to an application as text, `[0.12,-0.03,...]`:
  the JDBC driver reports the column as a `VARCHAR`, reads it with `getString` and binds it with `setString`; it reads
  or binds it neither as `byte[]` nor as `float[]`. The converter writes each coordinate with `Float.toString` and
  parses it with `Float.parseFloat`, and every value Db2 accepts reads back bit-exact. Db2 rejects `NaN`, the
  infinities, the subnormal values, `Float.MAX_VALUE` and a vector of another dimension (`SQLCODE -420`, `-302`).
* **Copies.** The getter returns a copy and the setter keeps one, so the value changes only through the setter:
  EclipseLink does not see a change made to the elements of a converted array, Hibernate ORM does.
* **No vector functions.** Jakarta Persistence has none, so a similarity search, `VECTOR_DISTANCE(...)`, is a native
  query. Hibernate ORM's `hibernate-vector` (`@JdbcTypeCode(SqlTypes.VECTOR_FLOAT32)`) maps the type and its
  functions on Db2 too, but it is Hibernate ORM's own, and has no type for H2, on which the `test` unit runs.
* **What the embeddings are.** They come with the database; which model made them is not recorded, so a new text
  cannot be embedded to compare with them.

### Tables and views with no key

An entity needs an identifier. Twelve tables declare no primary key, and a view has none; none of them is given one
which the data merely happens to keep unique. A view is an entity when its definition carries the key of what it
selects from, unchanged: a key, or a join which matches each row with one row at most. The others map no identifier:
the class extending `Mapped<Table>` is not an entity, is listed in no persistence unit, and is built from the rows of
a native query: `SELECT ` + `SELECT_LIST`, a constant of the columns in their order, gives each row as an `Object[]`,
which the class's public constructor converts and hands to the protected all-columns constructor of `Mapped<Table>`
(`NoKey_PersistenceIT` reads every row so). Its `equals` and `hashCode` are `Object`'s, by identity. Its `_PersistenceIT` selects a random row with a
native `COUNT(*)` and a native `SELECT *` at a random offset (`selectRandomRow__`), and persists nothing; its
`_PersistenceTest`, on H2, where no table is generated for it, and its `_Test`'s `equals_verify_`, are disabled.

The views which are entities (`DEPT`, `EMP` and `PROJ` are aliases of `DEPARTMENT`, `EMPLOYEE` and `PROJECT`):

| View | Identifier | Key, by the definition |
| --- | --- | --- |
| `VACT` | `ACTNO` | `SELECT ... FROM ACT`: the key of `ACT` |
| `VDEPT`, `VHDEPT` | `DEPTNO` | `SELECT ... FROM DEPT`: the key of `DEPARTMENT` |
| `VDEPMG1` | `DEPTNO` | `DEPT LEFT OUTER JOIN EMP ON MGRNO = EMPNO`: an employee at most per department |
| `VEMP` | `EMPNO` | `SELECT ... FROM EMP`: the key of `EMPLOYEE` |
| `VEMPLP` | `EMPLOYEENUMBER` | `EMPNO` of `EMP`, renamed |
| `VEMPDPT1` | `EMPNO` | `DEPT RIGHT OUTER JOIN EMP ON WORKDEPT = DEPTNO`: a department at most per employee |
| `VPHONE` | `EMPLOYEENUMBER` | `EMP, DEPT WHERE WORKDEPT = DEPTNO`: the one department of each employee |
| `VPROJ` | `PROJNO` | `SELECT ... FROM PROJ`: the key of `PROJECT` |
| `VPROJRE1` | `PROJNO` | `PROJ, EMP WHERE RESPEMP = EMPNO`: the one responsible employee of each project |
| `VPSTRDE1` | `PROJ1NO`, `PROJ2NO` | `VPROJRE1 P1, VPROJRE1 P2 WHERE P1.PROJNO = P2.MAJPROJ`: a project and a subproject of it |
| `VPSTRDE2` | `PROJ1NO` | `VPROJRE1 P1 WHERE NOT EXISTS (...)`: each project with no subproject, once |
| `VASTRDE1` | `DEPT1NO`, `DEPT2NO` | `VDEPMG1 D1, VDEPMG1 D2 WHERE D1.DEPTNO = D2.ADMRDEPT`: a department and one it administers |
| `VASTRDE2` | `DEPT1NO`, `EMP2NO` | `VDEPMG1 D1, EMP E2 WHERE D1.DEPTNO = E2.WORKDEPT`: a department and an employee in it |
| `VPROJACT` | `PROJNO`, `ACTNO`, `ACSTDATE` | `SELECT ... FROM PROJACT`: the key of `PROJACT` |
| `VSTAFAC1` | `PROJNO`, `ACTNO`, `STDATE` | `PROJACT PA, ACT AC WHERE PA.ACTNO = AC.ACTNO`: the key of `PROJACT`, `ACSTDATE` renamed |

The tables and views which are not entities, with what the installed data alone would suggest, and why it is no key:

| Table or view | Unique in the data | Why no key |
| --- | --- | --- |
| `ADEFUSR` | `WORKDEPT` | the materialized query table groups by it, but it is nullable |
| `CL_SCHED` | `CLASS_CODE` | "Class Code (room:teacher)": a class may meet on more than one day |
| `EMPMDC` | `EMPNO` | the name only; a [multidimensional clustering (MDC)](https://www.ibm.com/docs/en/db2/12.1.x?topic=tables-table-index-management-mdc-itc) table, organized by `DIV` and `DEPT`, whose three indexes are the block indexes of those dimensions, none unique |
| `EMPPROJACT` | `EMPNO`, `PROJNO`, `ACTNO`, `EMSTDATE` | its foreign key `REPAPA` names a row of `PROJACT`, not one of its own; `EMSTDATE` is nullable |
| `IN_TRAY` | `RECEIVED` | "Date and Time received"; nullable |
| `MLBLOGS_ANSWERS` | none | 108 rows, 105 answers: the duplicates are whole-row copies |
| `MLBLOGS_QUESTIONS` | `QUESTION` | the text only; nullable |
| `ORG` | `DEPTNUMB` | "Department number", `NOT NULL`, but declared no key |
| `PATIENTS` | `PATIENT_ID` | the name only; nullable |
| `SALES` | `SALES_DATE`, `SALES_PERSON`, `REGION` | no column, or set of them, is a key by what it describes; nullable |
| `STAFF`, `STAFFG` | `ID` | "Employee number", `NOT NULL`, but declared no key |
| `VEMPPROJACT` | `EMPNO`, `PROJNO`, `ACTNO`, `EMSTDATE` | selects from `EMPPROJACT`, which has no key |
| `VSTAFAC2` | `PROJNO`, `ACTNO`, `EMPNO`, `STDATE` | selects from `EMPPROJACT`, which has no key |
| `VFORPLA` | none | repeats a project once per row of `EMPPROJACT`: 14 projects in 68 rows |

The `IDENTIFIER` section of each one's `src/test/sql/<NAME>.sql` checks what the data shares.

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

Two persistence providers, one profile each; `jakartaee-11-hibernate-orm` is active by default. Building the tests
needs JDK 25 or newer.

```shell
$ ./_mvn_jakarta_ee_11_test_hibernate-orm.sh              # unit tests, H2 in DB2 mode
$ ./_mvn_jakarta_ee_11_test_eclipselink.sh
$ ./_mvn_jakarta_ee_11_verify_hibernate-orm.sh            # + integration tests, against the database above
$ ./_mvn_jakarta_ee_11_verify_eclipselink.sh
$ ./_mvn_jakarta_ee_11_verify_notests_hibernate-orm.sh    # no database needed
$ ./_mvn_jakarta_ee_11_verify_notests_eclipselink.sh
```
