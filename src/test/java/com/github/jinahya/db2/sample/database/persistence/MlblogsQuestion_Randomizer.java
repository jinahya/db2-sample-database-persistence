package com.github.jinahya.db2.sample.database.persistence;

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

import com.github.jinahya.object.randomizer.PodamObjectRandomizer;

import java.util.List;

/**
 * Randomizes a new {@link MlblogsQuestion}, whose identifier it sets itself, within the lengths of
 * its columns, since Podam does not reach its setters, which are not public; the embedding, too, is
 * set here, to a vector of the column's dimension.
 */
@SuppressWarnings({
        "java:S101" // Class names should comply with a naming convention
})
class MlblogsQuestion_Randomizer
        extends PodamObjectRandomizer<MlblogsQuestion> {

    MlblogsQuestion_Randomizer() {
        super(MlblogsQuestion.class, List.of(
                MlblogsQuestion.ATTRIBUTE_NAME_QUESTION
        ));
    }

    // ---------------------------------------------------------------------------------------------
    @Override
    public MlblogsQuestion get() {
        final var instance = super.get();
        instance.setQuestion(__Randomizer_Utils.string(20));
        instance.setEmbedding(
                __Randomizer_Utils.vector(MlblogsQuestion.COLUMN_DIMENSION_EMBEDDING));
        return instance;
    }
}

