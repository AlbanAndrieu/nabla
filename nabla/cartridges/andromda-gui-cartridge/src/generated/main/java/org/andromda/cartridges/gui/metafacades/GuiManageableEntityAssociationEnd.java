// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;

/**
 * TODO: Model Documentation for
 * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiManageableEntityAssociationEnd
    extends ManageableEntityAssociationEnd
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiManageableEntityAssociationEndMetaType();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.backingListName
     * @return String
     */
    public String getBackingListName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.dictionaryReturnType
     * @return String
     */
    public String getDictionaryReturnType();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.displayName
     * @return String
     */
    public String getDisplayName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.functionalCoherency
     * @return String
     */
    public String getFunctionalCoherency();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.labelListName
     * @return String
     */
    public String getLabelListName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.messageKey
     * @return String
     */
    public String getMessageKey();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.messageValue
     * @return String
     */
    public String getMessageValue();

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return String
     */
    public String getOnlineHelpKey();

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return String
     */
    public String getOnlineHelpValue();

    /**
     * Retrieves Other End reference column name. Other end type must carry <<Entity>> and
     * <<BusinessReference>> stereotypes.
     * By default, if tagged value is left empty, name of business reference entity is taken. If it
     * does not exist, then shortname is taken.
     * @return String
     */
    public String getOtherEndReferenceColumnName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.valueListName
     * @return String
     */
    public String getValueListName();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.widgetType
     * @return String
     */
    public String getWidgetType();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.filterElement
     * @return boolean
     */
    public boolean isFilterElement();

    /**
     * Denotes a mandatory field (help group must have a value)
     * @return boolean
     */
    public boolean isMandatory();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.readOnlyForUpdate
     * @return boolean
     */
    public boolean isReadOnlyForUpdate();

    /**
     * True if this parameter has a name that can properly be handled by Jakarta commons (this lib
     * is used by Gui but contains a bug)
     * @return boolean
     */
    public boolean isSafeNamePresent();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiManageableEntityAssociationEnd.simpleDisplay
     * @return boolean
     */
    public boolean isSimpleDisplay();
}