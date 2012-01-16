// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * A front end controller is assigned as the context of a use-case. The controller provides the
 * "controlling" of the use case's activity.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndController
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndControllerMetaType();

    /**
     * All actions that defer to at least one operation of this controller.
     * @return List<FrontEndAction>
     */
    public List<FrontEndAction> getDeferringActions();

    /**
     * Returns all back-end services referenced by this controller.
     * @return List<DependencyFacade>
     */
    public List<DependencyFacade> getServiceReferences();

    /**
     * Returns the use-case "controlled" by this controller.
     * @return FrontEndUseCase
     */
    public FrontEndUseCase getUseCase();
}