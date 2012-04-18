package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;

import org.andromda.metafacades.uml.PseudostateFacade;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiActivityGraph.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiActivityGraph
 */
public class GuiActivityGraphLogicImpl extends GuiActivityGraphLogic {
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiActivityGraphLogicImpl(final Object metaObject, final String context) {
        super(metaObject, context);
    }

    @Override
    protected java.lang.Object handleGetFirstAction() {

        Object firstAction = null;
        final Collection<PseudostateFacade> initialStates = this.getInitialStates();

        if (!initialStates.isEmpty()) {

            final PseudostateFacade initialState = initialStates.iterator().next();
            final Collection outgoing = initialState.getOutgoings();

            firstAction = (outgoing.isEmpty()) ? null : outgoing.iterator().next();

        }

        return firstAction;

    }
}
