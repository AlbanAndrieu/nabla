// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * State machines can be used to express the behavior of part of a system. Behavior is modeled as a
 * traversal of a graph of state nodes interconnected by one or more joined transition arcs that are
 * triggered by the dispatching of series of (event) occurrences. During this traversal, the state
 * machine executes a series of activities associated with various elements of the state machine.
 * Not implmented for UML2.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface SubactivityStateFacade
    extends StateFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isSubactivityStateFacadeMetaType();

    /**
     * State machines can be used to express the behavior of part of a system. Behavior is modeled
     * as a
     * traversal of a graph of state nodes interconnected by one or more joined transition arcs that
     * are
     * triggered by the dispatching of series of (event) occurrences. During this traversal, the
     * state
     * machine executes a series of activities associated with various elements of the state
     * machine.
     * @return StateMachineFacade
     */
    public StateMachineFacade getSubmachine();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.SubactivityStateFacade.dynamic
     * @return boolean
     */
    public boolean isDynamic();
}