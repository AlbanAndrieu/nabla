// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.Entity;
import org.andromda.metafacades.uml.ManageableEntity;
import org.andromda.metafacades.uml.Role;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiManageableEntity
    extends ManageableEntity
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiManageableEntityMetaType();

    /**
     * 
     * @return boolean
     */
    public boolean eachBusinessObjectReferenceIsValid();

    /**
     * 
     * @return String
     */
    public String getActionClassName();

    /**
     * 
     * @return String
     */
    public String getActionFullPath();

    /**
     * 
     * @return String
     */
    public String getActionParameter();

    /**
     * 
     * @return String
     */
    public String getActionPath();

    /**
     * 
     * @return String
     */
    public String getActionRoles();

    /**
     * The calcuated serial version UID for this manageable actions.
     * @return String
     */
    public String getActionSerialVersionUID();

    /**
     * 
     * @return String
     */
    public String getActionType();

    /**
     * 
     * @param displayName String
     * @return String
     */
    public String getAttributeNameByDisplayName(String displayName);

    /**
     * 
     * @param displayName String
     * @return String
     */
    public String getAttributeTypeByDisplayName(String displayName);

    /**
     * 
     * @return List<Entity>
     */
    public List<Entity> getBusinessObjectReferences();

    /**
     * The bean name of this manageable controller (this is what is stored in the JSF configuration
     * file).
     * @return String
     */
    public String getControllerBeanName();

    /**
     * Full path of this manageable controller.
     * @return String
     */
    public String getControllerFullPath();

    /**
     * Manageable controller class name.
     * @return String
     */
    public String getControllerName();

    /**
     * Fully qualified name of this manageable controller.
     * @return String
     */
    public String getControllerType();

    /**
     * 
     * @return String
     */
    public String getConverterClassName();

    /**
     * 
     * @return String
     */
    public String getConverterFullPath();

    /**
     * 
     * @return String
     */
    public String getConverterType();

    /**
     * 
     * @param association GuiManageableEntityAssociationEnd
     * @return AttributeFacade
     */
    public AttributeFacade getCorrespondingRuleVOAttr(GuiManageableEntityAssociationEnd association);

    /**
     * 
     * @param manageableAttr GuiManageableEntityAttribute
     * @return AttributeFacade
     */
    public AttributeFacade getCorrespondingVOAttr(GuiManageableEntityAttribute manageableAttr);

    /**
     * 
     * @return Collection
     */
    public Collection getCreatePreconditions();

    /**
     * 
     * @return List<GuiManageableEntity>
     */
    public List<GuiManageableEntity> getCustomEntityReferences();

    /**
     * 
     * @return GuiManageableEntity
     */
    public GuiManageableEntity getCustomOwner();

    /**
     * 
     * @param customUseCaseName String
     * @return String
     */
    public String getCustomUseCaseActionType(String customUseCaseName);

    /**
     * 
     * @param customUseCaseName String
     * @return String
     */
    public String getCustomUseCaseDisplayType(String customUseCaseName);

    /**
     * 
     * @return Collection
     */
    public Collection getCustomUseCases();

    /**
     * 
     * @return Collection
     */
    public Collection getDeletePreconditions();

    /**
     * 
     * @return String
     */
    public String getDisplayName();

    /**
     * 
     * @return String
     */
    public String getEjbInterfaceName();

    /**
     * 
     * @return String
     */
    public String getExceptionKey();

    /**
     * 
     * @return String
     */
    public String getExceptionPath();

    /**
     * 
     * @return Collection
     */
    public Collection getExternalUseCases();

    /**
     * 
     * @return String
     */
    public String getFormBeanClassName();

    /**
     * 
     * @return String
     */
    public String getFormBeanFullPath();

    /**
     * 
     * @return String
     */
    public String getFormBeanName();

    /**
     * 
     * @return String
     */
    public String getFormBeanType();

    /**
     * The calcuated serial version UID for this action's form.
     * @return String
     */
    public String getFormSerialVersionUID();

    /**
     * 
     * @param businessObjectName String
     * @return String
     */
    public String getIdentifierForBusinessObjectReference(String businessObjectName);

    /**
     * 
     * @return AttributeFacade
     */
    public AttributeFacade getIdentifierToDelete();

    /**
     * 
     * @return String
     */
    public String getListGetterName();

    /**
     * 
     * @return String
     */
    public String getListName();

    /**
     * 
     * @return String
     */
    public String getListSetterName();

    /**
     * 
     * @return Object
     */
    public Object getManageableExternalOrganization();

    /**
     * 
     * @return ManageableEntity
     */
    public ManageableEntity getManageableGeneralizationToDelete();

    /**
     * 
     * @return Collection
     */
    public Collection getManageableSearchAssociationEnds();

    /**
     * 
     * @return Collection
     */
    public Collection getManageableSearchAttributes();

    /**
     * 
     * @return String
     */
    public String getMessageKey();

    /**
     * 
     * @return String
     */
    public String getMessageValue();

    /**
     * 
     * @return String
     */
    public String getOdsExportFullPath();

    /**
     * The full path to this entity's online help action. The returned String does not have a suffix
     * such as '.do'.
     * @return String
     */
    public String getOnlineHelpActionPath();

    /**
     * The key to lookup the online help documentation.
     * @return String
     */
    public String getOnlineHelpKey();

    /**
     * The full path to this entitiy's online help page. The returned String does not have a suffix
     * such as '.jsp'.
     * @return String
     */
    public String getOnlineHelpPagePath();

    /**
     * The online help documentation. The format is HTML without any style.
     * @return String
     */
    public String getOnlineHelpValue();

    /**
     * 
     * @return String
     */
    public String getPageFullPath();

    /**
     * 
     * @return String
     */
    public String getPageName();

    /**
     * 
     * @return String
     */
    public String getPageTitleKey();

    /**
     * 
     * @return String
     */
    public String getPageTitleValue();

    /**
     * 
     * @return String
     */
    public String getPopulatorFullPath();

    /**
     * 
     * @return String
     */
    public String getPopulatorName();

    /**
     * 
     * @return String
     */
    public String getPopulatorType();

    /**
     * 
     * @return Collection
     */
    public Collection getPreconditions();

    /**
     * 
     * @return Collection<Role>
     */
    public Collection<Role> getRoles();

    /**
     * To retrieve corresponding criterias search data represented by a typical value object
     * @return ClassifierFacade
     */
    public ClassifierFacade getRulesCriteriasSearchValueObject();

    /**
     * To retrieve all associations which end is a RulesSearchData stereotyped class.
     * @return Collection
     */
    public Collection getRulesSearchData();

    /**
     * 
     * @return String
     */
    public String getSearchFormBeanClassName();

    /**
     * 
     * @return String
     */
    public String getSearchFormBeanFullPath();

    /**
     * 
     * @return String
     */
    public String getSearchFormBeanName();

    /**
     * 
     * @return String
     */
    public String getSearchFormBeanType();

    /**
     * 
     * @return String
     */
    public String getSecurityName();

    /**
     * 
     * @return AttributeFacade
     */
    public AttributeFacade getShowDealDealId();

    /**
     * 
     * @return AttributeFacade
     */
    public AttributeFacade getShowDealDealType();

    /**
     * Tthe available types of export in a single String instance.
     * @return String
     */
    public String getTableExportTypes();

    /**
     * The maximum number of rows to be displayed in the table at the same time. This is also known
     * as the page size. A value of zero or less will display all data in the same table (therefore
     * also on the same page).
     * @return int
     */
    public int getTableMaxRows();

    /**
     * 
     * @return Collection
     */
    public Collection getUpdatePreconditions();

    /**
     * 
     * @return String
     */
    public String getValueObjectClassName();

    /**
     * 
     * @return Entity
     */
    public Entity getVersionableEntityReference();

    /**
     * 
     * @return String
     */
    public String getViewFullPath();

    /**
     * 
     * @return String
     */
    public String getViewName();

    /**
     * 
     * @return String
     */
    public String getViewTitleKey();

    /**
     * 
     * @return String
     */
    public String getViewTitleValue();

    /**
     * will return true if Manageable entity has no Show Deal use case, or if deal id and deal type
     * info is available (attributes with correct tags)
     * @return boolean
     */
    public boolean hasCorrectShowDealInfo();

    /**
     * 
     * @return boolean
     */
    public boolean hasCustomUsecases();

    /**
     * 
     * @param name String
     * @return boolean
     */
    public boolean isAttributeOrAssociation(String name);

    /**
     * 
     * @return boolean
     */
    public boolean isClonable();

    /**
     * 
     * @return boolean
     */
    public boolean isEditable();

    /**
     * 
     * @return boolean
     */
    public boolean isExportable();

    /**
     * 
     * @return boolean
     */
    public boolean isExternalOrganizationExists();

    /**
     * 
     * @return boolean
     */
    public boolean isFilterLoadingShortcut();

    /**
     * Defines whether or not the manageable entity is filterable (advanced search)
     * @return boolean
     */
    public boolean isFilterable();

    /**
     * True if the Manageable Entity has at least one filter element (attribute or association).
     * Simple filter feature, for Rules
     * @return boolean
     */
    public boolean isFiltered();

    /**
     * True if the Manageable Entity has children that must be handled. Usefull for Rules.
     * @return boolean
     */
    public boolean isHasCustom();

    /**
     * Returns true if tagged value associated to custom sorters (K+TP Rule entity) is set to true
     * for Manageable Entity.
     * @return boolean
     */
    public boolean isHasCustomSorters();

    /**
     * 
     * @return boolean
     */
    public boolean isHasHelp();

    /**
     * 
     * @return boolean
     */
    public boolean isHasMaximumListSize();

    /**
     * 
     * @return boolean
     */
    public boolean isInsertable();

    /**
     * True if the manageable entity carries Interceptable stereotype (Interceptable object)
     * @return boolean
     */
    public boolean isInterceptable();

    /**
     * True if it is a custom manageable. In this case, it is related to another Manageable, and it
     * won't be a stand-alone Mask.
     * @return boolean
     */
    public boolean isIsCustom();

    /**
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return boolean
     */
    public boolean isMultipartFormData();

    /**
     * 
     * @return boolean
     */
    public boolean isNeedsFileUpload();

    /**
     * 
     * @return boolean
     */
    public boolean isNeedsUserInterface();

    /**
     * Defines whether or not the manageable entity edition form will be displayed in a pop-up
     * @return boolean
     */
    public boolean isPopEdition();

    /**
     * 
     * @return boolean
     */
    public boolean isPreload();

    /**
     * true if Manageable Entity carries RealTimeData stereotype
     * @return boolean
     */
    public boolean isRealTimeData();

    /**
     * Defines whether or not the manageable entity is referencable (sub blotter with drill down
     * references)
     * @return boolean
     */
    public boolean isReferencable();

    /**
     * 
     * @return boolean
     */
    public boolean isRegroupMandatoryFields();

    /**
     * 
     * @return boolean
     */
    public boolean isRemovable();

    /**
     * true if Manageable entity is a K+TP Rule
     * @return boolean
     */
    public boolean isRule();

    /**
     * 
     * @param element Object
     * @return boolean
     */
    public boolean isSearchable(Object element);

    /**
     * is True if Manageable entity has the corresponding tagged value set to true
     * @return boolean
     */
    public boolean isShowDeal();

    /**
     * 
     * @return boolean
     */
    public boolean isSortable();

    /**
     * True if it is possible to export the table data to XML, CSV, PDF or Excel format.
     * @return boolean
     */
    public boolean isTableExportable();

    /**
     * True if it is possible to sort the columns of the table.
     * @return boolean
     */
    public boolean isTableSortable();

    /**
     * 
     * @return boolean
     */
    public boolean isUpdatable();

    /**
     * 
     * @return boolean
     */
    public boolean isUseTemplating();

    /**
     * True if the manageable entity carries Validable stereotype (Validable object)
     * @return boolean
     */
    public boolean isValidable();

    /**
     * 
     * @return boolean
     */
    public boolean isValidationRequired();

    /**
     * True if the manageable entity carries Versionable stereotype (Versionable object)
     * @return boolean
     */
    public boolean isVersionable();

    /**
     * 
     * @return boolean
     */
    public boolean isVersionableRefExists();

    /**
     * 
     * @param serviceName String
     * @return boolean
     */
    public boolean serviceNameExists(String serviceName);
}