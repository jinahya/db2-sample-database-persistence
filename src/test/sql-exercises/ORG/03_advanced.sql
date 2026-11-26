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
-- Exercises at the advanced level on ORG: a correlated subquery, a comparison across tables, or what only Db2 can do: a
-- recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and shows
-- what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/ORG/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- --------------------------------------------------------------------------------- SAMPLE_ORG_A_01
-- the departments with more staff than the average.
-- DEPTNUMB DEPTNAME       STAFF
-- -------- -------------- -----
--       38 South Atlantic     5
--       51 Plains             5
--       66 Pacific            5
--
--   3 record(s) selected.
SELECT o.DEPTNUMB, o.DEPTNAME, COUNT(*) AS STAFF
FROM ORG o
         JOIN STAFF s ON s.DEPT = o.DEPTNUMB
GROUP BY o.DEPTNUMB, o.DEPTNAME
HAVING COUNT(*) > (SELECT COUNT(*) FROM STAFF) / (SELECT COUNT(*) FROM ORG)
ORDER BY o.DEPTNUMB
;
