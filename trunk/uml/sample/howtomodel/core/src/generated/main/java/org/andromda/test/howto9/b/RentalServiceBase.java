// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by SessionBeanBase.vsl in andromda-ejb3-cartridge.
//
package org.andromda.test.howto9.b;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Autogenerated EJB3 session bean base class RentalServiceBean which contains
 * method level annotations for the session bean.  All method level annotations
 * are inherited by the extending session bean class.
 * 
 */
public abstract class RentalServiceBase implements RentalService
{

    // ------ Session Context Injection ------

    @Resource
    protected SessionContext context;

    // ------ Persistence Context Definitions --------
    /**
     * Inject persistence context howtomodel
     */
    @PersistenceContext(unitName = "howtomodel")
    protected EntityManager emanager;


    // ------ DAO Injection Definitions --------

    /**
     * Inject DAO PersonDao
     */
    @EJB(mappedName="howtomodel-1.0/PersonDaoImpl")
    private PersonDao personDao;

    /**
     * Inject DAO VehicleDao
     */
    @EJB(mappedName="howtomodel-1.0/VehicleDaoImpl")
    private VehicleDao vehicleDao;

    // --------------- Constructors ---------------

    public RentalServiceBase()
    {
        super();
    }

    // ------ DAO Getters --------

    /**
     * Get the injected DAO PersonDao
     */
    protected PersonDao getPersonDao()
    {
        return this.personDao;
    }

    /**
     * Get the injected DAO VehicleDao
     */
    protected VehicleDao getVehicleDao()
    {
        return this.vehicleDao;
    }

    // -------- Business Methods  --------------

    /**
     * Returns a list of all cars known by the system.
     */
    public List getAllCars() throws RentalException
    {
        try
        {
            return this.handleGetAllCars();
        }
        catch (RentalException ex)
        {
            throw ex;
        }
        catch (Throwable th)
        {
            throw new RentalServiceException("Error performing 'RentalService.getAllCars()' --> " + th, th);
        }
    }

    /**
     * Performs the core logic for {@link #getAllCars()}
     */
    protected abstract List handleGetAllCars() throws Exception;

    /**
     * Returns all customers with the specified name.
     */
    public List getCustomersByName(String name) throws RentalException
    {
        if (name == null)
        {
            throw new IllegalArgumentException("org.andromda.test.howto9.b.RentalServiceBean.getCustomersByName(String name) - 'name' can not be null");
        }
        try
        {
            return this.handleGetCustomersByName(name);
        }
        catch (RentalException ex)
        {
            throw ex;
        }
        catch (Throwable th)
        {
            throw new RentalServiceException("Error performing 'RentalService.getCustomersByName(String name)' --> " + th, th);
        }
    }

    /**
     * Performs the core logic for {@link #getCustomersByName(String)}
     */
    protected abstract List handleGetCustomersByName(String name) throws Exception;


    // -------- Lifecycle Callbacks --------------

}