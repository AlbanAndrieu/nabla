// license-header java merge-point
//
// Generated by: SessionBeanImpl.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto3.a;

import java.util.List;

/**
 * @see RentalServiceBase
 *
 * Remember to manually configure the local business interface this bean implements if originally you only
 * defined the remote business interface.  However, this change is automatically reflected in the ejb-jar.xml.
 *
 * Do not specify the javax.ejb.Stateless annotation
 * Instead, the session bean is defined in the ejb-jar.xml descriptor.
 */
// Uncomment to enable webservices for RentalServiceBean
// @javax.jws.WebService(endpointInterface = "org.andromda.test.howto3.a.RentalServiceWSInterface", serviceName = "RentalService")
public class RentalServiceBean
    extends RentalServiceBase
    implements RentalServiceRemote
{

    // --------------- Constructors ---------------

    /**
     * Default constructor extending base class default constructor
     */
    public RentalServiceBean()
    {
        super();
    }

    // -------- Business Methods Impl --------------

    /**
     * @see RentalServiceBase#getAllCars()
     */
    protected List handleGetAllCars()
        throws Exception
    {
        //TODO: put your implementation here.
        // Dummy return value, just that the file compiles
        return null;
    }

    /**
     * @see RentalServiceBase#getCustomersByName(String)
     */
    protected List handleGetCustomersByName(String name)
        throws Exception
    {
        //TODO: put your implementation here.
        // Dummy return value, just that the file compiles
        return null;
    }


    // -------- Lifecycle Callback Implementation --------------

}