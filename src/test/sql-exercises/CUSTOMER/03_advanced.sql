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
-- Exercises at the advanced level on CUSTOMER: a correlated subquery, a comparison across tables, or what only Db2 can
-- do: a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and
-- shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/CUSTOMER/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_CUSTOMER_A_01
-- the name and the city of each customer.
-- CID  NAME             CITY
-- ---- ---------------- -------
-- 1000 Kathy Smith      Toronto
-- 1001 Kathy Smith      Markham
-- 1002 Jim Noodle       Markham
-- 1003 Robert Shoemaker Aurora
-- 1004 Matt Foreman     Toronto
-- 1005 Larry Menard     Toronto
--
--   6 record(s) selected.
SELECT c.CID, x.NAME, x.CITY
FROM CUSTOMER c,
     XMLTABLE('$i/customerinfo' PASSING c.INFO AS "i"
              COLUMNS NAME VARCHAR(20) PATH 'name',
                      CITY VARCHAR(20) PATH 'addr/city') x
ORDER BY c.CID
;
