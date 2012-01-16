// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A special kind of state signifying that the enclosing region is completed. If the enclosing
 * region is directly contained in a state machine and all other regions in the state machine also
 * are completed, then it means that the entire state machine is completed.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FinalStateFacade
    extends StateFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFinalStateFacadeMetaType();
}