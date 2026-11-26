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
-- Profiling queries on VPHONE, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VPHONE.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VPHONE.sql'
--

-- how many rows; 42.
SELECT COUNT(*)
FROM VPHONE
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, EMPLOYEENUMBER, of a view, which has no key: the values which more than one
-- row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT EMPLOYEENUMBER, COUNT(*)
FROM VPHONE
GROUP BY EMPLOYEENUMBER
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------------------------ LASTNAME
-- the shortest and the longest LASTNAME, trailing spaces trimmed; 3 to 10 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(LASTNAME))), MAX(LENGTH(RTRIM(LASTNAME)))
FROM VPHONE
;

-- rows whose LASTNAME is blank, or carries leading or trailing spaces.
-- no rows: every LASTNAME is trimmed and not blank.
SELECT LASTNAME, '[' || LASTNAME || ']' AS BRACKETED
FROM VPHONE
WHERE RTRIM(LASTNAME) = ''
   OR LASTNAME <> LTRIM(LASTNAME)
   OR LENGTH(LASTNAME) <> LENGTH(RTRIM(LASTNAME))
;


-- ----------------------------------------------------------------------------------------------------------- FIRSTNAME
-- the shortest and the longest FIRSTNAME, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(12) declared.
SELECT MIN(LENGTH(RTRIM(FIRSTNAME))), MAX(LENGTH(RTRIM(FIRSTNAME)))
FROM VPHONE
;

-- rows whose FIRSTNAME is blank, or carries leading or trailing spaces.
-- no rows: every FIRSTNAME is trimmed and not blank.
SELECT FIRSTNAME, '[' || FIRSTNAME || ']' AS BRACKETED
FROM VPHONE
WHERE RTRIM(FIRSTNAME) = ''
   OR FIRSTNAME <> LTRIM(FIRSTNAME)
   OR LENGTH(FIRSTNAME) <> LENGTH(RTRIM(FIRSTNAME))
;


-- ------------------------------------------------------------------------------------------------------- MIDDLEINITIAL
-- the shortest and the longest MIDDLEINITIAL, trailing spaces trimmed; 0 to 1 characters, of CHARACTER(1) declared.
SELECT MIN(LENGTH(RTRIM(MIDDLEINITIAL))), MAX(LENGTH(RTRIM(MIDDLEINITIAL)))
FROM VPHONE
;

-- rows whose MIDDLEINITIAL is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does
-- not count).
-- 7 rows have a blank or padded MIDDLEINITIAL; the view copies EMPLOYEE.MIDINIT, which is blank for an employee with no
-- middle initial.
SELECT MIDDLEINITIAL, '[' || MIDDLEINITIAL || ']' AS BRACKETED
FROM VPHONE
WHERE RTRIM(MIDDLEINITIAL) = ''
   OR MIDDLEINITIAL <> LTRIM(MIDDLEINITIAL)
;

-- how many rows have no MIDDLEINITIAL; 0 of 42.
SELECT COUNT(*) - COUNT(MIDDLEINITIAL), COUNT(*)
FROM VPHONE
;


-- --------------------------------------------------------------------------------------------------------- PHONENUMBER
-- the shortest and the longest PHONENUMBER, trailing spaces trimmed; always 4 characters, of VARCHAR(4) declared.
SELECT MIN(LENGTH(RTRIM(PHONENUMBER))), MAX(LENGTH(RTRIM(PHONENUMBER)))
FROM VPHONE
;

-- rows whose PHONENUMBER is blank, or carries leading or trailing spaces.
-- no rows: every PHONENUMBER is trimmed and not blank.
SELECT PHONENUMBER, '[' || PHONENUMBER || ']' AS BRACKETED
FROM VPHONE
WHERE RTRIM(PHONENUMBER) = ''
   OR PHONENUMBER <> LTRIM(PHONENUMBER)
   OR LENGTH(PHONENUMBER) <> LENGTH(RTRIM(PHONENUMBER))
;


-- ------------------------------------------------------------------------------------------------------ EMPLOYEENUMBER
-- the shortest and the longest EMPLOYEENUMBER, trailing spaces trimmed; always 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(EMPLOYEENUMBER))), MAX(LENGTH(RTRIM(EMPLOYEENUMBER)))
FROM VPHONE
;

-- rows whose EMPLOYEENUMBER is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does
-- not count).
-- no rows: every EMPLOYEENUMBER is trimmed and not blank.
SELECT EMPLOYEENUMBER, '[' || EMPLOYEENUMBER || ']' AS BRACKETED
FROM VPHONE
WHERE RTRIM(EMPLOYEENUMBER) = ''
   OR EMPLOYEENUMBER <> LTRIM(EMPLOYEENUMBER)
;


-- ---------------------------------------------------------------------------------------------------------- DEPTNUMBER
-- the shortest and the longest DEPTNUMBER, trailing spaces trimmed; always 3 characters, of CHARACTER(3) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNUMBER))), MAX(LENGTH(RTRIM(DEPTNUMBER)))
FROM VPHONE
;

-- rows whose DEPTNUMBER is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every DEPTNUMBER is trimmed and not blank.
SELECT DEPTNUMBER, '[' || DEPTNUMBER || ']' AS BRACKETED
FROM VPHONE
WHERE RTRIM(DEPTNUMBER) = ''
   OR DEPTNUMBER <> LTRIM(DEPTNUMBER)
;


-- ------------------------------------------------------------------------------------------------------------ DEPTNAME
-- the shortest and the longest DEPTNAME, trailing spaces trimmed; 8 to 28 characters, of VARCHAR(36) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNAME))), MAX(LENGTH(RTRIM(DEPTNAME)))
FROM VPHONE
;

-- rows whose DEPTNAME is blank, or carries leading or trailing spaces.
-- no rows: every DEPTNAME is trimmed and not blank.
SELECT DEPTNAME, '[' || DEPTNAME || ']' AS BRACKETED
FROM VPHONE
WHERE RTRIM(DEPTNAME) = ''
   OR DEPTNAME <> LTRIM(DEPTNAME)
   OR LENGTH(DEPTNAME) <> LENGTH(RTRIM(DEPTNAME))
;

