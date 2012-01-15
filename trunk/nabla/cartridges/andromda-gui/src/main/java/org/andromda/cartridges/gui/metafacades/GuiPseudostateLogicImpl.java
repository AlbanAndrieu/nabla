// license-header java merge-point
//
// Generated by: MetafacadeLogicImpl.vsl in andromda-meta-cartridge.
package org.andromda.cartridges.gui.metafacades;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.andromda.metafacades.uml.ActivityGraphFacade;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.UseCaseFacade;
import org.andromda.utils.StringUtilsHelper;

/**
 * Encapsulates a pseudostate and provides specific Gui services. This pseudostate can be a
 * decision point, junction or initial state.
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiPseudostate.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiPseudostate
 */
public class GuiPseudostateLogicImpl extends GuiPseudostateLogic {
    private static final long serialVersionUID = 34L;

    /**
     * Public constructor for GuiPseudostateLogicImpl
     * @see org.andromda.cartridges.gui.metafacades.GuiPseudostate
     */
    public GuiPseudostateLogicImpl(final Object metaObject, final String context) {
        super(metaObject, context);
    }

    /**
     * @return getStateMachine() instanceof GuiActivityGraph
     */
    protected boolean handleIsContainedInFrontEndUseCase() {
        return this.getStateMachine() instanceof GuiActivityGraph;
    }

    /**
     * @return actionMethodName
     * @see org.andromda.cartridges.gui.metafacades.GuiPseudostate#getActionMethodName()
     */
    @Override
    protected String handleGetActionMethodName() {
        final String methodName = this.getName();
        return (methodName == null) ? "a" + System.currentTimeMillis() : StringUtilsHelper.lowerCamelCaseName(methodName);
    }

    /**
     * Overridden and not typesafe since GuiAction does not extend FrontEndAction
     *
     * @see org.andromda.metafacades.uml.FrontEndPseudostate#getContainerActions()
     */
    @Override
    public List getContainerActions() {
        final Set<GuiAction> actionSet = new LinkedHashSet<GuiAction>();
        final StateMachineFacade graphContext = this.getStateMachine();

        if (graphContext instanceof ActivityGraphFacade) {
            final UseCaseFacade useCase = ((ActivityGraphFacade) graphContext).getUseCase();

            if (useCase instanceof GuiUseCase) {
                // GuiUseCase.getActions returns GuiAction which cannot be cast to FrontEndAction
                for (final Object action : ((GuiUseCaseLogicImpl) useCase).getActions()) {
                    for (final FrontEndForward transition : ((GuiAction) action).getTransitions()) {
                        if (this.equals(transition.getTarget())) {
                            actionSet.add((GuiAction) action);
                        }
                    }
                }
            }
        }
        // Cannot make return type List<GuiAction> because GuiAction does not extend FrontEndAction
        return new ArrayList<GuiAction>(actionSet);
    }
}
