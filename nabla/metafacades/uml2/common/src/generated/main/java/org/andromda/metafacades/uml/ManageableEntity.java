// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * 
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
     * 
     * @return ManageableEntityAttribute
     */
    public ManageableEntityAttribute getDisplayAttribute();

    /**
     * 
     * @return String
     */
    public String getFullyQualifiedManageableServiceName();

    /**
     * 
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
     * 
     * @return String
     */
    public String getManageablePackageName();

    /**
     * 
     * @return String
     */
    public String getManageablePackagePath();

    /**
     * 
     * @return String
     */
    public String getManageableServiceAccessorCall();

    /**
     * 
     * @return String
     */
    public String getManageableServiceFullPath();

    /**
     * 
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
     * 
     * @return List<ManageableEntity>
     */
    public List<ManageableEntity> getReferencingManageables();

    /**
     * 
     * @return List<ActorFacade>
     */
    public List<ActorFacade> getUsers();

    /**
     * 
     * @return boolean
     */
    public boolean isCreate();

    /**
     * 
     * @return boolean
     */
    public boolean isDelete();

    /**
     * 
     * @return boolean
     */
    public boolean isManageable();

    /**
     * 
     * @return boolean
     */
    public boolean isRead();

    /**
     * The maximum number of rows to load from the database.
     * @return boolean
     */
    public boolean isResolveable();

    /**
     * 
     * @return boolean
     */
    public boolean isUpdate();

    /**
     * 
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