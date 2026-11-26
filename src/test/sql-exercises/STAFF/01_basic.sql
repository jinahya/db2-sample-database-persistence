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
-- Exercises at the basic level on STAFF: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/STAFF/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ------------------------------------------------------------------------------- SAMPLE_STAFF_B_01
-- the staff of department 20.
-- ID  NAME    JOB   YEARS SALARY
-- --- ------- ----- ----- --------
--  10 Sanders Mgr       7 98357.50
--  20 Pernal  Sales     8 78171.25
--  80 James   Clerk     - 43504.60
-- 190 Sneider Clerk     8 34252.75
--
--   4 record(s) selected.
SELECT ID, NAME, JOB, YEARS, SALARY
FROM STAFF
WHERE DEPT = 20
ORDER BY ID
;

-- ------------------------------------------------------------------------------- SAMPLE_STAFF_B_02
-- the staff without a commission.
-- ID  NAME     DEPT JOB
-- --- -------- ---- ---
--  10 Sanders    20 Mgr
--  30 Marenghi   38 Mgr
--  50 Hanes      15 Mgr
-- 100 Plotz      42 Mgr
-- 140 Fraye      51 Mgr
-- 160 Molinare   10 Mgr
-- 210 Lu         10 Mgr
-- 240 Daniels    10 Mgr
-- 260 Jones      10 Mgr
-- 270 Lea        66 Mgr
-- ... 11 rows in all.
SELECT ID, NAME, DEPT, JOB
FROM STAFF
WHERE COMM IS NULL
ORDER BY ID
;
