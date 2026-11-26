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
-- Exercises at the advanced level on PROJECT: a correlated subquery, a comparison across tables, or what only Db2 can
-- do: a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and
-- shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PROJECT/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_PROJECT_A_01
-- the projects under MA2100, level by level.
-- PROJNO PROJNAME             MAJPROJ DEPTH
-- ------ -------------------- ------- -----
-- MA2100 WELD LINE AUTOMATION -           0
-- MA2110 W L PROGRAMMING      MA2100      1
-- PL2100 WELD LINE PLANNING   MA2100      1
-- MA2111 W L PROGRAM DESIGN   MA2110      2
-- MA2112 W L ROBOT DESIGN     MA2110      2
-- MA2113 W L PROD CONT PROGS  MA2110      2
--
--   6 record(s) selected with 1 warning messages suppressed.
WITH TREE (PROJNO, PROJNAME, MAJPROJ, DEPTH) AS (
    SELECT PROJNO, PROJNAME, MAJPROJ, 0
    FROM PROJECT
    WHERE PROJNO = 'MA2100'
    UNION ALL
    SELECT p.PROJNO, p.PROJNAME, p.MAJPROJ, t.DEPTH + 1
    FROM PROJECT p, TREE t
    WHERE p.MAJPROJ = t.PROJNO
)
SELECT PROJNO, PROJNAME, MAJPROJ, DEPTH
FROM TREE
ORDER BY DEPTH, PROJNO
;

-- ----------------------------------------------------------------------------- SAMPLE_PROJECT_A_02
-- the projects in the charge of an employee of another department.
-- PROJNO PROJNAME             DEPTNO EMPNO  WORKDEPT
-- ------ -------------------- ------ ------ --------
-- AD3100 ADMIN SERVICES       D01    000010 A00
-- MA2100 WELD LINE AUTOMATION D01    000010 A00
--
--   2 record(s) selected.
SELECT p.PROJNO, p.PROJNAME, p.DEPTNO, e.EMPNO, e.WORKDEPT
FROM PROJECT p
         JOIN EMPLOYEE e ON e.EMPNO = p.RESPEMP
WHERE e.WORKDEPT <> p.DEPTNO
ORDER BY p.PROJNO
;
