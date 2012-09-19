// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
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
import org.andromda.metafacades.uml.FrontEndParameter;
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
import org.andromda.translation.ocl.validation.OCLCollections;
import org.andromda.translation.ocl.validation.OCLExpressions;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.commons.collections.Predicate;
import org.apache.log4j.Logger;

/**
 * A Gui parameter is an object communicated between the client and the server. Typically form beans
 * encapsulate such parameters.
 * MetafacadeLogic for GuiParameter
 *
 * @see GuiParameter
 */
public abstract class GuiParameterLogic
    extends MetafacadeBase
    implements GuiParameter
{

    private static final long serialVersionUID = 1L;
    
    /**
     * The underlying UML object
     * @see Object
     */
    protected transient Object metaObject;

    /** Create Metafacade implementation instance using the MetafacadeFactory from the context
     * @param metaObjectIn
     * @param context
     */
    protected GuiParameterLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superFrontEndParameter =
           (FrontEndParameter)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.FrontEndParameter",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiParameterLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiParameter if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiParameter";
        }
        return context;
    }

    private FrontEndParameter superFrontEndParameter;
    private boolean superFrontEndParameterInitialized = false;

    /**
     * Gets the FrontEndParameter parent instance.
     * @return this.superFrontEndParameter FrontEndParameter
     */
    private FrontEndParameter getSuperFrontEndParameter()
    {
        if (!this.superFrontEndParameterInitialized)
        {
            ((MetafacadeBase)this.superFrontEndParameter).setMetafacadeContext(this.getMetafacadeContext());
            this.superFrontEndParameterInitialized = true;
        }
        return this.superFrontEndParameter;
    }

    /** Reset context only for non-root metafacades
     * @param context
     * @see MetafacadeBase#resetMetafacadeContext(String context)
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
            if (this.superFrontEndParameterInitialized)
            {
                ((MetafacadeBase)this.superFrontEndParameter).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see GuiParameter
     */
    public boolean isGuiParameterMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see GuiParameter#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private String messageKey1a;
    private boolean messageKey1aSet = false;

    /**
     * The default message key for this parameter.
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String amessageKey1a = this.messageKey1a;
        if (!this.messageKey1aSet)
        {
            // messageKey has no pre constraints
            amessageKey1a = handleGetMessageKey();
            // messageKey has no post constraints
            this.messageKey1a = amessageKey1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageKey1aSet = true;
            }
        }
        return amessageKey1a;
    }

   /**
    * @see GuiParameter#getMessageValue()
    * @return String
    */
    protected abstract String handleGetMessageValue();

    private String messageValue2a;
    private boolean messageValue2aSet = false;

    /**
     * The default message value for this parameter.
     * @return (String)handleGetMessageValue()
     */
    public final String getMessageValue()
    {
        String amessageValue2a = this.messageValue2a;
        if (!this.messageValue2aSet)
        {
            // messageValue has no pre constraints
            amessageValue2a = handleGetMessageValue();
            // messageValue has no post constraints
            this.messageValue2a = amessageValue2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageValue2aSet = true;
            }
        }
        return amessageValue2a;
    }

   /**
    * @see GuiParameter#getTitleKey()
    * @return String
    */
    protected abstract String handleGetTitleKey();

    private String titleKey3a;
    private boolean titleKey3aSet = false;

    /**
     * 
     * @return (String)handleGetTitleKey()
     */
    public final String getTitleKey()
    {
        String atitleKey3a = this.titleKey3a;
        if (!this.titleKey3aSet)
        {
            // titleKey has no pre constraints
            atitleKey3a = handleGetTitleKey();
            // titleKey has no post constraints
            this.titleKey3a = atitleKey3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.titleKey3aSet = true;
            }
        }
        return atitleKey3a;
    }

   /**
    * @see GuiParameter#getTitleValue()
    * @return String
    */
    protected abstract String handleGetTitleValue();

    private String titleValue4a;
    private boolean titleValue4aSet = false;

    /**
     * 
     * @return (String)handleGetTitleValue()
     */
    public final String getTitleValue()
    {
        String atitleValue4a = this.titleValue4a;
        if (!this.titleValue4aSet)
        {
            // titleValue has no pre constraints
            atitleValue4a = handleGetTitleValue();
            // titleValue has no post constraints
            this.titleValue4a = atitleValue4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.titleValue4aSet = true;
            }
        }
        return atitleValue4a;
    }

   /**
    * @see GuiParameter#isMultiple()
    * @return boolean
    */
    protected abstract boolean handleIsMultiple();

    private boolean multiple5a;
    private boolean multiple5aSet = false;

    /**
     * True if this parameter is either an array type or Collection type.
     * @return (boolean)handleIsMultiple()
     */
    public final boolean isMultiple()
    {
        boolean amultiple5a = this.multiple5a;
        if (!this.multiple5aSet)
        {
            // multiple has no pre constraints
            amultiple5a = handleIsMultiple();
            // multiple has no post constraints
            this.multiple5a = amultiple5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.multiple5aSet = true;
            }
        }
        return amultiple5a;
    }

   /**
    * @see GuiParameter#getBackingListName()
    * @return String
    */
    protected abstract String handleGetBackingListName();

    private String backingListName6a;
    private boolean backingListName6aSet = false;

    /**
     * The backing list name for this parameter. This is useful if you want to be able to select the
     * parameter value from a list.
     * @return (String)handleGetBackingListName()
     */
    public final String getBackingListName()
    {
        String abackingListName6a = this.backingListName6a;
        if (!this.backingListName6aSet)
        {
            // backingListName has no pre constraints
            abackingListName6a = handleGetBackingListName();
            // backingListName has no post constraints
            this.backingListName6a = abackingListName6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.backingListName6aSet = true;
            }
        }
        return abackingListName6a;
    }

   /**
    * @see GuiParameter#isResetRequired()
    * @return boolean
    */
    protected abstract boolean handleIsResetRequired();

    private boolean resetRequired7a;
    private boolean resetRequired7aSet = false;

    /**
     * True if the value of this parameter must be reset between requests (Gui requires this for
     * specific types), false otherwise.
     * @return (boolean)handleIsResetRequired()
     */
    public final boolean isResetRequired()
    {
        boolean aresetRequired7a = this.resetRequired7a;
        if (!this.resetRequired7aSet)
        {
            // resetRequired has no pre constraints
            aresetRequired7a = handleIsResetRequired();
            // resetRequired has no post constraints
            this.resetRequired7a = aresetRequired7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetRequired7aSet = true;
            }
        }
        return aresetRequired7a;
    }

   /**
    * @see GuiParameter#getNullValue()
    * @return String
    */
    protected abstract String handleGetNullValue();

    private String nullValue8a;
    private boolean nullValue8aSet = false;

    /**
     * The null value for the type of this parameter. For decimals this would be zero, for booleans
     * this would be 'false', etc...
     * @return (String)handleGetNullValue()
     */
    public final String getNullValue()
    {
        String anullValue8a = this.nullValue8a;
        if (!this.nullValue8aSet)
        {
            // nullValue has no pre constraints
            anullValue8a = handleGetNullValue();
            // nullValue has no post constraints
            this.nullValue8a = anullValue8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.nullValue8aSet = true;
            }
        }
        return anullValue8a;
    }

   /**
    * @see GuiParameter#getWidgetType()
    * @return String
    */
    protected abstract String handleGetWidgetType();

    private String widgetType9a;
    private boolean widgetType9aSet = false;

    /**
     * The widget type for this parameter, this value is the tagname for the Gui HTML taglib. This
     * method is useful only when rendering forms.
     * @return (String)handleGetWidgetType()
     */
    public final String getWidgetType()
    {
        String awidgetType9a = this.widgetType9a;
        if (!this.widgetType9aSet)
        {
            // widgetType has no pre constraints
            awidgetType9a = handleGetWidgetType();
            // widgetType has no post constraints
            this.widgetType9a = awidgetType9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.widgetType9aSet = true;
            }
        }
        return awidgetType9a;
    }

   /**
    * @see GuiParameter#getResetValue()
    * @return String
    */
    protected abstract String handleGetResetValue();

    private String resetValue10a;
    private boolean resetValue10aSet = false;

    /**
     * The reset value for this parameter. The reset value is the non-null value to which this
     * parameter is set by default between requests, you can use this method to be able to generate
     * an application that will deploy and run with default data.
     * @return (String)handleGetResetValue()
     */
    public final String getResetValue()
    {
        String aresetValue10a = this.resetValue10a;
        if (!this.resetValue10aSet)
        {
            // resetValue has no pre constraints
            aresetValue10a = handleGetResetValue();
            // resetValue has no post constraints
            this.resetValue10a = aresetValue10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetValue10aSet = true;
            }
        }
        return aresetValue10a;
    }

   /**
    * @see GuiParameter#isReadOnly()
    * @return boolean
    */
    protected abstract boolean handleIsReadOnly();

    private boolean readOnly11a;
    private boolean readOnly11aSet = false;

    /**
     * True if this parameter cannot be changed by the user, false otherwise.
     * @return (boolean)handleIsReadOnly()
     */
    public final boolean isReadOnly()
    {
        boolean areadOnly11a = this.readOnly11a;
        if (!this.readOnly11aSet)
        {
            // readOnly has no pre constraints
            areadOnly11a = handleIsReadOnly();
            // readOnly has no post constraints
            this.readOnly11a = areadOnly11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.readOnly11aSet = true;
            }
        }
        return areadOnly11a;
    }

   /**
    * @see GuiParameter#getValueListResetValue()
    * @return String
    */
    protected abstract String handleGetValueListResetValue();

    private String valueListResetValue12a;
    private boolean valueListResetValue12aSet = false;

    /**
     * The reset value for this parameter's value list. Only makes sense if this parameter is
     * selectable.
     * @return (String)handleGetValueListResetValue()
     */
    public final String getValueListResetValue()
    {
        String avalueListResetValue12a = this.valueListResetValue12a;
        if (!this.valueListResetValue12aSet)
        {
            // valueListResetValue has no pre constraints
            avalueListResetValue12a = handleGetValueListResetValue();
            // valueListResetValue has no post constraints
            this.valueListResetValue12a = avalueListResetValue12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.valueListResetValue12aSet = true;
            }
        }
        return avalueListResetValue12a;
    }

   /**
    * @see GuiParameter#getValidatorTypes()
    * @return Collection
    */
    protected abstract Collection handleGetValidatorTypes();

    private Collection validatorTypes13a;
    private boolean validatorTypes13aSet = false;

    /**
     * A collection of all the validator types for this parameter. Use this value in conjunction
     * with the Gui validator plugin.
     * @return (Collection)handleGetValidatorTypes()
     */
    public final Collection getValidatorTypes()
    {
        Collection avalidatorTypes13a = this.validatorTypes13a;
        if (!this.validatorTypes13aSet)
        {
            // validatorTypes has no pre constraints
            avalidatorTypes13a = handleGetValidatorTypes();
            // validatorTypes has no post constraints
            this.validatorTypes13a = avalidatorTypes13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validatorTypes13aSet = true;
            }
        }
        return avalidatorTypes13a;
    }

   /**
    * @see GuiParameter#getValidatorMsgKey()
    * @return String
    */
    protected abstract String handleGetValidatorMsgKey();

    private String validatorMsgKey14a;
    private boolean validatorMsgKey14aSet = false;

    /**
     * The message key for this parameter, equivalent to getMessageKey().
     * @return (String)handleGetValidatorMsgKey()
     */
    public final String getValidatorMsgKey()
    {
        String avalidatorMsgKey14a = this.validatorMsgKey14a;
        if (!this.validatorMsgKey14aSet)
        {
            // validatorMsgKey has no pre constraints
            avalidatorMsgKey14a = handleGetValidatorMsgKey();
            // validatorMsgKey has no post constraints
            this.validatorMsgKey14a = avalidatorMsgKey14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validatorMsgKey14aSet = true;
            }
        }
        return avalidatorMsgKey14a;
    }

   /**
    * @see GuiParameter#getValidatorVars()
    * @return Collection
    */
    protected abstract Collection handleGetValidatorVars();

    private Collection validatorVars15a;
    private boolean validatorVars15aSet = false;

    /**
     * The validator arguments.
     * @return (Collection)handleGetValidatorVars()
     */
    public final Collection getValidatorVars()
    {
        Collection avalidatorVars15a = this.validatorVars15a;
        if (!this.validatorVars15aSet)
        {
            // validatorVars has no pre constraints
            avalidatorVars15a = handleGetValidatorVars();
            // validatorVars has no post constraints
            this.validatorVars15a = avalidatorVars15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validatorVars15aSet = true;
            }
        }
        return avalidatorVars15a;
    }

   /**
    * @see GuiParameter#getValidWhen()
    * @return String
    */
    protected abstract String handleGetValidWhen();

    private String validWhen16a;
    private boolean validWhen16aSet = false;

    /**
     * The validator's 'validwhen' value, this is useful when the validation of a parameter depends
     * on the validation of others. See the Gui validator plugin documentation for more information.
     * @return (String)handleGetValidWhen()
     */
    public final String getValidWhen()
    {
        String avalidWhen16a = this.validWhen16a;
        if (!this.validWhen16aSet)
        {
            // validWhen has no pre constraints
            avalidWhen16a = handleGetValidWhen();
            // validWhen has no post constraints
            this.validWhen16a = avalidWhen16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validWhen16aSet = true;
            }
        }
        return avalidWhen16a;
    }

   /**
    * @see GuiParameter#getOptionKeys()
    * @return List
    */
    protected abstract List handleGetOptionKeys();

    private List optionKeys17a;
    private boolean optionKeys17aSet = false;

    /**
     * If this parameter is a choice between radio buttons, then you may use this method to retrieve
     * the message keys for the resource bundle. The message keys hold the value to be displayed for
     * the possible options.
     * @return (List)handleGetOptionKeys()
     */
    public final List getOptionKeys()
    {
        List aoptionKeys17a = this.optionKeys17a;
        if (!this.optionKeys17aSet)
        {
            // optionKeys has no pre constraints
            aoptionKeys17a = handleGetOptionKeys();
            // optionKeys has no post constraints
            this.optionKeys17a = aoptionKeys17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.optionKeys17aSet = true;
            }
        }
        return aoptionKeys17a;
    }

   /**
    * @see GuiParameter#getTableMaxRows()
    * @return int
    */
    protected abstract int handleGetTableMaxRows();

    private int tableMaxRows18a;
    private boolean tableMaxRows18aSet = false;

    /**
     * The maximum number of rows to be displayed in the table at the same time. This is also known
     * as the page size. A value of zero or less will display all data in the same table (therefore
     * also on the same page).
     * @return (int)handleGetTableMaxRows()
     */
    public final int getTableMaxRows()
    {
        int atableMaxRows18a = this.tableMaxRows18a;
        if (!this.tableMaxRows18aSet)
        {
            // tableMaxRows has no pre constraints
            atableMaxRows18a = handleGetTableMaxRows();
            // tableMaxRows has no post constraints
            this.tableMaxRows18a = atableMaxRows18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableMaxRows18aSet = true;
            }
        }
        return atableMaxRows18a;
    }

   /**
    * @see GuiParameter#isTableExportable()
    * @return boolean
    */
    protected abstract boolean handleIsTableExportable();

    private boolean tableExportable19a;
    private boolean tableExportable19aSet = false;

    /**
     * True if it is possible to export the table data to XML, CSV, PDF or Excel format.
     * @return (boolean)handleIsTableExportable()
     */
    public final boolean isTableExportable()
    {
        boolean atableExportable19a = this.tableExportable19a;
        if (!this.tableExportable19aSet)
        {
            // tableExportable has no pre constraints
            atableExportable19a = handleIsTableExportable();
            // tableExportable has no post constraints
            this.tableExportable19a = atableExportable19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableExportable19aSet = true;
            }
        }
        return atableExportable19a;
    }

   /**
    * @see GuiParameter#isTableSortable()
    * @return boolean
    */
    protected abstract boolean handleIsTableSortable();

    private boolean tableSortable20a;
    private boolean tableSortable20aSet = false;

    /**
     * True if it is possible to sort the columns of the table.
     * @return (boolean)handleIsTableSortable()
     */
    public final boolean isTableSortable()
    {
        boolean atableSortable20a = this.tableSortable20a;
        if (!this.tableSortable20aSet)
        {
            // tableSortable has no pre constraints
            atableSortable20a = handleIsTableSortable();
            // tableSortable has no post constraints
            this.tableSortable20a = atableSortable20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableSortable20aSet = true;
            }
        }
        return atableSortable20a;
    }

   /**
    * @see GuiParameter#getTableExportTypes()
    * @return String
    */
    protected abstract String handleGetTableExportTypes();

    private String tableExportTypes21a;
    private boolean tableExportTypes21aSet = false;

    /**
     * Tthe available types of export in a single String instance.
     * @return (String)handleGetTableExportTypes()
     */
    public final String getTableExportTypes()
    {
        String atableExportTypes21a = this.tableExportTypes21a;
        if (!this.tableExportTypes21aSet)
        {
            // tableExportTypes has no pre constraints
            atableExportTypes21a = handleGetTableExportTypes();
            // tableExportTypes has no post constraints
            this.tableExportTypes21a = atableExportTypes21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableExportTypes21aSet = true;
            }
        }
        return atableExportTypes21a;
    }

   /**
    * @see GuiParameter#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private boolean validationRequired22a;
    private boolean validationRequired22aSet = false;

    /**
     * True if this parameter requires some kind of validation. This means the collection of
     * validator types is not empty.
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean avalidationRequired22a = this.validationRequired22a;
        if (!this.validationRequired22aSet)
        {
            // validationRequired has no pre constraints
            avalidationRequired22a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.validationRequired22a = avalidationRequired22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validationRequired22aSet = true;
            }
        }
        return avalidationRequired22a;
    }

   /**
    * @see GuiParameter#isDate()
    * @return boolean
    */
    protected abstract boolean handleIsDate();

    private boolean date23a;
    private boolean date23aSet = false;

    /**
     * True if the type of this parameter represents a date. This is equivalent to
     * parameter.type.isDateType().
     * @return (boolean)handleIsDate()
     */
    public final boolean isDate()
    {
        boolean adate23a = this.date23a;
        if (!this.date23aSet)
        {
            // date has no pre constraints
            adate23a = handleIsDate();
            // date has no post constraints
            this.date23a = adate23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.date23aSet = true;
            }
        }
        return adate23a;
    }

   /**
    * @see GuiParameter#getDateFormat()
    * @return String
    */
    protected abstract String handleGetDateFormat();

    private String dateFormat24a;
    private boolean dateFormat24aSet = false;

    /**
     * If this parameter represents a date this method will return the format in which it must be
     * represented. In case this format has not been specified by the any tagged value a default one
     * will be taken.
     * @return (String)handleGetDateFormat()
     */
    public final String getDateFormat()
    {
        String adateFormat24a = this.dateFormat24a;
        if (!this.dateFormat24aSet)
        {
            // dateFormat has no pre constraints
            adateFormat24a = handleGetDateFormat();
            // dateFormat has no post constraints
            this.dateFormat24a = adateFormat24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dateFormat24aSet = true;
            }
        }
        return adateFormat24a;
    }

   /**
    * @see GuiParameter#isStrictDateFormat()
    * @return boolean
    */
    protected abstract boolean handleIsStrictDateFormat();

    private boolean strictDateFormat25a;
    private boolean strictDateFormat25aSet = false;

    /**
     * True if the date format is to be strictly respected. Otherwise the dateformatter used for the
     * representation of this date is to be set to lenient.
     * @return (boolean)handleIsStrictDateFormat()
     */
    public final boolean isStrictDateFormat()
    {
        boolean astrictDateFormat25a = this.strictDateFormat25a;
        if (!this.strictDateFormat25aSet)
        {
            // strictDateFormat has no pre constraints
            astrictDateFormat25a = handleIsStrictDateFormat();
            // strictDateFormat has no post constraints
            this.strictDateFormat25a = astrictDateFormat25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.strictDateFormat25aSet = true;
            }
        }
        return astrictDateFormat25a;
    }

   /**
    * @see GuiParameter#isCalendarRequired()
    * @return boolean
    */
    protected abstract boolean handleIsCalendarRequired();

    private boolean calendarRequired26a;
    private boolean calendarRequired26aSet = false;

    /**
     * True if this parameter is a date and it requires a calendar popup.
     * @return (boolean)handleIsCalendarRequired()
     */
    public final boolean isCalendarRequired()
    {
        boolean acalendarRequired26a = this.calendarRequired26a;
        if (!this.calendarRequired26aSet)
        {
            // calendarRequired has no pre constraints
            acalendarRequired26a = handleIsCalendarRequired();
            // calendarRequired has no post constraints
            this.calendarRequired26a = acalendarRequired26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.calendarRequired26aSet = true;
            }
        }
        return acalendarRequired26a;
    }

   /**
    * @see GuiParameter#getTableDecoratorPackageName()
    * @return String
    */
    protected abstract String handleGetTableDecoratorPackageName();

    private String tableDecoratorPackageName27a;
    private boolean tableDecoratorPackageName27aSet = false;

    /**
     * The package name of the decorator to use for the table.
     * @return (String)handleGetTableDecoratorPackageName()
     */
    public final String getTableDecoratorPackageName()
    {
        String atableDecoratorPackageName27a = this.tableDecoratorPackageName27a;
        if (!this.tableDecoratorPackageName27aSet)
        {
            // tableDecoratorPackageName has no pre constraints
            atableDecoratorPackageName27a = handleGetTableDecoratorPackageName();
            // tableDecoratorPackageName has no post constraints
            this.tableDecoratorPackageName27a = atableDecoratorPackageName27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableDecoratorPackageName27aSet = true;
            }
        }
        return atableDecoratorPackageName27a;
    }

   /**
    * @see GuiParameter#getTableDecoratorClassName()
    * @return String
    */
    protected abstract String handleGetTableDecoratorClassName();

    private String tableDecoratorClassName28a;
    private boolean tableDecoratorClassName28aSet = false;

    /**
     * The class name of the decorator to use for the table.
     * @return (String)handleGetTableDecoratorClassName()
     */
    public final String getTableDecoratorClassName()
    {
        String atableDecoratorClassName28a = this.tableDecoratorClassName28a;
        if (!this.tableDecoratorClassName28aSet)
        {
            // tableDecoratorClassName has no pre constraints
            atableDecoratorClassName28a = handleGetTableDecoratorClassName();
            // tableDecoratorClassName has no post constraints
            this.tableDecoratorClassName28a = atableDecoratorClassName28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableDecoratorClassName28aSet = true;
            }
        }
        return atableDecoratorClassName28a;
    }

   /**
    * @see GuiParameter#getTableDecoratorFullPath()
    * @return String
    */
    protected abstract String handleGetTableDecoratorFullPath();

    private String tableDecoratorFullPath29a;
    private boolean tableDecoratorFullPath29aSet = false;

    /**
     * The full path to the decorator class.
     * @return (String)handleGetTableDecoratorFullPath()
     */
    public final String getTableDecoratorFullPath()
    {
        String atableDecoratorFullPath29a = this.tableDecoratorFullPath29a;
        if (!this.tableDecoratorFullPath29aSet)
        {
            // tableDecoratorFullPath has no pre constraints
            atableDecoratorFullPath29a = handleGetTableDecoratorFullPath();
            // tableDecoratorFullPath has no post constraints
            this.tableDecoratorFullPath29a = atableDecoratorFullPath29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableDecoratorFullPath29aSet = true;
            }
        }
        return atableDecoratorFullPath29a;
    }

   /**
    * @see GuiParameter#getOptionValues()
    * @return List
    */
    protected abstract List handleGetOptionValues();

    private List optionValues30a;
    private boolean optionValues30aSet = false;

    /**
     * The values for the options. Only makes sense when the widget type is radiobutton. The
     * property value may directly be specified usiing the tagged value.
     * @return (List)handleGetOptionValues()
     */
    public final List getOptionValues()
    {
        List aoptionValues30a = this.optionValues30a;
        if (!this.optionValues30aSet)
        {
            // optionValues has no pre constraints
            aoptionValues30a = handleGetOptionValues();
            // optionValues has no post constraints
            this.optionValues30a = aoptionValues30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.optionValues30aSet = true;
            }
        }
        return aoptionValues30a;
    }

   /**
    * @see GuiParameter#getOptionCount()
    * @return int
    */
    protected abstract int handleGetOptionCount();

    private int optionCount31a;
    private boolean optionCount31aSet = false;

    /**
     * In case this parameter represents an option set using radiobuttons, this attribute is a
     * positive integer and zero otherwise.
     * @return (int)handleGetOptionCount()
     */
    public final int getOptionCount()
    {
        int aoptionCount31a = this.optionCount31a;
        if (!this.optionCount31aSet)
        {
            // optionCount has no pre constraints
            aoptionCount31a = handleGetOptionCount();
            // optionCount has no post constraints
            this.optionCount31a = aoptionCount31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.optionCount31aSet = true;
            }
        }
        return aoptionCount31a;
    }

   /**
    * @see GuiParameter#getDocumentationKey()
    * @return String
    */
    protected abstract String handleGetDocumentationKey();

    private String documentationKey32a;
    private boolean documentationKey32aSet = false;

    /**
     * The key to lookup the documentation for this parameter.
     * @return (String)handleGetDocumentationKey()
     */
    public final String getDocumentationKey()
    {
        String adocumentationKey32a = this.documentationKey32a;
        if (!this.documentationKey32aSet)
        {
            // documentationKey has no pre constraints
            adocumentationKey32a = handleGetDocumentationKey();
            // documentationKey has no post constraints
            this.documentationKey32a = adocumentationKey32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentationKey32aSet = true;
            }
        }
        return adocumentationKey32a;
    }

   /**
    * @see GuiParameter#getDocumentationValue()
    * @return String
    */
    protected abstract String handleGetDocumentationValue();

    private String documentationValue33a;
    private boolean documentationValue33aSet = false;

    /**
     * The documentation for this parameter, formatted to be inserted into a resource bundle.
     * @return (String)handleGetDocumentationValue()
     */
    public final String getDocumentationValue()
    {
        String adocumentationValue33a = this.documentationValue33a;
        if (!this.documentationValue33aSet)
        {
            // documentationValue has no pre constraints
            adocumentationValue33a = handleGetDocumentationValue();
            // documentationValue has no post constraints
            this.documentationValue33a = adocumentationValue33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.documentationValue33aSet = true;
            }
        }
        return adocumentationValue33a;
    }

   /**
    * @see GuiParameter#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String onlineHelpKey34a;
    private boolean onlineHelpKey34aSet = false;

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String aonlineHelpKey34a = this.onlineHelpKey34a;
        if (!this.onlineHelpKey34aSet)
        {
            // onlineHelpKey has no pre constraints
            aonlineHelpKey34a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.onlineHelpKey34a = aonlineHelpKey34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpKey34aSet = true;
            }
        }
        return aonlineHelpKey34a;
    }

   /**
    * @see GuiParameter#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String onlineHelpValue35a;
    private boolean onlineHelpValue35aSet = false;

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String aonlineHelpValue35a = this.onlineHelpValue35a;
        if (!this.onlineHelpValue35aSet)
        {
            // onlineHelpValue has no pre constraints
            aonlineHelpValue35a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.onlineHelpValue35a = aonlineHelpValue35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpValue35aSet = true;
            }
        }
        return aonlineHelpValue35a;
    }

   /**
    * @see GuiParameter#isSelectable()
    * @return boolean
    */
    protected abstract boolean handleIsSelectable();

    private boolean selectable36a;
    private boolean selectable36aSet = false;

    /**
     * Whether or not this parameter is selectable. In case this would be true this parameter always
     * has a backing list, a value list and a list containing the labels.
     * @return (boolean)handleIsSelectable()
     */
    public final boolean isSelectable()
    {
        boolean aselectable36a = this.selectable36a;
        if (!this.selectable36aSet)
        {
            // selectable has no pre constraints
            aselectable36a = handleIsSelectable();
            // selectable has no post constraints
            this.selectable36a = aselectable36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.selectable36aSet = true;
            }
        }
        return aselectable36a;
    }

   /**
    * @see GuiParameter#getValueListName()
    * @return String
    */
    protected abstract String handleGetValueListName();

    private String valueListName37a;
    private boolean valueListName37aSet = false;

    /**
     * The name of the list holding the values for this parameter. Only makes sense when the
     * parameter is selectable.
     * @return (String)handleGetValueListName()
     */
    public final String getValueListName()
    {
        String avalueListName37a = this.valueListName37a;
        if (!this.valueListName37aSet)
        {
            // valueListName has no pre constraints
            avalueListName37a = handleGetValueListName();
            // valueListName has no post constraints
            this.valueListName37a = avalueListName37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.valueListName37aSet = true;
            }
        }
        return avalueListName37a;
    }

   /**
    * @see GuiParameter#getLabelListName()
    * @return String
    */
    protected abstract String handleGetLabelListName();

    private String labelListName38a;
    private boolean labelListName38aSet = false;

    /**
     * The name of the list holding the labels for this parameter. Only makes sense when the
     * parameter is selectable.
     * @return (String)handleGetLabelListName()
     */
    public final String getLabelListName()
    {
        String alabelListName38a = this.labelListName38a;
        if (!this.labelListName38aSet)
        {
            // labelListName has no pre constraints
            alabelListName38a = handleGetLabelListName();
            // labelListName has no post constraints
            this.labelListName38a = alabelListName38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.labelListName38aSet = true;
            }
        }
        return alabelListName38a;
    }

   /**
    * @see GuiParameter#getCollectionImplementationType()
    * @return String
    */
    protected abstract String handleGetCollectionImplementationType();

    private String collectionImplementationType39a;
    private boolean collectionImplementationType39aSet = false;

    /**
     * If this parameter is a collection type, this property will represent the fully qualified name
     * of a class suitable for implementation. If the type is neither Collection, List, nor Set the
     * type itself is assumed.
     * @return (String)handleGetCollectionImplementationType()
     */
    public final String getCollectionImplementationType()
    {
        String acollectionImplementationType39a = this.collectionImplementationType39a;
        if (!this.collectionImplementationType39aSet)
        {
            // collectionImplementationType has no pre constraints
            acollectionImplementationType39a = handleGetCollectionImplementationType();
            // collectionImplementationType has no post constraints
            this.collectionImplementationType39a = acollectionImplementationType39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.collectionImplementationType39aSet = true;
            }
        }
        return acollectionImplementationType39a;
    }

   /**
    * @see GuiParameter#getMultiboxPropertyName()
    * @return String
    */
    protected abstract String handleGetMultiboxPropertyName();

    private String multiboxPropertyName40a;
    private boolean multiboxPropertyName40aSet = false;

    /**
     * The name of the array to be used for the multibox, this only makes sense when this parameter
     * is actually a multibox.
     * @return (String)handleGetMultiboxPropertyName()
     */
    public final String getMultiboxPropertyName()
    {
        String amultiboxPropertyName40a = this.multiboxPropertyName40a;
        if (!this.multiboxPropertyName40aSet)
        {
            // multiboxPropertyName has no pre constraints
            amultiboxPropertyName40a = handleGetMultiboxPropertyName();
            // multiboxPropertyName has no post constraints
            this.multiboxPropertyName40a = amultiboxPropertyName40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.multiboxPropertyName40aSet = true;
            }
        }
        return amultiboxPropertyName40a;
    }

   /**
    * @see GuiParameter#isShouldReset()
    * @return boolean
    */
    protected abstract boolean handleIsShouldReset();

    private boolean shouldReset41a;
    private boolean shouldReset41aSet = false;

    /**
     * Whether or not this parameter should be reset between requests.  This is different than
     * resetRequired in that this is user specified.
     * @return (boolean)handleIsShouldReset()
     */
    public final boolean isShouldReset()
    {
        boolean ashouldReset41a = this.shouldReset41a;
        if (!this.shouldReset41aSet)
        {
            // shouldReset has no pre constraints
            ashouldReset41a = handleIsShouldReset();
            // shouldReset has no post constraints
            this.shouldReset41a = ashouldReset41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.shouldReset41aSet = true;
            }
        }
        return ashouldReset41a;
    }

   /**
    * @see GuiParameter#getResetName()
    * @return String
    */
    protected abstract String handleGetResetName();

    private String resetName42a;
    private boolean resetName42aSet = false;

    /**
     * The name of the operation that resets this parameter to its original value.
     * @return (String)handleGetResetName()
     */
    public final String getResetName()
    {
        String aresetName42a = this.resetName42a;
        if (!this.resetName42aSet)
        {
            // resetName has no pre constraints
            aresetName42a = handleGetResetName();
            // resetName has no post constraints
            this.resetName42a = aresetName42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetName42aSet = true;
            }
        }
        return aresetName42a;
    }

   /**
    * @see GuiParameter#isFile()
    * @return boolean
    */
    protected abstract boolean handleIsFile();

    private boolean file43a;
    private boolean file43aSet = false;

    /**
     * 
     * @return (boolean)handleIsFile()
     */
    public final boolean isFile()
    {
        boolean afile43a = this.file43a;
        if (!this.file43aSet)
        {
            // file has no pre constraints
            afile43a = handleIsFile();
            // file has no post constraints
            this.file43a = afile43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.file43aSet = true;
            }
        }
        return afile43a;
    }

   /**
    * @see GuiParameter#isPassword()
    * @return boolean
    */
    protected abstract boolean handleIsPassword();

    private boolean password44a;
    private boolean password44aSet = false;

    /**
     * True if this parameter represents a password field.
     * @return (boolean)handleIsPassword()
     */
    public final boolean isPassword()
    {
        boolean apassword44a = this.password44a;
        if (!this.password44aSet)
        {
            // password has no pre constraints
            apassword44a = handleIsPassword();
            // password has no post constraints
            this.password44a = apassword44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.password44aSet = true;
            }
        }
        return apassword44a;
    }

   /**
    * @see GuiParameter#isTableDecoratorRequired()
    * @return boolean
    */
    protected abstract boolean handleIsTableDecoratorRequired();

    private boolean tableDecoratorRequired45a;
    private boolean tableDecoratorRequired45aSet = false;

    /**
     * 
     * @return (boolean)handleIsTableDecoratorRequired()
     */
    public final boolean isTableDecoratorRequired()
    {
        boolean atableDecoratorRequired45a = this.tableDecoratorRequired45a;
        if (!this.tableDecoratorRequired45aSet)
        {
            // tableDecoratorRequired has no pre constraints
            atableDecoratorRequired45a = handleIsTableDecoratorRequired();
            // tableDecoratorRequired has no post constraints
            this.tableDecoratorRequired45a = atableDecoratorRequired45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableDecoratorRequired45aSet = true;
            }
        }
        return atableDecoratorRequired45a;
    }

   /**
    * @see GuiParameter#getTableDecoratorFullyQualifiedName()
    * @return String
    */
    protected abstract String handleGetTableDecoratorFullyQualifiedName();

    private String tableDecoratorFullyQualifiedName46a;
    private boolean tableDecoratorFullyQualifiedName46aSet = false;

    /**
     * The complete table decorator classname.
     * @return (String)handleGetTableDecoratorFullyQualifiedName()
     */
    public final String getTableDecoratorFullyQualifiedName()
    {
        String atableDecoratorFullyQualifiedName46a = this.tableDecoratorFullyQualifiedName46a;
        if (!this.tableDecoratorFullyQualifiedName46aSet)
        {
            // tableDecoratorFullyQualifiedName has no pre constraints
            atableDecoratorFullyQualifiedName46a = handleGetTableDecoratorFullyQualifiedName();
            // tableDecoratorFullyQualifiedName has no post constraints
            this.tableDecoratorFullyQualifiedName46a = atableDecoratorFullyQualifiedName46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableDecoratorFullyQualifiedName46aSet = true;
            }
        }
        return atableDecoratorFullyQualifiedName46a;
    }

   /**
    * @see GuiParameter#isTableHyperlinkColumn()
    * @return boolean
    */
    protected abstract boolean handleIsTableHyperlinkColumn();

    private boolean tableHyperlinkColumn47a;
    private boolean tableHyperlinkColumn47aSet = false;

    /**
     * True if this parameter represents a table column into which an hyperlink must be rendered.
     * This property only makes sense when it has been called on parameters representing an actual
     * table column. Note that the getTableColumns() operation also returns String instances.
     * @return (boolean)handleIsTableHyperlinkColumn()
     */
    public final boolean isTableHyperlinkColumn()
    {
        boolean atableHyperlinkColumn47a = this.tableHyperlinkColumn47a;
        if (!this.tableHyperlinkColumn47aSet)
        {
            // tableHyperlinkColumn has no pre constraints
            atableHyperlinkColumn47a = handleIsTableHyperlinkColumn();
            // tableHyperlinkColumn has no post constraints
            this.tableHyperlinkColumn47a = atableHyperlinkColumn47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableHyperlinkColumn47aSet = true;
            }
        }
        return atableHyperlinkColumn47a;
    }

   /**
    * @see GuiParameter#isTableFormActionSharingWidgets()
    * @return boolean
    */
    protected abstract boolean handleIsTableFormActionSharingWidgets();

    private boolean tableFormActionSharingWidgets48a;
    private boolean tableFormActionSharingWidgets48aSet = false;

    /**
     * True if this table has form actions that share the column widgets. It is not allowed to have
     * different actions use different widgets on the same column.
     * @return (boolean)handleIsTableFormActionSharingWidgets()
     */
    public final boolean isTableFormActionSharingWidgets()
    {
        boolean atableFormActionSharingWidgets48a = this.tableFormActionSharingWidgets48a;
        if (!this.tableFormActionSharingWidgets48aSet)
        {
            // tableFormActionSharingWidgets has no pre constraints
            atableFormActionSharingWidgets48a = handleIsTableFormActionSharingWidgets();
            // tableFormActionSharingWidgets has no post constraints
            this.tableFormActionSharingWidgets48a = atableFormActionSharingWidgets48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableFormActionSharingWidgets48aSet = true;
            }
        }
        return atableFormActionSharingWidgets48a;
    }

   /**
    * @see GuiParameter#getStyleId()
    * @return String
    */
    protected abstract String handleGetStyleId();

    private String styleId49a;
    private boolean styleId49aSet = false;

    /**
     * 
     * @return (String)handleGetStyleId()
     */
    public final String getStyleId()
    {
        String astyleId49a = this.styleId49a;
        if (!this.styleId49aSet)
        {
            // styleId has no pre constraints
            astyleId49a = handleGetStyleId();
            // styleId has no post constraints
            this.styleId49a = astyleId49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.styleId49aSet = true;
            }
        }
        return astyleId49a;
    }

   /**
    * @see GuiParameter#isSortableBy()
    * @return boolean
    */
    protected abstract boolean handleIsSortableBy();

    private boolean sortableBy50a;
    private boolean sortableBy50aSet = false;

    /**
     * Indicates if a table can be sorted by this parameter.
     * @return (boolean)handleIsSortableBy()
     */
    public final boolean isSortableBy()
    {
        boolean asortableBy50a = this.sortableBy50a;
        if (!this.sortableBy50aSet)
        {
            // sortableBy has no pre constraints
            asortableBy50a = handleIsSortableBy();
            // sortableBy has no post constraints
            this.sortableBy50a = asortableBy50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.sortableBy50aSet = true;
            }
        }
        return asortableBy50a;
    }

   /**
    * @see GuiParameter#getTimeFormat()
    * @return String
    */
    protected abstract String handleGetTimeFormat();

    private String timeFormat51a;
    private boolean timeFormat51aSet = false;

    /**
     * The time format for this parameter (if this parameter stores time).
     * @return (String)handleGetTimeFormat()
     */
    public final String getTimeFormat()
    {
        String atimeFormat51a = this.timeFormat51a;
        if (!this.timeFormat51aSet)
        {
            // timeFormat has no pre constraints
            atimeFormat51a = handleGetTimeFormat();
            // timeFormat has no post constraints
            this.timeFormat51a = atimeFormat51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.timeFormat51aSet = true;
            }
        }
        return atimeFormat51a;
    }

   /**
    * @see GuiParameter#isTime()
    * @return boolean
    */
    protected abstract boolean handleIsTime();

    private boolean time52a;
    private boolean time52aSet = false;

    /**
     * Indicates if this parameter's type represents a time.
     * @return (boolean)handleIsTime()
     */
    public final boolean isTime()
    {
        boolean atime52a = this.time52a;
        if (!this.time52aSet)
        {
            // time has no pre constraints
            atime52a = handleIsTime();
            // time has no post constraints
            this.time52a = atime52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.time52aSet = true;
            }
        }
        return atime52a;
    }

   /**
    * @see GuiParameter#isAllGlobalTableActionsHaveSameParameter()
    * @return boolean
    */
    protected abstract boolean handleIsAllGlobalTableActionsHaveSameParameter();

    private boolean allGlobalTableActionsHaveSameParameter53a;
    private boolean allGlobalTableActionsHaveSameParameter53aSet = false;

    /**
     * This property is used in model validation. It denotes whether all actions targetting this
     * table page-variable take the same parameter (same name and type). Only makes sense when this
     * parameter is actually a table page-variable.
     * @return (boolean)handleIsAllGlobalTableActionsHaveSameParameter()
     */
    public final boolean isAllGlobalTableActionsHaveSameParameter()
    {
        boolean aallGlobalTableActionsHaveSameParameter53a = this.allGlobalTableActionsHaveSameParameter53a;
        if (!this.allGlobalTableActionsHaveSameParameter53aSet)
        {
            // allGlobalTableActionsHaveSameParameter has no pre constraints
            aallGlobalTableActionsHaveSameParameter53a = handleIsAllGlobalTableActionsHaveSameParameter();
            // allGlobalTableActionsHaveSameParameter has no post constraints
            this.allGlobalTableActionsHaveSameParameter53a = aallGlobalTableActionsHaveSameParameter53a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.allGlobalTableActionsHaveSameParameter53aSet = true;
            }
        }
        return aallGlobalTableActionsHaveSameParameter53a;
    }

   /**
    * @see GuiParameter#getFieldRowCount()
    * @return Integer
    */
    protected abstract Integer handleGetFieldRowCount();

    private Integer fieldRowCount54a;
    private boolean fieldRowCount54aSet = false;

    /**
     * The number of rows for this field, null if default browser value is desired.
     * @return (Integer)handleGetFieldRowCount()
     */
    public final Integer getFieldRowCount()
    {
        Integer afieldRowCount54a = this.fieldRowCount54a;
        if (!this.fieldRowCount54aSet)
        {
            // fieldRowCount has no pre constraints
            afieldRowCount54a = handleGetFieldRowCount();
            // fieldRowCount has no post constraints
            this.fieldRowCount54a = afieldRowCount54a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fieldRowCount54aSet = true;
            }
        }
        return afieldRowCount54a;
    }

   /**
    * @see GuiParameter#getFieldColumnCount()
    * @return Integer
    */
    protected abstract Integer handleGetFieldColumnCount();

    private Integer fieldColumnCount55a;
    private boolean fieldColumnCount55aSet = false;

    /**
     * The number of columns for this field, null if default browser value is desired.
     * @return (Integer)handleGetFieldColumnCount()
     */
    public final Integer getFieldColumnCount()
    {
        Integer afieldColumnCount55a = this.fieldColumnCount55a;
        if (!this.fieldColumnCount55aSet)
        {
            // fieldColumnCount has no pre constraints
            afieldColumnCount55a = handleGetFieldColumnCount();
            // fieldColumnCount has no post constraints
            this.fieldColumnCount55a = afieldColumnCount55a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fieldColumnCount55aSet = true;
            }
        }
        return afieldColumnCount55a;
    }

   /**
    * @see GuiParameter#isCombobox()
    * @return boolean
    */
    protected abstract boolean handleIsCombobox();

    private boolean combobox56a;
    private boolean combobox56aSet = false;

    /**
     * 
     * @return (boolean)handleIsCombobox()
     */
    public final boolean isCombobox()
    {
        boolean acombobox56a = this.combobox56a;
        if (!this.combobox56aSet)
        {
            // combobox has no pre constraints
            acombobox56a = handleIsCombobox();
            // combobox has no post constraints
            this.combobox56a = acombobox56a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.combobox56aSet = true;
            }
        }
        return acombobox56a;
    }

   /**
    * @see GuiParameter#isCheckbox()
    * @return boolean
    */
    protected abstract boolean handleIsCheckbox();

    private boolean checkbox57a;
    private boolean checkbox57aSet = false;

    /**
     * 
     * @return (boolean)handleIsCheckbox()
     */
    public final boolean isCheckbox()
    {
        boolean acheckbox57a = this.checkbox57a;
        if (!this.checkbox57aSet)
        {
            // checkbox has no pre constraints
            acheckbox57a = handleIsCheckbox();
            // checkbox has no post constraints
            this.checkbox57a = acheckbox57a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.checkbox57aSet = true;
            }
        }
        return acheckbox57a;
    }

   /**
    * @see GuiParameter#isTextField()
    * @return boolean
    */
    protected abstract boolean handleIsTextField();

    private boolean textField58a;
    private boolean textField58aSet = false;

    /**
     * 
     * @return (boolean)handleIsTextField()
     */
    public final boolean isTextField()
    {
        boolean atextField58a = this.textField58a;
        if (!this.textField58aSet)
        {
            // textField has no pre constraints
            atextField58a = handleIsTextField();
            // textField has no post constraints
            this.textField58a = atextField58a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.textField58aSet = true;
            }
        }
        return atextField58a;
    }

   /**
    * @see GuiParameter#isTextArea()
    * @return boolean
    */
    protected abstract boolean handleIsTextArea();

    private boolean textArea59a;
    private boolean textArea59aSet = false;

    /**
     * 
     * @return (boolean)handleIsTextArea()
     */
    public final boolean isTextArea()
    {
        boolean atextArea59a = this.textArea59a;
        if (!this.textArea59aSet)
        {
            // textArea has no pre constraints
            atextArea59a = handleIsTextArea();
            // textArea has no post constraints
            this.textArea59a = atextArea59a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.textArea59aSet = true;
            }
        }
        return atextArea59a;
    }

   /**
    * @see GuiParameter#isMultibox()
    * @return boolean
    */
    protected abstract boolean handleIsMultibox();

    private boolean multibox60a;
    private boolean multibox60aSet = false;

    /**
     * 
     * @return (boolean)handleIsMultibox()
     */
    public final boolean isMultibox()
    {
        boolean amultibox60a = this.multibox60a;
        if (!this.multibox60aSet)
        {
            // multibox has no pre constraints
            amultibox60a = handleIsMultibox();
            // multibox has no post constraints
            this.multibox60a = amultibox60a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.multibox60aSet = true;
            }
        }
        return amultibox60a;
    }

   /**
    * @see GuiParameter#isRadioButton()
    * @return boolean
    */
    protected abstract boolean handleIsRadioButton();

    private boolean radioButton61a;
    private boolean radioButton61aSet = false;

    /**
     * 
     * @return (boolean)handleIsRadioButton()
     */
    public final boolean isRadioButton()
    {
        boolean aradioButton61a = this.radioButton61a;
        if (!this.radioButton61aSet)
        {
            // radioButton has no pre constraints
            aradioButton61a = handleIsRadioButton();
            // radioButton has no post constraints
            this.radioButton61a = aradioButton61a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.radioButton61aSet = true;
            }
        }
        return aradioButton61a;
    }

   /**
    * @see GuiParameter#isHiddenField()
    * @return boolean
    */
    protected abstract boolean handleIsHiddenField();

    private boolean hiddenField62a;
    private boolean hiddenField62aSet = false;

    /**
     * 
     * @return (boolean)handleIsHiddenField()
     */
    public final boolean isHiddenField()
    {
        boolean ahiddenField62a = this.hiddenField62a;
        if (!this.hiddenField62aSet)
        {
            // hiddenField has no pre constraints
            ahiddenField62a = handleIsHiddenField();
            // hiddenField has no post constraints
            this.hiddenField62a = ahiddenField62a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hiddenField62aSet = true;
            }
        }
        return ahiddenField62a;
    }

   /**
    * @see GuiParameter#isHyperlink()
    * @return boolean
    */
    protected abstract boolean handleIsHyperlink();

    private boolean hyperlink63a;
    private boolean hyperlink63aSet = false;

    /**
     * 
     * @return (boolean)handleIsHyperlink()
     */
    public final boolean isHyperlink()
    {
        boolean ahyperlink63a = this.hyperlink63a;
        if (!this.hyperlink63aSet)
        {
            // hyperlink has no pre constraints
            ahyperlink63a = handleIsHyperlink();
            // hyperlink has no post constraints
            this.hyperlink63a = ahyperlink63a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hyperlink63aSet = true;
            }
        }
        return ahyperlink63a;
    }

   /**
    * @see GuiParameter#isSafeNamePresent()
    * @return boolean
    */
    protected abstract boolean handleIsSafeNamePresent();

    private boolean safeNamePresent64a;
    private boolean safeNamePresent64aSet = false;

    /**
     * True if this parameter has a name that can properly be handled by Jakarta commons (this lib
     * is used by Gui but contains a bug)
     * @return (boolean)handleIsSafeNamePresent()
     */
    public final boolean isSafeNamePresent()
    {
        boolean asafeNamePresent64a = this.safeNamePresent64a;
        if (!this.safeNamePresent64aSet)
        {
            // safeNamePresent has no pre constraints
            asafeNamePresent64a = handleIsSafeNamePresent();
            // safeNamePresent has no post constraints
            this.safeNamePresent64a = asafeNamePresent64a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.safeNamePresent64aSet = true;
            }
        }
        return asafeNamePresent64a;
    }

   /**
    * @see GuiParameter#isMultiSelection()
    * @return boolean
    */
    protected abstract boolean handleIsMultiSelection();

    private boolean multiSelection65a;
    private boolean multiSelection65aSet = false;

    /**
     * 
     * @return (boolean)handleIsMultiSelection()
     */
    public final boolean isMultiSelection()
    {
        boolean amultiSelection65a = this.multiSelection65a;
        if (!this.multiSelection65aSet)
        {
            // multiSelection has no pre constraints
            amultiSelection65a = handleIsMultiSelection();
            // multiSelection has no post constraints
            this.multiSelection65a = amultiSelection65a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.multiSelection65aSet = true;
            }
        }
        return amultiSelection65a;
    }

   /**
    * @see GuiParameter#getFormat()
    * @return String
    */
    protected abstract String handleGetFormat();

    private String format66a;
    private boolean format66aSet = false;

    /**
     * If this parameter represents a date or time this method will return the format in which it
     * must be represented. In the event this format has not been specified by the any tagged value
     * the default will be used.
     * @return (String)handleGetFormat()
     */
    public final String getFormat()
    {
        String aformat66a = this.format66a;
        if (!this.format66aSet)
        {
            // format has no pre constraints
            aformat66a = handleGetFormat();
            // format has no post constraints
            this.format66a = aformat66a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.format66aSet = true;
            }
        }
        return aformat66a;
    }

   /**
    * @see GuiParameter#getDateFormatter()
    * @return String
    */
    protected abstract String handleGetDateFormatter();

    private String dateFormatter67a;
    private boolean dateFormatter67aSet = false;

    /**
     * The name of the date formatter for this parameter (if this parameter represents a date).
     * @return (String)handleGetDateFormatter()
     */
    public final String getDateFormatter()
    {
        String adateFormatter67a = this.dateFormatter67a;
        if (!this.dateFormatter67aSet)
        {
            // dateFormatter has no pre constraints
            adateFormatter67a = handleGetDateFormatter();
            // dateFormatter has no post constraints
            this.dateFormatter67a = adateFormatter67a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dateFormatter67aSet = true;
            }
        }
        return adateFormatter67a;
    }

   /**
    * @see GuiParameter#getTimeFormatter()
    * @return String
    */
    protected abstract String handleGetTimeFormatter();

    private String timeFormatter68a;
    private boolean timeFormatter68aSet = false;

    /**
     * The name of the time formatter (if this parameter represents a time).
     * @return (String)handleGetTimeFormatter()
     */
    public final String getTimeFormatter()
    {
        String atimeFormatter68a = this.timeFormatter68a;
        if (!this.timeFormatter68aSet)
        {
            // timeFormatter has no pre constraints
            atimeFormatter68a = handleGetTimeFormatter();
            // timeFormatter has no post constraints
            this.timeFormatter68a = atimeFormatter68a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.timeFormatter68aSet = true;
            }
        }
        return atimeFormatter68a;
    }

   /**
    * @see GuiParameter#isInputCheckbox()
    * @return boolean
    */
    protected abstract boolean handleIsInputCheckbox();

    private boolean inputCheckbox69a;
    private boolean inputCheckbox69aSet = false;

    /**
     * Indicates if this parameter represents a checkbox widget.
     * @return (boolean)handleIsInputCheckbox()
     */
    public final boolean isInputCheckbox()
    {
        boolean ainputCheckbox69a = this.inputCheckbox69a;
        if (!this.inputCheckbox69aSet)
        {
            // inputCheckbox has no pre constraints
            ainputCheckbox69a = handleIsInputCheckbox();
            // inputCheckbox has no post constraints
            this.inputCheckbox69a = ainputCheckbox69a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputCheckbox69aSet = true;
            }
        }
        return ainputCheckbox69a;
    }

   /**
    * @see GuiParameter#isInputTextarea()
    * @return boolean
    */
    protected abstract boolean handleIsInputTextarea();

    private boolean inputTextarea70a;
    private boolean inputTextarea70aSet = false;

    /**
     * Indicates if this parameter represents as an input text area widget.
     * @return (boolean)handleIsInputTextarea()
     */
    public final boolean isInputTextarea()
    {
        boolean ainputTextarea70a = this.inputTextarea70a;
        if (!this.inputTextarea70aSet)
        {
            // inputTextarea has no pre constraints
            ainputTextarea70a = handleIsInputTextarea();
            // inputTextarea has no post constraints
            this.inputTextarea70a = ainputTextarea70a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputTextarea70aSet = true;
            }
        }
        return ainputTextarea70a;
    }

   /**
    * @see GuiParameter#isInputSelect()
    * @return boolean
    */
    protected abstract boolean handleIsInputSelect();

    private boolean inputSelect71a;
    private boolean inputSelect71aSet = false;

    /**
     * Indicates whether or not this parameter represents an input select widget.
     * @return (boolean)handleIsInputSelect()
     */
    public final boolean isInputSelect()
    {
        boolean ainputSelect71a = this.inputSelect71a;
        if (!this.inputSelect71aSet)
        {
            // inputSelect has no pre constraints
            ainputSelect71a = handleIsInputSelect();
            // inputSelect has no post constraints
            this.inputSelect71a = ainputSelect71a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputSelect71aSet = true;
            }
        }
        return ainputSelect71a;
    }

   /**
    * @see GuiParameter#isInputSecret()
    * @return boolean
    */
    protected abstract boolean handleIsInputSecret();

    private boolean inputSecret72a;
    private boolean inputSecret72aSet = false;

    /**
     * Indicates whether or not this parameter represents an input "secret" widget (i.e. password).
     * @return (boolean)handleIsInputSecret()
     */
    public final boolean isInputSecret()
    {
        boolean ainputSecret72a = this.inputSecret72a;
        if (!this.inputSecret72aSet)
        {
            // inputSecret has no pre constraints
            ainputSecret72a = handleIsInputSecret();
            // inputSecret has no post constraints
            this.inputSecret72a = ainputSecret72a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputSecret72aSet = true;
            }
        }
        return ainputSecret72a;
    }

   /**
    * @see GuiParameter#isInputHidden()
    * @return boolean
    */
    protected abstract boolean handleIsInputHidden();

    private boolean inputHidden73a;
    private boolean inputHidden73aSet = false;

    /**
     * Indicates whether or not this parameter represents a hidden input widget.
     * @return (boolean)handleIsInputHidden()
     */
    public final boolean isInputHidden()
    {
        boolean ainputHidden73a = this.inputHidden73a;
        if (!this.inputHidden73aSet)
        {
            // inputHidden has no pre constraints
            ainputHidden73a = handleIsInputHidden();
            // inputHidden has no post constraints
            this.inputHidden73a = ainputHidden73a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputHidden73aSet = true;
            }
        }
        return ainputHidden73a;
    }

   /**
    * @see GuiParameter#isPlaintext()
    * @return boolean
    */
    protected abstract boolean handleIsPlaintext();

    private boolean plaintext74a;
    private boolean plaintext74aSet = false;

    /**
     * Indicates whether or not this field should be rendered as plain text (not as a widget).
     * @return (boolean)handleIsPlaintext()
     */
    public final boolean isPlaintext()
    {
        boolean aplaintext74a = this.plaintext74a;
        if (!this.plaintext74aSet)
        {
            // plaintext has no pre constraints
            aplaintext74a = handleIsPlaintext();
            // plaintext has no post constraints
            this.plaintext74a = aplaintext74a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.plaintext74aSet = true;
            }
        }
        return aplaintext74a;
    }

   /**
    * @see GuiParameter#isInputRadio()
    * @return boolean
    */
    protected abstract boolean handleIsInputRadio();

    private boolean inputRadio75a;
    private boolean inputRadio75aSet = false;

    /**
     * Indicates whether or not this parameter should be rendered as an input radio widget.
     * @return (boolean)handleIsInputRadio()
     */
    public final boolean isInputRadio()
    {
        boolean ainputRadio75a = this.inputRadio75a;
        if (!this.inputRadio75aSet)
        {
            // inputRadio has no pre constraints
            ainputRadio75a = handleIsInputRadio();
            // inputRadio has no post constraints
            this.inputRadio75a = ainputRadio75a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputRadio75aSet = true;
            }
        }
        return ainputRadio75a;
    }

   /**
    * @see GuiParameter#isInputText()
    * @return boolean
    */
    protected abstract boolean handleIsInputText();

    private boolean inputText76a;
    private boolean inputText76aSet = false;

    /**
     * Indicates whether or not this parameter should be rendered as a text input widget.
     * @return (boolean)handleIsInputText()
     */
    public final boolean isInputText()
    {
        boolean ainputText76a = this.inputText76a;
        if (!this.inputText76aSet)
        {
            // inputText has no pre constraints
            ainputText76a = handleIsInputText();
            // inputText has no post constraints
            this.inputText76a = ainputText76a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputText76aSet = true;
            }
        }
        return ainputText76a;
    }

   /**
    * @see GuiParameter#getDummyValue()
    * @return String
    */
    protected abstract String handleGetDummyValue();

    private String dummyValue77a;
    private boolean dummyValue77aSet = false;

    /**
     * The dummy value for this parameter. The dummy value is used for setting the dummy information
     * when dummyData is enabled.
     * @return (String)handleGetDummyValue()
     */
    public final String getDummyValue()
    {
        String adummyValue77a = this.dummyValue77a;
        if (!this.dummyValue77aSet)
        {
            // dummyValue has no pre constraints
            adummyValue77a = handleGetDummyValue();
            // dummyValue has no post constraints
            this.dummyValue77a = adummyValue77a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dummyValue77aSet = true;
            }
        }
        return adummyValue77a;
    }

   /**
    * @see GuiParameter#getValueListDummyValue()
    * @return String
    */
    protected abstract String handleGetValueListDummyValue();

    private String valueListDummyValue78a;
    private boolean valueListDummyValue78aSet = false;

    /**
     * The dummy value for a value list.
     * @return (String)handleGetValueListDummyValue()
     */
    public final String getValueListDummyValue()
    {
        String avalueListDummyValue78a = this.valueListDummyValue78a;
        if (!this.valueListDummyValue78aSet)
        {
            // valueListDummyValue has no pre constraints
            avalueListDummyValue78a = handleGetValueListDummyValue();
            // valueListDummyValue has no post constraints
            this.valueListDummyValue78a = avalueListDummyValue78a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.valueListDummyValue78aSet = true;
            }
        }
        return avalueListDummyValue78a;
    }

   /**
    * @see GuiParameter#getTableSortColumnProperty()
    * @return String
    */
    protected abstract String handleGetTableSortColumnProperty();

    private String tableSortColumnProperty79a;
    private boolean tableSortColumnProperty79aSet = false;

    /**
     * The name of the property storing the column to sort by if this parameter represents a table.
     * @return (String)handleGetTableSortColumnProperty()
     */
    public final String getTableSortColumnProperty()
    {
        String atableSortColumnProperty79a = this.tableSortColumnProperty79a;
        if (!this.tableSortColumnProperty79aSet)
        {
            // tableSortColumnProperty has no pre constraints
            atableSortColumnProperty79a = handleGetTableSortColumnProperty();
            // tableSortColumnProperty has no post constraints
            this.tableSortColumnProperty79a = atableSortColumnProperty79a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableSortColumnProperty79aSet = true;
            }
        }
        return atableSortColumnProperty79a;
    }

   /**
    * @see GuiParameter#getTableSortAscendingProperty()
    * @return String
    */
    protected abstract String handleGetTableSortAscendingProperty();

    private String tableSortAscendingProperty80a;
    private boolean tableSortAscendingProperty80aSet = false;

    /**
     * The name of the property that Indicates whether or not the table should be sorted ascending
     * (if this parameter represents a table).
     * @return (String)handleGetTableSortAscendingProperty()
     */
    public final String getTableSortAscendingProperty()
    {
        String atableSortAscendingProperty80a = this.tableSortAscendingProperty80a;
        if (!this.tableSortAscendingProperty80aSet)
        {
            // tableSortAscendingProperty has no pre constraints
            atableSortAscendingProperty80a = handleGetTableSortAscendingProperty();
            // tableSortAscendingProperty has no post constraints
            this.tableSortAscendingProperty80a = atableSortAscendingProperty80a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.tableSortAscendingProperty80aSet = true;
            }
        }
        return atableSortAscendingProperty80a;
    }

   /**
    * @see GuiParameter#getFormAttributeSetProperty()
    * @return String
    */
    protected abstract String handleGetFormAttributeSetProperty();

    private String formAttributeSetProperty81a;
    private boolean formAttributeSetProperty81aSet = false;

    /**
     * The name of the property used for indicating whether or not a form attribute has been set at
     * least once.
     * @return (String)handleGetFormAttributeSetProperty()
     */
    public final String getFormAttributeSetProperty()
    {
        String aformAttributeSetProperty81a = this.formAttributeSetProperty81a;
        if (!this.formAttributeSetProperty81aSet)
        {
            // formAttributeSetProperty has no pre constraints
            aformAttributeSetProperty81a = handleGetFormAttributeSetProperty();
            // formAttributeSetProperty has no post constraints
            this.formAttributeSetProperty81a = aformAttributeSetProperty81a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.formAttributeSetProperty81aSet = true;
            }
        }
        return aformAttributeSetProperty81a;
    }

   /**
    * @see GuiParameter#isInputFile()
    * @return boolean
    */
    protected abstract boolean handleIsInputFile();

    private boolean inputFile82a;
    private boolean inputFile82aSet = false;

    /**
     * Indicates whether or not this is a file input type.
     * @return (boolean)handleIsInputFile()
     */
    public final boolean isInputFile()
    {
        boolean ainputFile82a = this.inputFile82a;
        if (!this.inputFile82aSet)
        {
            // inputFile has no pre constraints
            ainputFile82a = handleIsInputFile();
            // inputFile has no post constraints
            this.inputFile82a = ainputFile82a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputFile82aSet = true;
            }
        }
        return ainputFile82a;
    }

   /**
    * @see GuiParameter#isInputMultibox()
    * @return boolean
    */
    protected abstract boolean handleIsInputMultibox();

    private boolean inputMultibox83a;
    private boolean inputMultibox83aSet = false;

    /**
     * Indicates whether or not this type represents an input multibox.
     * @return (boolean)handleIsInputMultibox()
     */
    public final boolean isInputMultibox()
    {
        boolean ainputMultibox83a = this.inputMultibox83a;
        if (!this.inputMultibox83aSet)
        {
            // inputMultibox has no pre constraints
            ainputMultibox83a = handleIsInputMultibox();
            // inputMultibox has no post constraints
            this.inputMultibox83a = ainputMultibox83a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputMultibox83aSet = true;
            }
        }
        return ainputMultibox83a;
    }

   /**
    * @see GuiParameter#isReset()
    * @return boolean
    */
    protected abstract boolean handleIsReset();

    private boolean reset84a;
    private boolean reset84aSet = false;

    /**
     * Indicates if this parameter's value should be reset or not after an action has been performed
     * with this parameter.
     * @return (boolean)handleIsReset()
     */
    public final boolean isReset()
    {
        boolean areset84a = this.reset84a;
        if (!this.reset84aSet)
        {
            // reset has no pre constraints
            areset84a = handleIsReset();
            // reset has no post constraints
            this.reset84a = areset84a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.reset84aSet = true;
            }
        }
        return areset84a;
    }

   /**
    * @see GuiParameter#isComplex()
    * @return boolean
    */
    protected abstract boolean handleIsComplex();

    private boolean complex85a;
    private boolean complex85aSet = false;

    /**
     * Indicates if this parameter is 'complex', that is: its of a complex type (has at least one
     * attribute or association).
     * @return (boolean)handleIsComplex()
     */
    public final boolean isComplex()
    {
        boolean acomplex85a = this.complex85a;
        if (!this.complex85aSet)
        {
            // complex has no pre constraints
            acomplex85a = handleIsComplex();
            // complex has no post constraints
            this.complex85a = acomplex85a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.complex85aSet = true;
            }
        }
        return acomplex85a;
    }

   /**
    * @see GuiParameter#getAttributes()
    * @return Collection
    */
    protected abstract Collection handleGetAttributes();

    private Collection attributes86a;
    private boolean attributes86aSet = false;

    /**
     * All attributes belonging to this parameter's type.
     * @return (Collection)handleGetAttributes()
     */
    public final Collection getAttributes()
    {
        Collection aattributes86a = this.attributes86a;
        if (!this.attributes86aSet)
        {
            // attributes has no pre constraints
            aattributes86a = handleGetAttributes();
            // attributes has no post constraints
            this.attributes86a = aattributes86a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.attributes86aSet = true;
            }
        }
        return aattributes86a;
    }

   /**
    * @see GuiParameter#getNavigableAssociationEnds()
    * @return Collection
    */
    protected abstract Collection handleGetNavigableAssociationEnds();

    private Collection navigableAssociationEnds87a;
    private boolean navigableAssociationEnds87aSet = false;

    /**
     * All navigation association ends belonging to this parameter's type.
     * @return (Collection)handleGetNavigableAssociationEnds()
     */
    public final Collection getNavigableAssociationEnds()
    {
        Collection anavigableAssociationEnds87a = this.navigableAssociationEnds87a;
        if (!this.navigableAssociationEnds87aSet)
        {
            // navigableAssociationEnds has no pre constraints
            anavigableAssociationEnds87a = handleGetNavigableAssociationEnds();
            // navigableAssociationEnds has no post constraints
            this.navigableAssociationEnds87a = anavigableAssociationEnds87a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.navigableAssociationEnds87aSet = true;
            }
        }
        return anavigableAssociationEnds87a;
    }

   /**
    * @see GuiParameter#isEqualValidator()
    * @return boolean
    */
    protected abstract boolean handleIsEqualValidator();

    private boolean equalValidator88a;
    private boolean equalValidator88aSet = false;

    /**
     * Indicates whether or not this parameter uses the equal validator.
     * @return (boolean)handleIsEqualValidator()
     */
    public final boolean isEqualValidator()
    {
        boolean aequalValidator88a = this.equalValidator88a;
        if (!this.equalValidator88aSet)
        {
            // equalValidator has no pre constraints
            aequalValidator88a = handleIsEqualValidator();
            // equalValidator has no post constraints
            this.equalValidator88a = aequalValidator88a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.equalValidator88aSet = true;
            }
        }
        return aequalValidator88a;
    }

   /**
    * @see GuiParameter#getBackingValueName()
    * @return String
    */
    protected abstract String handleGetBackingValueName();

    private String backingValueName89a;
    private boolean backingValueName89aSet = false;

    /**
     * The name of the backing value for this parameter (only used with collections and arrays that
     * are input type table).
     * @return (String)handleGetBackingValueName()
     */
    public final String getBackingValueName()
    {
        String abackingValueName89a = this.backingValueName89a;
        if (!this.backingValueName89aSet)
        {
            // backingValueName has no pre constraints
            abackingValueName89a = handleGetBackingValueName();
            // backingValueName has no post constraints
            this.backingValueName89a = abackingValueName89a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.backingValueName89aSet = true;
            }
        }
        return abackingValueName89a;
    }

   /**
    * @see GuiParameter#isInputTable()
    * @return boolean
    */
    protected abstract boolean handleIsInputTable();

    private boolean inputTable90a;
    private boolean inputTable90aSet = false;

    /**
     * Indicates whether or not this is an table input type.
     * @return (boolean)handleIsInputTable()
     */
    public final boolean isInputTable()
    {
        boolean ainputTable90a = this.inputTable90a;
        if (!this.inputTable90aSet)
        {
            // inputTable has no pre constraints
            ainputTable90a = handleIsInputTable();
            // inputTable has no post constraints
            this.inputTable90a = ainputTable90a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputTable90aSet = true;
            }
        }
        return ainputTable90a;
    }

   /**
    * @see GuiParameter#isBackingValueRequired()
    * @return boolean
    */
    protected abstract boolean handleIsBackingValueRequired();

    private boolean backingValueRequired91a;
    private boolean backingValueRequired91aSet = false;

    /**
     * Indicates if a backing value is required for this parameter.
     * @return (boolean)handleIsBackingValueRequired()
     */
    public final boolean isBackingValueRequired()
    {
        boolean abackingValueRequired91a = this.backingValueRequired91a;
        if (!this.backingValueRequired91aSet)
        {
            // backingValueRequired has no pre constraints
            abackingValueRequired91a = handleIsBackingValueRequired();
            // backingValueRequired has no post constraints
            this.backingValueRequired91a = abackingValueRequired91a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.backingValueRequired91aSet = true;
            }
        }
        return abackingValueRequired91a;
    }

   /**
    * @see GuiParameter#getInputTableIdentifierColumns()
    * @return String
    */
    protected abstract String handleGetInputTableIdentifierColumns();

    private String inputTableIdentifierColumns92a;
    private boolean inputTableIdentifierColumns92aSet = false;

    /**
     * A comma separated list of the input table identifier columns (these are the columns that
     * uniquely define a row in an input table).
     * @return (String)handleGetInputTableIdentifierColumns()
     */
    public final String getInputTableIdentifierColumns()
    {
        String ainputTableIdentifierColumns92a = this.inputTableIdentifierColumns92a;
        if (!this.inputTableIdentifierColumns92aSet)
        {
            // inputTableIdentifierColumns has no pre constraints
            ainputTableIdentifierColumns92a = handleGetInputTableIdentifierColumns();
            // inputTableIdentifierColumns has no post constraints
            this.inputTableIdentifierColumns92a = ainputTableIdentifierColumns92a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputTableIdentifierColumns92aSet = true;
            }
        }
        return ainputTableIdentifierColumns92a;
    }

   /**
    * @see GuiParameter#isPageableTable()
    * @return boolean
    */
    protected abstract boolean handleIsPageableTable();

    private boolean pageableTable93a;
    private boolean pageableTable93aSet = false;

    /**
     * Whether or not the parameter is a "pageable table", that is a table that supports paging
     * (i.e. DB paging).
     * @return (boolean)handleIsPageableTable()
     */
    public final boolean isPageableTable()
    {
        boolean apageableTable93a = this.pageableTable93a;
        if (!this.pageableTable93aSet)
        {
            // pageableTable has no pre constraints
            apageableTable93a = handleIsPageableTable();
            // pageableTable has no post constraints
            this.pageableTable93a = apageableTable93a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.pageableTable93aSet = true;
            }
        }
        return apageableTable93a;
    }

   /**
    * @see GuiParameter#getMaxLength()
    * @return String
    */
    protected abstract String handleGetMaxLength();

    private String maxLength94a;
    private boolean maxLength94aSet = false;

    /**
     * The max length allowed in the input component
     * @return (String)handleGetMaxLength()
     */
    public final String getMaxLength()
    {
        String amaxLength94a = this.maxLength94a;
        if (!this.maxLength94aSet)
        {
            // maxLength has no pre constraints
            amaxLength94a = handleGetMaxLength();
            // maxLength has no post constraints
            this.maxLength94a = amaxLength94a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.maxLength94aSet = true;
            }
        }
        return amaxLength94a;
    }

   /**
    * @see GuiParameter#getAnnotations()
    * @return Collection
    */
    protected abstract Collection handleGetAnnotations();

    private Collection annotations95a;
    private boolean annotations95aSet = false;

    /**
     * All the annotations for this parameter.
     * @return (Collection)handleGetAnnotations()
     */
    public final Collection getAnnotations()
    {
        Collection aannotations95a = this.annotations95a;
        if (!this.annotations95aSet)
        {
            // annotations has no pre constraints
            aannotations95a = handleGetAnnotations();
            // annotations has no post constraints
            this.annotations95a = aannotations95a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.annotations95aSet = true;
            }
        }
        return aannotations95a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * Returns the arguments for this parameter's validators.
     * @param validatorType
     * @return Collection
     */
    protected abstract Collection handleGetValidatorArgs(String validatorType);

    /**
     * Returns the arguments for this parameter's validators.
     * @param validatorType String
     * @return handleGetValidatorArgs(validatorType)
     */
    public Collection getValidatorArgs(String validatorType)
    {
        // getValidatorArgs has no pre constraints
        Collection returnValue = handleGetValidatorArgs(validatorType);
        // getValidatorArgs has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Returns the resource bundle key for this table's column, only returns a value when this
     * parameter is a table.
     * @param columnName
     * @return String
     */
    protected abstract String handleGetTableColumnMessageKey(String columnName);

    /**
     * Returns the resource bundle key for this table's column, only returns a value when this
     * parameter is a table.
     * @param columnName String
     * @return handleGetTableColumnMessageKey(columnName)
     */
    public String getTableColumnMessageKey(String columnName)
    {
        // getTableColumnMessageKey has no pre constraints
        String returnValue = handleGetTableColumnMessageKey(columnName);
        // getTableColumnMessageKey has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Returns the resource bundle value for this table's column, only returns a value when this
     * parameter is a table.
     * @param columnName
     * @return String
     */
    protected abstract String handleGetTableColumnMessageValue(String columnName);

    /**
     * Returns the resource bundle value for this table's column, only returns a value when this
     * parameter is a table.
     * @param columnName String
     * @return handleGetTableColumnMessageValue(columnName)
     */
    public String getTableColumnMessageValue(String columnName)
    {
        // getTableColumnMessageValue has no pre constraints
        String returnValue = handleGetTableColumnMessageValue(columnName);
        // getTableColumnMessageValue has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Those actions that are targetting this table's columns, only makes sense when this parameter
     * represents a table page-variable.
     * @param columnName
     * @return List
     */
    protected abstract List handleGetTableColumnActions(String columnName);

    /**
     * Those actions that are targetting this table's columns, only makes sense when this parameter
     * represents a table page-variable.
     * @param columnName String
     * @return handleGetTableColumnActions(columnName)
     */
    public List getTableColumnActions(String columnName)
    {
        // getTableColumnActions has no pre constraints
        List returnValue = handleGetTableColumnActions(columnName);
        // getTableColumnActions has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param string
     * @return String
     */
    protected abstract String handleToPhrase(String string);

    /**
     * 
     * @param string String
     * @return handleToPhrase(string)
     */
    public String toPhrase(String string)
    {
        // toPhrase has no pre constraints
        String returnValue = handleToPhrase(string);
        // toPhrase has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    private GuiAction getGuiAction1r;
    private boolean getGuiAction1rSet = false;

    /**
     * 
     * @return (GuiAction)handleGetGuiAction()
     */
    public final GuiAction getGuiAction()
    {
        GuiAction getGuiAction1r = this.getGuiAction1r;
        if (!this.getGuiAction1rSet)
        {
            // guiParameter has no pre constraints
            Object result = handleGetGuiAction();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getGuiAction1r = (GuiAction)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiParameterLogic.LOGGER.warn("incorrect metafacade cast for GuiParameterLogic.getGuiAction GuiAction " + result + ": " + shieldedResult);
            }
            // guiParameter has no post constraints
            this.getGuiAction1r = getGuiAction1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getGuiAction1rSet = true;
            }
        }
        return getGuiAction1r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetGuiAction();

    private GuiView getGuiView2r;
    private boolean getGuiView2rSet = false;

    /**
     * 
     * @return (GuiView)handleGetGuiView()
     */
    public final GuiView getGuiView()
    {
        GuiView getGuiView2r = this.getGuiView2r;
        if (!this.getGuiView2rSet)
        {
            // guiParameter has no pre constraints
            Object result = handleGetGuiView();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getGuiView2r = (GuiView)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiParameterLogic.LOGGER.warn("incorrect metafacade cast for GuiParameterLogic.getGuiView GuiView " + result + ": " + shieldedResult);
            }
            // guiParameter has no post constraints
            this.getGuiView2r = getGuiView2r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getGuiView2rSet = true;
            }
        }
        return getGuiView2r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetGuiView();

    private Collection<GuiAction> getTableGlobalActions3r;
    private boolean getTableGlobalActions3rSet = false;

    /**
     * 
     * @return (Collection<GuiAction>)handleGetTableGlobalActions()
     */
    public final Collection<GuiAction> getTableGlobalActions()
    {
        Collection<GuiAction> getTableGlobalActions3r = this.getTableGlobalActions3r;
        if (!this.getTableGlobalActions3rSet)
        {
            // guiParameter has no pre constraints
            Collection result = handleGetTableGlobalActions();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getTableGlobalActions3r = (Collection<GuiAction>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiParameterLogic.LOGGER.warn("incorrect metafacade cast for GuiParameterLogic.getTableGlobalActions Collection<GuiAction> " + result + ": " + shieldedResult);
            }
            // guiParameter has no post constraints
            this.getTableGlobalActions3r = getTableGlobalActions3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getTableGlobalActions3rSet = true;
            }
        }
        return getTableGlobalActions3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  Collection
     */
    protected abstract Collection handleGetTableGlobalActions();

    private List<GuiAction> getTableHyperlinkActions4r;
    private boolean getTableHyperlinkActions4rSet = false;

    /**
     * If the action is a table link then this property represents the table to which is being
     * linked.
     * @return (List<GuiAction>)handleGetTableHyperlinkActions()
     */
    public final List<GuiAction> getTableHyperlinkActions()
    {
        List<GuiAction> getTableHyperlinkActions4r = this.getTableHyperlinkActions4r;
        if (!this.getTableHyperlinkActions4rSet)
        {
            // tableLinkParameter has no pre constraints
            List result = handleGetTableHyperlinkActions();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getTableHyperlinkActions4r = (List<GuiAction>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiParameterLogic.LOGGER.warn("incorrect metafacade cast for GuiParameterLogic.getTableHyperlinkActions List<GuiAction> " + result + ": " + shieldedResult);
            }
            // tableLinkParameter has no post constraints
            this.getTableHyperlinkActions4r = getTableHyperlinkActions4r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getTableHyperlinkActions4rSet = true;
            }
        }
        return getTableHyperlinkActions4r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetTableHyperlinkActions();

    private GuiParameter getTableGlobalActionParameter5r;
    private boolean getTableGlobalActionParameter5rSet = false;

    /**
     * 
     * @return (GuiParameter)handleGetTableGlobalActionParameter()
     */
    public final GuiParameter getTableGlobalActionParameter()
    {
        GuiParameter getTableGlobalActionParameter5r = this.getTableGlobalActionParameter5r;
        if (!this.getTableGlobalActionParameter5rSet)
        {
            // guiParameter has no pre constraints
            Object result = handleGetTableGlobalActionParameter();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getTableGlobalActionParameter5r = (GuiParameter)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiParameterLogic.LOGGER.warn("incorrect metafacade cast for GuiParameterLogic.getTableGlobalActionParameter GuiParameter " + result + ": " + shieldedResult);
            }
            // guiParameter has no post constraints
            this.getTableGlobalActionParameter5r = getTableGlobalActionParameter5r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getTableGlobalActionParameter5rSet = true;
            }
        }
        return getTableGlobalActionParameter5r;
    }

    /**
     * UML Specific type is transformed by shieldedElements to AndroMDA Metafacade type
     * @return Object
     */
    protected abstract Object handleGetTableGlobalActionParameter();

    private List<GuiParameter> getFormFields6r;
    private boolean getFormFields6rSet = false;

    /**
     * 
     * @return (List<GuiParameter>)handleGetFormFields()
     */
    public final List<GuiParameter> getFormFields()
    {
        List<GuiParameter> getFormFields6r = this.getFormFields6r;
        if (!this.getFormFields6rSet)
        {
            // guiParameter has no pre constraints
            List result = handleGetFormFields();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getFormFields6r = (List<GuiParameter>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiParameterLogic.LOGGER.warn("incorrect metafacade cast for GuiParameterLogic.getFormFields List<GuiParameter> " + result + ": " + shieldedResult);
            }
            // guiParameter has no post constraints
            this.getFormFields6r = getFormFields6r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getFormFields6rSet = true;
            }
        }
        return getFormFields6r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetFormFields();

    private List<GuiAction> getTableFormActions7r;
    private boolean getTableFormActions7rSet = false;

    /**
     * Returns all parameters transported in this action.
     * @return (List<GuiAction>)handleGetTableFormActions()
     */
    public final List<GuiAction> getTableFormActions()
    {
        List<GuiAction> getTableFormActions7r = this.getTableFormActions7r;
        if (!this.getTableFormActions7rSet)
        {
            // actionParametersToDeletes has no pre constraints
            List result = handleGetTableFormActions();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getTableFormActions7r = (List<GuiAction>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiParameterLogic.LOGGER.warn("incorrect metafacade cast for GuiParameterLogic.getTableFormActions List<GuiAction> " + result + ": " + shieldedResult);
            }
            // actionParametersToDeletes has no post constraints
            this.getTableFormActions7r = getTableFormActions7r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getTableFormActions7rSet = true;
            }
        }
        return getTableFormActions7r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetTableFormActions();

    /**
     * @return true
     * @see FrontEndParameter
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

    // ----------- delegates to FrontEndParameter ------------
    /**
     * The action to which this parameter belongs (if it belongs to an action), otherwise it returns
     * null.
     * @see FrontEndParameter#getAction()
     */
    public FrontEndAction getAction()
    {
        return this.getSuperFrontEndParameter().getAction();
    }

    /**
     * Gets the controller operation to which this parameter belongs.
     * @see FrontEndParameter#getControllerOperation()
     */
    public FrontEndControllerOperation getControllerOperation()
    {
        return this.getSuperFrontEndParameter().getControllerOperation();
    }

    /**
     * A collection of all possible attribute names of a table (this will only work when your table
     * is modeled as an array..not a collection).
     * @see FrontEndParameter#getTableAttributeNames()
     */
    public Collection<String> getTableAttributeNames()
    {
        return this.getSuperFrontEndParameter().getTableAttributeNames();
    }

    /**
     * All the columns for this parameter if it represents a table variable. If a column is linked
     * by an event (action) a FrontEndParameter instance is included in the return value, otherwise
     * a plain String representing the column name.
     * @see FrontEndParameter#getTableColumnNames()
     */
    public Collection<String> getTableColumnNames()
    {
        return this.getSuperFrontEndParameter().getTableColumnNames();
    }

    /**
     * A list of all attributes which make up the table columns of this table (this only contains
     * attributes when the table is represented by an array).
     * @see FrontEndParameter#getTableColumns()
     */
    public Collection<String> getTableColumns()
    {
        return this.getSuperFrontEndParameter().getTableColumns();
    }

    /**
     * Represents the view in which this parameter will be used.
     * @see FrontEndParameter#getView()
     */
    public FrontEndView getView()
    {
        return this.getSuperFrontEndParameter().getView();
    }

    /**
     * Indicates whether or not this is an action parameter or not.
     * @see FrontEndParameter#isActionParameter()
     */
    public boolean isActionParameter()
    {
        return this.getSuperFrontEndParameter().isActionParameter();
    }

    /**
     * Indicates if this parameter is contained in a "front-end" use case.
     * @see FrontEndParameter#isContainedInFrontEndUseCase()
     */
    public boolean isContainedInFrontEndUseCase()
    {
        return this.getSuperFrontEndParameter().isContainedInFrontEndUseCase();
    }

    /**
     * Indicates whether or not this parameter is an argument of a controller operation.
     * @see FrontEndParameter#isControllerOperationArgument()
     */
    public boolean isControllerOperationArgument()
    {
        return this.getSuperFrontEndParameter().isControllerOperationArgument();
    }

    /**
     * Indicates whether or not this parameter represents a table.
     * @see FrontEndParameter#isTable()
     */
    public boolean isTable()
    {
        return this.getSuperFrontEndParameter().isTable();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperFrontEndParameter().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperFrontEndParameter().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperFrontEndParameter().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperFrontEndParameter().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperFrontEndParameter().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperFrontEndParameter().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperFrontEndParameter().getDocumentation(indent);
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
        return this.getSuperFrontEndParameter().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperFrontEndParameter().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperFrontEndParameter().getFullyQualifiedName();
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
        return this.getSuperFrontEndParameter().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperFrontEndParameter().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperFrontEndParameter().getId();
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
        return this.getSuperFrontEndParameter().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperFrontEndParameter().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperFrontEndParameter().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperFrontEndParameter().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperFrontEndParameter().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperFrontEndParameter().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperFrontEndParameter().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperFrontEndParameter().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperFrontEndParameter().getPackagePath();
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
        return this.getSuperFrontEndParameter().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperFrontEndParameter().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperFrontEndParameter().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperFrontEndParameter().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperFrontEndParameter().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperFrontEndParameter().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperFrontEndParameter().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperFrontEndParameter().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperFrontEndParameter().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperFrontEndParameter().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperFrontEndParameter().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndParameter().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperFrontEndParameter().hasKeyword(keywordName);
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
        return this.getSuperFrontEndParameter().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperFrontEndParameter().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperFrontEndParameter().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperFrontEndParameter().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperFrontEndParameter().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperFrontEndParameter().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperFrontEndParameter().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperFrontEndParameter().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperFrontEndParameter().translateConstraints(kind, translation);
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.ParameterFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {
        return this.getSuperFrontEndParameter().getDefaultValue();
    }

    /**
     * UML2: A representation of the literals of the enumeration 'Parameter Effect Kind': CREATE,
     * READ, UPDATE, DELETE. The datatype ParameterEffectKind is an enumeration that indicates the
     * effect of a behavior on values passed in or out of its parameters.
     * @see org.andromda.metafacades.uml.ParameterFacade#getEffect()
     */
    public String getEffect()
    {
        return this.getSuperFrontEndParameter().getEffect();
    }

    /**
     * If this parameter is located on an event, this will represent that event.
     * @see org.andromda.metafacades.uml.ParameterFacade#getEvent()
     */
    public EventFacade getEvent()
    {
        return this.getSuperFrontEndParameter().getEvent();
    }

    /**
     * The name to use for accessors getting this parameter from a bean.
     * @see org.andromda.metafacades.uml.ParameterFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperFrontEndParameter().getGetterName();
    }

    /**
     * Fully Qualified TypeName, determined in part by multiplicity (for UML2). For UML14, same as
     * getterName.
     * @see org.andromda.metafacades.uml.ParameterFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperFrontEndParameter().getGetterSetterTypeName();
    }

    /**
     * Fully Qualified implementation class of TypeName, determined in part by multiplicity (for
     * UML2). If upper multiplicity =1, same as getterSetterTypeName.
     * @see org.andromda.metafacades.uml.ParameterFacade#getGetterSetterTypeNameImpl()
     */
    public String getGetterSetterTypeNameImpl()
    {
        return this.getSuperFrontEndParameter().getGetterSetterTypeNameImpl();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.ParameterFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperFrontEndParameter().getLower();
    }

    /**
     * If this parameter is located on an operation, this will represent that operation.
     * @see org.andromda.metafacades.uml.ParameterFacade#getOperation()
     */
    public OperationFacade getOperation()
    {
        return this.getSuperFrontEndParameter().getOperation();
    }

    /**
     * The name to use for accessors getting this parameter in a bean.
     * @see org.andromda.metafacades.uml.ParameterFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperFrontEndParameter().getSetterName();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.ParameterFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperFrontEndParameter().getType();
    }

    /**
     * the upper value of the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.ParameterFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperFrontEndParameter().getUpper();
    }

    /**
     * Indicates if the default value is present.
     * @see org.andromda.metafacades.uml.ParameterFacade#isDefaultValuePresent()
     */
    public boolean isDefaultValuePresent()
    {
        return this.getSuperFrontEndParameter().isDefaultValuePresent();
    }

    /**
     * UML2: Returns the value of the 'Is Exception' attribute. The default value is "false". Tells
     * whether an output parameter may emit a value to the exclusion of the other outputs.
     * @see org.andromda.metafacades.uml.ParameterFacade#isException()
     */
    public boolean isException()
    {
        return this.getSuperFrontEndParameter().isException();
    }

    /**
     * True if this parameter is an 'in' parameter.
     * @see org.andromda.metafacades.uml.ParameterFacade#isInParameter()
     */
    public boolean isInParameter()
    {
        return this.getSuperFrontEndParameter().isInParameter();
    }

    /**
     * True if this parameter is an inout parameter.
     * @see org.andromda.metafacades.uml.ParameterFacade#isInoutParameter()
     */
    public boolean isInoutParameter()
    {
        return this.getSuperFrontEndParameter().isInoutParameter();
    }

    /**
     * If upper>1 or upper==unlimited. Only applies to UML2. For UML14, always false.
     * @see org.andromda.metafacades.uml.ParameterFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperFrontEndParameter().isMany();
    }

    /**
     * UML2 Only: Is parameter ordered within the Collection type. Ordered+Unique determines the
     * implementation Collection Type. For UML14, always false.
     * @see org.andromda.metafacades.uml.ParameterFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperFrontEndParameter().isOrdered();
    }

    /**
     * True if this parameter is an 'out' parameter.
     * @see org.andromda.metafacades.uml.ParameterFacade#isOutParameter()
     */
    public boolean isOutParameter()
    {
        return this.getSuperFrontEndParameter().isOutParameter();
    }

    /**
     * True if this parameter is readable, aka an in-parameter, or this feature is unspecified.
     * @see org.andromda.metafacades.uml.ParameterFacade#isReadable()
     */
    public boolean isReadable()
    {
        return this.getSuperFrontEndParameter().isReadable();
    }

    /**
     * Whether or not this parameter is considered required (i.e must a non-empty value).
     * @see org.andromda.metafacades.uml.ParameterFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperFrontEndParameter().isRequired();
    }

    /**
     * Whether or not this parameter represents a return parameter.
     * @see org.andromda.metafacades.uml.ParameterFacade#isReturn()
     */
    public boolean isReturn()
    {
        return this.getSuperFrontEndParameter().isReturn();
    }

    /**
     * If Parameter type isMany (UML2), is the parameter unique within the Collection. Unique+Sorted
     * determines pareter implementation type. For UML14, always false.
     * @see org.andromda.metafacades.uml.ParameterFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperFrontEndParameter().isUnique();
    }

    /**
     * True if this parameter is writable, aka an out-parameter, or this feature is unspecified.
     * @see org.andromda.metafacades.uml.ParameterFacade#isWritable()
     */
    public boolean isWritable()
    {
        return this.getSuperFrontEndParameter().isWritable();
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperFrontEndParameter().initialize();
    }

    /**
     * @return Object getSuperFrontEndParameter().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperFrontEndParameter().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperFrontEndParameter().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperFrontEndParameter().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiParameter::table on collection or array</p>
     * <p><b>Error:</b> A parameter can only be rendered in tabular format when it is a collection or an array.</p>
     * <p><b>OCL:</b> context GuiParameter inv: table implies multiple</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiParameter::table actions must all have one parameter</p>
     * <p><b>Error:</b> All actions targetting this table and operating on all visible rows at the same time can only have a single parameter, this parameter denotes the value that will be sent when the row has been selected.</p>
     * <p><b>OCL:</b> context GuiParameter inv: tableGlobalActions->notEmpty() implies tableGlobalActions->forAll(actionParameters->size() = 1)</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiParameter::all global table action must have the same parameter</p>
     * <p><b>Error:</b> All actions targetting this table and operating on the entire rowset must have the same event parameter declaration, this means both name and type must match for all parameters in these actions.</p>
     * <p><b>OCL:</b> context GuiParameter inv: tableGlobalActions->notEmpty() implies allGlobalTableActionsHaveSameParameter</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntityAssociationEnd::SAFE NAME - TO BE REMOVED LATER</p>
     * <p><b>Error:</b> The names you give to fields cannot start with a lowercase character directly followed by a character in uppercase. This is due to a bug in the Jakarta commons library which is used by Gui. The behavior of that library is inconsistent with the reflection API provided by the JDK. Please rename this field or you'll get exceptions when running your web application.</p>
     * <p><b>OCL:</b> context GuiAttribute inv: safeNamePresent</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperFrontEndParameter().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"table"))).booleanValue())).booleanValue()?Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"multiple"))).booleanValue():true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiParameter::table on collection or array",
                        "A parameter can only be rendered in tabular format when it is a collection or an array."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiParameter::table on collection or array' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"tableGlobalActions")))).booleanValue()?OCLCollections.forAll(OCLIntrospector.invoke(contextElement,"tableGlobalActions"),new Predicate(){public boolean evaluate(Object object){return Boolean.valueOf(String.valueOf(OCLExpressions.equal(OCLCollections.size(OCLIntrospector.invoke(object,"actionParameters")),1))).booleanValue();}}):true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiParameter::table actions must all have one parameter",
                        "All actions targetting this table and operating on all visible rows at the same time can only have a single parameter, this parameter denotes the value that will be sent when the row has been selected."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiParameter::table actions must all have one parameter' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"tableGlobalActions")))).booleanValue()?Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"allGlobalTableActionsHaveSameParameter"))).booleanValue():true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiParameter::all global table action must have the same parameter",
                        "All actions targetting this table and operating on the entire rowset must have the same event parameter declaration, this means both name and type must match for all parameters in these actions."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiParameter::all global table action must have the same parameter' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure(OCLIntrospector.invoke(contextElement,"safeNamePresent"));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntityAssociationEnd::SAFE NAME - TO BE REMOVED LATER",
                        "The names you give to fields cannot start with a lowercase character directly followed by a character in uppercase. This is due to a bug in the Jakarta commons library which is used by Gui. The behavior of that library is inconsistent with the reflection API provided by the JDK. Please rename this field or you'll get exceptions when running your web application."));
            }
        }
        catch (Throwable th)
        {
            Throwable cause = th.getCause();
            int depth = 0; // Some throwables have infinite recursion
            while (cause != null && depth < 7)
            {
                th = cause;
                depth++;
            }
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntityAssociationEnd::SAFE NAME - TO BE REMOVED LATER' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
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