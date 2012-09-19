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
import org.andromda.metafacades.uml.EnumerationFacade;
import org.andromda.metafacades.uml.ManageableEntityAttribute;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.andromda.translation.ocl.validation.OCLCollections;
import org.andromda.translation.ocl.validation.OCLExpressions;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.log4j.Logger;

/**
 * 
 * MetafacadeLogic for GuiManageableEntityAttribute
 *
 * @see GuiManageableEntityAttribute
 */
public abstract class GuiManageableEntityAttributeLogic
    extends MetafacadeBase
    implements GuiManageableEntityAttribute
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
    protected GuiManageableEntityAttributeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superManageableEntityAttribute =
           (ManageableEntityAttribute)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.ManageableEntityAttribute",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiManageableEntityAttributeLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiManageableEntityAttribute if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiManageableEntityAttribute";
        }
        return context;
    }

    private ManageableEntityAttribute superManageableEntityAttribute;
    private boolean superManageableEntityAttributeInitialized = false;

    /**
     * Gets the ManageableEntityAttribute parent instance.
     * @return this.superManageableEntityAttribute ManageableEntityAttribute
     */
    private ManageableEntityAttribute getSuperManageableEntityAttribute()
    {
        if (!this.superManageableEntityAttributeInitialized)
        {
            ((MetafacadeBase)this.superManageableEntityAttribute).setMetafacadeContext(this.getMetafacadeContext());
            this.superManageableEntityAttributeInitialized = true;
        }
        return this.superManageableEntityAttribute;
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
            if (this.superManageableEntityAttributeInitialized)
            {
                ((MetafacadeBase)this.superManageableEntityAttribute).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see GuiManageableEntityAttribute
     */
    public boolean isGuiManageableEntityAttributeMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see GuiManageableEntityAttribute#getDateFormat()
    * @return String
    */
    protected abstract String handleGetDateFormat();

    private String dateFormat1a;
    private boolean dateFormat1aSet = false;

    /**
     * The String format to use when referring to this date, only makes sense when the type is a
     * date type.
     * @return (String)handleGetDateFormat()
     */
    public final String getDateFormat()
    {
        String adateFormat1a = this.dateFormat1a;
        if (!this.dateFormat1aSet)
        {
            // dateFormat has no pre constraints
            adateFormat1a = handleGetDateFormat();
            // dateFormat has no post constraints
            this.dateFormat1a = adateFormat1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dateFormat1aSet = true;
            }
        }
        return adateFormat1a;
    }

   /**
    * @see GuiManageableEntityAttribute#isHidden()
    * @return boolean
    */
    protected abstract boolean handleIsHidden();

    private boolean hidden2a;
    private boolean hidden2aSet = false;

    /**
     * Whether or not this attribute should be hidden from the view
     * @return (boolean)handleIsHidden()
     */
    public final boolean isHidden()
    {
        boolean ahidden2a = this.hidden2a;
        if (!this.hidden2aSet)
        {
            // hidden has no pre constraints
            ahidden2a = handleIsHidden();
            // hidden has no post constraints
            this.hidden2a = ahidden2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.hidden2aSet = true;
            }
        }
        return ahidden2a;
    }

   /**
    * @see GuiManageableEntityAttribute#getWidgetType()
    * @return String
    */
    protected abstract String handleGetWidgetType();

    private String widgetType3a;
    private boolean widgetType3aSet = false;

    /**
     * The widget to use when rendering this attribute
     * @return (String)handleGetWidgetType()
     */
    public final String getWidgetType()
    {
        String awidgetType3a = this.widgetType3a;
        if (!this.widgetType3aSet)
        {
            // widgetType has no pre constraints
            awidgetType3a = handleGetWidgetType();
            // widgetType has no post constraints
            this.widgetType3a = awidgetType3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.widgetType3aSet = true;
            }
        }
        return awidgetType3a;
    }

   /**
    * @see GuiManageableEntityAttribute#isStrictDateFormat()
    * @return boolean
    */
    protected abstract boolean handleIsStrictDateFormat();

    private boolean strictDateFormat4a;
    private boolean strictDateFormat4aSet = false;

    /**
     * True if this field is a date type and the date format is not be interpreted strictly.
     * @return (boolean)handleIsStrictDateFormat()
     */
    public final boolean isStrictDateFormat()
    {
        boolean astrictDateFormat4a = this.strictDateFormat4a;
        if (!this.strictDateFormat4aSet)
        {
            // strictDateFormat has no pre constraints
            astrictDateFormat4a = handleIsStrictDateFormat();
            // strictDateFormat has no post constraints
            this.strictDateFormat4a = astrictDateFormat4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.strictDateFormat4aSet = true;
            }
        }
        return astrictDateFormat4a;
    }

   /**
    * @see GuiManageableEntityAttribute#isSafeNamePresent()
    * @return boolean
    */
    protected abstract boolean handleIsSafeNamePresent();

    private boolean safeNamePresent5a;
    private boolean safeNamePresent5aSet = false;

    /**
     * True if this parameter has a name that can properly be handled by Jakarta commons (this lib
     * is used by Gui but contains a bug)
     * @return (boolean)handleIsSafeNamePresent()
     */
    public final boolean isSafeNamePresent()
    {
        boolean asafeNamePresent5a = this.safeNamePresent5a;
        if (!this.safeNamePresent5aSet)
        {
            // safeNamePresent has no pre constraints
            asafeNamePresent5a = handleIsSafeNamePresent();
            // safeNamePresent has no post constraints
            this.safeNamePresent5a = asafeNamePresent5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.safeNamePresent5aSet = true;
            }
        }
        return asafeNamePresent5a;
    }

   /**
    * @see GuiManageableEntityAttribute#isFilterElement()
    * @return boolean
    */
    protected abstract boolean handleIsFilterElement();

    private boolean filterElement6a;
    private boolean filterElement6aSet = false;

    /**
     * 
     * @return (boolean)handleIsFilterElement()
     */
    public final boolean isFilterElement()
    {
        boolean afilterElement6a = this.filterElement6a;
        if (!this.filterElement6aSet)
        {
            // filterElement has no pre constraints
            afilterElement6a = handleIsFilterElement();
            // filterElement has no post constraints
            this.filterElement6a = afilterElement6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.filterElement6aSet = true;
            }
        }
        return afilterElement6a;
    }

   /**
    * @see GuiManageableEntityAttribute#isMandatory()
    * @return boolean
    */
    protected abstract boolean handleIsMandatory();

    private boolean mandatory7a;
    private boolean mandatory7aSet = false;

    /**
     * 
     * @return (boolean)handleIsMandatory()
     */
    public final boolean isMandatory()
    {
        boolean amandatory7a = this.mandatory7a;
        if (!this.mandatory7aSet)
        {
            // mandatory has no pre constraints
            amandatory7a = handleIsMandatory();
            // mandatory has no post constraints
            this.mandatory7a = amandatory7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.mandatory7aSet = true;
            }
        }
        return amandatory7a;
    }

   /**
    * @see GuiManageableEntityAttribute#isCoherencySource()
    * @return boolean
    */
    protected abstract boolean handleIsCoherencySource();

    private boolean coherencySource8a;
    private boolean coherencySource8aSet = false;

    /**
     * 
     * @return (boolean)handleIsCoherencySource()
     */
    public final boolean isCoherencySource()
    {
        boolean acoherencySource8a = this.coherencySource8a;
        if (!this.coherencySource8aSet)
        {
            // coherencySource has no pre constraints
            acoherencySource8a = handleIsCoherencySource();
            // coherencySource has no post constraints
            this.coherencySource8a = acoherencySource8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.coherencySource8aSet = true;
            }
        }
        return acoherencySource8a;
    }

   /**
    * @see GuiManageableEntityAttribute#isCoherencyTarget()
    * @return boolean
    */
    protected abstract boolean handleIsCoherencyTarget();

    private boolean coherencyTarget9a;
    private boolean coherencyTarget9aSet = false;

    /**
     * 
     * @return (boolean)handleIsCoherencyTarget()
     */
    public final boolean isCoherencyTarget()
    {
        boolean acoherencyTarget9a = this.coherencyTarget9a;
        if (!this.coherencyTarget9aSet)
        {
            // coherencyTarget has no pre constraints
            acoherencyTarget9a = handleIsCoherencyTarget();
            // coherencyTarget has no post constraints
            this.coherencyTarget9a = acoherencyTarget9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.coherencyTarget9aSet = true;
            }
        }
        return acoherencyTarget9a;
    }

   /**
    * @see GuiManageableEntityAttribute#getDisplayName()
    * @return String
    */
    protected abstract String handleGetDisplayName();

    private String displayName10a;
    private boolean displayName10aSet = false;

    /**
     * 
     * @return (String)handleGetDisplayName()
     */
    public final String getDisplayName()
    {
        String adisplayName10a = this.displayName10a;
        if (!this.displayName10aSet)
        {
            // displayName has no pre constraints
            adisplayName10a = handleGetDisplayName();
            // displayName has no post constraints
            this.displayName10a = adisplayName10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.displayName10aSet = true;
            }
        }
        return adisplayName10a;
    }

   /**
    * @see GuiManageableEntityAttribute#getFunctionalCoherency()
    * @return String
    */
    protected abstract String handleGetFunctionalCoherency();

    private String functionalCoherency11a;
    private boolean functionalCoherency11aSet = false;

    /**
     * 
     * @return (String)handleGetFunctionalCoherency()
     */
    public final String getFunctionalCoherency()
    {
        String afunctionalCoherency11a = this.functionalCoherency11a;
        if (!this.functionalCoherency11aSet)
        {
            // functionalCoherency has no pre constraints
            afunctionalCoherency11a = handleGetFunctionalCoherency();
            // functionalCoherency has no post constraints
            this.functionalCoherency11a = afunctionalCoherency11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.functionalCoherency11aSet = true;
            }
        }
        return afunctionalCoherency11a;
    }

   /**
    * @see GuiManageableEntityAttribute#getDictionaryReturnType()
    * @return String
    */
    protected abstract String handleGetDictionaryReturnType();

    private String dictionaryReturnType12a;
    private boolean dictionaryReturnType12aSet = false;

    /**
     * 
     * @return (String)handleGetDictionaryReturnType()
     */
    public final String getDictionaryReturnType()
    {
        String adictionaryReturnType12a = this.dictionaryReturnType12a;
        if (!this.dictionaryReturnType12aSet)
        {
            // dictionaryReturnType has no pre constraints
            adictionaryReturnType12a = handleGetDictionaryReturnType();
            // dictionaryReturnType has no post constraints
            this.dictionaryReturnType12a = adictionaryReturnType12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dictionaryReturnType12aSet = true;
            }
        }
        return adictionaryReturnType12a;
    }

   /**
    * @see GuiManageableEntityAttribute#getNumericFormat()
    * @return String
    */
    protected abstract String handleGetNumericFormat();

    private String numericFormat13a;
    private boolean numericFormat13aSet = false;

    /**
     * 
     * @return (String)handleGetNumericFormat()
     */
    public final String getNumericFormat()
    {
        String anumericFormat13a = this.numericFormat13a;
        if (!this.numericFormat13aSet)
        {
            // numericFormat has no pre constraints
            anumericFormat13a = handleGetNumericFormat();
            // numericFormat has no post constraints
            this.numericFormat13a = anumericFormat13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.numericFormat13aSet = true;
            }
        }
        return anumericFormat13a;
    }

   /**
    * @see GuiManageableEntityAttribute#isReadOnlyForUpdate()
    * @return boolean
    */
    protected abstract boolean handleIsReadOnlyForUpdate();

    private boolean readOnlyForUpdate14a;
    private boolean readOnlyForUpdate14aSet = false;

    /**
     * 
     * @return (boolean)handleIsReadOnlyForUpdate()
     */
    public final boolean isReadOnlyForUpdate()
    {
        boolean areadOnlyForUpdate14a = this.readOnlyForUpdate14a;
        if (!this.readOnlyForUpdate14aSet)
        {
            // readOnlyForUpdate has no pre constraints
            areadOnlyForUpdate14a = handleIsReadOnlyForUpdate();
            // readOnlyForUpdate has no post constraints
            this.readOnlyForUpdate14a = areadOnlyForUpdate14a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.readOnlyForUpdate14aSet = true;
            }
        }
        return areadOnlyForUpdate14a;
    }

   /**
    * @see GuiManageableEntityAttribute#getFieldSize()
    * @return int
    */
    protected abstract int handleGetFieldSize();

    private int fieldSize15a;
    private boolean fieldSize15aSet = false;

    /**
     * 
     * @return (int)handleGetFieldSize()
     */
    public final int getFieldSize()
    {
        int afieldSize15a = this.fieldSize15a;
        if (!this.fieldSize15aSet)
        {
            // fieldSize has no pre constraints
            afieldSize15a = handleGetFieldSize();
            // fieldSize has no post constraints
            this.fieldSize15a = afieldSize15a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.fieldSize15aSet = true;
            }
        }
        return afieldSize15a;
    }

   /**
    * @see GuiManageableEntityAttribute#isDealType()
    * @return boolean
    */
    protected abstract boolean handleIsDealType();

    private boolean dealType16a;
    private boolean dealType16aSet = false;

    /**
     * 
     * @return (boolean)handleIsDealType()
     */
    public final boolean isDealType()
    {
        boolean adealType16a = this.dealType16a;
        if (!this.dealType16aSet)
        {
            // dealType has no pre constraints
            adealType16a = handleIsDealType();
            // dealType has no post constraints
            this.dealType16a = adealType16a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dealType16aSet = true;
            }
        }
        return adealType16a;
    }

   /**
    * @see GuiManageableEntityAttribute#isDealId()
    * @return boolean
    */
    protected abstract boolean handleIsDealId();

    private boolean dealId17a;
    private boolean dealId17aSet = false;

    /**
     * 
     * @return (boolean)handleIsDealId()
     */
    public final boolean isDealId()
    {
        boolean adealId17a = this.dealId17a;
        if (!this.dealId17aSet)
        {
            // dealId has no pre constraints
            adealId17a = handleIsDealId();
            // dealId has no post constraints
            this.dealId17a = adealId17a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dealId17aSet = true;
            }
        }
        return adealId17a;
    }

   /**
    * @see GuiManageableEntityAttribute#getChoiceType()
    * @return String
    */
    protected abstract String handleGetChoiceType();

    private String choiceType18a;
    private boolean choiceType18aSet = false;

    /**
     * 
     * @return (String)handleGetChoiceType()
     */
    public final String getChoiceType()
    {
        String achoiceType18a = this.choiceType18a;
        if (!this.choiceType18aSet)
        {
            // choiceType has no pre constraints
            achoiceType18a = handleGetChoiceType();
            // choiceType has no post constraints
            this.choiceType18a = achoiceType18a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.choiceType18aSet = true;
            }
        }
        return achoiceType18a;
    }

   /**
    * @see GuiManageableEntityAttribute#getMessageKey()
    * @return String
    */
    protected abstract String handleGetMessageKey();

    private String messageKey19a;
    private boolean messageKey19aSet = false;

    /**
     * 
     * @return (String)handleGetMessageKey()
     */
    public final String getMessageKey()
    {
        String amessageKey19a = this.messageKey19a;
        if (!this.messageKey19aSet)
        {
            // messageKey has no pre constraints
            amessageKey19a = handleGetMessageKey();
            // messageKey has no post constraints
            this.messageKey19a = amessageKey19a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageKey19aSet = true;
            }
        }
        return amessageKey19a;
    }

   /**
    * @see GuiManageableEntityAttribute#getMessageValue()
    * @return String
    */
    protected abstract String handleGetMessageValue();

    private String messageValue20a;
    private boolean messageValue20aSet = false;

    /**
     * 
     * @return (String)handleGetMessageValue()
     */
    public final String getMessageValue()
    {
        String amessageValue20a = this.messageValue20a;
        if (!this.messageValue20aSet)
        {
            // messageValue has no pre constraints
            amessageValue20a = handleGetMessageValue();
            // messageValue has no post constraints
            this.messageValue20a = amessageValue20a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.messageValue20aSet = true;
            }
        }
        return amessageValue20a;
    }

   /**
    * @see GuiManageableEntityAttribute#isNeedsFileUpload()
    * @return boolean
    */
    protected abstract boolean handleIsNeedsFileUpload();

    private boolean needsFileUpload21a;
    private boolean needsFileUpload21aSet = false;

    /**
     * True if this attribute is of a type that cannot easily be represented as a textual string and
     * would be an ideal candidate for HTTP's support for file-upload.
     * @return (boolean)handleIsNeedsFileUpload()
     */
    public final boolean isNeedsFileUpload()
    {
        boolean aneedsFileUpload21a = this.needsFileUpload21a;
        if (!this.needsFileUpload21aSet)
        {
            // needsFileUpload has no pre constraints
            aneedsFileUpload21a = handleIsNeedsFileUpload();
            // needsFileUpload has no post constraints
            this.needsFileUpload21a = aneedsFileUpload21a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.needsFileUpload21aSet = true;
            }
        }
        return aneedsFileUpload21a;
    }

   /**
    * @see GuiManageableEntityAttribute#getOnlineHelpKey()
    * @return String
    */
    protected abstract String handleGetOnlineHelpKey();

    private String onlineHelpKey22a;
    private boolean onlineHelpKey22aSet = false;

    /**
     * The key to lookup the online help documentation. This documentation is gathered from the
     * documentation entered by the user, as well as analyzing the model.
     * @return (String)handleGetOnlineHelpKey()
     */
    public final String getOnlineHelpKey()
    {
        String aonlineHelpKey22a = this.onlineHelpKey22a;
        if (!this.onlineHelpKey22aSet)
        {
            // onlineHelpKey has no pre constraints
            aonlineHelpKey22a = handleGetOnlineHelpKey();
            // onlineHelpKey has no post constraints
            this.onlineHelpKey22a = aonlineHelpKey22a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpKey22aSet = true;
            }
        }
        return aonlineHelpKey22a;
    }

   /**
    * @see GuiManageableEntityAttribute#getOnlineHelpValue()
    * @return String
    */
    protected abstract String handleGetOnlineHelpValue();

    private String onlineHelpValue23a;
    private boolean onlineHelpValue23aSet = false;

    /**
     * The online help documentation. This documentation is gathered from the documentation entered
     * by the user, as well as analyzing the model. The format is HTML without any style.
     * @return (String)handleGetOnlineHelpValue()
     */
    public final String getOnlineHelpValue()
    {
        String aonlineHelpValue23a = this.onlineHelpValue23a;
        if (!this.onlineHelpValue23aSet)
        {
            // onlineHelpValue has no pre constraints
            aonlineHelpValue23a = handleGetOnlineHelpValue();
            // onlineHelpValue has no post constraints
            this.onlineHelpValue23a = aonlineHelpValue23a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.onlineHelpValue23aSet = true;
            }
        }
        return aonlineHelpValue23a;
    }

   /**
    * @see GuiManageableEntityAttribute#getFormat()
    * @return String
    */
    protected abstract String handleGetFormat();

    private String format24a;
    private boolean format24aSet = false;

    /**
     * 
     * @return (String)handleGetFormat()
     */
    public final String getFormat()
    {
        String aformat24a = this.format24a;
        if (!this.format24aSet)
        {
            // format has no pre constraints
            aformat24a = handleGetFormat();
            // format has no post constraints
            this.format24a = aformat24a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.format24aSet = true;
            }
        }
        return aformat24a;
    }

   /**
    * @see GuiManageableEntityAttribute#getDefaultDateFormat()
    * @return String
    */
    protected abstract String handleGetDefaultDateFormat();

    private String defaultDateFormat25a;
    private boolean defaultDateFormat25aSet = false;

    /**
     * 
     * @return (String)handleGetDefaultDateFormat()
     */
    public final String getDefaultDateFormat()
    {
        String adefaultDateFormat25a = this.defaultDateFormat25a;
        if (!this.defaultDateFormat25aSet)
        {
            // defaultDateFormat has no pre constraints
            adefaultDateFormat25a = handleGetDefaultDateFormat();
            // defaultDateFormat has no post constraints
            this.defaultDateFormat25a = adefaultDateFormat25a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.defaultDateFormat25aSet = true;
            }
        }
        return adefaultDateFormat25a;
    }

   /**
    * @see GuiManageableEntityAttribute#getDefaultTimeFormat()
    * @return String
    */
    protected abstract String handleGetDefaultTimeFormat();

    private String defaultTimeFormat26a;
    private boolean defaultTimeFormat26aSet = false;

    /**
     * 
     * @return (String)handleGetDefaultTimeFormat()
     */
    public final String getDefaultTimeFormat()
    {
        String adefaultTimeFormat26a = this.defaultTimeFormat26a;
        if (!this.defaultTimeFormat26aSet)
        {
            // defaultTimeFormat has no pre constraints
            adefaultTimeFormat26a = handleGetDefaultTimeFormat();
            // defaultTimeFormat has no post constraints
            this.defaultTimeFormat26a = adefaultTimeFormat26a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.defaultTimeFormat26aSet = true;
            }
        }
        return adefaultTimeFormat26a;
    }

   /**
    * @see GuiManageableEntityAttribute#getDateFormatter()
    * @return String
    */
    protected abstract String handleGetDateFormatter();

    private String dateFormatter27a;
    private boolean dateFormatter27aSet = false;

    /**
     * 
     * @return (String)handleGetDateFormatter()
     */
    public final String getDateFormatter()
    {
        String adateFormatter27a = this.dateFormatter27a;
        if (!this.dateFormatter27aSet)
        {
            // dateFormatter has no pre constraints
            adateFormatter27a = handleGetDateFormatter();
            // dateFormatter has no post constraints
            this.dateFormatter27a = adateFormatter27a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dateFormatter27aSet = true;
            }
        }
        return adateFormatter27a;
    }

   /**
    * @see GuiManageableEntityAttribute#getTimeFormatter()
    * @return String
    */
    protected abstract String handleGetTimeFormatter();

    private String timeFormatter28a;
    private boolean timeFormatter28aSet = false;

    /**
     * 
     * @return (String)handleGetTimeFormatter()
     */
    public final String getTimeFormatter()
    {
        String atimeFormatter28a = this.timeFormatter28a;
        if (!this.timeFormatter28aSet)
        {
            // timeFormatter has no pre constraints
            atimeFormatter28a = handleGetTimeFormatter();
            // timeFormatter has no post constraints
            this.timeFormatter28a = atimeFormatter28a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.timeFormatter28aSet = true;
            }
        }
        return atimeFormatter28a;
    }

   /**
    * @see GuiManageableEntityAttribute#getBackingListName()
    * @return String
    */
    protected abstract String handleGetBackingListName();

    private String backingListName29a;
    private boolean backingListName29aSet = false;

    /**
     * 
     * @return (String)handleGetBackingListName()
     */
    public final String getBackingListName()
    {
        String abackingListName29a = this.backingListName29a;
        if (!this.backingListName29aSet)
        {
            // backingListName has no pre constraints
            abackingListName29a = handleGetBackingListName();
            // backingListName has no post constraints
            this.backingListName29a = abackingListName29a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.backingListName29aSet = true;
            }
        }
        return abackingListName29a;
    }

   /**
    * @see GuiManageableEntityAttribute#getValueListName()
    * @return String
    */
    protected abstract String handleGetValueListName();

    private String valueListName30a;
    private boolean valueListName30aSet = false;

    /**
     * 
     * @return (String)handleGetValueListName()
     */
    public final String getValueListName()
    {
        String avalueListName30a = this.valueListName30a;
        if (!this.valueListName30aSet)
        {
            // valueListName has no pre constraints
            avalueListName30a = handleGetValueListName();
            // valueListName has no post constraints
            this.valueListName30a = avalueListName30a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.valueListName30aSet = true;
            }
        }
        return avalueListName30a;
    }

   /**
    * @see GuiManageableEntityAttribute#getLabelListName()
    * @return String
    */
    protected abstract String handleGetLabelListName();

    private String labelListName31a;
    private boolean labelListName31aSet = false;

    /**
     * 
     * @return (String)handleGetLabelListName()
     */
    public final String getLabelListName()
    {
        String alabelListName31a = this.labelListName31a;
        if (!this.labelListName31aSet)
        {
            // labelListName has no pre constraints
            alabelListName31a = handleGetLabelListName();
            // labelListName has no post constraints
            this.labelListName31a = alabelListName31a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.labelListName31aSet = true;
            }
        }
        return alabelListName31a;
    }

   /**
    * @see GuiManageableEntityAttribute#getValidatorTypes()
    * @return Collection
    */
    protected abstract Collection handleGetValidatorTypes();

    private Collection validatorTypes32a;
    private boolean validatorTypes32aSet = false;

    /**
     * All validator types for this attribute.
     * @return (Collection)handleGetValidatorTypes()
     */
    public final Collection getValidatorTypes()
    {
        Collection avalidatorTypes32a = this.validatorTypes32a;
        if (!this.validatorTypes32aSet)
        {
            // validatorTypes has no pre constraints
            avalidatorTypes32a = handleGetValidatorTypes();
            // validatorTypes has no post constraints
            this.validatorTypes32a = avalidatorTypes32a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validatorTypes32aSet = true;
            }
        }
        return avalidatorTypes32a;
    }

   /**
    * @see GuiManageableEntityAttribute#isValidationRequired()
    * @return boolean
    */
    protected abstract boolean handleIsValidationRequired();

    private boolean validationRequired33a;
    private boolean validationRequired33aSet = false;

    /**
     * Indicates whether or not this attribute requires some kind of validation (the collection of
     * validator types is not empty).
     * @return (boolean)handleIsValidationRequired()
     */
    public final boolean isValidationRequired()
    {
        boolean avalidationRequired33a = this.validationRequired33a;
        if (!this.validationRequired33aSet)
        {
            // validationRequired has no pre constraints
            avalidationRequired33a = handleIsValidationRequired();
            // validationRequired has no post constraints
            this.validationRequired33a = avalidationRequired33a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validationRequired33aSet = true;
            }
        }
        return avalidationRequired33a;
    }

   /**
    * @see GuiManageableEntityAttribute#getValidWhen()
    * @return String
    */
    protected abstract String handleGetValidWhen();

    private String validWhen34a;
    private boolean validWhen34aSet = false;

    /**
     * 
     * @return (String)handleGetValidWhen()
     */
    public final String getValidWhen()
    {
        String avalidWhen34a = this.validWhen34a;
        if (!this.validWhen34aSet)
        {
            // validWhen has no pre constraints
            avalidWhen34a = handleGetValidWhen();
            // validWhen has no post constraints
            this.validWhen34a = avalidWhen34a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validWhen34aSet = true;
            }
        }
        return avalidWhen34a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputCheckbox()
    * @return boolean
    */
    protected abstract boolean handleIsInputCheckbox();

    private boolean inputCheckbox35a;
    private boolean inputCheckbox35aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputCheckbox()
     */
    public final boolean isInputCheckbox()
    {
        boolean ainputCheckbox35a = this.inputCheckbox35a;
        if (!this.inputCheckbox35aSet)
        {
            // inputCheckbox has no pre constraints
            ainputCheckbox35a = handleIsInputCheckbox();
            // inputCheckbox has no post constraints
            this.inputCheckbox35a = ainputCheckbox35a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputCheckbox35aSet = true;
            }
        }
        return ainputCheckbox35a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputFile()
    * @return boolean
    */
    protected abstract boolean handleIsInputFile();

    private boolean inputFile36a;
    private boolean inputFile36aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputFile()
     */
    public final boolean isInputFile()
    {
        boolean ainputFile36a = this.inputFile36a;
        if (!this.inputFile36aSet)
        {
            // inputFile has no pre constraints
            ainputFile36a = handleIsInputFile();
            // inputFile has no post constraints
            this.inputFile36a = ainputFile36a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputFile36aSet = true;
            }
        }
        return ainputFile36a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputHidden()
    * @return boolean
    */
    protected abstract boolean handleIsInputHidden();

    private boolean inputHidden37a;
    private boolean inputHidden37aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputHidden()
     */
    public final boolean isInputHidden()
    {
        boolean ainputHidden37a = this.inputHidden37a;
        if (!this.inputHidden37aSet)
        {
            // inputHidden has no pre constraints
            ainputHidden37a = handleIsInputHidden();
            // inputHidden has no post constraints
            this.inputHidden37a = ainputHidden37a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputHidden37aSet = true;
            }
        }
        return ainputHidden37a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputMultibox()
    * @return boolean
    */
    protected abstract boolean handleIsInputMultibox();

    private boolean inputMultibox38a;
    private boolean inputMultibox38aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputMultibox()
     */
    public final boolean isInputMultibox()
    {
        boolean ainputMultibox38a = this.inputMultibox38a;
        if (!this.inputMultibox38aSet)
        {
            // inputMultibox has no pre constraints
            ainputMultibox38a = handleIsInputMultibox();
            // inputMultibox has no post constraints
            this.inputMultibox38a = ainputMultibox38a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputMultibox38aSet = true;
            }
        }
        return ainputMultibox38a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputRadio()
    * @return boolean
    */
    protected abstract boolean handleIsInputRadio();

    private boolean inputRadio39a;
    private boolean inputRadio39aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputRadio()
     */
    public final boolean isInputRadio()
    {
        boolean ainputRadio39a = this.inputRadio39a;
        if (!this.inputRadio39aSet)
        {
            // inputRadio has no pre constraints
            ainputRadio39a = handleIsInputRadio();
            // inputRadio has no post constraints
            this.inputRadio39a = ainputRadio39a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputRadio39aSet = true;
            }
        }
        return ainputRadio39a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputSecret()
    * @return boolean
    */
    protected abstract boolean handleIsInputSecret();

    private boolean inputSecret40a;
    private boolean inputSecret40aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputSecret()
     */
    public final boolean isInputSecret()
    {
        boolean ainputSecret40a = this.inputSecret40a;
        if (!this.inputSecret40aSet)
        {
            // inputSecret has no pre constraints
            ainputSecret40a = handleIsInputSecret();
            // inputSecret has no post constraints
            this.inputSecret40a = ainputSecret40a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputSecret40aSet = true;
            }
        }
        return ainputSecret40a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputSelect()
    * @return boolean
    */
    protected abstract boolean handleIsInputSelect();

    private boolean inputSelect41a;
    private boolean inputSelect41aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputSelect()
     */
    public final boolean isInputSelect()
    {
        boolean ainputSelect41a = this.inputSelect41a;
        if (!this.inputSelect41aSet)
        {
            // inputSelect has no pre constraints
            ainputSelect41a = handleIsInputSelect();
            // inputSelect has no post constraints
            this.inputSelect41a = ainputSelect41a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputSelect41aSet = true;
            }
        }
        return ainputSelect41a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputTable()
    * @return boolean
    */
    protected abstract boolean handleIsInputTable();

    private boolean inputTable42a;
    private boolean inputTable42aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputTable()
     */
    public final boolean isInputTable()
    {
        boolean ainputTable42a = this.inputTable42a;
        if (!this.inputTable42aSet)
        {
            // inputTable has no pre constraints
            ainputTable42a = handleIsInputTable();
            // inputTable has no post constraints
            this.inputTable42a = ainputTable42a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputTable42aSet = true;
            }
        }
        return ainputTable42a;
    }

   /**
    * @see GuiManageableEntityAttribute#getInputTableIdentifierColumns()
    * @return String
    */
    protected abstract String handleGetInputTableIdentifierColumns();

    private String inputTableIdentifierColumns43a;
    private boolean inputTableIdentifierColumns43aSet = false;

    /**
     * 
     * @return (String)handleGetInputTableIdentifierColumns()
     */
    public final String getInputTableIdentifierColumns()
    {
        String ainputTableIdentifierColumns43a = this.inputTableIdentifierColumns43a;
        if (!this.inputTableIdentifierColumns43aSet)
        {
            // inputTableIdentifierColumns has no pre constraints
            ainputTableIdentifierColumns43a = handleGetInputTableIdentifierColumns();
            // inputTableIdentifierColumns has no post constraints
            this.inputTableIdentifierColumns43a = ainputTableIdentifierColumns43a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputTableIdentifierColumns43aSet = true;
            }
        }
        return ainputTableIdentifierColumns43a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputText()
    * @return boolean
    */
    protected abstract boolean handleIsInputText();

    private boolean inputText44a;
    private boolean inputText44aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputText()
     */
    public final boolean isInputText()
    {
        boolean ainputText44a = this.inputText44a;
        if (!this.inputText44aSet)
        {
            // inputText has no pre constraints
            ainputText44a = handleIsInputText();
            // inputText has no post constraints
            this.inputText44a = ainputText44a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputText44aSet = true;
            }
        }
        return ainputText44a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputTextarea()
    * @return boolean
    */
    protected abstract boolean handleIsInputTextarea();

    private boolean inputTextarea45a;
    private boolean inputTextarea45aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputTextarea()
     */
    public final boolean isInputTextarea()
    {
        boolean ainputTextarea45a = this.inputTextarea45a;
        if (!this.inputTextarea45aSet)
        {
            // inputTextarea has no pre constraints
            ainputTextarea45a = handleIsInputTextarea();
            // inputTextarea has no post constraints
            this.inputTextarea45a = ainputTextarea45a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputTextarea45aSet = true;
            }
        }
        return ainputTextarea45a;
    }

   /**
    * @see GuiManageableEntityAttribute#isInputTypePresent()
    * @return boolean
    */
    protected abstract boolean handleIsInputTypePresent();

    private boolean inputTypePresent46a;
    private boolean inputTypePresent46aSet = false;

    /**
     * 
     * @return (boolean)handleIsInputTypePresent()
     */
    public final boolean isInputTypePresent()
    {
        boolean ainputTypePresent46a = this.inputTypePresent46a;
        if (!this.inputTypePresent46aSet)
        {
            // inputTypePresent has no pre constraints
            ainputTypePresent46a = handleIsInputTypePresent();
            // inputTypePresent has no post constraints
            this.inputTypePresent46a = ainputTypePresent46a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.inputTypePresent46aSet = true;
            }
        }
        return ainputTypePresent46a;
    }

   /**
    * @see GuiManageableEntityAttribute#getDummyValue()
    * @return String
    */
    protected abstract String handleGetDummyValue();

    private String dummyValue47a;
    private boolean dummyValue47aSet = false;

    /**
     * 
     * @return (String)handleGetDummyValue()
     */
    public final String getDummyValue()
    {
        String adummyValue47a = this.dummyValue47a;
        if (!this.dummyValue47aSet)
        {
            // dummyValue has no pre constraints
            adummyValue47a = handleGetDummyValue();
            // dummyValue has no post constraints
            this.dummyValue47a = adummyValue47a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.dummyValue47aSet = true;
            }
        }
        return adummyValue47a;
    }

   /**
    * @see GuiManageableEntityAttribute#isEqualValidator()
    * @return boolean
    */
    protected abstract boolean handleIsEqualValidator();

    private boolean equalValidator48a;
    private boolean equalValidator48aSet = false;

    /**
     * 
     * @return (boolean)handleIsEqualValidator()
     */
    public final boolean isEqualValidator()
    {
        boolean aequalValidator48a = this.equalValidator48a;
        if (!this.equalValidator48aSet)
        {
            // equalValidator has no pre constraints
            aequalValidator48a = handleIsEqualValidator();
            // equalValidator has no post constraints
            this.equalValidator48a = aequalValidator48a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.equalValidator48aSet = true;
            }
        }
        return aequalValidator48a;
    }

   /**
    * @see GuiManageableEntityAttribute#isPlaintext()
    * @return boolean
    */
    protected abstract boolean handleIsPlaintext();

    private boolean plaintext49a;
    private boolean plaintext49aSet = false;

    /**
     * 
     * @return (boolean)handleIsPlaintext()
     */
    public final boolean isPlaintext()
    {
        boolean aplaintext49a = this.plaintext49a;
        if (!this.plaintext49aSet)
        {
            // plaintext has no pre constraints
            aplaintext49a = handleIsPlaintext();
            // plaintext has no post constraints
            this.plaintext49a = aplaintext49a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.plaintext49aSet = true;
            }
        }
        return aplaintext49a;
    }

   /**
    * @see GuiManageableEntityAttribute#getValueListDummyValue()
    * @return String
    */
    protected abstract String handleGetValueListDummyValue();

    private String valueListDummyValue50a;
    private boolean valueListDummyValue50aSet = false;

    /**
     * 
     * @return (String)handleGetValueListDummyValue()
     */
    public final String getValueListDummyValue()
    {
        String avalueListDummyValue50a = this.valueListDummyValue50a;
        if (!this.valueListDummyValue50aSet)
        {
            // valueListDummyValue has no pre constraints
            avalueListDummyValue50a = handleGetValueListDummyValue();
            // valueListDummyValue has no post constraints
            this.valueListDummyValue50a = avalueListDummyValue50a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.valueListDummyValue50aSet = true;
            }
        }
        return avalueListDummyValue50a;
    }

   /**
    * @see GuiManageableEntityAttribute#getValidatorVars()
    * @return Collection
    */
    protected abstract Collection handleGetValidatorVars();

    private Collection validatorVars51a;
    private boolean validatorVars51aSet = false;

    /**
     * The validator variables.
     * @return (Collection)handleGetValidatorVars()
     */
    public final Collection getValidatorVars()
    {
        Collection avalidatorVars51a = this.validatorVars51a;
        if (!this.validatorVars51aSet)
        {
            // validatorVars has no pre constraints
            avalidatorVars51a = handleGetValidatorVars();
            // validatorVars has no post constraints
            this.validatorVars51a = avalidatorVars51a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validatorVars51aSet = true;
            }
        }
        return avalidatorVars51a;
    }

   /**
    * @see GuiManageableEntityAttribute#getMaxLength()
    * @return String
    */
    protected abstract String handleGetMaxLength();

    private String maxLength52a;
    private boolean maxLength52aSet = false;

    /**
     * The max length allowed in the input component
     * @return (String)handleGetMaxLength()
     */
    public final String getMaxLength()
    {
        String amaxLength52a = this.maxLength52a;
        if (!this.maxLength52aSet)
        {
            // maxLength has no pre constraints
            amaxLength52a = handleGetMaxLength();
            // maxLength has no post constraints
            this.maxLength52a = amaxLength52a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.maxLength52aSet = true;
            }
        }
        return amaxLength52a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * 
     * @param dependency
     * @return Object
     */
    protected abstract Object handleGetSourceCoherencyValue(DependencyFacade dependency);

    /**
     * 
     * @param dependency DependencyFacade
     * @return handleGetSourceCoherencyValue(dependency)
     */
    public Object getSourceCoherencyValue(DependencyFacade dependency)
    {
        // getSourceCoherencyValue has no pre constraints
        Object returnValue = handleGetSourceCoherencyValue(dependency);
        // getSourceCoherencyValue has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param targetElement
     * @return String
     */
    protected abstract String handleGetCoherencyStateWhenActivated(GuiManageableEntityAttribute targetElement);

    /**
     * 
     * @param targetElement GuiManageableEntityAttribute
     * @return handleGetCoherencyStateWhenActivated(targetElement)
     */
    public String getCoherencyStateWhenActivated(GuiManageableEntityAttribute targetElement)
    {
        // getCoherencyStateWhenActivated has no pre constraints
        String returnValue = handleGetCoherencyStateWhenActivated(targetElement);
        // getCoherencyStateWhenActivated has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param targetElement
     * @return String
     */
    protected abstract String handleGetCoherencyStateWhenDeactivated(GuiManageableEntityAttribute targetElement);

    /**
     * 
     * @param targetElement GuiManageableEntityAttribute
     * @return handleGetCoherencyStateWhenDeactivated(targetElement)
     */
    public String getCoherencyStateWhenDeactivated(GuiManageableEntityAttribute targetElement)
    {
        // getCoherencyStateWhenDeactivated has no pre constraints
        String returnValue = handleGetCoherencyStateWhenDeactivated(targetElement);
        // getCoherencyStateWhenDeactivated has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param targetElement
     * @param sourceValue
     * @return boolean
     */
    protected abstract boolean handleMustBeDeactivated(GuiManageableEntityAttribute targetElement, Object sourceValue);

    /**
     * 
     * @param targetElement GuiManageableEntityAttribute
     * @param sourceValue Object
     * @return handleMustBeDeactivated(targetElement, sourceValue)
     */
    public boolean mustBeDeactivated(GuiManageableEntityAttribute targetElement, Object sourceValue)
    {
        // mustBeDeactivated has no pre constraints
        boolean returnValue = handleMustBeDeactivated(targetElement, sourceValue);
        // mustBeDeactivated has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param sourceElement
     * @param sourceValue
     * @return Collection
     */
    protected abstract Collection handleGetTargetCoherencyValues(GuiManageableEntityAttribute sourceElement, Object sourceValue);

    /**
     * 
     * @param sourceElement GuiManageableEntityAttribute
     * @param sourceValue Object
     * @return handleGetTargetCoherencyValues(sourceElement, sourceValue)
     */
    public Collection getTargetCoherencyValues(GuiManageableEntityAttribute sourceElement, Object sourceValue)
    {
        // getTargetCoherencyValues has no pre constraints
        Collection returnValue = handleGetTargetCoherencyValues(sourceElement, sourceValue);
        // getTargetCoherencyValues has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return Collection
     */
    protected abstract Collection handleGetAllSourceCoherencyValues();

    /**
     * 
     * @return handleGetAllSourceCoherencyValues()
     */
    public Collection getAllSourceCoherencyValues()
    {
        // getAllSourceCoherencyValues has no pre constraints
        Collection returnValue = handleGetAllSourceCoherencyValues();
        // getAllSourceCoherencyValues has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @return Collection
     */
    protected abstract Collection handleGetAllTargetCoherencyValues();

    /**
     * 
     * @return handleGetAllTargetCoherencyValues()
     */
    public Collection getAllTargetCoherencyValues()
    {
        // getAllTargetCoherencyValues has no pre constraints
        Collection returnValue = handleGetAllTargetCoherencyValues();
        // getAllTargetCoherencyValues has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * 
     * @param validatorType
     * @return Collection
     */
    protected abstract Collection handleGetValidatorArgs(String validatorType);

    /**
     * 
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
     * Gets the unique id of this attribute on the form.
     * @param ownerParameter
     * @return String
     */
    protected abstract String handleGetFormPropertyId(ParameterFacade ownerParameter);

    /**
     * Gets the unique id of this attribute on the form.
     * @param ownerParameter ParameterFacade
     * The parameter that is the owner of this attribute.
     * @return handleGetFormPropertyId(ownerParameter)
     */
    public String getFormPropertyId(ParameterFacade ownerParameter)
    {
        // getFormPropertyId has no pre constraints
        String returnValue = handleGetFormPropertyId(ownerParameter);
        // getFormPropertyId has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * Retrieves the name of the form property for this attribute by taking the name of the owner
     * property.
     * @param ownerParameter
     * @return String
     */
    protected abstract String handleGetFormPropertyName(ParameterFacade ownerParameter);

    /**
     * Retrieves the name of the form property for this attribute by taking the name of the owner
     * property.
     * @param ownerParameter ParameterFacade
     * The parent that is the owner of this parameter.
     * @return handleGetFormPropertyName(ownerParameter)
     */
    public String getFormPropertyName(ParameterFacade ownerParameter)
    {
        // getFormPropertyName has no pre constraints
        String returnValue = handleGetFormPropertyName(ownerParameter);
        // getFormPropertyName has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    private List<GuiManageableEntityAttribute> getStateCoherencies1r;
    private boolean getStateCoherencies1rSet = false;

    /**
     * 
     * @return (List<GuiManageableEntityAttribute>)handleGetStateCoherencies()
     */
    public final List<GuiManageableEntityAttribute> getStateCoherencies()
    {
        List<GuiManageableEntityAttribute> getStateCoherencies1r = this.getStateCoherencies1r;
        if (!this.getStateCoherencies1rSet)
        {
            // guiManageableEntityAttribute has no pre constraints
            List result = handleGetStateCoherencies();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getStateCoherencies1r = (List<GuiManageableEntityAttribute>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiManageableEntityAttributeLogic.LOGGER.warn("incorrect metafacade cast for GuiManageableEntityAttributeLogic.getStateCoherencies List<GuiManageableEntityAttribute> " + result + ": " + shieldedResult);
            }
            // guiManageableEntityAttribute has no post constraints
            this.getStateCoherencies1r = getStateCoherencies1r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getStateCoherencies1rSet = true;
            }
        }
        return getStateCoherencies1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetStateCoherencies();

    /**
     * 
     * @return (List<GuiManageableEntityAttribute>)handleGetValueCoherencyTargets()
     */
    public final List<GuiManageableEntityAttribute> getValueCoherencyTargets()
    {
        List<GuiManageableEntityAttribute> getValueCoherencyTargets2r = null;
        // guiManageableEntityAttribute has no pre constraints
        List result = handleGetValueCoherencyTargets();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getValueCoherencyTargets2r = (List<GuiManageableEntityAttribute>)shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiManageableEntityAttributeLogic.LOGGER.warn("incorrect metafacade cast for GuiManageableEntityAttributeLogic.getValueCoherencyTargets List<GuiManageableEntityAttribute> " + result + ": " + shieldedResult);
        }
        // guiManageableEntityAttribute has no post constraints
        return getValueCoherencyTargets2r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetValueCoherencyTargets();

    private List<GuiManageableEntityAttribute> getValueCoherencySources3r;
    private boolean getValueCoherencySources3rSet = false;

    /**
     * 
     * @return (List<GuiManageableEntityAttribute>)handleGetValueCoherencySources()
     */
    public final List<GuiManageableEntityAttribute> getValueCoherencySources()
    {
        List<GuiManageableEntityAttribute> getValueCoherencySources3r = this.getValueCoherencySources3r;
        if (!this.getValueCoherencySources3rSet)
        {
            // guiManageableEntityAttribute has no pre constraints
            List result = handleGetValueCoherencySources();
            List shieldedResult = this.shieldedElements(result);
            try
            {
                getValueCoherencySources3r = (List<GuiManageableEntityAttribute>)shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiManageableEntityAttributeLogic.LOGGER.warn("incorrect metafacade cast for GuiManageableEntityAttributeLogic.getValueCoherencySources List<GuiManageableEntityAttribute> " + result + ": " + shieldedResult);
            }
            // guiManageableEntityAttribute has no post constraints
            this.getValueCoherencySources3r = getValueCoherencySources3r;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.getValueCoherencySources3rSet = true;
            }
        }
        return getValueCoherencySources3r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetValueCoherencySources();

    /**
     * @return true
     * @see ManageableEntityAttribute
     */
    public boolean isManageableEntityAttributeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.EntityAttribute
     */
    public boolean isEntityAttributeMetaType()
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

    // ----------- delegates to ManageableEntityAttribute ------------
    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class attribute
     * to the class itself and then up the class hierarchy.
     * @see org.andromda.metafacades.uml.AttributeFacade#findTaggedValue(String name, boolean follow)
     */
    public Object findTaggedValue(String name, boolean follow)
    {
        return this.getSuperManageableEntityAttribute().findTaggedValue(name, follow);
    }

    /**
     * The default value of the attribute.  This is the value given if no value is defined.
     * @see org.andromda.metafacades.uml.AttributeFacade#getDefaultValue()
     */
    public String getDefaultValue()
    {
        return this.getSuperManageableEntityAttribute().getDefaultValue();
    }

    /**
     * If the attribute is an enumeration literal this represents the owning enumeration. Can be
     * empty.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumeration()
     */
    public EnumerationFacade getEnumeration()
    {
        return this.getSuperManageableEntityAttribute().getEnumeration();
    }

    /**
     * Returns the enumeration literal parameters defined by tagged value as a comma separated list.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumerationLiteralParameters()
     */
    public String getEnumerationLiteralParameters()
    {
        return this.getSuperManageableEntityAttribute().getEnumerationLiteralParameters();
    }

    /**
     * The value for this attribute if it is an enumeration literal, null otherwise. The default
     * value is returned as a String if it has been specified, if it's not specified this
     * attribute's name is assumed.
     * @see org.andromda.metafacades.uml.AttributeFacade#getEnumerationValue()
     */
    public String getEnumerationValue()
    {
        return this.getSuperManageableEntityAttribute().getEnumerationValue();
    }

    /**
     * The name of the accessor operation that would retrieve this attribute's value.
     * @see org.andromda.metafacades.uml.AttributeFacade#getGetterName()
     */
    public String getGetterName()
    {
        return this.getSuperManageableEntityAttribute().getGetterName();
    }

    /**
     * The name of the type that is returned on the accessor and mutator operations,  determined in
     * part by the multiplicity.
     * @see org.andromda.metafacades.uml.AttributeFacade#getGetterSetterTypeName()
     */
    public String getGetterSetterTypeName()
    {
        return this.getSuperManageableEntityAttribute().getGetterSetterTypeName();
    }

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.AttributeFacade#getLower()
     */
    public int getLower()
    {
        return this.getSuperManageableEntityAttribute().getLower();
    }

    /**
     * Gets the classifier who is the owner of the attributes.
     * @see org.andromda.metafacades.uml.AttributeFacade#getOwner()
     */
    public ClassifierFacade getOwner()
    {
        return this.getSuperManageableEntityAttribute().getOwner();
    }

    /**
     * The name of the mutator operation that would retrieve this attribute's value.
     * @see org.andromda.metafacades.uml.AttributeFacade#getSetterName()
     */
    public String getSetterName()
    {
        return this.getSuperManageableEntityAttribute().getSetterName();
    }

    /**
     * The classifier owning this attribute.
     * @see org.andromda.metafacades.uml.AttributeFacade#getType()
     */
    public ClassifierFacade getType()
    {
        return this.getSuperManageableEntityAttribute().getType();
    }

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * -only applicable for UML2
     * @see org.andromda.metafacades.uml.AttributeFacade#getUpper()
     */
    public int getUpper()
    {
        return this.getSuperManageableEntityAttribute().getUpper();
    }

    /**
     * True if this attribute can only be set.
     * @see org.andromda.metafacades.uml.AttributeFacade#isAddOnly()
     */
    public boolean isAddOnly()
    {
        return this.getSuperManageableEntityAttribute().isAddOnly();
    }

    /**
     * True if this attribute can be modified.
     * @see org.andromda.metafacades.uml.AttributeFacade#isChangeable()
     */
    public boolean isChangeable()
    {
        return this.getSuperManageableEntityAttribute().isChangeable();
    }

    /**
     * Indicates if the default value is present.
     * @see org.andromda.metafacades.uml.AttributeFacade#isDefaultValuePresent()
     */
    public boolean isDefaultValuePresent()
    {
        return this.getSuperManageableEntityAttribute().isDefaultValuePresent();
    }

    /**
     * If the attribute is derived (its value is computed). UML2 only. UML14 always returns false.
     * Default=false.
     * @see org.andromda.metafacades.uml.AttributeFacade#isDerived()
     */
    public boolean isDerived()
    {
        return this.getSuperManageableEntityAttribute().isDerived();
    }

    /**
     * True if this attribute is owned by an enumeration.
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationLiteral()
     */
    public boolean isEnumerationLiteral()
    {
        return this.getSuperManageableEntityAttribute().isEnumerationLiteral();
    }

    /**
     * Returns true if enumeration literal parameters exist (defined by tagged value) for the
     * literal.
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationLiteralParametersExist()
     */
    public boolean isEnumerationLiteralParametersExist()
    {
        return this.getSuperManageableEntityAttribute().isEnumerationLiteralParametersExist();
    }

    /**
     * True if this attribute is owned by an enumeration but is defined as a member variable (NOT a
     * literal).
     * @see org.andromda.metafacades.uml.AttributeFacade#isEnumerationMember()
     */
    public boolean isEnumerationMember()
    {
        return this.getSuperManageableEntityAttribute().isEnumerationMember();
    }

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant.
     * @see org.andromda.metafacades.uml.AttributeFacade#isLeaf()
     */
    public boolean isLeaf()
    {
        return this.getSuperManageableEntityAttribute().isLeaf();
    }

    /**
     * Whether or not this attribute has a multiplicity greater than 1.
     * @see org.andromda.metafacades.uml.AttributeFacade#isMany()
     */
    public boolean isMany()
    {
        return this.getSuperManageableEntityAttribute().isMany();
    }

    /**
     * Indicates whether or not the attributes are ordered (if multiplicity is greater than 1).
     * @see org.andromda.metafacades.uml.AttributeFacade#isOrdered()
     */
    public boolean isOrdered()
    {
        return this.getSuperManageableEntityAttribute().isOrdered();
    }

    /**
     * Whether or not this attribute can be modified.
     * @see org.andromda.metafacades.uml.AttributeFacade#isReadOnly()
     */
    public boolean isReadOnly()
    {
        return this.getSuperManageableEntityAttribute().isReadOnly();
    }

    /**
     * Whether or not the multiplicity of this attribute is 1.
     * @see org.andromda.metafacades.uml.AttributeFacade#isRequired()
     */
    public boolean isRequired()
    {
        return this.getSuperManageableEntityAttribute().isRequired();
    }

    /**
     * Indicates if this attribute is 'static', meaning it has a classifier scope.
     * @see org.andromda.metafacades.uml.AttributeFacade#isStatic()
     */
    public boolean isStatic()
    {
        return this.getSuperManageableEntityAttribute().isStatic();
    }

    /**
     * If the attribute is unique within the Collection type. UML2 only. UML14 always returns false.
     * Unique+Ordered determines the implementation Collection type. Default=false.
     * @see org.andromda.metafacades.uml.AttributeFacade#isUnique()
     */
    public boolean isUnique()
    {
        return this.getSuperManageableEntityAttribute().isUnique();
    }

    /**
     * The name of the index to create on a column that persists the entity attribute.
     * @see org.andromda.metafacades.uml.EntityAttribute#getColumnIndex()
     */
    public String getColumnIndex()
    {
        return this.getSuperManageableEntityAttribute().getColumnIndex();
    }

    /**
     * The length of the column that persists this entity attribute.
     * @see org.andromda.metafacades.uml.EntityAttribute#getColumnLength()
     */
    public String getColumnLength()
    {
        return this.getSuperManageableEntityAttribute().getColumnLength();
    }

    /**
     * The name of the table column to which this entity is mapped.
     * @see org.andromda.metafacades.uml.EntityAttribute#getColumnName()
     */
    public String getColumnName()
    {
        return this.getSuperManageableEntityAttribute().getColumnName();
    }

    /**
     * The PIM to language specific mappings for JDBC.
     * @see org.andromda.metafacades.uml.EntityAttribute#getJdbcMappings()
     */
    public TypeMappings getJdbcMappings()
    {
        return this.getSuperManageableEntityAttribute().getJdbcMappings();
    }

    /**
     * The JDBC type for this entity attribute.
     * @see org.andromda.metafacades.uml.EntityAttribute#getJdbcType()
     */
    public String getJdbcType()
    {
        return this.getSuperManageableEntityAttribute().getJdbcType();
    }

    /**
     * The SQL mappings (i.e. the mappings which provide PIM to SQL mappings).
     * @see org.andromda.metafacades.uml.EntityAttribute#getSqlMappings()
     */
    public TypeMappings getSqlMappings()
    {
        return this.getSuperManageableEntityAttribute().getSqlMappings();
    }

    /**
     * The SQL type for this attribute.
     * @see org.andromda.metafacades.uml.EntityAttribute#getSqlType()
     */
    public String getSqlType()
    {
        return this.getSuperManageableEntityAttribute().getSqlType();
    }

    /**
     * The name of the unique-key that this unique attribute belongs
     * @see org.andromda.metafacades.uml.EntityAttribute#getUniqueGroup()
     */
    public String getUniqueGroup()
    {
        return this.getSuperManageableEntityAttribute().getUniqueGroup();
    }

    /**
     * True if this attribute is an identifier for its entity.
     * @see org.andromda.metafacades.uml.EntityAttribute#isIdentifier()
     */
    public boolean isIdentifier()
    {
        return this.getSuperManageableEntityAttribute().isIdentifier();
    }

    /**
     * Indicates this attribute should be ignored by the persistence layer.
     * @see org.andromda.metafacades.uml.EntityAttribute#isTransient()
     */
    public boolean isTransient()
    {
        return this.getSuperManageableEntityAttribute().isTransient();
    }

    /**
     * Whether or not this attribute should be displayed.
     * @see ManageableEntityAttribute#isDisplay()
     */
    public boolean isDisplay()
    {
        return this.getSuperManageableEntityAttribute().isDisplay();
    }

    /**
     * Whether or not this attribute can be read in a call isolated from the rest (for example when
     * downloading binary fields).
     * @see ManageableEntityAttribute#isManageableGetterAvailable()
     */
    public boolean isManageableGetterAvailable()
    {
        return this.getSuperManageableEntityAttribute().isManageableGetterAvailable();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperManageableEntityAttribute().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperManageableEntityAttribute().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperManageableEntityAttribute().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperManageableEntityAttribute().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperManageableEntityAttribute().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperManageableEntityAttribute().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperManageableEntityAttribute().getDocumentation(indent);
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
        return this.getSuperManageableEntityAttribute().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperManageableEntityAttribute().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperManageableEntityAttribute().getFullyQualifiedName();
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
        return this.getSuperManageableEntityAttribute().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperManageableEntityAttribute().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperManageableEntityAttribute().getId();
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
        return this.getSuperManageableEntityAttribute().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperManageableEntityAttribute().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperManageableEntityAttribute().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperManageableEntityAttribute().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperManageableEntityAttribute().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperManageableEntityAttribute().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperManageableEntityAttribute().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperManageableEntityAttribute().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperManageableEntityAttribute().getPackagePath();
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
        return this.getSuperManageableEntityAttribute().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperManageableEntityAttribute().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperManageableEntityAttribute().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperManageableEntityAttribute().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperManageableEntityAttribute().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperManageableEntityAttribute().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperManageableEntityAttribute().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperManageableEntityAttribute().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperManageableEntityAttribute().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperManageableEntityAttribute().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperManageableEntityAttribute().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperManageableEntityAttribute().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperManageableEntityAttribute().hasKeyword(keywordName);
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
        return this.getSuperManageableEntityAttribute().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperManageableEntityAttribute().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperManageableEntityAttribute().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperManageableEntityAttribute().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperManageableEntityAttribute().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperManageableEntityAttribute().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperManageableEntityAttribute().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperManageableEntityAttribute().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperManageableEntityAttribute().translateConstraints(kind, translation);
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperManageableEntityAttribute().initialize();
    }

    /**
     * @return Object getSuperManageableEntityAttribute().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperManageableEntityAttribute().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperManageableEntityAttribute().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperManageableEntityAttribute().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::required fields may not be hidden</p>
     * <p><b>Error:</b> Required fields may not be hidden, unless they are auto-generated identifiers.</p>
     * <p><b>OCL:</b> context GuiManageableEntityAttribute inv: 
(required and not (identifier and owner.dynamicIdentifiersPresent)) implies not hidden</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::widget type cannot be arbitrary</p>
     * <p><b>Error:</b> Only text, textarea and hidden widgets are supported, please select another one or let the cartridge decide by not specifying anything.</p>
     * <p><b>OCL:</b> context GuiManageableEntityAttribute inv: widgetType->notEmpty() implies 
(widgetType = 'text' or widgetType = 'textarea' or widgetType = 'hidden' or widgetType='select')</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntityAssociationEnd::SAFE NAME - TO BE REMOVED LATER</p>
     * <p><b>Error:</b> The names you give to fields cannot start with a lowercase character directly followed by a character in uppercase. This is due to a bug in the Jakarta commons library which is used by Gui. The behavior of that library is inconsistent with the reflection API provided by the JDK. Please rename this field or you'll get exceptions when running your web application.</p>
     * <p><b>OCL:</b> context GuiAttribute inv: safeNamePresent</p>
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::An attribute can be a source or a target coherency if it is a choice</p>
     * <p><b>Error:</b> An attribute can be a source or a target coherency if it has a 'select' widget type.</p>
     * <p><b>OCL:</b> context GuiManageableEntityAttribute
inv: (coherencySource or coherencyTarget) implies widgetType = 'select'</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperManageableEntityAttribute().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf((Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"required"))).booleanValue()&&!(Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"identifier"))).booleanValue()&&Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"owner.dynamicIdentifiersPresent"))).booleanValue())))).booleanValue()?Boolean.valueOf(String.valueOf(!Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"hidden"))).booleanValue())).booleanValue():true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::required fields may not be hidden",
                        "Required fields may not be hidden, unless they are auto-generated identifiers."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::required fields may not be hidden' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"widgetType")))).booleanValue()?(OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"widgetType"),"text")||OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"widgetType"),"textarea")||OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"widgetType"),"hidden")||OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"widgetType"),"select")):true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::widget type cannot be arbitrary",
                        "Only text, textarea and hidden widgets are supported, please select another one or let the cartridge decide by not specifying anything."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::widget type cannot be arbitrary' ON "
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
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf((Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"coherencySource"))).booleanValue()||Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"coherencyTarget"))).booleanValue()))).booleanValue()?OCLExpressions.equal(OCLIntrospector.invoke(contextElement,"widgetType"),"select"):true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::An attribute can be a source or a target coherency if it is a choice",
                        "An attribute can be a source or a target coherency if it has a 'select' widget type."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiManageableEntityAttribute::An attribute can be a source or a target coherency if it is a choice' ON "
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