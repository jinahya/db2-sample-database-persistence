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
-- Exercises at the intermediate level on VFORPLA: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/VFORPLA/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_VFORPLA_I_01
-- the number of rows per project, and the distinct ones.
-- PROJNO ROWS DISTINCT_ROWS
-- ------ ---- -------------
-- AD3100    1             1
-- AD3110    1             1
-- AD3111    7             1
-- AD3112    9             1
-- AD3113   14             1
-- IF1000    4             1
-- IF2000    5             1
-- MA2100    2             1
-- MA2110    1             1
-- MA2111    3             1
-- ... 20 rows in all.
SELECT a.PROJNO, a.ROWS, d.DISTINCT_ROWS
FROM (SELECT PROJNO, COUNT(*) AS ROWS FROM VFORPLA GROUP BY PROJNO) a
         JOIN (SELECT PROJNO, COUNT(*) AS DISTINCT_ROWS
               FROM (SELECT DISTINCT * FROM VFORPLA) v
               GROUP BY PROJNO) d ON d.PROJNO = a.PROJNO
ORDER BY a.PROJNO
;
