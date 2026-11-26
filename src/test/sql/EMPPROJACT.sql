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
-- Profiling queries on EMPPROJACT, a table, a section per column. Each says what it looks for and what the installed
-- data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/EMPPROJACT.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/EMPPROJACT.sql'
--

-- how many rows; 73.
SELECT COUNT(*)
FROM EMPPROJACT
;


-- --------------------------------------------------------------------------------------------------------------- EMPNO
-- the shortest and the longest EMPNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPNO))), MAX(LENGTH(RTRIM(EMPNO)))
FROM EMPPROJACT
;

-- rows whose EMPNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMPNO is trimmed and not blank.
SELECT EMPNO, '[' || EMPNO || ']' AS BRACKETED
FROM EMPPROJACT
WHERE RTRIM(EMPNO) = ''
   OR EMPNO <> LTRIM(EMPNO)
;


-- -------------------------------------------------------------------------------------------------------------- PROJNO
-- the shortest and the longest PROJNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJNO))), MAX(LENGTH(RTRIM(PROJNO)))
FROM EMPPROJACT
;

-- rows whose PROJNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJNO is trimmed and not blank.
SELECT PROJNO, '[' || PROJNO || ']' AS BRACKETED
FROM EMPPROJACT
WHERE RTRIM(PROJNO) = ''
   OR PROJNO <> LTRIM(PROJNO)
;


-- --------------------------------------------------------------------------------------------------------------- ACTNO
-- the smallest and the largest ACTNO; 10 and 180.
SELECT MIN(ACTNO), MAX(ACTNO)
FROM EMPPROJACT
;


-- ------------------------------------------------------------------------------------------------------------- EMPTIME
-- the smallest and the largest EMPTIME; 0.25 and 1.00.
SELECT MIN(EMPTIME), MAX(EMPTIME)
FROM EMPPROJACT
;

-- how many rows have no EMPTIME; 0 of 73.
SELECT COUNT(*) - COUNT(EMPTIME), COUNT(*)
FROM EMPPROJACT
;


-- ------------------------------------------------------------------------------------------------------------ EMSTDATE
-- the earliest and the latest EMSTDATE; 2002-01-01 and 2003-01-01.
SELECT MIN(EMSTDATE), MAX(EMSTDATE)
FROM EMPPROJACT
;

-- how many rows have no EMSTDATE; 0 of 73.
SELECT COUNT(*) - COUNT(EMSTDATE), COUNT(*)
FROM EMPPROJACT
;


-- ------------------------------------------------------------------------------------------------------------ EMENDATE
-- the earliest and the latest EMENDATE; 2002-02-01 and 2003-10-01.
SELECT MIN(EMENDATE), MAX(EMENDATE)
FROM EMPPROJACT
;

-- how many rows have no EMENDATE; 0 of 73.
SELECT COUNT(*) - COUNT(EMENDATE), COUNT(*)
FROM EMPPROJACT
;

