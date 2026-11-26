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
-- Profiling queries on STAFFG, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/STAFFG.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/STAFFG.sql'
--

-- how many rows; 35.
SELECT COUNT(*)
FROM STAFFG
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, ID, of a table, which declares no primary key: the values which more than one
-- row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT ID, COUNT(*)
FROM STAFFG
GROUP BY ID
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------------------------------ ID
-- the smallest and the largest ID; 10 and 350.
SELECT MIN(ID), MAX(ID)
FROM STAFFG
;


-- ---------------------------------------------------------------------------------------------------------------- NAME
-- the shortest and the longest NAME, trailing spaces trimmed; 2 to 9 characters, of VARGRAPHIC(9) declared.
SELECT MIN(LENGTH(RTRIM(NAME))), MAX(LENGTH(RTRIM(NAME)))
FROM STAFFG
;

-- rows whose NAME is blank, or carries leading or trailing spaces.
-- no rows: every NAME is trimmed and not blank.
SELECT NAME, '[' || NAME || ']' AS BRACKETED
FROM STAFFG
WHERE RTRIM(NAME) = ''
   OR NAME <> LTRIM(NAME)
   OR LENGTH(NAME) <> LENGTH(RTRIM(NAME))
;

-- how many rows have no NAME; 0 of 35.
SELECT COUNT(*) - COUNT(NAME), COUNT(*)
FROM STAFFG
;


-- ---------------------------------------------------------------------------------------------------------------- DEPT
-- the smallest and the largest DEPT; 10 and 84.
SELECT MIN(DEPT), MAX(DEPT)
FROM STAFFG
;

-- how many rows have no DEPT; 0 of 35.
SELECT COUNT(*) - COUNT(DEPT), COUNT(*)
FROM STAFFG
;


-- ----------------------------------------------------------------------------------------------------------------- JOB
-- the shortest and the longest JOB, trailing spaces trimmed; 3 to 5 characters, of GRAPHIC(5) declared.
SELECT MIN(LENGTH(RTRIM(JOB))), MAX(LENGTH(RTRIM(JOB)))
FROM STAFFG
;

-- rows whose JOB is blank, or carries leading spaces (GRAPHIC pads with trailing spaces, which this does not count).
-- no rows: every JOB is trimmed and not blank.
SELECT JOB, '[' || JOB || ']' AS BRACKETED
FROM STAFFG
WHERE RTRIM(JOB) = ''
   OR JOB <> LTRIM(JOB)
;

-- how many rows have no JOB; 0 of 35.
SELECT COUNT(*) - COUNT(JOB), COUNT(*)
FROM STAFFG
;


-- --------------------------------------------------------------------------------------------------------------- YEARS
-- the smallest and the largest YEARS; 1 and 13.
SELECT MIN(YEARS), MAX(YEARS)
FROM STAFFG
;

-- how many rows have no YEARS; 4 of 35.
SELECT COUNT(*) - COUNT(YEARS), COUNT(*)
FROM STAFFG
;


-- -------------------------------------------------------------------------------------------------------------- SALARY
-- the smallest and the largest SALARY; 10505. and 22959..
SELECT MIN(SALARY), MAX(SALARY)
FROM STAFFG
;

-- how many rows have no SALARY; 0 of 35.
SELECT COUNT(*) - COUNT(SALARY), COUNT(*)
FROM STAFFG
;


-- ---------------------------------------------------------------------------------------------------------------- COMM
-- the smallest and the largest COMM; 55. and 1386..
SELECT MIN(COMM), MAX(COMM)
FROM STAFFG
;

-- how many rows have no COMM; 11 of 35.
SELECT COUNT(*) - COUNT(COMM), COUNT(*)
FROM STAFFG
;

