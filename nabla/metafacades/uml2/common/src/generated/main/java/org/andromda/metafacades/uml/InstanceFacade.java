// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A representation of the model object 'Instance Specification'. Represents an instance in a
 * modeled system. Has the capability of being a deployment target in a deployment relationship, in
 * the case that it is an instance of a node. Has the capability of being a deployed artifact, if it
 * is an instance of an artifact.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface InstanceFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isInstanceFacadeMetaType();

    /**
     * Returns those slots that map onto attributes.
     * @return Collection<AttributeLinkFacade>
     */
    public Collection<AttributeLinkFacade> getAttributeLinks();

    /**
     * 
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getClassifiers();

    /**
     * Those slots that map onto association ends.
     * @return Collection<LinkEndFacade>
     */
    public Collection<LinkEndFacade> getLinkEnds();

    /**
     * 
     * @return Collection<InstanceFacade>
     */
    public Collection<InstanceFacade> getOwnedInstances();

    /**
     * 
     * @return Collection<LinkFacade>
     */
    public Collection<LinkFacade> getOwnedLinks();

    /**
     * All slots for this instance, this includes the ones that map onto attributes and the ones
     * that map onto association ends. In fact, this feature holds the collection of both
     * InstanceFacade.attributeLinks and InstanceFacade.linkEnds.
     * @return Collection<AttributeLinkFacade>
     */
    public Collection<AttributeLinkFacade> getSlots();
}