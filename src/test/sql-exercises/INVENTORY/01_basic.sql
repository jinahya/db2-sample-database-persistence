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
-- Exercises at the basic level on INVENTORY: a filter, a sort, a count or the first rows. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/INVENTORY/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- --------------------------------------------------------------------------- SAMPLE_INVENTORY_B_01
-- every product in stock, by id.
-- PID        QUANTITY LOCATION
-- ---------- -------- ---------
-- 100-100-01        5 -
-- 100-101-01       25 Store
-- 100-103-01       55 Store
-- 100-201-01       99 Warehouse
--
--   4 record(s) selected.
SELECT PID, QUANTITY, LOCATION
FROM INVENTORY
ORDER BY PID
;

-- --------------------------------------------------------------------------- SAMPLE_INVENTORY_B_02
-- the stock without a location.
-- PID        QUANTITY
-- ---------- --------
-- 100-100-01        5
--
--   1 record(s) selected.
SELECT PID, QUANTITY
FROM INVENTORY
WHERE LOCATION IS NULL
;
