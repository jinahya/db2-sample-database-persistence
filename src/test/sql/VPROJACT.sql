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
-- Profiling queries on VPROJACT, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VPROJACT.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VPROJACT.sql'
--

-- how many rows; 65.
SELECT COUNT(*)
FROM VPROJACT
;


-- -------------------------------------------------------------------------------------------------------------- PROJNO
-- the shortest and the longest PROJNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJNO))), MAX(LENGTH(RTRIM(PROJNO)))
FROM VPROJACT
;

-- rows whose PROJNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJNO is trimmed and not blank.
SELECT PROJNO, '[' || PROJNO || ']' AS BRACKETED
FROM VPROJACT
WHERE RTRIM(PROJNO) = ''
   OR PROJNO <> LTRIM(PROJNO)
;


-- --------------------------------------------------------------------------------------------------------------- ACTNO
-- the smallest and the largest ACTNO; 10 and 180.
SELECT MIN(ACTNO), MAX(ACTNO)
FROM VPROJACT
;


-- ------------------------------------------------------------------------------------------------------------- ACSTAFF
-- the smallest and the largest ACSTAFF; no value.
SELECT MIN(ACSTAFF), MAX(ACSTAFF)
FROM VPROJACT
;

-- how many rows have no ACSTAFF; 65 of 65.
SELECT COUNT(*) - COUNT(ACSTAFF), COUNT(*)
FROM VPROJACT
;


-- ------------------------------------------------------------------------------------------------------------ ACSTDATE
-- the earliest and the latest ACSTDATE; 2002-01-01 and 2003-01-01.
SELECT MIN(ACSTDATE), MAX(ACSTDATE)
FROM VPROJACT
;


-- ------------------------------------------------------------------------------------------------------------ ACENDATE
-- the earliest and the latest ACENDATE; no value.
SELECT MIN(ACENDATE), MAX(ACENDATE)
FROM VPROJACT
;

-- how many rows have no ACENDATE; 65 of 65.
SELECT COUNT(*) - COUNT(ACENDATE), COUNT(*)
FROM VPROJACT
;

