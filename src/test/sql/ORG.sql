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
-- Profiling queries on ORG, a table, a section per column. Each says what it looks for and what the installed data
-- returns; 'no rows' marks a check that passes when nothing comes back.
--
-- Run the file as a whole, from the project's directory:
--   docker cp src/test/sql/ORG.sql db2-sample-database-persistence:/tmp/ &&
--   docker exec db2-sample-database-persistence \
--     su - db2inst1 -c 'db2 connect to SAMPLE && db2 -tvf /tmp/ORG.sql'
--

-- how many rows; 8.
SELECT COUNT(*)
FROM ORG
;


-- -------------------------------------------------------------------------------------- IDENTIFIER
-- this table declares no primary key, and is mapped as no entity, with no identifier. DEPTNUMB, which the data alone
-- would suggest as one: the values which more than one row shares.
-- no rows: unique in the installed data; nothing in the database keeps it so.
SELECT DEPTNUMB, COUNT(*)
FROM ORG
GROUP BY DEPTNUMB
HAVING COUNT(*) > 1
;


-- the rows whose DEPTNUMB names a department of DEPARTMENT, as a foreign key to it would; DEPTNUMB is a SMALLINT and
-- DEPTNO a CHAR(3), which Db2 does not compare, so DEPTNUMB is compared as text.
-- no rows: ORG numbers its departments on its own (10 to 84), apart from DEPARTMENT (A00, B01, ...).
SELECT o.DEPTNUMB, d.DEPTNO
FROM ORG AS o
         JOIN DEPARTMENT AS d ON VARCHAR(o.DEPTNUMB) = d.DEPTNO
;


-- ---------------------------------------------------------------------------------------- DEPTNUMB
-- the smallest and the largest DEPTNUMB; 10 and 84.
SELECT MIN(DEPTNUMB), MAX(DEPTNUMB)
FROM ORG
;


-- ---------------------------------------------------------------------------------------- DEPTNAME
-- the shortest and the longest DEPTNAME, trailing spaces trimmed; 6 to 14 characters, of VARCHAR(14) declared.
SELECT MIN(LENGTH(RTRIM(DEPTNAME))), MAX(LENGTH(RTRIM(DEPTNAME)))
FROM ORG
;

-- rows whose DEPTNAME is blank, or carries leading or trailing spaces.
-- no rows: every DEPTNAME is trimmed and not blank.
SELECT DEPTNAME, '[' || DEPTNAME || ']' AS BRACKETED
FROM ORG
WHERE RTRIM(DEPTNAME) = ''
   OR DEPTNAME <> LTRIM(DEPTNAME)
   OR LENGTH(DEPTNAME) <> LENGTH(RTRIM(DEPTNAME))
;

-- how many rows have no DEPTNAME; 0 of 8.
SELECT COUNT(*) - COUNT(DEPTNAME), COUNT(*)
FROM ORG
;


-- ----------------------------------------------------------------------------------------- MANAGER
-- the smallest and the largest MANAGER; 10 and 290.
SELECT MIN(MANAGER), MAX(MANAGER)
FROM ORG
;

-- how many rows have no MANAGER; 0 of 8.
SELECT COUNT(*) - COUNT(MANAGER), COUNT(*)
FROM ORG
;

-- the rows whose MANAGER names an employee of EMPLOYEE, as a foreign key to it would; MANAGER is a SMALLINT and
-- EMPNO a CHAR(6), which Db2 does not compare, so MANAGER is compared as text, zero-padded to six digits as EMPNO is.
-- 8 rows, but by the number only: the manager of each is another person (10 is HAAS here, Sanders in STAFF).
SELECT o.MANAGER, e.EMPNO, e.LASTNAME
FROM ORG AS o
         JOIN EMPLOYEE AS e ON LPAD(VARCHAR(o.MANAGER), 6, '0') = e.EMPNO
;

-- the rows whose MANAGER is not the ID of a manager ('Mgr') of STAFF in the department of the row; STAFF and ORG are
-- the pair which the number belongs to, though no foreign key says so.
-- no rows: each MANAGER is a manager of STAFF, in the same department.
SELECT o.DEPTNUMB, o.MANAGER
FROM ORG AS o
WHERE NOT EXISTS (SELECT 1
                  FROM STAFF AS s
                  WHERE s.ID = o.MANAGER
                    AND s.DEPT = o.DEPTNUMB
                    AND s.JOB = 'Mgr')
;


-- ---------------------------------------------------------------------------------------- DIVISION
-- the shortest and the longest DIVISION, trailing spaces trimmed; 7 to 9 characters, of VARCHAR(10) declared.
SELECT MIN(LENGTH(RTRIM(DIVISION))), MAX(LENGTH(RTRIM(DIVISION)))
FROM ORG
;

-- rows whose DIVISION is blank, or carries leading or trailing spaces.
-- no rows: every DIVISION is trimmed and not blank.
SELECT DIVISION, '[' || DIVISION || ']' AS BRACKETED
FROM ORG
WHERE RTRIM(DIVISION) = ''
   OR DIVISION <> LTRIM(DIVISION)
   OR LENGTH(DIVISION) <> LENGTH(RTRIM(DIVISION))
;

-- how many rows have no DIVISION; 0 of 8.
SELECT COUNT(*) - COUNT(DIVISION), COUNT(*)
FROM ORG
;


-- ---------------------------------------------------------------------------------------- LOCATION
-- the shortest and the longest LOCATION, trailing spaces trimmed; 6 to 13 characters, of VARCHAR(13) declared.
SELECT MIN(LENGTH(RTRIM(LOCATION))), MAX(LENGTH(RTRIM(LOCATION)))
FROM ORG
;

-- rows whose LOCATION is blank, or carries leading or trailing spaces.
-- no rows: every LOCATION is trimmed and not blank.
SELECT LOCATION, '[' || LOCATION || ']' AS BRACKETED
FROM ORG
WHERE RTRIM(LOCATION) = ''
   OR LOCATION <> LTRIM(LOCATION)
   OR LENGTH(LOCATION) <> LENGTH(RTRIM(LOCATION))
;

-- how many rows have no LOCATION; 0 of 8.
SELECT COUNT(*) - COUNT(LOCATION), COUNT(*)
FROM ORG
;

