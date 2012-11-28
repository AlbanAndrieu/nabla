// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Identifies a point in the behavior of a use case where that behavior can be extended by the
 * behavior of some other (extending) use case, as specified by an extend relationship.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ExtensionPointFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isExtensionPointFacadeMetaType();

    /**
     * The specification of a set of actions performed by a system, which yields an observable
     * result that
     * is, typically, of value for one or more actors or other stakeholders of the system.
     * @return UseCaseFacade
     */
    public UseCaseFacade getUseCase();
}