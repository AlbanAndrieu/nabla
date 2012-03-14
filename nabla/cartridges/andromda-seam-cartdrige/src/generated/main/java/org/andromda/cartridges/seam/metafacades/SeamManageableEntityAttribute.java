// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import org.andromda.metafacades.uml.ManageableEntityAttribute;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface SeamManageableEntityAttribute
    extends ManageableEntityAttribute
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isSeamManageableEntityAttributeMetaType();

    /**
     * The String format to use when referring to this date, only makes sense when the type is a
     * date type.
     * @return String
     */
    public String getDateFormat();

    /**
     * The number of columns for this field, null if default browser value is desired.
     * @return Integer
     */
    public Integer getFieldColumnCount();

    /**
     * The number of rows for this field, null if default browser value is desired.
     * @return Integer
     */
    public Integer getFieldRowCount();

    /**
     * 
     * @return String
     */
    public String getMessageKey();

    /**
     * 
     * @return String
     */
    public String getMessageValue();

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return String
     */
    public String getOnlineHelpKey();

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return String
     */
    public String getOnlineHelpValue();

    /**
     * The widget to use when rendering this attribute
     * @return String
     */
    public String getWidgetType();

    /**
     * Whether or not this attribute should be hidden from the view
     * @return boolean
     */
    public boolean isHidden();

    /**
     * True if this attribute is of a type that cannot easily be represented as a textual string and
     * would be an ideal candidate for HTTP's support for file-upload.
     * @return boolean
     */
    public boolean isNeedsFileUpload();

    /**
     * True if this parameter has a name that can properly be handled by Jakarta commons (this lib
     * is used by Struts but contains a bug)
     * @return boolean
     */
    public boolean isSafeNamePresent();

    /**
     * True if this field is a date type and the date format is not be interpreted strictly.
     * @return boolean
     */
    public boolean isStrictDateFormat();
}