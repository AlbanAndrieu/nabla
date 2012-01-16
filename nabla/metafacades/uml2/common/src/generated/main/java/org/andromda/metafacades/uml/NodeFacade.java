// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A computational resource upon which artifacts may be deployed for execution. Nodes can be
 * interconnected through communication paths to define network structures.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface NodeFacade
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isNodeFacadeMetaType();
}