// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * The specification of a set of actions performed by a system, which yields an observable result
 * that is, typically, of value for one or more actors or other stakeholders of the system.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface UseCaseFacade
    extends NamespaceFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isUseCaseFacadeMetaType();

    /**
     * The extend instances related to this use-case.
     * @return Collection<ExtendFacade>
     */
    public Collection<ExtendFacade> getExtends();

    /**
     * Identifies a point in the behavior of a use case where that behavior can be extended by the
     * behavior
     * of some other (extending) use case, as specified by an extend relationship.
     * @return Collection<ExtensionPointFacade>
     */
    public Collection<ExtensionPointFacade> getExtensionPoints();

    /**
     * The first activity graph directly owned by this use-case.
     * @return ActivityGraphFacade
     */
    public ActivityGraphFacade getFirstActivityGraph();

    /**
     * An include relationship defines that a use case contains the behavior defined in another use
     * case.
     * @return Collection<IncludeFacade>
     */
    public Collection<IncludeFacade> getIncludes();
}