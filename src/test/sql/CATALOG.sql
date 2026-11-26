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
-- Profiling queries on CATALOG, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/CATALOG.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/CATALOG.sql'
--

-- how many rows; 0.
SELECT COUNT(*)
FROM CATALOG
;


-- ---------------------------------------------------------------------------------------------------------------- NAME
-- NAME is the primary key; 0 distinct values in 0 rows.
SELECT COUNT(DISTINCT NAME), COUNT(*)
FROM CATALOG
;

-- the shortest and the longest NAME; no value, of VARCHAR(128) declared.
SELECT MIN(LENGTH(RTRIM(NAME))), MAX(LENGTH(RTRIM(NAME)))
FROM CATALOG
;

-- rows whose NAME is blank, or carries leading or trailing spaces.
-- no rows: every NAME is trimmed and not blank.
SELECT NAME, '[' || NAME || ']' AS BRACKETED
FROM CATALOG
WHERE RTRIM(NAME) = ''
   OR NAME <> LTRIM(NAME)
   OR LENGTH(NAME) <> LENGTH(RTRIM(NAME))
;


-- -------------------------------------------------------------------------------------------------------------- CATLOG
-- the XML schema each CATLOG was validated against when it was loaded; no document.
SELECT COALESCE((SELECT o.OBJECTNAME
                  FROM SYSCAT.XSROBJECTS o
                  WHERE o.OBJECTID = XMLXSROBJECTID(t.CATLOG)), '-') AS SCHEMA, COUNT(*)
FROM CATALOG t
WHERE t.CATLOG IS NOT NULL
GROUP BY XMLXSROBJECTID(t.CATLOG)
;

-- how many rows have no CATLOG; 0 of 0.
SELECT COUNT(*) - COUNT(CATLOG), COUNT(*)
FROM CATALOG
;

