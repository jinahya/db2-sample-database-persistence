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
-- Profiling queries on PATIENTS, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/PATIENTS.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/PATIENTS.sql'
--

-- how many rows; 20.
SELECT COUNT(*)
FROM PATIENTS
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- this table declares no primary key, and is mapped as no entity, with no identifier. PATIENT_ID, which the data alone
-- would suggest as one: the values which more than one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT PATIENT_ID, COUNT(*)
FROM PATIENTS
GROUP BY PATIENT_ID
HAVING COUNT(*) > 1
;


-- ---------------------------------------------------------------------------------------------------------- PATIENT_ID
-- the smallest and the largest PATIENT_ID; 1 and 20.
SELECT MIN(PATIENT_ID), MAX(PATIENT_ID)
FROM PATIENTS
;

-- how many rows have no PATIENT_ID; 0 of 20.
SELECT COUNT(*) - COUNT(PATIENT_ID), COUNT(*)
FROM PATIENTS
;


-- ---------------------------------------------------------------------------------------------------------------- NAME
-- the shortest and the longest NAME, trailing spaces trimmed; 10 to 16 characters, of VARCHAR(30) declared.
SELECT MIN(LENGTH(RTRIM(NAME))), MAX(LENGTH(RTRIM(NAME)))
FROM PATIENTS
;

-- rows whose NAME is blank, or carries leading or trailing spaces.
-- no rows: every NAME is trimmed and not blank.
SELECT NAME, '[' || NAME || ']' AS BRACKETED
FROM PATIENTS
WHERE RTRIM(NAME) = ''
   OR NAME <> LTRIM(NAME)
   OR LENGTH(NAME) <> LENGTH(RTRIM(NAME))
;

-- how many rows have no NAME; 0 of 20.
SELECT COUNT(*) - COUNT(NAME), COUNT(*)
FROM PATIENTS
;


-- ----------------------------------------------------------------------------------------------------------------- AGE
-- the smallest and the largest AGE; 20 and 76.
SELECT MIN(AGE), MAX(AGE)
FROM PATIENTS
;

-- how many rows have no AGE; 0 of 20.
SELECT COUNT(*) - COUNT(AGE), COUNT(*)
FROM PATIENTS
;


-- -------------------------------------------------------------------------------------------------------------- GENDER
-- the shortest and the longest GENDER, trailing spaces trimmed; 4 to 6 characters, of VARCHAR(6) declared.
SELECT MIN(LENGTH(RTRIM(GENDER))), MAX(LENGTH(RTRIM(GENDER)))
FROM PATIENTS
;

-- rows whose GENDER is blank, or carries leading or trailing spaces.
-- no rows: every GENDER is trimmed and not blank.
SELECT GENDER, '[' || GENDER || ']' AS BRACKETED
FROM PATIENTS
WHERE RTRIM(GENDER) = ''
   OR GENDER <> LTRIM(GENDER)
   OR LENGTH(GENDER) <> LENGTH(RTRIM(GENDER))
;

-- how many rows have no GENDER; 0 of 20.
SELECT COUNT(*) - COUNT(GENDER), COUNT(*)
FROM PATIENTS
;


-- --------------------------------------------------------------------------------------------------- CHOLESTEROL_LEVEL
-- the smallest and the largest CHOLESTEROL_LEVEL; 152 and 244.
SELECT MIN(CHOLESTEROL_LEVEL), MAX(CHOLESTEROL_LEVEL)
FROM PATIENTS
;

-- how many rows have no CHOLESTEROL_LEVEL; 0 of 20.
SELECT COUNT(*) - COUNT(CHOLESTEROL_LEVEL), COUNT(*)
FROM PATIENTS
;


-- ------------------------------------------------------------------------------------------------------ BLOOD_PRESSURE
-- the smallest and the largest BLOOD_PRESSURE; 81 and 178.
SELECT MIN(BLOOD_PRESSURE), MAX(BLOOD_PRESSURE)
FROM PATIENTS
;

-- how many rows have no BLOOD_PRESSURE; 0 of 20.
SELECT COUNT(*) - COUNT(BLOOD_PRESSURE), COUNT(*)
FROM PATIENTS
;


-- ------------------------------------------------------------------------------------------------------ SMOKING_STATUS
-- the shortest and the longest SMOKING_STATUS, trailing spaces trimmed; 6 to 10 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(SMOKING_STATUS))), MAX(LENGTH(RTRIM(SMOKING_STATUS)))
FROM PATIENTS
;

-- rows whose SMOKING_STATUS is blank, or carries leading or trailing spaces.
-- no rows: every SMOKING_STATUS is trimmed and not blank.
SELECT SMOKING_STATUS, '[' || SMOKING_STATUS || ']' AS BRACKETED
FROM PATIENTS
WHERE RTRIM(SMOKING_STATUS) = ''
   OR SMOKING_STATUS <> LTRIM(SMOKING_STATUS)
   OR LENGTH(SMOKING_STATUS) <> LENGTH(RTRIM(SMOKING_STATUS))
;

-- how many rows have no SMOKING_STATUS; 0 of 20.
SELECT COUNT(*) - COUNT(SMOKING_STATUS), COUNT(*)
FROM PATIENTS
;


-- ----------------------------------------------------------------------------------------------------------- EMBEDDING
-- how many rows have no EMBEDDING; 0 of 20.
SELECT COUNT(*) - COUNT(EMBEDDING), COUNT(*)
FROM PATIENTS
;

