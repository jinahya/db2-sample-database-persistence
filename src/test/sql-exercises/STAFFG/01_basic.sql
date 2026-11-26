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
-- Exercises at the basic level on STAFFG: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/STAFFG/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ------------------------------------------------------------------------------ SAMPLE_STAFFG_B_01
-- the first page of staff.
-- ID NAME     DEPT JOB
-- -- -------- ---- -----
-- 10 Sanders    20 Mgr
-- 20 Pernal     20 Sales
-- 30 Marenghi   38 Mgr
-- 40 O Brien    38 Sales
-- 50 Hanes      15 Mgr
--
--   5 record(s) selected.
SELECT ID, NAME, DEPT, JOB
FROM STAFFG
ORDER BY ID
FETCH FIRST 5 ROWS ONLY
;
