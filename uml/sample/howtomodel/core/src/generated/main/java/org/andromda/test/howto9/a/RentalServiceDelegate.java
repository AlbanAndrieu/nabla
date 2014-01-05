// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by ServiceDelegate.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto9.a;

import java.util.List;
import java.util.Properties;
import javax.naming.NamingException;
import org.andromda.test.ServiceDelegateBase;
import org.andromda.test.ServiceLocator;

/**
 * Web service delegator for {@link org.andromda.test.howto9.a.RentalServiceBean}.
 *
 * @see org.andromda.test.howto9.a.RentalServiceBean
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
    private RentalServiceRemote getRentalServiceRemote()
        throws NamingException
    {
        return ServiceLocator.getInstance().get_org_andromda_test_howto9_a_RentalServiceBean_Remote(getProperties());
    }

    /**
     * Call the session bean operation using appropriate view type
     * @see org.andromda.test.howto9.a.RentalServiceBean#getAllCars()
     *
     * @return List
     * @throws RentalException
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
                "Error performing 'org.andromda.test.howto9.a.RentalService.getAllCars()' --> " + ex, ex);
        }
    }

    /**
     * Call the session bean operation using appropriate view type
     * @see org.andromda.test.howto9.a.RentalServiceBean#getCustomersByName(String)
     *
     * @param name
     * @return List
     * @throws RentalException
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
                "Error performing 'org.andromda.test.howto9.a.RentalService.getCustomersByName(String name)' --> " + ex, ex);
        }
    }

}