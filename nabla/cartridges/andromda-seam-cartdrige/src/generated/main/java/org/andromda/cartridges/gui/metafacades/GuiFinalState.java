// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.List;
import org.andromda.metafacades.uml.FrontEndFinalState;

/**
 * A final state represents the end of a use-case. In a Gui application this means a transition into
 * the next use-case.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiFinalState
    extends FrontEndFinalState
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiFinalStateMetaType();

    /**
     * The actions leading directly into this action state.
     * @return List<GuiAction>
     */
    public List<GuiAction> getActions();

    /**
     * A final state maps onto a use-case. The full path to this use-case is returned here. In case
     * no name for this final state was specified the use-case with the application's first use-case
     * path will be returned.
     * @return String
     */
    public String getFullPath();

    /**
     * The path to which this final state points.
     * @return String
     */
    public String getPath();
}