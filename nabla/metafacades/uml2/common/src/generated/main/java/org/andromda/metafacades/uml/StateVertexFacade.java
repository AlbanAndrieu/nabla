// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A representation of the model object 'Vertex'. An abstraction of a node in a state machine graph.
 * In general, it can be the source or destination of any number of transitions.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface StateVertexFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isStateVertexFacadeMetaType();

    /**
     * Models a situation during which some (usually implicit) invariant condition holds. The states
     * of protocol state machines are exposed to the users of their context classifiers. A protocol
     * state represents an exposed stable situation of its context classifier: when an instance of
     * the classifier is not processing any operation, users of this instance can always know its
     * state configuration.
     * @return StateFacade
     */
    public StateFacade getContainer();

    /**
     * A directed relationship between a source vertex and a target vertex. It may be part of a
     * compound transition, which takes the state machine from one state configuration to another,
     * representing the complete response of the state machine to an occurrence of an event of a
     * particular type.
     * @return Collection<TransitionFacade>
     */
    public Collection<TransitionFacade> getIncomings();

    /**
     * A directed relationship between a source vertex and a target vertex. It may be part of a
     * compound transition, which takes the state machine from one state configuration to another,
     * representing the complete response of the state machine to an occurrence of an event of a
     * particular type.
     * @return Collection<TransitionFacade>
     */
    public Collection<TransitionFacade> getOutgoings();

    /**
     * The partition (if any) to which this vertex belongs.
     * @return PartitionFacade
     */
    public PartitionFacade getPartition();

    /**
     * State machines can be used to express the behavior of part of a system. Behavior is modeled
     * as a traversal of a graph of state nodes interconnected by one or more joined transition arcs
     * that are triggered by the dispatching of series of (event) occurrences. During this
     * traversal, the state machine executes a series of activities associated with various elements
     * of the state machine.
     * @return StateMachineFacade
     */
    public StateMachineFacade getStateMachine();
}