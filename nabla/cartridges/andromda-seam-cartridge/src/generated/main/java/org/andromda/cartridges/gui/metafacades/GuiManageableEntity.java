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
 * TODO: Model Documentation for GuiManageableEntity
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
     * TODO: Model Documentation for
     * GuiManageableEntity.eachBusinessObjectReferenceIsValid
     * @return boolean
     */
    public boolean eachBusinessObjectReferenceIsValid();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.actionClassName
     * @return String
     */
    public String getActionClassName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.actionFullPath
     * @return String
     */
    public String getActionFullPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.actionParameter
     * @return String
     */
    public String getActionParameter();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.actionPath
     * @return String
     */
    public String getActionPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getActionRoles
     * @return String
     */
    public String getActionRoles();

    /**
     * The calcuated serial version UID for this manageable actions.
     * @return String
     */
    public String getActionSerialVersionUID();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.actionType
     * @return String
     */
    public String getActionType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getAttributeNameByDisplayName
     * @param displayName String
     * @return String
     */
    public String getAttributeNameByDisplayName(String displayName);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getAttributeTypeByDisplayName
     * @param displayName String
     * @return String
     */
    public String getAttributeTypeByDisplayName(String displayName);

    /**
     * Represents a persistent entity.
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
     * TODO: Model Documentation for
     * GuiManageableEntity.converterClassName
     * @return String
     */
    public String getConverterClassName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.converterFullPath
     * @return String
     */
    public String getConverterFullPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.converterType
     * @return String
     */
    public String getConverterType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getCorrespondingRuleVOAttr
     * @param association GuiManageableEntityAssociationEnd
     * @return AttributeFacade
     */
    public AttributeFacade getCorrespondingRuleVOAttr(GuiManageableEntityAssociationEnd association);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getCorrespondingVOAttr
     * @param manageableAttr GuiManageableEntityAttribute
     * @return AttributeFacade
     */
    public AttributeFacade getCorrespondingVOAttr(GuiManageableEntityAttribute manageableAttr);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.createPreconditions
     * @return Collection
     */
    public Collection getCreatePreconditions();

    /**
     * TODO: Model Documentation for GuiManageableEntity
     * @return List<GuiManageableEntity>
     */
    public List<GuiManageableEntity> getCustomEntityReferences();

    /**
     * TODO: Model Documentation for GuiManageableEntity
     * @return GuiManageableEntity
     */
    public GuiManageableEntity getCustomOwner();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getCustomUseCaseActionType
     * @param customUseCaseName String
     * @return String
     */
    public String getCustomUseCaseActionType(String customUseCaseName);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getCustomUseCaseDisplayType
     * @param customUseCaseName String
     * @return String
     */
    public String getCustomUseCaseDisplayType(String customUseCaseName);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getCustomUseCases
     * @return Collection
     */
    public Collection getCustomUseCases();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.deletePreconditions
     * @return Collection
     */
    public Collection getDeletePreconditions();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.displayName
     * @return String
     */
    public String getDisplayName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.ejbInterfaceName
     * @return String
     */
    public String getEjbInterfaceName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.exceptionKey
     * @return String
     */
    public String getExceptionKey();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.exceptionPath
     * @return String
     */
    public String getExceptionPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getExternalUseCases
     * @return Collection
     */
    public Collection getExternalUseCases();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.formBeanClassName
     * @return String
     */
    public String getFormBeanClassName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.formBeanFullPath
     * @return String
     */
    public String getFormBeanFullPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.formBeanName
     * @return String
     */
    public String getFormBeanName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.formBeanType
     * @return String
     */
    public String getFormBeanType();

    /**
     * The calcuated serial version UID for this action's form.
     * @return String
     */
    public String getFormSerialVersionUID();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getIdentifierForBusinessObjectReference
     * @param businessObjectName String
     * @return String
     */
    public String getIdentifierForBusinessObjectReference(String businessObjectName);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.listGetterName
     * @return String
     */
    public String getListGetterName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.listName
     * @return String
     */
    public String getListName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.listSetterName
     * @return String
     */
    public String getListSetterName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.manageableExternalOrganization
     * @return Object
     */
    public Object getManageableExternalOrganization();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getManageableGeneralizationToDelete
     * @return ManageableEntity
     */
    public ManageableEntity getManageableGeneralizationToDelete();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.manageableSearchAssociationEnds
     * @return Collection
     */
    public Collection getManageableSearchAssociationEnds();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.manageableSearchAttributes
     * @return Collection
     */
    public Collection getManageableSearchAttributes();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.messageKey
     * @return String
     */
    public String getMessageKey();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.messageValue
     * @return String
     */
    public String getMessageValue();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.odsExportFullPath
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
     * TODO: Model Documentation for
     * GuiManageableEntity.pageFullPath
     * @return String
     */
    public String getPageFullPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.pageName
     * @return String
     */
    public String getPageName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.pageTitleKey
     * @return String
     */
    public String getPageTitleKey();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.pageTitleValue
     * @return String
     */
    public String getPageTitleValue();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.populatorFullPath
     * @return String
     */
    public String getPopulatorFullPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.populatorName
     * @return String
     */
    public String getPopulatorName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.populatorType
     * @return String
     */
    public String getPopulatorType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.preconditions
     * @return Collection
     */
    public Collection getPreconditions();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.roles
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
    public Collection getRulesSearchDatas();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.searchFormBeanClassName
     * @return String
     */
    public String getSearchFormBeanClassName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.searchFormBeanFullPath
     * @return String
     */
    public String getSearchFormBeanFullPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.searchFormBeanName
     * @return String
     */
    public String getSearchFormBeanName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.searchFormBeanType
     * @return String
     */
    public String getSearchFormBeanType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.securityName
     * @return String
     */
    public String getSecurityName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getShowDealDealId
     * @return AttributeFacade
     */
    public AttributeFacade getShowDealDealId();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.getShowDealDealType
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
     * TODO: Model Documentation for
     * GuiManageableEntity.updatePreconditions
     * @return Collection
     */
    public Collection getUpdatePreconditions();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.valueObjectClassName
     * @return String
     */
    public String getValueObjectClassName();

    /**
     * Represents a persistent entity.
     * @return Entity
     */
    public Entity getVersionableEntityReference();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.viewFullPath
     * @return String
     */
    public String getViewFullPath();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.viewName
     * @return String
     */
    public String getViewName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.viewTitleKey
     * @return String
     */
    public String getViewTitleKey();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.viewTitleValue
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
     * TODO: Model Documentation for
     * GuiManageableEntity.hasCustomUsecases
     * @return boolean
     */
    public boolean hasCustomUsecases();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.isAttributeOrAssociation
     * @param name String
     * @return boolean
     */
    public boolean isAttributeOrAssociation(String name);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.clonable
     * @return boolean
     */
    public boolean isClonable();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.editable
     * @return boolean
     */
    public boolean isEditable();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.exportable
     * @return boolean
     */
    public boolean isExportable();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.externalOrganizationExists
     * @return boolean
     */
    public boolean isExternalOrganizationExists();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.filterLoadingShortcut
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
     * TODO: Model Documentation for
     * GuiManageableEntity.hasHelp
     * @return boolean
     */
    public boolean isHasHelp();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.hasMaximumListSize
     * @return boolean
     */
    public boolean isHasMaximumListSize();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.insertable
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
     * TODO: Model Documentation for
     * GuiManageableEntity.needsFileUpload
     * @return boolean
     */
    public boolean isNeedsFileUpload();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.needsUserInterface
     * @return boolean
     */
    public boolean isNeedsUserInterface();

    /**
     * Defines whether or not the manageable entity edition form will be displayed in a pop-up
     * @return boolean
     */
    public boolean isPopEdition();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.preload
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
     * TODO: Model Documentation for
     * GuiManageableEntity.regroupMandatoryFields
     * @return boolean
     */
    public boolean isRegroupMandatoryFields();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.removable
     * @return boolean
     */
    public boolean isRemovable();

    /**
     * true if Manageable entity is a K+TP Rule
     * @return boolean
     */
    public boolean isRule();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.isSearchable
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
     * TODO: Model Documentation for
     * GuiManageableEntity.sortable
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
     * TODO: Model Documentation for
     * GuiManageableEntity.updatable
     * @return boolean
     */
    public boolean isUpdatable();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.useTemplating
     * @return boolean
     */
    public boolean isUseTemplating();

    /**
     * True if the manageable entity carries Validable stereotype (Validable object)
     * @return boolean
     */
    public boolean isValidable();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.validationRequired
     * @return boolean
     */
    public boolean isValidationRequired();

    /**
     * True if the manageable entity carries Versionable stereotype (Versionable object)
     * @return boolean
     */
    public boolean isVersionable();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.versionableRefExists
     * @return boolean
     */
    public boolean isVersionableRefExists();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntity.serviceNameExists
     * @param serviceName String
     * @return boolean
     */
    public boolean serviceNameExists(String serviceName);
}