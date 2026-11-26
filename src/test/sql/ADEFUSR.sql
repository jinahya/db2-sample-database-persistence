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
-- Profiling queries on ADEFUSR, a materialized query table, a section per column. Each says what it looks for and what
-- the installed data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/ADEFUSR.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/ADEFUSR.sql'
--

-- how many rows; 8.
SELECT COUNT(*)
FROM ADEFUSR
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- this materialized query table declares no primary key, and is mapped as no entity, with no identifier. WORKDEPT,
-- which the data alone would suggest as one: the values which more than one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT WORKDEPT, COUNT(*)
FROM ADEFUSR
GROUP BY WORKDEPT
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------------------------ WORKDEPT
-- the shortest and the longest WORKDEPT, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(WORKDEPT))), MAX(LENGTH(RTRIM(WORKDEPT)))
FROM ADEFUSR
;

-- rows whose WORKDEPT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every WORKDEPT is trimmed and not blank.
SELECT WORKDEPT, '[' || WORKDEPT || ']' AS BRACKETED
FROM ADEFUSR
WHERE RTRIM(WORKDEPT) = ''
   OR WORKDEPT <> LTRIM(WORKDEPT)
;

-- how many rows have no WORKDEPT; 0 of 8.
SELECT COUNT(*) - COUNT(WORKDEPT), COUNT(*)
FROM ADEFUSR
;


-- ----------------------------------------------------------------------------------------------------- NO_OF_EMPLOYEES
-- the smallest and the largest NO_OF_EMPLOYEES; 1 and 11.
SELECT MIN(NO_OF_EMPLOYEES), MAX(NO_OF_EMPLOYEES)
FROM ADEFUSR
;

