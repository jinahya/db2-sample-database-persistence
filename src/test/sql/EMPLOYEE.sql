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
-- Profiling queries on EMPLOYEE, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/EMPLOYEE.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/EMPLOYEE.sql'
--

-- how many rows; 42.
SELECT COUNT(*)
FROM EMPLOYEE
;


-- ------------------------------------------------------------------------------------------- EMPNO
-- EMPNO is the primary key; 42 distinct values in 42 rows.
SELECT COUNT(DISTINCT EMPNO), COUNT(*)
FROM EMPLOYEE
;

-- the shortest and the longest EMPNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPNO))), MAX(LENGTH(RTRIM(EMPNO)))
FROM EMPLOYEE
;

-- rows whose EMPNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMPNO is trimmed and not blank.
SELECT EMPNO, '[' || EMPNO || ']' AS BRACKETED
FROM EMPLOYEE
WHERE RTRIM(EMPNO) = ''
   OR EMPNO <> LTRIM(EMPNO)
;


-- ---------------------------------------------------------------------------------------- FIRSTNME
-- the shortest and the longest FIRSTNME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(FIRSTNME))), MAX(LENGTH(RTRIM(FIRSTNME)))
FROM EMPLOYEE
;

-- rows whose FIRSTNME is blank, or carries leading or trailing spaces.
-- no rows: every FIRSTNME is trimmed and not blank.
SELECT EMPNO, FIRSTNME, '[' || FIRSTNME || ']' AS BRACKETED
FROM EMPLOYEE
WHERE RTRIM(FIRSTNME) = ''
   OR FIRSTNME <> LTRIM(FIRSTNME)
   OR LENGTH(FIRSTNME) <> LENGTH(RTRIM(FIRSTNME))
;


-- ----------------------------------------------------------------------------------------- MIDINIT
-- the shortest and the longest MIDINIT, trailing spaces trimmed; 0 to 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDINIT))), MAX(LENGTH(RTRIM(MIDINIT)))
FROM EMPLOYEE
;

-- rows whose MIDINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- 7 rows have a blank or padded MIDINIT; an employee with no middle initial has a blank one, not a null one.
SELECT EMPNO, MIDINIT, '[' || MIDINIT || ']' AS BRACKETED
FROM EMPLOYEE
WHERE RTRIM(MIDINIT) = ''
   OR MIDINIT <> LTRIM(MIDINIT)
;

-- how many rows have no MIDINIT; 0 of 42.
SELECT COUNT(*) - COUNT(MIDINIT), COUNT(*)
FROM EMPLOYEE
;


-- ---------------------------------------------------------------------------------------- LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; 3 to 10 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM EMPLOYEE
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- no rows: every LASTNAME is trimmed and not blank.
SELECT EMPNO, LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM EMPLOYEE
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;


-- ---------------------------------------------------------------------------------------- WORKDEPT
-- the shortest and the longest WORKDEPT, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(WORKDEPT))), MAX(LENGTH(RTRIM(WORKDEPT)))
FROM EMPLOYEE
;

-- rows whose WORKDEPT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every WORKDEPT is trimmed and not blank.
SELECT EMPNO, WORKDEPT, '[' || WORKDEPT || ']' AS BRACKETED
FROM EMPLOYEE
WHERE RTRIM(WORKDEPT) = ''
   OR WORKDEPT <> LTRIM(WORKDEPT)
;

-- how many rows have no WORKDEPT; 0 of 42.
SELECT COUNT(*) - COUNT(WORKDEPT), COUNT(*)
FROM EMPLOYEE
;


-- ----------------------------------------------------------------------------------------- PHONENO
-- the shortest and the longest PHONENO, trailing spaces trimmed; always 4 characters, of CHARACTER(4) declared.
SELECT MIN(LENGTH(RTRIM(PHONENO))), MAX(LENGTH(RTRIM(PHONENO)))
FROM EMPLOYEE
;

-- rows whose PHONENO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PHONENO is trimmed and not blank.
SELECT EMPNO, PHONENO, '[' || PHONENO || ']' AS BRACKETED
FROM EMPLOYEE
WHERE RTRIM(PHONENO) = ''
   OR PHONENO <> LTRIM(PHONENO)
;

-- how many rows have no PHONENO; 0 of 42.
SELECT COUNT(*) - COUNT(PHONENO), COUNT(*)
FROM EMPLOYEE
;


-- ---------------------------------------------------------------------------------------- HIREDATE
-- the earliest and the latest HIREDATE; 1977-05-05 and 2006-12-15.
SELECT MIN(HIREDATE), MAX(HIREDATE)
FROM EMPLOYEE
;

-- how many rows have no HIREDATE; 0 of 42.
SELECT COUNT(*) - COUNT(HIREDATE), COUNT(*)
FROM EMPLOYEE
;


-- --------------------------------------------------------------------------------------------- JOB
SELECT DISTINCT JOB
FROM EMPLOYEE
;

-- the shortest and the longest JOB, trailing spaces trimmed; 4 to 8 characters, of CHARACTER(8) declared.
SELECT MIN(LENGTH(RTRIM(JOB))), MAX(LENGTH(RTRIM(JOB)))
FROM EMPLOYEE
;

-- rows whose JOB is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not count).
-- no rows: every JOB is trimmed and not blank.
SELECT EMPNO, JOB, '[' || JOB || ']' AS BRACKETED
FROM EMPLOYEE
WHERE RTRIM(JOB) = ''
   OR JOB <> LTRIM(JOB)
;

-- how many rows have no JOB; 0 of 42.
SELECT COUNT(*) - COUNT(JOB), COUNT(*)
FROM EMPLOYEE
;


-- ----------------------------------------------------------------------------------------- EDLEVEL
SELECT DISTINCT EDLEVEL
FROM EMPLOYEE
;

-- the smallest and the largest EDLEVEL; 12 and 20.
SELECT MIN(EDLEVEL), MAX(EDLEVEL)
FROM EMPLOYEE
;


-- --------------------------------------------------------------------------------------------- SEX
SELECT DISTINCT SEX
FROM EMPLOYEE
;

-- the shortest and the longest SEX, trailing spaces trimmed; always 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(SEX))), MAX(LENGTH(RTRIM(SEX)))
FROM EMPLOYEE
;

-- rows whose SEX is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not count).
-- no rows: every SEX is trimmed and not blank.
SELECT EMPNO, SEX, '[' || SEX || ']' AS BRACKETED
FROM EMPLOYEE
WHERE RTRIM(SEX) = ''
   OR SEX <> LTRIM(SEX)
;

-- how many rows have no SEX; 0 of 42.
SELECT COUNT(*) - COUNT(SEX), COUNT(*)
FROM EMPLOYEE
;


-- --------------------------------------------------------------------------------------- BIRTHDATE
-- the earliest and the latest BIRTHDATE; 1955-09-15 and 2003-05-26.
SELECT MIN(BIRTHDATE), MAX(BIRTHDATE)
FROM EMPLOYEE
;

-- how many rows have no BIRTHDATE; 0 of 42.
SELECT COUNT(*) - COUNT(BIRTHDATE), COUNT(*)
FROM EMPLOYEE
;


-- ------------------------------------------------------------------------------------------ SALARY
-- the smallest and the largest SALARY; 31840.00 and 152750.00.
SELECT MIN(SALARY), MAX(SALARY)
FROM EMPLOYEE
;

-- how many rows have no SALARY; 0 of 42.
SELECT COUNT(*) - COUNT(SALARY), COUNT(*)
FROM EMPLOYEE
;


-- ------------------------------------------------------------------------------------------- BONUS
-- the smallest and the largest BONUS; 300.00 and 1000.00.
SELECT MIN(BONUS), MAX(BONUS)
FROM EMPLOYEE
;

-- how many rows have no BONUS; 0 of 42.
SELECT COUNT(*) - COUNT(BONUS), COUNT(*)
FROM EMPLOYEE
;


-- -------------------------------------------------------------------------------------------- COMM
-- the smallest and the largest COMM; 1227.00 and 4220.00.
SELECT MIN(COMM), MAX(COMM)
FROM EMPLOYEE
;

-- how many rows have no COMM; 0 of 42.
SELECT COUNT(*) - COUNT(COMM), COUNT(*)
FROM EMPLOYEE
;

