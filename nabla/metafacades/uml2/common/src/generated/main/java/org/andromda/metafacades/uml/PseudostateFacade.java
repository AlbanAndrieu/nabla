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
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.choice
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
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.decisionPoint
     * @return boolean
     */
    public boolean isDecisionPoint();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.deepHistory
     * @return boolean
     */
    public boolean isDeepHistory();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.fork
     * @return boolean
     */
    public boolean isFork();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.initialState
     * @return boolean
     */
    public boolean isInitialState();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.join
     * @return boolean
     */
    public boolean isJoin();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.junction
     * @return boolean
     */
    public boolean isJunction();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.mergePoint
     * @return boolean
     */
    public boolean isMergePoint();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.shallowHistory
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