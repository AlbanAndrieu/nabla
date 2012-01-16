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
     * 
     * @return String
     */
    public String getBody();

    /**
     * 
     * @return TransitionFacade
     */
    public TransitionFacade getTransition();
}