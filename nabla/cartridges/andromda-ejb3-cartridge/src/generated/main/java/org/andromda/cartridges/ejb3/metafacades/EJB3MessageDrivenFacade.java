// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.Service;

/**
 * Represents a message driven EJB.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3MessageDrivenFacade
    extends Service
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3MessageDrivenFacadeMetaType();

    /**
     * Returns the acknowledge mode for this JMS message driven bean.  This is automatically handled
     * by the container.  EJB 3.0 spec states:
     * For container managed transaction demarcation, message acknowledgment is automatically
     * handled as part of transaction commit.  If bean-managed transaction demarcation is used, the
     * message receipt cannot be part of the bean-managed transaction, therefore the receipt is
     * acknowledged by the container.  If this property is not specified, AUTO_ACKNOWLEDGE semantics
     * is assumed.
     * Possible values are AUTO_ACKNOWLEDGE or DUPS_OK_ACKNOWLEDGE.
     * @return String
     */
    public String getAcknowledgeMode();

    /**
     * Returns the comma separated list of attributes.<p/>This method can be used to generate
     * argument lists for constructors and method calls.
     * @param attributes Collection
     * @param includeTypes boolean
     * @param includeNames boolean
     * @return String
     */
    public String getAttributesAsList(Collection attributes, boolean includeTypes, boolean includeNames);

    /**
     * Gets all constants for this message driven EJB. Constants are defined as static read-only
     * attributes which do NOT have the <<EnvEntry>> stereotype.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all constants from any super types
     * as well.
     * @param follow boolean
     * @return Collection
     */
    public Collection getConstants(boolean follow);

    /**
     * Returns the destination queue or topic JNDI name this message driven bean is associated with.
     * @return String
     */
    public String getDestination();

    /**
     * Returns the destination type of the message driven bean.  Possible values are javax.jms.Queue
     * or javax.jms.Topic.
     * Queues ensure that messages are not missed, even if the EJB server is not running.  Same
     * applis to durable topic subscriptions.
     * @return String
     */
    public String getDestinationType();

    /**
     * This returns a subscription name which is only required for durable subscriptions.
     * @return String
     */
    public String getDurableSubscriptionId();

    /**
     * Gets all env-entries for the specified session EJB. Env-entries are stored as static
     * attributes on the entity and stereotyped as <<EnvEntry>>.  If 'follow' is true, then the
     * inheritance hierarchy will be followed and we'll retrieve all env-entries from any super
     * types as well.
     * @param follow boolean
     * @return Collection
     */
    public Collection getEnvironmentEntries(boolean follow);

    /**
     * Returns the fully qualified message driven bean implementation name.
     * @return String
     */
    public String getFullyQualifiedMessageDrivenImplementationName();

    /**
     * Returns the fully qualified message driven bean listener name.
     * @return String
     */
    public String getFullyQualifiedMessageDrivenListenerName();

    /**
     * Returns the fully qualified message driven bean name.
     * @return String
     */
    public String getFullyQualifiedMessageDrivenName();

    /**
     * Returns the fully qualified message driven test class name
     * @return String
     */
    public String getFullyQualifiedMessageDrivenTestName();

    /**
     * Returns the Collection of target elements from the message-driven bean class where  the
     * target class has a stereotype of Interceptor.
     * @return Collection
     */
    public Collection getInterceptorReferences();

    /**
     * Returns the MDB maximum pool size.
     * @return int
     */
    public int getMaximumPoolSize();

    /**
     * Returns the message driven bean implementation name.
     * @return String
     */
    public String getMessageDrivenImplementationName();

    /**
     * Returns the message driven bean callback listener name.
     * @return String
     */
    public String getMessageDrivenListenerName();

    /**
     * Returns message driven bean name.
     * @return String
     */
    public String getMessageDrivenName();

    /**
     * Returns the message driven bean test class name
     * @return String
     */
    public String getMessageDrivenTestName();

    /**
     * Returns the JMS message selector used when determining the messages a message driven bean is
     * to receive.
     * @return String
     */
    public String getMessageSelector();

    /**
     * Returns the MDB minimum pool size.
     * @return int
     */
    public int getMinimumPoolSize();

    /**
     * Returns the run-as identity for the message driven bean which is used to establish the
     * identity the bean will use when making calls.  It does not affect the identity of the
     * callers.
     * @return String
     */
    public String getRunAs();

    /**
     * If the message driven bean is associated with a topic, then this will return the subscription
     * durability.  Possible values are Durable or NonDurable.  By default, if a topic subscription
     * is not specified, the non-durable subscription is assumed.
     * Durable topic subscriptions ensure that messages are not missed, even if the EJB server is
     * not running.
     * @return String
     */
    public String getSubscriptionDurability();

    /**
     * Returns the message driven test package name. This simply appends .test to the existing class
     * package.
     * @return String
     */
    public String getTestPackageName();

    /**
     * Returns the transaction demarcation strategy for this bean.  Typically, this will return BEAN
     * for non default CONTAINER managed beans.  Unless specified, this will return null indicating
     * CONTAINER transaction demarcation.
     * @return String
     */
    public String getTransactionManagement();

    /**
     * Gets the transaction type for this message driven bean.  For container managed demarcation,
     * either the REQUIRED or NOT_SUPPORTED transaction attributes must be used on a message driven
     * bean.
     * @return String
     */
    public String getTransactionType();

    /**
     * Returns true if the destination type if a javax.jms.Queue.
     * @return boolean
     */
    public boolean isDestinationTypeQueue();

    /**
     * Returns true if the destination type is a javax.jms.Topic.
     * @return boolean
     */
    public boolean isDestinationTypeTopic();

    /**
     * Determines whether to exclude the invocation of the default interceptors for all business
     * method in the bean.
     * @return boolean
     */
    public boolean isExcludeDefaultInterceptors();

    /**
     * Returns true if this message driven bean has the stereotype Listener.  False otherwise.
     * @return boolean
     */
    public boolean isListenerEnabled();

    /**
     * Returns true if the topic subscription durability setting is Durable.
     * @return boolean
     */
    public boolean isSubscriptionDurable();

    /**
     * Returns true if the subscription durability setting is NonDurable.
     * @return boolean
     */
    public boolean isSubscriptionNonDurable();

    /**
     * Returns true if the transaction demarcation strategy is bean managedfor this bean.
     * @return boolean
     */
    public boolean isTransactionManagementBean();
}