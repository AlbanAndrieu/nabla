// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ActionFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EventFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndExceptionHandler;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndUseCase;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.PartitionFacade;
import org.andromda.metafacades.uml.StateFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TransitionFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.andromda.translation.ocl.validation.OCLExpressions;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.log4j.Logger;

/**
 * A Gui view represents a page in the web application. A page possibly contains several conainters
 * and controls (either buttons or hyperlinks) that call actions. A Gui view allow generation of
 * EJBs and XML page descriptors
 * MetafacadeLogic for GuiView
 *
 * @see GuiView
 */
public abstract class GuiViewLogic
    extends MetafacadeBase
    implements GuiView
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
    protected GuiViewLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superFrontEndView =
           (FrontEndView)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.FrontEndView",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiViewLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiView if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiView";
        }
        return context;
    }

    private FrontEndView superFrontEndView;
    private boolean superFrontEndViewInitialized = false;

    /**
     * Gets the FrontEndView parent instance.
     * @return this.superFrontEndView FrontEndView
     */
    private FrontEndView getSuperFrontEndView()
    {
        if (!this.superFrontEndViewInitialized)
        {
            ((MetafacadeBase)this.superFrontEndView).setMetafacadeContext(this.getMetafacadeContext());
            this.superFrontEndViewInitialized = true;
        }
        return this.superFrontEndView;
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
            if (this.superFrontEndViewInitialized)
            {
                ((MetafacadeBase)this.superFrontEndView).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see GuiView
     */
    public boolean isGuiViewMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getFullPath()
    * @return String
    */
    protected abstract String handleGetFullPath();

    private transient String fullPath1a;
    private transient boolean fullPath1aSet = false;

    /**
     * The full path to this view page.
     * @return (String)handleGetFullPath()
     */
    public final String getFullPath()
    {
        String fullPath1a = this.fullPath1a;
        if (!this.fullPath1aSet)
        {
            // fullPath has no pre constraints
            fullPath1a = handleGetFullPath();
            // fullPath has no post constraints
            this.fullPath1a = fullPath1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullPath1aSet = true;
            }
        }
        return fullPath1a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getTitleKey()
    * @return String
    */
    protected abstract String handleGetTitleKey();

    private transient String titleKey2a;
    private transient boolean titleKey2aSet = false;

    /**
     * A resource message key suited for the page's title.
     * @return (String)handleGetTitleKey()
     */
    public final String getTitleKey()
    {
        String titleKey2a = this.titleKey2a;
        if (!this.titleKey2aSet)
        {
            // titleKey has no pre constraints
            titleKey2a = handleGetTitleKey();
            // titleKey has no post constraints
            this.titleKey2a = titleKey2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.titleKey2aSet = true;
            }
        }
        return titleKey2a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getTitleValue()
    * @return String
    */
    protected abstract String handleGetTitleValue();

    private transient String titleValue3a;
    private transient boolean titleValue3aSet = false;

    /**
     * A default resource message value suited for the page's title.
     * @return (String)handleGetTitleValue()
     */
    public final String getTitleValue()
    {
        String titleValue3a = this.titleValue3a;
        if (!this.titleValue3aSet)
        {
            // titleValue has no pre constraints
            titleValue3a = handleGetTitleValue();
            // titleValue has no post constraints
            this.titleValue3a = titleValue3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.titleValue3aSet = true;
            }
        }
        return titleValue3a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private transient String messageKey4a;
    private transient boolean messageKey4aSet = false;

    /**
     * The default resource message key.
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String messageKey4a = this.messageKey4a;
        if (!this.messageKey4aSet)
        {
            // messageKey has no pre constraints
            messageKey4a = handleGetMessageKey();
            // messageKey has no post constraints
            this.messageKey4a = messageKey4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageKey4aSet = true;
            }
        }
        return messageKey4a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getDocumentationKey()
    * @return String
    */
    protected abstract String handleGetDocumentationKey();

    private transient String documentationKey5a;
    private transient boolean documentationKey5aSet = false;

    /**
     * A resource message key suited for the page's documentation.
     * @return (String)handleGetDocumentationKey()
     */
    public final String getDocumentationKey()
    {
        String documentationKey5a = this.documentationKey5a;
        if (!this.documentationKey5aSet)
        {
            // documentationKey has no pre constraints
            documentationKey5a = handleGetDocumentationKey();
            // documentationKey has no post constraints
            this.documentationKey5a = documentationKey5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentationKey5aSet = true;
            }
        }
        return documentationKey5a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getDocumentationValue()
    * @return String
    */
    protected abstract String handleGetDocumentationValue();

    private transient String documentationValue6a;
    private transient boolean documentationValue6aSet = false;

    /**
     * A resource message value suited for the page's documentation.
     * @return (String)handleGetDocumentationValue()
     */
    public final String getDocumentationValue()
    {
        String documentationValue6a = this.documentationValue6a;
        if (!this.documentationValue6aSet)
        {
            // documentationValue has no pre constraints
            documentationValue6a = handleGetDocumentationValue();
            // documentationValue has no post constraints
            this.documentationValue6a = documentationValue6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentationValue6aSet = true;
            }
        }
        return documentationValue6a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private transient boolean validationRequired7a;
    private transient boolean validationRequired7aSet = false;

    /**
     * True if at least one client/server parameter requires validation.
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean validationRequired7a = this.validationRequired7a;
        if (!this.validationRequired7aSet)
        {
            // validationRequired has no pre constraints
            validationRequired7a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.validationRequired7a = validationRequired7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validationRequired7aSet = true;
            }
        }
        return validationRequired7a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isDateFieldPresent()
    * @return boolean
    */
    protected abstract boolean handleIsDateFieldPresent();

    private transient boolean dateFieldPresent8a;
    private transient boolean dateFieldPresent8aSet = false;

    /**
     * True if any of the actions have a parameter of type Date.
     * @return (boolean)handleIsDateFieldPresent()
     */
    public final boolean isDateFieldPresent()
    {
        boolean dateFieldPresent8a = this.dateFieldPresent8a;
        if (!this.dateFieldPresent8aSet)
        {
            // dateFieldPresent has no pre constraints
            dateFieldPresent8a = handleIsDateFieldPresent();
            // dateFieldPresent has no post constraints
            this.dateFieldPresent8a = dateFieldPresent8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dateFieldPresent8aSet = true;
            }
        }
        return dateFieldPresent8a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isCalendarRequired()
    * @return boolean
    */
    protected abstract boolean handleIsCalendarRequired();

    private transient boolean calendarRequired9a;
    private transient boolean calendarRequired9aSet = false;

    /**
     * True if this view contains a date field which requires a calendar popup.
     * @return (boolean)handleIsCalendarRequired()
     */
    public final boolean isCalendarRequired()
    {
        boolean calendarRequired9a = this.calendarRequired9a;
        if (!this.calendarRequired9aSet)
        {
            // calendarRequired has no pre constraints
            calendarRequired9a = handleIsCalendarRequired();
            // calendarRequired has no post constraints
            this.calendarRequired9a = calendarRequired9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.calendarRequired9aSet = true;
            }
        }
        return calendarRequired9a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private transient String onlineHelpKey10a;
    private transient boolean onlineHelpKey10aSet = false;

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String onlineHelpKey10a = this.onlineHelpKey10a;
        if (!this.onlineHelpKey10aSet)
        {
            // onlineHelpKey has no pre constraints
            onlineHelpKey10a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.onlineHelpKey10a = onlineHelpKey10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpKey10aSet = true;
            }
        }
        return onlineHelpKey10a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private transient String onlineHelpValue11a;
    private transient boolean onlineHelpValue11aSet = false;

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String onlineHelpValue11a = this.onlineHelpValue11a;
        if (!this.onlineHelpValue11aSet)
        {
            // onlineHelpValue has no pre constraints
            onlineHelpValue11a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.onlineHelpValue11a = onlineHelpValue11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpValue11aSet = true;
            }
        }
        return onlineHelpValue11a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getMessageValue()
    * @return String
    */
    protected abstract String handleGetMessageValue();

    private transient String messageValue12a;
    private transient boolean messageValue12aSet = false;

    /**
     * A displayable version of this page's name.
     * @return (String)handleGetMessageValue()
     */
    public final String getMessageValue()
    {
        String messageValue12a = this.messageValue12a;
        if (!this.messageValue12aSet)
        {
            // messageValue has no pre constraints
            messageValue12a = handleGetMessageValue();
            // messageValue has no post constraints
            this.messageValue12a = messageValue12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageValue12aSet = true;
            }
        }
        return messageValue12a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getCssFileName()
    * @return String
    */
    protected abstract String handleGetCssFileName();

    private transient String cssFileName13a;
    private transient boolean cssFileName13aSet = false;

    /**
     * The name of the file containing specific styles for this page only.
     * @return (String)handleGetCssFileName()
     */
    public final String getCssFileName()
    {
        String cssFileName13a = this.cssFileName13a;
        if (!this.cssFileName13aSet)
        {
            // cssFileName has no pre constraints
            cssFileName13a = handleGetCssFileName();
            // cssFileName has no post constraints
            this.cssFileName13a = cssFileName13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.cssFileName13aSet = true;
            }
        }
        return cssFileName13a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getOnlineHelpActionPath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpActionPath();

    private transient String onlineHelpActionPath14a;
    private transient boolean onlineHelpActionPath14aSet = false;

    /**
     * The full path to this view's online help action.
     * @return (String)handleGetOnlineHelpActionPath()
     */
    public final String getOnlineHelpActionPath()
    {
        String onlineHelpActionPath14a = this.onlineHelpActionPath14a;
        if (!this.onlineHelpActionPath14aSet)
        {
            // onlineHelpActionPath has no pre constraints
            onlineHelpActionPath14a = handleGetOnlineHelpActionPath();
            // onlineHelpActionPath has no post constraints
            this.onlineHelpActionPath14a = onlineHelpActionPath14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpActionPath14aSet = true;
            }
        }
        return onlineHelpActionPath14a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getOnlineHelpPagePath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpPagePath();

    private transient String onlineHelpPagePath15a;
    private transient boolean onlineHelpPagePath15aSet = false;

    /**
     * The full path to this view's online help page.
     * @return (String)handleGetOnlineHelpPagePath()
     */
    public final String getOnlineHelpPagePath()
    {
        String onlineHelpPagePath15a = this.onlineHelpPagePath15a;
        if (!this.onlineHelpPagePath15aSet)
        {
            // onlineHelpPagePath has no pre constraints
            onlineHelpPagePath15a = handleGetOnlineHelpPagePath();
            // onlineHelpPagePath has no post constraints
            this.onlineHelpPagePath15a = onlineHelpPagePath15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpPagePath15aSet = true;
            }
        }
        return onlineHelpPagePath15a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isActionGroup()
    * @return boolean
    */
    protected abstract boolean handleIsActionGroup();

    private transient boolean actionGroup16a;
    private transient boolean actionGroup16aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.actionGroup
     * @return (boolean)handleIsActionGroup()
     */
    public final boolean isActionGroup()
    {
        boolean actionGroup16a = this.actionGroup16a;
        if (!this.actionGroup16aSet)
        {
            // actionGroup has no pre constraints
            actionGroup16a = handleIsActionGroup();
            // actionGroup has no post constraints
            this.actionGroup16a = actionGroup16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionGroup16aSet = true;
            }
        }
        return actionGroup16a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getActionGroupName()
    * @return String
    */
    protected abstract String handleGetActionGroupName();

    private transient String actionGroupName17a;
    private transient boolean actionGroupName17aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.actionGroupName
     * @return (String)handleGetActionGroupName()
     */
    public final String getActionGroupName()
    {
        String actionGroupName17a = this.actionGroupName17a;
        if (!this.actionGroupName17aSet)
        {
            // actionGroupName has no pre constraints
            actionGroupName17a = handleGetActionGroupName();
            // actionGroupName has no post constraints
            this.actionGroupName17a = actionGroupName17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionGroupName17aSet = true;
            }
        }
        return actionGroupName17a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isExpandable()
    * @return boolean
    */
    protected abstract boolean handleIsExpandable();

    private transient boolean expandable18a;
    private transient boolean expandable18aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.expandable
     * @return (boolean)handleIsExpandable()
     */
    public final boolean isExpandable()
    {
        boolean expandable18a = this.expandable18a;
        if (!this.expandable18aSet)
        {
            // expandable has no pre constraints
            expandable18a = handleIsExpandable();
            // expandable has no post constraints
            this.expandable18a = expandable18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.expandable18aSet = true;
            }
        }
        return expandable18a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isTabs()
    * @return boolean
    */
    protected abstract boolean handleIsTabs();

    private transient boolean tabs19a;
    private transient boolean tabs19aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.tabs
     * @return (boolean)handleIsTabs()
     */
    public final boolean isTabs()
    {
        boolean tabs19a = this.tabs19a;
        if (!this.tabs19aSet)
        {
            // tabs has no pre constraints
            tabs19a = handleIsTabs();
            // tabs has no post constraints
            this.tabs19a = tabs19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tabs19aSet = true;
            }
        }
        return tabs19a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isTransparent()
    * @return boolean
    */
    protected abstract boolean handleIsTransparent();

    private transient boolean transparent20a;
    private transient boolean transparent20aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.transparent
     * @return (boolean)handleIsTransparent()
     */
    public final boolean isTransparent()
    {
        boolean transparent20a = this.transparent20a;
        if (!this.transparent20aSet)
        {
            // transparent has no pre constraints
            transparent20a = handleIsTransparent();
            // transparent has no post constraints
            this.transparent20a = transparent20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transparent20aSet = true;
            }
        }
        return transparent20a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isWindow()
    * @return boolean
    */
    protected abstract boolean handleIsWindow();

    private transient boolean window21a;
    private transient boolean window21aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.window
     * @return (boolean)handleIsWindow()
     */
    public final boolean isWindow()
    {
        boolean window21a = this.window21a;
        if (!this.window21aSet)
        {
            // window has no pre constraints
            window21a = handleIsWindow();
            // window has no post constraints
            this.window21a = window21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.window21aSet = true;
            }
        }
        return window21a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isToolbar()
    * @return boolean
    */
    protected abstract boolean handleIsToolbar();

    private transient boolean toolbar22a;
    private transient boolean toolbar22aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.toolbar
     * @return (boolean)handleIsToolbar()
     */
    public final boolean isToolbar()
    {
        boolean toolbar22a = this.toolbar22a;
        if (!this.toolbar22aSet)
        {
            // toolbar has no pre constraints
            toolbar22a = handleIsToolbar();
            // toolbar has no post constraints
            this.toolbar22a = toolbar22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.toolbar22aSet = true;
            }
        }
        return toolbar22a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isFilterView()
    * @return boolean
    */
    protected abstract boolean handleIsFilterView();

    private transient boolean filterView23a;
    private transient boolean filterView23aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.filterView
     * @return (boolean)handleIsFilterView()
     */
    public final boolean isFilterView()
    {
        boolean filterView23a = this.filterView23a;
        if (!this.filterView23aSet)
        {
            // filterView has no pre constraints
            filterView23a = handleIsFilterView();
            // filterView has no post constraints
            this.filterView23a = filterView23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.filterView23aSet = true;
            }
        }
        return filterView23a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isMainToolbar()
    * @return boolean
    */
    protected abstract boolean handleIsMainToolbar();

    private transient boolean mainToolbar24a;
    private transient boolean mainToolbar24aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.mainToolbar
     * @return (boolean)handleIsMainToolbar()
     */
    public final boolean isMainToolbar()
    {
        boolean mainToolbar24a = this.mainToolbar24a;
        if (!this.mainToolbar24aSet)
        {
            // mainToolbar has no pre constraints
            mainToolbar24a = handleIsMainToolbar();
            // mainToolbar has no post constraints
            this.mainToolbar24a = mainToolbar24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.mainToolbar24aSet = true;
            }
        }
        return mainToolbar24a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isHeldTable()
    * @return boolean
    */
    protected abstract boolean handleIsHeldTable();

    private transient boolean heldTable25a;
    private transient boolean heldTable25aSet = false;

    /**
     * Returns true if the view contains only a table.
     * @return (boolean)handleIsHeldTable()
     */
    public final boolean isHeldTable()
    {
        boolean heldTable25a = this.heldTable25a;
        if (!this.heldTable25aSet)
        {
            // heldTable has no pre constraints
            heldTable25a = handleIsHeldTable();
            // heldTable has no post constraints
            this.heldTable25a = heldTable25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.heldTable25aSet = true;
            }
        }
        return heldTable25a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isAsynchronous()
    * @return boolean
    */
    protected abstract boolean handleIsAsynchronous();

    private transient boolean asynchronous26a;
    private transient boolean asynchronous26aSet = false;

    /**
     * This attribute is true if the view is stereotyped with AsynchronousView
     * @return (boolean)handleIsAsynchronous()
     */
    public final boolean isAsynchronous()
    {
        boolean asynchronous26a = this.asynchronous26a;
        if (!this.asynchronous26aSet)
        {
            // asynchronous has no pre constraints
            asynchronous26a = handleIsAsynchronous();
            // asynchronous has no post constraints
            this.asynchronous26a = asynchronous26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.asynchronous26aSet = true;
            }
        }
        return asynchronous26a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getPath()
    * @return String
    */
    protected abstract String handleGetPath();

    private transient String path27a;
    private transient boolean path27aSet = false;

    /**
     * The full path of the view resources (i.e. the JSP page).
     * @return (String)handleGetPath()
     */
    public final String getPath()
    {
        String path27a = this.path27a;
        if (!this.path27aSet)
        {
            // path has no pre constraints
            path27a = handleGetPath();
            // path has no post constraints
            this.path27a = path27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.path27aSet = true;
            }
        }
        return path27a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getFullyQualifiedPopulator()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedPopulator();

    private transient String fullyQualifiedPopulator28a;
    private transient boolean fullyQualifiedPopulator28aSet = false;

    /**
     * The fully qualified name of this view's form populator.
     * @return (String)handleGetFullyQualifiedPopulator()
     */
    public final String getFullyQualifiedPopulator()
    {
        String fullyQualifiedPopulator28a = this.fullyQualifiedPopulator28a;
        if (!this.fullyQualifiedPopulator28aSet)
        {
            // fullyQualifiedPopulator has no pre constraints
            fullyQualifiedPopulator28a = handleGetFullyQualifiedPopulator();
            // fullyQualifiedPopulator has no post constraints
            this.fullyQualifiedPopulator28a = fullyQualifiedPopulator28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedPopulator28aSet = true;
            }
        }
        return fullyQualifiedPopulator28a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getPopulator()
    * @return String
    */
    protected abstract String handleGetPopulator();

    private transient String populator29a;
    private transient boolean populator29aSet = false;

    /**
     * The name of the form populator for this view.
     * @return (String)handleGetPopulator()
     */
    public final String getPopulator()
    {
        String populator29a = this.populator29a;
        if (!this.populator29aSet)
        {
            // populator has no pre constraints
            populator29a = handleGetPopulator();
            // populator has no post constraints
            this.populator29a = populator29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.populator29aSet = true;
            }
        }
        return populator29a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getPopulatorPath()
    * @return String
    */
    protected abstract String handleGetPopulatorPath();

    private transient String populatorPath30a;
    private transient boolean populatorPath30aSet = false;

    /**
     * The path to the form populator.
     * @return (String)handleGetPopulatorPath()
     */
    public final String getPopulatorPath()
    {
        String populatorPath30a = this.populatorPath30a;
        if (!this.populatorPath30aSet)
        {
            // populatorPath has no pre constraints
            populatorPath30a = handleGetPopulatorPath();
            // populatorPath has no post constraints
            this.populatorPath30a = populatorPath30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.populatorPath30aSet = true;
            }
        }
        return populatorPath30a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isPopulatorRequired()
    * @return boolean
    */
    protected abstract boolean handleIsPopulatorRequired();

    private transient boolean populatorRequired31a;
    private transient boolean populatorRequired31aSet = false;

    /**
     * Indicates if a populator is required for this view.
     * @return (boolean)handleIsPopulatorRequired()
     */
    public final boolean isPopulatorRequired()
    {
        boolean populatorRequired31a = this.populatorRequired31a;
        if (!this.populatorRequired31aSet)
        {
            // populatorRequired has no pre constraints
            populatorRequired31a = handleIsPopulatorRequired();
            // populatorRequired has no post constraints
            this.populatorRequired31a = populatorRequired31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.populatorRequired31aSet = true;
            }
        }
        return populatorRequired31a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isPopup()
    * @return boolean
    */
    protected abstract boolean handleIsPopup();

    private transient boolean popup32a;
    private transient boolean popup32aSet = false;

    /**
     * Indicates if this view represents a popup.
     * @return (boolean)handleIsPopup()
     */
    public final boolean isPopup()
    {
        boolean popup32a = this.popup32a;
        if (!this.popup32aSet)
        {
            // popup has no pre constraints
            popup32a = handleIsPopup();
            // popup has no post constraints
            this.popup32a = popup32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.popup32aSet = true;
            }
        }
        return popup32a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isNonTableVariablesPresent()
    * @return boolean
    */
    protected abstract boolean handleIsNonTableVariablesPresent();

    private transient boolean nonTableVariablesPresent33a;
    private transient boolean nonTableVariablesPresent33aSet = false;

    /**
     * Indicates whether or not any non-table view variables are present in this view.
     * @return (boolean)handleIsNonTableVariablesPresent()
     */
    public final boolean isNonTableVariablesPresent()
    {
        boolean nonTableVariablesPresent33a = this.nonTableVariablesPresent33a;
        if (!this.nonTableVariablesPresent33aSet)
        {
            // nonTableVariablesPresent has no pre constraints
            nonTableVariablesPresent33a = handleIsNonTableVariablesPresent();
            // nonTableVariablesPresent has no post constraints
            this.nonTableVariablesPresent33a = nonTableVariablesPresent33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.nonTableVariablesPresent33aSet = true;
            }
        }
        return nonTableVariablesPresent33a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isHasNameOfUseCase()
    * @return boolean
    */
    protected abstract boolean handleIsHasNameOfUseCase();

    private transient boolean hasNameOfUseCase34a;
    private transient boolean hasNameOfUseCase34aSet = false;

    /**
     * Indicates whether or not this view has the same name as the use case in which it is
     * contained.
     * @return (boolean)handleIsHasNameOfUseCase()
     */
    public final boolean isHasNameOfUseCase()
    {
        boolean hasNameOfUseCase34a = this.hasNameOfUseCase34a;
        if (!this.hasNameOfUseCase34aSet)
        {
            // hasNameOfUseCase has no pre constraints
            hasNameOfUseCase34a = handleIsHasNameOfUseCase();
            // hasNameOfUseCase has no post constraints
            this.hasNameOfUseCase34a = hasNameOfUseCase34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hasNameOfUseCase34aSet = true;
            }
        }
        return hasNameOfUseCase34a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getFormKey()
    * @return String
    */
    protected abstract String handleGetFormKey();

    private transient String formKey35a;
    private transient boolean formKey35aSet = false;

    /**
     * The key that stores the form in which information is passed from one action to another.
     * @return (String)handleGetFormKey()
     */
    public final String getFormKey()
    {
        String formKey35a = this.formKey35a;
        if (!this.formKey35aSet)
        {
            // formKey has no pre constraints
            formKey35a = handleGetFormKey();
            // formKey has no post constraints
            this.formKey35a = formKey35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formKey35aSet = true;
            }
        }
        return formKey35a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getFromOutcome()
    * @return String
    */
    protected abstract String handleGetFromOutcome();

    private transient String fromOutcome36a;
    private transient boolean fromOutcome36aSet = false;

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @return (String)handleGetFromOutcome()
     */
    public final String getFromOutcome()
    {
        String fromOutcome36a = this.fromOutcome36a;
        if (!this.fromOutcome36aSet)
        {
            // fromOutcome has no pre constraints
            fromOutcome36a = handleGetFromOutcome();
            // fromOutcome has no post constraints
            this.fromOutcome36a = fromOutcome36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fromOutcome36aSet = true;
            }
        }
        return fromOutcome36a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#isNeedsFileUpload()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsFileUpload();

    private transient boolean needsFileUpload37a;
    private transient boolean needsFileUpload37aSet = false;

    /**
     * TODO: Model Documentation for org.andromda.cartridges.gui.metafacades.GuiView.needsFileUpload
     * @return (boolean)handleIsNeedsFileUpload()
     */
    public final boolean isNeedsFileUpload()
    {
        boolean needsFileUpload37a = this.needsFileUpload37a;
        if (!this.needsFileUpload37aSet)
        {
            // needsFileUpload has no pre constraints
            needsFileUpload37a = handleIsNeedsFileUpload();
            // needsFileUpload has no post constraints
            this.needsFileUpload37a = needsFileUpload37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.needsFileUpload37aSet = true;
            }
        }
        return needsFileUpload37a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getForwards()
    * @return List<ModelElementFacade>
    */
    protected abstract List<ModelElementFacade> handleGetForwards();

    private transient List<ModelElementFacade> forwards38a;
    private transient boolean forwards38aSet = false;

    /**
     * Gets the forwards which can be targgeted from this view.
     * @return (List<ModelElementFacade>)handleGetForwards()
     */
    public final List<ModelElementFacade> getForwards()
    {
        List<ModelElementFacade> forwards38a = this.forwards38a;
        if (!this.forwards38aSet)
        {
            // forwards has no pre constraints
            forwards38a = handleGetForwards();
            // forwards has no post constraints
            this.forwards38a = forwards38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.forwards38aSet = true;
            }
        }
        return forwards38a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getBackingValueVariables()
    * @return List<GuiParameter>
    */
    protected abstract List<GuiParameter> handleGetBackingValueVariables();

    /**
     * All variables that have backing value.
     * @return (List<GuiParameter>)handleGetBackingValueVariables()
     */
    public final List<GuiParameter> getBackingValueVariables()
    {
        List<GuiParameter> backingValueVariables39a = null;
        // backingValueVariables has no pre constraints
        backingValueVariables39a = handleGetBackingValueVariables();
        // backingValueVariables has no post constraints
        return backingValueVariables39a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getFormActions()
    * @return List<GuiAction>
    */
    protected abstract List<GuiAction> handleGetFormActions();

    private transient List<GuiAction> formActions40a;
    private transient boolean formActions40aSet = false;

    /**
     * All actions that have forms associated with them.
     * @return (List<GuiAction>)handleGetFormActions()
     */
    public final List<GuiAction> getFormActions()
    {
        List<GuiAction> formActions40a = this.formActions40a;
        if (!this.formActions40aSet)
        {
            // formActions has no pre constraints
            formActions40a = handleGetFormActions();
            // formActions has no post constraints
            this.formActions40a = formActions40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formActions40aSet = true;
            }
        }
        return formActions40a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiView#getActionForwards()
    * @return List<GuiAction>
    */
    protected abstract List<GuiAction> handleGetActionForwards();

    private transient List<GuiAction> actionForwards41a;
    private transient boolean actionForwards41aSet = false;

    /**
     * All those forwards that are actions.
     * @return (List<GuiAction>)handleGetActionForwards()
     */
    public final List<GuiAction> getActionForwards()
    {
        List<GuiAction> actionForwards41a = this.actionForwards41a;
        if (!this.actionForwards41aSet)
        {
            // actionForwards has no pre constraints
            actionForwards41a = handleGetActionForwards();
            // actionForwards has no post constraints
            this.actionForwards41a = actionForwards41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionForwards41aSet = true;
            }
        }
        return actionForwards41a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Returns true if name of GuiView is unique in the domain of the parent worksheet useCase
     * @return boolean
     */
    protected abstract boolean handleIsNameUniqueInWorksheetDomain();

    /**
     * Returns true if name of GuiView is unique in the domain of the parent worksheet useCase
     * @return handleIsNameUniqueInWorksheetDomain()
     */
    public boolean isNameUniqueInWorksheetDomain()
    {
        // isNameUniqueInWorksheetDomain has no pre constraints
        boolean returnValue = handleIsNameUniqueInWorksheetDomain();
        // isNameUniqueInWorksheetDomain has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    private transient List<GuiAction> getIncomingActions1r;
    private transient boolean getIncomingActions1rSet = false;

    /**
     * The set of pages that are a possible target of the triggering of this action.
     * @return (List<GuiAction>)handleGetIncomingActions()
     */
    public final List<GuiAction> getIncomingActions()
    {
        List<GuiAction> getIncomingActions1r = this.getIncomingActions1r;
        if (!this.getIncomingActions1rSet)
        {
            // targetPages has no pre constraints
            List result = handleGetIncomingActions();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getIncomingActions1r = (List<GuiAction>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiViewLogic.LOGGER.warn("incorrect metafacade cast for GuiViewLogic.getIncomingActions List<GuiAction> " + result + ": " + shieldedResult);
            }
            // targetPages has no post constraints
            this.getIncomingActions1r = getIncomingActions1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getIncomingActions1rSet = true;
            }
        }
        return getIncomingActions1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetIncomingActions();

    private transient List<GuiForward> getNonActionForwards2r;
    private transient boolean getNonActionForwards2rSet = false;

    /**
     * A Gui view represents a page in the web application. A page possibly contains several
     * conainters and
     * controls (either buttons or hyperlinks) that call actions. A Gui view allow generation of
     * EJBs and
     * XML page descriptors
     * @return (List<GuiForward>)handleGetNonActionForwards()
     */
    public final List<GuiForward> getNonActionForwards()
    {
        List<GuiForward> getNonActionForwards2r = this.getNonActionForwards2r;
        if (!this.getNonActionForwards2rSet)
        {
            // guiView has no pre constraints
            List result = handleGetNonActionForwards();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getNonActionForwards2r = (List<GuiForward>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiViewLogic.LOGGER.warn("incorrect metafacade cast for GuiViewLogic.getNonActionForwards List<GuiForward> " + result + ": " + shieldedResult);
            }
            // guiView has no post constraints
            this.getNonActionForwards2r = getNonActionForwards2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getNonActionForwards2rSet = true;
            }
        }
        return getNonActionForwards2r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetNonActionForwards();

    private transient List<GuiParameter> getPageVariables3r;
    private transient boolean getPageVariables3rSet = false;

    /**
     * A Gui view represents a page in the web application. A page possibly contains several
     * conainters and
     * controls (either buttons or hyperlinks) that call actions. A Gui view allow generation of
     * EJBs and
     * XML page descriptors
     * @return (List<GuiParameter>)handleGetPageVariables()
     */
    public final List<GuiParameter> getPageVariables()
    {
        List<GuiParameter> getPageVariables3r = this.getPageVariables3r;
        if (!this.getPageVariables3rSet)
        {
            // guiView has no pre constraints
            List result = handleGetPageVariables();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getPageVariables3r = (List<GuiParameter>) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiViewLogic.LOGGER.warn("incorrect metafacade cast for GuiViewLogic.getPageVariables List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiView has no post constraints
            this.getPageVariables3r = getPageVariables3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getPageVariables3rSet = true;
            }
        }
        return getPageVariables3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetPageVariables();

    /**
     * @return true
     * @see FrontEndView
     */
    public boolean isFrontEndViewMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.FrontEndActionState
     */
    public boolean isFrontEndActionStateMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.ActionStateFacade
     */
    public boolean isActionStateFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see StateFacade
     */
    public boolean isStateFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.StateVertexFacade
     */
    public boolean isStateVertexFacadeMetaType()
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

    // ----------- delegates to FrontEndView ------------
    /**
     * The entry action for this action state (if any).
     * @see org.andromda.metafacades.uml.ActionStateFacade#getEntry()
     */
    public ActionFacade getEntry()
    {
        return this.getSuperFrontEndView().getEntry();
    }

    /**
     * The method name representing this action state.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getActionMethodName()
     */
    public String getActionMethodName()
    {
        return this.getSuperFrontEndView().getActionMethodName();
    }

    /**
     * The actions that pass through this action state.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getContainerActions()
     */
    public List<FrontEndAction> getContainerActions()
    {
        return this.getSuperFrontEndView().getContainerActions();
    }

    /**
     * All calls deferred to the controller by this action state.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getControllerCalls()
     */
    public List<OperationFacade> getControllerCalls()
    {
        return this.getSuperFrontEndView().getControllerCalls();
    }

    /**
     * All exceptions modelled on this action state.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getExceptions()
     */
    public List<FrontEndExceptionHandler> getExceptions()
    {
        return this.getSuperFrontEndView().getExceptions();
    }

    /**
     * The next transition, there can be only one transition going out of an action state, otherwise
     * decision points should be used (triggers are not supported at the server-side).
     * @see org.andromda.metafacades.uml.FrontEndActionState#getForward()
     */
    public FrontEndForward getForward()
    {
        return this.getSuperFrontEndView().getForward();
    }

    /**
     * A behavioral feature of a classifier that specifies the name, type, parameters, and
     * constraints for
     * invoking an associated behavior. May invoke both the execution of method behaviors as well as
     * other
     * behavioral responses.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getServiceCalls()
     */
    public List<OperationFacade> getServiceCalls()
    {
        return this.getSuperFrontEndView().getServiceCalls();
    }

    /**
     * True if this element is contained in a FrontEndUseCase.
     * @see org.andromda.metafacades.uml.FrontEndActionState#isContainedInFrontEndUseCase()
     */
    public boolean isContainedInFrontEndUseCase()
    {
        return this.getSuperFrontEndView().isContainedInFrontEndUseCase();
    }

    /**
     * Indicates whether or not this front end action state is server side. Pages, for example, are
     * also action states but they return control to the client.
     * @see org.andromda.metafacades.uml.FrontEndActionState#isServerSide()
     */
    public boolean isServerSide()
    {
        return this.getSuperFrontEndView().isServerSide();
    }

    /**
     * All actions that can be triggered on this view.
     * @see FrontEndView#getActions()
     */
    public List<FrontEndAction> getActions()
    {
        return this.getSuperFrontEndView().getActions();
    }

    /**
     * All parameters for each action going out of this view.
     * @see FrontEndView#getAllActionParameters()
     */
    public List<FrontEndParameter> getAllActionParameters()
    {
        return this.getSuperFrontEndView().getAllActionParameters();
    }

    /**
     * All fields from all forms on the given view.
     * @see FrontEndView#getAllFormFields()
     */
    public List<FrontEndParameter> getAllFormFields()
    {
        return this.getSuperFrontEndView().getAllFormFields();
    }

    /**
     * All tables belonging to the front end view.
     * @see FrontEndView#getTables()
     */
    public List<FrontEndParameter> getTables()
    {
        return this.getSuperFrontEndView().getTables();
    }

    /**
     * The use-case of which this view is a member.
     * @see FrontEndView#getUseCase()
     */
    public FrontEndUseCase getUseCase()
    {
        return this.getSuperFrontEndView().getUseCase();
    }

    /**
     * All those variables that will be present as variables in the target view. These are the
     * trigger parameters on the incoming transitions.
     * @see FrontEndView#getVariables()
     */
    public List<FrontEndParameter> getVariables()
    {
        return this.getSuperFrontEndView().getVariables();
    }

    /**
     * True if this element carries the FrontEndView stereotype.
     * @see FrontEndView#isFrontEndView()
     */
    public boolean isFrontEndView()
    {
        return this.getSuperFrontEndView().isFrontEndView();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperFrontEndView().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperFrontEndView().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperFrontEndView().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperFrontEndView().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperFrontEndView().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperFrontEndView().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperFrontEndView().getDocumentation(indent);
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
        return this.getSuperFrontEndView().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperFrontEndView().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperFrontEndView().getFullyQualifiedName();
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
        return this.getSuperFrontEndView().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperFrontEndView().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperFrontEndView().getId();
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
        return this.getSuperFrontEndView().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperFrontEndView().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperFrontEndView().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperFrontEndView().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperFrontEndView().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperFrontEndView().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperFrontEndView().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperFrontEndView().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperFrontEndView().getPackagePath();
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
        return this.getSuperFrontEndView().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperFrontEndView().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperFrontEndView().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperFrontEndView().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperFrontEndView().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperFrontEndView().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperFrontEndView().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperFrontEndView().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperFrontEndView().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperFrontEndView().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperFrontEndView().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndView().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperFrontEndView().hasKeyword(keywordName);
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
        return this.getSuperFrontEndView().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperFrontEndView().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperFrontEndView().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperFrontEndView().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperFrontEndView().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperFrontEndView().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperFrontEndView().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperFrontEndView().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperFrontEndView().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperFrontEndView().translateConstraints(kind, translation);
    }

    /**
     * Events to which is being deferred in this action state.
     * @see StateFacade#getDeferrableEvents()
     */
    public Collection<EventFacade> getDeferrableEvents()
    {
        return this.getSuperFrontEndView().getDeferrableEvents();
    }

    /**
     * Models a situation during which some (usually implicit) invariant condition holds. The states
     * of protocol state machines are exposed to the users of their context classifiers. A protocol
     * state represents an exposed stable situation of its context classifier: when an instance of
     * the classifier is not processing any operation, users of this instance can always know its
     * state configuration.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getContainer()
     */
    public StateFacade getContainer()
    {
        return this.getSuperFrontEndView().getContainer();
    }

    /**
     * A directed relationship between a source vertex and a target vertex. It may be part of a
     * compound transition, which takes the state machine from one state configuration to another,
     * representing the complete response of the state machine to an occurrence of an event of a
     * particular type.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getIncomings()
     */
    public Collection<TransitionFacade> getIncomings()
    {
        return this.getSuperFrontEndView().getIncomings();
    }

    /**
     * A directed relationship between a source vertex and a target vertex. It may be part of a
     * compound transition, which takes the state machine from one state configuration to another,
     * representing the complete response of the state machine to an occurrence of an event of a
     * particular type.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getOutgoings()
     */
    public Collection<TransitionFacade> getOutgoings()
    {
        return this.getSuperFrontEndView().getOutgoings();
    }

    /**
     * The partition (if any) to which this vertex belongs.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getPartition()
     */
    public PartitionFacade getPartition()
    {
        return this.getSuperFrontEndView().getPartition();
    }

    /**
     * State machines can be used to express the behavior of part of a system. Behavior is modeled
     * as a traversal of a graph of state nodes interconnected by one or more joined transition arcs
     * that are triggered by the dispatching of series of (event) occurrences. During this
     * traversal, the state machine executes a series of activities associated with various elements
     * of the state machine.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getStateMachine()
     */
    public StateMachineFacade getStateMachine()
    {
        return this.getSuperFrontEndView().getStateMachine();
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperFrontEndView().initialize();
    }

    /**
     * @return Object getSuperFrontEndView().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperFrontEndView().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperFrontEndView().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperFrontEndView().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiView::View must handle a toolbar or a maintoolbar</p>
     * <p><b>Error:</b> A view can contain a toolbar or a mainToolbar, but not both</p>
     * <p><b>OCL:</b> context GuiView
inv: (toolbar = true implies mainToolbar = false) and (mainToolbar = true implies toolbar = false)</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiView::Action state carrying a FrontEndView stereotype must have a unique name</p>
     * <p><b>Error:</b> Action state carrying a FrontEndView stereotype must have a unique name in the domain of its worksheet use case.</p>
     * <p><b>OCL:</b> context GuiView
inv: isNameUniqueInWorksheetDomain()</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperFrontEndView().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure(((Boolean.valueOf(String.valueOf(OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"toolbar"),true))).booleanValue()?OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"mainToolbar"),false):true))&&((Boolean.valueOf(String.valueOf(OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"mainToolbar"),true))).booleanValue()?OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"toolbar"),false):true)));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiView::View must handle a toolbar or a maintoolbar",
                        "A view can contain a toolbar or a mainToolbar, but not both"));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiView::View must handle a toolbar or a maintoolbar' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure(OCLIntrospector.invoke(contextElement,"isNameUniqueInWorksheetDomain()"));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiView::Action state carrying a FrontEndView stereotype must have a unique name",
                        "Action state carrying a FrontEndView stereotype must have a unique name in the domain of its worksheet use case."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiView::Action state carrying a FrontEndView stereotype must have a unique name' ON "
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