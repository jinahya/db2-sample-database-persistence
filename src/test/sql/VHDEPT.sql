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
-- Profiling queries on VHDEPT, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VHDEPT.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VHDEPT.sql'
--

-- how many rows; 14.
SELECT COUNT(*)
FROM VHDEPT
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, DEPTNO, of a view, which has no key: the values which more than one row
-- shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT DEPTNO, COUNT(*)
FROM VHDEPT
GROUP BY DEPTNO
HAVING COUNT(*) > 1
;


-- -------------------------------------------------------------------------------------------------------------- DEPTNO
-- the shortest and the longest DEPTNO, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNO))), MAX(LENGTH(RTRIM(DEPTNO)))
FROM VHDEPT
;

-- rows whose DEPTNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every DEPTNO is trimmed and not blank.
SELECT DEPTNO, '[' || DEPTNO || ']' AS BRACKETED
FROM VHDEPT
WHERE RTRIM(DEPTNO) = ''
   OR DEPTNO <> LTRIM(DEPTNO)
;


-- ------------------------------------------------------------------------------------------------------------ DEPTNAME
-- the shortest and the longest DEPTNAME, trailing spaces trimmed; 8 to 28 characters, of VARCHAR(36) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNAME))), MAX(LENGTH(RTRIM(DEPTNAME)))
FROM VHDEPT
;

-- rows whose DEPTNAME is blank, or carries leading or trailing spaces.
-- no rows: every DEPTNAME is trimmed and not blank.
SELECT DEPTNAME, '[' || DEPTNAME || ']' AS BRACKETED
FROM VHDEPT
WHERE RTRIM(DEPTNAME) = ''
   OR DEPTNAME <> LTRIM(DEPTNAME)
   OR LENGTH(DEPTNAME) <> LENGTH(RTRIM(DEPTNAME))
;


-- --------------------------------------------------------------------------------------------------------------- MGRNO
-- the shortest and the longest MGRNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(MGRNO))), MAX(LENGTH(RTRIM(MGRNO)))
FROM VHDEPT
;

-- rows whose MGRNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every MGRNO is trimmed and not blank.
SELECT MGRNO, '[' || MGRNO || ']' AS BRACKETED
FROM VHDEPT
WHERE RTRIM(MGRNO) = ''
   OR MGRNO <> LTRIM(MGRNO)
;

-- how many rows have no MGRNO; 6 of 14.
SELECT COUNT(*) - COUNT(MGRNO), COUNT(*)
FROM VHDEPT
;


-- ------------------------------------------------------------------------------------------------------------ ADMRDEPT
-- the shortest and the longest ADMRDEPT, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(ADMRDEPT))), MAX(LENGTH(RTRIM(ADMRDEPT)))
FROM VHDEPT
;

-- rows whose ADMRDEPT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every ADMRDEPT is trimmed and not blank.
SELECT ADMRDEPT, '[' || ADMRDEPT || ']' AS BRACKETED
FROM VHDEPT
WHERE RTRIM(ADMRDEPT) = ''
   OR ADMRDEPT <> LTRIM(ADMRDEPT)
;


-- ------------------------------------------------------------------------------------------------------------ LOCATION
-- the shortest and the longest LOCATION; no value, of CHARACTER(16) declared.
SELECT MIN(LENGTH(RTRIM(LOCATION))), MAX(LENGTH(RTRIM(LOCATION)))
FROM VHDEPT
;

-- rows whose LOCATION is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every LOCATION is trimmed and not blank.
SELECT LOCATION, '[' || LOCATION || ']' AS BRACKETED
FROM VHDEPT
WHERE RTRIM(LOCATION) = ''
   OR LOCATION <> LTRIM(LOCATION)
;

-- how many rows have no LOCATION; 14 of 14.
SELECT COUNT(*) - COUNT(LOCATION), COUNT(*)
FROM VHDEPT
;

