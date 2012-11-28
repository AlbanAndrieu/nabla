// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.List;
import java.util.Map;
import org.andromda.metafacades.uml.FrontEndAction;

/**
 * Represents a Gui action. Such an action typically is associated with a form bean handling all
 * parameters of this action.
 * This action model element extends a transition, but the actual logic contained by the action
 * envelops all action states called, until either a final state or View is reached.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiAction
    extends FrontEndAction
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiActionMetaType();

    /**
     * A good Java class name for this action. The name is constructed from the source page and the
     * name of the trigger.
     * @return String
     */
    public String getActionClassName();

    /**
     * Returns all exception handlers for this action.
     * @return List<GuiExceptionHandler>
     */
    public List<GuiExceptionHandler> getActionExceptionsToDeletes();

    /**
     * Returns all form fields for this action. Form fields are those parameters that can be altered
     * by the user at runtime.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getActionFormFieldsToDeletes();

    /**
     * The action input corresponding to this action, as found in the gui deployment descriptor. The
     * action input maps the action to the page on which it originated.
     * @return String
     */
    public String getActionInput();

    /**
     * The action name corresponding to this action, as found in the gui deployment descriptor. The
     * action name maps the action to a form bean.
     * @return String
     */
    public String getActionName();

    /**
     * Returns all parameters transported in this action.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getActionParametersToDeletes();

    /**
     * The action path corresponding to this action, as found in the gui deployment descriptor. The
     * action path specifies the URL to enter in order to call the action.
     * @return String
     */
    public String getActionPath();

    /**
     * The root of the action path, this is the same as the path for the use-case context for this
     * action, that is, the use-case holding the activity graph in which this action is contained.
     * @return String
     */
    public String getActionPathRoot();

    /**
     * The action roles corresponding to this action, as found in the gui deployment descriptor. The
     * action roles specifiy the roles in which the user must be in order to be authorized to call
     * the action. One of the roles must be satisfied.
     * @return String
     */
    public String getActionRoles();

    /**
     * The scope in which the form bean will be placed (could be page, request, session or
     * application).
     * @return String
     */
    public String getActionScope();

    /**
     * Returns the trigger that calls this action. Typically this is a button or an hyperlink.
     * @return GuiTrigger
     */
    public GuiTrigger getActionTriggerToDelete();

    /**
     * The fully qualified name for the action class.
     * @return String
     */
    public String getActionType();

    /**
     * The name of the action on the controller that executions this action.
     * @return String
     */
    public String getControllerAction();

    /**
     * A key suited as a resource message key for the documentation for this action.
     * @return String
     */
    public String getDocumentationKey();

    /**
     * The documentation for this action as a String that can be used as a resource message (with
     * the backslashes at the end of the line).
     * @return String
     */
    public String getDocumentationValue();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiAction.errorMessages
     * @return Map
     */
    public Map getErrorMessages();

    /**
     * Returns the class name of the form bean associated to this action.
     * @return String
     */
    public String getFormBeanClassName();

    /**
     * The name of the form bean associated to this action. The name is returned as it should appear
     * in the Gui deployment descriptor.
     * @return String
     */
    public String getFormBeanName();

    /**
     * The package for the form bean.
     * @return String
     */
    public String getFormBeanPackageName();

    /**
     * The fully qualified name of the form bean associated to this action.
     * @return String
     */
    public String getFormBeanType();

    /**
     * The signature of the accessor method that returns the form implementation instance.
     * @return String
     */
    public String getFormImplementationGetter();

    /**
     * A comma separated list of all the form interfaces which the form implementation implements.
     * @return String
     */
    public String getFormImplementationInterfaceList();

    /**
     * The name of the form implementation.
     * @return String
     */
    public String getFormImplementationName();

    /**
     * The key that stores the form in which information is passed from one action to another.
     * @return String
     */
    public String getFormKey();

    /**
     * The scope to place the current "form" variable within when this action is executing.
     * @return String
     */
    public String getFormScope();

    /**
     * The calcuated serial version UID for this action's form.
     * @return String
     */
    public String getFormSerialVersionUID();

    /**
     * The Javascript function name of the validation method that will validate the action
     * parameters.
     * @return String
     */
    public String getFormValidationMethodName();

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @return String
     */
    public String getFromOutcome();

    /**
     * The full path for this action. The full path also contains the package name rendered as
     * directories.
     * @return String
     */
    public String getFullActionPath();

    /**
     * Returns the full path for the form bean associated to this action.
     * @return String
     */
    public String getFullFormBeanPath();

    /**
     * The name of a file that can be used as a view file name in case you want to have each action
     * rendered onto a different tile.
     * @return String
     */
    public String getFullTilePath();

    /**
     * The fully qualified name of the action class that execute this action.
     * @return String
     */
    public String getFullyQualifiedActionClassName();

    /**
     * The fully qualified path to the action class that execute this action.
     * @return String
     */
    public String getFullyQualifiedActionClassPath();

    /**
     * The fully qualified name of the form implementation.
     * @return String
     */
    public String getFullyQualifiedFormImplementationName();

    /**
     * The fully qualified path of the form implementation.
     * @return String
     */
    public String getFullyQualifiedFormImplementationPath();

    /**
     * All action parameters that represent 'hidden' widgets.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getHiddenActionParameters();

    /**
     * All parameters that are of hidden input type.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getHiddenParameters();

    /**
     * The resource message key used to look to location of the image for this action.
     * @return String
     */
    public String getImageMessageKey();

    /**
     * If this action is an imageLink this property represents the path to the corresponding image.
     * @return String
     */
    public String getImagePath();

    /**
     * Those parameters that are directly entering a final state and have been submitted into the
     * request, they will be able to survive a trip to the next use-case. All returned elements are
     * of type GuiParameter.
     * @param finalState GuiFinalState
     * @return List
     */
    public List getInterUseCaseParameters(GuiFinalState finalState);

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiAction.messageKey
     * @return String
     */
    public String getMessageKey();

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return String
     */
    public String getOnlineHelpKey();

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return String
     */
    public String getOnlineHelpValue();

    /**
     * The path to this action.
     * @return String
     */
    public String getPath();

    /**
     * The path's root.
     * @return String
     */
    public String getPathRoot();

    /**
     * Gets all those parameters that should be reset after action execution.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getResettableActionParameters();

    /**
     * The name of the CSS id in which this action will be contained.
     * @return String
     */
    public String getStyleId();

    /**
     * Messages used to indicate successful execution.
     * @return Map
     */
    public Map getSuccessMessages();

    /**
     * The name of the column targetted by this action.
     * @return String
     */
    public String getTableLinkColumnName();

    /**
     * The name of the table link specified for this action.
     * @return String
     */
    public String getTableLinkName();

    /**
     * If the action is a table link then this property represents the table to which is being
     * linked.
     * @return GuiParameter
     */
    public GuiParameter getTableLinkParameter();

    /**
     * This table action's parameters not mapped to any table column. Only makes sense when this is
     * a table form action.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getTableNonColumnFormParameters();

    /**
     * The set of pages that are a possible target of the triggering of this action.
     * @return List<GuiView>
     */
    public List<GuiView> getTargetPages();

    /**
     * The name of the method to be executed when this action is triggered.
     * @return String
     */
    public String getTriggerMethodName();

    /**
     * The name of the trigger that triggers that action.
     * @return String
     */
    public String getTriggerName();

    /**
     * The path to the view fragment corresponding to this action
     * @return String
     */
    public String getViewFragmentPath();

    /**
     * Any messages used to indicate a warning.
     * @return Map
     */
    public Map getWarningMessages();

    /**
     * True if this action contains a parameter which requires a calendar popup.
     * @return boolean
     */
    public boolean isCalendarRequired();

    /**
     * True if this action contains a parameter of type Date. The generated pages will contain
     * special javascript code to handle them (popup window etc...).
     * @return boolean
     */
    public boolean isDateFieldPresent();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiAction.errorMessagesPresent
     * @return boolean
     */
    public boolean isErrorMessagesPresent();

    /**
     * Indicates whether or not a final state is the target of this action.
     * @return boolean
     */
    public boolean isFinalStateTarget();

    /**
     * Specifies whether or not this action is represented by the posting of a form.
     * @return boolean
     */
    public boolean isFormPost();

    /**
     * Whether or not the entire form should be reset (all action parameters on the form).
     * @return boolean
     */
    public boolean isFormReset();

    /**
     * Indicates if at least one parameter on the form requires being reset.
     * @return boolean
     */
    public boolean isFormResetRequired();

    /**
     * Indicates if the form scope is of type "none".
     * @return boolean
     */
    public boolean isFormScopeNone();

    /**
     * Indicates if the from scope is of type "request".
     * @return boolean
     */
    public boolean isFormScopeRequest();

    /**
     * Indicates if the form scope is of type "session".
     * @return boolean
     */
    public boolean isFormScopeSession();

    /**
     * Specifies whether or not this action is represented by clicking on a hyperlink.
     * @return boolean
     */
    public boolean isHyperlink();

    /**
     * Specifies whether or not this action is represented by clicking on an image.
     * @return boolean
     */
    public boolean isImageLink();

    /**
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return boolean
     */
    public boolean isMultipartFormData();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiAction.needsFileUpload
     * @return boolean
     */
    public boolean isNeedsFileUpload();

    /**
     * Indicates if this action forwards to a popup (this is determed when the targetted view is a
     * popup).
     * @return boolean
     */
    public boolean isPopup();

    /**
     * Defines whether or not when this action's forward is executed, an HTTP redirect should occur.
     *  Default value is based on the value of the 'defaultActionRedirect' namespace.
     * @return boolean
     */
    public boolean isRedirect();

    /**
     * True if it should be possible to reset the form represented by this action. False otherwise.
     * @return boolean
     */
    public boolean isResettable();

    /**
     * Indicates whether or not any success messags are present.
     * @return boolean
     */
    public boolean isSuccessMessagesPresent();

    /**
     * Denotes this action works on all rows of the table from the table link relation.
     * @return boolean
     */
    public boolean isTableAction();

    /**
     * True if a table link name has been specified and it properly targets a table page-variable
     * from the input page.
     * @return boolean
     */
    public boolean isTableLink();

    /**
     * Denotes this action works on a single row of the table from the table link relation.
     * @return boolean
     */
    public boolean isTableRowAction();

    /**
     * True if this action requires validation, false otherwise. An action requires validation if it
     * represented by a form and one or more fields require validation.
     * @return boolean
     */
    public boolean isValidationRequired();

    /**
     * Whether or not any warning messages are present.
     * @return boolean
     */
    public boolean isWarningMessagesPresent();
}