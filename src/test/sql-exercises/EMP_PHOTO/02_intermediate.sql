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
-- Exercises at the intermediate level on EMP_PHOTO: a join, a group, an outer join or a subquery. Each poses a
-- question, answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMP_PHOTO/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- --------------------------------------------------------------------------- SAMPLE_EMP_PHOTO_I_01
-- the employees with a photo.
-- EMPNO  FIRSTNME LASTNAME
-- ------ -------- --------
-- 000130 DELORES  QUINTANA
-- 000140 HEATHER  NICHOLLS
-- 000150 BRUCE    ADAMSON
-- 000190 JAMES    WALKER
--
--   4 record(s) selected.
SELECT DISTINCT e.EMPNO, e.FIRSTNME, e.LASTNAME
FROM EMP_PHOTO p
         JOIN EMPLOYEE e ON e.EMPNO = p.EMPNO
ORDER BY e.EMPNO
;
