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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedProjAct;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/**
 * An entity of the {@value #TABLE_NAME} table, which declares the identifier {@link MappedProjAct}
 * leaves out, with {@link ProjActId} as its {@link IdClass @IdClass}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@IdClass(ProjActId.class)
@Table(name = ProjAct.TABLE_NAME)
public class ProjAct
        extends MappedProjAct {

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJNO} column, a part of the
     * identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNO = ProjActId.ATTRIBUTE_NAME_PROJNO;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACTNO} column, a part of the
     * identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = ProjActId.ATTRIBUTE_NAME_ACTNO;

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACSTDATE} column, a part of the
     * identifier. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACSTDATE = ProjActId.ATTRIBUTE_NAME_ACSTDATE;

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected ProjAct() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "projno=" + projno +
               ",actno=" + actno +
               ",acstdate=" + acstdate +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PROJNO} and
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_ACSTDATE}, the
     *         identifier.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof ProjAct that)) {
            return false;
        }
        return Objects.equals(getProjno(), that.getProjno())
               && Objects.equals(getActno(), that.getActno())
               && Objects.equals(getAcstdate(), that.getAcstdate());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PROJNO} and
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_ACSTDATE}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getProjno(), getActno(), getAcstdate());
    }
    // -------------------------------------------------------------------------------------- projno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     */
    public String getProjno() {
        return projno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_PROJNO} attribute with the specified
     * value.
     *
     * @param projno new value for {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     * @apiNote This method is not public: the column is written through
     *         {@link #setProject(Project)}, which calls this.
     */
    protected void setProjno(final String projno) {
        this.projno = projno;
    }

    // --------------------------------------------------------------------------------------- actno

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    public Integer getActno() {
        return actno;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACTNO} attribute with the specified value.
     *
     * @param actno new value for {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    public void setActno(final Integer actno) {
        this.actno = actno;
    }

    // ------------------------------------------------------------------------------------ acstdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     */
    public LocalDate getAcstdate() {
        return acstdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_ACSTDATE} attribute with the specified
     * value.
     *
     * @param acstdate new value for {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     */
    public void setAcstdate(final LocalDate acstdate) {
        this.acstdate = acstdate;
    }

    // ------------------------------------------------------------------------------------- project

    /**
     * Returns the project.
     *
     * @return the project.
     */
    public Project getProject() {
        return project;
    }

    /**
     * Replaces the project with the specified value, and the {@value #ATTRIBUTE_NAME_PROJNO}
     * attribute, the part of the identifier which writes the same column, with its project number.
     *
     * @param project new value for the project.
     */
    public void setProject(final Project project) {
        this.project = project;
        setProjno(Optional.ofNullable(project).map(Project::getProjno).orElse(null));
    }

    // ---------------------------------------------------------------------------------------------
    @Size(max = SIZE_MAX_PROJNO)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_PROJNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = COLUMN_LENGTH_PROJNO
    )
    private String projno;

    // ---------------------------------------------------------------------------------------------
    @Max(Db2Constants.SMALLINT_MAX)
    @Min(Db2Constants.SMALLINT_MIN)
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACTNO,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Integer actno;

    // ---------------------------------------------------------------------------------------------
    @NotNull
    @Id
    @Basic(optional = false, fetch = FetchType.EAGER)
    @Column(name = COLUMN_NAME_ACSTDATE,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private LocalDate acstdate;

    // ---------------------------------------------------------------------------------------------
    // read-only: the column(s) are part of the identifier, which the superclass writes
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = ProjAct.COLUMN_NAME_PROJNO,
                referencedColumnName = Project.COLUMN_NAME_PROJNO,
                nullable = false,
                insertable = false,
                updatable = false)
    private Project project;
}
