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
-- Exercises at the advanced level on EMPLOYEE: a correlated subquery, a comparison across tables, or what only Db2 can
-- do: a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and
-- shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMPLOYEE/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_A_01
-- the highest paid employee of each department.
-- WORKDEPT EMPNO  LASTNAME  SALARY
-- -------- ------ --------- ---------
-- A00      000010 HAAS      152750.00
-- B01      000020 THOMPSON   94250.00
-- C01      000030 KWAN       98250.00
-- D11      000060 STERN      72250.00
-- D21      000070 PULASKI    96170.00
-- E01      000050 GEYER      80175.00
-- E11      000090 HENDERSON  89750.00
-- E21      000100 SPENSER    86150.00
--
--   8 record(s) selected.
SELECT e.WORKDEPT, e.EMPNO, e.LASTNAME, e.SALARY
FROM EMPLOYEE e
WHERE e.SALARY = (SELECT MAX(x.SALARY) FROM EMPLOYEE x WHERE x.WORKDEPT = e.WORKDEPT)
ORDER BY e.WORKDEPT
;

-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_A_02
-- the employees older than the manager of their department.
-- EMPNO  LASTNAME   BIRTHDATE  MGRNO  MGR_BIRTHDATE
-- ------ ---------- ---------- ------ -------------
-- 000110 LUCCHESSI  11/05/1959 000010 08/24/1963
-- 000130 QUINTANA   09/15/1955 000030 05/11/1971
-- 000200 BROWN      05/29/1971 000060 07/07/1975
-- 000230 JEFFERSON  05/30/1980 000070 05/26/2003
-- 000240 MARINO     03/31/2002 000070 05/26/2003
-- 000250 SMITH      11/12/1969 000070 05/26/2003
-- 000260 JOHNSON    10/05/1976 000070 05/26/2003
-- 000310 SETRIGHT   04/21/1961 000090 05/15/1971
-- 000320 MEHTA      08/11/1962 000100 12/18/1980
-- 000330 LEE        07/18/1971 000100 12/18/1980
-- ... 16 rows in all.
SELECT e.EMPNO, e.LASTNAME, e.BIRTHDATE, m.EMPNO AS MGRNO, m.BIRTHDATE AS MGR_BIRTHDATE
FROM EMPLOYEE e
         JOIN DEPARTMENT d ON d.DEPTNO = e.WORKDEPT
         JOIN EMPLOYEE m ON m.EMPNO = d.MGRNO
WHERE e.BIRTHDATE < m.BIRTHDATE
ORDER BY e.EMPNO
;

-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_A_03
-- each employee's rank by salary within the department, D21.
-- EMPNO  LASTNAME   SALARY   SALARY_RANK SHARE
-- ------ ---------- -------- ----------- -----
-- 000070 PULASKI    96170.00           1 26.81
-- 000250 SMITH      49180.00           2 13.71
-- 000240 MARINO     48760.00           3 13.59
-- 000260 JOHNSON    47250.00           4 13.17
-- 000230 JEFFERSON  42180.00           5 11.76
-- 200240 MONTEVERDE 37760.00           6 10.53
-- 000270 PEREZ      37380.00           7 10.42
--
--   7 record(s) selected.
SELECT EMPNO, LASTNAME, SALARY,
       RANK() OVER (ORDER BY SALARY DESC) AS SALARY_RANK,
       DECIMAL(DECFLOAT(SALARY) * 100 / SUM(SALARY) OVER (), 5, 2) AS SHARE
FROM EMPLOYEE
WHERE WORKDEPT = 'D21'
ORDER BY SALARY_RANK, EMPNO
;
