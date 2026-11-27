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

import com.github.jinahya.db2.sample.database.persistence.mapped.MappedProjact;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/**
 * An entity of the {@value #TABLE_NAME} table, which declares the identifier
 * {@link MappedProjact} leaves out, an {@link EmbeddedId @EmbeddedId} of {@link ProjactId}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 */
@Entity
@Table(name = Projact.TABLE_NAME)
public class Projact
        extends MappedProjact {

    /**
     * The name of the attribute of the identifier, an {@link EmbeddedId @EmbeddedId} of
     * {@link ProjactId}. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ID = "id";

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_PROJNO} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_PROJNO =
            ATTRIBUTE_NAME_ID + "." + ProjactId.ATTRIBUTE_NAME_PROJNO;

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_ACTNO} column. The
     * value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_ACTNO =
            ATTRIBUTE_NAME_ID + "." + ProjactId.ATTRIBUTE_NAME_ACTNO;

    /**
     * The path of the identifier's attribute which maps the {@value #COLUMN_NAME_ACSTDATE} column.
     * The value is {@value}.
     */
    public static final String ATTRIBUTE_PATH_ID_ACSTDATE =
            ATTRIBUTE_NAME_ID + "." + ProjactId.ATTRIBUTE_NAME_ACSTDATE;

    // -------------------------------------------------------------------------------------- PROJNO

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_PROJNO} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_PROJECT = "project";

    // --------------------------------------------------------------------------------------- ACTNO

    /**
     * The name of the attribute which maps the {@value #COLUMN_NAME_ACTNO} column as an
     * association. The value is {@value}.
     */
    public static final String ATTRIBUTE_NAME_ACT = "act";

    // -------------------------------------------------------------------------------- CONSTRUCTORS

    /**
     * Creates a new instance.
     */
    protected Projact() {
        super();
    }

    // ---------------------------------------------------------------------------- java.lang.Object

    @Override
    public String toString() {
        return super.toString() + '{' +
               "id=" + id +
               '}';
    }

    /**
     * {@inheritDoc}
     *
     * @param obj {@inheritDoc}
     * @return {@inheritDoc}
     * @implSpec Equality is by {@value #ATTRIBUTE_NAME_ID}, the identifier.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (!(obj instanceof Projact that)) {
            return false;
        }
        return Objects.equals(getId(), that.getId());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     * @implSpec The hash is over {@value #ATTRIBUTE_NAME_ID}, consistent with
     *         {@link #equals(Object)}.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }

    // ------------------------------------------------------------------------------------------ id

    /**
     * Returns current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     *
     * @return current value of {@value #ATTRIBUTE_NAME_ID} attribute.
     */
    public ProjactId getId() {
        return id;
    }

    // ---------------------------------------------------------------------------------------------

    /**
     * Replaces the activity start date of the identifier with the specified value; an identifier
     * is created when there is none.
     *
     * @param acstdate new value for the activity start date of the identifier.
     */
    protected void setAcstdate(final LocalDate acstdate) {
        id = Optional.ofNullable(id)
                .map(v -> v.withAcstdate(acstdate))
                .orElseGet(() -> ProjactId.from(project, act, acstdate));
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
     * Replaces the project with the specified value.
     *
     * @param project new value for the project.
     * @implNote The association maps the project number of the identifier
     *         ({@link jakarta.persistence.MapsId @MapsId}), which the provider sets from it when
     *         this instance is persisted; this sets it as well, so that the identifier is complete
     *         before then.
     */
    public void setProject(final Project project) {
        this.project = project;
        id = Optional.ofNullable(id)
                .map(v -> v.withProject(this.project))
                .orElseGet(() -> ProjactId.from(this.project, this.act, null));
    }

    // ----------------------------------------------------------------------------------------- act

    /**
     * Returns the activity.
     *
     * @return the activity.
     */
    public Act getAct() {
        return act;
    }

    /**
     * Replaces the activity with the specified value.
     *
     * @param act new value for the activity.
     * @implNote The association maps the activity number of the identifier
     *         ({@link jakarta.persistence.MapsId @MapsId}), which the provider sets from it when
     *         this instance is persisted; this sets it as well, so that the identifier is complete
     *         before then.
     */
    public void setAct(final Act act) {
        this.act = act;
        id = Optional.ofNullable(id)
                .map(v -> v.withAct(this.act))
                .orElseGet(() -> ProjactId.from(this.project, this.act, null));
    }

    // ---------------------------------------------------------------------------------------------
    @Valid
    @NotNull
    @EmbeddedId
    private ProjactId id;

    // ---------------------------------------------------------------------------------------------
    // maps the project number of the identifier, which the provider derives from it
    @Valid
    @NotNull
    @MapsId(ProjactId.ATTRIBUTE_NAME_PROJNO)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Projact.COLUMN_NAME_PROJNO,
                referencedColumnName = Project.COLUMN_NAME_PROJNO,
                nullable = false,
                insertable = true,
                updatable = false
    )
    private Project project;

    // ---------------------------------------------------------------------------------------------
    // the table declares no foreign key on ACTNO; it names an activity, as the column says, and
    // every installed row's does. Maps the activity number of the identifier, which the provider
    // derives from it
    @Valid
    @NotNull
    @MapsId(ProjactId.ATTRIBUTE_NAME_ACTNO)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = Projact.COLUMN_NAME_ACTNO,
                referencedColumnName = Act.COLUMN_NAME_ACTNO,
                nullable = false,
                insertable = true,
                updatable = false
    )
    private Act act;
}
