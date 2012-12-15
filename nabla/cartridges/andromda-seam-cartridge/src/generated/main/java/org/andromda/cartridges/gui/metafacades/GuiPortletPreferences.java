// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.ClassifierFacade;

/**
 * Represents the portlet preferences for a given use case (assuming the JSF application being
 * generated is a portlet).
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiPortletPreferences
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiPortletPreferencesMetaType();

    /**
     * A Gui use-case represents a set of related client/server requests and communication.
     * @return GuiUseCase
     */
    public GuiUseCase getUseCase();
}