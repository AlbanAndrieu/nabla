// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * Represents a use case used in the "front end" of an application.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndUseCase
    extends UseCaseFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndUseCaseMetaType();

    /**
     * The actions for this use-case. This will include the initial action to start the use-case.
     * @return List<FrontEndAction>
     */
    public List<FrontEndAction> getActions();

    /**
     * Returns the activity graph describing this use-case in more detail.
     * @return FrontEndActivityGraph
     */
    public FrontEndActivityGraph getActivityGraph();

    /**
     * All roles that directly or indirectly related to any "front-end" use cases.
     * @return List<Role>
     */
    public List<Role> getAllRoles();

    /**
     * Returns all struts use-cases in this "front end" application.
     * @return List<FrontEndUseCase>
     */
    public List<FrontEndUseCase> getAllUseCases();

    /**
     * Returns the controller for this use-case.
     * @return FrontEndController
     */
    public FrontEndController getController();

    /**
     * The first view of this use case, this may actually return a view of another use case if the
     * first is found by traveling through the final state.
     * @return FrontEndView
     */
    public FrontEndView getInitialView();

    /**
     * The final states linking to this use case
     * @return List<FrontEndFinalState>
     */
    public List<FrontEndFinalState> getReferencingFinalStates();

    /**
     * Returns all roles that are directly and indirectly associated to this use-case.
     * @return List<Role>
     */
    public List<Role> getRoles();

    /**
     * The variables for all views in this use-case. A parameter qualifies to be a variable when it
     * explicitely and directly receives it via an action.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getViewVariables();

    /**
     * All views that are part of this use case.
     * @return List<FrontEndView>
     */
    public List<FrontEndView> getViews();

    /**
     * True if this use-case is the entry point to the front end.
     * @return boolean
     */
    public boolean isEntryUseCase();

    /**
     * Indicates if this use case is "secured".  This is true when there is at least one role
     * associated to it.
     * @return boolean
     */
    public boolean isSecured();
}