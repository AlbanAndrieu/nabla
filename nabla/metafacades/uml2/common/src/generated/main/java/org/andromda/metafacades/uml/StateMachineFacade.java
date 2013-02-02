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
     * Represents a model element. It may be an Element or NamedElement. A named element is an
     * element in a model that may have a name. An element is a constituent of a model. As such, it
     * has the capability of owning other elements.
     * @return ModelElementFacade
     */
    public ModelElementFacade getContextElement();

    /**
     * A special kind of state signifying that the enclosing region is completed. If the enclosing
     * region is directly contained in a state machine and all other regions in the state machine
     * also are completed, then it means that the entire state machine is completed.
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
     * An abstraction that encompasses different types of transient vertices in the state machine
     * graph.
     * @return Collection<PseudostateFacade>
     */
    public Collection<PseudostateFacade> getInitialStates();

    /**
     * The first transition on the first initial state found for this activity graph.
     * @return TransitionFacade
     */
    public TransitionFacade getInitialTransition();

    /**
     * An abstraction that encompasses different types of transient vertices in the state machine
     * graph.
     * @return Collection<PseudostateFacade>
     */
    public Collection<PseudostateFacade> getPseudostates();

    /**
     * Models a situation during which some (usually implicit) invariant condition holds. The states
     * of protocol state machines are exposed to the users of their context classifiers. A protocol
     * state represents an exposed stable situation of its context classifier: when an instance of
     * the classifier is not processing any operation, users of this instance can always know its
     * state configuration.
     * @return Collection<StateFacade>
     */
    public Collection<StateFacade> getStates();

    /**
     * A directed relationship between a source vertex and a target vertex. It may be part of a
     * compound transition, which takes the state machine from one state configuration to another,
     * representing the complete response of the state machine to an occurrence of an event of a
     * particular type.
     * @return Collection<TransitionFacade>
     */
    public Collection<TransitionFacade> getTransitions();
}