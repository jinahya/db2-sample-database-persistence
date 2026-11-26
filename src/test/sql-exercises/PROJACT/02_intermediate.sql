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
-- Exercises at the intermediate level on PROJACT: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PROJACT/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_PROJACT_I_01
-- the activities of MA2111 with their description.
-- ACTNO ACTDESC             ACSTDATE
-- ----- ------------------- ----------
--    40 LEAD PROGRAM/DESIGN 01/01/2002
--    50 WRITE SPECS         01/01/2002
--    60 DESCRIBE LOGIC      06/15/2002
--
--   3 record(s) selected.
SELECT pa.ACTNO, a.ACTDESC, pa.ACSTDATE
FROM PROJACT pa
         JOIN ACT a ON a.ACTNO = pa.ACTNO
WHERE pa.PROJNO = 'MA2111'
ORDER BY pa.ACTNO, pa.ACSTDATE
;

-- ----------------------------------------------------------------------------- SAMPLE_PROJACT_I_02
-- the number of activities and their first and last start per project.
-- PROJNO ACTIVITIES FIRST_START LAST_START
-- ------ ---------- ----------- ----------
-- AD3100          1 01/01/2002  01/01/2002
-- AD3110          1 01/01/2002  01/01/2002
-- AD3111          7 01/01/2002  10/15/2002
-- AD3112          9 01/01/2002  01/01/2003
-- AD3113         12 01/01/2002  10/15/2002
-- IF1000          3 06/01/2002  10/01/2002
-- IF2000          5 01/01/2002  10/01/2002
-- MA2100          2 01/01/2002  01/01/2002
-- MA2110          1 01/01/2002  01/01/2002
-- MA2111          3 01/01/2002  06/15/2002
-- ... 19 rows in all.
SELECT PROJNO, COUNT(*) AS ACTIVITIES, MIN(ACSTDATE) AS FIRST_START, MAX(ACSTDATE) AS LAST_START
FROM PROJACT
GROUP BY PROJNO
ORDER BY PROJNO
;
