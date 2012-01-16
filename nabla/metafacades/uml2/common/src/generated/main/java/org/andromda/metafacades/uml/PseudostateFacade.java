// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

/**
 * An abstraction that encompasses different types of transient vertices in the state machine graph.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface PseudostateFacade
    extends StateVertexFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isPseudostateFacadeMetaType();

    /**
     * 
     * @return boolean
     */
    public boolean isChoice();

    /**
     * Denotes this pseudostate to be either a join or a fork with a single outgoing transition and
     * more than one incoming transition.
     * @return boolean
     */
    public boolean isCollect();

    /**
     * 
     * @return boolean
     */
    public boolean isDecisionPoint();

    /**
     * 
     * @return boolean
     */
    public boolean isDeepHistory();

    /**
     * 
     * @return boolean
     */
    public boolean isFork();

    /**
     * 
     * @return boolean
     */
    public boolean isInitialState();

    /**
     * 
     * @return boolean
     */
    public boolean isJoin();

    /**
     * 
     * @return boolean
     */
    public boolean isJunction();

    /**
     * 
     * @return boolean
     */
    public boolean isMergePoint();

    /**
     * 
     * @return boolean
     */
    public boolean isShallowHistory();

    /**
     * Denotes this pseudostate to be either a join or a fork with a single incoming transition and
     * more than one outgoing transition.
     * @return boolean
     */
    public boolean isSplit();
}