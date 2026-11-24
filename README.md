# db2-sample-database-persistence

Jakarta Persistence mappings for the [IBM Db2 `SAMPLE` database](https://www.ibm.com/docs/en/db2/11.5.x?topic=samples-sample-database)
(schema `DB2INST1`).

Sibling of [postgresql-demodb-persistence](https://github.com/jinahya/postgresql-demodb-persistence) and
[oracle-sample-schemas-persistence-mapped](https://github.com/jinahya/oracle-sample-schemas-persistence-mapped).

## What is in it

| | |
| --- | --- |
| `src/main` | one `@MappedSuperclass` per table, `Mapped<Table>`, plus a `Mapped<Table>Id` per composite key |
| `src/test` | an `@Entity` extending each, with the declared foreign keys as associations |

23 of the 26 tables are mapped. `MLBLOGS_ANSWERS` and `MLBLOGS_QUESTIONS` have no key and little but a `VECTOR`
column, and `ADEFUSR` is a materialized query table; `PATIENTS.EMBEDDING`, a `VECTOR`, is not mapped either.

Nine tables declare no primary key; each is mapped by a column, or a set of columns, which is unique and not `null` in
the data `db2sampl` loads (`ORG.DEPTNUMB`, `STAFF.ID`, `SALES` by date, person and region, ...). Nothing in the
database keeps that so; each class says which.

A foreign key column is mapped read-only in the superclass; the entity owns its writable mapping, as an association.
`XML` columns map to `String`, `BLOB` to `byte[]` and `CLOB` to `String`.

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
