// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by DefaultServiceException.vsl in andromda-ejb3-cartridge.
//
package org.andromda.timetracker.service;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * The default exception thrown for unexpected errors occurring
 * within {@link org.andromda.timetracker.service.TimeTrackingService}.
 */
public class TimeTrackingServiceException
    extends RuntimeException
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -6405529844507086518L;

    /**
     * The default constructor for <code>TimeTrackingServiceException</code>.
     */
    public TimeTrackingServiceException()
    {}

    /**
     * Constructs a new instance of <code>TimeTrackingServiceException</code>.
     *
     * @param throwable the parent Throwable
     */
    public TimeTrackingServiceException(Throwable throwable)
    {
        super(findRootCause(throwable));
    }

    /**
     * Constructs a new instance of <code>TimeTrackingServiceException</code>.
     *
     * @param message the throwable message.
     */
    public TimeTrackingServiceException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new instance of <code>TimeTrackingServiceException</code>.
     *
     * @param message the throwable message.
     * @param throwable the parent of this Throwable.
     */
    public TimeTrackingServiceException(String message, Throwable throwable)
    {
        super(message, findRootCause(throwable));
    }

    /**
     * Finds the root cause of the parent exception
     * by traveling up the exception tree
     */
    private static Throwable findRootCause(Throwable th)
    {
        if (th != null)
        {
            // Reflectively get any exception causes.
            try
            {
                Throwable targetException = null;

                // java.lang.reflect.InvocationTargetException
                String exceptionProperty = "targetException";
                if (PropertyUtils.isReadable(th, exceptionProperty))
                {
                    targetException = (Throwable)PropertyUtils.getProperty(th, exceptionProperty);
                }
                else
                {
                    exceptionProperty = "causedByException";
                    //javax.ejb.EJBException
                    if (PropertyUtils.isReadable(th, exceptionProperty))
                    {
                        targetException = (Throwable)PropertyUtils.getProperty(th, exceptionProperty);
                    }
                }
                if (targetException != null)
                {
                    th = targetException;
                }
            }
            catch (Exception ex)
            {
                // just print the exception and continue
                ex.printStackTrace();
            }

            if (th.getCause() != null)
            {
                th = th.getCause();
                th = findRootCause(th);
            }
        }
        return th;
    }
}