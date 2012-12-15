// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

/**
 * TODO: Model Documentation for
 * org.andromda.cartridges.ejb3.metafacades.EJB3WebServiceOperationFacade
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3WebServiceOperationFacade
    extends EJB3SessionOperationFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3WebServiceOperationFacadeMetaType();

    /**
     * Returns the web service operation signature having @WebParam annotations for each parameter.
     * @return String
     */
    public String getAnnotatedSignature();

    /**
     * Returns the webMethod operation name.
     * @return String
     */
    public String getMethodName();

    /**
     * Returns the webResult name.
     * @return String
     */
    public String getResultName();

    /**
     * Returns true/false depending on whether or not this web service operation is exposed.
     * @return boolean
     */
    public boolean isExposed();

    /**
     * Specifies that this webservice operation has only an input message and no output. Typically,
     * a oneway method returns the thread of control to the calling application prior to executing
     * the actual business method.
     * You should not model the andromda_webservice_operation_oneway tagged value on operations that
     * have a return value or holder parameters, or declare any checked exceptions.
     * @return boolean
     */
    public boolean isOneway();
}