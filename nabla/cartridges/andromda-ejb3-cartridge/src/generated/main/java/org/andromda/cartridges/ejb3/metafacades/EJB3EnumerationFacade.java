// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.EnumerationFacade;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3EnumerationFacade
    extends EnumerationFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3EnumerationFacadeMetaType();

    /**
     * Create a comma separated list of member variables. This method can be used to generate
     * argument lists for constructors, method calls etc.
     * @param variables Collection
     * @param includeTypes boolean
     * @param includeNames boolean
     * @return String
     */
    public String getMemberVariablesAsList(Collection variables, boolean includeTypes, boolean includeNames);
}