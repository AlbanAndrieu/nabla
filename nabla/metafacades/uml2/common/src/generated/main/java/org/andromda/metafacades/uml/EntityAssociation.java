// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Represents an association between entities.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EntityAssociation
    extends AssociationFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEntityAssociationMetaType();

    /**
     * The name of the schema that contains the database table
     * @return String
     */
    public String getSchema();

    /**
     * The name of the table if this is a many-to-many association.  Otherwise it just returns null
     * if not part of a many-to-many association.
     * @return String
     */
    public String getTableName();

    /**
     * is this an EntityAssociation?
     * @return boolean
     */
    public boolean isEntityAssociation();
}