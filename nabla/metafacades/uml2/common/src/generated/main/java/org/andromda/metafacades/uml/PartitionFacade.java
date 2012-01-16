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
     * 
     * @return ActivityGraphFacade
     */
    public ActivityGraphFacade getActivityGraph();

    /**
     * All vertices enveloped by this partition.
     * @return Collection<StateVertexFacade>
     */
    public Collection<StateVertexFacade> getVertices();
}