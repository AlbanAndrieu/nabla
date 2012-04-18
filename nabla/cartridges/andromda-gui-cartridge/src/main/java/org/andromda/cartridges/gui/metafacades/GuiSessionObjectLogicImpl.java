package org.andromda.cartridges.gui.metafacades;

import org.andromda.cartridges.gui.GuiGlobals;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiSessionObject.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiSessionObject
 */
public class GuiSessionObjectLogicImpl extends GuiSessionObjectLogic {
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiSessionObjectLogicImpl(final Object metaObject, final String context) {
        super(metaObject, context);
    }

    /**
     * @return GuiGlobals.SEPARATOR + getFullyQualifiedName().replace(".", GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiSessionObject#getFullPath()
     */
    @Override
    protected String handleGetFullPath() {
        return GuiGlobals.SEPARATOR + this.getFullyQualifiedName().replace(".", GuiGlobals.SEPARATOR);
    }
}
