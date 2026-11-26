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
-- Exercises at the basic level on MLBLOGS_QUESTIONS: a filter, a sort, a count or the first rows. Each poses a
-- question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/MLBLOGS_QUESTIONS/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ------------------------------------------------------------------- SAMPLE_MLBLOGS_QUESTIONS_B_01
-- every question.
-- QUESTION
-- ----------------------------------------------------------------
-- How can one inference a Python model with Db2?
-- How to generate summary statistics for a Db2 table?
-- How to integrate a Python model with Db2?
-- What are Db2's key capabilities for enterprise machine learning?
-- What is Python UDF?
--
--   5 record(s) selected.
SELECT QUESTION
FROM MLBLOGS_QUESTIONS
ORDER BY QUESTION
;

-- ------------------------------------------------------------------- SAMPLE_MLBLOGS_QUESTIONS_B_02
-- the questions about Python.
-- QUESTION
-- ----------------------------------------------
-- How can one inference a Python model with Db2?
-- How to integrate a Python model with Db2?
-- What is Python UDF?
--
--   3 record(s) selected.
SELECT QUESTION
FROM MLBLOGS_QUESTIONS
WHERE QUESTION LIKE '%Python%'
ORDER BY QUESTION
;
