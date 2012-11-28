// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A representation of the model object 'Constraint'. A condition or restriction expressed in
 * natural language text or in a machine readable language for the purpose of declaring some of the
 * semantics of an element.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuardFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuardFacadeMetaType();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.GuardFacade.body
     * @return String
     */
    public String getBody();

    /**
     * A directed relationship between a source vertex and a target vertex. It may be part of a
     * compound
     * transition, which takes the state machine from one state configuration to another,
     * representing the
     * complete response of the state machine to an occurrence of an event of a particular type.
     * @return TransitionFacade
     */
    public TransitionFacade getTransition();
}