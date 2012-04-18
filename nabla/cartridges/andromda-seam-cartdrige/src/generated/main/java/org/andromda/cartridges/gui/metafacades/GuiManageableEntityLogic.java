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
import org.andromda.metafacades.uml.ActorFacade;
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Entity;
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
import org.apache.log4j.Logger;

/**
 * 
 * MetafacadeLogic for GuiManageableEntity
 *
 * @see GuiManageableEntity
 */
public abstract class GuiManageableEntityLogic
    extends MetafacadeBase
    implements GuiManageableEntity
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
    protected GuiManageableEntityLogic(Object metaObjectIn, String context)
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
     * The logger instance.
     */
    private static final Logger logger = Logger.getLogger(GuiManageableEntityLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiManageableEntity if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiManageableEntity";
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
     * @see MetafacadeBase#resetMetafacadeContext(String context)
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
     * @see GuiManageableEntity
     */
    public boolean isGuiManageableEntityMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see GuiManageableEntity#getPageName()
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
    * @see GuiManageableEntity#getPageFullPath()
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
    * @see GuiManageableEntity#getPageTitleKey()
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
    * @see GuiManageableEntity#getPageTitleValue()
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
    * @see GuiManageableEntity#getListName()
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
    * @see GuiManageableEntity#getExceptionKey()
    * @return String
    */
    protected abstract String handleGetExceptionKey();

    private String __exceptionKey6a;
    private boolean __exceptionKey6aSet = false;

    /**
     * 
     * @return (String)handleGetExceptionKey()
     */
    public final String getExceptionKey()
    {
        String exceptionKey6a = this.__exceptionKey6a;
        if (!this.__exceptionKey6aSet)
        {
            // exceptionKey has no pre constraints
            exceptionKey6a = handleGetExceptionKey();
            // exceptionKey has no post constraints
            this.__exceptionKey6a = exceptionKey6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__exceptionKey6aSet = true;
            }
        }
        return exceptionKey6a;
    }

   /**
    * @see GuiManageableEntity#getActionType()
    * @return String
    */
    protected abstract String handleGetActionType();

    private String __actionType7a;
    private boolean __actionType7aSet = false;

    /**
     * 
     * @return (String)handleGetActionType()
     */
    public final String getActionType()
    {
        String actionType7a = this.__actionType7a;
        if (!this.__actionType7aSet)
        {
            // actionType has no pre constraints
            actionType7a = handleGetActionType();
            // actionType has no post constraints
            this.__actionType7a = actionType7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionType7aSet = true;
            }
        }
        return actionType7a;
    }

   /**
    * @see GuiManageableEntity#getActionFullPath()
    * @return String
    */
    protected abstract String handleGetActionFullPath();

    private String __actionFullPath8a;
    private boolean __actionFullPath8aSet = false;

    /**
     * 
     * @return (String)handleGetActionFullPath()
     */
    public final String getActionFullPath()
    {
        String actionFullPath8a = this.__actionFullPath8a;
        if (!this.__actionFullPath8aSet)
        {
            // actionFullPath has no pre constraints
            actionFullPath8a = handleGetActionFullPath();
            // actionFullPath has no post constraints
            this.__actionFullPath8a = actionFullPath8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionFullPath8aSet = true;
            }
        }
        return actionFullPath8a;
    }

   /**
    * @see GuiManageableEntity#getActionPath()
    * @return String
    */
    protected abstract String handleGetActionPath();

    private String __actionPath9a;
    private boolean __actionPath9aSet = false;

    /**
     * 
     * @return (String)handleGetActionPath()
     */
    public final String getActionPath()
    {
        String actionPath9a = this.__actionPath9a;
        if (!this.__actionPath9aSet)
        {
            // actionPath has no pre constraints
            actionPath9a = handleGetActionPath();
            // actionPath has no post constraints
            this.__actionPath9a = actionPath9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionPath9aSet = true;
            }
        }
        return actionPath9a;
    }

   /**
    * @see GuiManageableEntity#getActionClassName()
    * @return String
    */
    protected abstract String handleGetActionClassName();

    private String __actionClassName10a;
    private boolean __actionClassName10aSet = false;

    /**
     * 
     * @return (String)handleGetActionClassName()
     */
    public final String getActionClassName()
    {
        String actionClassName10a = this.__actionClassName10a;
        if (!this.__actionClassName10aSet)
        {
            // actionClassName has no pre constraints
            actionClassName10a = handleGetActionClassName();
            // actionClassName has no post constraints
            this.__actionClassName10a = actionClassName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionClassName10aSet = true;
            }
        }
        return actionClassName10a;
    }

   /**
    * @see GuiManageableEntity#getExceptionPath()
    * @return String
    */
    protected abstract String handleGetExceptionPath();

    private String __exceptionPath11a;
    private boolean __exceptionPath11aSet = false;

    /**
     * 
     * @return (String)handleGetExceptionPath()
     */
    public final String getExceptionPath()
    {
        String exceptionPath11a = this.__exceptionPath11a;
        if (!this.__exceptionPath11aSet)
        {
            // exceptionPath has no pre constraints
            exceptionPath11a = handleGetExceptionPath();
            // exceptionPath has no post constraints
            this.__exceptionPath11a = exceptionPath11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__exceptionPath11aSet = true;
            }
        }
        return exceptionPath11a;
    }

   /**
    * @see GuiManageableEntity#getListGetterName()
    * @return String
    */
    protected abstract String handleGetListGetterName();

    private String __listGetterName12a;
    private boolean __listGetterName12aSet = false;

    /**
     * 
     * @return (String)handleGetListGetterName()
     */
    public final String getListGetterName()
    {
        String listGetterName12a = this.__listGetterName12a;
        if (!this.__listGetterName12aSet)
        {
            // listGetterName has no pre constraints
            listGetterName12a = handleGetListGetterName();
            // listGetterName has no post constraints
            this.__listGetterName12a = listGetterName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__listGetterName12aSet = true;
            }
        }
        return listGetterName12a;
    }

   /**
    * @see GuiManageableEntity#getListSetterName()
    * @return String
    */
    protected abstract String handleGetListSetterName();

    private String __listSetterName13a;
    private boolean __listSetterName13aSet = false;

    /**
     * 
     * @return (String)handleGetListSetterName()
     */
    public final String getListSetterName()
    {
        String listSetterName13a = this.__listSetterName13a;
        if (!this.__listSetterName13aSet)
        {
            // listSetterName has no pre constraints
            listSetterName13a = handleGetListSetterName();
            // listSetterName has no post constraints
            this.__listSetterName13a = listSetterName13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__listSetterName13aSet = true;
            }
        }
        return listSetterName13a;
    }

   /**
    * @see GuiManageableEntity#getActionParameter()
    * @return String
    */
    protected abstract String handleGetActionParameter();

    private String __actionParameter14a;
    private boolean __actionParameter14aSet = false;

    /**
     * 
     * @return (String)handleGetActionParameter()
     */
    public final String getActionParameter()
    {
        String actionParameter14a = this.__actionParameter14a;
        if (!this.__actionParameter14aSet)
        {
            // actionParameter has no pre constraints
            actionParameter14a = handleGetActionParameter();
            // actionParameter has no post constraints
            this.__actionParameter14a = actionParameter14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionParameter14aSet = true;
            }
        }
        return actionParameter14a;
    }

   /**
    * @see GuiManageableEntity#isTableExportable()
    * @return boolean
    */
    protected abstract boolean handleIsTableExportable();

    private boolean __tableExportable15a;
    private boolean __tableExportable15aSet = false;

    /**
     * True if it is possible to export the table data to XML, CSV, PDF or Excel format.
     * @return (boolean)handleIsTableExportable()
     */
    public final boolean isTableExportable()
    {
        boolean tableExportable15a = this.__tableExportable15a;
        if (!this.__tableExportable15aSet)
        {
            // tableExportable has no pre constraints
            tableExportable15a = handleIsTableExportable();
            // tableExportable has no post constraints
            this.__tableExportable15a = tableExportable15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableExportable15aSet = true;
            }
        }
        return tableExportable15a;
    }

   /**
    * @see GuiManageableEntity#getTableExportTypes()
    * @return String
    */
    protected abstract String handleGetTableExportTypes();

    private String __tableExportTypes16a;
    private boolean __tableExportTypes16aSet = false;

    /**
     * Tthe available types of export in a single String instance.
     * @return (String)handleGetTableExportTypes()
     */
    public final String getTableExportTypes()
    {
        String tableExportTypes16a = this.__tableExportTypes16a;
        if (!this.__tableExportTypes16aSet)
        {
            // tableExportTypes has no pre constraints
            tableExportTypes16a = handleGetTableExportTypes();
            // tableExportTypes has no post constraints
            this.__tableExportTypes16a = tableExportTypes16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableExportTypes16aSet = true;
            }
        }
        return tableExportTypes16a;
    }

   /**
    * @see GuiManageableEntity#getTableMaxRows()
    * @return int
    */
    protected abstract int handleGetTableMaxRows();

    private int __tableMaxRows17a;
    private boolean __tableMaxRows17aSet = false;

    /**
     * The maximum number of rows to be displayed in the table at the same time. This is also known
     * as the page size. A value of zero or less will display all data in the same table (therefore
     * also on the same page).
     * @return (int)handleGetTableMaxRows()
     */
    public final int getTableMaxRows()
    {
        int tableMaxRows17a = this.__tableMaxRows17a;
        if (!this.__tableMaxRows17aSet)
        {
            // tableMaxRows has no pre constraints
            tableMaxRows17a = handleGetTableMaxRows();
            // tableMaxRows has no post constraints
            this.__tableMaxRows17a = tableMaxRows17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableMaxRows17aSet = true;
            }
        }
        return tableMaxRows17a;
    }

   /**
    * @see GuiManageableEntity#isTableSortable()
    * @return boolean
    */
    protected abstract boolean handleIsTableSortable();

    private boolean __tableSortable18a;
    private boolean __tableSortable18aSet = false;

    /**
     * True if it is possible to sort the columns of the table.
     * @return (boolean)handleIsTableSortable()
     */
    public final boolean isTableSortable()
    {
        boolean tableSortable18a = this.__tableSortable18a;
        if (!this.__tableSortable18aSet)
        {
            // tableSortable has no pre constraints
            tableSortable18a = handleIsTableSortable();
            // tableSortable has no post constraints
            this.__tableSortable18a = tableSortable18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__tableSortable18aSet = true;
            }
        }
        return tableSortable18a;
    }

   /**
    * @see GuiManageableEntity#isMultipartFormData()
    * @return boolean
    */
    protected abstract boolean handleIsMultipartFormData();

    private boolean __multipartFormData19a;
    private boolean __multipartFormData19aSet = false;

    /**
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return (boolean)handleIsMultipartFormData()
     */
    public final boolean isMultipartFormData()
    {
        boolean multipartFormData19a = this.__multipartFormData19a;
        if (!this.__multipartFormData19aSet)
        {
            // multipartFormData has no pre constraints
            multipartFormData19a = handleIsMultipartFormData();
            // multipartFormData has no post constraints
            this.__multipartFormData19a = multipartFormData19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__multipartFormData19aSet = true;
            }
        }
        return multipartFormData19a;
    }

   /**
    * @see GuiManageableEntity#getPreconditions()
    * @return Collection
    */
    protected abstract Collection handleGetPreconditions();

    private Collection __preconditions20a;
    private boolean __preconditions20aSet = false;

    /**
     * 
     * @return (Collection)handleGetPreconditions()
     */
    public final Collection getPreconditions()
    {
        Collection preconditions20a = this.__preconditions20a;
        if (!this.__preconditions20aSet)
        {
            // preconditions has no pre constraints
            preconditions20a = handleGetPreconditions();
            // preconditions has no post constraints
            this.__preconditions20a = preconditions20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__preconditions20aSet = true;
            }
        }
        return preconditions20a;
    }

   /**
    * @see GuiManageableEntity#getCreatePreconditions()
    * @return Collection
    */
    protected abstract Collection handleGetCreatePreconditions();

    private Collection __createPreconditions21a;
    private boolean __createPreconditions21aSet = false;

    /**
     * 
     * @return (Collection)handleGetCreatePreconditions()
     */
    public final Collection getCreatePreconditions()
    {
        Collection createPreconditions21a = this.__createPreconditions21a;
        if (!this.__createPreconditions21aSet)
        {
            // createPreconditions has no pre constraints
            createPreconditions21a = handleGetCreatePreconditions();
            // createPreconditions has no post constraints
            this.__createPreconditions21a = createPreconditions21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__createPreconditions21aSet = true;
            }
        }
        return createPreconditions21a;
    }

   /**
    * @see GuiManageableEntity#getUpdatePreconditions()
    * @return Collection
    */
    protected abstract Collection handleGetUpdatePreconditions();

    private Collection __updatePreconditions22a;
    private boolean __updatePreconditions22aSet = false;

    /**
     * 
     * @return (Collection)handleGetUpdatePreconditions()
     */
    public final Collection getUpdatePreconditions()
    {
        Collection updatePreconditions22a = this.__updatePreconditions22a;
        if (!this.__updatePreconditions22aSet)
        {
            // updatePreconditions has no pre constraints
            updatePreconditions22a = handleGetUpdatePreconditions();
            // updatePreconditions has no post constraints
            this.__updatePreconditions22a = updatePreconditions22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__updatePreconditions22aSet = true;
            }
        }
        return updatePreconditions22a;
    }

   /**
    * @see GuiManageableEntity#getDeletePreconditions()
    * @return Collection
    */
    protected abstract Collection handleGetDeletePreconditions();

    private Collection __deletePreconditions23a;
    private boolean __deletePreconditions23aSet = false;

    /**
     * 
     * @return (Collection)handleGetDeletePreconditions()
     */
    public final Collection getDeletePreconditions()
    {
        Collection deletePreconditions23a = this.__deletePreconditions23a;
        if (!this.__deletePreconditions23aSet)
        {
            // deletePreconditions has no pre constraints
            deletePreconditions23a = handleGetDeletePreconditions();
            // deletePreconditions has no post constraints
            this.__deletePreconditions23a = deletePreconditions23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__deletePreconditions23aSet = true;
            }
        }
        return deletePreconditions23a;
    }

   /**
    * @see GuiManageableEntity#isRegroupMandatoryFields()
    * @return boolean
    */
    protected abstract boolean handleIsRegroupMandatoryFields();

    private boolean __regroupMandatoryFields24a;
    private boolean __regroupMandatoryFields24aSet = false;

    /**
     * 
     * @return (boolean)handleIsRegroupMandatoryFields()
     */
    public final boolean isRegroupMandatoryFields()
    {
        boolean regroupMandatoryFields24a = this.__regroupMandatoryFields24a;
        if (!this.__regroupMandatoryFields24aSet)
        {
            // regroupMandatoryFields has no pre constraints
            regroupMandatoryFields24a = handleIsRegroupMandatoryFields();
            // regroupMandatoryFields has no post constraints
            this.__regroupMandatoryFields24a = regroupMandatoryFields24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__regroupMandatoryFields24aSet = true;
            }
        }
        return regroupMandatoryFields24a;
    }

   /**
    * @see GuiManageableEntity#getDisplayName()
    * @return String
    */
    protected abstract String handleGetDisplayName();

    private String __displayName25a;
    private boolean __displayName25aSet = false;

    /**
     * 
     * @return (String)handleGetDisplayName()
     */
    public final String getDisplayName()
    {
        String displayName25a = this.__displayName25a;
        if (!this.__displayName25aSet)
        {
            // displayName has no pre constraints
            displayName25a = handleGetDisplayName();
            // displayName has no post constraints
            this.__displayName25a = displayName25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__displayName25aSet = true;
            }
        }
        return displayName25a;
    }

   /**
    * @see GuiManageableEntity#isVersionable()
    * @return boolean
    */
    protected abstract boolean handleIsVersionable();

    private boolean __versionable26a;
    private boolean __versionable26aSet = false;

    /**
     * True if the manageable entity carries Versionable stereotype (Versionable object)
     * @return (boolean)handleIsVersionable()
     */
    public final boolean isVersionable()
    {
        boolean versionable26a = this.__versionable26a;
        if (!this.__versionable26aSet)
        {
            // versionable has no pre constraints
            versionable26a = handleIsVersionable();
            // versionable has no post constraints
            this.__versionable26a = versionable26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__versionable26aSet = true;
            }
        }
        return versionable26a;
    }

   /**
    * @see GuiManageableEntity#isVersionableRefExists()
    * @return boolean
    */
    protected abstract boolean handleIsVersionableRefExists();

    private boolean __versionableRefExists27a;
    private boolean __versionableRefExists27aSet = false;

    /**
     * 
     * @return (boolean)handleIsVersionableRefExists()
     */
    public final boolean isVersionableRefExists()
    {
        boolean versionableRefExists27a = this.__versionableRefExists27a;
        if (!this.__versionableRefExists27aSet)
        {
            // versionableRefExists has no pre constraints
            versionableRefExists27a = handleIsVersionableRefExists();
            // versionableRefExists has no post constraints
            this.__versionableRefExists27a = versionableRefExists27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__versionableRefExists27aSet = true;
            }
        }
        return versionableRefExists27a;
    }

   /**
    * @see GuiManageableEntity#getRulesSearchData()
    * @return Collection
    */
    protected abstract Collection handleGetRulesSearchData();

    private Collection __rulesSearchData28a;
    private boolean __rulesSearchData28aSet = false;

    /**
     * To retrieve all associations which end is a RulesSearchData stereotyped class.
     * @return (Collection)handleGetRulesSearchData()
     */
    public final Collection getRulesSearchData()
    {
        Collection rulesSearchData28a = this.__rulesSearchData28a;
        if (!this.__rulesSearchData28aSet)
        {
            // rulesSearchData has no pre constraints
            rulesSearchData28a = handleGetRulesSearchData();
            // rulesSearchData has no post constraints
            this.__rulesSearchData28a = rulesSearchData28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__rulesSearchData28aSet = true;
            }
        }
        return rulesSearchData28a;
    }

   /**
    * @see GuiManageableEntity#getRulesCriteriasSearchValueObject()
    * @return ClassifierFacade
    */
    protected abstract ClassifierFacade handleGetRulesCriteriasSearchValueObject();

    private ClassifierFacade __rulesCriteriasSearchValueObject29a;
    private boolean __rulesCriteriasSearchValueObject29aSet = false;

    /**
     * To retrieve corresponding criterias search data represented by a typical value object
     * @return (ClassifierFacade)handleGetRulesCriteriasSearchValueObject()
     */
    public final ClassifierFacade getRulesCriteriasSearchValueObject()
    {
        ClassifierFacade rulesCriteriasSearchValueObject29a = this.__rulesCriteriasSearchValueObject29a;
        if (!this.__rulesCriteriasSearchValueObject29aSet)
        {
            // rulesCriteriasSearchValueObject has no pre constraints
            rulesCriteriasSearchValueObject29a = handleGetRulesCriteriasSearchValueObject();
            // rulesCriteriasSearchValueObject has no post constraints
            this.__rulesCriteriasSearchValueObject29a = rulesCriteriasSearchValueObject29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__rulesCriteriasSearchValueObject29aSet = true;
            }
        }
        return rulesCriteriasSearchValueObject29a;
    }

   /**
    * @see GuiManageableEntity#isInsertable()
    * @return boolean
    */
    protected abstract boolean handleIsInsertable();

    private boolean __insertable30a;
    private boolean __insertable30aSet = false;

    /**
     * 
     * @return (boolean)handleIsInsertable()
     */
    public final boolean isInsertable()
    {
        boolean insertable30a = this.__insertable30a;
        if (!this.__insertable30aSet)
        {
            // insertable has no pre constraints
            insertable30a = handleIsInsertable();
            // insertable has no post constraints
            this.__insertable30a = insertable30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__insertable30aSet = true;
            }
        }
        return insertable30a;
    }

   /**
    * @see GuiManageableEntity#isUpdatable()
    * @return boolean
    */
    protected abstract boolean handleIsUpdatable();

    private boolean __updatable31a;
    private boolean __updatable31aSet = false;

    /**
     * 
     * @return (boolean)handleIsUpdatable()
     */
    public final boolean isUpdatable()
    {
        boolean updatable31a = this.__updatable31a;
        if (!this.__updatable31aSet)
        {
            // updatable has no pre constraints
            updatable31a = handleIsUpdatable();
            // updatable has no post constraints
            this.__updatable31a = updatable31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__updatable31aSet = true;
            }
        }
        return updatable31a;
    }

   /**
    * @see GuiManageableEntity#isRemovable()
    * @return boolean
    */
    protected abstract boolean handleIsRemovable();

    private boolean __removable32a;
    private boolean __removable32aSet = false;

    /**
     * 
     * @return (boolean)handleIsRemovable()
     */
    public final boolean isRemovable()
    {
        boolean removable32a = this.__removable32a;
        if (!this.__removable32aSet)
        {
            // removable has no pre constraints
            removable32a = handleIsRemovable();
            // removable has no post constraints
            this.__removable32a = removable32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__removable32aSet = true;
            }
        }
        return removable32a;
    }

   /**
    * @see GuiManageableEntity#isFiltered()
    * @return boolean
    */
    protected abstract boolean handleIsFiltered();

    private boolean __filtered33a;
    private boolean __filtered33aSet = false;

    /**
     * True if the Manageable Entity has at least one filter element (attribute or association).
     * Simple filter feature, for Rules
     * @return (boolean)handleIsFiltered()
     */
    public final boolean isFiltered()
    {
        boolean filtered33a = this.__filtered33a;
        if (!this.__filtered33aSet)
        {
            // filtered has no pre constraints
            filtered33a = handleIsFiltered();
            // filtered has no post constraints
            this.__filtered33a = filtered33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__filtered33aSet = true;
            }
        }
        return filtered33a;
    }

   /**
    * @see GuiManageableEntity#isPopEdition()
    * @return boolean
    */
    protected abstract boolean handleIsPopEdition();

    private boolean __popEdition34a;
    private boolean __popEdition34aSet = false;

    /**
     * Defines whether or not the manageable entity edition form will be displayed in a pop-up
     * @return (boolean)handleIsPopEdition()
     */
    public final boolean isPopEdition()
    {
        boolean popEdition34a = this.__popEdition34a;
        if (!this.__popEdition34aSet)
        {
            // popEdition has no pre constraints
            popEdition34a = handleIsPopEdition();
            // popEdition has no post constraints
            this.__popEdition34a = popEdition34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__popEdition34aSet = true;
            }
        }
        return popEdition34a;
    }

   /**
    * @see GuiManageableEntity#isExportable()
    * @return boolean
    */
    protected abstract boolean handleIsExportable();

    private boolean __exportable35a;
    private boolean __exportable35aSet = false;

    /**
     * 
     * @return (boolean)handleIsExportable()
     */
    public final boolean isExportable()
    {
        boolean exportable35a = this.__exportable35a;
        if (!this.__exportable35aSet)
        {
            // exportable has no pre constraints
            exportable35a = handleIsExportable();
            // exportable has no post constraints
            this.__exportable35a = exportable35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__exportable35aSet = true;
            }
        }
        return exportable35a;
    }

   /**
    * @see GuiManageableEntity#isClonable()
    * @return boolean
    */
    protected abstract boolean handleIsClonable();

    private boolean __clonable36a;
    private boolean __clonable36aSet = false;

    /**
     * 
     * @return (boolean)handleIsClonable()
     */
    public final boolean isClonable()
    {
        boolean clonable36a = this.__clonable36a;
        if (!this.__clonable36aSet)
        {
            // clonable has no pre constraints
            clonable36a = handleIsClonable();
            // clonable has no post constraints
            this.__clonable36a = clonable36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__clonable36aSet = true;
            }
        }
        return clonable36a;
    }

   /**
    * @see GuiManageableEntity#isSortable()
    * @return boolean
    */
    protected abstract boolean handleIsSortable();

    private boolean __sortable37a;
    private boolean __sortable37aSet = false;

    /**
     * 
     * @return (boolean)handleIsSortable()
     */
    public final boolean isSortable()
    {
        boolean sortable37a = this.__sortable37a;
        if (!this.__sortable37aSet)
        {
            // sortable has no pre constraints
            sortable37a = handleIsSortable();
            // sortable has no post constraints
            this.__sortable37a = sortable37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__sortable37aSet = true;
            }
        }
        return sortable37a;
    }

   /**
    * @see GuiManageableEntity#isHasHelp()
    * @return boolean
    */
    protected abstract boolean handleIsHasHelp();

    private boolean __hasHelp38a;
    private boolean __hasHelp38aSet = false;

    /**
     * 
     * @return (boolean)handleIsHasHelp()
     */
    public final boolean isHasHelp()
    {
        boolean hasHelp38a = this.__hasHelp38a;
        if (!this.__hasHelp38aSet)
        {
            // hasHelp has no pre constraints
            hasHelp38a = handleIsHasHelp();
            // hasHelp has no post constraints
            this.__hasHelp38a = hasHelp38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hasHelp38aSet = true;
            }
        }
        return hasHelp38a;
    }

   /**
    * @see GuiManageableEntity#isFilterable()
    * @return boolean
    */
    protected abstract boolean handleIsFilterable();

    private boolean __filterable39a;
    private boolean __filterable39aSet = false;

    /**
     * Defines whether or not the manageable entity is filterable (advanced search)
     * @return (boolean)handleIsFilterable()
     */
    public final boolean isFilterable()
    {
        boolean filterable39a = this.__filterable39a;
        if (!this.__filterable39aSet)
        {
            // filterable has no pre constraints
            filterable39a = handleIsFilterable();
            // filterable has no post constraints
            this.__filterable39a = filterable39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__filterable39aSet = true;
            }
        }
        return filterable39a;
    }

   /**
    * @see GuiManageableEntity#isHasCustom()
    * @return boolean
    */
    protected abstract boolean handleIsHasCustom();

    private boolean __hasCustom40a;
    private boolean __hasCustom40aSet = false;

    /**
     * True if the Manageable Entity has children that must be handled. Usefull for Rules.
     * @return (boolean)handleIsHasCustom()
     */
    public final boolean isHasCustom()
    {
        boolean hasCustom40a = this.__hasCustom40a;
        if (!this.__hasCustom40aSet)
        {
            // hasCustom has no pre constraints
            hasCustom40a = handleIsHasCustom();
            // hasCustom has no post constraints
            this.__hasCustom40a = hasCustom40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hasCustom40aSet = true;
            }
        }
        return hasCustom40a;
    }

   /**
    * @see GuiManageableEntity#isIsCustom()
    * @return boolean
    */
    protected abstract boolean handleIsIsCustom();

    private boolean __isCustom41a;
    private boolean __isCustom41aSet = false;

    /**
     * True if it is a custom manageable. In this case, it is related to another Manageable, and it
     * won't be a stand-alone Mask.
     * @return (boolean)handleIsIsCustom()
     */
    public final boolean isIsCustom()
    {
        boolean isCustom41a = this.__isCustom41a;
        if (!this.__isCustom41aSet)
        {
            // isCustom has no pre constraints
            isCustom41a = handleIsIsCustom();
            // isCustom has no post constraints
            this.__isCustom41a = isCustom41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__isCustom41aSet = true;
            }
        }
        return isCustom41a;
    }

   /**
    * @see GuiManageableEntity#isEditable()
    * @return boolean
    */
    protected abstract boolean handleIsEditable();

    private boolean __editable42a;
    private boolean __editable42aSet = false;

    /**
     * 
     * @return (boolean)handleIsEditable()
     */
    public final boolean isEditable()
    {
        boolean editable42a = this.__editable42a;
        if (!this.__editable42aSet)
        {
            // editable has no pre constraints
            editable42a = handleIsEditable();
            // editable has no post constraints
            this.__editable42a = editable42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__editable42aSet = true;
            }
        }
        return editable42a;
    }

   /**
    * @see GuiManageableEntity#isHasMaximumListSize()
    * @return boolean
    */
    protected abstract boolean handleIsHasMaximumListSize();

    private boolean __hasMaximumListSize43a;
    private boolean __hasMaximumListSize43aSet = false;

    /**
     * 
     * @return (boolean)handleIsHasMaximumListSize()
     */
    public final boolean isHasMaximumListSize()
    {
        boolean hasMaximumListSize43a = this.__hasMaximumListSize43a;
        if (!this.__hasMaximumListSize43aSet)
        {
            // hasMaximumListSize has no pre constraints
            hasMaximumListSize43a = handleIsHasMaximumListSize();
            // hasMaximumListSize has no post constraints
            this.__hasMaximumListSize43a = hasMaximumListSize43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hasMaximumListSize43aSet = true;
            }
        }
        return hasMaximumListSize43a;
    }

   /**
    * @see GuiManageableEntity#getSecurityName()
    * @return String
    */
    protected abstract String handleGetSecurityName();

    private String __securityName44a;
    private boolean __securityName44aSet = false;

    /**
     * 
     * @return (String)handleGetSecurityName()
     */
    public final String getSecurityName()
    {
        String securityName44a = this.__securityName44a;
        if (!this.__securityName44aSet)
        {
            // securityName has no pre constraints
            securityName44a = handleGetSecurityName();
            // securityName has no post constraints
            this.__securityName44a = securityName44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__securityName44aSet = true;
            }
        }
        return securityName44a;
    }

   /**
    * @see GuiManageableEntity#isFilterLoadingShortcut()
    * @return boolean
    */
    protected abstract boolean handleIsFilterLoadingShortcut();

    private boolean __filterLoadingShortcut45a;
    private boolean __filterLoadingShortcut45aSet = false;

    /**
     * 
     * @return (boolean)handleIsFilterLoadingShortcut()
     */
    public final boolean isFilterLoadingShortcut()
    {
        boolean filterLoadingShortcut45a = this.__filterLoadingShortcut45a;
        if (!this.__filterLoadingShortcut45aSet)
        {
            // filterLoadingShortcut has no pre constraints
            filterLoadingShortcut45a = handleIsFilterLoadingShortcut();
            // filterLoadingShortcut has no post constraints
            this.__filterLoadingShortcut45a = filterLoadingShortcut45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__filterLoadingShortcut45aSet = true;
            }
        }
        return filterLoadingShortcut45a;
    }

   /**
    * @see GuiManageableEntity#getEjbInterfaceName()
    * @return String
    */
    protected abstract String handleGetEjbInterfaceName();

    private String __ejbInterfaceName46a;
    private boolean __ejbInterfaceName46aSet = false;

    /**
     * 
     * @return (String)handleGetEjbInterfaceName()
     */
    public final String getEjbInterfaceName()
    {
        String ejbInterfaceName46a = this.__ejbInterfaceName46a;
        if (!this.__ejbInterfaceName46aSet)
        {
            // ejbInterfaceName has no pre constraints
            ejbInterfaceName46a = handleGetEjbInterfaceName();
            // ejbInterfaceName has no post constraints
            this.__ejbInterfaceName46a = ejbInterfaceName46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__ejbInterfaceName46aSet = true;
            }
        }
        return ejbInterfaceName46a;
    }

   /**
    * @see GuiManageableEntity#isHasCustomSorters()
    * @return boolean
    */
    protected abstract boolean handleIsHasCustomSorters();

    private boolean __hasCustomSorters47a;
    private boolean __hasCustomSorters47aSet = false;

    /**
     * Returns true if tagged value associated to custom sorters (K+TP Rule entity) is set to true
     * for Manageable Entity.
     * @return (boolean)handleIsHasCustomSorters()
     */
    public final boolean isHasCustomSorters()
    {
        boolean hasCustomSorters47a = this.__hasCustomSorters47a;
        if (!this.__hasCustomSorters47aSet)
        {
            // hasCustomSorters has no pre constraints
            hasCustomSorters47a = handleIsHasCustomSorters();
            // hasCustomSorters has no post constraints
            this.__hasCustomSorters47a = hasCustomSorters47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__hasCustomSorters47aSet = true;
            }
        }
        return hasCustomSorters47a;
    }

   /**
    * @see GuiManageableEntity#isReferencable()
    * @return boolean
    */
    protected abstract boolean handleIsReferencable();

    private boolean __referencable48a;
    private boolean __referencable48aSet = false;

    /**
     * Defines whether or not the manageable entity is referencable (sub blotter with drill down
     * references)
     * @return (boolean)handleIsReferencable()
     */
    public final boolean isReferencable()
    {
        boolean referencable48a = this.__referencable48a;
        if (!this.__referencable48aSet)
        {
            // referencable has no pre constraints
            referencable48a = handleIsReferencable();
            // referencable has no post constraints
            this.__referencable48a = referencable48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__referencable48aSet = true;
            }
        }
        return referencable48a;
    }

   /**
    * @see GuiManageableEntity#isRealTimeData()
    * @return boolean
    */
    protected abstract boolean handleIsRealTimeData();

    private boolean __realTimeData49a;
    private boolean __realTimeData49aSet = false;

    /**
     * true if Manageable Entity carries RealTimeData stereotype
     * @return (boolean)handleIsRealTimeData()
     */
    public final boolean isRealTimeData()
    {
        boolean realTimeData49a = this.__realTimeData49a;
        if (!this.__realTimeData49aSet)
        {
            // realTimeData has no pre constraints
            realTimeData49a = handleIsRealTimeData();
            // realTimeData has no post constraints
            this.__realTimeData49a = realTimeData49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__realTimeData49aSet = true;
            }
        }
        return realTimeData49a;
    }

   /**
    * @see GuiManageableEntity#isValidable()
    * @return boolean
    */
    protected abstract boolean handleIsValidable();

    private boolean __validable50a;
    private boolean __validable50aSet = false;

    /**
     * True if the manageable entity carries Validable stereotype (Validable object)
     * @return (boolean)handleIsValidable()
     */
    public final boolean isValidable()
    {
        boolean validable50a = this.__validable50a;
        if (!this.__validable50aSet)
        {
            // validable has no pre constraints
            validable50a = handleIsValidable();
            // validable has no post constraints
            this.__validable50a = validable50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__validable50aSet = true;
            }
        }
        return validable50a;
    }

   /**
    * @see GuiManageableEntity#isExternalOrganizationExists()
    * @return boolean
    */
    protected abstract boolean handleIsExternalOrganizationExists();

    private boolean __externalOrganizationExists51a;
    private boolean __externalOrganizationExists51aSet = false;

    /**
     * 
     * @return (boolean)handleIsExternalOrganizationExists()
     */
    public final boolean isExternalOrganizationExists()
    {
        boolean externalOrganizationExists51a = this.__externalOrganizationExists51a;
        if (!this.__externalOrganizationExists51aSet)
        {
            // externalOrganizationExists has no pre constraints
            externalOrganizationExists51a = handleIsExternalOrganizationExists();
            // externalOrganizationExists has no post constraints
            this.__externalOrganizationExists51a = externalOrganizationExists51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__externalOrganizationExists51aSet = true;
            }
        }
        return externalOrganizationExists51a;
    }

   /**
    * @see GuiManageableEntity#getManageableExternalOrganization()
    * @return Object
    */
    protected abstract Object handleGetManageableExternalOrganization();

    private Object __manageableExternalOrganization52a;
    private boolean __manageableExternalOrganization52aSet = false;

    /**
     * 
     * @return (Object)handleGetManageableExternalOrganization()
     */
    public final Object getManageableExternalOrganization()
    {
        Object manageableExternalOrganization52a = this.__manageableExternalOrganization52a;
        if (!this.__manageableExternalOrganization52aSet)
        {
            // manageableExternalOrganization has no pre constraints
            manageableExternalOrganization52a = handleGetManageableExternalOrganization();
            // manageableExternalOrganization has no post constraints
            this.__manageableExternalOrganization52a = manageableExternalOrganization52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__manageableExternalOrganization52aSet = true;
            }
        }
        return manageableExternalOrganization52a;
    }

   /**
    * @see GuiManageableEntity#isShowDeal()
    * @return boolean
    */
    protected abstract boolean handleIsShowDeal();

    private boolean __showDeal53a;
    private boolean __showDeal53aSet = false;

    /**
     * is True if Manageable entity has the corresponding tagged value set to true
     * @return (boolean)handleIsShowDeal()
     */
    public final boolean isShowDeal()
    {
        boolean showDeal53a = this.__showDeal53a;
        if (!this.__showDeal53aSet)
        {
            // showDeal has no pre constraints
            showDeal53a = handleIsShowDeal();
            // showDeal has no post constraints
            this.__showDeal53a = showDeal53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__showDeal53aSet = true;
            }
        }
        return showDeal53a;
    }

   /**
    * @see GuiManageableEntity#isUseTemplating()
    * @return boolean
    */
    protected abstract boolean handleIsUseTemplating();

    private boolean __useTemplating54a;
    private boolean __useTemplating54aSet = false;

    /**
     * 
     * @return (boolean)handleIsUseTemplating()
     */
    public final boolean isUseTemplating()
    {
        boolean useTemplating54a = this.__useTemplating54a;
        if (!this.__useTemplating54aSet)
        {
            // useTemplating has no pre constraints
            useTemplating54a = handleIsUseTemplating();
            // useTemplating has no post constraints
            this.__useTemplating54a = useTemplating54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__useTemplating54aSet = true;
            }
        }
        return useTemplating54a;
    }

   /**
    * @see GuiManageableEntity#isRule()
    * @return boolean
    */
    protected abstract boolean handleIsRule();

    private boolean __rule55a;
    private boolean __rule55aSet = false;

    /**
     * true if Manageable entity is a K+TP Rule
     * @return (boolean)handleIsRule()
     */
    public final boolean isRule()
    {
        boolean rule55a = this.__rule55a;
        if (!this.__rule55aSet)
        {
            // rule has no pre constraints
            rule55a = handleIsRule();
            // rule has no post constraints
            this.__rule55a = rule55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__rule55aSet = true;
            }
        }
        return rule55a;
    }

   /**
    * @see GuiManageableEntity#isInterceptable()
    * @return boolean
    */
    protected abstract boolean handleIsInterceptable();

    private boolean __interceptable56a;
    private boolean __interceptable56aSet = false;

    /**
     * True if the manageable entity carries Interceptable stereotype (Interceptable object)
     * @return (boolean)handleIsInterceptable()
     */
    public final boolean isInterceptable()
    {
        boolean interceptable56a = this.__interceptable56a;
        if (!this.__interceptable56aSet)
        {
            // interceptable has no pre constraints
            interceptable56a = handleIsInterceptable();
            // interceptable has no post constraints
            this.__interceptable56a = interceptable56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__interceptable56aSet = true;
            }
        }
        return interceptable56a;
    }

   /**
    * @see GuiManageableEntity#getViewName()
    * @return String
    */
    protected abstract String handleGetViewName();

    private String __viewName57a;
    private boolean __viewName57aSet = false;

    /**
     * 
     * @return (String)handleGetViewName()
     */
    public final String getViewName()
    {
        String viewName57a = this.__viewName57a;
        if (!this.__viewName57aSet)
        {
            // viewName has no pre constraints
            viewName57a = handleGetViewName();
            // viewName has no post constraints
            this.__viewName57a = viewName57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__viewName57aSet = true;
            }
        }
        return viewName57a;
    }

   /**
    * @see GuiManageableEntity#getViewTitleKey()
    * @return String
    */
    protected abstract String handleGetViewTitleKey();

    private String __viewTitleKey58a;
    private boolean __viewTitleKey58aSet = false;

    /**
     * 
     * @return (String)handleGetViewTitleKey()
     */
    public final String getViewTitleKey()
    {
        String viewTitleKey58a = this.__viewTitleKey58a;
        if (!this.__viewTitleKey58aSet)
        {
            // viewTitleKey has no pre constraints
            viewTitleKey58a = handleGetViewTitleKey();
            // viewTitleKey has no post constraints
            this.__viewTitleKey58a = viewTitleKey58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__viewTitleKey58aSet = true;
            }
        }
        return viewTitleKey58a;
    }

   /**
    * @see GuiManageableEntity#getViewTitleValue()
    * @return String
    */
    protected abstract String handleGetViewTitleValue();

    private String __viewTitleValue59a;
    private boolean __viewTitleValue59aSet = false;

    /**
     * 
     * @return (String)handleGetViewTitleValue()
     */
    public final String getViewTitleValue()
    {
        String viewTitleValue59a = this.__viewTitleValue59a;
        if (!this.__viewTitleValue59aSet)
        {
            // viewTitleValue has no pre constraints
            viewTitleValue59a = handleGetViewTitleValue();
            // viewTitleValue has no post constraints
            this.__viewTitleValue59a = viewTitleValue59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__viewTitleValue59aSet = true;
            }
        }
        return viewTitleValue59a;
    }

   /**
    * @see GuiManageableEntity#getFormBeanType()
    * @return String
    */
    protected abstract String handleGetFormBeanType();

    private String __formBeanType60a;
    private boolean __formBeanType60aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanType()
     */
    public final String getFormBeanType()
    {
        String formBeanType60a = this.__formBeanType60a;
        if (!this.__formBeanType60aSet)
        {
            // formBeanType has no pre constraints
            formBeanType60a = handleGetFormBeanType();
            // formBeanType has no post constraints
            this.__formBeanType60a = formBeanType60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanType60aSet = true;
            }
        }
        return formBeanType60a;
    }

   /**
    * @see GuiManageableEntity#getFormBeanName()
    * @return String
    */
    protected abstract String handleGetFormBeanName();

    private String __formBeanName61a;
    private boolean __formBeanName61aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanName()
     */
    public final String getFormBeanName()
    {
        String formBeanName61a = this.__formBeanName61a;
        if (!this.__formBeanName61aSet)
        {
            // formBeanName has no pre constraints
            formBeanName61a = handleGetFormBeanName();
            // formBeanName has no post constraints
            this.__formBeanName61a = formBeanName61a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanName61aSet = true;
            }
        }
        return formBeanName61a;
    }

   /**
    * @see GuiManageableEntity#isPreload()
    * @return boolean
    */
    protected abstract boolean handleIsPreload();

    private boolean __preload62a;
    private boolean __preload62aSet = false;

    /**
     * 
     * @return (boolean)handleIsPreload()
     */
    public final boolean isPreload()
    {
        boolean preload62a = this.__preload62a;
        if (!this.__preload62aSet)
        {
            // preload has no pre constraints
            preload62a = handleIsPreload();
            // preload has no post constraints
            this.__preload62a = preload62a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__preload62aSet = true;
            }
        }
        return preload62a;
    }

   /**
    * @see GuiManageableEntity#getFormBeanClassName()
    * @return String
    */
    protected abstract String handleGetFormBeanClassName();

    private String __formBeanClassName63a;
    private boolean __formBeanClassName63aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanClassName()
     */
    public final String getFormBeanClassName()
    {
        String formBeanClassName63a = this.__formBeanClassName63a;
        if (!this.__formBeanClassName63aSet)
        {
            // formBeanClassName has no pre constraints
            formBeanClassName63a = handleGetFormBeanClassName();
            // formBeanClassName has no post constraints
            this.__formBeanClassName63a = formBeanClassName63a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanClassName63aSet = true;
            }
        }
        return formBeanClassName63a;
    }

   /**
    * @see GuiManageableEntity#getFormBeanFullPath()
    * @return String
    */
    protected abstract String handleGetFormBeanFullPath();

    private String __formBeanFullPath64a;
    private boolean __formBeanFullPath64aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanFullPath()
     */
    public final String getFormBeanFullPath()
    {
        String formBeanFullPath64a = this.__formBeanFullPath64a;
        if (!this.__formBeanFullPath64aSet)
        {
            // formBeanFullPath has no pre constraints
            formBeanFullPath64a = handleGetFormBeanFullPath();
            // formBeanFullPath has no post constraints
            this.__formBeanFullPath64a = formBeanFullPath64a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formBeanFullPath64aSet = true;
            }
        }
        return formBeanFullPath64a;
    }

   /**
    * @see GuiManageableEntity#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private String __messageKey65a;
    private boolean __messageKey65aSet = false;

    /**
     * 
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String messageKey65a = this.__messageKey65a;
        if (!this.__messageKey65aSet)
        {
            // messageKey has no pre constraints
            messageKey65a = handleGetMessageKey();
            // messageKey has no post constraints
            this.__messageKey65a = messageKey65a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__messageKey65aSet = true;
            }
        }
        return messageKey65a;
    }

   /**
    * @see GuiManageableEntity#getMessageValue()
    * @return String
    */
    protected abstract String handleGetMessageValue();

    private String __messageValue66a;
    private boolean __messageValue66aSet = false;

    /**
     * 
     * @return (String)handleGetMessageValue()
     */
    public final String getMessageValue()
    {
        String messageValue66a = this.__messageValue66a;
        if (!this.__messageValue66aSet)
        {
            // messageValue has no pre constraints
            messageValue66a = handleGetMessageValue();
            // messageValue has no post constraints
            this.__messageValue66a = messageValue66a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__messageValue66aSet = true;
            }
        }
        return messageValue66a;
    }

   /**
    * @see GuiManageableEntity#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String __onlineHelpKey67a;
    private boolean __onlineHelpKey67aSet = false;

    /**
     * The key to lookup the online help documentation.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String onlineHelpKey67a = this.__onlineHelpKey67a;
        if (!this.__onlineHelpKey67aSet)
        {
            // onlineHelpKey has no pre constraints
            onlineHelpKey67a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.__onlineHelpKey67a = onlineHelpKey67a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpKey67aSet = true;
            }
        }
        return onlineHelpKey67a;
    }

   /**
    * @see GuiManageableEntity#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String __onlineHelpValue68a;
    private boolean __onlineHelpValue68aSet = false;

    /**
     * The online help documentation. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String onlineHelpValue68a = this.__onlineHelpValue68a;
        if (!this.__onlineHelpValue68aSet)
        {
            // onlineHelpValue has no pre constraints
            onlineHelpValue68a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.__onlineHelpValue68a = onlineHelpValue68a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpValue68aSet = true;
            }
        }
        return onlineHelpValue68a;
    }

   /**
    * @see GuiManageableEntity#getOnlineHelpActionPath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpActionPath();

    private String __onlineHelpActionPath69a;
    private boolean __onlineHelpActionPath69aSet = false;

    /**
     * The full path to this entity's online help action. The returned String does not have a suffix
     * such as '.do'.
     * @return (String)handleGetOnlineHelpActionPath()
     */
    public final String getOnlineHelpActionPath()
    {
        String onlineHelpActionPath69a = this.__onlineHelpActionPath69a;
        if (!this.__onlineHelpActionPath69aSet)
        {
            // onlineHelpActionPath has no pre constraints
            onlineHelpActionPath69a = handleGetOnlineHelpActionPath();
            // onlineHelpActionPath has no post constraints
            this.__onlineHelpActionPath69a = onlineHelpActionPath69a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpActionPath69aSet = true;
            }
        }
        return onlineHelpActionPath69a;
    }

   /**
    * @see GuiManageableEntity#getOnlineHelpPagePath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpPagePath();

    private String __onlineHelpPagePath70a;
    private boolean __onlineHelpPagePath70aSet = false;

    /**
     * The full path to this entitiy's online help page. The returned String does not have a suffix
     * such as '.jsp'.
     * @return (String)handleGetOnlineHelpPagePath()
     */
    public final String getOnlineHelpPagePath()
    {
        String onlineHelpPagePath70a = this.__onlineHelpPagePath70a;
        if (!this.__onlineHelpPagePath70aSet)
        {
            // onlineHelpPagePath has no pre constraints
            onlineHelpPagePath70a = handleGetOnlineHelpPagePath();
            // onlineHelpPagePath has no post constraints
            this.__onlineHelpPagePath70a = onlineHelpPagePath70a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__onlineHelpPagePath70aSet = true;
            }
        }
        return onlineHelpPagePath70a;
    }

   /**
    * @see GuiManageableEntity#getControllerType()
    * @return String
    */
    protected abstract String handleGetControllerType();

    private String __controllerType71a;
    private boolean __controllerType71aSet = false;

    /**
     * Fully qualified name of this manageable controller.
     * @return (String)handleGetControllerType()
     */
    public final String getControllerType()
    {
        String controllerType71a = this.__controllerType71a;
        if (!this.__controllerType71aSet)
        {
            // controllerType has no pre constraints
            controllerType71a = handleGetControllerType();
            // controllerType has no post constraints
            this.__controllerType71a = controllerType71a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__controllerType71aSet = true;
            }
        }
        return controllerType71a;
    }

   /**
    * @see GuiManageableEntity#getControllerBeanName()
    * @return String
    */
    protected abstract String handleGetControllerBeanName();

    private String __controllerBeanName72a;
    private boolean __controllerBeanName72aSet = false;

    /**
     * The bean name of this manageable controller (this is what is stored in the JSF configuration
     * file).
     * @return (String)handleGetControllerBeanName()
     */
    public final String getControllerBeanName()
    {
        String controllerBeanName72a = this.__controllerBeanName72a;
        if (!this.__controllerBeanName72aSet)
        {
            // controllerBeanName has no pre constraints
            controllerBeanName72a = handleGetControllerBeanName();
            // controllerBeanName has no post constraints
            this.__controllerBeanName72a = controllerBeanName72a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__controllerBeanName72aSet = true;
            }
        }
        return controllerBeanName72a;
    }

   /**
    * @see GuiManageableEntity#getControllerFullPath()
    * @return String
    */
    protected abstract String handleGetControllerFullPath();

    private String __controllerFullPath73a;
    private boolean __controllerFullPath73aSet = false;

    /**
     * Full path of this manageable controller.
     * @return (String)handleGetControllerFullPath()
     */
    public final String getControllerFullPath()
    {
        String controllerFullPath73a = this.__controllerFullPath73a;
        if (!this.__controllerFullPath73aSet)
        {
            // controllerFullPath has no pre constraints
            controllerFullPath73a = handleGetControllerFullPath();
            // controllerFullPath has no post constraints
            this.__controllerFullPath73a = controllerFullPath73a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__controllerFullPath73aSet = true;
            }
        }
        return controllerFullPath73a;
    }

   /**
    * @see GuiManageableEntity#getControllerName()
    * @return String
    */
    protected abstract String handleGetControllerName();

    private String __controllerName74a;
    private boolean __controllerName74aSet = false;

    /**
     * Manageable controller class name.
     * @return (String)handleGetControllerName()
     */
    public final String getControllerName()
    {
        String controllerName74a = this.__controllerName74a;
        if (!this.__controllerName74aSet)
        {
            // controllerName has no pre constraints
            controllerName74a = handleGetControllerName();
            // controllerName has no post constraints
            this.__controllerName74a = controllerName74a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__controllerName74aSet = true;
            }
        }
        return controllerName74a;
    }

   /**
    * @see GuiManageableEntity#getValueObjectClassName()
    * @return String
    */
    protected abstract String handleGetValueObjectClassName();

    private String __valueObjectClassName75a;
    private boolean __valueObjectClassName75aSet = false;

    /**
     * 
     * @return (String)handleGetValueObjectClassName()
     */
    public final String getValueObjectClassName()
    {
        String valueObjectClassName75a = this.__valueObjectClassName75a;
        if (!this.__valueObjectClassName75aSet)
        {
            // valueObjectClassName has no pre constraints
            valueObjectClassName75a = handleGetValueObjectClassName();
            // valueObjectClassName has no post constraints
            this.__valueObjectClassName75a = valueObjectClassName75a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__valueObjectClassName75aSet = true;
            }
        }
        return valueObjectClassName75a;
    }

   /**
    * @see GuiManageableEntity#getFormSerialVersionUID()
    * @return String
    */
    protected abstract String handleGetFormSerialVersionUID();

    private String __formSerialVersionUID76a;
    private boolean __formSerialVersionUID76aSet = false;

    /**
     * The calcuated serial version UID for this action's form.
     * @return (String)handleGetFormSerialVersionUID()
     */
    public final String getFormSerialVersionUID()
    {
        String formSerialVersionUID76a = this.__formSerialVersionUID76a;
        if (!this.__formSerialVersionUID76aSet)
        {
            // formSerialVersionUID has no pre constraints
            formSerialVersionUID76a = handleGetFormSerialVersionUID();
            // formSerialVersionUID has no post constraints
            this.__formSerialVersionUID76a = formSerialVersionUID76a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__formSerialVersionUID76aSet = true;
            }
        }
        return formSerialVersionUID76a;
    }

   /**
    * @see GuiManageableEntity#getActionSerialVersionUID()
    * @return String
    */
    protected abstract String handleGetActionSerialVersionUID();

    private String __actionSerialVersionUID77a;
    private boolean __actionSerialVersionUID77aSet = false;

    /**
     * The calcuated serial version UID for this manageable actions.
     * @return (String)handleGetActionSerialVersionUID()
     */
    public final String getActionSerialVersionUID()
    {
        String actionSerialVersionUID77a = this.__actionSerialVersionUID77a;
        if (!this.__actionSerialVersionUID77aSet)
        {
            // actionSerialVersionUID has no pre constraints
            actionSerialVersionUID77a = handleGetActionSerialVersionUID();
            // actionSerialVersionUID has no post constraints
            this.__actionSerialVersionUID77a = actionSerialVersionUID77a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__actionSerialVersionUID77aSet = true;
            }
        }
        return actionSerialVersionUID77a;
    }

   /**
    * @see GuiManageableEntity#getPopulatorName()
    * @return String
    */
    protected abstract String handleGetPopulatorName();

    private String __populatorName78a;
    private boolean __populatorName78aSet = false;

    /**
     * 
     * @return (String)handleGetPopulatorName()
     */
    public final String getPopulatorName()
    {
        String populatorName78a = this.__populatorName78a;
        if (!this.__populatorName78aSet)
        {
            // populatorName has no pre constraints
            populatorName78a = handleGetPopulatorName();
            // populatorName has no post constraints
            this.__populatorName78a = populatorName78a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__populatorName78aSet = true;
            }
        }
        return populatorName78a;
    }

   /**
    * @see GuiManageableEntity#getPopulatorFullPath()
    * @return String
    */
    protected abstract String handleGetPopulatorFullPath();

    private String __populatorFullPath79a;
    private boolean __populatorFullPath79aSet = false;

    /**
     * 
     * @return (String)handleGetPopulatorFullPath()
     */
    public final String getPopulatorFullPath()
    {
        String populatorFullPath79a = this.__populatorFullPath79a;
        if (!this.__populatorFullPath79aSet)
        {
            // populatorFullPath has no pre constraints
            populatorFullPath79a = handleGetPopulatorFullPath();
            // populatorFullPath has no post constraints
            this.__populatorFullPath79a = populatorFullPath79a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__populatorFullPath79aSet = true;
            }
        }
        return populatorFullPath79a;
    }

   /**
    * @see GuiManageableEntity#getPopulatorType()
    * @return String
    */
    protected abstract String handleGetPopulatorType();

    private String __populatorType80a;
    private boolean __populatorType80aSet = false;

    /**
     * 
     * @return (String)handleGetPopulatorType()
     */
    public final String getPopulatorType()
    {
        String populatorType80a = this.__populatorType80a;
        if (!this.__populatorType80aSet)
        {
            // populatorType has no pre constraints
            populatorType80a = handleGetPopulatorType();
            // populatorType has no post constraints
            this.__populatorType80a = populatorType80a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__populatorType80aSet = true;
            }
        }
        return populatorType80a;
    }

   /**
    * @see GuiManageableEntity#getViewFullPath()
    * @return String
    */
    protected abstract String handleGetViewFullPath();

    private String __viewFullPath81a;
    private boolean __viewFullPath81aSet = false;

    /**
     * 
     * @return (String)handleGetViewFullPath()
     */
    public final String getViewFullPath()
    {
        String viewFullPath81a = this.__viewFullPath81a;
        if (!this.__viewFullPath81aSet)
        {
            // viewFullPath has no pre constraints
            viewFullPath81a = handleGetViewFullPath();
            // viewFullPath has no post constraints
            this.__viewFullPath81a = viewFullPath81a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__viewFullPath81aSet = true;
            }
        }
        return viewFullPath81a;
    }

   /**
    * @see GuiManageableEntity#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private boolean __validationRequired82a;
    private boolean __validationRequired82aSet = false;

    /**
     * 
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean validationRequired82a = this.__validationRequired82a;
        if (!this.__validationRequired82aSet)
        {
            // validationRequired has no pre constraints
            validationRequired82a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.__validationRequired82a = validationRequired82a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__validationRequired82aSet = true;
            }
        }
        return validationRequired82a;
    }

   /**
    * @see GuiManageableEntity#getSearchFormBeanName()
    * @return String
    */
    protected abstract String handleGetSearchFormBeanName();

    private String __searchFormBeanName83a;
    private boolean __searchFormBeanName83aSet = false;

    /**
     * 
     * @return (String)handleGetSearchFormBeanName()
     */
    public final String getSearchFormBeanName()
    {
        String searchFormBeanName83a = this.__searchFormBeanName83a;
        if (!this.__searchFormBeanName83aSet)
        {
            // searchFormBeanName has no pre constraints
            searchFormBeanName83a = handleGetSearchFormBeanName();
            // searchFormBeanName has no post constraints
            this.__searchFormBeanName83a = searchFormBeanName83a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__searchFormBeanName83aSet = true;
            }
        }
        return searchFormBeanName83a;
    }

   /**
    * @see GuiManageableEntity#getSearchFormBeanType()
    * @return String
    */
    protected abstract String handleGetSearchFormBeanType();

    private String __searchFormBeanType84a;
    private boolean __searchFormBeanType84aSet = false;

    /**
     * 
     * @return (String)handleGetSearchFormBeanType()
     */
    public final String getSearchFormBeanType()
    {
        String searchFormBeanType84a = this.__searchFormBeanType84a;
        if (!this.__searchFormBeanType84aSet)
        {
            // searchFormBeanType has no pre constraints
            searchFormBeanType84a = handleGetSearchFormBeanType();
            // searchFormBeanType has no post constraints
            this.__searchFormBeanType84a = searchFormBeanType84a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__searchFormBeanType84aSet = true;
            }
        }
        return searchFormBeanType84a;
    }

   /**
    * @see GuiManageableEntity#getSearchFormBeanFullPath()
    * @return String
    */
    protected abstract String handleGetSearchFormBeanFullPath();

    private String __searchFormBeanFullPath85a;
    private boolean __searchFormBeanFullPath85aSet = false;

    /**
     * 
     * @return (String)handleGetSearchFormBeanFullPath()
     */
    public final String getSearchFormBeanFullPath()
    {
        String searchFormBeanFullPath85a = this.__searchFormBeanFullPath85a;
        if (!this.__searchFormBeanFullPath85aSet)
        {
            // searchFormBeanFullPath has no pre constraints
            searchFormBeanFullPath85a = handleGetSearchFormBeanFullPath();
            // searchFormBeanFullPath has no post constraints
            this.__searchFormBeanFullPath85a = searchFormBeanFullPath85a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__searchFormBeanFullPath85aSet = true;
            }
        }
        return searchFormBeanFullPath85a;
    }

   /**
    * @see GuiManageableEntity#getSearchFormBeanClassName()
    * @return String
    */
    protected abstract String handleGetSearchFormBeanClassName();

    private String __searchFormBeanClassName86a;
    private boolean __searchFormBeanClassName86aSet = false;

    /**
     * 
     * @return (String)handleGetSearchFormBeanClassName()
     */
    public final String getSearchFormBeanClassName()
    {
        String searchFormBeanClassName86a = this.__searchFormBeanClassName86a;
        if (!this.__searchFormBeanClassName86aSet)
        {
            // searchFormBeanClassName has no pre constraints
            searchFormBeanClassName86a = handleGetSearchFormBeanClassName();
            // searchFormBeanClassName has no post constraints
            this.__searchFormBeanClassName86a = searchFormBeanClassName86a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__searchFormBeanClassName86aSet = true;
            }
        }
        return searchFormBeanClassName86a;
    }

   /**
    * @see GuiManageableEntity#getManageableSearchAttributes()
    * @return Collection
    */
    protected abstract Collection handleGetManageableSearchAttributes();

    private Collection __manageableSearchAttributes87a;
    private boolean __manageableSearchAttributes87aSet = false;

    /**
     * 
     * @return (Collection)handleGetManageableSearchAttributes()
     */
    public final Collection getManageableSearchAttributes()
    {
        Collection manageableSearchAttributes87a = this.__manageableSearchAttributes87a;
        if (!this.__manageableSearchAttributes87aSet)
        {
            // manageableSearchAttributes has no pre constraints
            manageableSearchAttributes87a = handleGetManageableSearchAttributes();
            // manageableSearchAttributes has no post constraints
            this.__manageableSearchAttributes87a = manageableSearchAttributes87a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__manageableSearchAttributes87aSet = true;
            }
        }
        return manageableSearchAttributes87a;
    }

   /**
    * @see GuiManageableEntity#getManageableSearchAssociationEnds()
    * @return Collection
    */
    protected abstract Collection handleGetManageableSearchAssociationEnds();

    private Collection __manageableSearchAssociationEnds88a;
    private boolean __manageableSearchAssociationEnds88aSet = false;

    /**
     * 
     * @return (Collection)handleGetManageableSearchAssociationEnds()
     */
    public final Collection getManageableSearchAssociationEnds()
    {
        Collection manageableSearchAssociationEnds88a = this.__manageableSearchAssociationEnds88a;
        if (!this.__manageableSearchAssociationEnds88aSet)
        {
            // manageableSearchAssociationEnds has no pre constraints
            manageableSearchAssociationEnds88a = handleGetManageableSearchAssociationEnds();
            // manageableSearchAssociationEnds has no post constraints
            this.__manageableSearchAssociationEnds88a = manageableSearchAssociationEnds88a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__manageableSearchAssociationEnds88aSet = true;
            }
        }
        return manageableSearchAssociationEnds88a;
    }

   /**
    * @see GuiManageableEntity#isNeedsFileUpload()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsFileUpload();

    private boolean __needsFileUpload89a;
    private boolean __needsFileUpload89aSet = false;

    /**
     * 
     * @return (boolean)handleIsNeedsFileUpload()
     */
    public final boolean isNeedsFileUpload()
    {
        boolean needsFileUpload89a = this.__needsFileUpload89a;
        if (!this.__needsFileUpload89aSet)
        {
            // needsFileUpload has no pre constraints
            needsFileUpload89a = handleIsNeedsFileUpload();
            // needsFileUpload has no post constraints
            this.__needsFileUpload89a = needsFileUpload89a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__needsFileUpload89aSet = true;
            }
        }
        return needsFileUpload89a;
    }

   /**
    * @see GuiManageableEntity#getConverterFullPath()
    * @return String
    */
    protected abstract String handleGetConverterFullPath();

    private String __converterFullPath90a;
    private boolean __converterFullPath90aSet = false;

    /**
     * 
     * @return (String)handleGetConverterFullPath()
     */
    public final String getConverterFullPath()
    {
        String converterFullPath90a = this.__converterFullPath90a;
        if (!this.__converterFullPath90aSet)
        {
            // converterFullPath has no pre constraints
            converterFullPath90a = handleGetConverterFullPath();
            // converterFullPath has no post constraints
            this.__converterFullPath90a = converterFullPath90a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__converterFullPath90aSet = true;
            }
        }
        return converterFullPath90a;
    }

   /**
    * @see GuiManageableEntity#getConverterType()
    * @return String
    */
    protected abstract String handleGetConverterType();

    private String __converterType91a;
    private boolean __converterType91aSet = false;

    /**
     * 
     * @return (String)handleGetConverterType()
     */
    public final String getConverterType()
    {
        String converterType91a = this.__converterType91a;
        if (!this.__converterType91aSet)
        {
            // converterType has no pre constraints
            converterType91a = handleGetConverterType();
            // converterType has no post constraints
            this.__converterType91a = converterType91a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__converterType91aSet = true;
            }
        }
        return converterType91a;
    }

   /**
    * @see GuiManageableEntity#getConverterClassName()
    * @return String
    */
    protected abstract String handleGetConverterClassName();

    private String __converterClassName92a;
    private boolean __converterClassName92aSet = false;

    /**
     * 
     * @return (String)handleGetConverterClassName()
     */
    public final String getConverterClassName()
    {
        String converterClassName92a = this.__converterClassName92a;
        if (!this.__converterClassName92aSet)
        {
            // converterClassName has no pre constraints
            converterClassName92a = handleGetConverterClassName();
            // converterClassName has no post constraints
            this.__converterClassName92a = converterClassName92a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__converterClassName92aSet = true;
            }
        }
        return converterClassName92a;
    }

   /**
    * @see GuiManageableEntity#getOdsExportFullPath()
    * @return String
    */
    protected abstract String handleGetOdsExportFullPath();

    private String __odsExportFullPath93a;
    private boolean __odsExportFullPath93aSet = false;

    /**
     * 
     * @return (String)handleGetOdsExportFullPath()
     */
    public final String getOdsExportFullPath()
    {
        String odsExportFullPath93a = this.__odsExportFullPath93a;
        if (!this.__odsExportFullPath93aSet)
        {
            // odsExportFullPath has no pre constraints
            odsExportFullPath93a = handleGetOdsExportFullPath();
            // odsExportFullPath has no post constraints
            this.__odsExportFullPath93a = odsExportFullPath93a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__odsExportFullPath93aSet = true;
            }
        }
        return odsExportFullPath93a;
    }

   /**
    * @see GuiManageableEntity#isNeedsUserInterface()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsUserInterface();

    private boolean __needsUserInterface94a;
    private boolean __needsUserInterface94aSet = false;

    /**
     * 
     * @return (boolean)handleIsNeedsUserInterface()
     */
    public final boolean isNeedsUserInterface()
    {
        boolean needsUserInterface94a = this.__needsUserInterface94a;
        if (!this.__needsUserInterface94aSet)
        {
            // needsUserInterface has no pre constraints
            needsUserInterface94a = handleIsNeedsUserInterface();
            // needsUserInterface has no post constraints
            this.__needsUserInterface94a = needsUserInterface94a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__needsUserInterface94aSet = true;
            }
        }
        return needsUserInterface94a;
    }

   /**
    * @see GuiManageableEntity#getRoles()
    * @return Collection<Role>
    */
    protected abstract Collection<Role> handleGetRoles();

    /**
     * 
     * @return (Collection<Role>)handleGetRoles()
     */
    public final Collection<Role> getRoles()
    {
        Collection<Role> roles95a = null;
        // roles has no pre constraints
        roles95a = handleGetRoles();
        // roles has no post constraints
        return roles95a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * 
     * @return boolean
     */
    protected abstract boolean handleHasCustomUsecases();

    /**
     * 
     * @return handleHasCustomUsecases()
     */
    public boolean hasCustomUsecases()
    {
        // hasCustomUsecases has no pre constraints
        boolean returnValue = handleHasCustomUsecases();
        // hasCustomUsecases has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return Collection
     */
    protected abstract Collection handleGetCustomUseCases();

    /**
     * 
     * @return handleGetCustomUseCases()
     */
    public Collection getCustomUseCases()
    {
        // getCustomUseCases has no pre constraints
        Collection returnValue = handleGetCustomUseCases();
        // getCustomUseCases has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param businessObjectName
     * @return String
     */
    protected abstract String handleGetIdentifierForBusinessObjectReference(String businessObjectName);

    /**
     * 
     * @param businessObjectName String
     * @return handleGetIdentifierForBusinessObjectReference(businessObjectName)
     */
    public String getIdentifierForBusinessObjectReference(String businessObjectName)
    {
        // getIdentifierForBusinessObjectReference has no pre constraints
        String returnValue = handleGetIdentifierForBusinessObjectReference(businessObjectName);
        // getIdentifierForBusinessObjectReference has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return boolean
     */
    protected abstract boolean handleEachBusinessObjectReferenceIsValid();

    /**
     * 
     * @return handleEachBusinessObjectReferenceIsValid()
     */
    public boolean eachBusinessObjectReferenceIsValid()
    {
        // eachBusinessObjectReferenceIsValid has no pre constraints
        boolean returnValue = handleEachBusinessObjectReferenceIsValid();
        // eachBusinessObjectReferenceIsValid has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param customUseCaseName
     * @return String
     */
    protected abstract String handleGetCustomUseCaseActionType(String customUseCaseName);

    /**
     * 
     * @param customUseCaseName String
     * @return handleGetCustomUseCaseActionType(customUseCaseName)
     */
    public String getCustomUseCaseActionType(String customUseCaseName)
    {
        // getCustomUseCaseActionType has no pre constraints
        String returnValue = handleGetCustomUseCaseActionType(customUseCaseName);
        // getCustomUseCaseActionType has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param customUseCaseName
     * @return String
     */
    protected abstract String handleGetCustomUseCaseDisplayType(String customUseCaseName);

    /**
     * 
     * @param customUseCaseName String
     * @return handleGetCustomUseCaseDisplayType(customUseCaseName)
     */
    public String getCustomUseCaseDisplayType(String customUseCaseName)
    {
        // getCustomUseCaseDisplayType has no pre constraints
        String returnValue = handleGetCustomUseCaseDisplayType(customUseCaseName);
        // getCustomUseCaseDisplayType has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param serviceName
     * @return boolean
     */
    protected abstract boolean handleServiceNameExists(String serviceName);

    /**
     * 
     * @param serviceName String
     * @return handleServiceNameExists(serviceName)
     */
    public boolean serviceNameExists(String serviceName)
    {
        // serviceNameExists has no pre constraints
        boolean returnValue = handleServiceNameExists(serviceName);
        // serviceNameExists has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return Collection
     */
    protected abstract Collection handleGetExternalUseCases();

    /**
     * 
     * @return handleGetExternalUseCases()
     */
    public Collection getExternalUseCases()
    {
        // getExternalUseCases has no pre constraints
        Collection returnValue = handleGetExternalUseCases();
        // getExternalUseCases has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return AttributeFacade
     */
    protected abstract AttributeFacade handleGetIdentifierToDelete();

    /**
     * 
     * @return handleGetIdentifierToDelete()
     */
    public AttributeFacade getIdentifierToDelete()
    {
        // getIdentifierToDelete has no pre constraints
        AttributeFacade returnValue = handleGetIdentifierToDelete();
        // getIdentifierToDelete has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return ManageableEntity
     */
    protected abstract ManageableEntity handleGetManageableGeneralizationToDelete();

    /**
     * 
     * @return handleGetManageableGeneralizationToDelete()
     */
    public ManageableEntity getManageableGeneralizationToDelete()
    {
        // getManageableGeneralizationToDelete has no pre constraints
        ManageableEntity returnValue = handleGetManageableGeneralizationToDelete();
        // getManageableGeneralizationToDelete has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param name
     * @return boolean
     */
    protected abstract boolean handleIsAttributeOrAssociation(String name);

    /**
     * 
     * @param name String
     * @return handleIsAttributeOrAssociation(name)
     */
    public boolean isAttributeOrAssociation(String name)
    {
        // isAttributeOrAssociation has no pre constraints
        boolean returnValue = handleIsAttributeOrAssociation(name);
        // isAttributeOrAssociation has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param displayName
     * @return String
     */
    protected abstract String handleGetAttributeNameByDisplayName(String displayName);

    /**
     * 
     * @param displayName String
     * @return handleGetAttributeNameByDisplayName(displayName)
     */
    public String getAttributeNameByDisplayName(String displayName)
    {
        // getAttributeNameByDisplayName has no pre constraints
        String returnValue = handleGetAttributeNameByDisplayName(displayName);
        // getAttributeNameByDisplayName has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param displayName
     * @return String
     */
    protected abstract String handleGetAttributeTypeByDisplayName(String displayName);

    /**
     * 
     * @param displayName String
     * @return handleGetAttributeTypeByDisplayName(displayName)
     */
    public String getAttributeTypeByDisplayName(String displayName)
    {
        // getAttributeTypeByDisplayName has no pre constraints
        String returnValue = handleGetAttributeTypeByDisplayName(displayName);
        // getAttributeTypeByDisplayName has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * will return true if Manageable entity has no Show Deal use case, or if deal id and deal type
     * info is available (attributes with correct tags)
     * @return boolean
     */
    protected abstract boolean handleHasCorrectShowDealInfo();

    /**
     * will return true if Manageable entity has no Show Deal use case, or if deal id and deal type
     * info is available (attributes with correct tags)
     * @return handleHasCorrectShowDealInfo()
     */
    public boolean hasCorrectShowDealInfo()
    {
        // hasCorrectShowDealInfo has no pre constraints
        boolean returnValue = handleHasCorrectShowDealInfo();
        // hasCorrectShowDealInfo has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return AttributeFacade
     */
    protected abstract AttributeFacade handleGetShowDealDealId();

    /**
     * 
     * @return handleGetShowDealDealId()
     */
    public AttributeFacade getShowDealDealId()
    {
        // getShowDealDealId has no pre constraints
        AttributeFacade returnValue = handleGetShowDealDealId();
        // getShowDealDealId has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return AttributeFacade
     */
    protected abstract AttributeFacade handleGetShowDealDealType();

    /**
     * 
     * @return handleGetShowDealDealType()
     */
    public AttributeFacade getShowDealDealType()
    {
        // getShowDealDealType has no pre constraints
        AttributeFacade returnValue = handleGetShowDealDealType();
        // getShowDealDealType has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param manageableAttr
     * @return AttributeFacade
     */
    protected abstract AttributeFacade handleGetCorrespondingVOAttr(GuiManageableEntityAttribute manageableAttr);

    /**
     * 
     * @param manageableAttr GuiManageableEntityAttribute
     * @return handleGetCorrespondingVOAttr(manageableAttr)
     */
    public AttributeFacade getCorrespondingVOAttr(GuiManageableEntityAttribute manageableAttr)
    {
        // getCorrespondingVOAttr has no pre constraints
        AttributeFacade returnValue = handleGetCorrespondingVOAttr(manageableAttr);
        // getCorrespondingVOAttr has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param association
     * @return AttributeFacade
     */
    protected abstract AttributeFacade handleGetCorrespondingRuleVOAttr(GuiManageableEntityAssociationEnd association);

    /**
     * 
     * @param association GuiManageableEntityAssociationEnd
     * @return handleGetCorrespondingRuleVOAttr(association)
     */
    public AttributeFacade getCorrespondingRuleVOAttr(GuiManageableEntityAssociationEnd association)
    {
        // getCorrespondingRuleVOAttr has no pre constraints
        AttributeFacade returnValue = handleGetCorrespondingRuleVOAttr(association);
        // getCorrespondingRuleVOAttr has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param element
     * @return boolean
     */
    protected abstract boolean handleIsSearchable(Object element);

    /**
     * 
     * @param element Object
     * @return handleIsSearchable(element)
     */
    public boolean isSearchable(Object element)
    {
        // isSearchable has no pre constraints
        boolean returnValue = handleIsSearchable(element);
        // isSearchable has no post constraints
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

    /**
     * 
     * @return (Entity)handleGetVersionableEntityReference()
     */
    public final Entity getVersionableEntityReference()
    {
        Entity getVersionableEntityReference1r = null;
        // guiManageableEntity has no pre constraints
        Object result = handleGetVersionableEntityReference();
        MetafacadeBase shieldedResult = this.shieldedElement(result);
        try
        {
            getVersionableEntityReference1r = (Entity)shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiManageableEntityLogic.logger.warn("incorrect metafacade cast for GuiManageableEntityLogic.getVersionableEntityReference Entity " + result + ": " + shieldedResult);
        }
        // guiManageableEntity has no post constraints
        return getVersionableEntityReference1r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetVersionableEntityReference();

    /**
     * 
     * @return (GuiManageableEntity)handleGetCustomOwner()
     */
    public final GuiManageableEntity getCustomOwner()
    {
        GuiManageableEntity getCustomOwner2r = null;
        // customEntityReferences has no pre constraints
        Object result = handleGetCustomOwner();
        MetafacadeBase shieldedResult = this.shieldedElement(result);
        try
        {
            getCustomOwner2r = (GuiManageableEntity)shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiManageableEntityLogic.logger.warn("incorrect metafacade cast for GuiManageableEntityLogic.getCustomOwner GuiManageableEntity " + result + ": " + shieldedResult);
        }
        // customEntityReferences has no post constraints
        return getCustomOwner2r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetCustomOwner();

    /**
     * 
     * @return (List<GuiManageableEntity>)handleGetCustomEntityReferences()
     */
    public final List<GuiManageableEntity> getCustomEntityReferences()
    {
        List<GuiManageableEntity> getCustomEntityReferences3r = null;
        // customOwner has no pre constraints
        List result = handleGetCustomEntityReferences();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getCustomEntityReferences3r = (List<GuiManageableEntity>)shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiManageableEntityLogic.logger.warn("incorrect metafacade cast for GuiManageableEntityLogic.getCustomEntityReferences List<GuiManageableEntity> " + result + ": " + shieldedResult);
        }
        // customOwner has no post constraints
        return getCustomEntityReferences3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetCustomEntityReferences();

    private List<Entity> __getBusinessObjectReferences4r;
    private boolean __getBusinessObjectReferences4rSet = false;

    /**
     * 
     * @return (List<Entity>)handleGetBusinessObjectReferences()
     */
    public final List<Entity> getBusinessObjectReferences()
    {
        List<Entity> getBusinessObjectReferences4r = this.__getBusinessObjectReferences4r;
        if (!this.__getBusinessObjectReferences4rSet)
        {
            // guiManageableEntity has no pre constraints
            List result = handleGetBusinessObjectReferences();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getBusinessObjectReferences4r = (List<Entity>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiManageableEntityLogic.logger.warn("incorrect metafacade cast for GuiManageableEntityLogic.getBusinessObjectReferences List<Entity> " + result + ": " + shieldedResult);
            }
            // guiManageableEntity has no post constraints
            this.__getBusinessObjectReferences4r = getBusinessObjectReferences4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__getBusinessObjectReferences4rSet = true;
            }
        }
        return getBusinessObjectReferences4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetBusinessObjectReferences();

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
     * @see Entity
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
     * @see Entity#getAllEntityReferences()
     */
    public Collection<DependencyFacade> getAllEntityReferences()
    {
        return this.getSuperManageableEntity().getAllEntityReferences();
    }

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see Entity#getAttributeNameList(boolean follow, boolean withIdentifiers)
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
     * @see Entity#getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperManageableEntity().getAttributeNameList(follow, withIdentifiers, withDerived);
    }

    /**
     * Gets a comma separated list of attribute types.  If 'follow' is true, will travel up the
     * inheritance hierarchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see Entity#getAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false.
     * @see Entity#getAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection getAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false and exclude
     * derived attributes if 'withDerived' is set to false.
     * @see Entity#getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public Collection getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperManageableEntity().getAttributes(follow, withIdentifiers, withDerived);
    }

    /**
     * All business operations of the entity, these include any operations that aren't queries.
     * @see Entity#getBusinessOperations()
     */
    public Collection<OperationFacade> getBusinessOperations()
    {
        return this.getSuperManageableEntity().getBusinessOperations();
    }

    /**
     * Gets any children association ends (i.e. entity association ends that are participants in an
     * association with this entity and this entity has composite aggregation defined for those
     * associations).
     * @see Entity#getChildEnds()
     */
    public Collection<EntityAssociationEnd> getChildEnds()
    {
        return this.getSuperManageableEntity().getChildEnds();
    }

    /**
     * The embedded values belonging to this entity.
     * @see Entity#getEmbeddedValues()
     */
    public Collection getEmbeddedValues()
    {
        return this.getSuperManageableEntity().getEmbeddedValues();
    }

    /**
     * All entities referenced by this entity.
     * @see Entity#getEntityReferences()
     */
    public Collection<DependencyFacade> getEntityReferences()
    {
        return this.getSuperManageableEntity().getEntityReferences();
    }

    /**
     * The full name of the type of the identifier. If composite identifier add the PK sufix to the
     * class name. If not, retorns the fully qualified name of the identifier.
     * @see Entity#getFullyQualifiedIdentifierTypeName()
     */
    public String getFullyQualifiedIdentifierTypeName()
    {
        return this.getSuperManageableEntity().getFullyQualifiedIdentifierTypeName();
    }

    /**
     * Gets all the associationEnds of this entity marked with the identifiers stereotype.
     * @see Entity#getIdentifierAssociationEnds()
     */
    public Collection getIdentifierAssociationEnds()
    {
        return this.getSuperManageableEntity().getIdentifierAssociationEnds();
    }

    /**
     * The getter name of the identifier.
     * @see Entity#getIdentifierGetterName()
     */
    public String getIdentifierGetterName()
    {
        return this.getSuperManageableEntity().getIdentifierGetterName();
    }

    /**
     * The name of the identifier. If composite identifier add the Pk sufix. If not composite
     * returns the atribute name of the identifier.
     * @see Entity#getIdentifierName()
     */
    public String getIdentifierName()
    {
        return this.getSuperManageableEntity().getIdentifierName();
    }

    /**
     * The setter name of the identifier.
     * @see Entity#getIdentifierSetterName()
     */
    public String getIdentifierSetterName()
    {
        return this.getSuperManageableEntity().getIdentifierSetterName();
    }

    /**
     * The name of the type of the identifier. If composite identifier add the PK sufix to the class
     * name. If not, retorns the name of the identifier.
     * @see Entity#getIdentifierTypeName()
     */
    public String getIdentifierTypeName()
    {
        return this.getSuperManageableEntity().getIdentifierTypeName();
    }

    /**
     * All the attributes of the entity which make up its identifier (primary key).  Will search any
     * super classes as well.  If no identifiers exist, a default identifier will be created if the
     * allowDefaultIdentifiers property is set to true.
     * @see Entity#getIdentifiers()
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
     * @see Entity#getIdentifiers(boolean follow)
     */
    public Collection getIdentifiers(boolean follow)
    {
        return this.getSuperManageableEntity().getIdentifiers(follow);
    }

    /**
     * The maximum length a SQL name may be.
     * @see Entity#getMaxSqlNameLength()
     */
    public short getMaxSqlNameLength()
    {
        return this.getSuperManageableEntity().getMaxSqlNameLength();
    }

    /**
     * Gets the attributes as a list within an operation call, optionally including the type names
     * and the identifier attributes.
     * @see Entity#getOperationCallFromAttributes(boolean withIdentifiers)
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
     * @see Entity#getOperationCallFromAttributes(boolean withIdentifiers, boolean follow)
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers, boolean follow)
    {
        return this.getSuperManageableEntity().getOperationCallFromAttributes(withIdentifiers, follow);
    }

    /**
     * Returns the parent association end of this entity if its a child entity.  The parent is the
     * entity that is the participant the association that has composite aggregation defined.  Will
     * return null if the entity has no parent.
     * @see Entity#getParentEnd()
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
     * @see Entity#getProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection getProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getProperties(follow, withIdentifiers);
    }

    /**
     * Returns all the operations that can perform queries on the entity.
     * @see Entity#getQueryOperations()
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
     * @see Entity#getQueryOperations(boolean follow)
     */
    public Collection getQueryOperations(boolean follow)
    {
        return this.getSuperManageableEntity().getQueryOperations(follow);
    }

    /**
     * Gets a comma separated list of required attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see Entity#getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of attribute types with are required.  If 'follow' is true, will
     * travel up the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see Entity#getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
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
     * @see Entity#getRequiredAttributes(boolean follow, boolean withIdentifiers)
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
     * @see Entity#getRequiredProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection getRequiredProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredProperties(follow, withIdentifiers);
    }

    /**
     * Creates a comma separated list of the required property names.
     * @see Entity#getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredPropertyNameList(follow, withIdentifiers);
    }

    /**
     * A comma separated list of the required property types.
     * @see Entity#getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getRequiredPropertyTypeList(follow, withIdentifiers);
    }

    /**
     * The name of the schema that contains the database table
     * @see Entity#getSchema()
     */
    public String getSchema()
    {
        return this.getSuperManageableEntity().getSchema();
    }

    /**
     * The name of the database table to which this entity is persisted.
     * @see Entity#getTableName()
     */
    public String getTableName()
    {
        return this.getSuperManageableEntity().getTableName();
    }

    /**
     * Returns true/false depending on whether or not this entity represetns a child in an
     * association (this occurs when this entity is on the opposite end of an assocation end defined
     * as composite).
     * @see Entity#isChild()
     */
    public boolean isChild()
    {
        return this.getSuperManageableEntity().isChild();
    }

    /**
     * 
     * @see Entity#isCompositeIdentifier()
     */
    public boolean isCompositeIdentifier()
    {
        return this.getSuperManageableEntity().isCompositeIdentifier();
    }

    /**
     * True if the entity has its identifiers dynamically added, false otherwise.
     * @see Entity#isDynamicIdentifiersPresent()
     */
    public boolean isDynamicIdentifiersPresent()
    {
        return this.getSuperManageableEntity().isDynamicIdentifiersPresent();
    }

    /**
     * True if the entity has any identifiers defined, false otherwise.
     * @see Entity#isIdentifiersPresent()
     */
    public boolean isIdentifiersPresent()
    {
        return this.getSuperManageableEntity().isIdentifiersPresent();
    }

    /**
     * Indiciates if this entity is using an assigned identifier or not.
     * @see Entity#isUsingAssignedIdentifier()
     */
    public boolean isUsingAssignedIdentifier()
    {
        return this.getSuperManageableEntity().isUsingAssignedIdentifier();
    }

    /**
     * Indicates whether or not this entity is using a foreign identifier as its identifiers.  That
     * is: the foreignIdentifier flag was set on an incoming association end and the entity is
     * therefore using the related foreign parent entity's identifier.
     * @see Entity#isUsingForeignIdentifier()
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
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperManageableEntity().initialize();
    }

    /**
     * @return Object getSuperManageableEntity().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperManageableEntity().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperManageableEntity().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperManageableEntity().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A versionable entity must have a versionable entity dependency</p>
     * <p><b>Error:</b> A versionable entity must have a versinable entity dependency. Model a dependency between this entity and an other, stereotyped with VersionableRef.</p>
     * <p><b>OCL:</b> context GuiManageableEntity
inv: (versionable = true) implies (versionableRefExists = true)</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntity::Criterias search value object constraint</p>
     * <p><b>Error:</b> If a manageable entity has references to a RulesSearchData stereotyped entity, then a criterias search value object with stereotype RulesCriteriasSearchData must exist in the model.</p>
     * <p><b>OCL:</b> context GuiManageableEntity
inv: rulesSearchData->notEmpty() implies rulesCriteriasSearchValueObject->notEmpty()</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntity::Each business object reference (dependency) must have a correct discriminator name.</p>
     * <p><b>Error:</b> Each business object reference (dependency) must have a correct discriminator name. It must be the name of an attribute or an association end of the source entity.The target element (Entity) must also have a dedicated Value Object.</p>
     * <p><b>OCL:</b> context GuiManageableEntity
inv: eachBusinessObjectReferenceIsValid()</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A manageable entity service defined must have a valid name</p>
     * <p><b>Error:</b> The service specified that will be attached to the manageable entity must be valid (exist and correct name). More over, each Manageable Entity must be attached to a Service. Model this by modeling a dependency between them (Service is source), and giving the 'true' value to @andromda.service.manageable tagged value. You can also specify it by filling service name tagged value on the manageable entity.</p>
     * <p><b>OCL:</b> -- context GuiManageableEntity inv:manageableServiceName->notEmpty()</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A manageable entity with show deal use case activated must provide all info</p>
     * <p><b>Error:</b> A manageable entity with show deal use case activated must provide 2 attributes with tagged values corresponding to deal type and deal id</p>
     * <p><b>OCL:</b> -- context GuiManageableEntity inv: hasCorrectShowDealInfo()</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperManageableEntity().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf((OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"versionable"),true)))).booleanValue()?(OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"versionableRefExists"),true)):true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A versionable entity must have a versionable entity dependency",
                        "A versionable entity must have a versinable entity dependency. Model a dependency between this entity and an other, stereotyped with VersionableRef."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A versionable entity must have a versionable entity dependency' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"rulesSearchData")))).booleanValue()?OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"rulesCriteriasSearchValueObject")):true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntity::Criterias search value object constraint",
                        "If a manageable entity has references to a RulesSearchData stereotyped entity, then a criterias search value object with stereotype RulesCriteriasSearchData must exist in the model."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntity::Criterias search value object constraint' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure(OCLIntrospector.invoke(contextElement,"eachBusinessObjectReferenceIsValid()"));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntity::Each business object reference (dependency) must have a correct discriminator name.",
                        "Each business object reference (dependency) must have a correct discriminator name. It must be the name of an attribute or an association end of the source entity.The target element (Entity) must also have a dedicated Value Object."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntity::Each business object reference (dependency) must have a correct discriminator name.' ON "
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
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A manageable entity service defined must have a valid name",
                        "The service specified that will be attached to the manageable entity must be valid (exist and correct name). More over, each Manageable Entity must be attached to a Service. Model this by modeling a dependency between them (Service is source), and giving the 'true' value to @andromda.service.manageable tagged value. You can also specify it by filling service name tagged value on the manageable entity."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A manageable entity service defined must have a valid name' ON "
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
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A manageable entity with show deal use case activated must provide all info",
                        "A manageable entity with show deal use case activated must provide 2 attributes with tagged values corresponding to deal type and deal id"));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntity::A manageable entity with show deal use case activated must provide all info' ON "
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