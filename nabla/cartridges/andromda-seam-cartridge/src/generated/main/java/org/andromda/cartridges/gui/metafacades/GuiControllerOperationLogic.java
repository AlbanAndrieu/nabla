// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndActivityGraph;
import org.andromda.metafacades.uml.FrontEndControllerOperation;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.ServiceOperation;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.andromda.translation.ocl.validation.OCLCollections;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.log4j.Logger;

/**
 * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiControllerOperation
 * MetafacadeLogic for GuiControllerOperation
 *
 * @see GuiControllerOperation
 */
public abstract class GuiControllerOperationLogic
    extends MetafacadeBase
    implements GuiControllerOperation
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
    protected GuiControllerOperationLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superFrontEndControllerOperation =
           (FrontEndControllerOperation)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.FrontEndControllerOperation",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiControllerOperationLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiControllerOperation if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiControllerOperation";
        }
        return context;
    }

    private FrontEndControllerOperation superFrontEndControllerOperation;
    private boolean superFrontEndControllerOperationInitialized = false;

    /**
     * Gets the FrontEndControllerOperation parent instance.
     * @return this.superFrontEndControllerOperation FrontEndControllerOperation
     */
    private FrontEndControllerOperation getSuperFrontEndControllerOperation()
    {
        if (!this.superFrontEndControllerOperationInitialized)
        {
            ((MetafacadeBase)this.superFrontEndControllerOperation).setMetafacadeContext(this.getMetafacadeContext());
            this.superFrontEndControllerOperationInitialized = true;
        }
        return this.superFrontEndControllerOperation;
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
            if (this.superFrontEndControllerOperationInitialized)
            {
                ((MetafacadeBase)this.superFrontEndControllerOperation).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see GuiControllerOperation
     */
    public boolean isGuiControllerOperationMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getInterfaceName()
    * @return String
    */
    protected abstract String handleGetInterfaceName();

    private transient String interfaceName1a;
    private transient boolean interfaceName1aSet = false;

    /**
     * The name of the interface used for forms that correspond to the calling of this operation (we
     * need to pass the form to the controller, but many forms/actions my be deferring to this
     * operation, this way we can aggregate them).
     * @return (String)handleGetInterfaceName()
     */
    public final String getInterfaceName()
    {
        String interfaceName1a = this.interfaceName1a;
        if (!this.interfaceName1aSet)
        {
            // interfaceName has no pre constraints
            interfaceName1a = handleGetInterfaceName();
            // interfaceName has no post constraints
            this.interfaceName1a = interfaceName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.interfaceName1aSet = true;
            }
        }
        return interfaceName1a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getInterfacePackageName()
    * @return String
    */
    protected abstract String handleGetInterfacePackageName();

    private transient String interfacePackageName2a;
    private transient boolean interfacePackageName2aSet = false;

    /**
     * The package of the interface used for forms that correspond to the calling of this operation
     * (we need to pass the form to the controller, but many forms/actions my be deferring to this
     * operation, this way we can aggregate them).
     * @return (String)handleGetInterfacePackageName()
     */
    public final String getInterfacePackageName()
    {
        String interfacePackageName2a = this.interfacePackageName2a;
        if (!this.interfacePackageName2aSet)
        {
            // interfacePackageName has no pre constraints
            interfacePackageName2a = handleGetInterfacePackageName();
            // interfacePackageName has no post constraints
            this.interfacePackageName2a = interfacePackageName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.interfacePackageName2aSet = true;
            }
        }
        return interfacePackageName2a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getInterfaceFullPath()
    * @return String
    */
    protected abstract String handleGetInterfaceFullPath();

    private transient String interfaceFullPath3a;
    private transient boolean interfaceFullPath3aSet = false;

    /**
     * The package of the interface converted to a file-system compatible format.
     * @return (String)handleGetInterfaceFullPath()
     */
    public final String getInterfaceFullPath()
    {
        String interfaceFullPath3a = this.interfaceFullPath3a;
        if (!this.interfaceFullPath3aSet)
        {
            // interfaceFullPath has no pre constraints
            interfaceFullPath3a = handleGetInterfaceFullPath();
            // interfaceFullPath has no post constraints
            this.interfaceFullPath3a = interfaceFullPath3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.interfaceFullPath3aSet = true;
            }
        }
        return interfaceFullPath3a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getInterfaceType()
    * @return String
    */
    protected abstract String handleGetInterfaceType();

    private transient String interfaceType4a;
    private transient boolean interfaceType4aSet = false;

    /**
     * The fully qualified name of the interface.
     * @return (String)handleGetInterfaceType()
     */
    public final String getInterfaceType()
    {
        String interfaceType4a = this.interfaceType4a;
        if (!this.interfaceType4aSet)
        {
            // interfaceType has no pre constraints
            interfaceType4a = handleGetInterfaceType();
            // interfaceType has no post constraints
            this.interfaceType4a = interfaceType4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.interfaceType4aSet = true;
            }
        }
        return interfaceType4a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#isBackEndServiceOperationMatchingParameters()
    * @return boolean
    */
    protected abstract boolean handleIsBackEndServiceOperationMatchingParameters();

    private transient boolean backEndServiceOperationMatchingParameters5a;
    private transient boolean backEndServiceOperationMatchingParameters5aSet = false;

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiControllerOperation.backEndServiceOperationMatchingParameters
     * @return (boolean)handleIsBackEndServiceOperationMatchingParameters()
     */
    public final boolean isBackEndServiceOperationMatchingParameters()
    {
        boolean backEndServiceOperationMatchingParameters5a = this.backEndServiceOperationMatchingParameters5a;
        if (!this.backEndServiceOperationMatchingParameters5aSet)
        {
            // backEndServiceOperationMatchingParameters has no pre constraints
            backEndServiceOperationMatchingParameters5a = handleIsBackEndServiceOperationMatchingParameters();
            // backEndServiceOperationMatchingParameters has no post constraints
            this.backEndServiceOperationMatchingParameters5a = backEndServiceOperationMatchingParameters5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.backEndServiceOperationMatchingParameters5aSet = true;
            }
        }
        return backEndServiceOperationMatchingParameters5a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#isCallingBackEnd()
    * @return boolean
    */
    protected abstract boolean handleIsCallingBackEnd();

    private transient boolean callingBackEnd6a;
    private transient boolean callingBackEnd6aSet = false;

    /**
     * If this is true then the backEndServiceOperation property is not null, meaning this operation
     * is calling a specific backend operation.
     * @return (boolean)handleIsCallingBackEnd()
     */
    public final boolean isCallingBackEnd()
    {
        boolean callingBackEnd6a = this.callingBackEnd6a;
        if (!this.callingBackEnd6aSet)
        {
            // callingBackEnd has no pre constraints
            callingBackEnd6a = handleIsCallingBackEnd();
            // callingBackEnd has no post constraints
            this.callingBackEnd6a = callingBackEnd6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.callingBackEnd6aSet = true;
            }
        }
        return callingBackEnd6a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFullyQualifiedFormPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedFormPath();

    private transient String fullyQualifiedFormPath7a;
    private transient boolean fullyQualifiedFormPath7aSet = false;

    /**
     * The fully qualified path of the form file.
     * @return (String)handleGetFullyQualifiedFormPath()
     */
    public final String getFullyQualifiedFormPath()
    {
        String fullyQualifiedFormPath7a = this.fullyQualifiedFormPath7a;
        if (!this.fullyQualifiedFormPath7aSet)
        {
            // fullyQualifiedFormPath has no pre constraints
            fullyQualifiedFormPath7a = handleGetFullyQualifiedFormPath();
            // fullyQualifiedFormPath has no post constraints
            this.fullyQualifiedFormPath7a = fullyQualifiedFormPath7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedFormPath7aSet = true;
            }
        }
        return fullyQualifiedFormPath7a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFullyQualifiedFormName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedFormName();

    private transient String fullyQualifiedFormName8a;
    private transient boolean fullyQualifiedFormName8aSet = false;

    /**
     * The fully qualified form name.
     * @return (String)handleGetFullyQualifiedFormName()
     */
    public final String getFullyQualifiedFormName()
    {
        String fullyQualifiedFormName8a = this.fullyQualifiedFormName8a;
        if (!this.fullyQualifiedFormName8aSet)
        {
            // fullyQualifiedFormName has no pre constraints
            fullyQualifiedFormName8a = handleGetFullyQualifiedFormName();
            // fullyQualifiedFormName has no post constraints
            this.fullyQualifiedFormName8a = fullyQualifiedFormName8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedFormName8aSet = true;
            }
        }
        return fullyQualifiedFormName8a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFormName()
    * @return String
    */
    protected abstract String handleGetFormName();

    private transient String formName9a;
    private transient boolean formName9aSet = false;

    /**
     * The form name the corresponds to this controller operation.
     * @return (String)handleGetFormName()
     */
    public final String getFormName()
    {
        String formName9a = this.formName9a;
        if (!this.formName9aSet)
        {
            // formName has no pre constraints
            formName9a = handleGetFormName();
            // formName has no post constraints
            this.formName9a = formName9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formName9aSet = true;
            }
        }
        return formName9a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFormCall()
    * @return String
    */
    protected abstract String handleGetFormCall();

    private transient String formCall10a;
    private transient boolean formCall10aSet = false;

    /**
     * The operation call that takes the appropriate form as an argument.
     * @return (String)handleGetFormCall()
     */
    public final String getFormCall()
    {
        String formCall10a = this.formCall10a;
        if (!this.formCall10aSet)
        {
            // formCall has no pre constraints
            formCall10a = handleGetFormCall();
            // formCall has no post constraints
            this.formCall10a = formCall10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formCall10aSet = true;
            }
        }
        return formCall10a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getFormSignature()
    * @return String
    */
    protected abstract String handleGetFormSignature();

    private transient String formSignature11a;
    private transient boolean formSignature11aSet = false;

    /**
     * The controller operation signature that takes the appropriate form (if this operation has at
     * least one form field) as an argument.
     * @return (String)handleGetFormSignature()
     */
    public final String getFormSignature()
    {
        String formSignature11a = this.formSignature11a;
        if (!this.formSignature11aSet)
        {
            // formSignature has no pre constraints
            formSignature11a = handleGetFormSignature();
            // formSignature has no post constraints
            this.formSignature11a = formSignature11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formSignature11aSet = true;
            }
        }
        return formSignature11a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiControllerOperation#getImplementationFormSignature()
    * @return String
    */
    protected abstract String handleGetImplementationFormSignature();

    private transient String implementationFormSignature12a;
    private transient boolean implementationFormSignature12aSet = false;

    /**
     * The controller implementation operation signature that takes the appropriate form (if this
     * operation has at least one form field) as an argument.
     * @return (String)handleGetImplementationFormSignature()
     */
    public final String getImplementationFormSignature()
    {
        String implementationFormSignature12a = this.implementationFormSignature12a;
        if (!this.implementationFormSignature12aSet)
        {
            // implementationFormSignature has no pre constraints
            implementationFormSignature12a = handleGetImplementationFormSignature();
            // implementationFormSignature has no post constraints
            this.implementationFormSignature12a = implementationFormSignature12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.implementationFormSignature12aSet = true;
            }
        }
        return implementationFormSignature12a;
    }

    // ------------- associations ------------------

    private transient GuiController getController1r;
    private transient boolean getController1rSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiControllerOperation
     * @return (GuiController)handleGetController()
     */
    public final GuiController getController()
    {
        GuiController getController1r = this.getController1r;
        if (!this.getController1rSet)
        {
            // guiControllerOperation has no pre constraints
            Object result = handleGetController();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getController1r = (GuiController) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiControllerOperationLogic.LOGGER.warn("incorrect metafacade cast for GuiControllerOperationLogic.getController GuiController " + result + ": " + shieldedResult);
            }
            // guiControllerOperation has no post constraints
            this.getController1r = getController1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getController1rSet = true;
            }
        }
        return getController1r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetController();

    private transient ServiceOperation getBackEndServiceOperation2r;
    private transient boolean getBackEndServiceOperation2rSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiControllerOperation
     * @return (ServiceOperation)handleGetBackEndServiceOperation()
     */
    public final ServiceOperation getBackEndServiceOperation()
    {
        ServiceOperation getBackEndServiceOperation2r = this.getBackEndServiceOperation2r;
        if (!this.getBackEndServiceOperation2rSet)
        {
            // guiControllerOperation has no pre constraints
            Object result = handleGetBackEndServiceOperation();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getBackEndServiceOperation2r = (ServiceOperation) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiControllerOperationLogic.LOGGER.warn("incorrect metafacade cast for GuiControllerOperationLogic.getBackEndServiceOperation ServiceOperation " + result + ": " + shieldedResult);
            }
            // guiControllerOperation has no post constraints
            this.getBackEndServiceOperation2r = getBackEndServiceOperation2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getBackEndServiceOperation2rSet = true;
            }
        }
        return getBackEndServiceOperation2r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetBackEndServiceOperation();

    /**
     * @return true
     * @see FrontEndControllerOperation
     */
    public boolean isFrontEndControllerOperationMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see OperationFacade
     */
    public boolean isOperationFacadeMetaType()
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

    // ----------- delegates to FrontEndControllerOperation ------------
    /**
     * The activity graph in which this controller operation is used.
     * @see FrontEndControllerOperation#getActivityGraph()
     */
    public FrontEndActivityGraph getActivityGraph()
    {
        return this.getSuperFrontEndControllerOperation().getActivityGraph();
    }

    /**
     * All those actions that contain at least one front-end action state that is deferring to this
     * operation.
     * @see FrontEndControllerOperation#getDeferringActions()
     */
    public List<FrontEndAction> getDeferringActions()
    {
        return this.getSuperFrontEndControllerOperation().getDeferringActions();
    }

    /**
     * The set of fields in the form made up form this controller operation's parameters.
     * @see FrontEndControllerOperation#getFormFields()
     */
    public List<FrontEndParameter> getFormFields()
    {
        return this.getSuperFrontEndControllerOperation().getFormFields();
    }

    /**
     * For each front-end controller operation argument there must exist a form field for each
     * action deferring to that operation. This form field must carry the same name and must be of
     * the same type. True if this is the case, false otherwise.
     * @see FrontEndControllerOperation#isAllArgumentsHaveFormFields()
     */
    public boolean isAllArgumentsHaveFormFields()
    {
        return this.getSuperFrontEndControllerOperation().isAllArgumentsHaveFormFields();
    }

    /**
     * Indicates if the owner of this operation is a controller.
     * @see FrontEndControllerOperation#isOwnerIsController()
     */
    public boolean isOwnerIsController()
    {
        return this.getSuperFrontEndControllerOperation().isOwnerIsController();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperFrontEndControllerOperation().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperFrontEndControllerOperation().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperFrontEndControllerOperation().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperFrontEndControllerOperation().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperFrontEndControllerOperation().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperFrontEndControllerOperation().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperFrontEndControllerOperation().getDocumentation(indent);
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
        return this.getSuperFrontEndControllerOperation().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperFrontEndControllerOperation().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperFrontEndControllerOperation().getFullyQualifiedName();
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
        return this.getSuperFrontEndControllerOperation().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperFrontEndControllerOperation().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperFrontEndControllerOperation().getId();
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
        return this.getSuperFrontEndControllerOperation().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperFrontEndControllerOperation().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperFrontEndControllerOperation().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperFrontEndControllerOperation().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperFrontEndControllerOperation().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperFrontEndControllerOperation().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperFrontEndControllerOperation().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperFrontEndControllerOperation().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperFrontEndControllerOperation().getPackagePath();
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
        return this.getSuperFrontEndControllerOperation().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperFrontEndControllerOperation().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperFrontEndControllerOperation().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperFrontEndControllerOperation().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperFrontEndControllerOperation().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperFrontEndControllerOperation().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperFrontEndControllerOperation().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperFrontEndControllerOperation().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperFrontEndControllerOperation().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperFrontEndControllerOperation().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperFrontEndControllerOperation().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndControllerOperation().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperFrontEndControllerOperation().hasKeyword(keywordName);
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
        return this.getSuperFrontEndControllerOperation().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperFrontEndControllerOperation().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperFrontEndControllerOperation().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperFrontEndControllerOperation().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperFrontEndControllerOperation().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperFrontEndControllerOperation().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperFrontEndControllerOperation().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperFrontEndControllerOperation().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperFrontEndControllerOperation().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperFrontEndControllerOperation().translateConstraints(kind, translation);
    }

    /**
     * Finds the parameter on this operation having the given name, if no parameter is found, null
     * is returned instead.
     * @see OperationFacade#findParameter(String name)
     */
    public ParameterFacade findParameter(String name)
    {
        return this.getSuperFrontEndControllerOperation().findParameter(name);
    }

    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class operation
     * to the class itself and then up the class hierarchy.
     * @see OperationFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperFrontEndControllerOperation().findTaggedValue(name, follow);
    }

    /**
     * A comma separated list of all argument names.
     * @see OperationFacade#getArgumentNames()
     */
    public String getArgumentNames()
    {
        return this.getSuperFrontEndControllerOperation().getArgumentNames();
    }

    /**
     * A comma separated list of all types of each argument, in order.
     * @see OperationFacade#getArgumentTypeNames()
     */
    public String getArgumentTypeNames()
    {
        return this.getSuperFrontEndControllerOperation().getArgumentTypeNames();
    }

    /**
     * Specification of an argument used to pass information into or out of an invocation of a
     * behavioral feature. Parameters are allowed to be treated as connectable elements. Parameters
     * have support for streaming, exceptions, and parameter sets.
     * @see OperationFacade#getArguments()
     */
    public Collection<ParameterFacade> getArguments()
    {
        return this.getSuperFrontEndControllerOperation().getArguments();
    }

    /**
     * Constructs the operation call with the operation name.
     * @see OperationFacade#getCall()
     */
    public String getCall()
    {
        return this.getSuperFrontEndControllerOperation().getCall();
    }

    /**
     * Returns the concurrency modifier for this operation (i.e. concurrent, guarded or sequential)
     * of the model element, will attempt a lookup for these values in the language mappings (if
     * any).
     * @see OperationFacade#getConcurrency()
     */
    public String getConcurrency()
    {
        return this.getSuperFrontEndControllerOperation().getConcurrency();
    }

    /**
     * A comma separated list containing all exceptions that this operation throws.  Exceptions are
     * determined through dependencies that have the target element stereotyped as <<Exception>>.
     * @see OperationFacade#getExceptionList()
     */
    public String getExceptionList()
    {
        return this.getSuperFrontEndControllerOperation().getExceptionList();
    }

    /**
     * Returns a comma separated list of exceptions appended to the comma separated list of fully
     * qualified 'initialException' classes passed in to this method.
     * @see OperationFacade#getExceptionList(String initialExceptions)
     */
    public String getExceptionList(String initialExceptions)
    {
        return this.getSuperFrontEndControllerOperation().getExceptionList(initialExceptions);
    }

    /**
     * A collection of all exceptions thrown by this operation.
     * @see OperationFacade#getExceptions()
     */
    public Collection<ModelElementFacade> getExceptions()
    {
        return this.getSuperFrontEndControllerOperation().getExceptions();
    }

    /**
     * Return Type with multiplicity taken into account. UML14 does not allow multiplicity *.
     * @see OperationFacade#getGetterSetterReturnTypeName()
     */
    public String getGetterSetterReturnTypeName()
    {
        return this.getSuperFrontEndControllerOperation().getGetterSetterReturnTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see OperationFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperFrontEndControllerOperation().getLower();
    }

    /**
     * Returns the operation method body determined from UML sequence diagrams or other UML sources.
     * @see OperationFacade#getMethodBody()
     */
    public String getMethodBody()
    {
        return this.getSuperFrontEndControllerOperation().getMethodBody();
    }

    /**
     * The operation this operation overrides, null if this operation is not overriding.
     * @see OperationFacade#getOverriddenOperation()
     */
    public OperationFacade getOverriddenOperation()
    {
        return this.getSuperFrontEndControllerOperation().getOverriddenOperation();
    }

    /**
     * Gets the owner of this operation
     * @see OperationFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperFrontEndControllerOperation().getOwner();
    }

    /**
     * Return all parameters for the operation, including the return parameter.
     * @see OperationFacade#getParameters()
     */
    public Collection<ParameterFacade> getParameters()
    {
        return this.getSuperFrontEndControllerOperation().getParameters();
    }

    /**
     * The name of the operation that handles postcondition constraints.
     * @see OperationFacade#getPostconditionName()
     */
    public String getPostconditionName()
    {
        return this.getSuperFrontEndControllerOperation().getPostconditionName();
    }

    /**
     * The postcondition constraints belonging to this operation.
     * @see OperationFacade#getPostconditions()
     */
    public Collection<ConstraintFacade> getPostconditions()
    {
        return this.getSuperFrontEndControllerOperation().getPostconditions();
    }

    /**
     * The call to the precondition operation.
     * @see OperationFacade#getPreconditionCall()
     */
    public String getPreconditionCall()
    {
        return this.getSuperFrontEndControllerOperation().getPreconditionCall();
    }

    /**
     * The name of the operation that handles precondition constraints.
     * @see OperationFacade#getPreconditionName()
     */
    public String getPreconditionName()
    {
        return this.getSuperFrontEndControllerOperation().getPreconditionName();
    }

    /**
     * The signature of the precondition operation.
     * @see OperationFacade#getPreconditionSignature()
     */
    public String getPreconditionSignature()
    {
        return this.getSuperFrontEndControllerOperation().getPreconditionSignature();
    }

    /**
     * The precondition constraints belonging to this operation.
     * @see OperationFacade#getPreconditions()
     */
    public Collection<ConstraintFacade> getPreconditions()
    {
        return this.getSuperFrontEndControllerOperation().getPreconditions();
    }

    /**
     * (UML2 Only). Get the actual return parameter (which may have stereotypes etc).
     * @see OperationFacade#getReturnParameter()
     */
    public ParameterFacade getReturnParameter()
    {
        return this.getSuperFrontEndControllerOperation().getReturnParameter();
    }

    /**
     * The operation return type parameter.
     * @see OperationFacade#getReturnType()
     */
    public ClassifierFacade getReturnType()
    {
        return this.getSuperFrontEndControllerOperation().getReturnType();
    }

    /**
     * Return the operation signature, including public/protested abstract returnType name plus
     * argument type and name.
     * @see OperationFacade#getSignature()
     */
    public String getSignature()
    {
        return this.getSuperFrontEndControllerOperation().getSignature();
    }

    /**
     * Returns the signature of the operation and optionally appends the argument names (if
     * withArgumentNames is true), otherwise returns the signature with just the types alone in the
     * signature.
     * @see OperationFacade#getSignature(boolean withArgumentNames)
     */
    public String getSignature(boolean withArgumentNames)
    {
        return this.getSuperFrontEndControllerOperation().getSignature(withArgumentNames);
    }

    /**
     * Returns the signature of the operation and optionally appends the given 'argumentModifier' to
     * each argument.
     * @see OperationFacade#getSignature(String argumentModifier)
     */
    public String getSignature(String argumentModifier)
    {
        return this.getSuperFrontEndControllerOperation().getSignature(argumentModifier);
    }

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation.
     * @see OperationFacade#getTypedArgumentList()
     */
    public String getTypedArgumentList()
    {
        return this.getSuperFrontEndControllerOperation().getTypedArgumentList();
    }

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation with an
     * optional modifier (i.e final) before each parameter.
     * @see OperationFacade#getTypedArgumentList(String modifier)
     */
    public String getTypedArgumentList(String modifier)
    {
        return this.getSuperFrontEndControllerOperation().getTypedArgumentList(modifier);
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * - only applicable for UML2
     * @see OperationFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperFrontEndControllerOperation().getUpper();
    }

    /**
     * True is the operation is abstract.
     * @see OperationFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperFrontEndControllerOperation().isAbstract();
    }

    /**
     * True if the operation has (i.e. throws any exceptions) false otherwise.
     * @see OperationFacade#isExceptionsPresent()
     */
    public boolean isExceptionsPresent()
    {
        return this.getSuperFrontEndControllerOperation().isExceptionsPresent();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant. Default=false.
     * @see OperationFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperFrontEndControllerOperation().isLeaf();
    }

    /**
     * UML2 only. If the return type parameter multiplicity>1 OR the operation multiplicity>1.
     * Default=false.
     * @see OperationFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperFrontEndControllerOperation().isMany();
    }

    /**
     * UML2 only: If isMany (Collection type returned), is the type unique within the collection. 
     * Unique+Ordered determines CollectionType implementation of return result. Default=false.
     * @see OperationFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperFrontEndControllerOperation().isOrdered();
    }

    /**
     * True if this operation overrides an operation defined in an ancestor class. An operation
     * overrides when the names of the operations as well as the types of the arguments are equal.
     * The return type may be different and is, as well as any exceptions, ignored.
     * @see OperationFacade#isOverriding()
     */
    public boolean isOverriding()
    {
        return this.getSuperFrontEndControllerOperation().isOverriding();
    }

    /**
     * Whether any postcondition constraints are present on this operation.
     * @see OperationFacade#isPostconditionsPresent()
     */
    public boolean isPostconditionsPresent()
    {
        return this.getSuperFrontEndControllerOperation().isPostconditionsPresent();
    }

    /**
     * Whether any precondition constraints are present on this operation.
     * @see OperationFacade#isPreconditionsPresent()
     */
    public boolean isPreconditionsPresent()
    {
        return this.getSuperFrontEndControllerOperation().isPreconditionsPresent();
    }

    /**
     * Indicates whether or not this operation is a query operation.
     * @see OperationFacade#isQuery()
     */
    public boolean isQuery()
    {
        return this.getSuperFrontEndControllerOperation().isQuery();
    }

    /**
     * True/false depending on whether or not the operation has a return type or not (i.e. a return
     * type of something other than void).
     * @see OperationFacade#isReturnTypePresent()
     */
    public boolean isReturnTypePresent()
    {
        return this.getSuperFrontEndControllerOperation().isReturnTypePresent();
    }

    /**
     * True is the operation is static (only a single instance can be instantiated).
     * @see OperationFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperFrontEndControllerOperation().isStatic();
    }

    /**
     * UML2 only: for Collection return type, is the type unique within the collection.
     * Unique+Ordered determines the returned CollectionType. Default=false.
     * @see OperationFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperFrontEndControllerOperation().isUnique();
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperFrontEndControllerOperation().initialize();
    }

    /**
     * @return Object getSuperFrontEndControllerOperation().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperFrontEndControllerOperation().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperFrontEndControllerOperation().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperFrontEndControllerOperation().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiControllerOperation::non-empty controller operation names</p>
     * <p><b>Error:</b> Each operation name on a controller must be non-empty.</p>
     * <p><b>OCL:</b> context GuiControllerOperation inv: name->notEmpty()</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiControllerOperation::controller/service operations need matching parameter types and names</p>
     * <p><b>Error:</b> If a controller operation delegates to a service operation it is required for them to have the same number of parameters and to have the parameter names and types matching so it is straightforward to pass these on.</p>
     * <p><b>OCL:</b> context GuiControllerOperation inv: backEndServiceOperation->notEmpty() implies backEndServiceOperationMatchingParameters</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperFrontEndControllerOperation().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure(OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"name")));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiControllerOperation::non-empty controller operation names",
                        "Each operation name on a controller must be non-empty."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiControllerOperation::non-empty controller operation names' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"backEndServiceOperation")))).booleanValue()?Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"backEndServiceOperationMatchingParameters"))).booleanValue():true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiControllerOperation::controller/service operations need matching parameter types and names",
                        "If a controller operation delegates to a service operation it is required for them to have the same number of parameters and to have the parameter names and types matching so it is straightforward to pass these on."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiControllerOperation::controller/service operations need matching parameter types and names' ON "
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