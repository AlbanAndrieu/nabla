// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * An element in a model that contains a set of named elements that can be identified by name.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface NamespaceFacade
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isNamespaceFacadeMetaType();

    /**
     * Gets the model elements which this namespace owns.
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getOwnedElements();
}