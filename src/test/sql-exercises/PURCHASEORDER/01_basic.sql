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
-- Exercises at the basic level on PURCHASEORDER: a filter, a sort, a count or the first rows. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PURCHASEORDER/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ----------------------------------------------------------------------- SAMPLE_PURCHASEORDER_B_01
-- the shipped orders, by date.
-- POID CUSTID ORDERDATE
-- ---- ------ ----------
-- 5002   1001 02/29/2004
-- 5001   1003 02/03/2005
-- 5003   1002 02/28/2005
-- 5004   1005 11/18/2005
-- 5006   1002 03/01/2006
--
--   5 record(s) selected.
SELECT POID, CUSTID, ORDERDATE
FROM PURCHASEORDER
WHERE STATUS = 'Shipped'
ORDER BY ORDERDATE
;

-- ----------------------------------------------------------------------- SAMPLE_PURCHASEORDER_B_02
-- the number of orders per status.
-- STATUS    ORDERS
-- --------- ------
-- Shipped        5
-- Unshipped      1
--
--   2 record(s) selected.
SELECT STATUS, COUNT(*) AS ORDERS
FROM PURCHASEORDER
GROUP BY STATUS
ORDER BY STATUS
;
