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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedVstafac1;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The identifier of the {@value MappedVstafac1#TABLE_NAME} view, the key of
 * {@value MappedVstafac1#COLUMN_NAME_PROJNO}, {@value MappedVstafac1#COLUMN_NAME_ACTNO},
 * {@value MappedVstafac1#COLUMN_NAME_STDATE}.
 * <p>
 * It is an {@link Embeddable @Embeddable}, so that an entity extending {@link MappedVstafac1} may
 * name it either with {@link jakarta.persistence.IdClass @IdClass}, whose attributes have the names
 * and the types of the {@link jakarta.persistence.Id @Id} attributes there, or as the type of an
 * {@link jakarta.persistence.EmbeddedId @EmbeddedId}, which the column mappings here serve.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see MappedVstafac1
 */
@Embeddable
public class Vstafac1Id {

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the attribute which maps the {@value MappedVstafac1#COLUMN_NAME_PROJNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJNO = "projno";

    // --------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the attribute which maps the {@value MappedVstafac1#COLUMN_NAME_ACTNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACTNO = "actno";

    // -------------------------------------------------------------------------------------- STDATE

    /**
     * The name of the attribute which maps the {@value MappedVstafac1#COLUMN_NAME_STDATE} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_STDATE = "stdate";

    // ---------------------------------------------------------------------- STATIC_FACTORY_METHODS

    /**
     * Returns a new instance with the specified values.
     *
     * @param projno a value for the {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     * @param actno  a value for the {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     * @param stdate a value for the {@value #ATTRIBUTE_NAME_STDATE} attribute.
     * @return a new instance with the specified values.
     */
    public static Vstafac1Id of(final String projno, final Integer actno, final LocalDate stdate) {
        final var instance = new Vstafac1Id();
        instance.setProjno(projno);
        instance.setActno(actno);
        instance.setStdate(stdate);
        return instance;
    }

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    public Vstafac1Id() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "projno=" + projno +
               ",actno=" + actno +
               ",stdate=" + stdate +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_PROJNO} and
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_STDATE}.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Vstafac1Id that)) {
            return false;
        }
        return Objects.equals(getProjno(), that.getProjno())
               && Objects.equals(getActno(), that.getActno())
               && Objects.equals(getStdate(), that.getStdate());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_PROJNO} and
     *         {@value #ATTRIBUTE_NAME_ACTNO} and {@value #ATTRIBUTE_NAME_STDATE}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getProjno(), getActno(), getStdate());
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

    // -------------------------------------------------------------------------------------- stdate

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_STDATE} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_STDATE} attribute.
     */
    public LocalDate getStdate() {
        return stdate;
    }

    /**
     * Replaces current value of {@value #ATTRIBUTE_NAME_STDATE} attribute with the specified
     * value.
     *
     * @param stdate new value for {@value #ATTRIBUTE_NAME_STDATE} attribute.
     */
    protected void setStdate(final LocalDate stdate) {
        this.stdate = stdate;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_PROJNO} attribute.
     */
    @Size(max = MappedVstafac1.SIZE_MAX_PROJNO)
    @NotNull
    @Column(name = MappedVstafac1.COLUMN_NAME_PROJNO,
            nullable = false,
            insertable = true,
            updatable = false,
            length = MappedVstafac1.COLUMN_LENGTH_PROJNO
    )
    private String projno;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_ACTNO} attribute.
     */
    @Max(Db2Constants.SMALLINT_MAX)
    @Min(Db2Constants.SMALLINT_MIN)
    @NotNull
    @Column(name = MappedVstafac1.COLUMN_NAME_ACTNO,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private Integer actno;

    // ---------------------------------------------------------------------------------------------

    /**
     * The value of the {@value #ATTRIBUTE_NAME_STDATE} attribute.
     */
    @NotNull
    @Column(name = MappedVstafac1.COLUMN_NAME_STDATE,
            nullable = false,
            insertable = true,
            updatable = false
    )
    private LocalDate stdate;
}
