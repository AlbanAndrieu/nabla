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
import org.andromda.metafacades.uml.EntityAssociationEnd;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * Represents an EJB association end.
 * MetafacadeLogic for EJB3AssociationEndFacade
 *
 * @see EJB3AssociationEndFacade
 */
public abstract class EJB3AssociationEndFacadeLogic
    extends MetafacadeBase
    implements EJB3AssociationEndFacade
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
    protected EJB3AssociationEndFacadeLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superEntityAssociationEnd =
           (EntityAssociationEnd)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.EntityAssociationEnd",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3AssociationEndFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade";
        }
        return context;
    }

    private EntityAssociationEnd superEntityAssociationEnd;
    private boolean superEntityAssociationEndInitialized = false;

    /**
     * Gets the EntityAssociationEnd parent instance.
     * @return this.superEntityAssociationEnd EntityAssociationEnd
     */
    private EntityAssociationEnd getSuperEntityAssociationEnd()
    {
        if (!this.superEntityAssociationEndInitialized)
        {
            ((MetafacadeBase)this.superEntityAssociationEnd).setMetafacadeContext(this.getMetafacadeContext());
            this.superEntityAssociationEndInitialized = true;
        }
        return this.superEntityAssociationEnd;
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
            if (this.superEntityAssociationEndInitialized)
            {
                ((MetafacadeBase)this.superEntityAssociationEnd).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3AssociationEndFacade
     */
    public boolean isEJB3AssociationEndFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getFetchType()
    * @return String
    */
    protected abstract String handleGetFetchType();

    private String __fetchType1a;
    private boolean __fetchType1aSet = false;

    /**
     * Get the fetch type for this association end(CMR).
     * If no fetch type tagged value is specified and COMPOSITION_DEFINES_EAGER_LOADING is enabled,
     * then:
     * <ul><li>aggregation: lazy-loaded</li><li>composition: eager-loaded</li></ul>
     * Otherwise, the default fetch type for CMR of type One2Many and Many2Many is LAZY.
     * Default fetch type for CMR of type Many2One and One2One is EAGER.
     * This will return either EAGER or LAZY.
     * @return (String)handleGetFetchType()
     */
    public final String getFetchType()
    {
        String fetchType1a = this.__fetchType1a;
        if (!this.__fetchType1aSet)
        {
            // fetchType has no pre constraints
            fetchType1a = handleGetFetchType();
            // fetchType has no post constraints
            this.__fetchType1a = fetchType1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fetchType1aSet = true;
            }
        }
        return fetchType1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isOwning()
    * @return boolean
    */
    protected abstract boolean handleIsOwning();

    private boolean __owning2a;
    private boolean __owning2aSet = false;

    /**
     * Determines if this association end if the owning side.  Used in one-to-one and many-to-many
     * relationships.
     * @return (boolean)handleIsOwning()
     */
    public final boolean isOwning()
    {
        boolean owning2a = this.__owning2a;
        if (!this.__owning2aSet)
        {
            // owning has no pre constraints
            owning2a = handleIsOwning();
            // owning has no post constraints
            this.__owning2a = owning2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__owning2aSet = true;
            }
        }
        return owning2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isOptional()
    * @return boolean
    */
    protected abstract boolean handleIsOptional();

    private boolean __optional3a;
    private boolean __optional3aSet = false;

    /**
     * Sets the optional attribute on the annotation to determine if a null value is allowed.  If
     * set to false, non-null relationships must always exist.  If the andromda_persistence_optional
     * tag is set, then use the tagged value, otherwise determine if null value is allowed by way of
     * multiplicity on the association end.
     * @return (boolean)handleIsOptional()
     */
    public final boolean isOptional()
    {
        boolean optional3a = this.__optional3a;
        if (!this.__optional3aSet)
        {
            // optional has no pre constraints
            optional3a = handleIsOptional();
            // optional has no post constraints
            this.__optional3a = optional3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__optional3aSet = true;
            }
        }
        return optional3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getOrderByClause()
    * @return String
    */
    protected abstract String handleGetOrderByClause();

    private String __orderByClause4a;
    private boolean __orderByClause4aSet = false;

    /**
     * The order by clause set to order the returning Collection object on the many side of an
     * association.
     * @return (String)handleGetOrderByClause()
     */
    public final String getOrderByClause()
    {
        String orderByClause4a = this.__orderByClause4a;
        if (!this.__orderByClause4aSet)
        {
            // orderByClause has no pre constraints
            orderByClause4a = handleGetOrderByClause();
            // orderByClause has no post constraints
            this.__orderByClause4a = orderByClause4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__orderByClause4aSet = true;
            }
        }
        return orderByClause4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getColumnDefinition()
    * @return String
    */
    protected abstract String handleGetColumnDefinition();

    private String __columnDefinition5a;
    private boolean __columnDefinition5aSet = false;

    /**
     * Defines the column definition DDL used when creating table schema - use to override default
     * container DDL.
     * @return (String)handleGetColumnDefinition()
     */
    public final String getColumnDefinition()
    {
        String columnDefinition5a = this.__columnDefinition5a;
        if (!this.__columnDefinition5aSet)
        {
            // columnDefinition has no pre constraints
            columnDefinition5a = handleGetColumnDefinition();
            // columnDefinition has no post constraints
            this.__columnDefinition5a = columnDefinition5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__columnDefinition5aSet = true;
            }
        }
        return columnDefinition5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isEager()
    * @return boolean
    */
    protected abstract boolean handleIsEager();

    private boolean __eager6a;
    private boolean __eager6aSet = false;

    /**
     * Determine if the fetch type for this entity relationship end is eager loading.
     * @return (boolean)handleIsEager()
     */
    public final boolean isEager()
    {
        boolean eager6a = this.__eager6a;
        if (!this.__eager6aSet)
        {
            // eager has no pre constraints
            eager6a = handleIsEager();
            // eager has no post constraints
            this.__eager6a = eager6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__eager6aSet = true;
            }
        }
        return eager6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isLazy()
    * @return boolean
    */
    protected abstract boolean handleIsLazy();

    private boolean __lazy7a;
    private boolean __lazy7aSet = false;

    /**
     * Determine if the fetch type for this entity relationship end is lazy loading.
     * @return (boolean)handleIsLazy()
     */
    public final boolean isLazy()
    {
        boolean lazy7a = this.__lazy7a;
        if (!this.__lazy7aSet)
        {
            // lazy has no pre constraints
            lazy7a = handleIsLazy();
            // lazy has no post constraints
            this.__lazy7a = lazy7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__lazy7aSet = true;
            }
        }
        return lazy7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getCascadeType()
    * @return String
    */
    protected abstract String handleGetCascadeType();

    private String __cascadeType8a;
    private boolean __cascadeType8aSet = false;

    /**
     * Return the cascade type attributes as an array of this association end or null if no relevant
     * cascade attribute is found.
     * @return (String)handleGetCascadeType()
     */
    public final String getCascadeType()
    {
        String cascadeType8a = this.__cascadeType8a;
        if (!this.__cascadeType8aSet)
        {
            // cascadeType has no pre constraints
            cascadeType8a = handleGetCascadeType();
            // cascadeType has no post constraints
            this.__cascadeType8a = cascadeType8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__cascadeType8aSet = true;
            }
        }
        return cascadeType8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getCompositionCascadeType()
    * @return String
    */
    protected abstract String handleGetCompositionCascadeType();

    private String __compositionCascadeType9a;
    private boolean __compositionCascadeType9aSet = false;

    /**
     * Returns the default cascade property specified for UML composition.
     * @return (String)handleGetCompositionCascadeType()
     */
    public final String getCompositionCascadeType()
    {
        String compositionCascadeType9a = this.__compositionCascadeType9a;
        if (!this.__compositionCascadeType9aSet)
        {
            // compositionCascadeType has no pre constraints
            compositionCascadeType9a = handleGetCompositionCascadeType();
            // compositionCascadeType has no post constraints
            this.__compositionCascadeType9a = compositionCascadeType9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__compositionCascadeType9aSet = true;
            }
        }
        return compositionCascadeType9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getAggregationCascadeType()
    * @return String
    */
    protected abstract String handleGetAggregationCascadeType();

    private String __aggregationCascadeType10a;
    private boolean __aggregationCascadeType10aSet = false;

    /**
     * Returns the default cascade property specified for UML aggregation.
     * @return (String)handleGetAggregationCascadeType()
     */
    public final String getAggregationCascadeType()
    {
        String aggregationCascadeType10a = this.__aggregationCascadeType10a;
        if (!this.__aggregationCascadeType10aSet)
        {
            // aggregationCascadeType has no pre constraints
            aggregationCascadeType10a = handleGetAggregationCascadeType();
            // aggregationCascadeType has no post constraints
            this.__aggregationCascadeType10a = aggregationCascadeType10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__aggregationCascadeType10aSet = true;
            }
        }
        return aggregationCascadeType10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getCollectionType()
    * @return String
    */
    protected abstract String handleGetCollectionType();

    private String __collectionType11a;
    private boolean __collectionType11aSet = false;

    /**
     * Returns the collection type defined on this association end using the
     * andromda_persistence_collection_type tagged value.
     * If undefined use the following strategy:
     * - If ordered collection type: return a list
     * - Otherwise, return the default association collection type.
     * @return (String)handleGetCollectionType()
     */
    public final String getCollectionType()
    {
        String collectionType11a = this.__collectionType11a;
        if (!this.__collectionType11aSet)
        {
            // collectionType has no pre constraints
            collectionType11a = handleGetCollectionType();
            // collectionType has no post constraints
            this.__collectionType11a = collectionType11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__collectionType11aSet = true;
            }
        }
        return collectionType11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isMap()
    * @return boolean
    */
    protected abstract boolean handleIsMap();

    private boolean __map12a;
    private boolean __map12aSet = false;

    /**
     * Returns true if the collection type is a map.  This will only be the case if the association
     * end multiplicity is defined as unordered.
     * @return (boolean)handleIsMap()
     */
    public final boolean isMap()
    {
        boolean map12a = this.__map12a;
        if (!this.__map12aSet)
        {
            // map has no pre constraints
            map12a = handleIsMap();
            // map has no post constraints
            this.__map12a = map12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__map12aSet = true;
            }
        }
        return map12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isList()
    * @return boolean
    */
    protected abstract boolean handleIsList();

    private boolean __list13a;
    private boolean __list13aSet = false;

    /**
     * Returns true if the collection type is a list.  This will only be the case if the association
     * end multiplicity is defined as ordered.
     * @return (boolean)handleIsList()
     */
    public final boolean isList()
    {
        boolean list13a = this.__list13a;
        if (!this.__list13aSet)
        {
            // list has no pre constraints
            list13a = handleIsList();
            // list has no post constraints
            this.__list13a = list13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__list13aSet = true;
            }
        }
        return list13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isSet()
    * @return boolean
    */
    protected abstract boolean handleIsSet();

    private boolean __set14a;
    private boolean __set14aSet = false;

    /**
     * Returns true if the collection type is a set.  This will only be the case if the association
     * end multiplicity is defined as unordered.
     * @return (boolean)handleIsSet()
     */
    public final boolean isSet()
    {
        boolean set14a = this.__set14a;
        if (!this.__set14aSet)
        {
            // set has no pre constraints
            set14a = handleIsSet();
            // set has no post constraints
            this.__set14a = set14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__set14aSet = true;
            }
        }
        return set14a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getLabelName()
    * @return String
    */
    protected abstract String handleGetLabelName();

    private String __labelName15a;
    private boolean __labelName15aSet = false;

    /**
     * Returns the label name for the association end used as the display attribute for manageable
     * entities.
     * @return (String)handleGetLabelName()
     */
    public final String getLabelName()
    {
        String labelName15a = this.__labelName15a;
        if (!this.__labelName15aSet)
        {
            // labelName has no pre constraints
            labelName15a = handleGetLabelName();
            // labelName has no post constraints
            this.__labelName15a = labelName15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__labelName15aSet = true;
            }
        }
        return labelName15a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getGetterLabelName()
    * @return String
    */
    protected abstract String handleGetGetterLabelName();

    private String __getterLabelName16a;
    private boolean __getterLabelName16aSet = false;

    /**
     * Returns the getter name for the label name of the display attribute of the manageable entity.
     * @return (String)handleGetGetterLabelName()
     */
    public final String getGetterLabelName()
    {
        String getterLabelName16a = this.__getterLabelName16a;
        if (!this.__getterLabelName16aSet)
        {
            // getterLabelName has no pre constraints
            getterLabelName16a = handleGetGetterLabelName();
            // getterLabelName has no post constraints
            this.__getterLabelName16a = getterLabelName16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getterLabelName16aSet = true;
            }
        }
        return getterLabelName16a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getSetterLabelName()
    * @return String
    */
    protected abstract String handleGetSetterLabelName();

    private String __setterLabelName17a;
    private boolean __setterLabelName17aSet = false;

    /**
     * Returns the setter name for the label name of the display attribute of the manageable entity.
     * @return (String)handleGetSetterLabelName()
     */
    public final String getSetterLabelName()
    {
        String setterLabelName17a = this.__setterLabelName17a;
        if (!this.__setterLabelName17aSet)
        {
            // setterLabelName has no pre constraints
            setterLabelName17a = handleGetSetterLabelName();
            // setterLabelName has no post constraints
            this.__setterLabelName17a = setterLabelName17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__setterLabelName17aSet = true;
            }
        }
        return setterLabelName17a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getCacheType()
    * @return String
    */
    protected abstract String handleGetCacheType();

    private String __cacheType18a;
    private boolean __cacheType18aSet = false;

    /**
     * Provides the cache policy for the entity association Collection.
     * Posible values are NONE, READ_WRITE, NONSTRICT_READ_WRITE, READ_ONLY, TRANSACTIONAL.
     * @return (String)handleGetCacheType()
     */
    public final String getCacheType()
    {
        String cacheType18a = this.__cacheType18a;
        if (!this.__cacheType18aSet)
        {
            // cacheType has no pre constraints
            cacheType18a = handleGetCacheType();
            // cacheType has no post constraints
            this.__cacheType18a = cacheType18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__cacheType18aSet = true;
            }
        }
        return cacheType18a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isAssociationCacheEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsAssociationCacheEnabled();

    private boolean __associationCacheEnabled19a;
    private boolean __associationCacheEnabled19aSet = false;

    /**
     * Returns true if association caching has been enabled via namespace property
     * hibernateEnableAssociationCache.
     * @return (boolean)handleIsAssociationCacheEnabled()
     */
    public final boolean isAssociationCacheEnabled()
    {
        boolean associationCacheEnabled19a = this.__associationCacheEnabled19a;
        if (!this.__associationCacheEnabled19aSet)
        {
            // associationCacheEnabled has no pre constraints
            associationCacheEnabled19a = handleIsAssociationCacheEnabled();
            // associationCacheEnabled has no post constraints
            this.__associationCacheEnabled19a = associationCacheEnabled19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__associationCacheEnabled19aSet = true;
            }
        }
        return associationCacheEnabled19a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getCollectionTypeImplementation()
    * @return String
    */
    protected abstract String handleGetCollectionTypeImplementation();

    private String __collectionTypeImplementation20a;
    private boolean __collectionTypeImplementation20aSet = false;

    /**
     * The actual implementation of the collection type.
     * @return (String)handleGetCollectionTypeImplementation()
     */
    public final String getCollectionTypeImplementation()
    {
        String collectionTypeImplementation20a = this.__collectionTypeImplementation20a;
        if (!this.__collectionTypeImplementation20aSet)
        {
            // collectionTypeImplementation has no pre constraints
            collectionTypeImplementation20a = handleGetCollectionTypeImplementation();
            // collectionTypeImplementation has no post constraints
            this.__collectionTypeImplementation20a = collectionTypeImplementation20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__collectionTypeImplementation20aSet = true;
            }
        }
        return collectionTypeImplementation20a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isCollection()
    * @return boolean
    */
    protected abstract boolean handleIsCollection();

    private boolean __collection21a;
    private boolean __collection21aSet = false;

    /**
     * Returns true if the collection type is a collection.  This will only be the case if the
     * association end multiplicity is defined as ordered.
     * @return (boolean)handleIsCollection()
     */
    public final boolean isCollection()
    {
        boolean collection21a = this.__collection21a;
        if (!this.__collection21aSet)
        {
            // collection has no pre constraints
            collection21a = handleIsCollection();
            // collection has no post constraints
            this.__collection21a = collection21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__collection21aSet = true;
            }
        }
        return collection21a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getCollectionIndexType()
    * @return String
    */
    protected abstract String handleGetCollectionIndexType();

    private String __collectionIndexType22a;
    private boolean __collectionIndexType22aSet = false;

    /**
     * this will only apply for Maps; it will return the type of the attribute specified on the
     * CollectionIndexName tagged value
     * @return (String)handleGetCollectionIndexType()
     */
    public final String getCollectionIndexType()
    {
        String collectionIndexType22a = this.__collectionIndexType22a;
        if (!this.__collectionIndexType22aSet)
        {
            // collectionIndexType has no pre constraints
            collectionIndexType22a = handleGetCollectionIndexType();
            // collectionIndexType has no post constraints
            this.__collectionIndexType22a = collectionIndexType22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__collectionIndexType22aSet = true;
            }
        }
        return collectionIndexType22a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getCollectionIndexName()
    * @return String
    */
    protected abstract String handleGetCollectionIndexName();

    private String __collectionIndexName23a;
    private boolean __collectionIndexName23aSet = false;

    /**
     * Returns the association end collection index name.
     * @return (String)handleGetCollectionIndexName()
     */
    public final String getCollectionIndexName()
    {
        String collectionIndexName23a = this.__collectionIndexName23a;
        if (!this.__collectionIndexName23aSet)
        {
            // collectionIndexName has no pre constraints
            collectionIndexName23a = handleGetCollectionIndexName();
            // collectionIndexName has no post constraints
            this.__collectionIndexName23a = collectionIndexName23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__collectionIndexName23aSet = true;
            }
        }
        return collectionIndexName23a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getDefaultCollectionInterface()
    * @return String
    */
    protected abstract String handleGetDefaultCollectionInterface();

    private String __defaultCollectionInterface24a;
    private boolean __defaultCollectionInterface24aSet = false;

    /**
     * Returns the default collection interface from namespace descriptor.
     * @return (String)handleGetDefaultCollectionInterface()
     */
    public final String getDefaultCollectionInterface()
    {
        String defaultCollectionInterface24a = this.__defaultCollectionInterface24a;
        if (!this.__defaultCollectionInterface24aSet)
        {
            // defaultCollectionInterface has no pre constraints
            defaultCollectionInterface24a = handleGetDefaultCollectionInterface();
            // defaultCollectionInterface has no post constraints
            this.__defaultCollectionInterface24a = defaultCollectionInterface24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__defaultCollectionInterface24aSet = true;
            }
        }
        return defaultCollectionInterface24a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isCollectionInterfaceSortedSet()
    * @return boolean
    */
    protected abstract boolean handleIsCollectionInterfaceSortedSet();

    private boolean __collectionInterfaceSortedSet25a;
    private boolean __collectionInterfaceSortedSet25aSet = false;

    /**
     * Returns true if the collection interface for this association end is java.util.SortedSet.
     * @return (boolean)handleIsCollectionInterfaceSortedSet()
     */
    public final boolean isCollectionInterfaceSortedSet()
    {
        boolean collectionInterfaceSortedSet25a = this.__collectionInterfaceSortedSet25a;
        if (!this.__collectionInterfaceSortedSet25aSet)
        {
            // collectionInterfaceSortedSet has no pre constraints
            collectionInterfaceSortedSet25a = handleIsCollectionInterfaceSortedSet();
            // collectionInterfaceSortedSet has no post constraints
            this.__collectionInterfaceSortedSet25a = collectionInterfaceSortedSet25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__collectionInterfaceSortedSet25aSet = true;
            }
        }
        return collectionInterfaceSortedSet25a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getCollectionTypeImplemenationClass()
    * @return String
    */
    protected abstract String handleGetCollectionTypeImplemenationClass();

    private String __collectionTypeImplemenationClass26a;
    private boolean __collectionTypeImplemenationClass26aSet = false;

    /**
     * The fully qualified class name of the collection implementation type.
     * @return (String)handleGetCollectionTypeImplemenationClass()
     */
    public final String getCollectionTypeImplemenationClass()
    {
        String collectionTypeImplemenationClass26a = this.__collectionTypeImplemenationClass26a;
        if (!this.__collectionTypeImplemenationClass26aSet)
        {
            // collectionTypeImplemenationClass has no pre constraints
            collectionTypeImplemenationClass26a = handleGetCollectionTypeImplemenationClass();
            // collectionTypeImplemenationClass has no post constraints
            this.__collectionTypeImplemenationClass26a = collectionTypeImplemenationClass26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__collectionTypeImplemenationClass26aSet = true;
            }
        }
        return collectionTypeImplemenationClass26a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#getHibernateCascadeType()
    * @return String
    */
    protected abstract String handleGetHibernateCascadeType();

    private String __hibernateCascadeType27a;
    private boolean __hibernateCascadeType27aSet = false;

    /**
     * Returns the Hibernate cascade attribute of this association end.
     * @return (String)handleGetHibernateCascadeType()
     */
    public final String getHibernateCascadeType()
    {
        String hibernateCascadeType27a = this.__hibernateCascadeType27a;
        if (!this.__hibernateCascadeType27aSet)
        {
            // hibernateCascadeType has no pre constraints
            hibernateCascadeType27a = handleGetHibernateCascadeType();
            // hibernateCascadeType has no post constraints
            this.__hibernateCascadeType27a = hibernateCascadeType27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hibernateCascadeType27aSet = true;
            }
        }
        return hibernateCascadeType27a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isHibernateCascadeExists()
    * @return boolean
    */
    protected abstract boolean handleIsHibernateCascadeExists();

    private boolean __hibernateCascadeExists28a;
    private boolean __hibernateCascadeExists28aSet = false;

    /**
     * Returns true if a Hibernate cascade attribute is defined for this association end.
     * @return (boolean)handleIsHibernateCascadeExists()
     */
    public final boolean isHibernateCascadeExists()
    {
        boolean hibernateCascadeExists28a = this.__hibernateCascadeExists28a;
        if (!this.__hibernateCascadeExists28aSet)
        {
            // hibernateCascadeExists has no pre constraints
            hibernateCascadeExists28a = handleIsHibernateCascadeExists();
            // hibernateCascadeExists has no post constraints
            this.__hibernateCascadeExists28a = hibernateCascadeExists28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hibernateCascadeExists28aSet = true;
            }
        }
        return hibernateCascadeExists28a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3AssociationEndFacade#isForeignKeyConstraintDefined()
    * @return boolean
    */
    protected abstract boolean handleIsForeignKeyConstraintDefined();

    private boolean __foreignKeyConstraintDefined29a;
    private boolean __foreignKeyConstraintDefined29aSet = false;

    /**
     * Returns true if a foreign key constraint has been defined explicityly by the user.  Otherwise
     * returns false.  This will determine if the ForeignKey annotation will be rendered.  We
     * require this because there is no clean way of defining the constraint name for all
     * constraints as there may be a chance that two constraints may have the same name. This
     * vilates the database integrity.
     * @return (boolean)handleIsForeignKeyConstraintDefined()
     */
    public final boolean isForeignKeyConstraintDefined()
    {
        boolean foreignKeyConstraintDefined29a = this.__foreignKeyConstraintDefined29a;
        if (!this.__foreignKeyConstraintDefined29aSet)
        {
            // foreignKeyConstraintDefined has no pre constraints
            foreignKeyConstraintDefined29a = handleIsForeignKeyConstraintDefined();
            // foreignKeyConstraintDefined has no post constraints
            this.__foreignKeyConstraintDefined29a = foreignKeyConstraintDefined29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__foreignKeyConstraintDefined29aSet = true;
            }
        }
        return foreignKeyConstraintDefined29a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Returns true if the tagged value with the specified name exists for the association end.
     * @param name
     * @return boolean
     */
    protected abstract boolean handleHasTaggedValue(String name);

    /**
     * Returns true if the tagged value with the specified name exists for the association end.
     * @param name String
     * @return handleHasTaggedValue(name)
     */
    public boolean hasTaggedValue(String name)
    {
        // hasTaggedValue has no pre constraints
        boolean returnValue = handleHasTaggedValue(name);
        // hasTaggedValue has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Returns the name of the foreign key constraint to use for name property of
     * org.hibernate.annotations.ForeignKey annotation used for Many-To-One,
     * One-To-One and Many-To-Many relationships.
     * @param suffix
     * @return String
     */
    protected abstract String handleGetForeignKeyConstraintName(String suffix);

    /**
     * Returns the name of the foreign key constraint to use for name property of
     * org.hibernate.annotations.ForeignKey annotation used for Many-To-One,
     * One-To-One and Many-To-Many relationships.
     * @param suffix String
     * This is the referenced primary key column name.
     * @return handleGetForeignKeyConstraintName(suffix)
     */
    public String getForeignKeyConstraintName(String suffix)
    {
        // getForeignKeyConstraintName has no pre constraints
        String returnValue = handleGetForeignKeyConstraintName(suffix);
        // getForeignKeyConstraintName has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * The actual implementation of the collection type.
     * @param arg
     * @return String
     */
    protected abstract String handleGetCollectionTypeImplementation(String arg);

    /**
     * The actual implementation of the collection type.
     * @param arg String
     * Arguememt to the Collection type implemenation constructor.
     * @return handleGetCollectionTypeImplementation(arg)
     */
    public String getCollectionTypeImplementation(String arg)
    {
        // getCollectionTypeImplementation has no pre constraints
        String returnValue = handleGetCollectionTypeImplementation(arg);
        // getCollectionTypeImplementation has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Returns the name of the foreign key to use for name property of JoinColumn/InverseJoinColumn
     * used in JoinTable for One-To-Many and Many-To-Many relationships.
     * @param suffix
     * @return String
     */
    protected abstract String handleGetForeignKeyName(String suffix);

    /**
     * Returns the name of the foreign key to use for name property of JoinColumn/InverseJoinColumn
     * used in JoinTable for One-To-Many and Many-To-Many relationships.
     * @param suffix String
     * @return handleGetForeignKeyName(suffix)
     */
    public String getForeignKeyName(String suffix)
    {
        // getForeignKeyName has no pre constraints
        String returnValue = handleGetForeignKeyName(suffix);
        // getForeignKeyName has no post constraints
        return returnValue;
    }

    /**
     * @return true
     * @see EntityAssociationEnd
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

    // ----------- delegates to EntityAssociationEnd ------------
    /**
     * A name suitable for use when adding new elements to this association end in programming code.
     * @see AssociationEndFacade#getAdderName()
     */
    public String getAdderName()
    {
        return this.getSuperEntityAssociationEnd().getAdderName();
    }

    /**
     * Returns the value of the 'Aggregation' attribute (none, shared, composite). The default value
     * is "none". The literals are from the enumeration org.eclipse.uml2.uml.AggregationKind.
     * Specifies the kind of aggregation that applies to the Property.
     * @see AssociationEndFacade#getAggregationKind()
     */
    public String getAggregationKind()
    {
        return this.getSuperEntityAssociationEnd().getAggregationKind();
    }

    /**
     * The association owning this association end.
     * @see AssociationEndFacade#getAssociation()
     */
    public AssociationFacade getAssociation()
    {
        return this.getSuperEntityAssociationEnd().getAssociation();
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
        return this.getSuperEntityAssociationEnd().getDefault();
    }

    /**
     * A name suitable for use when accessing this association end in programming code.
     * @see AssociationEndFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperEntityAssociationEnd().getGetterName();
    }

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @see AssociationEndFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperEntityAssociationEnd().getGetterSetterTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see AssociationEndFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperEntityAssociationEnd().getLower();
    }

    /**
     * The other association end owned by this end's association.
     * @see AssociationEndFacade#getOtherEnd()
     */
    public AssociationEndFacade getOtherEnd()
    {
        return this.getSuperEntityAssociationEnd().getOtherEnd();
    }

    /**
     * A name suitable for use when removing element from this association end in programming code.
     * @see AssociationEndFacade#getRemoverName()
     */
    public String getRemoverName()
    {
        return this.getSuperEntityAssociationEnd().getRemoverName();
    }

    /**
     * A name suitable for use when accessing this association end in programming code.
     * @see AssociationEndFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperEntityAssociationEnd().getSetterName();
    }

    /**
     * The classifier attached to this association end.
     * @see AssociationEndFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperEntityAssociationEnd().getType();
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see AssociationEndFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperEntityAssociationEnd().getUpper();
    }

    /**
     * True if this association end represents an aggregation relationship.
     * @see AssociationEndFacade#isAggregation()
     */
    public boolean isAggregation()
    {
        return this.getSuperEntityAssociationEnd().isAggregation();
    }

    /**
     * Is true if update of one side of the association should also update the other side. false if
     * not.
     * @see AssociationEndFacade#isBidirectional()
     */
    public boolean isBidirectional()
    {
        return this.getSuperEntityAssociationEnd().isBidirectional();
    }

    /**
     * Returns whether or not (true/false) this association end is the child end of the assocation
     * (i.e. the other end's aggregation is composition).
     * @see AssociationEndFacade#isChild()
     */
    public boolean isChild()
    {
        return this.getSuperEntityAssociationEnd().isChild();
    }

    /**
     * True if this association end represents a composition relationship.
     * @see AssociationEndFacade#isComposition()
     */
    public boolean isComposition()
    {
        return this.getSuperEntityAssociationEnd().isComposition();
    }

    /**
     * If the association end is derived (its value is computed). UML2 only. UML14 always returns
     * false. Default=false.
     * @see AssociationEndFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperEntityAssociationEnd().isDerived();
    }

    /**
     * IsLeaf property in the association end property. If true, attribute is final, cannot be
     * extended or implemented by a descendant. Default=false.
     * @see AssociationEndFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEntityAssociationEnd().isLeaf();
    }

    /**
     * True if this association end's multiplicity is greater than one.
     * @see AssociationEndFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperEntityAssociationEnd().isMany();
    }

    /**
     * True if this association end's and the other end's multiplicities are both many.
     * @see AssociationEndFacade#isMany2Many()
     */
    public boolean isMany2Many()
    {
        return this.getSuperEntityAssociationEnd().isMany2Many();
    }

    /**
     * True if this association end's multiplicity is many while the other end's is one.
     * @see AssociationEndFacade#isMany2One()
     */
    public boolean isMany2One()
    {
        return this.getSuperEntityAssociationEnd().isMany2One();
    }

    /**
     * True if it is possible to navigate from the other end to this association end .
     * @see AssociationEndFacade#isNavigable()
     */
    public boolean isNavigable()
    {
        return this.getSuperEntityAssociationEnd().isNavigable();
    }

    /**
     * True if this association end's multiplicity is one while the other end's is many.
     * @see AssociationEndFacade#isOne2Many()
     */
    public boolean isOne2Many()
    {
        return this.getSuperEntityAssociationEnd().isOne2Many();
    }

    /**
     * True if this association end's and the other end's multiplicities are both one.
     * @see AssociationEndFacade#isOne2One()
     */
    public boolean isOne2One()
    {
        return this.getSuperEntityAssociationEnd().isOne2One();
    }

    /**
     * Indicates whether or not the association ends are ordered (if multiplicity is greater than
     * 1).
     * @see AssociationEndFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperEntityAssociationEnd().isOrdered();
    }

    /**
     * True if the association end cannot be changed.
     * @see AssociationEndFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperEntityAssociationEnd().isReadOnly();
    }

    /**
     * True if this association end's multiplicity is strictly greater than zero.
     * @see AssociationEndFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperEntityAssociationEnd().isRequired();
    }

    /**
     * UML2: If the association attribute is unique within the Collection type. UML14 always returns
     * false. Unique+Ordered determines the implementation Collection type. Default=false.
     * @see AssociationEndFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperEntityAssociationEnd().isUnique();
    }

    /**
     * The name of the index to create on a column that persists the foreign key attribute.
     * @see EntityAssociationEnd#getColumnIndex()
     */
    public String getColumnIndex()
    {
        return this.getSuperEntityAssociationEnd().getColumnIndex();
    }

    /**
     * The name of the column that makes up the foreign key.
     * @see EntityAssociationEnd#getColumnName()
     */
    public String getColumnName()
    {
        return this.getSuperEntityAssociationEnd().getColumnName();
    }

    /**
     * The name of the foreign key constraint to use for databases.
     * @see EntityAssociationEnd#getForeignKeyConstraintName()
     */
    public String getForeignKeyConstraintName()
    {
        return this.getSuperEntityAssociationEnd().getForeignKeyConstraintName();
    }

    /**
     * The current foreign key suffix specified for this entity association end facade.
     * @see EntityAssociationEnd#getForeignKeySuffix()
     */
    public String getForeignKeySuffix()
    {
        return this.getSuperEntityAssociationEnd().getForeignKeySuffix();
    }

    /**
     * The SQL type for this the foreign key column of this association end.
     * @see EntityAssociationEnd#getSqlType()
     */
    public String getSqlType()
    {
        return this.getSuperEntityAssociationEnd().getSqlType();
    }

    /**
     * The name of the unique-key that this unique association end belongs
     * @see EntityAssociationEnd#getUniqueGroup()
     */
    public String getUniqueGroup()
    {
        return this.getSuperEntityAssociationEnd().getUniqueGroup();
    }

    /**
     * Indicates whether or not a foreign identifier should be used for the entity that owns this
     * association end.  This would only make sense in the case of a child in a one-to-one
     * parent-child association.  If this flag is true, then the identifier of this entity should
     * also be used as the foreign key to the related parent entity.
     * @see EntityAssociationEnd#isForeignIdentifier()
     */
    public boolean isForeignIdentifier()
    {
        return this.getSuperEntityAssociationEnd().isForeignIdentifier();
    }

    /**
     * True if the associationEnd is marked with identifiers stereotype, false otherwise.
     * @see EntityAssociationEnd#isIdentifiersPresent()
     */
    public boolean isIdentifiersPresent()
    {
        return this.getSuperEntityAssociationEnd().isIdentifiersPresent();
    }

    /**
     * Indicates this association end should be ignored by the persistence layer.
     * @see EntityAssociationEnd#isTransient()
     */
    public boolean isTransient()
    {
        return this.getSuperEntityAssociationEnd().isTransient();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEntityAssociationEnd().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEntityAssociationEnd().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperEntityAssociationEnd().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEntityAssociationEnd().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEntityAssociationEnd().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperEntityAssociationEnd().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEntityAssociationEnd().getDocumentation(indent);
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
        return this.getSuperEntityAssociationEnd().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEntityAssociationEnd().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEntityAssociationEnd().getFullyQualifiedName();
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
        return this.getSuperEntityAssociationEnd().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEntityAssociationEnd().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEntityAssociationEnd().getId();
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
        return this.getSuperEntityAssociationEnd().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEntityAssociationEnd().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEntityAssociationEnd().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEntityAssociationEnd().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEntityAssociationEnd().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEntityAssociationEnd().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEntityAssociationEnd().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEntityAssociationEnd().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEntityAssociationEnd().getPackagePath();
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
        return this.getSuperEntityAssociationEnd().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEntityAssociationEnd().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEntityAssociationEnd().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEntityAssociationEnd().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEntityAssociationEnd().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEntityAssociationEnd().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEntityAssociationEnd().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEntityAssociationEnd().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEntityAssociationEnd().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEntityAssociationEnd().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEntityAssociationEnd().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEntityAssociationEnd().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEntityAssociationEnd().hasKeyword(keywordName);
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
        return this.getSuperEntityAssociationEnd().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEntityAssociationEnd().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEntityAssociationEnd().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEntityAssociationEnd().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEntityAssociationEnd().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEntityAssociationEnd().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEntityAssociationEnd().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEntityAssociationEnd().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEntityAssociationEnd().translateConstraints(kind, translation);
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEntityAssociationEnd().initialize();
    }

    /**
     * @return Object getSuperEntityAssociationEnd().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEntityAssociationEnd().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperEntityAssociationEnd().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEntityAssociationEnd().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperEntityAssociationEnd().validateInvariants(validationMessages);
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