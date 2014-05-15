// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.metafacades.uml.FrontEndParameter;

/**
 * A Gui parameter is an object communicated between the client and the server. Typically form beans
 * encapsulate such parameters.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface GuiParameter
    extends FrontEndParameter
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isGuiParameterMetaType();

    /**
     * All the annotations for this parameter.
     * @return Collection
     */
    public Collection getAnnotations();

    /**
     * All attributes belonging to this parameter's type.
     * @return Collection
     */
    public Collection getAttributes();

    /**
     * The backing list name for this parameter. This is useful if you want to be able to select the
     * parameter value from a list.
     * @return String
     */
    public String getBackingListName();

    /**
     * The name of the backing value for this parameter (only used with collections and arrays that
     * are input type table).
     * @return String
     */
    public String getBackingValueName();

    /**
     * If this parameter is a collection type, this property will represent the fully qualified name
     * of a class suitable for implementation. If the type is neither Collection, List, nor Set the
     * type itself is assumed.
     * @return String
     */
    public String getCollectionImplementationType();

    /**
     * If this parameter represents a date this method will return the format in which it must be
     * represented. In case this format has not been specified by the any tagged value a default one
     * will be taken.
     * @return String
     */
    public String getDateFormat();

    /**
     * The name of the date formatter for this parameter (if this parameter represents a date).
     * @return String
     */
    public String getDateFormatter();

    /**
     * The key to lookup the documentation for this parameter.
     * @return String
     */
    public String getDocumentationKey();

    /**
     * The documentation for this parameter, formatted to be inserted into a resource bundle.
     * @return String
     */
    public String getDocumentationValue();

    /**
     * The dummy value for this parameter. The dummy value is used for setting the dummy information
     * when dummyData is enabled.
     * @return String
     */
    public String getDummyValue();

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
     * The name of the property used for indicating whether or not a form attribute has been set at
     * least once.
     * @return String
     */
    public String getFormAttributeSetProperty();

    /**
     * If this is a controller operation argument these form fields will represent the form fields
     * for all actions deferring to the controller operation.
     * @return List<GuiParameter>
     */
    public List<GuiParameter> getFormFields();

    /**
     * If this parameter represents a date or time this method will return the format in which it
     * must be represented. In the event this format has not been specified by the any tagged value
     * the default will be used.
     * @return String
     */
    public String getFormat();

    /**
     * Represents a Gui action. Such an action typically is associated with a form bean handling all
     * parameters of this action.
     * This action model element extends a transition, but the actual logic contained by the action
     * envelops all action states called, until either a final state or View is reached.
     * @return GuiAction
     */
    public GuiAction getGuiAction();

    /**
     * Represents the view page in which this parameter will be used: either as a page variable,
     * either as an action parameter (form or hyperlink).
     * @return GuiView
     */
    public GuiView getGuiView();

    /**
     * A comma separated list of the input table identifier columns (these are the columns that
     * uniquely define a row in an input table).
     * @return String
     */
    public String getInputTableIdentifierColumns();

    /**
     * The name of the list holding the labels for this parameter. Only makes sense when the
     * parameter is selectable.
     * @return String
     */
    public String getLabelListName();

    /**
     * The max length allowed in the input component
     * @return String
     */
    public String getMaxLength();

    /**
     * The default message key for this parameter.
     * @return String
     */
    public String getMessageKey();

    /**
     * The default message value for this parameter.
     * @return String
     */
    public String getMessageValue();

    /**
     * The name of the array to be used for the multibox, this only makes sense when this parameter
     * is actually a multibox.
     * @return String
     */
    public String getMultiboxPropertyName();

    /**
     * All navigation association ends belonging to this parameter's type.
     * @return Collection
     */
    public Collection getNavigableAssociationEnds();

    /**
     * The null value for the type of this parameter. For decimals this would be zero, for booleans
     * this would be 'false', etc...
     * @return String
     */
    public String getNullValue();

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
     * In case this parameter represents an option set using radiobuttons, this attribute is a
     * positive integer and zero otherwise.
     * @return int
     */
    public int getOptionCount();

    /**
     * If this parameter is a choice between radio buttons, then you may use this method to retrieve
     * the message keys for the resource bundle. The message keys hold the value to be displayed for
     * the possible options.
     * @return List
     */
    public List getOptionKeys();

    /**
     * The values for the options. Only makes sense when the widget type is radiobutton. The
     * property value may directly be specified usiing the tagged value.
     * @return List
     */
    public List getOptionValues();

    /**
     * The name of the operation that resets this parameter to its original value.
     * @return String
     */
    public String getResetName();

    /**
     * The reset value for this parameter. The reset value is the non-null value to which this
     * parameter is set by default between requests, you can use this method to be able to generate
     * an application that will deploy and run with default data.
     * @return String
     */
    public String getResetValue();

    /**
     * TODO: Model Documentation for GuiParameter.styleId
     * @return String
     */
    public String getStyleId();

    /**
     * Those actions that are targetting this table's columns, only makes sense when this parameter
     * represents a table page-variable.
     * @param columnName String
     * @return List
     */
    public List getTableColumnActions(String columnName);

    /**
     * Returns the resource bundle key for this table's column, only returns a value when this
     * parameter is a table.
     * @param columnName String
     * @return String
     */
    public String getTableColumnMessageKey(String columnName);

    /**
     * Returns the resource bundle value for this table's column, only returns a value when this
     * parameter is a table.
     * @param columnName String
     * @return String
     */
    public String getTableColumnMessageValue(String columnName);

    /**
     * The class name of the decorator to use for the table.
     * @return String
     */
    public String getTableDecoratorClassName();

    /**
     * The full path to the decorator class.
     * @return String
     */
    public String getTableDecoratorFullPath();

    /**
     * The complete table decorator classname.
     * @return String
     */
    public String getTableDecoratorFullyQualifiedName();

    /**
     * The package name of the decorator to use for the table.
     * @return String
     */
    public String getTableDecoratorPackageName();

    /**
     * Tthe available types of export in a single String instance.
     * @return String
     */
    public String getTableExportTypes();

    /**
     * The actions used when submitting forms for this table. Table actions that are hyperlinks are
     * not included. It only makes sense to call this property on parameters that represent a table
     * page-variable.
     * @return List<GuiAction>
     */
    public List<GuiAction> getTableFormActions();

    /**
     * The column which is chosen to be submitted by the action targetting the entire table. Only
     * makes sense when there are actually global table actions present for this table parameter.
     * @return GuiParameter
     */
    public GuiParameter getTableGlobalActionParameter();

    /**
     * Returns those actions that allow table rows to be checked and submitted. Only makes sense
     * when this parameter represents a table page-variable.
     * @return Collection<GuiAction>
     */
    public Collection<GuiAction> getTableGlobalActions();

    /**
     * Those actions that are working on this table and are to be represented as hyperlinks. It only
     * makes sense to call this property on parameters that represent a table page-variable.
     * @return List<GuiAction>
     */
    public List<GuiAction> getTableHyperlinkActions();

    /**
     * The maximum number of rows to be displayed in the table at the same time. This is also known
     * as the page size. A value of zero or less will display all data in the same table (therefore
     * also on the same page).
     * @return int
     */
    public int getTableMaxRows();

    /**
     * The name of the property that Indicates whether or not the table should be sorted ascending
     * (if this parameter represents a table).
     * @return String
     */
    public String getTableSortAscendingProperty();

    /**
     * The name of the property storing the column to sort by if this parameter represents a table.
     * @return String
     */
    public String getTableSortColumnProperty();

    /**
     * The time format for this parameter (if this parameter stores time).
     * @return String
     */
    public String getTimeFormat();

    /**
     * The name of the time formatter (if this parameter represents a time).
     * @return String
     */
    public String getTimeFormatter();

    /**
     * TODO: Model Documentation for GuiParameter.titleKey
     * @return String
     */
    public String getTitleKey();

    /**
     * TODO: Model Documentation for GuiParameter.titleValue
     * @return String
     */
    public String getTitleValue();

    /**
     * The validator's 'validwhen' value, this is useful when the validation of a parameter depends
     * on the validation of others. See the Gui validator plugin documentation for more information.
     * @return String
     */
    public String getValidWhen();

    /**
     * Returns the arguments for this parameter's validators.
     * @param validatorType String
     * @return Collection
     */
    public Collection getValidatorArgs(String validatorType);

    /**
     * The message key for this parameter, equivalent to getMessageKey().
     * @return String
     */
    public String getValidatorMsgKey();

    /**
     * A collection of all the validator types for this parameter. Use this value in conjunction
     * with the Gui validator plugin.
     * @return Collection
     */
    public Collection getValidatorTypes();

    /**
     * The validator arguments.
     * @return Collection
     */
    public Collection getValidatorVars();

    /**
     * The dummy value for a value list.
     * @return String
     */
    public String getValueListDummyValue();

    /**
     * The name of the list holding the values for this parameter. Only makes sense when the
     * parameter is selectable.
     * @return String
     */
    public String getValueListName();

    /**
     * The reset value for this parameter's value list. Only makes sense if this parameter is
     * selectable.
     * @return String
     */
    public String getValueListResetValue();

    /**
     * The widget type for this parameter, this value is the tagname for the Gui HTML taglib. This
     * method is useful only when rendering forms.
     * @return String
     */
    public String getWidgetType();

    /**
     * This property is used in model validation. It denotes whether all actions targetting this
     * table page-variable take the same parameter (same name and type). Only makes sense when this
     * parameter is actually a table page-variable.
     * @return boolean
     */
    public boolean isAllGlobalTableActionsHaveSameParameter();

    /**
     * Indicates if a backing value is required for this parameter.
     * @return boolean
     */
    public boolean isBackingValueRequired();

    /**
     * True if this parameter is a date and it requires a calendar popup.
     * @return boolean
     */
    public boolean isCalendarRequired();

    /**
     * TODO: Model Documentation for GuiParameter.checkbox
     * @return boolean
     */
    public boolean isCheckbox();

    /**
     * TODO: Model Documentation for GuiParameter.combobox
     * @return boolean
     */
    public boolean isCombobox();

    /**
     * Indicates if this parameter is 'complex', that is: its of a complex type (has at least one
     * attribute or association).
     * @return boolean
     */
    public boolean isComplex();

    /**
     * True if the type of this parameter represents a date. This is equivalent to
     * parameter.type.isDateType().
     * @return boolean
     */
    public boolean isDate();

    /**
     * Indicates whether or not this parameter uses the equal validator.
     * @return boolean
     */
    public boolean isEqualValidator();

    /**
     * TODO: Model Documentation for GuiParameter.file
     * @return boolean
     */
    public boolean isFile();

    /**
     * TODO: Model Documentation for
     * GuiParameter.hiddenField
     * @return boolean
     */
    public boolean isHiddenField();

    /**
     * TODO: Model Documentation for GuiParameter.hyperlink
     * @return boolean
     */
    public boolean isHyperlink();

    /**
     * Indicates if this parameter represents a checkbox widget.
     * @return boolean
     */
    public boolean isInputCheckbox();

    /**
     * Indicates whether or not this is a file input type.
     * @return boolean
     */
    public boolean isInputFile();

    /**
     * Indicates whether or not this parameter represents a hidden input widget.
     * @return boolean
     */
    public boolean isInputHidden();

    /**
     * Indicates whether or not this type represents an input multibox.
     * @return boolean
     */
    public boolean isInputMultibox();

    /**
     * Indicates whether or not this parameter should be rendered as an input radio widget.
     * @return boolean
     */
    public boolean isInputRadio();

    /**
     * Indicates whether or not this parameter represents an input "secret" widget (i.e. password).
     * @return boolean
     */
    public boolean isInputSecret();

    /**
     * Indicates whether or not this parameter represents an input select widget.
     * @return boolean
     */
    public boolean isInputSelect();

    /**
     * Indicates whether or not this is an table input type.
     * @return boolean
     */
    public boolean isInputTable();

    /**
     * Indicates whether or not this parameter should be rendered as a text input widget.
     * @return boolean
     */
    public boolean isInputText();

    /**
     * Indicates if this parameter represents as an input text area widget.
     * @return boolean
     */
    public boolean isInputTextarea();

    /**
     * TODO: Model Documentation for
     * GuiParameter.multiSelection
     * @return boolean
     */
    public boolean isMultiSelection();

    /**
     * TODO: Model Documentation for GuiParameter.multibox
     * @return boolean
     */
    public boolean isMultibox();

    /**
     * True if this parameter is either an array type or Collection type.
     * @return boolean
     */
    public boolean isMultiple();

    /**
     * Whether or not the parameter is a "pageable table", that is a table that supports paging
     * (i.e. DB paging).
     * @return boolean
     */
    public boolean isPageableTable();

    /**
     * True if this parameter represents a password field.
     * @return boolean
     */
    public boolean isPassword();

    /**
     * Indicates whether or not this field should be rendered as plain text (not as a widget).
     * @return boolean
     */
    public boolean isPlaintext();

    /**
     * TODO: Model Documentation for
     * GuiParameter.radioButton
     * @return boolean
     */
    public boolean isRadioButton();

    /**
     * True if this parameter cannot be changed by the user, false otherwise.
     * @return boolean
     */
    public boolean isReadOnly();

    /**
     * Indicates if this parameter's value should be reset or not after an action has been performed
     * with this parameter.
     * @return boolean
     */
    public boolean isReset();

    /**
     * True if the value of this parameter must be reset between requests (Gui requires this for
     * specific types), false otherwise.
     * @return boolean
     */
    public boolean isResetRequired();

    /**
     * True if this parameter has a name that can properly be handled by Jakarta commons (this lib
     * is used by Gui but contains a bug)
     * @return boolean
     */
    public boolean isSafeNamePresent();

    /**
     * Whether or not this parameter is selectable. In case this would be true this parameter always
     * has a backing list, a value list and a list containing the labels.
     * @return boolean
     */
    public boolean isSelectable();

    /**
     * Whether or not this parameter should be reset between requests.  This is different than
     * resetRequired in that this is user specified.
     * @return boolean
     */
    public boolean isShouldReset();

    /**
     * Indicates if a table can be sorted by this parameter.
     * @return boolean
     */
    public boolean isSortableBy();

    /**
     * True if the date format is to be strictly respected. Otherwise the dateformatter used for the
     * representation of this date is to be set to lenient.
     * @return boolean
     */
    public boolean isStrictDateFormat();

    /**
     * TODO: Model Documentation for
     * GuiParameter.tableDecoratorRequired
     * @return boolean
     */
    public boolean isTableDecoratorRequired();

    /**
     * True if it is possible to export the table data to XML, CSV, PDF or Excel format.
     * @return boolean
     */
    public boolean isTableExportable();

    /**
     * True if this table has form actions that share the column widgets. It is not allowed to have
     * different actions use different widgets on the same column.
     * @return boolean
     */
    public boolean isTableFormActionSharingWidgets();

    /**
     * True if this parameter represents a table column into which an hyperlink must be rendered.
     * This property only makes sense when it has been called on parameters representing an actual
     * table column. Note that the getTableColumns() operation also returns String instances.
     * @return boolean
     */
    public boolean isTableHyperlinkColumn();

    /**
     * True if it is possible to sort the columns of the table.
     * @return boolean
     */
    public boolean isTableSortable();

    /**
     * TODO: Model Documentation for GuiParameter.textArea
     * @return boolean
     */
    public boolean isTextArea();

    /**
     * TODO: Model Documentation for GuiParameter.textField
     * @return boolean
     */
    public boolean isTextField();

    /**
     * Indicates if this parameter's type represents a time.
     * @return boolean
     */
    public boolean isTime();

    /**
     * True if this parameter requires some kind of validation. This means the collection of
     * validator types is not empty.
     * @return boolean
     */
    public boolean isValidationRequired();

    /**
     * TODO: Model Documentation for GuiParameter.toPhrase
     * @param string String
     * @return String
     */
    public String toPhrase(String string);
}