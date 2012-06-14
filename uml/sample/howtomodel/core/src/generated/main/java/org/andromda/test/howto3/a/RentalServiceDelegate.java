// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ServiceDelegate.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto3.a;

import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import org.andromda.test.ServiceDelegateBase;
import org.andromda.test.ServiceLocator;

/**
 * Web service delegator for {@link org.andromda.test.howto3.a.RentalServiceBean}.
 *
 * @see org.andromda.test.howto3.a.RentalServiceBean
 */
public class RentalServiceDelegate
    extends ServiceDelegateBase
{
    /**
     * Default constructor
     */
    public RentalServiceDelegate()
    {
        super();
    }

    /**
     * Constructor setting the envirinment properties.
     *
     * @param properties
     */
    public RentalServiceDelegate(Properties properties)
    {
        super(properties);
    }

    /**
     * Gets an instance of {@link RentalServiceRemote}
     */
    private final RentalServiceRemote getRentalServiceRemote()
        throws NamingException
    {
        return ServiceLocator.getInstance().get_org_andromda_test_howto3_a_RentalServiceBean_Remote(getProperties());
    }

    /**
     * @see org.andromda.test.howto3.a.RentalServiceBean#getAllCars()
     *
     * Call the session bean operation using appropriate view type
     */
    public List getAllCars()
    {
        try
        {
            return getRentalServiceRemote().getAllCars();
        }
        catch (NamingException ex)
        {
            throw new RentalServiceException(
                "Error performing 'org.andromda.test.howto3.a.RentalService.getAllCars()' --> " + ex, ex);
        }
    }

    /**
     * @see org.andromda.test.howto3.a.RentalServiceBean#getCustomersByName(String)
     *
     * Call the session bean operation using appropriate view type
     */
    public List getCustomersByName(String name)
    {
        try
        {
            return getRentalServiceRemote().getCustomersByName(name);
        }
        catch (NamingException ex)
        {
            throw new RentalServiceException(
                "Error performing 'org.andromda.test.howto3.a.RentalService.getCustomersByName(String name)' --> " + ex, ex);
        }
    }

}