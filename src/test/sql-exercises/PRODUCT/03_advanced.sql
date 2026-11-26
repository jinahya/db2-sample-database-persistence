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
-- Exercises at the advanced level on PRODUCT: a correlated subquery, a comparison across tables, or what only Db2 can
-- do: a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and
-- shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PRODUCT/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_PRODUCT_A_01
-- the weight of each product, from its description.
-- PID        WEIGHT
-- ---------- ------
-- 100-100-01 1 kg
-- 100-101-01 2 kg
-- 100-103-01 3 kg
-- 100-201-01 -
--
--   4 record(s) selected.
SELECT PID,
       XMLCAST(XMLQUERY('$d/product/description/weight' PASSING DESCRIPTION AS "d") AS VARCHAR(10)) AS WEIGHT
FROM PRODUCT
ORDER BY PID
;
