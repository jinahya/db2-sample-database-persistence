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
-- Profiling queries on VEMPDPT1, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VEMPDPT1.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VEMPDPT1.sql'
--

-- how many rows; 42.
SELECT COUNT(*)
FROM VEMPDPT1
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, EMPNO, of a view, which has no key: the values which more than one row
-- shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT EMPNO, COUNT(*)
FROM VEMPDPT1
GROUP BY EMPNO
HAVING COUNT(*) > 1
;


-- -------------------------------------------------------------------------------------------------------------- DEPTNO
-- the shortest and the longest DEPTNO, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNO))), MAX(LENGTH(RTRIM(DEPTNO)))
FROM VEMPDPT1
;

-- rows whose DEPTNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every DEPTNO is trimmed and not blank.
SELECT DEPTNO, '[' || DEPTNO || ']' AS BRACKETED
FROM VEMPDPT1
WHERE RTRIM(DEPTNO) = ''
   OR DEPTNO <> LTRIM(DEPTNO)
;

-- how many rows have no DEPTNO; 0 of 42.
SELECT COUNT(*) - COUNT(DEPTNO), COUNT(*)
FROM VEMPDPT1
;


-- ------------------------------------------------------------------------------------------------------------ DEPTNAME
-- the shortest and the longest DEPTNAME, trailing spaces trimmed; 8 to 28 characters, of VARCHAR(36) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNAME))), MAX(LENGTH(RTRIM(DEPTNAME)))
FROM VEMPDPT1
;

-- rows whose DEPTNAME is blank, or carries leading or trailing spaces.
-- no rows: every DEPTNAME is trimmed and not blank.
SELECT DEPTNAME, '[' || DEPTNAME || ']' AS BRACKETED
FROM VEMPDPT1
WHERE RTRIM(DEPTNAME) = ''
   OR DEPTNAME <> LTRIM(DEPTNAME)
   OR LENGTH(DEPTNAME) <> LENGTH(RTRIM(DEPTNAME))
;

-- how many rows have no DEPTNAME; 0 of 42.
SELECT COUNT(*) - COUNT(DEPTNAME), COUNT(*)
FROM VEMPDPT1
;


-- --------------------------------------------------------------------------------------------------------------- EMPNO
-- the shortest and the longest EMPNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPNO))), MAX(LENGTH(RTRIM(EMPNO)))
FROM VEMPDPT1
;

-- rows whose EMPNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMPNO is trimmed and not blank.
SELECT EMPNO, '[' || EMPNO || ']' AS BRACKETED
FROM VEMPDPT1
WHERE RTRIM(EMPNO) = ''
   OR EMPNO <> LTRIM(EMPNO)
;


-- ------------------------------------------------------------------------------------------------------------ FRSTINIT
-- the shortest and the longest FRSTINIT, trailing spaces trimmed; always 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(FRSTINIT))), MAX(LENGTH(RTRIM(FRSTINIT)))
FROM VEMPDPT1
;

-- rows whose FRSTINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every FRSTINIT is trimmed and not blank.
SELECT FRSTINIT, '[' || FRSTINIT || ']' AS BRACKETED
FROM VEMPDPT1
WHERE RTRIM(FRSTINIT) = ''
   OR FRSTINIT <> LTRIM(FRSTINIT)
;


-- ------------------------------------------------------------------------------------------------------------- MIDINIT
-- the shortest and the longest MIDINIT, trailing spaces trimmed; 0 to 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDINIT))), MAX(LENGTH(RTRIM(MIDINIT)))
FROM VEMPDPT1
;

-- rows whose MIDINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- 7 rows have a blank or padded MIDINIT; the view copies EMPLOYEE.MIDINIT, which is blank for an employee with no
-- middle initial.
SELECT MIDINIT, '[' || MIDINIT || ']' AS BRACKETED
FROM VEMPDPT1
WHERE RTRIM(MIDINIT) = ''
   OR MIDINIT <> LTRIM(MIDINIT)
;

-- how many rows have no MIDINIT; 0 of 42.
SELECT COUNT(*) - COUNT(MIDINIT), COUNT(*)
FROM VEMPDPT1
;


-- ------------------------------------------------------------------------------------------------------------ LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; 3 to 10 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM VEMPDPT1
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- no rows: every LASTNAME is trimmed and not blank.
SELECT LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM VEMPDPT1
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;


-- ------------------------------------------------------------------------------------------------------------ WORKDEPT
-- the shortest and the longest WORKDEPT, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(WORKDEPT))), MAX(LENGTH(RTRIM(WORKDEPT)))
FROM VEMPDPT1
;

-- rows whose WORKDEPT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every WORKDEPT is trimmed and not blank.
SELECT WORKDEPT, '[' || WORKDEPT || ']' AS BRACKETED
FROM VEMPDPT1
WHERE RTRIM(WORKDEPT) = ''
   OR WORKDEPT <> LTRIM(WORKDEPT)
;

-- how many rows have no WORKDEPT; 0 of 42.
SELECT COUNT(*) - COUNT(WORKDEPT), COUNT(*)
FROM VEMPDPT1
;

