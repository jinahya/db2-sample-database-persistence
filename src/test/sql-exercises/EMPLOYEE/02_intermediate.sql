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
-- Exercises at the intermediate level on EMPLOYEE: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMPLOYEE/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_I_01
-- the number of employees and their average salary per job.
-- JOB      EMPLOYEES AVG_SALARY
-- -------- --------- ----------
-- PRES             1  152750.00
-- MANAGER          7   88142.14
-- ANALYST          3   70213.33
-- DESIGNER        10   57437.00
-- SALESREP         2   56500.00
-- CLERK            8   43876.25
-- FIELDREP         5   39274.00
-- OPERATOR         6   37898.33
--
--   8 record(s) selected.
SELECT JOB, COUNT(*) AS EMPLOYEES, DECIMAL(AVG(SALARY), 9, 2) AS AVG_SALARY
FROM EMPLOYEE
GROUP BY JOB
ORDER BY AVG_SALARY DESC
;

-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_I_02
-- the employees of the E21 with the name of their department.
-- EMPNO  FIRSTNME LASTNAME DEPTNAME
-- ------ -------- -------- ----------------
-- 000100 THEODORE SPENSER  SOFTWARE SUPPORT
-- 000320 RAMLAL   MEHTA    SOFTWARE SUPPORT
-- 000330 WING     LEE      SOFTWARE SUPPORT
-- 000340 JASON    GOUNOT   SOFTWARE SUPPORT
-- 200330 HELENA   WONG     SOFTWARE SUPPORT
-- 200340 ROY      ALONZO   SOFTWARE SUPPORT
--
--   6 record(s) selected.
SELECT e.EMPNO, e.FIRSTNME, e.LASTNAME, d.DEPTNAME
FROM EMPLOYEE e
         JOIN DEPARTMENT d ON d.DEPTNO = e.WORKDEPT
WHERE e.WORKDEPT = 'E21'
ORDER BY e.EMPNO
;

-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_I_03
-- the employees who manage a department.
-- EMPNO  FIRSTNME  LASTNAME  JOB
-- ------ --------- --------- -------
-- 000010 CHRISTINE HAAS      PRES
-- 000020 MICHAEL   THOMPSON  MANAGER
-- 000030 SALLY     KWAN      MANAGER
-- 000050 JOHN      GEYER     MANAGER
-- 000060 IRVING    STERN     MANAGER
-- 000070 EVA       PULASKI   MANAGER
-- 000090 EILEEN    HENDERSON MANAGER
-- 000100 THEODORE  SPENSER   MANAGER
--
--   8 record(s) selected.
SELECT e.EMPNO, e.FIRSTNME, e.LASTNAME, e.JOB
FROM EMPLOYEE e
WHERE EXISTS (SELECT 1 FROM DEPARTMENT d WHERE d.MGRNO = e.EMPNO)
ORDER BY e.EMPNO
;

-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_I_04
-- the five highest total earnings.
-- EMPNO  LASTNAME  TOTAL
-- ------ --------- ---------
-- 000010 HAAS      157970.00
-- 000030 KWAN      102110.00
-- 000070 PULASKI    99763.00
-- 000020 THOMPSON   98350.00
-- 000090 HENDERSON  92730.00
--
--   5 record(s) selected.
SELECT EMPNO, LASTNAME, SALARY + BONUS + COMM AS TOTAL
FROM EMPLOYEE
ORDER BY TOTAL DESC, EMPNO
FETCH FIRST 5 ROWS ONLY
;
