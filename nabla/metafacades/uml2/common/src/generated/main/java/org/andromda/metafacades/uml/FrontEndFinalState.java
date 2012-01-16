// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * A final state represents the end of a use-case, in a "front-end" application this means its the
 * transition into the next front-end use case.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndFinalState
    extends FinalStateFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndFinalStateMetaType();

    /**
     * Parameters that are directly entering this final state, they will be able to survive a trip
     * to the next use-case.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getInterUseCaseParameters();

    /**
     * The use case the final state is "targetting".
     * @return FrontEndUseCase
     */
    public FrontEndUseCase getTargetUseCase();

    /**
     * Indicates if this front end final state is contained within a FrontEndUseCase.
     * @return boolean
     */
    public boolean isContainedInFrontEndUseCase();
}