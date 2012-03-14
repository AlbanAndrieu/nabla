// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.andromda.cartridges.jsf.metafacades.JSFAction;
import org.andromda.cartridges.jsf.metafacades.JSFParameter;
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

/**
 * 
 * MetafacadeLogic for SeamAction
 *
 * @see SeamAction
 */
public abstract class SeamActionLogic
    extends MetafacadeBase
    implements SeamAction
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
    protected SeamActionLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superJSFAction =
           (JSFAction)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.cartridges.jsf.metafacades.JSFAction",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to SeamAction if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.seam.metafacades.SeamAction";
        }
        return context;
    }

    private JSFAction superJSFAction;
    private boolean superJSFActionInitialized = false;

    /**
     * Gets the JSFAction parent instance.
     * @return this.superJSFAction JSFAction
     */
    private JSFAction getSuperJSFAction()
    {
        if (!this.superJSFActionInitialized)
        {
            ((MetafacadeBase)this.superJSFAction).setMetafacadeContext(this.getMetafacadeContext());
            this.superJSFActionInitialized = true;
        }
        return this.superJSFAction;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see org.andromda.core.metafacade.MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superJSFActionInitialized)
            {
                ((MetafacadeBase)this.superJSFAction).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see SeamAction
     */
    public boolean isSeamActionMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see JSFAction
     */
    public boolean isJSFActionMetaType()
    {
        return true;
    }

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

    // ----------- delegates to JSFAction ------------
    /**
     * The name of the action class that executes this action.
     * @see JSFAction#getActionClassName()
     */
    public String getActionClassName()
    {
        return this.getSuperJSFAction().getActionClassName();
    }

    /**
     * The name of the action on the controller that executions this action.
     * @see JSFAction#getControllerAction()
     */
    public String getControllerAction()
    {
        return this.getSuperJSFAction().getControllerAction();
    }

    /**
     * A resource message key suited for the action''s documentation.
     * @see JSFAction#getDocumentationKey()
     */
    public String getDocumentationKey()
    {
        return this.getSuperJSFAction().getDocumentationKey();
    }

    /**
     * The resource messsage value suited for the action''s documentation.
     * @see JSFAction#getDocumentationValue()
     */
    public String getDocumentationValue()
    {
        return this.getSuperJSFAction().getDocumentationValue();
    }

    /**
     * The name of the bean under which the form is stored.
     * @see JSFAction#getFormBeanName()
     */
    public String getFormBeanName()
    {
        return this.getSuperJSFAction().getFormBeanName();
    }

    /**
     * The signature of the accessor method that returns the form implementation instance.
     * @see JSFAction#getFormImplementationGetter()
     */
    public String getFormImplementationGetter()
    {
        return this.getSuperJSFAction().getFormImplementationGetter();
    }

    /**
     * A comma seperated list of all the form interfaces which the form implementation implements.
     * @see JSFAction#getFormImplementationInterfaceList()
     */
    public String getFormImplementationInterfaceList()
    {
        return this.getSuperJSFAction().getFormImplementationInterfaceList();
    }

    /**
     * The name of the form implementation.
     * @see JSFAction#getFormImplementationName()
     */
    public String getFormImplementationName()
    {
        return this.getSuperJSFAction().getFormImplementationName();
    }

    /**
     * The key that stores the form in which information is passed from one action to another.
     * @see JSFAction#getFormKey()
     */
    public String getFormKey()
    {
        return this.getSuperJSFAction().getFormKey();
    }

    /**
     * The scope of the JSF form (request, session,application,etc).
     * @see JSFAction#getFormScope()
     */
    public String getFormScope()
    {
        return this.getSuperJSFAction().getFormScope();
    }

    /**
     * The calcuated serial version UID for this action's form.
     * @see JSFAction#getFormSerialVersionUID()
     */
    public String getFormSerialVersionUID()
    {
        return this.getSuperJSFAction().getFormSerialVersionUID();
    }

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @see JSFAction#getFromOutcome()
     */
    public String getFromOutcome()
    {
        return this.getSuperJSFAction().getFromOutcome();
    }

    /**
     * The fully qualified name of the action class that execute this action.
     * @see JSFAction#getFullyQualifiedActionClassName()
     */
    public String getFullyQualifiedActionClassName()
    {
        return this.getSuperJSFAction().getFullyQualifiedActionClassName();
    }

    /**
     * The fully qualified path to the action class that execute this action.
     * @see JSFAction#getFullyQualifiedActionClassPath()
     */
    public String getFullyQualifiedActionClassPath()
    {
        return this.getSuperJSFAction().getFullyQualifiedActionClassPath();
    }

    /**
     * The fully qualified name of the form implementation.
     * @see JSFAction#getFullyQualifiedFormImplementationName()
     */
    public String getFullyQualifiedFormImplementationName()
    {
        return this.getSuperJSFAction().getFullyQualifiedFormImplementationName();
    }

    /**
     * The fully qualified path of the form implementation.
     * @see JSFAction#getFullyQualifiedFormImplementationPath()
     */
    public String getFullyQualifiedFormImplementationPath()
    {
        return this.getSuperJSFAction().getFullyQualifiedFormImplementationPath();
    }

    /**
     * All parameters that are of hidden input type.
     * @see JSFAction#getHiddenParameters()
     */
    public List<JSFParameter> getHiddenParameters()
    {
        return this.getSuperJSFAction().getHiddenParameters();
    }

    /**
     * The default resource message key for this action.
     * @see JSFAction#getMessageKey()
     */
    public String getMessageKey()
    {
        return this.getSuperJSFAction().getMessageKey();
    }

    /**
     * The path to this action.
     * @see JSFAction#getPath()
     */
    public String getPath()
    {
        return this.getSuperJSFAction().getPath();
    }

    /**
     * The path's root.
     * @see JSFAction#getPathRoot()
     */
    public String getPathRoot()
    {
        return this.getSuperJSFAction().getPathRoot();
    }

    /**
     * Messages used to indicate successful execution.
     * @see JSFAction#getSuccessMessages()
     */
    public Map getSuccessMessages()
    {
        return this.getSuperJSFAction().getSuccessMessages();
    }

    /**
     * The name of the column targetted by this action.
     * @see JSFAction#getTableLinkColumnName()
     */
    public String getTableLinkColumnName()
    {
        return this.getSuperJSFAction().getTableLinkColumnName();
    }

    /**
     * The name of the table link specified for this action.
     * @see JSFAction#getTableLinkName()
     */
    public String getTableLinkName()
    {
        return this.getSuperJSFAction().getTableLinkName();
    }

    /**
     * If the action is a table link then this property represents the table to which is being
     * linked.
     * @see JSFAction#getTableLinkParameter()
     */
    public JSFParameter getTableLinkParameter()
    {
        return this.getSuperJSFAction().getTableLinkParameter();
    }

    /**
     * The name of the trigger that triggers that action.
     * @see JSFAction#getTriggerName()
     */
    public String getTriggerName()
    {
        return this.getSuperJSFAction().getTriggerName();
    }

    /**
     * The path to the view fragment corresponding to this action
     * @see JSFAction#getViewFragmentPath()
     */
    public String getViewFragmentPath()
    {
        return this.getSuperJSFAction().getViewFragmentPath();
    }

    /**
     * Any messages used to indicate a warning.
     * @see JSFAction#getWarningMessages()
     */
    public Map getWarningMessages()
    {
        return this.getSuperJSFAction().getWarningMessages();
    }

    /**
     * Indicates whether or not a final state is the target of this action.
     * @see JSFAction#isFinalStateTarget()
     */
    public boolean isFinalStateTarget()
    {
        return this.getSuperJSFAction().isFinalStateTarget();
    }

    /**
     * Whether or not the entire form should be reset (all action parameters on the form).
     * @see JSFAction#isFormReset()
     */
    public boolean isFormReset()
    {
        return this.getSuperJSFAction().isFormReset();
    }

    /**
     * Indicates if at least one parameter on the form requires being reset.
     * @see JSFAction#isFormResetRequired()
     */
    public boolean isFormResetRequired()
    {
        return this.getSuperJSFAction().isFormResetRequired();
    }

    /**
     * Indicates whether or not this action is represented by clicking on a hyperlink.
     * @see JSFAction#isHyperlink()
     */
    public boolean isHyperlink()
    {
        return this.getSuperJSFAction().isHyperlink();
    }

    /**
     * 
     * @see JSFAction#isNeedsFileUpload()
     */
    public boolean isNeedsFileUpload()
    {
        return this.getSuperJSFAction().isNeedsFileUpload();
    }

    /**
     * Indicates if this action forwards to a popup (this is determed when the targetted view is a
     * popup).
     * @see JSFAction#isPopup()
     */
    public boolean isPopup()
    {
        return this.getSuperJSFAction().isPopup();
    }

    /**
     * Indicates whether or not the values passed along with this action can be reset or not.
     * @see JSFAction#isResettable()
     */
    public boolean isResettable()
    {
        return this.getSuperJSFAction().isResettable();
    }

    /**
     * Indicates whether or not any success messags are present.
     * @see JSFAction#isSuccessMessagesPresent()
     */
    public boolean isSuccessMessagesPresent()
    {
        return this.getSuperJSFAction().isSuccessMessagesPresent();
    }

    /**
     * Indicates that this action works on all rows of the table from the table link relation.
     * @see JSFAction#isTableAction()
     */
    public boolean isTableAction()
    {
        return this.getSuperJSFAction().isTableAction();
    }

    /**
     * Indicates if a table link name has been specified and it properly targets a table
     * page-variable from the input page.
     * @see JSFAction#isTableLink()
     */
    public boolean isTableLink()
    {
        return this.getSuperJSFAction().isTableLink();
    }

    /**
     * Indicates whether or not at least one parameter on this action requires validation.
     * @see JSFAction#isValidationRequired()
     */
    public boolean isValidationRequired()
    {
        return this.getSuperJSFAction().isValidationRequired();
    }

    /**
     * Whether or not any warning messages are present.
     * @see JSFAction#isWarningMessagesPresent()
     */
    public boolean isWarningMessagesPresent()
    {
        return this.getSuperJSFAction().isWarningMessagesPresent();
    }

    /**
     * Finds the parameter on this action having the given name, if no parameter is found, null is
     * returned instead.
     * @see FrontEndAction#findParameter(String name)
     */
    public ParameterFacade findParameter(String name)
    {
        return this.getSuperJSFAction().findParameter(name);
    }

    /**
     * All action forwards for this foward. Each action forward either calls a view or another
     * use-case (which is essentially an action).
     * @see FrontEndAction#getActionForwards()
     */
    public List<FrontEndForward> getActionForwards()
    {
        return this.getSuperJSFAction().getActionForwards();
    }

    /**
     * All action states visited by this action.
     * @see FrontEndAction#getActionStates()
     */
    public List<FrontEndActionState> getActionStates()
    {
        return this.getSuperJSFAction().getActionStates();
    }

    /**
     * The controller that will handle the execution of this front-end action. This controller is
     * set as the context of the activity graph (and therefore also of the use-case).
     * @see FrontEndAction#getController()
     */
    public FrontEndController getController()
    {
        return this.getSuperJSFAction().getController();
    }

    /**
     * All the transitions coming out of decision points. These transitions should all carry guards.
     * @see FrontEndAction#getDecisionTransitions()
     */
    public List<FrontEndForward> getDecisionTransitions()
    {
        return this.getSuperJSFAction().getDecisionTransitions();
    }

    /**
     * The controller operations to which this action defers, the order is preserved.
     * @see FrontEndAction#getDeferredOperations()
     */
    public List<FrontEndControllerOperation> getDeferredOperations()
    {
        return this.getSuperJSFAction().getDeferredOperations();
    }

    /**
     * Form fields for this action. Form fields are those parameters that can be altered by the user
     * on a corresponding view at runtime.
     * @see FrontEndAction#getFormFields()
     */
    public List<FrontEndParameter> getFormFields()
    {
        return this.getSuperJSFAction().getFormFields();
    }

    /**
     * The StateVertex (FrontEndView or PseudostateFacade) on which this action can be triggered.
     * @see FrontEndAction#getInput()
     */
    public StateVertexFacade getInput()
    {
        return this.getSuperJSFAction().getInput();
    }

    /**
     * All parameters sent by this "front-end" action.
     * @see FrontEndAction#getParameters()
     */
    public List<FrontEndParameter> getParameters()
    {
        return this.getSuperJSFAction().getParameters();
    }

    /**
     * All views that can be possibly targetted by triggering this action.
     * @see FrontEndAction#getTargetViews()
     */
    public List<FrontEndView> getTargetViews()
    {
        return this.getSuperJSFAction().getTargetViews();
    }

    /**
     * All the transitions that make up this action, this directly maps onto the forwards.
     * @see FrontEndAction#getTransitions()
     */
    public List<FrontEndForward> getTransitions()
    {
        return this.getSuperJSFAction().getTransitions();
    }

    /**
     * Indicates if this action represents the beginning of the front-end use case or not.
     * @see FrontEndAction#isUseCaseStart()
     */
    public boolean isUseCaseStart()
    {
        return this.getSuperJSFAction().isUseCaseStart();
    }

    /**
     * The method name used to delegate to this forward.
     * @see FrontEndForward#getActionMethodName()
     */
    public String getActionMethodName()
    {
        return this.getSuperJSFAction().getActionMethodName();
    }

    /**
     * The front-end actions directly containing this front-end forward.
     * @see FrontEndForward#getActions()
     */
    public List<FrontEndAction> getActions()
    {
        return this.getSuperJSFAction().getActions();
    }

    /**
     * The trigger for this front-end forward.
     * @see FrontEndForward#getDecisionTrigger()
     */
    public FrontEndEvent getDecisionTrigger()
    {
        return this.getSuperJSFAction().getDecisionTrigger();
    }

    /**
     * Tthe set of parameter used during transport in this forward.
     * @see FrontEndForward#getForwardParameters()
     */
    public List<FrontEndParameter> getForwardParameters()
    {
        return this.getSuperJSFAction().getForwardParameters();
    }

    /**
     * The activity graph which holds this forward if the graph is contained in a FrontEndUseCase.
     * @see FrontEndForward#getFrontEndActivityGraph()
     */
    public FrontEndActivityGraph getFrontEndActivityGraph()
    {
        return this.getSuperJSFAction().getFrontEndActivityGraph();
    }

    /**
     * The operation to which is called during execution of this front-end forward.
     * @see FrontEndForward#getOperationCall()
     */
    public FrontEndControllerOperation getOperationCall()
    {
        return this.getSuperJSFAction().getOperationCall();
    }

    /**
     * The use case in which this forward is contained.
     * @see FrontEndForward#getUseCase()
     */
    public FrontEndUseCase getUseCase()
    {
        return this.getSuperJSFAction().getUseCase();
    }

    /**
     * Indicates if this forward is contained in a FrontEndUseCase.
     * @see FrontEndForward#isContainedInFrontEndUseCase()
     */
    public boolean isContainedInFrontEndUseCase()
    {
        return this.getSuperJSFAction().isContainedInFrontEndUseCase();
    }

    /**
     * Indicates if this action directly targets a "front-end" view, false otherwise.
     * @see FrontEndForward#isEnteringView()
     */
    public boolean isEnteringView()
    {
        return this.getSuperJSFAction().isEnteringView();
    }

    /**
     * Indicates if this forward (transition) is coming out of a front-end view.
     * @see FrontEndForward#isExitingView()
     */
    public boolean isExitingView()
    {
        return this.getSuperJSFAction().isExitingView();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperJSFAction().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperJSFAction().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperJSFAction().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperJSFAction().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperJSFAction().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperJSFAction().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperJSFAction().getDocumentation(indent);
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
        return this.getSuperJSFAction().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperJSFAction().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperJSFAction().getFullyQualifiedName();
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
        return this.getSuperJSFAction().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperJSFAction().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperJSFAction().getId();
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
        return this.getSuperJSFAction().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperJSFAction().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperJSFAction().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperJSFAction().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperJSFAction().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperJSFAction().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperJSFAction().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperJSFAction().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperJSFAction().getPackagePath();
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
        return this.getSuperJSFAction().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperJSFAction().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperJSFAction().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperJSFAction().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperJSFAction().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperJSFAction().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperJSFAction().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperJSFAction().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperJSFAction().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperJSFAction().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperJSFAction().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperJSFAction().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperJSFAction().hasKeyword(keywordName);
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
        return this.getSuperJSFAction().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperJSFAction().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperJSFAction().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperJSFAction().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperJSFAction().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperJSFAction().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperJSFAction().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperJSFAction().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperJSFAction().translateConstraints(kind, translation);
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#getEffect()
     */
    public ActionFacade getEffect()
    {
        return this.getSuperJSFAction().getEffect();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#getGuard()
     */
    public GuardFacade getGuard()
    {
        return this.getSuperJSFAction().getGuard();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#getSource()
     */
    public StateVertexFacade getSource()
    {
        return this.getSuperJSFAction().getSource();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#getTarget()
     */
    public StateVertexFacade getTarget()
    {
        return this.getSuperJSFAction().getTarget();
    }

    /**
     * If a trigger is present on this transition, this event represents that trigger.
     * @see org.andromda.metafacades.uml.TransitionFacade#getTrigger()
     */
    public EventFacade getTrigger()
    {
        return this.getSuperJSFAction().getTrigger();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringActionState()
     */
    public boolean isEnteringActionState()
    {
        return this.getSuperJSFAction().isEnteringActionState();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringDecisionPoint()
     */
    public boolean isEnteringDecisionPoint()
    {
        return this.getSuperJSFAction().isEnteringDecisionPoint();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isEnteringFinalState()
     */
    public boolean isEnteringFinalState()
    {
        return this.getSuperJSFAction().isEnteringFinalState();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingActionState()
     */
    public boolean isExitingActionState()
    {
        return this.getSuperJSFAction().isExitingActionState();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingDecisionPoint()
     */
    public boolean isExitingDecisionPoint()
    {
        return this.getSuperJSFAction().isExitingDecisionPoint();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isExitingInitialState()
     */
    public boolean isExitingInitialState()
    {
        return this.getSuperJSFAction().isExitingInitialState();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.TransitionFacade#isTriggerPresent()
     */
    public boolean isTriggerPresent()
    {
        return this.getSuperJSFAction().isTriggerPresent();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperJSFAction().initialize();
    }

    /**
     * @return Object getSuperJSFAction().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperJSFAction().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperJSFAction().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperJSFAction().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperJSFAction().validateInvariants(validationMessages);
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