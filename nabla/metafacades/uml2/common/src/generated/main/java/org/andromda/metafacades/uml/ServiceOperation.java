// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * Reprsents an operation of a service.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ServiceOperation
    extends OperationFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isServiceOperationMetaType();

    /**
     * The destination for any incoming messages.
     * @return Destination
     */
    public Destination getIncomingDestination();

    /**
     * The destination for any outgoing messages.
     * @return Destination
     */
    public Destination getOutgoingDestination();

    /**
     * The users of the service operation, these are the actor's that can access this operation.
     * @return Collection<Role>
     */
    public Collection<Role> getRoles();

    /**
     * The service which owns the service operation.
     * @return Service
     */
    public Service getService();

    /**
     * Whether or not this operation represents an "incoming" message operation (i.e. it receives
     * messages from Queues or Topics).
     * @return boolean
     */
    public boolean isIncomingMessageOperation();

    /**
     * Whether or not this is operation accepts incoming or outgoing messages.
     * @return boolean
     */
    public boolean isMessageOperation();

    /**
     * Whether or not this service operation represents an "outgoing" messaging operation (i.e. it
     * sends messages to Queues or Topics).
     * @return boolean
     */
    public boolean isOutgoingMessageOperation();
}