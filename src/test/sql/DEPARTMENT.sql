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
-- Profiling queries on DEPARTMENT, a table, a section per column. Each says what it looks for and what the installed
-- data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/DEPARTMENT.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/DEPARTMENT.sql'
--

-- how many rows; 14.
SELECT COUNT(*)
FROM DEPARTMENT
;


-- -------------------------------------------------------------------------------------------------------------- DEPTNO
-- DEPTNO is the primary key; 14 distinct values in 14 rows.
SELECT COUNT(DISTINCT DEPTNO), COUNT(*)
FROM DEPARTMENT
;

-- the shortest and the longest DEPTNO, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNO))), MAX(LENGTH(RTRIM(DEPTNO)))
FROM DEPARTMENT
;

-- rows whose DEPTNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every DEPTNO is trimmed and not blank.
SELECT DEPTNO, '[' || DEPTNO || ']' AS BRACKETED
FROM DEPARTMENT
WHERE RTRIM(DEPTNO) = ''
   OR DEPTNO <> LTRIM(DEPTNO)
;


-- ------------------------------------------------------------------------------------------------------------ DEPTNAME
-- the shortest and the longest DEPTNAME, trailing spaces trimmed; 8 to 28 characters, of VARCHAR(36) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNAME))), MAX(LENGTH(RTRIM(DEPTNAME)))
FROM DEPARTMENT
;

-- rows whose DEPTNAME is blank, or carries leading or trailing spaces.
-- no rows: every DEPTNAME is trimmed and not blank.
SELECT DEPTNO, DEPTNAME, '[' || DEPTNAME || ']' AS BRACKETED
FROM DEPARTMENT
WHERE RTRIM(DEPTNAME) = ''
   OR DEPTNAME <> LTRIM(DEPTNAME)
   OR LENGTH(DEPTNAME) <> LENGTH(RTRIM(DEPTNAME))
;


-- --------------------------------------------------------------------------------------------------------------- MGRNO
-- the shortest and the longest MGRNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(MGRNO))), MAX(LENGTH(RTRIM(MGRNO)))
FROM DEPARTMENT
;

-- rows whose MGRNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every MGRNO is trimmed and not blank.
SELECT DEPTNO, MGRNO, '[' || MGRNO || ']' AS BRACKETED
FROM DEPARTMENT
WHERE RTRIM(MGRNO) = ''
   OR MGRNO <> LTRIM(MGRNO)
;

-- how many rows have no MGRNO; 6 of 14.
SELECT COUNT(*) - COUNT(MGRNO), COUNT(*)
FROM DEPARTMENT
;


-- ------------------------------------------------------------------------------------------------------------ ADMRDEPT
-- the shortest and the longest ADMRDEPT, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(ADMRDEPT))), MAX(LENGTH(RTRIM(ADMRDEPT)))
FROM DEPARTMENT
;

-- rows whose ADMRDEPT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every ADMRDEPT is trimmed and not blank.
SELECT DEPTNO, ADMRDEPT, '[' || ADMRDEPT || ']' AS BRACKETED
FROM DEPARTMENT
WHERE RTRIM(ADMRDEPT) = ''
   OR ADMRDEPT <> LTRIM(ADMRDEPT)
;


-- ------------------------------------------------------------------------------------------------------------ LOCATION
-- the shortest and the longest LOCATION; no value, of CHARACTER(16) declared.
SELECT MIN(LENGTH(RTRIM(LOCATION))), MAX(LENGTH(RTRIM(LOCATION)))
FROM DEPARTMENT
;

-- rows whose LOCATION is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every LOCATION is trimmed and not blank.
SELECT DEPTNO, LOCATION, '[' || LOCATION || ']' AS BRACKETED
FROM DEPARTMENT
WHERE RTRIM(LOCATION) = ''
   OR LOCATION <> LTRIM(LOCATION)
;

-- how many rows have no LOCATION; 14 of 14.
SELECT COUNT(*) - COUNT(LOCATION), COUNT(*)
FROM DEPARTMENT
;

