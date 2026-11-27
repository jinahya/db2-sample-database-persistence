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
-- Profiling queries on VPROJRE1, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VPROJRE1.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VPROJRE1.sql'
--

-- how many rows; 20.
SELECT COUNT(*)
FROM VPROJRE1
;


-- -------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, PROJNO, of a view, which has no key: the values which more than one row
-- shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT PROJNO, COUNT(*)
FROM VPROJRE1
GROUP BY PROJNO
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------ PROJNO
-- the shortest and the longest PROJNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJNO))), MAX(LENGTH(RTRIM(PROJNO)))
FROM VPROJRE1
;

-- rows whose PROJNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJNO is trimmed and not blank.
SELECT PROJNO, '[' || PROJNO || ']' AS BRACKETED
FROM VPROJRE1
WHERE RTRIM(PROJNO) = ''
   OR PROJNO <> LTRIM(PROJNO)
;


-- ---------------------------------------------------------------------------------------- PROJNAME
-- the shortest and the longest PROJNAME, trailing spaces trimmed; 9 to 21 characters, of VARCHAR(24) declared.
SELECT MIN(LENGTH(RTRIM(PROJNAME))), MAX(LENGTH(RTRIM(PROJNAME)))
FROM VPROJRE1
;

-- rows whose PROJNAME is blank, or carries leading or trailing spaces.
-- no rows: every PROJNAME is trimmed and not blank.
SELECT PROJNAME, '[' || PROJNAME || ']' AS BRACKETED
FROM VPROJRE1
WHERE RTRIM(PROJNAME) = ''
   OR PROJNAME <> LTRIM(PROJNAME)
   OR LENGTH(PROJNAME) <> LENGTH(RTRIM(PROJNAME))
;


-- ----------------------------------------------------------------------------------------- PROJDEP
-- the shortest and the longest PROJDEP, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(PROJDEP))), MAX(LENGTH(RTRIM(PROJDEP)))
FROM VPROJRE1
;

-- rows whose PROJDEP is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJDEP is trimmed and not blank.
SELECT PROJDEP, '[' || PROJDEP || ']' AS BRACKETED
FROM VPROJRE1
WHERE RTRIM(PROJDEP) = ''
   OR PROJDEP <> LTRIM(PROJDEP)
;


-- ----------------------------------------------------------------------------------------- RESPEMP
-- the shortest and the longest RESPEMP, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(RESPEMP))), MAX(LENGTH(RTRIM(RESPEMP)))
FROM VPROJRE1
;

-- rows whose RESPEMP is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every RESPEMP is trimmed and not blank.
SELECT RESPEMP, '[' || RESPEMP || ']' AS BRACKETED
FROM VPROJRE1
WHERE RTRIM(RESPEMP) = ''
   OR RESPEMP <> LTRIM(RESPEMP)
;


-- ---------------------------------------------------------------------------------------- FIRSTNME
-- the shortest and the longest FIRSTNME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(FIRSTNME))), MAX(LENGTH(RTRIM(FIRSTNME)))
FROM VPROJRE1
;

-- rows whose FIRSTNME is blank, or carries leading or trailing spaces.
-- no rows: every FIRSTNME is trimmed and not blank.
SELECT FIRSTNME, '[' || FIRSTNME || ']' AS BRACKETED
FROM VPROJRE1
WHERE RTRIM(FIRSTNME) = ''
   OR FIRSTNME <> LTRIM(FIRSTNME)
   OR LENGTH(FIRSTNME) <> LENGTH(RTRIM(FIRSTNME))
;


-- ----------------------------------------------------------------------------------------- MIDINIT
-- the shortest and the longest MIDINIT, trailing spaces trimmed; 0 to 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDINIT))), MAX(LENGTH(RTRIM(MIDINIT)))
FROM VPROJRE1
;

-- rows whose MIDINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- 2 rows have a blank or padded MIDINIT; the view copies EMPLOYEE.MIDINIT, which is blank for an employee with no
-- middle initial.
SELECT MIDINIT, '[' || MIDINIT || ']' AS BRACKETED
FROM VPROJRE1
WHERE RTRIM(MIDINIT) = ''
   OR MIDINIT <> LTRIM(MIDINIT)
;

-- how many rows have no MIDINIT; 0 of 20.
SELECT COUNT(*) - COUNT(MIDINIT), COUNT(*)
FROM VPROJRE1
;


-- ---------------------------------------------------------------------------------------- LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM VPROJRE1
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- no rows: every LASTNAME is trimmed and not blank.
SELECT LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM VPROJRE1
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;


-- ----------------------------------------------------------------------------------------- MAJPROJ
-- the shortest and the longest MAJPROJ, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(MAJPROJ))), MAX(LENGTH(RTRIM(MAJPROJ)))
FROM VPROJRE1
;

-- rows whose MAJPROJ is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every MAJPROJ is trimmed and not blank.
SELECT MAJPROJ, '[' || MAJPROJ || ']' AS BRACKETED
FROM VPROJRE1
WHERE RTRIM(MAJPROJ) = ''
   OR MAJPROJ <> LTRIM(MAJPROJ)
;

-- how many rows have no MAJPROJ; 6 of 20.
SELECT COUNT(*) - COUNT(MAJPROJ), COUNT(*)
FROM VPROJRE1
;

