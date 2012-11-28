// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.List;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.ModelElementFacade;

/**
 * A Gui view represents a page in the web application. A page possibly contains several conainters
 * and controls (either buttons or hyperlinks) that call actions. A Gui view allow generation of
 * EJBs and XML page descriptors
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiView
    extends FrontEndView
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiViewMetaType();

    /**
     * All those forwards that are actions.
     * @return List<GuiAction>
     */
    public List<GuiAction> getActionForwards();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.actionGroupName
     * @return String
     */
    public String getActionGroupName();

    /**
     * All variables that have backing value.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getBackingValueVariables();

    /**
     * The name of the file containing specific styles for this page only.
     * @return String
     */
    public String getCssFileName();

    /**
     * A resource message key suited for the page's documentation.
     * @return String
     */
    public String getDocumentationKey();

    /**
     * A resource message value suited for the page's documentation.
     * @return String
     */
    public String getDocumentationValue();

    /**
     * All actions that have forms associated with them.
     * @return List<GuiAction>
     */
    public List<GuiAction> getFormActions();

    /**
     * The key that stores the form in which information is passed from one action to another.
     * @return String
     */
    public String getFormKey();

    /**
     * Gets the forwards which can be targgeted from this view.
     * @return List<ModelElementFacade>
     */
    public List<ModelElementFacade> getForwards();

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @return String
     */
    public String getFromOutcome();

    /**
     * The full path to this view page.
     * @return String
     */
    public String getFullPath();

    /**
     * The fully qualified name of this view's form populator.
     * @return String
     */
    public String getFullyQualifiedPopulator();

    /**
     * Returns all actions that possibly result in returning this page.
     * @return List<GuiAction>
     */
    public List<GuiAction> getIncomingActions();

    /**
     * The default resource message key.
     * @return String
     */
    public String getMessageKey();

    /**
     * A displayable version of this page's name.
     * @return String
     */
    public String getMessageValue();

    /**
     * The collection of outgoing forwards that are not actions.
     * @return List<GuiForward>
     */
    public List<GuiForward> getNonActionForwards();

    /**
     * The full path to this view's online help action.
     * @return String
     */
    public String getOnlineHelpActionPath();

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return String
     */
    public String getOnlineHelpKey();

    /**
     * The full path to this view's online help page.
     * @return String
     */
    public String getOnlineHelpPagePath();

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return String
     */
    public String getOnlineHelpValue();

    /**
     * Returns all those variables that will be present as variables in the target page. These are
     * the trigger parameters on the incoming transitions.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getPageVariables();

    /**
     * The full path of the view resources (i.e. the JSP page).
     * @return String
     */
    public String getPath();

    /**
     * The name of the form populator for this view.
     * @return String
     */
    public String getPopulator();

    /**
     * The path to the form populator.
     * @return String
     */
    public String getPopulatorPath();

    /**
     * A resource message key suited for the page's title.
     * @return String
     */
    public String getTitleKey();

    /**
     * A default resource message value suited for the page's title.
     * @return String
     */
    public String getTitleValue();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.actionGroup
     * @return boolean
     */
    public boolean isActionGroup();

    /**
     * This attribute is true if the view is stereotyped with AsynchronousView
     * @return boolean
     */
    public boolean isAsynchronous();

    /**
     * True if this view contains a date field which requires a calendar popup.
     * @return boolean
     */
    public boolean isCalendarRequired();

    /**
     * True if any of the actions have a parameter of type Date.
     * @return boolean
     */
    public boolean isDateFieldPresent();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.expandable
     * @return boolean
     */
    public boolean isExpandable();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.filterView
     * @return boolean
     */
    public boolean isFilterView();

    /**
     * Indicates whether or not this view has the same name as the use case in which it is
     * contained.
     * @return boolean
     */
    public boolean isHasNameOfUseCase();

    /**
     * Returns true if the view contains only a table.
     * @return boolean
     */
    public boolean isHeldTable();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.mainToolbar
     * @return boolean
     */
    public boolean isMainToolbar();

    /**
     * Returns true if name of GuiView is unique in the domain of the parent worksheet useCase
     * @return boolean
     */
    public boolean isNameUniqueInWorksheetDomain();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.needsFileUpload
     * @return boolean
     */
    public boolean isNeedsFileUpload();

    /**
     * Indicates whether or not any non-table view variables are present in this view.
     * @return boolean
     */
    public boolean isNonTableVariablesPresent();

    /**
     * Indicates if a populator is required for this view.
     * @return boolean
     */
    public boolean isPopulatorRequired();

    /**
     * Indicates if this view represents a popup.
     * @return boolean
     */
    public boolean isPopup();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.tabs
     * @return boolean
     */
    public boolean isTabs();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.toolbar
     * @return boolean
     */
    public boolean isToolbar();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.transparent
     * @return boolean
     */
    public boolean isTransparent();

    /**
     * True if at least one client/server parameter requires validation.
     * @return boolean
     */
    public boolean isValidationRequired();

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.window
     * @return boolean
     */
    public boolean isWindow();
}