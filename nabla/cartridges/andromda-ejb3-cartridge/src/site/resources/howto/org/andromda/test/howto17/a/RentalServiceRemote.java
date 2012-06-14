// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SessionRemote.vsl in andromda-ejb3-cartridge.
//
package org.andromda.howto2.rental;

import java.util.List;

/**
 * Remote component interface for the RentalServiceBean session bean.
 *
 */
public interface RentalServiceRemote
{
    // ---------- Accessors For Constants -----------


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