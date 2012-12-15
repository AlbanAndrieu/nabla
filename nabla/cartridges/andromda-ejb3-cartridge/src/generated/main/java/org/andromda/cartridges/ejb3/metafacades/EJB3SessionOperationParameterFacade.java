// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ParameterFacade;

/**
 * TODO: Model Documentation for
 * org.andromda.cartridges.ejb3.metafacades.EJB3SessionOperationParameterFacade
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3SessionOperationParameterFacade
    extends ParameterFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3SessionOperationParameterFacadeMetaType();

    /**
     * Specifies that a parameter of the asynchronous call is the duration before the call is
     * processed (or first processed for recurring calls).
     * @return boolean
     */
    public boolean isSeamAsynchronousDuration();

    /**
     * Specifies that a parameter of the asynchronous call is the datetime at which the call is
     * processed (or first processed for recurring calls).
     * @return boolean
     */
    public boolean isSeamAsynchronousExpiration();

    /**
     * Specifies that an asynchronous method call recurs, and that the annotationed parameter is
     * duration between recurrences.
     * @return boolean
     */
    public boolean isSeamAsynchronousIntervalDuration();
}