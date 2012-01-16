// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * A front-end event is represented by some kind of even on some kind of front-end (hyperlink,
 * submit button, etc).
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndEvent
    extends EventFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndEventMetaType();

    /**
     * The action which triggers the "front-end" event.
     * @return FrontEndAction
     */
    public FrontEndAction getAction();

    /**
     * The call to the controller for this front-end event (if any).
     * @return FrontEndControllerOperation
     */
    public FrontEndControllerOperation getControllerCall();

    /**
     * Gets all controller operation calls for the front-end event.
     * @return List<FrontEndControllerOperation>
     */
    public List<FrontEndControllerOperation> getControllerCalls();

    /**
     * Indicates whether or not this front end event is contained within a FrontEndUseCase.
     * @return boolean
     */
    public boolean isContainedInFrontEndUseCase();
}