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
import org.andromda.metafacades.uml.AssociationEndFacade;
import org.andromda.metafacades.uml.AttributeFacade;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Destination;
import org.andromda.metafacades.uml.GeneralizableElementFacade;
import org.andromda.metafacades.uml.GeneralizationFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.Service;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.apache.log4j.Logger;

/**
 * Represents a Session EJB.
 * MetafacadeLogic for EJB3SessionFacade
 *
 * @see EJB3SessionFacade
 */
public abstract class EJB3SessionFacadeLogic
    extends MetafacadeBase
    implements EJB3SessionFacade
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
    protected EJB3SessionFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superService =
           (Service)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.Service",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(EJB3SessionFacadeLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3SessionFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade";
        }
        return context;
    }

    private Service superService;
    private boolean superServiceInitialized = false;

    /**
     * Gets the Service parent instance.
     * @return this.superService Service
     */
    private Service getSuperService()
    {
        if (!this.superServiceInitialized)
        {
            ((MetafacadeBase)this.superService).setMetafacadeContext(this.getMetafacadeContext());
            this.superServiceInitialized = true;
        }
        return this.superService;
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
            if (this.superServiceInitialized)
            {
                ((MetafacadeBase)this.superService).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3SessionFacade
     */
    public boolean isEJB3SessionFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isSyntheticCreateMethodAllowed()
    * @return boolean
    */
    protected abstract boolean handleIsSyntheticCreateMethodAllowed();

    private transient boolean syntheticCreateMethodAllowed1a;
    private transient boolean syntheticCreateMethodAllowed1aSet = false;

    /**
     * Whether or not to allow a synthetic (auto generated) create method.
     * @return (boolean)handleIsSyntheticCreateMethodAllowed()
     */
    public final boolean isSyntheticCreateMethodAllowed()
    {
        boolean syntheticCreateMethodAllowed1a = this.syntheticCreateMethodAllowed1a;
        if (!this.syntheticCreateMethodAllowed1aSet)
        {
            // syntheticCreateMethodAllowed has no pre constraints
            syntheticCreateMethodAllowed1a = handleIsSyntheticCreateMethodAllowed();
            // syntheticCreateMethodAllowed has no post constraints
            this.syntheticCreateMethodAllowed1a = syntheticCreateMethodAllowed1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.syntheticCreateMethodAllowed1aSet = true;
            }
        }
        return syntheticCreateMethodAllowed1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getBusinessOperations()
    * @return Collection
    */
    protected abstract Collection handleGetBusinessOperations();

    private transient Collection businessOperations2a;
    private transient boolean businessOperations2aSet = false;

    /**
     * All "business" operations for this Session EJB.  These are any operations that are NOT
     * identified as create methods.
     * @return (Collection)handleGetBusinessOperations()
     */
    public final Collection getBusinessOperations()
    {
        Collection businessOperations2a = this.businessOperations2a;
        if (!this.businessOperations2aSet)
        {
            // businessOperations has no pre constraints
            businessOperations2a = handleGetBusinessOperations();
            // businessOperations has no post constraints
            this.businessOperations2a = businessOperations2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.businessOperations2aSet = true;
            }
        }
        return businessOperations2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getAllInstanceAttributes()
    * @return List
    */
    protected abstract List handleGetAllInstanceAttributes();

    private transient List allInstanceAttributes3a;
    private transient boolean allInstanceAttributes3aSet = false;

    /**
     * All instanceAttributes for this session EJB. The list includes the instanceAttributes that
     * are inherited from super classes. The list contains the inherited instanceAttributes first,
     * followed by the instanceAttributes defined in this class.
     * @return (List)handleGetAllInstanceAttributes()
     */
    public final List getAllInstanceAttributes()
    {
        List allInstanceAttributes3a = this.allInstanceAttributes3a;
        if (!this.allInstanceAttributes3aSet)
        {
            // allInstanceAttributes has no pre constraints
            allInstanceAttributes3a = handleGetAllInstanceAttributes();
            // allInstanceAttributes has no post constraints
            this.allInstanceAttributes3a = allInstanceAttributes3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.allInstanceAttributes3aSet = true;
            }
        }
        return allInstanceAttributes3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getInheritedInstanceAttributes()
    * @return List
    */
    protected abstract List handleGetInheritedInstanceAttributes();

    private transient List inheritedInstanceAttributes4a;
    private transient boolean inheritedInstanceAttributes4aSet = false;

    /**
     * Alll inherited instanceAttributes this session EJB.  The instanceAttributes are grouped by
     * the class that defines the instanceAttributes, with instanceAttributes from the most removed
     * super class first.
     * @return (List)handleGetInheritedInstanceAttributes()
     */
    public final List getInheritedInstanceAttributes()
    {
        List inheritedInstanceAttributes4a = this.inheritedInstanceAttributes4a;
        if (!this.inheritedInstanceAttributes4aSet)
        {
            // inheritedInstanceAttributes has no pre constraints
            inheritedInstanceAttributes4a = handleGetInheritedInstanceAttributes();
            // inheritedInstanceAttributes has no post constraints
            this.inheritedInstanceAttributes4a = inheritedInstanceAttributes4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inheritedInstanceAttributes4aSet = true;
            }
        }
        return inheritedInstanceAttributes4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getJndiNameRemote()
    * @return String
    */
    protected abstract String handleGetJndiNameRemote();

    private transient String jndiNameRemote5a;
    private transient boolean jndiNameRemote5aSet = false;

    /**
     * The JNDI name to which this session EJB remote interface is bound.
     * @return (String)handleGetJndiNameRemote()
     */
    public final String getJndiNameRemote()
    {
        String jndiNameRemote5a = this.jndiNameRemote5a;
        if (!this.jndiNameRemote5aSet)
        {
            // jndiNameRemote has no pre constraints
            jndiNameRemote5a = handleGetJndiNameRemote();
            // jndiNameRemote has no post constraints
            this.jndiNameRemote5a = jndiNameRemote5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.jndiNameRemote5aSet = true;
            }
        }
        return jndiNameRemote5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isStateful()
    * @return boolean
    */
    protected abstract boolean handleIsStateful();

    private transient boolean stateful6a;
    private transient boolean stateful6aSet = false;

    /**
     * True/false depending on whether or not this Session EJB is stateful or not.
     * @return (boolean)handleIsStateful()
     */
    public final boolean isStateful()
    {
        boolean stateful6a = this.stateful6a;
        if (!this.stateful6aSet)
        {
            // stateful has no pre constraints
            stateful6a = handleIsStateful();
            // stateful has no post constraints
            this.stateful6a = stateful6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.stateful6aSet = true;
            }
        }
        return stateful6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isStateless()
    * @return boolean
    */
    protected abstract boolean handleIsStateless();

    private transient boolean stateless7a;
    private transient boolean stateless7aSet = false;

    /**
     * True/false depending on whether or not this Session EJB is stateless or not.
     * @return (boolean)handleIsStateless()
     */
    public final boolean isStateless()
    {
        boolean stateless7a = this.stateless7a;
        if (!this.stateless7aSet)
        {
            // stateless has no pre constraints
            stateless7a = handleIsStateless();
            // stateless has no post constraints
            this.stateless7a = stateless7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.stateless7aSet = true;
            }
        }
        return stateless7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getType()
    * @return String
    */
    protected abstract String handleGetType();

    private transient String type8a;
    private transient boolean type8aSet = false;

    /**
     * Returns the name of the type of this Session EJB, either Stateless or Stateful.
     * @return (String)handleGetType()
     */
    public final String getType()
    {
        String type8a = this.type8a;
        if (!this.type8aSet)
        {
            // type has no pre constraints
            type8a = handleGetType();
            // type has no post constraints
            this.type8a = type8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.type8aSet = true;
            }
        }
        return type8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getViewType()
    * @return String
    */
    protected abstract String handleGetViewType();

    private transient String viewType9a;
    private transient boolean viewType9aSet = false;

    /**
     * A string indicating whether the Bean is a local or remotely accessable bean.
     * @return (String)handleGetViewType()
     */
    public final String getViewType()
    {
        String viewType9a = this.viewType9a;
        if (!this.viewType9aSet)
        {
            // viewType has no pre constraints
            viewType9a = handleGetViewType();
            // viewType has no post constraints
            this.viewType9a = viewType9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewType9aSet = true;
            }
        }
        return viewType9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getHomeInterfaceName()
    * @return String
    */
    protected abstract String handleGetHomeInterfaceName();

    private transient String homeInterfaceName10a;
    private transient boolean homeInterfaceName10aSet = false;

    /**
     * A String representing the name of a home interface for this entity EJB.
     * @return (String)handleGetHomeInterfaceName()
     */
    public final String getHomeInterfaceName()
    {
        String homeInterfaceName10a = this.homeInterfaceName10a;
        if (!this.homeInterfaceName10aSet)
        {
            // homeInterfaceName has no pre constraints
            homeInterfaceName10a = handleGetHomeInterfaceName();
            // homeInterfaceName has no post constraints
            this.homeInterfaceName10a = homeInterfaceName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.homeInterfaceName10aSet = true;
            }
        }
        return homeInterfaceName10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getTransactionType()
    * @return String
    */
    protected abstract String handleGetTransactionType();

    private transient String transactionType11a;
    private transient boolean transactionType11aSet = false;

    /**
     * Gets the transaction type for this service (i.e. REQUIRED, etc)
     * @return (String)handleGetTransactionType()
     */
    public final String getTransactionType()
    {
        String transactionType11a = this.transactionType11a;
        if (!this.transactionType11aSet)
        {
            // transactionType has no pre constraints
            transactionType11a = handleGetTransactionType();
            // transactionType has no post constraints
            this.transactionType11a = transactionType11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transactionType11aSet = true;
            }
        }
        return transactionType11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceName()
    * @return String
    */
    protected abstract String handleGetServiceName();

    private transient String serviceName12a;
    private transient boolean serviceName12aSet = false;

    /**
     * Returns service bean name.
     * @return (String)handleGetServiceName()
     */
    public final String getServiceName()
    {
        String serviceName12a = this.serviceName12a;
        if (!this.serviceName12aSet)
        {
            // serviceName has no pre constraints
            serviceName12a = handleGetServiceName();
            // serviceName has no post constraints
            this.serviceName12a = serviceName12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceName12aSet = true;
            }
        }
        return serviceName12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceLocalInterfaceName()
    * @return String
    */
    protected abstract String handleGetServiceLocalInterfaceName();

    private transient String serviceLocalInterfaceName13a;
    private transient boolean serviceLocalInterfaceName13aSet = false;

    /**
     * Returns the service bean local interface name.
     * @return (String)handleGetServiceLocalInterfaceName()
     */
    public final String getServiceLocalInterfaceName()
    {
        String serviceLocalInterfaceName13a = this.serviceLocalInterfaceName13a;
        if (!this.serviceLocalInterfaceName13aSet)
        {
            // serviceLocalInterfaceName has no pre constraints
            serviceLocalInterfaceName13a = handleGetServiceLocalInterfaceName();
            // serviceLocalInterfaceName has no post constraints
            this.serviceLocalInterfaceName13a = serviceLocalInterfaceName13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceLocalInterfaceName13aSet = true;
            }
        }
        return serviceLocalInterfaceName13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceRemoteInterfaceName()
    * @return String
    */
    protected abstract String handleGetServiceRemoteInterfaceName();

    private transient String serviceRemoteInterfaceName14a;
    private transient boolean serviceRemoteInterfaceName14aSet = false;

    /**
     * Returns the service bean remote interface name.
     * @return (String)handleGetServiceRemoteInterfaceName()
     */
    public final String getServiceRemoteInterfaceName()
    {
        String serviceRemoteInterfaceName14a = this.serviceRemoteInterfaceName14a;
        if (!this.serviceRemoteInterfaceName14aSet)
        {
            // serviceRemoteInterfaceName has no pre constraints
            serviceRemoteInterfaceName14a = handleGetServiceRemoteInterfaceName();
            // serviceRemoteInterfaceName has no post constraints
            this.serviceRemoteInterfaceName14a = serviceRemoteInterfaceName14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceRemoteInterfaceName14aSet = true;
            }
        }
        return serviceRemoteInterfaceName14a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceImplementationName()
    * @return String
    */
    protected abstract String handleGetServiceImplementationName();

    private transient String serviceImplementationName15a;
    private transient boolean serviceImplementationName15aSet = false;

    /**
     * Returns the service bean implementation name.
     * @return (String)handleGetServiceImplementationName()
     */
    public final String getServiceImplementationName()
    {
        String serviceImplementationName15a = this.serviceImplementationName15a;
        if (!this.serviceImplementationName15aSet)
        {
            // serviceImplementationName has no pre constraints
            serviceImplementationName15a = handleGetServiceImplementationName();
            // serviceImplementationName has no post constraints
            this.serviceImplementationName15a = serviceImplementationName15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceImplementationName15aSet = true;
            }
        }
        return serviceImplementationName15a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceListenerName()
    * @return String
    */
    protected abstract String handleGetServiceListenerName();

    private transient String serviceListenerName16a;
    private transient boolean serviceListenerName16aSet = false;

    /**
     * Returns the service bean callback listener name.
     * @return (String)handleGetServiceListenerName()
     */
    public final String getServiceListenerName()
    {
        String serviceListenerName16a = this.serviceListenerName16a;
        if (!this.serviceListenerName16aSet)
        {
            // serviceListenerName has no pre constraints
            serviceListenerName16a = handleGetServiceListenerName();
            // serviceListenerName has no post constraints
            this.serviceListenerName16a = serviceListenerName16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceListenerName16aSet = true;
            }
        }
        return serviceListenerName16a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceImplementationName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceImplementationName();

    private transient String fullyQualifiedServiceImplementationName17a;
    private transient boolean fullyQualifiedServiceImplementationName17aSet = false;

    /**
     * Returns the fully qualified service bean implementation name.
     * @return (String)handleGetFullyQualifiedServiceImplementationName()
     */
    public final String getFullyQualifiedServiceImplementationName()
    {
        String fullyQualifiedServiceImplementationName17a = this.fullyQualifiedServiceImplementationName17a;
        if (!this.fullyQualifiedServiceImplementationName17aSet)
        {
            // fullyQualifiedServiceImplementationName has no pre constraints
            fullyQualifiedServiceImplementationName17a = handleGetFullyQualifiedServiceImplementationName();
            // fullyQualifiedServiceImplementationName has no post constraints
            this.fullyQualifiedServiceImplementationName17a = fullyQualifiedServiceImplementationName17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceImplementationName17aSet = true;
            }
        }
        return fullyQualifiedServiceImplementationName17a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceListenerName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceListenerName();

    private transient String fullyQualifiedServiceListenerName18a;
    private transient boolean fullyQualifiedServiceListenerName18aSet = false;

    /**
     * Returns the fully qualified service bean listener name.
     * @return (String)handleGetFullyQualifiedServiceListenerName()
     */
    public final String getFullyQualifiedServiceListenerName()
    {
        String fullyQualifiedServiceListenerName18a = this.fullyQualifiedServiceListenerName18a;
        if (!this.fullyQualifiedServiceListenerName18aSet)
        {
            // fullyQualifiedServiceListenerName has no pre constraints
            fullyQualifiedServiceListenerName18a = handleGetFullyQualifiedServiceListenerName();
            // fullyQualifiedServiceListenerName has no post constraints
            this.fullyQualifiedServiceListenerName18a = fullyQualifiedServiceListenerName18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceListenerName18aSet = true;
            }
        }
        return fullyQualifiedServiceListenerName18a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceLocalInterfaceName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceLocalInterfaceName();

    private transient String fullyQualifiedServiceLocalInterfaceName19a;
    private transient boolean fullyQualifiedServiceLocalInterfaceName19aSet = false;

    /**
     * Returns the fully qualified service bean local interface name.
     * @return (String)handleGetFullyQualifiedServiceLocalInterfaceName()
     */
    public final String getFullyQualifiedServiceLocalInterfaceName()
    {
        String fullyQualifiedServiceLocalInterfaceName19a = this.fullyQualifiedServiceLocalInterfaceName19a;
        if (!this.fullyQualifiedServiceLocalInterfaceName19aSet)
        {
            // fullyQualifiedServiceLocalInterfaceName has no pre constraints
            fullyQualifiedServiceLocalInterfaceName19a = handleGetFullyQualifiedServiceLocalInterfaceName();
            // fullyQualifiedServiceLocalInterfaceName has no post constraints
            this.fullyQualifiedServiceLocalInterfaceName19a = fullyQualifiedServiceLocalInterfaceName19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceLocalInterfaceName19aSet = true;
            }
        }
        return fullyQualifiedServiceLocalInterfaceName19a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceRemoteInterfaceName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceRemoteInterfaceName();

    private transient String fullyQualifiedServiceRemoteInterfaceName20a;
    private transient boolean fullyQualifiedServiceRemoteInterfaceName20aSet = false;

    /**
     * Returns the fully qualified service bean remote interface name.
     * @return (String)handleGetFullyQualifiedServiceRemoteInterfaceName()
     */
    public final String getFullyQualifiedServiceRemoteInterfaceName()
    {
        String fullyQualifiedServiceRemoteInterfaceName20a = this.fullyQualifiedServiceRemoteInterfaceName20a;
        if (!this.fullyQualifiedServiceRemoteInterfaceName20aSet)
        {
            // fullyQualifiedServiceRemoteInterfaceName has no pre constraints
            fullyQualifiedServiceRemoteInterfaceName20a = handleGetFullyQualifiedServiceRemoteInterfaceName();
            // fullyQualifiedServiceRemoteInterfaceName has no post constraints
            this.fullyQualifiedServiceRemoteInterfaceName20a = fullyQualifiedServiceRemoteInterfaceName20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceRemoteInterfaceName20aSet = true;
            }
        }
        return fullyQualifiedServiceRemoteInterfaceName20a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getPersistenceContextType()
    * @return String
    */
    protected abstract String handleGetPersistenceContextType();

    private transient String persistenceContextType21a;
    private transient boolean persistenceContextType21aSet = false;

    /**
     * Specifies whether the persistence context for this EntityManager is transaction scoped or
     * extended.
     * @return (String)handleGetPersistenceContextType()
     */
    public final String getPersistenceContextType()
    {
        String persistenceContextType21a = this.persistenceContextType21a;
        if (!this.persistenceContextType21aSet)
        {
            // persistenceContextType has no pre constraints
            persistenceContextType21a = handleGetPersistenceContextType();
            // persistenceContextType has no post constraints
            this.persistenceContextType21a = persistenceContextType21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.persistenceContextType21aSet = true;
            }
        }
        return persistenceContextType21a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getPersistenceContextUnitName()
    * @return String
    */
    protected abstract String handleGetPersistenceContextUnitName();

    private transient String persistenceContextUnitName22a;
    private transient boolean persistenceContextUnitName22aSet = false;

    /**
     * Returns the persistence context unit name for the injected EntityManger.  This is only
     * required if multiple persistence units exists.
     * @return (String)handleGetPersistenceContextUnitName()
     */
    public final String getPersistenceContextUnitName()
    {
        String persistenceContextUnitName22a = this.persistenceContextUnitName22a;
        if (!this.persistenceContextUnitName22aSet)
        {
            // persistenceContextUnitName has no pre constraints
            persistenceContextUnitName22a = handleGetPersistenceContextUnitName();
            // persistenceContextUnitName has no post constraints
            this.persistenceContextUnitName22a = persistenceContextUnitName22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.persistenceContextUnitName22aSet = true;
            }
        }
        return persistenceContextUnitName22a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getPersistenceContextReferences()
    * @return Collection
    */
    protected abstract Collection handleGetPersistenceContextReferences();

    private transient Collection persistenceContextReferences23a;
    private transient boolean persistenceContextReferences23aSet = false;

    /**
     * Returns the Collection of target objects from the service bean class that have a stereotype
     * of PersistenceContext.
     * @return (Collection)handleGetPersistenceContextReferences()
     */
    public final Collection getPersistenceContextReferences()
    {
        Collection persistenceContextReferences23a = this.persistenceContextReferences23a;
        if (!this.persistenceContextReferences23aSet)
        {
            // persistenceContextReferences has no pre constraints
            persistenceContextReferences23a = handleGetPersistenceContextReferences();
            // persistenceContextReferences has no post constraints
            this.persistenceContextReferences23a = persistenceContextReferences23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.persistenceContextReferences23aSet = true;
            }
        }
        return persistenceContextReferences23a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceName();

    private transient String fullyQualifiedServiceName24a;
    private transient boolean fullyQualifiedServiceName24aSet = false;

    /**
     * Returns the fully qualified service bean name.
     * @return (String)handleGetFullyQualifiedServiceName()
     */
    public final String getFullyQualifiedServiceName()
    {
        String fullyQualifiedServiceName24a = this.fullyQualifiedServiceName24a;
        if (!this.fullyQualifiedServiceName24aSet)
        {
            // fullyQualifiedServiceName has no pre constraints
            fullyQualifiedServiceName24a = handleGetFullyQualifiedServiceName();
            // fullyQualifiedServiceName has no post constraints
            this.fullyQualifiedServiceName24a = fullyQualifiedServiceName24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceName24aSet = true;
            }
        }
        return fullyQualifiedServiceName24a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getRolesAllowed()
    * @return String
    */
    protected abstract String handleGetRolesAllowed();

    private transient String rolesAllowed25a;
    private transient boolean rolesAllowed25aSet = false;

    /**
     * Returns the comma separated list of roles allowd to execute all operations in this session
     * bean.  This is defined by actor dependencies on the session bean.
     * @return (String)handleGetRolesAllowed()
     */
    public final String getRolesAllowed()
    {
        String rolesAllowed25a = this.rolesAllowed25a;
        if (!this.rolesAllowed25aSet)
        {
            // rolesAllowed has no pre constraints
            rolesAllowed25a = handleGetRolesAllowed();
            // rolesAllowed has no post constraints
            this.rolesAllowed25a = rolesAllowed25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.rolesAllowed25aSet = true;
            }
        }
        return rolesAllowed25a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isPermitAll()
    * @return boolean
    */
    protected abstract boolean handleIsPermitAll();

    private transient boolean permitAll26a;
    private transient boolean permitAll26aSet = false;

    /**
     * Returns true if all roles are permitted to execute all operations in this session bean.  This
     * is specified in the andromda.ejb.security.permitAll tagged value.  It will override the
     * andromda.ejb.security.rolesAllowed tagged value.
     * @return (boolean)handleIsPermitAll()
     */
    public final boolean isPermitAll()
    {
        boolean permitAll26a = this.permitAll26a;
        if (!this.permitAll26aSet)
        {
            // permitAll has no pre constraints
            permitAll26a = handleIsPermitAll();
            // permitAll has no post constraints
            this.permitAll26a = permitAll26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.permitAll26aSet = true;
            }
        }
        return permitAll26a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSecurityRealm()
    * @return String
    */
    protected abstract String handleGetSecurityRealm();

    private transient String securityRealm27a;
    private transient boolean securityRealm27aSet = false;

    /**
     * Returns the security domain value.  Specified using the securityRealm namespace property or
     * overriden in the andromda.ejb.security.realm tagged value.
     * @return (String)handleGetSecurityRealm()
     */
    public final String getSecurityRealm()
    {
        String securityRealm27a = this.securityRealm27a;
        if (!this.securityRealm27aSet)
        {
            // securityRealm has no pre constraints
            securityRealm27a = handleGetSecurityRealm();
            // securityRealm has no post constraints
            this.securityRealm27a = securityRealm27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.securityRealm27aSet = true;
            }
        }
        return securityRealm27a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getPersistenceContainer()
    * @return String
    */
    protected abstract String handleGetPersistenceContainer();

    private transient String persistenceContainer28a;
    private transient boolean persistenceContainer28aSet = false;

    /**
     * Returns the EJB3 container engine (jboss, weblogic).
     * @return (String)handleGetPersistenceContainer()
     */
    public final String getPersistenceContainer()
    {
        String persistenceContainer28a = this.persistenceContainer28a;
        if (!this.persistenceContainer28aSet)
        {
            // persistenceContainer has no pre constraints
            persistenceContainer28a = handleGetPersistenceContainer();
            // persistenceContainer has no post constraints
            this.persistenceContainer28a = persistenceContainer28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.persistenceContainer28aSet = true;
            }
        }
        return persistenceContainer28a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isPersistenceContainerJboss()
    * @return boolean
    */
    protected abstract boolean handleIsPersistenceContainerJboss();

    private transient boolean persistenceContainerJboss29a;
    private transient boolean persistenceContainerJboss29aSet = false;

    /**
     * Returns true if the persistence container is the JBoss engine.
     * @return (boolean)handleIsPersistenceContainerJboss()
     */
    public final boolean isPersistenceContainerJboss()
    {
        boolean persistenceContainerJboss29a = this.persistenceContainerJboss29a;
        if (!this.persistenceContainerJboss29aSet)
        {
            // persistenceContainerJboss has no pre constraints
            persistenceContainerJboss29a = handleIsPersistenceContainerJboss();
            // persistenceContainerJboss has no post constraints
            this.persistenceContainerJboss29a = persistenceContainerJboss29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.persistenceContainerJboss29aSet = true;
            }
        }
        return persistenceContainerJboss29a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isPersistenceContainerWeblogic()
    * @return boolean
    */
    protected abstract boolean handleIsPersistenceContainerWeblogic();

    private transient boolean persistenceContainerWeblogic30a;
    private transient boolean persistenceContainerWeblogic30aSet = false;

    /**
     * Returns true if the persistence container is the Weblogic engine.
     * @return (boolean)handleIsPersistenceContainerWeblogic()
     */
    public final boolean isPersistenceContainerWeblogic()
    {
        boolean persistenceContainerWeblogic30a = this.persistenceContainerWeblogic30a;
        if (!this.persistenceContainerWeblogic30aSet)
        {
            // persistenceContainerWeblogic has no pre constraints
            persistenceContainerWeblogic30a = handleIsPersistenceContainerWeblogic();
            // persistenceContainerWeblogic has no post constraints
            this.persistenceContainerWeblogic30a = persistenceContainerWeblogic30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.persistenceContainerWeblogic30aSet = true;
            }
        }
        return persistenceContainerWeblogic30a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getRunAs()
    * @return String
    */
    protected abstract String handleGetRunAs();

    private transient String runAs31a;
    private transient boolean runAs31aSet = false;

    /**
     * Returns the run-as identity for the session bean which is used to establish the identity the
     * bean will use when making calls.  It does not affect the identity of the callers.
     * @return (String)handleGetRunAs()
     */
    public final String getRunAs()
    {
        String runAs31a = this.runAs31a;
        if (!this.runAs31aSet)
        {
            // runAs has no pre constraints
            runAs31a = handleGetRunAs();
            // runAs has no post constraints
            this.runAs31a = runAs31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.runAs31aSet = true;
            }
        }
        return runAs31a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isDenyAll()
    * @return boolean
    */
    protected abstract boolean handleIsDenyAll();

    private transient boolean denyAll32a;
    private transient boolean denyAll32aSet = false;

    /**
     * Returns true if NO roles are permitted to execute operations in this bean.  This is specified
     * in the andromda.ejb.security.denyAll tagged value. Typically, it will be overriden at the
     * method level using the andromda.ejb.security.rolesAllowed tagged value.
     * @return (boolean)handleIsDenyAll()
     */
    public final boolean isDenyAll()
    {
        boolean denyAll32a = this.denyAll32a;
        if (!this.denyAll32aSet)
        {
            // denyAll has no pre constraints
            denyAll32a = handleIsDenyAll();
            // denyAll has no post constraints
            this.denyAll32a = denyAll32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.denyAll32aSet = true;
            }
        }
        return denyAll32a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getTransactionManagement()
    * @return String
    */
    protected abstract String handleGetTransactionManagement();

    private transient String transactionManagement33a;
    private transient boolean transactionManagement33aSet = false;

    /**
     * Returns the transaction demarcation strategy for this bean.  Typically, this will return BEAN
     * for non default CONTAINER managed beans.  Unless specified, this will return null indicating
     * CONTAINER transaction demarcation.
     * @return (String)handleGetTransactionManagement()
     */
    public final String getTransactionManagement()
    {
        String transactionManagement33a = this.transactionManagement33a;
        if (!this.transactionManagement33aSet)
        {
            // transactionManagement has no pre constraints
            transactionManagement33a = handleGetTransactionManagement();
            // transactionManagement has no post constraints
            this.transactionManagement33a = transactionManagement33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transactionManagement33aSet = true;
            }
        }
        return transactionManagement33a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isTransactionManagementBean()
    * @return boolean
    */
    protected abstract boolean handleIsTransactionManagementBean();

    private transient boolean transactionManagementBean34a;
    private transient boolean transactionManagementBean34aSet = false;

    /**
     * Returns true if the transaction demarcation strategy is bean managedfor this bean.
     * @return (boolean)handleIsTransactionManagementBean()
     */
    public final boolean isTransactionManagementBean()
    {
        boolean transactionManagementBean34a = this.transactionManagementBean34a;
        if (!this.transactionManagementBean34aSet)
        {
            // transactionManagementBean has no pre constraints
            transactionManagementBean34a = handleIsTransactionManagementBean();
            // transactionManagementBean has no post constraints
            this.transactionManagementBean34a = transactionManagementBean34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transactionManagementBean34aSet = true;
            }
        }
        return transactionManagementBean34a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getResourceUserTransactionReferences()
    * @return Collection
    */
    protected abstract Collection handleGetResourceUserTransactionReferences();

    private transient Collection resourceUserTransactionReferences35a;
    private transient boolean resourceUserTransactionReferences35aSet = false;

    /**
     * Returns the Collection of dependencies from the service bean that have stereotype of
     * ResourceRef and the target has a stereotype of UserTransaction.
     * @return (Collection)handleGetResourceUserTransactionReferences()
     */
    public final Collection getResourceUserTransactionReferences()
    {
        Collection resourceUserTransactionReferences35a = this.resourceUserTransactionReferences35a;
        if (!this.resourceUserTransactionReferences35aSet)
        {
            // resourceUserTransactionReferences has no pre constraints
            resourceUserTransactionReferences35a = handleGetResourceUserTransactionReferences();
            // resourceUserTransactionReferences has no post constraints
            this.resourceUserTransactionReferences35a = resourceUserTransactionReferences35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resourceUserTransactionReferences35aSet = true;
            }
        }
        return resourceUserTransactionReferences35a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getResourceDataSourceReferences()
    * @return Collection
    */
    protected abstract Collection handleGetResourceDataSourceReferences();

    private transient Collection resourceDataSourceReferences36a;
    private transient boolean resourceDataSourceReferences36aSet = false;

    /**
     * Returns the Collection of dependencies from the service bean that have stereotype of
     * ResourceRef and the target has a stereotype of DataSource.
     * @return (Collection)handleGetResourceDataSourceReferences()
     */
    public final Collection getResourceDataSourceReferences()
    {
        Collection resourceDataSourceReferences36a = this.resourceDataSourceReferences36a;
        if (!this.resourceDataSourceReferences36aSet)
        {
            // resourceDataSourceReferences has no pre constraints
            resourceDataSourceReferences36a = handleGetResourceDataSourceReferences();
            // resourceDataSourceReferences has no post constraints
            this.resourceDataSourceReferences36a = resourceDataSourceReferences36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resourceDataSourceReferences36aSet = true;
            }
        }
        return resourceDataSourceReferences36a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getMessageDrivenReferences()
    * @return Collection
    */
    protected abstract Collection handleGetMessageDrivenReferences();

    private transient Collection messageDrivenReferences37a;
    private transient boolean messageDrivenReferences37aSet = false;

    /**
     * Returns the Collection of dependencies from the service bean class where the target class has
     * a stereotype of MessageDriven.
     * @return (Collection)handleGetMessageDrivenReferences()
     */
    public final Collection getMessageDrivenReferences()
    {
        Collection messageDrivenReferences37a = this.messageDrivenReferences37a;
        if (!this.messageDrivenReferences37aSet)
        {
            // messageDrivenReferences has no pre constraints
            messageDrivenReferences37a = handleGetMessageDrivenReferences();
            // messageDrivenReferences has no post constraints
            this.messageDrivenReferences37a = messageDrivenReferences37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageDrivenReferences37aSet = true;
            }
        }
        return messageDrivenReferences37a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceDelegateName()
    * @return String
    */
    protected abstract String handleGetServiceDelegateName();

    private transient String serviceDelegateName38a;
    private transient boolean serviceDelegateName38aSet = false;

    /**
     * Return the service bean delegate class name.
     * @return (String)handleGetServiceDelegateName()
     */
    public final String getServiceDelegateName()
    {
        String serviceDelegateName38a = this.serviceDelegateName38a;
        if (!this.serviceDelegateName38aSet)
        {
            // serviceDelegateName has no pre constraints
            serviceDelegateName38a = handleGetServiceDelegateName();
            // serviceDelegateName has no post constraints
            this.serviceDelegateName38a = serviceDelegateName38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceDelegateName38aSet = true;
            }
        }
        return serviceDelegateName38a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceDelegateName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceDelegateName();

    private transient String fullyQualifiedServiceDelegateName39a;
    private transient boolean fullyQualifiedServiceDelegateName39aSet = false;

    /**
     * Returns the fully qualified service bean delegate class name.
     * @return (String)handleGetFullyQualifiedServiceDelegateName()
     */
    public final String getFullyQualifiedServiceDelegateName()
    {
        String fullyQualifiedServiceDelegateName39a = this.fullyQualifiedServiceDelegateName39a;
        if (!this.fullyQualifiedServiceDelegateName39aSet)
        {
            // fullyQualifiedServiceDelegateName has no pre constraints
            fullyQualifiedServiceDelegateName39a = handleGetFullyQualifiedServiceDelegateName();
            // fullyQualifiedServiceDelegateName has no post constraints
            this.fullyQualifiedServiceDelegateName39a = fullyQualifiedServiceDelegateName39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceDelegateName39aSet = true;
            }
        }
        return fullyQualifiedServiceDelegateName39a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getJndiNameLocal()
    * @return String
    */
    protected abstract String handleGetJndiNameLocal();

    private transient String jndiNameLocal40a;
    private transient boolean jndiNameLocal40aSet = false;

    /**
     * The JNDI name to which this session EJB local interface is bound.
     * @return (String)handleGetJndiNameLocal()
     */
    public final String getJndiNameLocal()
    {
        String jndiNameLocal40a = this.jndiNameLocal40a;
        if (!this.jndiNameLocal40aSet)
        {
            // jndiNameLocal has no pre constraints
            jndiNameLocal40a = handleGetJndiNameLocal();
            // jndiNameLocal has no post constraints
            this.jndiNameLocal40a = jndiNameLocal40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.jndiNameLocal40aSet = true;
            }
        }
        return jndiNameLocal40a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isViewTypeLocal()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeLocal();

    private transient boolean viewTypeLocal41a;
    private transient boolean viewTypeLocal41aSet = false;

    /**
     * Return true if the view type accessability for this bean is local or both.
     * Always generate a local interface is this session bean is a Seam component.
     * @return (boolean)handleIsViewTypeLocal()
     */
    public final boolean isViewTypeLocal()
    {
        boolean viewTypeLocal41a = this.viewTypeLocal41a;
        if (!this.viewTypeLocal41aSet)
        {
            // viewTypeLocal has no pre constraints
            viewTypeLocal41a = handleIsViewTypeLocal();
            // viewTypeLocal has no post constraints
            this.viewTypeLocal41a = viewTypeLocal41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeLocal41aSet = true;
            }
        }
        return viewTypeLocal41a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isViewTypeRemote()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeRemote();

    private transient boolean viewTypeRemote42a;
    private transient boolean viewTypeRemote42aSet = false;

    /**
     * Return true if the view type accessability for this bean is remote or both.
     * @return (boolean)handleIsViewTypeRemote()
     */
    public final boolean isViewTypeRemote()
    {
        boolean viewTypeRemote42a = this.viewTypeRemote42a;
        if (!this.viewTypeRemote42aSet)
        {
            // viewTypeRemote has no pre constraints
            viewTypeRemote42a = handleIsViewTypeRemote();
            // viewTypeRemote has no post constraints
            this.viewTypeRemote42a = viewTypeRemote42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeRemote42aSet = true;
            }
        }
        return viewTypeRemote42a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getInterceptorReferences()
    * @return Collection
    */
    protected abstract Collection handleGetInterceptorReferences();

    private transient Collection interceptorReferences43a;
    private transient boolean interceptorReferences43aSet = false;

    /**
     * Returns the Collection of target elements from the service bean class where  the target class
     * has a stereotype of Interceptor.
     * @return (Collection)handleGetInterceptorReferences()
     */
    public final Collection getInterceptorReferences()
    {
        Collection interceptorReferences43a = this.interceptorReferences43a;
        if (!this.interceptorReferences43aSet)
        {
            // interceptorReferences has no pre constraints
            interceptorReferences43a = handleGetInterceptorReferences();
            // interceptorReferences has no post constraints
            this.interceptorReferences43a = interceptorReferences43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.interceptorReferences43aSet = true;
            }
        }
        return interceptorReferences43a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getDefaultExceptionName()
    * @return String
    */
    protected abstract String handleGetDefaultExceptionName();

    private transient String defaultExceptionName44a;
    private transient boolean defaultExceptionName44aSet = false;

    /**
     * The name of the default exception to be generated for this service.
     * @return (String)handleGetDefaultExceptionName()
     */
    public final String getDefaultExceptionName()
    {
        String defaultExceptionName44a = this.defaultExceptionName44a;
        if (!this.defaultExceptionName44aSet)
        {
            // defaultExceptionName has no pre constraints
            defaultExceptionName44a = handleGetDefaultExceptionName();
            // defaultExceptionName has no post constraints
            this.defaultExceptionName44a = defaultExceptionName44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.defaultExceptionName44aSet = true;
            }
        }
        return defaultExceptionName44a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedDefaultExceptionName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedDefaultExceptionName();

    private transient String fullyQualifiedDefaultExceptionName45a;
    private transient boolean fullyQualifiedDefaultExceptionName45aSet = false;

    /**
     * The fully qualified class name of the default exception.
     * @return (String)handleGetFullyQualifiedDefaultExceptionName()
     */
    public final String getFullyQualifiedDefaultExceptionName()
    {
        String fullyQualifiedDefaultExceptionName45a = this.fullyQualifiedDefaultExceptionName45a;
        if (!this.fullyQualifiedDefaultExceptionName45aSet)
        {
            // fullyQualifiedDefaultExceptionName has no pre constraints
            fullyQualifiedDefaultExceptionName45a = handleGetFullyQualifiedDefaultExceptionName();
            // fullyQualifiedDefaultExceptionName has no post constraints
            this.fullyQualifiedDefaultExceptionName45a = fullyQualifiedDefaultExceptionName45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedDefaultExceptionName45aSet = true;
            }
        }
        return fullyQualifiedDefaultExceptionName45a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isAllowDefaultServiceException()
    * @return boolean
    */
    protected abstract boolean handleIsAllowDefaultServiceException();

    private transient boolean allowDefaultServiceException46a;
    private transient boolean allowDefaultServiceException46aSet = false;

    /**
     * Indicates whether or not a default service exception should be allowed.
     * @return (boolean)handleIsAllowDefaultServiceException()
     */
    public final boolean isAllowDefaultServiceException()
    {
        boolean allowDefaultServiceException46a = this.allowDefaultServiceException46a;
        if (!this.allowDefaultServiceException46aSet)
        {
            // allowDefaultServiceException has no pre constraints
            allowDefaultServiceException46a = handleIsAllowDefaultServiceException();
            // allowDefaultServiceException has no post constraints
            this.allowDefaultServiceException46a = allowDefaultServiceException46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.allowDefaultServiceException46aSet = true;
            }
        }
        return allowDefaultServiceException46a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isListenerEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsListenerEnabled();

    private transient boolean listenerEnabled47a;
    private transient boolean listenerEnabled47aSet = false;

    /**
     * Returns true if this session bean has the stereotype Listener.  False otherwise.
     * @return (boolean)handleIsListenerEnabled()
     */
    public final boolean isListenerEnabled()
    {
        boolean listenerEnabled47a = this.listenerEnabled47a;
        if (!this.listenerEnabled47aSet)
        {
            // listenerEnabled has no pre constraints
            listenerEnabled47a = handleIsListenerEnabled();
            // listenerEnabled has no post constraints
            this.listenerEnabled47a = listenerEnabled47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.listenerEnabled47aSet = true;
            }
        }
        return listenerEnabled47a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getJndiNamePrefix()
    * @return String
    */
    protected abstract String handleGetJndiNamePrefix();

    private transient String jndiNamePrefix48a;
    private transient boolean jndiNamePrefix48aSet = false;

    /**
     * Returns the JNDI name prefix for this session bean.  This is set using the jndiNamePrefix
     * namespace property and is commonly the ear file name excluding the extension for the EJB3
     * cartridge.  This prefix is applied whether the JNDI name is specified or not.
     * If no manual JNDI name is specified, then the prefix is applied like so:
     * jndiPrefix/EJBName/Remote
     * If a manual JNDI name is specified, then the prefix is applied:
     * jndiPrefix/ManualEJBJNDIName
     * @return (String)handleGetJndiNamePrefix()
     */
    public final String getJndiNamePrefix()
    {
        String jndiNamePrefix48a = this.jndiNamePrefix48a;
        if (!this.jndiNamePrefix48aSet)
        {
            // jndiNamePrefix has no pre constraints
            jndiNamePrefix48a = handleGetJndiNamePrefix();
            // jndiNamePrefix has no post constraints
            this.jndiNamePrefix48a = jndiNamePrefix48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.jndiNamePrefix48aSet = true;
            }
        }
        return jndiNamePrefix48a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isSecurityEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsSecurityEnabled();

    private transient boolean securityEnabled49a;
    private transient boolean securityEnabled49aSet = false;

    /**
     * Returns true if the security realm is specified indicating to generate the security
     * infrastructure files.
     * @return (boolean)handleIsSecurityEnabled()
     */
    public final boolean isSecurityEnabled()
    {
        boolean securityEnabled49a = this.securityEnabled49a;
        if (!this.securityEnabled49aSet)
        {
            // securityEnabled has no pre constraints
            securityEnabled49a = handleIsSecurityEnabled();
            // securityEnabled has no post constraints
            this.securityEnabled49a = securityEnabled49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.securityEnabled49aSet = true;
            }
        }
        return securityEnabled49a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isExcludeDefaultInterceptors()
    * @return boolean
    */
    protected abstract boolean handleIsExcludeDefaultInterceptors();

    private transient boolean excludeDefaultInterceptors50a;
    private transient boolean excludeDefaultInterceptors50aSet = false;

    /**
     * Determines whether to exclude the invocation of the default interceptors for all business
     * method in the bean.
     * @return (boolean)handleIsExcludeDefaultInterceptors()
     */
    public final boolean isExcludeDefaultInterceptors()
    {
        boolean excludeDefaultInterceptors50a = this.excludeDefaultInterceptors50a;
        if (!this.excludeDefaultInterceptors50aSet)
        {
            // excludeDefaultInterceptors has no pre constraints
            excludeDefaultInterceptors50a = handleIsExcludeDefaultInterceptors();
            // excludeDefaultInterceptors has no post constraints
            this.excludeDefaultInterceptors50a = excludeDefaultInterceptors50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.excludeDefaultInterceptors50aSet = true;
            }
        }
        return excludeDefaultInterceptors50a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isClusteringEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsClusteringEnabled();

    private transient boolean clusteringEnabled51a;
    private transient boolean clusteringEnabled51aSet = false;

    /**
     * Determine whether clustering has been enabled.  Either set application wide using
     * enableClustering namespace property or via the andromda_service_clustered tagged value.
     * @return (boolean)handleIsClusteringEnabled()
     */
    public final boolean isClusteringEnabled()
    {
        boolean clusteringEnabled51a = this.clusteringEnabled51a;
        if (!this.clusteringEnabled51aSet)
        {
            // clusteringEnabled has no pre constraints
            clusteringEnabled51a = handleIsClusteringEnabled();
            // clusteringEnabled has no post constraints
            this.clusteringEnabled51a = clusteringEnabled51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.clusteringEnabled51aSet = true;
            }
        }
        return clusteringEnabled51a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isWebServiceOperationExists()
    * @return boolean
    */
    protected abstract boolean handleIsWebServiceOperationExists();

    private transient boolean webServiceOperationExists52a;
    private transient boolean webServiceOperationExists52aSet = false;

    /**
     * Returns true if at least one of the session bean operations is marked with the
     * WebServiceOperation stereotype.
     * @return (boolean)handleIsWebServiceOperationExists()
     */
    public final boolean isWebServiceOperationExists()
    {
        boolean webServiceOperationExists52a = this.webServiceOperationExists52a;
        if (!this.webServiceOperationExists52aSet)
        {
            // webServiceOperationExists has no pre constraints
            webServiceOperationExists52a = handleIsWebServiceOperationExists();
            // webServiceOperationExists has no post constraints
            this.webServiceOperationExists52a = webServiceOperationExists52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.webServiceOperationExists52aSet = true;
            }
        }
        return webServiceOperationExists52a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isWebServiceEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsWebServiceEnabled();

    private transient boolean webServiceEnabled53a;
    private transient boolean webServiceEnabled53aSet = false;

    /**
     * Returns true if the session bean has either one of the following:
     * 1. The <<WebService>> stereotype is modelled on the bean class;
     * 2. The <<WebServiceOperation>> stereotype is modelled on at least one business method.
     * @return (boolean)handleIsWebServiceEnabled()
     */
    public final boolean isWebServiceEnabled()
    {
        boolean webServiceEnabled53a = this.webServiceEnabled53a;
        if (!this.webServiceEnabled53aSet)
        {
            // webServiceEnabled has no pre constraints
            webServiceEnabled53a = handleIsWebServiceEnabled();
            // webServiceEnabled has no post constraints
            this.webServiceEnabled53a = webServiceEnabled53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.webServiceEnabled53aSet = true;
            }
        }
        return webServiceEnabled53a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceBaseName()
    * @return String
    */
    protected abstract String handleGetServiceBaseName();

    private transient String serviceBaseName54a;
    private transient boolean serviceBaseName54aSet = false;

    /**
     * Returns the service bean base name.
     * @return (String)handleGetServiceBaseName()
     */
    public final String getServiceBaseName()
    {
        String serviceBaseName54a = this.serviceBaseName54a;
        if (!this.serviceBaseName54aSet)
        {
            // serviceBaseName has no pre constraints
            serviceBaseName54a = handleGetServiceBaseName();
            // serviceBaseName has no post constraints
            this.serviceBaseName54a = serviceBaseName54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceBaseName54aSet = true;
            }
        }
        return serviceBaseName54a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceBaseName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceBaseName();

    private transient String fullyQualifiedServiceBaseName55a;
    private transient boolean fullyQualifiedServiceBaseName55aSet = false;

    /**
     * Returns the fully qualified service base name.
     * @return (String)handleGetFullyQualifiedServiceBaseName()
     */
    public final String getFullyQualifiedServiceBaseName()
    {
        String fullyQualifiedServiceBaseName55a = this.fullyQualifiedServiceBaseName55a;
        if (!this.fullyQualifiedServiceBaseName55aSet)
        {
            // fullyQualifiedServiceBaseName has no pre constraints
            fullyQualifiedServiceBaseName55a = handleGetFullyQualifiedServiceBaseName();
            // fullyQualifiedServiceBaseName has no post constraints
            this.fullyQualifiedServiceBaseName55a = fullyQualifiedServiceBaseName55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceBaseName55aSet = true;
            }
        }
        return fullyQualifiedServiceBaseName55a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isSeamComponent()
    * @return boolean
    */
    protected abstract boolean handleIsSeamComponent();

    private transient boolean seamComponent56a;
    private transient boolean seamComponent56aSet = false;

    /**
     * Returns true if this session bean has the <<Seam>> stereotype modelled indicating it is a
     * Seam session bean component.
     * @return (boolean)handleIsSeamComponent()
     */
    public final boolean isSeamComponent()
    {
        boolean seamComponent56a = this.seamComponent56a;
        if (!this.seamComponent56aSet)
        {
            // seamComponent has no pre constraints
            seamComponent56a = handleIsSeamComponent();
            // seamComponent has no post constraints
            this.seamComponent56a = seamComponent56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponent56aSet = true;
            }
        }
        return seamComponent56a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentScopeType()
    * @return String
    */
    protected abstract String handleGetSeamComponentScopeType();

    private transient String seamComponentScopeType57a;
    private transient boolean seamComponentScopeType57aSet = false;

    /**
     * Tagged value andromda.seam.component.scope. Defines the default context of the component. 
     * Possible values are
     * EVENT
     * PAGE
     * CONVERSATION
     * SESSION
     * BUSINESS_PROCESS
     * APPLICATION
     * STATELESS
     * If no scope specified, default depends on component type.
     * @return (String)handleGetSeamComponentScopeType()
     */
    public final String getSeamComponentScopeType()
    {
        String seamComponentScopeType57a = this.seamComponentScopeType57a;
        if (!this.seamComponentScopeType57aSet)
        {
            // seamComponentScopeType has no pre constraints
            seamComponentScopeType57a = handleGetSeamComponentScopeType();
            // seamComponentScopeType has no post constraints
            this.seamComponentScopeType57a = seamComponentScopeType57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentScopeType57aSet = true;
            }
        }
        return seamComponentScopeType57a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentName()
    * @return String
    */
    protected abstract String handleGetSeamComponentName();

    private transient String seamComponentName58a;
    private transient boolean seamComponentName58aSet = false;

    /**
     * Returns the Seam component name for the class.
     * @return (String)handleGetSeamComponentName()
     */
    public final String getSeamComponentName()
    {
        String seamComponentName58a = this.seamComponentName58a;
        if (!this.seamComponentName58aSet)
        {
            // seamComponentName has no pre constraints
            seamComponentName58a = handleGetSeamComponentName();
            // seamComponentName has no post constraints
            this.seamComponentName58a = seamComponentName58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentName58aSet = true;
            }
        }
        return seamComponentName58a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isViewTypeBoth()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeBoth();

    private transient boolean viewTypeBoth59a;
    private transient boolean viewTypeBoth59aSet = false;

    /**
     * Return true if the view type accessability for this bean is both.
     * @return (boolean)handleIsViewTypeBoth()
     */
    public final boolean isViewTypeBoth()
    {
        boolean viewTypeBoth59a = this.viewTypeBoth59a;
        if (!this.viewTypeBoth59aSet)
        {
            // viewTypeBoth has no pre constraints
            viewTypeBoth59a = handleIsViewTypeBoth();
            // viewTypeBoth has no post constraints
            this.viewTypeBoth59a = viewTypeBoth59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeBoth59aSet = true;
            }
        }
        return viewTypeBoth59a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isViewTypeStrictlyLocal()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeStrictlyLocal();

    private transient boolean viewTypeStrictlyLocal60a;
    private transient boolean viewTypeStrictlyLocal60aSet = false;

    /**
     * Returns true if the bean view type was explicity set to local view using tagged value or set
     * as the app wide default.
     * @return (boolean)handleIsViewTypeStrictlyLocal()
     */
    public final boolean isViewTypeStrictlyLocal()
    {
        boolean viewTypeStrictlyLocal60a = this.viewTypeStrictlyLocal60a;
        if (!this.viewTypeStrictlyLocal60aSet)
        {
            // viewTypeStrictlyLocal has no pre constraints
            viewTypeStrictlyLocal60a = handleIsViewTypeStrictlyLocal();
            // viewTypeStrictlyLocal has no post constraints
            this.viewTypeStrictlyLocal60a = viewTypeStrictlyLocal60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeStrictlyLocal60aSet = true;
            }
        }
        return viewTypeStrictlyLocal60a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isViewTypeStrictlyRemote()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeStrictlyRemote();

    private transient boolean viewTypeStrictlyRemote61a;
    private transient boolean viewTypeStrictlyRemote61aSet = false;

    /**
     * Returns true if the bean view type was explicity set to remote view using tagged value or set
     * as the app wide default.
     * @return (boolean)handleIsViewTypeStrictlyRemote()
     */
    public final boolean isViewTypeStrictlyRemote()
    {
        boolean viewTypeStrictlyRemote61a = this.viewTypeStrictlyRemote61a;
        if (!this.viewTypeStrictlyRemote61aSet)
        {
            // viewTypeStrictlyRemote has no pre constraints
            viewTypeStrictlyRemote61a = handleIsViewTypeStrictlyRemote();
            // viewTypeStrictlyRemote has no post constraints
            this.viewTypeStrictlyRemote61a = viewTypeStrictlyRemote61a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeStrictlyRemote61aSet = true;
            }
        }
        return viewTypeStrictlyRemote61a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isViewTypeStrictlyBoth()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeStrictlyBoth();

    private transient boolean viewTypeStrictlyBoth62a;
    private transient boolean viewTypeStrictlyBoth62aSet = false;

    /**
     * Returns true if the bean view type was explicity set to both view using tagged value or set
     * as the app wide default.
     * @return (boolean)handleIsViewTypeStrictlyBoth()
     */
    public final boolean isViewTypeStrictlyBoth()
    {
        boolean viewTypeStrictlyBoth62a = this.viewTypeStrictlyBoth62a;
        if (!this.viewTypeStrictlyBoth62aSet)
        {
            // viewTypeStrictlyBoth has no pre constraints
            viewTypeStrictlyBoth62a = handleIsViewTypeStrictlyBoth();
            // viewTypeStrictlyBoth has no post constraints
            this.viewTypeStrictlyBoth62a = viewTypeStrictlyBoth62a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeStrictlyBoth62aSet = true;
            }
        }
        return viewTypeStrictlyBoth62a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isSeamComponentStartup()
    * @return boolean
    */
    protected abstract boolean handleIsSeamComponentStartup();

    private transient boolean seamComponentStartup63a;
    private transient boolean seamComponentStartup63aSet = false;

    /**
     * Returns true if stereotype <<Startup>> is set. Specifies that an application scope component
     * is started immediately at initialization time. This is mainly used for certain built-in
     * components that bootstrap critical infrastructure such as JNDI, datasources, etc.
     * @return (boolean)handleIsSeamComponentStartup()
     */
    public final boolean isSeamComponentStartup()
    {
        boolean seamComponentStartup63a = this.seamComponentStartup63a;
        if (!this.seamComponentStartup63aSet)
        {
            // seamComponentStartup has no pre constraints
            seamComponentStartup63a = handleIsSeamComponentStartup();
            // seamComponentStartup has no post constraints
            this.seamComponentStartup63a = seamComponentStartup63a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentStartup63aSet = true;
            }
        }
        return seamComponentStartup63a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentConversionalIfNotBegunOutcome()
    * @return String
    */
    protected abstract String handleGetSeamComponentConversionalIfNotBegunOutcome();

    private transient String seamComponentConversionalIfNotBegunOutcome64a;
    private transient boolean seamComponentConversionalIfNotBegunOutcome64aSet = false;

    /**
     * Tagged value andromda.seam.component.conversional.ifnotbegunoutcome. Specifies that a
     * conversation scope component is conversational, meaning that no method of the component can
     * be called unless a long-running conversation started by this component is active (unless the
     * method would begin a new long-running conversation).
     * @return (String)handleGetSeamComponentConversionalIfNotBegunOutcome()
     */
    public final String getSeamComponentConversionalIfNotBegunOutcome()
    {
        String seamComponentConversionalIfNotBegunOutcome64a = this.seamComponentConversionalIfNotBegunOutcome64a;
        if (!this.seamComponentConversionalIfNotBegunOutcome64aSet)
        {
            // seamComponentConversionalIfNotBegunOutcome has no pre constraints
            seamComponentConversionalIfNotBegunOutcome64a = handleGetSeamComponentConversionalIfNotBegunOutcome();
            // seamComponentConversionalIfNotBegunOutcome has no post constraints
            this.seamComponentConversionalIfNotBegunOutcome64a = seamComponentConversionalIfNotBegunOutcome64a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentConversionalIfNotBegunOutcome64aSet = true;
            }
        }
        return seamComponentConversionalIfNotBegunOutcome64a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentIntercept()
    * @return String
    */
    protected abstract String handleGetSeamComponentIntercept();

    private transient String seamComponentIntercept65a;
    private transient boolean seamComponentIntercept65aSet = false;

    /**
     * Tagged value andromda.seam.component.intercept. Determines when Seam interceptors are active.
     * The possible values are defined by the InterceptionType enumeration: ALWAYS,
     * AFTER_RESTORE_VIEW, AFTER_UPDATE_MODEL_VALUES, INVOKE_APPLICATION, NEVER.
     * When no interception type is explicitly specified, the default depends upon the component
     * type. For entity beans, the default is NEVER. For session beans, message driven beans and
     * JavaBeans, the default is ALWAYS.
     * @return (String)handleGetSeamComponentIntercept()
     */
    public final String getSeamComponentIntercept()
    {
        String seamComponentIntercept65a = this.seamComponentIntercept65a;
        if (!this.seamComponentIntercept65aSet)
        {
            // seamComponentIntercept has no pre constraints
            seamComponentIntercept65a = handleGetSeamComponentIntercept();
            // seamComponentIntercept has no post constraints
            this.seamComponentIntercept65a = seamComponentIntercept65a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentIntercept65aSet = true;
            }
        }
        return seamComponentIntercept65a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentJndiName()
    * @return String
    */
    protected abstract String handleGetSeamComponentJndiName();

    private transient String seamComponentJndiName66a;
    private transient boolean seamComponentJndiName66aSet = false;

    /**
     * Tagged value andromda.seam.component.jndiname. Specifies the JNDI name that Seam will use to
     * look up the EJB component. If no JNDI name is explicitly specified, Seam will use the JNDI
     * pattern specified by org.jboss.seam.core.init.jndiPattern.
     * @return (String)handleGetSeamComponentJndiName()
     */
    public final String getSeamComponentJndiName()
    {
        String seamComponentJndiName66a = this.seamComponentJndiName66a;
        if (!this.seamComponentJndiName66aSet)
        {
            // seamComponentJndiName has no pre constraints
            seamComponentJndiName66a = handleGetSeamComponentJndiName();
            // seamComponentJndiName has no post constraints
            this.seamComponentJndiName66a = seamComponentJndiName66a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentJndiName66aSet = true;
            }
        }
        return seamComponentJndiName66a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isSeamComponentReadonly()
    * @return boolean
    */
    protected abstract boolean handleIsSeamComponentReadonly();

    private transient boolean seamComponentReadonly67a;
    private transient boolean seamComponentReadonly67aSet = false;

    /**
     * Tagged value andromda.seam.component.readonly. Specifies that a JavaBean component or
     * component method does not require state replication at the end of the invocation.
     * @return (boolean)handleIsSeamComponentReadonly()
     */
    public final boolean isSeamComponentReadonly()
    {
        boolean seamComponentReadonly67a = this.seamComponentReadonly67a;
        if (!this.seamComponentReadonly67aSet)
        {
            // seamComponentReadonly has no pre constraints
            seamComponentReadonly67a = handleIsSeamComponentReadonly();
            // seamComponentReadonly has no post constraints
            this.seamComponentReadonly67a = seamComponentReadonly67a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentReadonly67aSet = true;
            }
        }
        return seamComponentReadonly67a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentRoleNames()
    * @return Collection
    */
    protected abstract Collection handleGetSeamComponentRoleNames();

    private transient Collection seamComponentRoleNames68a;
    private transient boolean seamComponentRoleNames68aSet = false;

    /**
     * Tagged value andromda.seam.component.role.name. Allows a Seam component to be bound to
     * multiple contexts variables. The Name/Scope annotations define a "default role". Each Role
     * annotation defines an additional role.
     * This tagged value specifies the context variable name.
     * @return (Collection)handleGetSeamComponentRoleNames()
     */
    public final Collection getSeamComponentRoleNames()
    {
        Collection seamComponentRoleNames68a = this.seamComponentRoleNames68a;
        if (!this.seamComponentRoleNames68aSet)
        {
            // seamComponentRoleNames has no pre constraints
            seamComponentRoleNames68a = handleGetSeamComponentRoleNames();
            // seamComponentRoleNames has no post constraints
            this.seamComponentRoleNames68a = seamComponentRoleNames68a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentRoleNames68aSet = true;
            }
        }
        return seamComponentRoleNames68a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentSynchronizedTimeout()
    * @return String
    */
    protected abstract String handleGetSeamComponentSynchronizedTimeout();

    private transient String seamComponentSynchronizedTimeout69a;
    private transient boolean seamComponentSynchronizedTimeout69aSet = false;

    /**
     * Tagged value andromda.seam.component.synchronized.timeout. Specifies that a component is
     * accessed concurrently by multiple clients, and that Seam should serialize requests. If a
     * request is not able to obtain its lock on the component in the given timeout period, an
     * exception will be raised.
     * @return (String)handleGetSeamComponentSynchronizedTimeout()
     */
    public final String getSeamComponentSynchronizedTimeout()
    {
        String seamComponentSynchronizedTimeout69a = this.seamComponentSynchronizedTimeout69a;
        if (!this.seamComponentSynchronizedTimeout69aSet)
        {
            // seamComponentSynchronizedTimeout has no pre constraints
            seamComponentSynchronizedTimeout69a = handleGetSeamComponentSynchronizedTimeout();
            // seamComponentSynchronizedTimeout has no post constraints
            this.seamComponentSynchronizedTimeout69a = seamComponentSynchronizedTimeout69a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentSynchronizedTimeout69aSet = true;
            }
        }
        return seamComponentSynchronizedTimeout69a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#isSeamComponentTransactional()
    * @return boolean
    */
    protected abstract boolean handleIsSeamComponentTransactional();

    private transient boolean seamComponentTransactional70a;
    private transient boolean seamComponentTransactional70aSet = false;

    /**
     * Returns true if stereotype <<Transactional>> is set. Specifies that a JavaBean component
     * should have a similar transactional behavior to the default behavior of a session bean
     * component. ie. method invocations should take place in a transaction, and if no transaction
     * exists when the method is called, a transaction will be started just for that method. This
     * annotation may be applied at either class or method level.
     * @return (boolean)handleIsSeamComponentTransactional()
     */
    public final boolean isSeamComponentTransactional()
    {
        boolean seamComponentTransactional70a = this.seamComponentTransactional70a;
        if (!this.seamComponentTransactional70aSet)
        {
            // seamComponentTransactional has no pre constraints
            seamComponentTransactional70a = handleIsSeamComponentTransactional();
            // seamComponentTransactional has no post constraints
            this.seamComponentTransactional70a = seamComponentTransactional70a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentTransactional70aSet = true;
            }
        }
        return seamComponentTransactional70a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentStartupParameters()
    * @return String
    */
    protected abstract String handleGetSeamComponentStartupParameters();

    private transient String seamComponentStartupParameters71a;
    private transient boolean seamComponentStartupParameters71aSet = false;

    /**
     * Returns a string with parameters for the Startup annotation. Supported parameters:
     * depends - specifies that the named components must be started first, if they are installed.
     * Specified by tagged value andromda.seam.component.startup.depends
     * @return (String)handleGetSeamComponentStartupParameters()
     */
    public final String getSeamComponentStartupParameters()
    {
        String seamComponentStartupParameters71a = this.seamComponentStartupParameters71a;
        if (!this.seamComponentStartupParameters71aSet)
        {
            // seamComponentStartupParameters has no pre constraints
            seamComponentStartupParameters71a = handleGetSeamComponentStartupParameters();
            // seamComponentStartupParameters has no post constraints
            this.seamComponentStartupParameters71a = seamComponentStartupParameters71a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentStartupParameters71aSet = true;
            }
        }
        return seamComponentStartupParameters71a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getSeamComponentRoleScopeTypes()
    * @return Collection
    */
    protected abstract Collection handleGetSeamComponentRoleScopeTypes();

    private transient Collection seamComponentRoleScopeTypes72a;
    private transient boolean seamComponentRoleScopeTypes72aSet = false;

    /**
     * If multiple roles are specified (since a seam component can be bound to multiple context
     * variables), then multiple roles are specified in the order the role names are specified. 
     * This is done by modelling the andromda.seam.component.role.scope tag with a comma separated
     * list of scopes.
     * @return (Collection)handleGetSeamComponentRoleScopeTypes()
     */
    public final Collection getSeamComponentRoleScopeTypes()
    {
        Collection seamComponentRoleScopeTypes72a = this.seamComponentRoleScopeTypes72a;
        if (!this.seamComponentRoleScopeTypes72aSet)
        {
            // seamComponentRoleScopeTypes has no pre constraints
            seamComponentRoleScopeTypes72a = handleGetSeamComponentRoleScopeTypes();
            // seamComponentRoleScopeTypes has no post constraints
            this.seamComponentRoleScopeTypes72a = seamComponentRoleScopeTypes72a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamComponentRoleScopeTypes72aSet = true;
            }
        }
        return seamComponentRoleScopeTypes72a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceTestName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceTestName();

    private transient String fullyQualifiedServiceTestName73a;
    private transient boolean fullyQualifiedServiceTestName73aSet = false;

    /**
     * Returns the fully qualified service test class name
     * @return (String)handleGetFullyQualifiedServiceTestName()
     */
    public final String getFullyQualifiedServiceTestName()
    {
        String fullyQualifiedServiceTestName73a = this.fullyQualifiedServiceTestName73a;
        if (!this.fullyQualifiedServiceTestName73aSet)
        {
            // fullyQualifiedServiceTestName has no pre constraints
            fullyQualifiedServiceTestName73a = handleGetFullyQualifiedServiceTestName();
            // fullyQualifiedServiceTestName has no post constraints
            this.fullyQualifiedServiceTestName73a = fullyQualifiedServiceTestName73a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceTestName73aSet = true;
            }
        }
        return fullyQualifiedServiceTestName73a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceTestName()
    * @return String
    */
    protected abstract String handleGetServiceTestName();

    private transient String serviceTestName74a;
    private transient boolean serviceTestName74aSet = false;

    /**
     * Returns the service bean test class name
     * @return (String)handleGetServiceTestName()
     */
    public final String getServiceTestName()
    {
        String serviceTestName74a = this.serviceTestName74a;
        if (!this.serviceTestName74aSet)
        {
            // serviceTestName has no pre constraints
            serviceTestName74a = handleGetServiceTestName();
            // serviceTestName has no post constraints
            this.serviceTestName74a = serviceTestName74a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceTestName74aSet = true;
            }
        }
        return serviceTestName74a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getTestPackageName()
    * @return String
    */
    protected abstract String handleGetTestPackageName();

    private transient String testPackageName75a;
    private transient boolean testPackageName75aSet = false;

    /**
     * Returns the service test package name. This simply appends .test to the existing service
     * class package.
     * @return (String)handleGetTestPackageName()
     */
    public final String getTestPackageName()
    {
        String testPackageName75a = this.testPackageName75a;
        if (!this.testPackageName75aSet)
        {
            // testPackageName has no pre constraints
            testPackageName75a = handleGetTestPackageName();
            // testPackageName has no post constraints
            this.testPackageName75a = testPackageName75a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.testPackageName75aSet = true;
            }
        }
        return testPackageName75a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getServiceInterfaceName()
    * @return String
    */
    protected abstract String handleGetServiceInterfaceName();

    private transient String serviceInterfaceName76a;
    private transient boolean serviceInterfaceName76aSet = false;

    /**
     * The parent business interface name for this session bean.
     * @return (String)handleGetServiceInterfaceName()
     */
    public final String getServiceInterfaceName()
    {
        String serviceInterfaceName76a = this.serviceInterfaceName76a;
        if (!this.serviceInterfaceName76aSet)
        {
            // serviceInterfaceName has no pre constraints
            serviceInterfaceName76a = handleGetServiceInterfaceName();
            // serviceInterfaceName has no post constraints
            this.serviceInterfaceName76a = serviceInterfaceName76a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.serviceInterfaceName76aSet = true;
            }
        }
        return serviceInterfaceName76a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade#getFullyQualifiedServiceInterfaceName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedServiceInterfaceName();

    private transient String fullyQualifiedServiceInterfaceName77a;
    private transient boolean fullyQualifiedServiceInterfaceName77aSet = false;

    /**
     * The fully qualified parent business interface name for this session bean.
     * @return (String)handleGetFullyQualifiedServiceInterfaceName()
     */
    public final String getFullyQualifiedServiceInterfaceName()
    {
        String fullyQualifiedServiceInterfaceName77a = this.fullyQualifiedServiceInterfaceName77a;
        if (!this.fullyQualifiedServiceInterfaceName77aSet)
        {
            // fullyQualifiedServiceInterfaceName has no pre constraints
            fullyQualifiedServiceInterfaceName77a = handleGetFullyQualifiedServiceInterfaceName();
            // fullyQualifiedServiceInterfaceName has no post constraints
            this.fullyQualifiedServiceInterfaceName77a = fullyQualifiedServiceInterfaceName77a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedServiceInterfaceName77aSet = true;
            }
        }
        return fullyQualifiedServiceInterfaceName77a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Gets create methods for this session EJB.  If 'follow' is set to true, it will follow the
     * inheritance hierarchy and retrieve those defined on any super types.
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetCreateMethods(boolean follow);

    /**
     * Gets create methods for this session EJB.  If 'follow' is set to true, it will follow the
     * inheritance hierarchy and retrieve those defined on any super types.
     * @param follow boolean
     * If set to true, then all create methods from the super type will also be included.
     * @return handleGetCreateMethods(follow)
     */
    public Collection getCreateMethods(boolean follow)
    {
        // getCreateMethods has no pre constraints
        Collection returnValue = handleGetCreateMethods(follow);
        // getCreateMethods has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets all env-entries for the specified session EJB. Env-entries are stored as static
     * attributes on the entity and stereotyped as <<EnvEntry>>.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all env-entries from any super
     * types as well.
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetEnvironmentEntries(boolean follow);

    /**
     * Gets all env-entries for the specified session EJB. Env-entries are stored as static
     * attributes on the entity and stereotyped as <<EnvEntry>>.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all env-entries from any super
     * types as well.
     * @param follow boolean
     * If true, then the inheritance hierarchy will be followed and we'll retrieve all env-entries
     * from any super types as well.
     * @return handleGetEnvironmentEntries(follow)
     */
    public Collection getEnvironmentEntries(boolean follow)
    {
        // getEnvironmentEntries has no pre constraints
        Collection returnValue = handleGetEnvironmentEntries(follow);
        // getEnvironmentEntries has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Gets all constants for this session EJB. Constants are defined as static read-only attributes
     * which do NOT have the <<EnvEntry>> stereotype.  If 'follow' is true, then the inheritance
     * hierarchy will be followed and we'll retrieve all constants from any super types as well.
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetConstants(boolean follow);

    /**
     * Gets all constants for this session EJB. Constants are defined as static read-only attributes
     * which do NOT have the <<EnvEntry>> stereotype.  If 'follow' is true, then the inheritance
     * hierarchy will be followed and we'll retrieve all constants from any super types as well.
     * @param follow boolean
     * If true, then the inheritance hierarchy will be followed and we'll retrieve all constants
     * from any super types as well.
     * @return handleGetConstants(follow)
     */
    public Collection getConstants(boolean follow)
    {
        // getConstants has no pre constraints
        Collection returnValue = handleGetConstants(follow);
        // getConstants has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Returns the comma separated list of attributes.<p/>This method can be used to generate
     * argument lists for constructors and method calls.
     * @param attributes
     * @param includeTypes
     * @param includeNames
     * @return String
     */
    protected abstract String handleGetAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames);

    /**
     * Returns the comma separated list of attributes.<p/>This method can be used to generate
     * argument lists for constructors and method calls.
     * @param attributes Collection
     * a collection of {@link Attribute} objects
     * @param includeTypes boolean
     * if <code>true</code>, the type names of the attributes are included.
     * @param includeNames boolean
     * if <code>true</code>, the names of the attributes are included
     * @return handleGetAttributesAsList(attributes, includeTypes, includeNames)
     */
    public String getAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames)
    {
        // getAttributesAsList has no pre constraints
        String returnValue = handleGetAttributesAsList(attributes, includeTypes, includeNames);
        // getAttributesAsList has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Filter out seam component attributes
     * @param attributes
     * @return Collection
     */
    protected abstract Collection handleFilterSeamAttributes(Collection attributes);

    /**
     * Filter out seam component attributes
     * @param attributes Collection
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3SessionFacade.filterSeamAttributes(attributes)
     * @return handleFilterSeamAttributes(attributes)
     */
    public Collection filterSeamAttributes(Collection attributes)
    {
        // filterSeamAttributes has no pre constraints
        Collection returnValue = handleFilterSeamAttributes(attributes);
        // filterSeamAttributes has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    /**
     * Represents a Session EJB.
     * @return (Collection<Role>)handleGetNonRunAsRoles()
     */
    public final Collection<Role> getNonRunAsRoles()
    {
        Collection<Role> getNonRunAsRoles1r = null;
        // eJB3SessionFacade has no pre constraints
        Collection result = handleGetNonRunAsRoles();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getNonRunAsRoles1r = (Collection<Role>) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            EJB3SessionFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3SessionFacadeLogic.getNonRunAsRoles Collection<Role> " + result + ": " + shieldedResult);
        }
        // eJB3SessionFacade has no post constraints
        return getNonRunAsRoles1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetNonRunAsRoles();

    /**
     * @return true
     * @see Service
     */
    public boolean isServiceMetaType()
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

    // ----------- delegates to Service ------------
    /**
     * Return the attribute which name matches the parameter
     * @see ClassifierFacade#findAttribute(String name)
     */
    public AttributeFacade findAttribute(String name)
    {
        return this.getSuperService().findAttribute(name);
    }

    /**
     * Those abstraction dependencies for which this classifier is the client.
     * @see ClassifierFacade#getAbstractions()
     */
    public Collection<ClassifierFacade> getAbstractions()
    {
        return this.getSuperService().getAbstractions();
    }

    /**
     * Lists all classes associated to this one and any ancestor classes (through generalization).
     * There will be no duplicates. The order of the elements is predictable.
     * @see ClassifierFacade#getAllAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAllAssociatedClasses()
    {
        return this.getSuperService().getAllAssociatedClasses();
    }

    /**
     * A collection containing all 'properties' of the classifier and its ancestors.  Properties are
     * any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllProperties()
     */
    public Collection<ModelElementFacade> getAllProperties()
    {
        return this.getSuperService().getAllProperties();
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier and its
     * ancestors. Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getAllRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getAllRequiredConstructorParameters()
    {
        return this.getSuperService().getAllRequiredConstructorParameters();
    }

    /**
     * Gets the array type for this classifier.  If this classifier already represents an array, it
     * just returns itself.
     * @see ClassifierFacade#getArray()
     */
    public ClassifierFacade getArray()
    {
        return this.getSuperService().getArray();
    }

    /**
     * The name of the classifier as an array.
     * @see ClassifierFacade#getArrayName()
     */
    public String getArrayName()
    {
        return this.getSuperService().getArrayName();
    }

    /**
     * Lists the classes associated to this one, there is no repitition of classes. The order of the
     * elements is predictable.
     * @see ClassifierFacade#getAssociatedClasses()
     */
    public Collection<ClassifierFacade> getAssociatedClasses()
    {
        return this.getSuperService().getAssociatedClasses();
    }

    /**
     * Gets the association ends belonging to a classifier.
     * @see ClassifierFacade#getAssociationEnds()
     */
    public List<AssociationEndFacade> getAssociationEnds()
    {
        return this.getSuperService().getAssociationEnds();
    }

    /**
     * Gets the attributes that belong to the classifier.
     * @see ClassifierFacade#getAttributes()
     */
    public List<AttributeFacade> getAttributes()
    {
        return this.getSuperService().getAttributes();
    }

    /**
     * Gets all attributes for the classifier and if 'follow' is true goes up the inheritance
     * hierarchy and gets the attributes from the super classes as well.
     * @see ClassifierFacade#getAttributes(boolean follow)
     */
    public List<AttributeFacade> getAttributes(boolean follow)
    {
        return this.getSuperService().getAttributes(follow);
    }

    /**
     * The fully qualified name of the classifier as an array.
     * @see ClassifierFacade#getFullyQualifiedArrayName()
     */
    public String getFullyQualifiedArrayName()
    {
        return this.getSuperService().getFullyQualifiedArrayName();
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
        return this.getSuperService().getImplementationOperations();
    }

    /**
     * A comma separated list of the fully qualified names of all implemented interfaces.
     * @see ClassifierFacade#getImplementedInterfaceList()
     */
    public String getImplementedInterfaceList()
    {
        return this.getSuperService().getImplementedInterfaceList();
    }

    /**
     * Those attributes that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceAttributes()
     */
    public Collection<AttributeFacade> getInstanceAttributes()
    {
        return this.getSuperService().getInstanceAttributes();
    }

    /**
     * Those operations that are scoped to an instance of this class.
     * @see ClassifierFacade#getInstanceOperations()
     */
    public List<OperationFacade> getInstanceOperations()
    {
        return this.getSuperService().getInstanceOperations();
    }

    /**
     * Those interfaces that are abstractions of this classifier, this basically means this
     * classifier realizes them.
     * @see ClassifierFacade#getInterfaceAbstractions()
     */
    public Collection<ClassifierFacade> getInterfaceAbstractions()
    {
        return this.getSuperService().getInterfaceAbstractions();
    }

    /**
     * A String representing a new Constructor declaration for this classifier type to be used in a
     * Java environment.
     * @see ClassifierFacade#getJavaNewString()
     */
    public String getJavaNewString()
    {
        return this.getSuperService().getJavaNewString();
    }

    /**
     * A String representing the null-value for this classifier type to be used in a Java
     * environment.
     * @see ClassifierFacade#getJavaNullString()
     */
    public String getJavaNullString()
    {
        return this.getSuperService().getJavaNullString();
    }

    /**
     * The other ends of this classifier's association ends which are navigable.
     * @see ClassifierFacade#getNavigableConnectingEnds()
     */
    public Collection<AssociationEndFacade> getNavigableConnectingEnds()
    {
        return this.getSuperService().getNavigableConnectingEnds();
    }

    /**
     * Get the other ends of this classifier's association ends which are navigable and if 'follow'
     * is true goes up the inheritance hierarchy and gets the super association ends as well.
     * @see ClassifierFacade#getNavigableConnectingEnds(boolean follow)
     */
    public List<AssociationEndFacade> getNavigableConnectingEnds(boolean follow)
    {
        return this.getSuperService().getNavigableConnectingEnds(follow);
    }

    /**
     * Assuming that the classifier is an array, this will return the non array type of the
     * classifier from
     * the model.  If the classifier is NOT an array, it will just return itself.
     * @see ClassifierFacade#getNonArray()
     */
    public ClassifierFacade getNonArray()
    {
        return this.getSuperService().getNonArray();
    }

    /**
     * The attributes from this classifier in the form of an operation call (this example would be
     * in Java): '(String attributeOne, String attributeTwo).  If there were no attributes on the
     * classifier, the result would be an empty '()'.
     * @see ClassifierFacade#getOperationCallFromAttributes()
     */
    public String getOperationCallFromAttributes()
    {
        return this.getSuperService().getOperationCallFromAttributes();
    }

    /**
     * The operations owned by this classifier.
     * @see ClassifierFacade#getOperations()
     */
    public List<OperationFacade> getOperations()
    {
        return this.getSuperService().getOperations();
    }

    /**
     * A collection containing all 'properties' of the classifier.  Properties are any attributes
     * and navigable connecting association ends.
     * @see ClassifierFacade#getProperties()
     */
    public List<ModelElementFacade> getProperties()
    {
        return this.getSuperService().getProperties();
    }

    /**
     * Gets all properties (attributes and navigable association ends) for the classifier and if
     * 'follow' is true goes up the inheritance hierarchy and gets the properties from the super
     * classes as well.
     * @see ClassifierFacade#getProperties(boolean follow)
     */
    public List getProperties(boolean follow)
    {
        return this.getSuperService().getProperties(follow);
    }

    /**
     * A collection containing all required and/or read-only 'properties' of the classifier. 
     * Properties are any attributes and navigable connecting association ends.
     * @see ClassifierFacade#getRequiredConstructorParameters()
     */
    public Collection<ModelElementFacade> getRequiredConstructorParameters()
    {
        return this.getSuperService().getRequiredConstructorParameters();
    }

    /**
     * Returns the serial version UID of the underlying model element.
     * @see ClassifierFacade#getSerialVersionUID()
     */
    public long getSerialVersionUID()
    {
        return this.getSuperService().getSerialVersionUID();
    }

    /**
     * Those attributes that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticAttributes()
     */
    public Collection<AttributeFacade> getStaticAttributes()
    {
        return this.getSuperService().getStaticAttributes();
    }

    /**
     * Those operations that are scoped to the definition of this class.
     * @see ClassifierFacade#getStaticOperations()
     */
    public List<OperationFacade> getStaticOperations()
    {
        return this.getSuperService().getStaticOperations();
    }

    /**
     * This class' superclass, returns the generalization if it is a ClassifierFacade, null
     * otherwise.
     * @see ClassifierFacade#getSuperClass()
     */
    public ClassifierFacade getSuperClass()
    {
        return this.getSuperService().getSuperClass();
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
        return this.getSuperService().getWrapperName();
    }

    /**
     * Indicates if this classifier is 'abstract'.
     * @see ClassifierFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperService().isAbstract();
    }

    /**
     * True if this classifier represents an array type. False otherwise.
     * @see ClassifierFacade#isArrayType()
     */
    public boolean isArrayType()
    {
        return this.getSuperService().isArrayType();
    }

    /**
     * True if the ClassifierFacade is an AssociationClass.
     * @see ClassifierFacade#isAssociationClass()
     */
    public boolean isAssociationClass()
    {
        return this.getSuperService().isAssociationClass();
    }

    /**
     * Returns true if this type represents a Blob type.
     * @see ClassifierFacade#isBlobType()
     */
    public boolean isBlobType()
    {
        return this.getSuperService().isBlobType();
    }

    /**
     * Indicates if this type represents a boolean type or not.
     * @see ClassifierFacade#isBooleanType()
     */
    public boolean isBooleanType()
    {
        return this.getSuperService().isBooleanType();
    }

    /**
     * Indicates if this type represents a char, Character, or java.lang.Character type or not.
     * @see ClassifierFacade#isCharacterType()
     */
    public boolean isCharacterType()
    {
        return this.getSuperService().isCharacterType();
    }

    /**
     * Returns true if this type represents a Clob type.
     * @see ClassifierFacade#isClobType()
     */
    public boolean isClobType()
    {
        return this.getSuperService().isClobType();
    }

    /**
     * True if this classifier represents a collection type. False otherwise.
     * @see ClassifierFacade#isCollectionType()
     */
    public boolean isCollectionType()
    {
        return this.getSuperService().isCollectionType();
    }

    /**
     * True/false depending on whether or not this classifier represents a datatype. A data type is
     * a type whose instances are identified only by their value. A data type may contain attributes
     * to support the modeling of structured data types.
     * @see ClassifierFacade#isDataType()
     */
    public boolean isDataType()
    {
        return this.getSuperService().isDataType();
    }

    /**
     * True when this classifier is a date type.
     * @see ClassifierFacade#isDateType()
     */
    public boolean isDateType()
    {
        return this.getSuperService().isDateType();
    }

    /**
     * Indicates if this type represents a Double type or not.
     * @see ClassifierFacade#isDoubleType()
     */
    public boolean isDoubleType()
    {
        return this.getSuperService().isDoubleType();
    }

    /**
     * Indicates whether or not this classifier represents an "EmbeddedValue'.
     * @see ClassifierFacade#isEmbeddedValue()
     */
    public boolean isEmbeddedValue()
    {
        return this.getSuperService().isEmbeddedValue();
    }

    /**
     * True if this classifier is in fact marked as an enumeration.
     * @see ClassifierFacade#isEnumeration()
     */
    public boolean isEnumeration()
    {
        return this.getSuperService().isEnumeration();
    }

    /**
     * Returns true if this type represents a 'file' type.
     * @see ClassifierFacade#isFileType()
     */
    public boolean isFileType()
    {
        return this.getSuperService().isFileType();
    }

    /**
     * Indicates if this type represents a Float type or not.
     * @see ClassifierFacade#isFloatType()
     */
    public boolean isFloatType()
    {
        return this.getSuperService().isFloatType();
    }

    /**
     * Indicates if this type represents an int or Integer or java.lang.Integer type or not.
     * @see ClassifierFacade#isIntegerType()
     */
    public boolean isIntegerType()
    {
        return this.getSuperService().isIntegerType();
    }

    /**
     * True/false depending on whether or not this Classifier represents an interface.
     * @see ClassifierFacade#isInterface()
     */
    public boolean isInterface()
    {
        return this.getSuperService().isInterface();
    }

    /**
     * True if this classifier cannot be extended and represent a leaf in the inheritance tree.
     * @see ClassifierFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperService().isLeaf();
    }

    /**
     * True if this classifier represents a list type. False otherwise.
     * @see ClassifierFacade#isListType()
     */
    public boolean isListType()
    {
        return this.getSuperService().isListType();
    }

    /**
     * Indicates if this type represents a Long type or not.
     * @see ClassifierFacade#isLongType()
     */
    public boolean isLongType()
    {
        return this.getSuperService().isLongType();
    }

    /**
     * Indicates whether or not this classifier represents a Map type.
     * @see ClassifierFacade#isMapType()
     */
    public boolean isMapType()
    {
        return this.getSuperService().isMapType();
    }

    /**
     * Indicates whether or not this classifier represents a primitive type.
     * @see ClassifierFacade#isPrimitive()
     */
    public boolean isPrimitive()
    {
        return this.getSuperService().isPrimitive();
    }

    /**
     * True if this classifier represents a set type. False otherwise.
     * @see ClassifierFacade#isSetType()
     */
    public boolean isSetType()
    {
        return this.getSuperService().isSetType();
    }

    /**
     * Indicates whether or not this classifier represents a string type.
     * @see ClassifierFacade#isStringType()
     */
    public boolean isStringType()
    {
        return this.getSuperService().isStringType();
    }

    /**
     * Indicates whether or not this classifier represents a time type.
     * @see ClassifierFacade#isTimeType()
     */
    public boolean isTimeType()
    {
        return this.getSuperService().isTimeType();
    }

    /**
     * Returns true if this type is a wrapped primitive type.
     * @see ClassifierFacade#isWrappedPrimitive()
     */
    public boolean isWrappedPrimitive()
    {
        return this.getSuperService().isWrappedPrimitive();
    }

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @see GeneralizableElementFacade#findTaggedValue(String tagName, boolean follow)
     */
    public Object findTaggedValue(String tagName, boolean follow)
    {
        return this.getSuperService().findTaggedValue(tagName, follow);
    }

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @see GeneralizableElementFacade#getAllGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations()
    {
        return this.getSuperService().getAllGeneralizations();
    }

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @see GeneralizableElementFacade#getAllSpecializations()
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations()
    {
        return this.getSuperService().getAllSpecializations();
    }

    /**
     * Gets the direct generalization for this generalizable element.
     * @see GeneralizableElementFacade#getGeneralization()
     */
    public GeneralizableElementFacade getGeneralization()
    {
        return this.getSuperService().getGeneralization();
    }

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @see GeneralizableElementFacade#getGeneralizationLinks()
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks()
    {
        return this.getSuperService().getGeneralizationLinks();
    }

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @see GeneralizableElementFacade#getGeneralizationList()
     */
    public String getGeneralizationList()
    {
        return this.getSuperService().getGeneralizationList();
    }

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @see GeneralizableElementFacade#getGeneralizationRoot()
     */
    public GeneralizableElementFacade getGeneralizationRoot()
    {
        return this.getSuperService().getGeneralizationRoot();
    }

    /**
     * The model element that represents an element that can be generalized or specialized.
     * @see GeneralizableElementFacade#getGeneralizations()
     */
    public Collection<GeneralizableElementFacade> getGeneralizations()
    {
        return this.getSuperService().getGeneralizations();
    }

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @see GeneralizableElementFacade#getSpecializations()
     */
    public Collection<GeneralizableElementFacade> getSpecializations()
    {
        return this.getSuperService().getSpecializations();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperService().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperService().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperService().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperService().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperService().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperService().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperService().getDocumentation(indent);
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
        return this.getSuperService().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperService().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperService().getFullyQualifiedName();
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
        return this.getSuperService().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperService().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperService().getId();
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
        return this.getSuperService().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperService().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperService().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperService().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperService().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperService().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperService().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperService().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperService().getPackagePath();
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
        return this.getSuperService().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperService().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperService().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperService().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperService().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperService().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperService().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperService().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperService().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperService().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperService().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperService().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperService().hasKeyword(keywordName);
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
        return this.getSuperService().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperService().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperService().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperService().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperService().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperService().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperService().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperService().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperService().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperService().translateConstraints(kind, translation);
    }

    /**
     * Returns a collection of all entities this service and its ancestors have a relation to.
     * @see Service#getAllEntityReferences()
     */
    public Collection<DependencyFacade> getAllEntityReferences()
    {
        return this.getSuperService().getAllEntityReferences();
    }

    /**
     * All messaging destinations that belong to this service and all decendent services.
     * @see Service#getAllMessagingDestinations()
     */
    public Collection<Destination> getAllMessagingDestinations()
    {
        return this.getSuperService().getAllMessagingDestinations();
    }

    /**
     * All roles associated with the service, this includes both roles that have access to the
     * entire service, and any roles that have access to a single operation.
     * @see Service#getAllRoles()
     */
    public Collection<Role> getAllRoles()
    {
        return this.getSuperService().getAllRoles();
    }

    /**
     * Returns a collection of all services this service and its ancestors have a relation to.
     * @see Service#getAllServiceReferences()
     */
    public Collection<DependencyFacade> getAllServiceReferences()
    {
        return this.getSuperService().getAllServiceReferences();
    }

    /**
     * References to all entities to which this service has a dependency.
     * @see Service#getEntityReferences()
     */
    public Collection<DependencyFacade> getEntityReferences()
    {
        return this.getSuperService().getEntityReferences();
    }

    /**
     * All messaging destinations available to this service.
     * @see Service#getMessagingDestinations()
     */
    public Collection<Destination> getMessagingDestinations()
    {
        return this.getSuperService().getMessagingDestinations();
    }

    /**
     * The roles of the service, these are the actor's that can access this service.
     * @see Service#getRoles()
     */
    public Collection<Role> getRoles()
    {
        return this.getSuperService().getRoles();
    }

    /**
     * References to all services to which this service has a dependency.
     * @see Service#getServiceReferences()
     */
    public Collection<DependencyFacade> getServiceReferences()
    {
        return this.getSuperService().getServiceReferences();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperService().initialize();
    }

    /**
     * @return Object getSuperService().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperService().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperService().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperService().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperService().validateInvariants(validationMessages);
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