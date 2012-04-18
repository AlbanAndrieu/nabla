// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * 
 * MetafacadeLogic for EJB3WebServiceOperationFacade
 *
 * @see EJB3WebServiceOperationFacade
 */
public abstract class EJB3WebServiceOperationFacadeLogic
    extends EJB3SessionOperationFacadeLogicImpl
    implements EJB3WebServiceOperationFacade
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
    protected EJB3WebServiceOperationFacadeLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3WebServiceOperationFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceOperationFacade";
        }
        return context;
    }

    /** Reset context only for non-root metafacades
     * @param context
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
        }
    }

    /**
     * @return boolean true always
     * @see EJB3WebServiceOperationFacade
     */
    public boolean isEJB3WebServiceOperationFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceOperationFacade#isExposed()
    * @return boolean
    */
    protected abstract boolean handleIsExposed();

    private boolean __exposed1a;
    private boolean __exposed1aSet = false;

    /**
     * Returns true/false depending on whether or not this web service operation is exposed.
     * @return (boolean)handleIsExposed()
     */
    public final boolean isExposed()
    {
        boolean exposed1a = this.__exposed1a;
        if (!this.__exposed1aSet)
        {
            // exposed has no pre constraints
            exposed1a = handleIsExposed();
            // exposed has no post constraints
            this.__exposed1a = exposed1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__exposed1aSet = true;
            }
        }
        return exposed1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceOperationFacade#isOneway()
    * @return boolean
    */
    protected abstract boolean handleIsOneway();

    private boolean __oneway2a;
    private boolean __oneway2aSet = false;

    /**
     * Specifies that this webservice operation has only an input message and no output. Typically,
     * a oneway method returns the thread of control to the calling application prior to executing
     * the actual business method.
     * You should not model the andromda_webservice_operation_oneway tagged value on operations that
     * have a return value or holder parameters, or declare any checked exceptions.
     * @return (boolean)handleIsOneway()
     */
    public final boolean isOneway()
    {
        boolean oneway2a = this.__oneway2a;
        if (!this.__oneway2aSet)
        {
            // oneway has no pre constraints
            oneway2a = handleIsOneway();
            // oneway has no post constraints
            this.__oneway2a = oneway2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__oneway2aSet = true;
            }
        }
        return oneway2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceOperationFacade#getMethodName()
    * @return String
    */
    protected abstract String handleGetMethodName();

    private String __methodName3a;
    private boolean __methodName3aSet = false;

    /**
     * Returns the webMethod operation name.
     * @return (String)handleGetMethodName()
     */
    public final String getMethodName()
    {
        String methodName3a = this.__methodName3a;
        if (!this.__methodName3aSet)
        {
            // methodName has no pre constraints
            methodName3a = handleGetMethodName();
            // methodName has no post constraints
            this.__methodName3a = methodName3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__methodName3aSet = true;
            }
        }
        return methodName3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceOperationFacade#getResultName()
    * @return String
    */
    protected abstract String handleGetResultName();

    private String __resultName4a;
    private boolean __resultName4aSet = false;

    /**
     * Returns the webResult name.
     * @return (String)handleGetResultName()
     */
    public final String getResultName()
    {
        String resultName4a = this.__resultName4a;
        if (!this.__resultName4aSet)
        {
            // resultName has no pre constraints
            resultName4a = handleGetResultName();
            // resultName has no post constraints
            this.__resultName4a = resultName4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.__resultName4aSet = true;
            }
        }
        return resultName4a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Returns the web service operation signature having @WebParam annotations for each parameter.
     * @return String
     */
    protected abstract String handleGetAnnotatedSignature();

    /**
     * Returns the web service operation signature having @WebParam annotations for each parameter.
     * @return handleGetAnnotatedSignature()
     */
    public String getAnnotatedSignature()
    {
        // getAnnotatedSignature has no pre constraints
        String returnValue = handleGetAnnotatedSignature();
        // getAnnotatedSignature has no post constraints
        return returnValue;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see EJB3SessionOperationFacadeLogicImpl#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        super.validateInvariants(validationMessages);
    }
}