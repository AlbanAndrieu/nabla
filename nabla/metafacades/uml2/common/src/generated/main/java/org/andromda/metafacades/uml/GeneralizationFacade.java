// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A taxonomic relationship between a more general classifier and a more specific classifier. Each
 * instance of the specific classifier is also an indirect instance of the general classifier. Thus,
 * the specific classifier inherits the features of the more general classifier. A generalization
 * relates a specific classifier to a more general classifier, and is owned by the specific
 * classifier.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GeneralizationFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGeneralizationFacadeMetaType();

    /**
     * 
     * @return GeneralizableElementFacade
     */
    public GeneralizableElementFacade getChild();

    /**
     * 
     * @return GeneralizableElementFacade
     */
    public GeneralizableElementFacade getParent();
}