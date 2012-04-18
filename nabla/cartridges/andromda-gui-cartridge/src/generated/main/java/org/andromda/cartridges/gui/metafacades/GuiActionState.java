// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.FrontEndActionState;

/**
 * A plain action state represents an operation on the server called by an action. Optionally an
 * action state may defer operations to the controller.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiActionState
    extends FrontEndActionState
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiActionStateMetaType();
}