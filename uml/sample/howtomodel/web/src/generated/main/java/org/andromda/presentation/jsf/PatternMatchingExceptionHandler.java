// license-header java merge-point
// Generated by andromda-jsf cartridge (exception\PatternMatchingExceptionHandler.java.vsl) DO NOT EDIT!
//
package org.andromda.presentation.jsf;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

/**
 * <p>
 *  A configurable pattern matching error handler retrieves exception mapping
 *  keys from an exception, and re-throws the exception if a pattern can not be
 *  retrieved.  This is used to retrieve keys from the back-end exceptions
 *  which can be mapped to exception messages keyed in an application resource
 *  file.
 * </p>
 */
public class PatternMatchingExceptionHandler
    implements Serializable
{
    private static final long serialVersionUID = 1L;

    private static final PatternMatchingExceptionHandler instance = new PatternMatchingExceptionHandler();

    private static final Pattern compiledPattern = Pattern.compile("(.*)(\\{\\s*([\\w|\\.+]*)\\s*\\})(.*)");

    /**
     * Gets the shared PatternMatchingExceptionHandler instance.
     *
     * @return the shared instance
     */
    public static PatternMatchingExceptionHandler instance()
    {
        return instance;
    }

    /**
     * Handles Exceptions by retrieving the message and attempting to extract
     * the specified pattern defined within this class. If a string can not be
     * found matching the pattern, the exception is re-thrown
     *
     * @param throwable the Exception containing the message to retrieve
     * @return the retrieved string matching the pattern.
     * @throws Throwable
     */
    public String handleException(final Throwable throwable) throws Throwable
    {
        final Throwable cause =  this.findRootCause(throwable);
        String matched = null;
        if (cause != null && cause.getMessage() != null)
        {
            final Matcher matcher = compiledPattern.matcher(cause.getMessage().replaceAll("[\\s]+", " "));
            try
            {
                if (matcher.matches())
                {
                    matched = matcher.group(3);
                }
            }
            catch (IllegalStateException ex)
            {
                // no match was found ignore
            }
            if (matched != null)
            {
                return matched;
            }
        }
        throw throwable;
    }

    /**
     * The property on the exception which could possibly contain any arguments on the matched exception.
     */
    private static final String MESSAGE_ARGUMENTS = "messageArguments";

    /**
     * Attempts to retrieve any arguments from the exception from a property named "messageArguments"
     * on the exception.
     *
     * @param throwable the Exception containing the message to retrieve
     * @return the retrieved message arguments (if any) from the exception.
     * @throws Throwable
     */
    public Object[] getMessageArguments(final Throwable throwable) throws Throwable
    {
        Object[] arguments = null;
        final Throwable cause =  this.findRootCause(throwable);
        if (cause != null && cause.getMessage() != null)
        {
            if (PropertyUtils.isReadable(cause, MESSAGE_ARGUMENTS))
            {
                arguments = (Object[])PropertyUtils.getProperty(cause, MESSAGE_ARGUMENTS);
            }
        }
        return arguments;
    }

    /**
     * Finds the root cause of the parent exception
     * by traveling up the exception hierarchy.
     * @param throwable the Exception containing the message to retrieve
     * @throws Throwable
     */
    private Throwable findRootCause(Throwable throwable)
    {
        final Throwable rootCause = ExceptionUtils.getRootCause(throwable);
        if (rootCause != null)
        {
            throwable = rootCause;
        }
        return throwable;
    }
}