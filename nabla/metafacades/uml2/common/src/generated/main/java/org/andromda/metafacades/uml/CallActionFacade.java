// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A representation of the model object 'Call Operation Action'. An action that transmits an
 * operation call request to the target object, where it may cause the invocation of associated
 * behavior. The argument values of the action are available to the execution of the invoked
 * behavior. If the action is marked synchronous, the execution of the call operation action waits
 * until the execution of the invoked behavior completes and a reply transmission is returned to the
 * caller; otherwise execution of the action is complete when the invocation of the operation is
 * established and the execution of the invoked operation proceeds concurrently with the execution
 * of the calling behavior. Any values returned as part of the reply transmission are put on the
 * result output pins of the call operation action. Upon receipt of the reply transmission,
 * execution of the call operation action is complete.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface CallActionFacade
    extends ActionFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isCallActionFacadeMetaType();

    /**
     * The operation called by this action.
     * @return OperationFacade
     */
    public OperationFacade getOperation();
}