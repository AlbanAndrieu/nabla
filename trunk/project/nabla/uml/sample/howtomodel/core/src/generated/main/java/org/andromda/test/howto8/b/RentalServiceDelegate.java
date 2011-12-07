// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ServiceDelegate.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto8.b;

import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import org.andromda.test.ServiceDelegateBase;
import org.andromda.test.ServiceLocator;

/**
 * Web service delegator for {@link org.andromda.test.howto8.b.RentalServiceBean}.
 *
 * @see org.andromda.test.howto8.b.RentalServiceBean
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
        return ServiceLocator.getInstance().get_org_andromda_test_howto8_b_RentalServiceBean_Remote(getProperties());
    }

    /**
     * @see org.andromda.test.howto8.b.RentalServiceBean#getAllCars()
     *
     * Call the session bean operation using appropriate view type
     */
    public List getAllCars()
        throws RentalException
    {
        try
        {
            return getRentalServiceRemote().getAllCars();
        }
        catch (RentalException ex)
        {
            throw ex;
        }
        catch (NamingException ex)
        {
            throw new RentalServiceException(
                "Error performing 'org.andromda.test.howto8.b.RentalService.getAllCars()' --> " + ex, ex);
        }
    }

    /**
     * @see org.andromda.test.howto8.b.RentalServiceBean#getCustomersByName(String)
     *
     * Call the session bean operation using appropriate view type
     */
    public List getCustomersByName(String name)
        throws RentalException
    {
        try
        {
            return getRentalServiceRemote().getCustomersByName(name);
        }
        catch (RentalException ex)
        {
            throw ex;
        }
        catch (NamingException ex)
        {
            throw new RentalServiceException(
                "Error performing 'org.andromda.test.howto8.b.RentalService.getCustomersByName(String name)' --> " + ex, ex);
        }
    }

}