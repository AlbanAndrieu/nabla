// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * Represents a value object, a Classifier whose unique value is determined only by its attributes.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ValueObject
    extends ClassifierFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isValueObjectMetaType();

    /**
     * Find all descendant children with the same ValueObject type. Used by WebServices to create
     * XmlSeeAlso references to Xml descendant types.
     * @return Collection<ValueObject>
     */
    public Collection<ValueObject> getTypeSpecializations();
}