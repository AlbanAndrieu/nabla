// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Destination;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.Service;
import org.andromda.metafacades.uml.ServiceOperation;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for EJB3MessageDrivenOperationFacade
 *
 * @see EJB3MessageDrivenOperationFacade
 */
public abstract class EJB3MessageDrivenOperationFacadeLogic
    extends MetafacadeBase
    implements EJB3MessageDrivenOperationFacade
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
    protected EJB3MessageDrivenOperationFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superServiceOperation =
           (ServiceOperation)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.ServiceOperation",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3MessageDrivenOperationFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenOperationFacade";
        }
        return context;
    }

    private ServiceOperation superServiceOperation;
    private boolean superServiceOperationInitialized = false;

    /**
     * Gets the ServiceOperation parent instance.
     * @return this.superServiceOperation ServiceOperation
     */
    private ServiceOperation getSuperServiceOperation()
    {
        if (!this.superServiceOperationInitialized)
        {
            ((MetafacadeBase)this.superServiceOperation).setMetafacadeContext(this.getMetafacadeContext());
            this.superServiceOperationInitialized = true;
        }
        return this.superServiceOperation;
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
            if (this.superServiceOperationInitialized)
            {
                ((MetafacadeBase)this.superServiceOperation).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3MessageDrivenOperationFacade
     */
    public boolean isEJB3MessageDrivenOperationFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenOperationFacade#isPostConstruct()
    * @return boolean
    */
    protected abstract boolean handleIsPostConstruct();

    private boolean postConstruct1a;
    private boolean postConstruct1aSet = false;

    /**
     * Returns true if the associated operation has the <<PostConstruct>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPostConstruct()
     */
    public final boolean isPostConstruct()
    {
        boolean apostConstruct1a = this.postConstruct1a;
        if (!this.postConstruct1aSet)
        {
            // postConstruct has no pre constraints
            apostConstruct1a = handleIsPostConstruct();
            // postConstruct has no post constraints
            this.postConstruct1a = apostConstruct1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.postConstruct1aSet = true;
            }
        }
        return apostConstruct1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenOperationFacade#isPreDestroy()
    * @return boolean
    */
    protected abstract boolean handleIsPreDestroy();

    private boolean preDestroy2a;
    private boolean preDestroy2aSet = false;

    /**
     * Returns true if the associated operation has the <<PreDestroy>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPreDestroy()
     */
    public final boolean isPreDestroy()
    {
        boolean apreDestroy2a = this.preDestroy2a;
        if (!this.preDestroy2aSet)
        {
            // preDestroy has no pre constraints
            apreDestroy2a = handleIsPreDestroy();
            // preDestroy has no post constraints
            this.preDestroy2a = apreDestroy2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.preDestroy2aSet = true;
            }
        }
        return apreDestroy2a;
    }

    /**
     * @return true
     * @see ServiceOperation
     */
    public boolean isServiceOperationMetaType()
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

    // ----------- delegates to ServiceOperation ------------
    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperServiceOperation().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperServiceOperation().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperServiceOperation().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperServiceOperation().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperServiceOperation().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperServiceOperation().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperServiceOperation().getDocumentation(indent);
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
        return this.getSuperServiceOperation().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperServiceOperation().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperServiceOperation().getFullyQualifiedName();
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
        return this.getSuperServiceOperation().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperServiceOperation().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperServiceOperation().getId();
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
        return this.getSuperServiceOperation().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperServiceOperation().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperServiceOperation().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperServiceOperation().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperServiceOperation().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperServiceOperation().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperServiceOperation().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperServiceOperation().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperServiceOperation().getPackagePath();
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
        return this.getSuperServiceOperation().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperServiceOperation().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperServiceOperation().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperServiceOperation().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperServiceOperation().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperServiceOperation().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperServiceOperation().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperServiceOperation().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperServiceOperation().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperServiceOperation().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperServiceOperation().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperServiceOperation().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperServiceOperation().hasKeyword(keywordName);
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
        return this.getSuperServiceOperation().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperServiceOperation().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperServiceOperation().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperServiceOperation().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperServiceOperation().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperServiceOperation().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperServiceOperation().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperServiceOperation().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperServiceOperation().translateConstraints(kind, translation);
    }

    /**
     * Finds the parameter on this operation having the given name, if no parameter is found, null
     * is returned instead.
     * @see OperationFacade#findParameter(String name)
     */
    public ParameterFacade findParameter(String name)
    {
        return this.getSuperServiceOperation().findParameter(name);
    }

    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class operation
     * to the class itself and then up the class hierarchy.
     * @see OperationFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperServiceOperation().findTaggedValue(name, follow);
    }

    /**
     * A comma separated list of all argument names.
     * @see OperationFacade#getArgumentNames()
     */
    public String getArgumentNames()
    {
        return this.getSuperServiceOperation().getArgumentNames();
    }

    /**
     * 
     * @see OperationFacade#getArgumentTypeNames()
     */
    public String getArgumentTypeNames()
    {
        return this.getSuperServiceOperation().getArgumentTypeNames();
    }

    /**
     * 
     * @see OperationFacade#getArguments()
     */
    public Collection<ParameterFacade> getArguments()
    {
        return this.getSuperServiceOperation().getArguments();
    }

    /**
     * 
     * @see OperationFacade#getCall()
     */
    public String getCall()
    {
        return this.getSuperServiceOperation().getCall();
    }

    /**
     * Returns the concurrency modifier for this operation (i.e. concurrent, guarded or sequential)
     * of the model element, will attempt a lookup for these values in the language mappings (if
     * any).
     * @see OperationFacade#getConcurrency()
     */
    public String getConcurrency()
    {
        return this.getSuperServiceOperation().getConcurrency();
    }

    /**
     * A comma separated list containing all exceptions that this operation throws.  Exceptions are
     * determined through dependencies that have the target element stereotyped as <<Exception>>.
     * @see OperationFacade#getExceptionList()
     */
    public String getExceptionList()
    {
        return this.getSuperServiceOperation().getExceptionList();
    }

    /**
     * Returns a comma separated list of exceptions appended to the comma separated list of fully
     * qualified 'initialException' classes passed in to this method.
     * @see OperationFacade#getExceptionList(String initialExceptions)
     */
    public String getExceptionList(String initialExceptions)
    {
        return this.getSuperServiceOperation().getExceptionList(initialExceptions);
    }

    /**
     * A collection of all exceptions thrown by this operation.
     * @see OperationFacade#getExceptions()
     */
    public Collection<ModelElementFacade> getExceptions()
    {
        return this.getSuperServiceOperation().getExceptions();
    }

    /**
     * Return Type with multiplicity taken into account. UML14 does not allow multiplicity *.
     * @see OperationFacade#getGetterSetterReturnTypeName()
     */
    public String getGetterSetterReturnTypeName()
    {
        return this.getSuperServiceOperation().getGetterSetterReturnTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see OperationFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperServiceOperation().getLower();
    }

    /**
     * Returns the operation method body determined from UML sequence diagrams or other UML sources.
     * @see OperationFacade#getMethodBody()
     */
    public String getMethodBody()
    {
        return this.getSuperServiceOperation().getMethodBody();
    }

    /**
     * The operation this operation overrides, null if this operation is not overriding.
     * @see OperationFacade#getOverriddenOperation()
     */
    public OperationFacade getOverriddenOperation()
    {
        return this.getSuperServiceOperation().getOverriddenOperation();
    }

    /**
     * Gets the owner of this operation
     * @see OperationFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperServiceOperation().getOwner();
    }

    /**
     * 
     * @see OperationFacade#getParameters()
     */
    public Collection<ParameterFacade> getParameters()
    {
        return this.getSuperServiceOperation().getParameters();
    }

    /**
     * The name of the operation that handles postcondition constraints.
     * @see OperationFacade#getPostconditionName()
     */
    public String getPostconditionName()
    {
        return this.getSuperServiceOperation().getPostconditionName();
    }

    /**
     * The postcondition constraints belonging to this operation.
     * @see OperationFacade#getPostconditions()
     */
    public Collection<ConstraintFacade> getPostconditions()
    {
        return this.getSuperServiceOperation().getPostconditions();
    }

    /**
     * The call to the precondition operation.
     * @see OperationFacade#getPreconditionCall()
     */
    public String getPreconditionCall()
    {
        return this.getSuperServiceOperation().getPreconditionCall();
    }

    /**
     * The name of the operation that handles precondition constraints.
     * @see OperationFacade#getPreconditionName()
     */
    public String getPreconditionName()
    {
        return this.getSuperServiceOperation().getPreconditionName();
    }

    /**
     * The signature of the precondition operation.
     * @see OperationFacade#getPreconditionSignature()
     */
    public String getPreconditionSignature()
    {
        return this.getSuperServiceOperation().getPreconditionSignature();
    }

    /**
     * The precondition constraints belonging to this operation.
     * @see OperationFacade#getPreconditions()
     */
    public Collection<ConstraintFacade> getPreconditions()
    {
        return this.getSuperServiceOperation().getPreconditions();
    }

    /**
     * (UML2 Only). Get the actual return parameter (which may have stereotypes etc).
     * @see OperationFacade#getReturnParameter()
     */
    public ParameterFacade getReturnParameter()
    {
        return this.getSuperServiceOperation().getReturnParameter();
    }

    /**
     * 
     * @see OperationFacade#getReturnType()
     */
    public ClassifierFacade getReturnType()
    {
        return this.getSuperServiceOperation().getReturnType();
    }

    /**
     * 
     * @see OperationFacade#getSignature()
     */
    public String getSignature()
    {
        return this.getSuperServiceOperation().getSignature();
    }

    /**
     * Returns the signature of the operation and optionally appends the argument names (if
     * withArgumentNames is true), otherwise returns the signature with just the types alone in the
     * signature.
     * @see OperationFacade#getSignature(boolean withArgumentNames)
     */
    public String getSignature(boolean withArgumentNames)
    {
        return this.getSuperServiceOperation().getSignature(withArgumentNames);
    }

    /**
     * Returns the signature of the operation and optionally appends the given 'argumentModifier' to
     * each argument.
     * @see OperationFacade#getSignature(String argumentModifier)
     */
    public String getSignature(String argumentModifier)
    {
        return this.getSuperServiceOperation().getSignature(argumentModifier);
    }

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation.
     * @see OperationFacade#getTypedArgumentList()
     */
    public String getTypedArgumentList()
    {
        return this.getSuperServiceOperation().getTypedArgumentList();
    }

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation with an
     * optional modifier (i.e final) before each parameter.
     * @see OperationFacade#getTypedArgumentList(String modifier)
     */
    public String getTypedArgumentList(String modifier)
    {
        return this.getSuperServiceOperation().getTypedArgumentList(modifier);
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * - only applicable for UML2
     * @see OperationFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperServiceOperation().getUpper();
    }

    /**
     * 
     * @see OperationFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperServiceOperation().isAbstract();
    }

    /**
     * True if the operation has (i.e. throws any exceptions) false otherwise.
     * @see OperationFacade#isExceptionsPresent()
     */
    public boolean isExceptionsPresent()
    {
        return this.getSuperServiceOperation().isExceptionsPresent();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant. Default=false.
     * @see OperationFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperServiceOperation().isLeaf();
    }

    /**
     * UML2 only. If the return type parameter multiplicity>1 OR the operation multiplicity>1.
     * Default=false.
     * @see OperationFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperServiceOperation().isMany();
    }

    /**
     * UML2 only: If isMany (Collection type returned), is the type unique within the collection. 
     * Unique+Ordered determines CollectionType implementation of return result. Default=false.
     * @see OperationFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperServiceOperation().isOrdered();
    }

    /**
     * True if this operation overrides an operation defined in an ancestor class. An operation
     * overrides when the names of the operations as well as the types of the arguments are equal.
     * The return type may be different and is, as well as any exceptions, ignored.
     * @see OperationFacade#isOverriding()
     */
    public boolean isOverriding()
    {
        return this.getSuperServiceOperation().isOverriding();
    }

    /**
     * Whether any postcondition constraints are present on this operation.
     * @see OperationFacade#isPostconditionsPresent()
     */
    public boolean isPostconditionsPresent()
    {
        return this.getSuperServiceOperation().isPostconditionsPresent();
    }

    /**
     * Whether any precondition constraints are present on this operation.
     * @see OperationFacade#isPreconditionsPresent()
     */
    public boolean isPreconditionsPresent()
    {
        return this.getSuperServiceOperation().isPreconditionsPresent();
    }

    /**
     * Indicates whether or not this operation is a query operation.
     * @see OperationFacade#isQuery()
     */
    public boolean isQuery()
    {
        return this.getSuperServiceOperation().isQuery();
    }

    /**
     * True/false depending on whether or not the operation has a return type or not (i.e. a return
     * type of something other than void).
     * @see OperationFacade#isReturnTypePresent()
     */
    public boolean isReturnTypePresent()
    {
        return this.getSuperServiceOperation().isReturnTypePresent();
    }

    /**
     * 
     * @see OperationFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperServiceOperation().isStatic();
    }

    /**
     * UML2 only: for Collection return type, is the type unique within the collection.
     * Unique+Ordered determines the returned CollectionType. Default=false.
     * @see OperationFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperServiceOperation().isUnique();
    }

    /**
     * The destination for any incoming messages.
     * @see ServiceOperation#getIncomingDestination()
     */
    public Destination getIncomingDestination()
    {
        return this.getSuperServiceOperation().getIncomingDestination();
    }

    /**
     * The destination for any outgoing messages.
     * @see ServiceOperation#getOutgoingDestination()
     */
    public Destination getOutgoingDestination()
    {
        return this.getSuperServiceOperation().getOutgoingDestination();
    }

    /**
     * The users of the service operation, these are the actor's that can access this operation.
     * @see ServiceOperation#getRoles()
     */
    public Collection<Role> getRoles()
    {
        return this.getSuperServiceOperation().getRoles();
    }

    /**
     * The service which owns the service operation.
     * @see ServiceOperation#getService()
     */
    public Service getService()
    {
        return this.getSuperServiceOperation().getService();
    }

    /**
     * Whether or not this operation represents an "incoming" message operation (i.e. it receives
     * messages from Queues or Topics).
     * @see ServiceOperation#isIncomingMessageOperation()
     */
    public boolean isIncomingMessageOperation()
    {
        return this.getSuperServiceOperation().isIncomingMessageOperation();
    }

    /**
     * Whether or not this is operation accepts incoming or outgoing messages.
     * @see ServiceOperation#isMessageOperation()
     */
    public boolean isMessageOperation()
    {
        return this.getSuperServiceOperation().isMessageOperation();
    }

    /**
     * Whether or not this service operation represents an "outgoing" messaging operation (i.e. it
     * sends messages to Queues or Topics).
     * @see ServiceOperation#isOutgoingMessageOperation()
     */
    public boolean isOutgoingMessageOperation()
    {
        return this.getSuperServiceOperation().isOutgoingMessageOperation();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperServiceOperation().initialize();
    }

    /**
     * @return Object getSuperServiceOperation().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperServiceOperation().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperServiceOperation().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperServiceOperation().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperServiceOperation().validateInvariants(validationMessages);
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