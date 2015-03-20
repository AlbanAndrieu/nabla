// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.database.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EntityAssociation;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.GeneralizationFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.apache.log4j.Logger;

/**
 * TODO: Model Documentation for org.andromda.cartridges.database.metafacades.AssociationTable
 * MetafacadeLogic for AssociationTable
 *
 * @see AssociationTable
 */
public abstract class AssociationTableLogic
    extends MetafacadeBase
    implements AssociationTable
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
    protected AssociationTableLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superEntityAssociation =
           (EntityAssociation)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.EntityAssociation",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(AssociationTableLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to AssociationTable if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.database.metafacades.AssociationTable";
        }
        return context;
    }

    private EntityAssociation superEntityAssociation;
    private boolean superEntityAssociationInitialized = false;

    /**
     * Gets the EntityAssociation parent instance.
     * @return this.superEntityAssociation EntityAssociation
     */
    private EntityAssociation getSuperEntityAssociation()
    {
        if (!this.superEntityAssociationInitialized)
        {
            ((MetafacadeBase)this.superEntityAssociation).setMetafacadeContext(this.getMetafacadeContext());
            this.superEntityAssociationInitialized = true;
        }
        return this.superEntityAssociation;
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
            if (this.superEntityAssociationInitialized)
            {
                ((MetafacadeBase)this.superEntityAssociation).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see AssociationTable
     */
    public boolean isAssociationTableMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.database.metafacades.AssociationTable#getPrimaryKeyColumns()
    * @return String
    */
    protected abstract String handleGetPrimaryKeyColumns();

    private transient String primaryKeyColumns1a;
    private transient boolean primaryKeyColumns1aSet = false;

    /**
     * A comma seperated list of primary key columns.
     * @return (String)handleGetPrimaryKeyColumns()
     */
    public final String getPrimaryKeyColumns()
    {
        String primaryKeyColumns1a = this.primaryKeyColumns1a;
        if (!this.primaryKeyColumns1aSet)
        {
            // primaryKeyColumns has no pre constraints
            primaryKeyColumns1a = handleGetPrimaryKeyColumns();
            // primaryKeyColumns has no post constraints
            this.primaryKeyColumns1a = primaryKeyColumns1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.primaryKeyColumns1aSet = true;
            }
        }
        return primaryKeyColumns1a;
    }

   /**
    * @see org.andromda.cartridges.database.metafacades.AssociationTable#getPrimaryKeyConstraintName()
    * @return String
    */
    protected abstract String handleGetPrimaryKeyConstraintName();

    private transient String primaryKeyConstraintName2a;
    private transient boolean primaryKeyConstraintName2aSet = false;

    /**
     * The name of the primary key constraint for this table.
     * @return (String)handleGetPrimaryKeyConstraintName()
     */
    public final String getPrimaryKeyConstraintName()
    {
        String primaryKeyConstraintName2a = this.primaryKeyConstraintName2a;
        if (!this.primaryKeyConstraintName2aSet)
        {
            // primaryKeyConstraintName has no pre constraints
            primaryKeyConstraintName2a = handleGetPrimaryKeyConstraintName();
            // primaryKeyConstraintName has no post constraints
            this.primaryKeyConstraintName2a = primaryKeyConstraintName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.primaryKeyConstraintName2aSet = true;
            }
        }
        return primaryKeyConstraintName2a;
    }

   /**
    * @see org.andromda.cartridges.database.metafacades.AssociationTable#isForeignKeyColumnsPresent()
    * @return boolean
    */
    protected abstract boolean handleIsForeignKeyColumnsPresent();

    private transient boolean foreignKeyColumnsPresent3a;
    private transient boolean foreignKeyColumnsPresent3aSet = false;

    /**
     * Are there foreign key columns present in this table?
     * @return (boolean)handleIsForeignKeyColumnsPresent()
     */
    public final boolean isForeignKeyColumnsPresent()
    {
        boolean foreignKeyColumnsPresent3a = this.foreignKeyColumnsPresent3a;
        if (!this.foreignKeyColumnsPresent3aSet)
        {
            // foreignKeyColumnsPresent has no pre constraints
            foreignKeyColumnsPresent3a = handleIsForeignKeyColumnsPresent();
            // foreignKeyColumnsPresent has no post constraints
            this.foreignKeyColumnsPresent3a = foreignKeyColumnsPresent3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.foreignKeyColumnsPresent3aSet = true;
            }
        }
        return foreignKeyColumnsPresent3a;
    }

    // ------------- associations ------------------

    private transient Collection<ForeignKeyColumn> getForeignKeyColumns1r;
    private transient boolean getForeignKeyColumns1rSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.database.metafacades.AssociationTable
     * @return (Collection<ForeignKeyColumn>)handleGetForeignKeyColumns()
     */
    public final Collection<ForeignKeyColumn> getForeignKeyColumns()
    {
        Collection<ForeignKeyColumn> getForeignKeyColumns1r = this.getForeignKeyColumns1r;
        if (!this.getForeignKeyColumns1rSet)
        {
            // associationTable has no pre constraints
            Collection result = handleGetForeignKeyColumns();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getForeignKeyColumns1r = (Collection<ForeignKeyColumn>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                AssociationTableLogic.LOGGER.warn("incorrect metafacade cast for AssociationTableLogic.getForeignKeyColumns Collection<ForeignKeyColumn> " + result + ": " + shieldedResult);
            }
            // associationTable has no post constraints
            this.getForeignKeyColumns1r = getForeignKeyColumns1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getForeignKeyColumns1rSet = true;
            }
        }
        return getForeignKeyColumns1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetForeignKeyColumns();

    /**
     * @return true
     * @see EntityAssociation
     */
    public boolean isEntityAssociationMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.AssociationFacade
     */
    public boolean isAssociationFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see GeneralizableElementFacade
     */
    public boolean isGeneralizableElementFacadeMetaType()
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

    // ----------- delegates to EntityAssociation ------------
    /**
     * The first association end.
     * @see org.andromda.metafacades.uml.AssociationFacade#getAssociationEndA()
     */
    public AssociationEndFacade getAssociationEndA()
    {
        return this.getSuperEntityAssociation().getAssociationEndA();
    }

    /**
     * The second association end.
     * @see org.andromda.metafacades.uml.AssociationFacade#getAssociationEndB()
     */
    public AssociationEndFacade getAssociationEndB()
    {
        return this.getSuperEntityAssociation().getAssociationEndB();
    }

    /**
     * Gets the association ends belonging to this association.
     * @see org.andromda.metafacades.uml.AssociationFacade#getAssociationEnds()
     */
    public List<AssociationEndFacade> getAssociationEnds()
    {
        return this.getSuperEntityAssociation().getAssociationEnds();
    }

    /**
     * A name suited for naming this relationship. This name will be constructed from both
     * association ends.
     * @see org.andromda.metafacades.uml.AssociationFacade#getRelationName()
     */
    public String getRelationName()
    {
        return this.getSuperEntityAssociation().getRelationName();
    }

    /**
     * Indicates if this association is 'abstract'.
     * @see org.andromda.metafacades.uml.AssociationFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperEntityAssociation().isAbstract();
    }

    /**
     * True if the AssociationFacade is an AssociationClass.
     * @see org.andromda.metafacades.uml.AssociationFacade#isAssociationClass()
     */
    public boolean isAssociationClass()
    {
        return this.getSuperEntityAssociation().isAssociationClass();
    }

    /**
     * UML2: Determines whether this association is a binary association, i.e. whether it has
     * exactly two member ends. UML2 allows association classes in the association itself (many2many
     * with association attributes). Default=true: only two member ends.
     * @see org.andromda.metafacades.uml.AssociationFacade#isBinary()
     */
    public boolean isBinary()
    {
        return this.getSuperEntityAssociation().isBinary();
    }

    /**
     * UML2: Returns the value of the 'Is Derived' attribute. The default value is "false". If
     * isDerived is true, the value of the attribute is derived from information elsewhere.
     * Specifies whether the Property is derived, i.e., whether its value or values can be computed
     * from other information.
     * @see org.andromda.metafacades.uml.AssociationFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperEntityAssociation().isDerived();
    }

    /**
     * True if this association cannot be extended and represent a leaf in the inheritance tree.
     * @see org.andromda.metafacades.uml.AssociationFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEntityAssociation().isLeaf();
    }

    /**
     * Indicates whether or not this associations represents a many-to-many relation.
     * @see org.andromda.metafacades.uml.AssociationFacade#isMany2Many()
     */
    public boolean isMany2Many()
    {
        return this.getSuperEntityAssociation().isMany2Many();
    }

    /**
     * The name of the schema that contains the database table
     * @see EntityAssociation#getSchema()
     */
    public String getSchema()
    {
        return this.getSuperEntityAssociation().getSchema();
    }

    /**
     * The name of the table if this is a many-to-many association.  Otherwise it just returns null
     * if not part of a many-to-many association.
     * @see EntityAssociation#getTableName()
     */
    public String getTableName()
    {
        return this.getSuperEntityAssociation().getTableName();
    }

    /**
     * is this an EntityAssociation?
     * @see EntityAssociation#isEntityAssociation()
     */
    public boolean isEntityAssociation()
    {
        return this.getSuperEntityAssociation().isEntityAssociation();
    }

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @see GeneralizableElementFacade#findTaggedValue(String tagName, boolean follow)
     */
    public Object findTaggedValue(String tagName, boolean follow)
    {
        return this.getSuperEntityAssociation().findTaggedValue(tagName, follow);
    }

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @see GeneralizableElementFacade#getAllGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations()
    {
        return this.getSuperEntityAssociation().getAllGeneralizations();
    }

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @see GeneralizableElementFacade#getAllSpecializations()
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations()
    {
        return this.getSuperEntityAssociation().getAllSpecializations();
    }

    /**
     * Gets the direct generalization for this generalizable element.
     * @see GeneralizableElementFacade#getGeneralization()
     */
    public GeneralizableElementFacade getGeneralization()
    {
        return this.getSuperEntityAssociation().getGeneralization();
    }

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @see GeneralizableElementFacade#getGeneralizationLinks()
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks()
    {
        return this.getSuperEntityAssociation().getGeneralizationLinks();
    }

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @see GeneralizableElementFacade#getGeneralizationList()
     */
    public String getGeneralizationList()
    {
        return this.getSuperEntityAssociation().getGeneralizationList();
    }

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @see GeneralizableElementFacade#getGeneralizationRoot()
     */
    public GeneralizableElementFacade getGeneralizationRoot()
    {
        return this.getSuperEntityAssociation().getGeneralizationRoot();
    }

    /**
     * The model element that represents an element that can be generalized or specialized.
     * @see GeneralizableElementFacade#getGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getGeneralizations()
    {
        return this.getSuperEntityAssociation().getGeneralizations();
    }

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @see GeneralizableElementFacade#getSpecializations()
     */
    public Collection<GeneralizableElementFacade> getSpecializations()
    {
        return this.getSuperEntityAssociation().getSpecializations();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEntityAssociation().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEntityAssociation().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperEntityAssociation().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEntityAssociation().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEntityAssociation().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperEntityAssociation().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEntityAssociation().getDocumentation(indent);
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
        return this.getSuperEntityAssociation().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEntityAssociation().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEntityAssociation().getFullyQualifiedName();
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
        return this.getSuperEntityAssociation().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEntityAssociation().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEntityAssociation().getId();
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
        return this.getSuperEntityAssociation().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEntityAssociation().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEntityAssociation().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEntityAssociation().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEntityAssociation().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEntityAssociation().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEntityAssociation().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEntityAssociation().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEntityAssociation().getPackagePath();
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
        return this.getSuperEntityAssociation().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEntityAssociation().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEntityAssociation().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEntityAssociation().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEntityAssociation().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEntityAssociation().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEntityAssociation().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEntityAssociation().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEntityAssociation().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEntityAssociation().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEntityAssociation().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEntityAssociation().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEntityAssociation().hasKeyword(keywordName);
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
        return this.getSuperEntityAssociation().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEntityAssociation().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEntityAssociation().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEntityAssociation().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEntityAssociation().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEntityAssociation().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperEntityAssociation().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEntityAssociation().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEntityAssociation().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEntityAssociation().translateConstraints(kind, translation);
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEntityAssociation().initialize();
    }

    /**
     * @return Object getSuperEntityAssociation().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEntityAssociation().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperEntityAssociation().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEntityAssociation().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperEntityAssociation().validateInvariants(validationMessages);
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