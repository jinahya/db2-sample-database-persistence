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
-- Exercises at the advanced level on SALES: a correlated subquery, a comparison across tables, or what only Db2 can do:
-- a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and shows
-- what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/SALES/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- ------------------------------------------------------------------------------- SAMPLE_SALES_A_01
-- the totals by person and region, with subtotals.
-- SALES_PERSON REGION        SALES
-- ------------ ------------- -----
-- GOUNOT       Manitoba         15
-- GOUNOT       Ontario-North     1
-- GOUNOT       Ontario-South    10
-- GOUNOT       Quebec           24
-- GOUNOT       -                50
-- LEE          Manitoba         23
-- LEE          Ontario-North     8
-- LEE          Ontario-South    34
-- LEE          Quebec           26
-- LEE          -                91
-- ... 15 rows in all.
SELECT SALES_PERSON, REGION, SUM(SALES) AS SALES
FROM SALES
GROUP BY ROLLUP (SALES_PERSON, REGION)
ORDER BY GROUPING(SALES_PERSON), SALES_PERSON, GROUPING(REGION), REGION
;
