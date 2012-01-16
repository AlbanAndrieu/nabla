// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * Models a situation during which some (usually implicit) invariant condition holds. The states of
 * protocol state machines are exposed to the users of their context classifiers. A protocol state
 * represents an exposed stable situation of its context classifier: when an instance of the
 * classifier is not processing any operation, users of this instance can always know its state
 * configuration.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface StateFacade
    extends StateVertexFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isStateFacadeMetaType();

    /**
     * Events to which is being deferred in this action state.
     * @return Collection<EventFacade>
     */
    public Collection<EventFacade> getDeferrableEvents();
}