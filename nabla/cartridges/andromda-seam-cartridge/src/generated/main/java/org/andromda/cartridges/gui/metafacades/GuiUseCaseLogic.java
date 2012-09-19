// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.swing.tree.TreeNode;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ActivityGraphFacade;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.ExtendFacade;
import org.andromda.metafacades.uml.ExtensionPointFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndActivityGraph;
import org.andromda.metafacades.uml.FrontEndController;
import org.andromda.metafacades.uml.FrontEndFinalState;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndUseCase;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.GeneralizationFacade;
import org.andromda.metafacades.uml.IncludeFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.andromda.translation.ocl.validation.OCLCollections;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.log4j.Logger;

/**
 * A Gui use-case represents a set of related client/server requests and communication.
 * MetafacadeLogic for GuiUseCase
 *
 * @see GuiUseCase
 */
public abstract class GuiUseCaseLogic
    extends MetafacadeBase
    implements GuiUseCase
{

    private static final long serialVersionUID = 1L;
    
    /**
     * The underlying UML object
     * @see Object
     */
    protected transient Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected GuiUseCaseLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superFrontEndUseCase =
           (FrontEndUseCase)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.FrontEndUseCase",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiUseCaseLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiUseCase if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiUseCase";
        }
        return context;
    }

    private FrontEndUseCase superFrontEndUseCase;
    private boolean superFrontEndUseCaseInitialized = false;

    /**
     * Gets the FrontEndUseCase parent instance.
     * @return this.superFrontEndUseCase FrontEndUseCase
     */
    private FrontEndUseCase getSuperFrontEndUseCase()
    {
        if (!this.superFrontEndUseCaseInitialized)
        {
            ((MetafacadeBase)this.superFrontEndUseCase).setMetafacadeContext(this.getMetafacadeContext());
            this.superFrontEndUseCaseInitialized = true;
        }
        return this.superFrontEndUseCase;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superFrontEndUseCaseInitialized)
            {
                ((MetafacadeBase)this.superFrontEndUseCase).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see GuiUseCase
     */
    public boolean isGuiUseCaseMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see GuiUseCase#getTitleKey()
    * @return String
    */
    protected abstract String handleGetTitleKey();

    private String titleKey1a;
    private boolean titleKey1aSet = false;

    /**
     * The title message key for this use-case.
     * @return (String)handleGetTitleKey()
     */
    public final String getTitleKey()
    {
        String atitleKey1a = this.titleKey1a;
        if (!this.titleKey1aSet)
        {
            // titleKey has no pre constraints
            atitleKey1a = handleGetTitleKey();
            // titleKey has no post constraints
            this.titleKey1a = atitleKey1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.titleKey1aSet = true;
            }
        }
        return atitleKey1a;
    }

   /**
    * @see GuiUseCase#getTitleValue()
    * @return String
    */
    protected abstract String handleGetTitleValue();

    private String titleValue2a;
    private boolean titleValue2aSet = false;

    /**
     * The title message value for this use-case.
     * @return (String)handleGetTitleValue()
     */
    public final String getTitleValue()
    {
        String atitleValue2a = this.titleValue2a;
        if (!this.titleValue2aSet)
        {
            // titleValue has no pre constraints
            atitleValue2a = handleGetTitleValue();
            // titleValue has no post constraints
            this.titleValue2a = atitleValue2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.titleValue2aSet = true;
            }
        }
        return atitleValue2a;
    }

   /**
    * @see GuiUseCase#getActionPath()
    * @return String
    */
    protected abstract String handleGetActionPath();

    private String actionPath3a;
    private boolean actionPath3aSet = false;

    /**
     * This use-case's action path.
     * @return (String)handleGetActionPath()
     */
    public final String getActionPath()
    {
        String aactionPath3a = this.actionPath3a;
        if (!this.actionPath3aSet)
        {
            // actionPath has no pre constraints
            aactionPath3a = handleGetActionPath();
            // actionPath has no post constraints
            this.actionPath3a = aactionPath3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionPath3aSet = true;
            }
        }
        return aactionPath3a;
    }

   /**
    * @see GuiUseCase#getActionPathRoot()
    * @return String
    */
    protected abstract String handleGetActionPathRoot();

    private String actionPathRoot4a;
    private boolean actionPathRoot4aSet = false;

    /**
     * The root of the action path.
     * @return (String)handleGetActionPathRoot()
     */
    public final String getActionPathRoot()
    {
        String aactionPathRoot4a = this.actionPathRoot4a;
        if (!this.actionPathRoot4aSet)
        {
            // actionPathRoot has no pre constraints
            aactionPathRoot4a = handleGetActionPathRoot();
            // actionPathRoot has no post constraints
            this.actionPathRoot4a = aactionPathRoot4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionPathRoot4aSet = true;
            }
        }
        return aactionPathRoot4a;
    }

   /**
    * @see GuiUseCase#isApplicationValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsApplicationValidationRequired();

    private boolean applicationValidationRequired5a;
    private boolean applicationValidationRequired5aSet = false;

    /**
     * True if at least one client/server parameter found in the collection of existing use-cases
     * requires validation.
     * @return (boolean)handleIsApplicationValidationRequired()
     */
    public final boolean isApplicationValidationRequired()
    {
        boolean aapplicationValidationRequired5a = this.applicationValidationRequired5a;
        if (!this.applicationValidationRequired5aSet)
        {
            // applicationValidationRequired has no pre constraints
            aapplicationValidationRequired5a = handleIsApplicationValidationRequired();
            // applicationValidationRequired has no post constraints
            this.applicationValidationRequired5a = aapplicationValidationRequired5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.applicationValidationRequired5aSet = true;
            }
        }
        return aapplicationValidationRequired5a;
    }

   /**
    * @see GuiUseCase#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private boolean validationRequired6a;
    private boolean validationRequired6aSet = false;

    /**
     * True if some client/server parameters require validation for this use-case.
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean avalidationRequired6a = this.validationRequired6a;
        if (!this.validationRequired6aSet)
        {
            // validationRequired has no pre constraints
            avalidationRequired6a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.validationRequired6a = avalidationRequired6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validationRequired6aSet = true;
            }
        }
        return avalidationRequired6a;
    }

   /**
    * @see GuiUseCase#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String onlineHelpKey7a;
    private boolean onlineHelpKey7aSet = false;

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String aonlineHelpKey7a = this.onlineHelpKey7a;
        if (!this.onlineHelpKey7aSet)
        {
            // onlineHelpKey has no pre constraints
            aonlineHelpKey7a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.onlineHelpKey7a = aonlineHelpKey7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpKey7aSet = true;
            }
        }
        return aonlineHelpKey7a;
    }

   /**
    * @see GuiUseCase#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String onlineHelpValue8a;
    private boolean onlineHelpValue8aSet = false;

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String aonlineHelpValue8a = this.onlineHelpValue8a;
        if (!this.onlineHelpValue8aSet)
        {
            // onlineHelpValue has no pre constraints
            aonlineHelpValue8a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.onlineHelpValue8a = aonlineHelpValue8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpValue8aSet = true;
            }
        }
        return aonlineHelpValue8a;
    }

   /**
    * @see GuiUseCase#isApplicationUseCase()
    * @return boolean
    */
    protected abstract boolean handleIsApplicationUseCase();

    private boolean applicationUseCase9a;
    private boolean applicationUseCase9aSet = false;

    /**
     * True if this use-case is where the application starts.
     * @return (boolean)handleIsApplicationUseCase()
     */
    public final boolean isApplicationUseCase()
    {
        boolean aapplicationUseCase9a = this.applicationUseCase9a;
        if (!this.applicationUseCase9aSet)
        {
            // applicationUseCase has no pre constraints
            aapplicationUseCase9a = handleIsApplicationUseCase();
            // applicationUseCase has no post constraints
            this.applicationUseCase9a = aapplicationUseCase9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.applicationUseCase9aSet = true;
            }
        }
        return aapplicationUseCase9a;
    }

   /**
    * @see GuiUseCase#getApplicationHierarchyRoot()
    * @return TreeNode
    */
    protected abstract TreeNode handleGetApplicationHierarchyRoot();

    private TreeNode applicationHierarchyRoot10a;
    private boolean applicationHierarchyRoot10aSet = false;

    /**
     * The root node of the application usecase hierarchy. Only makes sense when this usecase is an
     * application usecase. Each usecase is only listed once in it's subtree, meaning when cycles ar
     * edetected in the applicaion usecase graph the usecase will not be added when it already
     * exists as an ancestor.
     * @return (TreeNode)handleGetApplicationHierarchyRoot()
     */
    public final TreeNode getApplicationHierarchyRoot()
    {
        TreeNode aapplicationHierarchyRoot10a = this.applicationHierarchyRoot10a;
        if (!this.applicationHierarchyRoot10aSet)
        {
            // applicationHierarchyRoot has no pre constraints
            aapplicationHierarchyRoot10a = handleGetApplicationHierarchyRoot();
            // applicationHierarchyRoot has no post constraints
            this.applicationHierarchyRoot10a = aapplicationHierarchyRoot10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.applicationHierarchyRoot10aSet = true;
            }
        }
        return aapplicationHierarchyRoot10a;
    }

   /**
    * @see GuiUseCase#getHierarchyRoot()
    * @return TreeNode
    */
    protected abstract TreeNode handleGetHierarchyRoot();

    private TreeNode hierarchyRoot11a;
    private boolean hierarchyRoot11aSet = false;

    /**
     * The root of the hierarchy of application usecases where this usecase is at the top. It is
     * possible not all usecases are included in the descendants, they can be found in the
     * collection of ancestor nodes.
     * @return (TreeNode)handleGetHierarchyRoot()
     */
    public final TreeNode getHierarchyRoot()
    {
        TreeNode ahierarchyRoot11a = this.hierarchyRoot11a;
        if (!this.hierarchyRoot11aSet)
        {
            // hierarchyRoot has no pre constraints
            ahierarchyRoot11a = handleGetHierarchyRoot();
            // hierarchyRoot has no post constraints
            this.hierarchyRoot11a = ahierarchyRoot11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hierarchyRoot11aSet = true;
            }
        }
        return ahierarchyRoot11a;
    }

   /**
    * @see GuiUseCase#getCssFileName()
    * @return String
    */
    protected abstract String handleGetCssFileName();

    private String cssFileName12a;
    private boolean cssFileName12aSet = false;

    /**
     * The name of the file containing specific styles for this use-case only.
     * @return (String)handleGetCssFileName()
     */
    public final String getCssFileName()
    {
        String acssFileName12a = this.cssFileName12a;
        if (!this.cssFileName12aSet)
        {
            // cssFileName has no pre constraints
            acssFileName12a = handleGetCssFileName();
            // cssFileName has no post constraints
            this.cssFileName12a = acssFileName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.cssFileName12aSet = true;
            }
        }
        return acssFileName12a;
    }

   /**
    * @see GuiUseCase#getAllMessages()
    * @return Map
    */
    protected abstract Map handleGetAllMessages();

    private Map allMessages13a;
    private boolean allMessages13aSet = false;

    /**
     * A map with keys sorted alphabetically, normalized across all different use-cases and pages
     * etc..
     * @return (Map)handleGetAllMessages()
     */
    public final Map getAllMessages()
    {
        Map aallMessages13a = this.allMessages13a;
        if (!this.allMessages13aSet)
        {
            // allMessages has no pre constraints
            aallMessages13a = handleGetAllMessages();
            // allMessages has no post constraints
            this.allMessages13a = aallMessages13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.allMessages13aSet = true;
            }
        }
        return aallMessages13a;
    }

   /**
    * @see GuiUseCase#isCyclic()
    * @return boolean
    */
    protected abstract boolean handleIsCyclic();

    private boolean cyclic14a;
    private boolean cyclic14aSet = false;

    /**
     * 
     * @return (boolean)handleIsCyclic()
     */
    public final boolean isCyclic()
    {
        boolean acyclic14a = this.cyclic14a;
        if (!this.cyclic14aSet)
        {
            // cyclic has no pre constraints
            acyclic14a = handleIsCyclic();
            // cyclic has no post constraints
            this.cyclic14a = acyclic14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.cyclic14aSet = true;
            }
        }
        return acyclic14a;
    }

   /**
    * @see GuiUseCase#getOnlineHelpPagePath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpPagePath();

    private String onlineHelpPagePath15a;
    private boolean onlineHelpPagePath15aSet = false;

    /**
     * The full path to this use-case's online help page.
     * @return (String)handleGetOnlineHelpPagePath()
     */
    public final String getOnlineHelpPagePath()
    {
        String aonlineHelpPagePath15a = this.onlineHelpPagePath15a;
        if (!this.onlineHelpPagePath15aSet)
        {
            // onlineHelpPagePath has no pre constraints
            aonlineHelpPagePath15a = handleGetOnlineHelpPagePath();
            // onlineHelpPagePath has no post constraints
            this.onlineHelpPagePath15a = aonlineHelpPagePath15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpPagePath15aSet = true;
            }
        }
        return aonlineHelpPagePath15a;
    }

   /**
    * @see GuiUseCase#getOnlineHelpActionPath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpActionPath();

    private String onlineHelpActionPath16a;
    private boolean onlineHelpActionPath16aSet = false;

    /**
     * The full path to this use-case's online help action. The returned String does not have a
     * suffix such as '.do'.
     * @return (String)handleGetOnlineHelpActionPath()
     */
    public final String getOnlineHelpActionPath()
    {
        String aonlineHelpActionPath16a = this.onlineHelpActionPath16a;
        if (!this.onlineHelpActionPath16aSet)
        {
            // onlineHelpActionPath has no pre constraints
            aonlineHelpActionPath16a = handleGetOnlineHelpActionPath();
            // onlineHelpActionPath has no post constraints
            this.onlineHelpActionPath16a = aonlineHelpActionPath16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpActionPath16aSet = true;
            }
        }
        return aonlineHelpActionPath16a;
    }

   /**
    * @see GuiUseCase#getFormKey()
    * @return String
    */
    protected abstract String handleGetFormKey();

    private String formKey17a;
    private boolean formKey17aSet = false;

    /**
     * The key under which to store the forms contained in this use-case.
     * @return (String)handleGetFormKey()
     */
    public final String getFormKey()
    {
        String aformKey17a = this.formKey17a;
        if (!this.formKey17aSet)
        {
            // formKey has no pre constraints
            aformKey17a = handleGetFormKey();
            // formKey has no post constraints
            this.formKey17a = aformKey17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formKey17aSet = true;
            }
        }
        return aformKey17a;
    }

   /**
    * @see GuiUseCase#isWorkbook()
    * @return boolean
    */
    protected abstract boolean handleIsWorkbook();

    private boolean workbook18a;
    private boolean workbook18aSet = false;

    /**
     * 
     * @return (boolean)handleIsWorkbook()
     */
    public final boolean isWorkbook()
    {
        boolean aworkbook18a = this.workbook18a;
        if (!this.workbook18aSet)
        {
            // workbook has no pre constraints
            aworkbook18a = handleIsWorkbook();
            // workbook has no post constraints
            this.workbook18a = aworkbook18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.workbook18aSet = true;
            }
        }
        return aworkbook18a;
    }

   /**
    * @see GuiUseCase#isWorksheet()
    * @return boolean
    */
    protected abstract boolean handleIsWorksheet();

    private boolean worksheet19a;
    private boolean worksheet19aSet = false;

    /**
     * 
     * @return (boolean)handleIsWorksheet()
     */
    public final boolean isWorksheet()
    {
        boolean aworksheet19a = this.worksheet19a;
        if (!this.worksheet19aSet)
        {
            // worksheet has no pre constraints
            aworksheet19a = handleIsWorksheet();
            // worksheet has no post constraints
            this.worksheet19a = aworksheet19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.worksheet19aSet = true;
            }
        }
        return aworksheet19a;
    }

   /**
    * @see GuiUseCase#isContainer()
    * @return boolean
    */
    protected abstract boolean handleIsContainer();

    private boolean container20a;
    private boolean container20aSet = false;

    /**
     * 
     * @return (boolean)handleIsContainer()
     */
    public final boolean isContainer()
    {
        boolean acontainer20a = this.container20a;
        if (!this.container20aSet)
        {
            // container has no pre constraints
            acontainer20a = handleIsContainer();
            // container has no post constraints
            this.container20a = acontainer20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.container20aSet = true;
            }
        }
        return acontainer20a;
    }

   /**
    * @see GuiUseCase#getContainerHeight()
    * @return String
    */
    protected abstract String handleGetContainerHeight();

    private String containerHeight21a;
    private boolean containerHeight21aSet = false;

    /**
     * 
     * @return (String)handleGetContainerHeight()
     */
    public final String getContainerHeight()
    {
        String acontainerHeight21a = this.containerHeight21a;
        if (!this.containerHeight21aSet)
        {
            // containerHeight has no pre constraints
            acontainerHeight21a = handleGetContainerHeight();
            // containerHeight has no post constraints
            this.containerHeight21a = acontainerHeight21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.containerHeight21aSet = true;
            }
        }
        return acontainerHeight21a;
    }

   /**
    * @see GuiUseCase#getContainerWidth()
    * @return String
    */
    protected abstract String handleGetContainerWidth();

    private String containerWidth22a;
    private boolean containerWidth22aSet = false;

    /**
     * 
     * @return (String)handleGetContainerWidth()
     */
    public final String getContainerWidth()
    {
        String acontainerWidth22a = this.containerWidth22a;
        if (!this.containerWidth22aSet)
        {
            // containerWidth has no pre constraints
            acontainerWidth22a = handleGetContainerWidth();
            // containerWidth has no post constraints
            this.containerWidth22a = acontainerWidth22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.containerWidth22aSet = true;
            }
        }
        return acontainerWidth22a;
    }

   /**
    * @see GuiUseCase#getPath()
    * @return String
    */
    protected abstract String handleGetPath();

    private String path23a;
    private boolean path23aSet = false;

    /**
     * The path to which this use case points.
     * @return (String)handleGetPath()
     */
    public final String getPath()
    {
        String apath23a = this.path23a;
        if (!this.path23aSet)
        {
            // path has no pre constraints
            apath23a = handleGetPath();
            // path has no post constraints
            this.path23a = apath23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.path23aSet = true;
            }
        }
        return apath23a;
    }

   /**
    * @see GuiUseCase#getPathRoot()
    * @return String
    */
    protected abstract String handleGetPathRoot();

    private String pathRoot24a;
    private boolean pathRoot24aSet = false;

    /**
     * The root path for this use case (this is the path the directory containing the use case's
     * resources).
     * @return (String)handleGetPathRoot()
     */
    public final String getPathRoot()
    {
        String apathRoot24a = this.pathRoot24a;
        if (!this.pathRoot24aSet)
        {
            // pathRoot has no pre constraints
            apathRoot24a = handleGetPathRoot();
            // pathRoot has no post constraints
            this.pathRoot24a = apathRoot24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.pathRoot24aSet = true;
            }
        }
        return apathRoot24a;
    }

   /**
    * @see GuiUseCase#getForwardName()
    * @return String
    */
    protected abstract String handleGetForwardName();

    private String forwardName25a;
    private boolean forwardName25aSet = false;

    /**
     * The name that will cause a forward to use case.
     * @return (String)handleGetForwardName()
     */
    public final String getForwardName()
    {
        String aforwardName25a = this.forwardName25a;
        if (!this.forwardName25aSet)
        {
            // forwardName has no pre constraints
            aforwardName25a = handleGetForwardName();
            // forwardName has no post constraints
            this.forwardName25a = aforwardName25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.forwardName25aSet = true;
            }
        }
        return aforwardName25a;
    }

   /**
    * @see GuiUseCase#getActionClassName()
    * @return String
    */
    protected abstract String handleGetActionClassName();

    private String actionClassName26a;
    private boolean actionClassName26aSet = false;

    /**
     * The name of the action class that forwards to this use case.
     * @return (String)handleGetActionClassName()
     */
    public final String getActionClassName()
    {
        String aactionClassName26a = this.actionClassName26a;
        if (!this.actionClassName26aSet)
        {
            // actionClassName has no pre constraints
            aactionClassName26a = handleGetActionClassName();
            // actionClassName has no post constraints
            this.actionClassName26a = aactionClassName26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionClassName26aSet = true;
            }
        }
        return aactionClassName26a;
    }

   /**
    * @see GuiUseCase#getFullyQualifiedActionClassPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassPath();

    private String fullyQualifiedActionClassPath27a;
    private boolean fullyQualifiedActionClassPath27aSet = false;

    /**
     * The fully qualified path to the action class that forwards to this use case.
     * @return (String)handleGetFullyQualifiedActionClassPath()
     */
    public final String getFullyQualifiedActionClassPath()
    {
        String afullyQualifiedActionClassPath27a = this.fullyQualifiedActionClassPath27a;
        if (!this.fullyQualifiedActionClassPath27aSet)
        {
            // fullyQualifiedActionClassPath has no pre constraints
            afullyQualifiedActionClassPath27a = handleGetFullyQualifiedActionClassPath();
            // fullyQualifiedActionClassPath has no post constraints
            this.fullyQualifiedActionClassPath27a = afullyQualifiedActionClassPath27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedActionClassPath27aSet = true;
            }
        }
        return afullyQualifiedActionClassPath27a;
    }

   /**
    * @see GuiUseCase#getControllerAction()
    * @return String
    */
    protected abstract String handleGetControllerAction();

    private String controllerAction28a;
    private boolean controllerAction28aSet = false;

    /**
     * The name of the action on the controller that executions this use case.
     * @return (String)handleGetControllerAction()
     */
    public final String getControllerAction()
    {
        String acontrollerAction28a = this.controllerAction28a;
        if (!this.controllerAction28aSet)
        {
            // controllerAction has no pre constraints
            acontrollerAction28a = handleGetControllerAction();
            // controllerAction has no post constraints
            this.controllerAction28a = acontrollerAction28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.controllerAction28aSet = true;
            }
        }
        return acontrollerAction28a;
    }

   /**
    * @see GuiUseCase#getFullyQualifiedActionClassName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassName();

    private String fullyQualifiedActionClassName29a;
    private boolean fullyQualifiedActionClassName29aSet = false;

    /**
     * The fully qualified name of the action class that forwards to this use case.
     * @return (String)handleGetFullyQualifiedActionClassName()
     */
    public final String getFullyQualifiedActionClassName()
    {
        String afullyQualifiedActionClassName29a = this.fullyQualifiedActionClassName29a;
        if (!this.fullyQualifiedActionClassName29aSet)
        {
            // fullyQualifiedActionClassName has no pre constraints
            afullyQualifiedActionClassName29a = handleGetFullyQualifiedActionClassName();
            // fullyQualifiedActionClassName has no post constraints
            this.fullyQualifiedActionClassName29a = afullyQualifiedActionClassName29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedActionClassName29aSet = true;
            }
        }
        return afullyQualifiedActionClassName29a;
    }

   /**
    * @see GuiUseCase#getInitialTargetPath()
    * @return String
    */
    protected abstract String handleGetInitialTargetPath();

    private String initialTargetPath30a;
    private boolean initialTargetPath30aSet = false;

    /**
     * The path of the initial target going into this use case.
     * @return (String)handleGetInitialTargetPath()
     */
    public final String getInitialTargetPath()
    {
        String ainitialTargetPath30a = this.initialTargetPath30a;
        if (!this.initialTargetPath30aSet)
        {
            // initialTargetPath has no pre constraints
            ainitialTargetPath30a = handleGetInitialTargetPath();
            // initialTargetPath has no post constraints
            this.initialTargetPath30a = ainitialTargetPath30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.initialTargetPath30aSet = true;
            }
        }
        return ainitialTargetPath30a;
    }

   /**
    * @see GuiUseCase#isInitialTargetView()
    * @return boolean
    */
    protected abstract boolean handleIsInitialTargetView();

    private boolean initialTargetView31a;
    private boolean initialTargetView31aSet = false;

    /**
     * Indicates whether or not the initial target of this use case is a view or not.
     * @return (boolean)handleIsInitialTargetView()
     */
    public final boolean isInitialTargetView()
    {
        boolean ainitialTargetView31a = this.initialTargetView31a;
        if (!this.initialTargetView31aSet)
        {
            // initialTargetView has no pre constraints
            ainitialTargetView31a = handleIsInitialTargetView();
            // initialTargetView has no post constraints
            this.initialTargetView31a = ainitialTargetView31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.initialTargetView31aSet = true;
            }
        }
        return ainitialTargetView31a;
    }

   /**
    * @see GuiUseCase#isViewHasNameOfUseCase()
    * @return boolean
    */
    protected abstract boolean handleIsViewHasNameOfUseCase();

    private boolean viewHasNameOfUseCase32a;
    private boolean viewHasNameOfUseCase32aSet = false;

    /**
     * Indicates whether or not at least one view in the use case has the same name as this use
     * case.
     * @return (boolean)handleIsViewHasNameOfUseCase()
     */
    public final boolean isViewHasNameOfUseCase()
    {
        boolean aviewHasNameOfUseCase32a = this.viewHasNameOfUseCase32a;
        if (!this.viewHasNameOfUseCase32aSet)
        {
            // viewHasNameOfUseCase has no pre constraints
            aviewHasNameOfUseCase32a = handleIsViewHasNameOfUseCase();
            // viewHasNameOfUseCase has no post constraints
            this.viewHasNameOfUseCase32a = aviewHasNameOfUseCase32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewHasNameOfUseCase32aSet = true;
            }
        }
        return aviewHasNameOfUseCase32a;
    }

   /**
    * @see GuiUseCase#isRegistrationUseCase()
    * @return boolean
    */
    protected abstract boolean handleIsRegistrationUseCase();

    private boolean registrationUseCase33a;
    private boolean registrationUseCase33aSet = false;

    /**
     * Indicates whether or not this is a front-end registration use case.  Only one use case can be
     * labeled as a 'registration' use case.
     * @return (boolean)handleIsRegistrationUseCase()
     */
    public final boolean isRegistrationUseCase()
    {
        boolean aregistrationUseCase33a = this.registrationUseCase33a;
        if (!this.registrationUseCase33aSet)
        {
            // registrationUseCase has no pre constraints
            aregistrationUseCase33a = handleIsRegistrationUseCase();
            // registrationUseCase has no post constraints
            this.registrationUseCase33a = aregistrationUseCase33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.registrationUseCase33aSet = true;
            }
        }
        return aregistrationUseCase33a;
    }

   /**
    * @see GuiUseCase#getForwardsClassName()
    * @return String
    */
    protected abstract String handleGetForwardsClassName();

    private String forwardsClassName34a;
    private boolean forwardsClassName34aSet = false;

    /**
     * The name of the class that stores all the forwards paths.
     * @return (String)handleGetForwardsClassName()
     */
    public final String getForwardsClassName()
    {
        String aforwardsClassName34a = this.forwardsClassName34a;
        if (!this.forwardsClassName34aSet)
        {
            // forwardsClassName has no pre constraints
            aforwardsClassName34a = handleGetForwardsClassName();
            // forwardsClassName has no post constraints
            this.forwardsClassName34a = aforwardsClassName34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.forwardsClassName34aSet = true;
            }
        }
        return aforwardsClassName34a;
    }

   /**
    * @see GuiUseCase#getAllForwards()
    * @return List
    */
    protected abstract List handleGetAllForwards();

    private List allForwards35a;
    private boolean allForwards35aSet = false;

    /**
     * Constains all forwards includes regular FrontEndForwards and all actiion forwards.
     * @return (List)handleGetAllForwards()
     */
    public final List getAllForwards()
    {
        List aallForwards35a = this.allForwards35a;
        if (!this.allForwards35aSet)
        {
            // allForwards has no pre constraints
            aallForwards35a = handleGetAllForwards();
            // allForwards has no post constraints
            this.allForwards35a = aallForwards35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.allForwards35aSet = true;
            }
        }
        return aallForwards35a;
    }

   /**
    * @see GuiUseCase#getPortletViewForwardName()
    * @return String
    */
    protected abstract String handleGetPortletViewForwardName();

    private String portletViewForwardName36a;
    private boolean portletViewForwardName36aSet = false;

    /**
     * The forward name for the portlet 'view' page.
     * @return (String)handleGetPortletViewForwardName()
     */
    public final String getPortletViewForwardName()
    {
        String aportletViewForwardName36a = this.portletViewForwardName36a;
        if (!this.portletViewForwardName36aSet)
        {
            // portletViewForwardName has no pre constraints
            aportletViewForwardName36a = handleGetPortletViewForwardName();
            // portletViewForwardName has no post constraints
            this.portletViewForwardName36a = aportletViewForwardName36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.portletViewForwardName36aSet = true;
            }
        }
        return aportletViewForwardName36a;
    }

   /**
    * @see GuiUseCase#getPortletEditForwardName()
    * @return String
    */
    protected abstract String handleGetPortletEditForwardName();

    private String portletEditForwardName37a;
    private boolean portletEditForwardName37aSet = false;

    /**
     * The forward name for the portlet 'edit' page.
     * @return (String)handleGetPortletEditForwardName()
     */
    public final String getPortletEditForwardName()
    {
        String aportletEditForwardName37a = this.portletEditForwardName37a;
        if (!this.portletEditForwardName37aSet)
        {
            // portletEditForwardName has no pre constraints
            aportletEditForwardName37a = handleGetPortletEditForwardName();
            // portletEditForwardName has no post constraints
            this.portletEditForwardName37a = aportletEditForwardName37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.portletEditForwardName37aSet = true;
            }
        }
        return aportletEditForwardName37a;
    }

   /**
    * @see GuiUseCase#getPortletHelpForwardName()
    * @return String
    */
    protected abstract String handleGetPortletHelpForwardName();

    private String portletHelpForwardName38a;
    private boolean portletHelpForwardName38aSet = false;

    /**
     * The forward name for the portlet 'help' page.
     * @return (String)handleGetPortletHelpForwardName()
     */
    public final String getPortletHelpForwardName()
    {
        String aportletHelpForwardName38a = this.portletHelpForwardName38a;
        if (!this.portletHelpForwardName38aSet)
        {
            // portletHelpForwardName has no pre constraints
            aportletHelpForwardName38a = handleGetPortletHelpForwardName();
            // portletHelpForwardName has no post constraints
            this.portletHelpForwardName38a = aportletHelpForwardName38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.portletHelpForwardName38aSet = true;
            }
        }
        return aportletHelpForwardName38a;
    }

   /**
    * @see GuiUseCase#getPortletViewPath()
    * @return String
    */
    protected abstract String handleGetPortletViewPath();

    private String portletViewPath39a;
    private boolean portletViewPath39aSet = false;

    /**
     * The path to the portlet 'view' page.
     * @return (String)handleGetPortletViewPath()
     */
    public final String getPortletViewPath()
    {
        String aportletViewPath39a = this.portletViewPath39a;
        if (!this.portletViewPath39aSet)
        {
            // portletViewPath has no pre constraints
            aportletViewPath39a = handleGetPortletViewPath();
            // portletViewPath has no post constraints
            this.portletViewPath39a = aportletViewPath39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.portletViewPath39aSet = true;
            }
        }
        return aportletViewPath39a;
    }

   /**
    * @see GuiUseCase#getPortletEditPath()
    * @return String
    */
    protected abstract String handleGetPortletEditPath();

    private String portletEditPath40a;
    private boolean portletEditPath40aSet = false;

    /**
     * The path to the portlet 'edit' page.
     * @return (String)handleGetPortletEditPath()
     */
    public final String getPortletEditPath()
    {
        String aportletEditPath40a = this.portletEditPath40a;
        if (!this.portletEditPath40aSet)
        {
            // portletEditPath has no pre constraints
            aportletEditPath40a = handleGetPortletEditPath();
            // portletEditPath has no post constraints
            this.portletEditPath40a = aportletEditPath40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.portletEditPath40aSet = true;
            }
        }
        return aportletEditPath40a;
    }

   /**
    * @see GuiUseCase#getPortletHelpPath()
    * @return String
    */
    protected abstract String handleGetPortletHelpPath();

    private String portletHelpPath41a;
    private boolean portletHelpPath41aSet = false;

    /**
     * The path to the 'help' page of the portlet.
     * @return (String)handleGetPortletHelpPath()
     */
    public final String getPortletHelpPath()
    {
        String aportletHelpPath41a = this.portletHelpPath41a;
        if (!this.portletHelpPath41aSet)
        {
            // portletHelpPath has no pre constraints
            aportletHelpPath41a = handleGetPortletHelpPath();
            // portletHelpPath has no post constraints
            this.portletHelpPath41a = aportletHelpPath41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.portletHelpPath41aSet = true;
            }
        }
        return aportletHelpPath41a;
    }

   /**
    * @see GuiUseCase#getForwards()
    * @return List<GuiForward>
    */
    protected abstract List<GuiForward> handleGetForwards();

    /**
     * All forwards contained in this use case.
     * @return (List<GuiForward>)handleGetForwards()
     */
    public final List<GuiForward> getForwards()
    {
        List<GuiForward> aforwards42a = null;
        // forwards has no pre constraints
        aforwards42a = handleGetForwards();
        // forwards has no post constraints
        return aforwards42a;
    }

   /**
    * @see GuiUseCase#getActionForwards()
    * @return List<GuiAction>
    */
    protected abstract List<GuiAction> handleGetActionForwards();

    private List<GuiAction> actionForwards43a;
    private boolean actionForwards43aSet = false;

    /**
     * All forwards in this use case that are represented as actions.
     * @return (List<GuiAction>)handleGetActionForwards()
     */
    public final List<GuiAction> getActionForwards()
    {
        List<GuiAction> aactionForwards43a = this.actionForwards43a;
        if (!this.actionForwards43aSet)
        {
            // actionForwards has no pre constraints
            aactionForwards43a = handleGetActionForwards();
            // actionForwards has no post constraints
            this.actionForwards43a = aactionForwards43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionForwards43aSet = true;
            }
        }
        return aactionForwards43a;
    }

   /**
    * @see GuiUseCase#getAllViews()
    * @return Collection<GuiView>
    */
    protected abstract Collection<GuiView> handleGetAllViews();

    private Collection<GuiView> allViews44a;
    private boolean allViews44aSet = false;

    /**
     * All views for the application (not just the ones belonging to this use case).
     * @return (Collection<GuiView>)handleGetAllViews()
     */
    public final Collection<GuiView> getAllViews()
    {
        Collection<GuiView> aallViews44a = this.allViews44a;
        if (!this.allViews44aSet)
        {
            // allViews has no pre constraints
            aallViews44a = handleGetAllViews();
            // allViews has no post constraints
            this.allViews44a = aallViews44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.allViews44aSet = true;
            }
        }
        return aallViews44a;
    }

   /**
    * @see GuiUseCase#getRegistrationUseCases()
    * @return List<GuiUseCase>
    */
    protected abstract List<GuiUseCase> handleGetRegistrationUseCases();

    private List<GuiUseCase> registrationUseCases45a;
    private boolean registrationUseCases45aSet = false;

    /**
     * All use cases that are labled as registration use cases.
     * @return (List<GuiUseCase>)handleGetRegistrationUseCases()
     */
    public final List<GuiUseCase> getRegistrationUseCases()
    {
        List<GuiUseCase> aregistrationUseCases45a = this.registrationUseCases45a;
        if (!this.registrationUseCases45aSet)
        {
            // registrationUseCases has no pre constraints
            aregistrationUseCases45a = handleGetRegistrationUseCases();
            // registrationUseCases has no post constraints
            this.registrationUseCases45a = aregistrationUseCases45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.registrationUseCases45aSet = true;
            }
        }
        return aregistrationUseCases45a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Retrieves all navigation rules for the faces-config.xml
     * @return Collection
     */
    protected abstract Collection handleGetNavigationRules();

    /**
     * Retrieves all navigation rules for the faces-config.xml
     * @return handleGetNavigationRules()
     */
    public Collection getNavigationRules()
    {
        // getNavigationRules has no pre constraints
        Collection returnValue = handleGetNavigationRules();
        // getNavigationRules has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return Collection
     */
    protected abstract Collection handleGetNavigationChildren();

    /**
     * 
     * @return handleGetNavigationChildren()
     */
    public Collection getNavigationChildren()
    {
        // getNavigationChildren has no pre constraints
        Collection returnValue = handleGetNavigationChildren();
        // getNavigationChildren has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return Collection
     */
    protected abstract Collection handleGetNavigationParents();

    /**
     * 
     * @return handleGetNavigationParents()
     */
    public Collection getNavigationParents()
    {
        // getNavigationParents has no pre constraints
        Collection returnValue = handleGetNavigationParents();
        // getNavigationParents has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return String
     */
    protected abstract String handleGetActionRoles();

    /**
     * 
     * @return handleGetActionRoles()
     */
    public String getActionRoles()
    {
        // getActionRoles has no pre constraints
        String returnValue = handleGetActionRoles();
        // getActionRoles has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    private List<GuiView> getAllPages1r;
    private boolean getAllPages1rSet = false;

    /**
     * 
     * @return (List<GuiView>)handleGetAllPages()
     */
    public final List<GuiView> getAllPages()
    {
        List<GuiView> getAllPages1r = this.getAllPages1r;
        if (!this.getAllPages1rSet)
        {
            // guiUseCase has no pre constraints
            List result = handleGetAllPages();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getAllPages1r = (List<GuiView>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiUseCaseLogic.LOGGER.warn("incorrect metafacade cast for GuiUseCaseLogic.getAllPages List<GuiView> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.getAllPages1r = getAllPages1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getAllPages1rSet = true;
            }
        }
        return getAllPages1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetAllPages();

    private List<GuiParameter> getFormFields2r;
    private boolean getFormFields2rSet = false;

    /**
     * 
     * @return (List<GuiParameter>)handleGetFormFields()
     */
    public final List<GuiParameter> getFormFields()
    {
        List<GuiParameter> getFormFields2r = this.getFormFields2r;
        if (!this.getFormFields2rSet)
        {
            // guiUseCase has no pre constraints
            List result = handleGetFormFields();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getFormFields2r = (List<GuiParameter>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiUseCaseLogic.LOGGER.warn("incorrect metafacade cast for GuiUseCaseLogic.getFormFields List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.getFormFields2r = getFormFields2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getFormFields2rSet = true;
            }
        }
        return getFormFields2r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetFormFields();

    private Collection<GuiUseCase> getIncludedUseCases3r;
    private boolean getIncludedUseCases3rSet = false;

    /**
     * 
     * @return (Collection<GuiUseCase>)handleGetIncludedUseCases()
     */
    public final Collection<GuiUseCase> getIncludedUseCases()
    {
        Collection<GuiUseCase> getIncludedUseCases3r = this.getIncludedUseCases3r;
        if (!this.getIncludedUseCases3rSet)
        {
            // guiUseCase has no pre constraints
            Collection result = handleGetIncludedUseCases();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getIncludedUseCases3r = (Collection<GuiUseCase>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiUseCaseLogic.LOGGER.warn("incorrect metafacade cast for GuiUseCaseLogic.getIncludedUseCases Collection<GuiUseCase> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.getIncludedUseCases3r = getIncludedUseCases3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getIncludedUseCases3rSet = true;
            }
        }
        return getIncludedUseCases3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetIncludedUseCases();

    private List<GuiParameter> getPageVariables4r;
    private boolean getPageVariables4rSet = false;

    /**
     * 
     * @return (List<GuiParameter>)handleGetPageVariables()
     */
    public final List<GuiParameter> getPageVariables()
    {
        List<GuiParameter> getPageVariables4r = this.getPageVariables4r;
        if (!this.getPageVariables4rSet)
        {
            // guiUseCase has no pre constraints
            List result = handleGetPageVariables();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getPageVariables4r = (List<GuiParameter>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiUseCaseLogic.LOGGER.warn("incorrect metafacade cast for GuiUseCaseLogic.getPageVariables List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.getPageVariables4r = getPageVariables4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getPageVariables4rSet = true;
            }
        }
        return getPageVariables4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetPageVariables();

    private List<GuiUseCase> getDirectSubUseCases5r;
    private boolean getDirectSubUseCases5rSet = false;

    /**
     * 
     * @return (List<GuiUseCase>)handleGetDirectSubUseCases()
     */
    public final List<GuiUseCase> getDirectSubUseCases()
    {
        List<GuiUseCase> getDirectSubUseCases5r = this.getDirectSubUseCases5r;
        if (!this.getDirectSubUseCases5rSet)
        {
            // guiUseCase has no pre constraints
            List result = handleGetDirectSubUseCases();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getDirectSubUseCases5r = (List<GuiUseCase>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiUseCaseLogic.LOGGER.warn("incorrect metafacade cast for GuiUseCaseLogic.getDirectSubUseCases List<GuiUseCase> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.getDirectSubUseCases5r = getDirectSubUseCases5r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getDirectSubUseCases5rSet = true;
            }
        }
        return getDirectSubUseCases5r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetDirectSubUseCases();

    private List<GuiView> getPages6r;
    private boolean getPages6rSet = false;

    /**
     * 
     * @return (List<GuiView>)handleGetPages()
     */
    public final List<GuiView> getPages()
    {
        List<GuiView> getPages6r = this.getPages6r;
        if (!this.getPages6rSet)
        {
            // guiUseCase has no pre constraints
            List result = handleGetPages();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getPages6r = (List<GuiView>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiUseCaseLogic.LOGGER.warn("incorrect metafacade cast for GuiUseCaseLogic.getPages List<GuiView> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.getPages6r = getPages6r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getPages6rSet = true;
            }
        }
        return getPages6r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetPages();

    /**
     * 
     * @return (GuiPortletPreferences)handleGetPreferences()
     */
    public final GuiPortletPreferences getPreferences()
    {
        GuiPortletPreferences getPreferences7r = null;
        // useCase has no pre constraints
        Object result = handleGetPreferences();
        MetafacadeBase shieldedResult = this.shieldedElement(result);
        try
        {
            getPreferences7r = (GuiPortletPreferences)shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiUseCaseLogic.LOGGER.warn("incorrect metafacade cast for GuiUseCaseLogic.getPreferences GuiPortletPreferences " + result + ": " + shieldedResult);
        }
        // useCase has no post constraints
        return getPreferences7r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetPreferences();

    /**
     * @return true
     * @see FrontEndUseCase
     */
    public boolean isFrontEndUseCaseMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.UseCaseFacade
     */
    public boolean isUseCaseFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.NamespaceFacade
     */
    public boolean isNamespaceFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ClassifierFacade
     */
    public boolean isClassifierFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see GeneralizableElementFacade
     */
    public boolean isGeneralizableElementFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ModelElementFacade
     */
    public boolean isModelElementFacadeMetaType()
    {
        return true;
    }

    // ----------- delegates to FrontEndUseCase ------------
    /**
     * Return the attribute which name matches the parameter
     * @see ClassifierFacade#findAttribute(String name)
     */
    public AttributeFacade findAttribute(String name)
    {
        return this.getSuperFrontEndUseCase().findAttribute(name);
    }

    /**
     * Those abstraction dependencies for which this classifier is the client.
     * @see ClassifierFacade#getAbstractions()
     */
    public Collection<ClassifierFacade> getAbstractions()
    {
        return this.getSuperFrontEndUseCase().getAbstractions();
    }

    /**
     * Lists all classes associated to this one and any ancestor classes (through generalization).
     * There will be no duplicates. The order of the elements is predictable.
     * @see ClassifierFacade#getAllAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAllAssociatedClasses()
    {
        return this.getSuperFrontEndUseCase().getAllAssociatedClasses();
    }

    /**
     * A collection containing all 'properties' of the classifier and its ancestors.  Properties are
     * any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllProperties()
     */
    public Collection<ModelElementFacade> getAllProperties()
    {
        return this.getSuperFrontEndUseCase().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getAllRequiredConstructorParameters()
    {
        return this.getSuperFrontEndUseCase().getAllRequiredConstructorParameters();
    }

    /**
     * Gets the array type for this classifier.  If this classifier already represents an array, it
     * just returns itself.
     * @see ClassifierFacade#getArray()
     */
    public ClassifierFacade getArray()
    {
        return this.getSuperFrontEndUseCase().getArray();
    }

    /**
     * The name of the classifier as an array.
     * @see ClassifierFacade#getArrayName()
     */
    public String getArrayName()
    {
        return this.getSuperFrontEndUseCase().getArrayName();
    }

    /**
     * Lists the classes associated to this one, there is no repitition of classes. The order of the
     * elements is predictable.
     * @see ClassifierFacade#getAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAssociatedClasses()
    {
        return this.getSuperFrontEndUseCase().getAssociatedClasses();
    }

    /**
     * Gets the association ends belonging to a classifier.
     * @see ClassifierFacade#getAssociationEnds()
     */
    public List<AssociationEndFacade> getAssociationEnds()
    {
        return this.getSuperFrontEndUseCase().getAssociationEnds();
    }

    /**
     * Gets the attributes that belong to the classifier.
     * @see ClassifierFacade#getAttributes()
     */
    public List<AttributeFacade> getAttributes()
    {
        return this.getSuperFrontEndUseCase().getAttributes();
    }

    /**
     * Gets all attributes for the classifier and if 'follow' is true goes up the inheritance
     * hierarchy and gets the attributes from the super classes as well.
     * @see ClassifierFacade#getAttributes(boolean follow)
     */
    public List<AttributeFacade> getAttributes(boolean follow)
    {
        return this.getSuperFrontEndUseCase().getAttributes(follow);
    }

    /**
     * The fully qualified name of the classifier as an array.
     * @see ClassifierFacade#getFullyQualifiedArrayName()
     */
    public String getFullyQualifiedArrayName()
    {
        return this.getSuperFrontEndUseCase().getFullyQualifiedArrayName();
    }

    /**
     * Returns all those operations that could be implemented at this classifier's level. This means
     * the operations owned by this classifier as well as any realized interface's operations
     * (recursively) in case this classifier itself is not already an interface, or generalized when
     * this classifier is an interface.
     * @see ClassifierFacade#getImplementationOperations()
     */
    public Collection<OperationFacade> getImplementationOperations()
    {
        return this.getSuperFrontEndUseCase().getImplementationOperations();
    }

    /**
     * A comma separated list of the fully qualified names of all implemented interfaces.
     * @see ClassifierFacade#getImplementedInterfaceList()
     */
    public String getImplementedInterfaceList()
    {
        return this.getSuperFrontEndUseCase().getImplementedInterfaceList();
    }

    /**
     * Those attributes that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceAttributes()
     */
    public Collection<AttributeFacade> getInstanceAttributes()
    {
        return this.getSuperFrontEndUseCase().getInstanceAttributes();
    }

    /**
     * Those operations that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceOperations()
     */
    public List<OperationFacade> getInstanceOperations()
    {
        return this.getSuperFrontEndUseCase().getInstanceOperations();
    }

    /**
     * Those interfaces that are abstractions of this classifier, this basically means this
     * classifier realizes them.
     * @see ClassifierFacade#getInterfaceAbstractions()
     */
    public Collection<ClassifierFacade> getInterfaceAbstractions()
    {
        return this.getSuperFrontEndUseCase().getInterfaceAbstractions();
    }

    /**
     * A String representing a new Constructor declaration for this classifier type to be used in a
     * Java environment.
     * @see ClassifierFacade#getJavaNewString()
     */
    public String getJavaNewString()
    {
        return this.getSuperFrontEndUseCase().getJavaNewString();
    }

    /**
     * A String representing the null-value for this classifier type to be used in a Java
     * environment.
     * @see ClassifierFacade#getJavaNullString()
     */
    public String getJavaNullString()
    {
        return this.getSuperFrontEndUseCase().getJavaNullString();
    }

    /**
     * The other ends of this classifier's association ends which are navigable.
     * @see ClassifierFacade#getNavigableConnectingEnds()
     */
    public Collection<ClassifierFacade> getNavigableConnectingEnds()
    {
        return this.getSuperFrontEndUseCase().getNavigableConnectingEnds();
    }

    /**
     * Get the other ends of this classifier's association ends which are navigable and if 'follow'
     * is true goes up the inheritance hierarchy and gets the super association ends as well.
     * @see ClassifierFacade#getNavigableConnectingEnds(boolean follow)
     */
    public List<AssociationEndFacade> getNavigableConnectingEnds(boolean follow)
    {
        return this.getSuperFrontEndUseCase().getNavigableConnectingEnds(follow);
    }

    /**
     * Assuming that the classifier is an array, this will return the non array type of the
     * classifier from
     * the model.  If the classifier is NOT an array, it will just return itself.
     * @see ClassifierFacade#getNonArray()
     */
    public ClassifierFacade getNonArray()
    {
        return this.getSuperFrontEndUseCase().getNonArray();
    }

    /**
     * The attributes from this classifier in the form of an operation call (this example would be
     * in Java): '(String attributeOne, String attributeTwo).  If there were no attributes on the
     * classifier, the result would be an empty '()'.
     * @see ClassifierFacade#getOperationCallFromAttributes()
     */
    public String getOperationCallFromAttributes()
    {
        return this.getSuperFrontEndUseCase().getOperationCallFromAttributes();
    }

    /**
     * The operations owned by this classifier.
     * @see ClassifierFacade#getOperations()
     */
    public List<OperationFacade> getOperations()
    {
        return this.getSuperFrontEndUseCase().getOperations();
    }

    /**
     * A collection containing all 'properties' of the classifier.  Properties are any attributes
     * and navigable connecting association ends.
     * @see ClassifierFacade#getProperties()
     */
    public List<ModelElementFacade> getProperties()
    {
        return this.getSuperFrontEndUseCase().getProperties();
    }

    /**
     * Gets all properties (attributes and navigable association ends) for the classifier and if
     * 'follow' is true goes up the inheritance hierarchy and gets the properties from the super
     * classes as well.
     * @see ClassifierFacade#getProperties(boolean follow)
     */
    public List getProperties(boolean follow)
    {
        return this.getSuperFrontEndUseCase().getProperties(follow);
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier. 
     * Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getRequiredConstructorParameters()
    {
        return this.getSuperFrontEndUseCase().getRequiredConstructorParameters();
    }

    /**
     * Returns the serial version UID of the underlying model element.
     * @see ClassifierFacade#getSerialVersionUID()
     */
    public long getSerialVersionUID()
    {
        return this.getSuperFrontEndUseCase().getSerialVersionUID();
    }

    /**
     * Those attributes that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticAttributes()
     */
    public Collection<AttributeFacade> getStaticAttributes()
    {
        return this.getSuperFrontEndUseCase().getStaticAttributes();
    }

    /**
     * Those operations that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticOperations()
     */
    public List<OperationFacade> getStaticOperations()
    {
        return this.getSuperFrontEndUseCase().getStaticOperations();
    }

    /**
     * This class' superclass, returns the generalization if it is a ClassifierFacade, null
     * otherwise.
     * @see ClassifierFacade#getSuperClass()
     */
    public ClassifierFacade getSuperClass()
    {
        return this.getSuperFrontEndUseCase().getSuperClass();
    }

    /**
     * The wrapper name for this classifier if a mapped type has a defined wrapper class (ie. 'long'
     * maps to 'Long').  If the classifier doesn't have a wrapper defined for it, this method will
     * return a null.  Note that wrapper mappings must be defined for the namespace by defining the
     * 'wrapperMappingsUri', this property must point to the location of the mappings file which
     * maps the primitives to wrapper types.
     * @see ClassifierFacade#getWrapperName()
     */
    public String getWrapperName()
    {
        return this.getSuperFrontEndUseCase().getWrapperName();
    }

    /**
     * Indicates if this classifier is 'abstract'.
     * @see ClassifierFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperFrontEndUseCase().isAbstract();
    }

    /**
     * True if this classifier represents an array type. False otherwise.
     * @see ClassifierFacade#isArrayType()
     */
    public boolean isArrayType()
    {
        return this.getSuperFrontEndUseCase().isArrayType();
    }

    /**
     * 
     * @see ClassifierFacade#isAssociationClass()
     */
    public boolean isAssociationClass()
    {
        return this.getSuperFrontEndUseCase().isAssociationClass();
    }

    /**
     * Returns true if this type represents a Blob type.
     * @see ClassifierFacade#isBlobType()
     */
    public boolean isBlobType()
    {
        return this.getSuperFrontEndUseCase().isBlobType();
    }

    /**
     * Indicates if this type represents a boolean type or not.
     * @see ClassifierFacade#isBooleanType()
     */
    public boolean isBooleanType()
    {
        return this.getSuperFrontEndUseCase().isBooleanType();
    }

    /**
     * Indicates if this type represents a char, Character, or java.lang.Character type or not.
     * @see ClassifierFacade#isCharacterType()
     */
    public boolean isCharacterType()
    {
        return this.getSuperFrontEndUseCase().isCharacterType();
    }

    /**
     * Returns true if this type represents a Clob type.
     * @see ClassifierFacade#isClobType()
     */
    public boolean isClobType()
    {
        return this.getSuperFrontEndUseCase().isClobType();
    }

    /**
     * True if this classifier represents a collection type. False otherwise.
     * @see ClassifierFacade#isCollectionType()
     */
    public boolean isCollectionType()
    {
        return this.getSuperFrontEndUseCase().isCollectionType();
    }

    /**
     * True/false depending on whether or not this classifier represents a datatype. A data type is
     * a type whose instances are identified only by their value. A data type may contain attributes
     * to support the modeling of structured data types.
     * @see ClassifierFacade#isDataType()
     */
    public boolean isDataType()
    {
        return this.getSuperFrontEndUseCase().isDataType();
    }

    /**
     * True when this classifier is a date type.
     * @see ClassifierFacade#isDateType()
     */
    public boolean isDateType()
    {
        return this.getSuperFrontEndUseCase().isDateType();
    }

    /**
     * Indicates if this type represents a Double type or not.
     * @see ClassifierFacade#isDoubleType()
     */
    public boolean isDoubleType()
    {
        return this.getSuperFrontEndUseCase().isDoubleType();
    }

    /**
     * Indicates whether or not this classifier represents an "EmbeddedValue'.
     * @see ClassifierFacade#isEmbeddedValue()
     */
    public boolean isEmbeddedValue()
    {
        return this.getSuperFrontEndUseCase().isEmbeddedValue();
    }

    /**
     * True if this classifier is in fact marked as an enumeration.
     * @see ClassifierFacade#isEnumeration()
     */
    public boolean isEnumeration()
    {
        return this.getSuperFrontEndUseCase().isEnumeration();
    }

    /**
     * Returns true if this type represents a 'file' type.
     * @see ClassifierFacade#isFileType()
     */
    public boolean isFileType()
    {
        return this.getSuperFrontEndUseCase().isFileType();
    }

    /**
     * Indicates if this type represents a Float type or not.
     * @see ClassifierFacade#isFloatType()
     */
    public boolean isFloatType()
    {
        return this.getSuperFrontEndUseCase().isFloatType();
    }

    /**
     * Indicates if this type represents an int or Integer or java.lang.Integer type or not.
     * @see ClassifierFacade#isIntegerType()
     */
    public boolean isIntegerType()
    {
        return this.getSuperFrontEndUseCase().isIntegerType();
    }

    /**
     * True/false depending on whether or not this Classifier represents an interface.
     * @see ClassifierFacade#isInterface()
     */
    public boolean isInterface()
    {
        return this.getSuperFrontEndUseCase().isInterface();
    }

    /**
     * True if this classifier cannot be extended and represent a leaf in the inheritance tree.
     * @see ClassifierFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperFrontEndUseCase().isLeaf();
    }

    /**
     * True if this classifier represents a list type. False otherwise.
     * @see ClassifierFacade#isListType()
     */
    public boolean isListType()
    {
        return this.getSuperFrontEndUseCase().isListType();
    }

    /**
     * Indicates if this type represents a Long type or not.
     * @see ClassifierFacade#isLongType()
     */
    public boolean isLongType()
    {
        return this.getSuperFrontEndUseCase().isLongType();
    }

    /**
     * Indicates whether or not this classifier represents a Map type.
     * @see ClassifierFacade#isMapType()
     */
    public boolean isMapType()
    {
        return this.getSuperFrontEndUseCase().isMapType();
    }

    /**
     * Indicates whether or not this classifier represents a primitive type.
     * @see ClassifierFacade#isPrimitive()
     */
    public boolean isPrimitive()
    {
        return this.getSuperFrontEndUseCase().isPrimitive();
    }

    /**
     * True if this classifier represents a set type. False otherwise.
     * @see ClassifierFacade#isSetType()
     */
    public boolean isSetType()
    {
        return this.getSuperFrontEndUseCase().isSetType();
    }

    /**
     * Indicates whether or not this classifier represents a string type.
     * @see ClassifierFacade#isStringType()
     */
    public boolean isStringType()
    {
        return this.getSuperFrontEndUseCase().isStringType();
    }

    /**
     * Indicates whether or not this classifier represents a time type.
     * @see ClassifierFacade#isTimeType()
     */
    public boolean isTimeType()
    {
        return this.getSuperFrontEndUseCase().isTimeType();
    }

    /**
     * Returns true if this type is a wrapped primitive type.
     * @see ClassifierFacade#isWrappedPrimitive()
     */
    public boolean isWrappedPrimitive()
    {
        return this.getSuperFrontEndUseCase().isWrappedPrimitive();
    }

    /**
     * The actions for this use-case. This will include the initial action to start the use-case.
     * @see FrontEndUseCase#getActions()
     */
    public List<FrontEndAction> getActions()
    {
        return this.getSuperFrontEndUseCase().getActions();
    }

    /**
     * Returns the activity graph describing this use-case in more detail.
     * @see FrontEndUseCase#getActivityGraph()
     */
    public FrontEndActivityGraph getActivityGraph()
    {
        return this.getSuperFrontEndUseCase().getActivityGraph();
    }

    /**
     * All roles that directly or indirectly related to any "front-end" use cases.
     * @see FrontEndUseCase#getAllRoles()
     */
    public List<Role> getAllRoles()
    {
        return this.getSuperFrontEndUseCase().getAllRoles();
    }

    /**
     * Returns all struts use-cases in this "front end" application.
     * @see FrontEndUseCase#getAllUseCases()
     */
    public List<FrontEndUseCase> getAllUseCases()
    {
        return this.getSuperFrontEndUseCase().getAllUseCases();
    }

    /**
     * Returns the controller for this use-case.
     * @see FrontEndUseCase#getController()
     */
    public FrontEndController getController()
    {
        return this.getSuperFrontEndUseCase().getController();
    }

    /**
     * The first view of this use case, this may actually return a view of another use case if the
     * first is found by traveling through the final state.
     * @see FrontEndUseCase#getInitialView()
     */
    public FrontEndView getInitialView()
    {
        return this.getSuperFrontEndUseCase().getInitialView();
    }

    /**
     * The final states linking to this use case
     * @see FrontEndUseCase#getReferencingFinalStates()
     */
    public List<FrontEndFinalState> getReferencingFinalStates()
    {
        return this.getSuperFrontEndUseCase().getReferencingFinalStates();
    }

    /**
     * Returns all roles that are directly and indirectly associated to this use-case.
     * @see FrontEndUseCase#getRoles()
     */
    public List<Role> getRoles()
    {
        return this.getSuperFrontEndUseCase().getRoles();
    }

    /**
     * The variables for all views in this use-case. A parameter qualifies to be a variable when it
     * explicitely and directly receives it via an action.
     * @see FrontEndUseCase#getViewVariables()
     */
    public List<FrontEndParameter> getViewVariables()
    {
        return this.getSuperFrontEndUseCase().getViewVariables();
    }

    /**
     * All views that are part of this use case.
     * @see FrontEndUseCase#getViews()
     */
    public List<FrontEndView> getViews()
    {
        return this.getSuperFrontEndUseCase().getViews();
    }

    /**
     * True if this use-case is the entry point to the front end.
     * @see FrontEndUseCase#isEntryUseCase()
     */
    public boolean isEntryUseCase()
    {
        return this.getSuperFrontEndUseCase().isEntryUseCase();
    }

    /**
     * Indicates if this use case is "secured".  This is true when there is at least one role
     * associated to it.
     * @see FrontEndUseCase#isSecured()
     */
    public boolean isSecured()
    {
        return this.getSuperFrontEndUseCase().isSecured();
    }

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @see GeneralizableElementFacade#findTaggedValue(String tagName, boolean follow)
     */
    public Object findTaggedValue(String tagName, boolean follow)
    {
        return this.getSuperFrontEndUseCase().findTaggedValue(tagName, follow);
    }

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @see GeneralizableElementFacade#getAllGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations()
    {
        return this.getSuperFrontEndUseCase().getAllGeneralizations();
    }

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @see GeneralizableElementFacade#getAllSpecializations()
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations()
    {
        return this.getSuperFrontEndUseCase().getAllSpecializations();
    }

    /**
     * Gets the direct generalization for this generalizable element.
     * @see GeneralizableElementFacade#getGeneralization()
     */
    public GeneralizableElementFacade getGeneralization()
    {
        return this.getSuperFrontEndUseCase().getGeneralization();
    }

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @see GeneralizableElementFacade#getGeneralizationLinks()
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks()
    {
        return this.getSuperFrontEndUseCase().getGeneralizationLinks();
    }

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @see GeneralizableElementFacade#getGeneralizationList()
     */
    public String getGeneralizationList()
    {
        return this.getSuperFrontEndUseCase().getGeneralizationList();
    }

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @see GeneralizableElementFacade#getGeneralizationRoot()
     */
    public GeneralizableElementFacade getGeneralizationRoot()
    {
        return this.getSuperFrontEndUseCase().getGeneralizationRoot();
    }

    /**
     * 
     * @see GeneralizableElementFacade#getGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getGeneralizations()
    {
        return this.getSuperFrontEndUseCase().getGeneralizations();
    }

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @see GeneralizableElementFacade#getSpecializations()
     */
    public Collection<GeneralizableElementFacade> getSpecializations()
    {
        return this.getSuperFrontEndUseCase().getSpecializations();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperFrontEndUseCase().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperFrontEndUseCase().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperFrontEndUseCase().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperFrontEndUseCase().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperFrontEndUseCase().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperFrontEndUseCase().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperFrontEndUseCase().getDocumentation(indent);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. By default paragraphs are returned as HTML.
     * This method is equivalent to <code>getDocumentation(indent, lineLength, true)</code>.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength)
     */
    public String getDocumentation(String indent, int lineLength)
    {
        return this.getSuperFrontEndUseCase().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperFrontEndUseCase().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperFrontEndUseCase().getFullyQualifiedName();
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element.  If modelName is true, then
     * the original name of the model element (the name contained within the model) will be the name
     * returned, otherwise a name from a language mapping will be returned.
     * @see ModelElementFacade#getFullyQualifiedName(boolean modelName)
     */
    public String getFullyQualifiedName(boolean modelName)
    {
        return this.getSuperFrontEndUseCase().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperFrontEndUseCase().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperFrontEndUseCase().getId();
    }

    /**
     * UML2: Retrieves the keywords for this element. Used to modify implementation properties which
     * are not represented by other properties, i.e. native, transient, volatile, synchronized,
     * (added annotations) override, deprecated. Can also be used to suppress compiler warnings:
     * (added annotations) unchecked, fallthrough, path, serial, finally, all. Annotations require
     * JDK5 compiler level.
     * @see ModelElementFacade#getKeywords()
     */
    public Collection<String> getKeywords()
    {
        return this.getSuperFrontEndUseCase().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperFrontEndUseCase().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperFrontEndUseCase().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperFrontEndUseCase().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperFrontEndUseCase().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperFrontEndUseCase().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperFrontEndUseCase().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperFrontEndUseCase().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperFrontEndUseCase().getPackagePath();
    }

    /**
     * UML2: Returns the value of the 'Qualified Name' attribute. A name which allows the
     * NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from
     * the names of the containing namespaces starting at the root of the hierarchy and ending with
     * the name of the NamedElement itself.
     * @see ModelElementFacade#getQualifiedName()
     */
    public String getQualifiedName()
    {
        return this.getSuperFrontEndUseCase().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperFrontEndUseCase().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperFrontEndUseCase().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperFrontEndUseCase().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperFrontEndUseCase().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperFrontEndUseCase().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperFrontEndUseCase().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperFrontEndUseCase().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperFrontEndUseCase().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperFrontEndUseCase().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperFrontEndUseCase().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndUseCase().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperFrontEndUseCase().hasKeyword(keywordName);
    }

    /**
     * Returns true if the model element has the specified stereotype.  If the stereotype itself
     * does not match, then a search will be made up the stereotype inheritance hierarchy, and if
     * one of the stereotype's ancestors has a matching name this method will return true, false
     * otherwise.
     * For example, if we have a certain stereotype called <<exception>> and a model element has a
     * stereotype called <<applicationException>> which extends <<exception>>, when calling this
     * method with 'stereotypeName' defined as 'exception' the method would return true since
     * <<applicationException>> inherits from <<exception>>.  If you want to check if the model
     * element has the exact stereotype, then use the method 'hasExactStereotype' instead.
     * @see ModelElementFacade#hasStereotype(String stereotypeName)
     */
    public boolean hasStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndUseCase().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperFrontEndUseCase().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperFrontEndUseCase().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperFrontEndUseCase().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperFrontEndUseCase().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperFrontEndUseCase().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperFrontEndUseCase().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperFrontEndUseCase().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperFrontEndUseCase().translateConstraints(kind, translation);
    }

    /**
     * Gets the model elements which this namespace owns.
     * @see org.andromda.metafacades.uml.NamespaceFacade#getOwnedElements()
     */
    public Collection<ModelElementFacade> getOwnedElements()
    {
        return this.getSuperFrontEndUseCase().getOwnedElements();
    }

    /**
     * The extend instances related to this use-case.
     * @see org.andromda.metafacades.uml.UseCaseFacade#getExtends()
     */
    public Collection<ExtendFacade> getExtends()
    {
        return this.getSuperFrontEndUseCase().getExtends();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.UseCaseFacade#getExtensionPoints()
     */
    public Collection<ExtensionPointFacade> getExtensionPoints()
    {
        return this.getSuperFrontEndUseCase().getExtensionPoints();
    }

    /**
     * The first activity graph directly owned by this use-case.
     * @see org.andromda.metafacades.uml.UseCaseFacade#getFirstActivityGraph()
     */
    public ActivityGraphFacade getFirstActivityGraph()
    {
        return this.getSuperFrontEndUseCase().getFirstActivityGraph();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.UseCaseFacade#getIncludes()
     */
    public Collection<IncludeFacade> getIncludes()
    {
        return this.getSuperFrontEndUseCase().getIncludes();
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperFrontEndUseCase().initialize();
    }

    /**
     * @return Object getSuperFrontEndUseCase().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperFrontEndUseCase().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperFrontEndUseCase().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperFrontEndUseCase().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiUseCase::use-cases that loop need at least one page</p>
     * <p><b>Error:</b> This use-case has a final state targetting the same use-case, while at the same time no pages have been modeled. This will lead to an infinite loop at runtime since the same event will keep invoking itself.</p>
     * <p><b>OCL:</b> context GuiUseCase inv: cyclic implies pages->notEmpty()</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiUseCase::use cases graph contains one workbook</p>
     * <p><b>Error:</b> use cases graph must contain at least one use case tagged with 'workbook' value</p>
     * <p><b>OCL:</b> -- context GuiUseCase inv: allUseCases->exists(u : GuiUseCase | workbook=true)</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperFrontEndUseCase().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"cyclic"))).booleanValue()?OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"pages")):true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiUseCase::use-cases that loop need at least one page",
                        "This use-case has a final state targetting the same use-case, while at the same time no pages have been modeled. This will lead to an infinite loop at runtime since the same event will keep invoking itself."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiUseCase::use-cases that loop need at least one page' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure();
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiUseCase::use cases graph contains one workbook",
                        "use cases graph must contain at least one use case tagged with 'workbook' value"));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiUseCase::use cases graph contains one workbook' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
    }

    /**
     * The property that stores the name of the metafacade.
     */
    private static final String NAME_PROPERTY = "name";
    private static final String FQNAME_PROPERTY = "fullyQualifiedName";

    /**
     * @see Object#toString()
     */
    @Override
    public String toString()
    {
        final StringBuilder toString = new StringBuilder(this.getClass().getName());
        toString.append("[");
        try
        {
            toString.append(Introspector.instance().getProperty(this, FQNAME_PROPERTY));
        }
        catch (final Throwable tryAgain)
        {
            try
            {
                toString.append(Introspector.instance().getProperty(this, NAME_PROPERTY));
            }
            catch (final Throwable ignore)
            {
                // - just ignore when the metafacade doesn't have a name or fullyQualifiedName property
            }
        }
        toString.append("]");
        return toString.toString();
    }
}