package com.gwtplatform.dispatch.server.seam;

import java.util.logging.Logger;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.remoting.WebRemote;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwtplatform.dispatch.shared.DispatchService;
import com.gwtplatform.dispatch.server.AbstractDispatchServiceImpl;
import com.gwtplatform.dispatch.server.Dispatch;
import com.gwtplatform.dispatch.server.RequestProvider;

import com.gwtplatform.dispatch.server.seam.request.DefaultRequestProvider;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.ActionException;
import com.gwtplatform.dispatch.shared.Result;
import com.gwtplatform.dispatch.shared.ServiceException;

@Name("com.gwtplatform.dispatch.shared.DispatchService")
public class DispatchServiceImpl extends RemoteServiceServlet implements DispatchService
{

    private static final long                serialVersionUID = -708585059678689064L;
    protected static final Logger            logger           = Logger.getLogger(DispatchServiceImpl.class.getName());
    protected NonAbstractDispatchServiceImpl dispatchService;

    @In
    protected DispatchImpl                   gwtpDispatchImpl;
    @In
    protected HandlerRegistry                gwtpActionHandlerValidatorRegistry;

    @Create
    public void create()
    {
        DispatchConfiguration gwtpDispatchConfiguration = (DispatchConfiguration) Component.getInstance(DispatchConfiguration.COMPONENT_NAME);
        gwtpDispatchConfiguration.configureHandlers(gwtpActionHandlerValidatorRegistry);
        SecurityCookieFilterConfig securityConfiguration = gwtpDispatchConfiguration.getClass().getAnnotation(SecurityCookieFilterConfig.class);
        if (securityConfiguration != null)
        {
            dispatchService = new NonAbstractDispatchServiceImpl(logger, gwtpDispatchImpl, new DefaultRequestProvider(), securityConfiguration.cookieName());
        } else
        {
            dispatchService = new NonAbstractDispatchServiceImpl(logger, gwtpDispatchImpl, new DefaultRequestProvider(), null);
        }
    }

    @Override
    @WebRemote
    public Result execute(String cookieSentByRPC, Action<?> action) throws ActionException, ServiceException
    {
        return dispatchService.execute(cookieSentByRPC, action);
    }

    @Override
    @WebRemote
    public void undo(String cookieSentByRPC, Action<Result> action, Result result) throws ActionException, ServiceException
    {
        dispatchService.undo(cookieSentByRPC, action, result);
    }

    /**
     * @author Florian Sauter
     */
    private class NonAbstractDispatchServiceImpl extends AbstractDispatchServiceImpl
    {

        protected String          securityCookieName;

        private static final long serialVersionUID = 3471758240308402503L;

        protected NonAbstractDispatchServiceImpl(Logger logger, Dispatch dispatch, RequestProvider requestProvider, String securityCookieName)
        {
            super(logger, dispatch, requestProvider);
            this.securityCookieName = securityCookieName;
        }

        @Override
        public String getSecurityCookieName()
        {
            return securityCookieName;
        }
    }
}
