// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * A front end forward is any transition between front-end states.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndForward
    extends TransitionFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndForwardMetaType();

    /**
     * The method name used to delegate to this forward.
     * @return String
     */
    public String getActionMethodName();

    /**
     * The front-end actions directly containing this front-end forward.
     * @return List<FrontEndAction>
     */
    public List<FrontEndAction> getActions();

    /**
     * The trigger for this front-end forward.
     * @return FrontEndEvent
     */
    public FrontEndEvent getDecisionTrigger();

    /**
     * Tthe set of parameter used during transport in this forward.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getForwardParameters();

    /**
     * The activity graph which holds this forward if the graph is contained in a FrontEndUseCase.
     * @return FrontEndActivityGraph
     */
    public FrontEndActivityGraph getFrontEndActivityGraph();

    /**
     * The operation to which is called during execution of this front-end forward.
     * @return FrontEndControllerOperation
     */
    public FrontEndControllerOperation getOperationCall();

    /**
     * The use case in which this forward is contained.
     * @return FrontEndUseCase
     */
    public FrontEndUseCase getUseCase();

    /**
     * Indicates if this forward is contained in a FrontEndUseCase.
     * @return boolean
     */
    public boolean isContainedInFrontEndUseCase();

    /**
     * Indicates if this action directly targets a "front-end" view, false otherwise.
     * @return boolean
     */
    public boolean isEnteringView();

    /**
     * Indicates if this forward (transition) is coming out of a front-end view.
     * @return boolean
     */
    public boolean isExitingView();
}