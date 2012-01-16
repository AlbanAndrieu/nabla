// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * Represents an operation modeled on a controller.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndControllerOperation
    extends OperationFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndControllerOperationMetaType();

    /**
     * The activity graph in which this controller operation is used.
     * @return FrontEndActivityGraph
     */
    public FrontEndActivityGraph getActivityGraph();

    /**
     * All those actions that contain at least one front-end action state that is deferring to this
     * operation.
     * @return List<FrontEndAction>
     */
    public List<FrontEndAction> getDeferringActions();

    /**
     * The set of fields in the form made up form this controller operation's parameters.
     * @return List<FrontEndParameter>
     */
    public List<FrontEndParameter> getFormFields();

    /**
     * For each front-end controller operation argument there must exist a form field for each
     * action deferring to that operation. This form field must carry the same name and must be of
     * the same type. True if this is the case, false otherwise.
     * @return boolean
     */
    public boolean isAllArgumentsHaveFormFields();

    /**
     * Indicates if the owner of this operation is a controller.
     * @return boolean
     */
    public boolean isOwnerIsController();
}