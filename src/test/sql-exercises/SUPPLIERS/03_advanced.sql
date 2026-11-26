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
-- Exercises at the advanced level on SUPPLIERS: a correlated subquery, a comparison across tables, or what only Db2 can
-- do: a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and
-- shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/SUPPLIERS/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- --------------------------------------------------------------------------- SAMPLE_SUPPLIERS_A_01
-- the name and the city of each supplier.
-- SID NAME               CITY
-- --- ------------------ -------
-- 100 Harry Suppliers    Markham
-- 101 Johnston Suppliers Toronto
--
--   2 record(s) selected.
SELECT s.SID, x.NAME, x.CITY
FROM SUPPLIERS s,
     XMLTABLE(XMLNAMESPACES(DEFAULT 'http://posample.org'),
              '$a/supplierinfo' PASSING s.ADDR AS "a"
              COLUMNS NAME VARCHAR(20) PATH 'name',
                      CITY VARCHAR(20) PATH 'addr/city') x
ORDER BY s.SID
;
