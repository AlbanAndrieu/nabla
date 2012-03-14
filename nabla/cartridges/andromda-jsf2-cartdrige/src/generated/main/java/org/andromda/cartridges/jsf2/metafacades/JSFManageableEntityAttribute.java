// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.jsf2.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.ManageableEntityAttribute;
import org.andromda.metafacades.uml.ParameterFacade;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface JSFManageableEntityAttribute
    extends ManageableEntityAttribute
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isJSFManageableEntityAttributeMetaType();

    /**
     * 
     * @return String
     */
    public String getBackingListName();

    /**
     * The String format to use when referring to this date, only makes sense when the type is a
     * date type.
     * @return String
     */
    public String getDateFormat();

    /**
     * 
     * @return String
     */
    public String getDateFormatter();

    /**
     * 
     * @return String
     */
    public String getDefaultDateFormat();

    /**
     * 
     * @return String
     */
    public String getDefaultTimeFormat();

    /**
     * 
     * @return String
     */
    public String getDummyValue();

    /**
     * Gets the unique id of this attribute on the form.
     * @param ownerParameter ParameterFacade
     * @return String
     */
    public String getFormPropertyId(ParameterFacade ownerParameter);

    /**
     * Retrieves the name of the form property for this attribute by taking the name of the owner
     * property.
     * @param ownerParameter ParameterFacade
     * @return String
     */
    public String getFormPropertyName(ParameterFacade ownerParameter);

    /**
     * 
     * @return String
     */
    public String getFormat();

    /**
     * 
     * @return String
     */
    public String getInputTableIdentifierColumns();

    /**
     * 
     * @return String
     */
    public String getLabelListName();

    /**
     * The max length allowed in the input component
     * @return String
     */
    public String getMaxLength();

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
     * 
     * @return String
     */
    public String getTimeFormatter();

    /**
     * 
     * @return String
     */
    public String getValidWhen();

    /**
     * 
     * @param validatorType String
     * @return Collection
     */
    public Collection getValidatorArgs(String validatorType);

    /**
     * All validator types for this attribute.
     * @return Collection
     */
    public Collection getValidatorTypes();

    /**
     * The validator variables.
     * @return Collection
     */
    public Collection getValidatorVars();

    /**
     * 
     * @return String
     */
    public String getValueListDummyValue();

    /**
     * 
     * @return String
     */
    public String getValueListName();

    /**
     * The widget to use when rendering this attribute
     * @return String
     */
    public String getWidgetType();

    /**
     * 
     * @return boolean
     */
    public boolean isEqualValidator();

    /**
     * Whether or not this attribute should be hidden from the view
     * @return boolean
     */
    public boolean isHidden();

    /**
     * 
     * @return boolean
     */
    public boolean isInputCheckbox();

    /**
     * 
     * @return boolean
     */
    public boolean isInputFile();

    /**
     * 
     * @return boolean
     */
    public boolean isInputHidden();

    /**
     * 
     * @return boolean
     */
    public boolean isInputMultibox();

    /**
     * 
     * @return boolean
     */
    public boolean isInputRadio();

    /**
     * 
     * @return boolean
     */
    public boolean isInputSecret();

    /**
     * 
     * @return boolean
     */
    public boolean isInputSelect();

    /**
     * 
     * @return boolean
     */
    public boolean isInputTable();

    /**
     * 
     * @return boolean
     */
    public boolean isInputText();

    /**
     * 
     * @return boolean
     */
    public boolean isInputTextarea();

    /**
     * 
     * @return boolean
     */
    public boolean isInputTypePresent();

    /**
     * True if this attribute is of a type that cannot easily be represented as a textual string and
     * would be an ideal candidate for HTTP's support for file-upload.
     * @return boolean
     */
    public boolean isNeedsFileUpload();

    /**
     * 
     * @return boolean
     */
    public boolean isPlaintext();

    /**
     * True if this field is a date type and the date format is not be interpreted strictly.
     * @return boolean
     */
    public boolean isStrictDateFormat();

    /**
     * Indicates whether or not this attribute requires some kind of validation (the collection of
     * validator types is not empty).
     * @return boolean
     */
    public boolean isValidationRequired();
}