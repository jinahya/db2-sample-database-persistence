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
-- Exercises at the basic level on ACT: a filter, a sort, a count or the first rows. Each poses a question, answers it,
-- and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/ACT/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- --------------------------------------------------------------------------------- SAMPLE_ACT_B_01
-- every activity, by number.
-- ACTNO ACTKWD ACTDESC
-- ----- ------ -------------------
--    10 MANAGE MANAGE/ADVISE
--    20 ECOST  ESTIMATE COST
--    30 DEFINE DEFINE SPECS
--    40 LEADPR LEAD PROGRAM/DESIGN
--    50 SPECS  WRITE SPECS
--    60 LOGIC  DESCRIBE LOGIC
--    70 CODE   CODE PROGRAMS
--    80 TEST   TEST PROGRAMS
--    90 ADMQS  ADM QUERY SYSTEM
--   100 TEACH  TEACH CLASSES
-- ... 18 rows in all.
SELECT ACTNO, ACTKWD, ACTDESC
FROM ACT
ORDER BY ACTNO
;

-- --------------------------------------------------------------------------------- SAMPLE_ACT_B_02
-- the administrative activities.
-- ACTNO ACTKWD ACTDESC
-- ----- ------ -----------------
--    90 ADMQS  ADM QUERY SYSTEM
--   150 ADMSYS ADM OPERATING SYS
--   160 ADMDB  ADM DATA BASES
--   170 ADMDC  ADM DATA COMM
--
--   4 record(s) selected.
SELECT ACTNO, ACTKWD, ACTDESC
FROM ACT
WHERE ACTKWD LIKE 'ADM%'
ORDER BY ACTNO
;
