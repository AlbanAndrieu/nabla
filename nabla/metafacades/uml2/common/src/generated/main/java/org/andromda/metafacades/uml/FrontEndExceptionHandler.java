// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A front-end exception handler intercepts exceptions and delegates them into a front-end action
 * state that will handle it (for example by simply displaying it if the action state happened to be
 * a view) .
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndExceptionHandler
    extends FrontEndForward
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndExceptionHandlerMetaType();

    /**
     * Indicatesif this element carries the FrontEndException stereotype.
     * @return boolean
     */
    public boolean isFrontEndException();
}