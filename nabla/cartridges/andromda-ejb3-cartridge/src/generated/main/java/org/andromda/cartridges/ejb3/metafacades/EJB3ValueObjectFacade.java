// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ValueObject;

/**
 * Represents the EJB3 representation of the Value Object.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3ValueObjectFacade
    extends ValueObject
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3ValueObjectFacadeMetaType();

    /**
     * Returns the Seam component name for the class.
     * @return String
     */
    public String getSeamComponentName();

    /**
     * Returns the seam component scope type if one is specified.
     * @return String
     */
    public String getSeamComponentScopeType();

    /**
     * Returns true if this value object has the <<Seam>> stereotype modeled indicating it is a Seam
     * component.
     * @return boolean
     */
    public boolean isSeamComponent();
}