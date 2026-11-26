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
-- Exercises at the intermediate level on CL_SCHED: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/CL_SCHED/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_CL_SCHED_I_01
-- the length of each class in minutes.
-- CLASS_CODE STARTING ENDING   MINUTES
-- ---------- -------- -------- -------
-- 042:BF     12:10:00 14:00:00     110
-- 778:RES    12:10:00 14:00:00     110
-- 543:CWM    09:10:00 10:30:00      80
-- 044:HD     17:12:30 18:00:00      47
-- 553:MJA    10:30:00 11:00:00      30
--
--   5 record(s) selected.
SELECT CLASS_CODE, STARTING, ENDING,
       (MIDNIGHT_SECONDS(ENDING) - MIDNIGHT_SECONDS(STARTING)) / 60 AS MINUTES
FROM CL_SCHED
ORDER BY MINUTES DESC, CLASS_CODE
;
