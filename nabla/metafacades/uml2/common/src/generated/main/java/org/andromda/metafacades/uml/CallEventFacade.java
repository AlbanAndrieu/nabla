// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A representation of the model object 'Activity'. The specification of parameterized behavior as
 * the coordinated sequencing of subordinate units whose individual elements are actions.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface CallEventFacade
    extends EventFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isCallEventFacadeMetaType();

    /**
     * The operation called by this event.
     * @return OperationFacade
     */
    public OperationFacade getOperation();

    /**
     * The operations of this call event facade.  For UML 1.4 only one operation will be present,
     * for UML2, there can be more than one present.
     * @return Collection<OperationFacade>
     */
    public Collection<OperationFacade> getOperations();
}