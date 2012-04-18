package org.andromda.cartridges.gui.metafacades;

import org.andromda.cartridges.gui.GuiGlobals;
import org.andromda.utils.StringUtilsHelper;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiEvent.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiEvent
 */
public class GuiEventLogicImpl extends GuiEventLogic {
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiEventLogicImpl(final Object metaObject, final String context) {
        super(metaObject, context);
    }

    /**
     * @return triggerKey
     * @see org.andromda.cartridges.gui.metafacades.GuiEvent#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey() {
        String triggerKey = StringUtilsHelper.toResourceMessageKey(this.getName());
        if (!this.isNormalizeMessages()) {
            final GuiAction action = (GuiAction) this.getAction();
            if (action != null) {
                final GuiView view = (GuiView) action.getInput();
                if (view != null) {
                    triggerKey = view.getMessageKey() + "." + triggerKey;
                }
            }
        }
        return triggerKey;
    }

    /**
     * @return StringUtilsHelper.toPhrase(this.getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiEvent#getMessageValue()
     */
    @Override
    protected String handleGetMessageValue() {
        return StringUtilsHelper.toPhrase(this.getName());
    }

    /**
     * @return "Reset"
     * @see org.andromda.cartridges.gui.metafacades.GuiEvent#getResetMessageValue()
     */
    @Override
    protected String handleGetResetMessageValue() {
        return "Reset";
    }

    /**
     * @return getMessageKey() + ".reset.message"
     * @see org.andromda.cartridges.gui.metafacades.GuiEvent#getResetMessageKey()
     */
    @Override
    protected String handleGetResetMessageKey() {
        return this.getMessageKey() + ".reset.message";
    }

    /**
     * Indicates whether or not we should normalize messages.
     * @return normalizeMessages true/false
     */
    private boolean isNormalizeMessages() {
        final String normalizeMessages = (String) this.getConfiguredProperty(GuiGlobals.NORMALIZE_MESSAGES);
        return Boolean.valueOf(normalizeMessages).booleanValue();
    }
}
