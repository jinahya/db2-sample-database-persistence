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
-- Profiling queries on EMP_RESUME, a table, a section per column. Each says what it looks for and what the installed
-- data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/EMP_RESUME.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/EMP_RESUME.sql'
--

-- how many rows; 8.
SELECT COUNT(*)
FROM EMP_RESUME
;


-- --------------------------------------------------------------------------------------------------------------- EMPNO
-- the shortest and the longest EMPNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPNO))), MAX(LENGTH(RTRIM(EMPNO)))
FROM EMP_RESUME
;

-- rows whose EMPNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMPNO is trimmed and not blank.
SELECT RESUME_FORMAT, EMPNO, '[' || EMPNO || ']' AS BRACKETED
FROM EMP_RESUME
WHERE RTRIM(EMPNO) = ''
   OR EMPNO <> LTRIM(EMPNO)
;


-- ------------------------------------------------------------------------------------------------------- RESUME_FORMAT
-- the shortest and the longest RESUME_FORMAT, trailing spaces trimmed; 4 to 5 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(RESUME_FORMAT))), MAX(LENGTH(RTRIM(RESUME_FORMAT)))
FROM EMP_RESUME
;

-- rows whose RESUME_FORMAT is blank, or carries leading or trailing spaces.
-- no rows: every RESUME_FORMAT is trimmed and not blank.
SELECT EMPNO, RESUME_FORMAT, '[' || RESUME_FORMAT || ']' AS BRACKETED
FROM EMP_RESUME
WHERE RTRIM(RESUME_FORMAT) = ''
   OR RESUME_FORMAT <> LTRIM(RESUME_FORMAT)
   OR LENGTH(RESUME_FORMAT) <> LENGTH(RTRIM(RESUME_FORMAT))
;


-- -------------------------------------------------------------------------------------------------------------- RESUME
-- the smallest and the largest RESUME; 1237 and 2467 characters, of CLOB(5120) declared.
SELECT MIN(LENGTH(RESUME)), MAX(LENGTH(RESUME))
FROM EMP_RESUME
;

-- how many rows have no RESUME; 0 of 8.
SELECT COUNT(*) - COUNT(RESUME), COUNT(*)
FROM EMP_RESUME
;

