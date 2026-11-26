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
-- Profiling queries on CUSTOMER, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/CUSTOMER.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/CUSTOMER.sql'
--

-- how many rows; 6.
SELECT COUNT(*)
FROM CUSTOMER
;


-- ----------------------------------------------------------------------------------------------------------------- CID
-- CID is the primary key; 6 distinct values in 6 rows.
SELECT COUNT(DISTINCT CID), COUNT(*)
FROM CUSTOMER
;

-- the smallest and the largest CID; 1000 and 1005.
SELECT MIN(CID), MAX(CID)
FROM CUSTOMER
;


-- ---------------------------------------------------------------------------------------------------------------- INFO
-- the XML schema each INFO was validated against when it was loaded; CUSTOMER for 6.
SELECT COALESCE((SELECT o.OBJECTNAME
                  FROM SYSCAT.XSROBJECTS o
                  WHERE o.OBJECTID = XMLXSROBJECTID(t.INFO)), '-') AS SCHEMA, COUNT(*)
FROM CUSTOMER t
WHERE t.INFO IS NOT NULL
GROUP BY XMLXSROBJECTID(t.INFO)
;

-- how many rows have no INFO; 0 of 6.
SELECT COUNT(*) - COUNT(INFO), COUNT(*)
FROM CUSTOMER
;


-- ------------------------------------------------------------------------------------------------------------- HISTORY
-- the XML schema each HISTORY was validated against when it was loaded; no document.
SELECT COALESCE((SELECT o.OBJECTNAME
                  FROM SYSCAT.XSROBJECTS o
                  WHERE o.OBJECTID = XMLXSROBJECTID(t.HISTORY)), '-') AS SCHEMA, COUNT(*)
FROM CUSTOMER t
WHERE t.HISTORY IS NOT NULL
GROUP BY XMLXSROBJECTID(t.HISTORY)
;

-- how many rows have no HISTORY; 6 of 6.
SELECT COUNT(*) - COUNT(HISTORY), COUNT(*)
FROM CUSTOMER
;

