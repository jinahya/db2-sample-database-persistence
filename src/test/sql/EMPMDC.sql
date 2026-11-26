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
-- Profiling queries on EMPMDC, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/EMPMDC.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/EMPMDC.sql'
--

-- how many rows; 10000.
SELECT COUNT(*)
FROM EMPMDC
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, EMPNO, of a table, which declares no primary key: the values which more than
-- one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT EMPNO, COUNT(*)
FROM EMPMDC
GROUP BY EMPNO
HAVING COUNT(*) > 1
;


-- --------------------------------------------------------------------------------------------------------------- EMPNO
-- the smallest and the largest EMPNO; 0 and 9999.
SELECT MIN(EMPNO), MAX(EMPNO)
FROM EMPMDC
;

-- how many rows have no EMPNO; 0 of 10000.
SELECT COUNT(*) - COUNT(EMPNO), COUNT(*)
FROM EMPMDC
;


-- ---------------------------------------------------------------------------------------------------------------- DEPT
-- the smallest and the largest DEPT; 1 and 5.
SELECT MIN(DEPT), MAX(DEPT)
FROM EMPMDC
;

-- how many rows have no DEPT; 0 of 10000.
SELECT COUNT(*) - COUNT(DEPT), COUNT(*)
FROM EMPMDC
;


-- ----------------------------------------------------------------------------------------------------------------- DIV
-- the smallest and the largest DIV; 1 and 10.
SELECT MIN(DIV), MAX(DIV)
FROM EMPMDC
;

-- how many rows have no DIV; 0 of 10000.
SELECT COUNT(*) - COUNT(DIV), COUNT(*)
FROM EMPMDC
;

