package org.andromda.cartridges.jsf2.metafacades;

import org.andromda.cartridges.jsf2.JSFGlobals;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.andromda.utils.StringUtilsHelper;


/**
 * MetafacadeLogic implementation for org.andromda.cartridges.jsf2.metafacades.JSFEnumeration.
 *
 * @see org.andromda.cartridges.jsf2.metafacades.JSFEnumeration
 */
public class JSFEnumerationLogicImpl
    extends JSFEnumerationLogic
{

    public JSFEnumerationLogicImpl (Object metaObject, String context)
    {
        super (metaObject, context);
    }

    /**
     * @see org.andromda.cartridges.jsf2.metafacades.JSFEnumeration#getConverterName()
     */
    protected java.lang.String handleGetConverterName()
    {
        return StringUtils.replace(
            ObjectUtils.toString(this.getConfiguredProperty(JSFGlobals.CONVERTER_PATTERN)),
            "{0}",
            this.getName());
    }

    /**
     * @see org.andromda.cartridges.jsf2.metafacades.JSFEnumeration#getFullyQualifiedConverterName()
     */
    protected java.lang.String handleGetFullyQualifiedConverterName()
    {
        return this.getPackageName() + "." + this.getConverterName();
    }

    /**
     * @see org.andromda.cartridges.jsf2.metafacades.JSFEnumeration#getConverterPath()
     */
    protected String handleGetConverterPath()
    {
        return this.getFullyQualifiedConverterName().replace('.', '/');
    }

    /**
     * @see org.andromda.cartridges.jsf2.metafacades.JSFEnumeration#getMessageKey()
     */
    protected String handleGetMessageKey()
    {
        return StringUtilsHelper.toResourceMessageKey(getName());
    }

}