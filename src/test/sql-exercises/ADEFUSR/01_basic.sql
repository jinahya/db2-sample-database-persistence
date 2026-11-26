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
-- Exercises at the basic level on ADEFUSR: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/ADEFUSR/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_ADEFUSR_B_01
-- every department, by number.
-- WORKDEPT NO_OF_EMPLOYEES
-- -------- ---------------
-- A00                    5
-- B01                    1
-- C01                    4
-- D11                   11
-- D21                    7
-- E01                    1
-- E11                    7
-- E21                    6
--
--   8 record(s) selected.
SELECT WORKDEPT, NO_OF_EMPLOYEES
FROM ADEFUSR
ORDER BY WORKDEPT
;
