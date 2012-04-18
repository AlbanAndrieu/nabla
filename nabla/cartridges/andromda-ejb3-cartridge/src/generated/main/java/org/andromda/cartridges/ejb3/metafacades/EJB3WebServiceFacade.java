// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3WebServiceFacade
    extends EJB3SessionFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3WebServiceFacadeMetaType();

    /**
     * Returns the fully qualified interface name for this web service.
     * @return String
     */
    public String getFullyQualifiedWebServiceInterfaceName();

    /**
     * The name of the target namespace to which this web service belongs.
     * @return String
     */
    public String getNamespace();

    /**
     * Determines whether method parameters represent the entire message body, or whether the
     * parameters are elements wrapped inside a top-level element named after the operation.  Can be
     * one of WRAPPED or BARE.
     * @return String
     */
    public String getParameterStyle();

    /**
     * Returns the QName for this service.  Usually it will be the same name as the model element,
     * however it is possible to specify a prefix to give to this name.
     * @return String
     */
    public String getQName();

    /**
     * Defines the encoding binding style for messages send to and from the Web Service.  Can be one
     * of DOCUMENT or RPC.
     * @return String
     */
    public String getStyle();

    /**
     * Defines the formatting style for messages sent to and from the Web Service.  Can be one of
     * LITERAL or ENCODED.
     * @return String
     */
    public String getUse();

    /**
     * Returns the web service interface name for with web service.
     * @return String
     */
    public String getWebServiceInterfaceName();

    /**
     * Indicates whether or not this service parameter is "bare" style.
     * @return boolean
     */
    public boolean isBareParameterStyle();

    /**
     * Indicates whether or not this service is "document" style
     * @return boolean
     */
    public boolean isDocumentStyle();

    /**
     * Indicates whether or not this web service has a "encoded" use defined.
     * @return boolean
     */
    public boolean isEncodedUse();

    /**
     * Indicates whether or not this web service has a "literal" use defined.
     * @return boolean
     */
    public boolean isLiteralUse();

    /**
     * Indicates whether or not this service is "rpc" style.
     * @return boolean
     */
    public boolean isRpcStyle();

    /**
     * 
     * @return boolean
     */
    public boolean isWebServiceOperationsExist();

    /**
     * Indicates whether or not this service parameter is "wrapped" style.
     * @return boolean
     */
    public boolean isWrappedParameterStyle();
}