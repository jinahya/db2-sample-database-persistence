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
-- Exercises at the advanced level on PATIENTS: a correlated subquery, a comparison across tables, or what only Db2 can
-- do: a recursive query, a window, a rollup or a query into an XML document. Each poses a question, answers it, and
-- shows what the installed data gives back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql-exercises/PATIENTS/03_advanced.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/03_advanced.sql'
--


-- ---------------------------------------------------------------------------- SAMPLE_PATIENTS_A_01
-- the patients above the cholesterol average of their group.
-- PATIENT_ID NAME            SMOKING_STATUS CHOLESTEROL_LEVEL
-- ---------- --------------- -------------- -----------------
--          2 Noah Rhodes     Non-smoker                   193
--          4 Daniel Wagner   Non-smoker                   182
--          5 Cristian Santos Non-smoker                   195
--          6 Connie Lawrence Smoker                       237
--          7 Abigail Shaffer Non-smoker                   194
--         12 Jamie Arnold    Smoker                       236
--         13 Lisa Hensley    Non-smoker                   199
--         16 Brian Ramirez   Smoker                       244
--         18 Derek Zuniga    Smoker                       243
--         20 Carla Gray      Smoker                       236
--
--   10 record(s) selected.
SELECT p.PATIENT_ID, p.NAME, p.SMOKING_STATUS, p.CHOLESTEROL_LEVEL
FROM PATIENTS p
WHERE p.CHOLESTEROL_LEVEL > (SELECT AVG(x.CHOLESTEROL_LEVEL)
                             FROM PATIENTS x
                             WHERE x.SMOKING_STATUS = p.SMOKING_STATUS)
ORDER BY p.PATIENT_ID
;
