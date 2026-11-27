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
-- Profiling queries on VPROJ, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VPROJ.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VPROJ.sql'
--

-- how many rows; 20.
SELECT COUNT(*)
FROM VPROJ
;


-- -------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, PROJNO, of a view, which has no key: the values which more than one row
-- shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT PROJNO, COUNT(*)
FROM VPROJ
GROUP BY PROJNO
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------ PROJNO
-- the shortest and the longest PROJNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJNO))), MAX(LENGTH(RTRIM(PROJNO)))
FROM VPROJ
;

-- rows whose PROJNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJNO is trimmed and not blank.
SELECT PROJNO, '[' || PROJNO || ']' AS BRACKETED
FROM VPROJ
WHERE RTRIM(PROJNO) = ''
   OR PROJNO <> LTRIM(PROJNO)
;


-- ---------------------------------------------------------------------------------------- PROJNAME
-- the shortest and the longest PROJNAME, trailing spaces trimmed; 9 to 21 characters, of VARCHAR(24) declared.
SELECT MIN(LENGTH(RTRIM(PROJNAME))), MAX(LENGTH(RTRIM(PROJNAME)))
FROM VPROJ
;

-- rows whose PROJNAME is blank, or carries leading or trailing spaces.
-- no rows: every PROJNAME is trimmed and not blank.
SELECT PROJNAME, '[' || PROJNAME || ']' AS BRACKETED
FROM VPROJ
WHERE RTRIM(PROJNAME) = ''
   OR PROJNAME <> LTRIM(PROJNAME)
   OR LENGTH(PROJNAME) <> LENGTH(RTRIM(PROJNAME))
;


-- ------------------------------------------------------------------------------------------ DEPTNO
-- the shortest and the longest DEPTNO, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNO))), MAX(LENGTH(RTRIM(DEPTNO)))
FROM VPROJ
;

-- rows whose DEPTNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every DEPTNO is trimmed and not blank.
SELECT DEPTNO, '[' || DEPTNO || ']' AS BRACKETED
FROM VPROJ
WHERE RTRIM(DEPTNO) = ''
   OR DEPTNO <> LTRIM(DEPTNO)
;


-- ----------------------------------------------------------------------------------------- RESPEMP
-- the shortest and the longest RESPEMP, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(RESPEMP))), MAX(LENGTH(RTRIM(RESPEMP)))
FROM VPROJ
;

-- rows whose RESPEMP is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every RESPEMP is trimmed and not blank.
SELECT RESPEMP, '[' || RESPEMP || ']' AS BRACKETED
FROM VPROJ
WHERE RTRIM(RESPEMP) = ''
   OR RESPEMP <> LTRIM(RESPEMP)
;


-- ----------------------------------------------------------------------------------------- PRSTAFF
-- the smallest and the largest PRSTAFF; 1.00 and 12.00.
SELECT MIN(PRSTAFF), MAX(PRSTAFF)
FROM VPROJ
;

-- how many rows have no PRSTAFF; 0 of 20.
SELECT COUNT(*) - COUNT(PRSTAFF), COUNT(*)
FROM VPROJ
;


-- ---------------------------------------------------------------------------------------- PRSTDATE
-- the earliest and the latest PRSTDATE; 2002-01-01 and 2002-02-15.
SELECT MIN(PRSTDATE), MAX(PRSTDATE)
FROM VPROJ
;

-- how many rows have no PRSTDATE; 0 of 20.
SELECT COUNT(*) - COUNT(PRSTDATE), COUNT(*)
FROM VPROJ
;


-- ---------------------------------------------------------------------------------------- PRENDATE
-- the earliest and the latest PRENDATE; 1982-12-01 and 2003-02-01.
SELECT MIN(PRENDATE), MAX(PRENDATE)
FROM VPROJ
;

-- how many rows have no PRENDATE; 0 of 20.
SELECT COUNT(*) - COUNT(PRENDATE), COUNT(*)
FROM VPROJ
;


-- ----------------------------------------------------------------------------------------- MAJPROJ
-- the shortest and the longest MAJPROJ, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(MAJPROJ))), MAX(LENGTH(RTRIM(MAJPROJ)))
FROM VPROJ
;

-- rows whose MAJPROJ is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every MAJPROJ is trimmed and not blank.
SELECT MAJPROJ, '[' || MAJPROJ || ']' AS BRACKETED
FROM VPROJ
WHERE RTRIM(MAJPROJ) = ''
   OR MAJPROJ <> LTRIM(MAJPROJ)
;

-- how many rows have no MAJPROJ; 6 of 20.
SELECT COUNT(*) - COUNT(MAJPROJ), COUNT(*)
FROM VPROJ
;

