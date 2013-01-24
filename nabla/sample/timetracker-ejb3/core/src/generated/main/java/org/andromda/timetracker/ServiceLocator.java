// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by ServiceLocator.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.andromda.timetracker.service.SecurityServiceRemote;
import org.andromda.timetracker.service.TimeTrackingServiceRemote;
import org.andromda.timetracker.service.UserServiceLocal;
import org.andromda.timetracker.service.UserServiceRemote;

/**
 * Locates and provides all available application services.
 */
public class ServiceLocator
{
    /**
     * The shared instance of this ServiceLocator.
     */
    private static ServiceLocator instance;

    /**
     * The Context to lookup the service beans.
     */
    protected InitialContext context = null;

    /**
     * Cannot be instantiated constructor
     */
    private ServiceLocator()
    {
        // shouldn't be instantiated
    }

    /**
     * Gets the instance of this Class.
     * Create it if doesn't already exist, otherwise return the current instance.
     *
     * @return the shared service locator instance.
     */
    public static final ServiceLocator getInstance()
    {
        if (instance == null)
        {
            instance = new ServiceLocator();
        }
        return instance;
    }

    /**
     * Gets the InitialContext.
     *
     * @param env the Context environment properties.
     * @return the InitialContext.
     * @throws NamingException failure to create InitialContext
     */
    protected synchronized InitialContext getContext(Properties env) throws NamingException
    {
        if (this.context == null)
        {
            this.context = new InitialContext(env);
        }
        return this.context;
    }

    /**
     * Instantiate a new InitialContext using the properties table.
     *
     * @param env passed to the InitialContext constructor.
     * @return the InitialContext.
     * @throws NamingException failure to create InitialContext
     */
    protected synchronized InitialContext newContext(Properties env) throws NamingException
    {
        this.context = new InitialContext(env);
        return this.context;
    }

    /**
     * Shuts down the ServiceLocator and releases any used resources.
     */
    public synchronized void shutdown()
    {
        if (this.context != null)
        {
            try
            {
                this.context.close();
            }
            catch (NamingException ne)
            {
                // ignore
            }
            finally
            {
                this.context = null;
            }
        }
    }

    /**
     * Gets an instance of {@link UserServiceRemote}.
     *
     * @throws NamingException failure to lookup remote service interface.
     */
    /*
    public final UserServiceRemote getUserService() throws NamingException
    {
        return get_org_andromda_timetracker_service_UserServiceBean_Remote(null);
            
    }
    */
    
    /**
     * Gets the remote interface {@link UserServiceRemote}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @return UserServiceRemote
     * @throws NamingException failure to lookup remote service interface.
     */
    public final UserServiceRemote get_org_andromda_timetracker_service_UserServiceBean_Remote(Properties env) throws NamingException
    {
        return (UserServiceRemote) getContext(env).lookup("UserServiceBean/remote");
    }

    /**
     * Gets the local interface {@link UserServiceLocal}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @return UserServiceRemote
     * @throws NamingException failure to lookup local service interface.
     */
    public final UserServiceLocal get_org_andromda_timetracker_service_UserServiceBean_Local(Properties env) throws NamingException
    {
        return (UserServiceLocal) getContext(env).lookup("UserServiceBean/local");
    }


    /**
     * Gets an instance of {@link TimeTrackingServiceRemote}.
     *
     * @throws NamingException failure to lookup remote service interface.
     */
    /*
    public final TimeTrackingServiceRemote getTimeTrackingService() throws NamingException
    {
        return get_org_andromda_timetracker_service_TimeTrackingServiceBean_Remote(null);
            
    }
    */
    
    /**
     * Gets the remote interface {@link TimeTrackingServiceRemote}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @return TimeTrackingServiceRemote
     * @throws NamingException failure to lookup remote service interface.
     */
    public final TimeTrackingServiceRemote get_org_andromda_timetracker_service_TimeTrackingServiceBean_Remote(Properties env) throws NamingException
    {
        return (TimeTrackingServiceRemote) getContext(env).lookup("TimeTrackingServiceBean/remote");
    }


    /**
     * Gets an instance of {@link SecurityServiceRemote}.
     *
     * @throws NamingException failure to lookup remote service interface.
     */
    /*
    public final SecurityServiceRemote getSecurityService() throws NamingException
    {
        return get_org_andromda_timetracker_service_SecurityServiceBean_Remote(null);
            
    }
    */
    
    /**
     * Gets the remote interface {@link SecurityServiceRemote}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @return SecurityServiceRemote
     * @throws NamingException failure to lookup remote service interface.
     */
    public final SecurityServiceRemote get_org_andromda_timetracker_service_SecurityServiceBean_Remote(Properties env) throws NamingException
    {
        return (SecurityServiceRemote) getContext(env).lookup("SecurityServiceBean/remote");
    }


    /**
     * Gets an instance of the given service.
     *
     * @param serviceName lookup this service from the context.
     * @return Object getService(serviceName, null)
     * @throws NamingException failure to lookup remote service interface.
     */
    public final Object getService(String serviceName) throws NamingException
    {
        return getService(serviceName, null);
    }

    /**
     * Gets an instance of the given service.
     *
     * @param serviceName lookup this service from the context.
     * @param env the Context environment properties.  Null represents no properties.
     * @return Object getContext(env).lookup(serviceName)
     * @throws NamingException failure to lookup remote service interface.
     */
    public final Object getService(String serviceName, Properties env) throws NamingException
    {
        return getContext(env).lookup(serviceName);
    }
}