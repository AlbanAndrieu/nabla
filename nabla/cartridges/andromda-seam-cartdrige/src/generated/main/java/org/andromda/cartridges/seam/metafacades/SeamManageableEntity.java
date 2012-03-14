// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import org.andromda.metafacades.uml.ManageableEntity;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface SeamManageableEntity
    extends ManageableEntity
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isSeamManageableEntityMetaType();

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
    public String getActionType();

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
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return boolean
     */
    public boolean isMultipartFormData();

    /**
     * 
     * @return boolean
     */
    public boolean isPreload();

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
}