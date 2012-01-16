// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A representation of the model object 'Activity'. The specification of parameterized behavior as
 * the coordinated sequencing of subordinate units whose individual elements are actions.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EventFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEventFacadeMetaType();

    /**
     * The parameters to this event.
     * @return Collection<ParameterFacade>
     */
    public Collection<ParameterFacade> getParameters();

    /**
     * If this event is located on an action state, this will represent that state.
     * @return StateFacade
     */
    public StateFacade getState();

    /**
     * If this event is located on a transition, this represents that transition.
     * @return TransitionFacade
     */
    public TransitionFacade getTransition();
}