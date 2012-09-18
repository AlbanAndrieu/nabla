// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

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
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for EJB3ManageableEntityFacade
 *
 * @see EJB3ManageableEntityFacade
 */
public abstract class EJB3ManageableEntityFacadeLogic
    extends MetafacadeBase
    implements EJB3ManageableEntityFacade
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
    protected EJB3ManageableEntityFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superEJB3EntityFacade =
           (EJB3EntityFacade)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.cartridges.ejb3.metafacades.EJB3EntityFacade",
                    metaObjectIn,
                    getContext(context));
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
     * @param context String. Set to EJB3ManageableEntityFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade";
        }
        return context;
    }

    private EJB3EntityFacade superEJB3EntityFacade;
    private boolean superEJB3EntityFacadeInitialized = false;

    /**
     * Gets the EJB3EntityFacade parent instance.
     * @return this.superEJB3EntityFacade EJB3EntityFacade
     */
    protected EJB3EntityFacade getSuperEJB3EntityFacade()
    {
        if (!this.superEJB3EntityFacadeInitialized)
        {
            ((MetafacadeBase)this.superEJB3EntityFacade).setMetafacadeContext(this.getMetafacadeContext());
            this.superEJB3EntityFacadeInitialized = true;
        }
        return this.superEJB3EntityFacade;
    }

    private ManageableEntity superManageableEntity;
    private boolean superManageableEntityInitialized = false;

    /**
     * Gets the ManageableEntity parent instance.
     * @return this.superManageableEntity ManageableEntity
     */
    protected ManageableEntity getSuperManageableEntity()
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
            if (this.superEJB3EntityFacadeInitialized)
            {
                ((MetafacadeBase)this.superEJB3EntityFacade).resetMetafacadeContext(context);
            }
            if (this.superManageableEntityInitialized)
            {
                ((MetafacadeBase)this.superManageableEntity).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3ManageableEntityFacade
     */
    public boolean isEJB3ManageableEntityFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getFullyQualifiedManageableServiceCreateExceptionName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedManageableServiceCreateExceptionName();

    private String fullyQualifiedManageableServiceCreateExceptionName1a;
    private boolean fullyQualifiedManageableServiceCreateExceptionName1aSet = false;

    /**
     * Returns the fully qualified name of the application create exception.
     * @return (String)handleGetFullyQualifiedManageableServiceCreateExceptionName()
     */
    public final String getFullyQualifiedManageableServiceCreateExceptionName()
    {
        String afullyQualifiedManageableServiceCreateExceptionName1a = this.fullyQualifiedManageableServiceCreateExceptionName1a;
        if (!this.fullyQualifiedManageableServiceCreateExceptionName1aSet)
        {
            // fullyQualifiedManageableServiceCreateExceptionName has no pre constraints
            afullyQualifiedManageableServiceCreateExceptionName1a = handleGetFullyQualifiedManageableServiceCreateExceptionName();
            // fullyQualifiedManageableServiceCreateExceptionName has no post constraints
            this.fullyQualifiedManageableServiceCreateExceptionName1a = afullyQualifiedManageableServiceCreateExceptionName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedManageableServiceCreateExceptionName1aSet = true;
            }
        }
        return afullyQualifiedManageableServiceCreateExceptionName1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getFullyQualifiedManageableServiceReadExceptionName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedManageableServiceReadExceptionName();

    private String fullyQualifiedManageableServiceReadExceptionName2a;
    private boolean fullyQualifiedManageableServiceReadExceptionName2aSet = false;

    /**
     * Returns the fully qualified name of the application read exception.
     * @return (String)handleGetFullyQualifiedManageableServiceReadExceptionName()
     */
    public final String getFullyQualifiedManageableServiceReadExceptionName()
    {
        String afullyQualifiedManageableServiceReadExceptionName2a = this.fullyQualifiedManageableServiceReadExceptionName2a;
        if (!this.fullyQualifiedManageableServiceReadExceptionName2aSet)
        {
            // fullyQualifiedManageableServiceReadExceptionName has no pre constraints
            afullyQualifiedManageableServiceReadExceptionName2a = handleGetFullyQualifiedManageableServiceReadExceptionName();
            // fullyQualifiedManageableServiceReadExceptionName has no post constraints
            this.fullyQualifiedManageableServiceReadExceptionName2a = afullyQualifiedManageableServiceReadExceptionName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedManageableServiceReadExceptionName2aSet = true;
            }
        }
        return afullyQualifiedManageableServiceReadExceptionName2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getFullyQualifiedManageableServiceUpdateExceptionName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedManageableServiceUpdateExceptionName();

    private String fullyQualifiedManageableServiceUpdateExceptionName3a;
    private boolean fullyQualifiedManageableServiceUpdateExceptionName3aSet = false;

    /**
     * Returns the fully qualified update application exception name.
     * @return (String)handleGetFullyQualifiedManageableServiceUpdateExceptionName()
     */
    public final String getFullyQualifiedManageableServiceUpdateExceptionName()
    {
        String afullyQualifiedManageableServiceUpdateExceptionName3a = this.fullyQualifiedManageableServiceUpdateExceptionName3a;
        if (!this.fullyQualifiedManageableServiceUpdateExceptionName3aSet)
        {
            // fullyQualifiedManageableServiceUpdateExceptionName has no pre constraints
            afullyQualifiedManageableServiceUpdateExceptionName3a = handleGetFullyQualifiedManageableServiceUpdateExceptionName();
            // fullyQualifiedManageableServiceUpdateExceptionName has no post constraints
            this.fullyQualifiedManageableServiceUpdateExceptionName3a = afullyQualifiedManageableServiceUpdateExceptionName3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedManageableServiceUpdateExceptionName3aSet = true;
            }
        }
        return afullyQualifiedManageableServiceUpdateExceptionName3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getFullyQualifiedManageableServiceDeleteExceptionName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedManageableServiceDeleteExceptionName();

    private String fullyQualifiedManageableServiceDeleteExceptionName4a;
    private boolean fullyQualifiedManageableServiceDeleteExceptionName4aSet = false;

    /**
     * Returns the fully qualified delete application exception name.
     * @return (String)handleGetFullyQualifiedManageableServiceDeleteExceptionName()
     */
    public final String getFullyQualifiedManageableServiceDeleteExceptionName()
    {
        String afullyQualifiedManageableServiceDeleteExceptionName4a = this.fullyQualifiedManageableServiceDeleteExceptionName4a;
        if (!this.fullyQualifiedManageableServiceDeleteExceptionName4aSet)
        {
            // fullyQualifiedManageableServiceDeleteExceptionName has no pre constraints
            afullyQualifiedManageableServiceDeleteExceptionName4a = handleGetFullyQualifiedManageableServiceDeleteExceptionName();
            // fullyQualifiedManageableServiceDeleteExceptionName has no post constraints
            this.fullyQualifiedManageableServiceDeleteExceptionName4a = afullyQualifiedManageableServiceDeleteExceptionName4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedManageableServiceDeleteExceptionName4aSet = true;
            }
        }
        return afullyQualifiedManageableServiceDeleteExceptionName4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getJndiNamePrefix()
    * @return String
    */
    protected abstract String handleGetJndiNamePrefix();

    private String jndiNamePrefix5a;
    private boolean jndiNamePrefix5aSet = false;

    /**
     * Returns the JNDI name prefix for this menageable session bean.  This is set using the
     * jndiNamePrefix namespace property and is commonly the ear file name excluding the extension
     * for the EJB3 cartridge.  The JNDI name prefix is applied like so:
     * jndiPrefix/EJBName/Remote
     * @return (String)handleGetJndiNamePrefix()
     */
    public final String getJndiNamePrefix()
    {
        String ajndiNamePrefix5a = this.jndiNamePrefix5a;
        if (!this.jndiNamePrefix5aSet)
        {
            // jndiNamePrefix has no pre constraints
            ajndiNamePrefix5a = handleGetJndiNamePrefix();
            // jndiNamePrefix has no post constraints
            this.jndiNamePrefix5a = ajndiNamePrefix5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.jndiNamePrefix5aSet = true;
            }
        }
        return ajndiNamePrefix5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableServiceBaseName()
    * @return String
    */
    protected abstract String handleGetManageableServiceBaseName();

    private String manageableServiceBaseName6a;
    private boolean manageableServiceBaseName6aSet = false;

    /**
     * Returns the manageable service base class name.  This is the manageable session bean
     * containing the CRUD implementation.
     * @return (String)handleGetManageableServiceBaseName()
     */
    public final String getManageableServiceBaseName()
    {
        String amanageableServiceBaseName6a = this.manageableServiceBaseName6a;
        if (!this.manageableServiceBaseName6aSet)
        {
            // manageableServiceBaseName has no pre constraints
            amanageableServiceBaseName6a = handleGetManageableServiceBaseName();
            // manageableServiceBaseName has no post constraints
            this.manageableServiceBaseName6a = amanageableServiceBaseName6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableServiceBaseName6aSet = true;
            }
        }
        return amanageableServiceBaseName6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableServiceBaseFullPath()
    * @return String
    */
    protected abstract String handleGetManageableServiceBaseFullPath();

    private String manageableServiceBaseFullPath7a;
    private boolean manageableServiceBaseFullPath7aSet = false;

    /**
     * Returns the manageable service base class fully qualified path used to set the template
     * generated file.
     * @return (String)handleGetManageableServiceBaseFullPath()
     */
    public final String getManageableServiceBaseFullPath()
    {
        String amanageableServiceBaseFullPath7a = this.manageableServiceBaseFullPath7a;
        if (!this.manageableServiceBaseFullPath7aSet)
        {
            // manageableServiceBaseFullPath has no pre constraints
            amanageableServiceBaseFullPath7a = handleGetManageableServiceBaseFullPath();
            // manageableServiceBaseFullPath has no post constraints
            this.manageableServiceBaseFullPath7a = amanageableServiceBaseFullPath7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableServiceBaseFullPath7aSet = true;
            }
        }
        return amanageableServiceBaseFullPath7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getFullyQualifiedManageableServiceBaseName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedManageableServiceBaseName();

    private String fullyQualifiedManageableServiceBaseName8a;
    private boolean fullyQualifiedManageableServiceBaseName8aSet = false;

    /**
     * Returns the fully qualified manageable service base class name that contains the
     * implementation.
     * @return (String)handleGetFullyQualifiedManageableServiceBaseName()
     */
    public final String getFullyQualifiedManageableServiceBaseName()
    {
        String afullyQualifiedManageableServiceBaseName8a = this.fullyQualifiedManageableServiceBaseName8a;
        if (!this.fullyQualifiedManageableServiceBaseName8aSet)
        {
            // fullyQualifiedManageableServiceBaseName has no pre constraints
            afullyQualifiedManageableServiceBaseName8a = handleGetFullyQualifiedManageableServiceBaseName();
            // fullyQualifiedManageableServiceBaseName has no post constraints
            this.fullyQualifiedManageableServiceBaseName8a = afullyQualifiedManageableServiceBaseName8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedManageableServiceBaseName8aSet = true;
            }
        }
        return afullyQualifiedManageableServiceBaseName8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableServiceCreateExceptionName()
    * @return String
    */
    protected abstract String handleGetManageableServiceCreateExceptionName();

    private String manageableServiceCreateExceptionName9a;
    private boolean manageableServiceCreateExceptionName9aSet = false;

    /**
     * Returns the manageable service create exception name.
     * @return (String)handleGetManageableServiceCreateExceptionName()
     */
    public final String getManageableServiceCreateExceptionName()
    {
        String amanageableServiceCreateExceptionName9a = this.manageableServiceCreateExceptionName9a;
        if (!this.manageableServiceCreateExceptionName9aSet)
        {
            // manageableServiceCreateExceptionName has no pre constraints
            amanageableServiceCreateExceptionName9a = handleGetManageableServiceCreateExceptionName();
            // manageableServiceCreateExceptionName has no post constraints
            this.manageableServiceCreateExceptionName9a = amanageableServiceCreateExceptionName9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableServiceCreateExceptionName9aSet = true;
            }
        }
        return amanageableServiceCreateExceptionName9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableServiceReadExceptionName()
    * @return String
    */
    protected abstract String handleGetManageableServiceReadExceptionName();

    private String manageableServiceReadExceptionName10a;
    private boolean manageableServiceReadExceptionName10aSet = false;

    /**
     * Returns the manageable service read exception name.
     * @return (String)handleGetManageableServiceReadExceptionName()
     */
    public final String getManageableServiceReadExceptionName()
    {
        String amanageableServiceReadExceptionName10a = this.manageableServiceReadExceptionName10a;
        if (!this.manageableServiceReadExceptionName10aSet)
        {
            // manageableServiceReadExceptionName has no pre constraints
            amanageableServiceReadExceptionName10a = handleGetManageableServiceReadExceptionName();
            // manageableServiceReadExceptionName has no post constraints
            this.manageableServiceReadExceptionName10a = amanageableServiceReadExceptionName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableServiceReadExceptionName10aSet = true;
            }
        }
        return amanageableServiceReadExceptionName10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableServiceUpdateExceptionName()
    * @return String
    */
    protected abstract String handleGetManageableServiceUpdateExceptionName();

    private String manageableServiceUpdateExceptionName11a;
    private boolean manageableServiceUpdateExceptionName11aSet = false;

    /**
     * Returns the manageable service update exception name.
     * @return (String)handleGetManageableServiceUpdateExceptionName()
     */
    public final String getManageableServiceUpdateExceptionName()
    {
        String amanageableServiceUpdateExceptionName11a = this.manageableServiceUpdateExceptionName11a;
        if (!this.manageableServiceUpdateExceptionName11aSet)
        {
            // manageableServiceUpdateExceptionName has no pre constraints
            amanageableServiceUpdateExceptionName11a = handleGetManageableServiceUpdateExceptionName();
            // manageableServiceUpdateExceptionName has no post constraints
            this.manageableServiceUpdateExceptionName11a = amanageableServiceUpdateExceptionName11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableServiceUpdateExceptionName11aSet = true;
            }
        }
        return amanageableServiceUpdateExceptionName11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableServiceDeleteExceptionName()
    * @return String
    */
    protected abstract String handleGetManageableServiceDeleteExceptionName();

    private String manageableServiceDeleteExceptionName12a;
    private boolean manageableServiceDeleteExceptionName12aSet = false;

    /**
     * Returns the manageable service delete exception name.
     * @return (String)handleGetManageableServiceDeleteExceptionName()
     */
    public final String getManageableServiceDeleteExceptionName()
    {
        String amanageableServiceDeleteExceptionName12a = this.manageableServiceDeleteExceptionName12a;
        if (!this.manageableServiceDeleteExceptionName12aSet)
        {
            // manageableServiceDeleteExceptionName has no pre constraints
            amanageableServiceDeleteExceptionName12a = handleGetManageableServiceDeleteExceptionName();
            // manageableServiceDeleteExceptionName has no post constraints
            this.manageableServiceDeleteExceptionName12a = amanageableServiceDeleteExceptionName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableServiceDeleteExceptionName12aSet = true;
            }
        }
        return amanageableServiceDeleteExceptionName12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableRolesAllowed()
    * @return String
    */
    protected abstract String handleGetManageableRolesAllowed();

    private String manageableRolesAllowed13a;
    private boolean manageableRolesAllowed13aSet = false;

    /**
     * Returns the comma separated list of roles which are used to secure manageable service beans.
     * @return (String)handleGetManageableRolesAllowed()
     */
    public final String getManageableRolesAllowed()
    {
        String amanageableRolesAllowed13a = this.manageableRolesAllowed13a;
        if (!this.manageableRolesAllowed13aSet)
        {
            // manageableRolesAllowed has no pre constraints
            amanageableRolesAllowed13a = handleGetManageableRolesAllowed();
            // manageableRolesAllowed has no post constraints
            this.manageableRolesAllowed13a = amanageableRolesAllowed13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableRolesAllowed13aSet = true;
            }
        }
        return amanageableRolesAllowed13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableDaoBaseFullPath()
    * @return String
    */
    protected abstract String handleGetManageableDaoBaseFullPath();

    private String manageableDaoBaseFullPath14a;
    private boolean manageableDaoBaseFullPath14aSet = false;

    /**
     * 
     * @return (String)handleGetManageableDaoBaseFullPath()
     */
    public final String getManageableDaoBaseFullPath()
    {
        String amanageableDaoBaseFullPath14a = this.manageableDaoBaseFullPath14a;
        if (!this.manageableDaoBaseFullPath14aSet)
        {
            // manageableDaoBaseFullPath has no pre constraints
            amanageableDaoBaseFullPath14a = handleGetManageableDaoBaseFullPath();
            // manageableDaoBaseFullPath has no post constraints
            this.manageableDaoBaseFullPath14a = amanageableDaoBaseFullPath14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableDaoBaseFullPath14aSet = true;
            }
        }
        return amanageableDaoBaseFullPath14a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableDaoBaseName()
    * @return String
    */
    protected abstract String handleGetManageableDaoBaseName();

    private String manageableDaoBaseName15a;
    private boolean manageableDaoBaseName15aSet = false;

    /**
     * 
     * @return (String)handleGetManageableDaoBaseName()
     */
    public final String getManageableDaoBaseName()
    {
        String amanageableDaoBaseName15a = this.manageableDaoBaseName15a;
        if (!this.manageableDaoBaseName15aSet)
        {
            // manageableDaoBaseName has no pre constraints
            amanageableDaoBaseName15a = handleGetManageableDaoBaseName();
            // manageableDaoBaseName has no post constraints
            this.manageableDaoBaseName15a = amanageableDaoBaseName15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableDaoBaseName15aSet = true;
            }
        }
        return amanageableDaoBaseName15a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableDaoFullPath()
    * @return String
    */
    protected abstract String handleGetManageableDaoFullPath();

    private String manageableDaoFullPath16a;
    private boolean manageableDaoFullPath16aSet = false;

    /**
     * 
     * @return (String)handleGetManageableDaoFullPath()
     */
    public final String getManageableDaoFullPath()
    {
        String amanageableDaoFullPath16a = this.manageableDaoFullPath16a;
        if (!this.manageableDaoFullPath16aSet)
        {
            // manageableDaoFullPath has no pre constraints
            amanageableDaoFullPath16a = handleGetManageableDaoFullPath();
            // manageableDaoFullPath has no post constraints
            this.manageableDaoFullPath16a = amanageableDaoFullPath16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableDaoFullPath16aSet = true;
            }
        }
        return amanageableDaoFullPath16a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableDaoName()
    * @return String
    */
    protected abstract String handleGetManageableDaoName();

    private String manageableDaoName17a;
    private boolean manageableDaoName17aSet = false;

    /**
     * 
     * @return (String)handleGetManageableDaoName()
     */
    public final String getManageableDaoName()
    {
        String amanageableDaoName17a = this.manageableDaoName17a;
        if (!this.manageableDaoName17aSet)
        {
            // manageableDaoName has no pre constraints
            amanageableDaoName17a = handleGetManageableDaoName();
            // manageableDaoName has no post constraints
            this.manageableDaoName17a = amanageableDaoName17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableDaoName17aSet = true;
            }
        }
        return amanageableDaoName17a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableValueObjectClassName()
    * @return String
    */
    protected abstract String handleGetManageableValueObjectClassName();

    private String manageableValueObjectClassName18a;
    private boolean manageableValueObjectClassName18aSet = false;

    /**
     * 
     * @return (String)handleGetManageableValueObjectClassName()
     */
    public final String getManageableValueObjectClassName()
    {
        String amanageableValueObjectClassName18a = this.manageableValueObjectClassName18a;
        if (!this.manageableValueObjectClassName18aSet)
        {
            // manageableValueObjectClassName has no pre constraints
            amanageableValueObjectClassName18a = handleGetManageableValueObjectClassName();
            // manageableValueObjectClassName has no post constraints
            this.manageableValueObjectClassName18a = amanageableValueObjectClassName18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableValueObjectClassName18aSet = true;
            }
        }
        return amanageableValueObjectClassName18a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getManageableValueObjectFullPath()
    * @return String
    */
    protected abstract String handleGetManageableValueObjectFullPath();

    private String manageableValueObjectFullPath19a;
    private boolean manageableValueObjectFullPath19aSet = false;

    /**
     * 
     * @return (String)handleGetManageableValueObjectFullPath()
     */
    public final String getManageableValueObjectFullPath()
    {
        String amanageableValueObjectFullPath19a = this.manageableValueObjectFullPath19a;
        if (!this.manageableValueObjectFullPath19aSet)
        {
            // manageableValueObjectFullPath has no pre constraints
            amanageableValueObjectFullPath19a = handleGetManageableValueObjectFullPath();
            // manageableValueObjectFullPath has no post constraints
            this.manageableValueObjectFullPath19a = amanageableValueObjectFullPath19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.manageableValueObjectFullPath19aSet = true;
            }
        }
        return amanageableValueObjectFullPath19a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getFullyQualifiedManageableDaoBaseName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedManageableDaoBaseName();

    private String fullyQualifiedManageableDaoBaseName20a;
    private boolean fullyQualifiedManageableDaoBaseName20aSet = false;

    /**
     * 
     * @return (String)handleGetFullyQualifiedManageableDaoBaseName()
     */
    public final String getFullyQualifiedManageableDaoBaseName()
    {
        String afullyQualifiedManageableDaoBaseName20a = this.fullyQualifiedManageableDaoBaseName20a;
        if (!this.fullyQualifiedManageableDaoBaseName20aSet)
        {
            // fullyQualifiedManageableDaoBaseName has no pre constraints
            afullyQualifiedManageableDaoBaseName20a = handleGetFullyQualifiedManageableDaoBaseName();
            // fullyQualifiedManageableDaoBaseName has no post constraints
            this.fullyQualifiedManageableDaoBaseName20a = afullyQualifiedManageableDaoBaseName20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedManageableDaoBaseName20aSet = true;
            }
        }
        return afullyQualifiedManageableDaoBaseName20a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getFullyQualifiedManageableDaoName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedManageableDaoName();

    private String fullyQualifiedManageableDaoName21a;
    private boolean fullyQualifiedManageableDaoName21aSet = false;

    /**
     * 
     * @return (String)handleGetFullyQualifiedManageableDaoName()
     */
    public final String getFullyQualifiedManageableDaoName()
    {
        String afullyQualifiedManageableDaoName21a = this.fullyQualifiedManageableDaoName21a;
        if (!this.fullyQualifiedManageableDaoName21aSet)
        {
            // fullyQualifiedManageableDaoName has no pre constraints
            afullyQualifiedManageableDaoName21a = handleGetFullyQualifiedManageableDaoName();
            // fullyQualifiedManageableDaoName has no post constraints
            this.fullyQualifiedManageableDaoName21a = afullyQualifiedManageableDaoName21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedManageableDaoName21aSet = true;
            }
        }
        return afullyQualifiedManageableDaoName21a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getFullyQualifiedManageableValueObjectName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedManageableValueObjectName();

    private String fullyQualifiedManageableValueObjectName22a;
    private boolean fullyQualifiedManageableValueObjectName22aSet = false;

    /**
     * 
     * @return (String)handleGetFullyQualifiedManageableValueObjectName()
     */
    public final String getFullyQualifiedManageableValueObjectName()
    {
        String afullyQualifiedManageableValueObjectName22a = this.fullyQualifiedManageableValueObjectName22a;
        if (!this.fullyQualifiedManageableValueObjectName22aSet)
        {
            // fullyQualifiedManageableValueObjectName has no pre constraints
            afullyQualifiedManageableValueObjectName22a = handleGetFullyQualifiedManageableValueObjectName();
            // fullyQualifiedManageableValueObjectName has no post constraints
            this.fullyQualifiedManageableValueObjectName22a = afullyQualifiedManageableValueObjectName22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedManageableValueObjectName22aSet = true;
            }
        }
        return afullyQualifiedManageableValueObjectName22a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade#getDaoReferenceName()
    * @return String
    */
    protected abstract String handleGetDaoReferenceName();

    private String daoReferenceName23a;
    private boolean daoReferenceName23aSet = false;

    /**
     * 
     * @return (String)handleGetDaoReferenceName()
     */
    public final String getDaoReferenceName()
    {
        String adaoReferenceName23a = this.daoReferenceName23a;
        if (!this.daoReferenceName23aSet)
        {
            // daoReferenceName has no pre constraints
            adaoReferenceName23a = handleGetDaoReferenceName();
            // daoReferenceName has no post constraints
            this.daoReferenceName23a = adaoReferenceName23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.daoReferenceName23aSet = true;
            }
        }
        return adaoReferenceName23a;
    }

    /**
     * @return true
     * @see EJB3EntityFacade
     */
    public boolean isEJB3EntityFacadeMetaType()
    {
        return true;
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

    // ----------- delegates to EJB3EntityFacade ------------
    /**
     * Find all associations that define relations to other entities.
     * This method returns the source association ends for all associations that define
     * a container managed relation.  The returned collection includes both
     * direct relations and inherited relations. A direct relation is an association with some other
     * class matching the following criteria: 1) The class at the other side of the association is
     * stereotyped <<Entity>> 2) The association is navigable from to the other side.
     * An inherited relation is an association from an abstract super type matching the following
     * criteria: 1) The inheritance path to this abstract super type, including this super type
     * itself, consists only of abstract classes with stereotype <<Entity>> 2)  The class at the
     * other side of the association is stereotyped <<Entity>>. 3) The association is navigable from
     * this abstract super type to the other side.
     * Relations must match the following integrity constraint:
     * - The <<Entity>> at the target end is not abstract.
     * The integrity constraint is necessary because the target of a container managed relation in
     * the EJB framework must be a concrete entity bean; there is no such thing as an
     * "abstract entity bean" in the EJB specification. It is possible, however, to generate and
     * compile code for this case, an error will only show up at deploy time. In order to catch
     * this kind of error at the earliest possible stage, this method checks the integrity
     * constraint and throws an exception if it is violated.
     * @see EJB3EntityFacade#getAllEntityRelations()
     */
    public Collection getAllEntityRelations()
    {
        return this.getSuperEJB3EntityFacade().getAllEntityRelations();
    }

    /**
     * All instanceAttributes for this entity. The list includes the instanceAttributes that are
     * inherited from super classes. The list contains the inherited instanceAttributes first,
     * followed by the instanceAttributes defined in this class.
     * @see EJB3EntityFacade#getAllInstanceAttributes()
     */
    public List getAllInstanceAttributes()
    {
        return this.getSuperEJB3EntityFacade().getAllInstanceAttributes();
    }

    /**
     * Returns all value object references (this includes all those that are inherited from any
     * parent entities)
     * @see EJB3EntityFacade#getAllValueObjectReferences()
     */
    public Collection<DependencyFacade> getAllValueObjectReferences()
    {
        return this.getSuperEJB3EntityFacade().getAllValueObjectReferences();
    }

    /**
     * Create a comma separated list of attributes. This method can be used to generate argument
     * lists for constructors, method calls etc. It will not return attributes tagged to be
     * optimistic lock values.  It will consider LOB attributes where the LOB type has been
     * overriden using the @androma.persistence.lob.type tagged value.
     * @see EJB3EntityFacade#getAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames, boolean includeAutoIdentifiers)
     */
    public String getAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames, boolean includeAutoIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getAttributesAsList(attributes, includeTypes, includeNames, includeAutoIdentifiers);
    }

    /**
     * Gets the Spring bean name, and optionally adds a target suffix, if 'targetSuffix' is set to
     * true.
     * @see EJB3EntityFacade#getBeanName(boolean targetSuffix)
     */
    public String getBeanName(boolean targetSuffix)
    {
        return this.getSuperEJB3EntityFacade().getBeanName(targetSuffix);
    }

    /**
     * Provides the cache policy for the entity.
     * Posible values are NONE, READ_WRITE, NONSTRICT_READ_WRITE, READ_ONLY, TRANSACTIONAL.
     * @see EJB3EntityFacade#getCacheType()
     */
    public String getCacheType()
    {
        return this.getSuperEJB3EntityFacade().getCacheType();
    }

    /**
     * Gets all constants for this entity. Constants are defined as static read-only attributes
     * which do NOT have the <<EnvEntry>> stereotype.   If 'follow' is true, then the inheritance
     * hierarchy will be followed and we'll retrieve all constants from any super types as well.
     * @see EJB3EntityFacade#getConstants(boolean follow)
     */
    public Collection getConstants(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getConstants(follow);
    }

    /**
     * Gets create methods for the entity.  If 'follow'l is set to true, create methods from any
     * super types will also be retrieved by following up the inheritance chain.
     * @see EJB3EntityFacade#getCreateMethods(boolean follow)
     */
    public Collection getCreateMethods(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getCreateMethods(follow);
    }

    /**
     * The DAO base class name.  This is the abstract DAO that containsCRUD operations as well as
     * any generated finders defined on an entity.
     * @see EJB3EntityFacade#getDaoBaseName()
     */
    public String getDaoBaseName()
    {
        return this.getSuperEJB3EntityFacade().getDaoBaseName();
    }

    /**
     * The business operations modeled on the entity that will be generated on the DAO (Data Access
     * Object).
     * @see EJB3EntityFacade#getDaoBusinessOperations()
     */
    public Collection<EJB3OperationFacade> getDaoBusinessOperations()
    {
        return this.getSuperEJB3EntityFacade().getDaoBusinessOperations();
    }

    /**
     * Returns the default DAO exception name.
     * @see EJB3EntityFacade#getDaoDefaultExceptionName()
     */
    public String getDaoDefaultExceptionName()
    {
        return this.getSuperEJB3EntityFacade().getDaoDefaultExceptionName();
    }

    /**
     * The DAO implementation class name.
     * @see EJB3EntityFacade#getDaoImplementationName()
     */
    public String getDaoImplementationName()
    {
        return this.getSuperEJB3EntityFacade().getDaoImplementationName();
    }

    /**
     * The name of the DAO for the specified entity.
     * @see EJB3EntityFacade#getDaoName()
     */
    public String getDaoName()
    {
        return this.getSuperEJB3EntityFacade().getDaoName();
    }

    /**
     * The constant name denoting no transformation is to be applied.
     * @see EJB3EntityFacade#getDaoNoTransformationConstantName()
     */
    public String getDaoNoTransformationConstantName()
    {
        return this.getSuperEJB3EntityFacade().getDaoNoTransformationConstantName();
    }

    /**
     * Returns the default entity cascadable property attribute looked up in the namespace
     * descriptor.
     * @see EJB3EntityFacade#getDefaultCascadeType()
     */
    public String getDefaultCascadeType()
    {
        return this.getSuperEJB3EntityFacade().getDefaultCascadeType();
    }

    /**
     * Returns the default persistence context unit name for the injected EntityManger for the
     * DAO/Manageable service beans.  It is derived from the persistenceContextUnitName namespace
     * property.
     * @see EJB3EntityFacade#getDefaultPersistenceContextUnitName()
     */
    public String getDefaultPersistenceContextUnitName()
    {
        return this.getSuperEJB3EntityFacade().getDefaultPersistenceContextUnitName();
    }

    /**
     * The name of the discriminator column.  Default is TYPE if this is missing.
     * @see EJB3EntityFacade#getDiscriminatorColumn()
     */
    public String getDiscriminatorColumn()
    {
        return this.getSuperEJB3EntityFacade().getDiscriminatorColumn();
    }

    /**
     * The SQL used when generating the DDL for the discriminator column.
     * @see EJB3EntityFacade#getDiscriminatorColumnDefinition()
     */
    public String getDiscriminatorColumnDefinition()
    {
        return this.getSuperEJB3EntityFacade().getDiscriminatorColumnDefinition();
    }

    /**
     * The standard length of a discriminator value.  Default is 10.
     * @see EJB3EntityFacade#getDiscriminatorLength()
     */
    public int getDiscriminatorLength()
    {
        return this.getSuperEJB3EntityFacade().getDiscriminatorLength();
    }

    /**
     * The type of the entity discriminator column.  Default is STRING.
     * @see EJB3EntityFacade#getDiscriminatorType()
     */
    public String getDiscriminatorType()
    {
        return this.getSuperEJB3EntityFacade().getDiscriminatorType();
    }

    /**
     * The value indicating the row in an entity of the annotated entity type.
     * @see EJB3EntityFacade#getDiscriminatorValue()
     */
    public String getDiscriminatorValue()
    {
        return this.getSuperEJB3EntityFacade().getDiscriminatorValue();
    }

    /**
     * Entity composite primary key class name for this entity.
     * @see EJB3EntityFacade#getEntityCompositePrimaryKeyName()
     */
    public String getEntityCompositePrimaryKeyName()
    {
        return this.getSuperEJB3EntityFacade().getEntityCompositePrimaryKeyName();
    }

    /**
     * Entity embeddable super class name this entity inherits from.
     * @see EJB3EntityFacade#getEntityEmbeddableName()
     */
    public String getEntityEmbeddableName()
    {
        return this.getSuperEJB3EntityFacade().getEntityEmbeddableName();
    }

    /**
     * The name of the implementation class.
     * @see EJB3EntityFacade#getEntityImplementationName()
     */
    public String getEntityImplementationName()
    {
        return this.getSuperEJB3EntityFacade().getEntityImplementationName();
    }

    /**
     * Entity listener class name for callback methods.
     * @see EJB3EntityFacade#getEntityListenerName()
     */
    public String getEntityListenerName()
    {
        return this.getSuperEJB3EntityFacade().getEntityListenerName();
    }

    /**
     * The named used for the EJB3 entity.
     * @see EJB3EntityFacade#getEntityName()
     */
    public String getEntityName()
    {
        return this.getSuperEJB3EntityFacade().getEntityName();
    }

    /**
     * 
     * @see EJB3EntityFacade#getEntityRelations()
     */
    public Collection getEntityRelations()
    {
        return this.getSuperEJB3EntityFacade().getEntityRelations();
    }

    /**
     * Gets all env-entries for the specified entity EJB. Env-entries are stored as static
     * attributes on the entity and stereotyped as <<EnvEntry>>.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all env-entries from any super
     * types as well.
     * @see EJB3EntityFacade#getEnvironmentEntries(boolean follow)
     */
    public Collection getEnvironmentEntries(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getEnvironmentEntries(follow);
    }

    /**
     * The fully qualified name of the base DAO.
     * @see EJB3EntityFacade#getFullyQualifiedDaoBaseName()
     */
    public String getFullyQualifiedDaoBaseName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedDaoBaseName();
    }

    /**
     * Returns the fully qualified default DAO exception name.
     * @see EJB3EntityFacade#getFullyQualifiedDaoDefaultExceptionName()
     */
    public String getFullyQualifiedDaoDefaultExceptionName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedDaoDefaultExceptionName();
    }

    /**
     * The fully qualified name of the DAO implemetation.
     * @see EJB3EntityFacade#getFullyQualifiedDaoImplementationName()
     */
    public String getFullyQualifiedDaoImplementationName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedDaoImplementationName();
    }

    /**
     * The fully qualified name of the DAO.
     * @see EJB3EntityFacade#getFullyQualifiedDaoName()
     */
    public String getFullyQualifiedDaoName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedDaoName();
    }

    /**
     * The fully qualified name of the composite primary key class of this entity.
     * @see EJB3EntityFacade#getFullyQualifiedEntityCompositePrimaryKeyName()
     */
    public String getFullyQualifiedEntityCompositePrimaryKeyName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedEntityCompositePrimaryKeyName();
    }

    /**
     * The fully qualified name of the embeddable super class of this entity.
     * @see EJB3EntityFacade#getFullyQualifiedEntityEmbeddableName()
     */
    public String getFullyQualifiedEntityEmbeddableName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedEntityEmbeddableName();
    }

    /**
     * Fully qualified name of the Entity implementation class.
     * @see EJB3EntityFacade#getFullyQualifiedEntityImplementationName()
     */
    public String getFullyQualifiedEntityImplementationName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedEntityImplementationName();
    }

    /**
     * Fully qualified name of the Entity listner class holding entity callback methods.
     * @see EJB3EntityFacade#getFullyQualifiedEntityListenerName()
     */
    public String getFullyQualifiedEntityListenerName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedEntityListenerName();
    }

    /**
     * The fully qualified name of the EJB3 entity.
     * @see EJB3EntityFacade#getFullyQualifiedEntityName()
     */
    public String getFullyQualifiedEntityName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedEntityName();
    }

    /**
     * A String representing the name of a home interface for this entity EJB.
     * @see EJB3EntityFacade#getHomeInterfaceName()
     */
    public String getHomeInterfaceName()
    {
        return this.getSuperEJB3EntityFacade().getHomeInterfaceName();
    }

    /**
     * Returns the attribute identifier.
     * @see EJB3EntityFacade#getIdentifier()
     */
    public EJB3EntityAttributeFacade getIdentifier()
    {
        return this.getSuperEJB3EntityFacade().getIdentifier();
    }

    /**
     * Return the value of the andromda_persistence_inheritance tagged value which is an enumeration
     * containing SINGLE_TABLE, TABLE_PER_CLASS or JOINED.
     * @see EJB3EntityFacade#getInheritanceStrategy()
     */
    public String getInheritanceStrategy()
    {
        return this.getSuperEJB3EntityFacade().getInheritanceStrategy();
    }

    /**
     * All inherited instanceAttributes this class.  The instanceAttributes are grouped by the class
     * that defines the instanceAttributes, with instanceAttributes from the most removed super
     * class first.
     * @see EJB3EntityFacade#getInheritedInstanceAttributes()
     */
    public List getInheritedInstanceAttributes()
    {
        return this.getSuperEJB3EntityFacade().getInheritedInstanceAttributes();
    }

    /**
     * Gets a comma separated list of instance attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include instance attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see EJB3EntityFacade#getInstanceAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getInstanceAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getInstanceAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of instance attribute types.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include instance attribute types in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see EJB3EntityFacade#getInstanceAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getInstanceAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getInstanceAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Gets all instance attributes of the entity, and optionally retieves the super entities
     * instance attributes as well as excludes the entity's identifiers if 'withIdentifiers' is set
     * to false.
     * @see EJB3EntityFacade#getInstanceAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection getInstanceAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getInstanceAttributes(follow, withIdentifiers);
    }

    /**
     * 
     * @see EJB3EntityFacade#getJndiName()
     */
    public String getJndiName()
    {
        return this.getSuperEJB3EntityFacade().getJndiName();
    }

    /**
     * 
     * @see EJB3EntityFacade#getManageableDisplayAttribute()
     */
    public AttributeFacade getManageableDisplayAttribute()
    {
        return this.getSuperEJB3EntityFacade().getManageableDisplayAttribute();
    }

    /**
     * 
     * @see EJB3EntityFacade#getNonRunAsRoles()
     */
    public Collection<Role> getNonRunAsRoles()
    {
        return this.getSuperEJB3EntityFacade().getNonRunAsRoles();
    }

    /**
     * Returns the comma separated list of roles allowd to execute DAO operations.  This is defined
     * by actor dependencies on the entity.
     * @see EJB3EntityFacade#getRolesAllowed()
     */
    public String getRolesAllowed()
    {
        return this.getSuperEJB3EntityFacade().getRolesAllowed();
    }

    /**
     * Travels up the inheritance hierarchy and retrieves the root of this entity.  If the root is
     * the entity itself then just the entity is returned.
     * @see EJB3EntityFacade#getRoot()
     */
    public EJB3EntityFacade getRoot()
    {
        return this.getSuperEJB3EntityFacade().getRoot();
    }

    /**
     * Returns the Seam component name for the class.
     * @see EJB3EntityFacade#getSeamComponentName()
     */
    public String getSeamComponentName()
    {
        return this.getSuperEJB3EntityFacade().getSeamComponentName();
    }

    /**
     * Returns the seam component scope type if one is specified.
     * @see EJB3EntityFacade#getSeamComponentScopeType()
     */
    public String getSeamComponentScopeType()
    {
        return this.getSuperEJB3EntityFacade().getSeamComponentScopeType();
    }

    /**
     * Returns the security domain value.  Specified using the securityRealm namespace property or
     * overriden in the andromda.ejb.security.realm tagged value.
     * @see EJB3EntityFacade#getSecurityRealm()
     */
    public String getSecurityRealm()
    {
        return this.getSuperEJB3EntityFacade().getSecurityRealm();
    }

    /**
     * Gets select methods for the entity, if all is set to 'true' then ALL select methods will be
     * retrieved (including those inherited from any superclasses).
     * @see EJB3EntityFacade#getSelectMethods(boolean follow)
     */
    public Collection getSelectMethods(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getSelectMethods(follow);
    }

    /**
     * 
     * @see EJB3EntityFacade#getSqlType()
     */
    public String getSqlType()
    {
        return this.getSuperEJB3EntityFacade().getSqlType();
    }

    /**
     * 
     * @see EJB3EntityFacade#getValueDependencies()
     */
    public Collection getValueDependencies()
    {
        return this.getSuperEJB3EntityFacade().getValueDependencies();
    }

    /**
     * Retrieves the value object dependencies for this entity without inherited object references.
     * @see EJB3EntityFacade#getValueObjectReferences()
     */
    public Collection<DependencyFacade> getValueObjectReferences()
    {
        return this.getSuperEJB3EntityFacade().getValueObjectReferences();
    }

    /**
     * Retrieves the values object references for this entity.  If <code>follow</code> is true, then
     * all value object references (including those that were inherited) will be retrieved.
     * @see EJB3EntityFacade#getValueObjectReferences(boolean follow)
     */
    public Collection getValueObjectReferences(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getValueObjectReferences(follow);
    }

    /**
     * A string indicating whether the Bean is a local or remotely accessable bean.
     * @see EJB3EntityFacade#getViewType()
     */
    public String getViewType()
    {
        return this.getSuperEJB3EntityFacade().getViewType();
    }

    /**
     * 
     * @see EJB3EntityFacade#isAttributePresent(String att)
     */
    public boolean isAttributePresent(String att)
    {
        return this.getSuperEJB3EntityFacade().isAttributePresent(att);
    }

    /**
     * Returns true if caching has been enabled via namespace property hibernateEnableCache.
     * @see EJB3EntityFacade#isCacheEnabled()
     */
    public boolean isCacheEnabled()
    {
        return this.getSuperEJB3EntityFacade().isCacheEnabled();
    }

    /**
     * Returns true if a composite primary key exists for this entity bean.  A composite primary key
     * consists of 2 or more entity identifiers.
     * @see EJB3EntityFacade#isCompositePrimaryKeyPresent()
     */
    public boolean isCompositePrimaryKeyPresent()
    {
        return this.getSuperEJB3EntityFacade().isCompositePrimaryKeyPresent();
    }

    /**
     * Indicates whether or not any business DAO operations are present.
     * @see EJB3EntityFacade#isDaoBusinessOperationsPresent()
     */
    public boolean isDaoBusinessOperationsPresent()
    {
        return this.getSuperEJB3EntityFacade().isDaoBusinessOperationsPresent();
    }

    /**
     * True if an implementation is required for the dao class, this is the case when there are
     * business operations or value-object transformation.
     * @see EJB3EntityFacade#isDaoImplementationRequired()
     */
    public boolean isDaoImplementationRequired()
    {
        return this.getSuperEJB3EntityFacade().isDaoImplementationRequired();
    }

    /**
     * Determines if this entity is an mapped/embeddable super class.
     * @see EJB3EntityFacade#isEmbeddableSuperclass()
     */
    public boolean isEmbeddableSuperclass()
    {
        return this.getSuperEJB3EntityFacade().isEmbeddableSuperclass();
    }

    /**
     * Returns true if this entity is a subclass of an mapped/embeddable super class.  You cannot
     * have more than 1 level of inheritance using mapped/embeddable super class.  To achieve
     * multiple levels, use one of the inheritance mapping strategies like single table, table per
     * class or joined table strategies.
     * @see EJB3EntityFacade#isEmbeddableSuperclassGeneralizationExists()
     */
    public boolean isEmbeddableSuperclassGeneralizationExists()
    {
        return this.getSuperEJB3EntityFacade().isEmbeddableSuperclassGeneralizationExists();
    }

    /**
     * True if an entity implementation is required for the entity class, this is the case when
     * there are business operations.
     * @see EJB3EntityFacade#isEntityImplementationRequired()
     */
    public boolean isEntityImplementationRequired()
    {
        return this.getSuperEJB3EntityFacade().isEntityImplementationRequired();
    }

    /**
     * Returns true if the findAll finder method (specified as a query method) has been modelled.
     * @see EJB3EntityFacade#isFinderFindAllExists()
     */
    public boolean isFinderFindAllExists()
    {
        return this.getSuperEJB3EntityFacade().isFinderFindAllExists();
    }

    /**
     * Returns true if the finder findByPrimaryKey has been modelled.
     * @see EJB3EntityFacade#isFinderFindByPrimaryKeyExists()
     */
    public boolean isFinderFindByPrimaryKeyExists()
    {
        return this.getSuperEJB3EntityFacade().isFinderFindByPrimaryKeyExists();
    }

    /**
     * Returns true if the generic finder property is true.  This will create generic finder static
     * methods in the entity POJO like findByPrimaryKey and findAll.
     * @see EJB3EntityFacade#isGenericFinders()
     */
    public boolean isGenericFinders()
    {
        return this.getSuperEJB3EntityFacade().isGenericFinders();
    }

    /**
     * 
     * @see EJB3EntityFacade#isIdentifierPresent(String id)
     */
    public boolean isIdentifierPresent(String id)
    {
        return this.getSuperEJB3EntityFacade().isIdentifierPresent(id);
    }

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as JOINED.
     * @see EJB3EntityFacade#isInheritanceJoined()
     */
    public boolean isInheritanceJoined()
    {
        return this.getSuperEJB3EntityFacade().isInheritanceJoined();
    }

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as SINGLE_TABLE.
     * @see EJB3EntityFacade#isInheritanceSingleTable()
     */
    public boolean isInheritanceSingleTable()
    {
        return this.getSuperEJB3EntityFacade().isInheritanceSingleTable();
    }

    /**
     * Return true if the entity inheritance strategy as specified by the tagged value
     * andromda_persistence_inheritance is defined as TABLE_PER_CLASS.
     * @see EJB3EntityFacade#isInheritanceTablePerClass()
     */
    public boolean isInheritanceTablePerClass()
    {
        return this.getSuperEJB3EntityFacade().isInheritanceTablePerClass();
    }

    /**
     * Returns true if this entity bean has the stereotype Listener.  False otherwise.
     * @see EJB3EntityFacade#isListenerEnabled()
     */
    public boolean isListenerEnabled()
    {
        return this.getSuperEJB3EntityFacade().isListenerEnabled();
    }

    /**
     * Returns true if this entity is assigned the Manageable stereotype.  False otherwise.
     * @see EJB3EntityFacade#isManageable()
     */
    public boolean isManageable()
    {
        return this.getSuperEJB3EntityFacade().isManageable();
    }

    /**
     * 
     * @see EJB3EntityFacade#isOperationPresent(String op)
     */
    public boolean isOperationPresent(String op)
    {
        return this.getSuperEJB3EntityFacade().isOperationPresent(op);
    }

    /**
     * Returns true if the entity requires generalization mapping.  The Inheritance annotation is
     * required for child entities for all inheritance strategies.
     * @see EJB3EntityFacade#isRequiresGeneralizationMapping()
     */
    public boolean isRequiresGeneralizationMapping()
    {
        return this.getSuperEJB3EntityFacade().isRequiresGeneralizationMapping();
    }

    /**
     * Returns true if the entity requires specialization mapping.  The Inheritance annotation is
     * required for parent entities for all inheritance strategies.
     * @see EJB3EntityFacade#isRequiresSpecializationMapping()
     */
    public boolean isRequiresSpecializationMapping()
    {
        return this.getSuperEJB3EntityFacade().isRequiresSpecializationMapping();
    }

    /**
     * Returns true if this entity has the <<Seam>> stereotype modelled indicating it is a Seam
     * entity component.
     * @see EJB3EntityFacade#isSeamComponent()
     */
    public boolean isSeamComponent()
    {
        return this.getSuperEJB3EntityFacade().isSeamComponent();
    }

    /**
     * Returns true if the security realm is specified.  This will generate the security setting for
     * the DAO components.
     * @see EJB3EntityFacade#isSecurityEnabled()
     */
    public boolean isSecurityEnabled()
    {
        return this.getSuperEJB3EntityFacade().isSecurityEnabled();
    }

    /**
     * Whether or not to allow a synthetic (auto generated) create method.
     * @see EJB3EntityFacade#isSyntheticCreateMethodAllowed()
     */
    public boolean isSyntheticCreateMethodAllowed()
    {
        return this.getSuperEJB3EntityFacade().isSyntheticCreateMethodAllowed();
    }

    /**
     * Return true if a unique cache region is NOT required for entities and queries.  This means we
     * use the default cache region specified by the container.  Specified via the
     * useDefaultCacheRegion namepsace property.
     * @see EJB3EntityFacade#isUseDefaultCacheRegion()
     */
    public boolean isUseDefaultCacheRegion()
    {
        return this.getSuperEJB3EntityFacade().isUseDefaultCacheRegion();
    }

    /**
     * Returns true if the application wide namespace property hibernateUseQueryCache is enabled. 
     * This is used for generic finder methods i.e. findAll.
     * @see EJB3EntityFacade#isUseQueryCache()
     */
    public boolean isUseQueryCache()
    {
        return this.getSuperEJB3EntityFacade().isUseQueryCache();
    }

    /**
     * Return the attribute which name matches the parameter
     * @see ClassifierFacade#findAttribute(String name)
     */
    public AttributeFacade findAttribute(String name)
    {
        return this.getSuperEJB3EntityFacade().findAttribute(name);
    }

    /**
     * Those abstraction dependencies for which this classifier is the client.
     * @see ClassifierFacade#getAbstractions()
     */
    public Collection<ClassifierFacade> getAbstractions()
    {
        return this.getSuperEJB3EntityFacade().getAbstractions();
    }

    /**
     * Lists all classes associated to this one and any ancestor classes (through generalization).
     * There will be no duplicates. The order of the elements is predictable.
     * @see ClassifierFacade#getAllAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAllAssociatedClasses()
    {
        return this.getSuperEJB3EntityFacade().getAllAssociatedClasses();
    }

    /**
     * A collection containing all 'properties' of the classifier and its ancestors.  Properties are
     * any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllProperties()
     */
    public Collection<ModelElementFacade> getAllProperties()
    {
        return this.getSuperEJB3EntityFacade().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getAllRequiredConstructorParameters()
    {
        return this.getSuperEJB3EntityFacade().getAllRequiredConstructorParameters();
    }

    /**
     * Gets the array type for this classifier.  If this classifier already represents an array, it
     * just returns itself.
     * @see ClassifierFacade#getArray()
     */
    public ClassifierFacade getArray()
    {
        return this.getSuperEJB3EntityFacade().getArray();
    }

    /**
     * The name of the classifier as an array.
     * @see ClassifierFacade#getArrayName()
     */
    public String getArrayName()
    {
        return this.getSuperEJB3EntityFacade().getArrayName();
    }

    /**
     * Lists the classes associated to this one, there is no repitition of classes. The order of the
     * elements is predictable.
     * @see ClassifierFacade#getAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAssociatedClasses()
    {
        return this.getSuperEJB3EntityFacade().getAssociatedClasses();
    }

    /**
     * Gets the association ends belonging to a classifier.
     * @see ClassifierFacade#getAssociationEnds()
     */
    public List<AssociationEndFacade> getAssociationEnds()
    {
        return this.getSuperEJB3EntityFacade().getAssociationEnds();
    }

    /**
     * Gets the attributes that belong to the classifier.
     * @see ClassifierFacade#getAttributes()
     */
    public List<AttributeFacade> getAttributes()
    {
        return this.getSuperEJB3EntityFacade().getAttributes();
    }

    /**
     * Gets all attributes for the classifier and if 'follow' is true goes up the inheritance
     * hierarchy and gets the attributes from the super classes as well.
     * @see ClassifierFacade#getAttributes(boolean follow)
     */
    public List<AttributeFacade> getAttributes(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getAttributes(follow);
    }

    /**
     * The fully qualified name of the classifier as an array.
     * @see ClassifierFacade#getFullyQualifiedArrayName()
     */
    public String getFullyQualifiedArrayName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedArrayName();
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
        return this.getSuperEJB3EntityFacade().getImplementationOperations();
    }

    /**
     * A comma separated list of the fully qualified names of all implemented interfaces.
     * @see ClassifierFacade#getImplementedInterfaceList()
     */
    public String getImplementedInterfaceList()
    {
        return this.getSuperEJB3EntityFacade().getImplementedInterfaceList();
    }

    /**
     * Those attributes that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceAttributes()
     */
    public Collection<AttributeFacade> getInstanceAttributes()
    {
        return this.getSuperEJB3EntityFacade().getInstanceAttributes();
    }

    /**
     * Those operations that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceOperations()
     */
    public List<OperationFacade> getInstanceOperations()
    {
        return this.getSuperEJB3EntityFacade().getInstanceOperations();
    }

    /**
     * Those interfaces that are abstractions of this classifier, this basically means this
     * classifier realizes them.
     * @see ClassifierFacade#getInterfaceAbstractions()
     */
    public Collection<ClassifierFacade> getInterfaceAbstractions()
    {
        return this.getSuperEJB3EntityFacade().getInterfaceAbstractions();
    }

    /**
     * A String representing a new Constructor declaration for this classifier type to be used in a
     * Java environment.
     * @see ClassifierFacade#getJavaNewString()
     */
    public String getJavaNewString()
    {
        return this.getSuperEJB3EntityFacade().getJavaNewString();
    }

    /**
     * A String representing the null-value for this classifier type to be used in a Java
     * environment.
     * @see ClassifierFacade#getJavaNullString()
     */
    public String getJavaNullString()
    {
        return this.getSuperEJB3EntityFacade().getJavaNullString();
    }

    /**
     * The other ends of this classifier's association ends which are navigable.
     * @see ClassifierFacade#getNavigableConnectingEnds()
     */
    public Collection<ClassifierFacade> getNavigableConnectingEnds()
    {
        return this.getSuperEJB3EntityFacade().getNavigableConnectingEnds();
    }

    /**
     * Get the other ends of this classifier's association ends which are navigable and if 'follow'
     * is true goes up the inheritance hierarchy and gets the super association ends as well.
     * @see ClassifierFacade#getNavigableConnectingEnds(boolean follow)
     */
    public List<AssociationEndFacade> getNavigableConnectingEnds(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getNavigableConnectingEnds(follow);
    }

    /**
     * Assuming that the classifier is an array, this will return the non array type of the
     * classifier from
     * the model.  If the classifier is NOT an array, it will just return itself.
     * @see ClassifierFacade#getNonArray()
     */
    public ClassifierFacade getNonArray()
    {
        return this.getSuperEJB3EntityFacade().getNonArray();
    }

    /**
     * The attributes from this classifier in the form of an operation call (this example would be
     * in Java): '(String attributeOne, String attributeTwo).  If there were no attributes on the
     * classifier, the result would be an empty '()'.
     * @see ClassifierFacade#getOperationCallFromAttributes()
     */
    public String getOperationCallFromAttributes()
    {
        return this.getSuperEJB3EntityFacade().getOperationCallFromAttributes();
    }

    /**
     * The operations owned by this classifier.
     * @see ClassifierFacade#getOperations()
     */
    public List<OperationFacade> getOperations()
    {
        return this.getSuperEJB3EntityFacade().getOperations();
    }

    /**
     * A collection containing all 'properties' of the classifier.  Properties are any attributes
     * and navigable connecting association ends.
     * @see ClassifierFacade#getProperties()
     */
    public List<ModelElementFacade> getProperties()
    {
        return this.getSuperEJB3EntityFacade().getProperties();
    }

    /**
     * Gets all properties (attributes and navigable association ends) for the classifier and if
     * 'follow' is true goes up the inheritance hierarchy and gets the properties from the super
     * classes as well.
     * @see ClassifierFacade#getProperties(boolean follow)
     */
    public List getProperties(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getProperties(follow);
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier. 
     * Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getRequiredConstructorParameters()
    {
        return this.getSuperEJB3EntityFacade().getRequiredConstructorParameters();
    }

    /**
     * Returns the serial version UID of the underlying model element.
     * @see ClassifierFacade#getSerialVersionUID()
     */
    public long getSerialVersionUID()
    {
        return this.getSuperEJB3EntityFacade().getSerialVersionUID();
    }

    /**
     * Those attributes that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticAttributes()
     */
    public Collection<AttributeFacade> getStaticAttributes()
    {
        return this.getSuperEJB3EntityFacade().getStaticAttributes();
    }

    /**
     * Those operations that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticOperations()
     */
    public List<OperationFacade> getStaticOperations()
    {
        return this.getSuperEJB3EntityFacade().getStaticOperations();
    }

    /**
     * This class' superclass, returns the generalization if it is a ClassifierFacade, null
     * otherwise.
     * @see ClassifierFacade#getSuperClass()
     */
    public ClassifierFacade getSuperClass()
    {
        return this.getSuperEJB3EntityFacade().getSuperClass();
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
        return this.getSuperEJB3EntityFacade().getWrapperName();
    }

    /**
     * Indicates if this classifier is 'abstract'.
     * @see ClassifierFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperEJB3EntityFacade().isAbstract();
    }

    /**
     * True if this classifier represents an array type. False otherwise.
     * @see ClassifierFacade#isArrayType()
     */
    public boolean isArrayType()
    {
        return this.getSuperEJB3EntityFacade().isArrayType();
    }

    /**
     * 
     * @see ClassifierFacade#isAssociationClass()
     */
    public boolean isAssociationClass()
    {
        return this.getSuperEJB3EntityFacade().isAssociationClass();
    }

    /**
     * Returns true if this type represents a Blob type.
     * @see ClassifierFacade#isBlobType()
     */
    public boolean isBlobType()
    {
        return this.getSuperEJB3EntityFacade().isBlobType();
    }

    /**
     * Indicates if this type represents a boolean type or not.
     * @see ClassifierFacade#isBooleanType()
     */
    public boolean isBooleanType()
    {
        return this.getSuperEJB3EntityFacade().isBooleanType();
    }

    /**
     * Indicates if this type represents a char, Character, or java.lang.Character type or not.
     * @see ClassifierFacade#isCharacterType()
     */
    public boolean isCharacterType()
    {
        return this.getSuperEJB3EntityFacade().isCharacterType();
    }

    /**
     * Returns true if this type represents a Clob type.
     * @see ClassifierFacade#isClobType()
     */
    public boolean isClobType()
    {
        return this.getSuperEJB3EntityFacade().isClobType();
    }

    /**
     * True if this classifier represents a collection type. False otherwise.
     * @see ClassifierFacade#isCollectionType()
     */
    public boolean isCollectionType()
    {
        return this.getSuperEJB3EntityFacade().isCollectionType();
    }

    /**
     * True/false depending on whether or not this classifier represents a datatype. A data type is
     * a type whose instances are identified only by their value. A data type may contain attributes
     * to support the modeling of structured data types.
     * @see ClassifierFacade#isDataType()
     */
    public boolean isDataType()
    {
        return this.getSuperEJB3EntityFacade().isDataType();
    }

    /**
     * True when this classifier is a date type.
     * @see ClassifierFacade#isDateType()
     */
    public boolean isDateType()
    {
        return this.getSuperEJB3EntityFacade().isDateType();
    }

    /**
     * Indicates if this type represents a Double type or not.
     * @see ClassifierFacade#isDoubleType()
     */
    public boolean isDoubleType()
    {
        return this.getSuperEJB3EntityFacade().isDoubleType();
    }

    /**
     * Indicates whether or not this classifier represents an "EmbeddedValue'.
     * @see ClassifierFacade#isEmbeddedValue()
     */
    public boolean isEmbeddedValue()
    {
        return this.getSuperEJB3EntityFacade().isEmbeddedValue();
    }

    /**
     * True if this classifier is in fact marked as an enumeration.
     * @see ClassifierFacade#isEnumeration()
     */
    public boolean isEnumeration()
    {
        return this.getSuperEJB3EntityFacade().isEnumeration();
    }

    /**
     * Returns true if this type represents a 'file' type.
     * @see ClassifierFacade#isFileType()
     */
    public boolean isFileType()
    {
        return this.getSuperEJB3EntityFacade().isFileType();
    }

    /**
     * Indicates if this type represents a Float type or not.
     * @see ClassifierFacade#isFloatType()
     */
    public boolean isFloatType()
    {
        return this.getSuperEJB3EntityFacade().isFloatType();
    }

    /**
     * Indicates if this type represents an int or Integer or java.lang.Integer type or not.
     * @see ClassifierFacade#isIntegerType()
     */
    public boolean isIntegerType()
    {
        return this.getSuperEJB3EntityFacade().isIntegerType();
    }

    /**
     * True/false depending on whether or not this Classifier represents an interface.
     * @see ClassifierFacade#isInterface()
     */
    public boolean isInterface()
    {
        return this.getSuperEJB3EntityFacade().isInterface();
    }

    /**
     * True if this classifier cannot be extended and represent a leaf in the inheritance tree.
     * @see ClassifierFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperEJB3EntityFacade().isLeaf();
    }

    /**
     * True if this classifier represents a list type. False otherwise.
     * @see ClassifierFacade#isListType()
     */
    public boolean isListType()
    {
        return this.getSuperEJB3EntityFacade().isListType();
    }

    /**
     * Indicates if this type represents a Long type or not.
     * @see ClassifierFacade#isLongType()
     */
    public boolean isLongType()
    {
        return this.getSuperEJB3EntityFacade().isLongType();
    }

    /**
     * Indicates whether or not this classifier represents a Map type.
     * @see ClassifierFacade#isMapType()
     */
    public boolean isMapType()
    {
        return this.getSuperEJB3EntityFacade().isMapType();
    }

    /**
     * Indicates whether or not this classifier represents a primitive type.
     * @see ClassifierFacade#isPrimitive()
     */
    public boolean isPrimitive()
    {
        return this.getSuperEJB3EntityFacade().isPrimitive();
    }

    /**
     * True if this classifier represents a set type. False otherwise.
     * @see ClassifierFacade#isSetType()
     */
    public boolean isSetType()
    {
        return this.getSuperEJB3EntityFacade().isSetType();
    }

    /**
     * Indicates whether or not this classifier represents a string type.
     * @see ClassifierFacade#isStringType()
     */
    public boolean isStringType()
    {
        return this.getSuperEJB3EntityFacade().isStringType();
    }

    /**
     * Indicates whether or not this classifier represents a time type.
     * @see ClassifierFacade#isTimeType()
     */
    public boolean isTimeType()
    {
        return this.getSuperEJB3EntityFacade().isTimeType();
    }

    /**
     * Returns true if this type is a wrapped primitive type.
     * @see ClassifierFacade#isWrappedPrimitive()
     */
    public boolean isWrappedPrimitive()
    {
        return this.getSuperEJB3EntityFacade().isWrappedPrimitive();
    }

    /**
     * Returns a collection of all entities this entity and its ancestors have a relation to.
     * @see org.andromda.metafacades.uml.Entity#getAllEntityReferences()
     */
    public Collection<DependencyFacade> getAllEntityReferences()
    {
        return this.getSuperEJB3EntityFacade().getAllEntityReferences();
    }

    /**
     * Gets a comma separated list of attribute names.  If 'follow' is true, will travel up the
     * inheritance hiearchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see org.andromda.metafacades.uml.Entity#getAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getAttributeNameList(follow, withIdentifiers);
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
        return this.getSuperEJB3EntityFacade().getAttributeNameList(follow, withIdentifiers, withDerived);
    }

    /**
     * Gets a comma separated list of attribute types.  If 'follow' is true, will travel up the
     * inheritance hierarchy to include attributes in parent entities as well.  If 'withIdentifiers'
     * is true, will include identifiers.
     * @see org.andromda.metafacades.uml.Entity#getAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false.
     * @see org.andromda.metafacades.uml.Entity#getAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getAttributes(follow, withIdentifiers);
    }

    /**
     * Gets all attributes of the entity, and optionally retieves the super entities attributes as
     * well as excludes the entity's identifiers if 'withIdentifiers' is set to false and exclude
     * derived attributes if 'withDerived' is set to false.
     * @see org.andromda.metafacades.uml.Entity#getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
     */
    public Collection<AttributeFacade> getAttributes(boolean follow, boolean withIdentifiers, boolean withDerived)
    {
        return this.getSuperEJB3EntityFacade().getAttributes(follow, withIdentifiers, withDerived);
    }

    /**
     * All business operations of the entity, these include any operations that aren't queries.
     * @see org.andromda.metafacades.uml.Entity#getBusinessOperations()
     */
    public Collection<OperationFacade> getBusinessOperations()
    {
        return this.getSuperEJB3EntityFacade().getBusinessOperations();
    }

    /**
     * Gets any children association ends (i.e. entity association ends that are participants in an
     * association with this entity and this entity has composite aggregation defined for those
     * associations).
     * @see org.andromda.metafacades.uml.Entity#getChildEnds()
     */
    public Collection<EntityAssociationEnd> getChildEnds()
    {
        return this.getSuperEJB3EntityFacade().getChildEnds();
    }

    /**
     * The embedded values belonging to this entity.
     * @see org.andromda.metafacades.uml.Entity#getEmbeddedValues()
     */
    public Collection<AttributeFacade> getEmbeddedValues()
    {
        return this.getSuperEJB3EntityFacade().getEmbeddedValues();
    }

    /**
     * All entities referenced by this entity.
     * @see org.andromda.metafacades.uml.Entity#getEntityReferences()
     */
    public Collection<DependencyFacade> getEntityReferences()
    {
        return this.getSuperEJB3EntityFacade().getEntityReferences();
    }

    /**
     * The full name of the type of the identifier. If composite identifier add the PK sufix to the
     * class name. If not, retorns the fully qualified name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getFullyQualifiedIdentifierTypeName()
     */
    public String getFullyQualifiedIdentifierTypeName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedIdentifierTypeName();
    }

    /**
     * Gets all the associationEnds of this entity marked with the identifiers stereotype.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierAssociationEnds()
     */
    public Collection<AssociationEndFacade> getIdentifierAssociationEnds()
    {
        return this.getSuperEJB3EntityFacade().getIdentifierAssociationEnds();
    }

    /**
     * The getter name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierGetterName()
     */
    public String getIdentifierGetterName()
    {
        return this.getSuperEJB3EntityFacade().getIdentifierGetterName();
    }

    /**
     * The name of the identifier. If composite identifier add the Pk suffix. If not composite
     * returns the attribute name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierName()
     */
    public String getIdentifierName()
    {
        return this.getSuperEJB3EntityFacade().getIdentifierName();
    }

    /**
     * The setter name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierSetterName()
     */
    public String getIdentifierSetterName()
    {
        return this.getSuperEJB3EntityFacade().getIdentifierSetterName();
    }

    /**
     * The name of the type of the identifier. If composite identifier add the PK suffix to the
     * class name. If not, returns the name of the identifier.
     * @see org.andromda.metafacades.uml.Entity#getIdentifierTypeName()
     */
    public String getIdentifierTypeName()
    {
        return this.getSuperEJB3EntityFacade().getIdentifierTypeName();
    }

    /**
     * All the attributes of the entity which make up its identifier (primary key).  Will search any
     * super classes as well.  If no identifiers exist, a default identifier will be created if the
     * allowDefaultIdentifiers property is set to true.
     * @see org.andromda.metafacades.uml.Entity#getIdentifiers()
     */
    public Collection<EntityAttribute> getIdentifiers()
    {
        return this.getSuperEJB3EntityFacade().getIdentifiers();
    }

    /**
     * Gets all identifiers for an entity. If 'follow' is true, and if no identifiers can be found
     * on the entity, a search up the inheritance chain will be performed, and the identifiers from
     * the first super class having them will be used.   If no identifiers exist, a default
     * identifier will be created if the allowDefaultIdentifiers property is set to true.
     * @see org.andromda.metafacades.uml.Entity#getIdentifiers(boolean follow)
     */
    public Collection<EntityAttribute> getIdentifiers(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getIdentifiers(follow);
    }

    /**
     * The maximum length a SQL name may be.
     * @see org.andromda.metafacades.uml.Entity#getMaxSqlNameLength()
     */
    public short getMaxSqlNameLength()
    {
        return this.getSuperEJB3EntityFacade().getMaxSqlNameLength();
    }

    /**
     * Gets the attributes as a list within an operation call, optionally including the type names
     * and the identifier attributes.
     * @see org.andromda.metafacades.uml.Entity#getOperationCallFromAttributes(boolean withIdentifiers)
     */
    public String getOperationCallFromAttributes(boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getOperationCallFromAttributes(withIdentifiers);
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
        return this.getSuperEJB3EntityFacade().getOperationCallFromAttributes(withIdentifiers, follow);
    }

    /**
     * Returns the parent association end of this entity if its a child entity.  The parent is the
     * entity that is the participant the association that has composite aggregation defined.  Will
     * return null if the entity has no parent.
     * @see org.andromda.metafacades.uml.Entity#getParentEnd()
     */
    public EntityAssociationEnd getParentEnd()
    {
        return this.getSuperEJB3EntityFacade().getParentEnd();
    }

    /**
     * Gets all properties of this entity, this includes the attributes and navigable association
     * ends of the entity.  The 'follow' flag indcates whether or not the inheritance hierarchy
     * should be followed when getting all the properties.  The 'withIdentifiers' flag indicates
     * whether or not identifiers should be included in the collection of properties.
     * @see org.andromda.metafacades.uml.Entity#getProperties(boolean follow, boolean withIdentifiers)
     */
    public Collection<ModelElementFacade> getProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getProperties(follow, withIdentifiers);
    }

    /**
     * Returns all the operations that can perform queries on the entity.
     * @see org.andromda.metafacades.uml.Entity#getQueryOperations()
     */
    public Collection<EntityQueryOperation> getQueryOperations()
    {
        return this.getSuperEJB3EntityFacade().getQueryOperations();
    }

    /**
     * Gets all query operations for an entity. If 'follow' is true, and if no query operations can
     * be found on the entity, a search up the inheritance chain will be performed, and the
     * identifiers from the first super class having them will be used.   If no identifiers exist, a
     * default identifier will be created if the allowDefaultIdentifiers property is set to true.
     * @see org.andromda.metafacades.uml.Entity#getQueryOperations(boolean follow)
     */
    public Collection<OperationFacade> getQueryOperations(boolean follow)
    {
        return this.getSuperEJB3EntityFacade().getQueryOperations(follow);
    }

    /**
     * Gets a comma separated list of required attribute names.  If 'follow' is true, will travel up
     * the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see org.andromda.metafacades.uml.Entity#getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getRequiredAttributeNameList(follow, withIdentifiers);
    }

    /**
     * Gets a comma separated list of attribute types with are required.  If 'follow' is true, will
     * travel up the inheritance hierarchy to include attributes in parent entities as well.  If
     * 'withIdentifiers' is true, will include identifiers.
     * @see org.andromda.metafacades.uml.Entity#getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredAttributeTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getRequiredAttributeTypeList(follow, withIdentifiers);
    }

    /**
     * Returns all attributes that are specified as 'required' in the model.  If 'follow' is true,
     * then required attributes in super classes will also be returned, if false, just the ones
     * directly on the entity will be returned.  If 'withIdentifiers' is true, the identifiers will
     * be include, if false, no identifiers will be included.
     * @see org.andromda.metafacades.uml.Entity#getRequiredAttributes(boolean follow, boolean withIdentifiers)
     */
    public Collection<AttributeFacade> getRequiredAttributes(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getRequiredAttributes(follow, withIdentifiers);
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
    public Collection<ModelElementFacade> getRequiredProperties(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getRequiredProperties(follow, withIdentifiers);
    }

    /**
     * Creates a comma separated list of the required property names.
     * @see org.andromda.metafacades.uml.Entity#getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyNameList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getRequiredPropertyNameList(follow, withIdentifiers);
    }

    /**
     * A comma separated list of the required property types.
     * @see org.andromda.metafacades.uml.Entity#getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
     */
    public String getRequiredPropertyTypeList(boolean follow, boolean withIdentifiers)
    {
        return this.getSuperEJB3EntityFacade().getRequiredPropertyTypeList(follow, withIdentifiers);
    }

    /**
     * The name of the schema that contains the database table
     * @see org.andromda.metafacades.uml.Entity#getSchema()
     */
    public String getSchema()
    {
        return this.getSuperEJB3EntityFacade().getSchema();
    }

    /**
     * The name of the database table to which this entity is persisted.
     * @see org.andromda.metafacades.uml.Entity#getTableName()
     */
    public String getTableName()
    {
        return this.getSuperEJB3EntityFacade().getTableName();
    }

    /**
     * Returns true/false depending on whether or not this entity represetns a child in an
     * association (this occurs when this entity is on the opposite end of an assocation end defined
     * as composite).
     * @see org.andromda.metafacades.uml.Entity#isChild()
     */
    public boolean isChild()
    {
        return this.getSuperEJB3EntityFacade().isChild();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.Entity#isCompositeIdentifier()
     */
    public boolean isCompositeIdentifier()
    {
        return this.getSuperEJB3EntityFacade().isCompositeIdentifier();
    }

    /**
     * True if the entity has its identifiers dynamically added, false otherwise.
     * @see org.andromda.metafacades.uml.Entity#isDynamicIdentifiersPresent()
     */
    public boolean isDynamicIdentifiersPresent()
    {
        return this.getSuperEJB3EntityFacade().isDynamicIdentifiersPresent();
    }

    /**
     * True if the entity has any identifiers defined, false otherwise.
     * @see org.andromda.metafacades.uml.Entity#isIdentifiersPresent()
     */
    public boolean isIdentifiersPresent()
    {
        return this.getSuperEJB3EntityFacade().isIdentifiersPresent();
    }

    /**
     * Indiciates if this entity is using an assigned identifier or not.
     * @see org.andromda.metafacades.uml.Entity#isUsingAssignedIdentifier()
     */
    public boolean isUsingAssignedIdentifier()
    {
        return this.getSuperEJB3EntityFacade().isUsingAssignedIdentifier();
    }

    /**
     * Indicates whether or not this entity is using a foreign identifier as its identifiers.  That
     * is: the foreignIdentifier flag was set on an incoming association end and the entity is
     * therefore using the related foreign parent entity's identifier.
     * @see org.andromda.metafacades.uml.Entity#isUsingForeignIdentifier()
     */
    public boolean isUsingForeignIdentifier()
    {
        return this.getSuperEJB3EntityFacade().isUsingForeignIdentifier();
    }

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @see GeneralizableElementFacade#findTaggedValue(String tagName, boolean follow)
     */
    public Object findTaggedValue(String tagName, boolean follow)
    {
        return this.getSuperEJB3EntityFacade().findTaggedValue(tagName, follow);
    }

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @see GeneralizableElementFacade#getAllGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations()
    {
        return this.getSuperEJB3EntityFacade().getAllGeneralizations();
    }

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @see GeneralizableElementFacade#getAllSpecializations()
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations()
    {
        return this.getSuperEJB3EntityFacade().getAllSpecializations();
    }

    /**
     * Gets the direct generalization for this generalizable element.
     * @see GeneralizableElementFacade#getGeneralization()
     */
    public GeneralizableElementFacade getGeneralization()
    {
        return this.getSuperEJB3EntityFacade().getGeneralization();
    }

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @see GeneralizableElementFacade#getGeneralizationLinks()
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks()
    {
        return this.getSuperEJB3EntityFacade().getGeneralizationLinks();
    }

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @see GeneralizableElementFacade#getGeneralizationList()
     */
    public String getGeneralizationList()
    {
        return this.getSuperEJB3EntityFacade().getGeneralizationList();
    }

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @see GeneralizableElementFacade#getGeneralizationRoot()
     */
    public GeneralizableElementFacade getGeneralizationRoot()
    {
        return this.getSuperEJB3EntityFacade().getGeneralizationRoot();
    }

    /**
     * 
     * @see GeneralizableElementFacade#getGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getGeneralizations()
    {
        return this.getSuperEJB3EntityFacade().getGeneralizations();
    }

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @see GeneralizableElementFacade#getSpecializations()
     */
    public Collection<GeneralizableElementFacade> getSpecializations()
    {
        return this.getSuperEJB3EntityFacade().getSpecializations();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperEJB3EntityFacade().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperEJB3EntityFacade().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperEJB3EntityFacade().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperEJB3EntityFacade().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperEJB3EntityFacade().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperEJB3EntityFacade().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperEJB3EntityFacade().getDocumentation(indent);
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
        return this.getSuperEJB3EntityFacade().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperEJB3EntityFacade().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedName();
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
        return this.getSuperEJB3EntityFacade().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperEJB3EntityFacade().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperEJB3EntityFacade().getId();
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
        return this.getSuperEJB3EntityFacade().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperEJB3EntityFacade().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperEJB3EntityFacade().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperEJB3EntityFacade().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperEJB3EntityFacade().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperEJB3EntityFacade().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperEJB3EntityFacade().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperEJB3EntityFacade().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperEJB3EntityFacade().getPackagePath();
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
        return this.getSuperEJB3EntityFacade().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperEJB3EntityFacade().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperEJB3EntityFacade().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperEJB3EntityFacade().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperEJB3EntityFacade().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperEJB3EntityFacade().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperEJB3EntityFacade().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperEJB3EntityFacade().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperEJB3EntityFacade().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperEJB3EntityFacade().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperEJB3EntityFacade().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperEJB3EntityFacade().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperEJB3EntityFacade().hasKeyword(keywordName);
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
        return this.getSuperEJB3EntityFacade().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperEJB3EntityFacade().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperEJB3EntityFacade().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperEJB3EntityFacade().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperEJB3EntityFacade().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperEJB3EntityFacade().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperEJB3EntityFacade().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperEJB3EntityFacade().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperEJB3EntityFacade().translateConstraints(kind, translation);
    }

    // ----------- delegates to ManageableEntity ------------
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
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperEJB3EntityFacade().initialize();
        this.getSuperManageableEntity().initialize();
    }

    /**
     * @return Object getSuperEJB3EntityFacade().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperEJB3EntityFacade().getValidationOwner();
        if (owner == null)
        {
            owner = this.getSuperManageableEntity().getValidationOwner();
        }
        return owner;
    }

    /**
     * @return String getSuperEJB3EntityFacade().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperEJB3EntityFacade().getValidationName();
        if (name == null)
        {
            name = this.getSuperManageableEntity().getValidationName();
        }
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperEJB3EntityFacade().validateInvariants(validationMessages);
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