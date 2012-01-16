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
public interface ManageableEntityAttribute
    extends EntityAttribute
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isManageableEntityAttributeMetaType();

    /**
     * Whether or not this attribute should be displayed.
     * @return boolean
     */
    public boolean isDisplay();

    /**
     * Whether or not this attribute can be read in a call isolated from the rest (for example when
     * downloading binary fields).
     * @return boolean
     */
    public boolean isManageableGetterAvailable();
}