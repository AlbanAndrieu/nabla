// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * TODO: Model Documentation for org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade
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

    private transient String fullyQualifiedWebServiceInterfaceName1a;
    private transient boolean fullyQualifiedWebServiceInterfaceName1aSet = false;

    /**
     * Returns the fully qualified interface name for this web service.
     * @return (String)handleGetFullyQualifiedWebServiceInterfaceName()
     */
    public final String getFullyQualifiedWebServiceInterfaceName()
    {
        String fullyQualifiedWebServiceInterfaceName1a = this.fullyQualifiedWebServiceInterfaceName1a;
        if (!this.fullyQualifiedWebServiceInterfaceName1aSet)
        {
            // fullyQualifiedWebServiceInterfaceName has no pre constraints
            fullyQualifiedWebServiceInterfaceName1a = handleGetFullyQualifiedWebServiceInterfaceName();
            // fullyQualifiedWebServiceInterfaceName has no post constraints
            this.fullyQualifiedWebServiceInterfaceName1a = fullyQualifiedWebServiceInterfaceName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fullyQualifiedWebServiceInterfaceName1aSet = true;
            }
        }
        return fullyQualifiedWebServiceInterfaceName1a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getWebServiceInterfaceName()
    * @return String
    */
    protected abstract String handleGetWebServiceInterfaceName();

    private transient String webServiceInterfaceName2a;
    private transient boolean webServiceInterfaceName2aSet = false;

    /**
     * Returns the web service interface name for with web service.
     * @return (String)handleGetWebServiceInterfaceName()
     */
    public final String getWebServiceInterfaceName()
    {
        String webServiceInterfaceName2a = this.webServiceInterfaceName2a;
        if (!this.webServiceInterfaceName2aSet)
        {
            // webServiceInterfaceName has no pre constraints
            webServiceInterfaceName2a = handleGetWebServiceInterfaceName();
            // webServiceInterfaceName has no post constraints
            this.webServiceInterfaceName2a = webServiceInterfaceName2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.webServiceInterfaceName2aSet = true;
            }
        }
        return webServiceInterfaceName2a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getStyle()
    * @return String
    */
    protected abstract String handleGetStyle();

    private transient String style3a;
    private transient boolean style3aSet = false;

    /**
     * Defines the encoding binding style for messages send to and from the Web Service.  Can be one
     * of DOCUMENT or RPC.
     * @return (String)handleGetStyle()
     */
    public final String getStyle()
    {
        String style3a = this.style3a;
        if (!this.style3aSet)
        {
            // style has no pre constraints
            style3a = handleGetStyle();
            // style has no post constraints
            this.style3a = style3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.style3aSet = true;
            }
        }
        return style3a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getUse()
    * @return String
    */
    protected abstract String handleGetUse();

    private transient String use4a;
    private transient boolean use4aSet = false;

    /**
     * Defines the formatting style for messages sent to and from the Web Service.  Can be one of
     * LITERAL or ENCODED.
     * @return (String)handleGetUse()
     */
    public final String getUse()
    {
        String use4a = this.use4a;
        if (!this.use4aSet)
        {
            // use has no pre constraints
            use4a = handleGetUse();
            // use has no post constraints
            this.use4a = use4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.use4aSet = true;
            }
        }
        return use4a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isRpcStyle()
    * @return boolean
    */
    protected abstract boolean handleIsRpcStyle();

    private transient boolean rpcStyle5a;
    private transient boolean rpcStyle5aSet = false;

    /**
     * Indicates whether or not this service is "rpc" style.
     * @return (boolean)handleIsRpcStyle()
     */
    public final boolean isRpcStyle()
    {
        boolean rpcStyle5a = this.rpcStyle5a;
        if (!this.rpcStyle5aSet)
        {
            // rpcStyle has no pre constraints
            rpcStyle5a = handleIsRpcStyle();
            // rpcStyle has no post constraints
            this.rpcStyle5a = rpcStyle5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.rpcStyle5aSet = true;
            }
        }
        return rpcStyle5a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isDocumentStyle()
    * @return boolean
    */
    protected abstract boolean handleIsDocumentStyle();

    private transient boolean documentStyle6a;
    private transient boolean documentStyle6aSet = false;

    /**
     * Indicates whether or not this service is "document" style
     * @return (boolean)handleIsDocumentStyle()
     */
    public final boolean isDocumentStyle()
    {
        boolean documentStyle6a = this.documentStyle6a;
        if (!this.documentStyle6aSet)
        {
            // documentStyle has no pre constraints
            documentStyle6a = handleIsDocumentStyle();
            // documentStyle has no post constraints
            this.documentStyle6a = documentStyle6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentStyle6aSet = true;
            }
        }
        return documentStyle6a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isEncodedUse()
    * @return boolean
    */
    protected abstract boolean handleIsEncodedUse();

    private transient boolean encodedUse7a;
    private transient boolean encodedUse7aSet = false;

    /**
     * Indicates whether or not this web service has a "encoded" use defined.
     * @return (boolean)handleIsEncodedUse()
     */
    public final boolean isEncodedUse()
    {
        boolean encodedUse7a = this.encodedUse7a;
        if (!this.encodedUse7aSet)
        {
            // encodedUse has no pre constraints
            encodedUse7a = handleIsEncodedUse();
            // encodedUse has no post constraints
            this.encodedUse7a = encodedUse7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.encodedUse7aSet = true;
            }
        }
        return encodedUse7a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isLiteralUse()
    * @return boolean
    */
    protected abstract boolean handleIsLiteralUse();

    private transient boolean literalUse8a;
    private transient boolean literalUse8aSet = false;

    /**
     * Indicates whether or not this web service has a "literal" use defined.
     * @return (boolean)handleIsLiteralUse()
     */
    public final boolean isLiteralUse()
    {
        boolean literalUse8a = this.literalUse8a;
        if (!this.literalUse8aSet)
        {
            // literalUse has no pre constraints
            literalUse8a = handleIsLiteralUse();
            // literalUse has no post constraints
            this.literalUse8a = literalUse8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.literalUse8aSet = true;
            }
        }
        return literalUse8a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isWebServiceOperationsExist()
    * @return boolean
    */
    protected abstract boolean handleIsWebServiceOperationsExist();

    private transient boolean webServiceOperationsExist9a;
    private transient boolean webServiceOperationsExist9aSet = false;

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade.webServiceOperationsExist
     * @return (boolean)handleIsWebServiceOperationsExist()
     */
    public final boolean isWebServiceOperationsExist()
    {
        boolean webServiceOperationsExist9a = this.webServiceOperationsExist9a;
        if (!this.webServiceOperationsExist9aSet)
        {
            // webServiceOperationsExist has no pre constraints
            webServiceOperationsExist9a = handleIsWebServiceOperationsExist();
            // webServiceOperationsExist has no post constraints
            this.webServiceOperationsExist9a = webServiceOperationsExist9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.webServiceOperationsExist9aSet = true;
            }
        }
        return webServiceOperationsExist9a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isWrappedParameterStyle()
    * @return boolean
    */
    protected abstract boolean handleIsWrappedParameterStyle();

    private transient boolean wrappedParameterStyle10a;
    private transient boolean wrappedParameterStyle10aSet = false;

    /**
     * Indicates whether or not this service parameter is "wrapped" style.
     * @return (boolean)handleIsWrappedParameterStyle()
     */
    public final boolean isWrappedParameterStyle()
    {
        boolean wrappedParameterStyle10a = this.wrappedParameterStyle10a;
        if (!this.wrappedParameterStyle10aSet)
        {
            // wrappedParameterStyle has no pre constraints
            wrappedParameterStyle10a = handleIsWrappedParameterStyle();
            // wrappedParameterStyle has no post constraints
            this.wrappedParameterStyle10a = wrappedParameterStyle10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.wrappedParameterStyle10aSet = true;
            }
        }
        return wrappedParameterStyle10a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#isBareParameterStyle()
    * @return boolean
    */
    protected abstract boolean handleIsBareParameterStyle();

    private transient boolean bareParameterStyle11a;
    private transient boolean bareParameterStyle11aSet = false;

    /**
     * Indicates whether or not this service parameter is "bare" style.
     * @return (boolean)handleIsBareParameterStyle()
     */
    public final boolean isBareParameterStyle()
    {
        boolean bareParameterStyle11a = this.bareParameterStyle11a;
        if (!this.bareParameterStyle11aSet)
        {
            // bareParameterStyle has no pre constraints
            bareParameterStyle11a = handleIsBareParameterStyle();
            // bareParameterStyle has no post constraints
            this.bareParameterStyle11a = bareParameterStyle11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.bareParameterStyle11aSet = true;
            }
        }
        return bareParameterStyle11a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getParameterStyle()
    * @return String
    */
    protected abstract String handleGetParameterStyle();

    private transient String parameterStyle12a;
    private transient boolean parameterStyle12aSet = false;

    /**
     * Determines whether method parameters represent the entire message body, or whether the
     * parameters are elements wrapped inside a top-level element named after the operation.  Can be
     * one of WRAPPED or BARE.
     * @return (String)handleGetParameterStyle()
     */
    public final String getParameterStyle()
    {
        String parameterStyle12a = this.parameterStyle12a;
        if (!this.parameterStyle12aSet)
        {
            // parameterStyle has no pre constraints
            parameterStyle12a = handleGetParameterStyle();
            // parameterStyle has no post constraints
            this.parameterStyle12a = parameterStyle12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.parameterStyle12aSet = true;
            }
        }
        return parameterStyle12a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getQName()
    * @return String
    */
    protected abstract String handleGetQName();

    private transient String qName13a;
    private transient boolean qName13aSet = false;

    /**
     * Returns the QName for this service.  Usually it will be the same name as the model element,
     * however it is possible to specify a prefix to give to this name.
     * @return (String)handleGetQName()
     */
    public final String getQName()
    {
        String qName13a = this.qName13a;
        if (!this.qName13aSet)
        {
            // qName has no pre constraints
            qName13a = handleGetQName();
            // qName has no post constraints
            this.qName13a = qName13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.qName13aSet = true;
            }
        }
        return qName13a;
    }

   /**
    * @see org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceFacade#getNamespace()
    * @return String
    */
    protected abstract String handleGetNamespace();

    private transient String namespace14a;
    private transient boolean namespace14aSet = false;

    /**
     * The name of the target namespace to which this web service belongs.
     * @return (String)handleGetNamespace()
     */
    public final String getNamespace()
    {
        String namespace14a = this.namespace14a;
        if (!this.namespace14aSet)
        {
            // namespace has no pre constraints
            namespace14a = handleGetNamespace();
            // namespace has no post constraints
            this.namespace14a = namespace14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.namespace14aSet = true;
            }
        }
        return namespace14a;
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