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
-- Exercises at the advanced level on STAFF: a correlated subquery, a comparison across tables, or what only Db2 can do:
-- a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and shows
-- what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/STAFF/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- ------------------------------------------------------------------------------- SAMPLE_STAFF_A_01
-- the staff paid more than the average of their department.
-- ID  NAME      DEPT SALARY
-- --- --------- ---- --------
-- 210 Lu          10 90010.00
--  50 Hanes       15 80659.80
--  70 Rothman     15 76502.83
--  10 Sanders     20 98357.50
--  20 Pernal      20 78171.25
--  30 Marenghi    38 77506.75
--  40 O'Brien     38 78006.00
--  60 Quigley     38 66808.30
-- 100 Plotz       42 78352.80
-- 140 Fraye       51 91150.00
-- ... 17 rows in all.
SELECT s.ID, s.NAME, s.DEPT, s.SALARY
FROM STAFF s
WHERE s.SALARY > (SELECT AVG(x.SALARY) FROM STAFF x WHERE x.DEPT = s.DEPT)
ORDER BY s.DEPT, s.ID
;
