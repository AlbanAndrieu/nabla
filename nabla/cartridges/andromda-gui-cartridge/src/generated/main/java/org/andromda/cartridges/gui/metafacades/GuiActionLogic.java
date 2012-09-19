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

    private String actionName1a;
    private boolean actionName1aSet = false;

    /**
     * The action name corresponding to this action, as found in the gui deployment descriptor. The
     * action name maps the action to a form bean.
     * @return (String)handleGetActionName()
     */
    public final String getActionName()
    {
        String aactionName1a = this.actionName1a;
        if (!this.actionName1aSet)
        {
            // actionName has no pre constraints
            aactionName1a = handleGetActionName();
            // actionName has no post constraints
            this.actionName1a = aactionName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionName1aSet = true;
            }
        }
        return aactionName1a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionPath()
    * @return String
    */
    protected abstract String handleGetActionPath();

    private String actionPath2a;
    private boolean actionPath2aSet = false;

    /**
     * The action path corresponding to this action, as found in the gui deployment descriptor. The
     * action path specifies the URL to enter in order to call the action.
     * @return (String)handleGetActionPath()
     */
    public final String getActionPath()
    {
        String aactionPath2a = this.actionPath2a;
        if (!this.actionPath2aSet)
        {
            // actionPath has no pre constraints
            aactionPath2a = handleGetActionPath();
            // actionPath has no post constraints
            this.actionPath2a = aactionPath2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionPath2aSet = true;
            }
        }
        return aactionPath2a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionInput()
    * @return String
    */
    protected abstract String handleGetActionInput();

    private String actionInput3a;
    private boolean actionInput3aSet = false;

    /**
     * The action input corresponding to this action, as found in the gui deployment descriptor. The
     * action input maps the action to the page on which it originated.
     * @return (String)handleGetActionInput()
     */
    public final String getActionInput()
    {
        String aactionInput3a = this.actionInput3a;
        if (!this.actionInput3aSet)
        {
            // actionInput has no pre constraints
            aactionInput3a = handleGetActionInput();
            // actionInput has no post constraints
            this.actionInput3a = aactionInput3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionInput3aSet = true;
            }
        }
        return aactionInput3a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionRoles()
    * @return String
    */
    protected abstract String handleGetActionRoles();

    private String actionRoles4a;
    private boolean actionRoles4aSet = false;

    /**
     * The action roles corresponding to this action, as found in the gui deployment descriptor. The
     * action roles specifiy the roles in which the user must be in order to be authorized to call
     * the action. One of the roles must be satisfied.
     * @return (String)handleGetActionRoles()
     */
    public final String getActionRoles()
    {
        String aactionRoles4a = this.actionRoles4a;
        if (!this.actionRoles4aSet)
        {
            // actionRoles has no pre constraints
            aactionRoles4a = handleGetActionRoles();
            // actionRoles has no post constraints
            this.actionRoles4a = aactionRoles4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionRoles4aSet = true;
            }
        }
        return aactionRoles4a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormPost()
    * @return boolean
    */
    protected abstract boolean handleIsFormPost();

    private boolean formPost5a;
    private boolean formPost5aSet = false;

    /**
     * Specifies whether or not this action is represented by the posting of a form.
     * @return (boolean)handleIsFormPost()
     */
    public final boolean isFormPost()
    {
        boolean aformPost5a = this.formPost5a;
        if (!this.formPost5aSet)
        {
            // formPost has no pre constraints
            aformPost5a = handleIsFormPost();
            // formPost has no post constraints
            this.formPost5a = aformPost5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formPost5aSet = true;
            }
        }
        return aformPost5a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isHyperlink()
    * @return boolean
    */
    protected abstract boolean handleIsHyperlink();

    private boolean hyperlink6a;
    private boolean hyperlink6aSet = false;

    /**
     * Specifies whether or not this action is represented by clicking on a hyperlink.
     * @return (boolean)handleIsHyperlink()
     */
    public final boolean isHyperlink()
    {
        boolean ahyperlink6a = this.hyperlink6a;
        if (!this.hyperlink6aSet)
        {
            // hyperlink has no pre constraints
            ahyperlink6a = handleIsHyperlink();
            // hyperlink has no post constraints
            this.hyperlink6a = ahyperlink6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hyperlink6aSet = true;
            }
        }
        return ahyperlink6a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionClassName()
    * @return String
    */
    protected abstract String handleGetActionClassName();

    private String actionClassName7a;
    private boolean actionClassName7aSet = false;

    /**
     * A good Java class name for this action. The name is constructed from the source page and the
     * name of the trigger.
     * @return (String)handleGetActionClassName()
     */
    public final String getActionClassName()
    {
        String aactionClassName7a = this.actionClassName7a;
        if (!this.actionClassName7aSet)
        {
            // actionClassName has no pre constraints
            aactionClassName7a = handleGetActionClassName();
            // actionClassName has no post constraints
            this.actionClassName7a = aactionClassName7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionClassName7aSet = true;
            }
        }
        return aactionClassName7a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanClassName()
    * @return String
    */
    protected abstract String handleGetFormBeanClassName();

    private String formBeanClassName8a;
    private boolean formBeanClassName8aSet = false;

    /**
     * Returns the class name of the form bean associated to this action.
     * @return (String)handleGetFormBeanClassName()
     */
    public final String getFormBeanClassName()
    {
        String aformBeanClassName8a = this.formBeanClassName8a;
        if (!this.formBeanClassName8aSet)
        {
            // formBeanClassName has no pre constraints
            aformBeanClassName8a = handleGetFormBeanClassName();
            // formBeanClassName has no post constraints
            this.formBeanClassName8a = aformBeanClassName8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanClassName8aSet = true;
            }
        }
        return aformBeanClassName8a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanName()
    * @return String
    */
    protected abstract String handleGetFormBeanName();

    private String formBeanName9a;
    private boolean formBeanName9aSet = false;

    /**
     * The name of the form bean associated to this action. The name is returned as it should appear
     * in the Gui deployment descriptor.
     * @return (String)handleGetFormBeanName()
     */
    public final String getFormBeanName()
    {
        String aformBeanName9a = this.formBeanName9a;
        if (!this.formBeanName9aSet)
        {
            // formBeanName has no pre constraints
            aformBeanName9a = handleGetFormBeanName();
            // formBeanName has no post constraints
            this.formBeanName9a = aformBeanName9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanName9aSet = true;
            }
        }
        return aformBeanName9a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormValidationMethodName()
    * @return String
    */
    protected abstract String handleGetFormValidationMethodName();

    private String formValidationMethodName10a;
    private boolean formValidationMethodName10aSet = false;

    /**
     * The Javascript function name of the validation method that will validate the action
     * parameters.
     * @return (String)handleGetFormValidationMethodName()
     */
    public final String getFormValidationMethodName()
    {
        String aformValidationMethodName10a = this.formValidationMethodName10a;
        if (!this.formValidationMethodName10aSet)
        {
            // formValidationMethodName has no pre constraints
            aformValidationMethodName10a = handleGetFormValidationMethodName();
            // formValidationMethodName has no post constraints
            this.formValidationMethodName10a = aformValidationMethodName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formValidationMethodName10aSet = true;
            }
        }
        return aformValidationMethodName10a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isResettable()
    * @return boolean
    */
    protected abstract boolean handleIsResettable();

    private boolean resettable11a;
    private boolean resettable11aSet = false;

    /**
     * True if it should be possible to reset the form represented by this action. False otherwise.
     * @return (boolean)handleIsResettable()
     */
    public final boolean isResettable()
    {
        boolean aresettable11a = this.resettable11a;
        if (!this.resettable11aSet)
        {
            // resettable has no pre constraints
            aresettable11a = handleIsResettable();
            // resettable has no post constraints
            this.resettable11a = aresettable11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resettable11aSet = true;
            }
        }
        return aresettable11a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullActionPath()
    * @return String
    */
    protected abstract String handleGetFullActionPath();

    private String fullActionPath12a;
    private boolean fullActionPath12aSet = false;

    /**
     * The full path for this action. The full path also contains the package name rendered as
     * directories.
     * @return (String)handleGetFullActionPath()
     */
    public final String getFullActionPath()
    {
        String afullActionPath12a = this.fullActionPath12a;
        if (!this.fullActionPath12aSet)
        {
            // fullActionPath has no pre constraints
            afullActionPath12a = handleGetFullActionPath();
            // fullActionPath has no post constraints
            this.fullActionPath12a = afullActionPath12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullActionPath12aSet = true;
            }
        }
        return afullActionPath12a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullFormBeanPath()
    * @return String
    */
    protected abstract String handleGetFullFormBeanPath();

    private String fullFormBeanPath13a;
    private boolean fullFormBeanPath13aSet = false;

    /**
     * Returns the full path for the form bean associated to this action.
     * @return (String)handleGetFullFormBeanPath()
     */
    public final String getFullFormBeanPath()
    {
        String afullFormBeanPath13a = this.fullFormBeanPath13a;
        if (!this.fullFormBeanPath13aSet)
        {
            // fullFormBeanPath has no pre constraints
            afullFormBeanPath13a = handleGetFullFormBeanPath();
            // fullFormBeanPath has no post constraints
            this.fullFormBeanPath13a = afullFormBeanPath13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullFormBeanPath13aSet = true;
            }
        }
        return afullFormBeanPath13a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionPathRoot()
    * @return String
    */
    protected abstract String handleGetActionPathRoot();

    private String actionPathRoot14a;
    private boolean actionPathRoot14aSet = false;

    /**
     * The root of the action path, this is the same as the path for the use-case context for this
     * action, that is, the use-case holding the activity graph in which this action is contained.
     * @return (String)handleGetActionPathRoot()
     */
    public final String getActionPathRoot()
    {
        String aactionPathRoot14a = this.actionPathRoot14a;
        if (!this.actionPathRoot14aSet)
        {
            // actionPathRoot has no pre constraints
            aactionPathRoot14a = handleGetActionPathRoot();
            // actionPathRoot has no post constraints
            this.actionPathRoot14a = aactionPathRoot14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionPathRoot14aSet = true;
            }
        }
        return aactionPathRoot14a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private boolean validationRequired15a;
    private boolean validationRequired15aSet = false;

    /**
     * True if this action requires validation, false otherwise. An action requires validation if it
     * represented by a form and one or more fields require validation.
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean avalidationRequired15a = this.validationRequired15a;
        if (!this.validationRequired15aSet)
        {
            // validationRequired has no pre constraints
            avalidationRequired15a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.validationRequired15a = avalidationRequired15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validationRequired15aSet = true;
            }
        }
        return avalidationRequired15a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanType()
    * @return String
    */
    protected abstract String handleGetFormBeanType();

    private String formBeanType16a;
    private boolean formBeanType16aSet = false;

    /**
     * The fully qualified name of the form bean associated to this action.
     * @return (String)handleGetFormBeanType()
     */
    public final String getFormBeanType()
    {
        String aformBeanType16a = this.formBeanType16a;
        if (!this.formBeanType16aSet)
        {
            // formBeanType has no pre constraints
            aformBeanType16a = handleGetFormBeanType();
            // formBeanType has no post constraints
            this.formBeanType16a = aformBeanType16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanType16aSet = true;
            }
        }
        return aformBeanType16a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getDocumentationValue()
    * @return String
    */
    protected abstract String handleGetDocumentationValue();

    private String documentationValue17a;
    private boolean documentationValue17aSet = false;

    /**
     * The documentation for this action as a String that can be used as a resource message (with
     * the backslashes at the end of the line).
     * @return (String)handleGetDocumentationValue()
     */
    public final String getDocumentationValue()
    {
        String adocumentationValue17a = this.documentationValue17a;
        if (!this.documentationValue17aSet)
        {
            // documentationValue has no pre constraints
            adocumentationValue17a = handleGetDocumentationValue();
            // documentationValue has no post constraints
            this.documentationValue17a = adocumentationValue17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentationValue17aSet = true;
            }
        }
        return adocumentationValue17a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getDocumentationKey()
    * @return String
    */
    protected abstract String handleGetDocumentationKey();

    private String documentationKey18a;
    private boolean documentationKey18aSet = false;

    /**
     * A key suited as a resource message key for the documentation for this action.
     * @return (String)handleGetDocumentationKey()
     */
    public final String getDocumentationKey()
    {
        String adocumentationKey18a = this.documentationKey18a;
        if (!this.documentationKey18aSet)
        {
            // documentationKey has no pre constraints
            adocumentationKey18a = handleGetDocumentationKey();
            // documentationKey has no post constraints
            this.documentationKey18a = adocumentationKey18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentationKey18aSet = true;
            }
        }
        return adocumentationKey18a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullTilePath()
    * @return String
    */
    protected abstract String handleGetFullTilePath();

    private String fullTilePath19a;
    private boolean fullTilePath19aSet = false;

    /**
     * The name of a file that can be used as a view file name in case you want to have each action
     * rendered onto a different tile.
     * @return (String)handleGetFullTilePath()
     */
    public final String getFullTilePath()
    {
        String afullTilePath19a = this.fullTilePath19a;
        if (!this.fullTilePath19aSet)
        {
            // fullTilePath has no pre constraints
            afullTilePath19a = handleGetFullTilePath();
            // fullTilePath has no post constraints
            this.fullTilePath19a = afullTilePath19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullTilePath19aSet = true;
            }
        }
        return afullTilePath19a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isDateFieldPresent()
    * @return boolean
    */
    protected abstract boolean handleIsDateFieldPresent();

    private boolean dateFieldPresent20a;
    private boolean dateFieldPresent20aSet = false;

    /**
     * True if this action contains a parameter of type Date. The generated pages will contain
     * special javascript code to handle them (popup window etc...).
     * @return (boolean)handleIsDateFieldPresent()
     */
    public final boolean isDateFieldPresent()
    {
        boolean adateFieldPresent20a = this.dateFieldPresent20a;
        if (!this.dateFieldPresent20aSet)
        {
            // dateFieldPresent has no pre constraints
            adateFieldPresent20a = handleIsDateFieldPresent();
            // dateFieldPresent has no post constraints
            this.dateFieldPresent20a = adateFieldPresent20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dateFieldPresent20aSet = true;
            }
        }
        return adateFieldPresent20a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isCalendarRequired()
    * @return boolean
    */
    protected abstract boolean handleIsCalendarRequired();

    private boolean calendarRequired21a;
    private boolean calendarRequired21aSet = false;

    /**
     * True if this action contains a parameter which requires a calendar popup.
     * @return (boolean)handleIsCalendarRequired()
     */
    public final boolean isCalendarRequired()
    {
        boolean acalendarRequired21a = this.calendarRequired21a;
        if (!this.calendarRequired21aSet)
        {
            // calendarRequired has no pre constraints
            acalendarRequired21a = handleIsCalendarRequired();
            // calendarRequired has no post constraints
            this.calendarRequired21a = acalendarRequired21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.calendarRequired21aSet = true;
            }
        }
        return acalendarRequired21a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableLink()
    * @return boolean
    */
    protected abstract boolean handleIsTableLink();

    private boolean tableLink22a;
    private boolean tableLink22aSet = false;

    /**
     * True if a table link name has been specified and it properly targets a table page-variable
     * from the input page.
     * @return (boolean)handleIsTableLink()
     */
    public final boolean isTableLink()
    {
        boolean atableLink22a = this.tableLink22a;
        if (!this.tableLink22aSet)
        {
            // tableLink has no pre constraints
            atableLink22a = handleIsTableLink();
            // tableLink has no post constraints
            this.tableLink22a = atableLink22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableLink22aSet = true;
            }
        }
        return atableLink22a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String onlineHelpKey23a;
    private boolean onlineHelpKey23aSet = false;

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String aonlineHelpKey23a = this.onlineHelpKey23a;
        if (!this.onlineHelpKey23aSet)
        {
            // onlineHelpKey has no pre constraints
            aonlineHelpKey23a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.onlineHelpKey23a = aonlineHelpKey23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpKey23aSet = true;
            }
        }
        return aonlineHelpKey23a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String onlineHelpValue24a;
    private boolean onlineHelpValue24aSet = false;

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String aonlineHelpValue24a = this.onlineHelpValue24a;
        if (!this.onlineHelpValue24aSet)
        {
            // onlineHelpValue has no pre constraints
            aonlineHelpValue24a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.onlineHelpValue24a = aonlineHelpValue24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpValue24aSet = true;
            }
        }
        return aonlineHelpValue24a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionScope()
    * @return String
    */
    protected abstract String handleGetActionScope();

    private String actionScope25a;
    private boolean actionScope25aSet = false;

    /**
     * The scope in which the form bean will be placed (could be page, request, session or
     * application).
     * @return (String)handleGetActionScope()
     */
    public final String getActionScope()
    {
        String aactionScope25a = this.actionScope25a;
        if (!this.actionScope25aSet)
        {
            // actionScope has no pre constraints
            aactionScope25a = handleGetActionScope();
            // actionScope has no post constraints
            this.actionScope25a = aactionScope25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionScope25aSet = true;
            }
        }
        return aactionScope25a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormBeanPackageName()
    * @return String
    */
    protected abstract String handleGetFormBeanPackageName();

    private String formBeanPackageName26a;
    private boolean formBeanPackageName26aSet = false;

    /**
     * The package for the form bean.
     * @return (String)handleGetFormBeanPackageName()
     */
    public final String getFormBeanPackageName()
    {
        String aformBeanPackageName26a = this.formBeanPackageName26a;
        if (!this.formBeanPackageName26aSet)
        {
            // formBeanPackageName has no pre constraints
            aformBeanPackageName26a = handleGetFormBeanPackageName();
            // formBeanPackageName has no post constraints
            this.formBeanPackageName26a = aformBeanPackageName26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanPackageName26aSet = true;
            }
        }
        return aformBeanPackageName26a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getActionType()
    * @return String
    */
    protected abstract String handleGetActionType();

    private String actionType27a;
    private boolean actionType27aSet = false;

    /**
     * The fully qualified name for the action class.
     * @return (String)handleGetActionType()
     */
    public final String getActionType()
    {
        String aactionType27a = this.actionType27a;
        if (!this.actionType27aSet)
        {
            // actionType has no pre constraints
            aactionType27a = handleGetActionType();
            // actionType has no post constraints
            this.actionType27a = aactionType27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionType27aSet = true;
            }
        }
        return aactionType27a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getStyleId()
    * @return String
    */
    protected abstract String handleGetStyleId();

    private String styleId28a;
    private boolean styleId28aSet = false;

    /**
     * The name of the CSS id in which this action will be contained.
     * @return (String)handleGetStyleId()
     */
    public final String getStyleId()
    {
        String astyleId28a = this.styleId28a;
        if (!this.styleId28aSet)
        {
            // styleId has no pre constraints
            astyleId28a = handleGetStyleId();
            // styleId has no post constraints
            this.styleId28a = astyleId28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.styleId28aSet = true;
            }
        }
        return astyleId28a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isRedirect()
    * @return boolean
    */
    protected abstract boolean handleIsRedirect();

    private boolean redirect29a;
    private boolean redirect29aSet = false;

    /**
     * Defines whether or not when this action's forward is executed, an HTTP redirect should occur.
     *  Default value is based on the value of the 'defaultActionRedirect' namespace.
     * @return (boolean)handleIsRedirect()
     */
    public final boolean isRedirect()
    {
        boolean aredirect29a = this.redirect29a;
        if (!this.redirect29aSet)
        {
            // redirect has no pre constraints
            aredirect29a = handleIsRedirect();
            // redirect has no post constraints
            this.redirect29a = aredirect29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.redirect29aSet = true;
            }
        }
        return aredirect29a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormScope()
    * @return String
    */
    protected abstract String handleGetFormScope();

    private String formScope30a;
    private boolean formScope30aSet = false;

    /**
     * The scope to place the current "form" variable within when this action is executing.
     * @return (String)handleGetFormScope()
     */
    public final String getFormScope()
    {
        String aformScope30a = this.formScope30a;
        if (!this.formScope30aSet)
        {
            // formScope has no pre constraints
            aformScope30a = handleGetFormScope();
            // formScope has no post constraints
            this.formScope30a = aformScope30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formScope30aSet = true;
            }
        }
        return aformScope30a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeSession()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeSession();

    private boolean formScopeSession31a;
    private boolean formScopeSession31aSet = false;

    /**
     * Indicates if the form scope is of type "session".
     * @return (boolean)handleIsFormScopeSession()
     */
    public final boolean isFormScopeSession()
    {
        boolean aformScopeSession31a = this.formScopeSession31a;
        if (!this.formScopeSession31aSet)
        {
            // formScopeSession has no pre constraints
            aformScopeSession31a = handleIsFormScopeSession();
            // formScopeSession has no post constraints
            this.formScopeSession31a = aformScopeSession31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formScopeSession31aSet = true;
            }
        }
        return aformScopeSession31a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeRequest()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeRequest();

    private boolean formScopeRequest32a;
    private boolean formScopeRequest32aSet = false;

    /**
     * Indicates if the from scope is of type "request".
     * @return (boolean)handleIsFormScopeRequest()
     */
    public final boolean isFormScopeRequest()
    {
        boolean aformScopeRequest32a = this.formScopeRequest32a;
        if (!this.formScopeRequest32aSet)
        {
            // formScopeRequest has no pre constraints
            aformScopeRequest32a = handleIsFormScopeRequest();
            // formScopeRequest has no post constraints
            this.formScopeRequest32a = aformScopeRequest32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formScopeRequest32aSet = true;
            }
        }
        return aformScopeRequest32a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormScopeNone()
    * @return boolean
    */
    protected abstract boolean handleIsFormScopeNone();

    private boolean formScopeNone33a;
    private boolean formScopeNone33aSet = false;

    /**
     * Indicates if the form scope is of type "none".
     * @return (boolean)handleIsFormScopeNone()
     */
    public final boolean isFormScopeNone()
    {
        boolean aformScopeNone33a = this.formScopeNone33a;
        if (!this.formScopeNone33aSet)
        {
            // formScopeNone has no pre constraints
            aformScopeNone33a = handleIsFormScopeNone();
            // formScopeNone has no post constraints
            this.formScopeNone33a = aformScopeNone33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formScopeNone33aSet = true;
            }
        }
        return aformScopeNone33a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTableLinkName()
    * @return String
    */
    protected abstract String handleGetTableLinkName();

    private String tableLinkName34a;
    private boolean tableLinkName34aSet = false;

    /**
     * The name of the table link specified for this action.
     * @return (String)handleGetTableLinkName()
     */
    public final String getTableLinkName()
    {
        String atableLinkName34a = this.tableLinkName34a;
        if (!this.tableLinkName34aSet)
        {
            // tableLinkName has no pre constraints
            atableLinkName34a = handleGetTableLinkName();
            // tableLinkName has no post constraints
            this.tableLinkName34a = atableLinkName34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableLinkName34aSet = true;
            }
        }
        return atableLinkName34a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTableLinkColumnName()
    * @return String
    */
    protected abstract String handleGetTableLinkColumnName();

    private String tableLinkColumnName35a;
    private boolean tableLinkColumnName35aSet = false;

    /**
     * The name of the column targetted by this action.
     * @return (String)handleGetTableLinkColumnName()
     */
    public final String getTableLinkColumnName()
    {
        String atableLinkColumnName35a = this.tableLinkColumnName35a;
        if (!this.tableLinkColumnName35aSet)
        {
            // tableLinkColumnName has no pre constraints
            atableLinkColumnName35a = handleGetTableLinkColumnName();
            // tableLinkColumnName has no post constraints
            this.tableLinkColumnName35a = atableLinkColumnName35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableLinkColumnName35aSet = true;
            }
        }
        return atableLinkColumnName35a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isImageLink()
    * @return boolean
    */
    protected abstract boolean handleIsImageLink();

    private boolean imageLink36a;
    private boolean imageLink36aSet = false;

    /**
     * Specifies whether or not this action is represented by clicking on an image.
     * @return (boolean)handleIsImageLink()
     */
    public final boolean isImageLink()
    {
        boolean aimageLink36a = this.imageLink36a;
        if (!this.imageLink36aSet)
        {
            // imageLink has no pre constraints
            aimageLink36a = handleIsImageLink();
            // imageLink has no post constraints
            this.imageLink36a = aimageLink36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.imageLink36aSet = true;
            }
        }
        return aimageLink36a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getImagePath()
    * @return String
    */
    protected abstract String handleGetImagePath();

    private String imagePath37a;
    private boolean imagePath37aSet = false;

    /**
     * If this action is an imageLink this property represents the path to the corresponding image.
     * @return (String)handleGetImagePath()
     */
    public final String getImagePath()
    {
        String aimagePath37a = this.imagePath37a;
        if (!this.imagePath37aSet)
        {
            // imagePath has no pre constraints
            aimagePath37a = handleGetImagePath();
            // imagePath has no post constraints
            this.imagePath37a = aimagePath37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.imagePath37aSet = true;
            }
        }
        return aimagePath37a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private String messageKey38a;
    private boolean messageKey38aSet = false;

    /**
     * 
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String amessageKey38a = this.messageKey38a;
        if (!this.messageKey38aSet)
        {
            // messageKey has no pre constraints
            amessageKey38a = handleGetMessageKey();
            // messageKey has no post constraints
            this.messageKey38a = amessageKey38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageKey38aSet = true;
            }
        }
        return amessageKey38a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getImageMessageKey()
    * @return String
    */
    protected abstract String handleGetImageMessageKey();

    private String imageMessageKey39a;
    private boolean imageMessageKey39aSet = false;

    /**
     * The resource message key used to look to location of the image for this action.
     * @return (String)handleGetImageMessageKey()
     */
    public final String getImageMessageKey()
    {
        String aimageMessageKey39a = this.imageMessageKey39a;
        if (!this.imageMessageKey39aSet)
        {
            // imageMessageKey has no pre constraints
            aimageMessageKey39a = handleGetImageMessageKey();
            // imageMessageKey has no post constraints
            this.imageMessageKey39a = aimageMessageKey39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.imageMessageKey39aSet = true;
            }
        }
        return aimageMessageKey39a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableAction()
    * @return boolean
    */
    protected abstract boolean handleIsTableAction();

    private boolean tableAction40a;
    private boolean tableAction40aSet = false;

    /**
     * Denotes this action works on all rows of the table from the table link relation.
     * @return (boolean)handleIsTableAction()
     */
    public final boolean isTableAction()
    {
        boolean atableAction40a = this.tableAction40a;
        if (!this.tableAction40aSet)
        {
            // tableAction has no pre constraints
            atableAction40a = handleIsTableAction();
            // tableAction has no post constraints
            this.tableAction40a = atableAction40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableAction40aSet = true;
            }
        }
        return atableAction40a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isTableRowAction()
    * @return boolean
    */
    protected abstract boolean handleIsTableRowAction();

    private boolean tableRowAction41a;
    private boolean tableRowAction41aSet = false;

    /**
     * Denotes this action works on a single row of the table from the table link relation.
     * @return (boolean)handleIsTableRowAction()
     */
    public final boolean isTableRowAction()
    {
        boolean atableRowAction41a = this.tableRowAction41a;
        if (!this.tableRowAction41aSet)
        {
            // tableRowAction has no pre constraints
            atableRowAction41a = handleIsTableRowAction();
            // tableRowAction has no post constraints
            this.tableRowAction41a = atableRowAction41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableRowAction41aSet = true;
            }
        }
        return atableRowAction41a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isMultipartFormData()
    * @return boolean
    */
    protected abstract boolean handleIsMultipartFormData();

    private boolean multipartFormData42a;
    private boolean multipartFormData42aSet = false;

    /**
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return (boolean)handleIsMultipartFormData()
     */
    public final boolean isMultipartFormData()
    {
        boolean amultipartFormData42a = this.multipartFormData42a;
        if (!this.multipartFormData42aSet)
        {
            // multipartFormData has no pre constraints
            amultipartFormData42a = handleIsMultipartFormData();
            // multipartFormData has no post constraints
            this.multipartFormData42a = amultipartFormData42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.multipartFormData42aSet = true;
            }
        }
        return amultipartFormData42a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationName()
    * @return String
    */
    protected abstract String handleGetFormImplementationName();

    private String formImplementationName43a;
    private boolean formImplementationName43aSet = false;

    /**
     * The name of the form implementation.
     * @return (String)handleGetFormImplementationName()
     */
    public final String getFormImplementationName()
    {
        String aformImplementationName43a = this.formImplementationName43a;
        if (!this.formImplementationName43aSet)
        {
            // formImplementationName has no pre constraints
            aformImplementationName43a = handleGetFormImplementationName();
            // formImplementationName has no post constraints
            this.formImplementationName43a = aformImplementationName43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formImplementationName43aSet = true;
            }
        }
        return aformImplementationName43a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedFormImplementationName();

    private String fullyQualifiedFormImplementationName44a;
    private boolean fullyQualifiedFormImplementationName44aSet = false;

    /**
     * The fully qualified name of the form implementation.
     * @return (String)handleGetFullyQualifiedFormImplementationName()
     */
    public final String getFullyQualifiedFormImplementationName()
    {
        String afullyQualifiedFormImplementationName44a = this.fullyQualifiedFormImplementationName44a;
        if (!this.fullyQualifiedFormImplementationName44aSet)
        {
            // fullyQualifiedFormImplementationName has no pre constraints
            afullyQualifiedFormImplementationName44a = handleGetFullyQualifiedFormImplementationName();
            // fullyQualifiedFormImplementationName has no post constraints
            this.fullyQualifiedFormImplementationName44a = afullyQualifiedFormImplementationName44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedFormImplementationName44aSet = true;
            }
        }
        return afullyQualifiedFormImplementationName44a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedFormImplementationPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedFormImplementationPath();

    private String fullyQualifiedFormImplementationPath45a;
    private boolean fullyQualifiedFormImplementationPath45aSet = false;

    /**
     * The fully qualified path of the form implementation.
     * @return (String)handleGetFullyQualifiedFormImplementationPath()
     */
    public final String getFullyQualifiedFormImplementationPath()
    {
        String afullyQualifiedFormImplementationPath45a = this.fullyQualifiedFormImplementationPath45a;
        if (!this.fullyQualifiedFormImplementationPath45aSet)
        {
            // fullyQualifiedFormImplementationPath has no pre constraints
            afullyQualifiedFormImplementationPath45a = handleGetFullyQualifiedFormImplementationPath();
            // fullyQualifiedFormImplementationPath has no post constraints
            this.fullyQualifiedFormImplementationPath45a = afullyQualifiedFormImplementationPath45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedFormImplementationPath45aSet = true;
            }
        }
        return afullyQualifiedFormImplementationPath45a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationInterfaceList()
    * @return String
    */
    protected abstract String handleGetFormImplementationInterfaceList();

    private String formImplementationInterfaceList46a;
    private boolean formImplementationInterfaceList46aSet = false;

    /**
     * A comma separated list of all the form interfaces which the form implementation implements.
     * @return (String)handleGetFormImplementationInterfaceList()
     */
    public final String getFormImplementationInterfaceList()
    {
        String aformImplementationInterfaceList46a = this.formImplementationInterfaceList46a;
        if (!this.formImplementationInterfaceList46aSet)
        {
            // formImplementationInterfaceList has no pre constraints
            aformImplementationInterfaceList46a = handleGetFormImplementationInterfaceList();
            // formImplementationInterfaceList has no post constraints
            this.formImplementationInterfaceList46a = aformImplementationInterfaceList46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formImplementationInterfaceList46aSet = true;
            }
        }
        return aformImplementationInterfaceList46a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getPath()
    * @return String
    */
    protected abstract String handleGetPath();

    private String path47a;
    private boolean path47aSet = false;

    /**
     * The path to this action.
     * @return (String)handleGetPath()
     */
    public final String getPath()
    {
        String apath47a = this.path47a;
        if (!this.path47aSet)
        {
            // path has no pre constraints
            apath47a = handleGetPath();
            // path has no post constraints
            this.path47a = apath47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.path47aSet = true;
            }
        }
        return apath47a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getPathRoot()
    * @return String
    */
    protected abstract String handleGetPathRoot();

    private String pathRoot48a;
    private boolean pathRoot48aSet = false;

    /**
     * The path's root.
     * @return (String)handleGetPathRoot()
     */
    public final String getPathRoot()
    {
        String apathRoot48a = this.pathRoot48a;
        if (!this.pathRoot48aSet)
        {
            // pathRoot has no pre constraints
            apathRoot48a = handleGetPathRoot();
            // pathRoot has no post constraints
            this.pathRoot48a = apathRoot48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.pathRoot48aSet = true;
            }
        }
        return apathRoot48a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTriggerName()
    * @return String
    */
    protected abstract String handleGetTriggerName();

    private String triggerName49a;
    private boolean triggerName49aSet = false;

    /**
     * The name of the trigger that triggers that action.
     * @return (String)handleGetTriggerName()
     */
    public final String getTriggerName()
    {
        String atriggerName49a = this.triggerName49a;
        if (!this.triggerName49aSet)
        {
            // triggerName has no pre constraints
            atriggerName49a = handleGetTriggerName();
            // triggerName has no post constraints
            this.triggerName49a = atriggerName49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.triggerName49aSet = true;
            }
        }
        return atriggerName49a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getViewFragmentPath()
    * @return String
    */
    protected abstract String handleGetViewFragmentPath();

    private String viewFragmentPath50a;
    private boolean viewFragmentPath50aSet = false;

    /**
     * The path to the view fragment corresponding to this action
     * @return (String)handleGetViewFragmentPath()
     */
    public final String getViewFragmentPath()
    {
        String aviewFragmentPath50a = this.viewFragmentPath50a;
        if (!this.viewFragmentPath50aSet)
        {
            // viewFragmentPath has no pre constraints
            aviewFragmentPath50a = handleGetViewFragmentPath();
            // viewFragmentPath has no post constraints
            this.viewFragmentPath50a = aviewFragmentPath50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewFragmentPath50aSet = true;
            }
        }
        return aviewFragmentPath50a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedActionClassPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassPath();

    private String fullyQualifiedActionClassPath51a;
    private boolean fullyQualifiedActionClassPath51aSet = false;

    /**
     * The fully qualified path to the action class that execute this action.
     * @return (String)handleGetFullyQualifiedActionClassPath()
     */
    public final String getFullyQualifiedActionClassPath()
    {
        String afullyQualifiedActionClassPath51a = this.fullyQualifiedActionClassPath51a;
        if (!this.fullyQualifiedActionClassPath51aSet)
        {
            // fullyQualifiedActionClassPath has no pre constraints
            afullyQualifiedActionClassPath51a = handleGetFullyQualifiedActionClassPath();
            // fullyQualifiedActionClassPath has no post constraints
            this.fullyQualifiedActionClassPath51a = afullyQualifiedActionClassPath51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedActionClassPath51aSet = true;
            }
        }
        return afullyQualifiedActionClassPath51a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getControllerAction()
    * @return String
    */
    protected abstract String handleGetControllerAction();

    private String controllerAction52a;
    private boolean controllerAction52aSet = false;

    /**
     * The name of the action on the controller that executions this action.
     * @return (String)handleGetControllerAction()
     */
    public final String getControllerAction()
    {
        String acontrollerAction52a = this.controllerAction52a;
        if (!this.controllerAction52aSet)
        {
            // controllerAction has no pre constraints
            acontrollerAction52a = handleGetControllerAction();
            // controllerAction has no post constraints
            this.controllerAction52a = acontrollerAction52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.controllerAction52aSet = true;
            }
        }
        return acontrollerAction52a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFullyQualifiedActionClassName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassName();

    private String fullyQualifiedActionClassName53a;
    private boolean fullyQualifiedActionClassName53aSet = false;

    /**
     * The fully qualified name of the action class that execute this action.
     * @return (String)handleGetFullyQualifiedActionClassName()
     */
    public final String getFullyQualifiedActionClassName()
    {
        String afullyQualifiedActionClassName53a = this.fullyQualifiedActionClassName53a;
        if (!this.fullyQualifiedActionClassName53aSet)
        {
            // fullyQualifiedActionClassName has no pre constraints
            afullyQualifiedActionClassName53a = handleGetFullyQualifiedActionClassName();
            // fullyQualifiedActionClassName has no post constraints
            this.fullyQualifiedActionClassName53a = afullyQualifiedActionClassName53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedActionClassName53aSet = true;
            }
        }
        return afullyQualifiedActionClassName53a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormKey()
    * @return String
    */
    protected abstract String handleGetFormKey();

    private String formKey54a;
    private boolean formKey54aSet = false;

    /**
     * The key that stores the form in which information is passed from one action to another.
     * @return (String)handleGetFormKey()
     */
    public final String getFormKey()
    {
        String aformKey54a = this.formKey54a;
        if (!this.formKey54aSet)
        {
            // formKey has no pre constraints
            aformKey54a = handleGetFormKey();
            // formKey has no post constraints
            this.formKey54a = aformKey54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formKey54aSet = true;
            }
        }
        return aformKey54a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isPopup()
    * @return boolean
    */
    protected abstract boolean handleIsPopup();

    private boolean popup55a;
    private boolean popup55aSet = false;

    /**
     * Indicates if this action forwards to a popup (this is determed when the targetted view is a
     * popup).
     * @return (boolean)handleIsPopup()
     */
    public final boolean isPopup()
    {
        boolean apopup55a = this.popup55a;
        if (!this.popup55aSet)
        {
            // popup has no pre constraints
            apopup55a = handleIsPopup();
            // popup has no post constraints
            this.popup55a = apopup55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.popup55aSet = true;
            }
        }
        return apopup55a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormResetRequired()
    * @return boolean
    */
    protected abstract boolean handleIsFormResetRequired();

    private boolean formResetRequired56a;
    private boolean formResetRequired56aSet = false;

    /**
     * Indicates if at least one parameter on the form requires being reset.
     * @return (boolean)handleIsFormResetRequired()
     */
    public final boolean isFormResetRequired()
    {
        boolean aformResetRequired56a = this.formResetRequired56a;
        if (!this.formResetRequired56aSet)
        {
            // formResetRequired has no pre constraints
            aformResetRequired56a = handleIsFormResetRequired();
            // formResetRequired has no post constraints
            this.formResetRequired56a = aformResetRequired56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formResetRequired56aSet = true;
            }
        }
        return aformResetRequired56a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFormReset()
    * @return boolean
    */
    protected abstract boolean handleIsFormReset();

    private boolean formReset57a;
    private boolean formReset57aSet = false;

    /**
     * Whether or not the entire form should be reset (all action parameters on the form).
     * @return (boolean)handleIsFormReset()
     */
    public final boolean isFormReset()
    {
        boolean aformReset57a = this.formReset57a;
        if (!this.formReset57aSet)
        {
            // formReset has no pre constraints
            aformReset57a = handleIsFormReset();
            // formReset has no post constraints
            this.formReset57a = aformReset57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formReset57aSet = true;
            }
        }
        return aformReset57a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormImplementationGetter()
    * @return String
    */
    protected abstract String handleGetFormImplementationGetter();

    private String formImplementationGetter58a;
    private boolean formImplementationGetter58aSet = false;

    /**
     * The signature of the accessor method that returns the form implementation instance.
     * @return (String)handleGetFormImplementationGetter()
     */
    public final String getFormImplementationGetter()
    {
        String aformImplementationGetter58a = this.formImplementationGetter58a;
        if (!this.formImplementationGetter58aSet)
        {
            // formImplementationGetter has no pre constraints
            aformImplementationGetter58a = handleGetFormImplementationGetter();
            // formImplementationGetter has no post constraints
            this.formImplementationGetter58a = aformImplementationGetter58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formImplementationGetter58aSet = true;
            }
        }
        return aformImplementationGetter58a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFormSerialVersionUID()
    * @return String
    */
    protected abstract String handleGetFormSerialVersionUID();

    private String formSerialVersionUID59a;
    private boolean formSerialVersionUID59aSet = false;

    /**
     * The calcuated serial version UID for this action's form.
     * @return (String)handleGetFormSerialVersionUID()
     */
    public final String getFormSerialVersionUID()
    {
        String aformSerialVersionUID59a = this.formSerialVersionUID59a;
        if (!this.formSerialVersionUID59aSet)
        {
            // formSerialVersionUID has no pre constraints
            aformSerialVersionUID59a = handleGetFormSerialVersionUID();
            // formSerialVersionUID has no post constraints
            this.formSerialVersionUID59a = aformSerialVersionUID59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formSerialVersionUID59aSet = true;
            }
        }
        return aformSerialVersionUID59a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isFinalStateTarget()
    * @return boolean
    */
    protected abstract boolean handleIsFinalStateTarget();

    private boolean finalStateTarget60a;
    private boolean finalStateTarget60aSet = false;

    /**
     * Indicates whether or not a final state is the target of this action.
     * @return (boolean)handleIsFinalStateTarget()
     */
    public final boolean isFinalStateTarget()
    {
        boolean afinalStateTarget60a = this.finalStateTarget60a;
        if (!this.finalStateTarget60aSet)
        {
            // finalStateTarget has no pre constraints
            afinalStateTarget60a = handleIsFinalStateTarget();
            // finalStateTarget has no post constraints
            this.finalStateTarget60a = afinalStateTarget60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.finalStateTarget60aSet = true;
            }
        }
        return afinalStateTarget60a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getFromOutcome()
    * @return String
    */
    protected abstract String handleGetFromOutcome();

    private String fromOutcome61a;
    private boolean fromOutcome61aSet = false;

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @return (String)handleGetFromOutcome()
     */
    public final String getFromOutcome()
    {
        String afromOutcome61a = this.fromOutcome61a;
        if (!this.fromOutcome61aSet)
        {
            // fromOutcome has no pre constraints
            afromOutcome61a = handleGetFromOutcome();
            // fromOutcome has no post constraints
            this.fromOutcome61a = afromOutcome61a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fromOutcome61aSet = true;
            }
        }
        return afromOutcome61a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isWarningMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsWarningMessagesPresent();

    private boolean warningMessagesPresent62a;
    private boolean warningMessagesPresent62aSet = false;

    /**
     * Whether or not any warning messages are present.
     * @return (boolean)handleIsWarningMessagesPresent()
     */
    public final boolean isWarningMessagesPresent()
    {
        boolean awarningMessagesPresent62a = this.warningMessagesPresent62a;
        if (!this.warningMessagesPresent62aSet)
        {
            // warningMessagesPresent has no pre constraints
            awarningMessagesPresent62a = handleIsWarningMessagesPresent();
            // warningMessagesPresent has no post constraints
            this.warningMessagesPresent62a = awarningMessagesPresent62a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.warningMessagesPresent62aSet = true;
            }
        }
        return awarningMessagesPresent62a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getWarningMessages()
    * @return Map
    */
    protected abstract Map handleGetWarningMessages();

    private Map warningMessages63a;
    private boolean warningMessages63aSet = false;

    /**
     * Any messages used to indicate a warning.
     * @return (Map)handleGetWarningMessages()
     */
    public final Map getWarningMessages()
    {
        Map awarningMessages63a = this.warningMessages63a;
        if (!this.warningMessages63aSet)
        {
            // warningMessages has no pre constraints
            awarningMessages63a = handleGetWarningMessages();
            // warningMessages has no post constraints
            this.warningMessages63a = awarningMessages63a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.warningMessages63aSet = true;
            }
        }
        return awarningMessages63a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isSuccessMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsSuccessMessagesPresent();

    private boolean successMessagesPresent64a;
    private boolean successMessagesPresent64aSet = false;

    /**
     * Indicates whether or not any success messags are present.
     * @return (boolean)handleIsSuccessMessagesPresent()
     */
    public final boolean isSuccessMessagesPresent()
    {
        boolean asuccessMessagesPresent64a = this.successMessagesPresent64a;
        if (!this.successMessagesPresent64aSet)
        {
            // successMessagesPresent has no pre constraints
            asuccessMessagesPresent64a = handleIsSuccessMessagesPresent();
            // successMessagesPresent has no post constraints
            this.successMessagesPresent64a = asuccessMessagesPresent64a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.successMessagesPresent64aSet = true;
            }
        }
        return asuccessMessagesPresent64a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getSuccessMessages()
    * @return Map
    */
    protected abstract Map handleGetSuccessMessages();

    private Map successMessages65a;
    private boolean successMessages65aSet = false;

    /**
     * Messages used to indicate successful execution.
     * @return (Map)handleGetSuccessMessages()
     */
    public final Map getSuccessMessages()
    {
        Map asuccessMessages65a = this.successMessages65a;
        if (!this.successMessages65aSet)
        {
            // successMessages has no pre constraints
            asuccessMessages65a = handleGetSuccessMessages();
            // successMessages has no post constraints
            this.successMessages65a = asuccessMessages65a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.successMessages65aSet = true;
            }
        }
        return asuccessMessages65a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isErrorMessagesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsErrorMessagesPresent();

    private boolean errorMessagesPresent66a;
    private boolean errorMessagesPresent66aSet = false;

    /**
     * 
     * @return (boolean)handleIsErrorMessagesPresent()
     */
    public final boolean isErrorMessagesPresent()
    {
        boolean aerrorMessagesPresent66a = this.errorMessagesPresent66a;
        if (!this.errorMessagesPresent66aSet)
        {
            // errorMessagesPresent has no pre constraints
            aerrorMessagesPresent66a = handleIsErrorMessagesPresent();
            // errorMessagesPresent has no post constraints
            this.errorMessagesPresent66a = aerrorMessagesPresent66a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.errorMessagesPresent66aSet = true;
            }
        }
        return aerrorMessagesPresent66a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getErrorMessages()
    * @return Map
    */
    protected abstract Map handleGetErrorMessages();

    private Map errorMessages67a;
    private boolean errorMessages67aSet = false;

    /**
     * 
     * @return (Map)handleGetErrorMessages()
     */
    public final Map getErrorMessages()
    {
        Map aerrorMessages67a = this.errorMessages67a;
        if (!this.errorMessages67aSet)
        {
            // errorMessages has no pre constraints
            aerrorMessages67a = handleGetErrorMessages();
            // errorMessages has no post constraints
            this.errorMessages67a = aerrorMessages67a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.errorMessages67aSet = true;
            }
        }
        return aerrorMessages67a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#isNeedsFileUpload()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsFileUpload();

    private boolean needsFileUpload68a;
    private boolean needsFileUpload68aSet = false;

    /**
     * 
     * @return (boolean)handleIsNeedsFileUpload()
     */
    public final boolean isNeedsFileUpload()
    {
        boolean aneedsFileUpload68a = this.needsFileUpload68a;
        if (!this.needsFileUpload68aSet)
        {
            // needsFileUpload has no pre constraints
            aneedsFileUpload68a = handleIsNeedsFileUpload();
            // needsFileUpload has no post constraints
            this.needsFileUpload68a = aneedsFileUpload68a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.needsFileUpload68aSet = true;
            }
        }
        return aneedsFileUpload68a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getTriggerMethodName()
    * @return String
    */
    protected abstract String handleGetTriggerMethodName();

    private String triggerMethodName69a;
    private boolean triggerMethodName69aSet = false;

    /**
     * The name of the method to be executed when this action is triggered.
     * @return (String)handleGetTriggerMethodName()
     */
    public final String getTriggerMethodName()
    {
        String atriggerMethodName69a = this.triggerMethodName69a;
        if (!this.triggerMethodName69aSet)
        {
            // triggerMethodName has no pre constraints
            atriggerMethodName69a = handleGetTriggerMethodName();
            // triggerMethodName has no post constraints
            this.triggerMethodName69a = atriggerMethodName69a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.triggerMethodName69aSet = true;
            }
        }
        return atriggerMethodName69a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiAction#getHiddenParameters()
    * @return List<GuiParameter>
    */
    protected abstract List<GuiParameter> handleGetHiddenParameters();

    private List<GuiParameter> hiddenParameters70a;
    private boolean hiddenParameters70aSet = false;

    /**
     * All parameters that are of hidden input type.
     * @return (List<GuiParameter>)handleGetHiddenParameters()
     */
    public final List<GuiParameter> getHiddenParameters()
    {
        List<GuiParameter> ahiddenParameters70a = this.hiddenParameters70a;
        if (!this.hiddenParameters70aSet)
        {
            // hiddenParameters has no pre constraints
            ahiddenParameters70a = handleGetHiddenParameters();
            // hiddenParameters has no post constraints
            this.hiddenParameters70a = ahiddenParameters70a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hiddenParameters70aSet = true;
            }
        }
        return ahiddenParameters70a;
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

    private List<GuiView> getTargetPages1r;
    private boolean getTargetPages1rSet = false;

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
                getTargetPages1r = (List<GuiView>)shieldedResult;
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

    private List<GuiParameter> getActionParametersToDeletes2r;
    private boolean getActionParametersToDeletes2rSet = false;

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
                getActionParametersToDeletes2r = (List<GuiParameter>)shieldedResult;
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

    private List<GuiParameter> getActionFormFieldsToDeletes3r;
    private boolean getActionFormFieldsToDeletes3rSet = false;

    /**
     * 
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
                getActionFormFieldsToDeletes3r = (List<GuiParameter>)shieldedResult;
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

    private List<GuiParameter> getResettableActionParameters4r;
    private boolean getResettableActionParameters4rSet = false;

    /**
     * 
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
                getResettableActionParameters4r = (List<GuiParameter>)shieldedResult;
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

    private List<GuiExceptionHandler> getActionExceptionsToDeletes5r;
    private boolean getActionExceptionsToDeletes5rSet = false;

    /**
     * 
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
                getActionExceptionsToDeletes5r = (List<GuiExceptionHandler>)shieldedResult;
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

    private GuiParameter getTableLinkParameter8r;
    private boolean getTableLinkParameter8rSet = false;

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
                getTableLinkParameter8r = (GuiParameter)shieldedResult;
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

    private GuiTrigger getActionTriggerToDelete9r;
    private boolean getActionTriggerToDelete9rSet = false;

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
                getActionTriggerToDelete9r = (GuiTrigger)shieldedResult;
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