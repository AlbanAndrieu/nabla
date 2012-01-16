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
     * 
     * @return ClassifierFacade
     */
    public ClassifierFacade getType();
}