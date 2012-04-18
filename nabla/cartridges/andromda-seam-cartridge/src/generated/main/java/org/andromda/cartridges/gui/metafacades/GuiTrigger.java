// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import org.andromda.metafacades.uml.FrontEndEvent;

/**
 * A Gui trigger is represented by clicking a hyperlink or posting an action form.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiTrigger
    extends FrontEndEvent
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiTriggerMetaType();

    /**
     * If isActionTrigger() returns true them this association points to the action to which the
     * trigger has been associated.
     * @return GuiAction
     */
    public GuiAction getGuiAction();

    /**
     * The message key to use as a tooltip when the user is not allowed to use this trigger.
     * @return String
     */
    public String getNotAllowedTitleKey();

    /**
     * The message value to use as a tooltip when the user is not allowed to use this trigger.
     * @return String
     */
    public String getNotAllowedTitleValue();

    /**
     * The message key to use for reset button labels.
     * @return String
     */
    public String getResetMessageKey();

    /**
     * The message value to use for reset button labels.
     * @return String
     */
    public String getResetMessageValue();

    /**
     * Returns the message key to use as a tooltip when the user is not allowed to use reset the
     * form behind this trigger.
     * @return String
     */
    public String getResetNotAllowedTitleKey();

    /**
     * The message value to use as a tooltip when the user is not allowed to use reset the form
     * behind this trigger.
     * @return String
     */
    public String getResetNotAllowedTitleValue();

    /**
     * The message reset title key to use as a tooltip for this trigger's reset feature.
     * @return String
     */
    public String getResetTitleKey();

    /**
     * The tooltip value for this trigger's reset feature.
     * @return String
     */
    public String getResetTitleValue();

    /**
     * The message title key to use as a tooltip for this trigger.
     * @return String
     */
    public String getTitleKey();

    /**
     * The default resource message value  for this trigger's tooltip.
     * @return String
     */
    public String getTitleValue();

    /**
     * The message reset key for this trigger.
     * @return String
     */
    public String getTriggerKey();

    /**
     * The resource message value  for this trigger, this would be the button label or hyperlink
     * name.
     * @return String
     */
    public String getTriggerValue();

    /**
     * True if this trigger is modeled on an action transition. That means, the transition is coming
     * out of an action state with the FrontEndView stereotype. False otherwise.
     * @return boolean
     */
    public boolean isActionTrigger();
}