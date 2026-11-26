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
-- Exercises at the basic level on VASTRDE1: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/VASTRDE1/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_VASTRDE1_B_01
-- the departments A00 administers.
-- DEPT2NO DEPT2NAM                     EMP2NO EMP2LN
-- ------- ---------------------------- ------ --------
-- A00     SPIFFY COMPUTER SERVICE DIV. 000010 HAAS
-- B01     PLANNING                     000020 THOMPSON
-- C01     INFORMATION CENTER           000030 KWAN
-- D01     DEVELOPMENT CENTER           -      -
-- E01     SUPPORT SERVICES             000050 GEYER
--
--   5 record(s) selected.
SELECT DEPT2NO, DEPT2NAM, EMP2NO, EMP2LN
FROM VASTRDE1
WHERE DEPT1NO = 'A00'
ORDER BY DEPT2NO
;
