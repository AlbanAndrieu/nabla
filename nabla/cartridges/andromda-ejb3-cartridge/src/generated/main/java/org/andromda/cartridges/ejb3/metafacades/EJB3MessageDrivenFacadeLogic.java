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

/**
 * Represents a message driven EJB.
 * MetafacadeLogic for EJB3MessageDrivenFacade
 *
 * @see EJB3MessageDrivenFacade
 */
public abstract class EJB3MessageDrivenFacadeLogic
    extends MetafacadeBase
    implements EJB3MessageDrivenFacade
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
    protected EJB3MessageDrivenFacadeLogic(final Object metaObjectIn, String context)
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
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3MessageDrivenFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade";
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
     * @see EJB3MessageDrivenFacade
     */
    public boolean isEJB3MessageDrivenFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getAcknowledgeMode()
    * @return String
    */
    protected abstract String handleGetAcknowledgeMode();

    private String acknowledgeMode1a;
    private boolean acknowledgeMode1aSet = false;

    /**
     * Returns the acknowledge mode for this JMS message driven bean.  This is automatically handled
     * by the container.  EJB 3.0 spec states:
     * For container managed transaction demarcation, message acknowledgment is automatically
     * handled as part of transaction commit.  If bean-managed transaction demarcation is used, the
     * message receipt cannot be part of the bean-managed transaction, therefore the receipt is
     * acknowledged by the container.  If this property is not specified, AUTO_ACKNOWLEDGE semantics
     * is assumed.
     * Possible values are AUTO_ACKNOWLEDGE or DUPS_OK_ACKNOWLEDGE.
     * @return (String)handleGetAcknowledgeMode()
     */
    public final String getAcknowledgeMode()
    {
        String aacknowledgeMode1a = this.acknowledgeMode1a;
        if (!this.acknowledgeMode1aSet)
        {
            // acknowledgeMode has no pre constraints
            aacknowledgeMode1a = handleGetAcknowledgeMode();
            // acknowledgeMode has no post constraints
            this.acknowledgeMode1a = aacknowledgeMode1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.acknowledgeMode1aSet = true;
            }
        }
        return aacknowledgeMode1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getDestination()
    * @return String
    */
    protected abstract String handleGetDestination();

    private String destination2a;
    private boolean destination2aSet = false;

    /**
     * Returns the destination queue or topic JNDI name this message driven bean is associated with.
     * @return (String)handleGetDestination()
     */
    public final String getDestination()
    {
        String adestination2a = this.destination2a;
        if (!this.destination2aSet)
        {
            // destination has no pre constraints
            adestination2a = handleGetDestination();
            // destination has no post constraints
            this.destination2a = adestination2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.destination2aSet = true;
            }
        }
        return adestination2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getDestinationType()
    * @return String
    */
    protected abstract String handleGetDestinationType();

    private String destinationType3a;
    private boolean destinationType3aSet = false;

    /**
     * Returns the destination type of the message driven bean.  Possible values are javax.jms.Queue
     * or javax.jms.Topic.
     * Queues ensure that messages are not missed, even if the EJB server is not running.  Same
     * applis to durable topic subscriptions.
     * @return (String)handleGetDestinationType()
     */
    public final String getDestinationType()
    {
        String adestinationType3a = this.destinationType3a;
        if (!this.destinationType3aSet)
        {
            // destinationType has no pre constraints
            adestinationType3a = handleGetDestinationType();
            // destinationType has no post constraints
            this.destinationType3a = adestinationType3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.destinationType3aSet = true;
            }
        }
        return adestinationType3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getFullyQualifiedMessageDrivenImplementationName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedMessageDrivenImplementationName();

    private String fullyQualifiedMessageDrivenImplementationName4a;
    private boolean fullyQualifiedMessageDrivenImplementationName4aSet = false;

    /**
     * Returns the fully qualified message driven bean implementation name.
     * @return (String)handleGetFullyQualifiedMessageDrivenImplementationName()
     */
    public final String getFullyQualifiedMessageDrivenImplementationName()
    {
        String afullyQualifiedMessageDrivenImplementationName4a = this.fullyQualifiedMessageDrivenImplementationName4a;
        if (!this.fullyQualifiedMessageDrivenImplementationName4aSet)
        {
            // fullyQualifiedMessageDrivenImplementationName has no pre constraints
            afullyQualifiedMessageDrivenImplementationName4a = handleGetFullyQualifiedMessageDrivenImplementationName();
            // fullyQualifiedMessageDrivenImplementationName has no post constraints
            this.fullyQualifiedMessageDrivenImplementationName4a = afullyQualifiedMessageDrivenImplementationName4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedMessageDrivenImplementationName4aSet = true;
            }
        }
        return afullyQualifiedMessageDrivenImplementationName4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getFullyQualifiedMessageDrivenListenerName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedMessageDrivenListenerName();

    private String fullyQualifiedMessageDrivenListenerName5a;
    private boolean fullyQualifiedMessageDrivenListenerName5aSet = false;

    /**
     * Returns the fully qualified message driven bean listener name.
     * @return (String)handleGetFullyQualifiedMessageDrivenListenerName()
     */
    public final String getFullyQualifiedMessageDrivenListenerName()
    {
        String afullyQualifiedMessageDrivenListenerName5a = this.fullyQualifiedMessageDrivenListenerName5a;
        if (!this.fullyQualifiedMessageDrivenListenerName5aSet)
        {
            // fullyQualifiedMessageDrivenListenerName has no pre constraints
            afullyQualifiedMessageDrivenListenerName5a = handleGetFullyQualifiedMessageDrivenListenerName();
            // fullyQualifiedMessageDrivenListenerName has no post constraints
            this.fullyQualifiedMessageDrivenListenerName5a = afullyQualifiedMessageDrivenListenerName5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedMessageDrivenListenerName5aSet = true;
            }
        }
        return afullyQualifiedMessageDrivenListenerName5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getFullyQualifiedMessageDrivenName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedMessageDrivenName();

    private String fullyQualifiedMessageDrivenName6a;
    private boolean fullyQualifiedMessageDrivenName6aSet = false;

    /**
     * Returns the fully qualified message driven bean name.
     * @return (String)handleGetFullyQualifiedMessageDrivenName()
     */
    public final String getFullyQualifiedMessageDrivenName()
    {
        String afullyQualifiedMessageDrivenName6a = this.fullyQualifiedMessageDrivenName6a;
        if (!this.fullyQualifiedMessageDrivenName6aSet)
        {
            // fullyQualifiedMessageDrivenName has no pre constraints
            afullyQualifiedMessageDrivenName6a = handleGetFullyQualifiedMessageDrivenName();
            // fullyQualifiedMessageDrivenName has no post constraints
            this.fullyQualifiedMessageDrivenName6a = afullyQualifiedMessageDrivenName6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedMessageDrivenName6aSet = true;
            }
        }
        return afullyQualifiedMessageDrivenName6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getMessageDrivenImplementationName()
    * @return String
    */
    protected abstract String handleGetMessageDrivenImplementationName();

    private String messageDrivenImplementationName7a;
    private boolean messageDrivenImplementationName7aSet = false;

    /**
     * Returns the message driven bean implementation name.
     * @return (String)handleGetMessageDrivenImplementationName()
     */
    public final String getMessageDrivenImplementationName()
    {
        String amessageDrivenImplementationName7a = this.messageDrivenImplementationName7a;
        if (!this.messageDrivenImplementationName7aSet)
        {
            // messageDrivenImplementationName has no pre constraints
            amessageDrivenImplementationName7a = handleGetMessageDrivenImplementationName();
            // messageDrivenImplementationName has no post constraints
            this.messageDrivenImplementationName7a = amessageDrivenImplementationName7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageDrivenImplementationName7aSet = true;
            }
        }
        return amessageDrivenImplementationName7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getMessageDrivenListenerName()
    * @return String
    */
    protected abstract String handleGetMessageDrivenListenerName();

    private String messageDrivenListenerName8a;
    private boolean messageDrivenListenerName8aSet = false;

    /**
     * Returns the message driven bean callback listener name.
     * @return (String)handleGetMessageDrivenListenerName()
     */
    public final String getMessageDrivenListenerName()
    {
        String amessageDrivenListenerName8a = this.messageDrivenListenerName8a;
        if (!this.messageDrivenListenerName8aSet)
        {
            // messageDrivenListenerName has no pre constraints
            amessageDrivenListenerName8a = handleGetMessageDrivenListenerName();
            // messageDrivenListenerName has no post constraints
            this.messageDrivenListenerName8a = amessageDrivenListenerName8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageDrivenListenerName8aSet = true;
            }
        }
        return amessageDrivenListenerName8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getMessageDrivenName()
    * @return String
    */
    protected abstract String handleGetMessageDrivenName();

    private String messageDrivenName9a;
    private boolean messageDrivenName9aSet = false;

    /**
     * Returns message driven bean name.
     * @return (String)handleGetMessageDrivenName()
     */
    public final String getMessageDrivenName()
    {
        String amessageDrivenName9a = this.messageDrivenName9a;
        if (!this.messageDrivenName9aSet)
        {
            // messageDrivenName has no pre constraints
            amessageDrivenName9a = handleGetMessageDrivenName();
            // messageDrivenName has no post constraints
            this.messageDrivenName9a = amessageDrivenName9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageDrivenName9aSet = true;
            }
        }
        return amessageDrivenName9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getMessageSelector()
    * @return String
    */
    protected abstract String handleGetMessageSelector();

    private String messageSelector10a;
    private boolean messageSelector10aSet = false;

    /**
     * Returns the JMS message selector used when determining the messages a message driven bean is
     * to receive.
     * @return (String)handleGetMessageSelector()
     */
    public final String getMessageSelector()
    {
        String amessageSelector10a = this.messageSelector10a;
        if (!this.messageSelector10aSet)
        {
            // messageSelector has no pre constraints
            amessageSelector10a = handleGetMessageSelector();
            // messageSelector has no post constraints
            this.messageSelector10a = amessageSelector10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageSelector10aSet = true;
            }
        }
        return amessageSelector10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getRunAs()
    * @return String
    */
    protected abstract String handleGetRunAs();

    private String runAs11a;
    private boolean runAs11aSet = false;

    /**
     * Returns the run-as identity for the message driven bean which is used to establish the
     * identity the bean will use when making calls.  It does not affect the identity of the
     * callers.
     * @return (String)handleGetRunAs()
     */
    public final String getRunAs()
    {
        String arunAs11a = this.runAs11a;
        if (!this.runAs11aSet)
        {
            // runAs has no pre constraints
            arunAs11a = handleGetRunAs();
            // runAs has no post constraints
            this.runAs11a = arunAs11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.runAs11aSet = true;
            }
        }
        return arunAs11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getSubscriptionDurability()
    * @return String
    */
    protected abstract String handleGetSubscriptionDurability();

    private String subscriptionDurability12a;
    private boolean subscriptionDurability12aSet = false;

    /**
     * If the message driven bean is associated with a topic, then this will return the subscription
     * durability.  Possible values are Durable or NonDurable.  By default, if a topic subscription
     * is not specified, the non-durable subscription is assumed.
     * Durable topic subscriptions ensure that messages are not missed, even if the EJB server is
     * not running.
     * @return (String)handleGetSubscriptionDurability()
     */
    public final String getSubscriptionDurability()
    {
        String asubscriptionDurability12a = this.subscriptionDurability12a;
        if (!this.subscriptionDurability12aSet)
        {
            // subscriptionDurability has no pre constraints
            asubscriptionDurability12a = handleGetSubscriptionDurability();
            // subscriptionDurability has no post constraints
            this.subscriptionDurability12a = asubscriptionDurability12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.subscriptionDurability12aSet = true;
            }
        }
        return asubscriptionDurability12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getTransactionManagement()
    * @return String
    */
    protected abstract String handleGetTransactionManagement();

    private String transactionManagement13a;
    private boolean transactionManagement13aSet = false;

    /**
     * Returns the transaction demarcation strategy for this bean.  Typically, this will return BEAN
     * for non default CONTAINER managed beans.  Unless specified, this will return null indicating
     * CONTAINER transaction demarcation.
     * @return (String)handleGetTransactionManagement()
     */
    public final String getTransactionManagement()
    {
        String atransactionManagement13a = this.transactionManagement13a;
        if (!this.transactionManagement13aSet)
        {
            // transactionManagement has no pre constraints
            atransactionManagement13a = handleGetTransactionManagement();
            // transactionManagement has no post constraints
            this.transactionManagement13a = atransactionManagement13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transactionManagement13aSet = true;
            }
        }
        return atransactionManagement13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#isTransactionManagementBean()
    * @return boolean
    */
    protected abstract boolean handleIsTransactionManagementBean();

    private boolean transactionManagementBean14a;
    private boolean transactionManagementBean14aSet = false;

    /**
     * Returns true if the transaction demarcation strategy is bean managedfor this bean.
     * @return (boolean)handleIsTransactionManagementBean()
     */
    public final boolean isTransactionManagementBean()
    {
        boolean atransactionManagementBean14a = this.transactionManagementBean14a;
        if (!this.transactionManagementBean14aSet)
        {
            // transactionManagementBean has no pre constraints
            atransactionManagementBean14a = handleIsTransactionManagementBean();
            // transactionManagementBean has no post constraints
            this.transactionManagementBean14a = atransactionManagementBean14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transactionManagementBean14aSet = true;
            }
        }
        return atransactionManagementBean14a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getTransactionType()
    * @return String
    */
    protected abstract String handleGetTransactionType();

    private String transactionType15a;
    private boolean transactionType15aSet = false;

    /**
     * Gets the transaction type for this message driven bean.  For container managed demarcation,
     * either the REQUIRED or NOT_SUPPORTED transaction attributes must be used on a message driven
     * bean.
     * @return (String)handleGetTransactionType()
     */
    public final String getTransactionType()
    {
        String atransactionType15a = this.transactionType15a;
        if (!this.transactionType15aSet)
        {
            // transactionType has no pre constraints
            atransactionType15a = handleGetTransactionType();
            // transactionType has no post constraints
            this.transactionType15a = atransactionType15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transactionType15aSet = true;
            }
        }
        return atransactionType15a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#isDestinationTypeQueue()
    * @return boolean
    */
    protected abstract boolean handleIsDestinationTypeQueue();

    private boolean destinationTypeQueue16a;
    private boolean destinationTypeQueue16aSet = false;

    /**
     * Returns true if the destination type if a javax.jms.Queue.
     * @return (boolean)handleIsDestinationTypeQueue()
     */
    public final boolean isDestinationTypeQueue()
    {
        boolean adestinationTypeQueue16a = this.destinationTypeQueue16a;
        if (!this.destinationTypeQueue16aSet)
        {
            // destinationTypeQueue has no pre constraints
            adestinationTypeQueue16a = handleIsDestinationTypeQueue();
            // destinationTypeQueue has no post constraints
            this.destinationTypeQueue16a = adestinationTypeQueue16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.destinationTypeQueue16aSet = true;
            }
        }
        return adestinationTypeQueue16a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#isDestinationTypeTopic()
    * @return boolean
    */
    protected abstract boolean handleIsDestinationTypeTopic();

    private boolean destinationTypeTopic17a;
    private boolean destinationTypeTopic17aSet = false;

    /**
     * Returns true if the destination type is a javax.jms.Topic.
     * @return (boolean)handleIsDestinationTypeTopic()
     */
    public final boolean isDestinationTypeTopic()
    {
        boolean adestinationTypeTopic17a = this.destinationTypeTopic17a;
        if (!this.destinationTypeTopic17aSet)
        {
            // destinationTypeTopic has no pre constraints
            adestinationTypeTopic17a = handleIsDestinationTypeTopic();
            // destinationTypeTopic has no post constraints
            this.destinationTypeTopic17a = adestinationTypeTopic17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.destinationTypeTopic17aSet = true;
            }
        }
        return adestinationTypeTopic17a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getMinimumPoolSize()
    * @return int
    */
    protected abstract int handleGetMinimumPoolSize();

    private int minimumPoolSize18a;
    private boolean minimumPoolSize18aSet = false;

    /**
     * Returns the MDB minimum pool size.
     * @return (int)handleGetMinimumPoolSize()
     */
    public final int getMinimumPoolSize()
    {
        int aminimumPoolSize18a = this.minimumPoolSize18a;
        if (!this.minimumPoolSize18aSet)
        {
            // minimumPoolSize has no pre constraints
            aminimumPoolSize18a = handleGetMinimumPoolSize();
            // minimumPoolSize has no post constraints
            this.minimumPoolSize18a = aminimumPoolSize18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.minimumPoolSize18aSet = true;
            }
        }
        return aminimumPoolSize18a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#isListenerEnabled()
    * @return boolean
    */
    protected abstract boolean handleIsListenerEnabled();

    private boolean listenerEnabled19a;
    private boolean listenerEnabled19aSet = false;

    /**
     * Returns true if this message driven bean has the stereotype Listener.  False otherwise.
     * @return (boolean)handleIsListenerEnabled()
     */
    public final boolean isListenerEnabled()
    {
        boolean alistenerEnabled19a = this.listenerEnabled19a;
        if (!this.listenerEnabled19aSet)
        {
            // listenerEnabled has no pre constraints
            alistenerEnabled19a = handleIsListenerEnabled();
            // listenerEnabled has no post constraints
            this.listenerEnabled19a = alistenerEnabled19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.listenerEnabled19aSet = true;
            }
        }
        return alistenerEnabled19a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getInterceptorReferences()
    * @return Collection
    */
    protected abstract Collection handleGetInterceptorReferences();

    private Collection interceptorReferences20a;
    private boolean interceptorReferences20aSet = false;

    /**
     * Returns the Collection of target elements from the message-driven bean class where  the
     * target class has a stereotype of Interceptor.
     * @return (Collection)handleGetInterceptorReferences()
     */
    public final Collection getInterceptorReferences()
    {
        Collection ainterceptorReferences20a = this.interceptorReferences20a;
        if (!this.interceptorReferences20aSet)
        {
            // interceptorReferences has no pre constraints
            ainterceptorReferences20a = handleGetInterceptorReferences();
            // interceptorReferences has no post constraints
            this.interceptorReferences20a = ainterceptorReferences20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.interceptorReferences20aSet = true;
            }
        }
        return ainterceptorReferences20a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#isExcludeDefaultInterceptors()
    * @return boolean
    */
    protected abstract boolean handleIsExcludeDefaultInterceptors();

    private boolean excludeDefaultInterceptors21a;
    private boolean excludeDefaultInterceptors21aSet = false;

    /**
     * Determines whether to exclude the invocation of the default interceptors for all business
     * method in the bean.
     * @return (boolean)handleIsExcludeDefaultInterceptors()
     */
    public final boolean isExcludeDefaultInterceptors()
    {
        boolean aexcludeDefaultInterceptors21a = this.excludeDefaultInterceptors21a;
        if (!this.excludeDefaultInterceptors21aSet)
        {
            // excludeDefaultInterceptors has no pre constraints
            aexcludeDefaultInterceptors21a = handleIsExcludeDefaultInterceptors();
            // excludeDefaultInterceptors has no post constraints
            this.excludeDefaultInterceptors21a = aexcludeDefaultInterceptors21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.excludeDefaultInterceptors21aSet = true;
            }
        }
        return aexcludeDefaultInterceptors21a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getMaximumPoolSize()
    * @return int
    */
    protected abstract int handleGetMaximumPoolSize();

    private int maximumPoolSize22a;
    private boolean maximumPoolSize22aSet = false;

    /**
     * Returns the MDB maximum pool size.
     * @return (int)handleGetMaximumPoolSize()
     */
    public final int getMaximumPoolSize()
    {
        int amaximumPoolSize22a = this.maximumPoolSize22a;
        if (!this.maximumPoolSize22aSet)
        {
            // maximumPoolSize has no pre constraints
            amaximumPoolSize22a = handleGetMaximumPoolSize();
            // maximumPoolSize has no post constraints
            this.maximumPoolSize22a = amaximumPoolSize22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.maximumPoolSize22aSet = true;
            }
        }
        return amaximumPoolSize22a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getTestPackageName()
    * @return String
    */
    protected abstract String handleGetTestPackageName();

    private String testPackageName23a;
    private boolean testPackageName23aSet = false;

    /**
     * Returns the message driven test package name. This simply appends .test to the existing class
     * package.
     * @return (String)handleGetTestPackageName()
     */
    public final String getTestPackageName()
    {
        String atestPackageName23a = this.testPackageName23a;
        if (!this.testPackageName23aSet)
        {
            // testPackageName has no pre constraints
            atestPackageName23a = handleGetTestPackageName();
            // testPackageName has no post constraints
            this.testPackageName23a = atestPackageName23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.testPackageName23aSet = true;
            }
        }
        return atestPackageName23a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getMessageDrivenTestName()
    * @return String
    */
    protected abstract String handleGetMessageDrivenTestName();

    private String messageDrivenTestName24a;
    private boolean messageDrivenTestName24aSet = false;

    /**
     * Returns the message driven bean test class name
     * @return (String)handleGetMessageDrivenTestName()
     */
    public final String getMessageDrivenTestName()
    {
        String amessageDrivenTestName24a = this.messageDrivenTestName24a;
        if (!this.messageDrivenTestName24aSet)
        {
            // messageDrivenTestName has no pre constraints
            amessageDrivenTestName24a = handleGetMessageDrivenTestName();
            // messageDrivenTestName has no post constraints
            this.messageDrivenTestName24a = amessageDrivenTestName24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageDrivenTestName24aSet = true;
            }
        }
        return amessageDrivenTestName24a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getFullyQualifiedMessageDrivenTestName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedMessageDrivenTestName();

    private String fullyQualifiedMessageDrivenTestName25a;
    private boolean fullyQualifiedMessageDrivenTestName25aSet = false;

    /**
     * Returns the fully qualified message driven test class name
     * @return (String)handleGetFullyQualifiedMessageDrivenTestName()
     */
    public final String getFullyQualifiedMessageDrivenTestName()
    {
        String afullyQualifiedMessageDrivenTestName25a = this.fullyQualifiedMessageDrivenTestName25a;
        if (!this.fullyQualifiedMessageDrivenTestName25aSet)
        {
            // fullyQualifiedMessageDrivenTestName has no pre constraints
            afullyQualifiedMessageDrivenTestName25a = handleGetFullyQualifiedMessageDrivenTestName();
            // fullyQualifiedMessageDrivenTestName has no post constraints
            this.fullyQualifiedMessageDrivenTestName25a = afullyQualifiedMessageDrivenTestName25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedMessageDrivenTestName25aSet = true;
            }
        }
        return afullyQualifiedMessageDrivenTestName25a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#isSubscriptionDurable()
    * @return boolean
    */
    protected abstract boolean handleIsSubscriptionDurable();

    private boolean subscriptionDurable26a;
    private boolean subscriptionDurable26aSet = false;

    /**
     * Returns true if the topic subscription durability setting is Durable.
     * @return (boolean)handleIsSubscriptionDurable()
     */
    public final boolean isSubscriptionDurable()
    {
        boolean asubscriptionDurable26a = this.subscriptionDurable26a;
        if (!this.subscriptionDurable26aSet)
        {
            // subscriptionDurable has no pre constraints
            asubscriptionDurable26a = handleIsSubscriptionDurable();
            // subscriptionDurable has no post constraints
            this.subscriptionDurable26a = asubscriptionDurable26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.subscriptionDurable26aSet = true;
            }
        }
        return asubscriptionDurable26a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#isSubscriptionNonDurable()
    * @return boolean
    */
    protected abstract boolean handleIsSubscriptionNonDurable();

    private boolean subscriptionNonDurable27a;
    private boolean subscriptionNonDurable27aSet = false;

    /**
     * Returns true if the subscription durability setting is NonDurable.
     * @return (boolean)handleIsSubscriptionNonDurable()
     */
    public final boolean isSubscriptionNonDurable()
    {
        boolean asubscriptionNonDurable27a = this.subscriptionNonDurable27a;
        if (!this.subscriptionNonDurable27aSet)
        {
            // subscriptionNonDurable has no pre constraints
            asubscriptionNonDurable27a = handleIsSubscriptionNonDurable();
            // subscriptionNonDurable has no post constraints
            this.subscriptionNonDurable27a = asubscriptionNonDurable27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.subscriptionNonDurable27aSet = true;
            }
        }
        return asubscriptionNonDurable27a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenFacade#getDurableSubscriptionId()
    * @return String
    */
    protected abstract String handleGetDurableSubscriptionId();

    private String durableSubscriptionId28a;
    private boolean durableSubscriptionId28aSet = false;

    /**
     * This returns a subscription name which is only required for durable subscriptions.
     * @return (String)handleGetDurableSubscriptionId()
     */
    public final String getDurableSubscriptionId()
    {
        String adurableSubscriptionId28a = this.durableSubscriptionId28a;
        if (!this.durableSubscriptionId28aSet)
        {
            // durableSubscriptionId has no pre constraints
            adurableSubscriptionId28a = handleGetDurableSubscriptionId();
            // durableSubscriptionId has no post constraints
            this.durableSubscriptionId28a = adurableSubscriptionId28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.durableSubscriptionId28aSet = true;
            }
        }
        return adurableSubscriptionId28a;
    }

    // ---------------- business methods ----------------------

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
     * Gets all constants for this message driven EJB. Constants are defined as static read-only
     * attributes which do NOT have the <<EnvEntry>> stereotype.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all constants from any super types
     * as well.
     * @param follow
     * @return Collection
     */
    protected abstract Collection handleGetConstants(boolean follow);

    /**
     * Gets all constants for this message driven EJB. Constants are defined as static read-only
     * attributes which do NOT have the <<EnvEntry>> stereotype.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all constants from any super types
     * as well.
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
    public Collection<ClassifierFacade> getNavigableConnectingEnds()
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
     * 
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
     * 
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
     * 
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
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperService().getLanguageMappings();
    }

    /**
     * 
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
     * 
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
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperService().getTemplateParameter(parameterName);
    }

    /**
     * 
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
     * 
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
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperService().isTemplateParametersPresent();
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