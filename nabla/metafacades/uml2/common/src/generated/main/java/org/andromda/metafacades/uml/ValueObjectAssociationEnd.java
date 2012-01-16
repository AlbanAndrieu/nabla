// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * Represents the association end of a ValueObject.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ValueObjectAssociationEnd
    extends AssociationEndFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isValueObjectAssociationEndMetaType();

    /**
     * Indicates if the type of this association is a value object or not.
     * @return boolean
     */
    public boolean isValueObjectType();
}