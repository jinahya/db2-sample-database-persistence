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
-- Exercises at the basic level on EMPMDC: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMPMDC/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ------------------------------------------------------------------------------ SAMPLE_EMPMDC_B_01
-- the number of rows.
-- ROWS  DEPTS DIVS
-- ----- ----- ----
-- 10000     5   10
--
--   1 record(s) selected.
SELECT COUNT(*) AS ROWS, COUNT(DISTINCT DEPT) AS DEPTS, COUNT(DISTINCT DIV) AS DIVS
FROM EMPMDC
;

-- ------------------------------------------------------------------------------ SAMPLE_EMPMDC_B_02
-- the first page of division 3.
-- EMPNO DEPT DIV
-- ----- ---- ---
--     2    3   3
--    12    3   3
--    22    3   3
--    32    3   3
--    42    3   3
--
--   5 record(s) selected.
SELECT EMPNO, DEPT, DIV
FROM EMPMDC
WHERE DIV = 3
ORDER BY EMPNO
FETCH FIRST 5 ROWS ONLY
;
