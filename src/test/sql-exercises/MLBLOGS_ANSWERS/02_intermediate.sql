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
-- Exercises at the intermediate level on MLBLOGS_ANSWERS: a join, a group, an outer join or a subquery. Each poses a
-- question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/MLBLOGS_ANSWERS/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- --------------------------------------------------------------------- SAMPLE_MLBLOGS_ANSWERS_I_01
-- the answers stored more than once.
-- ANSWER                                   ROWS
-- ---------------------------------------- ----
-- Events  Conference Community Events User    3
-- Groups  AI Automation Data Security Sust    2
--
--   2 record(s) selected.
SELECT SUBSTR(ANSWER, 1, 40) AS ANSWER, COUNT(*) AS ROWS
FROM MLBLOGS_ANSWERS
GROUP BY ANSWER
HAVING COUNT(*) > 1
ORDER BY 1
;
