package org.andromda.timetracker.action;

import org.jboss.seam.contexts.Contexts;

/**
 * Interceptor class LoggedInInterceptor
 */
public class LoggedInInterceptor
{
    /**
     * Default interceptor execution method
     * 
     * @param ctx the invocation context
     * @return
     */
    @javax.interceptor.AroundInvoke
    public Object execute(final javax.interceptor.InvocationContext ctx) throws Exception
    {

        final boolean isLoggedIn = Contexts.getSessionContext().get("loggedIn") != null;
        if (isLoggedIn)
        {
            // the user is already logged in
            return ctx.proceed();
        } else
        {
            // the user is not logged in, fwd to login page
            return "login";
        }
    }
}
