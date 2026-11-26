/*-
 * #%L
 * db2-sample-database-persistence
 * %%
 * Copyright (C) 2026 Jinahya, Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

/**
 * Defines classes which map the tables and the views of the {@code SAMPLE} database, as created by
 * {@code db2sampl} into the {@code DB2INST1} schema, each holding the column mappings of one table
 * or view.
 * <p>
 * Every table and every view is mapped. The views, and {@code ADEFUSR}, a materialized query table
 * which the database maintains, are mapped read-only. The {@code VECTOR} columns of
 * {@code MLBLOGS_ANSWERS}, {@code MLBLOGS_QUESTIONS} and {@code PATIENTS} map to {@code float[]}
 * through {@code VectorStringAttributeConverter}. The aliases ({@code DEPT}, {@code EMP},
 * {@code EMPACT}, {@code EMP_ACT}, {@code PROJ}) are other names of tables mapped here.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
package com.github.jinahya.db2.sample.database.persistence.mapped;
