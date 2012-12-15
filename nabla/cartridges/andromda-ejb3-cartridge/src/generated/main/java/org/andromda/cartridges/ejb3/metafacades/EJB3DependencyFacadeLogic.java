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
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * TODO: Model Documentation for org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade
 * MetafacadeLogic for EJB3DependencyFacade
 *
 * @see EJB3DependencyFacade
 */
public abstract class EJB3DependencyFacadeLogic
    extends MetafacadeBase
    implements EJB3DependencyFacade
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
    protected EJB3DependencyFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superDependencyFacade =
           (DependencyFacade)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.DependencyFacade",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3DependencyFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade";
        }
        return context;
    }

    private DependencyFacade superDependencyFacade;
    private boolean superDependencyFacadeInitialized = false;

    /**
     * Gets the DependencyFacade parent instance.
     * @return this.superDependencyFacade DependencyFacade
     */
    private DependencyFacade getSuperDependencyFacade()
    {
        if (!this.superDependencyFacadeInitialized)
        {
            ((MetafacadeBase)this.superDependencyFacade).setMetafacadeContext(this.getMetafacadeContext());
            this.superDependencyFacadeInitialized = true;
        }
        return this.superDependencyFacade;
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
            if (this.superDependencyFacadeInitialized)
            {
                ((MetafacadeBase)this.superDependencyFacade).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3DependencyFacade
     */
    public boolean isEJB3DependencyFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getTransformationConstantName()
    * @return String
    */
    protected abstract String handleGetTransformationConstantName();

    private transient String transformationConstantName1a;
    private transient boolean transformationConstantName1aSet = false;

    /**
     * The name of the constant designated for use as a transformation flag for value objects (only
     * makes sense when this dependency goes into a value object).
     * @return (String)handleGetTransformationConstantName()
     */
    public final String getTransformationConstantName()
    {
        String transformationConstantName1a = this.transformationConstantName1a;
        if (!this.transformationConstantName1aSet)
        {
            // transformationConstantName has no pre constraints
            transformationConstantName1a = handleGetTransformationConstantName();
            // transformationConstantName has no post constraints
            this.transformationConstantName1a = transformationConstantName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transformationConstantName1aSet = true;
            }
        }
        return transformationConstantName1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getTransformationMethodName()
    * @return String
    */
    protected abstract String handleGetTransformationMethodName();

    private transient String transformationMethodName2a;
    private transient boolean transformationMethodName2aSet = false;

    /**
     * The name of the method used for transformation into a value object (only makes sense when
     * this dependency goes into a value object).
     * @return (String)handleGetTransformationMethodName()
     */
    public final String getTransformationMethodName()
    {
        String transformationMethodName2a = this.transformationMethodName2a;
        if (!this.transformationMethodName2aSet)
        {
            // transformationMethodName has no pre constraints
            transformationMethodName2a = handleGetTransformationMethodName();
            // transformationMethodName has no post constraints
            this.transformationMethodName2a = transformationMethodName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transformationMethodName2aSet = true;
            }
        }
        return transformationMethodName2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getTransformationAnonymousName()
    * @return String
    */
    protected abstract String handleGetTransformationAnonymousName();

    private transient String transformationAnonymousName3a;
    private transient boolean transformationAnonymousName3aSet = false;

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade.transformationAnonymousName
     * @return (String)handleGetTransformationAnonymousName()
     */
    public final String getTransformationAnonymousName()
    {
        String transformationAnonymousName3a = this.transformationAnonymousName3a;
        if (!this.transformationAnonymousName3aSet)
        {
            // transformationAnonymousName has no pre constraints
            transformationAnonymousName3a = handleGetTransformationAnonymousName();
            // transformationAnonymousName has no post constraints
            this.transformationAnonymousName3a = transformationAnonymousName3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transformationAnonymousName3aSet = true;
            }
        }
        return transformationAnonymousName3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#isCircularReference()
    * @return boolean
    */
    protected abstract boolean handleIsCircularReference();

    private transient boolean circularReference4a;
    private transient boolean circularReference4aSet = false;

    /**
     * Indicates if this dependency is part of a circular reference (meaning that both entities
     * reference each other).
     * @return (boolean)handleIsCircularReference()
     */
    public final boolean isCircularReference()
    {
        boolean circularReference4a = this.circularReference4a;
        if (!this.circularReference4aSet)
        {
            // circularReference has no pre constraints
            circularReference4a = handleIsCircularReference();
            // circularReference has no post constraints
            this.circularReference4a = circularReference4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.circularReference4aSet = true;
            }
        }
        return circularReference4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getTransformationConstantValue()
    * @return int
    */
    protected abstract int handleGetTransformationConstantValue();

    private transient int transformationConstantValue5a;
    private transient boolean transformationConstantValue5aSet = false;

    /**
     * Gets the transformation constant integer value.
     * @return (int)handleGetTransformationConstantValue()
     */
    public final int getTransformationConstantValue()
    {
        int transformationConstantValue5a = this.transformationConstantValue5a;
        if (!this.transformationConstantValue5aSet)
        {
            // transformationConstantValue has no pre constraints
            transformationConstantValue5a = handleGetTransformationConstantValue();
            // transformationConstantValue has no post constraints
            this.transformationConstantValue5a = transformationConstantValue5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transformationConstantValue5aSet = true;
            }
        }
        return transformationConstantValue5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getTransformationToCollectionMethodName()
    * @return String
    */
    protected abstract String handleGetTransformationToCollectionMethodName();

    private transient String transformationToCollectionMethodName6a;
    private transient boolean transformationToCollectionMethodName6aSet = false;

    /**
     * Returns the name of the method for transforming the contents of a collection.
     * @return (String)handleGetTransformationToCollectionMethodName()
     */
    public final String getTransformationToCollectionMethodName()
    {
        String transformationToCollectionMethodName6a = this.transformationToCollectionMethodName6a;
        if (!this.transformationToCollectionMethodName6aSet)
        {
            // transformationToCollectionMethodName has no pre constraints
            transformationToCollectionMethodName6a = handleGetTransformationToCollectionMethodName();
            // transformationToCollectionMethodName has no post constraints
            this.transformationToCollectionMethodName6a = transformationToCollectionMethodName6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transformationToCollectionMethodName6aSet = true;
            }
        }
        return transformationToCollectionMethodName6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getDaoName()
    * @return String
    */
    protected abstract String handleGetDaoName();

    private transient String daoName7a;
    private transient boolean daoName7aSet = false;

    /**
     * The name given to a DAO reference.
     * @return (String)handleGetDaoName()
     */
    public final String getDaoName()
    {
        String daoName7a = this.daoName7a;
        if (!this.daoName7aSet)
        {
            // daoName has no pre constraints
            daoName7a = handleGetDaoName();
            // daoName has no post constraints
            this.daoName7a = daoName7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoName7aSet = true;
            }
        }
        return daoName7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getDaoGetterName()
    * @return String
    */
    protected abstract String handleGetDaoGetterName();

    private transient String daoGetterName8a;
    private transient boolean daoGetterName8aSet = false;

    /**
     * The name of the DAO reference getter name.
     * @return (String)handleGetDaoGetterName()
     */
    public final String getDaoGetterName()
    {
        String daoGetterName8a = this.daoGetterName8a;
        if (!this.daoGetterName8aSet)
        {
            // daoGetterName has no pre constraints
            daoGetterName8a = handleGetDaoGetterName();
            // daoGetterName has no post constraints
            this.daoGetterName8a = daoGetterName8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoGetterName8aSet = true;
            }
        }
        return daoGetterName8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getDaoSetterName()
    * @return String
    */
    protected abstract String handleGetDaoSetterName();

    private transient String daoSetterName9a;
    private transient boolean daoSetterName9aSet = false;

    /**
     * The DAO reference setter's name.
     * @return (String)handleGetDaoSetterName()
     */
    public final String getDaoSetterName()
    {
        String daoSetterName9a = this.daoSetterName9a;
        if (!this.daoSetterName9aSet)
        {
            // daoSetterName has no pre constraints
            daoSetterName9a = handleGetDaoSetterName();
            // daoSetterName has no post constraints
            this.daoSetterName9a = daoSetterName9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoSetterName9aSet = true;
            }
        }
        return daoSetterName9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getTransformationToEntityCollectionMethodName()
    * @return String
    */
    protected abstract String handleGetTransformationToEntityCollectionMethodName();

    private transient String transformationToEntityCollectionMethodName10a;
    private transient boolean transformationToEntityCollectionMethodName10aSet = false;

    /**
     * The method name that performs the value object collection to entity collection
     * transformation.
     * @return (String)handleGetTransformationToEntityCollectionMethodName()
     */
    public final String getTransformationToEntityCollectionMethodName()
    {
        String transformationToEntityCollectionMethodName10a = this.transformationToEntityCollectionMethodName10a;
        if (!this.transformationToEntityCollectionMethodName10aSet)
        {
            // transformationToEntityCollectionMethodName has no pre constraints
            transformationToEntityCollectionMethodName10a = handleGetTransformationToEntityCollectionMethodName();
            // transformationToEntityCollectionMethodName has no post constraints
            this.transformationToEntityCollectionMethodName10a = transformationToEntityCollectionMethodName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transformationToEntityCollectionMethodName10aSet = true;
            }
        }
        return transformationToEntityCollectionMethodName10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getTransformationToEntityMethodName()
    * @return String
    */
    protected abstract String handleGetTransformationToEntityMethodName();

    private transient String transformationToEntityMethodName11a;
    private transient boolean transformationToEntityMethodName11aSet = false;

    /**
     * The name of the "to entity" transformation method name.
     * @return (String)handleGetTransformationToEntityMethodName()
     */
    public final String getTransformationToEntityMethodName()
    {
        String transformationToEntityMethodName11a = this.transformationToEntityMethodName11a;
        if (!this.transformationToEntityMethodName11aSet)
        {
            // transformationToEntityMethodName has no pre constraints
            transformationToEntityMethodName11a = handleGetTransformationToEntityMethodName();
            // transformationToEntityMethodName has no post constraints
            this.transformationToEntityMethodName11a = transformationToEntityMethodName11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transformationToEntityMethodName11aSet = true;
            }
        }
        return transformationToEntityMethodName11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3DependencyFacade#getValueObjectToEntityTransformerName()
    * @return String
    */
    protected abstract String handleGetValueObjectToEntityTransformerName();

    private transient String valueObjectToEntityTransformerName12a;
    private transient boolean valueObjectToEntityTransformerName12aSet = false;

    /**
     * The name of the class that performs the value object to entity transformation.
     * @return (String)handleGetValueObjectToEntityTransformerName()
     */
    public final String getValueObjectToEntityTransformerName()
    {
        String valueObjectToEntityTransformerName12a = this.valueObjectToEntityTransformerName12a;
        if (!this.valueObjectToEntityTransformerName12aSet)
        {
            // valueObjectToEntityTransformerName has no pre constraints
            valueObjectToEntityTransformerName12a = handleGetValueObjectToEntityTransformerName();
            // valueObjectToEntityTransformerName has no post constraints
            this.valueObjectToEntityTransformerName12a = valueObjectToEntityTransformerName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.valueObjectToEntityTransformerName12aSet = true;
            }
        }
        return valueObjectToEntityTransformerName12a;
    }

    /**
     * @return true
     * @see DependencyFacade
     */
    public boolean isDependencyFacadeMetaType()
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

    // ----------- delegates to DependencyFacade ------------
    /**
     * The "getter" name for this dependency.
     * @see DependencyFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperDependencyFacade().getGetterName();
    }

    /**
     * The "setter" name for this dependency.
     * @see DependencyFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperDependencyFacade().getSetterName();
    }

    /**
     * The source element of this dependency.
     * @see DependencyFacade#getSourceElement()
     */
    public ModelElementFacade getSourceElement()
    {
        return this.getSuperDependencyFacade().getSourceElement();
    }

    /**
     * Gets the element to which the dependencies belong.
     * @see DependencyFacade#getTargetElement()
     */
    public ModelElementFacade getTargetElement()
    {
        return this.getSuperDependencyFacade().getTargetElement();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperDependencyFacade().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperDependencyFacade().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperDependencyFacade().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperDependencyFacade().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperDependencyFacade().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperDependencyFacade().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperDependencyFacade().getDocumentation(indent);
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
        return this.getSuperDependencyFacade().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperDependencyFacade().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperDependencyFacade().getFullyQualifiedName();
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
        return this.getSuperDependencyFacade().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperDependencyFacade().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperDependencyFacade().getId();
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
        return this.getSuperDependencyFacade().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperDependencyFacade().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperDependencyFacade().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperDependencyFacade().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperDependencyFacade().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperDependencyFacade().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperDependencyFacade().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperDependencyFacade().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperDependencyFacade().getPackagePath();
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
        return this.getSuperDependencyFacade().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperDependencyFacade().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperDependencyFacade().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperDependencyFacade().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperDependencyFacade().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperDependencyFacade().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperDependencyFacade().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperDependencyFacade().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperDependencyFacade().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperDependencyFacade().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperDependencyFacade().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperDependencyFacade().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperDependencyFacade().hasKeyword(keywordName);
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
        return this.getSuperDependencyFacade().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperDependencyFacade().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperDependencyFacade().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperDependencyFacade().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperDependencyFacade().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperDependencyFacade().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperDependencyFacade().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperDependencyFacade().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperDependencyFacade().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperDependencyFacade().translateConstraints(kind, translation);
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperDependencyFacade().initialize();
    }

    /**
     * @return Object getSuperDependencyFacade().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperDependencyFacade().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperDependencyFacade().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperDependencyFacade().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperDependencyFacade().validateInvariants(validationMessages);
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