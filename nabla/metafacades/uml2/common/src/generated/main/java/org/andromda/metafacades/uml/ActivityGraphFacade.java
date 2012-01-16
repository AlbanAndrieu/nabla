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
public interface ActivityGraphFacade
    extends StateMachineFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isActivityGraphFacadeMetaType();

    /**
     * The set of action states contained in this activity graph.
     * @return Collection<ActionStateFacade>
     */
    public Collection<ActionStateFacade> getActionStates();

    /**
     * The set of object flow states contained in this activity graph.
     * @return Collection<ObjectFlowStateFacade>
     */
    public Collection<ObjectFlowStateFacade> getObjectFlowStates();

    /**
     * The set of partitions contained in this activity graph. Partitions are also known as
     * swimlanes in UML.
     * @return Collection<PartitionFacade>
     */
    public Collection<PartitionFacade> getPartitions();

    /**
     * The use-case owning this activity graph.
     * @return UseCaseFacade
     */
    public UseCaseFacade getUseCase();
}