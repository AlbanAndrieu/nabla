// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * Encapsulates a pseudostate and provides specific front-end services. This pseudostate can be a
 * decision point, junction or initial state.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndPseudostate
    extends PseudostateFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndPseudostateMetaType();

    /**
     * The actions that pass through this pseudo state.
     * @return List<FrontEndAction>
     */
    public List<FrontEndAction> getContainerActions();

    /**
     * Indicates if this "front-end" pseudo date is contained within a "front-end" use case.
     * @return boolean
     */
    public boolean isContainedInFrontEndUseCase();
}