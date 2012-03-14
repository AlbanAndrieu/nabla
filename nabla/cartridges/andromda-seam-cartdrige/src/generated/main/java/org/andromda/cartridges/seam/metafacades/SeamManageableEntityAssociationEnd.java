// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface SeamManageableEntityAssociationEnd
    extends ManageableEntityAssociationEnd
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isSeamManageableEntityAssociationEndMetaType();

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
     * True if this parameter has a name that can properly be handled by Jakarta commons (this lib
     * is used by Struts but contains a bug)
     * @return boolean
     */
    public boolean isSafeNamePresent();
}