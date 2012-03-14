// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.cartridges.jsf.metafacades.JSFAction;
import org.andromda.cartridges.jsf.metafacades.JSFParameter;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EventFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndControllerOperation;
import org.andromda.metafacades.uml.FrontEndView;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for SeamParameter
 *
 * @see SeamParameter
 */
public abstract class SeamParameterLogic
    extends MetafacadeBase
    implements SeamParameter
{
    /**
     * The underlying UML object
     * @see Object
     */
    protected Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected SeamParameterLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superJSFParameter =
           (JSFParameter)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.cartridges.jsf.metafacades.JSFParameter",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to SeamParameter if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.seam.metafacades.SeamParameter";
        }
        return context;
    }

    private JSFParameter superJSFParameter;
    private boolean superJSFParameterInitialized = false;

    /**
     * Gets the JSFParameter parent instance.
     * @return this.superJSFParameter JSFParameter
     */
    private JSFParameter getSuperJSFParameter()
    {
        if (!this.superJSFParameterInitialized)
        {
            ((MetafacadeBase)this.superJSFParameter).setMetafacadeContext(this.getMetafacadeContext());
            this.superJSFParameterInitialized = true;
        }
        return this.superJSFParameter;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see org.andromda.core.metafacade.MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superJSFParameterInitialized)
            {
                ((MetafacadeBase)this.superJSFParameter).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see SeamParameter
     */
    public boolean isSeamParameterMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see JSFParameter
     */
    public boolean isJSFParameterMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.FrontEndParameter
     */
    public boolean isFrontEndParameterMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.ParameterFacade
     */
    public boolean isParameterFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see ModelElementFacade
     */
    public boolean isModelElementFacadeMetaType()
    {
        return true;
    }

    // ----------- delegates to JSFParameter ------------
    /**
     * All attributes belonging to this parameter's type.
     * @see JSFParameter#getAttributes()
     */
    public Collection getAttributes()
    {
        return this.getSuperJSFParameter().getAttributes();
    }

    /**
     * The backing list name for this parameter. This is useful if you want to be able to select the
     * parameter value from a list (i.e. a drop-down select input type).
     * @see JSFParameter#getBackingListName()
     */
    public String getBackingListName()
    {
        return this.getSuperJSFParameter().getBackingListName();
    }

    /**
     * The name of the backing value for this parameter (only used with collections and arrays that
     * are input type table).
     * @see JSFParameter#getBackingValueName()
     */
    public String getBackingValueName()
    {
        return this.getSuperJSFParameter().getBackingValueName();
    }

    /**
     * The name of the date formatter for this parameter (if this parameter represents a date).
     * @see JSFParameter#getDateFormatter()
     */
    public String getDateFormatter()
    {
        return this.getSuperJSFParameter().getDateFormatter();
    }

    /**
     * A resource message key suited for the parameter's documentation.
     * @see JSFParameter#getDocumentationKey()
     */
    public String getDocumentationKey()
    {
        return this.getSuperJSFParameter().getDocumentationKey();
    }

    /**
     * A resource message value suited for the parameter's documentation.
     * @see JSFParameter#getDocumentationValue()
     */
    public String getDocumentationValue()
    {
        return this.getSuperJSFParameter().getDocumentationValue();
    }

    /**
     * The dummy value for this parameter. The dummy value is used for setting the dummy information
     * when dummyData is enabled.
     * @see JSFParameter#getDummyValue()
     */
    public String getDummyValue()
    {
        return this.getSuperJSFParameter().getDummyValue();
    }

    /**
     * The name of the property used for indicating whether or not a form attribute has been set at
     * least once.
     * @see JSFParameter#getFormAttributeSetProperty()
     */
    public String getFormAttributeSetProperty()
    {
        return this.getSuperJSFParameter().getFormAttributeSetProperty();
    }

    /**
     * If this parameter represents a date or time this method will return the format in which it
     * must be represented. In the event this format has not been specified by the any tagged value
     * the default will be used.
     * @see JSFParameter#getFormat()
     */
    public String getFormat()
    {
        return this.getSuperJSFParameter().getFormat();
    }

    /**
     * A comma seperated list of the input table identifier columns (these are the columns that
     * uniquely define a row in an input table).
     * @see JSFParameter#getInputTableIdentifierColumns()
     */
    public String getInputTableIdentifierColumns()
    {
        return this.getSuperJSFParameter().getInputTableIdentifierColumns();
    }

    /**
     * The name of the label list for this parameter. The label list name is the name of the list
     * storing the labels for the possible values of this parameter (typically used for the labels
     * of a drop-down select lists).
     * @see JSFParameter#getLabelListName()
     */
    public String getLabelListName()
    {
        return this.getSuperJSFParameter().getLabelListName();
    }

    /**
     * The max length allowed in the input component
     * @see JSFParameter#getMaxLength()
     */
    public String getMaxLength()
    {
        return this.getSuperJSFParameter().getMaxLength();
    }

    /**
     * The default message key for this parameter.
     * @see JSFParameter#getMessageKey()
     */
    public String getMessageKey()
    {
        return this.getSuperJSFParameter().getMessageKey();
    }

    /**
     * The default message value for this parameter.
     * @see JSFParameter#getMessageValue()
     */
    public String getMessageValue()
    {
        return this.getSuperJSFParameter().getMessageValue();
    }

    /**
     * All navigation association ends belonging to this parameter's type.
     * @see JSFParameter#getNavigableAssociationEnds()
     */
    public Collection getNavigableAssociationEnds()
    {
        return this.getSuperJSFParameter().getNavigableAssociationEnds();
    }

    /**
     * Those actions that are targetting the given column, only makes sense when this parameter
     * represents a table view-variable.
     * @see JSFParameter#getTableColumnActions(String columnName)
     */
    public List getTableColumnActions(String columnName)
    {
        return this.getSuperJSFParameter().getTableColumnActions(columnName);
    }

    /**
     * 
     * @see JSFParameter#getTableColumnMessageKey(String columnName)
     */
    public String getTableColumnMessageKey(String columnName)
    {
        return this.getSuperJSFParameter().getTableColumnMessageKey(columnName);
    }

    /**
     * 
     * @see JSFParameter#getTableColumnMessageValue(String columnName)
     */
    public String getTableColumnMessageValue(String columnName)
    {
        return this.getSuperJSFParameter().getTableColumnMessageValue(columnName);
    }

    /**
     * Actions used when submitting forms for this table. Table actions that are hyperlinks are not
     * included. It only makes sense to call this property on parameters that represent a table
     * page-variable.
     * @see JSFParameter#getTableFormActions()
     */
    public List<JSFAction> getTableFormActions()
    {
        return this.getSuperJSFParameter().getTableFormActions();
    }

    /**
     * Actions that are working with this table and are to be represented as hyperlinks. This only
     * makes sense on a parameter that represents a table page variable.
     * @see JSFParameter#getTableHyperlinkActions()
     */
    public List<JSFAction> getTableHyperlinkActions()
    {
        return this.getSuperJSFParameter().getTableHyperlinkActions();
    }

    /**
     * The name of the property that Indicates whether or not the table should be sorted ascending
     * (if this parameter represents a table).
     * @see JSFParameter#getTableSortAscendingProperty()
     */
    public String getTableSortAscendingProperty()
    {
        return this.getSuperJSFParameter().getTableSortAscendingProperty();
    }

    /**
     * The name of the property storing the column to sort by if this parameter represents a table.
     * @see JSFParameter#getTableSortColumnProperty()
     */
    public String getTableSortColumnProperty()
    {
        return this.getSuperJSFParameter().getTableSortColumnProperty();
    }

    /**
     * The name of the time formatter (if this parameter represents a time).
     * @see JSFParameter#getTimeFormatter()
     */
    public String getTimeFormatter()
    {
        return this.getSuperJSFParameter().getTimeFormatter();
    }

    /**
     * The validator's 'validwhen' value, this is useful when the validation of a parameter depends
     * on the validation of others. See the apache commons-validator documentation for more
     * information.
     * @see JSFParameter#getValidWhen()
     */
    public String getValidWhen()
    {
        return this.getSuperJSFParameter().getValidWhen();
    }

    /**
     * Gets the arguments for this parameter's validators.
     * @see JSFParameter#getValidatorArgs(String validatorType)
     */
    public Collection getValidatorArgs(String validatorType)
    {
        return this.getSuperJSFParameter().getValidatorArgs(validatorType);
    }

    /**
     * All the validator types for this parameter.
     * @see JSFParameter#getValidatorTypes()
     */
    public Collection getValidatorTypes()
    {
        return this.getSuperJSFParameter().getValidatorTypes();
    }

    /**
     * The validator variables.
     * @see JSFParameter#getValidatorVars()
     */
    public Collection getValidatorVars()
    {
        return this.getSuperJSFParameter().getValidatorVars();
    }

    /**
     * The dummy value for a value list.
     * @see JSFParameter#getValueListDummyValue()
     */
    public String getValueListDummyValue()
    {
        return this.getSuperJSFParameter().getValueListDummyValue();
    }

    /**
     * Stores the name of the value list for this parameter; this list stores the possible values
     * that this parameter may be (typically used for the values of a drop-down select list).
     * @see JSFParameter#getValueListName()
     */
    public String getValueListName()
    {
        return this.getSuperJSFParameter().getValueListName();
    }

    /**
     * Indicates if a backing value is required for this parameter.
     * @see JSFParameter#isBackingValueRequired()
     */
    public boolean isBackingValueRequired()
    {
        return this.getSuperJSFParameter().isBackingValueRequired();
    }

    /**
     * Indicates if this parameter is 'complex', that is: its of a complex type (has at least one
     * attribute or association).
     * @see JSFParameter#isComplex()
     */
    public boolean isComplex()
    {
        return this.getSuperJSFParameter().isComplex();
    }

    /**
     * Indicates whether or not this parameter uses the equal validator.
     * @see JSFParameter#isEqualValidator()
     */
    public boolean isEqualValidator()
    {
        return this.getSuperJSFParameter().isEqualValidator();
    }

    /**
     * Indicates if this parameter represents a checkbox widget.
     * @see JSFParameter#isInputCheckbox()
     */
    public boolean isInputCheckbox()
    {
        return this.getSuperJSFParameter().isInputCheckbox();
    }

    /**
     * Indicates whether or not this is a file input type.
     * @see JSFParameter#isInputFile()
     */
    public boolean isInputFile()
    {
        return this.getSuperJSFParameter().isInputFile();
    }

    /**
     * Indicates whether or not this parameter represents a hidden input widget.
     * @see JSFParameter#isInputHidden()
     */
    public boolean isInputHidden()
    {
        return this.getSuperJSFParameter().isInputHidden();
    }

    /**
     * Indicates whether or not this type represents an input multibox.
     * @see JSFParameter#isInputMultibox()
     */
    public boolean isInputMultibox()
    {
        return this.getSuperJSFParameter().isInputMultibox();
    }

    /**
     * Indicates whether or not this parameter should be rendered as an input radio widget.
     * @see JSFParameter#isInputRadio()
     */
    public boolean isInputRadio()
    {
        return this.getSuperJSFParameter().isInputRadio();
    }

    /**
     * Indicates whether or not this parameter represents an input "secret" widget (i.e. password).
     * @see JSFParameter#isInputSecret()
     */
    public boolean isInputSecret()
    {
        return this.getSuperJSFParameter().isInputSecret();
    }

    /**
     * Indicates whether or not this parameter represents an input select widget.
     * @see JSFParameter#isInputSelect()
     */
    public boolean isInputSelect()
    {
        return this.getSuperJSFParameter().isInputSelect();
    }

    /**
     * Indicates whether or not this is an table input type.
     * @see JSFParameter#isInputTable()
     */
    public boolean isInputTable()
    {
        return this.getSuperJSFParameter().isInputTable();
    }

    /**
     * Indicates whether or not this parameter should be rendered as a text input widget.
     * @see JSFParameter#isInputText()
     */
    public boolean isInputText()
    {
        return this.getSuperJSFParameter().isInputText();
    }

    /**
     * Indicates if this parameter represents as an input text area widget.
     * @see JSFParameter#isInputTextarea()
     */
    public boolean isInputTextarea()
    {
        return this.getSuperJSFParameter().isInputTextarea();
    }

    /**
     * Whether or not the parameter is a "pageable table", that is a table that supports paging
     * (i.e. DB paging).
     * @see JSFParameter#isPageableTable()
     */
    public boolean isPageableTable()
    {
        return this.getSuperJSFParameter().isPageableTable();
    }

    /**
     * Indicates whether or not this field should be rendered as plain text (not as a widget).
     * @see JSFParameter#isPlaintext()
     */
    public boolean isPlaintext()
    {
        return this.getSuperJSFParameter().isPlaintext();
    }

    /**
     * Indicates if this parameter can only be read and not modified.
     * @see JSFParameter#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperJSFParameter().isReadOnly();
    }

    /**
     * Indicates if this parameter's value should be reset or not after an action has been performed
     * with this parameter.
     * @see JSFParameter#isReset()
     */
    public boolean isReset()
    {
        return this.getSuperJSFParameter().isReset();
    }

    /**
     * Indicates whether or not this parameter is selectable or not (that is: it can be selected
     * from a list of values).
     * @see JSFParameter#isSelectable()
     */
    public boolean isSelectable()
    {
        return this.getSuperJSFParameter().isSelectable();
    }

    /**
     * Indicates where or not the date format is to be strictly respected. Otherwise the date
     * formatter used for the representation of this date is to be set to lenient.
     * @see JSFParameter#isStrictDateFormat()
     */
    public boolean isStrictDateFormat()
    {
        return this.getSuperJSFParameter().isStrictDateFormat();
    }

    /**
     * Indicates whether or not this parameter requires some kind of validation (the collection of
     * validator types is not empty).
     * @see JSFParameter#isValidationRequired()
     */
    public boolean isValidationRequired()
    {
        return this.getSuperJSFParameter().isValidationRequired();
    }

    /**
     * The action to which this parameter belongs (if it belongs to an action), otherwise it returns
     * null.
     * @see org.andromda.metafacades.uml.FrontEndParameter#getAction()
     */
    public FrontEndAction getAction()
    {
        return this.getSuperJSFParameter().getAction();
    }

    /**
     * Gets the controller operation to which this parameter belongs.
     * @see org.andromda.metafacades.uml.FrontEndParameter#getControllerOperation()
     */
    public FrontEndControllerOperation getControllerOperation()
    {
        return this.getSuperJSFParameter().getControllerOperation();
    }

    /**
     * A collection of all possible attribute names of a table (this will only work when your table
     * is modeled as an array..not a collection).
     * @see org.andromda.metafacades.uml.FrontEndParameter#getTableAttributeNames()
     */
    public Collection<String> getTableAttributeNames()
    {
        return this.getSuperJSFParameter().getTableAttributeNames();
    }

    /**
     * All the columns for this parameter if it represents a table variable. If a column is linked
     * by an event (action) a FrontEndParameter instance is included in the return value, otherwise
     * a plain String representing the column name.
     * @see org.andromda.metafacades.uml.FrontEndParameter#getTableColumnNames()
     */
    public Collection<String> getTableColumnNames()
    {
        return this.getSuperJSFParameter().getTableColumnNames();
    }

    /**
     * A list of all attributes which make up the table columns of this table (this only contains
     * attributes when the table is represented by an array).
     * @see org.andromda.metafacades.uml.FrontEndParameter#getTableColumns()
     */
    public Collection<String> getTableColumns()
    {
        return this.getSuperJSFParameter().getTableColumns();
    }

    /**
     * Represents the view in which this parameter will be used.
     * @see org.andromda.metafacades.uml.FrontEndParameter#getView()
     */
    public FrontEndView getView()
    {
        return this.getSuperJSFParameter().getView();
    }

    /**
     * Indicates whether or not this is an action parameter or not.
     * @see org.andromda.metafacades.uml.FrontEndParameter#isActionParameter()
     */
    public boolean isActionParameter()
    {
        return this.getSuperJSFParameter().isActionParameter();
    }

    /**
     * Indicates if this parameter is contained in a "front-end" use case.
     * @see org.andromda.metafacades.uml.FrontEndParameter#isContainedInFrontEndUseCase()
     */
    public boolean isContainedInFrontEndUseCase()
    {
        return this.getSuperJSFParameter().isContainedInFrontEndUseCase();
    }

    /**
     * Indicates whether or not this parameter is an argument of a controller operation.
     * @see org.andromda.metafacades.uml.FrontEndParameter#isControllerOperationArgument()
     */
    public boolean isControllerOperationArgument()
    {
        return this.getSuperJSFParameter().isControllerOperationArgument();
    }

    /**
     * Indicates whether or not this parameter represents a table.
     * @see org.andromda.metafacades.uml.FrontEndParameter#isTable()
     */
    public boolean isTable()
    {
        return this.getSuperJSFParameter().isTable();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperJSFParameter().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperJSFParameter().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperJSFParameter().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperJSFParameter().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperJSFParameter().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperJSFParameter().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperJSFParameter().getDocumentation(indent);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. By default paragraphs are returned as HTML.
     * This method is equivalent to <code>getDocumentation(indent, lineLength, true)</code>.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength)
     */
    public String getDocumentation(String indent, int lineLength)
    {
        return this.getSuperJSFParameter().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperJSFParameter().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperJSFParameter().getFullyQualifiedName();
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element.  If modelName is true, then
     * the original name of the model element (the name contained within the model) will be the name
     * returned, otherwise a name from a language mapping will be returned.
     * @see ModelElementFacade#getFullyQualifiedName(boolean modelName)
     */
    public String getFullyQualifiedName(boolean modelName)
    {
        return this.getSuperJSFParameter().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperJSFParameter().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperJSFParameter().getId();
    }

    /**
     * UML2: Retrieves the keywords for this element. Used to modify implementation properties which
     * are not represented by other properties, i.e. native, transient, volatile, synchronized,
     * (added annotations) override, deprecated. Can also be used to suppress compiler warnings:
     * (added annotations) unchecked, fallthrough, path, serial, finally, all. Annotations require
     * JDK5 compiler level.
     * @see ModelElementFacade#getKeywords()
     */
    public Collection<String> getKeywords()
    {
        return this.getSuperJSFParameter().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperJSFParameter().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperJSFParameter().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperJSFParameter().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperJSFParameter().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperJSFParameter().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperJSFParameter().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperJSFParameter().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperJSFParameter().getPackagePath();
    }

    /**
     * UML2: Returns the value of the 'Qualified Name' attribute. A name which allows the
     * NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from
     * the names of the containing namespaces starting at the root of the hierarchy and ending with
     * the name of the NamedElement itself.
     * @see ModelElementFacade#getQualifiedName()
     */
    public String getQualifiedName()
    {
        return this.getSuperJSFParameter().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperJSFParameter().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperJSFParameter().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperJSFParameter().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperJSFParameter().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperJSFParameter().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperJSFParameter().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperJSFParameter().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperJSFParameter().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperJSFParameter().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperJSFParameter().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperJSFParameter().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperJSFParameter().hasKeyword(keywordName);
    }

    /**
     * Returns true if the model element has the specified stereotype.  If the stereotype itself
     * does not match, then a search will be made up the stereotype inheritance hierarchy, and if
     * one of the stereotype's ancestors has a matching name this method will return true, false
     * otherwise.
     * For example, if we have a certain stereotype called <<exception>> and a model element has a
     * stereotype called <<applicationException>> which extends <<exception>>, when calling this
     * method with 'stereotypeName' defined as 'exception' the method would return true since
     * <<applicationException>> inherits from <<exception>>.  If you want to check if the model
     * element has the exact stereotype, then use the method 'hasExactStereotype' instead.
     * @see ModelElementFacade#hasStereotype(String stereotypeName)
     */
    public boolean hasStereotype(String stereotypeName)
    {
        return this.getSuperJSFParameter().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperJSFParameter().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperJSFParameter().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperJSFParameter().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperJSFParameter().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperJSFParameter().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperJSFParameter().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperJSFParameter().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperJSFParameter().translateConstraints(kind, translation);
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.ParameterFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {
        return this.getSuperJSFParameter().getDefaultValue();
    }

    /**
     * UML2: A representation of the literals of the enumeration 'Parameter Effect Kind': CREATE,
     * READ, UPDATE, DELETE. The datatype ParameterEffectKind is an enumeration that indicates the
     * effect of a behavior on values passed in or out of its parameters.
     * @see org.andromda.metafacades.uml.ParameterFacade#getEffect()
     */
    public String getEffect()
    {
        return this.getSuperJSFParameter().getEffect();
    }

    /**
     * If this parameter is located on an event, this will represent that event.
     * @see org.andromda.metafacades.uml.ParameterFacade#getEvent()
     */
    public EventFacade getEvent()
    {
        return this.getSuperJSFParameter().getEvent();
    }

    /**
     * The name to use for accessors getting this parameter from a bean.
     * @see org.andromda.metafacades.uml.ParameterFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperJSFParameter().getGetterName();
    }

    /**
     * Fully Qualified TypeName, determined in part by multiplicity (for UML2). For UML14, same as
     * getterName.
     * @see org.andromda.metafacades.uml.ParameterFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperJSFParameter().getGetterSetterTypeName();
    }

    /**
     * Fully Qualified implementation class of TypeName, determined in part by multiplicity (for
     * UML2). If upper multiplicity =1, same as getterSetterTypeName.
     * @see org.andromda.metafacades.uml.ParameterFacade#getGetterSetterTypeNameImpl()
     */
    public String getGetterSetterTypeNameImpl()
    {
        return this.getSuperJSFParameter().getGetterSetterTypeNameImpl();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.ParameterFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperJSFParameter().getLower();
    }

    /**
     * If this parameter is located on an operation, this will represent that operation.
     * @see org.andromda.metafacades.uml.ParameterFacade#getOperation()
     */
    public OperationFacade getOperation()
    {
        return this.getSuperJSFParameter().getOperation();
    }

    /**
     * The name to use for accessors getting this parameter in a bean.
     * @see org.andromda.metafacades.uml.ParameterFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperJSFParameter().getSetterName();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.ParameterFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperJSFParameter().getType();
    }

    /**
     * the upper value of the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.ParameterFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperJSFParameter().getUpper();
    }

    /**
     * Indicates if the default value is present.
     * @see org.andromda.metafacades.uml.ParameterFacade#isDefaultValuePresent()
     */
    public boolean isDefaultValuePresent()
    {
        return this.getSuperJSFParameter().isDefaultValuePresent();
    }

    /**
     * UML2: Returns the value of the 'Is Exception' attribute. The default value is "false". Tells
     * whether an output parameter may emit a value to the exclusion of the other outputs.
     * @see org.andromda.metafacades.uml.ParameterFacade#isException()
     */
    public boolean isException()
    {
        return this.getSuperJSFParameter().isException();
    }

    /**
     * True if this parameter is an 'in' parameter.
     * @see org.andromda.metafacades.uml.ParameterFacade#isInParameter()
     */
    public boolean isInParameter()
    {
        return this.getSuperJSFParameter().isInParameter();
    }

    /**
     * True if this parameter is an inout parameter.
     * @see org.andromda.metafacades.uml.ParameterFacade#isInoutParameter()
     */
    public boolean isInoutParameter()
    {
        return this.getSuperJSFParameter().isInoutParameter();
    }

    /**
     * If upper>1 or upper==unlimited. Only applies to UML2. For UML14, always false.
     * @see org.andromda.metafacades.uml.ParameterFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperJSFParameter().isMany();
    }

    /**
     * UML2 Only: Is parameter ordered within the Collection type. Ordered+Unique determines the
     * implementation Collection Type. For UML14, always false.
     * @see org.andromda.metafacades.uml.ParameterFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperJSFParameter().isOrdered();
    }

    /**
     * True if this parameter is an 'out' parameter.
     * @see org.andromda.metafacades.uml.ParameterFacade#isOutParameter()
     */
    public boolean isOutParameter()
    {
        return this.getSuperJSFParameter().isOutParameter();
    }

    /**
     * True if this parameter is readable, aka an in-parameter, or this feature is unspecified.
     * @see org.andromda.metafacades.uml.ParameterFacade#isReadable()
     */
    public boolean isReadable()
    {
        return this.getSuperJSFParameter().isReadable();
    }

    /**
     * Whether or not this parameter is considered required (i.e must a non-empty value).
     * @see org.andromda.metafacades.uml.ParameterFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperJSFParameter().isRequired();
    }

    /**
     * Whether or not this parameter represents a return parameter.
     * @see org.andromda.metafacades.uml.ParameterFacade#isReturn()
     */
    public boolean isReturn()
    {
        return this.getSuperJSFParameter().isReturn();
    }

    /**
     * If Parameter type isMany (UML2), is the parameter unique within the Collection. Unique+Sorted
     * determines pareter implementation type. For UML14, always false.
     * @see org.andromda.metafacades.uml.ParameterFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperJSFParameter().isUnique();
    }

    /**
     * True if this parameter is writable, aka an out-parameter, or this feature is unspecified.
     * @see org.andromda.metafacades.uml.ParameterFacade#isWritable()
     */
    public boolean isWritable()
    {
        return this.getSuperJSFParameter().isWritable();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperJSFParameter().initialize();
    }

    /**
     * @return Object getSuperJSFParameter().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperJSFParameter().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperJSFParameter().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperJSFParameter().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperJSFParameter().validateInvariants(validationMessages);
    }

    /**
     * The property that stores the name of the metafacade.
     */
    private static final String NAME_PROPERTY = "name";
    private static final String FQNAME_PROPERTY = "fullyQualifiedName";

    /**
     * @see Object#toString()
     */
    @Override
    public String toString()
    {
        final StringBuilder toString = new StringBuilder(this.getClass().getName());
        toString.append("[");
        try
        {
            toString.append(Introspector.instance().getProperty(this, FQNAME_PROPERTY));
        }
        catch (final Throwable tryAgain)
        {
            try
            {
                toString.append(Introspector.instance().getProperty(this, NAME_PROPERTY));
            }
            catch (final Throwable ignore)
            {
                // - just ignore when the metafacade doesn't have a name or fullyQualifiedName property
            }
        }
        toString.append("]");
        return toString.toString();
    }
}