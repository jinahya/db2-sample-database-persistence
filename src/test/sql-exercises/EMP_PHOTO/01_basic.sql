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
-- Exercises at the basic level on EMP_PHOTO: a filter, a sort, a count or the first rows. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/EMP_PHOTO/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- --------------------------------------------------------------------------- SAMPLE_EMP_PHOTO_B_01
-- every photo, by employee and format.
-- EMPNO  PHOTO_FORMAT
-- ------ ------------
-- 000130 bitmap
-- 000130 gif
-- 000140 bitmap
-- 000140 gif
-- 000150 bitmap
-- 000150 gif
-- 000190 bitmap
-- 000190 gif
--
--   8 record(s) selected.
SELECT EMPNO, PHOTO_FORMAT
FROM EMP_PHOTO
ORDER BY EMPNO, PHOTO_FORMAT
;

-- --------------------------------------------------------------------------- SAMPLE_EMP_PHOTO_B_02
-- the size of each photo.
-- EMPNO  PHOTO_FORMAT BYTES
-- ------ ------------ -----
-- 000150 bitmap       73438
-- 000140 bitmap       71798
-- 000190 bitmap       63542
-- 000130 bitmap       43690
-- 000150 gif          39795
-- 000190 gif          36088
-- 000130 gif          29540
-- 000140 gif          29143
--
--   8 record(s) selected.
SELECT EMPNO, PHOTO_FORMAT, LENGTH(PICTURE) AS BYTES
FROM EMP_PHOTO
ORDER BY BYTES DESC
;
