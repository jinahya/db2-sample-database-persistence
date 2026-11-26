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
-- Exercises at the intermediate level on SALES: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/SALES/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ------------------------------------------------------------------------------- SAMPLE_SALES_I_01
-- the total sales of each person.
-- SALES_PERSON SALES
-- ------------ -----
-- LEE             91
-- GOUNOT          50
-- LUCCHESSI       14
--
--   3 record(s) selected.
SELECT SALES_PERSON, SUM(SALES) AS SALES
FROM SALES
GROUP BY SALES_PERSON
ORDER BY SALES DESC
;

-- ------------------------------------------------------------------------------- SAMPLE_SALES_I_02
-- the total sales of each region on 03/31/2006.
-- REGION        SALES
-- ------------- -----
-- Manitoba          5
-- Ontario-North     3
-- Ontario-South    16
-- Quebec            8
--
--   4 record(s) selected.
SELECT REGION, SUM(SALES) AS SALES
FROM SALES
WHERE SALES_DATE = DATE '2006-03-31'
GROUP BY REGION
ORDER BY REGION
;
