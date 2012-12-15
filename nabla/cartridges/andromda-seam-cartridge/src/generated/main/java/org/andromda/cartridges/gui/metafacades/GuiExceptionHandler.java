// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.FrontEndExceptionHandler;

/**
 * A Gui exception handler intercepts action exceptions and delegates them into a page that will
 * handle it, by for example simply displaying it.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiExceptionHandler
    extends FrontEndExceptionHandler
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiExceptionHandlerMetaType();

    /**
     * The key to use with this handler's message resource bundle that will retrieve the error
     * message template for this exception.
     * @return String
     */
    public String getExceptionKey();

    /**
     * The module-relative URI to the resource that will complete the request/response if this
     * exception occurs.
     * @return String
     */
    public String getExceptionPath();

    /**
     * Fully qualified Java class name of the exception type to register with this handler.
     * @return String
     */
    public String getExceptionType();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiExceptionHandler.messageKey
     * @return String
     */
    public String getMessageKey();
}