package com.gwtplatform.dispatch.server.seam;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.server.actionvalidator.ActionValidator;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.Result;

/**
 * 
 * @author Florian Sauter
 */
public interface HandlerRegistry
{

    <A extends Action<R>, R extends Result> void bindHandler(Class<A> actionClass, Class<? extends ActionHandler<A, R>> handlerClass);

    <A extends Action<R>, R extends Result> void bindHandler(Class<A> actionClass, Class<? extends ActionHandler<A, R>> handlerClass, Class<? extends ActionValidator> actionValidatorClass);
}
