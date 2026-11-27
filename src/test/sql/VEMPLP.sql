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
-- Profiling queries on VEMPLP, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VEMPLP.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VEMPLP.sql'
--

-- how many rows; 42.
SELECT COUNT(*)
FROM VEMPLP
;


-- -------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, EMPLOYEENUMBER, of a view, which has no key: the values which more than one
-- row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT EMPLOYEENUMBER, COUNT(*)
FROM VEMPLP
GROUP BY EMPLOYEENUMBER
HAVING COUNT(*) > 1
;


-- ---------------------------------------------------------------------------------- EMPLOYEENUMBER
-- the shortest and the longest EMPLOYEENUMBER, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPLOYEENUMBER))), MAX(LENGTH(RTRIM(EMPLOYEENUMBER)))
FROM VEMPLP
;

-- rows whose EMPLOYEENUMBER is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does
-- not count).
-- no rows: every EMPLOYEENUMBER is trimmed and not blank.
SELECT EMPLOYEENUMBER, '[' || EMPLOYEENUMBER || ']' AS BRACKETED
FROM VEMPLP
WHERE RTRIM(EMPLOYEENUMBER) = ''
   OR EMPLOYEENUMBER <> LTRIM(EMPLOYEENUMBER)
;


-- ------------------------------------------------------------------------------------- PHONENUMBER
-- the shortest and the longest PHONENUMBER, trailing spaces trimmed; always 4 characters, of CHARACTER(4) declared.
SELECT MIN(LENGTH(RTRIM(PHONENUMBER))), MAX(LENGTH(RTRIM(PHONENUMBER)))
FROM VEMPLP
;

-- rows whose PHONENUMBER is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PHONENUMBER is trimmed and not blank.
SELECT PHONENUMBER, '[' || PHONENUMBER || ']' AS BRACKETED
FROM VEMPLP
WHERE RTRIM(PHONENUMBER) = ''
   OR PHONENUMBER <> LTRIM(PHONENUMBER)
;

-- how many rows have no PHONENUMBER; 0 of 42.
SELECT COUNT(*) - COUNT(PHONENUMBER), COUNT(*)
FROM VEMPLP
;

