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
-- Exercises at the advanced level on the schema as a whole, not on a single table: a correlated subquery, a comparison
-- across tables, or what only Db2 can do: a recursive query, a window, a rollup or a query into an XML document. Each
-- poses a question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/__/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- ------------------------------------------------------------------------------ SAMPLE_SCHEMA_A_01
-- the managers of the employees, up to the top.
-- STEP DEPTNO MGRNO  LASTNAME
-- ---- ------ ------ ---------
--    1 E11    000090 HENDERSON
--    2 E01    000050 GEYER
--    3 A00    000010 HAAS
--
--   3 record(s) selected.
WITH CHAIN (DEPTNO, ADMRDEPT, MGRNO, STEP) AS (
    SELECT d.DEPTNO, d.ADMRDEPT, d.MGRNO, 1
    FROM EMPLOYEE e, DEPARTMENT d
    WHERE d.DEPTNO = e.WORKDEPT
      AND e.EMPNO = '000290'
    UNION ALL
    SELECT d.DEPTNO, d.ADMRDEPT, d.MGRNO, c.STEP + 1
    FROM CHAIN c, DEPARTMENT d
    WHERE d.DEPTNO = c.ADMRDEPT
      AND c.DEPTNO <> c.ADMRDEPT
)
SELECT c.STEP, c.DEPTNO, c.MGRNO, m.LASTNAME
FROM CHAIN c
         LEFT JOIN EMPLOYEE m ON m.EMPNO = c.MGRNO
ORDER BY c.STEP
;

-- ------------------------------------------------------------------------------ SAMPLE_SCHEMA_A_02
-- the departments' share of the project time.
-- WORKDEPT EMPTIME SHARE
-- -------- ------- -----
-- D21        22.00 40.37
-- D11        13.00 23.85
-- C01         5.50 10.09
-- E11         5.00  9.17
-- E21         4.00  7.34
-- A00         3.00  5.50
-- B01         1.00  1.83
-- E01         1.00  1.83
--
--   8 record(s) selected.
SELECT e.WORKDEPT, SUM(x.EMPTIME) AS EMPTIME,
       DECIMAL(DECFLOAT(SUM(x.EMPTIME)) * 100 / (SELECT SUM(EMPTIME) FROM EMPPROJACT), 5, 2) AS SHARE
FROM EMPPROJACT x
         JOIN EMPLOYEE e ON e.EMPNO = x.EMPNO
GROUP BY e.WORKDEPT
ORDER BY EMPTIME DESC
;
