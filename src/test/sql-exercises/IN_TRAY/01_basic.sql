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
-- Exercises at the basic level on IN_TRAY: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/IN_TRAY/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ----------------------------------------------------------------------------- SAMPLE_IN_TRAY_B_01
-- the notes, the newest first.
-- RECEIVED                   SOURCE   SUBJECT
-- -------------------------- -------- ---------------------------------------
-- 1988-12-25-17.12.30.000000 BADAMSON FWD: Fantastic year! 4th Quarter Bonus.
-- 1988-12-23-08.53.58.000000 ISTERN   FWD: Fantastic year! 4th Quarter Bonus.
-- 1988-12-22-14.07.21.136421 CHAAS    Fantastic year! 4th Quarter Bonus.
--
--   3 record(s) selected.
SELECT RECEIVED, SOURCE, RTRIM(SUBJECT) AS SUBJECT
FROM IN_TRAY
ORDER BY RECEIVED DESC
;

-- ----------------------------------------------------------------------------- SAMPLE_IN_TRAY_B_02
-- the forwarded notes.
-- RECEIVED                   SOURCE
-- -------------------------- --------
-- 1988-12-23-08.53.58.000000 ISTERN
-- 1988-12-25-17.12.30.000000 BADAMSON
--
--   2 record(s) selected.
SELECT RECEIVED, SOURCE
FROM IN_TRAY
WHERE SUBJECT LIKE 'FWD:%'
ORDER BY RECEIVED
;
