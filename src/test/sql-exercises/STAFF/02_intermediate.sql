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
-- Exercises at the intermediate level on STAFF: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/STAFF/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ------------------------------------------------------------------------------- SAMPLE_STAFF_I_01
-- the number of staff and their average salary per job.
-- JOB   STAFF AVG_SALARY
-- ----- ----- ----------
-- Clerk    12   47945.94
-- Mgr      11   85260.34
-- Sales    12   72036.02
--
--   3 record(s) selected.
SELECT JOB, COUNT(*) AS STAFF, DECIMAL(AVG(SALARY), 9, 2) AS AVG_SALARY
FROM STAFF
GROUP BY JOB
ORDER BY JOB
;

-- ------------------------------------------------------------------------------- SAMPLE_STAFF_I_02
-- the staff of the Eastern division.
-- ID  NAME     DEPTNAME       LOCATION
-- --- -------- -------------- ----------
--  10 Sanders  Mid Atlantic   Washington
--  20 Pernal   Mid Atlantic   Washington
--  30 Marenghi South Atlantic Atlanta
--  40 O'Brien  South Atlantic Atlanta
--  50 Hanes    New England    Boston
--  60 Quigley  South Atlantic Atlanta
--  70 Rothman  New England    Boston
--  80 James    Mid Atlantic   Washington
-- 110 Ngan     New England    Boston
-- 120 Naughton South Atlantic Atlanta
-- ... 13 rows in all.
SELECT s.ID, s.NAME, o.DEPTNAME, o.LOCATION
FROM STAFF s
         JOIN ORG o ON o.DEPTNUMB = s.DEPT
WHERE o.DIVISION = 'Eastern'
ORDER BY s.ID
;
