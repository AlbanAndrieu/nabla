package org.andromda.cartridges.gui.metafacades;

import org.andromda.cartridges.gui.GuiGlobals;
import org.andromda.utils.StringUtilsHelper;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.gui.metafacades.GuiEnumeration.
 *
 * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration
 */
public class GuiEnumerationLogicImpl extends GuiEnumerationLogic {
    private static final long serialVersionUID = 34L;

    /**
     * @param metaObject
     * @param context
     */
    public GuiEnumerationLogicImpl(final Object metaObject, final String context) {
        super(metaObject, context);
    }

    /**
     * @return converterName
     * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration#getConverterName()
     */
    @Override
    protected String handleGetConverterName() {
        return StringUtils.replace(ObjectUtils.toString(this.getConfiguredProperty(GuiGlobals.CONVERTER_PATTERN)), "{0}", this.getName());
    }

    /**
     * @return getPackageName() + "." + getConverterName()
     * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration#getFullyQualifiedConverterName()
     */
    @Override
    protected String handleGetFullyQualifiedConverterName() {
        return this.getPackageName() + "." + this.getConverterName();
    }

    /**
     * @return getFullyQualifiedConverterName().replace(".", GuiGlobals.SEPARATOR)
     * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration#getConverterPath()
     */
    @Override
    protected String handleGetConverterPath() {
        return this.getFullyQualifiedConverterName().replace(".", GuiGlobals.SEPARATOR);
    }

    /**
     * @return StringUtilsHelper.toResourceMessageKey(getName())
     * @see org.andromda.cartridges.gui.metafacades.GuiEnumeration#getMessageKey()
     */
    @Override
    protected String handleGetMessageKey() {
        return StringUtilsHelper.toResourceMessageKey(this.getName());
    }
}
