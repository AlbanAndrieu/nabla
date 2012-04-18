// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.Service;

/**
 * Represents a Session EJB.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3SessionFacade
    extends Service
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3SessionFacadeMetaType();

    /**
     * Filter out seam component attributes
     * @param attributes Collection
     * @return Collection
     */
    public Collection filterSeamAttributes(Collection attributes);

    /**
     * All instanceAttributes for this session EJB. The list includes the instanceAttributes that
     * are inherited from super classes. The list contains the inherited instanceAttributes first,
     * followed by the instanceAttributes defined in this class.
     * @return List
     */
    public List getAllInstanceAttributes();

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
     * All "business" operations for this Session EJB.  These are any operations that are NOT
     * identified as create methods.
     * @return Collection
     */
    public Collection getBusinessOperations();

    /**
     * Gets all constants for this session EJB. Constants are defined as static read-only attributes
     * which do NOT have the <<EnvEntry>> stereotype.  If 'follow' is true, then the inheritance
     * hierarchy will be followed and we'll retrieve all constants from any super types as well.
     * @param follow boolean
     * @return Collection
     */
    public Collection getConstants(boolean follow);

    /**
     * Gets create methods for this session EJB.  If 'follow' is set to true, it will follow the
     * inheritance hierarchy and retrieve those defined on any super types.
     * @param follow boolean
     * @return Collection
     */
    public Collection getCreateMethods(boolean follow);

    /**
     * The name of the default exception to be generated for this service.
     * @return String
     */
    public String getDefaultExceptionName();

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
     * The fully qualified class name of the default exception.
     * @return String
     */
    public String getFullyQualifiedDefaultExceptionName();

    /**
     * Returns the fully qualified service base name.
     * @return String
     */
    public String getFullyQualifiedServiceBaseName();

    /**
     * Returns the fully qualified service bean delegate class name.
     * @return String
     */
    public String getFullyQualifiedServiceDelegateName();

    /**
     * Returns the fully qualified service bean implementation name.
     * @return String
     */
    public String getFullyQualifiedServiceImplementationName();

    /**
     * The fully qualified parent business interface name for this session bean.
     * @return String
     */
    public String getFullyQualifiedServiceInterfaceName();

    /**
     * Returns the fully qualified service bean listener name.
     * @return String
     */
    public String getFullyQualifiedServiceListenerName();

    /**
     * Returns the fully qualified service bean local interface name.
     * @return String
     */
    public String getFullyQualifiedServiceLocalInterfaceName();

    /**
     * Returns the fully qualified service bean name.
     * @return String
     */
    public String getFullyQualifiedServiceName();

    /**
     * Returns the fully qualified service bean remote interface name.
     * @return String
     */
    public String getFullyQualifiedServiceRemoteInterfaceName();

    /**
     * Returns the fully qualified service test class name
     * @return String
     */
    public String getFullyQualifiedServiceTestName();

    /**
     * A String representing the name of a home interface for this entity EJB.
     * @return String
     */
    public String getHomeInterfaceName();

    /**
     * Alll inherited instanceAttributes this session EJB.  The instanceAttributes are grouped by
     * the class that defines the instanceAttributes, with instanceAttributes from the most removed
     * super class first.
     * @return List
     */
    public List getInheritedInstanceAttributes();

    /**
     * Returns the Collection of target elements from the service bean class where  the target class
     * has a stereotype of Interceptor.
     * @return Collection
     */
    public Collection getInterceptorReferences();

    /**
     * The JNDI name to which this session EJB local interface is bound.
     * @return String
     */
    public String getJndiNameLocal();

    /**
     * Returns the JNDI name prefix for this session bean.  This is set using the jndiNamePrefix
     * namespace property and is commonly the ear file name excluding the extension for the EJB3
     * cartridge.  This prefix is applied whether the JNDI name is specified or not.
     * If no manual JNDI name is specified, then the prefix is applied like so:
     * jndiPrefix/EJBName/Remote
     * If a manual JNDI name is specified, then the prefix is applied:
     * jndiPrefix/ManualEJBJNDIName
     * @return String
     */
    public String getJndiNamePrefix();

    /**
     * The JNDI name to which this session EJB remote interface is bound.
     * @return String
     */
    public String getJndiNameRemote();

    /**
     * Returns the Collection of dependencies from the service bean class where the target class has
     * a stereotype of MessageDriven.
     * @return Collection
     */
    public Collection getMessageDrivenReferences();

    /**
     * Return only the Role object that do not have a Dependency stereotype of RunAs specified.
     * @return Collection<Role>
     */
    public Collection<Role> getNonRunAsRoles();

    /**
     * Returns the EJB3 container engine (jboss, weblogic).
     * @return String
     */
    public String getPersistenceContainer();

    /**
     * Returns the Collection of target objects from the service bean class that have a stereotype
     * of PersistenceContext.
     * @return Collection
     */
    public Collection getPersistenceContextReferences();

    /**
     * Specifies whether the persistence context for this EntityManager is transaction scoped or
     * extended.
     * @return String
     */
    public String getPersistenceContextType();

    /**
     * Returns the persistence context unit name for the injected EntityManger.  This is only
     * required if multiple persistence units exists.
     * @return String
     */
    public String getPersistenceContextUnitName();

    /**
     * Returns the Collection of dependencies from the service bean that have stereotype of
     * ResourceRef and the target has a stereotype of DataSource.
     * @return Collection
     */
    public Collection getResourceDataSourceReferences();

    /**
     * Returns the Collection of dependencies from the service bean that have stereotype of
     * ResourceRef and the target has a stereotype of UserTransaction.
     * @return Collection
     */
    public Collection getResourceUserTransactionReferences();

    /**
     * Returns the comma separated list of roles allowd to execute all operations in this session
     * bean.  This is defined by actor dependencies on the session bean.
     * @return String
     */
    public String getRolesAllowed();

    /**
     * Returns the run-as identity for the session bean which is used to establish the identity the
     * bean will use when making calls.  It does not affect the identity of the callers.
     * @return String
     */
    public String getRunAs();

    /**
     * Tagged value andromda.seam.component.conversional.ifnotbegunoutcome. Specifies that a
     * conversation scope component is conversational, meaning that no method of the component can
     * be called unless a long-running conversation started by this component is active (unless the
     * method would begin a new long-running conversation).
     * @return String
     */
    public String getSeamComponentConversionalIfNotBegunOutcome();

    /**
     * Tagged value andromda.seam.component.intercept. Determines when Seam interceptors are active.
     * The possible values are defined by the InterceptionType enumeration: ALWAYS,
     * AFTER_RESTORE_VIEW, AFTER_UPDATE_MODEL_VALUES, INVOKE_APPLICATION, NEVER.
     * When no interception type is explicitly specified, the default depends upon the component
     * type. For entity beans, the default is NEVER. For session beans, message driven beans and
     * JavaBeans, the default is ALWAYS.
     * @return String
     */
    public String getSeamComponentIntercept();

    /**
     * Tagged value andromda.seam.component.jndiname. Specifies the JNDI name that Seam will use to
     * look up the EJB component. If no JNDI name is explicitly specified, Seam will use the JNDI
     * pattern specified by org.jboss.seam.core.init.jndiPattern.
     * @return String
     */
    public String getSeamComponentJndiName();

    /**
     * Returns the Seam component name for the class.
     * @return String
     */
    public String getSeamComponentName();

    /**
     * Tagged value andromda.seam.component.role.name. Allows a Seam component to be bound to
     * multiple contexts variables. The Name/Scope annotations define a "default role". Each Role
     * annotation defines an additional role.
     * This tagged value specifies the context variable name.
     * @return Collection
     */
    public Collection getSeamComponentRoleNames();

    /**
     * If multiple roles are specified (since a seam component can be bound to multiple context
     * variables), then multiple roles are specified in the order the role names are specified. 
     * This is done by modelling the andromda.seam.component.role.scope tag with a comma separated
     * list of scopes.
     * @return Collection
     */
    public Collection getSeamComponentRoleScopeTypes();

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
     * @return String
     */
    public String getSeamComponentScopeType();

    /**
     * Returns a string with parameters for the Startup annotation. Supported parameters:
     * depends - specifies that the named components must be started first, if they are installed.
     * Specified by tagged value andromda.seam.component.startup.depends
     * @return String
     */
    public String getSeamComponentStartupParameters();

    /**
     * Tagged value andromda.seam.component.synchronized.timeout. Specifies that a component is
     * accessed concurrently by multiple clients, and that Seam should serialize requests. If a
     * request is not able to obtain its lock on the component in the given timeout period, an
     * exception will be raised.
     * @return String
     */
    public String getSeamComponentSynchronizedTimeout();

    /**
     * Returns the security domain value.  Specified using the securityRealm namespace property or
     * overriden in the andromda.ejb.security.realm tagged value.
     * @return String
     */
    public String getSecurityRealm();

    /**
     * Returns the service bean base name.
     * @return String
     */
    public String getServiceBaseName();

    /**
     * Return the service bean delegate class name.
     * @return String
     */
    public String getServiceDelegateName();

    /**
     * Returns the service bean implementation name.
     * @return String
     */
    public String getServiceImplementationName();

    /**
     * The parent business interface name for this session bean.
     * @return String
     */
    public String getServiceInterfaceName();

    /**
     * Returns the service bean callback listener name.
     * @return String
     */
    public String getServiceListenerName();

    /**
     * Returns the service bean local interface name.
     * @return String
     */
    public String getServiceLocalInterfaceName();

    /**
     * Returns service bean name.
     * @return String
     */
    public String getServiceName();

    /**
     * Returns the service bean remote interface name.
     * @return String
     */
    public String getServiceRemoteInterfaceName();

    /**
     * Returns the service bean test class name
     * @return String
     */
    public String getServiceTestName();

    /**
     * Returns the service test package name. This simply appends .test to the existing service
     * class package.
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
     * Gets the transaction type for this service (i.e. REQUIRED, etc)
     * @return String
     */
    public String getTransactionType();

    /**
     * Returns the name of the type of this Session EJB, either Stateless or Stateful.
     * @return String
     */
    public String getType();

    /**
     * A string indicating whether the Bean is a local or remotely accessable bean.
     * @return String
     */
    public String getViewType();

    /**
     * Indicates whether or not a default service exception should be allowed.
     * @return boolean
     */
    public boolean isAllowDefaultServiceException();

    /**
     * Determine whether clustering has been enabled.  Either set application wide using
     * enableClustering namespace property or via the andromda_service_clustered tagged value.
     * @return boolean
     */
    public boolean isClusteringEnabled();

    /**
     * Returns true if NO roles are permitted to execute operations in this bean.  This is specified
     * in the andromda.ejb.security.denyAll tagged value. Typically, it will be overriden at the
     * method level using the andromda.ejb.security.rolesAllowed tagged value.
     * @return boolean
     */
    public boolean isDenyAll();

    /**
     * Determines whether to exclude the invocation of the default interceptors for all business
     * method in the bean.
     * @return boolean
     */
    public boolean isExcludeDefaultInterceptors();

    /**
     * Returns true if this session bean has the stereotype Listener.  False otherwise.
     * @return boolean
     */
    public boolean isListenerEnabled();

    /**
     * Returns true if all roles are permitted to execute all operations in this session bean.  This
     * is specified in the andromda.ejb.security.permitAll tagged value.  It will override the
     * andromda.ejb.security.rolesAllowed tagged value.
     * @return boolean
     */
    public boolean isPermitAll();

    /**
     * Returns true if the persistence container is the JBoss engine.
     * @return boolean
     */
    public boolean isPersistenceContainerJboss();

    /**
     * Returns true if the persistence container is the Weblogic engine.
     * @return boolean
     */
    public boolean isPersistenceContainerWeblogic();

    /**
     * Returns true if this session bean has the <<Seam>> stereotype modelled indicating it is a
     * Seam session bean component.
     * @return boolean
     */
    public boolean isSeamComponent();

    /**
     * Tagged value andromda.seam.component.readonly. Specifies that a JavaBean component or
     * component method does not require state replication at the end of the invocation.
     * @return boolean
     */
    public boolean isSeamComponentReadonly();

    /**
     * Returns true if stereotype <<Startup>> is set. Specifies that an application scope component
     * is started immediately at initialization time. This is mainly used for certain built-in
     * components that bootstrap critical infrastructure such as JNDI, datasources, etc.
     * @return boolean
     */
    public boolean isSeamComponentStartup();

    /**
     * Returns true if stereotype <<Transactional>> is set. Specifies that a JavaBean component
     * should have a similar transactional behavior to the default behavior of a session bean
     * component. ie. method invocations should take place in a transaction, and if no transaction
     * exists when the method is called, a transaction will be started just for that method. This
     * annotation may be applied at either class or method level.
     * @return boolean
     */
    public boolean isSeamComponentTransactional();

    /**
     * Returns true if the security realm is specified indicating to generate the security
     * infrastructure files.
     * @return boolean
     */
    public boolean isSecurityEnabled();

    /**
     * True/false depending on whether or not this Session EJB is stateful or not.
     * @return boolean
     */
    public boolean isStateful();

    /**
     * True/false depending on whether or not this Session EJB is stateless or not.
     * @return boolean
     */
    public boolean isStateless();

    /**
     * Whether or not to allow a synthetic (auto generated) create method.
     * @return boolean
     */
    public boolean isSyntheticCreateMethodAllowed();

    /**
     * Returns true if the transaction demarcation strategy is bean managedfor this bean.
     * @return boolean
     */
    public boolean isTransactionManagementBean();

    /**
     * Return true if the view type accessability for this bean is both.
     * @return boolean
     */
    public boolean isViewTypeBoth();

    /**
     * Return true if the view type accessability for this bean is local or both.
     * Always generate a local interface is this session bean is a Seam component.
     * @return boolean
     */
    public boolean isViewTypeLocal();

    /**
     * Return true if the view type accessability for this bean is remote or both.
     * @return boolean
     */
    public boolean isViewTypeRemote();

    /**
     * Returns true if the bean view type was explicity set to both view using tagged value or set
     * as the app wide default.
     * @return boolean
     */
    public boolean isViewTypeStrictlyBoth();

    /**
     * Returns true if the bean view type was explicity set to local view using tagged value or set
     * as the app wide default.
     * @return boolean
     */
    public boolean isViewTypeStrictlyLocal();

    /**
     * Returns true if the bean view type was explicity set to remote view using tagged value or set
     * as the app wide default.
     * @return boolean
     */
    public boolean isViewTypeStrictlyRemote();

    /**
     * Returns true if the session bean has either one of the following:
     * 1. The <<WebService>> stereotype is modelled on the bean class;
     * 2. The <<WebServiceOperation>> stereotype is modelled on at least one business method.
     * @return boolean
     */
    public boolean isWebServiceEnabled();

    /**
     * Returns true if at least one of the session bean operations is marked with the
     * WebServiceOperation stereotype.
     * @return boolean
     */
    public boolean isWebServiceOperationExists();
}