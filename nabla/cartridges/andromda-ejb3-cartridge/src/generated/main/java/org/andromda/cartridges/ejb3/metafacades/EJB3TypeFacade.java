// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ClassifierFacade;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3TypeFacade
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3TypeFacadeMetaType();

    /**
     * Returns the fully qualified EJB3 type.
     * @return String
     */
    public String getFullyQualifiedEJB3Type();
}