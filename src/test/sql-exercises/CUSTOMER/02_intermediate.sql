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
-- Exercises at the intermediate level on CUSTOMER: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/CUSTOMER/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_CUSTOMER_I_01
-- the number of orders of each customer.
-- CID  ORDERS
-- ---- ------
-- 1000      0
-- 1001      1
-- 1002      3
-- 1003      1
-- 1004      0
-- 1005      1
--
--   6 record(s) selected.
SELECT c.CID, COUNT(po.POID) AS ORDERS
FROM CUSTOMER c
         LEFT JOIN PURCHASEORDER po ON po.CUSTID = c.CID
GROUP BY c.CID
ORDER BY c.CID
;
