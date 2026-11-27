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
-- Profiling queries on PROJACT, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/PROJACT.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/PROJACT.sql'
--

-- how many rows; 65.
SELECT COUNT(*)
FROM PROJACT
;


-- ------------------------------------------------------------------------------------------ PROJNO
-- the shortest and the longest PROJNO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJNO))), MAX(LENGTH(RTRIM(PROJNO)))
FROM PROJACT
;

-- rows whose PROJNO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJNO is trimmed and not blank.
SELECT ACTNO, ACSTDATE, PROJNO, '[' || PROJNO || ']' AS BRACKETED
FROM PROJACT
WHERE RTRIM(PROJNO) = ''
   OR PROJNO <> LTRIM(PROJNO)
;


-- ------------------------------------------------------------------------------------------- ACTNO
-- the smallest and the largest ACTNO; 10 and 180.
SELECT MIN(ACTNO), MAX(ACTNO)
FROM PROJACT
;

SELECT pa.ACTNO, a.ACTNO
FROM PROJACT AS pa
         LEFT OUTER JOIN ACT AS a ON pa.ACTNO = a.ACTNO
WHERE a.ACTNO IS NULL
;

-- ----------------------------------------------------------------------------------------- ACSTAFF
-- the smallest and the largest ACSTAFF; no value.
SELECT MIN(ACSTAFF), MAX(ACSTAFF)
FROM PROJACT
;

-- how many rows have no ACSTAFF; 65 of 65.
SELECT COUNT(*) - COUNT(ACSTAFF), COUNT(*)
FROM PROJACT
;


-- ---------------------------------------------------------------------------------------- ACSTDATE
-- the earliest and the latest ACSTDATE; 2002-01-01 and 2003-01-01.
SELECT MIN(ACSTDATE), MAX(ACSTDATE)
FROM PROJACT
;


-- ---------------------------------------------------------------------------------------- ACENDATE
-- the earliest and the latest ACENDATE; no value.
SELECT MIN(ACENDATE), MAX(ACENDATE)
FROM PROJACT
;

-- how many rows have no ACENDATE; 65 of 65.
SELECT COUNT(*) - COUNT(ACENDATE), COUNT(*)
FROM PROJACT
;

