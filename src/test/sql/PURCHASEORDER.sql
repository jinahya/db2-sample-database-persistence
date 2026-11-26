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
-- Profiling queries on PURCHASEORDER, a table, a section per column. Each says what it looks for and what the installed
-- data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/PURCHASEORDER.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/PURCHASEORDER.sql'
--

-- how many rows; 6.
SELECT COUNT(*)
FROM PURCHASEORDER
;


-- ---------------------------------------------------------------------------------------------------------------- POID
-- POID is the primary key; 6 distinct values in 6 rows.
SELECT COUNT(DISTINCT POID), COUNT(*)
FROM PURCHASEORDER
;

-- the smallest and the largest POID; 5000 and 5006.
SELECT MIN(POID), MAX(POID)
FROM PURCHASEORDER
;


-- -------------------------------------------------------------------------------------------------------------- STATUS
-- the shortest and the longest STATUS, trailing spaces trimmed; 7 to 9 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(STATUS))), MAX(LENGTH(RTRIM(STATUS)))
FROM PURCHASEORDER
;

-- rows whose STATUS is blank, or carries leading or trailing spaces.
-- no rows: every STATUS is trimmed and not blank.
SELECT POID, STATUS, '[' || STATUS || ']' AS BRACKETED
FROM PURCHASEORDER
WHERE RTRIM(STATUS) = ''
   OR STATUS <> LTRIM(STATUS)
   OR LENGTH(STATUS) <> LENGTH(RTRIM(STATUS))
;


-- -------------------------------------------------------------------------------------------------------------- CUSTID
-- the smallest and the largest CUSTID; 1001 and 1005.
SELECT MIN(CUSTID), MAX(CUSTID)
FROM PURCHASEORDER
;

-- how many rows have no CUSTID; 0 of 6.
SELECT COUNT(*) - COUNT(CUSTID), COUNT(*)
FROM PURCHASEORDER
;


-- ----------------------------------------------------------------------------------------------------------- ORDERDATE
-- the earliest and the latest ORDERDATE; 2004-02-29 and 2006-03-01.
SELECT MIN(ORDERDATE), MAX(ORDERDATE)
FROM PURCHASEORDER
;

-- how many rows have no ORDERDATE; 0 of 6.
SELECT COUNT(*) - COUNT(ORDERDATE), COUNT(*)
FROM PURCHASEORDER
;


-- -------------------------------------------------------------------------------------------------------------- PORDER
-- the XML schema each PORDER was validated against when it was loaded; PORDER for 6.
SELECT COALESCE((SELECT o.OBJECTNAME
                  FROM SYSCAT.XSROBJECTS o
                  WHERE o.OBJECTID = XMLXSROBJECTID(t.PORDER)), '-') AS SCHEMA, COUNT(*)
FROM PURCHASEORDER t
WHERE t.PORDER IS NOT NULL
GROUP BY XMLXSROBJECTID(t.PORDER)
;

-- how many rows have no PORDER; 0 of 6.
SELECT COUNT(*) - COUNT(PORDER), COUNT(*)
FROM PURCHASEORDER
;


-- ------------------------------------------------------------------------------------------------------------ COMMENTS
-- the shortest and the longest COMMENTS, trailing spaces trimmed; always 28 characters, of VARCHAR(1000) declared.
SELECT MIN(LENGTH(RTRIM(COMMENTS))), MAX(LENGTH(RTRIM(COMMENTS)))
FROM PURCHASEORDER
;

-- rows whose COMMENTS is blank, or carries leading or trailing spaces.
-- no rows: every COMMENTS is trimmed and not blank.
SELECT POID, COMMENTS, '[' || COMMENTS || ']' AS BRACKETED
FROM PURCHASEORDER
WHERE RTRIM(COMMENTS) = ''
   OR COMMENTS <> LTRIM(COMMENTS)
   OR LENGTH(COMMENTS) <> LENGTH(RTRIM(COMMENTS))
;

-- how many rows have no COMMENTS; 0 of 6.
SELECT COUNT(*) - COUNT(COMMENTS), COUNT(*)
FROM PURCHASEORDER
;

