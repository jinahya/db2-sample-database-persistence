-- -
-- #%L
-- db2-sample-database-persistence
-- %%
-- Copyright (C) 2026 Jinahya, Inc.
-- %%
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
--      http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- #L%
-- -
--
-- Exercises at the intermediate level on the schema as a whole, not on a single table: a join, a group, an outer join
-- or a subquery. Each poses a question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/__/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ------------------------------------------------------------------------------ SAMPLE_SCHEMA_I_01
-- the foreign keys of the schema.
-- TABNAME       CONSTNAME     FK_COLNAMES                                      REFTABNAME PK_COLNAMES
-- ------------- ------------- ------------------------------------------------ ---------- ------------------------------------------------
-- ACT           RPAA          ACTNO                                            ACT        ACTNO
-- DEPARTMENT    RDE           MGRNO                                            EMPLOYEE   EMPNO
-- DEPARTMENT    ROD           ADMRDEPT                                         DEPARTMENT DEPTNO
-- EMPLOYEE      RED           WORKDEPT                                         DEPARTMENT DEPTNO
-- EMPPROJACT    REPAPA        PROJNO              ACTNO               EMSTDATE PROJACT    PROJNO              ACTNO               ACSTDATE
-- EMP_PHOTO     FK_EMP_PHOTO  EMPNO                                            EMPLOYEE   EMPNO
-- EMP_RESUME    FK_EMP_RESUME EMPNO                                            EMPLOYEE   EMPNO
-- PROJACT       RPAP          PROJNO                                           PROJECT    PROJNO
-- PROJECT       FK_PROJECT_1  DEPTNO                                           DEPARTMENT DEPTNO
-- PROJECT       FK_PROJECT_2  RESPEMP                                          EMPLOYEE   EMPNO
-- ... 12 rows in all.
SELECT TABNAME, CONSTNAME, FK_COLNAMES, REFTABNAME, PK_COLNAMES
FROM SYSCAT.REFERENCES
WHERE TABSCHEMA = 'DB2INST1'
ORDER BY TABNAME, CONSTNAME
;

-- ------------------------------------------------------------------------------ SAMPLE_SCHEMA_I_02
-- the departments with their employees and projects.
-- DEPTNO DEPTNAME                     EMPLOYEES PROJECTS
-- ------ ---------------------------- --------- --------
-- A00    SPIFFY COMPUTER SERVICE DIV.         5        0
-- B01    PLANNING                             1        1
-- C01    INFORMATION CENTER                   4        2
-- D01    DEVELOPMENT CENTER                   0        2
-- D11    MANUFACTURING SYSTEMS               11        4
-- D21    ADMINISTRATION SYSTEMS               7        4
-- E01    SUPPORT SERVICES                     1        2
-- E11    OPERATIONS                           7        1
-- E21    SOFTWARE SUPPORT                     6        4
-- F22    BRANCH OFFICE F2                     0        0
-- ... 14 rows in all.
SELECT d.DEPTNO, d.DEPTNAME,
       (SELECT COUNT(*) FROM EMPLOYEE e WHERE e.WORKDEPT = d.DEPTNO) AS EMPLOYEES,
       (SELECT COUNT(*) FROM PROJECT p WHERE p.DEPTNO = d.DEPTNO) AS PROJECTS
FROM DEPARTMENT d
ORDER BY d.DEPTNO
;
