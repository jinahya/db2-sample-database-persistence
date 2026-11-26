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
-- Exercises at the basic level on EMP_RESUME: a filter, a sort, a count or the first rows. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMP_RESUME/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- -------------------------------------------------------------------------- SAMPLE_EMP_RESUME_B_01
-- every resume, by employee and format.
-- EMPNO  RESUME_FORMAT
-- ------ -------------
-- 000130 ascii
-- 000130 html
-- 000140 ascii
-- 000140 html
-- 000150 ascii
-- 000150 html
-- 000190 ascii
-- 000190 html
--
--   8 record(s) selected.
SELECT EMPNO, RESUME_FORMAT
FROM EMP_RESUME
ORDER BY EMPNO, RESUME_FORMAT
;

-- -------------------------------------------------------------------------- SAMPLE_EMP_RESUME_B_02
-- the length of each resume.
-- EMPNO  RESUME_FORMAT CHARACTERS
-- ------ ------------- ----------
-- 000130 ascii               1257
-- 000130 html                2415
-- 000140 ascii               1261
-- 000140 html                2440
-- 000150 ascii               1308
-- 000150 html                2467
-- 000190 ascii               1237
-- 000190 html                2402
--
--   8 record(s) selected.
SELECT EMPNO, RESUME_FORMAT, LENGTH(RESUME) AS CHARACTERS
FROM EMP_RESUME
ORDER BY EMPNO, RESUME_FORMAT
;
