// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * An action is a named element that is the fundamental unit of executable functionality. The
 * execution of an action represents some transformation or processing in the modeled system, be it
 * a computer system or otherwise. An action represents a single step within an activity, that is,
 * one that is not further decomposed within the activity. An action has pre- and post-conditions.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ActionFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isActionFacadeMetaType();

    /**
     * If this action is located on an action state, this will represent that state.
     * @return ActionStateFacade
     */
    public ActionStateFacade getActionState();

    /**
     * If this action is located on a transition, this represents that transition.
     * @return TransitionFacade
     */
    public TransitionFacade getTransition();
}