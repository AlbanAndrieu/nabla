// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.jsf2.metafacades;

import org.andromda.metafacades.uml.FrontEndFinalState;

/**
 * Represents a final state in a JSF use case.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface JSFFinalState
    extends FrontEndFinalState
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isJSFFinalStateMetaType();

    /**
     * The path to which this final state points.
     * @return String
     */
    public String getPath();
}