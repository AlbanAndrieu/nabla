package org.andromda.cartridges.seam.metafacades;

import org.andromda.metafacades.uml.EventFacade;
import org.andromda.utils.StringUtilsHelper;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.seam.metafacades.SeamAction.
 *
 * @see org.andromda.cartridges.seam.metafacades.SeamAction
 */
public class SeamActionLogicImpl extends SeamActionLogic
{

    public SeamActionLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see org.andromda.cartridges.jsf.metafacades.JSFAction#getTriggerMethodName()
     */
    @Override
    public String getTriggerMethodName()
    {
        final StringBuilder methodName = new StringBuilder();
        if (this.isExitingInitialState())
        {
            final SeamUseCase useCase = (SeamUseCase) this.getUseCase();
            methodName.append(StringUtilsHelper.lowerCamelCaseName(useCase.getName()) + "_started");
        } else
        {
            methodName.append(StringUtilsHelper.lowerCamelCaseName(this.getSource().getName()));
            methodName.append('_');
            final EventFacade trigger = this.getTrigger();
            final String suffix = trigger == null ? this.getTarget().getName() : trigger.getName();
            methodName.append(StringUtilsHelper.lowerCamelCaseName(suffix));
        }
        return "_" + methodName.toString();
    }

}
