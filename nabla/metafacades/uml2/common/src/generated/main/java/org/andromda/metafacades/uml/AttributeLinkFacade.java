// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A representation of the model object 'Slot'. A slot specifies that an entity modeled by an
 * instance specification has a value or values for a specific structural feature.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface AttributeLinkFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isAttributeLinkFacadeMetaType();

    /**
     * The attribute for this link.
     * @return AttributeFacade
     */
    public AttributeFacade getAttribute();

    /**
     * The owning instance for this link.
     * @return InstanceFacade
     */
    public InstanceFacade getInstance();

    /**
     * The first instance value for this link.
     * @return InstanceFacade
     */
    public InstanceFacade getValue();

    /**
     * The instances this attribute link is attached too. An attribute link can have many instance
     * values when its defining feature is an attribute with a 'many' multiplicity.
     * @return Collection<InstanceFacade>
     */
    public Collection<InstanceFacade> getValues();
}