package org.andromda.cartridges.gui.metafacades;

import org.andromda.cartridges.gui.GuiGlobals;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiBackendService.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiBackendService
 */
public class GuiBackendServiceLogicImpl extends GuiBackendServiceLogic {
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiBackendServiceLogicImpl(final Object metaObject, final String context) {
        super(metaObject, context);
    }

    /**
     * @return accessorImplementation
     * @see org.andromda.cartridges.gui.metafacades.GuiBackendService#getAccessorImplementation()
     */
    @Override
    protected String handleGetAccessorImplementation() {
        final String accessorImplementation = String.valueOf(this.getConfiguredProperty(GuiGlobals.SERVICE_ACCESSOR_PATTERN));
        return accessorImplementation.replaceAll("\\{0\\}", this.getPackageName()).replaceAll("\\{1\\}", this.getName());
    }

    /**
     * @see org.andromda.metafacades.uml.ModelElementFacade#getFullyQualifiedName()
     */
    @Override
    public String getFullyQualifiedName() {
        final String packageName = String.valueOf(this.getConfiguredProperty(GuiGlobals.SERVICE_PACKAGE_NAME_PATTERN));
        return packageName.replaceAll("\\{0\\}", super.getPackageName()) + "." + this.getName();
    }
}
