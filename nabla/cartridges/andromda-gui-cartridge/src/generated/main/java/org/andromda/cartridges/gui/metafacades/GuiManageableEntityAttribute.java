// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.ManageableEntityAttribute;
import org.andromda.metafacades.uml.ParameterFacade;

/**
 * TODO: Model Documentation for
 * GuiManageableEntityAttribute
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiManageableEntityAttribute
    extends ManageableEntityAttribute
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiManageableEntityAttributeMetaType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.getAllSourceCoherencyValues
     * @return Collection
     */
    public Collection getAllSourceCoherencyValues();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.getAllTargetCoherencyValues
     * @return Collection
     */
    public Collection getAllTargetCoherencyValues();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.backingListName
     * @return String
     */
    public String getBackingListName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.choiceType
     * @return String
     */
    public String getChoiceType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.getCoherencyStateWhenActivated
     * @param targetElement GuiManageableEntityAttribute
     * @return String
     */
    public String getCoherencyStateWhenActivated(GuiManageableEntityAttribute targetElement);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.getCoherencyStateWhenDeactivated
     * @param targetElement GuiManageableEntityAttribute
     * @return String
     */
    public String getCoherencyStateWhenDeactivated(GuiManageableEntityAttribute targetElement);

    /**
     * The String format to use when referring to this date, only makes sense when the type is a
     * date type.
     * @return String
     */
    public String getDateFormat();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.dateFormatter
     * @return String
     */
    public String getDateFormatter();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.defaultDateFormat
     * @return String
     */
    public String getDefaultDateFormat();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.defaultTimeFormat
     * @return String
     */
    public String getDefaultTimeFormat();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.dictionaryReturnType
     * @return String
     */
    public String getDictionaryReturnType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.displayName
     * @return String
     */
    public String getDisplayName();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.dummyValue
     * @return String
     */
    public String getDummyValue();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.fieldSize
     * @return int
     */
    public int getFieldSize();

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
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.format
     * @return String
     */
    public String getFormat();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.functionalCoherency
     * @return String
     */
    public String getFunctionalCoherency();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputTableIdentifierColumns
     * @return String
     */
    public String getInputTableIdentifierColumns();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.labelListName
     * @return String
     */
    public String getLabelListName();

    /**
     * The max length allowed in the input component
     * @return String
     */
    public String getMaxLength();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.messageKey
     * @return String
     */
    public String getMessageKey();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.messageValue
     * @return String
     */
    public String getMessageValue();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.numericFormat
     * @return String
     */
    public String getNumericFormat();

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
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.getSourceCoherencyValue
     * @param dependency DependencyFacade
     * @return Object
     */
    public Object getSourceCoherencyValue(DependencyFacade dependency);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute
     * @return List<GuiManageableEntityAttribute>
     */
    public List<GuiManageableEntityAttribute> getStateCoherencies();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.getTargetCoherencyValues
     * @param sourceElement GuiManageableEntityAttribute
     * @param sourceValue Object
     * @return Collection
     */
    public Collection getTargetCoherencyValues(GuiManageableEntityAttribute sourceElement, Object sourceValue);

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.timeFormatter
     * @return String
     */
    public String getTimeFormatter();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.validWhen
     * @return String
     */
    public String getValidWhen();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.getValidatorArgs
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
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute
     * @return List<GuiManageableEntityAttribute>
     */
    public List<GuiManageableEntityAttribute> getValueCoherencySources();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute
     * @return List<GuiManageableEntityAttribute>
     */
    public List<GuiManageableEntityAttribute> getValueCoherencyTargets();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.valueListDummyValue
     * @return String
     */
    public String getValueListDummyValue();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.valueListName
     * @return String
     */
    public String getValueListName();

    /**
     * The widget to use when rendering this attribute
     * @return String
     */
    public String getWidgetType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.coherencySource
     * @return boolean
     */
    public boolean isCoherencySource();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.coherencyTarget
     * @return boolean
     */
    public boolean isCoherencyTarget();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.dealId
     * @return boolean
     */
    public boolean isDealId();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.dealType
     * @return boolean
     */
    public boolean isDealType();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.equalValidator
     * @return boolean
     */
    public boolean isEqualValidator();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.filterElement
     * @return boolean
     */
    public boolean isFilterElement();

    /**
     * Whether or not this attribute should be hidden from the view
     * @return boolean
     */
    public boolean isHidden();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputCheckbox
     * @return boolean
     */
    public boolean isInputCheckbox();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputFile
     * @return boolean
     */
    public boolean isInputFile();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputHidden
     * @return boolean
     */
    public boolean isInputHidden();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputMultibox
     * @return boolean
     */
    public boolean isInputMultibox();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputRadio
     * @return boolean
     */
    public boolean isInputRadio();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputSecret
     * @return boolean
     */
    public boolean isInputSecret();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputSelect
     * @return boolean
     */
    public boolean isInputSelect();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputTable
     * @return boolean
     */
    public boolean isInputTable();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputText
     * @return boolean
     */
    public boolean isInputText();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputTextarea
     * @return boolean
     */
    public boolean isInputTextarea();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.inputTypePresent
     * @return boolean
     */
    public boolean isInputTypePresent();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.mandatory
     * @return boolean
     */
    public boolean isMandatory();

    /**
     * True if this attribute is of a type that cannot easily be represented as a textual string and
     * would be an ideal candidate for HTTP's support for file-upload.
     * @return boolean
     */
    public boolean isNeedsFileUpload();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.plaintext
     * @return boolean
     */
    public boolean isPlaintext();

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.readOnlyForUpdate
     * @return boolean
     */
    public boolean isReadOnlyForUpdate();

    /**
     * True if this parameter has a name that can properly be handled by Jakarta commons (this lib
     * is used by Gui but contains a bug)
     * @return boolean
     */
    public boolean isSafeNamePresent();

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

    /**
     * TODO: Model Documentation for
     * GuiManageableEntityAttribute.mustBeDeactivated
     * @param targetElement GuiManageableEntityAttribute
     * @param sourceValue Object
     * @return boolean
     */
    public boolean mustBeDeactivated(GuiManageableEntityAttribute targetElement, Object sourceValue);
}