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
-- Profiling queries on CL_SCHED, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/CL_SCHED.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/CL_SCHED.sql'
--

-- how many rows; 5.
SELECT COUNT(*)
FROM CL_SCHED
;


-- ---------------------------------------------------------------------------------------------------------- CLASS_CODE
-- the shortest and the longest CLASS_CODE, trailing spaces trimmed; 6 to 7 characters, of CHARACTER(7) declared.
SELECT MIN(LENGTH(RTRIM(CLASS_CODE))), MAX(LENGTH(RTRIM(CLASS_CODE)))
FROM CL_SCHED
;

-- rows whose CLASS_CODE is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every CLASS_CODE is trimmed and not blank.
SELECT CLASS_CODE, '[' || CLASS_CODE || ']' AS BRACKETED
FROM CL_SCHED
WHERE RTRIM(CLASS_CODE) = ''
   OR CLASS_CODE <> LTRIM(CLASS_CODE)
;

-- how many rows have no CLASS_CODE; 0 of 5.
SELECT COUNT(*) - COUNT(CLASS_CODE), COUNT(*)
FROM CL_SCHED
;


-- ----------------------------------------------------------------------------------------------------------------- DAY
-- the smallest and the largest DAY; 1 and 4.
SELECT MIN(DAY), MAX(DAY)
FROM CL_SCHED
;

-- how many rows have no DAY; 0 of 5.
SELECT COUNT(*) - COUNT(DAY), COUNT(*)
FROM CL_SCHED
;


-- ------------------------------------------------------------------------------------------------------------ STARTING
-- the earliest and the latest STARTING; 09:10:00 and 17:12:30.
SELECT MIN(STARTING), MAX(STARTING)
FROM CL_SCHED
;

-- how many rows have no STARTING; 0 of 5.
SELECT COUNT(*) - COUNT(STARTING), COUNT(*)
FROM CL_SCHED
;


-- -------------------------------------------------------------------------------------------------------------- ENDING
-- the earliest and the latest ENDING; 10:30:00 and 18:00:00.
SELECT MIN(ENDING), MAX(ENDING)
FROM CL_SCHED
;

-- how many rows have no ENDING; 0 of 5.
SELECT COUNT(*) - COUNT(ENDING), COUNT(*)
FROM CL_SCHED
;

