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
-- Profiling queries on SALES, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/SALES.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/SALES.sql'
--

-- how many rows; 41.
SELECT COUNT(*)
FROM SALES
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- this table declares no primary key, and is mapped as no entity, with no identifier. SALES_DATE, SALES_PERSON, REGION,
-- which the data alone would suggest as one: the values which more than one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT SALES_DATE, SALES_PERSON, REGION, COUNT(*)
FROM SALES
GROUP BY SALES_DATE, SALES_PERSON, REGION
HAVING COUNT(*) > 1
;


-- ---------------------------------------------------------------------------------------------------------- SALES_DATE
-- the earliest and the latest SALES_DATE; 1996-03-29 and 2006-04-01.
SELECT MIN(SALES_DATE), MAX(SALES_DATE)
FROM SALES
;

-- how many rows have no SALES_DATE; 0 of 41.
SELECT COUNT(*) - COUNT(SALES_DATE), COUNT(*)
FROM SALES
;


-- -------------------------------------------------------------------------------------------------------- SALES_PERSON
-- the shortest and the longest SALES_PERSON, trailing spaces trimmed; 3 to 9 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(SALES_PERSON))), MAX(LENGTH(RTRIM(SALES_PERSON)))
FROM SALES
;

-- rows whose SALES_PERSON is blank, or carries leading or trailing spaces.
-- no rows: every SALES_PERSON is trimmed and not blank.
SELECT SALES_PERSON, '[' || SALES_PERSON || ']' AS BRACKETED
FROM SALES
WHERE RTRIM(SALES_PERSON) = ''
   OR SALES_PERSON <> LTRIM(SALES_PERSON)
   OR LENGTH(SALES_PERSON) <> LENGTH(RTRIM(SALES_PERSON))
;

-- how many rows have no SALES_PERSON; 0 of 41.
SELECT COUNT(*) - COUNT(SALES_PERSON), COUNT(*)
FROM SALES
;


-- -------------------------------------------------------------------------------------------------------------- REGION
-- the shortest and the longest REGION, trailing spaces trimmed; 6 to 13 characters, of VARCHAR(15) declared.
SELECT MIN(LENGTH(RTRIM(REGION))), MAX(LENGTH(RTRIM(REGION)))
FROM SALES
;

-- rows whose REGION is blank, or carries leading or trailing spaces.
-- no rows: every REGION is trimmed and not blank.
SELECT REGION, '[' || REGION || ']' AS BRACKETED
FROM SALES
WHERE RTRIM(REGION) = ''
   OR REGION <> LTRIM(REGION)
   OR LENGTH(REGION) <> LENGTH(RTRIM(REGION))
;

-- how many rows have no REGION; 0 of 41.
SELECT COUNT(*) - COUNT(REGION), COUNT(*)
FROM SALES
;


-- --------------------------------------------------------------------------------------------------------------- SALES
-- the smallest and the largest SALES; 1 and 18.
SELECT MIN(SALES), MAX(SALES)
FROM SALES
;

-- how many rows have no SALES; 1 of 41.
SELECT COUNT(*) - COUNT(SALES), COUNT(*)
FROM SALES
;

