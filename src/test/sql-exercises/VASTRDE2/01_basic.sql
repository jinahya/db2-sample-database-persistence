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
-- Exercises at the basic level on VASTRDE2: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/VASTRDE2/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_VASTRDE2_B_01
-- the employees of C01 with their manager.
-- EMP1NO EMP1LN EMP2NO EMP2LN
-- ------ ------ ------ --------
-- 000030 KWAN   000030 KWAN
-- 000030 KWAN   000130 QUINTANA
-- 000030 KWAN   000140 NICHOLLS
-- 000030 KWAN   200140 NATZ
--
--   4 record(s) selected.
SELECT EMP1NO, EMP1LN, EMP2NO, EMP2LN
FROM VASTRDE2
WHERE DEPT1NO = 'C01'
ORDER BY EMP2NO
;
