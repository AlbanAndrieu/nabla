// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * Represents a "front-end" action. An action is some action that is taken when a front-end even
 * occurs.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndAction
    extends FrontEndForward
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndActionMetaType();

    /**
     * Finds the parameter on this action having the given name, if no parameter is found, null is
     * returned instead.
     * @param name String
     * @return ParameterFacade
     */
    public ParameterFacade findParameter(String name);

    /**
     * All action forwards for this foward. Each action forward either calls a view or another
     * use-case (which is essentially an action).
     * @return List<FrontEndForward>
     */
    public List<FrontEndForward> getActionForwards();

    /**
     * All action states visited by this action.
     * @return List<FrontEndActionState>
     */
    public List<FrontEndActionState> getActionStates();

    /**
     * The controller that will handle the execution of this front-end action. This controller is
     * set as the context of the activity graph (and therefore also of the use-case).
     * @return FrontEndController
     */
    public FrontEndController getController();

    /**
     * All the transitions coming out of decision points. These transitions should all carry guards.
     * @return List<FrontEndForward>
     */
    public List<FrontEndForward> getDecisionTransitions();

    /**
     * The controller operations to which this action defers, the order is preserved.
     * @return List<FrontEndControllerOperation>
     */
    public List<FrontEndControllerOperation> getDeferredOperations();

    /**
     * Form fields for this action. Form fields are those parameters that can be altered by the user
     * on a corresponding view at runtime.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getFormFields();

    /**
     * The StateVertex (FrontEndView or PseudostateFacade) on which this action can be triggered.
     * @return StateVertexFacade
     */
    public StateVertexFacade getInput();

    /**
     * All parameters sent by this "front-end" action.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getParameters();

    /**
     * All views that can be possibly targetted by triggering this action.
     * @return List<FrontEndView>
     */
    public List<FrontEndView> getTargetViews();

    /**
     * All the transitions that make up this action, this directly maps onto the forwards.
     * @return List<FrontEndForward>
     */
    public List<FrontEndForward> getTransitions();

    /**
     * Indicates if this action represents the beginning of the front-end use case or not.
     * @return boolean
     */
    public boolean isUseCaseStart();
}