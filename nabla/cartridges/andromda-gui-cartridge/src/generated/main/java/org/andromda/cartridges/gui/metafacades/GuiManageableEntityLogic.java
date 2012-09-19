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
    protected GuiManageableEntityLogic(final Object metaObjectIn, String context)
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
    private static final Logger LOGGER = Logger.getLogger(GuiManageableEntityLogic.class);

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

    private String pageName1a;
    private boolean pageName1aSet = false;

    /**
     * 
     * @return (String)handleGetPageName()
     */
    public final String getPageName()
    {
        String apageName1a = this.pageName1a;
        if (!this.pageName1aSet)
        {
            // pageName has no pre constraints
            apageName1a = handleGetPageName();
            // pageName has no post constraints
            this.pageName1a = apageName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.pageName1aSet = true;
            }
        }
        return apageName1a;
    }

   /**
    * @see GuiManageableEntity#getPageFullPath()
    * @return String
    */
    protected abstract String handleGetPageFullPath();

    private String pageFullPath2a;
    private boolean pageFullPath2aSet = false;

    /**
     * 
     * @return (String)handleGetPageFullPath()
     */
    public final String getPageFullPath()
    {
        String apageFullPath2a = this.pageFullPath2a;
        if (!this.pageFullPath2aSet)
        {
            // pageFullPath has no pre constraints
            apageFullPath2a = handleGetPageFullPath();
            // pageFullPath has no post constraints
            this.pageFullPath2a = apageFullPath2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.pageFullPath2aSet = true;
            }
        }
        return apageFullPath2a;
    }

   /**
    * @see GuiManageableEntity#getPageTitleKey()
    * @return String
    */
    protected abstract String handleGetPageTitleKey();

    private String pageTitleKey3a;
    private boolean pageTitleKey3aSet = false;

    /**
     * 
     * @return (String)handleGetPageTitleKey()
     */
    public final String getPageTitleKey()
    {
        String apageTitleKey3a = this.pageTitleKey3a;
        if (!this.pageTitleKey3aSet)
        {
            // pageTitleKey has no pre constraints
            apageTitleKey3a = handleGetPageTitleKey();
            // pageTitleKey has no post constraints
            this.pageTitleKey3a = apageTitleKey3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.pageTitleKey3aSet = true;
            }
        }
        return apageTitleKey3a;
    }

   /**
    * @see GuiManageableEntity#getPageTitleValue()
    * @return String
    */
    protected abstract String handleGetPageTitleValue();

    private String pageTitleValue4a;
    private boolean pageTitleValue4aSet = false;

    /**
     * 
     * @return (String)handleGetPageTitleValue()
     */
    public final String getPageTitleValue()
    {
        String apageTitleValue4a = this.pageTitleValue4a;
        if (!this.pageTitleValue4aSet)
        {
            // pageTitleValue has no pre constraints
            apageTitleValue4a = handleGetPageTitleValue();
            // pageTitleValue has no post constraints
            this.pageTitleValue4a = apageTitleValue4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.pageTitleValue4aSet = true;
            }
        }
        return apageTitleValue4a;
    }

   /**
    * @see GuiManageableEntity#getListName()
    * @return String
    */
    protected abstract String handleGetListName();

    private String listName5a;
    private boolean listName5aSet = false;

    /**
     * 
     * @return (String)handleGetListName()
     */
    public final String getListName()
    {
        String alistName5a = this.listName5a;
        if (!this.listName5aSet)
        {
            // listName has no pre constraints
            alistName5a = handleGetListName();
            // listName has no post constraints
            this.listName5a = alistName5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.listName5aSet = true;
            }
        }
        return alistName5a;
    }

   /**
    * @see GuiManageableEntity#getExceptionKey()
    * @return String
    */
    protected abstract String handleGetExceptionKey();

    private String exceptionKey6a;
    private boolean exceptionKey6aSet = false;

    /**
     * 
     * @return (String)handleGetExceptionKey()
     */
    public final String getExceptionKey()
    {
        String aexceptionKey6a = this.exceptionKey6a;
        if (!this.exceptionKey6aSet)
        {
            // exceptionKey has no pre constraints
            aexceptionKey6a = handleGetExceptionKey();
            // exceptionKey has no post constraints
            this.exceptionKey6a = aexceptionKey6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.exceptionKey6aSet = true;
            }
        }
        return aexceptionKey6a;
    }

   /**
    * @see GuiManageableEntity#getActionType()
    * @return String
    */
    protected abstract String handleGetActionType();

    private String actionType7a;
    private boolean actionType7aSet = false;

    /**
     * 
     * @return (String)handleGetActionType()
     */
    public final String getActionType()
    {
        String aactionType7a = this.actionType7a;
        if (!this.actionType7aSet)
        {
            // actionType has no pre constraints
            aactionType7a = handleGetActionType();
            // actionType has no post constraints
            this.actionType7a = aactionType7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionType7aSet = true;
            }
        }
        return aactionType7a;
    }

   /**
    * @see GuiManageableEntity#getActionFullPath()
    * @return String
    */
    protected abstract String handleGetActionFullPath();

    private String actionFullPath8a;
    private boolean actionFullPath8aSet = false;

    /**
     * 
     * @return (String)handleGetActionFullPath()
     */
    public final String getActionFullPath()
    {
        String aactionFullPath8a = this.actionFullPath8a;
        if (!this.actionFullPath8aSet)
        {
            // actionFullPath has no pre constraints
            aactionFullPath8a = handleGetActionFullPath();
            // actionFullPath has no post constraints
            this.actionFullPath8a = aactionFullPath8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionFullPath8aSet = true;
            }
        }
        return aactionFullPath8a;
    }

   /**
    * @see GuiManageableEntity#getActionPath()
    * @return String
    */
    protected abstract String handleGetActionPath();

    private String actionPath9a;
    private boolean actionPath9aSet = false;

    /**
     * 
     * @return (String)handleGetActionPath()
     */
    public final String getActionPath()
    {
        String aactionPath9a = this.actionPath9a;
        if (!this.actionPath9aSet)
        {
            // actionPath has no pre constraints
            aactionPath9a = handleGetActionPath();
            // actionPath has no post constraints
            this.actionPath9a = aactionPath9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionPath9aSet = true;
            }
        }
        return aactionPath9a;
    }

   /**
    * @see GuiManageableEntity#getActionClassName()
    * @return String
    */
    protected abstract String handleGetActionClassName();

    private String actionClassName10a;
    private boolean actionClassName10aSet = false;

    /**
     * 
     * @return (String)handleGetActionClassName()
     */
    public final String getActionClassName()
    {
        String aactionClassName10a = this.actionClassName10a;
        if (!this.actionClassName10aSet)
        {
            // actionClassName has no pre constraints
            aactionClassName10a = handleGetActionClassName();
            // actionClassName has no post constraints
            this.actionClassName10a = aactionClassName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionClassName10aSet = true;
            }
        }
        return aactionClassName10a;
    }

   /**
    * @see GuiManageableEntity#getExceptionPath()
    * @return String
    */
    protected abstract String handleGetExceptionPath();

    private String exceptionPath11a;
    private boolean exceptionPath11aSet = false;

    /**
     * 
     * @return (String)handleGetExceptionPath()
     */
    public final String getExceptionPath()
    {
        String aexceptionPath11a = this.exceptionPath11a;
        if (!this.exceptionPath11aSet)
        {
            // exceptionPath has no pre constraints
            aexceptionPath11a = handleGetExceptionPath();
            // exceptionPath has no post constraints
            this.exceptionPath11a = aexceptionPath11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.exceptionPath11aSet = true;
            }
        }
        return aexceptionPath11a;
    }

   /**
    * @see GuiManageableEntity#getListGetterName()
    * @return String
    */
    protected abstract String handleGetListGetterName();

    private String listGetterName12a;
    private boolean listGetterName12aSet = false;

    /**
     * 
     * @return (String)handleGetListGetterName()
     */
    public final String getListGetterName()
    {
        String alistGetterName12a = this.listGetterName12a;
        if (!this.listGetterName12aSet)
        {
            // listGetterName has no pre constraints
            alistGetterName12a = handleGetListGetterName();
            // listGetterName has no post constraints
            this.listGetterName12a = alistGetterName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.listGetterName12aSet = true;
            }
        }
        return alistGetterName12a;
    }

   /**
    * @see GuiManageableEntity#getListSetterName()
    * @return String
    */
    protected abstract String handleGetListSetterName();

    private String listSetterName13a;
    private boolean listSetterName13aSet = false;

    /**
     * 
     * @return (String)handleGetListSetterName()
     */
    public final String getListSetterName()
    {
        String alistSetterName13a = this.listSetterName13a;
        if (!this.listSetterName13aSet)
        {
            // listSetterName has no pre constraints
            alistSetterName13a = handleGetListSetterName();
            // listSetterName has no post constraints
            this.listSetterName13a = alistSetterName13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.listSetterName13aSet = true;
            }
        }
        return alistSetterName13a;
    }

   /**
    * @see GuiManageableEntity#getActionParameter()
    * @return String
    */
    protected abstract String handleGetActionParameter();

    private String actionParameter14a;
    private boolean actionParameter14aSet = false;

    /**
     * 
     * @return (String)handleGetActionParameter()
     */
    public final String getActionParameter()
    {
        String aactionParameter14a = this.actionParameter14a;
        if (!this.actionParameter14aSet)
        {
            // actionParameter has no pre constraints
            aactionParameter14a = handleGetActionParameter();
            // actionParameter has no post constraints
            this.actionParameter14a = aactionParameter14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionParameter14aSet = true;
            }
        }
        return aactionParameter14a;
    }

   /**
    * @see GuiManageableEntity#isTableExportable()
    * @return boolean
    */
    protected abstract boolean handleIsTableExportable();

    private boolean tableExportable15a;
    private boolean tableExportable15aSet = false;

    /**
     * True if it is possible to export the table data to XML, CSV, PDF or Excel format.
     * @return (boolean)handleIsTableExportable()
     */
    public final boolean isTableExportable()
    {
        boolean atableExportable15a = this.tableExportable15a;
        if (!this.tableExportable15aSet)
        {
            // tableExportable has no pre constraints
            atableExportable15a = handleIsTableExportable();
            // tableExportable has no post constraints
            this.tableExportable15a = atableExportable15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableExportable15aSet = true;
            }
        }
        return atableExportable15a;
    }

   /**
    * @see GuiManageableEntity#getTableExportTypes()
    * @return String
    */
    protected abstract String handleGetTableExportTypes();

    private String tableExportTypes16a;
    private boolean tableExportTypes16aSet = false;

    /**
     * Tthe available types of export in a single String instance.
     * @return (String)handleGetTableExportTypes()
     */
    public final String getTableExportTypes()
    {
        String atableExportTypes16a = this.tableExportTypes16a;
        if (!this.tableExportTypes16aSet)
        {
            // tableExportTypes has no pre constraints
            atableExportTypes16a = handleGetTableExportTypes();
            // tableExportTypes has no post constraints
            this.tableExportTypes16a = atableExportTypes16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableExportTypes16aSet = true;
            }
        }
        return atableExportTypes16a;
    }

   /**
    * @see GuiManageableEntity#getTableMaxRows()
    * @return int
    */
    protected abstract int handleGetTableMaxRows();

    private int tableMaxRows17a;
    private boolean tableMaxRows17aSet = false;

    /**
     * The maximum number of rows to be displayed in the table at the same time. This is also known
     * as the page size. A value of zero or less will display all data in the same table (therefore
     * also on the same page).
     * @return (int)handleGetTableMaxRows()
     */
    public final int getTableMaxRows()
    {
        int atableMaxRows17a = this.tableMaxRows17a;
        if (!this.tableMaxRows17aSet)
        {
            // tableMaxRows has no pre constraints
            atableMaxRows17a = handleGetTableMaxRows();
            // tableMaxRows has no post constraints
            this.tableMaxRows17a = atableMaxRows17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableMaxRows17aSet = true;
            }
        }
        return atableMaxRows17a;
    }

   /**
    * @see GuiManageableEntity#isTableSortable()
    * @return boolean
    */
    protected abstract boolean handleIsTableSortable();

    private boolean tableSortable18a;
    private boolean tableSortable18aSet = false;

    /**
     * True if it is possible to sort the columns of the table.
     * @return (boolean)handleIsTableSortable()
     */
    public final boolean isTableSortable()
    {
        boolean atableSortable18a = this.tableSortable18a;
        if (!this.tableSortable18aSet)
        {
            // tableSortable has no pre constraints
            atableSortable18a = handleIsTableSortable();
            // tableSortable has no post constraints
            this.tableSortable18a = atableSortable18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableSortable18aSet = true;
            }
        }
        return atableSortable18a;
    }

   /**
    * @see GuiManageableEntity#isMultipartFormData()
    * @return boolean
    */
    protected abstract boolean handleIsMultipartFormData();

    private boolean multipartFormData19a;
    private boolean multipartFormData19aSet = false;

    /**
     * True is this action is supposed to be rendered as enctype="multipart/form-data" on the page
     * form.
     * @return (boolean)handleIsMultipartFormData()
     */
    public final boolean isMultipartFormData()
    {
        boolean amultipartFormData19a = this.multipartFormData19a;
        if (!this.multipartFormData19aSet)
        {
            // multipartFormData has no pre constraints
            amultipartFormData19a = handleIsMultipartFormData();
            // multipartFormData has no post constraints
            this.multipartFormData19a = amultipartFormData19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.multipartFormData19aSet = true;
            }
        }
        return amultipartFormData19a;
    }

   /**
    * @see GuiManageableEntity#getPreconditions()
    * @return Collection
    */
    protected abstract Collection handleGetPreconditions();

    private Collection preconditions20a;
    private boolean preconditions20aSet = false;

    /**
     * 
     * @return (Collection)handleGetPreconditions()
     */
    public final Collection getPreconditions()
    {
        Collection apreconditions20a = this.preconditions20a;
        if (!this.preconditions20aSet)
        {
            // preconditions has no pre constraints
            apreconditions20a = handleGetPreconditions();
            // preconditions has no post constraints
            this.preconditions20a = apreconditions20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.preconditions20aSet = true;
            }
        }
        return apreconditions20a;
    }

   /**
    * @see GuiManageableEntity#getCreatePreconditions()
    * @return Collection
    */
    protected abstract Collection handleGetCreatePreconditions();

    private Collection createPreconditions21a;
    private boolean createPreconditions21aSet = false;

    /**
     * 
     * @return (Collection)handleGetCreatePreconditions()
     */
    public final Collection getCreatePreconditions()
    {
        Collection acreatePreconditions21a = this.createPreconditions21a;
        if (!this.createPreconditions21aSet)
        {
            // createPreconditions has no pre constraints
            acreatePreconditions21a = handleGetCreatePreconditions();
            // createPreconditions has no post constraints
            this.createPreconditions21a = acreatePreconditions21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.createPreconditions21aSet = true;
            }
        }
        return acreatePreconditions21a;
    }

   /**
    * @see GuiManageableEntity#getUpdatePreconditions()
    * @return Collection
    */
    protected abstract Collection handleGetUpdatePreconditions();

    private Collection updatePreconditions22a;
    private boolean updatePreconditions22aSet = false;

    /**
     * 
     * @return (Collection)handleGetUpdatePreconditions()
     */
    public final Collection getUpdatePreconditions()
    {
        Collection aupdatePreconditions22a = this.updatePreconditions22a;
        if (!this.updatePreconditions22aSet)
        {
            // updatePreconditions has no pre constraints
            aupdatePreconditions22a = handleGetUpdatePreconditions();
            // updatePreconditions has no post constraints
            this.updatePreconditions22a = aupdatePreconditions22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.updatePreconditions22aSet = true;
            }
        }
        return aupdatePreconditions22a;
    }

   /**
    * @see GuiManageableEntity#getDeletePreconditions()
    * @return Collection
    */
    protected abstract Collection handleGetDeletePreconditions();

    private Collection deletePreconditions23a;
    private boolean deletePreconditions23aSet = false;

    /**
     * 
     * @return (Collection)handleGetDeletePreconditions()
     */
    public final Collection getDeletePreconditions()
    {
        Collection adeletePreconditions23a = this.deletePreconditions23a;
        if (!this.deletePreconditions23aSet)
        {
            // deletePreconditions has no pre constraints
            adeletePreconditions23a = handleGetDeletePreconditions();
            // deletePreconditions has no post constraints
            this.deletePreconditions23a = adeletePreconditions23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.deletePreconditions23aSet = true;
            }
        }
        return adeletePreconditions23a;
    }

   /**
    * @see GuiManageableEntity#isRegroupMandatoryFields()
    * @return boolean
    */
    protected abstract boolean handleIsRegroupMandatoryFields();

    private boolean regroupMandatoryFields24a;
    private boolean regroupMandatoryFields24aSet = false;

    /**
     * 
     * @return (boolean)handleIsRegroupMandatoryFields()
     */
    public final boolean isRegroupMandatoryFields()
    {
        boolean aregroupMandatoryFields24a = this.regroupMandatoryFields24a;
        if (!this.regroupMandatoryFields24aSet)
        {
            // regroupMandatoryFields has no pre constraints
            aregroupMandatoryFields24a = handleIsRegroupMandatoryFields();
            // regroupMandatoryFields has no post constraints
            this.regroupMandatoryFields24a = aregroupMandatoryFields24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.regroupMandatoryFields24aSet = true;
            }
        }
        return aregroupMandatoryFields24a;
    }

   /**
    * @see GuiManageableEntity#getDisplayName()
    * @return String
    */
    protected abstract String handleGetDisplayName();

    private String displayName25a;
    private boolean displayName25aSet = false;

    /**
     * 
     * @return (String)handleGetDisplayName()
     */
    public final String getDisplayName()
    {
        String adisplayName25a = this.displayName25a;
        if (!this.displayName25aSet)
        {
            // displayName has no pre constraints
            adisplayName25a = handleGetDisplayName();
            // displayName has no post constraints
            this.displayName25a = adisplayName25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.displayName25aSet = true;
            }
        }
        return adisplayName25a;
    }

   /**
    * @see GuiManageableEntity#isVersionable()
    * @return boolean
    */
    protected abstract boolean handleIsVersionable();

    private boolean versionable26a;
    private boolean versionable26aSet = false;

    /**
     * True if the manageable entity carries Versionable stereotype (Versionable object)
     * @return (boolean)handleIsVersionable()
     */
    public final boolean isVersionable()
    {
        boolean aversionable26a = this.versionable26a;
        if (!this.versionable26aSet)
        {
            // versionable has no pre constraints
            aversionable26a = handleIsVersionable();
            // versionable has no post constraints
            this.versionable26a = aversionable26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.versionable26aSet = true;
            }
        }
        return aversionable26a;
    }

   /**
    * @see GuiManageableEntity#isVersionableRefExists()
    * @return boolean
    */
    protected abstract boolean handleIsVersionableRefExists();

    private boolean versionableRefExists27a;
    private boolean versionableRefExists27aSet = false;

    /**
     * 
     * @return (boolean)handleIsVersionableRefExists()
     */
    public final boolean isVersionableRefExists()
    {
        boolean aversionableRefExists27a = this.versionableRefExists27a;
        if (!this.versionableRefExists27aSet)
        {
            // versionableRefExists has no pre constraints
            aversionableRefExists27a = handleIsVersionableRefExists();
            // versionableRefExists has no post constraints
            this.versionableRefExists27a = aversionableRefExists27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.versionableRefExists27aSet = true;
            }
        }
        return aversionableRefExists27a;
    }

   /**
    * @see GuiManageableEntity#getRulesSearchData()
    * @return Collection
    */
    protected abstract Collection handleGetRulesSearchData();

    private Collection rulesSearchData28a;
    private boolean rulesSearchData28aSet = false;

    /**
     * To retrieve all associations which end is a RulesSearchData stereotyped class.
     * @return (Collection)handleGetRulesSearchData()
     */
    public final Collection getRulesSearchData()
    {
        Collection arulesSearchData28a = this.rulesSearchData28a;
        if (!this.rulesSearchData28aSet)
        {
            // rulesSearchData has no pre constraints
            arulesSearchData28a = handleGetRulesSearchData();
            // rulesSearchData has no post constraints
            this.rulesSearchData28a = arulesSearchData28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.rulesSearchData28aSet = true;
            }
        }
        return arulesSearchData28a;
    }

   /**
    * @see GuiManageableEntity#getRulesCriteriasSearchValueObject()
    * @return ClassifierFacade
    */
    protected abstract ClassifierFacade handleGetRulesCriteriasSearchValueObject();

    private ClassifierFacade rulesCriteriasSearchValueObject29a;
    private boolean rulesCriteriasSearchValueObject29aSet = false;

    /**
     * To retrieve corresponding criterias search data represented by a typical value object
     * @return (ClassifierFacade)handleGetRulesCriteriasSearchValueObject()
     */
    public final ClassifierFacade getRulesCriteriasSearchValueObject()
    {
        ClassifierFacade arulesCriteriasSearchValueObject29a = this.rulesCriteriasSearchValueObject29a;
        if (!this.rulesCriteriasSearchValueObject29aSet)
        {
            // rulesCriteriasSearchValueObject has no pre constraints
            arulesCriteriasSearchValueObject29a = handleGetRulesCriteriasSearchValueObject();
            // rulesCriteriasSearchValueObject has no post constraints
            this.rulesCriteriasSearchValueObject29a = arulesCriteriasSearchValueObject29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.rulesCriteriasSearchValueObject29aSet = true;
            }
        }
        return arulesCriteriasSearchValueObject29a;
    }

   /**
    * @see GuiManageableEntity#isInsertable()
    * @return boolean
    */
    protected abstract boolean handleIsInsertable();

    private boolean insertable30a;
    private boolean insertable30aSet = false;

    /**
     * 
     * @return (boolean)handleIsInsertable()
     */
    public final boolean isInsertable()
    {
        boolean ainsertable30a = this.insertable30a;
        if (!this.insertable30aSet)
        {
            // insertable has no pre constraints
            ainsertable30a = handleIsInsertable();
            // insertable has no post constraints
            this.insertable30a = ainsertable30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.insertable30aSet = true;
            }
        }
        return ainsertable30a;
    }

   /**
    * @see GuiManageableEntity#isUpdatable()
    * @return boolean
    */
    protected abstract boolean handleIsUpdatable();

    private boolean updatable31a;
    private boolean updatable31aSet = false;

    /**
     * 
     * @return (boolean)handleIsUpdatable()
     */
    public final boolean isUpdatable()
    {
        boolean aupdatable31a = this.updatable31a;
        if (!this.updatable31aSet)
        {
            // updatable has no pre constraints
            aupdatable31a = handleIsUpdatable();
            // updatable has no post constraints
            this.updatable31a = aupdatable31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.updatable31aSet = true;
            }
        }
        return aupdatable31a;
    }

   /**
    * @see GuiManageableEntity#isRemovable()
    * @return boolean
    */
    protected abstract boolean handleIsRemovable();

    private boolean removable32a;
    private boolean removable32aSet = false;

    /**
     * 
     * @return (boolean)handleIsRemovable()
     */
    public final boolean isRemovable()
    {
        boolean aremovable32a = this.removable32a;
        if (!this.removable32aSet)
        {
            // removable has no pre constraints
            aremovable32a = handleIsRemovable();
            // removable has no post constraints
            this.removable32a = aremovable32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.removable32aSet = true;
            }
        }
        return aremovable32a;
    }

   /**
    * @see GuiManageableEntity#isFiltered()
    * @return boolean
    */
    protected abstract boolean handleIsFiltered();

    private boolean filtered33a;
    private boolean filtered33aSet = false;

    /**
     * True if the Manageable Entity has at least one filter element (attribute or association).
     * Simple filter feature, for Rules
     * @return (boolean)handleIsFiltered()
     */
    public final boolean isFiltered()
    {
        boolean afiltered33a = this.filtered33a;
        if (!this.filtered33aSet)
        {
            // filtered has no pre constraints
            afiltered33a = handleIsFiltered();
            // filtered has no post constraints
            this.filtered33a = afiltered33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.filtered33aSet = true;
            }
        }
        return afiltered33a;
    }

   /**
    * @see GuiManageableEntity#isPopEdition()
    * @return boolean
    */
    protected abstract boolean handleIsPopEdition();

    private boolean popEdition34a;
    private boolean popEdition34aSet = false;

    /**
     * Defines whether or not the manageable entity edition form will be displayed in a pop-up
     * @return (boolean)handleIsPopEdition()
     */
    public final boolean isPopEdition()
    {
        boolean apopEdition34a = this.popEdition34a;
        if (!this.popEdition34aSet)
        {
            // popEdition has no pre constraints
            apopEdition34a = handleIsPopEdition();
            // popEdition has no post constraints
            this.popEdition34a = apopEdition34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.popEdition34aSet = true;
            }
        }
        return apopEdition34a;
    }

   /**
    * @see GuiManageableEntity#isExportable()
    * @return boolean
    */
    protected abstract boolean handleIsExportable();

    private boolean exportable35a;
    private boolean exportable35aSet = false;

    /**
     * 
     * @return (boolean)handleIsExportable()
     */
    public final boolean isExportable()
    {
        boolean aexportable35a = this.exportable35a;
        if (!this.exportable35aSet)
        {
            // exportable has no pre constraints
            aexportable35a = handleIsExportable();
            // exportable has no post constraints
            this.exportable35a = aexportable35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.exportable35aSet = true;
            }
        }
        return aexportable35a;
    }

   /**
    * @see GuiManageableEntity#isClonable()
    * @return boolean
    */
    protected abstract boolean handleIsClonable();

    private boolean clonable36a;
    private boolean clonable36aSet = false;

    /**
     * 
     * @return (boolean)handleIsClonable()
     */
    public final boolean isClonable()
    {
        boolean aclonable36a = this.clonable36a;
        if (!this.clonable36aSet)
        {
            // clonable has no pre constraints
            aclonable36a = handleIsClonable();
            // clonable has no post constraints
            this.clonable36a = aclonable36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.clonable36aSet = true;
            }
        }
        return aclonable36a;
    }

   /**
    * @see GuiManageableEntity#isSortable()
    * @return boolean
    */
    protected abstract boolean handleIsSortable();

    private boolean sortable37a;
    private boolean sortable37aSet = false;

    /**
     * 
     * @return (boolean)handleIsSortable()
     */
    public final boolean isSortable()
    {
        boolean asortable37a = this.sortable37a;
        if (!this.sortable37aSet)
        {
            // sortable has no pre constraints
            asortable37a = handleIsSortable();
            // sortable has no post constraints
            this.sortable37a = asortable37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.sortable37aSet = true;
            }
        }
        return asortable37a;
    }

   /**
    * @see GuiManageableEntity#isHasHelp()
    * @return boolean
    */
    protected abstract boolean handleIsHasHelp();

    private boolean hasHelp38a;
    private boolean hasHelp38aSet = false;

    /**
     * 
     * @return (boolean)handleIsHasHelp()
     */
    public final boolean isHasHelp()
    {
        boolean ahasHelp38a = this.hasHelp38a;
        if (!this.hasHelp38aSet)
        {
            // hasHelp has no pre constraints
            ahasHelp38a = handleIsHasHelp();
            // hasHelp has no post constraints
            this.hasHelp38a = ahasHelp38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hasHelp38aSet = true;
            }
        }
        return ahasHelp38a;
    }

   /**
    * @see GuiManageableEntity#isFilterable()
    * @return boolean
    */
    protected abstract boolean handleIsFilterable();

    private boolean filterable39a;
    private boolean filterable39aSet = false;

    /**
     * Defines whether or not the manageable entity is filterable (advanced search)
     * @return (boolean)handleIsFilterable()
     */
    public final boolean isFilterable()
    {
        boolean afilterable39a = this.filterable39a;
        if (!this.filterable39aSet)
        {
            // filterable has no pre constraints
            afilterable39a = handleIsFilterable();
            // filterable has no post constraints
            this.filterable39a = afilterable39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.filterable39aSet = true;
            }
        }
        return afilterable39a;
    }

   /**
    * @see GuiManageableEntity#isHasCustom()
    * @return boolean
    */
    protected abstract boolean handleIsHasCustom();

    private boolean hasCustom40a;
    private boolean hasCustom40aSet = false;

    /**
     * True if the Manageable Entity has children that must be handled. Usefull for Rules.
     * @return (boolean)handleIsHasCustom()
     */
    public final boolean isHasCustom()
    {
        boolean ahasCustom40a = this.hasCustom40a;
        if (!this.hasCustom40aSet)
        {
            // hasCustom has no pre constraints
            ahasCustom40a = handleIsHasCustom();
            // hasCustom has no post constraints
            this.hasCustom40a = ahasCustom40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hasCustom40aSet = true;
            }
        }
        return ahasCustom40a;
    }

   /**
    * @see GuiManageableEntity#isIsCustom()
    * @return boolean
    */
    protected abstract boolean handleIsIsCustom();

    private boolean isCustom41a;
    private boolean isCustom41aSet = false;

    /**
     * True if it is a custom manageable. In this case, it is related to another Manageable, and it
     * won't be a stand-alone Mask.
     * @return (boolean)handleIsIsCustom()
     */
    public final boolean isIsCustom()
    {
        boolean aisCustom41a = this.isCustom41a;
        if (!this.isCustom41aSet)
        {
            // isCustom has no pre constraints
            aisCustom41a = handleIsIsCustom();
            // isCustom has no post constraints
            this.isCustom41a = aisCustom41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.isCustom41aSet = true;
            }
        }
        return aisCustom41a;
    }

   /**
    * @see GuiManageableEntity#isEditable()
    * @return boolean
    */
    protected abstract boolean handleIsEditable();

    private boolean editable42a;
    private boolean editable42aSet = false;

    /**
     * 
     * @return (boolean)handleIsEditable()
     */
    public final boolean isEditable()
    {
        boolean aeditable42a = this.editable42a;
        if (!this.editable42aSet)
        {
            // editable has no pre constraints
            aeditable42a = handleIsEditable();
            // editable has no post constraints
            this.editable42a = aeditable42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.editable42aSet = true;
            }
        }
        return aeditable42a;
    }

   /**
    * @see GuiManageableEntity#isHasMaximumListSize()
    * @return boolean
    */
    protected abstract boolean handleIsHasMaximumListSize();

    private boolean hasMaximumListSize43a;
    private boolean hasMaximumListSize43aSet = false;

    /**
     * 
     * @return (boolean)handleIsHasMaximumListSize()
     */
    public final boolean isHasMaximumListSize()
    {
        boolean ahasMaximumListSize43a = this.hasMaximumListSize43a;
        if (!this.hasMaximumListSize43aSet)
        {
            // hasMaximumListSize has no pre constraints
            ahasMaximumListSize43a = handleIsHasMaximumListSize();
            // hasMaximumListSize has no post constraints
            this.hasMaximumListSize43a = ahasMaximumListSize43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hasMaximumListSize43aSet = true;
            }
        }
        return ahasMaximumListSize43a;
    }

   /**
    * @see GuiManageableEntity#getSecurityName()
    * @return String
    */
    protected abstract String handleGetSecurityName();

    private String securityName44a;
    private boolean securityName44aSet = false;

    /**
     * 
     * @return (String)handleGetSecurityName()
     */
    public final String getSecurityName()
    {
        String asecurityName44a = this.securityName44a;
        if (!this.securityName44aSet)
        {
            // securityName has no pre constraints
            asecurityName44a = handleGetSecurityName();
            // securityName has no post constraints
            this.securityName44a = asecurityName44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.securityName44aSet = true;
            }
        }
        return asecurityName44a;
    }

   /**
    * @see GuiManageableEntity#isFilterLoadingShortcut()
    * @return boolean
    */
    protected abstract boolean handleIsFilterLoadingShortcut();

    private boolean filterLoadingShortcut45a;
    private boolean filterLoadingShortcut45aSet = false;

    /**
     * 
     * @return (boolean)handleIsFilterLoadingShortcut()
     */
    public final boolean isFilterLoadingShortcut()
    {
        boolean afilterLoadingShortcut45a = this.filterLoadingShortcut45a;
        if (!this.filterLoadingShortcut45aSet)
        {
            // filterLoadingShortcut has no pre constraints
            afilterLoadingShortcut45a = handleIsFilterLoadingShortcut();
            // filterLoadingShortcut has no post constraints
            this.filterLoadingShortcut45a = afilterLoadingShortcut45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.filterLoadingShortcut45aSet = true;
            }
        }
        return afilterLoadingShortcut45a;
    }

   /**
    * @see GuiManageableEntity#getEjbInterfaceName()
    * @return String
    */
    protected abstract String handleGetEjbInterfaceName();

    private String ejbInterfaceName46a;
    private boolean ejbInterfaceName46aSet = false;

    /**
     * 
     * @return (String)handleGetEjbInterfaceName()
     */
    public final String getEjbInterfaceName()
    {
        String aejbInterfaceName46a = this.ejbInterfaceName46a;
        if (!this.ejbInterfaceName46aSet)
        {
            // ejbInterfaceName has no pre constraints
            aejbInterfaceName46a = handleGetEjbInterfaceName();
            // ejbInterfaceName has no post constraints
            this.ejbInterfaceName46a = aejbInterfaceName46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.ejbInterfaceName46aSet = true;
            }
        }
        return aejbInterfaceName46a;
    }

   /**
    * @see GuiManageableEntity#isHasCustomSorters()
    * @return boolean
    */
    protected abstract boolean handleIsHasCustomSorters();

    private boolean hasCustomSorters47a;
    private boolean hasCustomSorters47aSet = false;

    /**
     * Returns true if tagged value associated to custom sorters (K+TP Rule entity) is set to true
     * for Manageable Entity.
     * @return (boolean)handleIsHasCustomSorters()
     */
    public final boolean isHasCustomSorters()
    {
        boolean ahasCustomSorters47a = this.hasCustomSorters47a;
        if (!this.hasCustomSorters47aSet)
        {
            // hasCustomSorters has no pre constraints
            ahasCustomSorters47a = handleIsHasCustomSorters();
            // hasCustomSorters has no post constraints
            this.hasCustomSorters47a = ahasCustomSorters47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hasCustomSorters47aSet = true;
            }
        }
        return ahasCustomSorters47a;
    }

   /**
    * @see GuiManageableEntity#isReferencable()
    * @return boolean
    */
    protected abstract boolean handleIsReferencable();

    private boolean referencable48a;
    private boolean referencable48aSet = false;

    /**
     * Defines whether or not the manageable entity is referencable (sub blotter with drill down
     * references)
     * @return (boolean)handleIsReferencable()
     */
    public final boolean isReferencable()
    {
        boolean areferencable48a = this.referencable48a;
        if (!this.referencable48aSet)
        {
            // referencable has no pre constraints
            areferencable48a = handleIsReferencable();
            // referencable has no post constraints
            this.referencable48a = areferencable48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.referencable48aSet = true;
            }
        }
        return areferencable48a;
    }

   /**
    * @see GuiManageableEntity#isRealTimeData()
    * @return boolean
    */
    protected abstract boolean handleIsRealTimeData();

    private boolean realTimeData49a;
    private boolean realTimeData49aSet = false;

    /**
     * true if Manageable Entity carries RealTimeData stereotype
     * @return (boolean)handleIsRealTimeData()
     */
    public final boolean isRealTimeData()
    {
        boolean arealTimeData49a = this.realTimeData49a;
        if (!this.realTimeData49aSet)
        {
            // realTimeData has no pre constraints
            arealTimeData49a = handleIsRealTimeData();
            // realTimeData has no post constraints
            this.realTimeData49a = arealTimeData49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.realTimeData49aSet = true;
            }
        }
        return arealTimeData49a;
    }

   /**
    * @see GuiManageableEntity#isValidable()
    * @return boolean
    */
    protected abstract boolean handleIsValidable();

    private boolean validable50a;
    private boolean validable50aSet = false;

    /**
     * True if the manageable entity carries Validable stereotype (Validable object)
     * @return (boolean)handleIsValidable()
     */
    public final boolean isValidable()
    {
        boolean avalidable50a = this.validable50a;
        if (!this.validable50aSet)
        {
            // validable has no pre constraints
            avalidable50a = handleIsValidable();
            // validable has no post constraints
            this.validable50a = avalidable50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validable50aSet = true;
            }
        }
        return avalidable50a;
    }

   /**
    * @see GuiManageableEntity#isExternalOrganizationExists()
    * @return boolean
    */
    protected abstract boolean handleIsExternalOrganizationExists();

    private boolean externalOrganizationExists51a;
    private boolean externalOrganizationExists51aSet = false;

    /**
     * 
     * @return (boolean)handleIsExternalOrganizationExists()
     */
    public final boolean isExternalOrganizationExists()
    {
        boolean aexternalOrganizationExists51a = this.externalOrganizationExists51a;
        if (!this.externalOrganizationExists51aSet)
        {
            // externalOrganizationExists has no pre constraints
            aexternalOrganizationExists51a = handleIsExternalOrganizationExists();
            // externalOrganizationExists has no post constraints
            this.externalOrganizationExists51a = aexternalOrganizationExists51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.externalOrganizationExists51aSet = true;
            }
        }
        return aexternalOrganizationExists51a;
    }

   /**
    * @see GuiManageableEntity#getManageableExternalOrganization()
    * @return Object
    */
    protected abstract Object handleGetManageableExternalOrganization();

    private Object manageableExternalOrganization52a;
    private boolean manageableExternalOrganization52aSet = false;

    /**
     * 
     * @return (Object)handleGetManageableExternalOrganization()
     */
    public final Object getManageableExternalOrganization()
    {
        Object amanageableExternalOrganization52a = this.manageableExternalOrganization52a;
        if (!this.manageableExternalOrganization52aSet)
        {
            // manageableExternalOrganization has no pre constraints
            amanageableExternalOrganization52a = handleGetManageableExternalOrganization();
            // manageableExternalOrganization has no post constraints
            this.manageableExternalOrganization52a = amanageableExternalOrganization52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableExternalOrganization52aSet = true;
            }
        }
        return amanageableExternalOrganization52a;
    }

   /**
    * @see GuiManageableEntity#isShowDeal()
    * @return boolean
    */
    protected abstract boolean handleIsShowDeal();

    private boolean showDeal53a;
    private boolean showDeal53aSet = false;

    /**
     * is True if Manageable entity has the corresponding tagged value set to true
     * @return (boolean)handleIsShowDeal()
     */
    public final boolean isShowDeal()
    {
        boolean ashowDeal53a = this.showDeal53a;
        if (!this.showDeal53aSet)
        {
            // showDeal has no pre constraints
            ashowDeal53a = handleIsShowDeal();
            // showDeal has no post constraints
            this.showDeal53a = ashowDeal53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.showDeal53aSet = true;
            }
        }
        return ashowDeal53a;
    }

   /**
    * @see GuiManageableEntity#isUseTemplating()
    * @return boolean
    */
    protected abstract boolean handleIsUseTemplating();

    private boolean useTemplating54a;
    private boolean useTemplating54aSet = false;

    /**
     * 
     * @return (boolean)handleIsUseTemplating()
     */
    public final boolean isUseTemplating()
    {
        boolean auseTemplating54a = this.useTemplating54a;
        if (!this.useTemplating54aSet)
        {
            // useTemplating has no pre constraints
            auseTemplating54a = handleIsUseTemplating();
            // useTemplating has no post constraints
            this.useTemplating54a = auseTemplating54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.useTemplating54aSet = true;
            }
        }
        return auseTemplating54a;
    }

   /**
    * @see GuiManageableEntity#isRule()
    * @return boolean
    */
    protected abstract boolean handleIsRule();

    private boolean rule55a;
    private boolean rule55aSet = false;

    /**
     * true if Manageable entity is a K+TP Rule
     * @return (boolean)handleIsRule()
     */
    public final boolean isRule()
    {
        boolean arule55a = this.rule55a;
        if (!this.rule55aSet)
        {
            // rule has no pre constraints
            arule55a = handleIsRule();
            // rule has no post constraints
            this.rule55a = arule55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.rule55aSet = true;
            }
        }
        return arule55a;
    }

   /**
    * @see GuiManageableEntity#isInterceptable()
    * @return boolean
    */
    protected abstract boolean handleIsInterceptable();

    private boolean interceptable56a;
    private boolean interceptable56aSet = false;

    /**
     * True if the manageable entity carries Interceptable stereotype (Interceptable object)
     * @return (boolean)handleIsInterceptable()
     */
    public final boolean isInterceptable()
    {
        boolean ainterceptable56a = this.interceptable56a;
        if (!this.interceptable56aSet)
        {
            // interceptable has no pre constraints
            ainterceptable56a = handleIsInterceptable();
            // interceptable has no post constraints
            this.interceptable56a = ainterceptable56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.interceptable56aSet = true;
            }
        }
        return ainterceptable56a;
    }

   /**
    * @see GuiManageableEntity#getViewName()
    * @return String
    */
    protected abstract String handleGetViewName();

    private String viewName57a;
    private boolean viewName57aSet = false;

    /**
     * 
     * @return (String)handleGetViewName()
     */
    public final String getViewName()
    {
        String aviewName57a = this.viewName57a;
        if (!this.viewName57aSet)
        {
            // viewName has no pre constraints
            aviewName57a = handleGetViewName();
            // viewName has no post constraints
            this.viewName57a = aviewName57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewName57aSet = true;
            }
        }
        return aviewName57a;
    }

   /**
    * @see GuiManageableEntity#getViewTitleKey()
    * @return String
    */
    protected abstract String handleGetViewTitleKey();

    private String viewTitleKey58a;
    private boolean viewTitleKey58aSet = false;

    /**
     * 
     * @return (String)handleGetViewTitleKey()
     */
    public final String getViewTitleKey()
    {
        String aviewTitleKey58a = this.viewTitleKey58a;
        if (!this.viewTitleKey58aSet)
        {
            // viewTitleKey has no pre constraints
            aviewTitleKey58a = handleGetViewTitleKey();
            // viewTitleKey has no post constraints
            this.viewTitleKey58a = aviewTitleKey58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTitleKey58aSet = true;
            }
        }
        return aviewTitleKey58a;
    }

   /**
    * @see GuiManageableEntity#getViewTitleValue()
    * @return String
    */
    protected abstract String handleGetViewTitleValue();

    private String viewTitleValue59a;
    private boolean viewTitleValue59aSet = false;

    /**
     * 
     * @return (String)handleGetViewTitleValue()
     */
    public final String getViewTitleValue()
    {
        String aviewTitleValue59a = this.viewTitleValue59a;
        if (!this.viewTitleValue59aSet)
        {
            // viewTitleValue has no pre constraints
            aviewTitleValue59a = handleGetViewTitleValue();
            // viewTitleValue has no post constraints
            this.viewTitleValue59a = aviewTitleValue59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTitleValue59aSet = true;
            }
        }
        return aviewTitleValue59a;
    }

   /**
    * @see GuiManageableEntity#getFormBeanType()
    * @return String
    */
    protected abstract String handleGetFormBeanType();

    private String formBeanType60a;
    private boolean formBeanType60aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanType()
     */
    public final String getFormBeanType()
    {
        String aformBeanType60a = this.formBeanType60a;
        if (!this.formBeanType60aSet)
        {
            // formBeanType has no pre constraints
            aformBeanType60a = handleGetFormBeanType();
            // formBeanType has no post constraints
            this.formBeanType60a = aformBeanType60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanType60aSet = true;
            }
        }
        return aformBeanType60a;
    }

   /**
    * @see GuiManageableEntity#getFormBeanName()
    * @return String
    */
    protected abstract String handleGetFormBeanName();

    private String formBeanName61a;
    private boolean formBeanName61aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanName()
     */
    public final String getFormBeanName()
    {
        String aformBeanName61a = this.formBeanName61a;
        if (!this.formBeanName61aSet)
        {
            // formBeanName has no pre constraints
            aformBeanName61a = handleGetFormBeanName();
            // formBeanName has no post constraints
            this.formBeanName61a = aformBeanName61a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanName61aSet = true;
            }
        }
        return aformBeanName61a;
    }

   /**
    * @see GuiManageableEntity#isPreload()
    * @return boolean
    */
    protected abstract boolean handleIsPreload();

    private boolean preload62a;
    private boolean preload62aSet = false;

    /**
     * 
     * @return (boolean)handleIsPreload()
     */
    public final boolean isPreload()
    {
        boolean apreload62a = this.preload62a;
        if (!this.preload62aSet)
        {
            // preload has no pre constraints
            apreload62a = handleIsPreload();
            // preload has no post constraints
            this.preload62a = apreload62a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.preload62aSet = true;
            }
        }
        return apreload62a;
    }

   /**
    * @see GuiManageableEntity#getFormBeanClassName()
    * @return String
    */
    protected abstract String handleGetFormBeanClassName();

    private String formBeanClassName63a;
    private boolean formBeanClassName63aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanClassName()
     */
    public final String getFormBeanClassName()
    {
        String aformBeanClassName63a = this.formBeanClassName63a;
        if (!this.formBeanClassName63aSet)
        {
            // formBeanClassName has no pre constraints
            aformBeanClassName63a = handleGetFormBeanClassName();
            // formBeanClassName has no post constraints
            this.formBeanClassName63a = aformBeanClassName63a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanClassName63aSet = true;
            }
        }
        return aformBeanClassName63a;
    }

   /**
    * @see GuiManageableEntity#getFormBeanFullPath()
    * @return String
    */
    protected abstract String handleGetFormBeanFullPath();

    private String formBeanFullPath64a;
    private boolean formBeanFullPath64aSet = false;

    /**
     * 
     * @return (String)handleGetFormBeanFullPath()
     */
    public final String getFormBeanFullPath()
    {
        String aformBeanFullPath64a = this.formBeanFullPath64a;
        if (!this.formBeanFullPath64aSet)
        {
            // formBeanFullPath has no pre constraints
            aformBeanFullPath64a = handleGetFormBeanFullPath();
            // formBeanFullPath has no post constraints
            this.formBeanFullPath64a = aformBeanFullPath64a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formBeanFullPath64aSet = true;
            }
        }
        return aformBeanFullPath64a;
    }

   /**
    * @see GuiManageableEntity#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private String messageKey65a;
    private boolean messageKey65aSet = false;

    /**
     * 
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String amessageKey65a = this.messageKey65a;
        if (!this.messageKey65aSet)
        {
            // messageKey has no pre constraints
            amessageKey65a = handleGetMessageKey();
            // messageKey has no post constraints
            this.messageKey65a = amessageKey65a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageKey65aSet = true;
            }
        }
        return amessageKey65a;
    }

   /**
    * @see GuiManageableEntity#getMessageValue()
    * @return String
    */
    protected abstract String handleGetMessageValue();

    private String messageValue66a;
    private boolean messageValue66aSet = false;

    /**
     * 
     * @return (String)handleGetMessageValue()
     */
    public final String getMessageValue()
    {
        String amessageValue66a = this.messageValue66a;
        if (!this.messageValue66aSet)
        {
            // messageValue has no pre constraints
            amessageValue66a = handleGetMessageValue();
            // messageValue has no post constraints
            this.messageValue66a = amessageValue66a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageValue66aSet = true;
            }
        }
        return amessageValue66a;
    }

   /**
    * @see GuiManageableEntity#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String onlineHelpKey67a;
    private boolean onlineHelpKey67aSet = false;

    /**
     * The key to lookup the online help documentation.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String aonlineHelpKey67a = this.onlineHelpKey67a;
        if (!this.onlineHelpKey67aSet)
        {
            // onlineHelpKey has no pre constraints
            aonlineHelpKey67a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.onlineHelpKey67a = aonlineHelpKey67a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpKey67aSet = true;
            }
        }
        return aonlineHelpKey67a;
    }

   /**
    * @see GuiManageableEntity#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String onlineHelpValue68a;
    private boolean onlineHelpValue68aSet = false;

    /**
     * The online help documentation. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String aonlineHelpValue68a = this.onlineHelpValue68a;
        if (!this.onlineHelpValue68aSet)
        {
            // onlineHelpValue has no pre constraints
            aonlineHelpValue68a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.onlineHelpValue68a = aonlineHelpValue68a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpValue68aSet = true;
            }
        }
        return aonlineHelpValue68a;
    }

   /**
    * @see GuiManageableEntity#getOnlineHelpActionPath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpActionPath();

    private String onlineHelpActionPath69a;
    private boolean onlineHelpActionPath69aSet = false;

    /**
     * The full path to this entity's online help action. The returned String does not have a suffix
     * such as '.do'.
     * @return (String)handleGetOnlineHelpActionPath()
     */
    public final String getOnlineHelpActionPath()
    {
        String aonlineHelpActionPath69a = this.onlineHelpActionPath69a;
        if (!this.onlineHelpActionPath69aSet)
        {
            // onlineHelpActionPath has no pre constraints
            aonlineHelpActionPath69a = handleGetOnlineHelpActionPath();
            // onlineHelpActionPath has no post constraints
            this.onlineHelpActionPath69a = aonlineHelpActionPath69a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpActionPath69aSet = true;
            }
        }
        return aonlineHelpActionPath69a;
    }

   /**
    * @see GuiManageableEntity#getOnlineHelpPagePath()
    * @return String
    */
    protected abstract String handleGetOnlineHelpPagePath();

    private String onlineHelpPagePath70a;
    private boolean onlineHelpPagePath70aSet = false;

    /**
     * The full path to this entitiy's online help page. The returned String does not have a suffix
     * such as '.jsp'.
     * @return (String)handleGetOnlineHelpPagePath()
     */
    public final String getOnlineHelpPagePath()
    {
        String aonlineHelpPagePath70a = this.onlineHelpPagePath70a;
        if (!this.onlineHelpPagePath70aSet)
        {
            // onlineHelpPagePath has no pre constraints
            aonlineHelpPagePath70a = handleGetOnlineHelpPagePath();
            // onlineHelpPagePath has no post constraints
            this.onlineHelpPagePath70a = aonlineHelpPagePath70a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpPagePath70aSet = true;
            }
        }
        return aonlineHelpPagePath70a;
    }

   /**
    * @see GuiManageableEntity#getControllerType()
    * @return String
    */
    protected abstract String handleGetControllerType();

    private String controllerType71a;
    private boolean controllerType71aSet = false;

    /**
     * Fully qualified name of this manageable controller.
     * @return (String)handleGetControllerType()
     */
    public final String getControllerType()
    {
        String acontrollerType71a = this.controllerType71a;
        if (!this.controllerType71aSet)
        {
            // controllerType has no pre constraints
            acontrollerType71a = handleGetControllerType();
            // controllerType has no post constraints
            this.controllerType71a = acontrollerType71a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.controllerType71aSet = true;
            }
        }
        return acontrollerType71a;
    }

   /**
    * @see GuiManageableEntity#getControllerBeanName()
    * @return String
    */
    protected abstract String handleGetControllerBeanName();

    private String controllerBeanName72a;
    private boolean controllerBeanName72aSet = false;

    /**
     * The bean name of this manageable controller (this is what is stored in the JSF configuration
     * file).
     * @return (String)handleGetControllerBeanName()
     */
    public final String getControllerBeanName()
    {
        String acontrollerBeanName72a = this.controllerBeanName72a;
        if (!this.controllerBeanName72aSet)
        {
            // controllerBeanName has no pre constraints
            acontrollerBeanName72a = handleGetControllerBeanName();
            // controllerBeanName has no post constraints
            this.controllerBeanName72a = acontrollerBeanName72a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.controllerBeanName72aSet = true;
            }
        }
        return acontrollerBeanName72a;
    }

   /**
    * @see GuiManageableEntity#getControllerFullPath()
    * @return String
    */
    protected abstract String handleGetControllerFullPath();

    private String controllerFullPath73a;
    private boolean controllerFullPath73aSet = false;

    /**
     * Full path of this manageable controller.
     * @return (String)handleGetControllerFullPath()
     */
    public final String getControllerFullPath()
    {
        String acontrollerFullPath73a = this.controllerFullPath73a;
        if (!this.controllerFullPath73aSet)
        {
            // controllerFullPath has no pre constraints
            acontrollerFullPath73a = handleGetControllerFullPath();
            // controllerFullPath has no post constraints
            this.controllerFullPath73a = acontrollerFullPath73a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.controllerFullPath73aSet = true;
            }
        }
        return acontrollerFullPath73a;
    }

   /**
    * @see GuiManageableEntity#getControllerName()
    * @return String
    */
    protected abstract String handleGetControllerName();

    private String controllerName74a;
    private boolean controllerName74aSet = false;

    /**
     * Manageable controller class name.
     * @return (String)handleGetControllerName()
     */
    public final String getControllerName()
    {
        String acontrollerName74a = this.controllerName74a;
        if (!this.controllerName74aSet)
        {
            // controllerName has no pre constraints
            acontrollerName74a = handleGetControllerName();
            // controllerName has no post constraints
            this.controllerName74a = acontrollerName74a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.controllerName74aSet = true;
            }
        }
        return acontrollerName74a;
    }

   /**
    * @see GuiManageableEntity#getValueObjectClassName()
    * @return String
    */
    protected abstract String handleGetValueObjectClassName();

    private String valueObjectClassName75a;
    private boolean valueObjectClassName75aSet = false;

    /**
     * 
     * @return (String)handleGetValueObjectClassName()
     */
    public final String getValueObjectClassName()
    {
        String avalueObjectClassName75a = this.valueObjectClassName75a;
        if (!this.valueObjectClassName75aSet)
        {
            // valueObjectClassName has no pre constraints
            avalueObjectClassName75a = handleGetValueObjectClassName();
            // valueObjectClassName has no post constraints
            this.valueObjectClassName75a = avalueObjectClassName75a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.valueObjectClassName75aSet = true;
            }
        }
        return avalueObjectClassName75a;
    }

   /**
    * @see GuiManageableEntity#getFormSerialVersionUID()
    * @return String
    */
    protected abstract String handleGetFormSerialVersionUID();

    private String formSerialVersionUID76a;
    private boolean formSerialVersionUID76aSet = false;

    /**
     * The calcuated serial version UID for this action's form.
     * @return (String)handleGetFormSerialVersionUID()
     */
    public final String getFormSerialVersionUID()
    {
        String aformSerialVersionUID76a = this.formSerialVersionUID76a;
        if (!this.formSerialVersionUID76aSet)
        {
            // formSerialVersionUID has no pre constraints
            aformSerialVersionUID76a = handleGetFormSerialVersionUID();
            // formSerialVersionUID has no post constraints
            this.formSerialVersionUID76a = aformSerialVersionUID76a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formSerialVersionUID76aSet = true;
            }
        }
        return aformSerialVersionUID76a;
    }

   /**
    * @see GuiManageableEntity#getActionSerialVersionUID()
    * @return String
    */
    protected abstract String handleGetActionSerialVersionUID();

    private String actionSerialVersionUID77a;
    private boolean actionSerialVersionUID77aSet = false;

    /**
     * The calcuated serial version UID for this manageable actions.
     * @return (String)handleGetActionSerialVersionUID()
     */
    public final String getActionSerialVersionUID()
    {
        String aactionSerialVersionUID77a = this.actionSerialVersionUID77a;
        if (!this.actionSerialVersionUID77aSet)
        {
            // actionSerialVersionUID has no pre constraints
            aactionSerialVersionUID77a = handleGetActionSerialVersionUID();
            // actionSerialVersionUID has no post constraints
            this.actionSerialVersionUID77a = aactionSerialVersionUID77a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionSerialVersionUID77aSet = true;
            }
        }
        return aactionSerialVersionUID77a;
    }

   /**
    * @see GuiManageableEntity#getPopulatorName()
    * @return String
    */
    protected abstract String handleGetPopulatorName();

    private String populatorName78a;
    private boolean populatorName78aSet = false;

    /**
     * 
     * @return (String)handleGetPopulatorName()
     */
    public final String getPopulatorName()
    {
        String apopulatorName78a = this.populatorName78a;
        if (!this.populatorName78aSet)
        {
            // populatorName has no pre constraints
            apopulatorName78a = handleGetPopulatorName();
            // populatorName has no post constraints
            this.populatorName78a = apopulatorName78a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.populatorName78aSet = true;
            }
        }
        return apopulatorName78a;
    }

   /**
    * @see GuiManageableEntity#getPopulatorFullPath()
    * @return String
    */
    protected abstract String handleGetPopulatorFullPath();

    private String populatorFullPath79a;
    private boolean populatorFullPath79aSet = false;

    /**
     * 
     * @return (String)handleGetPopulatorFullPath()
     */
    public final String getPopulatorFullPath()
    {
        String apopulatorFullPath79a = this.populatorFullPath79a;
        if (!this.populatorFullPath79aSet)
        {
            // populatorFullPath has no pre constraints
            apopulatorFullPath79a = handleGetPopulatorFullPath();
            // populatorFullPath has no post constraints
            this.populatorFullPath79a = apopulatorFullPath79a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.populatorFullPath79aSet = true;
            }
        }
        return apopulatorFullPath79a;
    }

   /**
    * @see GuiManageableEntity#getPopulatorType()
    * @return String
    */
    protected abstract String handleGetPopulatorType();

    private String populatorType80a;
    private boolean populatorType80aSet = false;

    /**
     * 
     * @return (String)handleGetPopulatorType()
     */
    public final String getPopulatorType()
    {
        String apopulatorType80a = this.populatorType80a;
        if (!this.populatorType80aSet)
        {
            // populatorType has no pre constraints
            apopulatorType80a = handleGetPopulatorType();
            // populatorType has no post constraints
            this.populatorType80a = apopulatorType80a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.populatorType80aSet = true;
            }
        }
        return apopulatorType80a;
    }

   /**
    * @see GuiManageableEntity#getViewFullPath()
    * @return String
    */
    protected abstract String handleGetViewFullPath();

    private String viewFullPath81a;
    private boolean viewFullPath81aSet = false;

    /**
     * 
     * @return (String)handleGetViewFullPath()
     */
    public final String getViewFullPath()
    {
        String aviewFullPath81a = this.viewFullPath81a;
        if (!this.viewFullPath81aSet)
        {
            // viewFullPath has no pre constraints
            aviewFullPath81a = handleGetViewFullPath();
            // viewFullPath has no post constraints
            this.viewFullPath81a = aviewFullPath81a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewFullPath81aSet = true;
            }
        }
        return aviewFullPath81a;
    }

   /**
    * @see GuiManageableEntity#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private boolean validationRequired82a;
    private boolean validationRequired82aSet = false;

    /**
     * 
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean avalidationRequired82a = this.validationRequired82a;
        if (!this.validationRequired82aSet)
        {
            // validationRequired has no pre constraints
            avalidationRequired82a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.validationRequired82a = avalidationRequired82a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validationRequired82aSet = true;
            }
        }
        return avalidationRequired82a;
    }

   /**
    * @see GuiManageableEntity#getSearchFormBeanName()
    * @return String
    */
    protected abstract String handleGetSearchFormBeanName();

    private String searchFormBeanName83a;
    private boolean searchFormBeanName83aSet = false;

    /**
     * 
     * @return (String)handleGetSearchFormBeanName()
     */
    public final String getSearchFormBeanName()
    {
        String asearchFormBeanName83a = this.searchFormBeanName83a;
        if (!this.searchFormBeanName83aSet)
        {
            // searchFormBeanName has no pre constraints
            asearchFormBeanName83a = handleGetSearchFormBeanName();
            // searchFormBeanName has no post constraints
            this.searchFormBeanName83a = asearchFormBeanName83a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.searchFormBeanName83aSet = true;
            }
        }
        return asearchFormBeanName83a;
    }

   /**
    * @see GuiManageableEntity#getSearchFormBeanType()
    * @return String
    */
    protected abstract String handleGetSearchFormBeanType();

    private String searchFormBeanType84a;
    private boolean searchFormBeanType84aSet = false;

    /**
     * 
     * @return (String)handleGetSearchFormBeanType()
     */
    public final String getSearchFormBeanType()
    {
        String asearchFormBeanType84a = this.searchFormBeanType84a;
        if (!this.searchFormBeanType84aSet)
        {
            // searchFormBeanType has no pre constraints
            asearchFormBeanType84a = handleGetSearchFormBeanType();
            // searchFormBeanType has no post constraints
            this.searchFormBeanType84a = asearchFormBeanType84a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.searchFormBeanType84aSet = true;
            }
        }
        return asearchFormBeanType84a;
    }

   /**
    * @see GuiManageableEntity#getSearchFormBeanFullPath()
    * @return String
    */
    protected abstract String handleGetSearchFormBeanFullPath();

    private String searchFormBeanFullPath85a;
    private boolean searchFormBeanFullPath85aSet = false;

    /**
     * 
     * @return (String)handleGetSearchFormBeanFullPath()
     */
    public final String getSearchFormBeanFullPath()
    {
        String asearchFormBeanFullPath85a = this.searchFormBeanFullPath85a;
        if (!this.searchFormBeanFullPath85aSet)
        {
            // searchFormBeanFullPath has no pre constraints
            asearchFormBeanFullPath85a = handleGetSearchFormBeanFullPath();
            // searchFormBeanFullPath has no post constraints
            this.searchFormBeanFullPath85a = asearchFormBeanFullPath85a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.searchFormBeanFullPath85aSet = true;
            }
        }
        return asearchFormBeanFullPath85a;
    }

   /**
    * @see GuiManageableEntity#getSearchFormBeanClassName()
    * @return String
    */
    protected abstract String handleGetSearchFormBeanClassName();

    private String searchFormBeanClassName86a;
    private boolean searchFormBeanClassName86aSet = false;

    /**
     * 
     * @return (String)handleGetSearchFormBeanClassName()
     */
    public final String getSearchFormBeanClassName()
    {
        String asearchFormBeanClassName86a = this.searchFormBeanClassName86a;
        if (!this.searchFormBeanClassName86aSet)
        {
            // searchFormBeanClassName has no pre constraints
            asearchFormBeanClassName86a = handleGetSearchFormBeanClassName();
            // searchFormBeanClassName has no post constraints
            this.searchFormBeanClassName86a = asearchFormBeanClassName86a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.searchFormBeanClassName86aSet = true;
            }
        }
        return asearchFormBeanClassName86a;
    }

   /**
    * @see GuiManageableEntity#getManageableSearchAttributes()
    * @return Collection
    */
    protected abstract Collection handleGetManageableSearchAttributes();

    private Collection manageableSearchAttributes87a;
    private boolean manageableSearchAttributes87aSet = false;

    /**
     * 
     * @return (Collection)handleGetManageableSearchAttributes()
     */
    public final Collection getManageableSearchAttributes()
    {
        Collection amanageableSearchAttributes87a = this.manageableSearchAttributes87a;
        if (!this.manageableSearchAttributes87aSet)
        {
            // manageableSearchAttributes has no pre constraints
            amanageableSearchAttributes87a = handleGetManageableSearchAttributes();
            // manageableSearchAttributes has no post constraints
            this.manageableSearchAttributes87a = amanageableSearchAttributes87a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableSearchAttributes87aSet = true;
            }
        }
        return amanageableSearchAttributes87a;
    }

   /**
    * @see GuiManageableEntity#getManageableSearchAssociationEnds()
    * @return Collection
    */
    protected abstract Collection handleGetManageableSearchAssociationEnds();

    private Collection manageableSearchAssociationEnds88a;
    private boolean manageableSearchAssociationEnds88aSet = false;

    /**
     * 
     * @return (Collection)handleGetManageableSearchAssociationEnds()
     */
    public final Collection getManageableSearchAssociationEnds()
    {
        Collection amanageableSearchAssociationEnds88a = this.manageableSearchAssociationEnds88a;
        if (!this.manageableSearchAssociationEnds88aSet)
        {
            // manageableSearchAssociationEnds has no pre constraints
            amanageableSearchAssociationEnds88a = handleGetManageableSearchAssociationEnds();
            // manageableSearchAssociationEnds has no post constraints
            this.manageableSearchAssociationEnds88a = amanageableSearchAssociationEnds88a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableSearchAssociationEnds88aSet = true;
            }
        }
        return amanageableSearchAssociationEnds88a;
    }

   /**
    * @see GuiManageableEntity#isNeedsFileUpload()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsFileUpload();

    private boolean needsFileUpload89a;
    private boolean needsFileUpload89aSet = false;

    /**
     * 
     * @return (boolean)handleIsNeedsFileUpload()
     */
    public final boolean isNeedsFileUpload()
    {
        boolean aneedsFileUpload89a = this.needsFileUpload89a;
        if (!this.needsFileUpload89aSet)
        {
            // needsFileUpload has no pre constraints
            aneedsFileUpload89a = handleIsNeedsFileUpload();
            // needsFileUpload has no post constraints
            this.needsFileUpload89a = aneedsFileUpload89a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.needsFileUpload89aSet = true;
            }
        }
        return aneedsFileUpload89a;
    }

   /**
    * @see GuiManageableEntity#getConverterFullPath()
    * @return String
    */
    protected abstract String handleGetConverterFullPath();

    private String converterFullPath90a;
    private boolean converterFullPath90aSet = false;

    /**
     * 
     * @return (String)handleGetConverterFullPath()
     */
    public final String getConverterFullPath()
    {
        String aconverterFullPath90a = this.converterFullPath90a;
        if (!this.converterFullPath90aSet)
        {
            // converterFullPath has no pre constraints
            aconverterFullPath90a = handleGetConverterFullPath();
            // converterFullPath has no post constraints
            this.converterFullPath90a = aconverterFullPath90a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.converterFullPath90aSet = true;
            }
        }
        return aconverterFullPath90a;
    }

   /**
    * @see GuiManageableEntity#getConverterType()
    * @return String
    */
    protected abstract String handleGetConverterType();

    private String converterType91a;
    private boolean converterType91aSet = false;

    /**
     * 
     * @return (String)handleGetConverterType()
     */
    public final String getConverterType()
    {
        String aconverterType91a = this.converterType91a;
        if (!this.converterType91aSet)
        {
            // converterType has no pre constraints
            aconverterType91a = handleGetConverterType();
            // converterType has no post constraints
            this.converterType91a = aconverterType91a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.converterType91aSet = true;
            }
        }
        return aconverterType91a;
    }

   /**
    * @see GuiManageableEntity#getConverterClassName()
    * @return String
    */
    protected abstract String handleGetConverterClassName();

    private String converterClassName92a;
    private boolean converterClassName92aSet = false;

    /**
     * 
     * @return (String)handleGetConverterClassName()
     */
    public final String getConverterClassName()
    {
        String aconverterClassName92a = this.converterClassName92a;
        if (!this.converterClassName92aSet)
        {
            // converterClassName has no pre constraints
            aconverterClassName92a = handleGetConverterClassName();
            // converterClassName has no post constraints
            this.converterClassName92a = aconverterClassName92a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.converterClassName92aSet = true;
            }
        }
        return aconverterClassName92a;
    }

   /**
    * @see GuiManageableEntity#getOdsExportFullPath()
    * @return String
    */
    protected abstract String handleGetOdsExportFullPath();

    private String odsExportFullPath93a;
    private boolean odsExportFullPath93aSet = false;

    /**
     * 
     * @return (String)handleGetOdsExportFullPath()
     */
    public final String getOdsExportFullPath()
    {
        String aodsExportFullPath93a = this.odsExportFullPath93a;
        if (!this.odsExportFullPath93aSet)
        {
            // odsExportFullPath has no pre constraints
            aodsExportFullPath93a = handleGetOdsExportFullPath();
            // odsExportFullPath has no post constraints
            this.odsExportFullPath93a = aodsExportFullPath93a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.odsExportFullPath93aSet = true;
            }
        }
        return aodsExportFullPath93a;
    }

   /**
    * @see GuiManageableEntity#isNeedsUserInterface()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsUserInterface();

    private boolean needsUserInterface94a;
    private boolean needsUserInterface94aSet = false;

    /**
     * 
     * @return (boolean)handleIsNeedsUserInterface()
     */
    public final boolean isNeedsUserInterface()
    {
        boolean aneedsUserInterface94a = this.needsUserInterface94a;
        if (!this.needsUserInterface94aSet)
        {
            // needsUserInterface has no pre constraints
            aneedsUserInterface94a = handleIsNeedsUserInterface();
            // needsUserInterface has no post constraints
            this.needsUserInterface94a = aneedsUserInterface94a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.needsUserInterface94aSet = true;
            }
        }
        return aneedsUserInterface94a;
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
        Collection<Role> aroles95a = null;
        // roles has no pre constraints
        aroles95a = handleGetRoles();
        // roles has no post constraints
        return aroles95a;
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
            GuiManageableEntityLogic.LOGGER.warn("incorrect metafacade cast for GuiManageableEntityLogic.getVersionableEntityReference Entity " + result + ": " + shieldedResult);
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
            GuiManageableEntityLogic.LOGGER.warn("incorrect metafacade cast for GuiManageableEntityLogic.getCustomOwner GuiManageableEntity " + result + ": " + shieldedResult);
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
            GuiManageableEntityLogic.LOGGER.warn("incorrect metafacade cast for GuiManageableEntityLogic.getCustomEntityReferences List<GuiManageableEntity> " + result + ": " + shieldedResult);
        }
        // customOwner has no post constraints
        return getCustomEntityReferences3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetCustomEntityReferences();

    private List<Entity> getBusinessObjectReferences4r;
    private boolean getBusinessObjectReferences4rSet = false;

    /**
     * 
     * @return (List<Entity>)handleGetBusinessObjectReferences()
     */
    public final List<Entity> getBusinessObjectReferences()
    {
        List<Entity> getBusinessObjectReferences4r = this.getBusinessObjectReferences4r;
        if (!this.getBusinessObjectReferences4rSet)
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
                GuiManageableEntityLogic.LOGGER.warn("incorrect metafacade cast for GuiManageableEntityLogic.getBusinessObjectReferences List<Entity> " + result + ": " + shieldedResult);
            }
            // guiManageableEntity has no post constraints
            this.getBusinessObjectReferences4r = getBusinessObjectReferences4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getBusinessObjectReferences4rSet = true;
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
    public Collection<ModelElementFacade> getAllProperties()
    {
        return this.getSuperManageableEntity().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getAllRequiredConstructorParameters()
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
    public List<AttributeFacade> getAttributes(boolean follow)
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
    public List<AssociationEndFacade> getNavigableConnectingEnds(boolean follow)
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
    public List<ModelElementFacade> getProperties()
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
    public Collection<ModelElementFacade> getRequiredConstructorParameters()
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
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperManageableEntity().getAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false and exclude
     * derived attributes if 'withDerived' is set to false.
     * @see Entity#getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
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
    public Collection<AttributeFacade> getEmbeddedValues()
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
    public Collection<AssociationEndFacade> getIdentifierAssociationEnds()
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
     * The name of the identifier. If composite identifier add the Pk suffix. If not composite
     * returns the attribute name of the identifier.
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
     * The name of the type of the identifier. If composite identifier add the PK suffix to the
     * class name. If not, returns the name of the identifier.
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
    public Collection<EntityAttribute> getIdentifiers(boolean follow)
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
    public Collection<ModelElementFacade> getProperties(boolean follow, boolean withIdentifiers)
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
    public Collection<OperationFacade> getQueryOperations(boolean follow)
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
    public Collection<AttributeFacade> getRequiredAttributes(boolean follow, boolean withIdentifiers)
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
    public Collection<ModelElementFacade> getRequiredProperties(boolean follow, boolean withIdentifiers)
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
     * ManageableAttributes and ManageableAssociationEnds
     * @see ManageableEntity#getManageableMembers()
     */
    public List<ModelElementFacade> getManageableMembers()
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
    public Collection<Object> findTaggedValues(String tagName)
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
    public Collection<ConstraintFacade> getConstraints(String kind)
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