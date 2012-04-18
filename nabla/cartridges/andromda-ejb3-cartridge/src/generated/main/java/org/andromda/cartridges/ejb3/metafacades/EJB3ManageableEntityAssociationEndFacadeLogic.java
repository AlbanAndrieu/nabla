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
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AssociationFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EntityAttribute;
import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for EJB3ManageableEntityAssociationEndFacade
 *
 * @see EJB3ManageableEntityAssociationEndFacade
 */
public abstract class EJB3ManageableEntityAssociationEndFacadeLogic
    extends MetafacadeBase
    implements EJB3ManageableEntityAssociationEndFacade
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
    protected EJB3ManageableEntityAssociationEndFacadeLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superManageableEntityAssociationEnd =
           (ManageableEntityAssociationEnd)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.ManageableEntityAssociationEnd",
                    metaObjectIn,
                    getContext(context));
        this.superEJB3AssociationEndFacade =
           (EJB3AssociationEndFacade)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3ManageableEntityAssociationEndFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAssociationEndFacade";
        }
        return context;
    }

    private ManageableEntityAssociationEnd superManageableEntityAssociationEnd;
    private boolean superManageableEntityAssociationEndInitialized = false;

    /**
     * Gets the ManageableEntityAssociationEnd parent instance.
     * @return this.superManageableEntityAssociationEnd ManageableEntityAssociationEnd
     */
    protected ManageableEntityAssociationEnd getSuperManageableEntityAssociationEnd()
    {
        if (!this.superManageableEntityAssociationEndInitialized)
        {
            ((MetafacadeBase)this.superManageableEntityAssociationEnd).setMetafacadeContext(this.getMetafacadeContext());
            this.superManageableEntityAssociationEndInitialized = true;
        }
        return this.superManageableEntityAssociationEnd;
    }

    private EJB3AssociationEndFacade superEJB3AssociationEndFacade;
    private boolean superEJB3AssociationEndFacadeInitialized = false;

    /**
     * Gets the EJB3AssociationEndFacade parent instance.
     * @return this.superEJB3AssociationEndFacade EJB3AssociationEndFacade
     */
    protected EJB3AssociationEndFacade getSuperEJB3AssociationEndFacade()
    {
        if (!this.superEJB3AssociationEndFacadeInitialized)
        {
            ((MetafacadeBase)this.superEJB3AssociationEndFacade).setMetafacadeContext(this.getMetafacadeContext());
            this.superEJB3AssociationEndFacadeInitialized = true;
        }
        return this.superEJB3AssociationEndFacade;
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
            if (this.superManageableEntityAssociationEndInitialized)
            {
                ((MetafacadeBase)this.superManageableEntityAssociationEnd).resetMetafacadeContext(context);
            }
            if (this.superEJB3AssociationEndFacadeInitialized)
            {
                ((MetafacadeBase)this.superEJB3AssociationEndFacade).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3ManageableEntityAssociationEndFacade
     */
    public boolean isEJB3ManageableEntityAssociationEndFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAssociationEndFacade#getDaoSetterName()
    * @return String
    */
    protected abstract String handleGetDaoSetterName();

    private String __daoSetterName1a;
    private boolean __daoSetterName1aSet = false;

    /**
     * 
     * @return (String)handleGetDaoSetterName()
     */
    public final String getDaoSetterName()
    {
        String daoSetterName1a = this.__daoSetterName1a;
        if (!this.__daoSetterName1aSet)
        {
            // daoSetterName has no pre constraints
            daoSetterName1a = handleGetDaoSetterName();
            // daoSetterName has no post constraints
            this.__daoSetterName1a = daoSetterName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__daoSetterName1aSet = true;
            }
        }
        return daoSetterName1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAssociationEndFacade#getDaoReferenceName()
    * @return String
    */
    protected abstract String handleGetDaoReferenceName();

    private String __daoReferenceName2a;
    private boolean __daoReferenceName2aSet = false;

    /**
     * 
     * @return (String)handleGetDaoReferenceName()
     */
    public final String getDaoReferenceName()
    {
        String daoReferenceName2a = this.__daoReferenceName2a;
        if (!this.__daoReferenceName2aSet)
        {
            // daoReferenceName has no pre constraints
            daoReferenceName2a = handleGetDaoReferenceName();
            // daoReferenceName has no post constraints
            this.__daoReferenceName2a = daoReferenceName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__daoReferenceName2aSet = true;
            }
        }
        return daoReferenceName2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAssociationEndFacade#getDaoName()
    * @return String
    */
    protected abstract String handleGetDaoName();

    private String __daoName3a;
    private boolean __daoName3aSet = false;

    /**
     * 
     * @return (String)handleGetDaoName()
     */
    public final String getDaoName()
    {
        String daoName3a = this.__daoName3a;
        if (!this.__daoName3aSet)
        {
            // daoName has no pre constraints
            daoName3a = handleGetDaoName();
            // daoName has no post constraints
            this.__daoName3a = daoName3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__daoName3aSet = true;
            }
        }
        return daoName3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAssociationEndFacade#getDaoGetterName()
    * @return String
    */
    protected abstract String handleGetDaoGetterName();

    private String __daoGetterName4a;
    private boolean __daoGetterName4aSet = false;

    /**
     * 
     * @return (String)handleGetDaoGetterName()
     */
    public final String getDaoGetterName()
    {
        String daoGetterName4a = this.__daoGetterName4a;
        if (!this.__daoGetterName4aSet)
        {
            // daoGetterName has no pre constraints
            daoGetterName4a = handleGetDaoGetterName();
            // daoGetterName has no post constraints
            this.__daoGetterName4a = daoGetterName4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__daoGetterName4aSet = true;
            }
        }
        return daoGetterName4a;
    }

    /**
     * @return true
     * @see EJB3AssociationEndFacade
     */
    public boolean isEJB3AssociationEndFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ManageableEntityAssociationEnd
     */
    public boolean isManageableEntityAssociationEndMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.EntityAssociationEnd
     */
    public boolean isEntityAssociationEndMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see AssociationEndFacade
     */
    public boolean isAssociationEndFacadeMetaType()
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

    // ----------- delegates to ManageableEntityAssociationEnd ------------
    /**
     * 
     * @see ManageableEntityAssociationEnd#getManageableIdentifier()
     */
    public EntityAttribute getManageableIdentifier()
    {
        return this.getSuperManageableEntityAssociationEnd().getManageableIdentifier();
    }

    /**
     * Whether or not this association end should be displayed.
     * @see ManageableEntityAssociationEnd#isDisplay()
     */
    public boolean isDisplay()
    {
        return this.getSuperManageableEntityAssociationEnd().isDisplay();
    }

    // ----------- delegates to EJB3AssociationEndFacade ------------
    /**
     * Returns the default cascade property specified for UML aggregation.
     * @see EJB3AssociationEndFacade#getAggregationCascadeType()
     */
    public String getAggregationCascadeType()
    {
        return this.getSuperEJB3AssociationEndFacade().getAggregationCascadeType();
    }

    /**
     * Provides the cache policy for the entity association Collection.
     * Posible values are NONE, READ_WRITE, NONSTRICT_READ_WRITE, READ_ONLY, TRANSACTIONAL.
     * @see EJB3AssociationEndFacade#getCacheType()
     */
    public String getCacheType()
    {
        return this.getSuperEJB3AssociationEndFacade().getCacheType();
    }

    /**
     * Return the cascade type attributes as an array of this association end or null if no relevant
     * cascade attribute is found.
     * @see EJB3AssociationEndFacade#getCascadeType()
     */
    public String getCascadeType()
    {
        return this.getSuperEJB3AssociationEndFacade().getCascadeType();
    }

    /**
     * Returns the association end collection index name.
     * @see EJB3AssociationEndFacade#getCollectionIndexName()
     */
    public String getCollectionIndexName()
    {
        return this.getSuperEJB3AssociationEndFacade().getCollectionIndexName();
    }

    /**
     * this will only apply for Maps; it will return the type of the attribute specified on the
     * CollectionIndexName tagged value
     * @see EJB3AssociationEndFacade#getCollectionIndexType()
     */
    public String getCollectionIndexType()
    {
        return this.getSuperEJB3AssociationEndFacade().getCollectionIndexType();
    }

    /**
     * Returns the collection type defined on this association end using the
     * andromda_persistence_collection_type tagged value.
     * If undefined use the following strategy:
     * - If ordered collection type: return a list
     * - Otherwise, return the default association collection type.
     * @see EJB3AssociationEndFacade#getCollectionType()
     */
    public String getCollectionType()
    {
        return this.getSuperEJB3AssociationEndFacade().getCollectionType();
    }

    /**
     * The fully qualified class name of the collection implementation type.
     * @see EJB3AssociationEndFacade#getCollectionTypeImplemenationClass()
     */
    public String getCollectionTypeImplemenationClass()
    {
        return this.getSuperEJB3AssociationEndFacade().getCollectionTypeImplemenationClass();
    }

    /**
     * The actual implementation of the collection type.
     * @see EJB3AssociationEndFacade#getCollectionTypeImplementation()
     */
    public String getCollectionTypeImplementation()
    {
        return this.getSuperEJB3AssociationEndFacade().getCollectionTypeImplementation();
    }

    /**
     * The actual implementation of the collection type.
     * @see EJB3AssociationEndFacade#getCollectionTypeImplementation(String arg)
     */
    public String getCollectionTypeImplementation(String arg)
    {
        return this.getSuperEJB3AssociationEndFacade().getCollectionTypeImplementation(arg);
    }

    /**
     * Defines the column definition DDL used when creating table schema - use to override default
     * container DDL.
     * @see EJB3AssociationEndFacade#getColumnDefinition()
     */
    public String getColumnDefinition()
    {
        return this.getSuperEJB3AssociationEndFacade().getColumnDefinition();
    }

    /**
     * Returns the default cascade property specified for UML composition.
     * @see EJB3AssociationEndFacade#getCompositionCascadeType()
     */
    public String getCompositionCascadeType()
    {
        return this.getSuperEJB3AssociationEndFacade().getCompositionCascadeType();
    }

    /**
     * Returns the default collection interface from namespace descriptor.
     * @see EJB3AssociationEndFacade#getDefaultCollectionInterface()
     */
    public String getDefaultCollectionInterface()
    {
        return this.getSuperEJB3AssociationEndFacade().getDefaultCollectionInterface();
    }

    /**
     * Get the fetch type for this association end(CMR).
     * If no fetch type tagged value is specified and COMPOSITION_DEFINES_EAGER_LOADING is enabled,
     * then:
     * <ul><li>aggregation: lazy-loaded</li><li>composition: eager-loaded</li></ul>
     * Otherwise, the default fetch type for CMR of type One2Many and Many2Many is LAZY.
     * Default fetch type for CMR of type Many2One and One2One is EAGER.
     * This will return either EAGER or LAZY.
     * @see EJB3AssociationEndFacade#getFetchType()
     */
    public String getFetchType()
    {
        return this.getSuperEJB3AssociationEndFacade().getFetchType();
    }

    /**
     * Returns the name of the foreign key constraint to use for name property of
     * org.hibernate.annotations.ForeignKey annotation used for Many-To-One,
     * One-To-One and Many-To-Many relationships.
     * @see EJB3AssociationEndFacade#getForeignKeyConstraintName(String suffix)
     */
    public String getForeignKeyConstraintName(String suffix)
    {
        return this.getSuperEJB3AssociationEndFacade().getForeignKeyConstraintName(suffix);
    }

    /**
     * Returns the name of the foreign key to use for name property of JoinColumn/InverseJoinColumn
     * used in JoinTable for One-To-Many and Many-To-Many relationships.
     * @see EJB3AssociationEndFacade#getForeignKeyName(String suffix)
     */
    public String getForeignKeyName(String suffix)
    {
        return this.getSuperEJB3AssociationEndFacade().getForeignKeyName(suffix);
    }

    /**
     * Returns the getter name for the label name of the display attribute of the manageable entity.
     * @see EJB3AssociationEndFacade#getGetterLabelName()
     */
    public String getGetterLabelName()
    {
        return this.getSuperEJB3AssociationEndFacade().getGetterLabelName();
    }

    /**
     * Returns the Hibernate cascade attribute of this association end.
     * @see EJB3AssociationEndFacade#getHibernateCascadeType()
     */
    public String getHibernateCascadeType()
    {
        return this.getSuperEJB3AssociationEndFacade().getHibernateCascadeType();
    }

    /**
     * Returns the label name for the association end used as the display attribute for manageable
     * entities.
     * @see EJB3AssociationEndFacade#getLabelName()
     */
    public String getLabelName()
    {
        return this.getSuperEJB3AssociationEndFacade().getLabelName();
    }

    /**
     * The order by clause set to order the returning Collection object on the many side of an
     * association.
     * @see EJB3AssociationEndFacade#getOrderByClause()
     */
    public String getOrderByClause()
    {
        return this.getSuperEJB3AssociationEndFacade().getOrderByClause();
    }

    /**
     * Returns the setter name for the label name of the display attribute of the manageable entity.
     * @see EJB3AssociationEndFacade#getSetterLabelName()
     */
    public String getSetterLabelName()
    {
        return this.getSuperEJB3AssociationEndFacade().getSetterLabelName();
    }

    /**
     * Returns true if the tagged value with the specified name exists for the association end.
     * @see EJB3AssociationEndFacade#hasTaggedValue(String name)
     */
    public boolean hasTaggedValue(String name)
    {
        return this.getSuperEJB3AssociationEndFacade().hasTaggedValue(name);
    }

    /**
     * Returns true if association caching has been enabled via namespace property
     * hibernateEnableAssociationCache.
     * @see EJB3AssociationEndFacade#isAssociationCacheEnabled()
     */
    public boolean isAssociationCacheEnabled()
    {
        return this.getSuperEJB3AssociationEndFacade().isAssociationCacheEnabled();
    }

    /**
     * Returns true if the collection type is a collection.  This will only be the case if the
     * association end multiplicity is defined as ordered.
     * @see EJB3AssociationEndFacade#isCollection()
     */
    public boolean isCollection()
    {
        return this.getSuperEJB3AssociationEndFacade().isCollection();
    }

    /**
     * Returns true if the collection interface for this association end is java.util.SortedSet.
     * @see EJB3AssociationEndFacade#isCollectionInterfaceSortedSet()
     */
    public boolean isCollectionInterfaceSortedSet()
    {
        return this.getSuperEJB3AssociationEndFacade().isCollectionInterfaceSortedSet();
    }

    /**
     * Determine if the fetch type for this entity relationship end is eager loading.
     * @see EJB3AssociationEndFacade#isEager()
     */
    public boolean isEager()
    {
        return this.getSuperEJB3AssociationEndFacade().isEager();
    }

    /**
     * Returns true if a foreign key constraint has been defined explicityly by the user.  Otherwise
     * returns false.  This will determine if the ForeignKey annotation will be rendered.  We
     * require this because there is no clean way of defining the constraint name for all
     * constraints as there may be a chance that two constraints may have the same name. This
     * vilates the database integrity.
     * @see EJB3AssociationEndFacade#isForeignKeyConstraintDefined()
     */
    public boolean isForeignKeyConstraintDefined()
    {
        return this.getSuperEJB3AssociationEndFacade().isForeignKeyConstraintDefined();
    }

    /**
     * Returns true if a Hibernate cascade attribute is defined for this association end.
     * @see EJB3AssociationEndFacade#isHibernateCascadeExists()
     */
    public boolean isHibernateCascadeExists()
    {
        return this.getSuperEJB3AssociationEndFacade().isHibernateCascadeExists();
    }

    /**
     * Determine if the fetch type for this entity relationship end is lazy loading.
     * @see EJB3AssociationEndFacade#isLazy()
     */
    public boolean isLazy()
    {
        return this.getSuperEJB3AssociationEndFacade().isLazy();
    }

    /**
     * Returns true if the collection type is a list.  This will only be the case if the association
     * end multiplicity is defined as ordered.
     * @see EJB3AssociationEndFacade#isList()
     */
    public boolean isList()
    {
        return this.getSuperEJB3AssociationEndFacade().isList();
    }

    /**
     * Returns true if the collection type is a map.  This will only be the case if the association
     * end multiplicity is defined as unordered.
     * @see EJB3AssociationEndFacade#isMap()
     */
    public boolean isMap()
    {
        return this.getSuperEJB3AssociationEndFacade().isMap();
    }

    /**
     * Sets the optional attribute on the annotation to determine if a null value is allowed.  If
     * set to false, non-null relationships must always exist.  If the andromda_persistence_optional
     * tag is set, then use the tagged value, otherwise determine if null value is allowed by way of
     * multiplicity on the association end.
     * @see EJB3AssociationEndFacade#isOptional()
     */
    public boolean isOptional()
    {
        return this.getSuperEJB3AssociationEndFacade().isOptional();
    }

    /**
     * Determines if this association end if the owning side.  Used in one-to-one and many-to-many
     * relationships.
     * @see EJB3AssociationEndFacade#isOwning()
     */
    public boolean isOwning()
    {
        return this.getSuperEJB3AssociationEndFacade().isOwning();
    }

    /**
     * Returns true if the collection type is a set.  This will only be the case if the association
     * end multiplicity is defined as unordered.
     * @see EJB3AssociationEndFacade#isSet()
     */
    public boolean isSet()
    {
        return this.getSuperEJB3AssociationEndFacade().isSet();
    }

    /**
     * A name suitable for use when adding new elements to this association end in programming code.
     * @see AssociationEndFacade#getAdderName()
     */
    public String getAdderName()
    {
        return this.getSuperEJB3AssociationEndFacade().getAdderName();
    }

    /**
     * Returns the value of the 'Aggregation' attribute (none, shared, composite). The default value
     * is "none". The literals are from the enumeration org.eclipse.uml2.uml.AggregationKind.
     * Specifies the kind of aggregation that applies to the Property.
     * @see AssociationEndFacade#getAggregationKind()
     */
    public String getAggregationKind()
    {
        return this.getSuperEJB3AssociationEndFacade().getAggregationKind();
    }

    /**
     * The association owning this association end.
     * @see AssociationEndFacade#getAssociation()
     */
    public AssociationFacade getAssociation()
    {
        return this.getSuperEJB3AssociationEndFacade().getAssociation();
    }

    /**
     * UML2: Returns the value of the 'Default' attribute. Specifies a String that represents a
     * value to be used when no argument is supplied for the Property. A String that is evaluated to
     * give a default value for the Property when an object of the owning Classifier is
     * instantiated.  Can be something like: new ValueObject(values);
     * @see AssociationEndFacade#getDefault()
     */
    public String getDefault()
    {
        return this.getSuperEJB3AssociationEndFacade().getDefault();
    }

    /**
     * A name suitable for use when accessing this association end in programming code.
     * @see AssociationEndFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperEJB3AssociationEndFacade().getGetterName();
    }

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @see AssociationEndFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperEJB3AssociationEndFacade().getGetterSetterTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see AssociationEndFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperEJB3AssociationEndFacade().getLower();
    }

    /**
     * The other association end owned by this end's association.
     * @see AssociationEndFacade#getOtherEnd()
     */
    public AssociationEndFacade getOtherEnd()
    {
        return this.getSuperEJB3AssociationEndFacade().getOtherEnd();
    }

    /**
     * A name suitable for use when removing element from this association end in programming code.
     * @see AssociationEndFacade#getRemoverName()
     */
    public String getRemoverName()
    {
        return this.getSuperEJB3AssociationEndFacade().getRemoverName();
    }

    /**
     * A name suitable for use when accessing this association end in programming code.
     * @see AssociationEndFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperEJB3AssociationEndFacade().getSetterName();
    }

    /**
     * The classifier attached to this association end.
     * @see AssociationEndFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperEJB3AssociationEndFacade().getType();
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see AssociationEndFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperEJB3AssociationEndFacade().getUpper();
    }

    /**
     * True if this association end represents an aggregation relationship.
     * @see AssociationEndFacade#isAggregation()
     */
    public boolean isAggregation()
    {
        return this.getSuperEJB3AssociationEndFacade().isAggregation();
    }

    /**
     * Is true if update of one side of the association should also update the other side. false if
     * not.
     * @see AssociationEndFacade#isBidirectional()
     */
    public boolean isBidirectional()
    {
        return this.getSuperEJB3AssociationEndFacade().isBidirectional();
    }

    /**
     * Returns whether or not (true/false) this association end is the child end of the assocation
     * (i.e. the other end's aggregation is composition).
     * @see AssociationEndFacade#isChild()
     */
    public boolean isChild()
    {
        return this.getSuperEJB3AssociationEndFacade().isChild();
    }

    /**
     * True if this association end represents a composition relationship.
     * @see AssociationEndFacade#isComposition()
     */
    public boolean isComposition()
    {
        return this.getSuperEJB3AssociationEndFacade().isComposition();
    }

    /**
     * If the association end is derived (its value is computed). UML2 only. UML14 always returns
     * false. Default=false.
     * @see AssociationEndFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperEJB3AssociationEndFacade().isDerived();
    }

    /**
     * IsLeaf property in the association end property. If true, attribute is final, cannot be
     * extended or implemented by a descendant. Default=false.
     * @see AssociationEndFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEJB3AssociationEndFacade().isLeaf();
    }

    /**
     * True if this association end's multiplicity is greater than one.
     * @see AssociationEndFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperEJB3AssociationEndFacade().isMany();
    }

    /**
     * True if this association end's and the other end's multiplicities are both many.
     * @see AssociationEndFacade#isMany2Many()
     */
    public boolean isMany2Many()
    {
        return this.getSuperEJB3AssociationEndFacade().isMany2Many();
    }

    /**
     * True if this association end's multiplicity is many while the other end's is one.
     * @see AssociationEndFacade#isMany2One()
     */
    public boolean isMany2One()
    {
        return this.getSuperEJB3AssociationEndFacade().isMany2One();
    }

    /**
     * True if it is possible to navigate from the other end to this association end .
     * @see AssociationEndFacade#isNavigable()
     */
    public boolean isNavigable()
    {
        return this.getSuperEJB3AssociationEndFacade().isNavigable();
    }

    /**
     * True if this association end's multiplicity is one while the other end's is many.
     * @see AssociationEndFacade#isOne2Many()
     */
    public boolean isOne2Many()
    {
        return this.getSuperEJB3AssociationEndFacade().isOne2Many();
    }

    /**
     * True if this association end's and the other end's multiplicities are both one.
     * @see AssociationEndFacade#isOne2One()
     */
    public boolean isOne2One()
    {
        return this.getSuperEJB3AssociationEndFacade().isOne2One();
    }

    /**
     * Indicates whether or not the association ends are ordered (if multiplicity is greater than
     * 1).
     * @see AssociationEndFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperEJB3AssociationEndFacade().isOrdered();
    }

    /**
     * True if the association end cannot be changed.
     * @see AssociationEndFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperEJB3AssociationEndFacade().isReadOnly();
    }

    /**
     * True if this association end's multiplicity is strictly greater than zero.
     * @see AssociationEndFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperEJB3AssociationEndFacade().isRequired();
    }

    /**
     * UML2: If the association attribute is unique within the Collection type. UML14 always returns
     * false. Unique+Ordered determines the implementation Collection type. Default=false.
     * @see AssociationEndFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperEJB3AssociationEndFacade().isUnique();
    }

    /**
     * The name of the index to create on a column that persists the foreign key attribute.
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#getColumnIndex()
     */
    public String getColumnIndex()
    {
        return this.getSuperEJB3AssociationEndFacade().getColumnIndex();
    }

    /**
     * The name of the column that makes up the foreign key.
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#getColumnName()
     */
    public String getColumnName()
    {
        return this.getSuperEJB3AssociationEndFacade().getColumnName();
    }

    /**
     * The name of the foreign key constraint to use for databases.
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#getForeignKeyConstraintName()
     */
    public String getForeignKeyConstraintName()
    {
        return this.getSuperEJB3AssociationEndFacade().getForeignKeyConstraintName();
    }

    /**
     * The current foreign key suffix specified for this entity association end facade.
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#getForeignKeySuffix()
     */
    public String getForeignKeySuffix()
    {
        return this.getSuperEJB3AssociationEndFacade().getForeignKeySuffix();
    }

    /**
     * The SQL type for this the foreign key column of this association end.
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#getSqlType()
     */
    public String getSqlType()
    {
        return this.getSuperEJB3AssociationEndFacade().getSqlType();
    }

    /**
     * The name of the unique-key that this unique association end belongs
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#getUniqueGroup()
     */
    public String getUniqueGroup()
    {
        return this.getSuperEJB3AssociationEndFacade().getUniqueGroup();
    }

    /**
     * Indicates whether or not a foreign identifier should be used for the entity that owns this
     * association end.  This would only make sense in the case of a child in a one-to-one
     * parent-child association.  If this flag is true, then the identifier of this entity should
     * also be used as the foreign key to the related parent entity.
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#isForeignIdentifier()
     */
    public boolean isForeignIdentifier()
    {
        return this.getSuperEJB3AssociationEndFacade().isForeignIdentifier();
    }

    /**
     * True if the associationEnd is marked with identifiers stereotype, false otherwise.
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#isIdentifiersPresent()
     */
    public boolean isIdentifiersPresent()
    {
        return this.getSuperEJB3AssociationEndFacade().isIdentifiersPresent();
    }

    /**
     * Indicates this association end should be ignored by the persistence layer.
     * @see org.andromda.metafacades.uml.EntityAssociationEnd#isTransient()
     */
    public boolean isTransient()
    {
        return this.getSuperEJB3AssociationEndFacade().isTransient();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEJB3AssociationEndFacade().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEJB3AssociationEndFacade().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperEJB3AssociationEndFacade().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEJB3AssociationEndFacade().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEJB3AssociationEndFacade().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperEJB3AssociationEndFacade().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEJB3AssociationEndFacade().getDocumentation(indent);
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
        return this.getSuperEJB3AssociationEndFacade().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEJB3AssociationEndFacade().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEJB3AssociationEndFacade().getFullyQualifiedName();
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
        return this.getSuperEJB3AssociationEndFacade().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEJB3AssociationEndFacade().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEJB3AssociationEndFacade().getId();
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
        return this.getSuperEJB3AssociationEndFacade().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEJB3AssociationEndFacade().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEJB3AssociationEndFacade().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEJB3AssociationEndFacade().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEJB3AssociationEndFacade().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEJB3AssociationEndFacade().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEJB3AssociationEndFacade().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEJB3AssociationEndFacade().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEJB3AssociationEndFacade().getPackagePath();
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
        return this.getSuperEJB3AssociationEndFacade().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEJB3AssociationEndFacade().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEJB3AssociationEndFacade().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEJB3AssociationEndFacade().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEJB3AssociationEndFacade().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEJB3AssociationEndFacade().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEJB3AssociationEndFacade().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEJB3AssociationEndFacade().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEJB3AssociationEndFacade().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEJB3AssociationEndFacade().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEJB3AssociationEndFacade().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEJB3AssociationEndFacade().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEJB3AssociationEndFacade().hasKeyword(keywordName);
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
        return this.getSuperEJB3AssociationEndFacade().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEJB3AssociationEndFacade().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEJB3AssociationEndFacade().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEJB3AssociationEndFacade().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEJB3AssociationEndFacade().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEJB3AssociationEndFacade().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEJB3AssociationEndFacade().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEJB3AssociationEndFacade().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEJB3AssociationEndFacade().translateConstraints(kind, translation);
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperManageableEntityAssociationEnd().initialize();
        this.getSuperEJB3AssociationEndFacade().initialize();
    }

    /**
     * @return Object getSuperManageableEntityAssociationEnd().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperManageableEntityAssociationEnd().getValidationOwner();
        if (owner == null)
        {
            owner = this.getSuperEJB3AssociationEndFacade().getValidationOwner();
        }
        return owner;
    }

    /**
     * @return String getSuperManageableEntityAssociationEnd().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperManageableEntityAssociationEnd().getValidationName();
        if (name == null)
        {
            name = this.getSuperEJB3AssociationEndFacade().getValidationName();
        }
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperManageableEntityAssociationEnd().validateInvariants(validationMessages);
        this.getSuperEJB3AssociationEndFacade().validateInvariants(validationMessages);
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