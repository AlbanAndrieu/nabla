// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.Role;

/**
 * Represents an entity EJB.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3EntityFacade
    extends Entity
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3EntityFacadeMetaType();

    /**
     * Find all associations that define relations to other entities.
     * This method returns the source association ends for all associations that define
     * a container managed relation.  The returned collection includes both
     * direct relations and inherited relations. A direct relation is an association with some other
     * class matching the following criteria: 1) The class at the other side of the association is
     * stereotyped <<Entity>> 2) The association is navigable from to the other side.
     * An inherited relation is an association from an abstract super type matching the following
     * criteria: 1) The inheritance path to this abstract super type, including this super type
     * itself, consists only of abstract classes with stereotype <<Entity>> 2)  The class at the
     * other side of the association is stereotyped <<Entity>>. 3) The association is navigable from
     * this abstract super type to the other side.
     * Relations must match the following integrity constraint:
     * - The <<Entity>> at the target end is not abstract.
     * The integrity constraint is necessary because the target of a container managed relation in
     * the EJB framework must be a concrete entity bean; there is no such thing as an
     * "abstract entity bean" in the EJB specification. It is possible, however, to generate and
     * compile code for this case, an error will only show up at deploy time. In order to catch
     * this kind of error at the earliest possible stage, this method checks the integrity
     * constraint and throws an exception if it is violated.
     * @return Collection
     */
    public Collection getAllEntityRelations();

    /**
     * All instanceAttributes for this entity. The list includes the instanceAttributes that are
     * inherited from super classes. The list contains the inherited instanceAttributes first,
     * followed by the instanceAttributes defined in this class.
     * @return List
     */
    public List getAllInstanceAttributes();

    /**
     * Returns all value object references (this includes all those that are inherited from any
     * parent entities)
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getAllValueObjectReferences();

    /**
     * Create a comma separated list of attributes. This method can be used to generate argument
     * lists for constructors, method calls etc. It will not return attributes tagged to be
     * optimistic lock values.  It will consider LOB attributes where the LOB type has been
     * overriden using the @androma.persistence.lob.type tagged value.
     * @param attributes Collection
     * @param includeTypes boolean
     * @param includeNames boolean
     * @param includeAutoIdentifiers boolean
     * @return String
     */
    public String getAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames, boolean includeAutoIdentifiers);

    /**
     * Gets the Spring bean name, and optionally adds a target suffix, if 'targetSuffix' is set to
     * true.
     * @param targetSuffix boolean
     * @return String
     */
    public String getBeanName(boolean targetSuffix);

    /**
     * Provides the cache policy for the entity.
     * Posible values are NONE, READ_WRITE, NONSTRICT_READ_WRITE, READ_ONLY, TRANSACTIONAL.
     * @return String
     */
    public String getCacheType();

    /**
     * Gets all constants for this entity. Constants are defined as static read-only attributes
     * which do NOT have the <<EnvEntry>> stereotype.   If 'follow' is true, then the inheritance
     * hierarchy will be followed and we'll retrieve all constants from any super types as well.
     * @param follow boolean
     * @return Collection
     */
    public Collection getConstants(boolean follow);

    /**
     * Gets create methods for the entity.  If 'follow'l is set to true, create methods from any
     * super types will also be retrieved by following up the inheritance chain.
     * @param follow boolean
     * @return Collection
     */
    public Collection getCreateMethods(boolean follow);

    /**
     * The DAO base class name.  This is the abstract DAO that containsCRUD operations as well as
     * any generated finders defined on an entity.
     * @return String
     */
    public String getDaoBaseName();

    /**
     * The business operations modeled on the entity that will be generated on the DAO (Data Access
     * Object).
     * @return Collection<EJB3OperationFacade>
     */
    public Collection<EJB3OperationFacade> getDaoBusinessOperations();

    /**
     * Returns the default DAO exception name.
     * @return String
     */
    public String getDaoDefaultExceptionName();

    /**
     * The DAO implementation class name.
     * @return String
     */
    public String getDaoImplementationName();

    /**
     * The name of the DAO for the specified entity.
     * @return String
     */
    public String getDaoName();

    /**
     * The constant name denoting no transformation is to be applied.
     * @return String
     */
    public String getDaoNoTransformationConstantName();

    /**
     * Returns the default entity cascadable property attribute looked up in the namespace
     * descriptor.
     * @return String
     */
    public String getDefaultCascadeType();

    /**
     * Returns the default persistence context unit name for the injected EntityManger for the
     * DAO/Manageable service beans.  It is derived from the persistenceContextUnitName namespace
     * property.
     * @return String
     */
    public String getDefaultPersistenceContextUnitName();

    /**
     * The name of the discriminator column.  Default is TYPE if this is missing.
     * @return String
     */
    public String getDiscriminatorColumn();

    /**
     * The SQL used when generating the DDL for the discriminator column.
     * @return String
     */
    public String getDiscriminatorColumnDefinition();

    /**
     * The standard length of a discriminator value.  Default is 10.
     * @return int
     */
    public int getDiscriminatorLength();

    /**
     * The type of the entity discriminator column.  Default is STRING.
     * @return String
     */
    public String getDiscriminatorType();

    /**
     * The value indicating the row in an entity of the annotated entity type.
     * @return String
     */
    public String getDiscriminatorValue();

    /**
     * Entity composite primary key class name for this entity.
     * @return String
     */
    public String getEntityCompositePrimaryKeyName();

    /**
     * Entity embeddable super class name this entity inherits from.
     * @return String
     */
    public String getEntityEmbeddableName();

    /**
     * The name of the implementation class.
     * @return String
     */
    public String getEntityImplementationName();

    /**
     * Entity listener class name for callback methods.
     * @return String
     */
    public String getEntityListenerName();

    /**
     * The named used for the EJB3 entity.
     * @return String
     */
    public String getEntityName();

    /**
     * 
     * @return Collection
     */
    public Collection getEntityRelations();

    /**
     * Gets all env-entries for the specified entity EJB. Env-entries are stored as static
     * attributes on the entity and stereotyped as <<EnvEntry>>.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all env-entries from any super
     * types as well.
     * @param follow boolean
     * @return Collection
     */
    public Collection getEnvironmentEntries(boolean follow);

    /**
     * The fully qualified name of the base DAO.
     * @return String
     */
    public String getFullyQualifiedDaoBaseName();

    /**
     * Returns the fully qualified default DAO exception name.
     * @return String
     */
    public String getFullyQualifiedDaoDefaultExceptionName();

    /**
     * The fully qualified name of the DAO implemetation.
     * @return String
     */
    public String getFullyQualifiedDaoImplementationName();

    /**
     * The fully qualified name of the DAO.
     * @return String
     */
    public String getFullyQualifiedDaoName();

    /**
     * The fully qualified name of the composite primary key class of this entity.
     * @return String
     */
    public String getFullyQualifiedEntityCompositePrimaryKeyName();

    /**
     * The fully qualified name of the embeddable super class of this entity.
     * @return String
     */
    public String getFullyQualifiedEntityEmbeddableName();

    /**
     * Fully qualified name of the Entity implementation class.
     * @return String
     */
    public String getFullyQualifiedEntityImplementationName();

    /**
     * Fully qualified name of the Entity listner class holding entity callback methods.
     * @return String
     */
    public String getFullyQualifiedEntityListenerName();

    /**
     * The fully qualified name of the EJB3 entity.
     * @return String
     */
    public String getFullyQualifiedEntityName();

    /**
     * A String representing the name of a home interface for this entity EJB.
     * @return String
     */
    public String getHomeInterfaceName();

    /**
     * Returns the attribute identifier.
     * @return EJB3EntityAttributeFacade
     */
    public EJB3EntityAttributeFacade getIdentifier();

    /**
     * Return the value of the andromda_persistence_inheritance tagged value which is an enumeration
     * containing SINGLE_TABLE, TABLE_PER_CLASS or JOINED.
     * @return String
     */
    public String getInheritanceStrategy();

    /**
     * All inherited instanceAttributes this class.  The instanceAttributes are grouped by the class
     * that defines the instanceAttributes, with instanceAttributes from the most removed super
     * class first.
     * @return List
     */
    public List getInheritedInstanceAttributes();

    /**
     * Gets a comma separated list of instance attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include instance attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return String
     */
    public String getInstanceAttributeNameList(boolean follow, boolean withIdentifiers);

    /**
     * Gets a comma separated list of instance attribute types.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include instance attribute types in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return String
     */
    public String getInstanceAttributeTypeList(boolean follow, boolean withIdentifiers);

    /**
     * Gets all instance attributes of the entity, and optionally retieves the super entities
     * instance attributes as well as excludes the entity's identifiers if 'withIdentifiers' is set
     * to false.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return Collection
     */
    public Collection getInstanceAttributes(boolean follow, boolean withIdentifiers);

    /**
     * 
     * @return String
     */
    public String getJndiName();

    /**
     * 
     * @return AttributeFacade
     */
    public AttributeFacade getManageableDisplayAttribute();

    /**
     * 
     * @return Collection<Role>
     */
    public Collection<Role> getNonRunAsRoles();

    /**
     * Returns the comma separated list of roles allowd to execute DAO operations.  This is defined
     * by actor dependencies on the entity.
     * @return String
     */
    public String getRolesAllowed();

    /**
     * Travels up the inheritance hierarchy and retrieves the root of this entity.  If the root is
     * the entity itself then just the entity is returned.
     * @return EJB3EntityFacade
     */
    public EJB3EntityFacade getRoot();

    /**
     * Returns the Seam component name for the class.
     * @return String
     */
    public String getSeamComponentName();

    /**
     * Returns the seam component scope type if one is specified.
     * @return String
     */
    public String getSeamComponentScopeType();

    /**
     * Returns the security domain value.  Specified using the securityRealm namespace property or
     * overriden in the andromda.ejb.security.realm tagged value.
     * @return String
     */
    public String getSecurityRealm();

    /**
     * Gets select methods for the entity, if all is set to 'true' then ALL select methods will be
     * retrieved (including those inherited from any superclasses).
     * @param follow boolean
     * @return Collection
     */
    public Collection getSelectMethods(boolean follow);

    /**
     * 
     * @return String
     */
    public String getSqlType();

    /**
     * 
     * @return Collection
     */
    public Collection getValueDependencies();

    /**
     * Retrieves the value object dependencies for this entity without inherited object references.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getValueObjectReferences();

    /**
     * Retrieves the values object references for this entity.  If <code>follow</code> is true, then
     * all value object references (including those that were inherited) will be retrieved.
     * @param follow boolean
     * @return Collection
     */
    public Collection getValueObjectReferences(boolean follow);

    /**
     * A string indicating whether the Bean is a local or remotely accessable bean.
     * @return String
     */
    public String getViewType();

    /**
     * 
     * @param att String
     * @return boolean
     */
    public boolean isAttributePresent(String att);

    /**
     * Returns true if caching has been enabled via namespace property hibernateEnableCache.
     * @return boolean
     */
    public boolean isCacheEnabled();

    /**
     * Returns true if a composite primary key exists for this entity bean.  A composite primary key
     * consists of 2 or more entity identifiers.
     * @return boolean
     */
    public boolean isCompositePrimaryKeyPresent();

    /**
     * Indicates whether or not any business DAO operations are present.
     * @return boolean
     */
    public boolean isDaoBusinessOperationsPresent();

    /**
     * True if an implementation is required for the dao class, this is the case when there are
     * business operations or value-object transformation.
     * @return boolean
     */
    public boolean isDaoImplementationRequired();

    /**
     * Determines if this entity is an mapped/embeddable super class.
     * @return boolean
     */
    public boolean isEmbeddableSuperclass();

    /**
     * Returns true if this entity is a subclass of an mapped/embeddable super class.  You cannot
     * have more than 1 level of inheritance using mapped/embeddable super class.  To achieve
     * multiple levels, use one of the inheritance mapping strategies like single table, table per
     * class or joined table strategies.
     * @return boolean
     */
    public boolean isEmbeddableSuperclassGeneralizationExists();

    /**
     * True if an entity implementation is required for the entity class, this is the case when
     * there are business operations.
     * @return boolean
     */
    public boolean isEntityImplementationRequired();

    /**
     * Returns true if the findAll finder method (specified as a query method) has been modelled.
     * @return boolean
     */
    public boolean isFinderFindAllExists();

    /**
     * Returns true if the finder findByPrimaryKey has been modelled.
     * @return boolean
     */
    public boolean isFinderFindByPrimaryKeyExists();

    /**
     * Returns true if the generic finder property is true.  This will create generic finder static
     * methods in the entity POJO like findByPrimaryKey and findAll.
     * @return boolean
     */
    public boolean isGenericFinders();

    /**
     * 
     * @param id String
     * @return boolean
     */
    public boolean isIdentifierPresent(String id);

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as JOINED.
     * @return boolean
     */
    public boolean isInheritanceJoined();

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as SINGLE_TABLE.
     * @return boolean
     */
    public boolean isInheritanceSingleTable();

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as TABLE_PER_CLASS.
     * @return boolean
     */
    public boolean isInheritanceTablePerClass();

    /**
     * Returns true if this entity bean has the stereotype Listener.  False otherwise.
     * @return boolean
     */
    public boolean isListenerEnabled();

    /**
     * Returns true if this entity is assigned the Manageable stereotype.  False otherwise.
     * @return boolean
     */
    public boolean isManageable();

    /**
     * 
     * @param op String
     * @return boolean
     */
    public boolean isOperationPresent(String op);

    /**
     * Returns true if the entity requires generalization mapping.  The Inheritance annotation is
     * required for child entities for all inheritance strategies.
     * @return boolean
     */
    public boolean isRequiresGeneralizationMapping();

    /**
     * Returns true if the entity requires specialization mapping.  The Inheritance annotation is
     * required for parent entities for all inheritance strategies.
     * @return boolean
     */
    public boolean isRequiresSpecializationMapping();

    /**
     * Returns true if this entity has the <<Seam>> stereotype modelled indicating it is a Seam
     * entity component.
     * @return boolean
     */
    public boolean isSeamComponent();

    /**
     * Returns true if the security realm is specified.  This will generate the security setting for
     * the DAO components.
     * @return boolean
     */
    public boolean isSecurityEnabled();

    /**
     * Whether or not to allow a synthetic (auto generated) create method.
     * @return boolean
     */
    public boolean isSyntheticCreateMethodAllowed();

    /**
     * Return true if a unique cache region is NOT required for entities and queries.  This means we
     * use the default cache region specified by the container.  Specified via the
     * useDefaultCacheRegion namepsace property.
     * @return boolean
     */
    public boolean isUseDefaultCacheRegion();

    /**
     * Returns true if the application wide namespace property hibernateUseQueryCache is enabled. 
     * This is used for generic finder methods i.e. findAll.
     * @return boolean
     */
    public boolean isUseQueryCache();
}