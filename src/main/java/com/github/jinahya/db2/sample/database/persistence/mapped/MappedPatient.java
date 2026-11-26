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

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedPatient#TABLE_NAME} table, the
 * patients.
 * <p>
 * <strong>The table declares no primary key.</strong> The column
 * {@value MappedPatient#COLUMN_NAME_PATIENT_ID}, unique and not {@code null} in every row the
 * sample database is created with, is mapped as the identifier, which an entity needs; nothing in
 * the database keeps that so.
 * <p>
 * The {@code EMBEDDING} column is not mapped; it is a VECTOR, for which Jakarta Persistence has no
 * mapping.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedPatient {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "PATIENTS";

    // ------------------------------------------------------------------------------------------------------ PATIENT_ID

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PATIENT_ID} attribute maps.
     * The value is {@value}.
     */
    public static final String COLUMN_NAME_PATIENT_ID = "PATIENT_ID";

    /**
     * Whether the {@value #COLUMN_NAME_PATIENT_ID} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PATIENT_ID = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PATIENT_ID} column. The value
     * is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PATIENT_ID = "patientId";

    // ------------------------------------------------------------------------------------------------------------ NAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_NAME} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_NAME = "NAME";

    /**
     * Whether the {@value #COLUMN_NAME_NAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_NAME = true;

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

    // ------------------------------------------------------------------------------------------------------------- AGE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_AGE} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_AGE = "AGE";

    /**
     * Whether the {@value #COLUMN_NAME_AGE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_AGE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_AGE} column. The value is
     * {@value}.
     */
    public static final String ATTRIBUTE_NAME_AGE = "age";

    // ---------------------------------------------------------------------------------------------------------- GENDER

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_GENDER} attribute maps. The
     * value is {@value}.
     */
    public static final String COLUMN_NAME_GENDER = "GENDER";

    /**
     * Whether the {@value #COLUMN_NAME_GENDER} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_GENDER = true;

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

    // ----------------------------------------------------------------------------------------------- CHOLESTEROL_LEVEL

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_CHOLESTEROL_LEVEL}
     * attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_CHOLESTEROL_LEVEL = "CHOLESTEROL_LEVEL";

    /**
     * Whether the {@value #COLUMN_NAME_CHOLESTEROL_LEVEL} column is nullable. The value is
     * {@value}.
     */
    public static final boolean COLUMN_NULLABLE_CHOLESTEROL_LEVEL = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_CHOLESTEROL_LEVEL} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_CHOLESTEROL_LEVEL = "cholesterolLevel";

    // -------------------------------------------------------------------------------------------------- BLOOD_PRESSURE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_BLOOD_PRESSURE} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_BLOOD_PRESSURE = "BLOOD_PRESSURE";

    /**
     * Whether the {@value #COLUMN_NAME_BLOOD_PRESSURE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_BLOOD_PRESSURE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_BLOOD_PRESSURE} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_BLOOD_PRESSURE = "bloodPressure";

    // -------------------------------------------------------------------------------------------------- SMOKING_STATUS

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SMOKING_STATUS} attribute
     * maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_SMOKING_STATUS = "SMOKING_STATUS";

    /**
     * Whether the {@value #COLUMN_NAME_SMOKING_STATUS} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SMOKING_STATUS = true;

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

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedPatient() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

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

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PATIENT_ID} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedPatient that)) {
            return false;
        }
        return Objects.equals(getPatientId(), that.getPatientId());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PATIENT_ID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getPatientId());
    }

    // ------------------------------------------------------------------------------------------------------- patientId

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

    // ------------------------------------------------------------------------------------------------------------ name

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

    // ------------------------------------------------------------------------------------------------------------- age

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

    // ---------------------------------------------------------------------------------------------------------- gender

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

    // ------------------------------------------------------------------------------------------------ cholesterolLevel

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

    // --------------------------------------------------------------------------------------------------- bloodPressure

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

    // --------------------------------------------------------------------------------------------------- smokingStatus

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

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PATIENT_ID,
            nullable = COLUMN_NULLABLE_PATIENT_ID,
            insertable = true,
            updatable = false
    )
    private Integer patientId;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_NAME)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_NAME,
            nullable = COLUMN_NULLABLE_NAME,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_NAME
    )
    private String name;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_AGE,
            nullable = COLUMN_NULLABLE_AGE,
            insertable = true,
            updatable = true
    )
    private Integer age;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_GENDER)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_GENDER,
            nullable = COLUMN_NULLABLE_GENDER,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_GENDER
    )
    private String gender;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_CHOLESTEROL_LEVEL,
            nullable = COLUMN_NULLABLE_CHOLESTEROL_LEVEL,
            insertable = true,
            updatable = true
    )
    private Integer cholesterolLevel;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_BLOOD_PRESSURE,
            nullable = COLUMN_NULLABLE_BLOOD_PRESSURE,
            insertable = true,
            updatable = true
    )
    private Integer bloodPressure;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_SMOKING_STATUS)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SMOKING_STATUS,
            nullable = COLUMN_NULLABLE_SMOKING_STATUS,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_SMOKING_STATUS
    )
    private String smokingStatus;
}
