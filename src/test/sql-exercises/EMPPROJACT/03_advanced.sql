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
-- Exercises at the advanced level on EMPPROJACT: a correlated subquery, a comparison across tables, or what only Db2
-- can do: a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and
-- shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMPPROJACT/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- -------------------------------------------------------------------------- SAMPLE_EMPPROJACT_A_01
-- the employees on no project.
-- EMPNO  LASTNAME   WORKDEPT
-- ------ ---------- --------
-- 000060 STERN      D11
-- 000120 O'CONNELL  A00
-- 200010 HEMMINGER  A00
-- 200120 ORLANDO    A00
-- 200140 NATZ       C01
-- 200170 YAMAMOTO   D11
-- 200220 JOHN       D11
-- 200240 MONTEVERDE D21
-- 200280 SCHWARTZ   E11
-- 200310 SPRINGER   E11
-- ... 12 rows in all.
SELECT e.EMPNO, e.LASTNAME, e.WORKDEPT
FROM EMPLOYEE e
WHERE NOT EXISTS (SELECT 1 FROM EMPPROJACT x WHERE x.EMPNO = e.EMPNO)
ORDER BY e.EMPNO
;

-- -------------------------------------------------------------------------- SAMPLE_EMPPROJACT_A_02
-- the employees on a project of a department other than their own.
-- EMPNO  LASTNAME  WORKDEPT PROJNO DEPTNO
-- ------ --------- -------- ------ ------
-- 000010 HAAS      A00      AD3100 D01
-- 000010 HAAS      A00      MA2100 D01
-- 000010 HAAS      A00      MA2110 D11
-- 000050 GEYER     E01      OP2010 E21
-- 000110 LUCCHESSI A00      MA2100 D01
--
--   5 record(s) selected.
SELECT DISTINCT e.EMPNO, e.LASTNAME, e.WORKDEPT, p.PROJNO, p.DEPTNO
FROM EMPPROJACT x
         JOIN EMPLOYEE e ON e.EMPNO = x.EMPNO
         JOIN PROJECT p ON p.PROJNO = x.PROJNO
WHERE p.DEPTNO <> e.WORKDEPT
ORDER BY e.EMPNO, p.PROJNO
;
