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
-- Profiling queries on VDEPMG1, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VDEPMG1.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VDEPMG1.sql'
--

-- how many rows; 14.
SELECT COUNT(*)
FROM VDEPMG1
;


-- -------------------------------------------------------------------------------------------------------------- DEPTNO
-- the shortest and the longest DEPTNO, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNO))), MAX(LENGTH(RTRIM(DEPTNO)))
FROM VDEPMG1
;

-- rows whose DEPTNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every DEPTNO is trimmed and not blank.
SELECT DEPTNO, '[' || DEPTNO || ']' AS BRACKETED
FROM VDEPMG1
WHERE RTRIM(DEPTNO) = ''
   OR DEPTNO <> LTRIM(DEPTNO)
;


-- ------------------------------------------------------------------------------------------------------------ DEPTNAME
-- the shortest and the longest DEPTNAME, trailing spaces trimmed; 8 to 28 characters, of VARCHAR(36) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNAME))), MAX(LENGTH(RTRIM(DEPTNAME)))
FROM VDEPMG1
;

-- rows whose DEPTNAME is blank, or carries leading or trailing spaces.
-- no rows: every DEPTNAME is trimmed and not blank.
SELECT DEPTNAME, '[' || DEPTNAME || ']' AS BRACKETED
FROM VDEPMG1
WHERE RTRIM(DEPTNAME) = ''
   OR DEPTNAME <> LTRIM(DEPTNAME)
   OR LENGTH(DEPTNAME) <> LENGTH(RTRIM(DEPTNAME))
;


-- --------------------------------------------------------------------------------------------------------------- MGRNO
-- the shortest and the longest MGRNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(MGRNO))), MAX(LENGTH(RTRIM(MGRNO)))
FROM VDEPMG1
;

-- rows whose MGRNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every MGRNO is trimmed and not blank.
SELECT MGRNO, '[' || MGRNO || ']' AS BRACKETED
FROM VDEPMG1
WHERE RTRIM(MGRNO) = ''
   OR MGRNO <> LTRIM(MGRNO)
;

-- how many rows have no MGRNO; 6 of 14.
SELECT COUNT(*) - COUNT(MGRNO), COUNT(*)
FROM VDEPMG1
;


-- ------------------------------------------------------------------------------------------------------------ FIRSTNME
-- the shortest and the longest FIRSTNME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(FIRSTNME))), MAX(LENGTH(RTRIM(FIRSTNME)))
FROM VDEPMG1
;

-- rows whose FIRSTNME is blank, or carries leading or trailing spaces.
-- no rows: every FIRSTNME is trimmed and not blank.
SELECT FIRSTNME, '[' || FIRSTNME || ']' AS BRACKETED
FROM VDEPMG1
WHERE RTRIM(FIRSTNME) = ''
   OR FIRSTNME <> LTRIM(FIRSTNME)
   OR LENGTH(FIRSTNME) <> LENGTH(RTRIM(FIRSTNME))
;

-- how many rows have no FIRSTNME; 6 of 14.
SELECT COUNT(*) - COUNT(FIRSTNME), COUNT(*)
FROM VDEPMG1
;


-- ------------------------------------------------------------------------------------------------------------- MIDINIT
-- the shortest and the longest MIDINIT, trailing spaces trimmed; always 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDINIT))), MAX(LENGTH(RTRIM(MIDINIT)))
FROM VDEPMG1
;

-- rows whose MIDINIT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every MIDINIT is trimmed and not blank.
SELECT MIDINIT, '[' || MIDINIT || ']' AS BRACKETED
FROM VDEPMG1
WHERE RTRIM(MIDINIT) = ''
   OR MIDINIT <> LTRIM(MIDINIT)
;

-- how many rows have no MIDINIT; 6 of 14.
SELECT COUNT(*) - COUNT(MIDINIT), COUNT(*)
FROM VDEPMG1
;


-- ------------------------------------------------------------------------------------------------------------ LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; 4 to 9 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM VDEPMG1
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- no rows: every LASTNAME is trimmed and not blank.
SELECT LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM VDEPMG1
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;

-- how many rows have no LASTNAME; 6 of 14.
SELECT COUNT(*) - COUNT(LASTNAME), COUNT(*)
FROM VDEPMG1
;


-- ------------------------------------------------------------------------------------------------------------ ADMRDEPT
-- the shortest and the longest ADMRDEPT, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(ADMRDEPT))), MAX(LENGTH(RTRIM(ADMRDEPT)))
FROM VDEPMG1
;

-- rows whose ADMRDEPT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every ADMRDEPT is trimmed and not blank.
SELECT ADMRDEPT, '[' || ADMRDEPT || ']' AS BRACKETED
FROM VDEPMG1
WHERE RTRIM(ADMRDEPT) = ''
   OR ADMRDEPT <> LTRIM(ADMRDEPT)
;

