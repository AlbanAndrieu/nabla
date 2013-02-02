// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * Represents an operation on the server called by an action. Optionally may defer operations to the
 * controller.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndActionState
    extends ActionStateFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndActionStateMetaType();

    /**
     * The method name representing this action state.
     * @return String
     */
    public String getActionMethodName();

    /**
     * The actions that pass through this action state.
     * @return List<FrontEndAction>
     */
    public List<FrontEndAction> getContainerActions();

    /**
     * All calls deferred to the controller by this action state.
     * @return List<OperationFacade>
     */
    public List<OperationFacade> getControllerCalls();

    /**
     * All exceptions modelled on this action state.
     * @return List<FrontEndExceptionHandler>
     */
    public List<FrontEndExceptionHandler> getExceptions();

    /**
     * The next transition, there can be only one transition going out of an action state, otherwise
     * decision points should be used (triggers are not supported at the server-side).
     * @return FrontEndForward
     */
    public FrontEndForward getForward();

    /**
     * A behavioral feature of a classifier that specifies the name, type, parameters, and
     * constraints for
     * invoking an associated behavior. May invoke both the execution of method behaviors as well as
     * other
     * behavioral responses.
     * @return List<OperationFacade>
     */
    public List<OperationFacade> getServiceCalls();

    /**
     * True if this element is contained in a FrontEndUseCase.
     * @return boolean
     */
    public boolean isContainedInFrontEndUseCase();

    /**
     * Indicates whether or not this front end action state is server side. Pages, for example, are
     * also action states but they return control to the client.
     * @return boolean
     */
    public boolean isServerSide();
}