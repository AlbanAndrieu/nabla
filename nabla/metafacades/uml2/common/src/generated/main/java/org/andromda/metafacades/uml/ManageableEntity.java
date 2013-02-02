// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * An Entity that is Manageable: will produce CRUD operations in the EntityManager implementation.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ManageableEntity
    extends Entity
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isManageableEntityMetaType();

    /**
     * All entities to which can be browsed from this entity. Currently this property will simple
     * hold all entities, so the value is the same for any arbitrary entity. Hiding entities can be
     * done in the presentation tier, for example depending on runtime security information.
     * @return List<ManageableEntity>
     */
    public List<ManageableEntity> getAllManageables();

    /**
     * The attribute used as a key link to display values for this entity.
     * @return ManageableEntityAttribute
     */
    public ManageableEntityAttribute getDisplayAttribute();

    /**
     * The fully qualified service name of the entity.
     * @return String
     */
    public String getFullyQualifiedManageableServiceName();

    /**
     * The associations to other entities from this entity.
     * @return List<ManageableEntityAssociationEnd>
     */
    public List<ManageableEntityAssociationEnd> getManageableAssociationEnds();

    /**
     * Lists the attributes that can be managed for this entity. This feature is particularly
     * important when resolving inherited attributes and ids.
     * @return List<ManageableEntityAttribute>
     */
    public List<ManageableEntityAttribute> getManageableAttributes();

    /**
     * The identifier used when managing this entity.
     * @return ManageableEntityAttribute
     */
    public ManageableEntityAttribute getManageableIdentifier();

    /**
     * ManageableAttributes and ManageableAssociationEnds
     * @return List<ModelElementFacade>
     */
    public List<ModelElementFacade> getManageableMembers();

    /**
     * The entity package name.
     * @return String
     */
    public String getManageablePackageName();

    /**
     * The Package path of the Entity.
     * @return String
     */
    public String getManageablePackagePath();

    /**
     * The entity accessor (getter) call.
     * @return String
     */
    public String getManageableServiceAccessorCall();

    /**
     * The service full path of the entity.
     * @return String
     */
    public String getManageableServiceFullPath();

    /**
     * The service name of the entity.
     * @return String
     */
    public String getManageableServiceName();

    /**
     * The maximum number of rows to load from the database.
     * @return int
     */
    public int getMaximumListSize();

    /**
     * The maximum number of rows to load from the database.
     * @return int
     */
    public int getPageSize();

    /**
     * Other Manageable Entities which reference this entity.
     * @return List<ManageableEntity>
     */
    public List<ManageableEntity> getReferencingManageables();

    /**
     * The Actors (Roles) which can manage the Entity.
     * @return List<ActorFacade>
     */
    public List<ActorFacade> getUsers();

    /**
     * Create a create operation on the entity manager?
     * @return boolean
     */
    public boolean isCreate();

    /**
     * Create a delete operation on the entity manager?
     * @return boolean
     */
    public boolean isDelete();

    /**
     * True: Entity is manageable.
     * @return boolean
     */
    public boolean isManageable();

    /**
     * Create a read operation on the entity manager?
     * @return boolean
     */
    public boolean isRead();

    /**
     * The maximum number of rows to load from the database.
     * @return boolean
     */
    public boolean isResolveable();

    /**
     * Create an update operation on the entity manager?
     * @return boolean
     */
    public boolean isUpdate();

    /**
     * Returns a string with the attributes without wrapper types.
     * @param withTypes boolean
     * @return String
     */
    public String listManageableMembers(boolean withTypes);

    /**
     * Returns a string with the attributes and wrapper types.
     * @return String
     */
    public String listManageableMembersWithWrapperTypes();
}