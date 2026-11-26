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
-- Exercises at the basic level on DEPARTMENT: a filter, a sort, a count or the first rows. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/DEPARTMENT/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- -------------------------------------------------------------------------- SAMPLE_DEPARTMENT_B_01
-- every department, by number.
-- DEPTNO DEPTNAME                     MGRNO  ADMRDEPT
-- ------ ---------------------------- ------ --------
-- A00    SPIFFY COMPUTER SERVICE DIV. 000010 A00
-- B01    PLANNING                     000020 A00
-- C01    INFORMATION CENTER           000030 A00
-- D01    DEVELOPMENT CENTER           -      A00
-- D11    MANUFACTURING SYSTEMS        000060 D01
-- D21    ADMINISTRATION SYSTEMS       000070 D01
-- E01    SUPPORT SERVICES             000050 A00
-- E11    OPERATIONS                   000090 E01
-- E21    SOFTWARE SUPPORT             000100 E01
-- F22    BRANCH OFFICE F2             -      E01
-- ... 14 rows in all.
SELECT DEPTNO, DEPTNAME, MGRNO, ADMRDEPT
FROM DEPARTMENT
ORDER BY DEPTNO
;

-- -------------------------------------------------------------------------- SAMPLE_DEPARTMENT_B_02
-- the departments without a manager.
-- DEPTNO DEPTNAME           ADMRDEPT
-- ------ ------------------ --------
-- D01    DEVELOPMENT CENTER A00
-- F22    BRANCH OFFICE F2   E01
-- G22    BRANCH OFFICE G2   E01
-- H22    BRANCH OFFICE H2   E01
-- I22    BRANCH OFFICE I2   E01
-- J22    BRANCH OFFICE J2   E01
--
--   6 record(s) selected.
SELECT DEPTNO, DEPTNAME, ADMRDEPT
FROM DEPARTMENT
WHERE MGRNO IS NULL
ORDER BY DEPTNO
;

-- -------------------------------------------------------------------------- SAMPLE_DEPARTMENT_B_03
-- the departments E01 administers.
-- DEPTNO DEPTNAME
-- ------ ----------------
-- E11    OPERATIONS
-- E21    SOFTWARE SUPPORT
-- F22    BRANCH OFFICE F2
-- G22    BRANCH OFFICE G2
-- H22    BRANCH OFFICE H2
-- I22    BRANCH OFFICE I2
-- J22    BRANCH OFFICE J2
--
--   7 record(s) selected.
SELECT DEPTNO, DEPTNAME
FROM DEPARTMENT
WHERE ADMRDEPT = 'E01'
ORDER BY DEPTNO
;
