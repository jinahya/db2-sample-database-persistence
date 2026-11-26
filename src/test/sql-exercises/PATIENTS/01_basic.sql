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
-- Exercises at the basic level on PATIENTS: a filter, a sort, a count or the first rows. Each poses a question, answers
-- it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PATIENTS/01_basic.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/01_basic.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_PATIENTS_B_01
-- the smokers, the oldest first.
-- PATIENT_ID NAME            AGE CHOLESTEROL_LEVEL
-- ---------- --------------- --- -----------------
--         12 Jamie Arnold     76               236
--         10 Ryan Munoz       69               202
--         15 Dylan Miller     64               210
--          8 Gina Moore       58               213
--         18 Derek Zuniga     58               243
--          6 Connie Lawrence  57               237
--         16 Brian Ramirez    56               244
--         20 Carla Gray       52               236
--
--   8 record(s) selected.
SELECT PATIENT_ID, NAME, AGE, CHOLESTEROL_LEVEL
FROM PATIENTS
WHERE SMOKING_STATUS = 'Smoker'
ORDER BY AGE DESC, PATIENT_ID
;

-- ---------------------------------------------------------------------------- SAMPLE_PATIENTS_B_02
-- the patients with a cholesterol level of 240 or more.
-- PATIENT_ID NAME          CHOLESTEROL_LEVEL
-- ---------- ------------- -----------------
--         16 Brian Ramirez               244
--         18 Derek Zuniga                243
--
--   2 record(s) selected.
SELECT PATIENT_ID, NAME, CHOLESTEROL_LEVEL
FROM PATIENTS
WHERE CHOLESTEROL_LEVEL >= 240
ORDER BY PATIENT_ID
;
