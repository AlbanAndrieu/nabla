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
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * Represents an operation in an entity EJB bean POJO.
 * MetafacadeLogic for EJB3OperationFacade
 *
 * @see EJB3OperationFacade
 */
public abstract class EJB3OperationFacadeLogic
    extends MetafacadeBase
    implements EJB3OperationFacade
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
    protected EJB3OperationFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superOperationFacade =
           (OperationFacade)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.OperationFacade",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3OperationFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade";
        }
        return context;
    }

    private OperationFacade superOperationFacade;
    private boolean superOperationFacadeInitialized = false;

    /**
     * Gets the OperationFacade parent instance.
     * @return this.superOperationFacade OperationFacade
     */
    private OperationFacade getSuperOperationFacade()
    {
        if (!this.superOperationFacadeInitialized)
        {
            ((MetafacadeBase)this.superOperationFacade).setMetafacadeContext(this.getMetafacadeContext());
            this.superOperationFacadeInitialized = true;
        }
        return this.superOperationFacade;
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
            if (this.superOperationFacadeInitialized)
            {
                ((MetafacadeBase)this.superOperationFacade).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3OperationFacade
     */
    public boolean isEJB3OperationFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isBusinessOperation()
    * @return boolean
    */
    protected abstract boolean handleIsBusinessOperation();

    private transient boolean businessOperation1a;
    private transient boolean businessOperation1aSet = false;

    /**
     * True/false on whether or not this operation is an EJB business operation.  This returns true
     * if the operation is not one of the following:
     * Create Method
     * Finder or Query Method
     * Select Method
     * @return (boolean)handleIsBusinessOperation()
     */
    public final boolean isBusinessOperation()
    {
        boolean businessOperation1a = this.businessOperation1a;
        if (!this.businessOperation1aSet)
        {
            // businessOperation has no pre constraints
            businessOperation1a = handleIsBusinessOperation();
            // businessOperation has no post constraints
            this.businessOperation1a = businessOperation1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.businessOperation1aSet = true;
            }
        }
        return businessOperation1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isSelectMethod()
    * @return boolean
    */
    protected abstract boolean handleIsSelectMethod();

    private transient boolean selectMethod2a;
    private transient boolean selectMethod2aSet = false;

    /**
     * True/false on whether or not this operation represents a select method.
     * @return (boolean)handleIsSelectMethod()
     */
    public final boolean isSelectMethod()
    {
        boolean selectMethod2a = this.selectMethod2a;
        if (!this.selectMethod2aSet)
        {
            // selectMethod has no pre constraints
            selectMethod2a = handleIsSelectMethod();
            // selectMethod has no post constraints
            this.selectMethod2a = selectMethod2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.selectMethod2aSet = true;
            }
        }
        return selectMethod2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isPrePersist()
    * @return boolean
    */
    protected abstract boolean handleIsPrePersist();

    private transient boolean prePersist3a;
    private transient boolean prePersist3aSet = false;

    /**
     * Returns true if the associated operation has the <<PrePersist>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPrePersist()
     */
    public final boolean isPrePersist()
    {
        boolean prePersist3a = this.prePersist3a;
        if (!this.prePersist3aSet)
        {
            // prePersist has no pre constraints
            prePersist3a = handleIsPrePersist();
            // prePersist has no post constraints
            this.prePersist3a = prePersist3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.prePersist3aSet = true;
            }
        }
        return prePersist3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isPostPersist()
    * @return boolean
    */
    protected abstract boolean handleIsPostPersist();

    private transient boolean postPersist4a;
    private transient boolean postPersist4aSet = false;

    /**
     * Returns true if the associated operation has the <<PostPersist>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPostPersist()
     */
    public final boolean isPostPersist()
    {
        boolean postPersist4a = this.postPersist4a;
        if (!this.postPersist4aSet)
        {
            // postPersist has no pre constraints
            postPersist4a = handleIsPostPersist();
            // postPersist has no post constraints
            this.postPersist4a = postPersist4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.postPersist4aSet = true;
            }
        }
        return postPersist4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isPreRemove()
    * @return boolean
    */
    protected abstract boolean handleIsPreRemove();

    private transient boolean preRemove5a;
    private transient boolean preRemove5aSet = false;

    /**
     * Returns true if the associated operation has the <<PreRemove>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPreRemove()
     */
    public final boolean isPreRemove()
    {
        boolean preRemove5a = this.preRemove5a;
        if (!this.preRemove5aSet)
        {
            // preRemove has no pre constraints
            preRemove5a = handleIsPreRemove();
            // preRemove has no post constraints
            this.preRemove5a = preRemove5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.preRemove5aSet = true;
            }
        }
        return preRemove5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isPostRemove()
    * @return boolean
    */
    protected abstract boolean handleIsPostRemove();

    private transient boolean postRemove6a;
    private transient boolean postRemove6aSet = false;

    /**
     * Returns true if the associated operation has the <<PostRemove>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPostRemove()
     */
    public final boolean isPostRemove()
    {
        boolean postRemove6a = this.postRemove6a;
        if (!this.postRemove6aSet)
        {
            // postRemove has no pre constraints
            postRemove6a = handleIsPostRemove();
            // postRemove has no post constraints
            this.postRemove6a = postRemove6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.postRemove6aSet = true;
            }
        }
        return postRemove6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isPreUpdate()
    * @return boolean
    */
    protected abstract boolean handleIsPreUpdate();

    private transient boolean preUpdate7a;
    private transient boolean preUpdate7aSet = false;

    /**
     * Returns true if the associated operation has the <<PreUpdate>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPreUpdate()
     */
    public final boolean isPreUpdate()
    {
        boolean preUpdate7a = this.preUpdate7a;
        if (!this.preUpdate7aSet)
        {
            // preUpdate has no pre constraints
            preUpdate7a = handleIsPreUpdate();
            // preUpdate has no post constraints
            this.preUpdate7a = preUpdate7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.preUpdate7aSet = true;
            }
        }
        return preUpdate7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isPostUpdate()
    * @return boolean
    */
    protected abstract boolean handleIsPostUpdate();

    private transient boolean postUpdate8a;
    private transient boolean postUpdate8aSet = false;

    /**
     * Returns true if the associated operation has the <<PostUpdate>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPostUpdate()
     */
    public final boolean isPostUpdate()
    {
        boolean postUpdate8a = this.postUpdate8a;
        if (!this.postUpdate8aSet)
        {
            // postUpdate has no pre constraints
            postUpdate8a = handleIsPostUpdate();
            // postUpdate has no post constraints
            this.postUpdate8a = postUpdate8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.postUpdate8aSet = true;
            }
        }
        return postUpdate8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isPostLoad()
    * @return boolean
    */
    protected abstract boolean handleIsPostLoad();

    private transient boolean postLoad9a;
    private transient boolean postLoad9aSet = false;

    /**
     * Returns true if the associated operation has the <<PostLoad>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPostLoad()
     */
    public final boolean isPostLoad()
    {
        boolean postLoad9a = this.postLoad9a;
        if (!this.postLoad9aSet)
        {
            // postLoad has no pre constraints
            postLoad9a = handleIsPostLoad();
            // postLoad has no post constraints
            this.postLoad9a = postLoad9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.postLoad9aSet = true;
            }
        }
        return postLoad9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isLifecycleCallback()
    * @return boolean
    */
    protected abstract boolean handleIsLifecycleCallback();

    private transient boolean lifecycleCallback10a;
    private transient boolean lifecycleCallback10aSet = false;

    /**
     * Returns true if this operation is marked with any of the lifecycle callback stereotypes like
     * PrePersist, PostPersist, PreRemove, PostRemove, PreUpdate, PostUpdate or PostLoad.
     * @return (boolean)handleIsLifecycleCallback()
     */
    public final boolean isLifecycleCallback()
    {
        boolean lifecycleCallback10a = this.lifecycleCallback10a;
        if (!this.lifecycleCallback10aSet)
        {
            // lifecycleCallback has no pre constraints
            lifecycleCallback10a = handleIsLifecycleCallback();
            // lifecycleCallback has no post constraints
            this.lifecycleCallback10a = lifecycleCallback10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.lifecycleCallback10aSet = true;
            }
        }
        return lifecycleCallback10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#getImplementationName()
    * @return String
    */
    protected abstract String handleGetImplementationName();

    private transient String implementationName11a;
    private transient boolean implementationName11aSet = false;

    /**
     * The name of the operation used within the entity implementation.
     * @return (String)handleGetImplementationName()
     */
    public final String getImplementationName()
    {
        String implementationName11a = this.implementationName11a;
        if (!this.implementationName11aSet)
        {
            // implementationName has no pre constraints
            implementationName11a = handleGetImplementationName();
            // implementationName has no post constraints
            this.implementationName11a = implementationName11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.implementationName11aSet = true;
            }
        }
        return implementationName11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#getImplementationCall()
    * @return String
    */
    protected abstract String handleGetImplementationCall();

    private transient String implementationCall12a;
    private transient boolean implementationCall12aSet = false;

    /**
     * The method call for the implementation operation.
     * @return (String)handleGetImplementationCall()
     */
    public final String getImplementationCall()
    {
        String implementationCall12a = this.implementationCall12a;
        if (!this.implementationCall12aSet)
        {
            // implementationCall has no pre constraints
            implementationCall12a = handleGetImplementationCall();
            // implementationCall has no post constraints
            this.implementationCall12a = implementationCall12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.implementationCall12aSet = true;
            }
        }
        return implementationCall12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#getImplementationSignature()
    * @return String
    */
    protected abstract String handleGetImplementationSignature();

    private transient String implementationSignature13a;
    private transient boolean implementationSignature13aSet = false;

    /**
     * The signature for the implementation operation.
     * @return (String)handleGetImplementationSignature()
     */
    public final String getImplementationSignature()
    {
        String implementationSignature13a = this.implementationSignature13a;
        if (!this.implementationSignature13aSet)
        {
            // implementationSignature has no pre constraints
            implementationSignature13a = handleGetImplementationSignature();
            // implementationSignature has no post constraints
            this.implementationSignature13a = implementationSignature13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.implementationSignature13aSet = true;
            }
        }
        return implementationSignature13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isCreateMethod()
    * @return boolean
    */
    protected abstract boolean handleIsCreateMethod();

    private transient boolean createMethod14a;
    private transient boolean createMethod14aSet = false;

    /**
     * Returns true if the operation has the <<CreateMethod>> stereotype.
     * @return (boolean)handleIsCreateMethod()
     */
    public final boolean isCreateMethod()
    {
        boolean createMethod14a = this.createMethod14a;
        if (!this.createMethod14aSet)
        {
            // createMethod has no pre constraints
            createMethod14a = handleIsCreateMethod();
            // createMethod has no post constraints
            this.createMethod14a = createMethod14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.createMethod14aSet = true;
            }
        }
        return createMethod14a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3OperationFacade#isFinderMethod()
    * @return boolean
    */
    protected abstract boolean handleIsFinderMethod();

    private transient boolean finderMethod15a;
    private transient boolean finderMethod15aSet = false;

    /**
     * Returns true if the operation is a finder or query operation.
     * @return (boolean)handleIsFinderMethod()
     */
    public final boolean isFinderMethod()
    {
        boolean finderMethod15a = this.finderMethod15a;
        if (!this.finderMethod15aSet)
        {
            // finderMethod has no pre constraints
            finderMethod15a = handleIsFinderMethod();
            // finderMethod has no post constraints
            this.finderMethod15a = finderMethod15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.finderMethod15aSet = true;
            }
        }
        return finderMethod15a;
    }

    // ------------- associations ------------------

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

    // ----------- delegates to OperationFacade ------------
    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperOperationFacade().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperOperationFacade().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperOperationFacade().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperOperationFacade().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperOperationFacade().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperOperationFacade().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperOperationFacade().getDocumentation(indent);
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
        return this.getSuperOperationFacade().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperOperationFacade().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperOperationFacade().getFullyQualifiedName();
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
        return this.getSuperOperationFacade().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperOperationFacade().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperOperationFacade().getId();
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
        return this.getSuperOperationFacade().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperOperationFacade().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperOperationFacade().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperOperationFacade().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperOperationFacade().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperOperationFacade().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperOperationFacade().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperOperationFacade().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperOperationFacade().getPackagePath();
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
        return this.getSuperOperationFacade().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperOperationFacade().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperOperationFacade().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperOperationFacade().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperOperationFacade().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperOperationFacade().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperOperationFacade().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperOperationFacade().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperOperationFacade().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperOperationFacade().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperOperationFacade().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperOperationFacade().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperOperationFacade().hasKeyword(keywordName);
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
        return this.getSuperOperationFacade().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperOperationFacade().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperOperationFacade().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperOperationFacade().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperOperationFacade().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperOperationFacade().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperOperationFacade().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperOperationFacade().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperOperationFacade().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperOperationFacade().translateConstraints(kind, translation);
    }

    /**
     * Finds the parameter on this operation having the given name, if no parameter is found, null
     * is returned instead.
     * @see OperationFacade#findParameter(String name)
     */
    public ParameterFacade findParameter(String name)
    {
        return this.getSuperOperationFacade().findParameter(name);
    }

    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class operation
     * to the class itself and then up the class hierarchy.
     * @see OperationFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperOperationFacade().findTaggedValue(name, follow);
    }

    /**
     * A comma separated list of all argument names.
     * @see OperationFacade#getArgumentNames()
     */
    public String getArgumentNames()
    {
        return this.getSuperOperationFacade().getArgumentNames();
    }

    /**
     * A comma separated list of all types of each argument, in order.
     * @see OperationFacade#getArgumentTypeNames()
     */
    public String getArgumentTypeNames()
    {
        return this.getSuperOperationFacade().getArgumentTypeNames();
    }

    /**
     * Specification of an argument used to pass information into or out of an invocation of a
     * behavioral feature. Parameters are allowed to be treated as connectable elements. Parameters
     * have support for streaming, exceptions, and parameter sets.
     * @see OperationFacade#getArguments()
     */
    public Collection<ParameterFacade> getArguments()
    {
        return this.getSuperOperationFacade().getArguments();
    }

    /**
     * Constructs the operation call with the operation name.
     * @see OperationFacade#getCall()
     */
    public String getCall()
    {
        return this.getSuperOperationFacade().getCall();
    }

    /**
     * Returns the concurrency modifier for this operation (i.e. concurrent, guarded or sequential)
     * of the model element, will attempt a lookup for these values in the language mappings (if
     * any).
     * @see OperationFacade#getConcurrency()
     */
    public String getConcurrency()
    {
        return this.getSuperOperationFacade().getConcurrency();
    }

    /**
     * A comma separated list containing all exceptions that this operation throws.  Exceptions are
     * determined through dependencies that have the target element stereotyped as <<Exception>>.
     * @see OperationFacade#getExceptionList()
     */
    public String getExceptionList()
    {
        return this.getSuperOperationFacade().getExceptionList();
    }

    /**
     * Returns a comma separated list of exceptions appended to the comma separated list of fully
     * qualified 'initialException' classes passed in to this method.
     * @see OperationFacade#getExceptionList(String initialExceptions)
     */
    public String getExceptionList(String initialExceptions)
    {
        return this.getSuperOperationFacade().getExceptionList(initialExceptions);
    }

    /**
     * A collection of all exceptions thrown by this operation.
     * @see OperationFacade#getExceptions()
     */
    public Collection<ModelElementFacade> getExceptions()
    {
        return this.getSuperOperationFacade().getExceptions();
    }

    /**
     * Return Type with multiplicity taken into account. UML14 does not allow multiplicity *.
     * @see OperationFacade#getGetterSetterReturnTypeName()
     */
    public String getGetterSetterReturnTypeName()
    {
        return this.getSuperOperationFacade().getGetterSetterReturnTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see OperationFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperOperationFacade().getLower();
    }

    /**
     * Returns the operation method body determined from UML sequence diagrams or other UML sources.
     * @see OperationFacade#getMethodBody()
     */
    public String getMethodBody()
    {
        return this.getSuperOperationFacade().getMethodBody();
    }

    /**
     * The operation this operation overrides, null if this operation is not overriding.
     * @see OperationFacade#getOverriddenOperation()
     */
    public OperationFacade getOverriddenOperation()
    {
        return this.getSuperOperationFacade().getOverriddenOperation();
    }

    /**
     * Gets the owner of this operation
     * @see OperationFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperOperationFacade().getOwner();
    }

    /**
     * Return all parameters for the operation, including the return parameter.
     * @see OperationFacade#getParameters()
     */
    public Collection<ParameterFacade> getParameters()
    {
        return this.getSuperOperationFacade().getParameters();
    }

    /**
     * The name of the operation that handles postcondition constraints.
     * @see OperationFacade#getPostconditionName()
     */
    public String getPostconditionName()
    {
        return this.getSuperOperationFacade().getPostconditionName();
    }

    /**
     * The postcondition constraints belonging to this operation.
     * @see OperationFacade#getPostconditions()
     */
    public Collection<ConstraintFacade> getPostconditions()
    {
        return this.getSuperOperationFacade().getPostconditions();
    }

    /**
     * The call to the precondition operation.
     * @see OperationFacade#getPreconditionCall()
     */
    public String getPreconditionCall()
    {
        return this.getSuperOperationFacade().getPreconditionCall();
    }

    /**
     * The name of the operation that handles precondition constraints.
     * @see OperationFacade#getPreconditionName()
     */
    public String getPreconditionName()
    {
        return this.getSuperOperationFacade().getPreconditionName();
    }

    /**
     * The signature of the precondition operation.
     * @see OperationFacade#getPreconditionSignature()
     */
    public String getPreconditionSignature()
    {
        return this.getSuperOperationFacade().getPreconditionSignature();
    }

    /**
     * The precondition constraints belonging to this operation.
     * @see OperationFacade#getPreconditions()
     */
    public Collection<ConstraintFacade> getPreconditions()
    {
        return this.getSuperOperationFacade().getPreconditions();
    }

    /**
     * (UML2 Only). Get the actual return parameter (which may have stereotypes etc).
     * @see OperationFacade#getReturnParameter()
     */
    public ParameterFacade getReturnParameter()
    {
        return this.getSuperOperationFacade().getReturnParameter();
    }

    /**
     * The operation return type parameter.
     * @see OperationFacade#getReturnType()
     */
    public ClassifierFacade getReturnType()
    {
        return this.getSuperOperationFacade().getReturnType();
    }

    /**
     * Return the operation signature, including public/protested abstract returnType name plus
     * argument type and name.
     * @see OperationFacade#getSignature()
     */
    public String getSignature()
    {
        return this.getSuperOperationFacade().getSignature();
    }

    /**
     * Returns the signature of the operation and optionally appends the argument names (if
     * withArgumentNames is true), otherwise returns the signature with just the types alone in the
     * signature.
     * @see OperationFacade#getSignature(boolean withArgumentNames)
     */
    public String getSignature(boolean withArgumentNames)
    {
        return this.getSuperOperationFacade().getSignature(withArgumentNames);
    }

    /**
     * Returns the signature of the operation and optionally appends the given 'argumentModifier' to
     * each argument.
     * @see OperationFacade#getSignature(String argumentModifier)
     */
    public String getSignature(String argumentModifier)
    {
        return this.getSuperOperationFacade().getSignature(argumentModifier);
    }

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation.
     * @see OperationFacade#getTypedArgumentList()
     */
    public String getTypedArgumentList()
    {
        return this.getSuperOperationFacade().getTypedArgumentList();
    }

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation with an
     * optional modifier (i.e final) before each parameter.
     * @see OperationFacade#getTypedArgumentList(String modifier)
     */
    public String getTypedArgumentList(String modifier)
    {
        return this.getSuperOperationFacade().getTypedArgumentList(modifier);
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * - only applicable for UML2
     * @see OperationFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperOperationFacade().getUpper();
    }

    /**
     * True is the operation is abstract.
     * @see OperationFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperOperationFacade().isAbstract();
    }

    /**
     * True if the operation has (i.e. throws any exceptions) false otherwise.
     * @see OperationFacade#isExceptionsPresent()
     */
    public boolean isExceptionsPresent()
    {
        return this.getSuperOperationFacade().isExceptionsPresent();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant. Default=false.
     * @see OperationFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperOperationFacade().isLeaf();
    }

    /**
     * UML2 only. If the return type parameter multiplicity>1 OR the operation multiplicity>1.
     * Default=false.
     * @see OperationFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperOperationFacade().isMany();
    }

    /**
     * UML2 only: If isMany (Collection type returned), is the type unique within the collection. 
     * Unique+Ordered determines CollectionType implementation of return result. Default=false.
     * @see OperationFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperOperationFacade().isOrdered();
    }

    /**
     * True if this operation overrides an operation defined in an ancestor class. An operation
     * overrides when the names of the operations as well as the types of the arguments are equal.
     * The return type may be different and is, as well as any exceptions, ignored.
     * @see OperationFacade#isOverriding()
     */
    public boolean isOverriding()
    {
        return this.getSuperOperationFacade().isOverriding();
    }

    /**
     * Whether any postcondition constraints are present on this operation.
     * @see OperationFacade#isPostconditionsPresent()
     */
    public boolean isPostconditionsPresent()
    {
        return this.getSuperOperationFacade().isPostconditionsPresent();
    }

    /**
     * Whether any precondition constraints are present on this operation.
     * @see OperationFacade#isPreconditionsPresent()
     */
    public boolean isPreconditionsPresent()
    {
        return this.getSuperOperationFacade().isPreconditionsPresent();
    }

    /**
     * Indicates whether or not this operation is a query operation.
     * @see OperationFacade#isQuery()
     */
    public boolean isQuery()
    {
        return this.getSuperOperationFacade().isQuery();
    }

    /**
     * True/false depending on whether or not the operation has a return type or not (i.e. a return
     * type of something other than void).
     * @see OperationFacade#isReturnTypePresent()
     */
    public boolean isReturnTypePresent()
    {
        return this.getSuperOperationFacade().isReturnTypePresent();
    }

    /**
     * True is the operation is static (only a single instance can be instantiated).
     * @see OperationFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperOperationFacade().isStatic();
    }

    /**
     * UML2 only: for Collection return type, is the type unique within the collection.
     * Unique+Ordered determines the returned CollectionType. Default=false.
     * @see OperationFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperOperationFacade().isUnique();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperOperationFacade().initialize();
    }

    /**
     * @return Object getSuperOperationFacade().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperOperationFacade().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperOperationFacade().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperOperationFacade().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperOperationFacade().validateInvariants(validationMessages);
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