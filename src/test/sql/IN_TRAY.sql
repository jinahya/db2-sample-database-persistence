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
-- Profiling queries on IN_TRAY, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/IN_TRAY.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/IN_TRAY.sql'
--

-- how many rows; 3.
SELECT COUNT(*)
FROM IN_TRAY
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- this table declares no primary key, and is mapped as no entity, with no identifier. RECEIVED, which the data alone
-- would suggest as one: the values which more than one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT RECEIVED, COUNT(*)
FROM IN_TRAY
GROUP BY RECEIVED
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------------------------ RECEIVED
-- the earliest and the latest RECEIVED; 1988-12-22-14.07.21.136421 and 1988-12-25-17.12.30.000000.
SELECT MIN(RECEIVED), MAX(RECEIVED)
FROM IN_TRAY
;

-- how many rows have no RECEIVED; 0 of 3.
SELECT COUNT(*) - COUNT(RECEIVED), COUNT(*)
FROM IN_TRAY
;


-- -------------------------------------------------------------------------------------------------------------- SOURCE
-- the shortest and the longest SOURCE, trailing spaces trimmed; 5 to 8 characters, of CHARACTER(8) declared.
SELECT MIN(LENGTH(RTRIM(SOURCE))), MAX(LENGTH(RTRIM(SOURCE)))
FROM IN_TRAY
;

-- rows whose SOURCE is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every SOURCE is trimmed and not blank.
SELECT SOURCE, '[' || SOURCE || ']' AS BRACKETED
FROM IN_TRAY
WHERE RTRIM(SOURCE) = ''
   OR SOURCE <> LTRIM(SOURCE)
;

-- how many rows have no SOURCE; 0 of 3.
SELECT COUNT(*) - COUNT(SOURCE), COUNT(*)
FROM IN_TRAY
;


-- ------------------------------------------------------------------------------------------------------------- SUBJECT
-- the shortest and the longest SUBJECT, trailing spaces trimmed; 34 to 39 characters, of CHARACTER(64) declared.
SELECT MIN(LENGTH(RTRIM(SUBJECT))), MAX(LENGTH(RTRIM(SUBJECT)))
FROM IN_TRAY
;

-- rows whose SUBJECT is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every SUBJECT is trimmed and not blank.
SELECT SUBJECT, '[' || SUBJECT || ']' AS BRACKETED
FROM IN_TRAY
WHERE RTRIM(SUBJECT) = ''
   OR SUBJECT <> LTRIM(SUBJECT)
;

-- how many rows have no SUBJECT; 0 of 3.
SELECT COUNT(*) - COUNT(SUBJECT), COUNT(*)
FROM IN_TRAY
;


-- ----------------------------------------------------------------------------------------------------------- NOTE_TEXT
-- the shortest and the longest NOTE_TEXT, trailing spaces trimmed; 192 to 649 characters, of VARCHAR(3000) declared.
SELECT MIN(LENGTH(RTRIM(NOTE_TEXT))), MAX(LENGTH(RTRIM(NOTE_TEXT)))
FROM IN_TRAY
;

-- rows whose NOTE_TEXT is blank, or carries leading or trailing spaces.
-- no rows: every NOTE_TEXT is trimmed and not blank.
SELECT NOTE_TEXT, '[' || NOTE_TEXT || ']' AS BRACKETED
FROM IN_TRAY
WHERE RTRIM(NOTE_TEXT) = ''
   OR NOTE_TEXT <> LTRIM(NOTE_TEXT)
   OR LENGTH(NOTE_TEXT) <> LENGTH(RTRIM(NOTE_TEXT))
;

-- how many rows have no NOTE_TEXT; 0 of 3.
SELECT COUNT(*) - COUNT(NOTE_TEXT), COUNT(*)
FROM IN_TRAY
;

