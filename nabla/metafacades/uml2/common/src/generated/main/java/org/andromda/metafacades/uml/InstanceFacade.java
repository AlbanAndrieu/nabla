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
     * A Classifier is a classification of instances - it describes a set of instances that have
     * features
     * in common. Can specify a generalization hierarchy by referencing its general classifiers. It
     * may be
     * a Class, DataType, PrimitiveType, Association, Collaboration, UseCase, etc. Can specify a
     * generalization hierarchy by referencing its general classifiers. Has the capability to own
     * collaboration uses. These collaboration uses link a collaboration with the classifier to give
     * a
     * description of the workings of the classifier. Classifier is defined to be a kind of
     * templateable
     * element so that a classifier can be parameterized. It is also defined to be a kind of
     * parameterable
     * element so that a classifier can be a formal template parameter.
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getClassifiers();

    /**
     * Those slots that map onto association ends.
     * @return Collection<LinkEndFacade>
     */
    public Collection<LinkEndFacade> getLinkEnds();

    /**
     * A representation of the model object 'Instance Specification'. Represents an instance in a
     * modeled
     * system. Has the capability of being a deployment target in a deployment relationship, in the
     * case
     * that it is an instance of a node. Has the capability of being a deployed artifact, if it is
     * an
     * instance of an artifact.
     * @return Collection<InstanceFacade>
     */
    public Collection<InstanceFacade> getOwnedInstances();

    /**
     * A representation of the model object 'Instance Specification'. Represents an instance in a
     * modeled
     * system. Has the capability of being a deployment target in a deployment relationship, in the
     * case
     * that it is an instance of a node. Has the capability of being a deployed artifact, if it is
     * an
     * instance of an artifact.
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