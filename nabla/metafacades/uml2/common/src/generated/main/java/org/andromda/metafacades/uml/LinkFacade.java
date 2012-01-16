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
public interface LinkFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isLinkFacadeMetaType();

    /**
     * The two links ends owned by this link.
     * @return Collection<LinkEndFacade>
     */
    public Collection<LinkEndFacade> getLinkEnds();
}