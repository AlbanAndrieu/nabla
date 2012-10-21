package com.gwtplatform.dispatch.server.seam.actionhandlervalidator;

import java.util.HashMap;
import java.util.Map;

import org.jboss.seam.Component;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import com.gwtplatform.dispatch.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.server.actionhandlervalidator.ActionHandlerValidatorClass;
import com.gwtplatform.dispatch.server.actionhandlervalidator.ActionHandlerValidatorInstance;
import com.gwtplatform.dispatch.server.actionhandlervalidator.ActionHandlerValidatorRegistry;
import com.gwtplatform.dispatch.server.actionvalidator.ActionValidator;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.Result;

import com.gwtplatform.dispatch.server.seam.HandlerRegistry;
import com.gwtplatform.dispatch.server.seam.actionvalidator.DefaultActionValidator;

@AutoCreate
@Scope(ScopeType.APPLICATION)
@Name("gwtpActionHandlerValidatorRegistry")
public class SeamActionHandlerValidatorRegistry implements ActionHandlerValidatorRegistry, HandlerRegistry
{

    private Map<Class<? extends Action<?>>, ActionHandlerValidatorClass<? extends Action<?>, ? extends Result>> actionHandlerValidatorClasses;

    @Create
    public void create()
    {
        actionHandlerValidatorClasses = new HashMap<Class<? extends Action<?>>, ActionHandlerValidatorClass<? extends Action<?>, ? extends Result>>();
    }

    @Override
    public void clearActionHandlerValidators()
    {
        // Nothing to clear (no caching)
    }

    @Override
    public <A extends Action<R>, R extends Result> void bindHandler(Class<A> actionClass, Class<? extends ActionHandler<A, R>> handlerClass)
    {
        ActionHandlerValidatorClass<A, R> handlerValidatorMap = new ActionHandlerValidatorClass<A, R>(handlerClass, DefaultActionValidator.class);
        actionHandlerValidatorClasses.put(actionClass, handlerValidatorMap);
    }

    @Override
    public <A extends Action<R>, R extends Result> void bindHandler(Class<A> actionClass, Class<? extends ActionHandler<A, R>> handlerClass, Class<? extends ActionValidator> actionValidatorClass)
    {
        ActionHandlerValidatorClass<A, R> handlerValidatorMap = new ActionHandlerValidatorClass<A, R>(handlerClass, actionValidatorClass);
        actionHandlerValidatorClasses.put(actionClass, handlerValidatorMap);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A extends Action<R>, R extends Result> ActionHandlerValidatorInstance findActionHandlerValidator(A action)
    {
        ActionHandlerValidatorInstance actionHandlerValidatorInstance = null;

        ActionHandlerValidatorClass<? extends Action<?>, ? extends Result> actionHandlerValidatorClass = actionHandlerValidatorClasses.get(action.getClass());
        if (actionHandlerValidatorClass != null)
        {
            ActionHandler<A, R> handler = (ActionHandler<A, R>) Component.getInstance(actionHandlerValidatorClass.getActionHandlerClass());
            ActionValidator validator = (ActionValidator) Component.getInstance(actionHandlerValidatorClass.getActionValidatorClass());
            actionHandlerValidatorInstance = new ActionHandlerValidatorInstance(validator, handler);
        }

        return actionHandlerValidatorInstance;
    }

    @Override
    public ActionValidator findActionValidator(Class<? extends ActionValidator> actionValidatorClass)
    {
        return (ActionValidator) Component.getInstance(actionValidatorClass);
    }
}
