package org.andromda.cartridges.jsf2.metafacades;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.andromda.cartridges.jsf2.JSFGlobals;
import org.andromda.cartridges.jsf2.JSFProfile;
import org.andromda.cartridges.jsf2.JSFUtils;
import org.andromda.metafacades.uml.StateVertexFacade;
import org.andromda.utils.StringUtilsHelper;
import org.apache.log4j.Logger;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.jsf2.metafacades.JSFForward.
 * 
 * @see org.andromda.cartridges.jsf2.metafacades.JSFForward
 */
public class JSFForwardLogicImpl extends JSFForwardLogic
{
    private static final long serialVersionUID = 34L;

    private final Logger      logger_          = Logger.getLogger(JSFForwardLogicImpl.class);

    /**
     * @param metaObject
     * @param context
     */
    public JSFForwardLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see org.andromda.metafacades.uml.ModelElementFacade#getName()
     */
    @Override
    public String getName()
    {
        final StringBuilder name = new StringBuilder(super.getName());
        final Object target = this.getTarget();
        this.logger_.debug("getName is : " + name + " - " + target + " for : " + this.getFullyQualifiedName());
        if (target instanceof JSFFinalState)
        {
            name.append(JSFGlobals.USECASE_FORWARD_NAME_SUFFIX);
        } else
        {
            name.insert(0, this.getUseCase().getName() + "-");
        }
        return JSFUtils.toWebResourceName(name.toString());
    }

    /**
     * @return forwardPath
     * @see org.andromda.cartridges.jsf.metafacades.JSFForward#getPath()
     */
    @Override
    protected String handleGetPath()
    {
        String forwardPath = null;
        final StateVertexFacade target = this.getTarget();
        if (this.isEnteringView())
        {
            forwardPath = ((JSFView) target).getPath();
        } else if (this.isEnteringFinalState())
        {
            forwardPath = ((JSFFinalState) target).getPath();
        }

        return forwardPath;
    }

    /**
     * @see org.andromda.cartridges.jsf.metafacades.JSFForwardLogic#handleIsSuccessMessagesPresent()
     */
    @Override
    protected boolean handleIsSuccessMessagesPresent()
    {
        return !this.getSuccessMessages().isEmpty();
    }

    /**
     * @see org.andromda.cartridges.jsf.metafacades.JSFForwardLogic#handleIsWarningMessagesPresent()
     */
    @Override
    protected boolean handleIsWarningMessagesPresent()
    {
        return !this.getWarningMessages().isEmpty();
    }

    /**
     * Collects specific messages in a map.
     * 
     * @param taggedValue the tagged value from which to read the message
     * @return maps message keys to message values, but only those that match the arguments
     * will have been recorded
     */
    @SuppressWarnings("unchecked")
    private Map<String, String> getMessages(final String taggedValue)
    {
        Map<String, String> messages;

        final Collection taggedValues = this.findTaggedValues(taggedValue);
        if (taggedValues.isEmpty())
        {
            messages = Collections.EMPTY_MAP;
        } else
        {
            messages = new LinkedHashMap<String, String>(); // we want to keep the order

            for (final Iterator iterator = taggedValues.iterator(); iterator.hasNext();)
            {
                final String value = (String) iterator.next();
                messages.put(StringUtilsHelper.toResourceMessageKey(value), value);
            }
        }

        return messages;
    }

    /**
     * @see org.andromda.cartridges.jsf.metafacades.JSFForwardLogic#handleGetSuccessMessages()
     */
    @Override
    protected Map handleGetSuccessMessages()
    {
        return this.getMessages(JSFProfile.TAGGEDVALUE_ACTION_SUCCESS_MESSAGE);
    }

    /**
     * @see org.andromda.cartridges.jsf.metafacades.JSFForwardLogic#handleGetWarningMessages()
     */
    @Override
    protected Map handleGetWarningMessages()
    {
        return this.getMessages(JSFProfile.TAGGEDVALUE_ACTION_WARNING_MESSAGE);
    }

    /**
     * @return getTarget() instanceof JSFFinalState
     * @see org.andromda.cartridges.jsf.metafacades.JSFForward#isFinalStateTarget()
     */
    @Override
    protected boolean handleIsFinalStateTarget()
    {
        return this.getTarget() instanceof JSFFinalState;
    }

    /**
     * @return getName()
     * @see org.andromda.cartridges.jsf.metafacades.JSFForward#getFromOutcome()
     */
    @Override
    protected String handleGetFromOutcome()
    {
        return this.getName();
    }
}
