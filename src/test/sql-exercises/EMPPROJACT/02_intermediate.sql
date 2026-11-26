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
-- Exercises at the intermediate level on EMPPROJACT: a join, a group, an outer join or a subquery. Each poses a
-- question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMPPROJACT/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- -------------------------------------------------------------------------- SAMPLE_EMPPROJACT_I_01
-- the total time of each employee.
-- EMPNO  LASTNAME  EMPTIME
-- ------ --------- -------
-- 000250 SMITH        5.50
-- 000260 JOHNSON      5.50
-- 000270 PEREZ        5.00
-- 000140 NICHOLLS     3.00
-- 000170 YOSHIMURA    3.00
-- 000230 JEFFERSON    3.00
-- 000010 HAAS         2.00
-- 000150 ADAMSON      2.00
-- 000190 WALKER       2.00
-- 000200 BROWN        2.00
-- ... 30 rows in all.
SELECT e.EMPNO, e.LASTNAME, SUM(x.EMPTIME) AS EMPTIME
FROM EMPPROJACT x
         JOIN EMPLOYEE e ON e.EMPNO = x.EMPNO
GROUP BY e.EMPNO, e.LASTNAME
ORDER BY EMPTIME DESC, e.EMPNO
;

-- -------------------------------------------------------------------------- SAMPLE_EMPPROJACT_I_02
-- the employees on more than one project.
-- EMPNO  PROJECTS
-- ------ --------
-- 000010        3
-- 000030        2
-- 000050        2
-- 000140        2
-- 000170        2
--
--   5 record(s) selected.
SELECT EMPNO, COUNT(DISTINCT PROJNO) AS PROJECTS
FROM EMPPROJACT
GROUP BY EMPNO
HAVING COUNT(DISTINCT PROJNO) > 1
ORDER BY EMPNO
;
