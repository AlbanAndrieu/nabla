// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ManageableEntityAssociationEnd
    extends EntityAssociationEnd
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isManageableEntityAssociationEndMetaType();

    /**
     * 
     * @return EntityAttribute
     */
    public EntityAttribute getManageableIdentifier();

    /**
     * Whether or not this association end should be displayed.
     * @return boolean
     */
    public boolean isDisplay();
}