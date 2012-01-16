// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Represents a role a user may play within a system.  Provides access to things such as services
 * and service operations.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface Role
    extends ActorFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isRoleMetaType();

    /**
     * Indicates if the necessary references are present for the Role.  This include any references
     * to a service, service operation or use case.
     * @return boolean
     */
    public boolean isReferencesPresent();
}