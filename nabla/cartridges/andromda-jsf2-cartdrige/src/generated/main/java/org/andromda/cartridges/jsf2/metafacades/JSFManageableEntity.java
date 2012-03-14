// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.jsf2.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.ManageableEntity;
import org.andromda.metafacades.uml.Role;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface JSFManageableEntity
    extends ManageableEntity
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isJSFManageableEntityMetaType();

    /**
     * The name of the action class that executes the manageable actions.
     * @return String
     */
    public String getActionClassName();

    /**
     * The fully qualified path to the action class that execute the manageable actions.
     * @return String
     */
    public String getActionFullPath();

    /**
     * The path to the action class that execute the manageable actions.
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
     * The fully qualified name of the action class that execute the manageable actions.
     * @return String
     */
    public String getActionType();

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
     * @return Collection<Role>
     */
    public Collection<Role> getRoles();

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
     * @return String
     */
    public String getValueObjectClassName();

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
     * 
     * @return boolean
     */
    public boolean isNeedsFileUpload();

    /**
     * 
     * @return boolean
     */
    public boolean isPreload();

    /**
     * 
     * @param element Object
     * @return boolean
     */
    public boolean isSearchable(Object element);

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
    public boolean isValidationRequired();
}