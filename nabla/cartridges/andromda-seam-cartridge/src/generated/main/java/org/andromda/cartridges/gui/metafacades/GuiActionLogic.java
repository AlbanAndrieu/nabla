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
    /**
     * The underlying UML object
     * @see Object
     */
    protected Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected GuiActionLogic(Object metaObjectIn, String context)
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
    private static final Logger logger = Logger.getLogger(GuiActionLogic.class);

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

    private String __actionName1a;
    private boolean __actionName1aSet = false;

    /**
     * The action name corresponding to this action, as found in the gui deployment descriptor. The
     * action name maps the action to a form bean.
     * @return (String)handleGetActionName()
     */
    public final String getActionName()
    {
        String actionName1a = this.__actionName1a;
        if (!this.__actionName1aSet)
        {
            // actionName has no pre constraints
            actionName1a = handleGetActionName();
            // actionName has no post constraints
            this.__actionName1a = actionName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionName1aSet = true;
            }
        }
        return actionName1a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionPath()
    * @return String
    */
    protected abstract String handleGetActionPath();

    private String __actionPath2a;
    private boolean __actionPath2aSet = false;

    /**
     * The action path corresponding to this action, as found in the gui deployment descriptor. The
     * action path specifies the URL to enter in order to call the action.
     * @return (String)handleGetActionPath()
     */
    public final String getActionPath()
    {
        String actionPath2a = this.__actionPath2a;
        if (!this.__actionPath2aSet)
        {
            // actionPath has no pre constraints
            actionPath2a = handleGetActionPath();
            // actionPath has no post constraints
            this.__actionPath2a = actionPath2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionPath2aSet = true;
            }
        }
        return actionPath2a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionInput()
    * @return String
    */
    protected abstract String handleGetActionInput();

    private String __actionInput3a;
    private boolean __actionInput3aSet = false;

    /**
     * The action input corresponding to this action, as found in the gui deployment descriptor. The
     * action input maps the action to the page on which it originated.
     * @return (String)handleGetActionInput()
     */
    public final String getActionInput()
    {
        String actionInput3a = this.__actionInput3a;
        if (!this.__actionInput3aSet)
        {
            // actionInput has no pre constraints
            actionInput3a = handleGetActionInput();
            // actionInput has no post constraints
            this.__actionInput3a = actionInput3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionInput3aSet = true;
            }
        }
        return actionInput3a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionRoles()
    * @return String
    */
    protected abstract String handleGetActionRoles();

    private String __actionRoles4a;
    private boolean __actionRoles4aSet = false;

    /**
     * The action roles corresponding to this action, as found in the gui deployment descriptor. The
     * action roles specifiy the roles in which the user must be in order to be authorized to call
     * the action. One of the roles must be satisfied.
     * @return (String)handleGetActionRoles()
     */
    public final String getActionRoles()
    {
        String actionRoles4a = this.__actionRoles4a;
        if (!this.__actionRoles4aSet)
        {
            // actionRoles has no pre constraints
            actionRoles4a = handleGetActionRoles();
            // actionRoles has no post constraints
            this.__actionRoles4a = actionRoles4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionRoles4aSet = true;
            }
        }
        return actionRoles4a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormPost()
    * @return boolean
    */
    protected abstract boolean handleIsFormPost();

    private boolean __formPost5a;
    private boolean __formPost5aSet = false;

    /**
     * Specifies whether or not this action is represented by the posting of a form.
     * @return (boolean)handleIsFormPost()
     */
    public final boolean isFormPost()
    {
        boolean formPost5a = this.__formPost5a;
        if (!this.__formPost5aSet)
        {
            // formPost has no pre constraints
            formPost5a = handleIsFormPost();
            // formPost has no post constraints
            this.__formPost5a = formPost5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formPost5aSet = true;
            }
        }
        return formPost5a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isHyperlink()
    * @return boolean
    */
    protected abstract boolean handleIsHyperlink();

    private boolean __hyperlink6a;
    private boolean __hyperlink6aSet = false;

    /**
     * Specifies whether or not this action is represented by clicking on a hyperlink.
     * @return (boolean)handleIsHyperlink()
     */
    public final boolean isHyperlink()
    {
        boolean hyperlink6a = this.__hyperlink6a;
        if (!this.__hyperlink6aSet)
        {
            // hyperlink has no pre constraints
            hyperlink6a = handleIsHyperlink();
            // hyperlink has no post constraints
            this.__hyperlink6a = hyperlink6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hyperlink6aSet = true;
            }
        }
        return hyperlink6a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionClassName()
    * @return String
    */
    protected abstract String handleGetActionClassName();

    private String __actionClassName7a;
    private boolean __actionClassName7aSet = false;

    /**
     * A good Java class name for this action. The name is constructed from the source page and the
     * name of the trigger.
     * @return (String)handleGetActionClassName()
     */
    public final String getActionClassName()
    {
        String actionClassName7a = this.__actionClassName7a;
        if (!this.__actionClassName7aSet)
        {
            // actionClassName has no pre constraints
            actionClassName7a = handleGetActionClassName();
            // actionClassName has no post constraints
            this.__actionClassName7a = actionClassName7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionClassName7aSet = true;
            }
        }
        return actionClassName7a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanClassName()
    * @return String
    */
    protected abstract String handleGetFormBeanClassName();

    private String __formBeanClassName8a;
    private boolean __formBeanClassName8aSet = false;

    /**
     * Returns the class name of the form bean associated to this action.
     * @return (String)handleGetFormBeanClassName()
     */
    public final String getFormBeanClassName()
    {
        String formBeanClassName8a = this.__formBeanClassName8a;
        if (!this.__formBeanClassName8aSet)
        {
            // formBeanClassName has no pre constraints
            formBeanClassName8a = handleGetFormBeanClassName();
            // formBeanClassName has no post constraints
            this.__formBeanClassName8a = formBeanClassName8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanClassName8aSet = true;
            }
        }
        return formBeanClassName8a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanName()
    * @return String
    */
    protected abstract String handleGetFormBeanName();

    private String __formBeanName9a;
    private boolean __formBeanName9aSet = false;

    /**
     * The name of the form bean associated to this action. The name is returned as it should appear
     * in the Gui deployment descriptor.
     * @return (String)handleGetFormBeanName()
     */
    public final String getFormBeanName()
    {
        String formBeanName9a = this.__formBeanName9a;
        if (!this.__formBeanName9aSet)
        {
            // formBeanName has no pre constraints
            formBeanName9a = handleGetFormBeanName();
            // formBeanName has no post constraints
            this.__formBeanName9a = formBeanName9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanName9aSet = true;
            }
        }
        return formBeanName9a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormValidationMethodName()
    * @return String
    */
    protected abstract String handleGetFormValidationMethodName();

    private String __formValidationMethodName10a;
    private boolean __formValidationMethodName10aSet = false;

    /**
     * The Javascript function name of the validation method that will validate the action
     * parameters.
     * @return (String)handleGetFormValidationMethodName()
     */
    public final String getFormValidationMethodName()
    {
        String formValidationMethodName10a = this.__formValidationMethodName10a;
        if (!this.__formValidationMethodName10aSet)
        {
            // formValidationMethodName has no pre constraints
            formValidationMethodName10a = handleGetFormValidationMethodName();
            // formValidationMethodName has no post constraints
            this.__formValidationMethodName10a = formValidationMethodName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formValidationMethodName10aSet = true;
            }
        }
        return formValidationMethodName10a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isResettable()
    * @return boolean
    */
    protected abstract boolean handleIsResettable();

    private boolean __resettable11a;
    private boolean __resettable11aSet = false;

    /**
     * True if it should be possible to reset the form represented by this action. False otherwise.
     * @return (boolean)handleIsResettable()
     */
    public final boolean isResettable()
    {
        boolean resettable11a = this.__resettable11a;
        if (!this.__resettable11aSet)
        {
            // resettable has no pre constraints
            resettable11a = handleIsResettable();
            // resettable has no post constraints
            this.__resettable11a = resettable11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__resettable11aSet = true;
            }
        }
        return resettable11a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullActionPath()
    * @return String
    */
    protected abstract String handleGetFullActionPath();

    private String __fullActionPath12a;
    private boolean __fullActionPath12aSet = false;

    /**
     * The full path for this action. The full path also contains the package name rendered as
     * directories.
     * @return (String)handleGetFullActionPath()
     */
    public final String getFullActionPath()
    {
        String fullActionPath12a = this.__fullActionPath12a;
        if (!this.__fullActionPath12aSet)
        {
            // fullActionPath has no pre constraints
            fullActionPath12a = handleGetFullActionPath();
            // fullActionPath has no post constraints
            this.__fullActionPath12a = fullActionPath12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullActionPath12aSet = true;
            }
        }
        return fullActionPath12a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullFormBeanPath()
    * @return String
    */
    protected abstract String handleGetFullFormBeanPath();

    private String __fullFormBeanPath13a;
    private boolean __fullFormBeanPath13aSet = false;

    /**
     * Returns the full path for the form bean associated to this action.
     * @return (String)handleGetFullFormBeanPath()
     */
    public final String getFullFormBeanPath()
    {
        String fullFormBeanPath13a = this.__fullFormBeanPath13a;
        if (!this.__fullFormBeanPath13aSet)
        {
            // fullFormBeanPath has no pre constraints
            fullFormBeanPath13a = handleGetFullFormBeanPath();
            // fullFormBeanPath has no post constraints
            this.__fullFormBeanPath13a = fullFormBeanPath13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullFormBeanPath13aSet = true;
            }
        }
        return fullFormBeanPath13a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionPathRoot()
    * @return String
    */
    protected abstract String handleGetActionPathRoot();

    private String __actionPathRoot14a;
    private boolean __actionPathRoot14aSet = false;

    /**
     * The root of the action path, this is the same as the path for the use-case context for this
     * action, that is, the use-case holding the activity graph in which this action is contained.
     * @return (String)handleGetActionPathRoot()
     */
    public final String getActionPathRoot()
    {
        String actionPathRoot14a = this.__actionPathRoot14a;
        if (!this.__actionPathRoot14aSet)
        {
            // actionPathRoot has no pre constraints
            actionPathRoot14a = handleGetActionPathRoot();
            // actionPathRoot has no post constraints
            this.__actionPathRoot14a = actionPathRoot14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionPathRoot14aSet = true;
            }
        }
        return actionPathRoot14a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private boolean __validationRequired15a;
    private boolean __validationRequired15aSet = false;

    /**
     * True if this action requires validation, false otherwise. An action requires validation if it
     * represented by a form and one or more fields require validation.
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean validationRequired15a = this.__validationRequired15a;
        if (!this.__validationRequired15aSet)
        {
            // validationRequired has no pre constraints
            validationRequired15a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.__validationRequired15a = validationRequired15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__validationRequired15aSet = true;
            }
        }
        return validationRequired15a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanType()
    * @return String
    */
    protected abstract String handleGetFormBeanType();

    private String __formBeanType16a;
    private boolean __formBeanType16aSet = false;

    /**
     * The fully qualified name of the form bean associated to this action.
     * @return (String)handleGetFormBeanType()
     */
    public final String getFormBeanType()
    {
        String formBeanType16a = this.__formBeanType16a;
        if (!this.__formBeanType16aSet)
        {
            // formBeanType has no pre constraints
            formBeanType16a = handleGetFormBeanType();
            // formBeanType has no post constraints
            this.__formBeanType16a = formBeanType16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanType16aSet = true;
            }
        }
        return formBeanType16a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getDocumentationValue()
    * @return String
    */
    protected abstract String handleGetDocumentationValue();

    private String __documentationValue17a;
    private boolean __documentationValue17aSet = false;

    /**
     * The documentation for this action as a String that can be used as a resource message (with
     * the backslashes at the end of the line).
     * @return (String)handleGetDocumentationValue()
     */
    public final String getDocumentationValue()
    {
        String documentationValue17a = this.__documentationValue17a;
        if (!this.__documentationValue17aSet)
        {
            // documentationValue has no pre constraints
            documentationValue17a = handleGetDocumentationValue();
            // documentationValue has no post constraints
            this.__documentationValue17a = documentationValue17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__documentationValue17aSet = true;
            }
        }
        return documentationValue17a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getDocumentationKey()
    * @return String
    */
    protected abstract String handleGetDocumentationKey();

    private String __documentationKey18a;
    private boolean __documentationKey18aSet = false;

    /**
     * A key suited as a resource message key for the documentation for this action.
     * @return (String)handleGetDocumentationKey()
     */
    public final String getDocumentationKey()
    {
        String documentationKey18a = this.__documentationKey18a;
        if (!this.__documentationKey18aSet)
        {
            // documentationKey has no pre constraints
            documentationKey18a = handleGetDocumentationKey();
            // documentationKey has no post constraints
            this.__documentationKey18a = documentationKey18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__documentationKey18aSet = true;
            }
        }
        return documentationKey18a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullTilePath()
    * @return String
    */
    protected abstract String handleGetFullTilePath();

    private String __fullTilePath19a;
    private boolean __fullTilePath19aSet = false;

    /**
     * The name of a file that can be used as a view file name in case you want to have each action
     * rendered onto a different tile.
     * @return (String)handleGetFullTilePath()
     */
    public final String getFullTilePath()
    {
        String fullTilePath19a = this.__fullTilePath19a;
        if (!this.__fullTilePath19aSet)
        {
            // fullTilePath has no pre constraints
            fullTilePath19a = handleGetFullTilePath();
            // fullTilePath has no post constraints
            this.__fullTilePath19a = fullTilePath19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullTilePath19aSet = true;
            }
        }
        return fullTilePath19a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isDateFieldPresent()
    * @return boolean
    */
    protected abstract boolean handleIsDateFieldPresent();

    private boolean __dateFieldPresent20a;
    private boolean __dateFieldPresent20aSet = false;

    /**
     * True if this action contains a parameter of type Date. The generated pages will contain
     * special javascript code to handle them (popup window etc...).
     * @return (boolean)handleIsDateFieldPresent()
     */
    public final boolean isDateFieldPresent()
    {
        boolean dateFieldPresent20a = this.__dateFieldPresent20a;
        if (!this.__dateFieldPresent20aSet)
        {
            // dateFieldPresent has no pre constraints
            dateFieldPresent20a = handleIsDateFieldPresent();
            // dateFieldPresent has no post constraints
            this.__dateFieldPresent20a = dateFieldPresent20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__dateFieldPresent20aSet = true;
            }
        }
        return dateFieldPresent20a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isCalendarRequired()
    * @return boolean
    */
    protected abstract boolean handleIsCalendarRequired();

    private boolean __calendarRequired21a;
    private boolean __calendarRequired21aSet = false;

    /**
     * True if this action contains a parameter which requires a calendar popup.
     * @return (boolean)handleIsCalendarRequired()
     */
    public final boolean isCalendarRequired()
    {
        boolean calendarRequired21a = this.__calendarRequired21a;
        if (!this.__calendarRequired21aSet)
        {
            // calendarRequired has no pre constraints
            calendarRequired21a = handleIsCalendarRequired();
            // calendarRequired has no post constraints
            this.__calendarRequired21a = calendarRequired21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__calendarRequired21aSet = true;
            }
        }
        return calendarRequired21a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableLink()
    * @return boolean
    */
    protected abstract boolean handleIsTableLink();

    private boolean __tableLink22a;
    private boolean __tableLink22aSet = false;

    /**
     * True if a table link name has been specified and it properly targets a table page-variable
     * from the input page.
     * @return (boolean)handleIsTableLink()
     */
    public final boolean isTableLink()
    {
        boolean tableLink22a = this.__tableLink22a;
        if (!this.__tableLink22aSet)
        {
            // tableLink has no pre constraints
            tableLink22a = handleIsTableLink();
            // tableLink has no post constraints
            this.__tableLink22a = tableLink22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableLink22aSet = true;
            }
        }
        return tableLink22a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String __onlineHelpKey23a;
    private boolean __onlineHelpKey23aSet = false;

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String onlineHelpKey23a = this.__onlineHelpKey23a;
        if (!this.__onlineHelpKey23aSet)
        {
            // onlineHelpKey has no pre constraints
            onlineHelpKey23a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.__onlineHelpKey23a = onlineHelpKey23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpKey23aSet = true;
            }
        }
        return onlineHelpKey23a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String __onlineHelpValue24a;
    private boolean __onlineHelpValue24aSet = false;

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String onlineHelpValue24a = this.__onlineHelpValue24a;
        if (!this.__onlineHelpValue24aSet)
        {
            // onlineHelpValue has no pre constraints
            onlineHelpValue24a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.__onlineHelpValue24a = onlineHelpValue24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpValue24aSet = true;
            }
        }
        return onlineHelpValue24a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionScope()
    * @return String
    */
    protected abstract String handleGetActionScope();

    private String __actionScope25a;
    private boolean __actionScope25aSet = false;

    /**
     * The scope in which the form bean will be placed (could be page, request, session or
     * application).
     * @return (String)handleGetActionScope()
     */
    public final String getActionScope()
    {
        String actionScope25a = this.__actionScope25a;
        if (!this.__actionScope25aSet)
        {
            // actionScope has no pre constraints
            actionScope25a = handleGetActionScope();
            // actionScope has no post constraints
            this.__actionScope25a = actionScope25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionScope25aSet = true;
            }
        }
        return actionScope25a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanPackageName()
    * @return String
    */
    protected abstract String handleGetFormBeanPackageName();

    private String __formBeanPackageName26a;
    private boolean __formBeanPackageName26aSet = false;

    /**
     * The package for the form bean.
     * @return (String)handleGetFormBeanPackageName()
     */
    public final String getFormBeanPackageName()
    {
        String formBeanPackageName26a = this.__formBeanPackageName26a;
        if (!this.__formBeanPackageName26aSet)
        {
            // formBeanPackageName has no pre constraints
            formBeanPackageName26a = handleGetFormBeanPackageName();
            // formBeanPackageName has no post constraints
            this.__formBeanPackageName26a = formBeanPackageName26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanPackageName26aSet = true;
            }
        }
        return formBeanPackageName26a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionType()
    * @return String
    */
    protected abstract String handleGetActionType();

    private String __actionType27a;
    private boolean __actionType27aSet = false;

    /**
     * The fully qualified name for the action class.
     * @return (String)handleGetActionType()
     */
    public final String getActionType()
    {
        String actionType27a = this.__actionType27a;
        if (!this.__actionType27aSet)
        {
            // actionType has no pre constraints
            actionType27a = handleGetActionType();
            // actionType has no post constraints
            this.__actionType27a = actionType27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionType27aSet = true;
            }
        }
        return actionType27a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getStyleId()
    * @return String
    */
    protected abstract String handleGetStyleId();

    private String __styleId28a;
    private boolean __styleId28aSet = false;

    /**
     * The name of the CSS id in which this action will be contained.
     * @return (String)handleGetStyleId()
     */
    public final String getStyleId()
    {
        String styleId28a = this.__styleId28a;
        if (!this.__styleId28aSet)
        {
            // styleId has no pre constraints
            styleId28a = handleGetStyleId();
            // styleId has no post constraints
            this.__styleId28a = styleId28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__styleId28aSet = true;
            }
        }
        return styleId28a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isRedirect()
    * @return boolean
    */
    protected abstract boolean handleIsRedirect();

    private boolean __redirect29a;
    private boolean __redirect29aSet = false;

    /**
     * Defines whether or not when this action's forward is executed, an HTTP redirect should occur.
     *  Default value is based on the value of the 'defaultActionRedirect' namespace.
     * @return (boolean)handleIsRedirect()
     */
    public final boolean isRedirect()
    {
        boolean redirect29a = this.__redirect29a;
        if (!this.__redirect29aSet)
        {
            // redirect has no pre constraints
            redirect29a = handleIsRedirect();
            // redirect has no post constraints
            this.__redirect29a = redirect29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__redirect29aSet = true;
            }
        }
        return redirect29a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormScope()
    * @return String
    */
    protected abstract String handleGetFormScope();

    private String __formScope30a;
    private boolean __formScope30aSet = false;

    /**
     * The scope to place the current "form" variable within when this action is executing.
     * @return (String)handleGetFormScope()
     */
    public final String getFormScope()
    {
        String formScope30a = this.__formScope30a;
        if (!this.__formScope30aSet)
        {
            // formScope has no pre constraints
            formScope30a = handleGetFormScope();
            // formScope has no post constraints
            this.__formScope30a = formScope30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formScope30aSet = true;
            }
        }
        return formScope30a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeSession()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeSession();

    private boolean __formScopeSession31a;
    private boolean __formScopeSession31aSet = false;

    /**
     * Indicates if the form scope is of type "session".
     * @return (boolean)handleIsFormScopeSession()
     */
    public final boolean isFormScopeSession()
    {
        boolean formScopeSession31a = this.__formScopeSession31a;
        if (!this.__formScopeSession31aSet)
        {
            // formScopeSession has no pre constraints
            formScopeSession31a = handleIsFormScopeSession();
            // formScopeSession has no post constraints
            this.__formScopeSession31a = formScopeSession31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formScopeSession31aSet = true;
            }
        }
        return formScopeSession31a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeRequest()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeRequest();

    private boolean __formScopeRequest32a;
    private boolean __formScopeRequest32aSet = false;

    /**
     * Indicates if the from scope is of type "request".
     * @return (boolean)handleIsFormScopeRequest()
     */
    public final boolean isFormScopeRequest()
    {
        boolean formScopeRequest32a = this.__formScopeRequest32a;
        if (!this.__formScopeRequest32aSet)
        {
            // formScopeRequest has no pre constraints
            formScopeRequest32a = handleIsFormScopeRequest();
            // formScopeRequest has no post constraints
            this.__formScopeRequest32a = formScopeRequest32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formScopeRequest32aSet = true;
            }
        }
        return formScopeRequest32a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeNone()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeNone();

    private boolean __formScopeNone33a;
    private boolean __formScopeNone33aSet = false;

    /**
     * Indicates if the form scope is of type "none".
     * @return (boolean)handleIsFormScopeNone()
     */
    public final boolean isFormScopeNone()
    {
        boolean formScopeNone33a = this.__formScopeNone33a;
        if (!this.__formScopeNone33aSet)
        {
            // formScopeNone has no pre constraints
            formScopeNone33a = handleIsFormScopeNone();
            // formScopeNone has no post constraints
            this.__formScopeNone33a = formScopeNone33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formScopeNone33aSet = true;
            }
        }
        return formScopeNone33a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTableLinkName()
    * @return String
    */
    protected abstract String handleGetTableLinkName();

    private String __tableLinkName34a;
    private boolean __tableLinkName34aSet = false;

    /**
     * The name of the table link specified for this action.
     * @return (String)handleGetTableLinkName()
     */
    public final String getTableLinkName()
    {
        String tableLinkName34a = this.__tableLinkName34a;
        if (!this.__tableLinkName34aSet)
        {
            // tableLinkName has no pre constraints
            tableLinkName34a = handleGetTableLinkName();
            // tableLinkName has no post constraints
            this.__tableLinkName34a = tableLinkName34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableLinkName34aSet = true;
            }
        }
        return tableLinkName34a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTableLinkColumnName()
    * @return String
    */
    protected abstract String handleGetTableLinkColumnName();

    private String __tableLinkColumnName35a;
    private boolean __tableLinkColumnName35aSet = false;

    /**
     * The name of the column targetted by this action.
     * @return (String)handleGetTableLinkColumnName()
     */
    public final String getTableLinkColumnName()
    {
        String tableLinkColumnName35a = this.__tableLinkColumnName35a;
        if (!this.__tableLinkColumnName35aSet)
        {
            // tableLinkColumnName has no pre constraints
            tableLinkColumnName35a = handleGetTableLinkColumnName();
            // tableLinkColumnName has no post constraints
            this.__tableLinkColumnName35a = tableLinkColumnName35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableLinkColumnName35aSet = true;
            }
        }
        return tableLinkColumnName35a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isImageLink()
    * @return boolean
    */
    protected abstract boolean handleIsImageLink();

    private boolean __imageLink36a;
    private boolean __imageLink36aSet = false;

    /**
     * Specifies whether or not this action is represented by clicking on an image.
     * @return (boolean)handleIsImageLink()
     */
    public final boolean isImageLink()
    {
        boolean imageLink36a = this.__imageLink36a;
        if (!this.__imageLink36aSet)
        {
            // imageLink has no pre constraints
            imageLink36a = handleIsImageLink();
            // imageLink has no post constraints
            this.__imageLink36a = imageLink36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__imageLink36aSet = true;
            }
        }
        return imageLink36a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getImagePath()
    * @return String
    */
    protected abstract String handleGetImagePath();

    private String __imagePath37a;
    private boolean __imagePath37aSet = false;

    /**
     * If this action is an imageLink this property represents the path to the corresponding image.
     * @return (String)handleGetImagePath()
     */
    public final String getImagePath()
    {
        String imagePath37a = this.__imagePath37a;
        if (!this.__imagePath37aSet)
        {
            // imagePath has no pre constraints
            imagePath37a = handleGetImagePath();
            // imagePath has no post constraints
            this.__imagePath37a = imagePath37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__imagePath37aSet = true;
            }
        }
        return imagePath37a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private String __messageKey38a;
    private boolean __messageKey38aSet = false;

    /**
     * 
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String messageKey38a = this.__messageKey38a;
        if (!this.__messageKey38aSet)
        {
            // messageKey has no pre constraints
            messageKey38a = handleGetMessageKey();
            // messageKey has no post constraints
            this.__messageKey38a = messageKey38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__messageKey38aSet = true;
            }
        }
        return messageKey38a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getImageMessageKey()
    * @return String
    */
    protected abstract String handleGetImageMessageKey();

    private String __imageMessageKey39a;
    private boolean __imageMessageKey39aSet = false;

    /**
     * The resource message key used to look to location of the image for this action.
     * @return (String)handleGetImageMessageKey()
     */
    public final String getImageMessageKey()
    {
        String imageMessageKey39a = this.__imageMessageKey39a;
        if (!this.__imageMessageKey39aSet)
        {
            // imageMessageKey has no pre constraints
            imageMessageKey39a = handleGetImageMessageKey();
            // imageMessageKey has no post constraints
            this.__imageMessageKey39a = imageMessageKey39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__imageMessageKey39aSet = true;
            }
        }
        return imageMessageKey39a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableAction()
    * @return boolean
    */
    protected abstract boolean handleIsTableAction();

    private boolean __tableAction40a;
    private boolean __tableAction40aSet = false;

    /**
     * Denotes this action works on all rows of the table from the table link relation.
     * @return (boolean)handleIsTableAction()
     */
    public final boolean isTableAction()
    {
        boolean tableAction40a = this.__tableAction40a;
        if (!this.__tableAction40aSet)
        {
            // tableAction has no pre constraints
            tableAction40a = handleIsTableAction();
            // tableAction has no post constraints
            this.__tableAction40a = tableAction40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableAction40aSet = true;
            }
        }
        return tableAction40a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableRowAction()
    * @return boolean
    */
    protected abstract boolean handleIsTableRowAction();

    private boolean __tableRowAction41a;
    private boolean __tableRowAction41aSet = false;

    /**
     * Denotes this action works on a single row of the table from the table link relation.
     * @return (boolean)handleIsTableRowAction()
     */
    public final boolean isTableRowAction()
    {
        boolean tableRowAction41a = this.__tableRowAction41a;
        if (!this.__tableRowAction41aSet)
        {
            // tableRowAction has no pre constraints
            tableRowAction41a = handleIsTableRowAction();
            // tableRowAction has no post constraints
            this.__tableRowAction41a = tableRowAction41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableRowAction41aSet = true;
            }
        }
        return tableRowAction41a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isMultipartFormData()
    * @return boolean
    */
    protected abstract boolean handleIsMultipartFormData();

    private boolean __multipartFormData42a;
    private boolean __multipartFormData42aSet = false;

    /**
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return (boolean)handleIsMultipartFormData()
     */
    public final boolean isMultipartFormData()
    {
        boolean multipartFormData42a = this.__multipartFormData42a;
        if (!this.__multipartFormData42aSet)
        {
            // multipartFormData has no pre constraints
            multipartFormData42a = handleIsMultipartFormData();
            // multipartFormData has no post constraints
            this.__multipartFormData42a = multipartFormData42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__multipartFormData42aSet = true;
            }
        }
        return multipartFormData42a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationName()
    * @return String
    */
    protected abstract String handleGetFormImplementationName();

    private String __formImplementationName43a;
    private boolean __formImplementationName43aSet = false;

    /**
     * The name of the form implementation.
     * @return (String)handleGetFormImplementationName()
     */
    public final String getFormImplementationName()
    {
        String formImplementationName43a = this.__formImplementationName43a;
        if (!this.__formImplementationName43aSet)
        {
            // formImplementationName has no pre constraints
            formImplementationName43a = handleGetFormImplementationName();
            // formImplementationName has no post constraints
            this.__formImplementationName43a = formImplementationName43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formImplementationName43aSet = true;
            }
        }
        return formImplementationName43a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedFormImplementationName();

    private String __fullyQualifiedFormImplementationName44a;
    private boolean __fullyQualifiedFormImplementationName44aSet = false;

    /**
     * The fully qualified name of the form implementation.
     * @return (String)handleGetFullyQualifiedFormImplementationName()
     */
    public final String getFullyQualifiedFormImplementationName()
    {
        String fullyQualifiedFormImplementationName44a = this.__fullyQualifiedFormImplementationName44a;
        if (!this.__fullyQualifiedFormImplementationName44aSet)
        {
            // fullyQualifiedFormImplementationName has no pre constraints
            fullyQualifiedFormImplementationName44a = handleGetFullyQualifiedFormImplementationName();
            // fullyQualifiedFormImplementationName has no post constraints
            this.__fullyQualifiedFormImplementationName44a = fullyQualifiedFormImplementationName44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullyQualifiedFormImplementationName44aSet = true;
            }
        }
        return fullyQualifiedFormImplementationName44a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedFormImplementationPath();

    private String __fullyQualifiedFormImplementationPath45a;
    private boolean __fullyQualifiedFormImplementationPath45aSet = false;

    /**
     * The fully qualified path of the form implementation.
     * @return (String)handleGetFullyQualifiedFormImplementationPath()
     */
    public final String getFullyQualifiedFormImplementationPath()
    {
        String fullyQualifiedFormImplementationPath45a = this.__fullyQualifiedFormImplementationPath45a;
        if (!this.__fullyQualifiedFormImplementationPath45aSet)
        {
            // fullyQualifiedFormImplementationPath has no pre constraints
            fullyQualifiedFormImplementationPath45a = handleGetFullyQualifiedFormImplementationPath();
            // fullyQualifiedFormImplementationPath has no post constraints
            this.__fullyQualifiedFormImplementationPath45a = fullyQualifiedFormImplementationPath45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullyQualifiedFormImplementationPath45aSet = true;
            }
        }
        return fullyQualifiedFormImplementationPath45a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationInterfaceList()
    * @return String
    */
    protected abstract String handleGetFormImplementationInterfaceList();

    private String __formImplementationInterfaceList46a;
    private boolean __formImplementationInterfaceList46aSet = false;

    /**
     * A comma separated list of all the form interfaces which the form implementation implements.
     * @return (String)handleGetFormImplementationInterfaceList()
     */
    public final String getFormImplementationInterfaceList()
    {
        String formImplementationInterfaceList46a = this.__formImplementationInterfaceList46a;
        if (!this.__formImplementationInterfaceList46aSet)
        {
            // formImplementationInterfaceList has no pre constraints
            formImplementationInterfaceList46a = handleGetFormImplementationInterfaceList();
            // formImplementationInterfaceList has no post constraints
            this.__formImplementationInterfaceList46a = formImplementationInterfaceList46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formImplementationInterfaceList46aSet = true;
            }
        }
        return formImplementationInterfaceList46a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getPath()
    * @return String
    */
    protected abstract String handleGetPath();

    private String __path47a;
    private boolean __path47aSet = false;

    /**
     * The path to this action.
     * @return (String)handleGetPath()
     */
    public final String getPath()
    {
        String path47a = this.__path47a;
        if (!this.__path47aSet)
        {
            // path has no pre constraints
            path47a = handleGetPath();
            // path has no post constraints
            this.__path47a = path47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__path47aSet = true;
            }
        }
        return path47a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getPathRoot()
    * @return String
    */
    protected abstract String handleGetPathRoot();

    private String __pathRoot48a;
    private boolean __pathRoot48aSet = false;

    /**
     * The path's root.
     * @return (String)handleGetPathRoot()
     */
    public final String getPathRoot()
    {
        String pathRoot48a = this.__pathRoot48a;
        if (!this.__pathRoot48aSet)
        {
            // pathRoot has no pre constraints
            pathRoot48a = handleGetPathRoot();
            // pathRoot has no post constraints
            this.__pathRoot48a = pathRoot48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__pathRoot48aSet = true;
            }
        }
        return pathRoot48a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTriggerName()
    * @return String
    */
    protected abstract String handleGetTriggerName();

    private String __triggerName49a;
    private boolean __triggerName49aSet = false;

    /**
     * The name of the trigger that triggers that action.
     * @return (String)handleGetTriggerName()
     */
    public final String getTriggerName()
    {
        String triggerName49a = this.__triggerName49a;
        if (!this.__triggerName49aSet)
        {
            // triggerName has no pre constraints
            triggerName49a = handleGetTriggerName();
            // triggerName has no post constraints
            this.__triggerName49a = triggerName49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__triggerName49aSet = true;
            }
        }
        return triggerName49a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getViewFragmentPath()
    * @return String
    */
    protected abstract String handleGetViewFragmentPath();

    private String __viewFragmentPath50a;
    private boolean __viewFragmentPath50aSet = false;

    /**
     * The path to the view fragment corresponding to this action
     * @return (String)handleGetViewFragmentPath()
     */
    public final String getViewFragmentPath()
    {
        String viewFragmentPath50a = this.__viewFragmentPath50a;
        if (!this.__viewFragmentPath50aSet)
        {
            // viewFragmentPath has no pre constraints
            viewFragmentPath50a = handleGetViewFragmentPath();
            // viewFragmentPath has no post constraints
            this.__viewFragmentPath50a = viewFragmentPath50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__viewFragmentPath50aSet = true;
            }
        }
        return viewFragmentPath50a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedActionClassPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassPath();

    private String __fullyQualifiedActionClassPath51a;
    private boolean __fullyQualifiedActionClassPath51aSet = false;

    /**
     * The fully qualified path to the action class that execute this action.
     * @return (String)handleGetFullyQualifiedActionClassPath()
     */
    public final String getFullyQualifiedActionClassPath()
    {
        String fullyQualifiedActionClassPath51a = this.__fullyQualifiedActionClassPath51a;
        if (!this.__fullyQualifiedActionClassPath51aSet)
        {
            // fullyQualifiedActionClassPath has no pre constraints
            fullyQualifiedActionClassPath51a = handleGetFullyQualifiedActionClassPath();
            // fullyQualifiedActionClassPath has no post constraints
            this.__fullyQualifiedActionClassPath51a = fullyQualifiedActionClassPath51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullyQualifiedActionClassPath51aSet = true;
            }
        }
        return fullyQualifiedActionClassPath51a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getControllerAction()
    * @return String
    */
    protected abstract String handleGetControllerAction();

    private String __controllerAction52a;
    private boolean __controllerAction52aSet = false;

    /**
     * The name of the action on the controller that executions this action.
     * @return (String)handleGetControllerAction()
     */
    public final String getControllerAction()
    {
        String controllerAction52a = this.__controllerAction52a;
        if (!this.__controllerAction52aSet)
        {
            // controllerAction has no pre constraints
            controllerAction52a = handleGetControllerAction();
            // controllerAction has no post constraints
            this.__controllerAction52a = controllerAction52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__controllerAction52aSet = true;
            }
        }
        return controllerAction52a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedActionClassName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassName();

    private String __fullyQualifiedActionClassName53a;
    private boolean __fullyQualifiedActionClassName53aSet = false;

    /**
     * The fully qualified name of the action class that execute this action.
     * @return (String)handleGetFullyQualifiedActionClassName()
     */
    public final String getFullyQualifiedActionClassName()
    {
        String fullyQualifiedActionClassName53a = this.__fullyQualifiedActionClassName53a;
        if (!this.__fullyQualifiedActionClassName53aSet)
        {
            // fullyQualifiedActionClassName has no pre constraints
            fullyQualifiedActionClassName53a = handleGetFullyQualifiedActionClassName();
            // fullyQualifiedActionClassName has no post constraints
            this.__fullyQualifiedActionClassName53a = fullyQualifiedActionClassName53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullyQualifiedActionClassName53aSet = true;
            }
        }
        return fullyQualifiedActionClassName53a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormKey()
    * @return String
    */
    protected abstract String handleGetFormKey();

    private String __formKey54a;
    private boolean __formKey54aSet = false;

    /**
     * The key that stores the form in which information is passed from one action to another.
     * @return (String)handleGetFormKey()
     */
    public final String getFormKey()
    {
        String formKey54a = this.__formKey54a;
        if (!this.__formKey54aSet)
        {
            // formKey has no pre constraints
            formKey54a = handleGetFormKey();
            // formKey has no post constraints
            this.__formKey54a = formKey54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formKey54aSet = true;
            }
        }
        return formKey54a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isPopup()
    * @return boolean
    */
    protected abstract boolean handleIsPopup();

    private boolean __popup55a;
    private boolean __popup55aSet = false;

    /**
     * Indicates if this action forwards to a popup (this is determed when the targetted view is a
     * popup).
     * @return (boolean)handleIsPopup()
     */
    public final boolean isPopup()
    {
        boolean popup55a = this.__popup55a;
        if (!this.__popup55aSet)
        {
            // popup has no pre constraints
            popup55a = handleIsPopup();
            // popup has no post constraints
            this.__popup55a = popup55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__popup55aSet = true;
            }
        }
        return popup55a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormResetRequired()
    * @return boolean
    */
    protected abstract boolean handleIsFormResetRequired();

    private boolean __formResetRequired56a;
    private boolean __formResetRequired56aSet = false;

    /**
     * Indicates if at least one parameter on the form requires being reset.
     * @return (boolean)handleIsFormResetRequired()
     */
    public final boolean isFormResetRequired()
    {
        boolean formResetRequired56a = this.__formResetRequired56a;
        if (!this.__formResetRequired56aSet)
        {
            // formResetRequired has no pre constraints
            formResetRequired56a = handleIsFormResetRequired();
            // formResetRequired has no post constraints
            this.__formResetRequired56a = formResetRequired56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formResetRequired56aSet = true;
            }
        }
        return formResetRequired56a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormReset()
    * @return boolean
    */
    protected abstract boolean handleIsFormReset();

    private boolean __formReset57a;
    private boolean __formReset57aSet = false;

    /**
     * Whether or not the entire form should be reset (all action parameters on the form).
     * @return (boolean)handleIsFormReset()
     */
    public final boolean isFormReset()
    {
        boolean formReset57a = this.__formReset57a;
        if (!this.__formReset57aSet)
        {
            // formReset has no pre constraints
            formReset57a = handleIsFormReset();
            // formReset has no post constraints
            this.__formReset57a = formReset57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formReset57aSet = true;
            }
        }
        return formReset57a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationGetter()
    * @return String
    */
    protected abstract String handleGetFormImplementationGetter();

    private String __formImplementationGetter58a;
    private boolean __formImplementationGetter58aSet = false;

    /**
     * The signature of the accessor method that returns the form implementation instance.
     * @return (String)handleGetFormImplementationGetter()
     */
    public final String getFormImplementationGetter()
    {
        String formImplementationGetter58a = this.__formImplementationGetter58a;
        if (!this.__formImplementationGetter58aSet)
        {
            // formImplementationGetter has no pre constraints
            formImplementationGetter58a = handleGetFormImplementationGetter();
            // formImplementationGetter has no post constraints
            this.__formImplementationGetter58a = formImplementationGetter58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formImplementationGetter58aSet = true;
            }
        }
        return formImplementationGetter58a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormSerialVersionUID()
    * @return String
    */
    protected abstract String handleGetFormSerialVersionUID();

    private String __formSerialVersionUID59a;
    private boolean __formSerialVersionUID59aSet = false;

    /**
     * The calcuated serial version UID for this action's form.
     * @return (String)handleGetFormSerialVersionUID()
     */
    public final String getFormSerialVersionUID()
    {
        String formSerialVersionUID59a = this.__formSerialVersionUID59a;
        if (!this.__formSerialVersionUID59aSet)
        {
            // formSerialVersionUID has no pre constraints
            formSerialVersionUID59a = handleGetFormSerialVersionUID();
            // formSerialVersionUID has no post constraints
            this.__formSerialVersionUID59a = formSerialVersionUID59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formSerialVersionUID59aSet = true;
            }
        }
        return formSerialVersionUID59a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFinalStateTarget()
    * @return boolean
    */
    protected abstract boolean handleIsFinalStateTarget();

    private boolean __finalStateTarget60a;
    private boolean __finalStateTarget60aSet = false;

    /**
     * Indicates whether or not a final state is the target of this action.
     * @return (boolean)handleIsFinalStateTarget()
     */
    public final boolean isFinalStateTarget()
    {
        boolean finalStateTarget60a = this.__finalStateTarget60a;
        if (!this.__finalStateTarget60aSet)
        {
            // finalStateTarget has no pre constraints
            finalStateTarget60a = handleIsFinalStateTarget();
            // finalStateTarget has no post constraints
            this.__finalStateTarget60a = finalStateTarget60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__finalStateTarget60aSet = true;
            }
        }
        return finalStateTarget60a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFromOutcome()
    * @return String
    */
    protected abstract String handleGetFromOutcome();

    private String __fromOutcome61a;
    private boolean __fromOutcome61aSet = false;

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @return (String)handleGetFromOutcome()
     */
    public final String getFromOutcome()
    {
        String fromOutcome61a = this.__fromOutcome61a;
        if (!this.__fromOutcome61aSet)
        {
            // fromOutcome has no pre constraints
            fromOutcome61a = handleGetFromOutcome();
            // fromOutcome has no post constraints
            this.__fromOutcome61a = fromOutcome61a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fromOutcome61aSet = true;
            }
        }
        return fromOutcome61a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isWarningMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsWarningMessagesPresent();

    private boolean __warningMessagesPresent62a;
    private boolean __warningMessagesPresent62aSet = false;

    /**
     * Whether or not any warning messages are present.
     * @return (boolean)handleIsWarningMessagesPresent()
     */
    public final boolean isWarningMessagesPresent()
    {
        boolean warningMessagesPresent62a = this.__warningMessagesPresent62a;
        if (!this.__warningMessagesPresent62aSet)
        {
            // warningMessagesPresent has no pre constraints
            warningMessagesPresent62a = handleIsWarningMessagesPresent();
            // warningMessagesPresent has no post constraints
            this.__warningMessagesPresent62a = warningMessagesPresent62a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__warningMessagesPresent62aSet = true;
            }
        }
        return warningMessagesPresent62a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getWarningMessages()
    * @return Map
    */
    protected abstract Map handleGetWarningMessages();

    private Map __warningMessages63a;
    private boolean __warningMessages63aSet = false;

    /**
     * Any messages used to indicate a warning.
     * @return (Map)handleGetWarningMessages()
     */
    public final Map getWarningMessages()
    {
        Map warningMessages63a = this.__warningMessages63a;
        if (!this.__warningMessages63aSet)
        {
            // warningMessages has no pre constraints
            warningMessages63a = handleGetWarningMessages();
            // warningMessages has no post constraints
            this.__warningMessages63a = warningMessages63a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__warningMessages63aSet = true;
            }
        }
        return warningMessages63a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isSuccessMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsSuccessMessagesPresent();

    private boolean __successMessagesPresent64a;
    private boolean __successMessagesPresent64aSet = false;

    /**
     * Indicates whether or not any success messags are present.
     * @return (boolean)handleIsSuccessMessagesPresent()
     */
    public final boolean isSuccessMessagesPresent()
    {
        boolean successMessagesPresent64a = this.__successMessagesPresent64a;
        if (!this.__successMessagesPresent64aSet)
        {
            // successMessagesPresent has no pre constraints
            successMessagesPresent64a = handleIsSuccessMessagesPresent();
            // successMessagesPresent has no post constraints
            this.__successMessagesPresent64a = successMessagesPresent64a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__successMessagesPresent64aSet = true;
            }
        }
        return successMessagesPresent64a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getSuccessMessages()
    * @return Map
    */
    protected abstract Map handleGetSuccessMessages();

    private Map __successMessages65a;
    private boolean __successMessages65aSet = false;

    /**
     * Messages used to indicate successful execution.
     * @return (Map)handleGetSuccessMessages()
     */
    public final Map getSuccessMessages()
    {
        Map successMessages65a = this.__successMessages65a;
        if (!this.__successMessages65aSet)
        {
            // successMessages has no pre constraints
            successMessages65a = handleGetSuccessMessages();
            // successMessages has no post constraints
            this.__successMessages65a = successMessages65a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__successMessages65aSet = true;
            }
        }
        return successMessages65a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isErrorMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsErrorMessagesPresent();

    private boolean __errorMessagesPresent66a;
    private boolean __errorMessagesPresent66aSet = false;

    /**
     * 
     * @return (boolean)handleIsErrorMessagesPresent()
     */
    public final boolean isErrorMessagesPresent()
    {
        boolean errorMessagesPresent66a = this.__errorMessagesPresent66a;
        if (!this.__errorMessagesPresent66aSet)
        {
            // errorMessagesPresent has no pre constraints
            errorMessagesPresent66a = handleIsErrorMessagesPresent();
            // errorMessagesPresent has no post constraints
            this.__errorMessagesPresent66a = errorMessagesPresent66a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__errorMessagesPresent66aSet = true;
            }
        }
        return errorMessagesPresent66a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getErrorMessages()
    * @return Map
    */
    protected abstract Map handleGetErrorMessages();

    private Map __errorMessages67a;
    private boolean __errorMessages67aSet = false;

    /**
     * 
     * @return (Map)handleGetErrorMessages()
     */
    public final Map getErrorMessages()
    {
        Map errorMessages67a = this.__errorMessages67a;
        if (!this.__errorMessages67aSet)
        {
            // errorMessages has no pre constraints
            errorMessages67a = handleGetErrorMessages();
            // errorMessages has no post constraints
            this.__errorMessages67a = errorMessages67a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__errorMessages67aSet = true;
            }
        }
        return errorMessages67a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isNeedsFileUpload()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsFileUpload();

    private boolean __needsFileUpload68a;
    private boolean __needsFileUpload68aSet = false;

    /**
     * 
     * @return (boolean)handleIsNeedsFileUpload()
     */
    public final boolean isNeedsFileUpload()
    {
        boolean needsFileUpload68a = this.__needsFileUpload68a;
        if (!this.__needsFileUpload68aSet)
        {
            // needsFileUpload has no pre constraints
            needsFileUpload68a = handleIsNeedsFileUpload();
            // needsFileUpload has no post constraints
            this.__needsFileUpload68a = needsFileUpload68a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__needsFileUpload68aSet = true;
            }
        }
        return needsFileUpload68a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTriggerMethodName()
    * @return String
    */
    protected abstract String handleGetTriggerMethodName();

    private String __triggerMethodName69a;
    private boolean __triggerMethodName69aSet = false;

    /**
     * The name of the method to be executed when this action is triggered.
     * @return (String)handleGetTriggerMethodName()
     */
    public final String getTriggerMethodName()
    {
        String triggerMethodName69a = this.__triggerMethodName69a;
        if (!this.__triggerMethodName69aSet)
        {
            // triggerMethodName has no pre constraints
            triggerMethodName69a = handleGetTriggerMethodName();
            // triggerMethodName has no post constraints
            this.__triggerMethodName69a = triggerMethodName69a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__triggerMethodName69aSet = true;
            }
        }
        return triggerMethodName69a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getHiddenParameters()
    * @return List<GuiParameter>
    */
    protected abstract List<GuiParameter> handleGetHiddenParameters();

    private List<GuiParameter> __hiddenParameters70a;
    private boolean __hiddenParameters70aSet = false;

    /**
     * All parameters that are of hidden input type.
     * @return (List<GuiParameter>)handleGetHiddenParameters()
     */
    public final List<GuiParameter> getHiddenParameters()
    {
        List<GuiParameter> hiddenParameters70a = this.__hiddenParameters70a;
        if (!this.__hiddenParameters70aSet)
        {
            // hiddenParameters has no pre constraints
            hiddenParameters70a = handleGetHiddenParameters();
            // hiddenParameters has no post constraints
            this.__hiddenParameters70a = hiddenParameters70a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hiddenParameters70aSet = true;
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

    private List<GuiView> __getTargetPages1r;
    private boolean __getTargetPages1rSet = false;

    /**
     * Returns all actions that possibly result in returning this page.
     * @return (List<GuiView>)handleGetTargetPages()
     */
    public final List<GuiView> getTargetPages()
    {
        List<GuiView> getTargetPages1r = this.__getTargetPages1r;
        if (!this.__getTargetPages1rSet)
        {
            // incomingActions has no pre constraints
            List result = handleGetTargetPages();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getTargetPages1r = (List<GuiView>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getTargetPages List<GuiView> " + result + ": " + shieldedResult);
            }
            // incomingActions has no post constraints
            this.__getTargetPages1r = getTargetPages1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getTargetPages1rSet = true;
            }
        }
        return getTargetPages1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetTargetPages();

    private List<GuiParameter> __getActionParametersToDeletes2r;
    private boolean __getActionParametersToDeletes2rSet = false;

    /**
     * The actions used when submitting forms for this table. Table actions that are hyperlinks are
     * not included. It only makes sense to call this property on parameters that represent a table
     * page-variable.
     * @return (List<GuiParameter>)handleGetActionParametersToDeletes()
     */
    public final List<GuiParameter> getActionParametersToDeletes()
    {
        List<GuiParameter> getActionParametersToDeletes2r = this.__getActionParametersToDeletes2r;
        if (!this.__getActionParametersToDeletes2rSet)
        {
            // tableFormActions has no pre constraints
            List result = handleGetActionParametersToDeletes();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getActionParametersToDeletes2r = (List<GuiParameter>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getActionParametersToDeletes List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // tableFormActions has no post constraints
            this.__getActionParametersToDeletes2r = getActionParametersToDeletes2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getActionParametersToDeletes2rSet = true;
            }
        }
        return getActionParametersToDeletes2r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetActionParametersToDeletes();

    private List<GuiParameter> __getActionFormFieldsToDeletes3r;
    private boolean __getActionFormFieldsToDeletes3rSet = false;

    /**
     * 
     * @return (List<GuiParameter>)handleGetActionFormFieldsToDeletes()
     */
    public final List<GuiParameter> getActionFormFieldsToDeletes()
    {
        List<GuiParameter> getActionFormFieldsToDeletes3r = this.__getActionFormFieldsToDeletes3r;
        if (!this.__getActionFormFieldsToDeletes3rSet)
        {
            // guiAction has no pre constraints
            List result = handleGetActionFormFieldsToDeletes();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getActionFormFieldsToDeletes3r = (List<GuiParameter>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getActionFormFieldsToDeletes List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiAction has no post constraints
            this.__getActionFormFieldsToDeletes3r = getActionFormFieldsToDeletes3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getActionFormFieldsToDeletes3rSet = true;
            }
        }
        return getActionFormFieldsToDeletes3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetActionFormFieldsToDeletes();

    private List<GuiParameter> __getResettableActionParameters4r;
    private boolean __getResettableActionParameters4rSet = false;

    /**
     * 
     * @return (List<GuiParameter>)handleGetResettableActionParameters()
     */
    public final List<GuiParameter> getResettableActionParameters()
    {
        List<GuiParameter> getResettableActionParameters4r = this.__getResettableActionParameters4r;
        if (!this.__getResettableActionParameters4rSet)
        {
            // guiAction has no pre constraints
            List result = handleGetResettableActionParameters();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getResettableActionParameters4r = (List<GuiParameter>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getResettableActionParameters List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiAction has no post constraints
            this.__getResettableActionParameters4r = getResettableActionParameters4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getResettableActionParameters4rSet = true;
            }
        }
        return getResettableActionParameters4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetResettableActionParameters();

    private List<GuiExceptionHandler> __getActionExceptionsToDeletes5r;
    private boolean __getActionExceptionsToDeletes5rSet = false;

    /**
     * 
     * @return (List<GuiExceptionHandler>)handleGetActionExceptionsToDeletes()
     */
    public final List<GuiExceptionHandler> getActionExceptionsToDeletes()
    {
        List<GuiExceptionHandler> getActionExceptionsToDeletes5r = this.__getActionExceptionsToDeletes5r;
        if (!this.__getActionExceptionsToDeletes5rSet)
        {
            // guiAction has no pre constraints
            List result = handleGetActionExceptionsToDeletes();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getActionExceptionsToDeletes5r = (List<GuiExceptionHandler>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getActionExceptionsToDeletes List<GuiExceptionHandler> " + result + ": " + shieldedResult);
            }
            // guiAction has no post constraints
            this.__getActionExceptionsToDeletes5r = getActionExceptionsToDeletes5r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getActionExceptionsToDeletes5rSet = true;
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
     * 
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
            getTableNonColumnFormParameters6r = (List<GuiParameter>)shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getTableNonColumnFormParameters List<GuiParameter> " + result + ": " + shieldedResult);
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
     * 
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
            getHiddenActionParameters7r = (List<GuiParameter>)shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getHiddenActionParameters List<GuiParameter> " + result + ": " + shieldedResult);
        }
        // guiAction has no post constraints
        return getHiddenActionParameters7r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetHiddenActionParameters();

    private GuiParameter __getTableLinkParameter8r;
    private boolean __getTableLinkParameter8rSet = false;

    /**
     * Those actions that are working on this table and are to be represented as hyperlinks. It only
     * makes sense to call this property on parameters that represent a table page-variable.
     * @return (GuiParameter)handleGetTableLinkParameter()
     */
    public final GuiParameter getTableLinkParameter()
    {
        GuiParameter getTableLinkParameter8r = this.__getTableLinkParameter8r;
        if (!this.__getTableLinkParameter8rSet)
        {
            // tableHyperlinkActions has no pre constraints
            Object result = handleGetTableLinkParameter();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getTableLinkParameter8r = (GuiParameter)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getTableLinkParameter GuiParameter " + result + ": " + shieldedResult);
            }
            // tableHyperlinkActions has no post constraints
            this.__getTableLinkParameter8r = getTableLinkParameter8r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getTableLinkParameter8rSet = true;
            }
        }
        return getTableLinkParameter8r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetTableLinkParameter();

    private GuiTrigger __getActionTriggerToDelete9r;
    private boolean __getActionTriggerToDelete9rSet = false;

    /**
     * If isActionTrigger() returns true them this association points to the action to which the
     * trigger has been associated.
     * @return (GuiTrigger)handleGetActionTriggerToDelete()
     */
    public final GuiTrigger getActionTriggerToDelete()
    {
        GuiTrigger getActionTriggerToDelete9r = this.__getActionTriggerToDelete9r;
        if (!this.__getActionTriggerToDelete9rSet)
        {
            // guiAction has no pre constraints
            Object result = handleGetActionTriggerToDelete();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getActionTriggerToDelete9r = (GuiTrigger)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiActionLogic.logger.warn("incorrect metafacade cast for GuiActionLogic.getActionTriggerToDelete GuiTrigger " + result + ": " + shieldedResult);
            }
            // guiAction has no post constraints
            this.__getActionTriggerToDelete9r = getActionTriggerToDelete9r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getActionTriggerToDelete9rSet = true;
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
     * 
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
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperFrontEndAction().getLanguageMappings();
    }

    /**
     * 
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
     * 
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
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperFrontEndAction().getTemplateParameter(parameterName);
    }

    /**
     * 
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
     * 
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
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperFrontEndAction().isTemplateParametersPresent();
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
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#getEffect()
     */
    public ActionFacade getEffect()
    {
        return this.getSuperFrontEndAction().getEffect();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#getGuard()
     */
    public GuardFacade getGuard()
    {
        return this.getSuperFrontEndAction().getGuard();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#getSource()
     */
    public StateVertexFacade getSource()
    {
        return this.getSuperFrontEndAction().getSource();
    }

    /**
     * 
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
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringActionState()
     */
    public boolean isEnteringActionState()
    {
        return this.getSuperFrontEndAction().isEnteringActionState();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringDecisionPoint()
     */
    public boolean isEnteringDecisionPoint()
    {
        return this.getSuperFrontEndAction().isEnteringDecisionPoint();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringFinalState()
     */
    public boolean isEnteringFinalState()
    {
        return this.getSuperFrontEndAction().isEnteringFinalState();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingActionState()
     */
    public boolean isExitingActionState()
    {
        return this.getSuperFrontEndAction().isExitingActionState();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingDecisionPoint()
     */
    public boolean isExitingDecisionPoint()
    {
        return this.getSuperFrontEndAction().isExitingDecisionPoint();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingInitialState()
     */
    public boolean isExitingInitialState()
    {
        return this.getSuperFrontEndAction().isExitingInitialState();
    }

    /**
     * 
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