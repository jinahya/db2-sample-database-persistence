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
-- Exercises at the intermediate level on EMP_RESUME: a join, a group, an outer join or a subquery. Each poses a
-- question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMP_RESUME/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- -------------------------------------------------------------------------- SAMPLE_EMP_RESUME_I_01
-- the employees whose resume lists a B.A..
-- EMPNO  LASTNAME
-- ------ --------
-- 000130 QUINTANA
-- 000140 NICHOLLS
-- 000150 ADAMSON
-- 000190 WALKER
--
--   4 record(s) selected.
SELECT r.EMPNO, e.LASTNAME
FROM EMP_RESUME r
         JOIN EMPLOYEE e ON e.EMPNO = r.EMPNO
WHERE r.RESUME_FORMAT = 'ascii'
  AND LOCATE('B.A.', r.RESUME) > 0
ORDER BY r.EMPNO
;
