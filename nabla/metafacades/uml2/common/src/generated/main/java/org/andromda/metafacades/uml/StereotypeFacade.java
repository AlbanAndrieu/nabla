// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Defines how an existing metaclass may be extended, and enables the use of platform or domain
 * specific terminology or notation in place of, or in addition to, the ones used for the extended
 * metaclass.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface StereotypeFacade
    extends GeneralizableElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isStereotypeFacadeMetaType();
}