// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ClassifierFacade;

/**
 * TODO: Model Documentation for org.andromda.cartridges.ejb3.metafacades.EJB3EmbeddedValueFacade
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3EmbeddedValueFacade
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3EmbeddedValueFacadeMetaType();

    /**
     * Returns the fully qualified name of the embeddable value implementation class.
     * @return String
     */
    public String getFullyQualifiedImplementationName();

    /**
     * Returns the name of the implementation class.
     * @return String
     */
    public String getImplementationName();

    /**
     * Returns true if the embedded value object is immutable.
     * @return boolean
     */
    public boolean isImmutable();
}