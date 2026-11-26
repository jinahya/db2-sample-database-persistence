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
-- Exercises at the basic level on SALES: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/SALES/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ------------------------------------------------------------------------------- SAMPLE_SALES_B_01
-- the sales of LUCCHESSI.
-- SALES_DATE REGION        SALES
-- ---------- ------------- -----
-- 12/31/2005 Ontario-South     1
-- 03/29/2006 Ontario-South     3
-- 03/29/2006 Quebec            1
-- 03/30/2006 Manitoba          1
-- 03/30/2006 Ontario-South     1
-- 03/30/2006 Quebec            2
-- 03/31/2006 Manitoba          1
-- 04/01/2006 Manitoba          1
-- 04/01/2006 Ontario-South     3
--
--   9 record(s) selected.
SELECT SALES_DATE, REGION, SALES
FROM SALES
WHERE SALES_PERSON = 'LUCCHESSI'
ORDER BY SALES_DATE, REGION
;

-- ------------------------------------------------------------------------------- SAMPLE_SALES_B_02
-- the rows without a count.
-- SALES_DATE SALES_PERSON REGION
-- ---------- ------------ -------------
-- 04/01/2006 LEE          Ontario-North
--
--   1 record(s) selected.
SELECT SALES_DATE, SALES_PERSON, REGION
FROM SALES
WHERE SALES IS NULL
;
