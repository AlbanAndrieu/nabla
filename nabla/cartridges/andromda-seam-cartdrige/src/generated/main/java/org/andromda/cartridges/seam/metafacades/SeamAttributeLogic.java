// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import java.util.Collection;
import org.andromda.cartridges.jsf.metafacades.JSFAttribute;
import org.andromda.cartridges.jsf.metafacades.JSFParameter;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EnumerationFacade;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for SeamAttribute
 *
 * @see SeamAttribute
 */
public abstract class SeamAttributeLogic
    extends MetafacadeBase
    implements SeamAttribute
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
    protected SeamAttributeLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superJSFAttribute =
           (JSFAttribute)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.cartridges.jsf.metafacades.JSFAttribute",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to SeamAttribute if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.seam.metafacades.SeamAttribute";
        }
        return context;
    }

    private JSFAttribute superJSFAttribute;
    private boolean superJSFAttributeInitialized = false;

    /**
     * Gets the JSFAttribute parent instance.
     * @return this.superJSFAttribute JSFAttribute
     */
    private JSFAttribute getSuperJSFAttribute()
    {
        if (!this.superJSFAttributeInitialized)
        {
            ((MetafacadeBase)this.superJSFAttribute).setMetafacadeContext(this.getMetafacadeContext());
            this.superJSFAttributeInitialized = true;
        }
        return this.superJSFAttribute;
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
            if (this.superJSFAttributeInitialized)
            {
                ((MetafacadeBase)this.superJSFAttribute).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see SeamAttribute
     */
    public boolean isSeamAttributeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see JSFAttribute
     */
    public boolean isJSFAttributeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.AttributeFacade
     */
    public boolean isAttributeFacadeMetaType()
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

    // ----------- delegates to JSFAttribute ------------
    /**
     * Gets backing list name for this attribute. This is useful if you want to be able to select
     * the attribute value from a list (i.e. a drop-down select input type).
     * @see JSFAttribute#getBackingListName(ParameterFacade ownerParameter)
     */
    public String getBackingListName(ParameterFacade ownerParameter)
    {
        return this.getSuperJSFAttribute().getBackingListName(ownerParameter);
    }

    /**
     * Constructs and returns the backing value name given the 'ownerParameter'.
     * @see JSFAttribute#getBackingValueName(ParameterFacade ownerParameter)
     */
    public String getBackingValueName(ParameterFacade ownerParameter)
    {
        return this.getSuperJSFAttribute().getBackingValueName(ownerParameter);
    }

    /**
     * Gets the name of the date formatter for this attribute by constructing the name from the
     * 'ownerParameter' (if this attribute represents a date).
     * @see JSFAttribute#getDateFormatter(JSFParameter ownerParameter)
     */
    public String getDateFormatter(JSFParameter ownerParameter)
    {
        return this.getSuperJSFAttribute().getDateFormatter(ownerParameter);
    }

    /**
     * The dummy value to give the attribute when creating a dummy instance of this attribute's
     * owner.
     * @see JSFAttribute#getDummyValue()
     */
    public String getDummyValue()
    {
        return this.getSuperJSFAttribute().getDummyValue();
    }

    /**
     * Gets the unique id of this attribute on the form.
     * @see JSFAttribute#getFormPropertyId(ParameterFacade ownerParameter)
     */
    public String getFormPropertyId(ParameterFacade ownerParameter)
    {
        return this.getSuperJSFAttribute().getFormPropertyId(ownerParameter);
    }

    /**
     * Retrieves the name of the form property for this attribute by taking the name of the owner
     * property.
     * @see JSFAttribute#getFormPropertyName(ParameterFacade ownerParameter)
     */
    public String getFormPropertyName(ParameterFacade ownerParameter)
    {
        return this.getSuperJSFAttribute().getFormPropertyName(ownerParameter);
    }

    /**
     * If this attributes represents a date or time this method will return the format in which it
     * must be represented. In the event this format has not been specified by the any tagged value
     * the default will be used.
     * @see JSFAttribute#getFormat()
     */
    public String getFormat()
    {
        return this.getSuperJSFAttribute().getFormat();
    }

    /**
     * A comma seperated list of the input table identifier columns (these are the columns that
     * uniquely define a row in an input table).
     * @see JSFAttribute#getInputTableIdentifierColumns()
     */
    public String getInputTableIdentifierColumns()
    {
        return this.getSuperJSFAttribute().getInputTableIdentifierColumns();
    }

    /**
     * Gets the name of the label list for this parameter. The label list name is the name of the
     * list storing the labels for the possible values of this attribute (typically used for the
     * labels of a drop-down select lists).
     * @see JSFAttribute#getLabelListName(ParameterFacade ownerParameter)
     */
    public String getLabelListName(ParameterFacade ownerParameter)
    {
        return this.getSuperJSFAttribute().getLabelListName(ownerParameter);
    }

    /**
     * The max length allowed in the input component
     * @see JSFAttribute#getMaxLength()
     */
    public String getMaxLength()
    {
        return this.getSuperJSFAttribute().getMaxLength();
    }

    /**
     * The message key for this attribute.
     * @see JSFAttribute#getMessageKey()
     */
    public String getMessageKey()
    {
        return this.getSuperJSFAttribute().getMessageKey();
    }

    /**
     * The default value for the message key.
     * @see JSFAttribute#getMessageValue()
     */
    public String getMessageValue()
    {
        return this.getSuperJSFAttribute().getMessageValue();
    }

    /**
     * Gets the name of the time formatter (if this parameter represents a time).
     * @see JSFAttribute#getTimeFormatter(JSFParameter ownerParameter)
     */
    public String getTimeFormatter(JSFParameter ownerParameter)
    {
        return this.getSuperJSFAttribute().getTimeFormatter(ownerParameter);
    }

    /**
     * The validator's 'validwhen' value, this is useful when the validation of a parameter depends
     * on the validation of others. See the apache commons-validator documentation for more
     * information.
     * @see JSFAttribute#getValidWhen()
     */
    public String getValidWhen()
    {
        return this.getSuperJSFAttribute().getValidWhen();
    }

    /**
     * Gets the arguments for this parameter's validators.
     * @see JSFAttribute#getValidatorArgs(String validatorType)
     */
    public Collection getValidatorArgs(String validatorType)
    {
        return this.getSuperJSFAttribute().getValidatorArgs(validatorType);
    }

    /**
     * All validator types for this attribute.
     * @see JSFAttribute#getValidatorTypes()
     */
    public Collection getValidatorTypes()
    {
        return this.getSuperJSFAttribute().getValidatorTypes();
    }

    /**
     * Gets the validator args for this attribute
     * @see JSFAttribute#getValidatorVars(JSFParameter ownerParameter)
     */
    public Collection getValidatorVars(JSFParameter ownerParameter)
    {
        return this.getSuperJSFAttribute().getValidatorVars(ownerParameter);
    }

    /**
     * The dummy value for a value list.
     * @see JSFAttribute#getValueListDummyValue()
     */
    public String getValueListDummyValue()
    {
        return this.getSuperJSFAttribute().getValueListDummyValue();
    }

    /**
     * Gets the name of the value list for this parameter; this list stores the possible values that
     * this attribute may be (typically used for the values of a drop-down select list).
     * @see JSFAttribute#getValueListName(ParameterFacade ownerParameter)
     */
    public String getValueListName(ParameterFacade ownerParameter)
    {
        return this.getSuperJSFAttribute().getValueListName(ownerParameter);
    }

    /**
     * Indicates whether or not the backing value is required for this attribute (depending on the
     * 'ownerParameter').
     * @see JSFAttribute#isBackingValueRequired(FrontEndParameter ownerParameter)
     */
    public boolean isBackingValueRequired(FrontEndParameter ownerParameter)
    {
        return this.getSuperJSFAttribute().isBackingValueRequired(ownerParameter);
    }

    /**
     * Indicates whether or not this parameter uses the equal validator.
     * @see JSFAttribute#isEqualValidator()
     */
    public boolean isEqualValidator()
    {
        return this.getSuperJSFAttribute().isEqualValidator();
    }

    /**
     * Indicates if this parameter represents a checkbox widget.
     * @see JSFAttribute#isInputCheckbox()
     */
    public boolean isInputCheckbox()
    {
        return this.getSuperJSFAttribute().isInputCheckbox();
    }

    /**
     * Indicates whether or not this is a file input type.
     * @see JSFAttribute#isInputFile()
     */
    public boolean isInputFile()
    {
        return this.getSuperJSFAttribute().isInputFile();
    }

    /**
     * Indicates whether or not this parameter represents a hidden input widget.
     * @see JSFAttribute#isInputHidden()
     */
    public boolean isInputHidden()
    {
        return this.getSuperJSFAttribute().isInputHidden();
    }

    /**
     * Indicates whether or not this type represents an input multibox.
     * @see JSFAttribute#isInputMultibox()
     */
    public boolean isInputMultibox()
    {
        return this.getSuperJSFAttribute().isInputMultibox();
    }

    /**
     * Indicates whether or not this parameter should be rendered as an input radio widget.
     * @see JSFAttribute#isInputRadio()
     */
    public boolean isInputRadio()
    {
        return this.getSuperJSFAttribute().isInputRadio();
    }

    /**
     * Indicates whether or not this parameter represents an input "secret" widget (i.e. password).
     * @see JSFAttribute#isInputSecret()
     */
    public boolean isInputSecret()
    {
        return this.getSuperJSFAttribute().isInputSecret();
    }

    /**
     * Indicates whether or not this parameter represents an input select widget.
     * @see JSFAttribute#isInputSelect()
     */
    public boolean isInputSelect()
    {
        return this.getSuperJSFAttribute().isInputSelect();
    }

    /**
     * Indicates whether or not this is an table input type.
     * @see JSFAttribute#isInputTable()
     */
    public boolean isInputTable()
    {
        return this.getSuperJSFAttribute().isInputTable();
    }

    /**
     * Indicates whether or not this parameter should be rendered as a text input widget.
     * @see JSFAttribute#isInputText()
     */
    public boolean isInputText()
    {
        return this.getSuperJSFAttribute().isInputText();
    }

    /**
     * Indicates if this parameter represents as an input text area widget.
     * @see JSFAttribute#isInputTextarea()
     */
    public boolean isInputTextarea()
    {
        return this.getSuperJSFAttribute().isInputTextarea();
    }

    /**
     * Indicates whether or not there is an input type defined for this attribute.
     * @see JSFAttribute#isInputTypePresent()
     */
    public boolean isInputTypePresent()
    {
        return this.getSuperJSFAttribute().isInputTypePresent();
    }

    /**
     * Indicates whether or not this attribute's value should be rendered as plain text (not as a
     * widget).
     * @see JSFAttribute#isPlaintext()
     */
    public boolean isPlaintext()
    {
        return this.getSuperJSFAttribute().isPlaintext();
    }

    /**
     * Indicates whether or not this attribute is selectable according to its 'ownerParameter'.
     * @see JSFAttribute#isSelectable(FrontEndParameter ownerParameter)
     */
    public boolean isSelectable(FrontEndParameter ownerParameter)
    {
        return this.getSuperJSFAttribute().isSelectable(ownerParameter);
    }

    /**
     * Indicates where or not the date format is to be strictly respected. Otherwise the date
     * formatter used for the representation of this date is to be set to lenient.
     * @see JSFAttribute#isStrictDateFormat()
     */
    public boolean isStrictDateFormat()
    {
        return this.getSuperJSFAttribute().isStrictDateFormat();
    }

    /**
     * Indicates whether or not this attribute requires some kind of validation (the collection of
     * validator types is not empty).
     * @see JSFAttribute#isValidationRequired()
     */
    public boolean isValidationRequired()
    {
        return this.getSuperJSFAttribute().isValidationRequired();
    }

    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class attribute
     * to the class itself and then up the class hierarchy.
     * @see org.andromda.metafacades.uml.AttributeFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperJSFAttribute().findTaggedValue(name, follow);
    }

    /**
     * The default value of the attribute.  This is the value given if no value is defined.
     * @see org.andromda.metafacades.uml.AttributeFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {
        return this.getSuperJSFAttribute().getDefaultValue();
    }

    /**
     * If the attribute is an enumeration literal this represents the owning enumeration. Can be
     * empty.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumeration()
     */
    public EnumerationFacade getEnumeration()
    {
        return this.getSuperJSFAttribute().getEnumeration();
    }

    /**
     * Returns the enumeration literal parameters defined by tagged value as a comma separated list.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumerationLiteralParameters()
     */
    public String getEnumerationLiteralParameters()
    {
        return this.getSuperJSFAttribute().getEnumerationLiteralParameters();
    }

    /**
     * The value for this attribute if it is an enumeration literal, null otherwise. The default
     * value is returned as a String if it has been specified, if it's not specified this
     * attribute's name is assumed.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumerationValue()
     */
    public String getEnumerationValue()
    {
        return this.getSuperJSFAttribute().getEnumerationValue();
    }

    /**
     * The name of the accessor operation that would retrieve this attribute's value.
     * @see org.andromda.metafacades.uml.AttributeFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperJSFAttribute().getGetterName();
    }

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @see org.andromda.metafacades.uml.AttributeFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperJSFAttribute().getGetterSetterTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.AttributeFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperJSFAttribute().getLower();
    }

    /**
     * Gets the classifier who is the owner of the attributes.
     * @see org.andromda.metafacades.uml.AttributeFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperJSFAttribute().getOwner();
    }

    /**
     * The name of the mutator operation that would retrieve this attribute's value.
     * @see org.andromda.metafacades.uml.AttributeFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperJSFAttribute().getSetterName();
    }

    /**
     * The classifier owning this attribute.
     * @see org.andromda.metafacades.uml.AttributeFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperJSFAttribute().getType();
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.AttributeFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperJSFAttribute().getUpper();
    }

    /**
     * True if this attribute can only be set.
     * @see org.andromda.metafacades.uml.AttributeFacade#isAddOnly()
     */
    public boolean isAddOnly()
    {
        return this.getSuperJSFAttribute().isAddOnly();
    }

    /**
     * True if this attribute can be modified.
     * @see org.andromda.metafacades.uml.AttributeFacade#isChangeable()
     */
    public boolean isChangeable()
    {
        return this.getSuperJSFAttribute().isChangeable();
    }

    /**
     * Indicates if the default value is present.
     * @see org.andromda.metafacades.uml.AttributeFacade#isDefaultValuePresent()
     */
    public boolean isDefaultValuePresent()
    {
        return this.getSuperJSFAttribute().isDefaultValuePresent();
    }

    /**
     * If the attribute is derived (its value is computed). UML2 only. UML14 always returns false.
     * Default=false.
     * @see org.andromda.metafacades.uml.AttributeFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperJSFAttribute().isDerived();
    }

    /**
     * True if this attribute is owned by an enumeration.
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationLiteral()
     */
    public boolean isEnumerationLiteral()
    {
        return this.getSuperJSFAttribute().isEnumerationLiteral();
    }

    /**
     * Returns true if enumeration literal parameters exist (defined by tagged value) for the
     * literal.
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationLiteralParametersExist()
     */
    public boolean isEnumerationLiteralParametersExist()
    {
        return this.getSuperJSFAttribute().isEnumerationLiteralParametersExist();
    }

    /**
     * True if this attribute is owned by an enumeration but is defined as a member variable (NOT a
     * literal).
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationMember()
     */
    public boolean isEnumerationMember()
    {
        return this.getSuperJSFAttribute().isEnumerationMember();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant.
     * @see org.andromda.metafacades.uml.AttributeFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperJSFAttribute().isLeaf();
    }

    /**
     * Whether or not this attribute has a multiplicity greater than 1.
     * @see org.andromda.metafacades.uml.AttributeFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperJSFAttribute().isMany();
    }

    /**
     * Indicates whether or not the attributes are ordered (if multiplicity is greater than 1).
     * @see org.andromda.metafacades.uml.AttributeFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperJSFAttribute().isOrdered();
    }

    /**
     * Whether or not this attribute can be modified.
     * @see org.andromda.metafacades.uml.AttributeFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperJSFAttribute().isReadOnly();
    }

    /**
     * Whether or not the multiplicity of this attribute is 1.
     * @see org.andromda.metafacades.uml.AttributeFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperJSFAttribute().isRequired();
    }

    /**
     * Indicates if this attribute is 'static', meaning it has a classifier scope.
     * @see org.andromda.metafacades.uml.AttributeFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperJSFAttribute().isStatic();
    }

    /**
     * If the attribute is unique within the Collection type. UML2 only. UML14 always returns false.
     * Unique+Ordered determines the implementation Collection type. Default=false.
     * @see org.andromda.metafacades.uml.AttributeFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperJSFAttribute().isUnique();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperJSFAttribute().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperJSFAttribute().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperJSFAttribute().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperJSFAttribute().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperJSFAttribute().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperJSFAttribute().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperJSFAttribute().getDocumentation(indent);
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
        return this.getSuperJSFAttribute().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperJSFAttribute().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperJSFAttribute().getFullyQualifiedName();
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
        return this.getSuperJSFAttribute().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperJSFAttribute().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperJSFAttribute().getId();
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
        return this.getSuperJSFAttribute().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperJSFAttribute().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperJSFAttribute().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperJSFAttribute().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperJSFAttribute().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperJSFAttribute().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperJSFAttribute().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperJSFAttribute().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperJSFAttribute().getPackagePath();
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
        return this.getSuperJSFAttribute().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperJSFAttribute().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperJSFAttribute().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperJSFAttribute().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperJSFAttribute().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperJSFAttribute().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperJSFAttribute().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperJSFAttribute().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperJSFAttribute().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperJSFAttribute().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperJSFAttribute().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperJSFAttribute().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperJSFAttribute().hasKeyword(keywordName);
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
        return this.getSuperJSFAttribute().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperJSFAttribute().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperJSFAttribute().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperJSFAttribute().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperJSFAttribute().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperJSFAttribute().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperJSFAttribute().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperJSFAttribute().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperJSFAttribute().translateConstraints(kind, translation);
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperJSFAttribute().initialize();
    }

    /**
     * @return Object getSuperJSFAttribute().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperJSFAttribute().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperJSFAttribute().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperJSFAttribute().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperJSFAttribute().validateInvariants(validationMessages);
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