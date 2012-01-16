// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * An actor specifies a role played by a user or any other system that interacts with the subject.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ActorFacade
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isActorFacadeMetaType();

    /**
     * All actors generalized by this actor.
     * @return List<ActorFacade>
     */
    public List<ActorFacade> getGeneralizedActors();

    /**
     * The set of actors that generalize this actor.
     * @return List<ActorFacade>
     */
    public List<ActorFacade> getGeneralizedByActors();
}