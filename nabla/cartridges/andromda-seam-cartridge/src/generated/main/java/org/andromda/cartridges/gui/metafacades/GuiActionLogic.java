// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ActionFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EventFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndActionState;
import org.andromda.metafacades.uml.FrontEndActivityGraph;
import org.andromda.metafacades.uml.FrontEndController;
import org.andromda.metafacades.uml.FrontEndControllerOperation;
import org.andromda.metafacades.uml.FrontEndEvent;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndUseCase;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.GuardFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StateVertexFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.andromda.translation.ocl.validation.OCLCollections;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.log4j.Logger;

/**
 * Represents a Gui action. Such an action typically is associated with a form bean handling all
 * parameters of this action.
 * This action model element extends a transition, but the actual logic contained by the action
 * envelops all action states called, until either a final state or View is reached.
 * MetafacadeLogic for GuiAction
 *
 * @see GuiAction
 */
public abstract class GuiActionLogic
    extends MetafacadeBase
    implements GuiAction
{

    private static final long serialVersionUID = 1L;
    
    /**
     * The underlying UML object
     * @see Object
     */
    protected transient Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected GuiActionLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superFrontEndAction =
           (FrontEndAction)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.FrontEndAction",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiActionLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiAction if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiAction";
        }
        return context;
    }

    private FrontEndAction superFrontEndAction;
    private boolean superFrontEndActionInitialized = false;

    /**
     * Gets the FrontEndAction parent instance.
     * @return this.superFrontEndAction FrontEndAction
     */
    private FrontEndAction getSuperFrontEndAction()
    {
        if (!this.superFrontEndActionInitialized)
        {
            ((MetafacadeBase)this.superFrontEndAction).setMetafacadeContext(this.getMetafacadeContext());
            this.superFrontEndActionInitialized = true;
        }
        return this.superFrontEndAction;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superFrontEndActionInitialized)
            {
                ((MetafacadeBase)this.superFrontEndAction).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see GuiAction
     */
    public boolean isGuiActionMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionName()
    * @return String
    */
    protected abstract String handleGetActionName();

    private transient String actionName1a;
    private transient boolean actionName1aSet = false;

    /**
     * The action name corresponding to this action, as found in the gui deployment descriptor. The
     * action name maps the action to a form bean.
     * @return (String)handleGetActionName()
     */
    public final String getActionName()
    {
        String actionName1a = this.actionName1a;
        if (!this.actionName1aSet)
        {
            // actionName has no pre constraints
            actionName1a = handleGetActionName();
            // actionName has no post constraints
            this.actionName1a = actionName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionName1aSet = true;
            }
        }
        return actionName1a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionPath()
    * @return String
    */
    protected abstract String handleGetActionPath();

    private transient String actionPath2a;
    private transient boolean actionPath2aSet = false;

    /**
     * The action path corresponding to this action, as found in the gui deployment descriptor. The
     * action path specifies the URL to enter in order to call the action.
     * @return (String)handleGetActionPath()
     */
    public final String getActionPath()
    {
        String actionPath2a = this.actionPath2a;
        if (!this.actionPath2aSet)
        {
            // actionPath has no pre constraints
            actionPath2a = handleGetActionPath();
            // actionPath has no post constraints
            this.actionPath2a = actionPath2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionPath2aSet = true;
            }
        }
        return actionPath2a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionInput()
    * @return String
    */
    protected abstract String handleGetActionInput();

    private transient String actionInput3a;
    private transient boolean actionInput3aSet = false;

    /**
     * The action input corresponding to this action, as found in the gui deployment descriptor. The
     * action input maps the action to the page on which it originated.
     * @return (String)handleGetActionInput()
     */
    public final String getActionInput()
    {
        String actionInput3a = this.actionInput3a;
        if (!this.actionInput3aSet)
        {
            // actionInput has no pre constraints
            actionInput3a = handleGetActionInput();
            // actionInput has no post constraints
            this.actionInput3a = actionInput3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionInput3aSet = true;
            }
        }
        return actionInput3a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionRoles()
    * @return String
    */
    protected abstract String handleGetActionRoles();

    private transient String actionRoles4a;
    private transient boolean actionRoles4aSet = false;

    /**
     * The action roles corresponding to this action, as found in the gui deployment descriptor. The
     * action roles specifiy the roles in which the user must be in order to be authorized to call
     * the action. One of the roles must be satisfied.
     * @return (String)handleGetActionRoles()
     */
    public final String getActionRoles()
    {
        String actionRoles4a = this.actionRoles4a;
        if (!this.actionRoles4aSet)
        {
            // actionRoles has no pre constraints
            actionRoles4a = handleGetActionRoles();
            // actionRoles has no post constraints
            this.actionRoles4a = actionRoles4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionRoles4aSet = true;
            }
        }
        return actionRoles4a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormPost()
    * @return boolean
    */
    protected abstract boolean handleIsFormPost();

    private transient boolean formPost5a;
    private transient boolean formPost5aSet = false;

    /**
     * Specifies whether or not this action is represented by the posting of a form.
     * @return (boolean)handleIsFormPost()
     */
    public final boolean isFormPost()
    {
        boolean formPost5a = this.formPost5a;
        if (!this.formPost5aSet)
        {
            // formPost has no pre constraints
            formPost5a = handleIsFormPost();
            // formPost has no post constraints
            this.formPost5a = formPost5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formPost5aSet = true;
            }
        }
        return formPost5a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isHyperlink()
    * @return boolean
    */
    protected abstract boolean handleIsHyperlink();

    private transient boolean hyperlink6a;
    private transient boolean hyperlink6aSet = false;

    /**
     * Specifies whether or not this action is represented by clicking on a hyperlink.
     * @return (boolean)handleIsHyperlink()
     */
    public final boolean isHyperlink()
    {
        boolean hyperlink6a = this.hyperlink6a;
        if (!this.hyperlink6aSet)
        {
            // hyperlink has no pre constraints
            hyperlink6a = handleIsHyperlink();
            // hyperlink has no post constraints
            this.hyperlink6a = hyperlink6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hyperlink6aSet = true;
            }
        }
        return hyperlink6a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionClassName()
    * @return String
    */
    protected abstract String handleGetActionClassName();

    private transient String actionClassName7a;
    private transient boolean actionClassName7aSet = false;

    /**
     * A good Java class name for this action. The name is constructed from the source page and the
     * name of the trigger.
     * @return (String)handleGetActionClassName()
     */
    public final String getActionClassName()
    {
        String actionClassName7a = this.actionClassName7a;
        if (!this.actionClassName7aSet)
        {
            // actionClassName has no pre constraints
            actionClassName7a = handleGetActionClassName();
            // actionClassName has no post constraints
            this.actionClassName7a = actionClassName7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionClassName7aSet = true;
            }
        }
        return actionClassName7a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanClassName()
    * @return String
    */
    protected abstract String handleGetFormBeanClassName();

    private transient String formBeanClassName8a;
    private transient boolean formBeanClassName8aSet = false;

    /**
     * Returns the class name of the form bean associated to this action.
     * @return (String)handleGetFormBeanClassName()
     */
    public final String getFormBeanClassName()
    {
        String formBeanClassName8a = this.formBeanClassName8a;
        if (!this.formBeanClassName8aSet)
        {
            // formBeanClassName has no pre constraints
            formBeanClassName8a = handleGetFormBeanClassName();
            // formBeanClassName has no post constraints
            this.formBeanClassName8a = formBeanClassName8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanClassName8aSet = true;
            }
        }
        return formBeanClassName8a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanName()
    * @return String
    */
    protected abstract String handleGetFormBeanName();

    private transient String formBeanName9a;
    private transient boolean formBeanName9aSet = false;

    /**
     * The name of the form bean associated to this action. The name is returned as it should appear
     * in the Gui deployment descriptor.
     * @return (String)handleGetFormBeanName()
     */
    public final String getFormBeanName()
    {
        String formBeanName9a = this.formBeanName9a;
        if (!this.formBeanName9aSet)
        {
            // formBeanName has no pre constraints
            formBeanName9a = handleGetFormBeanName();
            // formBeanName has no post constraints
            this.formBeanName9a = formBeanName9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanName9aSet = true;
            }
        }
        return formBeanName9a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormValidationMethodName()
    * @return String
    */
    protected abstract String handleGetFormValidationMethodName();

    private transient String formValidationMethodName10a;
    private transient boolean formValidationMethodName10aSet = false;

    /**
     * The Javascript function name of the validation method that will validate the action
     * parameters.
     * @return (String)handleGetFormValidationMethodName()
     */
    public final String getFormValidationMethodName()
    {
        String formValidationMethodName10a = this.formValidationMethodName10a;
        if (!this.formValidationMethodName10aSet)
        {
            // formValidationMethodName has no pre constraints
            formValidationMethodName10a = handleGetFormValidationMethodName();
            // formValidationMethodName has no post constraints
            this.formValidationMethodName10a = formValidationMethodName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formValidationMethodName10aSet = true;
            }
        }
        return formValidationMethodName10a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isResettable()
    * @return boolean
    */
    protected abstract boolean handleIsResettable();

    private transient boolean resettable11a;
    private transient boolean resettable11aSet = false;

    /**
     * True if it should be possible to reset the form represented by this action. False otherwise.
     * @return (boolean)handleIsResettable()
     */
    public final boolean isResettable()
    {
        boolean resettable11a = this.resettable11a;
        if (!this.resettable11aSet)
        {
            // resettable has no pre constraints
            resettable11a = handleIsResettable();
            // resettable has no post constraints
            this.resettable11a = resettable11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resettable11aSet = true;
            }
        }
        return resettable11a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullActionPath()
    * @return String
    */
    protected abstract String handleGetFullActionPath();

    private transient String fullActionPath12a;
    private transient boolean fullActionPath12aSet = false;

    /**
     * The full path for this action. The full path also contains the package name rendered as
     * directories.
     * @return (String)handleGetFullActionPath()
     */
    public final String getFullActionPath()
    {
        String fullActionPath12a = this.fullActionPath12a;
        if (!this.fullActionPath12aSet)
        {
            // fullActionPath has no pre constraints
            fullActionPath12a = handleGetFullActionPath();
            // fullActionPath has no post constraints
            this.fullActionPath12a = fullActionPath12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullActionPath12aSet = true;
            }
        }
        return fullActionPath12a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullFormBeanPath()
    * @return String
    */
    protected abstract String handleGetFullFormBeanPath();

    private transient String fullFormBeanPath13a;
    private transient boolean fullFormBeanPath13aSet = false;

    /**
     * Returns the full path for the form bean associated to this action.
     * @return (String)handleGetFullFormBeanPath()
     */
    public final String getFullFormBeanPath()
    {
        String fullFormBeanPath13a = this.fullFormBeanPath13a;
        if (!this.fullFormBeanPath13aSet)
        {
            // fullFormBeanPath has no pre constraints
            fullFormBeanPath13a = handleGetFullFormBeanPath();
            // fullFormBeanPath has no post constraints
            this.fullFormBeanPath13a = fullFormBeanPath13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullFormBeanPath13aSet = true;
            }
        }
        return fullFormBeanPath13a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionPathRoot()
    * @return String
    */
    protected abstract String handleGetActionPathRoot();

    private transient String actionPathRoot14a;
    private transient boolean actionPathRoot14aSet = false;

    /**
     * The root of the action path, this is the same as the path for the use-case context for this
     * action, that is, the use-case holding the activity graph in which this action is contained.
     * @return (String)handleGetActionPathRoot()
     */
    public final String getActionPathRoot()
    {
        String actionPathRoot14a = this.actionPathRoot14a;
        if (!this.actionPathRoot14aSet)
        {
            // actionPathRoot has no pre constraints
            actionPathRoot14a = handleGetActionPathRoot();
            // actionPathRoot has no post constraints
            this.actionPathRoot14a = actionPathRoot14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionPathRoot14aSet = true;
            }
        }
        return actionPathRoot14a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private transient boolean validationRequired15a;
    private transient boolean validationRequired15aSet = false;

    /**
     * True if this action requires validation, false otherwise. An action requires validation if it
     * represented by a form and one or more fields require validation.
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean validationRequired15a = this.validationRequired15a;
        if (!this.validationRequired15aSet)
        {
            // validationRequired has no pre constraints
            validationRequired15a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.validationRequired15a = validationRequired15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validationRequired15aSet = true;
            }
        }
        return validationRequired15a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanType()
    * @return String
    */
    protected abstract String handleGetFormBeanType();

    private transient String formBeanType16a;
    private transient boolean formBeanType16aSet = false;

    /**
     * The fully qualified name of the form bean associated to this action.
     * @return (String)handleGetFormBeanType()
     */
    public final String getFormBeanType()
    {
        String formBeanType16a = this.formBeanType16a;
        if (!this.formBeanType16aSet)
        {
            // formBeanType has no pre constraints
            formBeanType16a = handleGetFormBeanType();
            // formBeanType has no post constraints
            this.formBeanType16a = formBeanType16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanType16aSet = true;
            }
        }
        return formBeanType16a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getDocumentationValue()
    * @return String
    */
    protected abstract String handleGetDocumentationValue();

    private transient String documentationValue17a;
    private transient boolean documentationValue17aSet = false;

    /**
     * The documentation for this action as a String that can be used as a resource message (with
     * the backslashes at the end of the line).
     * @return (String)handleGetDocumentationValue()
     */
    public final String getDocumentationValue()
    {
        String documentationValue17a = this.documentationValue17a;
        if (!this.documentationValue17aSet)
        {
            // documentationValue has no pre constraints
            documentationValue17a = handleGetDocumentationValue();
            // documentationValue has no post constraints
            this.documentationValue17a = documentationValue17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentationValue17aSet = true;
            }
        }
        return documentationValue17a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getDocumentationKey()
    * @return String
    */
    protected abstract String handleGetDocumentationKey();

    private transient String documentationKey18a;
    private transient boolean documentationKey18aSet = false;

    /**
     * A key suited as a resource message key for the documentation for this action.
     * @return (String)handleGetDocumentationKey()
     */
    public final String getDocumentationKey()
    {
        String documentationKey18a = this.documentationKey18a;
        if (!this.documentationKey18aSet)
        {
            // documentationKey has no pre constraints
            documentationKey18a = handleGetDocumentationKey();
            // documentationKey has no post constraints
            this.documentationKey18a = documentationKey18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentationKey18aSet = true;
            }
        }
        return documentationKey18a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullTilePath()
    * @return String
    */
    protected abstract String handleGetFullTilePath();

    private transient String fullTilePath19a;
    private transient boolean fullTilePath19aSet = false;

    /**
     * The name of a file that can be used as a view file name in case you want to have each action
     * rendered onto a different tile.
     * @return (String)handleGetFullTilePath()
     */
    public final String getFullTilePath()
    {
        String fullTilePath19a = this.fullTilePath19a;
        if (!this.fullTilePath19aSet)
        {
            // fullTilePath has no pre constraints
            fullTilePath19a = handleGetFullTilePath();
            // fullTilePath has no post constraints
            this.fullTilePath19a = fullTilePath19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullTilePath19aSet = true;
            }
        }
        return fullTilePath19a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isDateFieldPresent()
    * @return boolean
    */
    protected abstract boolean handleIsDateFieldPresent();

    private transient boolean dateFieldPresent20a;
    private transient boolean dateFieldPresent20aSet = false;

    /**
     * True if this action contains a parameter of type Date. The generated pages will contain
     * special javascript code to handle them (popup window etc...).
     * @return (boolean)handleIsDateFieldPresent()
     */
    public final boolean isDateFieldPresent()
    {
        boolean dateFieldPresent20a = this.dateFieldPresent20a;
        if (!this.dateFieldPresent20aSet)
        {
            // dateFieldPresent has no pre constraints
            dateFieldPresent20a = handleIsDateFieldPresent();
            // dateFieldPresent has no post constraints
            this.dateFieldPresent20a = dateFieldPresent20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dateFieldPresent20aSet = true;
            }
        }
        return dateFieldPresent20a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isCalendarRequired()
    * @return boolean
    */
    protected abstract boolean handleIsCalendarRequired();

    private transient boolean calendarRequired21a;
    private transient boolean calendarRequired21aSet = false;

    /**
     * True if this action contains a parameter which requires a calendar popup.
     * @return (boolean)handleIsCalendarRequired()
     */
    public final boolean isCalendarRequired()
    {
        boolean calendarRequired21a = this.calendarRequired21a;
        if (!this.calendarRequired21aSet)
        {
            // calendarRequired has no pre constraints
            calendarRequired21a = handleIsCalendarRequired();
            // calendarRequired has no post constraints
            this.calendarRequired21a = calendarRequired21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.calendarRequired21aSet = true;
            }
        }
        return calendarRequired21a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableLink()
    * @return boolean
    */
    protected abstract boolean handleIsTableLink();

    private transient boolean tableLink22a;
    private transient boolean tableLink22aSet = false;

    /**
     * True if a table link name has been specified and it properly targets a table page-variable
     * from the input page.
     * @return (boolean)handleIsTableLink()
     */
    public final boolean isTableLink()
    {
        boolean tableLink22a = this.tableLink22a;
        if (!this.tableLink22aSet)
        {
            // tableLink has no pre constraints
            tableLink22a = handleIsTableLink();
            // tableLink has no post constraints
            this.tableLink22a = tableLink22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableLink22aSet = true;
            }
        }
        return tableLink22a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private transient String onlineHelpKey23a;
    private transient boolean onlineHelpKey23aSet = false;

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String onlineHelpKey23a = this.onlineHelpKey23a;
        if (!this.onlineHelpKey23aSet)
        {
            // onlineHelpKey has no pre constraints
            onlineHelpKey23a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.onlineHelpKey23a = onlineHelpKey23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpKey23aSet = true;
            }
        }
        return onlineHelpKey23a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private transient String onlineHelpValue24a;
    private transient boolean onlineHelpValue24aSet = false;

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String onlineHelpValue24a = this.onlineHelpValue24a;
        if (!this.onlineHelpValue24aSet)
        {
            // onlineHelpValue has no pre constraints
            onlineHelpValue24a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.onlineHelpValue24a = onlineHelpValue24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpValue24aSet = true;
            }
        }
        return onlineHelpValue24a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionScope()
    * @return String
    */
    protected abstract String handleGetActionScope();

    private transient String actionScope25a;
    private transient boolean actionScope25aSet = false;

    /**
     * The scope in which the form bean will be placed (could be page, request, session or
     * application).
     * @return (String)handleGetActionScope()
     */
    public final String getActionScope()
    {
        String actionScope25a = this.actionScope25a;
        if (!this.actionScope25aSet)
        {
            // actionScope has no pre constraints
            actionScope25a = handleGetActionScope();
            // actionScope has no post constraints
            this.actionScope25a = actionScope25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionScope25aSet = true;
            }
        }
        return actionScope25a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanPackageName()
    * @return String
    */
    protected abstract String handleGetFormBeanPackageName();

    private transient String formBeanPackageName26a;
    private transient boolean formBeanPackageName26aSet = false;

    /**
     * The package for the form bean.
     * @return (String)handleGetFormBeanPackageName()
     */
    public final String getFormBeanPackageName()
    {
        String formBeanPackageName26a = this.formBeanPackageName26a;
        if (!this.formBeanPackageName26aSet)
        {
            // formBeanPackageName has no pre constraints
            formBeanPackageName26a = handleGetFormBeanPackageName();
            // formBeanPackageName has no post constraints
            this.formBeanPackageName26a = formBeanPackageName26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanPackageName26aSet = true;
            }
        }
        return formBeanPackageName26a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionType()
    * @return String
    */
    protected abstract String handleGetActionType();

    private transient String actionType27a;
    private transient boolean actionType27aSet = false;

    /**
     * The fully qualified name for the action class.
     * @return (String)handleGetActionType()
     */
    public final String getActionType()
    {
        String actionType27a = this.actionType27a;
        if (!this.actionType27aSet)
        {
            // actionType has no pre constraints
            actionType27a = handleGetActionType();
            // actionType has no post constraints
            this.actionType27a = actionType27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionType27aSet = true;
            }
        }
        return actionType27a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getStyleId()
    * @return String
    */
    protected abstract String handleGetStyleId();

    private transient String styleId28a;
    private transient boolean styleId28aSet = false;

    /**
     * The name of the CSS id in which this action will be contained.
     * @return (String)handleGetStyleId()
     */
    public final String getStyleId()
    {
        String styleId28a = this.styleId28a;
        if (!this.styleId28aSet)
        {
            // styleId has no pre constraints
            styleId28a = handleGetStyleId();
            // styleId has no post constraints
            this.styleId28a = styleId28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.styleId28aSet = true;
            }
        }
        return styleId28a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isRedirect()
    * @return boolean
    */
    protected abstract boolean handleIsRedirect();

    private transient boolean redirect29a;
    private transient boolean redirect29aSet = false;

    /**
     * Defines whether or not when this action's forward is executed, an HTTP redirect should occur.
     *  Default value is based on the value of the 'defaultActionRedirect' namespace.
     * @return (boolean)handleIsRedirect()
     */
    public final boolean isRedirect()
    {
        boolean redirect29a = this.redirect29a;
        if (!this.redirect29aSet)
        {
            // redirect has no pre constraints
            redirect29a = handleIsRedirect();
            // redirect has no post constraints
            this.redirect29a = redirect29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.redirect29aSet = true;
            }
        }
        return redirect29a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormScope()
    * @return String
    */
    protected abstract String handleGetFormScope();

    private transient String formScope30a;
    private transient boolean formScope30aSet = false;

    /**
     * The scope to place the current "form" variable within when this action is executing.
     * @return (String)handleGetFormScope()
     */
    public final String getFormScope()
    {
        String formScope30a = this.formScope30a;
        if (!this.formScope30aSet)
        {
            // formScope has no pre constraints
            formScope30a = handleGetFormScope();
            // formScope has no post constraints
            this.formScope30a = formScope30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formScope30aSet = true;
            }
        }
        return formScope30a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeSession()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeSession();

    private transient boolean formScopeSession31a;
    private transient boolean formScopeSession31aSet = false;

    /**
     * Indicates if the form scope is of type "session".
     * @return (boolean)handleIsFormScopeSession()
     */
    public final boolean isFormScopeSession()
    {
        boolean formScopeSession31a = this.formScopeSession31a;
        if (!this.formScopeSession31aSet)
        {
            // formScopeSession has no pre constraints
            formScopeSession31a = handleIsFormScopeSession();
            // formScopeSession has no post constraints
            this.formScopeSession31a = formScopeSession31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formScopeSession31aSet = true;
            }
        }
        return formScopeSession31a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeRequest()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeRequest();

    private transient boolean formScopeRequest32a;
    private transient boolean formScopeRequest32aSet = false;

    /**
     * Indicates if the from scope is of type "request".
     * @return (boolean)handleIsFormScopeRequest()
     */
    public final boolean isFormScopeRequest()
    {
        boolean formScopeRequest32a = this.formScopeRequest32a;
        if (!this.formScopeRequest32aSet)
        {
            // formScopeRequest has no pre constraints
            formScopeRequest32a = handleIsFormScopeRequest();
            // formScopeRequest has no post constraints
            this.formScopeRequest32a = formScopeRequest32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formScopeRequest32aSet = true;
            }
        }
        return formScopeRequest32a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeNone()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeNone();

    private transient boolean formScopeNone33a;
    private transient boolean formScopeNone33aSet = false;

    /**
     * Indicates if the form scope is of type "none".
     * @return (boolean)handleIsFormScopeNone()
     */
    public final boolean isFormScopeNone()
    {
        boolean formScopeNone33a = this.formScopeNone33a;
        if (!this.formScopeNone33aSet)
        {
            // formScopeNone has no pre constraints
            formScopeNone33a = handleIsFormScopeNone();
            // formScopeNone has no post constraints
            this.formScopeNone33a = formScopeNone33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formScopeNone33aSet = true;
            }
        }
        return formScopeNone33a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTableLinkName()
    * @return String
    */
    protected abstract String handleGetTableLinkName();

    private transient String tableLinkName34a;
    private transient boolean tableLinkName34aSet = false;

    /**
     * The name of the table link specified for this action.
     * @return (String)handleGetTableLinkName()
     */
    public final String getTableLinkName()
    {
        String tableLinkName34a = this.tableLinkName34a;
        if (!this.tableLinkName34aSet)
        {
            // tableLinkName has no pre constraints
            tableLinkName34a = handleGetTableLinkName();
            // tableLinkName has no post constraints
            this.tableLinkName34a = tableLinkName34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableLinkName34aSet = true;
            }
        }
        return tableLinkName34a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTableLinkColumnName()
    * @return String
    */
    protected abstract String handleGetTableLinkColumnName();

    private transient String tableLinkColumnName35a;
    private transient boolean tableLinkColumnName35aSet = false;

    /**
     * The name of the column targetted by this action.
     * @return (String)handleGetTableLinkColumnName()
     */
    public final String getTableLinkColumnName()
    {
        String tableLinkColumnName35a = this.tableLinkColumnName35a;
        if (!this.tableLinkColumnName35aSet)
        {
            // tableLinkColumnName has no pre constraints
            tableLinkColumnName35a = handleGetTableLinkColumnName();
            // tableLinkColumnName has no post constraints
            this.tableLinkColumnName35a = tableLinkColumnName35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableLinkColumnName35aSet = true;
            }
        }
        return tableLinkColumnName35a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isImageLink()
    * @return boolean
    */
    protected abstract boolean handleIsImageLink();

    private transient boolean imageLink36a;
    private transient boolean imageLink36aSet = false;

    /**
     * Specifies whether or not this action is represented by clicking on an image.
     * @return (boolean)handleIsImageLink()
     */
    public final boolean isImageLink()
    {
        boolean imageLink36a = this.imageLink36a;
        if (!this.imageLink36aSet)
        {
            // imageLink has no pre constraints
            imageLink36a = handleIsImageLink();
            // imageLink has no post constraints
            this.imageLink36a = imageLink36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.imageLink36aSet = true;
            }
        }
        return imageLink36a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getImagePath()
    * @return String
    */
    protected abstract String handleGetImagePath();

    private transient String imagePath37a;
    private transient boolean imagePath37aSet = false;

    /**
     * If this action is an imageLink this property represents the path to the corresponding image.
     * @return (String)handleGetImagePath()
     */
    public final String getImagePath()
    {
        String imagePath37a = this.imagePath37a;
        if (!this.imagePath37aSet)
        {
            // imagePath has no pre constraints
            imagePath37a = handleGetImagePath();
            // imagePath has no post constraints
            this.imagePath37a = imagePath37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.imagePath37aSet = true;
            }
        }
        return imagePath37a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private transient String messageKey38a;
    private transient boolean messageKey38aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiAction.messageKey
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String messageKey38a = this.messageKey38a;
        if (!this.messageKey38aSet)
        {
            // messageKey has no pre constraints
            messageKey38a = handleGetMessageKey();
            // messageKey has no post constraints
            this.messageKey38a = messageKey38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageKey38aSet = true;
            }
        }
        return messageKey38a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getImageMessageKey()
    * @return String
    */
    protected abstract String handleGetImageMessageKey();

    private transient String imageMessageKey39a;
    private transient boolean imageMessageKey39aSet = false;

    /**
     * The resource message key used to look to location of the image for this action.
     * @return (String)handleGetImageMessageKey()
     */
    public final String getImageMessageKey()
    {
        String imageMessageKey39a = this.imageMessageKey39a;
        if (!this.imageMessageKey39aSet)
        {
            // imageMessageKey has no pre constraints
            imageMessageKey39a = handleGetImageMessageKey();
            // imageMessageKey has no post constraints
            this.imageMessageKey39a = imageMessageKey39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.imageMessageKey39aSet = true;
            }
        }
        return imageMessageKey39a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableAction()
    * @return boolean
    */
    protected abstract boolean handleIsTableAction();

    private transient boolean tableAction40a;
    private transient boolean tableAction40aSet = false;

    /**
     * Denotes this action works on all rows of the table from the table link relation.
     * @return (boolean)handleIsTableAction()
     */
    public final boolean isTableAction()
    {
        boolean tableAction40a = this.tableAction40a;
        if (!this.tableAction40aSet)
        {
            // tableAction has no pre constraints
            tableAction40a = handleIsTableAction();
            // tableAction has no post constraints
            this.tableAction40a = tableAction40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableAction40aSet = true;
            }
        }
        return tableAction40a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableRowAction()
    * @return boolean
    */
    protected abstract boolean handleIsTableRowAction();

    private transient boolean tableRowAction41a;
    private transient boolean tableRowAction41aSet = false;

    /**
     * Denotes this action works on a single row of the table from the table link relation.
     * @return (boolean)handleIsTableRowAction()
     */
    public final boolean isTableRowAction()
    {
        boolean tableRowAction41a = this.tableRowAction41a;
        if (!this.tableRowAction41aSet)
        {
            // tableRowAction has no pre constraints
            tableRowAction41a = handleIsTableRowAction();
            // tableRowAction has no post constraints
            this.tableRowAction41a = tableRowAction41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableRowAction41aSet = true;
            }
        }
        return tableRowAction41a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isMultipartFormData()
    * @return boolean
    */
    protected abstract boolean handleIsMultipartFormData();

    private transient boolean multipartFormData42a;
    private transient boolean multipartFormData42aSet = false;

    /**
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return (boolean)handleIsMultipartFormData()
     */
    public final boolean isMultipartFormData()
    {
        boolean multipartFormData42a = this.multipartFormData42a;
        if (!this.multipartFormData42aSet)
        {
            // multipartFormData has no pre constraints
            multipartFormData42a = handleIsMultipartFormData();
            // multipartFormData has no post constraints
            this.multipartFormData42a = multipartFormData42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.multipartFormData42aSet = true;
            }
        }
        return multipartFormData42a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationName()
    * @return String
    */
    protected abstract String handleGetFormImplementationName();

    private transient String formImplementationName43a;
    private transient boolean formImplementationName43aSet = false;

    /**
     * The name of the form implementation.
     * @return (String)handleGetFormImplementationName()
     */
    public final String getFormImplementationName()
    {
        String formImplementationName43a = this.formImplementationName43a;
        if (!this.formImplementationName43aSet)
        {
            // formImplementationName has no pre constraints
            formImplementationName43a = handleGetFormImplementationName();
            // formImplementationName has no post constraints
            this.formImplementationName43a = formImplementationName43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formImplementationName43aSet = true;
            }
        }
        return formImplementationName43a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedFormImplementationName();

    private transient String fullyQualifiedFormImplementationName44a;
    private transient boolean fullyQualifiedFormImplementationName44aSet = false;

    /**
     * The fully qualified name of the form implementation.
     * @return (String)handleGetFullyQualifiedFormImplementationName()
     */
    public final String getFullyQualifiedFormImplementationName()
    {
        String fullyQualifiedFormImplementationName44a = this.fullyQualifiedFormImplementationName44a;
        if (!this.fullyQualifiedFormImplementationName44aSet)
        {
            // fullyQualifiedFormImplementationName has no pre constraints
            fullyQualifiedFormImplementationName44a = handleGetFullyQualifiedFormImplementationName();
            // fullyQualifiedFormImplementationName has no post constraints
            this.fullyQualifiedFormImplementationName44a = fullyQualifiedFormImplementationName44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedFormImplementationName44aSet = true;
            }
        }
        return fullyQualifiedFormImplementationName44a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedFormImplementationPath();

    private transient String fullyQualifiedFormImplementationPath45a;
    private transient boolean fullyQualifiedFormImplementationPath45aSet = false;

    /**
     * The fully qualified path of the form implementation.
     * @return (String)handleGetFullyQualifiedFormImplementationPath()
     */
    public final String getFullyQualifiedFormImplementationPath()
    {
        String fullyQualifiedFormImplementationPath45a = this.fullyQualifiedFormImplementationPath45a;
        if (!this.fullyQualifiedFormImplementationPath45aSet)
        {
            // fullyQualifiedFormImplementationPath has no pre constraints
            fullyQualifiedFormImplementationPath45a = handleGetFullyQualifiedFormImplementationPath();
            // fullyQualifiedFormImplementationPath has no post constraints
            this.fullyQualifiedFormImplementationPath45a = fullyQualifiedFormImplementationPath45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedFormImplementationPath45aSet = true;
            }
        }
        return fullyQualifiedFormImplementationPath45a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationInterfaceList()
    * @return String
    */
    protected abstract String handleGetFormImplementationInterfaceList();

    private transient String formImplementationInterfaceList46a;
    private transient boolean formImplementationInterfaceList46aSet = false;

    /**
     * A comma separated list of all the form interfaces which the form implementation implements.
     * @return (String)handleGetFormImplementationInterfaceList()
     */
    public final String getFormImplementationInterfaceList()
    {
        String formImplementationInterfaceList46a = this.formImplementationInterfaceList46a;
        if (!this.formImplementationInterfaceList46aSet)
        {
            // formImplementationInterfaceList has no pre constraints
            formImplementationInterfaceList46a = handleGetFormImplementationInterfaceList();
            // formImplementationInterfaceList has no post constraints
            this.formImplementationInterfaceList46a = formImplementationInterfaceList46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formImplementationInterfaceList46aSet = true;
            }
        }
        return formImplementationInterfaceList46a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getPath()
    * @return String
    */
    protected abstract String handleGetPath();

    private transient String path47a;
    private transient boolean path47aSet = false;

    /**
     * The path to this action.
     * @return (String)handleGetPath()
     */
    public final String getPath()
    {
        String path47a = this.path47a;
        if (!this.path47aSet)
        {
            // path has no pre constraints
            path47a = handleGetPath();
            // path has no post constraints
            this.path47a = path47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.path47aSet = true;
            }
        }
        return path47a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getPathRoot()
    * @return String
    */
    protected abstract String handleGetPathRoot();

    private transient String pathRoot48a;
    private transient boolean pathRoot48aSet = false;

    /**
     * The path's root.
     * @return (String)handleGetPathRoot()
     */
    public final String getPathRoot()
    {
        String pathRoot48a = this.pathRoot48a;
        if (!this.pathRoot48aSet)
        {
            // pathRoot has no pre constraints
            pathRoot48a = handleGetPathRoot();
            // pathRoot has no post constraints
            this.pathRoot48a = pathRoot48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.pathRoot48aSet = true;
            }
        }
        return pathRoot48a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTriggerName()
    * @return String
    */
    protected abstract String handleGetTriggerName();

    private transient String triggerName49a;
    private transient boolean triggerName49aSet = false;

    /**
     * The name of the trigger that triggers that action.
     * @return (String)handleGetTriggerName()
     */
    public final String getTriggerName()
    {
        String triggerName49a = this.triggerName49a;
        if (!this.triggerName49aSet)
        {
            // triggerName has no pre constraints
            triggerName49a = handleGetTriggerName();
            // triggerName has no post constraints
            this.triggerName49a = triggerName49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.triggerName49aSet = true;
            }
        }
        return triggerName49a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getViewFragmentPath()
    * @return String
    */
    protected abstract String handleGetViewFragmentPath();

    private transient String viewFragmentPath50a;
    private transient boolean viewFragmentPath50aSet = false;

    /**
     * The path to the view fragment corresponding to this action
     * @return (String)handleGetViewFragmentPath()
     */
    public final String getViewFragmentPath()
    {
        String viewFragmentPath50a = this.viewFragmentPath50a;
        if (!this.viewFragmentPath50aSet)
        {
            // viewFragmentPath has no pre constraints
            viewFragmentPath50a = handleGetViewFragmentPath();
            // viewFragmentPath has no post constraints
            this.viewFragmentPath50a = viewFragmentPath50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewFragmentPath50aSet = true;
            }
        }
        return viewFragmentPath50a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedActionClassPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassPath();

    private transient String fullyQualifiedActionClassPath51a;
    private transient boolean fullyQualifiedActionClassPath51aSet = false;

    /**
     * The fully qualified path to the action class that execute this action.
     * @return (String)handleGetFullyQualifiedActionClassPath()
     */
    public final String getFullyQualifiedActionClassPath()
    {
        String fullyQualifiedActionClassPath51a = this.fullyQualifiedActionClassPath51a;
        if (!this.fullyQualifiedActionClassPath51aSet)
        {
            // fullyQualifiedActionClassPath has no pre constraints
            fullyQualifiedActionClassPath51a = handleGetFullyQualifiedActionClassPath();
            // fullyQualifiedActionClassPath has no post constraints
            this.fullyQualifiedActionClassPath51a = fullyQualifiedActionClassPath51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedActionClassPath51aSet = true;
            }
        }
        return fullyQualifiedActionClassPath51a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getControllerAction()
    * @return String
    */
    protected abstract String handleGetControllerAction();

    private transient String controllerAction52a;
    private transient boolean controllerAction52aSet = false;

    /**
     * The name of the action on the controller that executions this action.
     * @return (String)handleGetControllerAction()
     */
    public final String getControllerAction()
    {
        String controllerAction52a = this.controllerAction52a;
        if (!this.controllerAction52aSet)
        {
            // controllerAction has no pre constraints
            controllerAction52a = handleGetControllerAction();
            // controllerAction has no post constraints
            this.controllerAction52a = controllerAction52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.controllerAction52aSet = true;
            }
        }
        return controllerAction52a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedActionClassName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassName();

    private transient String fullyQualifiedActionClassName53a;
    private transient boolean fullyQualifiedActionClassName53aSet = false;

    /**
     * The fully qualified name of the action class that execute this action.
     * @return (String)handleGetFullyQualifiedActionClassName()
     */
    public final String getFullyQualifiedActionClassName()
    {
        String fullyQualifiedActionClassName53a = this.fullyQualifiedActionClassName53a;
        if (!this.fullyQualifiedActionClassName53aSet)
        {
            // fullyQualifiedActionClassName has no pre constraints
            fullyQualifiedActionClassName53a = handleGetFullyQualifiedActionClassName();
            // fullyQualifiedActionClassName has no post constraints
            this.fullyQualifiedActionClassName53a = fullyQualifiedActionClassName53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedActionClassName53aSet = true;
            }
        }
        return fullyQualifiedActionClassName53a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormKey()
    * @return String
    */
    protected abstract String handleGetFormKey();

    private transient String formKey54a;
    private transient boolean formKey54aSet = false;

    /**
     * The key that stores the form in which information is passed from one action to another.
     * @return (String)handleGetFormKey()
     */
    public final String getFormKey()
    {
        String formKey54a = this.formKey54a;
        if (!this.formKey54aSet)
        {
            // formKey has no pre constraints
            formKey54a = handleGetFormKey();
            // formKey has no post constraints
            this.formKey54a = formKey54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formKey54aSet = true;
            }
        }
        return formKey54a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isPopup()
    * @return boolean
    */
    protected abstract boolean handleIsPopup();

    private transient boolean popup55a;
    private transient boolean popup55aSet = false;

    /**
     * Indicates if this action forwards to a popup (this is determed when the targetted view is a
     * popup).
     * @return (boolean)handleIsPopup()
     */
    public final boolean isPopup()
    {
        boolean popup55a = this.popup55a;
        if (!this.popup55aSet)
        {
            // popup has no pre constraints
            popup55a = handleIsPopup();
            // popup has no post constraints
            this.popup55a = popup55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.popup55aSet = true;
            }
        }
        return popup55a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormResetRequired()
    * @return boolean
    */
    protected abstract boolean handleIsFormResetRequired();

    private transient boolean formResetRequired56a;
    private transient boolean formResetRequired56aSet = false;

    /**
     * Indicates if at least one parameter on the form requires being reset.
     * @return (boolean)handleIsFormResetRequired()
     */
    public final boolean isFormResetRequired()
    {
        boolean formResetRequired56a = this.formResetRequired56a;
        if (!this.formResetRequired56aSet)
        {
            // formResetRequired has no pre constraints
            formResetRequired56a = handleIsFormResetRequired();
            // formResetRequired has no post constraints
            this.formResetRequired56a = formResetRequired56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formResetRequired56aSet = true;
            }
        }
        return formResetRequired56a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormReset()
    * @return boolean
    */
    protected abstract boolean handleIsFormReset();

    private transient boolean formReset57a;
    private transient boolean formReset57aSet = false;

    /**
     * Whether or not the entire form should be reset (all action parameters on the form).
     * @return (boolean)handleIsFormReset()
     */
    public final boolean isFormReset()
    {
        boolean formReset57a = this.formReset57a;
        if (!this.formReset57aSet)
        {
            // formReset has no pre constraints
            formReset57a = handleIsFormReset();
            // formReset has no post constraints
            this.formReset57a = formReset57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formReset57aSet = true;
            }
        }
        return formReset57a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationGetter()
    * @return String
    */
    protected abstract String handleGetFormImplementationGetter();

    private transient String formImplementationGetter58a;
    private transient boolean formImplementationGetter58aSet = false;

    /**
     * The signature of the accessor method that returns the form implementation instance.
     * @return (String)handleGetFormImplementationGetter()
     */
    public final String getFormImplementationGetter()
    {
        String formImplementationGetter58a = this.formImplementationGetter58a;
        if (!this.formImplementationGetter58aSet)
        {
            // formImplementationGetter has no pre constraints
            formImplementationGetter58a = handleGetFormImplementationGetter();
            // formImplementationGetter has no post constraints
            this.formImplementationGetter58a = formImplementationGetter58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formImplementationGetter58aSet = true;
            }
        }
        return formImplementationGetter58a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormSerialVersionUID()
    * @return String
    */
    protected abstract String handleGetFormSerialVersionUID();

    private transient String formSerialVersionUID59a;
    private transient boolean formSerialVersionUID59aSet = false;

    /**
     * The calcuated serial version UID for this action's form.
     * @return (String)handleGetFormSerialVersionUID()
     */
    public final String getFormSerialVersionUID()
    {
        String formSerialVersionUID59a = this.formSerialVersionUID59a;
        if (!this.formSerialVersionUID59aSet)
        {
            // formSerialVersionUID has no pre constraints
            formSerialVersionUID59a = handleGetFormSerialVersionUID();
            // formSerialVersionUID has no post constraints
            this.formSerialVersionUID59a = formSerialVersionUID59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formSerialVersionUID59aSet = true;
            }
        }
        return formSerialVersionUID59a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFinalStateTarget()
    * @return boolean
    */
    protected abstract boolean handleIsFinalStateTarget();

    private transient boolean finalStateTarget60a;
    private transient boolean finalStateTarget60aSet = false;

    /**
     * Indicates whether or not a final state is the target of this action.
     * @return (boolean)handleIsFinalStateTarget()
     */
    public final boolean isFinalStateTarget()
    {
        boolean finalStateTarget60a = this.finalStateTarget60a;
        if (!this.finalStateTarget60aSet)
        {
            // finalStateTarget has no pre constraints
            finalStateTarget60a = handleIsFinalStateTarget();
            // finalStateTarget has no post constraints
            this.finalStateTarget60a = finalStateTarget60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.finalStateTarget60aSet = true;
            }
        }
        return finalStateTarget60a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFromOutcome()
    * @return String
    */
    protected abstract String handleGetFromOutcome();

    private transient String fromOutcome61a;
    private transient boolean fromOutcome61aSet = false;

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @return (String)handleGetFromOutcome()
     */
    public final String getFromOutcome()
    {
        String fromOutcome61a = this.fromOutcome61a;
        if (!this.fromOutcome61aSet)
        {
            // fromOutcome has no pre constraints
            fromOutcome61a = handleGetFromOutcome();
            // fromOutcome has no post constraints
            this.fromOutcome61a = fromOutcome61a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fromOutcome61aSet = true;
            }
        }
        return fromOutcome61a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isWarningMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsWarningMessagesPresent();

    private transient boolean warningMessagesPresent62a;
    private transient boolean warningMessagesPresent62aSet = false;

    /**
     * Whether or not any warning messages are present.
     * @return (boolean)handleIsWarningMessagesPresent()
     */
    public final boolean isWarningMessagesPresent()
    {
        boolean warningMessagesPresent62a = this.warningMessagesPresent62a;
        if (!this.warningMessagesPresent62aSet)
        {
            // warningMessagesPresent has no pre constraints
            warningMessagesPresent62a = handleIsWarningMessagesPresent();
            // warningMessagesPresent has no post constraints
            this.warningMessagesPresent62a = warningMessagesPresent62a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.warningMessagesPresent62aSet = true;
            }
        }
        return warningMessagesPresent62a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getWarningMessages()
    * @return Map
    */
    protected abstract Map handleGetWarningMessages();

    private transient Map warningMessages63a;
    private transient boolean warningMessages63aSet = false;

    /**
     * Any messages used to indicate a warning.
     * @return (Map)handleGetWarningMessages()
     */
    public final Map getWarningMessages()
    {
        Map warningMessages63a = this.warningMessages63a;
        if (!this.warningMessages63aSet)
        {
            // warningMessages has no pre constraints
            warningMessages63a = handleGetWarningMessages();
            // warningMessages has no post constraints
            this.warningMessages63a = warningMessages63a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.warningMessages63aSet = true;
            }
        }
        return warningMessages63a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isSuccessMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsSuccessMessagesPresent();

    private transient boolean successMessagesPresent64a;
    private transient boolean successMessagesPresent64aSet = false;

    /**
     * Indicates whether or not any success messags are present.
     * @return (boolean)handleIsSuccessMessagesPresent()
     */
    public final boolean isSuccessMessagesPresent()
    {
        boolean successMessagesPresent64a = this.successMessagesPresent64a;
        if (!this.successMessagesPresent64aSet)
        {
            // successMessagesPresent has no pre constraints
            successMessagesPresent64a = handleIsSuccessMessagesPresent();
            // successMessagesPresent has no post constraints
            this.successMessagesPresent64a = successMessagesPresent64a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.successMessagesPresent64aSet = true;
            }
        }
        return successMessagesPresent64a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getSuccessMessages()
    * @return Map
    */
    protected abstract Map handleGetSuccessMessages();

    private transient Map successMessages65a;
    private transient boolean successMessages65aSet = false;

    /**
     * Messages used to indicate successful execution.
     * @return (Map)handleGetSuccessMessages()
     */
    public final Map getSuccessMessages()
    {
        Map successMessages65a = this.successMessages65a;
        if (!this.successMessages65aSet)
        {
            // successMessages has no pre constraints
            successMessages65a = handleGetSuccessMessages();
            // successMessages has no post constraints
            this.successMessages65a = successMessages65a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.successMessages65aSet = true;
            }
        }
        return successMessages65a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isErrorMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsErrorMessagesPresent();

    private transient boolean errorMessagesPresent66a;
    private transient boolean errorMessagesPresent66aSet = false;

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiAction.errorMessagesPresent
     * @return (boolean)handleIsErrorMessagesPresent()
     */
    public final boolean isErrorMessagesPresent()
    {
        boolean errorMessagesPresent66a = this.errorMessagesPresent66a;
        if (!this.errorMessagesPresent66aSet)
        {
            // errorMessagesPresent has no pre constraints
            errorMessagesPresent66a = handleIsErrorMessagesPresent();
            // errorMessagesPresent has no post constraints
            this.errorMessagesPresent66a = errorMessagesPresent66a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.errorMessagesPresent66aSet = true;
            }
        }
        return errorMessagesPresent66a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getErrorMessages()
    * @return Map
    */
    protected abstract Map handleGetErrorMessages();

    private transient Map errorMessages67a;
    private transient boolean errorMessages67aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiAction.errorMessages
     * @return (Map)handleGetErrorMessages()
     */
    public final Map getErrorMessages()
    {
        Map errorMessages67a = this.errorMessages67a;
        if (!this.errorMessages67aSet)
        {
            // errorMessages has no pre constraints
            errorMessages67a = handleGetErrorMessages();
            // errorMessages has no post constraints
            this.errorMessages67a = errorMessages67a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.errorMessages67aSet = true;
            }
        }
        return errorMessages67a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isNeedsFileUpload()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsFileUpload();

    private transient boolean needsFileUpload68a;
    private transient boolean needsFileUpload68aSet = false;

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiAction.needsFileUpload
     * @return (boolean)handleIsNeedsFileUpload()
     */
    public final boolean isNeedsFileUpload()
    {
        boolean needsFileUpload68a = this.needsFileUpload68a;
        if (!this.needsFileUpload68aSet)
        {
            // needsFileUpload has no pre constraints
            needsFileUpload68a = handleIsNeedsFileUpload();
            // needsFileUpload has no post constraints
            this.needsFileUpload68a = needsFileUpload68a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.needsFileUpload68aSet = true;
            }
        }
        return needsFileUpload68a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTriggerMethodName()
    * @return String
    */
    protected abstract String handleGetTriggerMethodName();

    private transient String triggerMethodName69a;
    private transient boolean triggerMethodName69aSet = false;

    /**
     * The name of the method to be executed when this action is triggered.
     * @return (String)handleGetTriggerMethodName()
     */
    public final String getTriggerMethodName()
    {
        String triggerMethodName69a = this.triggerMethodName69a;
        if (!this.triggerMethodName69aSet)
        {
            // triggerMethodName has no pre constraints
            triggerMethodName69a = handleGetTriggerMethodName();
            // triggerMethodName has no post constraints
            this.triggerMethodName69a = triggerMethodName69a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.triggerMethodName69aSet = true;
            }
        }
        return triggerMethodName69a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getHiddenParameters()
    * @return List<GuiParameter>
    */
    protected abstract List<GuiParameter> handleGetHiddenParameters();

    private transient List<GuiParameter> hiddenParameters70a;
    private transient boolean hiddenParameters70aSet = false;

    /**
     * All parameters that are of hidden input type.
     * @return (List<GuiParameter>)handleGetHiddenParameters()
     */
    public final List<GuiParameter> getHiddenParameters()
    {
        List<GuiParameter> hiddenParameters70a = this.hiddenParameters70a;
        if (!this.hiddenParameters70aSet)
        {
            // hiddenParameters has no pre constraints
            hiddenParameters70a = handleGetHiddenParameters();
            // hiddenParameters has no post constraints
            this.hiddenParameters70a = hiddenParameters70a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hiddenParameters70aSet = true;
            }
        }
        return hiddenParameters70a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Those parameters that are directly entering a final state and have been submitted into the
     * request, they will be able to survive a trip to the next use-case. All returned elements are
     * of type GuiParameter.
     * @param finalState
     * @return List
     */
    protected abstract List handleGetInterUseCaseParameters(GuiFinalState finalState);

    /**
     * Those parameters that are directly entering a final state and have been submitted into the
     * request, they will be able to survive a trip to the next use-case. All returned elements are
     * of type GuiParameter.
     * @param finalState GuiFinalState
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiAction.getInterUseCaseParameters(finalState)
     * @return handleGetInterUseCaseParameters(finalState)
     */
    public List getInterUseCaseParameters(GuiFinalState finalState)
    {
        // getInterUseCaseParameters has no pre constraints
        List returnValue = handleGetInterUseCaseParameters(finalState);
        // getInterUseCaseParameters has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    private transient List<GuiView> getTargetPages1r;
    private transient boolean getTargetPages1rSet = false;

    /**
     * Returns all actions that possibly result in returning this page.
     * @return (List<GuiView>)handleGetTargetPages()
     */
    public final List<GuiView> getTargetPages()
    {
        List<GuiView> getTargetPages1r = this.getTargetPages1r;
        if (!this.getTargetPages1rSet)
        {
            // incomingActions has no pre constraints
            List result = handleGetTargetPages();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getTargetPages1r = (List<GuiView>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getTargetPages List<GuiView> " + result + ": " + shieldedResult);
            }
            // incomingActions has no post constraints
            this.getTargetPages1r = getTargetPages1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getTargetPages1rSet = true;
            }
        }
        return getTargetPages1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetTargetPages();

    private transient List<GuiParameter> getActionParametersToDeletes2r;
    private transient boolean getActionParametersToDeletes2rSet = false;

    /**
     * The actions used when submitting forms for this table. Table actions that are hyperlinks are
     * not included. It only makes sense to call this property on parameters that represent a table
     * page-variable.
     * @return (List<GuiParameter>)handleGetActionParametersToDeletes()
     */
    public final List<GuiParameter> getActionParametersToDeletes()
    {
        List<GuiParameter> getActionParametersToDeletes2r = this.getActionParametersToDeletes2r;
        if (!this.getActionParametersToDeletes2rSet)
        {
            // tableFormActions has no pre constraints
            List result = handleGetActionParametersToDeletes();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getActionParametersToDeletes2r = (List<GuiParameter>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getActionParametersToDeletes List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // tableFormActions has no post constraints
            this.getActionParametersToDeletes2r = getActionParametersToDeletes2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getActionParametersToDeletes2rSet = true;
            }
        }
        return getActionParametersToDeletes2r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetActionParametersToDeletes();

    private transient List<GuiParameter> getActionFormFieldsToDeletes3r;
    private transient boolean getActionFormFieldsToDeletes3rSet = false;

    /**
     * Represents a Gui action. Such an action typically is associated with a form bean handling all
     * parameters of this action.
     * This action model element extends a transition, but the actual logic contained by the action
     * envelops all action states called, until either a final state or View is reached.
     * @return (List<GuiParameter>)handleGetActionFormFieldsToDeletes()
     */
    public final List<GuiParameter> getActionFormFieldsToDeletes()
    {
        List<GuiParameter> getActionFormFieldsToDeletes3r = this.getActionFormFieldsToDeletes3r;
        if (!this.getActionFormFieldsToDeletes3rSet)
        {
            // guiAction has no pre constraints
            List result = handleGetActionFormFieldsToDeletes();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getActionFormFieldsToDeletes3r = (List<GuiParameter>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getActionFormFieldsToDeletes List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiAction has no post constraints
            this.getActionFormFieldsToDeletes3r = getActionFormFieldsToDeletes3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getActionFormFieldsToDeletes3rSet = true;
            }
        }
        return getActionFormFieldsToDeletes3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetActionFormFieldsToDeletes();

    private transient List<GuiParameter> getResettableActionParameters4r;
    private transient boolean getResettableActionParameters4rSet = false;

    /**
     * Represents a Gui action. Such an action typically is associated with a form bean handling all
     * parameters of this action.
     * This action model element extends a transition, but the actual logic contained by the action
     * envelops all action states called, until either a final state or View is reached.
     * @return (List<GuiParameter>)handleGetResettableActionParameters()
     */
    public final List<GuiParameter> getResettableActionParameters()
    {
        List<GuiParameter> getResettableActionParameters4r = this.getResettableActionParameters4r;
        if (!this.getResettableActionParameters4rSet)
        {
            // guiAction has no pre constraints
            List result = handleGetResettableActionParameters();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getResettableActionParameters4r = (List<GuiParameter>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getResettableActionParameters List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiAction has no post constraints
            this.getResettableActionParameters4r = getResettableActionParameters4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getResettableActionParameters4rSet = true;
            }
        }
        return getResettableActionParameters4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetResettableActionParameters();

    private transient List<GuiExceptionHandler> getActionExceptionsToDeletes5r;
    private transient boolean getActionExceptionsToDeletes5rSet = false;

    /**
     * Represents a Gui action. Such an action typically is associated with a form bean handling all
     * parameters of this action.
     * This action model element extends a transition, but the actual logic contained by the action
     * envelops all action states called, until either a final state or View is reached.
     * @return (List<GuiExceptionHandler>)handleGetActionExceptionsToDeletes()
     */
    public final List<GuiExceptionHandler> getActionExceptionsToDeletes()
    {
        List<GuiExceptionHandler> getActionExceptionsToDeletes5r = this.getActionExceptionsToDeletes5r;
        if (!this.getActionExceptionsToDeletes5rSet)
        {
            // guiAction has no pre constraints
            List result = handleGetActionExceptionsToDeletes();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getActionExceptionsToDeletes5r = (List<GuiExceptionHandler>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getActionExceptionsToDeletes List<GuiExceptionHandler> " + result + ": " + shieldedResult);
            }
            // guiAction has no post constraints
            this.getActionExceptionsToDeletes5r = getActionExceptionsToDeletes5r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getActionExceptionsToDeletes5rSet = true;
            }
        }
        return getActionExceptionsToDeletes5r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetActionExceptionsToDeletes();

    /**
     * Represents a Gui action. Such an action typically is associated with a form bean handling all
     * parameters of this action.
     * This action model element extends a transition, but the actual logic contained by the action
     * envelops all action states called, until either a final state or View is reached.
     * @return (List<GuiParameter>)handleGetTableNonColumnFormParameters()
     */
    public final List<GuiParameter> getTableNonColumnFormParameters()
    {
        List<GuiParameter> getTableNonColumnFormParameters6r = null;
        // guiAction has no pre constraints
        List result = handleGetTableNonColumnFormParameters();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getTableNonColumnFormParameters6r = (List<GuiParameter>) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getTableNonColumnFormParameters List<GuiParameter> " + result + ": " + shieldedResult);
        }
        // guiAction has no post constraints
        return getTableNonColumnFormParameters6r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetTableNonColumnFormParameters();

    /**
     * Represents a Gui action. Such an action typically is associated with a form bean handling all
     * parameters of this action.
     * This action model element extends a transition, but the actual logic contained by the action
     * envelops all action states called, until either a final state or View is reached.
     * @return (List<GuiParameter>)handleGetHiddenActionParameters()
     */
    public final List<GuiParameter> getHiddenActionParameters()
    {
        List<GuiParameter> getHiddenActionParameters7r = null;
        // guiAction has no pre constraints
        List result = handleGetHiddenActionParameters();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getHiddenActionParameters7r = (List<GuiParameter>) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getHiddenActionParameters List<GuiParameter> " + result + ": " + shieldedResult);
        }
        // guiAction has no post constraints
        return getHiddenActionParameters7r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetHiddenActionParameters();

    private transient GuiParameter getTableLinkParameter8r;
    private transient boolean getTableLinkParameter8rSet = false;

    /**
     * Those actions that are working on this table and are to be represented as hyperlinks. It only
     * makes sense to call this property on parameters that represent a table page-variable.
     * @return (GuiParameter)handleGetTableLinkParameter()
     */
    public final GuiParameter getTableLinkParameter()
    {
        GuiParameter getTableLinkParameter8r = this.getTableLinkParameter8r;
        if (!this.getTableLinkParameter8rSet)
        {
            // tableHyperlinkActions has no pre constraints
            Object result = handleGetTableLinkParameter();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getTableLinkParameter8r = (GuiParameter) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getTableLinkParameter GuiParameter " + result + ": " + shieldedResult);
            }
            // tableHyperlinkActions has no post constraints
            this.getTableLinkParameter8r = getTableLinkParameter8r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getTableLinkParameter8rSet = true;
            }
        }
        return getTableLinkParameter8r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetTableLinkParameter();

    private transient GuiTrigger getActionTriggerToDelete9r;
    private transient boolean getActionTriggerToDelete9rSet = false;

    /**
     * If isActionTrigger() returns true them this association points to the action to which the
     * trigger has been associated.
     * @return (GuiTrigger)handleGetActionTriggerToDelete()
     */
    public final GuiTrigger getActionTriggerToDelete()
    {
        GuiTrigger getActionTriggerToDelete9r = this.getActionTriggerToDelete9r;
        if (!this.getActionTriggerToDelete9rSet)
        {
            // guiAction has no pre constraints
            Object result = handleGetActionTriggerToDelete();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getActionTriggerToDelete9r = (GuiTrigger) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.LOGGER.warn("incorrect metafacade cast for GuiActionLogic.getActionTriggerToDelete GuiTrigger " + result + ": " + shieldedResult);
            }
            // guiAction has no post constraints
            this.getActionTriggerToDelete9r = getActionTriggerToDelete9r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getActionTriggerToDelete9rSet = true;
            }
        }
        return getActionTriggerToDelete9r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetActionTriggerToDelete();

    /**
     * @return true
     * @see FrontEndAction
     */
    public boolean isFrontEndActionMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see FrontEndForward
     */
    public boolean isFrontEndForwardMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.TransitionFacade
     */
    public boolean isTransitionFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ModelElementFacade
     */
    public boolean isModelElementFacadeMetaType()
    {
        return true;
    }

    // ----------- delegates to FrontEndAction ------------
    /**
     * Finds the parameter on this action having the given name, if no parameter is found, null is
     * returned instead.
     * @see FrontEndAction#findParameter(String name)
     */
    public ParameterFacade findParameter(String name)
    {
        return this.getSuperFrontEndAction().findParameter(name);
    }

    /**
     * All action forwards for this foward. Each action forward either calls a view or another
     * use-case (which is essentially an action).
     * @see FrontEndAction#getActionForwards()
     */
    public List<FrontEndForward> getActionForwards()
    {
        return this.getSuperFrontEndAction().getActionForwards();
    }

    /**
     * All action states visited by this action.
     * @see FrontEndAction#getActionStates()
     */
    public List<FrontEndActionState> getActionStates()
    {
        return this.getSuperFrontEndAction().getActionStates();
    }

    /**
     * The controller that will handle the execution of this front-end action. This controller is
     * set as the context of the activity graph (and therefore also of the use-case).
     * @see FrontEndAction#getController()
     */
    public FrontEndController getController()
    {
        return this.getSuperFrontEndAction().getController();
    }

    /**
     * All the transitions coming out of decision points. These transitions should all carry guards.
     * @see FrontEndAction#getDecisionTransitions()
     */
    public List<FrontEndForward> getDecisionTransitions()
    {
        return this.getSuperFrontEndAction().getDecisionTransitions();
    }

    /**
     * The controller operations to which this action defers, the order is preserved.
     * @see FrontEndAction#getDeferredOperations()
     */
    public List<FrontEndControllerOperation> getDeferredOperations()
    {
        return this.getSuperFrontEndAction().getDeferredOperations();
    }

    /**
     * Form fields for this action. Form fields are those parameters that can be altered by the user
     * on a corresponding view at runtime.
     * @see FrontEndAction#getFormFields()
     */
    public List<FrontEndParameter> getFormFields()
    {
        return this.getSuperFrontEndAction().getFormFields();
    }

    /**
     * The StateVertex (FrontEndView or PseudostateFacade) on which this action can be triggered.
     * @see FrontEndAction#getInput()
     */
    public StateVertexFacade getInput()
    {
        return this.getSuperFrontEndAction().getInput();
    }

    /**
     * All parameters sent by this "front-end" action.
     * @see FrontEndAction#getParameters()
     */
    public List<FrontEndParameter> getParameters()
    {
        return this.getSuperFrontEndAction().getParameters();
    }

    /**
     * All views that can be possibly targetted by triggering this action.
     * @see FrontEndAction#getTargetViews()
     */
    public List<FrontEndView> getTargetViews()
    {
        return this.getSuperFrontEndAction().getTargetViews();
    }

    /**
     * All the transitions that make up this action, this directly maps onto the forwards.
     * @see FrontEndAction#getTransitions()
     */
    public List<FrontEndForward> getTransitions()
    {
        return this.getSuperFrontEndAction().getTransitions();
    }

    /**
     * Indicates if this action represents the beginning of the front-end use case or not.
     * @see FrontEndAction#isUseCaseStart()
     */
    public boolean isUseCaseStart()
    {
        return this.getSuperFrontEndAction().isUseCaseStart();
    }

    /**
     * The method name used to delegate to this forward.
     * @see FrontEndForward#getActionMethodName()
     */
    public String getActionMethodName()
    {
        return this.getSuperFrontEndAction().getActionMethodName();
    }

    /**
     * The front-end actions directly containing this front-end forward.
     * @see FrontEndForward#getActions()
     */
    public List<FrontEndAction> getActions()
    {
        return this.getSuperFrontEndAction().getActions();
    }

    /**
     * The trigger for this front-end forward.
     * @see FrontEndForward#getDecisionTrigger()
     */
    public FrontEndEvent getDecisionTrigger()
    {
        return this.getSuperFrontEndAction().getDecisionTrigger();
    }

    /**
     * Tthe set of parameter used during transport in this forward.
     * @see FrontEndForward#getForwardParameters()
     */
    public List<FrontEndParameter> getForwardParameters()
    {
        return this.getSuperFrontEndAction().getForwardParameters();
    }

    /**
     * The activity graph which holds this forward if the graph is contained in a FrontEndUseCase.
     * @see FrontEndForward#getFrontEndActivityGraph()
     */
    public FrontEndActivityGraph getFrontEndActivityGraph()
    {
        return this.getSuperFrontEndAction().getFrontEndActivityGraph();
    }

    /**
     * The operation to which is called during execution of this front-end forward.
     * @see FrontEndForward#getOperationCall()
     */
    public FrontEndControllerOperation getOperationCall()
    {
        return this.getSuperFrontEndAction().getOperationCall();
    }

    /**
     * The use case in which this forward is contained.
     * @see FrontEndForward#getUseCase()
     */
    public FrontEndUseCase getUseCase()
    {
        return this.getSuperFrontEndAction().getUseCase();
    }

    /**
     * Indicates if this forward is contained in a FrontEndUseCase.
     * @see FrontEndForward#isContainedInFrontEndUseCase()
     */
    public boolean isContainedInFrontEndUseCase()
    {
        return this.getSuperFrontEndAction().isContainedInFrontEndUseCase();
    }

    /**
     * Indicates if this action directly targets a "front-end" view, false otherwise.
     * @see FrontEndForward#isEnteringView()
     */
    public boolean isEnteringView()
    {
        return this.getSuperFrontEndAction().isEnteringView();
    }

    /**
     * Indicates if this forward (transition) is coming out of a front-end view.
     * @see FrontEndForward#isExitingView()
     */
    public boolean isExitingView()
    {
        return this.getSuperFrontEndAction().isExitingView();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperFrontEndAction().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperFrontEndAction().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperFrontEndAction().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperFrontEndAction().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperFrontEndAction().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperFrontEndAction().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperFrontEndAction().getDocumentation(indent);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. By default paragraphs are returned as HTML.
     * This method is equivalent to <code>getDocumentation(indent, lineLength, true)</code>.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength)
     */
    public String getDocumentation(String indent, int lineLength)
    {
        return this.getSuperFrontEndAction().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperFrontEndAction().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperFrontEndAction().getFullyQualifiedName();
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element.  If modelName is true, then
     * the original name of the model element (the name contained within the model) will be the name
     * returned, otherwise a name from a language mapping will be returned.
     * @see ModelElementFacade#getFullyQualifiedName(boolean modelName)
     */
    public String getFullyQualifiedName(boolean modelName)
    {
        return this.getSuperFrontEndAction().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperFrontEndAction().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperFrontEndAction().getId();
    }

    /**
     * UML2: Retrieves the keywords for this element. Used to modify implementation properties which
     * are not represented by other properties, i.e. native, transient, volatile, synchronized,
     * (added annotations) override, deprecated. Can also be used to suppress compiler warnings:
     * (added annotations) unchecked, fallthrough, path, serial, finally, all. Annotations require
     * JDK5 compiler level.
     * @see ModelElementFacade#getKeywords()
     */
    public Collection<String> getKeywords()
    {
        return this.getSuperFrontEndAction().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperFrontEndAction().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperFrontEndAction().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperFrontEndAction().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperFrontEndAction().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperFrontEndAction().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperFrontEndAction().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperFrontEndAction().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperFrontEndAction().getPackagePath();
    }

    /**
     * UML2: Returns the value of the 'Qualified Name' attribute. A name which allows the
     * NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from
     * the names of the containing namespaces starting at the root of the hierarchy and ending with
     * the name of the NamedElement itself.
     * @see ModelElementFacade#getQualifiedName()
     */
    public String getQualifiedName()
    {
        return this.getSuperFrontEndAction().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperFrontEndAction().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperFrontEndAction().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperFrontEndAction().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperFrontEndAction().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperFrontEndAction().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperFrontEndAction().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperFrontEndAction().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperFrontEndAction().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperFrontEndAction().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperFrontEndAction().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndAction().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperFrontEndAction().hasKeyword(keywordName);
    }

    /**
     * Returns true if the model element has the specified stereotype.  If the stereotype itself
     * does not match, then a search will be made up the stereotype inheritance hierarchy, and if
     * one of the stereotype's ancestors has a matching name this method will return true, false
     * otherwise.
     * For example, if we have a certain stereotype called <<exception>> and a model element has a
     * stereotype called <<applicationException>> which extends <<exception>>, when calling this
     * method with 'stereotypeName' defined as 'exception' the method would return true since
     * <<applicationException>> inherits from <<exception>>.  If you want to check if the model
     * element has the exact stereotype, then use the method 'hasExactStereotype' instead.
     * @see ModelElementFacade#hasStereotype(String stereotypeName)
     */
    public boolean hasStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndAction().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperFrontEndAction().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperFrontEndAction().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperFrontEndAction().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperFrontEndAction().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperFrontEndAction().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperFrontEndAction().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperFrontEndAction().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperFrontEndAction().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperFrontEndAction().translateConstraints(kind, translation);
    }

    /**
     * An action is a named element that is the fundamental unit of executable functionality. The
     * execution
     * of an action represents some transformation or processing in the modeled system, be it a
     * computer
     * system or otherwise. An action represents a single step within an activity, that is, one that
     * is not
     * further decomposed within the activity. An action has pre- and post-conditions.
     * @see org.andromda.metafacades.uml.TransitionFacade#getEffect()
     */
    public ActionFacade getEffect()
    {
        return this.getSuperFrontEndAction().getEffect();
    }

    /**
     * A representation of the model object 'Constraint'. A condition or restriction expressed in
     * natural
     * language text or in a machine readable language for the purpose of declaring some of the
     * semantics
     * of an element.
     * @see org.andromda.metafacades.uml.TransitionFacade#getGuard()
     */
    public GuardFacade getGuard()
    {
        return this.getSuperFrontEndAction().getGuard();
    }

    /**
     * A representation of the model object 'Vertex'. An abstraction of a node in a state machine
     * graph. In
     * general, it can be the source or destination of any number of transitions.
     * @see org.andromda.metafacades.uml.TransitionFacade#getSource()
     */
    public StateVertexFacade getSource()
    {
        return this.getSuperFrontEndAction().getSource();
    }

    /**
     * A representation of the model object 'Vertex'. An abstraction of a node in a state machine
     * graph. In
     * general, it can be the source or destination of any number of transitions.
     * @see org.andromda.metafacades.uml.TransitionFacade#getTarget()
     */
    public StateVertexFacade getTarget()
    {
        return this.getSuperFrontEndAction().getTarget();
    }

    /**
     * If a trigger is present on this transition, this event represents that trigger.
     * @see org.andromda.metafacades.uml.TransitionFacade#getTrigger()
     */
    public EventFacade getTrigger()
    {
        return this.getSuperFrontEndAction().getTrigger();
    }

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.enteringActionState
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringActionState()
     */
    public boolean isEnteringActionState()
    {
        return this.getSuperFrontEndAction().isEnteringActionState();
    }

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.enteringDecisionPoint
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringDecisionPoint()
     */
    public boolean isEnteringDecisionPoint()
    {
        return this.getSuperFrontEndAction().isEnteringDecisionPoint();
    }

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.enteringFinalState
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringFinalState()
     */
    public boolean isEnteringFinalState()
    {
        return this.getSuperFrontEndAction().isEnteringFinalState();
    }

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.exitingActionState
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingActionState()
     */
    public boolean isExitingActionState()
    {
        return this.getSuperFrontEndAction().isExitingActionState();
    }

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.exitingDecisionPoint
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingDecisionPoint()
     */
    public boolean isExitingDecisionPoint()
    {
        return this.getSuperFrontEndAction().isExitingDecisionPoint();
    }

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.exitingInitialState
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingInitialState()
     */
    public boolean isExitingInitialState()
    {
        return this.getSuperFrontEndAction().isExitingInitialState();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.TransitionFacade.triggerPresent
     * @see org.andromda.metafacades.uml.TransitionFacade#isTriggerPresent()
     */
    public boolean isTriggerPresent()
    {
        return this.getSuperFrontEndAction().isTriggerPresent();
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperFrontEndAction().initialize();
    }

    /**
     * @return Object getSuperFrontEndAction().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperFrontEndAction().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperFrontEndAction().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperFrontEndAction().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiAction::each action coming out of a page must carry a trigger</p>
     * <p><b>Error:</b> Each action transition coming out of a page must have a trigger (the name could be sufficient), it is recommended to add a trigger of type 'signal'.</p>
     * <p><b>OCL:</b> -- context GuiAction inv: exitingPage implies triggerPresent</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiAction::table links must target an existing table page-variable</p>
     * <p><b>Error:</b> When specifying a table link for this action you will need to target a table page-variable from the input page, the specified table does not exist in that page.</p>
     * <p><b>OCL:</b> context GuiAction inv: tableLinkName->notEmpty() implies tableLink</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiAction::hyperlink table actions need to indicate the column</p>
     * <p><b>Error:</b> This hyperlink table event is not specifying the target column name on the table link, you will need to do this in order to determine in which column to render the hyperlink.</p>
     * <p><b>OCL:</b> -- context GuiAction inv: (hyperlink and tableLink) implies tableLinkColumnName->notEmpty()</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperFrontEndAction().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure();
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiAction::each action coming out of a page must carry a trigger",
                        "Each action transition coming out of a page must have a trigger (the name could be sufficient), it is recommended to add a trigger of type 'signal'."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiAction::each action coming out of a page must carry a trigger' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"tableLinkName")))).booleanValue()?Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"tableLink"))).booleanValue():true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiAction::table links must target an existing table page-variable",
                        "When specifying a table link for this action you will need to target a table page-variable from the input page, the specified table does not exist in that page."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiAction::table links must target an existing table page-variable' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure();
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiAction::hyperlink table actions need to indicate the column",
                        "This hyperlink table event is not specifying the target column name on the table link, you will need to do this in order to determine in which column to render the hyperlink."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiAction::hyperlink table actions need to indicate the column' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
    }

    /**
     * The property that stores the name of the metafacade.
     */
    private static final String NAME_PROPERTY = "name";
    private static final String FQNAME_PROPERTY = "fullyQualifiedName";

    /**
     * @see Object#toString()
     */
    @Override
    public String toString()
    {
        final StringBuilder toString = new StringBuilder(this.getClass().getName());
        toString.append("[");
        try
        {
            toString.append(Introspector.instance().getProperty(this, FQNAME_PROPERTY));
        }
        catch (final Throwable tryAgain)
        {
            try
            {
                toString.append(Introspector.instance().getProperty(this, NAME_PROPERTY));
            }
            catch (final Throwable ignore)
            {
                // - just ignore when the metafacade doesn't have a name or fullyQualifiedName property
            }
        }
        toString.append("]");
        return toString.toString();
    }
}