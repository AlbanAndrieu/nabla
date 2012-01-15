// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.FrontEndPseudostate;

/**
 * Encapsulates a pseudostate and provides specific Struts services. This pseudostate can be a
 * decision point, junction or initial state.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiPseudostate
    extends FrontEndPseudostate
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiPseudostateMetaType();

    /**
     * The method name that delegates transitions from this state.
     * @return String
     */
    public String getActionMethodName();
}