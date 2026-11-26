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
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The identifier of the {@value MappedProjAct#TABLE_NAME} table, the key of
 * {@value MappedProjAct#COLUMN_NAME_PROJNO}, {@value MappedProjAct#COLUMN_NAME_ACTNO},
 * {@value MappedProjAct#COLUMN_NAME_ACSTDATE}.
 * <p>
 * It is an {@link Embeddable @Embeddable}, so that an entity extending {@link MappedProjAct} may
 * name it either with {@link jakarta.persistence.IdClass @IdClass}, whose attributes have the names
 * and the types of the {@link jakarta.persistence.Id @Id} attributes there, or as the type of an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId}, which the column mappings here serve.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedProjAct
 */
@Embeddable
public class ProjActId {

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the attribute which maps the {@value MappedProjAct#COLUMN_NAME_PROJNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNO = "projno";

    // --------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the attribute which maps the {@value MappedProjAct#COLUMN_NAME_ACTNO} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = "actno";

    // ------------------------------------------------------------------------------------ ACSTDATE

    /**
     * The name of the attribute which maps the {@value MappedProjAct#COLUMN_NAME_ACSTDATE} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACSTDATE = "acstdate";

    // ---------------------------------------------------------------------- STATIC_FACTORY_METHODS

    /**
     * Returns a new instance with the specified values.
     *
     * @param projno   a value for the {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     * @param actno    a value for the {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     * @param acstdate a value for the {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     * @return a new instance with the specified values.
     */
    public static ProjActId of(final String projno, final Integer actno, final LocalDate acstdate) {
        final var instance = new ProjActId();
        instance.setProjno(projno);
        instance.setActno(actno);
        instance.setAcstdate(acstdate);
        return instance;
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public ProjActId() {
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
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_ACSTDATE}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof ProjActId that)) {
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
    protected void setActno(final Integer actno) {
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
    protected void setAcstdate(final LocalDate acstdate) {
        this.acstdate = acstdate;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     */
    @Size(max = MappedProjAct.SIZE_MAX_PROJNO)
    @NotNull
    @Column(name = MappedProjAct.COLUMN_NAME_PROJNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedProjAct.COLUMN_LENGTH_PROJNO
    )
    private String projno;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    @Max(Db2Constants.SMALLINT_MAX)
    @Min(Db2Constants.SMALLINT_MIN)
    @NotNull
    @Column(name = MappedProjAct.COLUMN_NAME_ACTNO,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Integer actno;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_ACSTDATE} attribute.
     */
    @NotNull
    @Column(name = MappedProjAct.COLUMN_NAME_ACSTDATE,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private LocalDate acstdate;
}
