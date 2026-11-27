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
-- Profiling queries on VFORPLA, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VFORPLA.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VFORPLA.sql'
--

-- how many rows; 74.
SELECT COUNT(*)
FROM VFORPLA
;


-- -------------------------------------------------------------------------------------- IDENTIFIER
-- this view has no key, and is mapped as no entity, with no identifier. PROJNO, the project of a row: the values which
-- more than one row shares.
-- 14 PROJNOs, in 68 rows: the view repeats a project once per row of EMPPROJACT, so the rows of each are copies of one
-- another.
SELECT PROJNO, COUNT(*)
FROM VFORPLA
GROUP BY PROJNO
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------ PROJNO
-- the shortest and the longest PROJNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJNO))), MAX(LENGTH(RTRIM(PROJNO)))
FROM VFORPLA
;

-- rows whose PROJNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJNO is trimmed and not blank.
SELECT PROJNO, '[' || PROJNO || ']' AS BRACKETED
FROM VFORPLA
WHERE RTRIM(PROJNO) = ''
   OR PROJNO <> LTRIM(PROJNO)
;


-- ---------------------------------------------------------------------------------------- PROJNAME
-- the shortest and the longest PROJNAME, trailing spaces trimmed; 9 to 21 characters, of VARCHAR(24) declared.
SELECT MIN(LENGTH(RTRIM(PROJNAME))), MAX(LENGTH(RTRIM(PROJNAME)))
FROM VFORPLA
;

-- rows whose PROJNAME is blank, or carries leading or trailing spaces.
-- no rows: every PROJNAME is trimmed and not blank.
SELECT PROJNAME, '[' || PROJNAME || ']' AS BRACKETED
FROM VFORPLA
WHERE RTRIM(PROJNAME) = ''
   OR PROJNAME <> LTRIM(PROJNAME)
   OR LENGTH(PROJNAME) <> LENGTH(RTRIM(PROJNAME))
;


-- ----------------------------------------------------------------------------------------- RESPEMP
-- the shortest and the longest RESPEMP, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(RESPEMP))), MAX(LENGTH(RTRIM(RESPEMP)))
FROM VFORPLA
;

-- rows whose RESPEMP is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every RESPEMP is trimmed and not blank.
SELECT RESPEMP, '[' || RESPEMP || ']' AS BRACKETED
FROM VFORPLA
WHERE RTRIM(RESPEMP) = ''
   OR RESPEMP <> LTRIM(RESPEMP)
;


-- ----------------------------------------------------------------------------------------- PROJDEP
-- the shortest and the longest PROJDEP, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(PROJDEP))), MAX(LENGTH(RTRIM(PROJDEP)))
FROM VFORPLA
;

-- rows whose PROJDEP is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJDEP is trimmed and not blank.
SELECT PROJDEP, '[' || PROJDEP || ']' AS BRACKETED
FROM VFORPLA
WHERE RTRIM(PROJDEP) = ''
   OR PROJDEP <> LTRIM(PROJDEP)
;


-- ---------------------------------------------------------------------------------------- FRSTINIT
-- the shortest and the longest FRSTINIT, trailing spaces trimmed; always 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(FRSTINIT))), MAX(LENGTH(RTRIM(FRSTINIT)))
FROM VFORPLA
;

-- rows whose FRSTINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every FRSTINIT is trimmed and not blank.
SELECT FRSTINIT, '[' || FRSTINIT || ']' AS BRACKETED
FROM VFORPLA
WHERE RTRIM(FRSTINIT) = ''
   OR FRSTINIT <> LTRIM(FRSTINIT)
;


-- ----------------------------------------------------------------------------------------- MIDINIT
-- the shortest and the longest MIDINIT, trailing spaces trimmed; 0 to 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDINIT))), MAX(LENGTH(RTRIM(MIDINIT)))
FROM VFORPLA
;

-- rows whose MIDINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- 8 rows have a blank or padded MIDINIT; the view copies EMPLOYEE.MIDINIT, which is blank for an employee with no
-- middle initial.
SELECT MIDINIT, '[' || MIDINIT || ']' AS BRACKETED
FROM VFORPLA
WHERE RTRIM(MIDINIT) = ''
   OR MIDINIT <> LTRIM(MIDINIT)
;

-- how many rows have no MIDINIT; 0 of 74.
SELECT COUNT(*) - COUNT(MIDINIT), COUNT(*)
FROM VFORPLA
;


-- ---------------------------------------------------------------------------------------- LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM VFORPLA
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- no rows: every LASTNAME is trimmed and not blank.
SELECT LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM VFORPLA
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;

