package org.andromda.cartridges.jsf2.metafacades;


/**
 * MetafacadeLogic implementation for org.andromda.cartridges.jsf2.metafacades.JSFSessionObject.
 *
 * @see org.andromda.cartridges.jsf2.metafacades.JSFSessionObject
 */
public class JSFSessionObjectLogicImpl
    extends JSFSessionObjectLogic
{

    public JSFSessionObjectLogicImpl (Object metaObject, String context)
    {
        super (metaObject, context);
    }
    
    /**
     * @see org.andromda.cartridges.jsf2.metafacades.JSFSessionObject#getFullPath()
     */
    protected java.lang.String handleGetFullPath()
    {
        return '/' + this.getFullyQualifiedName().replace('.', '/');
    }
}