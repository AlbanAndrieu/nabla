// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Map;
import org.andromda.metafacades.uml.FrontEndForward;

/**
 * A Gui forward is any transition between states.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiForward
    extends FrontEndForward
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiForwardMetaType();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiForward.errorMessages
     * @return Map
     */
    public Map getErrorMessages();

    /**
     * The name for this forward. This name is always lowercase and words are separated using dots,
     * not unlike the convention for Java package names.
     * @return String
     */
    public String getForwardName();

    /**
     * Returns the path targetted by this forward.
     * @return String
     */
    public String getForwardPath();

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @return String
     */
    public String getFromOutcome();

    /**
     * If this forward is guarded (such as with decision points) this method return the name of that
     * guard.
     * @return String
     */
    public String getGuardName();

    /**
     * Returns the activity graph which holds this action if the graph is contained in a
     * FrontEndUseCase.
     * @return GuiActivityGraph
     */
    public GuiActivityGraph getGuiActivityGraph();

    /**
     * The path to which this forward points.
     * @return String
     */
    public String getPath();

    /**
     * A map of key=value pairs, one for each success message.
     * @return Map
     */
    public Map getSuccessMessages();

    /**
     * The resource bundle key of the name for the target element. This method returns the key for
     * the use-case orview page. If targetting anything else this method returns null.
     * @return String
     */
    public String getTargetNameKey();

    /**
     * A map of key=value pairs, one for each warning message.
     * @return Map
     */
    public Map getWarningMessages();

    /**
     * True if this action directly targets a view page, false otherwise.
     * @return boolean
     */
    public boolean isEnteringPage();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiForward.errorMessagesPresent
     * @return boolean
     */
    public boolean isErrorMessagesPresent();

    /**
     * Whether or not this forward (transition) is coming out of a page.
     * @return boolean
     */
    public boolean isExitingPage();

    /**
     * Indicates whether or not a final state is the target of this forward.
     * @return boolean
     */
    public boolean isFinalStateTarget();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiForward.successMessagesPresent
     * @return boolean
     */
    public boolean isSuccessMessagesPresent();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiForward.warningMessagesPresent
     * @return boolean
     */
    public boolean isWarningMessagesPresent();
}