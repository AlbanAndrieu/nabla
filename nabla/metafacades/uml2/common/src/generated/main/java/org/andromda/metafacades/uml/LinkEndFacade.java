// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * Can be an AttributeLinkImpl or LinkEndImpl. A representation of the model object 'Slot'. A slot
 * specifies that an entity modeled by an instance specification has a value or values for a
 * specific structural feature.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface LinkEndFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isLinkEndFacadeMetaType();

    /**
     * The association end owned by this link.
     * @return AssociationEndFacade
     */
    public AssociationEndFacade getAssociationEnd();

    /**
     * The first instance to which this link end is attached.
     * @return InstanceFacade
     */
    public InstanceFacade getInstance();

    /**
     * The instances this link end is attached too. A link can have many instance values when its
     * defining feature is an association end with a 'many' multiplicity.
     * @return Collection<InstanceFacade>
     */
    public Collection<InstanceFacade> getInstances();

    /**
     * The link owning this link end.
     * @return LinkFacade
     */
    public LinkFacade getLink();
}