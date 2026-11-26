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
-- Profiling queries on MLBLOGS_QUESTIONS, a table, a section per column. Each says what it looks for and what the
-- installed data returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/MLBLOGS_QUESTIONS.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/MLBLOGS_QUESTIONS.sql'
--

-- how many rows; 5.
SELECT COUNT(*)
FROM MLBLOGS_QUESTIONS
;


-- ---------------------------------------------------------------------------------------------------------- IDENTIFIER
-- the identifier which the mapping takes, QUESTION, of a table, which declares no primary key: the values which more
-- than one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT QUESTION, COUNT(*)
FROM MLBLOGS_QUESTIONS
GROUP BY QUESTION
HAVING COUNT(*) > 1
;


-- ------------------------------------------------------------------------------------------------------------ QUESTION
-- the shortest and the longest QUESTION, trailing spaces trimmed; 19 to 64 characters, of VARCHAR(1024) declared.
SELECT MIN(LENGTH(RTRIM(QUESTION))), MAX(LENGTH(RTRIM(QUESTION)))
FROM MLBLOGS_QUESTIONS
;

-- rows whose QUESTION is blank, or carries leading or trailing spaces.
-- no rows: every QUESTION is trimmed and not blank.
SELECT QUESTION, '[' || QUESTION || ']' AS BRACKETED
FROM MLBLOGS_QUESTIONS
WHERE RTRIM(QUESTION) = ''
   OR QUESTION <> LTRIM(QUESTION)
   OR LENGTH(QUESTION) <> LENGTH(RTRIM(QUESTION))
;

-- how many rows have no QUESTION; 0 of 5.
SELECT COUNT(*) - COUNT(QUESTION), COUNT(*)
FROM MLBLOGS_QUESTIONS
;


-- ----------------------------------------------------------------------------------------------------------- EMBEDDING
-- how many rows have no EMBEDDING; 0 of 5.
SELECT COUNT(*) - COUNT(EMBEDDING), COUNT(*)
FROM MLBLOGS_QUESTIONS
;

