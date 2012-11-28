// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A representation of the model object 'Region'. An orthogonal part of either a composite state or
 * a state machine. It contains states and transitions.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface PartitionFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isPartitionFacadeMetaType();

    /**
     * State machines can be used to express the behavior of part of a system. Behavior is modeled
     * as a
     * traversal of a graph of state nodes interconnected by one or more joined transition arcs that
     * are
     * triggered by the dispatching of series of (event) occurrences. During this traversal, the
     * state
     * machine executes a series of activities associated with various elements of the state
     * machine.
     * @return ActivityGraphFacade
     */
    public ActivityGraphFacade getActivityGraph();

    /**
     * All vertices enveloped by this partition.
     * @return Collection<StateVertexFacade>
     */
    public Collection<StateVertexFacade> getVertices();
}