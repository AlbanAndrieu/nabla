// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.FrontEndControllerOperation;
import org.andromda.metafacades.uml.ServiceOperation;

/**
 * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiControllerOperation
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiControllerOperation
    extends FrontEndControllerOperation
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiControllerOperationMetaType();

    /**
     * Reprsents an operation of a service.
     * @return ServiceOperation
     */
    public ServiceOperation getBackEndServiceOperation();

    /**
     * The controller for this operation. This is the owner in case this actually is a controller
     * operation, null otherwise.
     * @return GuiController
     */
    public GuiController getController();

    /**
     * The operation call that takes the appropriate form as an argument.
     * @return String
     */
    public String getFormCall();

    /**
     * The form name the corresponds to this controller operation.
     * @return String
     */
    public String getFormName();

    /**
     * The controller operation signature that takes the appropriate form (if this operation has at
     * least one form field) as an argument.
     * @return String
     */
    public String getFormSignature();

    /**
     * The fully qualified form name.
     * @return String
     */
    public String getFullyQualifiedFormName();

    /**
     * The fully qualified path of the form file.
     * @return String
     */
    public String getFullyQualifiedFormPath();

    /**
     * The controller implementation operation signature that takes the appropriate form (if this
     * operation has at least one form field) as an argument.
     * @return String
     */
    public String getImplementationFormSignature();

    /**
     * The package of the interface converted to a file-system compatible format.
     * @return String
     */
    public String getInterfaceFullPath();

    /**
     * The name of the interface used for forms that correspond to the calling of this operation (we
     * need to pass the form to the controller, but many forms/actions my be deferring to this
     * operation, this way we can aggregate them).
     * @return String
     */
    public String getInterfaceName();

    /**
     * The package of the interface used for forms that correspond to the calling of this operation
     * (we need to pass the form to the controller, but many forms/actions my be deferring to this
     * operation, this way we can aggregate them).
     * @return String
     */
    public String getInterfacePackageName();

    /**
     * The fully qualified name of the interface.
     * @return String
     */
    public String getInterfaceType();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiControllerOperation.backEndServiceOperationMatchingParameters
     * @return boolean
     */
    public boolean isBackEndServiceOperationMatchingParameters();

    /**
     * If this is true then the backEndServiceOperation property is not null, meaning this operation
     * is calling a specific backend operation.
     * @return boolean
     */
    public boolean isCallingBackEnd();
}