// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * An include relationship defines that a use case contains the behavior defined in another use
 * case.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface IncludeFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isIncludeFacadeMetaType();

    /**
     * The specification of a set of actions performed by a system, which yields an observable
     * result that
     * is, typically, of value for one or more actors or other stakeholders of the system.
     * @return UseCaseFacade
     */
    public UseCaseFacade getAddition();

    /**
     * The specification of a set of actions performed by a system, which yields an observable
     * result that
     * is, typically, of value for one or more actors or other stakeholders of the system.
     * @return UseCaseFacade
     */
    public UseCaseFacade getBase();
}