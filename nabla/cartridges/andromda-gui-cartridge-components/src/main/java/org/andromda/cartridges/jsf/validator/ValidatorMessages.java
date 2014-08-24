/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package org.andromda.cartridges.jsf.validator;

import org.andromda.cartridges.jsf.Messages;

import org.apache.commons.validator.Arg;
import org.apache.commons.validator.Field;
import org.apache.commons.validator.ValidatorAction;

import java.text.MessageFormat;

import java.util.Locale;
import java.util.MissingResourceException;

import javax.faces.context.FacesContext;

/**
 * Retrieves and formats the validation messages.
 * 
 * @author Chad Brandon
 */
public class ValidatorMessages
{

    /**
     * Gets the <code>message</code> based on the <code>action</code>
     * message and the <code>field</code>'s arg objects.
     * 
     * @param action Validator action
     * @param args any message arguments to be substituted.
     * @param context the faces context
     * @return action message
     */
    public static String getMessage(final ValidatorAction action, final String[] args, final FacesContext context)
    {

        final Locale locale = context.getViewRoot().getLocale();
        String message = null;
        final String messageKey = action.getMsg();

        if (messageKey != null)
        {

            try
            {

                message = Messages.get(messageKey, args);

            } catch (final MissingResourceException exception)
            {

                message = messageKey;

            }

        }

        message = new MessageFormat(message, locale).format(args);

        return message;

    }

    /**
     * Gets the message given the action, field and faces context.
     * 
     * @param action the validator action instance.
     * @param field the field.
     * @param context the faces context.
     * @return the message
     */
    public static String getMessage(final ValidatorAction action, final Field field, final FacesContext context)
    {

        return getMessage(action, getArgs(action.getName(), field), context);

    }

    /**
     * Gets the message arguments based on the given
     * validator <code>action</code> and <code>field</code>.
     * 
     * @param action action name
     * @param field the validator field
     * @return message arguments
     */
    public static String[] getArgs(final String action, final Field field)
    {

        final Arg[] args = field.getArgs(action);
        final String[] argMessages = new String[args.length];

        for (int ctr = 0; ctr < args.length; ctr++)
        {

            final Arg arg = args[ctr];

            if (arg != null)
            {

                if (arg.isResource())
                {

                    argMessages[ctr] = Messages.get(arg.getKey(), null);

                } else
                {

                    argMessages[ctr] = arg.getKey();

                }

            }

        }

        return argMessages;

    }

}
