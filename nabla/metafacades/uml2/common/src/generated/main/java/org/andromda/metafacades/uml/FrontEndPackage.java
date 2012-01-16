// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.List;

/**
 * Represents a package storing "front-end" components.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface FrontEndPackage
    extends PackageFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isFrontEndPackageMetaType();

    /**
     * The "front-end" controllers belonging to this package.
     * @return List<FrontEndController>
     */
    public List<FrontEndController> getFrontEndControllers();

    /**
     * The use cases that make up the "front-end".
     * @return List<FrontEndAction>
     */
    public List<FrontEndAction> getFrontEndUseCases();
}