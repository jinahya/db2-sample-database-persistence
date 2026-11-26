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
-- Exercises at the intermediate level on ACT: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/ACT/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- --------------------------------------------------------------------------------- SAMPLE_ACT_I_01
-- the number of projects of each activity.
-- ACTNO ACTKWD PROJECTS
-- ----- ------ --------
--    10 MANAGE        9
--    60 LOGIC         6
--    70 CODE          5
--    80 TEST          5
--   180 DOC           5
--   140 MAINT         3
--   100 TEACH         2
--    20 ECOST         1
--    30 DEFINE        1
--    40 LEADPR        1
-- ... 18 rows in all.
SELECT a.ACTNO, a.ACTKWD, COUNT(DISTINCT pa.PROJNO) AS PROJECTS
FROM ACT a
         LEFT JOIN PROJACT pa ON pa.ACTNO = a.ACTNO
GROUP BY a.ACTNO, a.ACTKWD
ORDER BY PROJECTS DESC, a.ACTNO
;

-- --------------------------------------------------------------------------------- SAMPLE_ACT_I_02
-- the activities no project has.
-- ACTNO ACTKWD ACTDESC
-- ----- ------ -----------------
--   120 STAFF  PERS AND STAFFING
--
--   1 record(s) selected.
SELECT a.ACTNO, a.ACTKWD, a.ACTDESC
FROM ACT a
WHERE NOT EXISTS (SELECT 1 FROM PROJACT pa WHERE pa.ACTNO = a.ACTNO)
ORDER BY a.ACTNO
;
