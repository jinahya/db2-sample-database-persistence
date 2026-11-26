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
-- Exercises at the intermediate level on STAFFG: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/STAFFG/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ------------------------------------------------------------------------------ SAMPLE_STAFFG_I_01
-- the names that differ from STAFF.
-- ID NAME    STAFF_NAME
-- -- ------- ----------
-- 40 O Brien O'Brien
--
--   1 record(s) selected.
SELECT g.ID, g.NAME, s.NAME AS STAFF_NAME
FROM STAFFG g
         JOIN STAFF s ON s.ID = g.ID
WHERE g.NAME <> s.NAME
ORDER BY g.ID
;

-- ------------------------------------------------------------------------------ SAMPLE_STAFFG_I_02
-- the salaries beside those of STAFF.
-- ID SALARY STAFF_SALARY DIFFERENCE
-- -- ------ ------------ ----------
-- 10 18357.     98357.50  -80000.50
-- 20 18171.     78171.25  -60000.25
-- 30 17506.     77506.75  -60000.75
-- 40 18006.     78006.00  -60000.00
-- 50 20659.     80659.80  -60000.80
--
--   5 record(s) selected.
SELECT g.ID, g.SALARY, s.SALARY AS STAFF_SALARY, g.SALARY - s.SALARY AS DIFFERENCE
FROM STAFFG g
         JOIN STAFF s ON s.ID = g.ID
ORDER BY g.ID
FETCH FIRST 5 ROWS ONLY
;
