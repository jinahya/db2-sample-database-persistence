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
-- Profiling queries on VASTRDE1, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VASTRDE1.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VASTRDE1.sql'
--

-- how many rows; 14.
SELECT COUNT(*)
FROM VASTRDE1
;


-- ------------------------------------------------------------------------------------------------------------- DEPT1NO
-- the shortest and the longest DEPT1NO, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(DEPT1NO))), MAX(LENGTH(RTRIM(DEPT1NO)))
FROM VASTRDE1
;

-- rows whose DEPT1NO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every DEPT1NO is trimmed and not blank.
SELECT DEPT1NO, '[' || DEPT1NO || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(DEPT1NO) = ''
   OR DEPT1NO <> LTRIM(DEPT1NO)
;


-- ------------------------------------------------------------------------------------------------------------ DEPT1NAM
-- the shortest and the longest DEPT1NAM, trailing spaces trimmed; 16 to 28 characters, of VARCHAR(36) declared.
SELECT MIN(LENGTH(RTRIM(DEPT1NAM))), MAX(LENGTH(RTRIM(DEPT1NAM)))
FROM VASTRDE1
;

-- rows whose DEPT1NAM is blank, or carries leading or trailing spaces.
-- no rows: every DEPT1NAM is trimmed and not blank.
SELECT DEPT1NAM, '[' || DEPT1NAM || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(DEPT1NAM) = ''
   OR DEPT1NAM <> LTRIM(DEPT1NAM)
   OR LENGTH(DEPT1NAM) <> LENGTH(RTRIM(DEPT1NAM))
;


-- -------------------------------------------------------------------------------------------------------------- EMP1NO
-- the shortest and the longest EMP1NO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMP1NO))), MAX(LENGTH(RTRIM(EMP1NO)))
FROM VASTRDE1
;

-- rows whose EMP1NO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMP1NO is trimmed and not blank.
SELECT EMP1NO, '[' || EMP1NO || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(EMP1NO) = ''
   OR EMP1NO <> LTRIM(EMP1NO)
;

-- how many rows have no EMP1NO; 2 of 14.
SELECT COUNT(*) - COUNT(EMP1NO), COUNT(*)
FROM VASTRDE1
;


-- -------------------------------------------------------------------------------------------------------------- EMP1FN
-- the shortest and the longest EMP1FN, trailing spaces trimmed; 4 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(EMP1FN))), MAX(LENGTH(RTRIM(EMP1FN)))
FROM VASTRDE1
;

-- rows whose EMP1FN is blank, or carries leading or trailing spaces.
-- no rows: every EMP1FN is trimmed and not blank.
SELECT EMP1FN, '[' || EMP1FN || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(EMP1FN) = ''
   OR EMP1FN <> LTRIM(EMP1FN)
   OR LENGTH(EMP1FN) <> LENGTH(RTRIM(EMP1FN))
;

-- how many rows have no EMP1FN; 2 of 14.
SELECT COUNT(*) - COUNT(EMP1FN), COUNT(*)
FROM VASTRDE1
;


-- -------------------------------------------------------------------------------------------------------------- EMP1MI
-- the shortest and the longest EMP1MI, trailing spaces trimmed; always 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(EMP1MI))), MAX(LENGTH(RTRIM(EMP1MI)))
FROM VASTRDE1
;

-- rows whose EMP1MI is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMP1MI is trimmed and not blank.
SELECT EMP1MI, '[' || EMP1MI || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(EMP1MI) = ''
   OR EMP1MI <> LTRIM(EMP1MI)
;

-- how many rows have no EMP1MI; 2 of 14.
SELECT COUNT(*) - COUNT(EMP1MI), COUNT(*)
FROM VASTRDE1
;


-- -------------------------------------------------------------------------------------------------------------- EMP1LN
-- the shortest and the longest EMP1LN, trailing spaces trimmed; 4 to 5 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(EMP1LN))), MAX(LENGTH(RTRIM(EMP1LN)))
FROM VASTRDE1
;

-- rows whose EMP1LN is blank, or carries leading or trailing spaces.
-- no rows: every EMP1LN is trimmed and not blank.
SELECT EMP1LN, '[' || EMP1LN || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(EMP1LN) = ''
   OR EMP1LN <> LTRIM(EMP1LN)
   OR LENGTH(EMP1LN) <> LENGTH(RTRIM(EMP1LN))
;

-- how many rows have no EMP1LN; 2 of 14.
SELECT COUNT(*) - COUNT(EMP1LN), COUNT(*)
FROM VASTRDE1
;


-- --------------------------------------------------------------------------------------------------------------- TYPE2
-- the shortest and the longest TYPE2, trailing spaces trimmed; always 1 characters, of VARCHAR(1) declared.
SELECT MIN(LENGTH(RTRIM(TYPE2))), MAX(LENGTH(RTRIM(TYPE2)))
FROM VASTRDE1
;

-- rows whose TYPE2 is blank, or carries leading or trailing spaces.
-- no rows: every TYPE2 is trimmed and not blank.
SELECT TYPE2, '[' || TYPE2 || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(TYPE2) = ''
   OR TYPE2 <> LTRIM(TYPE2)
   OR LENGTH(TYPE2) <> LENGTH(RTRIM(TYPE2))
;


-- ------------------------------------------------------------------------------------------------------------- DEPT2NO
-- the shortest and the longest DEPT2NO, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(DEPT2NO))), MAX(LENGTH(RTRIM(DEPT2NO)))
FROM VASTRDE1
;

-- rows whose DEPT2NO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every DEPT2NO is trimmed and not blank.
SELECT DEPT2NO, '[' || DEPT2NO || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(DEPT2NO) = ''
   OR DEPT2NO <> LTRIM(DEPT2NO)
;


-- ------------------------------------------------------------------------------------------------------------ DEPT2NAM
-- the shortest and the longest DEPT2NAM, trailing spaces trimmed; 8 to 28 characters, of VARCHAR(36) declared.
SELECT MIN(LENGTH(RTRIM(DEPT2NAM))), MAX(LENGTH(RTRIM(DEPT2NAM)))
FROM VASTRDE1
;

-- rows whose DEPT2NAM is blank, or carries leading or trailing spaces.
-- no rows: every DEPT2NAM is trimmed and not blank.
SELECT DEPT2NAM, '[' || DEPT2NAM || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(DEPT2NAM) = ''
   OR DEPT2NAM <> LTRIM(DEPT2NAM)
   OR LENGTH(DEPT2NAM) <> LENGTH(RTRIM(DEPT2NAM))
;


-- -------------------------------------------------------------------------------------------------------------- EMP2NO
-- the shortest and the longest EMP2NO, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMP2NO))), MAX(LENGTH(RTRIM(EMP2NO)))
FROM VASTRDE1
;

-- rows whose EMP2NO is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMP2NO is trimmed and not blank.
SELECT EMP2NO, '[' || EMP2NO || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(EMP2NO) = ''
   OR EMP2NO <> LTRIM(EMP2NO)
;

-- how many rows have no EMP2NO; 6 of 14.
SELECT COUNT(*) - COUNT(EMP2NO), COUNT(*)
FROM VASTRDE1
;


-- -------------------------------------------------------------------------------------------------------------- EMP2FN
-- the shortest and the longest EMP2FN, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(EMP2FN))), MAX(LENGTH(RTRIM(EMP2FN)))
FROM VASTRDE1
;

-- rows whose EMP2FN is blank, or carries leading or trailing spaces.
-- no rows: every EMP2FN is trimmed and not blank.
SELECT EMP2FN, '[' || EMP2FN || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(EMP2FN) = ''
   OR EMP2FN <> LTRIM(EMP2FN)
   OR LENGTH(EMP2FN) <> LENGTH(RTRIM(EMP2FN))
;

-- how many rows have no EMP2FN; 6 of 14.
SELECT COUNT(*) - COUNT(EMP2FN), COUNT(*)
FROM VASTRDE1
;


-- -------------------------------------------------------------------------------------------------------------- EMP2MI
-- the shortest and the longest EMP2MI, trailing spaces trimmed; always 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(EMP2MI))), MAX(LENGTH(RTRIM(EMP2MI)))
FROM VASTRDE1
;

-- rows whose EMP2MI is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every EMP2MI is trimmed and not blank.
SELECT EMP2MI, '[' || EMP2MI || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(EMP2MI) = ''
   OR EMP2MI <> LTRIM(EMP2MI)
;

-- how many rows have no EMP2MI; 6 of 14.
SELECT COUNT(*) - COUNT(EMP2MI), COUNT(*)
FROM VASTRDE1
;


-- -------------------------------------------------------------------------------------------------------------- EMP2LN
-- the shortest and the longest EMP2LN, trailing spaces trimmed; 4 to 9 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(EMP2LN))), MAX(LENGTH(RTRIM(EMP2LN)))
FROM VASTRDE1
;

-- rows whose EMP2LN is blank, or carries leading or trailing spaces.
-- no rows: every EMP2LN is trimmed and not blank.
SELECT EMP2LN, '[' || EMP2LN || ']' AS BRACKETED
FROM VASTRDE1
WHERE RTRIM(EMP2LN) = ''
   OR EMP2LN <> LTRIM(EMP2LN)
   OR LENGTH(EMP2LN) <> LENGTH(RTRIM(EMP2LN))
;

-- how many rows have no EMP2LN; 6 of 14.
SELECT COUNT(*) - COUNT(EMP2LN), COUNT(*)
FROM VASTRDE1
;

