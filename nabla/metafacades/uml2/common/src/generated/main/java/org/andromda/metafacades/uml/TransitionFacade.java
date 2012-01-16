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
     * 
     * @return ActionFacade
     */
    public ActionFacade getEffect();

    /**
     * 
     * @return GuardFacade
     */
    public GuardFacade getGuard();

    /**
     * 
     * @return StateVertexFacade
     */
    public StateVertexFacade getSource();

    /**
     * 
     * @return StateVertexFacade
     */
    public StateVertexFacade getTarget();

    /**
     * If a trigger is present on this transition, this event represents that trigger.
     * @return EventFacade
     */
    public EventFacade getTrigger();

    /**
     * 
     * @return boolean
     */
    public boolean isEnteringActionState();

    /**
     * 
     * @return boolean
     */
    public boolean isEnteringDecisionPoint();

    /**
     * 
     * @return boolean
     */
    public boolean isEnteringFinalState();

    /**
     * 
     * @return boolean
     */
    public boolean isExitingActionState();

    /**
     * 
     * @return boolean
     */
    public boolean isExitingDecisionPoint();

    /**
     * 
     * @return boolean
     */
    public boolean isExitingInitialState();

    /**
     * 
     * @return boolean
     */
    public boolean isTriggerPresent();
}