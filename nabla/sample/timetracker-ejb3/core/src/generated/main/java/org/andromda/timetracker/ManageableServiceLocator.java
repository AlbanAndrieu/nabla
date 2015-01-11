// license-header java merge-point
/* Autogenerated by AndroMDA crud/ManageableServiceLocator.vsl in andromda-ejb3-cartridge - do not edit */
package org.andromda.timetracker;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.andromda.timetracker.domain.crud.MovieManageableService;
import org.andromda.timetracker.domain.crud.TaskManageableService;
import org.andromda.timetracker.domain.crud.UserManageableService;
import org.andromda.timetracker.domain.crud.UserRoleManageableService;

/**
 * Locates and provides all available application services.
 */
public class ManageableServiceLocator
{
    /**
     * The shared instance of this ServiceLocator.
     */
    private static ManageableServiceLocator instance;

    /**
     * The Context to lookup the service beans.
     */
    protected InitialContext context = null;

    /**
     * Cannot be instantiated constructor
     */
    private ManageableServiceLocator()
    {
        // shouldn't be instantiated
    }

    /**
     * Gets the shared instance of this Class.
     * Create it if it doesn't already exists, otherwise return the current instance.
     *
     * @return the shared service locator instance.
     */
    public static final ManageableServiceLocator instance()
    {
        if (instance == null)
        {
            instance = new ManageableServiceLocator();
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
     * Shuts down the ManageableServiceLocator and releases any used resources.
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
     * Gets an instance of {@link UserManageableService}.
     *
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final UserManageableService getUserManageableService() throws NamingException
    {
        return this.getUserManageableServiceRemote(null);
    }

    /**
     * Get the remote interface for {@link UserManageableService}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final UserManageableService getUserManageableServiceRemote(Properties env) throws NamingException
    {
        return (UserManageableService) getContext(env).lookup("UserManageableService/remote");
    }

    /**
     * Get the local interface for {@link UserManageableService}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final UserManageableService getUserManageableServiceLocal(Properties env) throws NamingException
    {
        return (UserManageableService) getContext(env).lookup("UserManageableService/local");
    }
    /**
     * Gets an instance of {@link TaskManageableService}.
     *
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final TaskManageableService getTaskManageableService() throws NamingException
    {
        return this.getTaskManageableServiceRemote(null);
    }

    /**
     * Get the remote interface for {@link TaskManageableService}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final TaskManageableService getTaskManageableServiceRemote(Properties env) throws NamingException
    {
        return (TaskManageableService) getContext(env).lookup("TaskManageableService/remote");
    }

    /**
     * Get the local interface for {@link TaskManageableService}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final TaskManageableService getTaskManageableServiceLocal(Properties env) throws NamingException
    {
        return (TaskManageableService) getContext(env).lookup("TaskManageableService/local");
    }
    /**
     * Gets an instance of {@link UserRoleManageableService}.
     *
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final UserRoleManageableService getUserRoleManageableService() throws NamingException
    {
        return this.getUserRoleManageableServiceRemote(null);
    }

    /**
     * Get the remote interface for {@link UserRoleManageableService}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final UserRoleManageableService getUserRoleManageableServiceRemote(Properties env) throws NamingException
    {
        return (UserRoleManageableService) getContext(env).lookup("UserRoleManageableService/remote");
    }

    /**
     * Get the local interface for {@link UserRoleManageableService}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final UserRoleManageableService getUserRoleManageableServiceLocal(Properties env) throws NamingException
    {
        return (UserRoleManageableService) getContext(env).lookup("UserRoleManageableService/local");
    }
    /**
     * Gets an instance of {@link MovieManageableService}.
     *
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final MovieManageableService getMovieManageableService() throws NamingException
    {
        return this.getMovieManageableServiceRemote(null);
    }

    /**
     * Get the remote interface for {@link MovieManageableService}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final MovieManageableService getMovieManageableServiceRemote(Properties env) throws NamingException
    {
        return (MovieManageableService) getContext(env).lookup("MovieManageableService/remote");
    }

    /**
     * Get the local interface for {@link MovieManageableService}.
     *
     * @param env the Context environment properties.  Null represents no properties.
     * @throws NamingException failure to lookup remote manageable service interface.
     */
    public final MovieManageableService getMovieManageableServiceLocal(Properties env) throws NamingException
    {
        return (MovieManageableService) getContext(env).lookup("MovieManageableService/local");
    }

    /**
     * Gets an instance of the given service.
     *
     * @param serviceName lookup this service from the context.
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
     * @throws NamingException failure to lookup remote service interface.
     */
    public final Object getService(String serviceName, Properties env) throws NamingException
    {
        return getContext(env).lookup(serviceName);
    }
}