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
-- Profiling queries on INVENTORY, a table, a section per column. Each says what it looks for and what the installed
-- data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/INVENTORY.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/INVENTORY.sql'
--

-- how many rows; 4.
SELECT COUNT(*)
FROM INVENTORY
;


-- ----------------------------------------------------------------------------------------------------------------- PID
-- PID is the primary key; 4 distinct values in 4 rows.
SELECT COUNT(DISTINCT PID), COUNT(*)
FROM INVENTORY
;

-- the shortest and the longest PID, trailing spaces trimmed; always 10 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(PID))), MAX(LENGTH(RTRIM(PID)))
FROM INVENTORY
;

-- rows whose PID is blank, or carries leading or trailing spaces.
-- no rows: every PID is trimmed and not blank.
SELECT PID, '[' || PID || ']' AS BRACKETED
FROM INVENTORY
WHERE RTRIM(PID) = ''
   OR PID <> LTRIM(PID)
   OR LENGTH(PID) <> LENGTH(RTRIM(PID))
;


-- ------------------------------------------------------------------------------------------------------------ QUANTITY
-- the smallest and the largest QUANTITY; 5 and 99.
SELECT MIN(QUANTITY), MAX(QUANTITY)
FROM INVENTORY
;

-- how many rows have no QUANTITY; 0 of 4.
SELECT COUNT(*) - COUNT(QUANTITY), COUNT(*)
FROM INVENTORY
;


-- ------------------------------------------------------------------------------------------------------------ LOCATION
-- the shortest and the longest LOCATION, trailing spaces trimmed; 5 to 9 characters, of VARCHAR(128) declared.
SELECT MIN(LENGTH(RTRIM(LOCATION))), MAX(LENGTH(RTRIM(LOCATION)))
FROM INVENTORY
;

-- rows whose LOCATION is blank, or carries leading or trailing spaces.
-- no rows: every LOCATION is trimmed and not blank.
SELECT PID, LOCATION, '[' || LOCATION || ']' AS BRACKETED
FROM INVENTORY
WHERE RTRIM(LOCATION) = ''
   OR LOCATION <> LTRIM(LOCATION)
   OR LENGTH(LOCATION) <> LENGTH(RTRIM(LOCATION))
;

-- how many rows have no LOCATION; 1 of 4.
SELECT COUNT(*) - COUNT(LOCATION), COUNT(*)
FROM INVENTORY
;

