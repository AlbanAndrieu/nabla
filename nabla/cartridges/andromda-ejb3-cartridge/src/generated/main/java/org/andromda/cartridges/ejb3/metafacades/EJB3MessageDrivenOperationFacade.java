// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ServiceOperation;

/**
 * TODO: Model Documentation for
 * org.andromda.cartridges.ejb3.metafacades.EJB3MessageDrivenOperationFacade
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3MessageDrivenOperationFacade
    extends ServiceOperation
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3MessageDrivenOperationFacadeMetaType();

    /**
     * Returns true if the associated operation has the <<PostConstruct>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPostConstruct();

    /**
     * Returns true if the associated operation has the <<PreDestroy>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPreDestroy();
}