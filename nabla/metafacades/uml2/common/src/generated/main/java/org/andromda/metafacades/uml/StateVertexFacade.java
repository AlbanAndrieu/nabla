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
     * 
     * @return StateFacade
     */
    public StateFacade getContainer();

    /**
     * 
     * @return Collection<TransitionFacade>
     */
    public Collection<TransitionFacade> getIncomings();

    /**
     * 
     * @return Collection<TransitionFacade>
     */
    public Collection<TransitionFacade> getOutgoings();

    /**
     * The partition (if any) to which this vertex belongs.
     * @return PartitionFacade
     */
    public PartitionFacade getPartition();

    /**
     * 
     * @return StateMachineFacade
     */
    public StateMachineFacade getStateMachine();
}