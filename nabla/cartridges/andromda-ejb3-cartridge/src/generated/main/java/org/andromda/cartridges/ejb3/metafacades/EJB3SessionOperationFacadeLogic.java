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
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.Destination;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.Role;
import org.andromda.metafacades.uml.Service;
import org.andromda.metafacades.uml.ServiceOperation;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.apache.log4j.Logger;

/**
 * TODO: Model Documentation for org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade
 * MetafacadeLogic for EJB3SessionOperationFacade
 *
 * @see EJB3SessionOperationFacade
 */
public abstract class EJB3SessionOperationFacadeLogic
    extends MetafacadeBase
    implements EJB3SessionOperationFacade
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
    protected EJB3SessionOperationFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superServiceOperation =
           (ServiceOperation)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.ServiceOperation",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(EJB3SessionOperationFacadeLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3SessionOperationFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade";
        }
        return context;
    }

    private ServiceOperation superServiceOperation;
    private boolean superServiceOperationInitialized = false;

    /**
     * Gets the ServiceOperation parent instance.
     * @return this.superServiceOperation ServiceOperation
     */
    private ServiceOperation getSuperServiceOperation()
    {
        if (!this.superServiceOperationInitialized)
        {
            ((MetafacadeBase)this.superServiceOperation).setMetafacadeContext(this.getMetafacadeContext());
            this.superServiceOperationInitialized = true;
        }
        return this.superServiceOperation;
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
            if (this.superServiceOperationInitialized)
            {
                ((MetafacadeBase)this.superServiceOperation).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see EJB3SessionOperationFacade
     */
    public boolean isEJB3SessionOperationFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getViewType()
    * @return String
    */
    protected abstract String handleGetViewType();

    private transient String viewType1a;
    private transient boolean viewType1aSet = false;

    /**
     * Returns a string representing whether this operation is local, remotely or both local and
     * remotely accessible.  This overrides the default from the session bean view type.
     * @return (String)handleGetViewType()
     */
    public final String getViewType()
    {
        String viewType1a = this.viewType1a;
        if (!this.viewType1aSet)
        {
            // viewType has no pre constraints
            viewType1a = handleGetViewType();
            // viewType has no post constraints
            this.viewType1a = viewType1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewType1aSet = true;
            }
        }
        return viewType1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeRemote()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeRemote();

    private transient boolean viewTypeRemote2a;
    private transient boolean viewTypeRemote2aSet = false;

    /**
     * Returns true if the view type accessability for the operation is remote.
     * @return (boolean)handleIsViewTypeRemote()
     */
    public final boolean isViewTypeRemote()
    {
        boolean viewTypeRemote2a = this.viewTypeRemote2a;
        if (!this.viewTypeRemote2aSet)
        {
            // viewTypeRemote has no pre constraints
            viewTypeRemote2a = handleIsViewTypeRemote();
            // viewTypeRemote has no post constraints
            this.viewTypeRemote2a = viewTypeRemote2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeRemote2aSet = true;
            }
        }
        return viewTypeRemote2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeLocal()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeLocal();

    private transient boolean viewTypeLocal3a;
    private transient boolean viewTypeLocal3aSet = false;

    /**
     * Return true if the view type accessability for this operation is local.
     * @return (boolean)handleIsViewTypeLocal()
     */
    public final boolean isViewTypeLocal()
    {
        boolean viewTypeLocal3a = this.viewTypeLocal3a;
        if (!this.viewTypeLocal3aSet)
        {
            // viewTypeLocal has no pre constraints
            viewTypeLocal3a = handleIsViewTypeLocal();
            // viewTypeLocal has no post constraints
            this.viewTypeLocal3a = viewTypeLocal3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeLocal3aSet = true;
            }
        }
        return viewTypeLocal3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeBoth()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeBoth();

    private transient boolean viewTypeBoth4a;
    private transient boolean viewTypeBoth4aSet = false;

    /**
     * Returns true if the view type accessability for this operation is both local and remote.
     * @return (boolean)handleIsViewTypeBoth()
     */
    public final boolean isViewTypeBoth()
    {
        boolean viewTypeBoth4a = this.viewTypeBoth4a;
        if (!this.viewTypeBoth4aSet)
        {
            // viewTypeBoth has no pre constraints
            viewTypeBoth4a = handleIsViewTypeBoth();
            // viewTypeBoth has no post constraints
            this.viewTypeBoth4a = viewTypeBoth4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeBoth4aSet = true;
            }
        }
        return viewTypeBoth4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getTransactionType()
    * @return String
    */
    protected abstract String handleGetTransactionType();

    private transient String transactionType5a;
    private transient boolean transactionType5aSet = false;

    /**
     * Gets the transaction type for this attribute (i.e. REQUIRED, etc)
     * @return (String)handleGetTransactionType()
     */
    public final String getTransactionType()
    {
        String transactionType5a = this.transactionType5a;
        if (!this.transactionType5aSet)
        {
            // transactionType has no pre constraints
            transactionType5a = handleGetTransactionType();
            // transactionType has no post constraints
            this.transactionType5a = transactionType5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.transactionType5aSet = true;
            }
        }
        return transactionType5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isBusinessOperation()
    * @return boolean
    */
    protected abstract boolean handleIsBusinessOperation();

    private transient boolean businessOperation6a;
    private transient boolean businessOperation6aSet = false;

    /**
     * True/false on whether or not this operation is an EJB session business operation.
     * @return (boolean)handleIsBusinessOperation()
     */
    public final boolean isBusinessOperation()
    {
        boolean businessOperation6a = this.businessOperation6a;
        if (!this.businessOperation6aSet)
        {
            // businessOperation has no pre constraints
            businessOperation6a = handleIsBusinessOperation();
            // businessOperation has no post constraints
            this.businessOperation6a = businessOperation6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.businessOperation6aSet = true;
            }
        }
        return businessOperation6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getRolesAllowed()
    * @return String
    */
    protected abstract String handleGetRolesAllowed();

    private transient String rolesAllowed7a;
    private transient boolean rolesAllowed7aSet = false;

    /**
     * Returns the comma separated list of roles allowd to execute this operation.  This is defined
     * by actor dependencies.
     * @return (String)handleGetRolesAllowed()
     */
    public final String getRolesAllowed()
    {
        String rolesAllowed7a = this.rolesAllowed7a;
        if (!this.rolesAllowed7aSet)
        {
            // rolesAllowed has no pre constraints
            rolesAllowed7a = handleGetRolesAllowed();
            // rolesAllowed has no post constraints
            this.rolesAllowed7a = rolesAllowed7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.rolesAllowed7aSet = true;
            }
        }
        return rolesAllowed7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isPermitAll()
    * @return boolean
    */
    protected abstract boolean handleIsPermitAll();

    private transient boolean permitAll8a;
    private transient boolean permitAll8aSet = false;

    /**
     * Returns true if all roles are permitted to execute this operation.  This is specified in the
     * andromda.ejb.security.permitAll tagged value.  It will override the
     * andromda.ejb.security.rolesAllowed tagged value.
     * @return (boolean)handleIsPermitAll()
     */
    public final boolean isPermitAll()
    {
        boolean permitAll8a = this.permitAll8a;
        if (!this.permitAll8aSet)
        {
            // permitAll has no pre constraints
            permitAll8a = handleIsPermitAll();
            // permitAll has no post constraints
            this.permitAll8a = permitAll8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.permitAll8aSet = true;
            }
        }
        return permitAll8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isDenyAll()
    * @return boolean
    */
    protected abstract boolean handleIsDenyAll();

    private transient boolean denyAll9a;
    private transient boolean denyAll9aSet = false;

    /**
     * Returns true if NO roles are permitted to execute this operation in this bean.  This is
     * specified in the andromda.ejb.security.denyAll tagged value.
     * @return (boolean)handleIsDenyAll()
     */
    public final boolean isDenyAll()
    {
        boolean denyAll9a = this.denyAll9a;
        if (!this.denyAll9aSet)
        {
            // denyAll has no pre constraints
            denyAll9a = handleIsDenyAll();
            // denyAll has no post constraints
            this.denyAll9a = denyAll9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.denyAll9aSet = true;
            }
        }
        return denyAll9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getFlushMode()
    * @return String
    */
    protected abstract String handleGetFlushMode();

    private transient String flushMode10a;
    private transient boolean flushMode10aSet = false;

    /**
     * Return the flush mode to determine when the changes to the database are performed in the
     * application transaction.  This is typically set on a Stateful session bean where a
     * transaction span several methods and the database update is only required upon completion of
     * the final method.
     * @return (String)handleGetFlushMode()
     */
    public final String getFlushMode()
    {
        String flushMode10a = this.flushMode10a;
        if (!this.flushMode10aSet)
        {
            // flushMode has no pre constraints
            flushMode10a = handleGetFlushMode();
            // flushMode has no post constraints
            this.flushMode10a = flushMode10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.flushMode10aSet = true;
            }
        }
        return flushMode10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getThrowsClause()
    * @return String
    */
    protected abstract String handleGetThrowsClause();

    private transient String throwsClause11a;
    private transient boolean throwsClause11aSet = false;

    /**
     * Gets the throws clause for this service or null if the operation doesn't have any exceptions.
     * @return (String)handleGetThrowsClause()
     */
    public final String getThrowsClause()
    {
        String throwsClause11a = this.throwsClause11a;
        if (!this.throwsClause11aSet)
        {
            // throwsClause has no pre constraints
            throwsClause11a = handleGetThrowsClause();
            // throwsClause has no post constraints
            this.throwsClause11a = throwsClause11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.throwsClause11aSet = true;
            }
        }
        return throwsClause11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isTimeoutCallback()
    * @return boolean
    */
    protected abstract boolean handleIsTimeoutCallback();

    private transient boolean timeoutCallback12a;
    private transient boolean timeoutCallback12aSet = false;

    /**
     * Returns true if the Timeout stereotype is modelled on the session bean operation.  This will
     * associate the operation as a timeout callback with the Timer Service.  It does not setup the
     * timer.
     * @return (boolean)handleIsTimeoutCallback()
     */
    public final boolean isTimeoutCallback()
    {
        boolean timeoutCallback12a = this.timeoutCallback12a;
        if (!this.timeoutCallback12aSet)
        {
            // timeoutCallback has no pre constraints
            timeoutCallback12a = handleIsTimeoutCallback();
            // timeoutCallback has no post constraints
            this.timeoutCallback12a = timeoutCallback12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.timeoutCallback12aSet = true;
            }
        }
        return timeoutCallback12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getImplementationName()
    * @return String
    */
    protected abstract String handleGetImplementationName();

    private transient String implementationName13a;
    private transient boolean implementationName13aSet = false;

    /**
     * The name of the operation used within the service implementation that contains the core
     * logic.
     * @return (String)handleGetImplementationName()
     */
    public final String getImplementationName()
    {
        String implementationName13a = this.implementationName13a;
        if (!this.implementationName13aSet)
        {
            // implementationName has no pre constraints
            implementationName13a = handleGetImplementationName();
            // implementationName has no post constraints
            this.implementationName13a = implementationName13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.implementationName13aSet = true;
            }
        }
        return implementationName13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getImplementationCall()
    * @return String
    */
    protected abstract String handleGetImplementationCall();

    private transient String implementationCall14a;
    private transient boolean implementationCall14aSet = false;

    /**
     * The method call for the implementation operation.
     * @return (String)handleGetImplementationCall()
     */
    public final String getImplementationCall()
    {
        String implementationCall14a = this.implementationCall14a;
        if (!this.implementationCall14aSet)
        {
            // implementationCall has no pre constraints
            implementationCall14a = handleGetImplementationCall();
            // implementationCall has no post constraints
            this.implementationCall14a = implementationCall14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.implementationCall14aSet = true;
            }
        }
        return implementationCall14a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getImplementationSignature()
    * @return String
    */
    protected abstract String handleGetImplementationSignature();

    private transient String implementationSignature15a;
    private transient boolean implementationSignature15aSet = false;

    /**
     * The signature of the implementation operation.
     * @return (String)handleGetImplementationSignature()
     */
    public final String getImplementationSignature()
    {
        String implementationSignature15a = this.implementationSignature15a;
        if (!this.implementationSignature15aSet)
        {
            // implementationSignature has no pre constraints
            implementationSignature15a = handleGetImplementationSignature();
            // implementationSignature has no post constraints
            this.implementationSignature15a = implementationSignature15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.implementationSignature15aSet = true;
            }
        }
        return implementationSignature15a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getInterceptorReferences()
    * @return Collection
    */
    protected abstract Collection handleGetInterceptorReferences();

    private transient Collection interceptorReferences16a;
    private transient boolean interceptorReferences16aSet = false;

    /**
     * Returns the Collection of target elements from the service bean method where  the target
     * class has a stereotype of Interceptor.
     * @return (Collection)handleGetInterceptorReferences()
     */
    public final Collection getInterceptorReferences()
    {
        Collection interceptorReferences16a = this.interceptorReferences16a;
        if (!this.interceptorReferences16aSet)
        {
            // interceptorReferences has no pre constraints
            interceptorReferences16a = handleGetInterceptorReferences();
            // interceptorReferences has no post constraints
            this.interceptorReferences16a = interceptorReferences16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.interceptorReferences16aSet = true;
            }
        }
        return interceptorReferences16a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isExcludeDefaultInterceptors()
    * @return boolean
    */
    protected abstract boolean handleIsExcludeDefaultInterceptors();

    private transient boolean excludeDefaultInterceptors17a;
    private transient boolean excludeDefaultInterceptors17aSet = false;

    /**
     * Determines whether to exclude the invocation of the default interceptors for the applied
     * business method.
     * @return (boolean)handleIsExcludeDefaultInterceptors()
     */
    public final boolean isExcludeDefaultInterceptors()
    {
        boolean excludeDefaultInterceptors17a = this.excludeDefaultInterceptors17a;
        if (!this.excludeDefaultInterceptors17aSet)
        {
            // excludeDefaultInterceptors has no pre constraints
            excludeDefaultInterceptors17a = handleIsExcludeDefaultInterceptors();
            // excludeDefaultInterceptors has no post constraints
            this.excludeDefaultInterceptors17a = excludeDefaultInterceptors17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.excludeDefaultInterceptors17aSet = true;
            }
        }
        return excludeDefaultInterceptors17a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isExcludeClassInterceptors()
    * @return boolean
    */
    protected abstract boolean handleIsExcludeClassInterceptors();

    private transient boolean excludeClassInterceptors18a;
    private transient boolean excludeClassInterceptors18aSet = false;

    /**
     * Specifies whether to exclude the invocation of the class interceptors for the applied
     * business method.
     * @return (boolean)handleIsExcludeClassInterceptors()
     */
    public final boolean isExcludeClassInterceptors()
    {
        boolean excludeClassInterceptors18a = this.excludeClassInterceptors18a;
        if (!this.excludeClassInterceptors18aSet)
        {
            // excludeClassInterceptors has no pre constraints
            excludeClassInterceptors18a = handleIsExcludeClassInterceptors();
            // excludeClassInterceptors has no post constraints
            this.excludeClassInterceptors18a = excludeClassInterceptors18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.excludeClassInterceptors18aSet = true;
            }
        }
        return excludeClassInterceptors18a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isPostConstruct()
    * @return boolean
    */
    protected abstract boolean handleIsPostConstruct();

    private transient boolean postConstruct19a;
    private transient boolean postConstruct19aSet = false;

    /**
     * Returns true if the associated operation has the <<PostConstruct>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPostConstruct()
     */
    public final boolean isPostConstruct()
    {
        boolean postConstruct19a = this.postConstruct19a;
        if (!this.postConstruct19aSet)
        {
            // postConstruct has no pre constraints
            postConstruct19a = handleIsPostConstruct();
            // postConstruct has no post constraints
            this.postConstruct19a = postConstruct19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.postConstruct19aSet = true;
            }
        }
        return postConstruct19a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isPreDestroy()
    * @return boolean
    */
    protected abstract boolean handleIsPreDestroy();

    private transient boolean preDestroy20a;
    private transient boolean preDestroy20aSet = false;

    /**
     * Returns true if the associated operation has the <<PreDestroy>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPreDestroy()
     */
    public final boolean isPreDestroy()
    {
        boolean preDestroy20a = this.preDestroy20a;
        if (!this.preDestroy20aSet)
        {
            // preDestroy has no pre constraints
            preDestroy20a = handleIsPreDestroy();
            // preDestroy has no post constraints
            this.preDestroy20a = preDestroy20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.preDestroy20aSet = true;
            }
        }
        return preDestroy20a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isPostActivate()
    * @return boolean
    */
    protected abstract boolean handleIsPostActivate();

    private transient boolean postActivate21a;
    private transient boolean postActivate21aSet = false;

    /**
     * Returns true if the associated operation has the <<PostActivate>> stereotype.
     * This is only applicable for operations in a stateful session bean.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPostActivate()
     */
    public final boolean isPostActivate()
    {
        boolean postActivate21a = this.postActivate21a;
        if (!this.postActivate21aSet)
        {
            // postActivate has no pre constraints
            postActivate21a = handleIsPostActivate();
            // postActivate has no post constraints
            this.postActivate21a = postActivate21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.postActivate21aSet = true;
            }
        }
        return postActivate21a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isPrePassivate()
    * @return boolean
    */
    protected abstract boolean handleIsPrePassivate();

    private transient boolean prePassivate22a;
    private transient boolean prePassivate22aSet = false;

    /**
     * Returns true if the associated operation has the <<PrePassivate>> stereotype.
     * This is only applicable for operations in a stateful session bean.
     * NOTE: The method signature must return void and have no args.
     * @return (boolean)handleIsPrePassivate()
     */
    public final boolean isPrePassivate()
    {
        boolean prePassivate22a = this.prePassivate22a;
        if (!this.prePassivate22aSet)
        {
            // prePassivate has no pre constraints
            prePassivate22a = handleIsPrePassivate();
            // prePassivate has no post constraints
            this.prePassivate22a = prePassivate22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.prePassivate22aSet = true;
            }
        }
        return prePassivate22a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isLifecycleCallback()
    * @return boolean
    */
    protected abstract boolean handleIsLifecycleCallback();

    private transient boolean lifecycleCallback23a;
    private transient boolean lifecycleCallback23aSet = false;

    /**
     * Returns true if this operation is marked with any of the lifecycle callback stereotypes like
     * PostCostructs, PreDestroy etc.
     * @return (boolean)handleIsLifecycleCallback()
     */
    public final boolean isLifecycleCallback()
    {
        boolean lifecycleCallback23a = this.lifecycleCallback23a;
        if (!this.lifecycleCallback23aSet)
        {
            // lifecycleCallback has no pre constraints
            lifecycleCallback23a = handleIsLifecycleCallback();
            // lifecycleCallback has no post constraints
            this.lifecycleCallback23a = lifecycleCallback23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.lifecycleCallback23aSet = true;
            }
        }
        return lifecycleCallback23a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamValidationValidator()
    * @return boolean
    */
    protected abstract boolean handleIsSeamValidationValidator();

    private transient boolean seamValidationValidator24a;
    private transient boolean seamValidationValidator24aSet = false;

    /**
     * Returns true if the <<Validator>> stereotype is modelled on this operation and the session
     * bean is a Seam component.
     * @return (boolean)handleIsSeamValidationValidator()
     */
    public final boolean isSeamValidationValidator()
    {
        boolean seamValidationValidator24a = this.seamValidationValidator24a;
        if (!this.seamValidationValidator24aSet)
        {
            // seamValidationValidator has no pre constraints
            seamValidationValidator24a = handleIsSeamValidationValidator();
            // seamValidationValidator has no post constraints
            this.seamValidationValidator24a = seamValidationValidator24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamValidationValidator24aSet = true;
            }
        }
        return seamValidationValidator24a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamValidationOutcome()
    * @return String
    */
    protected abstract String handleGetSeamValidationOutcome();

    private transient String seamValidationOutcome25a;
    private transient boolean seamValidationOutcome25aSet = false;

    /**
     * Returns the JSF outcome when validation fails, set using andromda.seam.validation.outcome.
     * @return (String)handleGetSeamValidationOutcome()
     */
    public final String getSeamValidationOutcome()
    {
        String seamValidationOutcome25a = this.seamValidationOutcome25a;
        if (!this.seamValidationOutcome25aSet)
        {
            // seamValidationOutcome has no pre constraints
            seamValidationOutcome25a = handleGetSeamValidationOutcome();
            // seamValidationOutcome has no post constraints
            this.seamValidationOutcome25a = seamValidationOutcome25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamValidationOutcome25aSet = true;
            }
        }
        return seamValidationOutcome25a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamValidationRefreshEntities()
    * @return boolean
    */
    protected abstract boolean handleIsSeamValidationRefreshEntities();

    private transient boolean seamValidationRefreshEntities26a;
    private transient boolean seamValidationRefreshEntities26aSet = false;

    /**
     * Returns true if the andromda.seam.validation.refreshEntities is modelled on the operation as
     * true to indicate that any invalid entities in the managed state should be refreshed from the
     * database when validation fails.
     * @return (boolean)handleIsSeamValidationRefreshEntities()
     */
    public final boolean isSeamValidationRefreshEntities()
    {
        boolean seamValidationRefreshEntities26a = this.seamValidationRefreshEntities26a;
        if (!this.seamValidationRefreshEntities26aSet)
        {
            // seamValidationRefreshEntities has no pre constraints
            seamValidationRefreshEntities26a = handleIsSeamValidationRefreshEntities();
            // seamValidationRefreshEntities has no post constraints
            this.seamValidationRefreshEntities26a = seamValidationRefreshEntities26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamValidationRefreshEntities26aSet = true;
            }
        }
        return seamValidationRefreshEntities26a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeStrictlyLocal()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeStrictlyLocal();

    private transient boolean viewTypeStrictlyLocal27a;
    private transient boolean viewTypeStrictlyLocal27aSet = false;

    /**
     * Returns true if the operation view type was explicity set to local view using tagged value.
     * @return (boolean)handleIsViewTypeStrictlyLocal()
     */
    public final boolean isViewTypeStrictlyLocal()
    {
        boolean viewTypeStrictlyLocal27a = this.viewTypeStrictlyLocal27a;
        if (!this.viewTypeStrictlyLocal27aSet)
        {
            // viewTypeStrictlyLocal has no pre constraints
            viewTypeStrictlyLocal27a = handleIsViewTypeStrictlyLocal();
            // viewTypeStrictlyLocal has no post constraints
            this.viewTypeStrictlyLocal27a = viewTypeStrictlyLocal27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeStrictlyLocal27aSet = true;
            }
        }
        return viewTypeStrictlyLocal27a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeStrictlyRemote()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeStrictlyRemote();

    private transient boolean viewTypeStrictlyRemote28a;
    private transient boolean viewTypeStrictlyRemote28aSet = false;

    /**
     * Returns true if the operation view type was explicity set to remote view using tagged value.
     * @return (boolean)handleIsViewTypeStrictlyRemote()
     */
    public final boolean isViewTypeStrictlyRemote()
    {
        boolean viewTypeStrictlyRemote28a = this.viewTypeStrictlyRemote28a;
        if (!this.viewTypeStrictlyRemote28aSet)
        {
            // viewTypeStrictlyRemote has no pre constraints
            viewTypeStrictlyRemote28a = handleIsViewTypeStrictlyRemote();
            // viewTypeStrictlyRemote has no post constraints
            this.viewTypeStrictlyRemote28a = viewTypeStrictlyRemote28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeStrictlyRemote28aSet = true;
            }
        }
        return viewTypeStrictlyRemote28a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeAbsoluteLocal()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeAbsoluteLocal();

    private transient boolean viewTypeAbsoluteLocal29a;
    private transient boolean viewTypeAbsoluteLocal29aSet = false;

    /**
     * Return true if the view type of the operation is local after examing all aspects of the owner
     * and operation. This is used to determine if operation is included in local interface.
     * @return (boolean)handleIsViewTypeAbsoluteLocal()
     */
    public final boolean isViewTypeAbsoluteLocal()
    {
        boolean viewTypeAbsoluteLocal29a = this.viewTypeAbsoluteLocal29a;
        if (!this.viewTypeAbsoluteLocal29aSet)
        {
            // viewTypeAbsoluteLocal has no pre constraints
            viewTypeAbsoluteLocal29a = handleIsViewTypeAbsoluteLocal();
            // viewTypeAbsoluteLocal has no post constraints
            this.viewTypeAbsoluteLocal29a = viewTypeAbsoluteLocal29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeAbsoluteLocal29aSet = true;
            }
        }
        return viewTypeAbsoluteLocal29a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeAbsoluteRemote()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeAbsoluteRemote();

    private transient boolean viewTypeAbsoluteRemote30a;
    private transient boolean viewTypeAbsoluteRemote30aSet = false;

    /**
     * Return true if the view type of the operation is local after examing all aspects of the owner
     * and operation. This is used to determine if operation is included in remote interface.
     * @return (boolean)handleIsViewTypeAbsoluteRemote()
     */
    public final boolean isViewTypeAbsoluteRemote()
    {
        boolean viewTypeAbsoluteRemote30a = this.viewTypeAbsoluteRemote30a;
        if (!this.viewTypeAbsoluteRemote30aSet)
        {
            // viewTypeAbsoluteRemote has no pre constraints
            viewTypeAbsoluteRemote30a = handleIsViewTypeAbsoluteRemote();
            // viewTypeAbsoluteRemote has no post constraints
            this.viewTypeAbsoluteRemote30a = viewTypeAbsoluteRemote30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeAbsoluteRemote30aSet = true;
            }
        }
        return viewTypeAbsoluteRemote30a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeAbsoluteBoth()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeAbsoluteBoth();

    private transient boolean viewTypeAbsoluteBoth31a;
    private transient boolean viewTypeAbsoluteBoth31aSet = false;

    /**
     * Return true if the view type of the operation is both after examing all aspects of the owner
     * and operation. This is used to determine which interface to use in the service delegate.
     * @return (boolean)handleIsViewTypeAbsoluteBoth()
     */
    public final boolean isViewTypeAbsoluteBoth()
    {
        boolean viewTypeAbsoluteBoth31a = this.viewTypeAbsoluteBoth31a;
        if (!this.viewTypeAbsoluteBoth31aSet)
        {
            // viewTypeAbsoluteBoth has no pre constraints
            viewTypeAbsoluteBoth31a = handleIsViewTypeAbsoluteBoth();
            // viewTypeAbsoluteBoth has no post constraints
            this.viewTypeAbsoluteBoth31a = viewTypeAbsoluteBoth31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeAbsoluteBoth31aSet = true;
            }
        }
        return viewTypeAbsoluteBoth31a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isViewTypeStrictlyBoth()
    * @return boolean
    */
    protected abstract boolean handleIsViewTypeStrictlyBoth();

    private transient boolean viewTypeStrictlyBoth32a;
    private transient boolean viewTypeStrictlyBoth32aSet = false;

    /**
     * Returns true if the operation view type was explicity set to both using tagged value.
     * @return (boolean)handleIsViewTypeStrictlyBoth()
     */
    public final boolean isViewTypeStrictlyBoth()
    {
        boolean viewTypeStrictlyBoth32a = this.viewTypeStrictlyBoth32a;
        if (!this.viewTypeStrictlyBoth32aSet)
        {
            // viewTypeStrictlyBoth has no pre constraints
            viewTypeStrictlyBoth32a = handleIsViewTypeStrictlyBoth();
            // viewTypeStrictlyBoth has no post constraints
            this.viewTypeStrictlyBoth32a = viewTypeStrictlyBoth32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.viewTypeStrictlyBoth32aSet = true;
            }
        }
        return viewTypeStrictlyBoth32a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamAsynchronous()
    * @return boolean
    */
    protected abstract boolean handleIsSeamAsynchronous();

    private transient boolean seamAsynchronous33a;
    private transient boolean seamAsynchronous33aSet = false;

    /**
     * Stereotype Asynchronous. Specifies that the method call is processed asynchronously.
     * @return (boolean)handleIsSeamAsynchronous()
     */
    public final boolean isSeamAsynchronous()
    {
        boolean seamAsynchronous33a = this.seamAsynchronous33a;
        if (!this.seamAsynchronous33aSet)
        {
            // seamAsynchronous has no pre constraints
            seamAsynchronous33a = handleIsSeamAsynchronous();
            // seamAsynchronous has no post constraints
            this.seamAsynchronous33a = seamAsynchronous33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamAsynchronous33aSet = true;
            }
        }
        return seamAsynchronous33a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamConversationBegin()
    * @return boolean
    */
    protected abstract boolean handleIsSeamConversationBegin();

    private transient boolean seamConversationBegin34a;
    private transient boolean seamConversationBegin34aSet = false;

    /**
     * Returns true if the <<Begin>> stereotype is set. Specifies that a long-running conversation
     * begins when this method returns a non-null outcome without exception.
     * @return (boolean)handleIsSeamConversationBegin()
     */
    public final boolean isSeamConversationBegin()
    {
        boolean seamConversationBegin34a = this.seamConversationBegin34a;
        if (!this.seamConversationBegin34aSet)
        {
            // seamConversationBegin has no pre constraints
            seamConversationBegin34a = handleIsSeamConversationBegin();
            // seamConversationBegin has no post constraints
            this.seamConversationBegin34a = seamConversationBegin34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationBegin34aSet = true;
            }
        }
        return seamConversationBegin34a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamConversationBeginTask()
    * @return boolean
    */
    protected abstract boolean handleIsSeamConversationBeginTask();

    private transient boolean seamConversationBeginTask35a;
    private transient boolean seamConversationBeginTask35aSet = false;

    /**
     * Returns true if stereotype <<BeginTask>> is set. Resumes work on an incomplete jBPM task.
     * Specifies that a long-running conversation begins when this method returns a non-null outcome
     * without exception. This conversation is associated with the jBPM task specified in the named
     * request parameter. Within the context of this conversation, a business process context is
     * also defined, for the business process instance of the task instance.
     * @return (boolean)handleIsSeamConversationBeginTask()
     */
    public final boolean isSeamConversationBeginTask()
    {
        boolean seamConversationBeginTask35a = this.seamConversationBeginTask35a;
        if (!this.seamConversationBeginTask35aSet)
        {
            // seamConversationBeginTask has no pre constraints
            seamConversationBeginTask35a = handleIsSeamConversationBeginTask();
            // seamConversationBeginTask has no post constraints
            this.seamConversationBeginTask35a = seamConversationBeginTask35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationBeginTask35aSet = true;
            }
        }
        return seamConversationBeginTask35a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamConversationCreateProcess()
    * @return boolean
    */
    protected abstract boolean handleIsSeamConversationCreateProcess();

    private transient boolean seamConversationCreateProcess36a;
    private transient boolean seamConversationCreateProcess36aSet = false;

    /**
     * Returns true if stereotype <<CreateProcess>> is set. Creates a new jBPM process instance when
     * the method returns a non-null outcome without exception. The ProcessInstance object will be
     * available in a context variable named processInstance.
     * @return (boolean)handleIsSeamConversationCreateProcess()
     */
    public final boolean isSeamConversationCreateProcess()
    {
        boolean seamConversationCreateProcess36a = this.seamConversationCreateProcess36a;
        if (!this.seamConversationCreateProcess36aSet)
        {
            // seamConversationCreateProcess has no pre constraints
            seamConversationCreateProcess36a = handleIsSeamConversationCreateProcess();
            // seamConversationCreateProcess has no post constraints
            this.seamConversationCreateProcess36a = seamConversationCreateProcess36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationCreateProcess36aSet = true;
            }
        }
        return seamConversationCreateProcess36a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamConversationEnd()
    * @return boolean
    */
    protected abstract boolean handleIsSeamConversationEnd();

    private transient boolean seamConversationEnd37a;
    private transient boolean seamConversationEnd37aSet = false;

    /**
     * Returns true if stereotype <<End>> is set. Specifies that a long-running conversation ends
     * when this method returns a non-null outcome without exception.
     * @return (boolean)handleIsSeamConversationEnd()
     */
    public final boolean isSeamConversationEnd()
    {
        boolean seamConversationEnd37a = this.seamConversationEnd37a;
        if (!this.seamConversationEnd37aSet)
        {
            // seamConversationEnd has no pre constraints
            seamConversationEnd37a = handleIsSeamConversationEnd();
            // seamConversationEnd has no post constraints
            this.seamConversationEnd37a = seamConversationEnd37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationEnd37aSet = true;
            }
        }
        return seamConversationEnd37a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamConversationEndTask()
    * @return boolean
    */
    protected abstract boolean handleIsSeamConversationEndTask();

    private transient boolean seamConversationEndTask38a;
    private transient boolean seamConversationEndTask38aSet = false;

    /**
     * Returns true if stereotype <<EndTask>> is set and "Ends" a jBPM task. Specifies that a
     * long-running conversation ends when this method returns a non-null outcome, and that the
     * current task is complete. Triggers a jBPM transition. The actual transition triggered will be
     * the default transition unless the application has called Transition.setName() on the built-in
     * component named transition.
     * @return (boolean)handleIsSeamConversationEndTask()
     */
    public final boolean isSeamConversationEndTask()
    {
        boolean seamConversationEndTask38a = this.seamConversationEndTask38a;
        if (!this.seamConversationEndTask38aSet)
        {
            // seamConversationEndTask has no pre constraints
            seamConversationEndTask38a = handleIsSeamConversationEndTask();
            // seamConversationEndTask has no post constraints
            this.seamConversationEndTask38a = seamConversationEndTask38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationEndTask38aSet = true;
            }
        }
        return seamConversationEndTask38a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamBijectionFactory()
    * @return boolean
    */
    protected abstract boolean handleIsSeamBijectionFactory();

    private transient boolean seamBijectionFactory39a;
    private transient boolean seamBijectionFactory39aSet = false;

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
     * @return (boolean)handleIsSeamBijectionFactory()
     */
    public final boolean isSeamBijectionFactory()
    {
        boolean seamBijectionFactory39a = this.seamBijectionFactory39a;
        if (!this.seamBijectionFactory39aSet)
        {
            // seamBijectionFactory has no pre constraints
            seamBijectionFactory39a = handleIsSeamBijectionFactory();
            // seamBijectionFactory has no post constraints
            this.seamBijectionFactory39a = seamBijectionFactory39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamBijectionFactory39aSet = true;
            }
        }
        return seamBijectionFactory39a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamObserverEventName()
    * @return String
    */
    protected abstract String handleGetSeamObserverEventName();

    private transient String seamObserverEventName40a;
    private transient boolean seamObserverEventName40aSet = false;

    /**
     * Specifies that the method should be called when a component-driven event of the specified
     * type occurs.
     * @return (String)handleGetSeamObserverEventName()
     */
    public final String getSeamObserverEventName()
    {
        String seamObserverEventName40a = this.seamObserverEventName40a;
        if (!this.seamObserverEventName40aSet)
        {
            // seamObserverEventName has no pre constraints
            seamObserverEventName40a = handleGetSeamObserverEventName();
            // seamObserverEventName has no post constraints
            this.seamObserverEventName40a = seamObserverEventName40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamObserverEventName40aSet = true;
            }
        }
        return seamObserverEventName40a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamConversationResumeProcess()
    * @return boolean
    */
    protected abstract boolean handleIsSeamConversationResumeProcess();

    private transient boolean seamConversationResumeProcess41a;
    private transient boolean seamConversationResumeProcess41aSet = false;

    /**
     * Returns true if stereotype <<ResumeProcess>> is set. Re-enters the scope of an existing jBPM
     * process instance when the method returns a non-null outcome without exception. The
     * ProcessInstance object will be available in a context variable named processInstance.
     * @return (boolean)handleIsSeamConversationResumeProcess()
     */
    public final boolean isSeamConversationResumeProcess()
    {
        boolean seamConversationResumeProcess41a = this.seamConversationResumeProcess41a;
        if (!this.seamConversationResumeProcess41aSet)
        {
            // seamConversationResumeProcess has no pre constraints
            seamConversationResumeProcess41a = handleIsSeamConversationResumeProcess();
            // seamConversationResumeProcess has no post constraints
            this.seamConversationResumeProcess41a = seamConversationResumeProcess41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationResumeProcess41aSet = true;
            }
        }
        return seamConversationResumeProcess41a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamTransactionRollback()
    * @return boolean
    */
    protected abstract boolean handleIsSeamTransactionRollback();

    private transient boolean seamTransactionRollback42a;
    private transient boolean seamTransactionRollback42aSet = false;

    /**
     * Returns true if stereotype <<Rollback>> is set. If the outcome of the method matches any of
     * the listed outcomes, or if no outcomes are listed, set the transaction to rollback only when
     * the method completes.
     * @return (boolean)handleIsSeamTransactionRollback()
     */
    public final boolean isSeamTransactionRollback()
    {
        boolean seamTransactionRollback42a = this.seamTransactionRollback42a;
        if (!this.seamTransactionRollback42aSet)
        {
            // seamTransactionRollback has no pre constraints
            seamTransactionRollback42a = handleIsSeamTransactionRollback();
            // seamTransactionRollback has no post constraints
            this.seamTransactionRollback42a = seamTransactionRollback42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamTransactionRollback42aSet = true;
            }
        }
        return seamTransactionRollback42a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamConversationStartTask()
    * @return boolean
    */
    protected abstract boolean handleIsSeamConversationStartTask();

    private transient boolean seamConversationStartTask43a;
    private transient boolean seamConversationStartTask43aSet = false;

    /**
     * Returns true if stereotype <<StartTask>> is set. It "Starts" a jBPM task. Specifies that a
     * long-running conversation begins when this method returns a non-null outcome without
     * exception. This conversation is associated with the jBPM task specified in the named request
     * parameter. Within the context of this conversation, a business process context is also
     * defined, for the business process instance of the task instance.
     * The jBPM TaskInstance will be available in a request context variable named taskInstance. The
     * jPBM ProcessInstance will be available in a request context variable named processInstance.
     * (Of course, these objects are available for injection via In.)
     * @return (boolean)handleIsSeamConversationStartTask()
     */
    public final boolean isSeamConversationStartTask()
    {
        boolean seamConversationStartTask43a = this.seamConversationStartTask43a;
        if (!this.seamConversationStartTask43aSet)
        {
            // seamConversationStartTask has no pre constraints
            seamConversationStartTask43a = handleIsSeamConversationStartTask();
            // seamConversationStartTask has no post constraints
            this.seamConversationStartTask43a = seamConversationStartTask43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationStartTask43aSet = true;
            }
        }
        return seamConversationStartTask43a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamTransactional()
    * @return boolean
    */
    protected abstract boolean handleIsSeamTransactional();

    private transient boolean seamTransactional44a;
    private transient boolean seamTransactional44aSet = false;

    /**
     * Specifies that a JavaBean component should have a similar transactional behavior to the
     * default behavior of a session bean component. ie. method invocations should take place in a
     * transaction, and if no transaction exists when the method is called, a transaction will be
     * started just for that method. This annotation may be applied at either class or method level.
     * @return (boolean)handleIsSeamTransactional()
     */
    public final boolean isSeamTransactional()
    {
        boolean seamTransactional44a = this.seamTransactional44a;
        if (!this.seamTransactional44aSet)
        {
            // seamTransactional has no pre constraints
            seamTransactional44a = handleIsSeamTransactional();
            // seamTransactional has no post constraints
            this.seamTransactional44a = seamTransactional44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamTransactional44aSet = true;
            }
        }
        return seamTransactional44a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamWebRemote()
    * @return boolean
    */
    protected abstract boolean handleIsSeamWebRemote();

    private transient boolean seamWebRemote45a;
    private transient boolean seamWebRemote45aSet = false;

    /**
     * True if <<WebRemote>> stereotype is set. Indicates that the annotated method may be called
     * from client-side JavaScript.
     * @return (boolean)handleIsSeamWebRemote()
     */
    public final boolean isSeamWebRemote()
    {
        boolean seamWebRemote45a = this.seamWebRemote45a;
        if (!this.seamWebRemote45aSet)
        {
            // seamWebRemote has no pre constraints
            seamWebRemote45a = handleIsSeamWebRemote();
            // seamWebRemote has no post constraints
            this.seamWebRemote45a = seamWebRemote45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamWebRemote45aSet = true;
            }
        }
        return seamWebRemote45a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamLifecycleDestroy()
    * @return boolean
    */
    protected abstract boolean handleIsSeamLifecycleDestroy();

    private transient boolean seamLifecycleDestroy46a;
    private transient boolean seamLifecycleDestroy46aSet = false;

    /**
     * Returns true if the operation has the <<Destroy>> stereotype modelled.
     * @return (boolean)handleIsSeamLifecycleDestroy()
     */
    public final boolean isSeamLifecycleDestroy()
    {
        boolean seamLifecycleDestroy46a = this.seamLifecycleDestroy46a;
        if (!this.seamLifecycleDestroy46aSet)
        {
            // seamLifecycleDestroy has no pre constraints
            seamLifecycleDestroy46a = handleIsSeamLifecycleDestroy();
            // seamLifecycleDestroy has no post constraints
            this.seamLifecycleDestroy46a = seamLifecycleDestroy46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamLifecycleDestroy46aSet = true;
            }
        }
        return seamLifecycleDestroy46a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamLifecycleCreate()
    * @return boolean
    */
    protected abstract boolean handleIsSeamLifecycleCreate();

    private transient boolean seamLifecycleCreate47a;
    private transient boolean seamLifecycleCreate47aSet = false;

    /**
     * Returns true if the operation has the <<Create>> stereotype modelled.
     * @return (boolean)handleIsSeamLifecycleCreate()
     */
    public final boolean isSeamLifecycleCreate()
    {
        boolean seamLifecycleCreate47a = this.seamLifecycleCreate47a;
        if (!this.seamLifecycleCreate47aSet)
        {
            // seamLifecycleCreate has no pre constraints
            seamLifecycleCreate47a = handleIsSeamLifecycleCreate();
            // seamLifecycleCreate has no post constraints
            this.seamLifecycleCreate47a = seamLifecycleCreate47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamLifecycleCreate47aSet = true;
            }
        }
        return seamLifecycleCreate47a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamWebRemoteParameters()
    * @return String
    */
    protected abstract String handleGetSeamWebRemoteParameters();

    private transient String seamWebRemoteParameters48a;
    private transient boolean seamWebRemoteParameters48aSet = false;

    /**
     * Returns a string with parameters for the org.jboss.seam.annotations.WebRemote annotation.
     * Supported parameters:
     * exclude - Allows objects to be excluded from the result's object graph. Example:
     * WebRemote(exclude="path.to.exclude")
     * @return (String)handleGetSeamWebRemoteParameters()
     */
    public final String getSeamWebRemoteParameters()
    {
        String seamWebRemoteParameters48a = this.seamWebRemoteParameters48a;
        if (!this.seamWebRemoteParameters48aSet)
        {
            // seamWebRemoteParameters has no pre constraints
            seamWebRemoteParameters48a = handleGetSeamWebRemoteParameters();
            // seamWebRemoteParameters has no post constraints
            this.seamWebRemoteParameters48a = seamWebRemoteParameters48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamWebRemoteParameters48aSet = true;
            }
        }
        return seamWebRemoteParameters48a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamConversationBeginParameters()
    * @return String
    */
    protected abstract String handleGetSeamConversationBeginParameters();

    private transient String seamConversationBeginParameters49a;
    private transient boolean seamConversationBeginParameters49aSet = false;

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
     * @return (String)handleGetSeamConversationBeginParameters()
     */
    public final String getSeamConversationBeginParameters()
    {
        String seamConversationBeginParameters49a = this.seamConversationBeginParameters49a;
        if (!this.seamConversationBeginParameters49aSet)
        {
            // seamConversationBeginParameters has no pre constraints
            seamConversationBeginParameters49a = handleGetSeamConversationBeginParameters();
            // seamConversationBeginParameters has no post constraints
            this.seamConversationBeginParameters49a = seamConversationBeginParameters49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationBeginParameters49aSet = true;
            }
        }
        return seamConversationBeginParameters49a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamConversationBeginTaskParameters()
    * @return String
    */
    protected abstract String handleGetSeamConversationBeginTaskParameters();

    private transient String seamConversationBeginTaskParameters50a;
    private transient boolean seamConversationBeginTaskParameters50aSet = false;

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.BeginTask annotation. Supported
     * parameters:
     * * taskIdParameter - the name of a request parameter which holds the id of the task. Default
     * to "taskId", which is also the default used by the Seam taskList JSF component.
     * * flushMode - set the flush mode of any Seam-managed Hibernate sessions or JPA persistence
     * contexts that are created during this conversation.
     * @return (String)handleGetSeamConversationBeginTaskParameters()
     */
    public final String getSeamConversationBeginTaskParameters()
    {
        String seamConversationBeginTaskParameters50a = this.seamConversationBeginTaskParameters50a;
        if (!this.seamConversationBeginTaskParameters50aSet)
        {
            // seamConversationBeginTaskParameters has no pre constraints
            seamConversationBeginTaskParameters50a = handleGetSeamConversationBeginTaskParameters();
            // seamConversationBeginTaskParameters has no post constraints
            this.seamConversationBeginTaskParameters50a = seamConversationBeginTaskParameters50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationBeginTaskParameters50aSet = true;
            }
        }
        return seamConversationBeginTaskParameters50a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamConversationCreateProcessParameters()
    * @return String
    */
    protected abstract String handleGetSeamConversationCreateProcessParameters();

    private transient String seamConversationCreateProcessParameters51a;
    private transient boolean seamConversationCreateProcessParameters51aSet = false;

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.CreateProcess annotation.
     * Supported parameters:
     * * definition - the name of the jBPM process definition deployed via
     * org.jboss.seam.core.jbpm.processDefinitions.
     * @return (String)handleGetSeamConversationCreateProcessParameters()
     */
    public final String getSeamConversationCreateProcessParameters()
    {
        String seamConversationCreateProcessParameters51a = this.seamConversationCreateProcessParameters51a;
        if (!this.seamConversationCreateProcessParameters51aSet)
        {
            // seamConversationCreateProcessParameters has no pre constraints
            seamConversationCreateProcessParameters51a = handleGetSeamConversationCreateProcessParameters();
            // seamConversationCreateProcessParameters has no post constraints
            this.seamConversationCreateProcessParameters51a = seamConversationCreateProcessParameters51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationCreateProcessParameters51aSet = true;
            }
        }
        return seamConversationCreateProcessParameters51a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamConversationEndParameters()
    * @return String
    */
    protected abstract String handleGetSeamConversationEndParameters();

    private transient String seamConversationEndParameters52a;
    private transient boolean seamConversationEndParameters52aSet = false;

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.End annotation. Supported
     * parameters:
     * * ifOutcome - specifies the JSF outcome or outcomes that result in the end of the current
     * long-running conversation.
     * * beforeRedirect - by default, the conversation will not actually be destroyed until after
     * any redirect has occurred. Setting beforeRedirect=true specifies that the conversation should
     * be destroyed at the end of the current request, and that the redirect will be processed in a
     * new temporary conversation context.
     * @return (String)handleGetSeamConversationEndParameters()
     */
    public final String getSeamConversationEndParameters()
    {
        String seamConversationEndParameters52a = this.seamConversationEndParameters52a;
        if (!this.seamConversationEndParameters52aSet)
        {
            // seamConversationEndParameters has no pre constraints
            seamConversationEndParameters52a = handleGetSeamConversationEndParameters();
            // seamConversationEndParameters has no post constraints
            this.seamConversationEndParameters52a = seamConversationEndParameters52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationEndParameters52aSet = true;
            }
        }
        return seamConversationEndParameters52a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamConversationEndTaskParameters()
    * @return String
    */
    protected abstract String handleGetSeamConversationEndTaskParameters();

    private transient String seamConversationEndTaskParameters53a;
    private transient boolean seamConversationEndTaskParameters53aSet = false;

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
     * @return (String)handleGetSeamConversationEndTaskParameters()
     */
    public final String getSeamConversationEndTaskParameters()
    {
        String seamConversationEndTaskParameters53a = this.seamConversationEndTaskParameters53a;
        if (!this.seamConversationEndTaskParameters53aSet)
        {
            // seamConversationEndTaskParameters has no pre constraints
            seamConversationEndTaskParameters53a = handleGetSeamConversationEndTaskParameters();
            // seamConversationEndTaskParameters has no post constraints
            this.seamConversationEndTaskParameters53a = seamConversationEndTaskParameters53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationEndTaskParameters53aSet = true;
            }
        }
        return seamConversationEndTaskParameters53a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamBijectionFactoryParameters()
    * @return String
    */
    protected abstract String handleGetSeamBijectionFactoryParameters();

    private transient String seamBijectionFactoryParameters54a;
    private transient boolean seamBijectionFactoryParameters54aSet = false;

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.Factory annotation. Supported
     * parameters:
     * * value - specifies the name of the context variable. If the method is a getter method,
     * default to the JavaBeans property name.
     * * scope - specifies the scope that Seam should bind the returned value to. Only meaningful
     * for factory methods which return a value.
     * @return (String)handleGetSeamBijectionFactoryParameters()
     */
    public final String getSeamBijectionFactoryParameters()
    {
        String seamBijectionFactoryParameters54a = this.seamBijectionFactoryParameters54a;
        if (!this.seamBijectionFactoryParameters54aSet)
        {
            // seamBijectionFactoryParameters has no pre constraints
            seamBijectionFactoryParameters54a = handleGetSeamBijectionFactoryParameters();
            // seamBijectionFactoryParameters has no post constraints
            this.seamBijectionFactoryParameters54a = seamBijectionFactoryParameters54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamBijectionFactoryParameters54aSet = true;
            }
        }
        return seamBijectionFactoryParameters54a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamConversationResumeProcessParameters()
    * @return String
    */
    protected abstract String handleGetSeamConversationResumeProcessParameters();

    private transient String seamConversationResumeProcessParameters55a;
    private transient boolean seamConversationResumeProcessParameters55aSet = false;

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.ResumeProcess annotation.
     * Supported parameters:
     * * processIdParameter - the name a request parameter holding the process id. Default to
     * "processId".
     * @return (String)handleGetSeamConversationResumeProcessParameters()
     */
    public final String getSeamConversationResumeProcessParameters()
    {
        String seamConversationResumeProcessParameters55a = this.seamConversationResumeProcessParameters55a;
        if (!this.seamConversationResumeProcessParameters55aSet)
        {
            // seamConversationResumeProcessParameters has no pre constraints
            seamConversationResumeProcessParameters55a = handleGetSeamConversationResumeProcessParameters();
            // seamConversationResumeProcessParameters has no post constraints
            this.seamConversationResumeProcessParameters55a = seamConversationResumeProcessParameters55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationResumeProcessParameters55aSet = true;
            }
        }
        return seamConversationResumeProcessParameters55a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamConversationStartTaskParameters()
    * @return String
    */
    protected abstract String handleGetSeamConversationStartTaskParameters();

    private transient String seamConversationStartTaskParameters56a;
    private transient boolean seamConversationStartTaskParameters56aSet = false;

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.StartTask annotation. Supported
     * parameters:
     * * taskIdParameter - the name of a request parameter which holds the id of the task. Default
     * to "taskId", which is also the default used by the Seam taskList JSF component.
     * * flushMode - set the flush mode of any Seam-managed Hibernate sessions or JPA persistence
     * contexts that are created during this conversation.
     * @return (String)handleGetSeamConversationStartTaskParameters()
     */
    public final String getSeamConversationStartTaskParameters()
    {
        String seamConversationStartTaskParameters56a = this.seamConversationStartTaskParameters56a;
        if (!this.seamConversationStartTaskParameters56aSet)
        {
            // seamConversationStartTaskParameters has no pre constraints
            seamConversationStartTaskParameters56a = handleGetSeamConversationStartTaskParameters();
            // seamConversationStartTaskParameters has no post constraints
            this.seamConversationStartTaskParameters56a = seamConversationStartTaskParameters56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamConversationStartTaskParameters56aSet = true;
            }
        }
        return seamConversationStartTaskParameters56a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getSeamTransactionRollbackParameters()
    * @return String
    */
    protected abstract String handleGetSeamTransactionRollbackParameters();

    private transient String seamTransactionRollbackParameters57a;
    private transient boolean seamTransactionRollbackParameters57aSet = false;

    /**
     * Returns a parameter string for the org.jboss.seam.annotations.Rollback annotation. Supported
     * parameters:
     * * ifOutcome - the JSF outcomes that cause a transaction rollback (no outcomes is interpreted
     * to mean any outcome).
     * @return (String)handleGetSeamTransactionRollbackParameters()
     */
    public final String getSeamTransactionRollbackParameters()
    {
        String seamTransactionRollbackParameters57a = this.seamTransactionRollbackParameters57a;
        if (!this.seamTransactionRollbackParameters57aSet)
        {
            // seamTransactionRollbackParameters has no pre constraints
            seamTransactionRollbackParameters57a = handleGetSeamTransactionRollbackParameters();
            // seamTransactionRollbackParameters has no post constraints
            this.seamTransactionRollbackParameters57a = seamTransactionRollbackParameters57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamTransactionRollbackParameters57aSet = true;
            }
        }
        return seamTransactionRollbackParameters57a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#isSeamObserver()
    * @return boolean
    */
    protected abstract boolean handleIsSeamObserver();

    private transient boolean seamObserver58a;
    private transient boolean seamObserver58aSet = false;

    /**
     * True if the annotated method is a seam component-driven event observer.
     * @return (boolean)handleIsSeamObserver()
     */
    public final boolean isSeamObserver()
    {
        boolean seamObserver58a = this.seamObserver58a;
        if (!this.seamObserver58aSet)
        {
            // seamObserver has no pre constraints
            seamObserver58a = handleIsSeamObserver();
            // seamObserver has no post constraints
            this.seamObserver58a = seamObserver58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.seamObserver58aSet = true;
            }
        }
        return seamObserver58a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getTestSignature()
    * @return String
    */
    protected abstract String handleGetTestSignature();

    private transient String testSignature59a;
    private transient boolean testSignature59aSet = false;

    /**
     * Returns the session operation test signature used to generate the test method for the
     * operation  in the session bean test class.
     * @return (String)handleGetTestSignature()
     */
    public final String getTestSignature()
    {
        String testSignature59a = this.testSignature59a;
        if (!this.testSignature59aSet)
        {
            // testSignature has no pre constraints
            testSignature59a = handleGetTestSignature();
            // testSignature has no post constraints
            this.testSignature59a = testSignature59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.testSignature59aSet = true;
            }
        }
        return testSignature59a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade#getTestName()
    * @return String
    */
    protected abstract String handleGetTestName();

    private transient String testName60a;
    private transient boolean testName60aSet = false;

    /**
     * Returns the operation test name
     * @return (String)handleGetTestName()
     */
    public final String getTestName()
    {
        String testName60a = this.testName60a;
        if (!this.testName60aSet)
        {
            // testName has no pre constraints
            testName60a = handleGetTestName();
            // testName has no post constraints
            this.testName60a = testName60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.testName60aSet = true;
            }
        }
        return testName60a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Retrieves the throws clause allowing a comma separated list of exceptions to be passed in and
     * appended to the list.
     * @param initialExceptions
     * @return String
     */
    protected abstract String handleGetThrowsClause(String initialExceptions);

    /**
     * Retrieves the throws clause allowing a comma separated list of exceptions to be passed in and
     * appended to the list.
     * @param initialExceptions String
     * A comma separated list of exceptions to be passed in.
     * @return handleGetThrowsClause(initialExceptions)
     */
    public String getThrowsClause(String initialExceptions)
    {
        // getThrowsClause has no pre constraints
        String returnValue = handleGetThrowsClause(initialExceptions);
        // getThrowsClause has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationFacade
     * @return (Collection<Role>)handleGetNonRunAsRoles()
     */
    public final Collection<Role> getNonRunAsRoles()
    {
        Collection<Role> getNonRunAsRoles1r = null;
        // eJB3SessionOperationFacade has no pre constraints
        Collection result = handleGetNonRunAsRoles();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getNonRunAsRoles1r = (Collection<Role>) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            EJB3SessionOperationFacadeLogic.LOGGER.warn("incorrect metafacade cast for EJB3SessionOperationFacadeLogic.getNonRunAsRoles Collection<Role> " + result + ": " + shieldedResult);
        }
        // eJB3SessionOperationFacade has no post constraints
        return getNonRunAsRoles1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetNonRunAsRoles();

    /**
     * @return true
     * @see ServiceOperation
     */
    public boolean isServiceOperationMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see OperationFacade
     */
    public boolean isOperationFacadeMetaType()
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

    // ----------- delegates to ServiceOperation ------------
    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperServiceOperation().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperServiceOperation().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperServiceOperation().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperServiceOperation().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperServiceOperation().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperServiceOperation().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperServiceOperation().getDocumentation(indent);
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
        return this.getSuperServiceOperation().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperServiceOperation().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperServiceOperation().getFullyQualifiedName();
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
        return this.getSuperServiceOperation().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperServiceOperation().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperServiceOperation().getId();
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
        return this.getSuperServiceOperation().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperServiceOperation().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperServiceOperation().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperServiceOperation().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperServiceOperation().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperServiceOperation().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperServiceOperation().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperServiceOperation().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperServiceOperation().getPackagePath();
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
        return this.getSuperServiceOperation().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperServiceOperation().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperServiceOperation().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperServiceOperation().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperServiceOperation().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperServiceOperation().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperServiceOperation().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperServiceOperation().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperServiceOperation().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperServiceOperation().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperServiceOperation().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperServiceOperation().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperServiceOperation().hasKeyword(keywordName);
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
        return this.getSuperServiceOperation().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperServiceOperation().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperServiceOperation().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperServiceOperation().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperServiceOperation().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperServiceOperation().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperServiceOperation().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperServiceOperation().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperServiceOperation().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperServiceOperation().translateConstraints(kind, translation);
    }

    /**
     * Finds the parameter on this operation having the given name, if no parameter is found, null
     * is returned instead.
     * @see OperationFacade#findParameter(String name)
     */
    public ParameterFacade findParameter(String name)
    {
        return this.getSuperServiceOperation().findParameter(name);
    }

    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class operation
     * to the class itself and then up the class hierarchy.
     * @see OperationFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperServiceOperation().findTaggedValue(name, follow);
    }

    /**
     * A comma separated list of all argument names.
     * @see OperationFacade#getArgumentNames()
     */
    public String getArgumentNames()
    {
        return this.getSuperServiceOperation().getArgumentNames();
    }

    /**
     * A comma separated list of all types of each argument, in order.
     * @see OperationFacade#getArgumentTypeNames()
     */
    public String getArgumentTypeNames()
    {
        return this.getSuperServiceOperation().getArgumentTypeNames();
    }

    /**
     * Specification of an argument used to pass information into or out of an invocation of a
     * behavioral feature. Parameters are allowed to be treated as connectable elements. Parameters
     * have support for streaming, exceptions, and parameter sets.
     * @see OperationFacade#getArguments()
     */
    public Collection<ParameterFacade> getArguments()
    {
        return this.getSuperServiceOperation().getArguments();
    }

    /**
     * Constructs the operation call with the operation name.
     * @see OperationFacade#getCall()
     */
    public String getCall()
    {
        return this.getSuperServiceOperation().getCall();
    }

    /**
     * Returns the concurrency modifier for this operation (i.e. concurrent, guarded or sequential)
     * of the model element, will attempt a lookup for these values in the language mappings (if
     * any).
     * @see OperationFacade#getConcurrency()
     */
    public String getConcurrency()
    {
        return this.getSuperServiceOperation().getConcurrency();
    }

    /**
     * A comma separated list containing all exceptions that this operation throws.  Exceptions are
     * determined through dependencies that have the target element stereotyped as <<Exception>>.
     * @see OperationFacade#getExceptionList()
     */
    public String getExceptionList()
    {
        return this.getSuperServiceOperation().getExceptionList();
    }

    /**
     * Returns a comma separated list of exceptions appended to the comma separated list of fully
     * qualified 'initialException' classes passed in to this method.
     * @see OperationFacade#getExceptionList(String initialExceptions)
     */
    public String getExceptionList(String initialExceptions)
    {
        return this.getSuperServiceOperation().getExceptionList(initialExceptions);
    }

    /**
     * A collection of all exceptions thrown by this operation.
     * @see OperationFacade#getExceptions()
     */
    public Collection<ModelElementFacade> getExceptions()
    {
        return this.getSuperServiceOperation().getExceptions();
    }

    /**
     * Return Type with multiplicity taken into account. UML14 does not allow multiplicity *.
     * @see OperationFacade#getGetterSetterReturnTypeName()
     */
    public String getGetterSetterReturnTypeName()
    {
        return this.getSuperServiceOperation().getGetterSetterReturnTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see OperationFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperServiceOperation().getLower();
    }

    /**
     * Returns the operation method body determined from UML sequence diagrams or other UML sources.
     * @see OperationFacade#getMethodBody()
     */
    public String getMethodBody()
    {
        return this.getSuperServiceOperation().getMethodBody();
    }

    /**
     * The operation this operation overrides, null if this operation is not overriding.
     * @see OperationFacade#getOverriddenOperation()
     */
    public OperationFacade getOverriddenOperation()
    {
        return this.getSuperServiceOperation().getOverriddenOperation();
    }

    /**
     * Gets the owner of this operation
     * @see OperationFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperServiceOperation().getOwner();
    }

    /**
     * Return all parameters for the operation, including the return parameter.
     * @see OperationFacade#getParameters()
     */
    public Collection<ParameterFacade> getParameters()
    {
        return this.getSuperServiceOperation().getParameters();
    }

    /**
     * The name of the operation that handles postcondition constraints.
     * @see OperationFacade#getPostconditionName()
     */
    public String getPostconditionName()
    {
        return this.getSuperServiceOperation().getPostconditionName();
    }

    /**
     * The postcondition constraints belonging to this operation.
     * @see OperationFacade#getPostconditions()
     */
    public Collection<ConstraintFacade> getPostconditions()
    {
        return this.getSuperServiceOperation().getPostconditions();
    }

    /**
     * The call to the precondition operation.
     * @see OperationFacade#getPreconditionCall()
     */
    public String getPreconditionCall()
    {
        return this.getSuperServiceOperation().getPreconditionCall();
    }

    /**
     * The name of the operation that handles precondition constraints.
     * @see OperationFacade#getPreconditionName()
     */
    public String getPreconditionName()
    {
        return this.getSuperServiceOperation().getPreconditionName();
    }

    /**
     * The signature of the precondition operation.
     * @see OperationFacade#getPreconditionSignature()
     */
    public String getPreconditionSignature()
    {
        return this.getSuperServiceOperation().getPreconditionSignature();
    }

    /**
     * The precondition constraints belonging to this operation.
     * @see OperationFacade#getPreconditions()
     */
    public Collection<ConstraintFacade> getPreconditions()
    {
        return this.getSuperServiceOperation().getPreconditions();
    }

    /**
     * (UML2 Only). Get the actual return parameter (which may have stereotypes etc).
     * @see OperationFacade#getReturnParameter()
     */
    public ParameterFacade getReturnParameter()
    {
        return this.getSuperServiceOperation().getReturnParameter();
    }

    /**
     * The operation return type parameter.
     * @see OperationFacade#getReturnType()
     */
    public ClassifierFacade getReturnType()
    {
        return this.getSuperServiceOperation().getReturnType();
    }

    /**
     * Return the operation signature, including public/protested abstract returnType name plus
     * argument type and name.
     * @see OperationFacade#getSignature()
     */
    public String getSignature()
    {
        return this.getSuperServiceOperation().getSignature();
    }

    /**
     * Returns the signature of the operation and optionally appends the argument names (if
     * withArgumentNames is true), otherwise returns the signature with just the types alone in the
     * signature.
     * @see OperationFacade#getSignature(boolean withArgumentNames)
     */
    public String getSignature(boolean withArgumentNames)
    {
        return this.getSuperServiceOperation().getSignature(withArgumentNames);
    }

    /**
     * Returns the signature of the operation and optionally appends the given 'argumentModifier' to
     * each argument.
     * @see OperationFacade#getSignature(String argumentModifier)
     */
    public String getSignature(String argumentModifier)
    {
        return this.getSuperServiceOperation().getSignature(argumentModifier);
    }

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation.
     * @see OperationFacade#getTypedArgumentList()
     */
    public String getTypedArgumentList()
    {
        return this.getSuperServiceOperation().getTypedArgumentList();
    }

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation with an
     * optional modifier (i.e final) before each parameter.
     * @see OperationFacade#getTypedArgumentList(String modifier)
     */
    public String getTypedArgumentList(String modifier)
    {
        return this.getSuperServiceOperation().getTypedArgumentList(modifier);
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * - only applicable for UML2
     * @see OperationFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperServiceOperation().getUpper();
    }

    /**
     * True is the operation is abstract.
     * @see OperationFacade#isAbstract()
     */
    public boolean isAbstract()
    {
        return this.getSuperServiceOperation().isAbstract();
    }

    /**
     * True if the operation has (i.e. throws any exceptions) false otherwise.
     * @see OperationFacade#isExceptionsPresent()
     */
    public boolean isExceptionsPresent()
    {
        return this.getSuperServiceOperation().isExceptionsPresent();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant. Default=false.
     * @see OperationFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperServiceOperation().isLeaf();
    }

    /**
     * UML2 only. If the return type parameter multiplicity>1 OR the operation multiplicity>1.
     * Default=false.
     * @see OperationFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperServiceOperation().isMany();
    }

    /**
     * UML2 only: If isMany (Collection type returned), is the type unique within the collection. 
     * Unique+Ordered determines CollectionType implementation of return result. Default=false.
     * @see OperationFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperServiceOperation().isOrdered();
    }

    /**
     * True if this operation overrides an operation defined in an ancestor class. An operation
     * overrides when the names of the operations as well as the types of the arguments are equal.
     * The return type may be different and is, as well as any exceptions, ignored.
     * @see OperationFacade#isOverriding()
     */
    public boolean isOverriding()
    {
        return this.getSuperServiceOperation().isOverriding();
    }

    /**
     * Whether any postcondition constraints are present on this operation.
     * @see OperationFacade#isPostconditionsPresent()
     */
    public boolean isPostconditionsPresent()
    {
        return this.getSuperServiceOperation().isPostconditionsPresent();
    }

    /**
     * Whether any precondition constraints are present on this operation.
     * @see OperationFacade#isPreconditionsPresent()
     */
    public boolean isPreconditionsPresent()
    {
        return this.getSuperServiceOperation().isPreconditionsPresent();
    }

    /**
     * Indicates whether or not this operation is a query operation.
     * @see OperationFacade#isQuery()
     */
    public boolean isQuery()
    {
        return this.getSuperServiceOperation().isQuery();
    }

    /**
     * True/false depending on whether or not the operation has a return type or not (i.e. a return
     * type of something other than void).
     * @see OperationFacade#isReturnTypePresent()
     */
    public boolean isReturnTypePresent()
    {
        return this.getSuperServiceOperation().isReturnTypePresent();
    }

    /**
     * True is the operation is static (only a single instance can be instantiated).
     * @see OperationFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperServiceOperation().isStatic();
    }

    /**
     * UML2 only: for Collection return type, is the type unique within the collection.
     * Unique+Ordered determines the returned CollectionType. Default=false.
     * @see OperationFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperServiceOperation().isUnique();
    }

    /**
     * The destination for any incoming messages.
     * @see ServiceOperation#getIncomingDestination()
     */
    public Destination getIncomingDestination()
    {
        return this.getSuperServiceOperation().getIncomingDestination();
    }

    /**
     * The destination for any outgoing messages.
     * @see ServiceOperation#getOutgoingDestination()
     */
    public Destination getOutgoingDestination()
    {
        return this.getSuperServiceOperation().getOutgoingDestination();
    }

    /**
     * The users of the service operation, these are the actor's that can access this operation.
     * @see ServiceOperation#getRoles()
     */
    public Collection<Role> getRoles()
    {
        return this.getSuperServiceOperation().getRoles();
    }

    /**
     * The service which owns the service operation.
     * @see ServiceOperation#getService()
     */
    public Service getService()
    {
        return this.getSuperServiceOperation().getService();
    }

    /**
     * Whether or not this operation represents an "incoming" message operation (i.e. it receives
     * messages from Queues or Topics).
     * @see ServiceOperation#isIncomingMessageOperation()
     */
    public boolean isIncomingMessageOperation()
    {
        return this.getSuperServiceOperation().isIncomingMessageOperation();
    }

    /**
     * Whether or not this is operation accepts incoming or outgoing messages.
     * @see ServiceOperation#isMessageOperation()
     */
    public boolean isMessageOperation()
    {
        return this.getSuperServiceOperation().isMessageOperation();
    }

    /**
     * Whether or not this service operation represents an "outgoing" messaging operation (i.e. it
     * sends messages to Queues or Topics).
     * @see ServiceOperation#isOutgoingMessageOperation()
     */
    public boolean isOutgoingMessageOperation()
    {
        return this.getSuperServiceOperation().isOutgoingMessageOperation();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperServiceOperation().initialize();
    }

    /**
     * @return Object getSuperServiceOperation().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperServiceOperation().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperServiceOperation().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperServiceOperation().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperServiceOperation().validateInvariants(validationMessages);
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