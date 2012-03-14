// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ActorFacade;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EntityAssociationEnd;
import org.andromda.metafacades.uml.EntityAttribute;
import org.andromda.metafacades.uml.EntityQueryOperation;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.GeneralizationFacade;
import org.andromda.metafacades.uml.ManageableEntity;
import org.andromda.metafacades.uml.ManageableEntityAssociationEnd;
import org.andromda.metafacades.uml.ManageableEntityAttribute;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for SeamManageableEntity
 *
 * @see SeamManageableEntity
 */
public abstract class SeamManageableEntityLogic
    extends MetafacadeBase
    implements SeamManageableEntity
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
    protected SeamManageableEntityLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superManageableEntity =
           (ManageableEntity)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.ManageableEntity",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to SeamManageableEntity if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.seam.metafacades.SeamManageableEntity";
        }
        return context;
    }

    private ManageableEntity superManageableEntity;
    private boolean superManageableEntityInitialized = false;

    /**
     * Gets the ManageableEntity parent instance.
     * @return this.superManageableEntity ManageableEntity
     */
    private ManageableEntity getSuperManageableEntity()
    {
        if (!this.superManageableEntityInitialized)
        {
            ((MetafacadeBase)this.superManageableEntity).setMetafacadeContext(this.getMetafacadeContext());
            this.superManageableEntityInitialized = true;
        }
        return this.superManageableEntity;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see org.andromda.core.metafacade.MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superManageableEntityInitialized)
            {
                ((MetafacadeBase)this.superManageableEntity).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see SeamManageableEntity
     */
    public boolean isSeamManageableEntityMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getPageName()
    * @return String
    */
    protected abstract String handleGetPageName();

    private String __pageName1a;
    private boolean __pageName1aSet = false;

    /**
     * 
     * @return (String)handleGetPageName()
     */
    public final String getPageName()
    {
        String pageName1a = this.__pageName1a;
        if (!this.__pageName1aSet)
        {
            // pageName has no pre constraints
            pageName1a = handleGetPageName();
            // pageName has no post constraints
            this.__pageName1a = pageName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__pageName1aSet = true;
            }
        }
        return pageName1a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getPageFullPath()
    * @return String
    */
    protected abstract String handleGetPageFullPath();

    private String __pageFullPath2a;
    private boolean __pageFullPath2aSet = false;

    /**
     * 
     * @return (String)handleGetPageFullPath()
     */
    public final String getPageFullPath()
    {
        String pageFullPath2a = this.__pageFullPath2a;
        if (!this.__pageFullPath2aSet)
        {
            // pageFullPath has no pre constraints
            pageFullPath2a = handleGetPageFullPath();
            // pageFullPath has no post constraints
            this.__pageFullPath2a = pageFullPath2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__pageFullPath2aSet = true;
            }
        }
        return pageFullPath2a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getPageTitleKey()
    * @return String
    */
    protected abstract String handleGetPageTitleKey();

    private String __pageTitleKey3a;
    private boolean __pageTitleKey3aSet = false;

    /**
     * 
     * @return (String)handleGetPageTitleKey()
     */
    public final String getPageTitleKey()
    {
        String pageTitleKey3a = this.__pageTitleKey3a;
        if (!this.__pageTitleKey3aSet)
        {
            // pageTitleKey has no pre constraints
            pageTitleKey3a = handleGetPageTitleKey();
            // pageTitleKey has no post constraints
            this.__pageTitleKey3a = pageTitleKey3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__pageTitleKey3aSet = true;
            }
        }
        return pageTitleKey3a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getPageTitleValue()
    * @return String
    */
    protected abstract String handleGetPageTitleValue();

    private String __pageTitleValue4a;
    private boolean __pageTitleValue4aSet = false;

    /**
     * 
     * @return (String)handleGetPageTitleValue()
     */
    public final String getPageTitleValue()
    {
        String pageTitleValue4a = this.__pageTitleValue4a;
        if (!this.__pageTitleValue4aSet)
        {
            // pageTitleValue has no pre constraints
            pageTitleValue4a = handleGetPageTitleValue();
            // pageTitleValue has no post constraints
            this.__pageTitleValue4a = pageTitleValue4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__pageTitleValue4aSet = true;
            }
        }
        return pageTitleValue4a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getListName()
    * @return String
    */
    protected abstract String handleGetListName();

    private String __listName5a;
    private boolean __listName5aSet = false;

    /**
     * 
     * @return (String)handleGetListName()
     */
    public final String getListName()
    {
        String listName5a = this.__listName5a;
        if (!this.__listName5aSet)
        {
            // listName has no pre constraints
            listName5a = handleGetListName();
            // listName has no post constraints
            this.__listName5a = listName5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__listName5aSet = true;
            }
        }
        return listName5a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getFormBeanType()
    * @return String
    */
    protected abstract String handleGetFormBeanType();

    private String __formBeanType6a;
    private boolean __formBeanType6aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanType()
     */
    public final String getFormBeanType()
    {
        String formBeanType6a = this.__formBeanType6a;
        if (!this.__formBeanType6aSet)
        {
            // formBeanType has no pre constraints
            formBeanType6a = handleGetFormBeanType();
            // formBeanType has no post constraints
            this.__formBeanType6a = formBeanType6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanType6aSet = true;
            }
        }
        return formBeanType6a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getFormBeanName()
    * @return String
    */
    protected abstract String handleGetFormBeanName();

    private String __formBeanName7a;
    private boolean __formBeanName7aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanName()
     */
    public final String getFormBeanName()
    {
        String formBeanName7a = this.__formBeanName7a;
        if (!this.__formBeanName7aSet)
        {
            // formBeanName has no pre constraints
            formBeanName7a = handleGetFormBeanName();
            // formBeanName has no post constraints
            this.__formBeanName7a = formBeanName7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanName7aSet = true;
            }
        }
        return formBeanName7a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getExceptionKey()
    * @return String
    */
    protected abstract String handleGetExceptionKey();

    private String __exceptionKey8a;
    private boolean __exceptionKey8aSet = false;

    /**
     * 
     * @return (String)handleGetExceptionKey()
     */
    public final String getExceptionKey()
    {
        String exceptionKey8a = this.__exceptionKey8a;
        if (!this.__exceptionKey8aSet)
        {
            // exceptionKey has no pre constraints
            exceptionKey8a = handleGetExceptionKey();
            // exceptionKey has no post constraints
            this.__exceptionKey8a = exceptionKey8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__exceptionKey8aSet = true;
            }
        }
        return exceptionKey8a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getActionType()
    * @return String
    */
    protected abstract String handleGetActionType();

    private String __actionType9a;
    private boolean __actionType9aSet = false;

    /**
     * 
     * @return (String)handleGetActionType()
     */
    public final String getActionType()
    {
        String actionType9a = this.__actionType9a;
        if (!this.__actionType9aSet)
        {
            // actionType has no pre constraints
            actionType9a = handleGetActionType();
            // actionType has no post constraints
            this.__actionType9a = actionType9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionType9aSet = true;
            }
        }
        return actionType9a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getActionFullPath()
    * @return String
    */
    protected abstract String handleGetActionFullPath();

    private String __actionFullPath10a;
    private boolean __actionFullPath10aSet = false;

    /**
     * 
     * @return (String)handleGetActionFullPath()
     */
    public final String getActionFullPath()
    {
        String actionFullPath10a = this.__actionFullPath10a;
        if (!this.__actionFullPath10aSet)
        {
            // actionFullPath has no pre constraints
            actionFullPath10a = handleGetActionFullPath();
            // actionFullPath has no post constraints
            this.__actionFullPath10a = actionFullPath10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionFullPath10aSet = true;
            }
        }
        return actionFullPath10a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getActionPath()
    * @return String
    */
    protected abstract String handleGetActionPath();

    private String __actionPath11a;
    private boolean __actionPath11aSet = false;

    /**
     * 
     * @return (String)handleGetActionPath()
     */
    public final String getActionPath()
    {
        String actionPath11a = this.__actionPath11a;
        if (!this.__actionPath11aSet)
        {
            // actionPath has no pre constraints
            actionPath11a = handleGetActionPath();
            // actionPath has no post constraints
            this.__actionPath11a = actionPath11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionPath11aSet = true;
            }
        }
        return actionPath11a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getActionClassName()
    * @return String
    */
    protected abstract String handleGetActionClassName();

    private String __actionClassName12a;
    private boolean __actionClassName12aSet = false;

    /**
     * 
     * @return (String)handleGetActionClassName()
     */
    public final String getActionClassName()
    {
        String actionClassName12a = this.__actionClassName12a;
        if (!this.__actionClassName12aSet)
        {
            // actionClassName has no pre constraints
            actionClassName12a = handleGetActionClassName();
            // actionClassName has no post constraints
            this.__actionClassName12a = actionClassName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionClassName12aSet = true;
            }
        }
        return actionClassName12a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getExceptionPath()
    * @return String
    */
    protected abstract String handleGetExceptionPath();

    private String __exceptionPath13a;
    private boolean __exceptionPath13aSet = false;

    /**
     * 
     * @return (String)handleGetExceptionPath()
     */
    public final String getExceptionPath()
    {
        String exceptionPath13a = this.__exceptionPath13a;
        if (!this.__exceptionPath13aSet)
        {
            // exceptionPath has no pre constraints
            exceptionPath13a = handleGetExceptionPath();
            // exceptionPath has no post constraints
            this.__exceptionPath13a = exceptionPath13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__exceptionPath13aSet = true;
            }
        }
        return exceptionPath13a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#isPreload()
    * @return boolean
    */
    protected abstract boolean handleIsPreload();

    private boolean __preload14a;
    private boolean __preload14aSet = false;

    /**
     * 
     * @return (boolean)handleIsPreload()
     */
    public final boolean isPreload()
    {
        boolean preload14a = this.__preload14a;
        if (!this.__preload14aSet)
        {
            // preload has no pre constraints
            preload14a = handleIsPreload();
            // preload has no post constraints
            this.__preload14a = preload14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__preload14aSet = true;
            }
        }
        return preload14a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getFormBeanClassName()
    * @return String
    */
    protected abstract String handleGetFormBeanClassName();

    private String __formBeanClassName15a;
    private boolean __formBeanClassName15aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanClassName()
     */
    public final String getFormBeanClassName()
    {
        String formBeanClassName15a = this.__formBeanClassName15a;
        if (!this.__formBeanClassName15aSet)
        {
            // formBeanClassName has no pre constraints
            formBeanClassName15a = handleGetFormBeanClassName();
            // formBeanClassName has no post constraints
            this.__formBeanClassName15a = formBeanClassName15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanClassName15aSet = true;
            }
        }
        return formBeanClassName15a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getFormBeanFullPath()
    * @return String
    */
    protected abstract String handleGetFormBeanFullPath();

    private String __formBeanFullPath16a;
    private boolean __formBeanFullPath16aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanFullPath()
     */
    public final String getFormBeanFullPath()
    {
        String formBeanFullPath16a = this.__formBeanFullPath16a;
        if (!this.__formBeanFullPath16aSet)
        {
            // formBeanFullPath has no pre constraints
            formBeanFullPath16a = handleGetFormBeanFullPath();
            // formBeanFullPath has no post constraints
            this.__formBeanFullPath16a = formBeanFullPath16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanFullPath16aSet = true;
            }
        }
        return formBeanFullPath16a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getListGetterName()
    * @return String
    */
    protected abstract String handleGetListGetterName();

    private String __listGetterName17a;
    private boolean __listGetterName17aSet = false;

    /**
     * 
     * @return (String)handleGetListGetterName()
     */
    public final String getListGetterName()
    {
        String listGetterName17a = this.__listGetterName17a;
        if (!this.__listGetterName17aSet)
        {
            // listGetterName has no pre constraints
            listGetterName17a = handleGetListGetterName();
            // listGetterName has no post constraints
            this.__listGetterName17a = listGetterName17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__listGetterName17aSet = true;
            }
        }
        return listGetterName17a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getListSetterName()
    * @return String
    */
    protected abstract String handleGetListSetterName();

    private String __listSetterName18a;
    private boolean __listSetterName18aSet = false;

    /**
     * 
     * @return (String)handleGetListSetterName()
     */
    public final String getListSetterName()
    {
        String listSetterName18a = this.__listSetterName18a;
        if (!this.__listSetterName18aSet)
        {
            // listSetterName has no pre constraints
            listSetterName18a = handleGetListSetterName();
            // listSetterName has no post constraints
            this.__listSetterName18a = listSetterName18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__listSetterName18aSet = true;
            }
        }
        return listSetterName18a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private String __messageKey19a;
    private boolean __messageKey19aSet = false;

    /**
     * 
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String messageKey19a = this.__messageKey19a;
        if (!this.__messageKey19aSet)
        {
            // messageKey has no pre constraints
            messageKey19a = handleGetMessageKey();
            // messageKey has no post constraints
            this.__messageKey19a = messageKey19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__messageKey19aSet = true;
            }
        }
        return messageKey19a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getMessageValue()
    * @return String
    */
    protected abstract String handleGetMessageValue();

    private String __messageValue20a;
    private boolean __messageValue20aSet = false;

    /**
     * 
     * @return (String)handleGetMessageValue()
     */
    public final String getMessageValue()
    {
        String messageValue20a = this.__messageValue20a;
        if (!this.__messageValue20aSet)
        {
            // messageValue has no pre constraints
            messageValue20a = handleGetMessageValue();
            // messageValue has no post constraints
            this.__messageValue20a = messageValue20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__messageValue20aSet = true;
            }
        }
        return messageValue20a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getActionParameter()
    * @return String
    */
    protected abstract String handleGetActionParameter();

    private String __actionParameter21a;
    private boolean __actionParameter21aSet = false;

    /**
     * 
     * @return (String)handleGetActionParameter()
     */
    public final String getActionParameter()
    {
        String actionParameter21a = this.__actionParameter21a;
        if (!this.__actionParameter21aSet)
        {
            // actionParameter has no pre constraints
            actionParameter21a = handleGetActionParameter();
            // actionParameter has no post constraints
            this.__actionParameter21a = actionParameter21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionParameter21aSet = true;
            }
        }
        return actionParameter21a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String __onlineHelpKey22a;
    private boolean __onlineHelpKey22aSet = false;

    /**
     * The key to lookup the online help documentation.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String onlineHelpKey22a = this.__onlineHelpKey22a;
        if (!this.__onlineHelpKey22aSet)
        {
            // onlineHelpKey has no pre constraints
            onlineHelpKey22a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.__onlineHelpKey22a = onlineHelpKey22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpKey22aSet = true;
            }
        }
        return onlineHelpKey22a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String __onlineHelpValue23a;
    private boolean __onlineHelpValue23aSet = false;

    /**
     * The online help documentation. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String onlineHelpValue23a = this.__onlineHelpValue23a;
        if (!this.__onlineHelpValue23aSet)
        {
            // onlineHelpValue has no pre constraints
            onlineHelpValue23a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.__onlineHelpValue23a = onlineHelpValue23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpValue23aSet = true;
            }
        }
        return onlineHelpValue23a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getOnlineHelpActionPath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpActionPath();

    private String __onlineHelpActionPath24a;
    private boolean __onlineHelpActionPath24aSet = false;

    /**
     * The full path to this entity's online help action. The returned String does not have a suffix
     * such as '.do'.
     * @return (String)handleGetOnlineHelpActionPath()
     */
    public final String getOnlineHelpActionPath()
    {
        String onlineHelpActionPath24a = this.__onlineHelpActionPath24a;
        if (!this.__onlineHelpActionPath24aSet)
        {
            // onlineHelpActionPath has no pre constraints
            onlineHelpActionPath24a = handleGetOnlineHelpActionPath();
            // onlineHelpActionPath has no post constraints
            this.__onlineHelpActionPath24a = onlineHelpActionPath24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpActionPath24aSet = true;
            }
        }
        return onlineHelpActionPath24a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getOnlineHelpPagePath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpPagePath();

    private String __onlineHelpPagePath25a;
    private boolean __onlineHelpPagePath25aSet = false;

    /**
     * The full path to this entitiy's online help page. The returned String does not have a suffix
     * such as '.jsp'.
     * @return (String)handleGetOnlineHelpPagePath()
     */
    public final String getOnlineHelpPagePath()
    {
        String onlineHelpPagePath25a = this.__onlineHelpPagePath25a;
        if (!this.__onlineHelpPagePath25aSet)
        {
            // onlineHelpPagePath has no pre constraints
            onlineHelpPagePath25a = handleGetOnlineHelpPagePath();
            // onlineHelpPagePath has no post constraints
            this.__onlineHelpPagePath25a = onlineHelpPagePath25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpPagePath25aSet = true;
            }
        }
        return onlineHelpPagePath25a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#isTableExportable()
    * @return boolean
    */
    protected abstract boolean handleIsTableExportable();

    private boolean __tableExportable26a;
    private boolean __tableExportable26aSet = false;

    /**
     * True if it is possible to export the table data to XML, CSV, PDF or Excel format.
     * @return (boolean)handleIsTableExportable()
     */
    public final boolean isTableExportable()
    {
        boolean tableExportable26a = this.__tableExportable26a;
        if (!this.__tableExportable26aSet)
        {
            // tableExportable has no pre constraints
            tableExportable26a = handleIsTableExportable();
            // tableExportable has no post constraints
            this.__tableExportable26a = tableExportable26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableExportable26aSet = true;
            }
        }
        return tableExportable26a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getTableExportTypes()
    * @return String
    */
    protected abstract String handleGetTableExportTypes();

    private String __tableExportTypes27a;
    private boolean __tableExportTypes27aSet = false;

    /**
     * Tthe available types of export in a single String instance.
     * @return (String)handleGetTableExportTypes()
     */
    public final String getTableExportTypes()
    {
        String tableExportTypes27a = this.__tableExportTypes27a;
        if (!this.__tableExportTypes27aSet)
        {
            // tableExportTypes has no pre constraints
            tableExportTypes27a = handleGetTableExportTypes();
            // tableExportTypes has no post constraints
            this.__tableExportTypes27a = tableExportTypes27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableExportTypes27aSet = true;
            }
        }
        return tableExportTypes27a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#getTableMaxRows()
    * @return int
    */
    protected abstract int handleGetTableMaxRows();

    private int __tableMaxRows28a;
    private boolean __tableMaxRows28aSet = false;

    /**
     * The maximum number of rows to be displayed in the table at the same time. This is also known
     * as the page size. A value of zero or less will display all data in the same table (therefore
     * also on the same page).
     * @return (int)handleGetTableMaxRows()
     */
    public final int getTableMaxRows()
    {
        int tableMaxRows28a = this.__tableMaxRows28a;
        if (!this.__tableMaxRows28aSet)
        {
            // tableMaxRows has no pre constraints
            tableMaxRows28a = handleGetTableMaxRows();
            // tableMaxRows has no post constraints
            this.__tableMaxRows28a = tableMaxRows28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableMaxRows28aSet = true;
            }
        }
        return tableMaxRows28a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#isTableSortable()
    * @return boolean
    */
    protected abstract boolean handleIsTableSortable();

    private boolean __tableSortable29a;
    private boolean __tableSortable29aSet = false;

    /**
     * True if it is possible to sort the columns of the table.
     * @return (boolean)handleIsTableSortable()
     */
    public final boolean isTableSortable()
    {
        boolean tableSortable29a = this.__tableSortable29a;
        if (!this.__tableSortable29aSet)
        {
            // tableSortable has no pre constraints
            tableSortable29a = handleIsTableSortable();
            // tableSortable has no post constraints
            this.__tableSortable29a = tableSortable29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableSortable29aSet = true;
            }
        }
        return tableSortable29a;
    }

   /**
    * @see org.andromda.cartridges.seam.metafacades.SeamManageableEntity#isMultipartFormData()
    * @return boolean
    */
    protected abstract boolean handleIsMultipartFormData();

    private boolean __multipartFormData30a;
    private boolean __multipartFormData30aSet = false;

    /**
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return (boolean)handleIsMultipartFormData()
     */
    public final boolean isMultipartFormData()
    {
        boolean multipartFormData30a = this.__multipartFormData30a;
        if (!this.__multipartFormData30aSet)
        {
            // multipartFormData has no pre constraints
            multipartFormData30a = handleIsMultipartFormData();
            // multipartFormData has no post constraints
            this.__multipartFormData30a = multipartFormData30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__multipartFormData30aSet = true;
            }
        }
        return multipartFormData30a;
    }

    /**
     * @return true
     * @see ManageableEntity
     */
    public boolean isManageableEntityMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.Entity
     */
    public boolean isEntityMetaType()
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

    // ----------- delegates to ManageableEntity ------------
    /**
     * Return the attribute which name matches the parameter
     * @see ClassifierFacade#findAttribute(String name)
     */
    public AttributeFacade findAttribute(String name)
    {
        return this.getSuperManageableEntity().findAttribute(name);
    }

    /**
     * Those abstraction dependencies for which this classifier is the client.
     * @see ClassifierFacade#getAbstractions()
     */
    public Collection<ClassifierFacade> getAbstractions()
    {
        return this.getSuperManageableEntity().getAbstractions();
    }

    /**
     * Lists all classes associated to this one and any ancestor classes (through generalization).
     * There will be no duplicates. The order of the elements is predictable.
     * @see ClassifierFacade#getAllAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAllAssociatedClasses()
    {
        return this.getSuperManageableEntity().getAllAssociatedClasses();
    }

    /**
     * A collection containing all 'properties' of the classifier and its ancestors.  Properties are
     * any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllProperties()
     */
    public Collection getAllProperties()
    {
        return this.getSuperManageableEntity().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection getAllRequiredConstructorParameters()
    {
        return this.getSuperManageableEntity().getAllRequiredConstructorParameters();
    }

    /**
     * Gets the array type for this classifier.  If this classifier already represents an array, it
     * just returns itself.
     * @see ClassifierFacade#getArray()
     */
    public ClassifierFacade getArray()
    {
        return this.getSuperManageableEntity().getArray();
    }

    /**
     * The name of the classifier as an array.
     * @see ClassifierFacade#getArrayName()
     */
    public String getArrayName()
    {
        return this.getSuperManageableEntity().getArrayName();
    }

    /**
     * Lists the classes associated to this one, there is no repitition of classes. The order of the
     * elements is predictable.
     * @see ClassifierFacade#getAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAssociatedClasses()
    {
        return this.getSuperManageableEntity().getAssociatedClasses();
    }

    /**
     * Gets the association ends belonging to a classifier.
     * @see ClassifierFacade#getAssociationEnds()
     */
    public List<AssociationEndFacade> getAssociationEnds()
    {
        return this.getSuperManageableEntity().getAssociationEnds();
    }

    /**
     * Gets the attributes that belong to the classifier.
     * @see ClassifierFacade#getAttributes()
     */
    public List<AttributeFacade> getAttributes()
    {
        return this.getSuperManageableEntity().getAttributes();
    }

    /**
     * Gets all attributes for the classifier and if 'follow' is true goes up the inheritance
     * hierarchy and gets the attributes from the super classes as well.
     * @see ClassifierFacade#getAttributes(boolean follow)
     */
    public List getAttributes(boolean follow)
    {
        return this.getSuperManageableEntity().getAttributes(follow);
    }

    /**
     * The fully qualified name of the classifier as an array.
     * @see ClassifierFacade#getFullyQualifiedArrayName()
     */
    public String getFullyQualifiedArrayName()
    {
        return this.getSuperManageableEntity().getFullyQualifiedArrayName();
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
        return this.getSuperManageableEntity().getImplementationOperations();
    }

    /**
     * A comma separated list of the fully qualified names of all implemented interfaces.
     * @see ClassifierFacade#getImplementedInterfaceList()
     */
    public String getImplementedInterfaceList()
    {
        return this.getSuperManageableEntity().getImplementedInterfaceList();
    }

    /**
     * Those attributes that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceAttributes()
     */
    public Collection<AttributeFacade> getInstanceAttributes()
    {
        return this.getSuperManageableEntity().getInstanceAttributes();
    }

    /**
     * Those operations that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceOperations()
     */
    public List<OperationFacade> getInstanceOperations()
    {
        return this.getSuperManageableEntity().getInstanceOperations();
    }

    /**
     * Those interfaces that are abstractions of this classifier, this basically means this
     * classifier realizes them.
     * @see ClassifierFacade#getInterfaceAbstractions()
     */
    public Collection<ClassifierFacade> getInterfaceAbstractions()
    {
        return this.getSuperManageableEntity().getInterfaceAbstractions();
    }

    /**
     * A String representing a new Constructor declaration for this classifier type to be used in a
     * Java environment.
     * @see ClassifierFacade#getJavaNewString()
     */
    public String getJavaNewString()
    {
        return this.getSuperManageableEntity().getJavaNewString();
    }

    /**
     * A String representing the null-value for this classifier type to be used in a Java
     * environment.
     * @see ClassifierFacade#getJavaNullString()
     */
    public String getJavaNullString()
    {
        return this.getSuperManageableEntity().getJavaNullString();
    }

    /**
     * The other ends of this classifier's association ends which are navigable.
     * @see ClassifierFacade#getNavigableConnectingEnds()
     */
    public Collection<ClassifierFacade> getNavigableConnectingEnds()
    {
        return this.getSuperManageableEntity().getNavigableConnectingEnds();
    }

    /**
     * Get the other ends of this classifier's association ends which are navigable and if 'follow'
     * is true goes up the inheritance hierarchy and gets the super association ends as well.
     * @see ClassifierFacade#getNavigableConnectingEnds(boolean follow)
     */
    public List getNavigableConnectingEnds(boolean follow)
    {
        return this.getSuperManageableEntity().getNavigableConnectingEnds(follow);
    }

    /**
     * Assuming that the classifier is an array, this will return the non array type of the
     * classifier from
     * the model.  If the classifier is NOT an array, it will just return itself.
     * @see ClassifierFacade#getNonArray()
     */
    public ClassifierFacade getNonArray()
    {
        return this.getSuperManageableEntity().getNonArray();
    }

    /**
     * The attributes from this classifier in the form of an operation call (this example would be
     * in Java): '(String attributeOne, String attributeTwo).  If there were no attributes on the
     * classifier, the result would be an empty '()'.
     * @see ClassifierFacade#getOperationCallFromAttributes()
     */
    public String getOperationCallFromAttributes()
    {
        return this.getSuperManageableEntity().getOperationCallFromAttributes();
    }

    /**
     * The operations owned by this classifier.
     * @see ClassifierFacade#getOperations()
     */
    public List<OperationFacade> getOperations()
    {
        return this.getSuperManageableEntity().getOperations();
    }

    /**
     * A collection containing all 'properties' of the classifier.  Properties are any attributes
     * and navigable connecting association ends.
     * @see ClassifierFacade#getProperties()
     */
    public List getProperties()
    {
        return this.getSuperManageableEntity().getProperties();
    }

    /**
     * Gets all properties (attributes and navigable association ends) for the classifier and if
     * 'follow' is true goes up the inheritance hierarchy and gets the properties from the super
     * classes as well.
     * @see ClassifierFacade#getProperties(boolean follow)
     */
    public List getProperties(boolean follow)
    {
        return this.getSuperManageableEntity().getProperties(follow);
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier. 
     * Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getRequiredConstructorParameters()
     */
    public Collection getRequiredConstructorParameters()
    {
        return this.getSuperManageableEntity().getRequiredConstructorParameters();
    }

    /**
     * Returns the serial version UID of the underlying model element.
     * @see ClassifierFacade#getSerialVersionUID()
     */
    public long getSerialVersionUID()
    {
        return this.getSuperManageableEntity().getSerialVersionUID();
    }

    /**
     * Those attributes that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticAttributes()
     */
    public Collection<AttributeFacade> getStaticAttributes()
    {
        return this.getSuperManageableEntity().getStaticAttributes();
    }

    /**
     * Those operations that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticOperations()
     */
    public List<OperationFacade> getStaticOperations()
    {
        return this.getSuperManageableEntity().getStaticOperations();
    }

    /**
     * This class' superclass, returns the generalization if it is a ClassifierFacade, null
     * otherwise.
     * @see ClassifierFacade#getSuperClass()
     */
    public ClassifierFacade getSuperClass()
    {
        return this.getSuperManageableEntity().getSuperClass();
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
        return this.getSuperManageableEntity().getWrapperName();
    }

    /**
     * Indicates if this classifier is 'abstract'.
     * @see ClassifierFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperManageableEntity().isAbstract();
    }

    /**
     * True if this classifier represents an array type. False otherwise.
     * @see ClassifierFacade#isArrayType()
     */
    public boolean isArrayType()
    {
        return this.getSuperManageableEntity().isArrayType();
    }

    /**
     * 
     * @see ClassifierFacade#isAssociationClass()
     */
    public boolean isAssociationClass()
    {
        return this.getSuperManageableEntity().isAssociationClass();
    }

    /**
     * Returns true if this type represents a Blob type.
     * @see ClassifierFacade#isBlobType()
     */
    public boolean isBlobType()
    {
        return this.getSuperManageableEntity().isBlobType();
    }

    /**
     * Indicates if this type represents a boolean type or not.
     * @see ClassifierFacade#isBooleanType()
     */
    public boolean isBooleanType()
    {
        return this.getSuperManageableEntity().isBooleanType();
    }

    /**
     * Indicates if this type represents a char, Character, or java.lang.Character type or not.
     * @see ClassifierFacade#isCharacterType()
     */
    public boolean isCharacterType()
    {
        return this.getSuperManageableEntity().isCharacterType();
    }

    /**
     * Returns true if this type represents a Clob type.
     * @see ClassifierFacade#isClobType()
     */
    public boolean isClobType()
    {
        return this.getSuperManageableEntity().isClobType();
    }

    /**
     * True if this classifier represents a collection type. False otherwise.
     * @see ClassifierFacade#isCollectionType()
     */
    public boolean isCollectionType()
    {
        return this.getSuperManageableEntity().isCollectionType();
    }

    /**
     * True/false depending on whether or not this classifier represents a datatype. A data type is
     * a type whose instances are identified only by their value. A data type may contain attributes
     * to support the modeling of structured data types.
     * @see ClassifierFacade#isDataType()
     */
    public boolean isDataType()
    {
        return this.getSuperManageableEntity().isDataType();
    }

    /**
     * True when this classifier is a date type.
     * @see ClassifierFacade#isDateType()
     */
    public boolean isDateType()
    {
        return this.getSuperManageableEntity().isDateType();
    }

    /**
     * Indicates if this type represents a Double type or not.
     * @see ClassifierFacade#isDoubleType()
     */
    public boolean isDoubleType()
    {
        return this.getSuperManageableEntity().isDoubleType();
    }

    /**
     * Indicates whether or not this classifier represents an "EmbeddedValue'.
     * @see ClassifierFacade#isEmbeddedValue()
     */
    public boolean isEmbeddedValue()
    {
        return this.getSuperManageableEntity().isEmbeddedValue();
    }

    /**
     * True if this classifier is in fact marked as an enumeration.
     * @see ClassifierFacade#isEnumeration()
     */
    public boolean isEnumeration()
    {
        return this.getSuperManageableEntity().isEnumeration();
    }

    /**
     * Returns true if this type represents a 'file' type.
     * @see ClassifierFacade#isFileType()
     */
    public boolean isFileType()
    {
        return this.getSuperManageableEntity().isFileType();
    }

    /**
     * Indicates if this type represents a Float type or not.
     * @see ClassifierFacade#isFloatType()
     */
    public boolean isFloatType()
    {
        return this.getSuperManageableEntity().isFloatType();
    }

    /**
     * Indicates if this type represents an int or Integer or java.lang.Integer type or not.
     * @see ClassifierFacade#isIntegerType()
     */
    public boolean isIntegerType()
    {
        return this.getSuperManageableEntity().isIntegerType();
    }

    /**
     * True/false depending on whether or not this Classifier represents an interface.
     * @see ClassifierFacade#isInterface()
     */
    public boolean isInterface()
    {
        return this.getSuperManageableEntity().isInterface();
    }

    /**
     * True if this classifier cannot be extended and represent a leaf in the inheritance tree.
     * @see ClassifierFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperManageableEntity().isLeaf();
    }

    /**
     * True if this classifier represents a list type. False otherwise.
     * @see ClassifierFacade#isListType()
     */
    public boolean isListType()
    {
        return this.getSuperManageableEntity().isListType();
    }

    /**
     * Indicates if this type represents a Long type or not.
     * @see ClassifierFacade#isLongType()
     */
    public boolean isLongType()
    {
        return this.getSuperManageableEntity().isLongType();
    }

    /**
     * Indicates whether or not this classifier represents a Map type.
     * @see ClassifierFacade#isMapType()
     */
    public boolean isMapType()
    {
        return this.getSuperManageableEntity().isMapType();
    }

    /**
     * Indicates whether or not this classifier represents a primitive type.
     * @see ClassifierFacade#isPrimitive()
     */
    public boolean isPrimitive()
    {
        return this.getSuperManageableEntity().isPrimitive();
    }

    /**
     * True if this classifier represents a set type. False otherwise.
     * @see ClassifierFacade#isSetType()
     */
    public boolean isSetType()
    {
        return this.getSuperManageableEntity().isSetType();
    }

    /**
     * Indicates whether or not this classifier represents a string type.
     * @see ClassifierFacade#isStringType()
     */
    public boolean isStringType()
    {
        return this.getSuperManageableEntity().isStringType();
    }

    /**
     * Indicates whether or not this classifier represents a time type.
     * @see ClassifierFacade#isTimeType()
     */
    public boolean isTimeType()
    {
        return this.getSuperManageableEntity().isTimeType();
    }

    /**
     * Returns true if this type is a wrapped primitive type.
     * @see ClassifierFacade#isWrappedPrimitive()
     */
    public boolean isWrappedPrimitive()
    {
        return this.getSuperManageableEntity().isWrappedPrimitive();
    }

    /**
     * Returns a collection of all entities this entity and its ancestors have a relation to.
     * @see org.andromda.metafacades.uml.Entity#getAllEntityReferences()
     */
    public Collection<DependencyFacade> getAllEntityReferences()
    {
        return this.getSuperManageableEntity().getAllEntityReferences();
    }

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see org.andromda.metafacades.uml.Entity#getAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers  and  if 'withDerived' is set to true, will include derived
     * attributes.
     * @see org.andromda.metafacades.uml.Entity#getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperManageableEntity().getAttributeNameList(follow, withIdentifiers, withDerived);
    }

    /**
     * Gets a comma separated list of attribute types.  If 'follow' is true, will travel up the
     * inheritance hierarchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see org.andromda.metafacades.uml.Entity#getAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false.
     * @see org.andromda.metafacades.uml.Entity#getAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection getAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false and exclude
     * derived attributes if 'withDerived' is set to false.
     * @see org.andromda.metafacades.uml.Entity#getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public Collection getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperManageableEntity().getAttributes(follow, withIdentifiers, withDerived);
    }

    /**
     * All business operations of the entity, these include any operations that aren't queries.
     * @see org.andromda.metafacades.uml.Entity#getBusinessOperations()
     */
    public Collection<OperationFacade> getBusinessOperations()
    {
        return this.getSuperManageableEntity().getBusinessOperations();
    }

    /**
     * Gets any children association ends (i.e. entity association ends that are participants in an
     * association with this entity and this entity has composite aggregation defined for those
     * associations).
     * @see org.andromda.metafacades.uml.Entity#getChildEnds()
     */
    public Collection<EntityAssociationEnd> getChildEnds()
    {
        return this.getSuperManageableEntity().getChildEnds();
    }

    /**
     * The embedded values belonging to this entity.
     * @see org.andromda.metafacades.uml.Entity#getEmbeddedValues()
     */
    public Collection getEmbeddedValues()
    {
        return this.getSuperManageableEntity().getEmbeddedValues();
    }

    /**
     * All entities referenced by this entity.
     * @see org.andromda.metafacades.uml.Entity#getEntityReferences()
     */
    public Collection<DependencyFacade> getEntityReferences()
    {
        return this.getSuperManageableEntity().getEntityReferences();
    }

    /**
     * The full name of the type of the identifier. If composite identifier add the PK sufix to the
     * class name. If not, retorns the fully qualified name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getFullyQualifiedIdentifierTypeName()
     */
    public String getFullyQualifiedIdentifierTypeName()
    {
        return this.getSuperManageableEntity().getFullyQualifiedIdentifierTypeName();
    }

    /**
     * Gets all the associationEnds of this entity marked with the identifiers stereotype.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierAssociationEnds()
     */
    public Collection getIdentifierAssociationEnds()
    {
        return this.getSuperManageableEntity().getIdentifierAssociationEnds();
    }

    /**
     * The getter name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierGetterName()
     */
    public String getIdentifierGetterName()
    {
        return this.getSuperManageableEntity().getIdentifierGetterName();
    }

    /**
     * The name of the identifier. If composite identifier add the Pk sufix. If not composite
     * returns the atribute name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierName()
     */
    public String getIdentifierName()
    {
        return this.getSuperManageableEntity().getIdentifierName();
    }

    /**
     * The setter name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierSetterName()
     */
    public String getIdentifierSetterName()
    {
        return this.getSuperManageableEntity().getIdentifierSetterName();
    }

    /**
     * The name of the type of the identifier. If composite identifier add the PK sufix to the class
     * name. If not, retorns the name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierTypeName()
     */
    public String getIdentifierTypeName()
    {
        return this.getSuperManageableEntity().getIdentifierTypeName();
    }

    /**
     * All the attributes of the entity which make up its identifier (primary key).  Will search any
     * super classes as well.  If no identifiers exist, a default identifier will be created if the
     * allowDefaultIdentifiers property is set to true.
     * @see org.andromda.metafacades.uml.Entity#getIdentifiers()
     */
    public Collection<EntityAttribute> getIdentifiers()
    {
        return this.getSuperManageableEntity().getIdentifiers();
    }

    /**
     * Gets all identifiers for an entity. If 'follow' is true, and if no identifiers can be found
     * on the entity, a search up the inheritance chain will be performed, and the identifiers from
     * the first super class having them will be used.   If no identifiers exist, a default
     * identifier will be created if the allowDefaultIdentifiers property is set to true.
     * @see org.andromda.metafacades.uml.Entity#getIdentifiers(boolean follow)
     */
    public Collection getIdentifiers(boolean follow)
    {
        return this.getSuperManageableEntity().getIdentifiers(follow);
    }

    /**
     * The maximum length a SQL name may be.
     * @see org.andromda.metafacades.uml.Entity#getMaxSqlNameLength()
     */
    public short getMaxSqlNameLength()
    {
        return this.getSuperManageableEntity().getMaxSqlNameLength();
    }

    /**
     * Gets the attributes as a list within an operation call, optionally including the type names
     * and the identifier attributes.
     * @see org.andromda.metafacades.uml.Entity#getOperationCallFromAttributes(boolean withIdentifiers)
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getOperationCallFromAttributes(withIdentifiers);
    }

    /**
     * Gets the attributes as a list within an operation call.  If 'withTypeNames' is true, it will
     * include the type names, if 'withIdentifiers' is true it will include the identifiers.  If
     * 'follow' is true it will follow the inheritance hierarchy and get the attributes of the super
     * class as well.
     * @see org.andromda.metafacades.uml.Entity#getOperationCallFromAttributes(boolean withIdentifiers, boolean follow)
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers, boolean follow)
    {
        return this.getSuperManageableEntity().getOperationCallFromAttributes(withIdentifiers, follow);
    }

    /**
     * Returns the parent association end of this entity if its a child entity.  The parent is the
     * entity that is the participant the association that has composite aggregation defined.  Will
     * return null if the entity has no parent.
     * @see org.andromda.metafacades.uml.Entity#getParentEnd()
     */
    public EntityAssociationEnd getParentEnd()
    {
        return this.getSuperManageableEntity().getParentEnd();
    }

    /**
     * Gets all properties of this entity, this includes the attributes and navigable association
     * ends of the entity.  The 'follow' flag indcates whether or not the inheritance hierarchy
     * should be followed when getting all the properties.  The 'withIdentifiers' flag indicates
     * whether or not identifiers should be included in the collection of properties.
     * @see org.andromda.metafacades.uml.Entity#getProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection getProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getProperties(follow, withIdentifiers);
    }

    /**
     * Returns all the operations that can perform queries on the entity.
     * @see org.andromda.metafacades.uml.Entity#getQueryOperations()
     */
    public Collection<EntityQueryOperation> getQueryOperations()
    {
        return this.getSuperManageableEntity().getQueryOperations();
    }

    /**
     * Gets all query operations for an entity. If 'follow' is true, and if no query operations can
     * be found on the entity, a search up the inheritance chain will be performed, and the
     * identifiers from the first super class having them will be used.   If no identifiers exist, a
     * default identifier will be created if the allowDefaultIdentifiers property is set to true.
     * @see org.andromda.metafacades.uml.Entity#getQueryOperations(boolean follow)
     */
    public Collection getQueryOperations(boolean follow)
    {
        return this.getSuperManageableEntity().getQueryOperations(follow);
    }

    /**
     * Gets a comma separated list of required attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see org.andromda.metafacades.uml.Entity#getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of attribute types with are required.  If 'follow' is true, will
     * travel up the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see org.andromda.metafacades.uml.Entity#getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Returns all attributes that are specified as 'required' in the model.  If 'follow' is true,
     * then required attributes in super classes will also be returned, if false, just the ones
     * directly on the entity will be returned.  If 'withIdentifiers' is true, the identifiers will
     * be include, if false, no identifiers will be included.
     * @see org.andromda.metafacades.uml.Entity#getRequiredAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection getRequiredAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all required properties for this entity.  These consist of any required attributes as
     * well as navigable associations that are marked as 'required'.  If 'follow' is true, then the
     * inheritance hierchy will be followed and all required properties from super classes will be
     * included as well.
     * If 'withIdentifiers' is true, the identifiers will be include, if false, no identifiers will
     * be included.
     * @see org.andromda.metafacades.uml.Entity#getRequiredProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection getRequiredProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredProperties(follow, withIdentifiers);
    }

    /**
     * Creates a comma separated list of the required property names.
     * @see org.andromda.metafacades.uml.Entity#getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredPropertyNameList(follow, withIdentifiers);
    }

    /**
     * A comma separated list of the required property types.
     * @see org.andromda.metafacades.uml.Entity#getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredPropertyTypeList(follow, withIdentifiers);
    }

    /**
     * The name of the schema that contains the database table
     * @see org.andromda.metafacades.uml.Entity#getSchema()
     */
    public String getSchema()
    {
        return this.getSuperManageableEntity().getSchema();
    }

    /**
     * The name of the database table to which this entity is persisted.
     * @see org.andromda.metafacades.uml.Entity#getTableName()
     */
    public String getTableName()
    {
        return this.getSuperManageableEntity().getTableName();
    }

    /**
     * Returns true/false depending on whether or not this entity represetns a child in an
     * association (this occurs when this entity is on the opposite end of an assocation end defined
     * as composite).
     * @see org.andromda.metafacades.uml.Entity#isChild()
     */
    public boolean isChild()
    {
        return this.getSuperManageableEntity().isChild();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.Entity#isCompositeIdentifier()
     */
    public boolean isCompositeIdentifier()
    {
        return this.getSuperManageableEntity().isCompositeIdentifier();
    }

    /**
     * True if the entity has its identifiers dynamically added, false otherwise.
     * @see org.andromda.metafacades.uml.Entity#isDynamicIdentifiersPresent()
     */
    public boolean isDynamicIdentifiersPresent()
    {
        return this.getSuperManageableEntity().isDynamicIdentifiersPresent();
    }

    /**
     * True if the entity has any identifiers defined, false otherwise.
     * @see org.andromda.metafacades.uml.Entity#isIdentifiersPresent()
     */
    public boolean isIdentifiersPresent()
    {
        return this.getSuperManageableEntity().isIdentifiersPresent();
    }

    /**
     * Indiciates if this entity is using an assigned identifier or not.
     * @see org.andromda.metafacades.uml.Entity#isUsingAssignedIdentifier()
     */
    public boolean isUsingAssignedIdentifier()
    {
        return this.getSuperManageableEntity().isUsingAssignedIdentifier();
    }

    /**
     * Indicates whether or not this entity is using a foreign identifier as its identifiers.  That
     * is: the foreignIdentifier flag was set on an incoming association end and the entity is
     * therefore using the related foreign parent entity's identifier.
     * @see org.andromda.metafacades.uml.Entity#isUsingForeignIdentifier()
     */
    public boolean isUsingForeignIdentifier()
    {
        return this.getSuperManageableEntity().isUsingForeignIdentifier();
    }

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @see GeneralizableElementFacade#findTaggedValue(String tagName, boolean follow)
     */
    public Object findTaggedValue(String tagName, boolean follow)
    {
        return this.getSuperManageableEntity().findTaggedValue(tagName, follow);
    }

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @see GeneralizableElementFacade#getAllGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations()
    {
        return this.getSuperManageableEntity().getAllGeneralizations();
    }

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @see GeneralizableElementFacade#getAllSpecializations()
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations()
    {
        return this.getSuperManageableEntity().getAllSpecializations();
    }

    /**
     * Gets the direct generalization for this generalizable element.
     * @see GeneralizableElementFacade#getGeneralization()
     */
    public GeneralizableElementFacade getGeneralization()
    {
        return this.getSuperManageableEntity().getGeneralization();
    }

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @see GeneralizableElementFacade#getGeneralizationLinks()
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks()
    {
        return this.getSuperManageableEntity().getGeneralizationLinks();
    }

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @see GeneralizableElementFacade#getGeneralizationList()
     */
    public String getGeneralizationList()
    {
        return this.getSuperManageableEntity().getGeneralizationList();
    }

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @see GeneralizableElementFacade#getGeneralizationRoot()
     */
    public GeneralizableElementFacade getGeneralizationRoot()
    {
        return this.getSuperManageableEntity().getGeneralizationRoot();
    }

    /**
     * 
     * @see GeneralizableElementFacade#getGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getGeneralizations()
    {
        return this.getSuperManageableEntity().getGeneralizations();
    }

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @see GeneralizableElementFacade#getSpecializations()
     */
    public Collection<GeneralizableElementFacade> getSpecializations()
    {
        return this.getSuperManageableEntity().getSpecializations();
    }

    /**
     * All entities to which can be browsed from this entity. Currently this property will simple
     * hold all entities, so the value is the same for any arbitrary entity. Hiding entities can be
     * done in the presentation tier, for example depending on runtime security information.
     * @see ManageableEntity#getAllManageables()
     */
    public List<ManageableEntity> getAllManageables()
    {
        return this.getSuperManageableEntity().getAllManageables();
    }

    /**
     * 
     * @see ManageableEntity#getDisplayAttribute()
     */
    public ManageableEntityAttribute getDisplayAttribute()
    {
        return this.getSuperManageableEntity().getDisplayAttribute();
    }

    /**
     * 
     * @see ManageableEntity#getFullyQualifiedManageableServiceName()
     */
    public String getFullyQualifiedManageableServiceName()
    {
        return this.getSuperManageableEntity().getFullyQualifiedManageableServiceName();
    }

    /**
     * 
     * @see ManageableEntity#getManageableAssociationEnds()
     */
    public List<ManageableEntityAssociationEnd> getManageableAssociationEnds()
    {
        return this.getSuperManageableEntity().getManageableAssociationEnds();
    }

    /**
     * Lists the attributes that can be managed for this entity. This feature is particularly
     * important when resolving inherited attributes and ids.
     * @see ManageableEntity#getManageableAttributes()
     */
    public List<ManageableEntityAttribute> getManageableAttributes()
    {
        return this.getSuperManageableEntity().getManageableAttributes();
    }

    /**
     * The identifier used when managing this entity.
     * @see ManageableEntity#getManageableIdentifier()
     */
    public ManageableEntityAttribute getManageableIdentifier()
    {
        return this.getSuperManageableEntity().getManageableIdentifier();
    }

    /**
     * 
     * @see ManageableEntity#getManageableMembers()
     */
    public List getManageableMembers()
    {
        return this.getSuperManageableEntity().getManageableMembers();
    }

    /**
     * 
     * @see ManageableEntity#getManageablePackageName()
     */
    public String getManageablePackageName()
    {
        return this.getSuperManageableEntity().getManageablePackageName();
    }

    /**
     * 
     * @see ManageableEntity#getManageablePackagePath()
     */
    public String getManageablePackagePath()
    {
        return this.getSuperManageableEntity().getManageablePackagePath();
    }

    /**
     * 
     * @see ManageableEntity#getManageableServiceAccessorCall()
     */
    public String getManageableServiceAccessorCall()
    {
        return this.getSuperManageableEntity().getManageableServiceAccessorCall();
    }

    /**
     * 
     * @see ManageableEntity#getManageableServiceFullPath()
     */
    public String getManageableServiceFullPath()
    {
        return this.getSuperManageableEntity().getManageableServiceFullPath();
    }

    /**
     * 
     * @see ManageableEntity#getManageableServiceName()
     */
    public String getManageableServiceName()
    {
        return this.getSuperManageableEntity().getManageableServiceName();
    }

    /**
     * The maximum number of rows to load from the database.
     * @see ManageableEntity#getMaximumListSize()
     */
    public int getMaximumListSize()
    {
        return this.getSuperManageableEntity().getMaximumListSize();
    }

    /**
     * The maximum number of rows to load from the database.
     * @see ManageableEntity#getPageSize()
     */
    public int getPageSize()
    {
        return this.getSuperManageableEntity().getPageSize();
    }

    /**
     * 
     * @see ManageableEntity#getReferencingManageables()
     */
    public List<ManageableEntity> getReferencingManageables()
    {
        return this.getSuperManageableEntity().getReferencingManageables();
    }

    /**
     * 
     * @see ManageableEntity#getUsers()
     */
    public List<ActorFacade> getUsers()
    {
        return this.getSuperManageableEntity().getUsers();
    }

    /**
     * 
     * @see ManageableEntity#isCreate()
     */
    public boolean isCreate()
    {
        return this.getSuperManageableEntity().isCreate();
    }

    /**
     * 
     * @see ManageableEntity#isDelete()
     */
    public boolean isDelete()
    {
        return this.getSuperManageableEntity().isDelete();
    }

    /**
     * 
     * @see ManageableEntity#isManageable()
     */
    public boolean isManageable()
    {
        return this.getSuperManageableEntity().isManageable();
    }

    /**
     * 
     * @see ManageableEntity#isRead()
     */
    public boolean isRead()
    {
        return this.getSuperManageableEntity().isRead();
    }

    /**
     * The maximum number of rows to load from the database.
     * @see ManageableEntity#isResolveable()
     */
    public boolean isResolveable()
    {
        return this.getSuperManageableEntity().isResolveable();
    }

    /**
     * 
     * @see ManageableEntity#isUpdate()
     */
    public boolean isUpdate()
    {
        return this.getSuperManageableEntity().isUpdate();
    }

    /**
     * 
     * @see ManageableEntity#listManageableMembers(boolean withTypes)
     */
    public String listManageableMembers(boolean withTypes)
    {
        return this.getSuperManageableEntity().listManageableMembers(withTypes);
    }

    /**
     * Returns a string with the attributes and wrapper types.
     * @see ManageableEntity#listManageableMembersWithWrapperTypes()
     */
    public String listManageableMembersWithWrapperTypes()
    {
        return this.getSuperManageableEntity().listManageableMembersWithWrapperTypes();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperManageableEntity().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperManageableEntity().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperManageableEntity().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperManageableEntity().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperManageableEntity().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperManageableEntity().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperManageableEntity().getDocumentation(indent);
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
        return this.getSuperManageableEntity().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperManageableEntity().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperManageableEntity().getFullyQualifiedName();
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
        return this.getSuperManageableEntity().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperManageableEntity().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperManageableEntity().getId();
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
        return this.getSuperManageableEntity().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperManageableEntity().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperManageableEntity().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperManageableEntity().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperManageableEntity().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperManageableEntity().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperManageableEntity().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperManageableEntity().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperManageableEntity().getPackagePath();
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
        return this.getSuperManageableEntity().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperManageableEntity().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperManageableEntity().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperManageableEntity().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperManageableEntity().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperManageableEntity().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperManageableEntity().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperManageableEntity().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperManageableEntity().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperManageableEntity().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperManageableEntity().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperManageableEntity().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperManageableEntity().hasKeyword(keywordName);
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
        return this.getSuperManageableEntity().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperManageableEntity().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperManageableEntity().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperManageableEntity().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperManageableEntity().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperManageableEntity().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperManageableEntity().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperManageableEntity().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperManageableEntity().translateConstraints(kind, translation);
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperManageableEntity().initialize();
    }

    /**
     * @return Object getSuperManageableEntity().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperManageableEntity().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperManageableEntity().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperManageableEntity().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperManageableEntity().validateInvariants(validationMessages);
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