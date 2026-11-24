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
 * Defines classes which map the tables of the {@code SAMPLE} database, as created by {@code db2sampl} into the
 * {@code DB2INST1} schema, each holding the column mappings of one table.
 * <p>
 * Every table but three is mapped. {@code MLBLOGS_ANSWERS} and {@code MLBLOGS_QUESTIONS} have no key, declared or
 * logical, and hold little but a {@code VECTOR} column, for which Jakarta Persistence has no mapping; {@code ADEFUSR}
 * is a materialized query table, which the database maintains.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
package com.github.jinahya.db2.sample.database.persistence;
