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
-- Exercises at the intermediate level on PRODUCT: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PRODUCT/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_PRODUCT_I_01
-- the discount of each promotion.
-- PID        PRICE PROMOPRICE DISCOUNT
-- ---------- ----- ---------- --------
-- 100-100-01  9.99       7.25    27.43
-- 100-101-01 19.99      15.99    20.01
-- 100-103-01 49.99      39.99    20.00
--
--   3 record(s) selected.
SELECT PID, PRICE, PROMOPRICE, DECIMAL(DECFLOAT(PRICE - PROMOPRICE) * 100 / PRICE, 5, 2) AS DISCOUNT
FROM PRODUCT
WHERE PROMOPRICE IS NOT NULL
ORDER BY DISCOUNT DESC
;

-- ----------------------------------------------------------------------------- SAMPLE_PRODUCT_I_02
-- the products with their supplier.
-- PID        NAME                           SID
-- ---------- ------------------------------ ---
-- 100-101-01 Snow Shovel, Deluxe 24 inch    100
-- 100-201-01 Ice Scraper, Windshield 4 inch 101
--
--   2 record(s) selected.
SELECT p.PID, p.NAME, ps.SID
FROM PRODUCT p
         JOIN PRODUCTSUPPLIER ps ON ps.PID = p.PID
ORDER BY p.PID
;
