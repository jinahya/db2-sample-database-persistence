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
-- Exercises at the basic level on VPROJRE1: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/VPROJRE1/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_VPROJRE1_B_01
-- the projects of D11, with the employee in charge.
-- PROJNO PROJNAME            RESPEMP LASTNAME
-- ------ ------------------- ------- --------
-- MA2110 W L PROGRAMMING     000060  STERN
-- MA2111 W L PROGRAM DESIGN  000220  LUTZ
-- MA2112 W L ROBOT DESIGN    000150  ADAMSON
-- MA2113 W L PROD CONT PROGS 000160  PIANKA
--
--   4 record(s) selected.
SELECT PROJNO, PROJNAME, RESPEMP, LASTNAME
FROM VPROJRE1
WHERE PROJDEP = 'D11'
ORDER BY PROJNO
;
