// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.swing.tree.TreeNode;
import org.andromda.metafacades.uml.FrontEndUseCase;

/**
 * A Gui use-case represents a set of related client/server requests and communication.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiUseCase
    extends FrontEndUseCase
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiUseCaseMetaType();

    /**
     * The name of the action class that forwards to this use case.
     * @return String
     */
    public String getActionClassName();

    /**
     * All forwards in this use case that are represented as actions.
     * @return List<GuiAction>
     */
    public List<GuiAction> getActionForwards();

    /**
     * This use-case's action path.
     * @return String
     */
    public String getActionPath();

    /**
     * The root of the action path.
     * @return String
     */
    public String getActionPathRoot();

    /**
     * TODO: Model Documentation for
     * GuiUseCase.getActionRoles
     * @return String
     */
    public String getActionRoles();

    /**
     * Constains all forwards includes regular FrontEndForwards and all actiion forwards.
     * @return List
     */
    public List getAllForwards();

    /**
     * A map with keys sorted alphabetically, normalized across all different use-cases and pages
     * etc..
     * @return Map
     */
    public Map getAllMessages();

    /**
     * This method returns all pages in the application. A page is an action state with the
     * FrontEndView stereotype.
     * @return List<GuiView>
     */
    public List<GuiView> getAllPages();

    /**
     * All views for the application (not just the ones belonging to this use case).
     * @return Collection<GuiView>
     */
    public Collection<GuiView> getAllViews();

    /**
     * The root node of the application usecase hierarchy. Only makes sense when this usecase is an
     * application usecase. Each usecase is only listed once in it's subtree, meaning when cycles ar
     * edetected in the applicaion usecase graph the usecase will not be added when it already
     * exists as an ancestor.
     * @return TreeNode
     */
    public TreeNode getApplicationHierarchyRoot();

    /**
     * TODO: Model Documentation for
     * GuiUseCase.containerHeight
     * @return String
     */
    public String getContainerHeight();

    /**
     * TODO: Model Documentation for
     * GuiUseCase.containerWidth
     * @return String
     */
    public String getContainerWidth();

    /**
     * The name of the action on the controller that executions this use case.
     * @return String
     */
    public String getControllerAction();

    /**
     * The name of the file containing specific styles for this use-case only.
     * @return String
     */
    public String getCssFileName();

    /**
     * A Gui use-case represents a set of related client/server requests and communication.
     * @return List<GuiUseCase>
     */
    public List<GuiUseCase> getDirectSubUseCases();

    /**
     * Returns the form fields used in this use-case, in fact these are all the parameters used in
     * client/server communication for this use-case.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getFormFields();

    /**
     * The key under which to store the forms contained in this use-case.
     * @return String
     */
    public String getFormKey();

    /**
     * The name that will cause a forward to use case.
     * @return String
     */
    public String getForwardName();

    /**
     * All forwards contained in this use case.
     * @return List<GuiForward>
     */
    public List<GuiForward> getForwards();

    /**
     * The name of the class that stores all the forwards paths.
     * @return String
     */
    public String getForwardsClassName();

    /**
     * The fully qualified name of the action class that forwards to this use case.
     * @return String
     */
    public String getFullyQualifiedActionClassName();

    /**
     * The fully qualified path to the action class that forwards to this use case.
     * @return String
     */
    public String getFullyQualifiedActionClassPath();

    /**
     * The root of the hierarchy of application usecases where this usecase is at the top. It is
     * possible not all usecases are included in the descendants, they can be found in the
     * collection of ancestor nodes.
     * @return TreeNode
     */
    public TreeNode getHierarchyRoot();

    /**
     * A Gui use-case represents a set of related client/server requests and communication.
     * @return Collection<GuiUseCase>
     */
    public Collection<GuiUseCase> getIncludedUseCases();

    /**
     * The path of the initial target going into this use case.
     * @return String
     */
    public String getInitialTargetPath();

    /**
     * TODO: Model Documentation for
     * GuiUseCase.getNavigationChildren
     * @return Collection
     */
    public Collection getNavigationChildren();

    /**
     * TODO: Model Documentation for
     * GuiUseCase.getNavigationParents
     * @return Collection
     */
    public Collection getNavigationParents();

    /**
     * Retrieves all navigation rules for the faces-config.xml
     * @return Collection
     */
    public Collection getNavigationRules();

    /**
     * The full path to this use-case's online help action. The returned String does not have a
     * suffix such as '.do'.
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
     * The full path to this use-case's online help page.
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
     * The variables for all pages in this use-case. A parameter qualifies to be a variable when it
     * explicitely and directly receives it via an action.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getPageVariables();

    /**
     * This method returns all pages in the use-case. A page is an action state with the
     * FrontEndView stereotype.
     * @return List<GuiView>
     */
    public List<GuiView> getPages();

    /**
     * The path to which this use case points.
     * @return String
     */
    public String getPath();

    /**
     * The root path for this use case (this is the path the directory containing the use case's
     * resources).
     * @return String
     */
    public String getPathRoot();

    /**
     * The forward name for the portlet 'edit' page.
     * @return String
     */
    public String getPortletEditForwardName();

    /**
     * The path to the portlet 'edit' page.
     * @return String
     */
    public String getPortletEditPath();

    /**
     * The forward name for the portlet 'help' page.
     * @return String
     */
    public String getPortletHelpForwardName();

    /**
     * The path to the 'help' page of the portlet.
     * @return String
     */
    public String getPortletHelpPath();

    /**
     * The forward name for the portlet 'view' page.
     * @return String
     */
    public String getPortletViewForwardName();

    /**
     * The path to the portlet 'view' page.
     * @return String
     */
    public String getPortletViewPath();

    /**
     * Represents the portlet preferences for a given use case (assuming the JSF application being
     * generated is a portlet).
     * @return GuiPortletPreferences
     */
    public GuiPortletPreferences getPreferences();

    /**
     * All use cases that are labled as registration use cases.
     * @return List<GuiUseCase>
     */
    public List<GuiUseCase> getRegistrationUseCases();

    /**
     * The title message key for this use-case.
     * @return String
     */
    public String getTitleKey();

    /**
     * The title message value for this use-case.
     * @return String
     */
    public String getTitleValue();

    /**
     * True if this use-case is where the application starts.
     * @return boolean
     */
    public boolean isApplicationUseCase();

    /**
     * True if at least one client/server parameter found in the collection of existing use-cases
     * requires validation.
     * @return boolean
     */
    public boolean isApplicationValidationRequired();

    /**
     * TODO: Model Documentation for GuiUseCase.container
     * @return boolean
     */
    public boolean isContainer();

    /**
     * TODO: Model Documentation for GuiUseCase.cyclic
     * @return boolean
     */
    public boolean isCyclic();

    /**
     * Indicates whether or not the initial target of this use case is a view or not.
     * @return boolean
     */
    public boolean isInitialTargetView();

    /**
     * Indicates whether or not this is a front-end registration use case.  Only one use case can be
     * labeled as a 'registration' use case.
     * @return boolean
     */
    public boolean isRegistrationUseCase();

    /**
     * True if some client/server parameters require validation for this use-case.
     * @return boolean
     */
    public boolean isValidationRequired();

    /**
     * Indicates whether or not at least one view in the use case has the same name as this use
     * case.
     * @return boolean
     */
    public boolean isViewHasNameOfUseCase();

    /**
     * TODO: Model Documentation for GuiUseCase.workbook
     * @return boolean
     */
    public boolean isWorkbook();

    /**
     * TODO: Model Documentation for GuiUseCase.worksheet
     * @return boolean
     */
    public boolean isWorksheet();
}