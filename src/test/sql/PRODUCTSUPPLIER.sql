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
-- Profiling queries on PRODUCTSUPPLIER, a table, a section per column. Each says what it looks for and what the
-- installed data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/PRODUCTSUPPLIER.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/PRODUCTSUPPLIER.sql'
--

-- how many rows; 2.
SELECT COUNT(*)
FROM PRODUCTSUPPLIER
;


-- ----------------------------------------------------------------------------------------------------------------- PID
-- the shortest and the longest PID, trailing spaces trimmed; always 10 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(PID))), MAX(LENGTH(RTRIM(PID)))
FROM PRODUCTSUPPLIER
;

-- rows whose PID is blank, or carries leading or trailing spaces.
-- no rows: every PID is trimmed and not blank.
SELECT SID, PID, '[' || PID || ']' AS BRACKETED
FROM PRODUCTSUPPLIER
WHERE RTRIM(PID) = ''
   OR PID <> LTRIM(PID)
   OR LENGTH(PID) <> LENGTH(RTRIM(PID))
;


-- ----------------------------------------------------------------------------------------------------------------- SID
-- the shortest and the longest SID, trailing spaces trimmed; always 3 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(SID))), MAX(LENGTH(RTRIM(SID)))
FROM PRODUCTSUPPLIER
;

-- rows whose SID is blank, or carries leading or trailing spaces.
-- no rows: every SID is trimmed and not blank.
SELECT PID, SID, '[' || SID || ']' AS BRACKETED
FROM PRODUCTSUPPLIER
WHERE RTRIM(SID) = ''
   OR SID <> LTRIM(SID)
   OR LENGTH(SID) <> LENGTH(RTRIM(SID))
;

