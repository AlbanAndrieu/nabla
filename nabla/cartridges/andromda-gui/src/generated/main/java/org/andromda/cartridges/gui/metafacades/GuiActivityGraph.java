// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.FrontEndActivityGraph;

/**
 * Represents the activity graph describing the details of a Struts use-case.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiActivityGraph
    extends FrontEndActivityGraph
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiActivityGraphMetaType();

    /**
     * Returns the first action encountered in this activity graph. This is the one and only
     * transition coming out of the initial state.
     * @return GuiAction
     */
    public GuiAction getFirstAction();
}