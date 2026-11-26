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
-- Profiling queries on VEMP, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VEMP.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VEMP.sql'
--

-- how many rows; 42.
SELECT COUNT(*)
FROM VEMP
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, EMPNO, of a view, which has no key: the values which more than one row
-- shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT EMPNO, COUNT(*)
FROM VEMP
GROUP BY EMPNO
HAVING COUNT(*) > 1
;


-- --------------------------------------------------------------------------------------------------------------- EMPNO
-- the shortest and the longest EMPNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPNO))), MAX(LENGTH(RTRIM(EMPNO)))
FROM VEMP
;

-- rows whose EMPNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMPNO is trimmed and not blank.
SELECT EMPNO, '[' || EMPNO || ']' AS BRACKETED
FROM VEMP
WHERE RTRIM(EMPNO) = ''
   OR EMPNO <> LTRIM(EMPNO)
;


-- ------------------------------------------------------------------------------------------------------------ FIRSTNME
-- the shortest and the longest FIRSTNME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(FIRSTNME))), MAX(LENGTH(RTRIM(FIRSTNME)))
FROM VEMP
;

-- rows whose FIRSTNME is blank, or carries leading or trailing spaces.
-- no rows: every FIRSTNME is trimmed and not blank.
SELECT FIRSTNME, '[' || FIRSTNME || ']' AS BRACKETED
FROM VEMP
WHERE RTRIM(FIRSTNME) = ''
   OR FIRSTNME <> LTRIM(FIRSTNME)
   OR LENGTH(FIRSTNME) <> LENGTH(RTRIM(FIRSTNME))
;


-- ------------------------------------------------------------------------------------------------------------- MIDINIT
-- the shortest and the longest MIDINIT, trailing spaces trimmed; 0 to 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDINIT))), MAX(LENGTH(RTRIM(MIDINIT)))
FROM VEMP
;

-- rows whose MIDINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- 7 rows have a blank or padded MIDINIT; the view copies EMPLOYEE.MIDINIT, which is blank for an employee with no
-- middle initial.
SELECT MIDINIT, '[' || MIDINIT || ']' AS BRACKETED
FROM VEMP
WHERE RTRIM(MIDINIT) = ''
   OR MIDINIT <> LTRIM(MIDINIT)
;

-- how many rows have no MIDINIT; 0 of 42.
SELECT COUNT(*) - COUNT(MIDINIT), COUNT(*)
FROM VEMP
;


-- ------------------------------------------------------------------------------------------------------------ LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; 3 to 10 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM VEMP
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- no rows: every LASTNAME is trimmed and not blank.
SELECT LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM VEMP
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;


-- ------------------------------------------------------------------------------------------------------------ WORKDEPT
-- the shortest and the longest WORKDEPT, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(WORKDEPT))), MAX(LENGTH(RTRIM(WORKDEPT)))
FROM VEMP
;

-- rows whose WORKDEPT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every WORKDEPT is trimmed and not blank.
SELECT WORKDEPT, '[' || WORKDEPT || ']' AS BRACKETED
FROM VEMP
WHERE RTRIM(WORKDEPT) = ''
   OR WORKDEPT <> LTRIM(WORKDEPT)
;

-- how many rows have no WORKDEPT; 0 of 42.
SELECT COUNT(*) - COUNT(WORKDEPT), COUNT(*)
FROM VEMP
;

