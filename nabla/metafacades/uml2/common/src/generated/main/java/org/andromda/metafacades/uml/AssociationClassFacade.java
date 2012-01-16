// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A model element that has both association and class properties. An AssociationClass can be seen
 * as an association that also has class properties, or as a class that also has association
 * properties. It not only connects a set of classifiers but also defines a set of features that
 * belong to the relationship itself and not to any of the classifiers.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface AssociationClassFacade
    extends AssociationFacade, ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isAssociationClassFacadeMetaType();

    /**
     * The association ends visible to this association class.
     * @return Collection<AssociationEndFacade>
     */
    public Collection<AssociationEndFacade> getConnectionAssociationEnds();
}