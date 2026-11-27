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
-- Profiling queries on PRODUCT, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/PRODUCT.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/PRODUCT.sql'
--

-- how many rows; 4.
SELECT COUNT(*)
FROM PRODUCT
;


-- --------------------------------------------------------------------------------------------- PID
-- PID is the primary key; 4 distinct values in 4 rows.
SELECT COUNT(DISTINCT PID), COUNT(*)
FROM PRODUCT
;

-- the shortest and the longest PID, trailing spaces trimmed; always 10 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(PID))), MAX(LENGTH(RTRIM(PID)))
FROM PRODUCT
;

-- rows whose PID is blank, or carries leading or trailing spaces.
-- no rows: every PID is trimmed and not blank.
SELECT PID, '[' || PID || ']' AS BRACKETED
FROM PRODUCT
WHERE RTRIM(PID) = ''
   OR PID <> LTRIM(PID)
   OR LENGTH(PID) <> LENGTH(RTRIM(PID))
;


-- -------------------------------------------------------------------------------------------- NAME
-- the shortest and the longest NAME, trailing spaces trimmed; 26 to 33 characters, of VARCHAR(128) declared.
SELECT MIN(LENGTH(RTRIM(NAME))), MAX(LENGTH(RTRIM(NAME)))
FROM PRODUCT
;

-- rows whose NAME is blank, or carries leading or trailing spaces.
-- no rows: every NAME is trimmed and not blank.
SELECT PID, NAME, '[' || NAME || ']' AS BRACKETED
FROM PRODUCT
WHERE RTRIM(NAME) = ''
   OR NAME <> LTRIM(NAME)
   OR LENGTH(NAME) <> LENGTH(RTRIM(NAME))
;

-- how many rows have no NAME; 0 of 4.
SELECT COUNT(*) - COUNT(NAME), COUNT(*)
FROM PRODUCT
;


-- ------------------------------------------------------------------------------------------- PRICE
-- the smallest and the largest PRICE; 3.99 and 49.99.
SELECT MIN(PRICE), MAX(PRICE)
FROM PRODUCT
;

-- how many rows have no PRICE; 0 of 4.
SELECT COUNT(*) - COUNT(PRICE), COUNT(*)
FROM PRODUCT
;


-- -------------------------------------------------------------------------------------- PROMOPRICE
-- the smallest and the largest PROMOPRICE; 7.25 and 39.99.
SELECT MIN(PROMOPRICE), MAX(PROMOPRICE)
FROM PRODUCT
;

-- how many rows have no PROMOPRICE; 1 of 4.
SELECT COUNT(*) - COUNT(PROMOPRICE), COUNT(*)
FROM PRODUCT
;

SELECT *
FROM PRODUCT
WHERE PRICE IS NOT NULL
  AND PROMOPRICE IS NOT NULL
  AND PROMOPRICE >= PRICE
;


-- -------------------------------------------------------------------------------------- PROMOSTART
-- the earliest and the latest PROMOSTART; 2004-11-19 and 2005-12-22.
SELECT MIN(PROMOSTART), MAX(PROMOSTART)
FROM PRODUCT
;

-- how many rows have no PROMOSTART; 1 of 4.
SELECT COUNT(*) - COUNT(PROMOSTART), COUNT(*)
FROM PRODUCT
;


-- ---------------------------------------------------------------------------------------- PROMOEND
-- the earliest and the latest PROMOEND; 2004-12-19 and 2006-02-28.
SELECT MIN(PROMOEND), MAX(PROMOEND)
FROM PRODUCT
;

-- how many rows have no PROMOEND; 1 of 4.
SELECT COUNT(*) - COUNT(PROMOEND), COUNT(*)
FROM PRODUCT
;

SELECT *
FROM PRODUCT
WHERE PROMOSTART IS NOT NULL
  AND PROMOEND IS NOT NULL
  AND PROMOEND < PROMOSTART
;


-- ------------------------------------------------------------------------------------- DESCRIPTION
-- the XML schema each DESCRIPTION was validated against when it was loaded; PRODUCT for 4.
SELECT COALESCE((SELECT o.OBJECTNAME
                 FROM SYSCAT.XSROBJECTS o
                 WHERE o.OBJECTID = XMLXSROBJECTID(t.DESCRIPTION)), '-') AS SCHEMA,
       COUNT(*)
FROM PRODUCT t
WHERE t.DESCRIPTION IS NOT NULL
GROUP BY XMLXSROBJECTID(t.DESCRIPTION)
;

-- how many rows have no DESCRIPTION; 0 of 4.
SELECT COUNT(*) - COUNT(DESCRIPTION), COUNT(*)
FROM PRODUCT
;

