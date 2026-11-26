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
-- Profiling queries on VPSTRDE1, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VPSTRDE1.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VPSTRDE1.sql'
--

-- how many rows; 14.
SELECT COUNT(*)
FROM VPSTRDE1
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, PROJ1NO, PROJ2NO, of a view, which has no key: the values which more than one
-- row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT PROJ1NO, PROJ2NO, COUNT(*)
FROM VPSTRDE1
GROUP BY PROJ1NO, PROJ2NO
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------------------------- PROJ1NO
-- the shortest and the longest PROJ1NO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJ1NO))), MAX(LENGTH(RTRIM(PROJ1NO)))
FROM VPSTRDE1
;

-- rows whose PROJ1NO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJ1NO is trimmed and not blank.
SELECT PROJ1NO, '[' || PROJ1NO || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(PROJ1NO) = ''
   OR PROJ1NO <> LTRIM(PROJ1NO)
;


-- ----------------------------------------------------------------------------------------------------------- PROJ1NAME
-- the shortest and the longest PROJ1NAME, trailing spaces trimmed; 14 to 21 characters, of VARCHAR(24) declared.
SELECT MIN(LENGTH(RTRIM(PROJ1NAME))), MAX(LENGTH(RTRIM(PROJ1NAME)))
FROM VPSTRDE1
;

-- rows whose PROJ1NAME is blank, or carries leading or trailing spaces.
-- no rows: every PROJ1NAME is trimmed and not blank.
SELECT PROJ1NAME, '[' || PROJ1NAME || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(PROJ1NAME) = ''
   OR PROJ1NAME <> LTRIM(PROJ1NAME)
   OR LENGTH(PROJ1NAME) <> LENGTH(RTRIM(PROJ1NAME))
;


-- ------------------------------------------------------------------------------------------------------------- RESP1NO
-- the shortest and the longest RESP1NO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(RESP1NO))), MAX(LENGTH(RTRIM(RESP1NO)))
FROM VPSTRDE1
;

-- rows whose RESP1NO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every RESP1NO is trimmed and not blank.
SELECT RESP1NO, '[' || RESP1NO || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(RESP1NO) = ''
   OR RESP1NO <> LTRIM(RESP1NO)
;


-- ------------------------------------------------------------------------------------------------------------- RESP1FN
-- the shortest and the longest RESP1FN, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(RESP1FN))), MAX(LENGTH(RTRIM(RESP1FN)))
FROM VPSTRDE1
;

-- rows whose RESP1FN is blank, or carries leading or trailing spaces.
-- no rows: every RESP1FN is trimmed and not blank.
SELECT RESP1FN, '[' || RESP1FN || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(RESP1FN) = ''
   OR RESP1FN <> LTRIM(RESP1FN)
   OR LENGTH(RESP1FN) <> LENGTH(RTRIM(RESP1FN))
;


-- ------------------------------------------------------------------------------------------------------------- RESP1MI
-- the shortest and the longest RESP1MI, trailing spaces trimmed; always 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(RESP1MI))), MAX(LENGTH(RTRIM(RESP1MI)))
FROM VPSTRDE1
;

-- rows whose RESP1MI is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every RESP1MI is trimmed and not blank.
SELECT RESP1MI, '[' || RESP1MI || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(RESP1MI) = ''
   OR RESP1MI <> LTRIM(RESP1MI)
;

-- how many rows have no RESP1MI; 0 of 14.
SELECT COUNT(*) - COUNT(RESP1MI), COUNT(*)
FROM VPSTRDE1
;


-- ------------------------------------------------------------------------------------------------------------- RESP1LN
-- the shortest and the longest RESP1LN, trailing spaces trimmed; 4 to 7 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(RESP1LN))), MAX(LENGTH(RTRIM(RESP1LN)))
FROM VPSTRDE1
;

-- rows whose RESP1LN is blank, or carries leading or trailing spaces.
-- no rows: every RESP1LN is trimmed and not blank.
SELECT RESP1LN, '[' || RESP1LN || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(RESP1LN) = ''
   OR RESP1LN <> LTRIM(RESP1LN)
   OR LENGTH(RESP1LN) <> LENGTH(RTRIM(RESP1LN))
;


-- ------------------------------------------------------------------------------------------------------------- PROJ2NO
-- the shortest and the longest PROJ2NO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(PROJ2NO))), MAX(LENGTH(RTRIM(PROJ2NO)))
FROM VPSTRDE1
;

-- rows whose PROJ2NO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every PROJ2NO is trimmed and not blank.
SELECT PROJ2NO, '[' || PROJ2NO || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(PROJ2NO) = ''
   OR PROJ2NO <> LTRIM(PROJ2NO)
;


-- ----------------------------------------------------------------------------------------------------------- PROJ2NAME
-- the shortest and the longest PROJ2NAME, trailing spaces trimmed; 9 to 21 characters, of VARCHAR(24) declared.
SELECT MIN(LENGTH(RTRIM(PROJ2NAME))), MAX(LENGTH(RTRIM(PROJ2NAME)))
FROM VPSTRDE1
;

-- rows whose PROJ2NAME is blank, or carries leading or trailing spaces.
-- no rows: every PROJ2NAME is trimmed and not blank.
SELECT PROJ2NAME, '[' || PROJ2NAME || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(PROJ2NAME) = ''
   OR PROJ2NAME <> LTRIM(PROJ2NAME)
   OR LENGTH(PROJ2NAME) <> LENGTH(RTRIM(PROJ2NAME))
;


-- ------------------------------------------------------------------------------------------------------------- RESP2NO
-- the shortest and the longest RESP2NO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(RESP2NO))), MAX(LENGTH(RTRIM(RESP2NO)))
FROM VPSTRDE1
;

-- rows whose RESP2NO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every RESP2NO is trimmed and not blank.
SELECT RESP2NO, '[' || RESP2NO || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(RESP2NO) = ''
   OR RESP2NO <> LTRIM(RESP2NO)
;


-- ------------------------------------------------------------------------------------------------------------- RESP2FN
-- the shortest and the longest RESP2FN, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(RESP2FN))), MAX(LENGTH(RTRIM(RESP2FN)))
FROM VPSTRDE1
;

-- rows whose RESP2FN is blank, or carries leading or trailing spaces.
-- no rows: every RESP2FN is trimmed and not blank.
SELECT RESP2FN, '[' || RESP2FN || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(RESP2FN) = ''
   OR RESP2FN <> LTRIM(RESP2FN)
   OR LENGTH(RESP2FN) <> LENGTH(RTRIM(RESP2FN))
;


-- ------------------------------------------------------------------------------------------------------------- RESP2MI
-- the shortest and the longest RESP2MI, trailing spaces trimmed; 0 to 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(RESP2MI))), MAX(LENGTH(RTRIM(RESP2MI)))
FROM VPSTRDE1
;

-- rows whose RESP2MI is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- 2 rows have a blank or padded RESP2MI; the view copies EMPLOYEE.MIDINIT, which is blank for an employee with no
-- middle initial.
SELECT RESP2MI, '[' || RESP2MI || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(RESP2MI) = ''
   OR RESP2MI <> LTRIM(RESP2MI)
;

-- how many rows have no RESP2MI; 0 of 14.
SELECT COUNT(*) - COUNT(RESP2MI), COUNT(*)
FROM VPSTRDE1
;


-- ------------------------------------------------------------------------------------------------------------- RESP2LN
-- the shortest and the longest RESP2LN, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(RESP2LN))), MAX(LENGTH(RTRIM(RESP2LN)))
FROM VPSTRDE1
;

-- rows whose RESP2LN is blank, or carries leading or trailing spaces.
-- no rows: every RESP2LN is trimmed and not blank.
SELECT RESP2LN, '[' || RESP2LN || ']' AS BRACKETED
FROM VPSTRDE1
WHERE RTRIM(RESP2LN) = ''
   OR RESP2LN <> LTRIM(RESP2LN)
   OR LENGTH(RESP2LN) <> LENGTH(RTRIM(RESP2LN))
;

