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
-- Profiling queries on SUPPLIERS, a table, a section per column. Each says what it looks for and what the installed
-- data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/SUPPLIERS.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/SUPPLIERS.sql'
--

-- how many rows; 2.
SELECT COUNT(*)
FROM SUPPLIERS
;


-- --------------------------------------------------------------------------------------------- SID
-- SID is the primary key; 2 distinct values in 2 rows.
SELECT COUNT(DISTINCT SID), COUNT(*)
FROM SUPPLIERS
;

-- the shortest and the longest SID, trailing spaces trimmed; always 3 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(SID))), MAX(LENGTH(RTRIM(SID)))
FROM SUPPLIERS
;

-- rows whose SID is blank, or carries leading or trailing spaces.
-- no rows: every SID is trimmed and not blank.
SELECT SID, '[' || SID || ']' AS BRACKETED
FROM SUPPLIERS
WHERE RTRIM(SID) = ''
   OR SID <> LTRIM(SID)
   OR LENGTH(SID) <> LENGTH(RTRIM(SID))
;


-- -------------------------------------------------------------------------------------------- ADDR
-- the XML schema each ADDR was validated against when it was loaded; SUPPLIER for 2.
SELECT COALESCE((SELECT o.OBJECTNAME
                  FROM SYSCAT.XSROBJECTS o
                  WHERE o.OBJECTID = XMLXSROBJECTID(t.ADDR)), '-') AS SCHEMA, COUNT(*)
FROM SUPPLIERS t
WHERE t.ADDR IS NOT NULL
GROUP BY XMLXSROBJECTID(t.ADDR)
;

-- how many rows have no ADDR; 0 of 2.
SELECT COUNT(*) - COUNT(ADDR), COUNT(*)
FROM SUPPLIERS
;

