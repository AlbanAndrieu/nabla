// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A representation of the model object 'Directed Relationship'.Represents a relationship between a
 * collection of source model elements and a collection of target model elements, a
 * dependency/reference.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface DependencyFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isDependencyFacadeMetaType();

    /**
     * The "getter" name for this dependency.
     * @return String
     */
    public String getGetterName();

    /**
     * The "setter" name for this dependency.
     * @return String
     */
    public String getSetterName();

    /**
     * The source element of this dependency.
     * @return ModelElementFacade
     */
    public ModelElementFacade getSourceElement();

    /**
     * Gets the element to which the dependencies belong.
     * @return ModelElementFacade
     */
    public ModelElementFacade getTargetElement();
}