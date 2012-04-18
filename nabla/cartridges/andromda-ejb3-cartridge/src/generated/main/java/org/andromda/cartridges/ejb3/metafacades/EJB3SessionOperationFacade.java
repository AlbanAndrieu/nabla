// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.ServiceOperation;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3SessionOperationFacade
    extends ServiceOperation
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3SessionOperationFacadeMetaType();

    /**
     * Return the flush mode to determine when the changes to the database are performed in the
     * application transaction.  This is typically set on a Stateful session bean where a
     * transaction span several methods and the database update is only required upon completion of
     * the final method.
     * @return String
     */
    public String getFlushMode();

    /**
     * The method call for the implementation operation.
     * @return String
     */
    public String getImplementationCall();

    /**
     * The name of the operation used within the service implementation that contains the core
     * logic.
     * @return String
     */
    public String getImplementationName();

    /**
     * The signature of the implementation operation.
     * @return String
     */
    public String getImplementationSignature();

    /**
     * Returns the Collection of target elements from the service bean method where  the target
     * class has a stereotype of Interceptor.
     * @return Collection
     */
    public Collection getInterceptorReferences();

    /**
     * Return only the Role object that do not have a Dependency stereotype of RunAs specified.
     * @return Collection<Role>
     */
    public Collection<Role> getNonRunAsRoles();

    /**
     * Returns the comma separated list of roles allowd to execute this operation.  This is defined
     * by actor dependencies.
     * @return String
     */
    public String getRolesAllowed();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.Factory annotation. Supported
     * parameters:
     * * value - specifies the name of the context variable. If the method is a getter method,
     * default to the JavaBeans property name.
     * * scope - specifies the scope that Seam should bind the returned value to. Only meaningful
     * for factory methods which return a value.
     * @return String
     */
    public String getSeamBijectionFactoryParameters();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.Begin annotation. Supported
     * parameters:
     * * ifOutcome - specifies the JSF outcome or outcomes that result in a new long-running
     * conversation context.
     * * join - determines the behavior when a long-running conversation is already in progress. If
     * true, the context is propagated. If false, an exception is thrown. Default to false. This
     * setting is ignored when nested=true is specified
     * * nested - specifies that a nested conversation should be started if a long-running
     * conversation is already in progress.
     * * flushMode - set the flush mode of any Seam-managed Hibernate sessions or JPA persistence
     * contexts that are created during this conversation.
     * * pageflow - a process definition name of a jBPM process definition deployed via
     * org.jboss.seam.core.jbpm.pageflowDefinitions.
     * @return String
     */
    public String getSeamConversationBeginParameters();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.BeginTask annotation. Supported
     * parameters:
     * * taskIdParameter - the name of a request parameter which holds the id of the task. Default
     * to "taskId", which is also the default used by the Seam taskList JSF component.
     * * flushMode - set the flush mode of any Seam-managed Hibernate sessions or JPA persistence
     * contexts that are created during this conversation.
     * @return String
     */
    public String getSeamConversationBeginTaskParameters();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.CreateProcess annotation.
     * Supported parameters:
     * * definition - the name of the jBPM process definition deployed via
     * org.jboss.seam.core.jbpm.processDefinitions.
     * @return String
     */
    public String getSeamConversationCreateProcessParameters();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.End annotation. Supported
     * parameters:
     * * ifOutcome - specifies the JSF outcome or outcomes that result in the end of the current
     * long-running conversation.
     * * beforeRedirect - by default, the conversation will not actually be destroyed until after
     * any redirect has occurred. Setting beforeRedirect=true specifies that the conversation should
     * be destroyed at the end of the current request, and that the redirect will be processed in a
     * new temporary conversation context.
     * @return String
     */
    public String getSeamConversationEndParameters();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.EndTask annotation. Supported
     * parameters:
     * * transition - the name of the jBPM transition to be triggered when ending the task. Defaults
     * to the default transition.
     * * ifOutcome - specifies the JSF outcome or outcomes that result in the end of the task.
     * * beforeRedirect - by default, the conversation will not actually be destroyed until after
     * any redirect has occurred. Setting beforeRedirect=true specifies that the conversation should
     * be destroyed at the end of the current request, and that the redirect will be processed in a
     * new temporary conversation context.
     * @return String
     */
    public String getSeamConversationEndTaskParameters();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.ResumeProcess annotation.
     * Supported parameters:
     * * processIdParameter - the name a request parameter holding the process id. Default to
     * "processId".
     * @return String
     */
    public String getSeamConversationResumeProcessParameters();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.StartTask annotation. Supported
     * parameters:
     * * taskIdParameter - the name of a request parameter which holds the id of the task. Default
     * to "taskId", which is also the default used by the Seam taskList JSF component.
     * * flushMode - set the flush mode of any Seam-managed Hibernate sessions or JPA persistence
     * contexts that are created during this conversation.
     * @return String
     */
    public String getSeamConversationStartTaskParameters();

    /**
     * Specifies that the method should be called when a component-driven event of the specified
     * type occurs.
     * @return String
     */
    public String getSeamObserverEventName();

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.Rollback annotation. Supported
     * parameters:
     * * ifOutcome * the JSF outcomes that cause a transaction rollback (no outcomes is interpreted
     * to mean any outcome).
     * @return String
     */
    public String getSeamTransactionRollbackParameters();

    /**
     * Returns the JSF outcome when validation fails, set using andromda.seam.validation.outcome.
     * @return String
     */
    public String getSeamValidationOutcome();

    /**
     * Returns a string with parameters for the org.jboss.seam.annotations.WebRemote annotation.
     * Supported parameters:
     * exclude - Allows objects to be excluded from the result's object graph. Example:
     * WebRemote(exclude="path.to.exclude")
     * @return String
     */
    public String getSeamWebRemoteParameters();

    /**
     * Returns the operation test name
     * @return String
     */
    public String getTestName();

    /**
     * Returns the session operation test signature used to generate the test method for the
     * operation  in the session bean test class.
     * @return String
     */
    public String getTestSignature();

    /**
     * Gets the throws clause for this service or null if the operation doesn't have any exceptions.
     * @return String
     */
    public String getThrowsClause();

    /**
     * Retrieves the throws clause allowing a comma separated list of exceptions to be passed in and
     * appended to the list.
     * @param initialExceptions String
     * @return String
     */
    public String getThrowsClause(String initialExceptions);

    /**
     * Gets the transaction type for this attribute (i.e. REQUIRED, etc)
     * @return String
     */
    public String getTransactionType();

    /**
     * Returns a string representing whether this operation is local, remotely or both local and
     * remotely accessible.  This overrides the default from the session bean view type.
     * @return String
     */
    public String getViewType();

    /**
     * True/false on whether or not this operation is an EJB session business operation.
     * @return boolean
     */
    public boolean isBusinessOperation();

    /**
     * Returns true if NO roles are permitted to execute this operation in this bean.  This is
     * specified in the andromda.ejb.security.denyAll tagged value.
     * @return boolean
     */
    public boolean isDenyAll();

    /**
     * Specifies whether to exclude the invocation of the class interceptors for the applied
     * business method.
     * @return boolean
     */
    public boolean isExcludeClassInterceptors();

    /**
     * Determines whether to exclude the invocation of the default interceptors for the applied
     * business method.
     * @return boolean
     */
    public boolean isExcludeDefaultInterceptors();

    /**
     * Returns true if this operation is marked with any of the lifecycle callback stereotypes like
     * PostCostructs, PreDestroy etc.
     * @return boolean
     */
    public boolean isLifecycleCallback();

    /**
     * Returns true if all roles are permitted to execute this operation.  This is specified in the
     * andromda.ejb.security.permitAll tagged value.  It will override the
     * andromda.ejb.security.rolesAllowed tagged value.
     * @return boolean
     */
    public boolean isPermitAll();

    /**
     * Returns true if the associated operation has the <<PostActivate>> stereotype.
     * This is only applicable for operations in a stateful session bean.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPostActivate();

    /**
     * Returns true if the associated operation has the <<PostConstruct>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPostConstruct();

    /**
     * Returns true if the associated operation has the <<PreDestroy>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPreDestroy();

    /**
     * Returns true if the associated operation has the <<PrePassivate>> stereotype.
     * This is only applicable for operations in a stateful session bean.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPrePassivate();

    /**
     * Stereotype Asynchronous. Specifies that the method call is processed asynchronously.
     * @return boolean
     */
    public boolean isSeamAsynchronous();

    /**
     * Returns true when stereotype <<Factory>> is set. When it is used on an operation which return
     * void that operation will be used to initialize the value of the named context variable, when
     * the context variable has no value.
     * When it is used on an operation that returns a value then Seam should use that value to
     * initialize the value of the named context variable, when the context variable has no value.
     * The context variable is specified by tagged value andromda.seam.bijection.factory.value. If
     * the method is a getter method, default to the JavaBeans property name.
     * If no scope is explicitly specified by tagged value andromda.seam.bijection.factory.scope,
     * the scope of the component with the Factory method is used (unless the component is
     * stateless, in which case the EVENT context is used).
     * @return boolean
     */
    public boolean isSeamBijectionFactory();

    /**
     * Returns true if the <<Begin>> stereotype is set. Specifies that a long-running conversation
     * begins when this method returns a non-null outcome without exception.
     * @return boolean
     */
    public boolean isSeamConversationBegin();

    /**
     * Returns true if stereotype <<BeginTask>> is set. Resumes work on an incomplete jBPM task.
     * Specifies that a long-running conversation begins when this method returns a non-null outcome
     * without exception. This conversation is associated with the jBPM task specified in the named
     * request parameter. Within the context of this conversation, a business process context is
     * also defined, for the business process instance of the task instance.
     * @return boolean
     */
    public boolean isSeamConversationBeginTask();

    /**
     * Returns true if stereotype <<CreateProcess>> is set. Creates a new jBPM process instance when
     * the method returns a non-null outcome without exception. The ProcessInstance object will be
     * available in a context variable named processInstance.
     * @return boolean
     */
    public boolean isSeamConversationCreateProcess();

    /**
     * Returns true if stereotype <<End>> is set. Specifies that a long-running conversation ends
     * when this method returns a non-null outcome without exception.
     * @return boolean
     */
    public boolean isSeamConversationEnd();

    /**
     * Returns true if stereotype <<EndTask>> is set and "Ends" a jBPM task. Specifies that a
     * long-running conversation ends when this method returns a non-null outcome, and that the
     * current task is complete. Triggers a jBPM transition. The actual transition triggered will be
     * the default transition unless the application has called Transition.setName() on the built-in
     * component named transition.
     * @return boolean
     */
    public boolean isSeamConversationEndTask();

    /**
     * Returns true if stereotype <<ResumeProcess>> is set. Re-enters the scope of an existing jBPM
     * process instance when the method returns a non-null outcome without exception. The
     * ProcessInstance object will be available in a context variable named processInstance.
     * @return boolean
     */
    public boolean isSeamConversationResumeProcess();

    /**
     * Returns true if stereotype <<StartTask>> is set. It "Starts" a jBPM task. Specifies that a
     * long-running conversation begins when this method returns a non-null outcome without
     * exception. This conversation is associated with the jBPM task specified in the named request
     * parameter. Within the context of this conversation, a business process context is also
     * defined, for the business process instance of the task instance.
     * The jBPM TaskInstance will be available in a request context variable named taskInstance. The
     * jPBM ProcessInstance will be available in a request context variable named processInstance.
     * (Of course, these objects are available for injection via In.)
     * @return boolean
     */
    public boolean isSeamConversationStartTask();

    /**
     * Returns true if the operation has the <<Create>> stereotype modelled.
     * @return boolean
     */
    public boolean isSeamLifecycleCreate();

    /**
     * Returns true if the operation has the <<Destroy>> stereotype modelled.
     * @return boolean
     */
    public boolean isSeamLifecycleDestroy();

    /**
     * True if the annotated method is a seam component-driven event observer.
     * @return boolean
     */
    public boolean isSeamObserver();

    /**
     * Returns true if stereotype <<Rollback>> is set. If the outcome of the method matches any of
     * the listed outcomes, or if no outcomes are listed, set the transaction to rollback only when
     * the method completes.
     * @return boolean
     */
    public boolean isSeamTransactionRollback();

    /**
     * Specifies that a JavaBean component should have a similar transactional behavior to the
     * default behavior of a session bean component. ie. method invocations should take place in a
     * transaction, and if no transaction exists when the method is called, a transaction will be
     * started just for that method. This annotation may be applied at either class or method level.
     * @return boolean
     */
    public boolean isSeamTransactional();

    /**
     * Returns true if the andromda.seam.validation.refreshEntities is modelled on the operation as
     * true to indicate that any invalid entities in the managed state should be refreshed from the
     * database when validation fails.
     * @return boolean
     */
    public boolean isSeamValidationRefreshEntities();

    /**
     * Returns true if the <<Validator>> stereotype is modelled on this operation and the session
     * bean is a Seam component.
     * @return boolean
     */
    public boolean isSeamValidationValidator();

    /**
     * True if <<WebRemote>> stereotype is set. Indicates that the annotated method may be called
     * from client-side JavaScript.
     * @return boolean
     */
    public boolean isSeamWebRemote();

    /**
     * Returns true if the Timeout stereotype is modelled on the session bean operation.  This will
     * associate the operation as a timeout callback with the Timer Service.  It does not setup the
     * timer.
     * @return boolean
     */
    public boolean isTimeoutCallback();

    /**
     * Return true if the view type of the operation is both after examing all aspects of the owner
     * and operation. This is used to determine which interface to use in the service delegate.
     * @return boolean
     */
    public boolean isViewTypeAbsoluteBoth();

    /**
     * Return true if the view type of the operation is local after examing all aspects of the owner
     * and operation. This is used to determine if operation is included in local interface.
     * @return boolean
     */
    public boolean isViewTypeAbsoluteLocal();

    /**
     * Return true if the view type of the operation is local after examing all aspects of the owner
     * and operation. This is used to determine if operation is included in remote interface.
     * @return boolean
     */
    public boolean isViewTypeAbsoluteRemote();

    /**
     * Returns true if the view type accessability for this operation is both local and remote.
     * @return boolean
     */
    public boolean isViewTypeBoth();

    /**
     * Return true if the view type accessability for this operation is local.
     * @return boolean
     */
    public boolean isViewTypeLocal();

    /**
     * Returns true if the view type accessability for the operation is remote.
     * @return boolean
     */
    public boolean isViewTypeRemote();

    /**
     * Returns true if the operation view type was explicity set to both using tagged value.
     * @return boolean
     */
    public boolean isViewTypeStrictlyBoth();

    /**
     * Returns true if the operation view type was explicity set to local view using tagged value.
     * @return boolean
     */
    public boolean isViewTypeStrictlyLocal();

    /**
     * Returns true if the operation view type was explicity set to remote view using tagged value.
     * @return boolean
     */
    public boolean isViewTypeStrictlyRemote();
}