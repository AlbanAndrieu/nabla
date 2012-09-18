// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * 
 * MetafacadeLogic for EJB3WebServiceFacade
 *
 * @see EJB3WebServiceFacade
 */
public abstract class EJB3WebServiceFacadeLogic
    extends EJB3SessionFacadeLogicImpl
    implements EJB3WebServiceFacade
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
    protected EJB3WebServiceFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3WebServiceFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade";
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
     * @see EJB3WebServiceFacade
     */
    public boolean isEJB3WebServiceFacadeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getFullyQualifiedWebServiceInterfaceName()
    * @return String
    */
    protected abstract String handleGetFullyQualifiedWebServiceInterfaceName();

    private String fullyQualifiedWebServiceInterfaceName1a;
    private boolean fullyQualifiedWebServiceInterfaceName1aSet = false;

    /**
     * Returns the fully qualified interface name for this web service.
     * @return (String)handleGetFullyQualifiedWebServiceInterfaceName()
     */
    public final String getFullyQualifiedWebServiceInterfaceName()
    {
        String afullyQualifiedWebServiceInterfaceName1a = this.fullyQualifiedWebServiceInterfaceName1a;
        if (!this.fullyQualifiedWebServiceInterfaceName1aSet)
        {
            // fullyQualifiedWebServiceInterfaceName has no pre constraints
            afullyQualifiedWebServiceInterfaceName1a = handleGetFullyQualifiedWebServiceInterfaceName();
            // fullyQualifiedWebServiceInterfaceName has no post constraints
            this.fullyQualifiedWebServiceInterfaceName1a = afullyQualifiedWebServiceInterfaceName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedWebServiceInterfaceName1aSet = true;
            }
        }
        return afullyQualifiedWebServiceInterfaceName1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getWebServiceInterfaceName()
    * @return String
    */
    protected abstract String handleGetWebServiceInterfaceName();

    private String webServiceInterfaceName2a;
    private boolean webServiceInterfaceName2aSet = false;

    /**
     * Returns the web service interface name for with web service.
     * @return (String)handleGetWebServiceInterfaceName()
     */
    public final String getWebServiceInterfaceName()
    {
        String awebServiceInterfaceName2a = this.webServiceInterfaceName2a;
        if (!this.webServiceInterfaceName2aSet)
        {
            // webServiceInterfaceName has no pre constraints
            awebServiceInterfaceName2a = handleGetWebServiceInterfaceName();
            // webServiceInterfaceName has no post constraints
            this.webServiceInterfaceName2a = awebServiceInterfaceName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.webServiceInterfaceName2aSet = true;
            }
        }
        return awebServiceInterfaceName2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getStyle()
    * @return String
    */
    protected abstract String handleGetStyle();

    private String style3a;
    private boolean style3aSet = false;

    /**
     * Defines the encoding binding style for messages send to and from the Web Service.  Can be one
     * of DOCUMENT or RPC.
     * @return (String)handleGetStyle()
     */
    public final String getStyle()
    {
        String astyle3a = this.style3a;
        if (!this.style3aSet)
        {
            // style has no pre constraints
            astyle3a = handleGetStyle();
            // style has no post constraints
            this.style3a = astyle3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.style3aSet = true;
            }
        }
        return astyle3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getUse()
    * @return String
    */
    protected abstract String handleGetUse();

    private String use4a;
    private boolean use4aSet = false;

    /**
     * Defines the formatting style for messages sent to and from the Web Service.  Can be one of
     * LITERAL or ENCODED.
     * @return (String)handleGetUse()
     */
    public final String getUse()
    {
        String ause4a = this.use4a;
        if (!this.use4aSet)
        {
            // use has no pre constraints
            ause4a = handleGetUse();
            // use has no post constraints
            this.use4a = ause4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.use4aSet = true;
            }
        }
        return ause4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isRpcStyle()
    * @return boolean
    */
    protected abstract boolean handleIsRpcStyle();

    private boolean rpcStyle5a;
    private boolean rpcStyle5aSet = false;

    /**
     * Indicates whether or not this service is "rpc" style.
     * @return (boolean)handleIsRpcStyle()
     */
    public final boolean isRpcStyle()
    {
        boolean arpcStyle5a = this.rpcStyle5a;
        if (!this.rpcStyle5aSet)
        {
            // rpcStyle has no pre constraints
            arpcStyle5a = handleIsRpcStyle();
            // rpcStyle has no post constraints
            this.rpcStyle5a = arpcStyle5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.rpcStyle5aSet = true;
            }
        }
        return arpcStyle5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isDocumentStyle()
    * @return boolean
    */
    protected abstract boolean handleIsDocumentStyle();

    private boolean documentStyle6a;
    private boolean documentStyle6aSet = false;

    /**
     * Indicates whether or not this service is "document" style
     * @return (boolean)handleIsDocumentStyle()
     */
    public final boolean isDocumentStyle()
    {
        boolean adocumentStyle6a = this.documentStyle6a;
        if (!this.documentStyle6aSet)
        {
            // documentStyle has no pre constraints
            adocumentStyle6a = handleIsDocumentStyle();
            // documentStyle has no post constraints
            this.documentStyle6a = adocumentStyle6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentStyle6aSet = true;
            }
        }
        return adocumentStyle6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isEncodedUse()
    * @return boolean
    */
    protected abstract boolean handleIsEncodedUse();

    private boolean encodedUse7a;
    private boolean encodedUse7aSet = false;

    /**
     * Indicates whether or not this web service has a "encoded" use defined.
     * @return (boolean)handleIsEncodedUse()
     */
    public final boolean isEncodedUse()
    {
        boolean aencodedUse7a = this.encodedUse7a;
        if (!this.encodedUse7aSet)
        {
            // encodedUse has no pre constraints
            aencodedUse7a = handleIsEncodedUse();
            // encodedUse has no post constraints
            this.encodedUse7a = aencodedUse7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.encodedUse7aSet = true;
            }
        }
        return aencodedUse7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isLiteralUse()
    * @return boolean
    */
    protected abstract boolean handleIsLiteralUse();

    private boolean literalUse8a;
    private boolean literalUse8aSet = false;

    /**
     * Indicates whether or not this web service has a "literal" use defined.
     * @return (boolean)handleIsLiteralUse()
     */
    public final boolean isLiteralUse()
    {
        boolean aliteralUse8a = this.literalUse8a;
        if (!this.literalUse8aSet)
        {
            // literalUse has no pre constraints
            aliteralUse8a = handleIsLiteralUse();
            // literalUse has no post constraints
            this.literalUse8a = aliteralUse8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.literalUse8aSet = true;
            }
        }
        return aliteralUse8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isWebServiceOperationsExist()
    * @return boolean
    */
    protected abstract boolean handleIsWebServiceOperationsExist();

    private boolean webServiceOperationsExist9a;
    private boolean webServiceOperationsExist9aSet = false;

    /**
     * 
     * @return (boolean)handleIsWebServiceOperationsExist()
     */
    public final boolean isWebServiceOperationsExist()
    {
        boolean awebServiceOperationsExist9a = this.webServiceOperationsExist9a;
        if (!this.webServiceOperationsExist9aSet)
        {
            // webServiceOperationsExist has no pre constraints
            awebServiceOperationsExist9a = handleIsWebServiceOperationsExist();
            // webServiceOperationsExist has no post constraints
            this.webServiceOperationsExist9a = awebServiceOperationsExist9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.webServiceOperationsExist9aSet = true;
            }
        }
        return awebServiceOperationsExist9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isWrappedParameterStyle()
    * @return boolean
    */
    protected abstract boolean handleIsWrappedParameterStyle();

    private boolean wrappedParameterStyle10a;
    private boolean wrappedParameterStyle10aSet = false;

    /**
     * Indicates whether or not this service parameter is "wrapped" style.
     * @return (boolean)handleIsWrappedParameterStyle()
     */
    public final boolean isWrappedParameterStyle()
    {
        boolean awrappedParameterStyle10a = this.wrappedParameterStyle10a;
        if (!this.wrappedParameterStyle10aSet)
        {
            // wrappedParameterStyle has no pre constraints
            awrappedParameterStyle10a = handleIsWrappedParameterStyle();
            // wrappedParameterStyle has no post constraints
            this.wrappedParameterStyle10a = awrappedParameterStyle10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.wrappedParameterStyle10aSet = true;
            }
        }
        return awrappedParameterStyle10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isBareParameterStyle()
    * @return boolean
    */
    protected abstract boolean handleIsBareParameterStyle();

    private boolean bareParameterStyle11a;
    private boolean bareParameterStyle11aSet = false;

    /**
     * Indicates whether or not this service parameter is "bare" style.
     * @return (boolean)handleIsBareParameterStyle()
     */
    public final boolean isBareParameterStyle()
    {
        boolean abareParameterStyle11a = this.bareParameterStyle11a;
        if (!this.bareParameterStyle11aSet)
        {
            // bareParameterStyle has no pre constraints
            abareParameterStyle11a = handleIsBareParameterStyle();
            // bareParameterStyle has no post constraints
            this.bareParameterStyle11a = abareParameterStyle11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.bareParameterStyle11aSet = true;
            }
        }
        return abareParameterStyle11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getParameterStyle()
    * @return String
    */
    protected abstract String handleGetParameterStyle();

    private String parameterStyle12a;
    private boolean parameterStyle12aSet = false;

    /**
     * Determines whether method parameters represent the entire message body, or whether the
     * parameters are elements wrapped inside a top-level element named after the operation.  Can be
     * one of WRAPPED or BARE.
     * @return (String)handleGetParameterStyle()
     */
    public final String getParameterStyle()
    {
        String aparameterStyle12a = this.parameterStyle12a;
        if (!this.parameterStyle12aSet)
        {
            // parameterStyle has no pre constraints
            aparameterStyle12a = handleGetParameterStyle();
            // parameterStyle has no post constraints
            this.parameterStyle12a = aparameterStyle12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.parameterStyle12aSet = true;
            }
        }
        return aparameterStyle12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getQName()
    * @return String
    */
    protected abstract String handleGetQName();

    private String qName13a;
    private boolean qName13aSet = false;

    /**
     * Returns the QName for this service.  Usually it will be the same name as the model element,
     * however it is possible to specify a prefix to give to this name.
     * @return (String)handleGetQName()
     */
    public final String getQName()
    {
        String aqName13a = this.qName13a;
        if (!this.qName13aSet)
        {
            // qName has no pre constraints
            aqName13a = handleGetQName();
            // qName has no post constraints
            this.qName13a = aqName13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.qName13aSet = true;
            }
        }
        return aqName13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getNamespace()
    * @return String
    */
    protected abstract String handleGetNamespace();

    private String namespace14a;
    private boolean namespace14aSet = false;

    /**
     * The name of the target namespace to which this web service belongs.
     * @return (String)handleGetNamespace()
     */
    public final String getNamespace()
    {
        String anamespace14a = this.namespace14a;
        if (!this.namespace14aSet)
        {
            // namespace has no pre constraints
            anamespace14a = handleGetNamespace();
            // namespace has no post constraints
            this.namespace14a = anamespace14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.namespace14aSet = true;
            }
        }
        return anamespace14a;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see EJB3SessionFacadeLogicImpl#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        super.validateInvariants(validationMessages);
    }
}