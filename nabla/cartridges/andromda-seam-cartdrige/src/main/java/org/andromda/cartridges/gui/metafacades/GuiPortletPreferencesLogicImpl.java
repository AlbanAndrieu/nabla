package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;

import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.UseCaseFacade;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiPortletPreferences.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiPortletPreferences
 */
public class GuiPortletPreferencesLogicImpl extends GuiPortletPreferencesLogic {
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiPortletPreferencesLogicImpl(final Object metaObject, final String context) {
        super(metaObject, context);
    }

    /**
     * @return useCase
     * @see org.andromda.cartridges.gui.metafacades.GuiPortletPreferences#getUseCase()
     */
    @Override
    protected Object handleGetUseCase() {
        UseCaseFacade useCase = null;
        final Collection<DependencyFacade> dependencies = this.getTargetDependencies();
        if ((dependencies != null) && !dependencies.isEmpty()) {
            for (final DependencyFacade dependency : dependencies) {
                final ModelElementFacade source = dependency.getSourceElement();
                if (source instanceof UseCaseFacade) {
                    useCase = (UseCaseFacade) source;
                    break;
                }
            }
        }
        return useCase;
    }
}
