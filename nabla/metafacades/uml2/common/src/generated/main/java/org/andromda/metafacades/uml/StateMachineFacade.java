// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * State machines can be used to express the behavior of part of a system. Behavior is modeled as a
 * traversal of a graph of state nodes interconnected by one or more joined transition arcs that are
 * triggered by the dispatching of series of (event) occurrences. During this traversal, the state
 * machine executes a series of activities associated with various elements of the state machine.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface StateMachineFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isStateMachineFacadeMetaType();

    /**
     * 
     * @return ModelElementFacade
     */
    public ModelElementFacade getContextElement();

    /**
     * 
     * @return Collection<FinalStateFacade>
     */
    public Collection<FinalStateFacade> getFinalStates();

    /**
     * The first initial state (if any) found in this activity graph. Although technically many
     * initial states per graph are allowed, it makes sense to have only one, for this reason we
     * provide this property.
     * @return PseudostateFacade
     */
    public PseudostateFacade getInitialState();

    /**
     * 
     * @return Collection<PseudostateFacade>
     */
    public Collection<PseudostateFacade> getInitialStates();

    /**
     * The first transition on the first initial state found for this activity graph.
     * @return TransitionFacade
     */
    public TransitionFacade getInitialTransition();

    /**
     * 
     * @return Collection<PseudostateFacade>
     */
    public Collection<PseudostateFacade> getPseudostates();

    /**
     * 
     * @return Collection<StateFacade>
     */
    public Collection<StateFacade> getStates();

    /**
     * 
     * @return Collection<TransitionFacade>
     */
    public Collection<TransitionFacade> getTransitions();
}