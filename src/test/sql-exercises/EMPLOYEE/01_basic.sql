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
-- Exercises at the basic level on EMPLOYEE: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMPLOYEE/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_B_01
-- the employees of D11, by name.
-- EMPNO  FIRSTNME  LASTNAME  JOB
-- ------ --------- --------- --------
-- 000150 BRUCE     ADAMSON   DESIGNER
-- 000200 DAVID     BROWN     DESIGNER
-- 200220 REBA      JOHN      DESIGNER
-- 000210 WILLIAM   JONES     DESIGNER
-- 000220 JENNIFER  LUTZ      DESIGNER
-- 000160 ELIZABETH PIANKA    DESIGNER
-- 000180 MARILYN   SCOUTTEN  DESIGNER
-- 000060 IRVING    STERN     MANAGER
-- 000190 JAMES     WALKER    DESIGNER
-- 200170 KIYOSHI   YAMAMOTO  DESIGNER
-- ... 11 rows in all.
SELECT EMPNO, FIRSTNME, LASTNAME, JOB
FROM EMPLOYEE
WHERE WORKDEPT = 'D11'
ORDER BY LASTNAME, FIRSTNME
;

-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_B_02
-- the employees hired in 2006.
-- EMPNO  FIRSTNME  LASTNAME HIREDATE
-- ------ --------- -------- ----------
-- 000330 WING      LEE      02/23/2006
-- 200330 HELENA    WONG     02/23/2006
-- 000290 JOHN      PARKER   05/30/2006
-- 000270 MARIA     PEREZ    09/30/2006
-- 000160 ELIZABETH PIANKA   10/11/2006
-- 000140 HEATHER   NICHOLLS 12/15/2006
-- 200140 KIM       NATZ     12/15/2006
--
--   7 record(s) selected.
SELECT EMPNO, FIRSTNME, LASTNAME, HIREDATE
FROM EMPLOYEE
WHERE HIREDATE >= DATE '2006-01-01'
  AND HIREDATE < DATE '2007-01-01'
ORDER BY HIREDATE, EMPNO
;

-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_B_03
-- the five highest salaries.
-- EMPNO  FIRSTNME  LASTNAME  SALARY
-- ------ --------- --------- ---------
-- 000010 CHRISTINE HAAS      152750.00
-- 000030 SALLY     KWAN       98250.00
-- 000070 EVA       PULASKI    96170.00
-- 000020 MICHAEL   THOMPSON   94250.00
-- 000090 EILEEN    HENDERSON  89750.00
--
--   5 record(s) selected.
SELECT EMPNO, FIRSTNME, LASTNAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC, EMPNO
FETCH FIRST 5 ROWS ONLY
;

-- ---------------------------------------------------------------------------- SAMPLE_EMPLOYEE_B_04
-- the employees without a middle initial.
-- EMPNO  FIRSTNME LASTNAME
-- ------ -------- ---------
-- 000120 SEAN     O'CONNELL
-- 000150 BRUCE    ADAMSON
-- 000200 DAVID    BROWN
-- 000330 WING     LEE
-- 200120 GREG     ORLANDO
-- 200170 KIYOSHI  YAMAMOTO
-- 200330 HELENA   WONG
--
--   7 record(s) selected.
SELECT EMPNO, FIRSTNME, LASTNAME
FROM EMPLOYEE
WHERE MIDINIT = ''
ORDER BY EMPNO
;
