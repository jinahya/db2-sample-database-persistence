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
-- Exercises at the basic level on CL_SCHED: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/CL_SCHED/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_CL_SCHED_B_01
-- every class, by day and time.
-- CLASS_CODE DAY STARTING ENDING
-- ---------- --- -------- --------
-- 553:MJA      1 10:30:00 11:00:00
-- 778:RES      2 12:10:00 14:00:00
-- 543:CWM      3 09:10:00 10:30:00
-- 044:HD       3 17:12:30 18:00:00
-- 042:BF       4 12:10:00 14:00:00
--
--   5 record(s) selected.
SELECT CLASS_CODE, DAY, STARTING, ENDING
FROM CL_SCHED
ORDER BY DAY, STARTING
;

-- ---------------------------------------------------------------------------- SAMPLE_CL_SCHED_B_02
-- the classes that start before noon.
-- CLASS_CODE DAY STARTING
-- ---------- --- --------
-- 543:CWM      3 09:10:00
-- 553:MJA      1 10:30:00
--
--   2 record(s) selected.
SELECT CLASS_CODE, DAY, STARTING
FROM CL_SCHED
WHERE STARTING < TIME '12:00:00'
ORDER BY STARTING
;
