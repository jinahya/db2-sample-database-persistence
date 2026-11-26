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
-- Exercises at the intermediate level on INVENTORY: a join, a group, an outer join or a subquery. Each poses a
-- question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/INVENTORY/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- --------------------------------------------------------------------------- SAMPLE_INVENTORY_I_01
-- the stock with the name and the value of each product.
-- PID        NAME                              QUANTITY VALUE
-- ---------- --------------------------------- -------- -------
-- 100-100-01 Snow Shovel, Basic 22 inch               5   49.95
-- 100-101-01 Snow Shovel, Deluxe 24 inch             25  499.75
-- 100-103-01 Snow Shovel, Super Deluxe 26 inch       55 2749.45
-- 100-201-01 Ice Scraper, Windshield 4 inch          99  395.01
--
--   4 record(s) selected.
SELECT i.PID, p.NAME, i.QUANTITY, i.QUANTITY * p.PRICE AS VALUE
FROM INVENTORY i
         JOIN PRODUCT p ON p.PID = i.PID
ORDER BY i.PID
;
