// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Represents the activity graph describing the details of a presentation tier or "front end" use
 * case.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndActivityGraph
    extends ActivityGraphFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndActivityGraphMetaType();

    /**
     * The controller context for this activity graph. This controller can be the target of
     * deferrable events in the action states and transitions in this graph.
     * @return FrontEndController
     */
    public FrontEndController getController();

    /**
     * This is the initial action encountered in this activity graph. This is the one and only
     * transition coming out of the initial state.
     * @return FrontEndAction
     */
    public FrontEndAction getInitialAction();

    /**
     * True if this element is contained in a FrontEndUseCase.
     * @return boolean
     */
    public boolean isContainedInFrontEndUseCase();
}