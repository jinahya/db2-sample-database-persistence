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
-- Exercises at the basic level on VPSTRDE1: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/VPSTRDE1/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_VPSTRDE1_B_01
-- the subprojects of AD3110.
-- PROJ2NO PROJ2NAME             RESP2NO RESP2LN
-- ------- --------------------- ------- ---------
-- AD3111  PAYROLL PROGRAMMING   000230  JEFFERSON
-- AD3112  PERSONNEL PROGRAMMING 000250  SMITH
-- AD3113  ACCOUNT PROGRAMMING   000270  PEREZ
--
--   3 record(s) selected.
SELECT PROJ2NO, PROJ2NAME, RESP2NO, RESP2LN
FROM VPSTRDE1
WHERE PROJ1NO = 'AD3110'
ORDER BY PROJ2NO
;
