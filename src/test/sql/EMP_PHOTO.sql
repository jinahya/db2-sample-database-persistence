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
-- Profiling queries on EMP_PHOTO, a table, a section per column. Each says what it looks for and what the installed
-- data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/EMP_PHOTO.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/EMP_PHOTO.sql'
--

-- how many rows; 8.
SELECT COUNT(*)
FROM EMP_PHOTO
;


-- --------------------------------------------------------------------------------------------------------------- EMPNO
-- the shortest and the longest EMPNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPNO))), MAX(LENGTH(RTRIM(EMPNO)))
FROM EMP_PHOTO
;

-- rows whose EMPNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMPNO is trimmed and not blank.
SELECT PHOTO_FORMAT, EMPNO, '[' || EMPNO || ']' AS BRACKETED
FROM EMP_PHOTO
WHERE RTRIM(EMPNO) = ''
   OR EMPNO <> LTRIM(EMPNO)
;


-- -------------------------------------------------------------------------------------------------------- PHOTO_FORMAT
-- the shortest and the longest PHOTO_FORMAT, trailing spaces trimmed; 3 to 6 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(PHOTO_FORMAT))), MAX(LENGTH(RTRIM(PHOTO_FORMAT)))
FROM EMP_PHOTO
;

SELECT DISTINCT PHOTO_FORMAT
FROM EMP_PHOTO
;

-- rows whose PHOTO_FORMAT is blank, or carries leading or trailing spaces.
-- no rows: every PHOTO_FORMAT is trimmed and not blank.
SELECT EMPNO, PHOTO_FORMAT, '[' || PHOTO_FORMAT || ']' AS BRACKETED
FROM EMP_PHOTO
WHERE RTRIM(PHOTO_FORMAT) = ''
   OR PHOTO_FORMAT <> LTRIM(PHOTO_FORMAT)
   OR LENGTH(PHOTO_FORMAT) <> LENGTH(RTRIM(PHOTO_FORMAT))
;


-- ------------------------------------------------------------------------------------------------------------- PICTURE
-- the smallest and the largest PICTURE; 29143 and 73438 bytes, of BLOB(102400) declared.
SELECT MIN(LENGTH(PICTURE)), MAX(LENGTH(PICTURE))
FROM EMP_PHOTO
;

-- how many rows have no PICTURE; 0 of 8.
SELECT COUNT(*) - COUNT(PICTURE), COUNT(*)
FROM EMP_PHOTO
;

