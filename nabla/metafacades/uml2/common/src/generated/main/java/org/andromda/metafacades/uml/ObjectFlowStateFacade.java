// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * A representation of the model object 'Object Flow'. An object flow is an activity edge that can
 * have objects or data passing along it. Object flows have support for multicast/receive, token
 * selection from object nodes, and transformation of tokens. Not implemented in UML2.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ObjectFlowStateFacade
    extends StateFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isObjectFlowStateFacadeMetaType();

    /**
     * A Classifier is a classification of instances - it describes a set of instances that have
     * features in common. Can specify a generalization hierarchy by referencing its general
     * classifiers. It may be a Class, DataType, PrimitiveType, Association, Collaboration, UseCase,
     * etc. Can specify a generalization hierarchy by referencing its general classifiers. Has the
     * capability to own collaboration uses. These collaboration uses link a collaboration with the
     * classifier to give a description of the workings of the classifier. Classifier is defined to
     * be a kind of templateable element so that a classifier can be parameterized. It is also
     * defined to be a kind of parameterable element so that a classifier can be a formal template
     * parameter.
     * @return ClassifierFacade
     */
    public ClassifierFacade getType();
}