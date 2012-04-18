// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.EntityAssociationEnd;

/**
 * Represents an EJB association end.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3AssociationEndFacade
    extends EntityAssociationEnd
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3AssociationEndFacadeMetaType();

    /**
     * Returns the default cascade property specified for UML aggregation.
     * @return String
     */
    public String getAggregationCascadeType();

    /**
     * Provides the cache policy for the entity association Collection.
     * Posible values are NONE, READ_WRITE, NONSTRICT_READ_WRITE, READ_ONLY, TRANSACTIONAL.
     * @return String
     */
    public String getCacheType();

    /**
     * Return the cascade type attributes as an array of this association end or null if no relevant
     * cascade attribute is found.
     * @return String
     */
    public String getCascadeType();

    /**
     * Returns the association end collection index name.
     * @return String
     */
    public String getCollectionIndexName();

    /**
     * this will only apply for Maps; it will return the type of the attribute specified on the
     * CollectionIndexName tagged value
     * @return String
     */
    public String getCollectionIndexType();

    /**
     * Returns the collection type defined on this association end using the
     * andromda_persistence_collection_type tagged value.
     * If undefined use the following strategy:
     * - If ordered collection type: return a list
     * - Otherwise, return the default association collection type.
     * @return String
     */
    public String getCollectionType();

    /**
     * The fully qualified class name of the collection implementation type.
     * @return String
     */
    public String getCollectionTypeImplemenationClass();

    /**
     * The actual implementation of the collection type.
     * @return String
     */
    public String getCollectionTypeImplementation();

    /**
     * The actual implementation of the collection type.
     * @param arg String
     * @return String
     */
    public String getCollectionTypeImplementation(String arg);

    /**
     * Defines the column definition DDL used when creating table schema - use to override default
     * container DDL.
     * @return String
     */
    public String getColumnDefinition();

    /**
     * Returns the default cascade property specified for UML composition.
     * @return String
     */
    public String getCompositionCascadeType();

    /**
     * Returns the default collection interface from namespace descriptor.
     * @return String
     */
    public String getDefaultCollectionInterface();

    /**
     * Get the fetch type for this association end(CMR).
     * If no fetch type tagged value is specified and COMPOSITION_DEFINES_EAGER_LOADING is enabled,
     * then:
     * <ul><li>aggregation: lazy-loaded</li><li>composition: eager-loaded</li></ul>
     * Otherwise, the default fetch type for CMR of type One2Many and Many2Many is LAZY.
     * Default fetch type for CMR of type Many2One and One2One is EAGER.
     * This will return either EAGER or LAZY.
     * @return String
     */
    public String getFetchType();

    /**
     * Returns the name of the foreign key constraint to use for name property of
     * org.hibernate.annotations.ForeignKey annotation used for Many-To-One,
     * One-To-One and Many-To-Many relationships.
     * @param suffix String
     * @return String
     */
    public String getForeignKeyConstraintName(String suffix);

    /**
     * Returns the name of the foreign key to use for name property of JoinColumn/InverseJoinColumn
     * used in JoinTable for One-To-Many and Many-To-Many relationships.
     * @param suffix String
     * @return String
     */
    public String getForeignKeyName(String suffix);

    /**
     * Returns the getter name for the label name of the display attribute of the manageable entity.
     * @return String
     */
    public String getGetterLabelName();

    /**
     * Returns the Hibernate cascade attribute of this association end.
     * @return String
     */
    public String getHibernateCascadeType();

    /**
     * Returns the label name for the association end used as the display attribute for manageable
     * entities.
     * @return String
     */
    public String getLabelName();

    /**
     * The order by clause set to order the returning Collection object on the many side of an
     * association.
     * @return String
     */
    public String getOrderByClause();

    /**
     * Returns the setter name for the label name of the display attribute of the manageable entity.
     * @return String
     */
    public String getSetterLabelName();

    /**
     * Returns true if the tagged value with the specified name exists for the association end.
     * @param name String
     * @return boolean
     */
    public boolean hasTaggedValue(String name);

    /**
     * Returns true if association caching has been enabled via namespace property
     * hibernateEnableAssociationCache.
     * @return boolean
     */
    public boolean isAssociationCacheEnabled();

    /**
     * Returns true if the collection type is a collection.  This will only be the case if the
     * association end multiplicity is defined as ordered.
     * @return boolean
     */
    public boolean isCollection();

    /**
     * Returns true if the collection interface for this association end is java.util.SortedSet.
     * @return boolean
     */
    public boolean isCollectionInterfaceSortedSet();

    /**
     * Determine if the fetch type for this entity relationship end is eager loading.
     * @return boolean
     */
    public boolean isEager();

    /**
     * Returns true if a foreign key constraint has been defined explicityly by the user.  Otherwise
     * returns false.  This will determine if the ForeignKey annotation will be rendered.  We
     * require this because there is no clean way of defining the constraint name for all
     * constraints as there may be a chance that two constraints may have the same name. This
     * vilates the database integrity.
     * @return boolean
     */
    public boolean isForeignKeyConstraintDefined();

    /**
     * Returns true if a Hibernate cascade attribute is defined for this association end.
     * @return boolean
     */
    public boolean isHibernateCascadeExists();

    /**
     * Determine if the fetch type for this entity relationship end is lazy loading.
     * @return boolean
     */
    public boolean isLazy();

    /**
     * Returns true if the collection type is a list.  This will only be the case if the association
     * end multiplicity is defined as ordered.
     * @return boolean
     */
    public boolean isList();

    /**
     * Returns true if the collection type is a map.  This will only be the case if the association
     * end multiplicity is defined as unordered.
     * @return boolean
     */
    public boolean isMap();

    /**
     * Sets the optional attribute on the annotation to determine if a null value is allowed.  If
     * set to false, non-null relationships must always exist.  If the andromda_persistence_optional
     * tag is set, then use the tagged value, otherwise determine if null value is allowed by way of
     * multiplicity on the association end.
     * @return boolean
     */
    public boolean isOptional();

    /**
     * Determines if this association end if the owning side.  Used in one-to-one and many-to-many
     * relationships.
     * @return boolean
     */
    public boolean isOwning();

    /**
     * Returns true if the collection type is a set.  This will only be the case if the association
     * end multiplicity is defined as unordered.
     * @return boolean
     */
    public boolean isSet();
}