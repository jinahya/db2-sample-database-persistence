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
-- Exercises at the basic level on PROJECT: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PROJECT/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_PROJECT_B_01
-- the projects of D21.
-- PROJNO PROJNAME              RESPEMP PRSTAFF
-- ------ --------------------- ------- -------
-- AD3110 GENERAL ADMIN SYSTEMS 000070     6.00
-- AD3111 PAYROLL PROGRAMMING   000230     2.00
-- AD3112 PERSONNEL PROGRAMMING 000250     1.00
-- AD3113 ACCOUNT PROGRAMMING   000270     2.00
--
--   4 record(s) selected.
SELECT PROJNO, PROJNAME, RESPEMP, PRSTAFF
FROM PROJECT
WHERE DEPTNO = 'D21'
ORDER BY PROJNO
;

-- ----------------------------------------------------------------------------- SAMPLE_PROJECT_B_02
-- the major projects.
-- PROJNO PROJNAME             DEPTNO
-- ------ -------------------- ------
-- AD3100 ADMIN SERVICES       D01
-- IF1000 QUERY SERVICES       C01
-- IF2000 USER EDUCATION       C01
-- MA2100 WELD LINE AUTOMATION D01
-- OP1000 OPERATION SUPPORT    E01
-- OP2000 GEN SYSTEMS SERVICES E01
--
--   6 record(s) selected.
SELECT PROJNO, PROJNAME, DEPTNO
FROM PROJECT
WHERE MAJPROJ IS NULL
ORDER BY PROJNO
;

-- ----------------------------------------------------------------------------- SAMPLE_PROJECT_B_03
-- the projects that end before they start.
-- PROJNO PROJNAME            PRSTDATE   PRENDATE
-- ------ ------------------- ---------- ----------
-- MA2111 W L PROGRAM DESIGN  01/01/2002 12/01/1982
-- MA2112 W L ROBOT DESIGN    01/01/2002 12/01/1982
-- MA2113 W L PROD CONT PROGS 02/15/2002 12/01/1982
--
--   3 record(s) selected.
SELECT PROJNO, PROJNAME, PRSTDATE, PRENDATE
FROM PROJECT
WHERE PRENDATE < PRSTDATE
ORDER BY PROJNO
;
