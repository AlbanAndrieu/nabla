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
import org.andromda.translation.ocl.validation.OCLExpressions;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.commons.collections.Predicate;
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
    /**
     * The underlying UML object
     * @see Object
     */
    protected Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected GuiUseCaseLogic(Object metaObjectIn, String context)
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
    private static final Logger logger = Logger.getLogger(GuiUseCaseLogic.class);

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

    private String __titleKey1a;
    private boolean __titleKey1aSet = false;

    /**
     * The title message key for this use-case.
     * @return (String)handleGetTitleKey()
     */
    public final String getTitleKey()
    {
        String titleKey1a = this.__titleKey1a;
        if (!this.__titleKey1aSet)
        {
            // titleKey has no pre constraints
            titleKey1a = handleGetTitleKey();
            // titleKey has no post constraints
            this.__titleKey1a = titleKey1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__titleKey1aSet = true;
            }
        }
        return titleKey1a;
    }

   /**
    * @see GuiUseCase#getTitleValue()
    * @return String
    */
    protected abstract String handleGetTitleValue();

    private String __titleValue2a;
    private boolean __titleValue2aSet = false;

    /**
     * The title message value for this use-case.
     * @return (String)handleGetTitleValue()
     */
    public final String getTitleValue()
    {
        String titleValue2a = this.__titleValue2a;
        if (!this.__titleValue2aSet)
        {
            // titleValue has no pre constraints
            titleValue2a = handleGetTitleValue();
            // titleValue has no post constraints
            this.__titleValue2a = titleValue2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__titleValue2aSet = true;
            }
        }
        return titleValue2a;
    }

   /**
    * @see GuiUseCase#getActionPath()
    * @return String
    */
    protected abstract String handleGetActionPath();

    private String __actionPath3a;
    private boolean __actionPath3aSet = false;

    /**
     * This use-case's action path.
     * @return (String)handleGetActionPath()
     */
    public final String getActionPath()
    {
        String actionPath3a = this.__actionPath3a;
        if (!this.__actionPath3aSet)
        {
            // actionPath has no pre constraints
            actionPath3a = handleGetActionPath();
            // actionPath has no post constraints
            this.__actionPath3a = actionPath3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionPath3aSet = true;
            }
        }
        return actionPath3a;
    }

   /**
    * @see GuiUseCase#getActionPathRoot()
    * @return String
    */
    protected abstract String handleGetActionPathRoot();

    private String __actionPathRoot4a;
    private boolean __actionPathRoot4aSet = false;

    /**
     * The root of the action path.
     * @return (String)handleGetActionPathRoot()
     */
    public final String getActionPathRoot()
    {
        String actionPathRoot4a = this.__actionPathRoot4a;
        if (!this.__actionPathRoot4aSet)
        {
            // actionPathRoot has no pre constraints
            actionPathRoot4a = handleGetActionPathRoot();
            // actionPathRoot has no post constraints
            this.__actionPathRoot4a = actionPathRoot4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionPathRoot4aSet = true;
            }
        }
        return actionPathRoot4a;
    }

   /**
    * @see GuiUseCase#isApplicationValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsApplicationValidationRequired();

    private boolean __applicationValidationRequired5a;
    private boolean __applicationValidationRequired5aSet = false;

    /**
     * True if at least one client/server parameter found in the collection of existing use-cases
     * requires validation.
     * @return (boolean)handleIsApplicationValidationRequired()
     */
    public final boolean isApplicationValidationRequired()
    {
        boolean applicationValidationRequired5a = this.__applicationValidationRequired5a;
        if (!this.__applicationValidationRequired5aSet)
        {
            // applicationValidationRequired has no pre constraints
            applicationValidationRequired5a = handleIsApplicationValidationRequired();
            // applicationValidationRequired has no post constraints
            this.__applicationValidationRequired5a = applicationValidationRequired5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__applicationValidationRequired5aSet = true;
            }
        }
        return applicationValidationRequired5a;
    }

   /**
    * @see GuiUseCase#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private boolean __validationRequired6a;
    private boolean __validationRequired6aSet = false;

    /**
     * True if some client/server parameters require validation for this use-case.
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean validationRequired6a = this.__validationRequired6a;
        if (!this.__validationRequired6aSet)
        {
            // validationRequired has no pre constraints
            validationRequired6a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.__validationRequired6a = validationRequired6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__validationRequired6aSet = true;
            }
        }
        return validationRequired6a;
    }

   /**
    * @see GuiUseCase#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String __onlineHelpKey7a;
    private boolean __onlineHelpKey7aSet = false;

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String onlineHelpKey7a = this.__onlineHelpKey7a;
        if (!this.__onlineHelpKey7aSet)
        {
            // onlineHelpKey has no pre constraints
            onlineHelpKey7a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.__onlineHelpKey7a = onlineHelpKey7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpKey7aSet = true;
            }
        }
        return onlineHelpKey7a;
    }

   /**
    * @see GuiUseCase#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String __onlineHelpValue8a;
    private boolean __onlineHelpValue8aSet = false;

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String onlineHelpValue8a = this.__onlineHelpValue8a;
        if (!this.__onlineHelpValue8aSet)
        {
            // onlineHelpValue has no pre constraints
            onlineHelpValue8a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.__onlineHelpValue8a = onlineHelpValue8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpValue8aSet = true;
            }
        }
        return onlineHelpValue8a;
    }

   /**
    * @see GuiUseCase#isApplicationUseCase()
    * @return boolean
    */
    protected abstract boolean handleIsApplicationUseCase();

    private boolean __applicationUseCase9a;
    private boolean __applicationUseCase9aSet = false;

    /**
     * True if this use-case is where the application starts.
     * @return (boolean)handleIsApplicationUseCase()
     */
    public final boolean isApplicationUseCase()
    {
        boolean applicationUseCase9a = this.__applicationUseCase9a;
        if (!this.__applicationUseCase9aSet)
        {
            // applicationUseCase has no pre constraints
            applicationUseCase9a = handleIsApplicationUseCase();
            // applicationUseCase has no post constraints
            this.__applicationUseCase9a = applicationUseCase9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__applicationUseCase9aSet = true;
            }
        }
        return applicationUseCase9a;
    }

   /**
    * @see GuiUseCase#getApplicationHierarchyRoot()
    * @return TreeNode
    */
    protected abstract TreeNode handleGetApplicationHierarchyRoot();

    private TreeNode __applicationHierarchyRoot10a;
    private boolean __applicationHierarchyRoot10aSet = false;

    /**
     * The root node of the application usecase hierarchy. Only makes sense when this usecase is an
     * application usecase. Each usecase is only listed once in it's subtree, meaning when cycles ar
     * edetected in the applicaion usecase graph the usecase will not be added when it already
     * exists as an ancestor.
     * @return (TreeNode)handleGetApplicationHierarchyRoot()
     */
    public final TreeNode getApplicationHierarchyRoot()
    {
        TreeNode applicationHierarchyRoot10a = this.__applicationHierarchyRoot10a;
        if (!this.__applicationHierarchyRoot10aSet)
        {
            // applicationHierarchyRoot has no pre constraints
            applicationHierarchyRoot10a = handleGetApplicationHierarchyRoot();
            // applicationHierarchyRoot has no post constraints
            this.__applicationHierarchyRoot10a = applicationHierarchyRoot10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__applicationHierarchyRoot10aSet = true;
            }
        }
        return applicationHierarchyRoot10a;
    }

   /**
    * @see GuiUseCase#getHierarchyRoot()
    * @return TreeNode
    */
    protected abstract TreeNode handleGetHierarchyRoot();

    private TreeNode __hierarchyRoot11a;
    private boolean __hierarchyRoot11aSet = false;

    /**
     * The root of the hierarchy of application usecases where this usecase is at the top. It is
     * possible not all usecases are included in the descendants, they can be found in the
     * collection of ancestor nodes.
     * @return (TreeNode)handleGetHierarchyRoot()
     */
    public final TreeNode getHierarchyRoot()
    {
        TreeNode hierarchyRoot11a = this.__hierarchyRoot11a;
        if (!this.__hierarchyRoot11aSet)
        {
            // hierarchyRoot has no pre constraints
            hierarchyRoot11a = handleGetHierarchyRoot();
            // hierarchyRoot has no post constraints
            this.__hierarchyRoot11a = hierarchyRoot11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hierarchyRoot11aSet = true;
            }
        }
        return hierarchyRoot11a;
    }

   /**
    * @see GuiUseCase#getCssFileName()
    * @return String
    */
    protected abstract String handleGetCssFileName();

    private String __cssFileName12a;
    private boolean __cssFileName12aSet = false;

    /**
     * The name of the file containing specific styles for this use-case only.
     * @return (String)handleGetCssFileName()
     */
    public final String getCssFileName()
    {
        String cssFileName12a = this.__cssFileName12a;
        if (!this.__cssFileName12aSet)
        {
            // cssFileName has no pre constraints
            cssFileName12a = handleGetCssFileName();
            // cssFileName has no post constraints
            this.__cssFileName12a = cssFileName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__cssFileName12aSet = true;
            }
        }
        return cssFileName12a;
    }

   /**
    * @see GuiUseCase#getAllMessages()
    * @return Map
    */
    protected abstract Map handleGetAllMessages();

    private Map __allMessages13a;
    private boolean __allMessages13aSet = false;

    /**
     * A map with keys sorted alphabetically, normalized across all different use-cases and pages
     * etc..
     * @return (Map)handleGetAllMessages()
     */
    public final Map getAllMessages()
    {
        Map allMessages13a = this.__allMessages13a;
        if (!this.__allMessages13aSet)
        {
            // allMessages has no pre constraints
            allMessages13a = handleGetAllMessages();
            // allMessages has no post constraints
            this.__allMessages13a = allMessages13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__allMessages13aSet = true;
            }
        }
        return allMessages13a;
    }

   /**
    * @see GuiUseCase#isCyclic()
    * @return boolean
    */
    protected abstract boolean handleIsCyclic();

    private boolean __cyclic14a;
    private boolean __cyclic14aSet = false;

    /**
     * 
     * @return (boolean)handleIsCyclic()
     */
    public final boolean isCyclic()
    {
        boolean cyclic14a = this.__cyclic14a;
        if (!this.__cyclic14aSet)
        {
            // cyclic has no pre constraints
            cyclic14a = handleIsCyclic();
            // cyclic has no post constraints
            this.__cyclic14a = cyclic14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__cyclic14aSet = true;
            }
        }
        return cyclic14a;
    }

   /**
    * @see GuiUseCase#getOnlineHelpPagePath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpPagePath();

    private String __onlineHelpPagePath15a;
    private boolean __onlineHelpPagePath15aSet = false;

    /**
     * The full path to this use-case's online help page.
     * @return (String)handleGetOnlineHelpPagePath()
     */
    public final String getOnlineHelpPagePath()
    {
        String onlineHelpPagePath15a = this.__onlineHelpPagePath15a;
        if (!this.__onlineHelpPagePath15aSet)
        {
            // onlineHelpPagePath has no pre constraints
            onlineHelpPagePath15a = handleGetOnlineHelpPagePath();
            // onlineHelpPagePath has no post constraints
            this.__onlineHelpPagePath15a = onlineHelpPagePath15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpPagePath15aSet = true;
            }
        }
        return onlineHelpPagePath15a;
    }

   /**
    * @see GuiUseCase#getOnlineHelpActionPath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpActionPath();

    private String __onlineHelpActionPath16a;
    private boolean __onlineHelpActionPath16aSet = false;

    /**
     * The full path to this use-case's online help action. The returned String does not have a
     * suffix such as '.do'.
     * @return (String)handleGetOnlineHelpActionPath()
     */
    public final String getOnlineHelpActionPath()
    {
        String onlineHelpActionPath16a = this.__onlineHelpActionPath16a;
        if (!this.__onlineHelpActionPath16aSet)
        {
            // onlineHelpActionPath has no pre constraints
            onlineHelpActionPath16a = handleGetOnlineHelpActionPath();
            // onlineHelpActionPath has no post constraints
            this.__onlineHelpActionPath16a = onlineHelpActionPath16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpActionPath16aSet = true;
            }
        }
        return onlineHelpActionPath16a;
    }

   /**
    * @see GuiUseCase#getFormKey()
    * @return String
    */
    protected abstract String handleGetFormKey();

    private String __formKey17a;
    private boolean __formKey17aSet = false;

    /**
     * The key under which to store the forms contained in this use-case.
     * @return (String)handleGetFormKey()
     */
    public final String getFormKey()
    {
        String formKey17a = this.__formKey17a;
        if (!this.__formKey17aSet)
        {
            // formKey has no pre constraints
            formKey17a = handleGetFormKey();
            // formKey has no post constraints
            this.__formKey17a = formKey17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formKey17aSet = true;
            }
        }
        return formKey17a;
    }

   /**
    * @see GuiUseCase#isWorkbook()
    * @return boolean
    */
    protected abstract boolean handleIsWorkbook();

    private boolean __workbook18a;
    private boolean __workbook18aSet = false;

    /**
     * 
     * @return (boolean)handleIsWorkbook()
     */
    public final boolean isWorkbook()
    {
        boolean workbook18a = this.__workbook18a;
        if (!this.__workbook18aSet)
        {
            // workbook has no pre constraints
            workbook18a = handleIsWorkbook();
            // workbook has no post constraints
            this.__workbook18a = workbook18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__workbook18aSet = true;
            }
        }
        return workbook18a;
    }

   /**
    * @see GuiUseCase#isWorksheet()
    * @return boolean
    */
    protected abstract boolean handleIsWorksheet();

    private boolean __worksheet19a;
    private boolean __worksheet19aSet = false;

    /**
     * 
     * @return (boolean)handleIsWorksheet()
     */
    public final boolean isWorksheet()
    {
        boolean worksheet19a = this.__worksheet19a;
        if (!this.__worksheet19aSet)
        {
            // worksheet has no pre constraints
            worksheet19a = handleIsWorksheet();
            // worksheet has no post constraints
            this.__worksheet19a = worksheet19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__worksheet19aSet = true;
            }
        }
        return worksheet19a;
    }

   /**
    * @see GuiUseCase#isContainer()
    * @return boolean
    */
    protected abstract boolean handleIsContainer();

    private boolean __container20a;
    private boolean __container20aSet = false;

    /**
     * 
     * @return (boolean)handleIsContainer()
     */
    public final boolean isContainer()
    {
        boolean container20a = this.__container20a;
        if (!this.__container20aSet)
        {
            // container has no pre constraints
            container20a = handleIsContainer();
            // container has no post constraints
            this.__container20a = container20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__container20aSet = true;
            }
        }
        return container20a;
    }

   /**
    * @see GuiUseCase#getContainerHeight()
    * @return String
    */
    protected abstract String handleGetContainerHeight();

    private String __containerHeight21a;
    private boolean __containerHeight21aSet = false;

    /**
     * 
     * @return (String)handleGetContainerHeight()
     */
    public final String getContainerHeight()
    {
        String containerHeight21a = this.__containerHeight21a;
        if (!this.__containerHeight21aSet)
        {
            // containerHeight has no pre constraints
            containerHeight21a = handleGetContainerHeight();
            // containerHeight has no post constraints
            this.__containerHeight21a = containerHeight21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__containerHeight21aSet = true;
            }
        }
        return containerHeight21a;
    }

   /**
    * @see GuiUseCase#getContainerWidth()
    * @return String
    */
    protected abstract String handleGetContainerWidth();

    private String __containerWidth22a;
    private boolean __containerWidth22aSet = false;

    /**
     * 
     * @return (String)handleGetContainerWidth()
     */
    public final String getContainerWidth()
    {
        String containerWidth22a = this.__containerWidth22a;
        if (!this.__containerWidth22aSet)
        {
            // containerWidth has no pre constraints
            containerWidth22a = handleGetContainerWidth();
            // containerWidth has no post constraints
            this.__containerWidth22a = containerWidth22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__containerWidth22aSet = true;
            }
        }
        return containerWidth22a;
    }

   /**
    * @see GuiUseCase#getPath()
    * @return String
    */
    protected abstract String handleGetPath();

    private String __path23a;
    private boolean __path23aSet = false;

    /**
     * The path to which this use case points.
     * @return (String)handleGetPath()
     */
    public final String getPath()
    {
        String path23a = this.__path23a;
        if (!this.__path23aSet)
        {
            // path has no pre constraints
            path23a = handleGetPath();
            // path has no post constraints
            this.__path23a = path23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__path23aSet = true;
            }
        }
        return path23a;
    }

   /**
    * @see GuiUseCase#getPathRoot()
    * @return String
    */
    protected abstract String handleGetPathRoot();

    private String __pathRoot24a;
    private boolean __pathRoot24aSet = false;

    /**
     * The root path for this use case (this is the path the directory containing the use case's
     * resources).
     * @return (String)handleGetPathRoot()
     */
    public final String getPathRoot()
    {
        String pathRoot24a = this.__pathRoot24a;
        if (!this.__pathRoot24aSet)
        {
            // pathRoot has no pre constraints
            pathRoot24a = handleGetPathRoot();
            // pathRoot has no post constraints
            this.__pathRoot24a = pathRoot24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__pathRoot24aSet = true;
            }
        }
        return pathRoot24a;
    }

   /**
    * @see GuiUseCase#getForwardName()
    * @return String
    */
    protected abstract String handleGetForwardName();

    private String __forwardName25a;
    private boolean __forwardName25aSet = false;

    /**
     * The name that will cause a forward to use case.
     * @return (String)handleGetForwardName()
     */
    public final String getForwardName()
    {
        String forwardName25a = this.__forwardName25a;
        if (!this.__forwardName25aSet)
        {
            // forwardName has no pre constraints
            forwardName25a = handleGetForwardName();
            // forwardName has no post constraints
            this.__forwardName25a = forwardName25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__forwardName25aSet = true;
            }
        }
        return forwardName25a;
    }

   /**
    * @see GuiUseCase#getActionClassName()
    * @return String
    */
    protected abstract String handleGetActionClassName();

    private String __actionClassName26a;
    private boolean __actionClassName26aSet = false;

    /**
     * The name of the action class that forwards to this use case.
     * @return (String)handleGetActionClassName()
     */
    public final String getActionClassName()
    {
        String actionClassName26a = this.__actionClassName26a;
        if (!this.__actionClassName26aSet)
        {
            // actionClassName has no pre constraints
            actionClassName26a = handleGetActionClassName();
            // actionClassName has no post constraints
            this.__actionClassName26a = actionClassName26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionClassName26aSet = true;
            }
        }
        return actionClassName26a;
    }

   /**
    * @see GuiUseCase#getFullyQualifiedActionClassPath()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassPath();

    private String __fullyQualifiedActionClassPath27a;
    private boolean __fullyQualifiedActionClassPath27aSet = false;

    /**
     * The fully qualified path to the action class that forwards to this use case.
     * @return (String)handleGetFullyQualifiedActionClassPath()
     */
    public final String getFullyQualifiedActionClassPath()
    {
        String fullyQualifiedActionClassPath27a = this.__fullyQualifiedActionClassPath27a;
        if (!this.__fullyQualifiedActionClassPath27aSet)
        {
            // fullyQualifiedActionClassPath has no pre constraints
            fullyQualifiedActionClassPath27a = handleGetFullyQualifiedActionClassPath();
            // fullyQualifiedActionClassPath has no post constraints
            this.__fullyQualifiedActionClassPath27a = fullyQualifiedActionClassPath27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullyQualifiedActionClassPath27aSet = true;
            }
        }
        return fullyQualifiedActionClassPath27a;
    }

   /**
    * @see GuiUseCase#getControllerAction()
    * @return String
    */
    protected abstract String handleGetControllerAction();

    private String __controllerAction28a;
    private boolean __controllerAction28aSet = false;

    /**
     * The name of the action on the controller that executions this use case.
     * @return (String)handleGetControllerAction()
     */
    public final String getControllerAction()
    {
        String controllerAction28a = this.__controllerAction28a;
        if (!this.__controllerAction28aSet)
        {
            // controllerAction has no pre constraints
            controllerAction28a = handleGetControllerAction();
            // controllerAction has no post constraints
            this.__controllerAction28a = controllerAction28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__controllerAction28aSet = true;
            }
        }
        return controllerAction28a;
    }

   /**
    * @see GuiUseCase#getFullyQualifiedActionClassName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedActionClassName();

    private String __fullyQualifiedActionClassName29a;
    private boolean __fullyQualifiedActionClassName29aSet = false;

    /**
     * The fully qualified name of the action class that forwards to this use case.
     * @return (String)handleGetFullyQualifiedActionClassName()
     */
    public final String getFullyQualifiedActionClassName()
    {
        String fullyQualifiedActionClassName29a = this.__fullyQualifiedActionClassName29a;
        if (!this.__fullyQualifiedActionClassName29aSet)
        {
            // fullyQualifiedActionClassName has no pre constraints
            fullyQualifiedActionClassName29a = handleGetFullyQualifiedActionClassName();
            // fullyQualifiedActionClassName has no post constraints
            this.__fullyQualifiedActionClassName29a = fullyQualifiedActionClassName29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__fullyQualifiedActionClassName29aSet = true;
            }
        }
        return fullyQualifiedActionClassName29a;
    }

   /**
    * @see GuiUseCase#getInitialTargetPath()
    * @return String
    */
    protected abstract String handleGetInitialTargetPath();

    private String __initialTargetPath30a;
    private boolean __initialTargetPath30aSet = false;

    /**
     * The path of the initial target going into this use case.
     * @return (String)handleGetInitialTargetPath()
     */
    public final String getInitialTargetPath()
    {
        String initialTargetPath30a = this.__initialTargetPath30a;
        if (!this.__initialTargetPath30aSet)
        {
            // initialTargetPath has no pre constraints
            initialTargetPath30a = handleGetInitialTargetPath();
            // initialTargetPath has no post constraints
            this.__initialTargetPath30a = initialTargetPath30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__initialTargetPath30aSet = true;
            }
        }
        return initialTargetPath30a;
    }

   /**
    * @see GuiUseCase#isInitialTargetView()
    * @return boolean
    */
    protected abstract boolean handleIsInitialTargetView();

    private boolean __initialTargetView31a;
    private boolean __initialTargetView31aSet = false;

    /**
     * Indicates whether or not the initial target of this use case is a view or not.
     * @return (boolean)handleIsInitialTargetView()
     */
    public final boolean isInitialTargetView()
    {
        boolean initialTargetView31a = this.__initialTargetView31a;
        if (!this.__initialTargetView31aSet)
        {
            // initialTargetView has no pre constraints
            initialTargetView31a = handleIsInitialTargetView();
            // initialTargetView has no post constraints
            this.__initialTargetView31a = initialTargetView31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__initialTargetView31aSet = true;
            }
        }
        return initialTargetView31a;
    }

   /**
    * @see GuiUseCase#isViewHasNameOfUseCase()
    * @return boolean
    */
    protected abstract boolean handleIsViewHasNameOfUseCase();

    private boolean __viewHasNameOfUseCase32a;
    private boolean __viewHasNameOfUseCase32aSet = false;

    /**
     * Indicates whether or not at least one view in the use case has the same name as this use
     * case.
     * @return (boolean)handleIsViewHasNameOfUseCase()
     */
    public final boolean isViewHasNameOfUseCase()
    {
        boolean viewHasNameOfUseCase32a = this.__viewHasNameOfUseCase32a;
        if (!this.__viewHasNameOfUseCase32aSet)
        {
            // viewHasNameOfUseCase has no pre constraints
            viewHasNameOfUseCase32a = handleIsViewHasNameOfUseCase();
            // viewHasNameOfUseCase has no post constraints
            this.__viewHasNameOfUseCase32a = viewHasNameOfUseCase32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__viewHasNameOfUseCase32aSet = true;
            }
        }
        return viewHasNameOfUseCase32a;
    }

   /**
    * @see GuiUseCase#isRegistrationUseCase()
    * @return boolean
    */
    protected abstract boolean handleIsRegistrationUseCase();

    private boolean __registrationUseCase33a;
    private boolean __registrationUseCase33aSet = false;

    /**
     * Indicates whether or not this is a front-end registration use case.  Only one use case can be
     * labeled as a 'registration' use case.
     * @return (boolean)handleIsRegistrationUseCase()
     */
    public final boolean isRegistrationUseCase()
    {
        boolean registrationUseCase33a = this.__registrationUseCase33a;
        if (!this.__registrationUseCase33aSet)
        {
            // registrationUseCase has no pre constraints
            registrationUseCase33a = handleIsRegistrationUseCase();
            // registrationUseCase has no post constraints
            this.__registrationUseCase33a = registrationUseCase33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__registrationUseCase33aSet = true;
            }
        }
        return registrationUseCase33a;
    }

   /**
    * @see GuiUseCase#getForwardsClassName()
    * @return String
    */
    protected abstract String handleGetForwardsClassName();

    private String __forwardsClassName34a;
    private boolean __forwardsClassName34aSet = false;

    /**
     * The name of the class that stores all the forwards paths.
     * @return (String)handleGetForwardsClassName()
     */
    public final String getForwardsClassName()
    {
        String forwardsClassName34a = this.__forwardsClassName34a;
        if (!this.__forwardsClassName34aSet)
        {
            // forwardsClassName has no pre constraints
            forwardsClassName34a = handleGetForwardsClassName();
            // forwardsClassName has no post constraints
            this.__forwardsClassName34a = forwardsClassName34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__forwardsClassName34aSet = true;
            }
        }
        return forwardsClassName34a;
    }

   /**
    * @see GuiUseCase#getAllForwards()
    * @return List
    */
    protected abstract List handleGetAllForwards();

    private List __allForwards35a;
    private boolean __allForwards35aSet = false;

    /**
     * Constains all forwards includes regular FrontEndForwards and all actiion forwards.
     * @return (List)handleGetAllForwards()
     */
    public final List getAllForwards()
    {
        List allForwards35a = this.__allForwards35a;
        if (!this.__allForwards35aSet)
        {
            // allForwards has no pre constraints
            allForwards35a = handleGetAllForwards();
            // allForwards has no post constraints
            this.__allForwards35a = allForwards35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__allForwards35aSet = true;
            }
        }
        return allForwards35a;
    }

   /**
    * @see GuiUseCase#getPortletViewForwardName()
    * @return String
    */
    protected abstract String handleGetPortletViewForwardName();

    private String __portletViewForwardName36a;
    private boolean __portletViewForwardName36aSet = false;

    /**
     * The forward name for the portlet 'view' page.
     * @return (String)handleGetPortletViewForwardName()
     */
    public final String getPortletViewForwardName()
    {
        String portletViewForwardName36a = this.__portletViewForwardName36a;
        if (!this.__portletViewForwardName36aSet)
        {
            // portletViewForwardName has no pre constraints
            portletViewForwardName36a = handleGetPortletViewForwardName();
            // portletViewForwardName has no post constraints
            this.__portletViewForwardName36a = portletViewForwardName36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__portletViewForwardName36aSet = true;
            }
        }
        return portletViewForwardName36a;
    }

   /**
    * @see GuiUseCase#getPortletEditForwardName()
    * @return String
    */
    protected abstract String handleGetPortletEditForwardName();

    private String __portletEditForwardName37a;
    private boolean __portletEditForwardName37aSet = false;

    /**
     * The forward name for the portlet 'edit' page.
     * @return (String)handleGetPortletEditForwardName()
     */
    public final String getPortletEditForwardName()
    {
        String portletEditForwardName37a = this.__portletEditForwardName37a;
        if (!this.__portletEditForwardName37aSet)
        {
            // portletEditForwardName has no pre constraints
            portletEditForwardName37a = handleGetPortletEditForwardName();
            // portletEditForwardName has no post constraints
            this.__portletEditForwardName37a = portletEditForwardName37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__portletEditForwardName37aSet = true;
            }
        }
        return portletEditForwardName37a;
    }

   /**
    * @see GuiUseCase#getPortletHelpForwardName()
    * @return String
    */
    protected abstract String handleGetPortletHelpForwardName();

    private String __portletHelpForwardName38a;
    private boolean __portletHelpForwardName38aSet = false;

    /**
     * The forward name for the portlet 'help' page.
     * @return (String)handleGetPortletHelpForwardName()
     */
    public final String getPortletHelpForwardName()
    {
        String portletHelpForwardName38a = this.__portletHelpForwardName38a;
        if (!this.__portletHelpForwardName38aSet)
        {
            // portletHelpForwardName has no pre constraints
            portletHelpForwardName38a = handleGetPortletHelpForwardName();
            // portletHelpForwardName has no post constraints
            this.__portletHelpForwardName38a = portletHelpForwardName38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__portletHelpForwardName38aSet = true;
            }
        }
        return portletHelpForwardName38a;
    }

   /**
    * @see GuiUseCase#getPortletViewPath()
    * @return String
    */
    protected abstract String handleGetPortletViewPath();

    private String __portletViewPath39a;
    private boolean __portletViewPath39aSet = false;

    /**
     * The path to the portlet 'view' page.
     * @return (String)handleGetPortletViewPath()
     */
    public final String getPortletViewPath()
    {
        String portletViewPath39a = this.__portletViewPath39a;
        if (!this.__portletViewPath39aSet)
        {
            // portletViewPath has no pre constraints
            portletViewPath39a = handleGetPortletViewPath();
            // portletViewPath has no post constraints
            this.__portletViewPath39a = portletViewPath39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__portletViewPath39aSet = true;
            }
        }
        return portletViewPath39a;
    }

   /**
    * @see GuiUseCase#getPortletEditPath()
    * @return String
    */
    protected abstract String handleGetPortletEditPath();

    private String __portletEditPath40a;
    private boolean __portletEditPath40aSet = false;

    /**
     * The path to the portlet 'edit' page.
     * @return (String)handleGetPortletEditPath()
     */
    public final String getPortletEditPath()
    {
        String portletEditPath40a = this.__portletEditPath40a;
        if (!this.__portletEditPath40aSet)
        {
            // portletEditPath has no pre constraints
            portletEditPath40a = handleGetPortletEditPath();
            // portletEditPath has no post constraints
            this.__portletEditPath40a = portletEditPath40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__portletEditPath40aSet = true;
            }
        }
        return portletEditPath40a;
    }

   /**
    * @see GuiUseCase#getPortletHelpPath()
    * @return String
    */
    protected abstract String handleGetPortletHelpPath();

    private String __portletHelpPath41a;
    private boolean __portletHelpPath41aSet = false;

    /**
     * The path to the 'help' page of the portlet.
     * @return (String)handleGetPortletHelpPath()
     */
    public final String getPortletHelpPath()
    {
        String portletHelpPath41a = this.__portletHelpPath41a;
        if (!this.__portletHelpPath41aSet)
        {
            // portletHelpPath has no pre constraints
            portletHelpPath41a = handleGetPortletHelpPath();
            // portletHelpPath has no post constraints
            this.__portletHelpPath41a = portletHelpPath41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__portletHelpPath41aSet = true;
            }
        }
        return portletHelpPath41a;
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
        List<GuiForward> forwards42a = null;
        // forwards has no pre constraints
        forwards42a = handleGetForwards();
        // forwards has no post constraints
        return forwards42a;
    }

   /**
    * @see GuiUseCase#getActionForwards()
    * @return List<GuiAction>
    */
    protected abstract List<GuiAction> handleGetActionForwards();

    private List<GuiAction> __actionForwards43a;
    private boolean __actionForwards43aSet = false;

    /**
     * All forwards in this use case that are represented as actions.
     * @return (List<GuiAction>)handleGetActionForwards()
     */
    public final List<GuiAction> getActionForwards()
    {
        List<GuiAction> actionForwards43a = this.__actionForwards43a;
        if (!this.__actionForwards43aSet)
        {
            // actionForwards has no pre constraints
            actionForwards43a = handleGetActionForwards();
            // actionForwards has no post constraints
            this.__actionForwards43a = actionForwards43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionForwards43aSet = true;
            }
        }
        return actionForwards43a;
    }

   /**
    * @see GuiUseCase#getAllViews()
    * @return Collection<GuiView>
    */
    protected abstract Collection<GuiView> handleGetAllViews();

    private Collection<GuiView> __allViews44a;
    private boolean __allViews44aSet = false;

    /**
     * All views for the application (not just the ones belonging to this use case).
     * @return (Collection<GuiView>)handleGetAllViews()
     */
    public final Collection<GuiView> getAllViews()
    {
        Collection<GuiView> allViews44a = this.__allViews44a;
        if (!this.__allViews44aSet)
        {
            // allViews has no pre constraints
            allViews44a = handleGetAllViews();
            // allViews has no post constraints
            this.__allViews44a = allViews44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__allViews44aSet = true;
            }
        }
        return allViews44a;
    }

   /**
    * @see GuiUseCase#getRegistrationUseCases()
    * @return List<GuiUseCase>
    */
    protected abstract List<GuiUseCase> handleGetRegistrationUseCases();

    private List<GuiUseCase> __registrationUseCases45a;
    private boolean __registrationUseCases45aSet = false;

    /**
     * All use cases that are labled as registration use cases.
     * @return (List<GuiUseCase>)handleGetRegistrationUseCases()
     */
    public final List<GuiUseCase> getRegistrationUseCases()
    {
        List<GuiUseCase> registrationUseCases45a = this.__registrationUseCases45a;
        if (!this.__registrationUseCases45aSet)
        {
            // registrationUseCases has no pre constraints
            registrationUseCases45a = handleGetRegistrationUseCases();
            // registrationUseCases has no post constraints
            this.__registrationUseCases45a = registrationUseCases45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__registrationUseCases45aSet = true;
            }
        }
        return registrationUseCases45a;
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

    private List<GuiView> __getAllPages1r;
    private boolean __getAllPages1rSet = false;

    /**
     * 
     * @return (List<GuiView>)handleGetAllPages()
     */
    public final List<GuiView> getAllPages()
    {
        List<GuiView> getAllPages1r = this.__getAllPages1r;
        if (!this.__getAllPages1rSet)
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
                GuiUseCaseLogic.logger.warn("incorrect metafacade cast for GuiUseCaseLogic.getAllPages List<GuiView> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.__getAllPages1r = getAllPages1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getAllPages1rSet = true;
            }
        }
        return getAllPages1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetAllPages();

    private List<GuiParameter> __getFormFields2r;
    private boolean __getFormFields2rSet = false;

    /**
     * 
     * @return (List<GuiParameter>)handleGetFormFields()
     */
    public final List<GuiParameter> getFormFields()
    {
        List<GuiParameter> getFormFields2r = this.__getFormFields2r;
        if (!this.__getFormFields2rSet)
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
                GuiUseCaseLogic.logger.warn("incorrect metafacade cast for GuiUseCaseLogic.getFormFields List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.__getFormFields2r = getFormFields2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getFormFields2rSet = true;
            }
        }
        return getFormFields2r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetFormFields();

    private Collection<GuiUseCase> __getIncludedUseCases3r;
    private boolean __getIncludedUseCases3rSet = false;

    /**
     * 
     * @return (Collection<GuiUseCase>)handleGetIncludedUseCases()
     */
    public final Collection<GuiUseCase> getIncludedUseCases()
    {
        Collection<GuiUseCase> getIncludedUseCases3r = this.__getIncludedUseCases3r;
        if (!this.__getIncludedUseCases3rSet)
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
                GuiUseCaseLogic.logger.warn("incorrect metafacade cast for GuiUseCaseLogic.getIncludedUseCases Collection<GuiUseCase> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.__getIncludedUseCases3r = getIncludedUseCases3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getIncludedUseCases3rSet = true;
            }
        }
        return getIncludedUseCases3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetIncludedUseCases();

    private List<GuiParameter> __getPageVariables4r;
    private boolean __getPageVariables4rSet = false;

    /**
     * 
     * @return (List<GuiParameter>)handleGetPageVariables()
     */
    public final List<GuiParameter> getPageVariables()
    {
        List<GuiParameter> getPageVariables4r = this.__getPageVariables4r;
        if (!this.__getPageVariables4rSet)
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
                GuiUseCaseLogic.logger.warn("incorrect metafacade cast for GuiUseCaseLogic.getPageVariables List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.__getPageVariables4r = getPageVariables4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getPageVariables4rSet = true;
            }
        }
        return getPageVariables4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetPageVariables();

    private List<GuiUseCase> __getDirectSubUseCases5r;
    private boolean __getDirectSubUseCases5rSet = false;

    /**
     * 
     * @return (List<GuiUseCase>)handleGetDirectSubUseCases()
     */
    public final List<GuiUseCase> getDirectSubUseCases()
    {
        List<GuiUseCase> getDirectSubUseCases5r = this.__getDirectSubUseCases5r;
        if (!this.__getDirectSubUseCases5rSet)
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
                GuiUseCaseLogic.logger.warn("incorrect metafacade cast for GuiUseCaseLogic.getDirectSubUseCases List<GuiUseCase> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.__getDirectSubUseCases5r = getDirectSubUseCases5r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getDirectSubUseCases5rSet = true;
            }
        }
        return getDirectSubUseCases5r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetDirectSubUseCases();

    private List<GuiView> __getPages6r;
    private boolean __getPages6rSet = false;

    /**
     * 
     * @return (List<GuiView>)handleGetPages()
     */
    public final List<GuiView> getPages()
    {
        List<GuiView> getPages6r = this.__getPages6r;
        if (!this.__getPages6rSet)
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
                GuiUseCaseLogic.logger.warn("incorrect metafacade cast for GuiUseCaseLogic.getPages List<GuiView> " + result + ": " + shieldedResult);
            }
            // guiUseCase has no post constraints
            this.__getPages6r = getPages6r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getPages6rSet = true;
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
            GuiUseCaseLogic.logger.warn("incorrect metafacade cast for GuiUseCaseLogic.getPreferences GuiPortletPreferences " + result + ": " + shieldedResult);
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
    public Collection getAllProperties()
    {
        return this.getSuperFrontEndUseCase().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection getAllRequiredConstructorParameters()
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
    public List getAttributes(boolean follow)
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
    public List getNavigableConnectingEnds(boolean follow)
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
    public List getProperties()
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
    public Collection getRequiredConstructorParameters()
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
    public Collection findTaggedValues(String tagName)
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
    public Collection getConstraints(String kind)
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
     * <p><b>OCL:</b> context GuiUseCase inv: allUseCases->exists(u : GuiUseCase | workbook=true)</p>
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
            boolean constraintValid = OCLResultEnsurer.ensure(OCLCollections.exists(OCLIntrospector.invoke(contextElement,"allUseCases"),new Predicate(){public boolean evaluate(Object object){return Boolean.valueOf(String.valueOf(OCLExpressions.equal(OCLIntrospector.invoke(object,"workbook"),true))).booleanValue();}}));
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