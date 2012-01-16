// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * Represents a service.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface Service
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isServiceMetaType();

    /**
     * Returns a collection of all entities this service and its ancestors have a relation to.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getAllEntityReferences();

    /**
     * All messaging destinations that belong to this service and all decendent services.
     * @return Collection<Destination>
     */
    public Collection<Destination> getAllMessagingDestinations();

    /**
     * All roles associated with the service, this includes both roles that have access to the
     * entire service, and any roles that have access to a single operation.
     * @return Collection<Role>
     */
    public Collection<Role> getAllRoles();

    /**
     * Returns a collection of all services this service and its ancestors have a relation to.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getAllServiceReferences();

    /**
     * References to all entities to which this service has a dependency.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getEntityReferences();

    /**
     * All messaging destinations available to this service.
     * @return Collection<Destination>
     */
    public Collection<Destination> getMessagingDestinations();

    /**
     * The roles of the service, these are the actor's that can access this service.
     * @return Collection<Role>
     */
    public Collection<Role> getRoles();

    /**
     * References to all services to which this service has a dependency.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getServiceReferences();
}