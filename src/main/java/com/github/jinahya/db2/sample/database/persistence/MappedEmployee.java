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

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A mapped superclass which holds the mappings of the {@value MappedEmployee#TABLE_NAME} table, the employees.
 * <p>
 * The foreign key column {@value MappedEmployee#COLUMN_NAME_WORKDEPT} is mapped read-only ({@code insertable = false,
 * updatable = false}), with a {@code protected} getter and no setter, for {@link #toString()} and for queries. How the
 * relationship behind it is mapped is the extending entity's decision, so the extending entity also owns the writable
 * mapping, by an association's {@link jakarta.persistence.JoinColumn @JoinColumn}. <strong>An extending entity which
 * maps it not never writes it.</strong> For the same reason it is constrained {@code NotNull} here, even where the
 * column is {@code NOT NULL}: the attribute stays {@code null} until a load, and the association is what is
 * constrained.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@MappedSuperclass
public abstract class MappedEmployee {

    /**
     * The name of the database table to which this class maps. The value is {@value}.
     */
    public static final String TABLE_NAME = "EMPLOYEE";

    // ----------------------------------------------------------------------------------------------------------- EMPNO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EMPNO} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_EMPNO = "EMPNO";

    /**
     * Whether the {@value #COLUMN_NAME_EMPNO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EMPNO = false;

    /**
     * The length of the {@value #COLUMN_NAME_EMPNO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_EMPNO = 6;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EMPNO} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EMPNO = "empno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_EMPNO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_EMPNO = COLUMN_LENGTH_EMPNO;

    // -------------------------------------------------------------------------------------------------------- FIRSTNME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_FIRSTNME} attribute maps. The value is
     * {@value}.
     */
    public static final String COLUMN_NAME_FIRSTNME = "FIRSTNME";

    /**
     * Whether the {@value #COLUMN_NAME_FIRSTNME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_FIRSTNME = false;

    /**
     * The length of the {@value #COLUMN_NAME_FIRSTNME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_FIRSTNME = 12;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_FIRSTNME} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_FIRSTNME = "firstnme";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_FIRSTNME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_FIRSTNME = COLUMN_LENGTH_FIRSTNME;

    // --------------------------------------------------------------------------------------------------------- MIDINIT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_MIDINIT} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_MIDINIT = "MIDINIT";

    /**
     * Whether the {@value #COLUMN_NAME_MIDINIT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_MIDINIT = true;

    /**
     * The length of the {@value #COLUMN_NAME_MIDINIT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_MIDINIT = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_MIDINIT} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_MIDINIT = "midinit";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_MIDINIT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_MIDINIT = COLUMN_LENGTH_MIDINIT;

    // -------------------------------------------------------------------------------------------------------- LASTNAME

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_LASTNAME} attribute maps. The value is
     * {@value}.
     */
    public static final String COLUMN_NAME_LASTNAME = "LASTNAME";

    /**
     * Whether the {@value #COLUMN_NAME_LASTNAME} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_LASTNAME = false;

    /**
     * The length of the {@value #COLUMN_NAME_LASTNAME} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_LASTNAME = 15;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_LASTNAME} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_LASTNAME = "lastname";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_LASTNAME} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_LASTNAME = COLUMN_LENGTH_LASTNAME;

    // -------------------------------------------------------------------------------------------------------- WORKDEPT

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_WORKDEPT} attribute maps. The value is
     * {@value}.
     */
    public static final String COLUMN_NAME_WORKDEPT = "WORKDEPT";

    /**
     * Whether the {@value #COLUMN_NAME_WORKDEPT} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_WORKDEPT = true;

    /**
     * The length of the {@value #COLUMN_NAME_WORKDEPT} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_WORKDEPT = 3;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_WORKDEPT} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_WORKDEPT = "workdept";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_WORKDEPT} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_WORKDEPT = COLUMN_LENGTH_WORKDEPT;

    // --------------------------------------------------------------------------------------------------------- PHONENO

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_PHONENO} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_PHONENO = "PHONENO";

    /**
     * Whether the {@value #COLUMN_NAME_PHONENO} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_PHONENO = true;

    /**
     * The length of the {@value #COLUMN_NAME_PHONENO} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_PHONENO = 4;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PHONENO} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PHONENO = "phoneno";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_PHONENO} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_PHONENO = COLUMN_LENGTH_PHONENO;

    // -------------------------------------------------------------------------------------------------------- HIREDATE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_HIREDATE} attribute maps. The value is
     * {@value}.
     */
    public static final String COLUMN_NAME_HIREDATE = "HIREDATE";

    /**
     * Whether the {@value #COLUMN_NAME_HIREDATE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_HIREDATE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_HIREDATE} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_HIREDATE = "hiredate";

    // ------------------------------------------------------------------------------------------------------------- JOB

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_JOB} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_JOB = "JOB";

    /**
     * Whether the {@value #COLUMN_NAME_JOB} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_JOB = true;

    /**
     * The length of the {@value #COLUMN_NAME_JOB} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_JOB = 8;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_JOB} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_JOB = "job";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_JOB} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_JOB = COLUMN_LENGTH_JOB;

    // --------------------------------------------------------------------------------------------------------- EDLEVEL

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_EDLEVEL} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_EDLEVEL = "EDLEVEL";

    /**
     * Whether the {@value #COLUMN_NAME_EDLEVEL} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_EDLEVEL = false;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_EDLEVEL} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_EDLEVEL = "edlevel";

    // ------------------------------------------------------------------------------------------------------------- SEX

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SEX} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_SEX = "SEX";

    /**
     * Whether the {@value #COLUMN_NAME_SEX} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SEX = true;

    /**
     * The length of the {@value #COLUMN_NAME_SEX} column. The value is {@value}.
     */
    public static final int COLUMN_LENGTH_SEX = 1;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SEX} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_SEX = "sex";

    /**
     * The maximum size of the {@value #ATTRIBUTE_NAME_SEX} attribute. The value is {@value}.
     */
    public static final int SIZE_MAX_SEX = COLUMN_LENGTH_SEX;

    // ------------------------------------------------------------------------------------------------------- BIRTHDATE

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_BIRTHDATE} attribute maps. The value is
     * {@value}.
     */
    public static final String COLUMN_NAME_BIRTHDATE = "BIRTHDATE";

    /**
     * Whether the {@value #COLUMN_NAME_BIRTHDATE} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_BIRTHDATE = true;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_BIRTHDATE} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_BIRTHDATE = "birthdate";

    // ---------------------------------------------------------------------------------------------------------- SALARY

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_SALARY} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_SALARY = "SALARY";

    /**
     * Whether the {@value #COLUMN_NAME_SALARY} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_SALARY = true;

    /**
     * The precision of the {@value #COLUMN_NAME_SALARY} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_SALARY = 9;

    /**
     * The scale of the {@value #COLUMN_NAME_SALARY} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_SALARY = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_SALARY} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_SALARY = "salary";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_SALARY} attribute. The value is {@value}.
     */
    public static final int DIGITS_INTEGER_SALARY = COLUMN_PRECISION_SALARY - COLUMN_SCALE_SALARY;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_SALARY} attribute. The value is {@value}.
     */
    public static final int DIGITS_FRACTION_SALARY = COLUMN_SCALE_SALARY;

    // ----------------------------------------------------------------------------------------------------------- BONUS

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_BONUS} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_BONUS = "BONUS";

    /**
     * Whether the {@value #COLUMN_NAME_BONUS} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_BONUS = true;

    /**
     * The precision of the {@value #COLUMN_NAME_BONUS} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_BONUS = 9;

    /**
     * The scale of the {@value #COLUMN_NAME_BONUS} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_BONUS = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_BONUS} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_BONUS = "bonus";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_BONUS} attribute. The value is {@value}.
     */
    public static final int DIGITS_INTEGER_BONUS = COLUMN_PRECISION_BONUS - COLUMN_SCALE_BONUS;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_BONUS} attribute. The value is {@value}.
     */
    public static final int DIGITS_FRACTION_BONUS = COLUMN_SCALE_BONUS;

    // ------------------------------------------------------------------------------------------------------------ COMM

    /**
     * The name of the table column to which the {@value #ATTRIBUTE_NAME_COMM} attribute maps. The value is {@value}.
     */
    public static final String COLUMN_NAME_COMM = "COMM";

    /**
     * Whether the {@value #COLUMN_NAME_COMM} column is nullable. The value is {@value}.
     */
    public static final boolean COLUMN_NULLABLE_COMM = true;

    /**
     * The precision of the {@value #COLUMN_NAME_COMM} column. The value is {@value}.
     */
    public static final int COLUMN_PRECISION_COMM = 9;

    /**
     * The scale of the {@value #COLUMN_NAME_COMM} column. The value is {@value}.
     */
    public static final int COLUMN_SCALE_COMM = 2;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_COMM} column. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_COMM = "comm";

    /**
     * The maximum number of integral digits of the {@value #ATTRIBUTE_NAME_COMM} attribute. The value is {@value}.
     */
    public static final int DIGITS_INTEGER_COMM = COLUMN_PRECISION_COMM - COLUMN_SCALE_COMM;

    /**
     * The maximum number of fractional digits of the {@value #ATTRIBUTE_NAME_COMM} attribute. The value is {@value}.
     */
    public static final int DIGITS_FRACTION_COMM = COLUMN_SCALE_COMM;

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected MappedEmployee() {
        super();
    }

    // ------------------------------------------------------------------------------------------------ java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "empno=" + empno +
               ",firstnme=" + firstnme +
               ",midinit=" + midinit +
               ",lastname=" + lastname +
               ",workdept=" + workdept +
               ",phoneno=" + phoneno +
               ",hiredate=" + hiredate +
               ",job=" + job +
               ",edlevel=" + edlevel +
               ",sex=" + sex +
               ",birthdate=" + birthdate +
               ",salary=" + salary +
               ",bonus=" + bonus +
               ",comm=" + comm +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_EMPNO} alone.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof MappedEmployee that)) {
            return false;
        }
        return Objects.equals(getEmpno(), that.getEmpno());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_EMPNO}, consistent with {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getEmpno());
    }

    // ----------------------------------------------------------------------------------------------------------- empno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    @Nonnull
    public String getEmpno() {
        return empno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EMPNO} attribute with the specified value.
     *
     * @param empno new value for {@value #ATTRIBUTE_NAME_EMPNO} attribute.
     */
    protected void setEmpno(@Nonnull final String empno) {
        this.empno = empno;
    }

    // -------------------------------------------------------------------------------------------------------- firstnme

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     */
    @Nonnull
    public String getFirstnme() {
        return firstnme;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_FIRSTNME} attribute with the specified value.
     *
     * @param firstnme new value for {@value #ATTRIBUTE_NAME_FIRSTNME} attribute.
     */
    public void setFirstnme(@Nonnull final String firstnme) {
        this.firstnme = firstnme;
    }

    // --------------------------------------------------------------------------------------------------------- midinit

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     */
    @Nullable
    public String getMidinit() {
        return midinit;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_MIDINIT} attribute with the specified value.
     *
     * @param midinit new value for {@value #ATTRIBUTE_NAME_MIDINIT} attribute.
     */
    public void setMidinit(@Nullable final String midinit) {
        this.midinit = midinit;
    }

    // -------------------------------------------------------------------------------------------------------- lastname

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     */
    @Nonnull
    public String getLastname() {
        return lastname;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_LASTNAME} attribute with the specified value.
     *
     * @param lastname new value for {@value #ATTRIBUTE_NAME_LASTNAME} attribute.
     */
    public void setLastname(@Nonnull final String lastname) {
        this.lastname = lastname;
    }

    // -------------------------------------------------------------------------------------------------------- workdept

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_WORKDEPT} attribute, which is {@code null} until this instance
     * is loaded.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_WORKDEPT} attribute.
     * @apiNote This method is {@code protected}, not package-private, so that a lazy proxy, which is a subclass in
     * another package, can override it.
     */
    @Nullable
    protected String getWorkdept() {
        return workdept;
    }

    // --------------------------------------------------------------------------------------------------------- phoneno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PHONENO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PHONENO} attribute.
     */
    @Nullable
    public String getPhoneno() {
        return phoneno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PHONENO} attribute with the specified value.
     *
     * @param phoneno new value for {@value #ATTRIBUTE_NAME_PHONENO} attribute.
     */
    public void setPhoneno(@Nullable final String phoneno) {
        this.phoneno = phoneno;
    }

    // -------------------------------------------------------------------------------------------------------- hiredate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_HIREDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_HIREDATE} attribute.
     */
    @Nullable
    public LocalDate getHiredate() {
        return hiredate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_HIREDATE} attribute with the specified value.
     *
     * @param hiredate new value for {@value #ATTRIBUTE_NAME_HIREDATE} attribute.
     */
    public void setHiredate(@Nullable final LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    // ------------------------------------------------------------------------------------------------------------- job

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_JOB} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_JOB} attribute.
     */
    @Nullable
    public String getJob() {
        return job;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_JOB} attribute with the specified value.
     *
     * @param job new value for {@value #ATTRIBUTE_NAME_JOB} attribute.
     */
    public void setJob(@Nullable final String job) {
        this.job = job;
    }

    // --------------------------------------------------------------------------------------------------------- edlevel

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_EDLEVEL} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_EDLEVEL} attribute.
     */
    @Nonnull
    public Short getEdlevel() {
        return edlevel;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_EDLEVEL} attribute with the specified value.
     *
     * @param edlevel new value for {@value #ATTRIBUTE_NAME_EDLEVEL} attribute.
     */
    public void setEdlevel(@Nonnull final Short edlevel) {
        this.edlevel = edlevel;
    }

    // ------------------------------------------------------------------------------------------------------------- sex

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SEX} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SEX} attribute.
     */
    @Nullable
    public String getSex() {
        return sex;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SEX} attribute with the specified value.
     *
     * @param sex new value for {@value #ATTRIBUTE_NAME_SEX} attribute.
     */
    public void setSex(@Nullable final String sex) {
        this.sex = sex;
    }

    // ------------------------------------------------------------------------------------------------------- birthdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_BIRTHDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_BIRTHDATE} attribute.
     */
    @Nullable
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_BIRTHDATE} attribute with the specified value.
     *
     * @param birthdate new value for {@value #ATTRIBUTE_NAME_BIRTHDATE} attribute.
     */
    public void setBirthdate(@Nullable final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    // ---------------------------------------------------------------------------------------------------------- salary

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_SALARY} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_SALARY} attribute.
     */
    @Nullable
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_SALARY} attribute with the specified value.
     *
     * @param salary new value for {@value #ATTRIBUTE_NAME_SALARY} attribute.
     */
    public void setSalary(@Nullable final BigDecimal salary) {
        this.salary = salary;
    }

    // ----------------------------------------------------------------------------------------------------------- bonus

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_BONUS} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_BONUS} attribute.
     */
    @Nullable
    public BigDecimal getBonus() {
        return bonus;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_BONUS} attribute with the specified value.
     *
     * @param bonus new value for {@value #ATTRIBUTE_NAME_BONUS} attribute.
     */
    public void setBonus(@Nullable final BigDecimal bonus) {
        this.bonus = bonus;
    }

    // ------------------------------------------------------------------------------------------------------------ comm

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_COMM} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_COMM} attribute.
     */
    @Nullable
    public BigDecimal getComm() {
        return comm;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_COMM} attribute with the specified value.
     *
     * @param comm new value for {@value #ATTRIBUTE_NAME_COMM} attribute.
     */
    public void setComm(@Nullable final BigDecimal comm) {
        this.comm = comm;
    }

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_EMPNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EMPNO,
            nullable = COLUMN_NULLABLE_EMPNO,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_EMPNO
    )
    private String empno;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_FIRSTNME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_FIRSTNME,
            nullable = COLUMN_NULLABLE_FIRSTNME,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_FIRSTNME
    )
    private String firstnme;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_MIDINIT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_MIDINIT,
            nullable = COLUMN_NULLABLE_MIDINIT,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_MIDINIT
    )
    private String midinit;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @Size(max = SIZE_MAX_LASTNAME)
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_LASTNAME,
            nullable = COLUMN_NULLABLE_LASTNAME,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_LASTNAME
    )
    private String lastname;

    // -----------------------------------------------------------------------------------------------------------------
    // read-only: the extending entity owns the writable mapping of this column; see the class documentation
    @Size(max = SIZE_MAX_WORKDEPT)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_WORKDEPT,
            nullable = COLUMN_NULLABLE_WORKDEPT,
            insertable = false,
            updatable = false,
            length = COLUMN_LENGTH_WORKDEPT
    )
    private String workdept;

    // -----------------------------------------------------------------------------------------------------------------
    // the table's NUMBER check constraint: PHONENO >= '0000' AND PHONENO <= '9999'
    @Size(max = SIZE_MAX_PHONENO)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PHONENO,
            nullable = COLUMN_NULLABLE_PHONENO,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_PHONENO
    )
    private String phoneno;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_HIREDATE,
            nullable = COLUMN_NULLABLE_HIREDATE,
            insertable = true,
            updatable = true
    )
    private LocalDate hiredate;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_JOB)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_JOB,
            nullable = COLUMN_NULLABLE_JOB,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_JOB
    )
    private String job;

    // -----------------------------------------------------------------------------------------------------------------
    @Nonnull
    @NotNull
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_EDLEVEL,
            nullable = COLUMN_NULLABLE_EDLEVEL,
            insertable = true,
            updatable = true
    )
    private Short edlevel;

    // -----------------------------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_SEX)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SEX,
            nullable = COLUMN_NULLABLE_SEX,
            insertable = true,
            updatable = true,
            length = COLUMN_LENGTH_SEX
    )
    private String sex;

    // -----------------------------------------------------------------------------------------------------------------
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_BIRTHDATE,
            nullable = COLUMN_NULLABLE_BIRTHDATE,
            insertable = true,
            updatable = true
    )
    private LocalDate birthdate;

    // -----------------------------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_SALARY, fraction = DIGITS_FRACTION_SALARY)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_SALARY,
            nullable = COLUMN_NULLABLE_SALARY,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_SALARY,
            scale = COLUMN_SCALE_SALARY
    )
    private BigDecimal salary;

    // -----------------------------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_BONUS, fraction = DIGITS_FRACTION_BONUS)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_BONUS,
            nullable = COLUMN_NULLABLE_BONUS,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_BONUS,
            scale = COLUMN_SCALE_BONUS
    )
    private BigDecimal bonus;

    // -----------------------------------------------------------------------------------------------------------------
    @Digits(integer = DIGITS_INTEGER_COMM, fraction = DIGITS_FRACTION_COMM)
    @Basic(optional = true, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_COMM,
            nullable = COLUMN_NULLABLE_COMM,
            insertable = true,
            updatable = true,
            precision = COLUMN_PRECISION_COMM,
            scale = COLUMN_SCALE_COMM
    )
    private BigDecimal comm;
}
