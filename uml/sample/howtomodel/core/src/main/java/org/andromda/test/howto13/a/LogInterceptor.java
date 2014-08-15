// license-header java merge-point
package org.andromda.test.howto13.a;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Interceptor class LogInterceptor
 */
public class LogInterceptor
{
    /**
     * Default interceptor execution method
     * 
     * @param ctx the invocation context
     * @return
     */
    @AroundInvoke
    public Object execute(InvocationContext ctx) throws Exception
    {
        // Add implementation

        try
        {
            return ctx.proceed();
        } catch (Exception e)
        {
            throw e;
        }
    }
}
