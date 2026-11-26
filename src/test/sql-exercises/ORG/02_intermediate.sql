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
-- Exercises at the intermediate level on ORG: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/ORG/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- --------------------------------------------------------------------------------- SAMPLE_ORG_I_01
-- the number of departments per division.
-- DIVISION  DEPTS
-- --------- -----
-- Corporate     1
-- Eastern       3
-- Midwest       2
-- Western       2
--
--   4 record(s) selected.
SELECT DIVISION, COUNT(*) AS DEPTS
FROM ORG
GROUP BY DIVISION
ORDER BY DIVISION
;

-- --------------------------------------------------------------------------------- SAMPLE_ORG_I_02
-- each department with the name of its manager.
-- DEPTNUMB DEPTNAME       MANAGER NAME
-- -------- -------------- ------- --------
--       10 Head Office        160 Molinare
--       15 New England         50 Hanes
--       20 Mid Atlantic        10 Sanders
--       38 South Atlantic      30 Marenghi
--       42 Great Lakes        100 Plotz
--       51 Plains             140 Fraye
--       66 Pacific            270 Lea
--       84 Mountain           290 Quill
--
--   8 record(s) selected.
SELECT o.DEPTNUMB, o.DEPTNAME, o.MANAGER, s.NAME
FROM ORG o
         JOIN STAFF s ON s.ID = o.MANAGER
ORDER BY o.DEPTNUMB
;
