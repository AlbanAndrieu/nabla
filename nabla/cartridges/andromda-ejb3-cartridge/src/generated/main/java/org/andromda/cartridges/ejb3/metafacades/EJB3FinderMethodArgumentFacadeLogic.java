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
import org.andromda.metafacades.uml.EventFacade;
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
 * Represents an argument in a EJB3 finder method.
 * MetafacadeLogic for EJB3FinderMethodArgumentFacade
 *
 * @see EJB3FinderMethodArgumentFacade
 */
public abstract class EJB3FinderMethodArgumentFacadeLogic
    extends MetafacadeBase
    implements EJB3FinderMethodArgumentFacade
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
    protected EJB3FinderMethodArgumentFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superParameterFacade =
           (ParameterFacade)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.ParameterFacade",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3FinderMethodArgumentFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3FinderMethodArgumentFacade";
        }
        return context;
    }

    private ParameterFacade superParameterFacade;
    private boolean superParameterFacadeInitialized = false;

    /**
     * Gets the ParameterFacade parent instance.
     * @return this.superParameterFacade ParameterFacade
     */
    private ParameterFacade getSuperParameterFacade()
    {
        if (!this.superParameterFacadeInitialized)
        {
            ((MetafacadeBase)this.superParameterFacade).setMetafacadeContext(this.getMetafacadeContext());
            this.superParameterFacadeInitialized = true;
        }
        return this.superParameterFacade;
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
            if (this.superParameterFacadeInitialized)
            {
                ((MetafacadeBase)this.superParameterFacade).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3FinderMethodArgumentFacade
     */
    public boolean isEJB3FinderMethodArgumentFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3FinderMethodArgumentFacade#getTemporalType()
    * @return String
    */
    protected abstract String handleGetTemporalType();

    private transient String temporalType1a;
    private transient boolean temporalType1aSet = false;

    /**
     * Returns the temporal type value set via tagged value on finder method parameters if one
     * exists.  Expect one of DATE, TIME, TIMESTAMP or NONE.  This is used in the Query.setParameter
     * method.
     * @return (String)handleGetTemporalType()
     */
    public final String getTemporalType()
    {
        String temporalType1a = this.temporalType1a;
        if (!this.temporalType1aSet)
        {
            // temporalType has no pre constraints
            temporalType1a = handleGetTemporalType();
            // temporalType has no post constraints
            this.temporalType1a = temporalType1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.temporalType1aSet = true;
            }
        }
        return temporalType1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3FinderMethodArgumentFacade#isFirstResult()
    * @return boolean
    */
    protected abstract boolean handleIsFirstResult();

    private transient boolean firstResult2a;
    private transient boolean firstResult2aSet = false;

    /**
     * Returns true if FirstResult stereotype is applied to this finder method parameter.
     * @return (boolean)handleIsFirstResult()
     */
    public final boolean isFirstResult()
    {
        boolean firstResult2a = this.firstResult2a;
        if (!this.firstResult2aSet)
        {
            // firstResult has no pre constraints
            firstResult2a = handleIsFirstResult();
            // firstResult has no post constraints
            this.firstResult2a = firstResult2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.firstResult2aSet = true;
            }
        }
        return firstResult2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3FinderMethodArgumentFacade#isMaxResults()
    * @return boolean
    */
    protected abstract boolean handleIsMaxResults();

    private transient boolean maxResults3a;
    private transient boolean maxResults3aSet = false;

    /**
     * Returns true if MaxResults stereotype is applied to this finder method parameter.
     * @return (boolean)handleIsMaxResults()
     */
    public final boolean isMaxResults()
    {
        boolean maxResults3a = this.maxResults3a;
        if (!this.maxResults3aSet)
        {
            // maxResults has no pre constraints
            maxResults3a = handleIsMaxResults();
            // maxResults has no post constraints
            this.maxResults3a = maxResults3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.maxResults3aSet = true;
            }
        }
        return maxResults3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3FinderMethodArgumentFacade#isEnumerationTypeOrdinal()
    * @return boolean
    */
    protected abstract boolean handleIsEnumerationTypeOrdinal();

    private transient boolean enumerationTypeOrdinal4a;
    private transient boolean enumerationTypeOrdinal4aSet = false;

    /**
     * Returns true if this parameter is of type enum and has ordinal values.
     * @return (boolean)handleIsEnumerationTypeOrdinal()
     */
    public final boolean isEnumerationTypeOrdinal()
    {
        boolean enumerationTypeOrdinal4a = this.enumerationTypeOrdinal4a;
        if (!this.enumerationTypeOrdinal4aSet)
        {
            // enumerationTypeOrdinal has no pre constraints
            enumerationTypeOrdinal4a = handleIsEnumerationTypeOrdinal();
            // enumerationTypeOrdinal has no post constraints
            this.enumerationTypeOrdinal4a = enumerationTypeOrdinal4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.enumerationTypeOrdinal4aSet = true;
            }
        }
        return enumerationTypeOrdinal4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3FinderMethodArgumentFacade#isEnumerationTypeString()
    * @return boolean
    */
    protected abstract boolean handleIsEnumerationTypeString();

    private transient boolean enumerationTypeString5a;
    private transient boolean enumerationTypeString5aSet = false;

    /**
     * Returns true if this parameter is of type enum and has string values.
     * @return (boolean)handleIsEnumerationTypeString()
     */
    public final boolean isEnumerationTypeString()
    {
        boolean enumerationTypeString5a = this.enumerationTypeString5a;
        if (!this.enumerationTypeString5aSet)
        {
            // enumerationTypeString has no pre constraints
            enumerationTypeString5a = handleIsEnumerationTypeString();
            // enumerationTypeString has no post constraints
            this.enumerationTypeString5a = enumerationTypeString5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.enumerationTypeString5aSet = true;
            }
        }
        return enumerationTypeString5a;
    }

    /**
     * @return true
     * @see ParameterFacade
     */
    public boolean isParameterFacadeMetaType()
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

    // ----------- delegates to ParameterFacade ------------
    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperParameterFacade().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperParameterFacade().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperParameterFacade().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperParameterFacade().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperParameterFacade().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperParameterFacade().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperParameterFacade().getDocumentation(indent);
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
        return this.getSuperParameterFacade().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperParameterFacade().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperParameterFacade().getFullyQualifiedName();
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
        return this.getSuperParameterFacade().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperParameterFacade().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperParameterFacade().getId();
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
        return this.getSuperParameterFacade().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperParameterFacade().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperParameterFacade().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperParameterFacade().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperParameterFacade().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperParameterFacade().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperParameterFacade().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperParameterFacade().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperParameterFacade().getPackagePath();
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
        return this.getSuperParameterFacade().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperParameterFacade().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperParameterFacade().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperParameterFacade().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperParameterFacade().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperParameterFacade().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperParameterFacade().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperParameterFacade().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperParameterFacade().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperParameterFacade().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperParameterFacade().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperParameterFacade().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperParameterFacade().hasKeyword(keywordName);
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
        return this.getSuperParameterFacade().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperParameterFacade().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperParameterFacade().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperParameterFacade().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperParameterFacade().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperParameterFacade().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperParameterFacade().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperParameterFacade().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperParameterFacade().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperParameterFacade().translateConstraints(kind, translation);
    }

    /**
     * TODO: Model Documentation for ParameterFacade.defaultValue
     * @see ParameterFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {
        return this.getSuperParameterFacade().getDefaultValue();
    }

    /**
     * UML2: A representation of the literals of the enumeration 'Parameter Effect Kind': CREATE,
     * READ, UPDATE, DELETE. The datatype ParameterEffectKind is an enumeration that indicates the
     * effect of a behavior on values passed in or out of its parameters.
     * @see ParameterFacade#getEffect()
     */
    public String getEffect()
    {
        return this.getSuperParameterFacade().getEffect();
    }

    /**
     * If this parameter is located on an event, this will represent that event.
     * @see ParameterFacade#getEvent()
     */
    public EventFacade getEvent()
    {
        return this.getSuperParameterFacade().getEvent();
    }

    /**
     * The name to use for accessors getting this parameter from a bean.
     * @see ParameterFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperParameterFacade().getGetterName();
    }

    /**
     * Fully Qualified TypeName, determined in part by multiplicity (for UML2). For UML14, same as
     * getterName.
     * @see ParameterFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperParameterFacade().getGetterSetterTypeName();
    }

    /**
     * Fully Qualified implementation class of TypeName, determined in part by multiplicity (for
     * UML2). If upper multiplicity =1, same as getterSetterTypeName.
     * @see ParameterFacade#getGetterSetterTypeNameImpl()
     */
    public String getGetterSetterTypeNameImpl()
    {
        return this.getSuperParameterFacade().getGetterSetterTypeNameImpl();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see ParameterFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperParameterFacade().getLower();
    }

    /**
     * If this parameter is located on an operation, this will represent that operation.
     * @see ParameterFacade#getOperation()
     */
    public OperationFacade getOperation()
    {
        return this.getSuperParameterFacade().getOperation();
    }

    /**
     * The name to use for accessors getting this parameter in a bean.
     * @see ParameterFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperParameterFacade().getSetterName();
    }

    /**
     * A Classifier is a classification of instances - it describes a set of instances that have
     * features in common. Can specify a generalization hierarchy by referencing its general
     * classifiers. It may be a Class, DataType, PrimitiveType, Association, Collaboration, UseCase,
     * etc. Can specify a generalization hierarchy by referencing its general classifiers. Has the
     * capability to own collaboration uses. These collaboration uses link a collaboration with the
     * classifier to give a description of the workings of the classifier. Classifier is defined to
     * be a kind of templateable element so that a classifier can be parameterized. It is also
     * defined to be a kind of parameterable element so that a classifier can be a formal template
     * parameter.
     * @see ParameterFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperParameterFacade().getType();
    }

    /**
     * the upper value of the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see ParameterFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperParameterFacade().getUpper();
    }

    /**
     * Indicates if the default value is present.
     * @see ParameterFacade#isDefaultValuePresent()
     */
    public boolean isDefaultValuePresent()
    {
        return this.getSuperParameterFacade().isDefaultValuePresent();
    }

    /**
     * UML2: Returns the value of the 'Is Exception' attribute. The default value is "false". Tells
     * whether an output parameter may emit a value to the exclusion of the other outputs.
     * @see ParameterFacade#isException()
     */
    public boolean isException()
    {
        return this.getSuperParameterFacade().isException();
    }

    /**
     * True if this parameter is an 'in' parameter.
     * @see ParameterFacade#isInParameter()
     */
    public boolean isInParameter()
    {
        return this.getSuperParameterFacade().isInParameter();
    }

    /**
     * True if this parameter is an inout parameter.
     * @see ParameterFacade#isInoutParameter()
     */
    public boolean isInoutParameter()
    {
        return this.getSuperParameterFacade().isInoutParameter();
    }

    /**
     * If upper>1 or upper==unlimited. Only applies to UML2. For UML14, always false.
     * @see ParameterFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperParameterFacade().isMany();
    }

    /**
     * UML2 Only: Is parameter ordered within the Collection type. Ordered+Unique determines the
     * implementation Collection Type. For UML14, always false.
     * @see ParameterFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperParameterFacade().isOrdered();
    }

    /**
     * True if this parameter is an 'out' parameter.
     * @see ParameterFacade#isOutParameter()
     */
    public boolean isOutParameter()
    {
        return this.getSuperParameterFacade().isOutParameter();
    }

    /**
     * True if this parameter is readable, aka an in-parameter, or this feature is unspecified.
     * @see ParameterFacade#isReadable()
     */
    public boolean isReadable()
    {
        return this.getSuperParameterFacade().isReadable();
    }

    /**
     * Whether or not this parameter is considered required (i.e must a non-empty value).
     * @see ParameterFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperParameterFacade().isRequired();
    }

    /**
     * Whether or not this parameter represents a return parameter.
     * @see ParameterFacade#isReturn()
     */
    public boolean isReturn()
    {
        return this.getSuperParameterFacade().isReturn();
    }

    /**
     * If Parameter type isMany (UML2), is the parameter unique within the Collection. Unique+Sorted
     * determines pareter implementation type. For UML14, always false.
     * @see ParameterFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperParameterFacade().isUnique();
    }

    /**
     * True if this parameter is writable, aka an out-parameter, or this feature is unspecified.
     * @see ParameterFacade#isWritable()
     */
    public boolean isWritable()
    {
        return this.getSuperParameterFacade().isWritable();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperParameterFacade().initialize();
    }

    /**
     * @return Object getSuperParameterFacade().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperParameterFacade().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperParameterFacade().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperParameterFacade().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperParameterFacade().validateInvariants(validationMessages);
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