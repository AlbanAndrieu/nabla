// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.database.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.EntityAssociation;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface AssociationTable
    extends EntityAssociation
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isAssociationTableMetaType();

    /**
     * The foreign-key columns that are part of this association table.
     * @return Collection<ForeignKeyColumn>
     */
    public Collection<ForeignKeyColumn> getForeignKeyColumns();

    /**
     * A comma seperated list of primary key columns.
     * @return String
     */
    public String getPrimaryKeyColumns();

    /**
     * The name of the primary key constraint for this table.
     * @return String
     */
    public String getPrimaryKeyConstraintName();

    /**
     * Are there foreign key columns present in this table?
     * @return boolean
     */
    public boolean isForeignKeyColumnsPresent();
}