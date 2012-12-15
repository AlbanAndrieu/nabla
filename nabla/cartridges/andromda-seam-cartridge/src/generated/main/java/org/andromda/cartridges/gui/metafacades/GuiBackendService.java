// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.Service;

/**
 * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiBackendService
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiBackendService
    extends Service
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiBackendServiceMetaType();

    /**
     * The implementation to use in a controller template in order to get an instance of this
     * service.
     * @return String
     */
    public String getAccessorImplementation();
}