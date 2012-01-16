// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * UML2 Stereotype attribute, UML14 TaggedValue.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface TaggedValueFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isTaggedValueFacadeMetaType();

    /**
     * The first value for this tagged value.
     * @return Object
     */
    public Object getValue();

    /**
     * The collection of values for this tagged value.
     * @return Collection<Object>
     */
    public Collection<Object> getValues();
}