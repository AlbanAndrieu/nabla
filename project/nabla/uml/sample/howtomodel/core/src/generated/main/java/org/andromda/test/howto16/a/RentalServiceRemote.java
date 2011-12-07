// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SessionRemote.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto16.a;

import java.util.List;
import javax.ejb.Remote;

/**
 * Remote component interface for the RentalServiceBean session bean.
 * 
 */
@Remote
public interface RentalServiceRemote
    extends RentalService
{

    // ------------ Business Methods  -----------------

    /**
     * 
     */
    public List getAllCars()
        throws RentalException;

    /**
     * 
     */
    public List getCustomersByName(String name)
        throws RentalException;

}