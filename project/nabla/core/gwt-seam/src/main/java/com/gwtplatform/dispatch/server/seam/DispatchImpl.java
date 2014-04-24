package com.gwtplatform.dispatch.server.seam;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import com.gwtplatform.dispatch.server.AbstractDispatchImpl;
import com.gwtplatform.dispatch.server.Dispatch;
import com.gwtplatform.dispatch.server.actionhandlervalidator.ActionHandlerValidatorRegistry;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.ActionException;
import com.gwtplatform.dispatch.shared.Result;
import com.gwtplatform.dispatch.shared.ServiceException;

@AutoCreate
@Name("gwtpDispatchImpl")
public class DispatchImpl implements Dispatch
{

    @In
    private ActionHandlerValidatorRegistry gwtpActionHandlerValidatorRegistry;

    private NonAbstractDispatchImpl        nonAbstractDispatchImpl;

    @Create
    public void create()
    {
        nonAbstractDispatchImpl = new NonAbstractDispatchImpl(gwtpActionHandlerValidatorRegistry);
    }

    @Override
    public <A extends Action<R>, R extends Result> R execute(A action) throws ActionException, ServiceException
    {
        return nonAbstractDispatchImpl.execute(action);
    }

    @Override
    public <A extends Action<R>, R extends Result> void undo(A action, R result) throws ActionException, ServiceException
    {
        nonAbstractDispatchImpl.undo(action, result);
    }

    private class NonAbstractDispatchImpl extends AbstractDispatchImpl
    {
        protected NonAbstractDispatchImpl(ActionHandlerValidatorRegistry actionHandlerValidatorRegistry)
        {
            super(actionHandlerValidatorRegistry);
        }
    }
}
