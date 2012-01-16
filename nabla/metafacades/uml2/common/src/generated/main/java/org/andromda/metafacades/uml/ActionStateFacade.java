// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A state models a situation during which some (usually implicit) invariant condition holds. The
 * states of protocol state machines are exposed to the users of their context classifiers. A
 * protocol state represents an exposed stable situation of its context classifier: when an instance
 * of the classifier is not processing any operation, users of this instance can always know its
 * state configuration.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ActionStateFacade
    extends StateFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isActionStateFacadeMetaType();

    /**
     * The entry action for this action state (if any).
     * @return ActionFacade
     */
    public ActionFacade getEntry();
}