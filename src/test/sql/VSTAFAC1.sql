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
-- Profiling queries on VSTAFAC1, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VSTAFAC1.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VSTAFAC1.sql'
--

-- how many rows; 65.
SELECT COUNT(*)
FROM VSTAFAC1
;


-- -------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, PROJNO, ACTNO, STDATE, of a view, which has no key: the values which more
-- than one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT PROJNO, ACTNO, STDATE, COUNT(*)
FROM VSTAFAC1
GROUP BY PROJNO, ACTNO, STDATE
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------ PROJNO
-- the shortest and the longest PROJNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJNO))), MAX(LENGTH(RTRIM(PROJNO)))
FROM VSTAFAC1
;

-- rows whose PROJNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJNO is trimmed and not blank.
SELECT PROJNO, '[' || PROJNO || ']' AS BRACKETED
FROM VSTAFAC1
WHERE RTRIM(PROJNO) = ''
   OR PROJNO <> LTRIM(PROJNO)
;


-- ------------------------------------------------------------------------------------------- ACTNO
-- the smallest and the largest ACTNO; 10 and 180.
SELECT MIN(ACTNO), MAX(ACTNO)
FROM VSTAFAC1
;


-- ----------------------------------------------------------------------------------------- ACTDESC
-- the shortest and the longest ACTDESC, trailing spaces trimmed; 8 to 19 characters, of VARCHAR(20) declared.
SELECT MIN(LENGTH(RTRIM(ACTDESC))), MAX(LENGTH(RTRIM(ACTDESC)))
FROM VSTAFAC1
;

-- rows whose ACTDESC is blank, or carries leading or trailing spaces.
-- no rows: every ACTDESC is trimmed and not blank.
SELECT ACTDESC, '[' || ACTDESC || ']' AS BRACKETED
FROM VSTAFAC1
WHERE RTRIM(ACTDESC) = ''
   OR ACTDESC <> LTRIM(ACTDESC)
   OR LENGTH(ACTDESC) <> LENGTH(RTRIM(ACTDESC))
;


-- ------------------------------------------------------------------------------------------- EMPNO
-- the shortest and the longest EMPNO, trailing spaces trimmed; always 0 characters, of VARCHAR(1) declared.
SELECT MIN(LENGTH(RTRIM(EMPNO))), MAX(LENGTH(RTRIM(EMPNO)))
FROM VSTAFAC1
;

-- rows whose EMPNO is blank, or carries leading or trailing spaces.
-- 65 rows have a blank or padded EMPNO; every row: the view writes ' ' as the EMPNO of a project activity, which has no
-- employee (its TYPE is '1'; VSTAFAC2 lists the employees').
SELECT EMPNO, '[' || EMPNO || ']' AS BRACKETED
FROM VSTAFAC1
WHERE RTRIM(EMPNO) = ''
   OR EMPNO <> LTRIM(EMPNO)
   OR LENGTH(EMPNO) <> LENGTH(RTRIM(EMPNO))
;


-- ---------------------------------------------------------------------------------------- FIRSTNME
-- the shortest and the longest FIRSTNME, trailing spaces trimmed; always 0 characters, of VARCHAR(1) declared.
SELECT MIN(LENGTH(RTRIM(FIRSTNME))), MAX(LENGTH(RTRIM(FIRSTNME)))
FROM VSTAFAC1
;

-- rows whose FIRSTNME is blank, or carries leading or trailing spaces.
-- 65 rows have a blank or padded FIRSTNME; every row: the view writes ' ' as the FIRSTNME of a project activity, which
-- has no employee (its TYPE is '1'; VSTAFAC2 lists the employees').
SELECT FIRSTNME, '[' || FIRSTNME || ']' AS BRACKETED
FROM VSTAFAC1
WHERE RTRIM(FIRSTNME) = ''
   OR FIRSTNME <> LTRIM(FIRSTNME)
   OR LENGTH(FIRSTNME) <> LENGTH(RTRIM(FIRSTNME))
;


-- ----------------------------------------------------------------------------------------- MIDINIT
-- the shortest and the longest MIDINIT, trailing spaces trimmed; always 0 characters, of VARCHAR(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDINIT))), MAX(LENGTH(RTRIM(MIDINIT)))
FROM VSTAFAC1
;

-- rows whose MIDINIT is blank, or carries leading or trailing spaces.
-- 65 rows have a blank or padded MIDINIT; every row: the view writes ' ' as the MIDINIT of a project activity, which
-- has no employee (its TYPE is '1'; VSTAFAC2 lists the employees').
SELECT MIDINIT, '[' || MIDINIT || ']' AS BRACKETED
FROM VSTAFAC1
WHERE RTRIM(MIDINIT) = ''
   OR MIDINIT <> LTRIM(MIDINIT)
   OR LENGTH(MIDINIT) <> LENGTH(RTRIM(MIDINIT))
;


-- ---------------------------------------------------------------------------------------- LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; always 0 characters, of VARCHAR(1) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM VSTAFAC1
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- 65 rows have a blank or padded LASTNAME; every row: the view writes ' ' as the LASTNAME of a project activity, which
-- has no employee (its TYPE is '1'; VSTAFAC2 lists the employees').
SELECT LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM VSTAFAC1
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;


-- ----------------------------------------------------------------------------------------- EMPTIME
-- the smallest and the largest EMPTIME; no value.
SELECT MIN(EMPTIME), MAX(EMPTIME)
FROM VSTAFAC1
;

-- how many rows have no EMPTIME; 65 of 65.
SELECT COUNT(*) - COUNT(EMPTIME), COUNT(*)
FROM VSTAFAC1
;


-- ------------------------------------------------------------------------------------------ STDATE
-- the earliest and the latest STDATE; 2002-01-01 and 2003-01-01.
SELECT MIN(STDATE), MAX(STDATE)
FROM VSTAFAC1
;


-- ------------------------------------------------------------------------------------------ ENDATE
-- the earliest and the latest ENDATE; no value.
SELECT MIN(ENDATE), MAX(ENDATE)
FROM VSTAFAC1
;

-- how many rows have no ENDATE; 65 of 65.
SELECT COUNT(*) - COUNT(ENDATE), COUNT(*)
FROM VSTAFAC1
;


-- -------------------------------------------------------------------------------------------- TYPE
-- the shortest and the longest TYPE, trailing spaces trimmed; always 1 characters, of VARCHAR(1) declared.
SELECT MIN(LENGTH(RTRIM(TYPE))), MAX(LENGTH(RTRIM(TYPE)))
FROM VSTAFAC1
;

-- rows whose TYPE is blank, or carries leading or trailing spaces.
-- no rows: every TYPE is trimmed and not blank.
SELECT TYPE, '[' || TYPE || ']' AS BRACKETED
FROM VSTAFAC1
WHERE RTRIM(TYPE) = ''
   OR TYPE <> LTRIM(TYPE)
   OR LENGTH(TYPE) <> LENGTH(RTRIM(TYPE))
;

