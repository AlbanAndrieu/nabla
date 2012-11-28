// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A signature containing the template parameters for the templated element (Class, operation,
 * property, etc). A template signature bundles the set of formal template parameters for a
 * templated element.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface RedefinableTemplateSignatureFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isRedefinableTemplateSignatureFacadeMetaType();

    /**
     * The Class which is templated.
     * @return ClassifierFacade
     */
    public ClassifierFacade getClassifier();
}