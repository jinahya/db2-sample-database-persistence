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
-- Profiling queries on VSTAFAC2, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VSTAFAC2.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VSTAFAC2.sql'
--

-- how many rows; 73.
SELECT COUNT(*)
FROM VSTAFAC2
;


-- -------------------------------------------------------------------------------------- IDENTIFIER
-- this view has no key, and is mapped as no entity, with no identifier. PROJNO, ACTNO, EMPNO, STDATE, which the data
-- alone would suggest as one: the values which more than one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT PROJNO, ACTNO, EMPNO, STDATE, COUNT(*)
FROM VSTAFAC2
GROUP BY PROJNO, ACTNO, EMPNO, STDATE
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------ PROJNO
-- the shortest and the longest PROJNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJNO))), MAX(LENGTH(RTRIM(PROJNO)))
FROM VSTAFAC2
;

-- rows whose PROJNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJNO is trimmed and not blank.
SELECT PROJNO, '[' || PROJNO || ']' AS BRACKETED
FROM VSTAFAC2
WHERE RTRIM(PROJNO) = ''
   OR PROJNO <> LTRIM(PROJNO)
;


-- ------------------------------------------------------------------------------------------- ACTNO
-- the smallest and the largest ACTNO; 10 and 180.
SELECT MIN(ACTNO), MAX(ACTNO)
FROM VSTAFAC2
;


-- ----------------------------------------------------------------------------------------- ACTDESC
-- the shortest and the longest ACTDESC, trailing spaces trimmed; 8 to 19 characters, of VARCHAR(20) declared.
SELECT MIN(LENGTH(RTRIM(ACTDESC))), MAX(LENGTH(RTRIM(ACTDESC)))
FROM VSTAFAC2
;

-- rows whose ACTDESC is blank, or carries leading or trailing spaces.
-- no rows: every ACTDESC is trimmed and not blank.
SELECT ACTDESC, '[' || ACTDESC || ']' AS BRACKETED
FROM VSTAFAC2
WHERE RTRIM(ACTDESC) = ''
   OR ACTDESC <> LTRIM(ACTDESC)
   OR LENGTH(ACTDESC) <> LENGTH(RTRIM(ACTDESC))
;


-- ------------------------------------------------------------------------------------------- EMPNO
-- the shortest and the longest EMPNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPNO))), MAX(LENGTH(RTRIM(EMPNO)))
FROM VSTAFAC2
;

-- rows whose EMPNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMPNO is trimmed and not blank.
SELECT EMPNO, '[' || EMPNO || ']' AS BRACKETED
FROM VSTAFAC2
WHERE RTRIM(EMPNO) = ''
   OR EMPNO <> LTRIM(EMPNO)
;


-- ---------------------------------------------------------------------------------------- FIRSTNME
-- the shortest and the longest FIRSTNME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(FIRSTNME))), MAX(LENGTH(RTRIM(FIRSTNME)))
FROM VSTAFAC2
;

-- rows whose FIRSTNME is blank, or carries leading or trailing spaces.
-- no rows: every FIRSTNME is trimmed and not blank.
SELECT FIRSTNME, '[' || FIRSTNME || ']' AS BRACKETED
FROM VSTAFAC2
WHERE RTRIM(FIRSTNME) = ''
   OR FIRSTNME <> LTRIM(FIRSTNME)
   OR LENGTH(FIRSTNME) <> LENGTH(RTRIM(FIRSTNME))
;


-- ----------------------------------------------------------------------------------------- MIDINIT
-- the shortest and the longest MIDINIT, trailing spaces trimmed; 0 to 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDINIT))), MAX(LENGTH(RTRIM(MIDINIT)))
FROM VSTAFAC2
;

-- rows whose MIDINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- 6 rows have a blank or padded MIDINIT; the view copies EMPLOYEE.MIDINIT, which is blank for an employee with no
-- middle initial.
SELECT MIDINIT, '[' || MIDINIT || ']' AS BRACKETED
FROM VSTAFAC2
WHERE RTRIM(MIDINIT) = ''
   OR MIDINIT <> LTRIM(MIDINIT)
;

-- how many rows have no MIDINIT; 0 of 73.
SELECT COUNT(*) - COUNT(MIDINIT), COUNT(*)
FROM VSTAFAC2
;


-- ---------------------------------------------------------------------------------------- LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM VSTAFAC2
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- no rows: every LASTNAME is trimmed and not blank.
SELECT LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM VSTAFAC2
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;


-- ----------------------------------------------------------------------------------------- EMPTIME
-- the smallest and the largest EMPTIME; 0.25 and 1.00.
SELECT MIN(EMPTIME), MAX(EMPTIME)
FROM VSTAFAC2
;

-- how many rows have no EMPTIME; 0 of 73.
SELECT COUNT(*) - COUNT(EMPTIME), COUNT(*)
FROM VSTAFAC2
;


-- ------------------------------------------------------------------------------------------ STDATE
-- the earliest and the latest STDATE; 2002-01-01 and 2003-01-01.
SELECT MIN(STDATE), MAX(STDATE)
FROM VSTAFAC2
;

-- how many rows have no STDATE; 0 of 73.
SELECT COUNT(*) - COUNT(STDATE), COUNT(*)
FROM VSTAFAC2
;


-- ------------------------------------------------------------------------------------------ ENDATE
-- the earliest and the latest ENDATE; 2002-02-01 and 2003-10-01.
SELECT MIN(ENDATE), MAX(ENDATE)
FROM VSTAFAC2
;

-- how many rows have no ENDATE; 0 of 73.
SELECT COUNT(*) - COUNT(ENDATE), COUNT(*)
FROM VSTAFAC2
;


-- -------------------------------------------------------------------------------------------- TYPE
-- the shortest and the longest TYPE, trailing spaces trimmed; always 1 characters, of VARCHAR(1) declared.
SELECT MIN(LENGTH(RTRIM(TYPE))), MAX(LENGTH(RTRIM(TYPE)))
FROM VSTAFAC2
;

-- rows whose TYPE is blank, or carries leading or trailing spaces.
-- no rows: every TYPE is trimmed and not blank.
SELECT TYPE, '[' || TYPE || ']' AS BRACKETED
FROM VSTAFAC2
WHERE RTRIM(TYPE) = ''
   OR TYPE <> LTRIM(TYPE)
   OR LENGTH(TYPE) <> LENGTH(RTRIM(TYPE))
;

