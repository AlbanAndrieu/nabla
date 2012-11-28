// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * Represents a persistent entity.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface Entity
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEntityMetaType();

    /**
     * Returns a collection of all entities this entity and its ancestors have a relation to.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getAllEntityReferences();

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return String
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers);

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers  and  if 'withDerived' is set to true, will include derived
     * attributes.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @param withDerived boolean
     * @return String
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived);

    /**
     * Gets a comma separated list of attribute types.  If 'follow' is true, will travel up the
     * inheritance hierarchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return String
     */
    public String getAttributeTypeList(boolean follow, boolean withIdentifiers);

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return Collection<AttributeFacade>
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers);

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false and exclude
     * derived attributes if 'withDerived' is set to false.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @param withDerived boolean
     * @return Collection<AttributeFacade>
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived);

    /**
     * All business operations of the entity, these include any operations that aren't queries.
     * @return Collection<OperationFacade>
     */
    public Collection<OperationFacade> getBusinessOperations();

    /**
     * Gets any children association ends (i.e. entity association ends that are participants in an
     * association with this entity and this entity has composite aggregation defined for those
     * associations).
     * @return Collection<EntityAssociationEnd>
     */
    public Collection<EntityAssociationEnd> getChildEnds();

    /**
     * The embedded values belonging to this entity.
     * @return Collection<AttributeFacade>
     */
    public Collection<AttributeFacade> getEmbeddedValues();

    /**
     * All entities referenced by this entity.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getEntityReferences();

    /**
     * The full name of the type of the identifier. If composite identifier add the PK sufix to the
     * class name. If not, retorns the fully qualified name of the identifier.
     * @return String
     */
    public String getFullyQualifiedIdentifierTypeName();

    /**
     * Gets all the associationEnds of this entity marked with the identifiers stereotype.
     * @return Collection<AssociationEndFacade>
     */
    public Collection<AssociationEndFacade> getIdentifierAssociationEnds();

    /**
     * The getter name of the identifier.
     * @return String
     */
    public String getIdentifierGetterName();

    /**
     * The name of the identifier. If composite identifier add the Pk suffix. If not composite
     * returns the attribute name of the identifier.
     * @return String
     */
    public String getIdentifierName();

    /**
     * The setter name of the identifier.
     * @return String
     */
    public String getIdentifierSetterName();

    /**
     * The name of the type of the identifier. If composite identifier add the PK suffix to the
     * class name. If not, returns the name of the identifier.
     * @return String
     */
    public String getIdentifierTypeName();

    /**
     * All the attributes of the entity which make up its identifier (primary key).  Will search any
     * super classes as well.  If no identifiers exist, a default identifier will be created if the
     * allowDefaultIdentifiers property is set to true.
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getIdentifiers();

    /**
     * Gets all identifiers for an entity. If 'follow' is true, and if no identifiers can be found
     * on the entity, a search up the inheritance chain will be performed, and the identifiers from
     * the first super class having them will be used.   If no identifiers exist, a default
     * identifier will be created if the allowDefaultIdentifiers property is set to true.
     * Identifiers can be on attributes or associations (composite primary key).
     * @param follow boolean
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getIdentifiers(boolean follow);

    /**
     * The maximum length a SQL name may be.
     * @return short
     */
    public short getMaxSqlNameLength();

    /**
     * Gets the attributes as a list within an operation call, optionally including the type names
     * and the identifier attributes.
     * @param withIdentifiers boolean
     * @return String
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers);

    /**
     * Gets the attributes as a list within an operation call.  If 'withTypeNames' is true, it will
     * include the type names, if 'withIdentifiers' is true it will include the identifiers.  If
     * 'follow' is true it will follow the inheritance hierarchy and get the attributes of the super
     * class as well.
     * @param withIdentifiers boolean
     * @param follow boolean
     * @return String
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers, boolean follow);

    /**
     * Returns the parent association end of this entity if its a child entity.  The parent is the
     * entity that is the participant the association that has composite aggregation defined.  Will
     * return null if the entity has no parent.
     * @return EntityAssociationEnd
     */
    public EntityAssociationEnd getParentEnd();

    /**
     * Gets all properties of this entity, this includes the attributes and navigable association
     * ends of the entity.  The 'follow' flag indcates whether or not the inheritance hierarchy
     * should be followed when getting all the properties.  The 'withIdentifiers' flag indicates
     * whether or not identifiers should be included in the collection of properties.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getProperties(boolean follow, boolean withIdentifiers);

    /**
     * Returns all the operations that can perform queries on the entity.
     * @return Collection<EntityQueryOperation>
     */
    public Collection<EntityQueryOperation> getQueryOperations();

    /**
     * Gets all query operations for an entity. If 'follow' is true, and if no query operations can
     * be found on the entity, a search up the inheritance chain will be performed, and the
     * identifiers from the first super class having them will be used.   If no identifiers exist, a
     * default identifier will be created if the allowDefaultIdentifiers property is set to true.
     * @param follow boolean
     * @return Collection<OperationFacade>
     */
    public Collection<OperationFacade> getQueryOperations(boolean follow);

    /**
     * Gets a comma separated list of required attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return String
     */
    public String getRequiredAttributeNameList(boolean follow, boolean withIdentifiers);

    /**
     * Gets a comma separated list of attribute types with are required.  If 'follow' is true, will
     * travel up the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return String
     */
    public String getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers);

    /**
     * Returns all attributes that are specified as 'required' in the model.  If 'follow' is true,
     * then required attributes in super classes will also be returned, if false, just the ones
     * directly on the entity will be returned.  If 'withIdentifiers' is true, the identifiers will
     * be include, if false, no identifiers will be included.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return Collection<AttributeFacade>
     */
    public Collection<AttributeFacade> getRequiredAttributes(boolean follow, boolean withIdentifiers);

    /**
     * Gets all required properties for this entity.  These consist of any required attributes as
     * well as navigable associations that are marked as 'required'.  If 'follow' is true, then the
     * inheritance hierchy will be followed and all required properties from super classes will be
     * included as well.
     * If 'withIdentifiers' is true, the identifiers will be include, if false, no identifiers will
     * be included.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getRequiredProperties(boolean follow, boolean withIdentifiers);

    /**
     * Creates a comma separated list of the required property names.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return String
     */
    public String getRequiredPropertyNameList(boolean follow, boolean withIdentifiers);

    /**
     * A comma separated list of the required property types.
     * @param follow boolean
     * @param withIdentifiers boolean
     * @return String
     */
    public String getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers);

    /**
     * The name of the schema that contains the database table
     * @return String
     */
    public String getSchema();

    /**
     * The name of the database table to which this entity is persisted.
     * @return String
     */
    public String getTableName();

    /**
     * Returns true/false depending on whether or not this entity represetns a child in an
     * association (this occurs when this entity is on the opposite end of an assocation end defined
     * as composite).
     * @return boolean
     */
    public boolean isChild();

    /**
     * True if this entity identifier is a composite (consists of multiple key columns, typically
     * abstracted into an external composite identifier class)
     * @return boolean
     */
    public boolean isCompositeIdentifier();

    /**
     * True if the entity has its identifiers dynamically added, false otherwise.
     * @return boolean
     */
    public boolean isDynamicIdentifiersPresent();

    /**
     * True if the entity has any identifiers defined, false otherwise.
     * @return boolean
     */
    public boolean isIdentifiersPresent();

    /**
     * Indiciates if this entity is using an assigned identifier or not.
     * @return boolean
     */
    public boolean isUsingAssignedIdentifier();

    /**
     * Indicates whether or not this entity is using a foreign identifier as its identifiers.  That
     * is: the foreignIdentifier flag was set on an incoming association end and the entity is
     * therefore using the related foreign parent entity's identifier.
     * @return boolean
     */
    public boolean isUsingForeignIdentifier();
}