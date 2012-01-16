// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * Represents a view within a front end application.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndView
    extends FrontEndActionState
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndViewMetaType();

    /**
     * All actions that can be triggered on this view.
     * @return List<FrontEndAction>
     */
    public List<FrontEndAction> getActions();

    /**
     * All parameters for each action going out of this view.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getAllActionParameters();

    /**
     * All fields from all forms on the given view.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getAllFormFields();

    /**
     * All tables belonging to the front end view.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getTables();

    /**
     * The use-case of which this view is a member.
     * @return FrontEndUseCase
     */
    public FrontEndUseCase getUseCase();

    /**
     * All those variables that will be present as variables in the target view. These are the
     * trigger parameters on the incoming transitions.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getVariables();

    /**
     * True if this element carries the FrontEndView stereotype.
     * @return boolean
     */
    public boolean isFrontEndView();
}