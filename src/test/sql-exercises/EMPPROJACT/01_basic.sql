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
-- Exercises at the basic level on EMPPROJACT: a filter, a sort, a count or the first rows. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMPPROJACT/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- -------------------------------------------------------------------------- SAMPLE_EMPPROJACT_B_01
-- the assignments of 000130.
-- PROJNO ACTNO EMPTIME EMSTDATE   EMENDATE
-- ------ ----- ------- ---------- ----------
-- IF1000    90    1.00 10/01/2002 01/01/2003
-- IF1000   100    0.50 10/01/2002 01/01/2003
--
--   2 record(s) selected.
SELECT PROJNO, ACTNO, EMPTIME, EMSTDATE, EMENDATE
FROM EMPPROJACT
WHERE EMPNO = '000130'
ORDER BY PROJNO, ACTNO, EMSTDATE
;

-- -------------------------------------------------------------------------- SAMPLE_EMPPROJACT_B_02
-- the part-time assignments of AD3113.
-- EMPNO  ACTNO EMPTIME EMSTDATE   EMENDATE
-- ------ ----- ------- ---------- ----------
-- 000260    70    0.50 06/15/2002 07/01/2002
-- 000260    80    0.50 03/01/2002 04/15/2002
-- 000260   180    0.50 03/01/2002 04/15/2002
-- 000270    60    0.50 03/01/2002 04/01/2002
-- 000270    60    0.25 09/01/2002 10/15/2002
-- 000270    70    0.75 09/01/2002 10/15/2002
-- 000270    80    0.50 03/01/2002 04/01/2002
--
--   7 record(s) selected.
SELECT EMPNO, ACTNO, EMPTIME, EMSTDATE, EMENDATE
FROM EMPPROJACT
WHERE PROJNO = 'AD3113'
  AND EMPTIME < 1
ORDER BY EMPNO, ACTNO, EMSTDATE
;
