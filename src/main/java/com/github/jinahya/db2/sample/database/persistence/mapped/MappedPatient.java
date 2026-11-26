package com.github.jinahya.db2.sample.database.persistence.mapped;

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

import com.github.jinahya.db2.sample.database.persistence.VectorStringAttributeConverter;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.FetchType;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Optional;

/**
 * A mapped superclass which holds the mappings of the {@value MappedPatient#TABLE_NAME} table, the
 * patients.
 * <p>
 * <strong>The table declares no primary key</strong>, and no column, or set of columns, is a key
 * by
 * its definition; the class maps no identifier, so an extending class is not an entity, and is
 * built from the rows of a native query.
 * <p>
 * The {@value MappedPatient#COLUMN_NAME_EMBEDDING} column, a {@code VECTOR(768, FLOAT32)}, maps to
 * a {@code float[]} through {@link VectorStringAttributeConverter}, by the string form in which Db2
 * hands a vector to an application.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedPatient {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "PATIENTS";

    // ---------------------------------------------------------------------------------- PATIENT_ID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PATIENT_ID} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PATIENT_ID = "PATIENT_ID";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PATIENT_ID} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PATIENT_ID = "patientId";

    // ---------------------------------------------------------------------------------------- NAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_NAME} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_NAME = "NAME";

    /**
     * The length of the {@value #COLUMN_NAME_NAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_NAME = 30;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_NAME} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_NAME = "name";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_NAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_NAME = COLUMN_LENGTH_NAME;

    // ----------------------------------------------------------------------------------------- AGE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_AGE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_AGE = "AGE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_AGE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_AGE = "age";

    // -------------------------------------------------------------------------------------- GENDER

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_GENDER} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_GENDER = "GENDER";

    /**
     * The length of the {@value #COLUMN_NAME_GENDER} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_GENDER = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_GENDER} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_GENDER = "gender";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_GENDER} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_GENDER = COLUMN_LENGTH_GENDER;

    // --------------------------------------------------------------------------- CHOLESTEROL_LEVEL

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_CHOLESTEROL_LEVEL}
     * attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_CHOLESTEROL_LEVEL = "CHOLESTEROL_LEVEL";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_CHOLESTEROL_LEVEL} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_CHOLESTEROL_LEVEL = "cholesterolLevel";

    // ------------------------------------------------------------------------------ BLOOD_PRESSURE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_BLOOD_PRESSURE} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_BLOOD_PRESSURE = "BLOOD_PRESSURE";

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_BLOOD_PRESSURE} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_BLOOD_PRESSURE = "bloodPressure";

    // ------------------------------------------------------------------------------ SMOKING_STATUS

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SMOKING_STATUS} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_SMOKING_STATUS = "SMOKING_STATUS";

    /**
     * The length of the {@value #COLUMN_NAME_SMOKING_STATUS} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_SMOKING_STATUS = 10;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SMOKING_STATUS} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_SMOKING_STATUS = "smokingStatus";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_SMOKING_STATUS} attribute. The value is
     * {@value}.
     */
    public static final int SIZE_MAX_SMOKING_STATUS = COLUMN_LENGTH_SMOKING_STATUS;

    // ----------------------------------------------------------------------------------- EMBEDDING

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMBEDDING} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_EMBEDDING = "EMBEDDING";

    /**
     * The dimension of the {@value #COLUMN_NAME_EMBEDDING} column, a {@code VECTOR(768, FLOAT32)}.
     * The value is {@value}.
     */
    public static final int COLUMN_DIMENSION_EMBEDDING = 768;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMBEDDING} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMBEDDING = "embedding";

    /**
     * The size of the {@value #ATTRIBUTE_NAME_EMBEDDING} attribute. The value is {@value}.
     */
    public static final int SIZE_EMBEDDING = COLUMN_DIMENSION_EMBEDDING;

    // --------------------------------------------------------------------------------- SELECT_LIST

    /**
     * The columns of {@value #TABLE_NAME}, in their order, as the select list of a native query
     * whose rows an extending class is built from. The value is {@value}.
     */
    public static final String SELECT_LIST =
            COLUMN_NAME_PATIENT_ID + ", "
            + COLUMN_NAME_NAME + ", "
            + COLUMN_NAME_AGE + ", "
            + COLUMN_NAME_GENDER + ", "
            + COLUMN_NAME_CHOLESTEROL_LEVEL + ", "
            + COLUMN_NAME_BLOOD_PRESSURE + ", "
            + COLUMN_NAME_SMOKING_STATUS + ", "
            + COLUMN_NAME_EMBEDDING;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedPatient() {
        super();
    }

    /**
     * Creates a new instance with the specified values, in the order of {@link #SELECT_LIST}.
     *
     * @param patientId        a value for the {@value #ATTRIBUTE_NAME_PATIENT_ID} attribute.
     * @param name             a value for the {@value #ATTRIBUTE_NAME_NAME} attribute.
     * @param age              a value for the {@value #ATTRIBUTE_NAME_AGE} attribute.
     * @param gender           a value for the {@value #ATTRIBUTE_NAME_GENDER} attribute.
     * @param cholesterolLevel a value for the {@value #ATTRIBUTE_NAME_CHOLESTEROL_LEVEL}
     *                         attribute.
     * @param bloodPressure    a value for the {@value #ATTRIBUTE_NAME_BLOOD_PRESSURE} attribute.
     * @param smokingStatus    a value for the {@value #ATTRIBUTE_NAME_SMOKING_STATUS} attribute.
     * @param embedding        a value for the {@value #ATTRIBUTE_NAME_EMBEDDING} attribute.
     */
    protected MappedPatient(
            final Integer patientId,
            final String name,
            final Integer age,
            final String gender,
            final Integer cholesterolLevel,
            final Integer bloodPressure,
            final String smokingStatus,
            final float[] embedding) {
        this();
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.cholesterolLevel = cholesterolLevel;
        this.bloodPressure = bloodPressure;
        this.smokingStatus = smokingStatus;
        this.embedding = Optional.ofNullable(embedding).map(float[]::clone).orElse(null);
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "patientId=" + patientId +
               ",name=" + name +
               ",age=" + age +
               ",gender=" + gender +
               ",cholesterolLevel=" + cholesterolLevel +
               ",bloodPressure=" + bloodPressure +
               ",smokingStatus=" + smokingStatus +
               '}';
    }

    // ----------------------------------------------------------------------------------- patientId

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PATIENT_ID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PATIENT_ID} attribute.
     */
    @Nonnull
    public Integer getPatientId() {
        return patientId;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PATIENT_ID} attribute with the specified
     * value.
     *
     * @param patientId new value for {@value #ATTRIBUTE_NAME_PATIENT_ID} attribute.
     */
    protected void setPatientId(@Nonnull final Integer patientId) {
        this.patientId = patientId;
    }

    // ---------------------------------------------------------------------------------------- name

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_NAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_NAME} attribute.
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_NAME} attribute with the specified value.
     *
     * @param name new value for {@value #ATTRIBUTE_NAME_NAME} attribute.
     */
    public void setName(@Nullable final String name) {
        this.name = name;
    }

    // ----------------------------------------------------------------------------------------- age

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_AGE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_AGE} attribute.
     */
    @Nullable
    public Integer getAge() {
        return age;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_AGE} attribute with the specified value.
     *
     * @param age new value for {@value #ATTRIBUTE_NAME_AGE} attribute.
     */
    public void setAge(@Nullable final Integer age) {
        this.age = age;
    }

    // -------------------------------------------------------------------------------------- gender

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_GENDER} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_GENDER} attribute.
     */
    @Nullable
    public String getGender() {
        return gender;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_GENDER} attribute with the specified
     * value.
     *
     * @param gender new value for {@value #ATTRIBUTE_NAME_GENDER} attribute.
     */
    public void setGender(@Nullable final String gender) {
        this.gender = gender;
    }

    // ---------------------------------------------------------------------------- cholesterolLevel

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_CHOLESTEROL_LEVEL} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_CHOLESTEROL_LEVEL} attribute.
     */
    @Nullable
    public Integer getCholesterolLevel() {
        return cholesterolLevel;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_CHOLESTEROL_LEVEL} attribute with the
     * specified value.
     *
     * @param cholesterolLevel new value for {@value #ATTRIBUTE_NAME_CHOLESTEROL_LEVEL} attribute.
     */
    public void setCholesterolLevel(@Nullable final Integer cholesterolLevel) {
        this.cholesterolLevel = cholesterolLevel;
    }

    // ------------------------------------------------------------------------------- bloodPressure

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_BLOOD_PRESSURE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_BLOOD_PRESSURE} attribute.
     */
    @Nullable
    public Integer getBloodPressure() {
        return bloodPressure;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_BLOOD_PRESSURE} attribute with the
     * specified value.
     *
     * @param bloodPressure new value for {@value #ATTRIBUTE_NAME_BLOOD_PRESSURE} attribute.
     */
    public void setBloodPressure(@Nullable final Integer bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    // ------------------------------------------------------------------------------- smokingStatus

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SMOKING_STATUS} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SMOKING_STATUS} attribute.
     */
    @Nullable
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SMOKING_STATUS} attribute with the
     * specified value.
     *
     * @param smokingStatus new value for {@value #ATTRIBUTE_NAME_SMOKING_STATUS} attribute.
     */
    public void setSmokingStatus(@Nullable final String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    // ----------------------------------------------------------------------------------- embedding

    /**
     * Returns a copy of current value of {@value #ATTRIBUTE_NAME_EMBEDDING} attribute.
     *
     * @return a copy of current value of {@value #ATTRIBUTE_NAME_EMBEDDING} attribute; {@code null}
     *         when it is {@code null}.
     * @implNote A copy is returned, and a copy is kept by {@link #setEmbedding(float[])},
     *         so that the value changes only through the setter; EclipseLink does not see a change
     *         made to the elements of a converted array.
     */
    @Nullable
    public float[] getEmbedding() {
        return Optional.ofNullable(embedding).map(float[]::clone).orElse(null);
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMBEDDING} attribute with a copy of the
     * specified value.
     *
     * @param embedding new value for {@value #ATTRIBUTE_NAME_EMBEDDING} attribute.
     */
    public void setEmbedding(@Nullable final float[] embedding) {
        this.embedding = Optional.ofNullable(embedding).map(float[]::clone).orElse(null);
    }

    // ---------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PATIENT_ID,
            nullable = true,
            insertable = true,
            updatable = false
    )
    private Integer patientId;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_NAME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_NAME,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_NAME
    )
    private String name;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_AGE,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer age;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_GENDER)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_GENDER,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_GENDER
    )
    private String gender;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_CHOLESTEROL_LEVEL,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer cholesterolLevel;

    // ---------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_BLOOD_PRESSURE,
            nullable = true,
            insertable = true,
            updatable = true
    )
    private Integer bloodPressure;

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_SMOKING_STATUS)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SMOKING_STATUS,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_SMOKING_STATUS
    )
    private String smokingStatus;

    // ---------------------------------------------------------------------------------------------
    @Size(min = SIZE_EMBEDDING, max = SIZE_EMBEDDING)
    @Convert(converter = VectorStringAttributeConverter.class)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMBEDDING,
            nullable = true,
            insertable = true,
            updatable = true,
            length = COLUMN_DIMENSION_EMBEDDING * 16 + 1 // just for H2
    )
    private float[] embedding;
}
