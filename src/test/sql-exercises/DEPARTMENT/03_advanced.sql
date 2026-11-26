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
-- Exercises at the advanced level on DEPARTMENT: a correlated subquery, a comparison across tables, or what only Db2
-- can do: a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and
-- shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/DEPARTMENT/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- -------------------------------------------------------------------------- SAMPLE_DEPARTMENT_A_01
-- the departments under A00, level by level.
-- DEPTNO DEPTNAME                     ADMRDEPT DEPTH
-- ------ ---------------------------- -------- -----
-- A00    SPIFFY COMPUTER SERVICE DIV. A00          0
-- B01    PLANNING                     A00          1
-- C01    INFORMATION CENTER           A00          1
-- D01    DEVELOPMENT CENTER           A00          1
-- E01    SUPPORT SERVICES             A00          1
-- D11    MANUFACTURING SYSTEMS        D01          2
-- D21    ADMINISTRATION SYSTEMS       D01          2
-- E11    OPERATIONS                   E01          2
-- E21    SOFTWARE SUPPORT             E01          2
-- F22    BRANCH OFFICE F2             E01          2
-- ... 14 rows in all.
WITH TREE (DEPTNO, DEPTNAME, ADMRDEPT, DEPTH) AS (
    SELECT DEPTNO, DEPTNAME, ADMRDEPT, 0
    FROM DEPARTMENT
    WHERE DEPTNO = 'A00'
    UNION ALL
    SELECT d.DEPTNO, d.DEPTNAME, d.ADMRDEPT, t.DEPTH + 1
    FROM DEPARTMENT d, TREE t
    WHERE d.ADMRDEPT = t.DEPTNO
      AND d.DEPTNO <> d.ADMRDEPT
)
SELECT DEPTNO, DEPTNAME, ADMRDEPT, DEPTH
FROM TREE
ORDER BY DEPTH, DEPTNO
;

-- -------------------------------------------------------------------------- SAMPLE_DEPARTMENT_A_02
-- the departments whose average salary is above the company's.
-- DEPTNO DEPTNAME                     AVG_SALARY
-- ------ ---------------------------- ----------
-- B01    PLANNING                       94250.00
-- E01    SUPPORT SERVICES               80175.00
-- C01    INFORMATION CENTER             77222.50
-- A00    SPIFFY COMPUTER SERVICE DIV.   70850.00
-- D11    MANUFACTURING SYSTEMS          58783.63
--
--   5 record(s) selected.
SELECT d.DEPTNO, d.DEPTNAME, DECIMAL(AVG(e.SALARY), 9, 2) AS AVG_SALARY
FROM DEPARTMENT d
         JOIN EMPLOYEE e ON e.WORKDEPT = d.DEPTNO
GROUP BY d.DEPTNO, d.DEPTNAME
HAVING AVG(e.SALARY) > (SELECT AVG(SALARY) FROM EMPLOYEE)
ORDER BY AVG_SALARY DESC
;
