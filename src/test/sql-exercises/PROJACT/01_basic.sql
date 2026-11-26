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
-- Exercises at the basic level on PROJACT: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PROJACT/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_PROJACT_B_01
-- the activities of AD3111.
-- PROJNO ACTNO ACSTDATE
-- ------ ----- ----------
-- AD3111    60 01/01/2002
-- AD3111    60 03/15/2002
-- AD3111    70 02/15/2002
-- AD3111    70 03/15/2002
-- AD3111    80 04/15/2002
-- AD3111    80 09/15/2002
-- AD3111   180 10/15/2002
--
--   7 record(s) selected.
SELECT PROJNO, ACTNO, ACSTDATE
FROM PROJACT
WHERE PROJNO = 'AD3111'
ORDER BY ACTNO, ACSTDATE
;

-- ----------------------------------------------------------------------------- SAMPLE_PROJACT_B_02
-- the columns that are never set.
-- ROWS WITH_STAFF WITH_END
-- ---- ---------- --------
--   65          0        0
--
--   1 record(s) selected.
SELECT COUNT(*) AS ROWS, COUNT(ACSTAFF) AS WITH_STAFF, COUNT(ACENDATE) AS WITH_END
FROM PROJACT
;
