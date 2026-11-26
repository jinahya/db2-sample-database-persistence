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
-- Exercises at the intermediate level on PROJECT: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PROJECT/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_PROJECT_I_01
-- each project with the name of the employee in charge.
-- PROJNO PROJNAME              FIRSTNME  LASTNAME
-- ------ --------------------- --------- ---------
-- AD3100 ADMIN SERVICES        CHRISTINE HAAS
-- AD3110 GENERAL ADMIN SYSTEMS EVA       PULASKI
-- AD3111 PAYROLL PROGRAMMING   JAMES     JEFFERSON
-- AD3112 PERSONNEL PROGRAMMING DANIEL    SMITH
-- AD3113 ACCOUNT PROGRAMMING   MARIA     PEREZ
-- IF1000 QUERY SERVICES        SALLY     KWAN
-- IF2000 USER EDUCATION        SALLY     KWAN
-- MA2100 WELD LINE AUTOMATION  CHRISTINE HAAS
-- MA2110 W L PROGRAMMING       IRVING    STERN
-- MA2111 W L PROGRAM DESIGN    JENNIFER  LUTZ
-- ... 20 rows in all.
SELECT p.PROJNO, p.PROJNAME, e.FIRSTNME, e.LASTNAME
FROM PROJECT p
         JOIN EMPLOYEE e ON e.EMPNO = p.RESPEMP
ORDER BY p.PROJNO
;

-- ----------------------------------------------------------------------------- SAMPLE_PROJECT_I_02
-- the number of subprojects of each project.
-- PROJNO PROJNAME              SUBPROJECTS
-- ------ --------------------- -----------
-- AD3100 ADMIN SERVICES                  1
-- AD3110 GENERAL ADMIN SYSTEMS           3
-- MA2100 WELD LINE AUTOMATION            2
-- MA2110 W L PROGRAMMING                 3
-- OP1000 OPERATION SUPPORT               1
-- OP2000 GEN SYSTEMS SERVICES            1
-- OP2010 SYSTEMS SUPPORT                 3
--
--   7 record(s) selected.
SELECT m.PROJNO, m.PROJNAME, COUNT(*) AS SUBPROJECTS
FROM PROJECT m
         JOIN PROJECT p ON p.MAJPROJ = m.PROJNO
GROUP BY m.PROJNO, m.PROJNAME
ORDER BY m.PROJNO
;
