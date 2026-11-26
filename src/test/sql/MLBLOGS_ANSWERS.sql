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
-- Profiling queries on MLBLOGS_ANSWERS, a table, a section per column. Each says what it looks for and what the
-- installed data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/MLBLOGS_ANSWERS.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/MLBLOGS_ANSWERS.sql'
--

-- how many rows; 108.
SELECT COUNT(*)
FROM MLBLOGS_ANSWERS
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, ANSWER, of a table, which declares no primary key: the values which more than
-- one row shares.
-- 2 ANSWERs, in 5 rows: the rows of each are copies of one another, which a query returns as one instance.
SELECT ANSWER, COUNT(*)
FROM MLBLOGS_ANSWERS
GROUP BY ANSWER
HAVING COUNT(*) > 1
;


-- -------------------------------------------------------------------------------------------------------------- ANSWER
-- the shortest and the longest ANSWER, trailing spaces trimmed; 30 to 1024 characters, of VARCHAR(1024) declared.
SELECT MIN(LENGTH(RTRIM(ANSWER))), MAX(LENGTH(RTRIM(ANSWER)))
FROM MLBLOGS_ANSWERS
;

-- rows whose ANSWER is blank, or carries leading or trailing spaces.
-- no rows: every ANSWER is trimmed and not blank.
SELECT ANSWER, '[' || ANSWER || ']' AS BRACKETED
FROM MLBLOGS_ANSWERS
WHERE RTRIM(ANSWER) = ''
   OR ANSWER <> LTRIM(ANSWER)
   OR LENGTH(ANSWER) <> LENGTH(RTRIM(ANSWER))
;

-- how many rows have no ANSWER; 0 of 108.
SELECT COUNT(*) - COUNT(ANSWER), COUNT(*)
FROM MLBLOGS_ANSWERS
;


-- ----------------------------------------------------------------------------------------------------------- EMBEDDING
-- how many rows have no EMBEDDING; 0 of 108.
SELECT COUNT(*) - COUNT(EMBEDDING), COUNT(*)
FROM MLBLOGS_ANSWERS
;

