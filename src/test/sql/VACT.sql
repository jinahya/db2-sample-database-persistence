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
-- Profiling queries on VACT, a view, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/VACT.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/VACT.sql'
--

-- how many rows; 18.
SELECT COUNT(*)
FROM VACT
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, ACTNO, of a view, which has no key: the values which more than one row
-- shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT ACTNO, COUNT(*)
FROM VACT
GROUP BY ACTNO
HAVING COUNT(*) > 1
;


-- --------------------------------------------------------------------------------------------------------------- ACTNO
-- the smallest and the largest ACTNO; 10 and 180.
SELECT MIN(ACTNO), MAX(ACTNO)
FROM VACT
;


-- -------------------------------------------------------------------------------------------------------------- ACTKWD
-- the shortest and the longest ACTKWD, trailing spaces trimmed; 3 to 6 characters, of CHARACTER(6) declared.
SELECT MIN(LENGTH(RTRIM(ACTKWD))), MAX(LENGTH(RTRIM(ACTKWD)))
FROM VACT
;

-- rows whose ACTKWD is blank, or carries leading spaces (CHARACTER pads with trailing spaces, which this does not
-- count).
-- no rows: every ACTKWD is trimmed and not blank.
SELECT ACTKWD, '[' || ACTKWD || ']' AS BRACKETED
FROM VACT
WHERE RTRIM(ACTKWD) = ''
   OR ACTKWD <> LTRIM(ACTKWD)
;


-- ------------------------------------------------------------------------------------------------------------- ACTDESC
-- the shortest and the longest ACTDESC, trailing spaces trimmed; 8 to 19 characters, of VARCHAR(20) declared.
SELECT MIN(LENGTH(RTRIM(ACTDESC))), MAX(LENGTH(RTRIM(ACTDESC)))
FROM VACT
;

-- rows whose ACTDESC is blank, or carries leading or trailing spaces.
-- no rows: every ACTDESC is trimmed and not blank.
SELECT ACTDESC, '[' || ACTDESC || ']' AS BRACKETED
FROM VACT
WHERE RTRIM(ACTDESC) = ''
   OR ACTDESC <> LTRIM(ACTDESC)
   OR LENGTH(ACTDESC) <> LENGTH(RTRIM(ACTDESC))
;

