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
-- Exercises at the intermediate level on DEPARTMENT: a join, a group, an outer join or a subquery. Each poses a
-- question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/DEPARTMENT/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- -------------------------------------------------------------------------- SAMPLE_DEPARTMENT_I_01
-- each department with the name of its manager.
-- DEPTNO DEPTNAME                     FIRSTNME  LASTNAME
-- ------ ---------------------------- --------- ---------
-- A00    SPIFFY COMPUTER SERVICE DIV. CHRISTINE HAAS
-- B01    PLANNING                     MICHAEL   THOMPSON
-- C01    INFORMATION CENTER           SALLY     KWAN
-- D01    DEVELOPMENT CENTER           -         -
-- D11    MANUFACTURING SYSTEMS        IRVING    STERN
-- D21    ADMINISTRATION SYSTEMS       EVA       PULASKI
-- E01    SUPPORT SERVICES             JOHN      GEYER
-- E11    OPERATIONS                   EILEEN    HENDERSON
-- E21    SOFTWARE SUPPORT             THEODORE  SPENSER
-- F22    BRANCH OFFICE F2             -         -
-- ... 14 rows in all.
SELECT d.DEPTNO, d.DEPTNAME, e.FIRSTNME, e.LASTNAME
FROM DEPARTMENT d
         LEFT JOIN EMPLOYEE e ON e.EMPNO = d.MGRNO
ORDER BY d.DEPTNO
;

-- -------------------------------------------------------------------------- SAMPLE_DEPARTMENT_I_02
-- each department with the name of the department that administers it.
-- DEPTNO DEPTNAME                     ADMRDEPT ADMRDEPTNAME
-- ------ ---------------------------- -------- ----------------------------
-- A00    SPIFFY COMPUTER SERVICE DIV. A00      SPIFFY COMPUTER SERVICE DIV.
-- B01    PLANNING                     A00      SPIFFY COMPUTER SERVICE DIV.
-- C01    INFORMATION CENTER           A00      SPIFFY COMPUTER SERVICE DIV.
-- D01    DEVELOPMENT CENTER           A00      SPIFFY COMPUTER SERVICE DIV.
-- D11    MANUFACTURING SYSTEMS        D01      DEVELOPMENT CENTER
-- D21    ADMINISTRATION SYSTEMS       D01      DEVELOPMENT CENTER
-- E01    SUPPORT SERVICES             A00      SPIFFY COMPUTER SERVICE DIV.
-- E11    OPERATIONS                   E01      SUPPORT SERVICES
-- E21    SOFTWARE SUPPORT             E01      SUPPORT SERVICES
-- F22    BRANCH OFFICE F2             E01      SUPPORT SERVICES
-- ... 14 rows in all.
SELECT d.DEPTNO, d.DEPTNAME, d.ADMRDEPT, a.DEPTNAME AS ADMRDEPTNAME
FROM DEPARTMENT d
         JOIN DEPARTMENT a ON a.DEPTNO = d.ADMRDEPT
ORDER BY d.DEPTNO
;

-- -------------------------------------------------------------------------- SAMPLE_DEPARTMENT_I_03
-- the number of employees in each department.
-- DEPTNO DEPTNAME                     EMPLOYEES
-- ------ ---------------------------- ---------
-- D11    MANUFACTURING SYSTEMS               11
-- D21    ADMINISTRATION SYSTEMS               7
-- E11    OPERATIONS                           7
-- E21    SOFTWARE SUPPORT                     6
-- A00    SPIFFY COMPUTER SERVICE DIV.         5
-- C01    INFORMATION CENTER                   4
-- B01    PLANNING                             1
-- E01    SUPPORT SERVICES                     1
-- D01    DEVELOPMENT CENTER                   0
-- F22    BRANCH OFFICE F2                     0
-- ... 14 rows in all.
SELECT d.DEPTNO, d.DEPTNAME, COUNT(e.EMPNO) AS EMPLOYEES
FROM DEPARTMENT d
         LEFT JOIN EMPLOYEE e ON e.WORKDEPT = d.DEPTNO
GROUP BY d.DEPTNO, d.DEPTNAME
ORDER BY EMPLOYEES DESC, d.DEPTNO
;
