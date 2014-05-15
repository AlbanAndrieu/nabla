// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.ClassifierFacade;

/**
 * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiSessionObject
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiSessionObject
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiSessionObjectMetaType();

    /**
     * The full path to the session object class file (comparable to the package name).
     * @return String
     */
    public String getFullPath();
}