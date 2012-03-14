// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.jsf2.metafacades;

import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface JSFManageableEntityAssociationEnd
    extends ManageableEntityAssociationEnd
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isJSFManageableEntityAssociationEndMetaType();

    /**
     * 
     * @return String
     */
    public String getBackingListName();

    /**
     * 
     * @return String
     */
    public String getLabelListName();

    /**
     * 
     * @return String
     */
    public String getMessageKey();

    /**
     * 
     * @return String
     */
    public String getMessageValue();

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return String
     */
    public String getOnlineHelpKey();

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return String
     */
    public String getOnlineHelpValue();

    /**
     * 
     * @return String
     */
    public String getValueListName();
}