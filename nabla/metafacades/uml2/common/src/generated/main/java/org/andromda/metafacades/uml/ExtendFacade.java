// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * A relationship from an extending use case to an extended use case that specifies how and when the
 * behavior defined in the extending use case can be inserted into the behavior defined in the
 * extended use case.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ExtendFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isExtendFacadeMetaType();

    /**
     * The base use-case.
     * @return UseCaseFacade
     */
    public UseCaseFacade getBase();

    /**
     * The extension use-case.
     * @return UseCaseFacade
     */
    public UseCaseFacade getExtension();

    /**
     * The extension points.
     * @return List<ExtensionPointFacade>
     */
    public List<ExtensionPointFacade> getExtensionPoints();
}