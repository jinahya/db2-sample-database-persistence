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
-- Exercises at the basic level on VSTAFAC2: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/VSTAFAC2/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_VSTAFAC2_B_01
-- the staff of IF1000.
-- ACTNO ACTDESC          EMPNO  LASTNAME EMPTIME STDATE
-- ----- ---------------- ------ -------- ------- ----------
--    10 MANAGE/ADVISE    000030 KWAN        0.50 06/01/2002
--    90 ADM QUERY SYSTEM 000130 QUINTANA    1.00 10/01/2002
--    90 ADM QUERY SYSTEM 000140 NICHOLLS    0.50 10/01/2002
--   100 TEACH CLASSES    000130 QUINTANA    0.50 10/01/2002
--
--   4 record(s) selected.
SELECT ACTNO, ACTDESC, EMPNO, LASTNAME, EMPTIME, STDATE
FROM VSTAFAC2
WHERE PROJNO = 'IF1000'
ORDER BY ACTNO, EMPNO, STDATE
;
