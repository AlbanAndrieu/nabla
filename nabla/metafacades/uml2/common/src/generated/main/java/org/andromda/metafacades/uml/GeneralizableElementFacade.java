// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * The model element that represents an element that can be generalized or specialized.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GeneralizableElementFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGeneralizableElementFacadeMetaType();

    /**
     * Finds the tagged value optional searching the entire inheritance hierarchy if 'follow' is set
     * to true.
     * @param tagName String
     * @param follow boolean
     * @return Object
     */
    public Object findTaggedValue(String tagName, boolean follow);

    /**
     * All generalizations for this generalizable element, goes up the inheritance tree.
     * @return Collection<GeneralizableElementFacade>
     */
    public Collection<GeneralizableElementFacade> getAllGeneralizations();

    /**
     * All specializations (travels down the inheritance hierarchy).
     * @return Collection<GeneralizableElementFacade>
     */
    public Collection<GeneralizableElementFacade> getAllSpecializations();

    /**
     * Gets the direct generalization for this generalizable element.
     * @return GeneralizableElementFacade
     */
    public GeneralizableElementFacade getGeneralization();

    /**
     * Gets the actual links that this generalization element is part of (it plays either the
     * specialization or generalization).
     * @return Collection<GeneralizationFacade>
     */
    public Collection<GeneralizationFacade> getGeneralizationLinks();

    /**
     * A comma separated list of the fully qualified names of all generalizations.
     * @return String
     */
    public String getGeneralizationList();

    /**
     * The element found when you recursively follow the generalization path up to the root. If an
     * element has no generalization itself will be considered the root.
     * @return GeneralizableElementFacade
     */
    public GeneralizableElementFacade getGeneralizationRoot();

    /**
     * 
     * @return Collection<GeneralizableElementFacade>
     */
    public Collection<GeneralizableElementFacade> getGeneralizations();

    /**
     * Gets the direct specializations (i.e. sub elements) for this generalizatble element.
     * @return Collection<GeneralizableElementFacade>
     */
    public Collection<GeneralizableElementFacade> getSpecializations();
}