// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A directed relationship between a source vertex and a target vertex. It may be part of a compound
 * transition, which takes the state machine from one state configuration to another, representing
 * the complete response of the state machine to an occurrence of an event of a particular type.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface TransitionFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isTransitionFacadeMetaType();

    /**
     * An action is a named element that is the fundamental unit of executable functionality. The
     * execution
     * of an action represents some transformation or processing in the modeled system, be it a
     * computer
     * system or otherwise. An action represents a single step within an activity, that is, one that
     * is not
     * further decomposed within the activity. An action has pre- and post-conditions.
     * @return ActionFacade
     */
    public ActionFacade getEffect();

    /**
     * A representation of the model object 'Constraint'. A condition or restriction expressed in
     * natural
     * language text or in a machine readable language for the purpose of declaring some of the
     * semantics
     * of an element.
     * @return GuardFacade
     */
    public GuardFacade getGuard();

    /**
     * A representation of the model object 'Vertex'. An abstraction of a node in a state machine
     * graph. In
     * general, it can be the source or destination of any number of transitions.
     * @return StateVertexFacade
     */
    public StateVertexFacade getSource();

    /**
     * A representation of the model object 'Vertex'. An abstraction of a node in a state machine
     * graph. In
     * general, it can be the source or destination of any number of transitions.
     * @return StateVertexFacade
     */
    public StateVertexFacade getTarget();

    /**
     * If a trigger is present on this transition, this event represents that trigger.
     * @return EventFacade
     */
    public EventFacade getTrigger();

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.enteringActionState
     * @return boolean
     */
    public boolean isEnteringActionState();

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.enteringDecisionPoint
     * @return boolean
     */
    public boolean isEnteringDecisionPoint();

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.enteringFinalState
     * @return boolean
     */
    public boolean isEnteringFinalState();

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.exitingActionState
     * @return boolean
     */
    public boolean isExitingActionState();

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.exitingDecisionPoint
     * @return boolean
     */
    public boolean isExitingDecisionPoint();

    /**
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TransitionFacade.exitingInitialState
     * @return boolean
     */
    public boolean isExitingInitialState();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.TransitionFacade.triggerPresent
     * @return boolean
     */
    public boolean isTriggerPresent();
}