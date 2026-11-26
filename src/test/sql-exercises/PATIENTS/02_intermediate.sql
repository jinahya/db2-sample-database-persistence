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
-- Exercises at the intermediate level on PATIENTS: a join, a group, an outer join or a subquery. Each poses a question,
-- answers it, and shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PATIENTS/02_intermediate.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/02_intermediate.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_PATIENTS_I_01
-- the averages of smokers and non-smokers.
-- SMOKING_STATUS PATIENTS AGE  CHOLESTEROL PRESSURE
-- -------------- -------- ---- ----------- --------
-- Non-smoker           12 34.2       173.1    105.1
-- Smoker                8 61.2       227.6    157.1
--
--   2 record(s) selected.
SELECT SMOKING_STATUS, COUNT(*) AS PATIENTS,
       DECIMAL(AVG(DECFLOAT(AGE)), 5, 1) AS AGE,
       DECIMAL(AVG(DECFLOAT(CHOLESTEROL_LEVEL)), 5, 1) AS CHOLESTEROL,
       DECIMAL(AVG(DECFLOAT(BLOOD_PRESSURE)), 5, 1) AS PRESSURE
FROM PATIENTS
GROUP BY SMOKING_STATUS
ORDER BY SMOKING_STATUS
;
