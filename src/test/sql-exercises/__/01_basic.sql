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
-- Exercises at the basic level on the schema as a whole, not on a single table: a filter, a sort, a count or the first
-- rows. Each poses a question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/__/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ------------------------------------------------------------------------------ SAMPLE_SCHEMA_B_01
-- the tables and the views of the schema.
-- TABNAME           TYPE
-- ----------------- ----
-- ADEFUSR           S
-- ACT               T
-- CATALOG           T
-- CL_SCHED          T
-- CUSTOMER          T
-- DEPARTMENT        T
-- EMPLOYEE          T
-- EMPMDC            T
-- EMPPROJACT        T
-- EMP_PHOTO         T
-- ... 45 rows in all.
SELECT TABNAME, TYPE
FROM SYSCAT.TABLES
WHERE TABSCHEMA = 'DB2INST1'
  AND TYPE IN ('T', 'V', 'S')
ORDER BY TYPE, TABNAME
;

-- ------------------------------------------------------------------------------ SAMPLE_SCHEMA_B_02
-- the columns of EMPLOYEE.
-- COLNAME   TYPENAME  LENGTH SCALE NULLS
-- --------- --------- ------ ----- -----
-- EMPNO     CHARACTER      6     0 N
-- FIRSTNME  VARCHAR       12     0 N
-- MIDINIT   CHARACTER      1     0 Y
-- LASTNAME  VARCHAR       15     0 N
-- WORKDEPT  CHARACTER      3     0 Y
-- PHONENO   CHARACTER      4     0 Y
-- HIREDATE  DATE           4     0 Y
-- JOB       CHARACTER      8     0 Y
-- EDLEVEL   SMALLINT       2     0 N
-- SEX       CHARACTER      1     0 Y
-- ... 14 rows in all.
SELECT COLNAME, TYPENAME, LENGTH, SCALE, NULLS
FROM SYSCAT.COLUMNS
WHERE TABSCHEMA = 'DB2INST1'
  AND TABNAME = 'EMPLOYEE'
ORDER BY COLNO
;
