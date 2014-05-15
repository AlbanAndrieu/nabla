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
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndControllerOperation;
import org.andromda.metafacades.uml.FrontEndEvent;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.ParameterFacade;
import org.andromda.metafacades.uml.StateFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TransitionFacade;
import org.andromda.metafacades.uml.TypeMappings;
import org.andromda.translation.ocl.validation.OCLCollections;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.log4j.Logger;

/**
 * A Gui trigger is represented by clicking a hyperlink or posting an action form.
 * MetafacadeLogic for GuiTrigger
 *
 * @see GuiTrigger
 */
public abstract class GuiTriggerLogic
    extends MetafacadeBase
    implements GuiTrigger
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
    protected GuiTriggerLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superFrontEndEvent =
           (FrontEndEvent)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.FrontEndEvent",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiTriggerLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiTrigger if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiTrigger";
        }
        return context;
    }

    private FrontEndEvent superFrontEndEvent;
    private boolean superFrontEndEventInitialized = false;

    /**
     * Gets the FrontEndEvent parent instance.
     * @return this.superFrontEndEvent FrontEndEvent
     */
    private FrontEndEvent getSuperFrontEndEvent()
    {
        if (!this.superFrontEndEventInitialized)
        {
            ((MetafacadeBase)this.superFrontEndEvent).setMetafacadeContext(this.getMetafacadeContext());
            this.superFrontEndEventInitialized = true;
        }
        return this.superFrontEndEvent;
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
            if (this.superFrontEndEventInitialized)
            {
                ((MetafacadeBase)this.superFrontEndEvent).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see GuiTrigger
     */
    public boolean isGuiTriggerMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getNotAllowedTitleKey()
    * @return String
    */
    protected abstract String handleGetNotAllowedTitleKey();

    private transient String notAllowedTitleKey1a;
    private transient boolean notAllowedTitleKey1aSet = false;

    /**
     * The message key to use as a tooltip when the user is not allowed to use this trigger.
     * @return (String)handleGetNotAllowedTitleKey()
     */
    public final String getNotAllowedTitleKey()
    {
        String notAllowedTitleKey1a = this.notAllowedTitleKey1a;
        if (!this.notAllowedTitleKey1aSet)
        {
            // notAllowedTitleKey has no pre constraints
            notAllowedTitleKey1a = handleGetNotAllowedTitleKey();
            // notAllowedTitleKey has no post constraints
            this.notAllowedTitleKey1a = notAllowedTitleKey1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.notAllowedTitleKey1aSet = true;
            }
        }
        return notAllowedTitleKey1a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getTitleKey()
    * @return String
    */
    protected abstract String handleGetTitleKey();

    private transient String titleKey2a;
    private transient boolean titleKey2aSet = false;

    /**
     * The message title key to use as a tooltip for this trigger.
     * @return (String)handleGetTitleKey()
     */
    public final String getTitleKey()
    {
        String titleKey2a = this.titleKey2a;
        if (!this.titleKey2aSet)
        {
            // titleKey has no pre constraints
            titleKey2a = handleGetTitleKey();
            // titleKey has no post constraints
            this.titleKey2a = titleKey2a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.titleKey2aSet = true;
            }
        }
        return titleKey2a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getResetTitleKey()
    * @return String
    */
    protected abstract String handleGetResetTitleKey();

    private transient String resetTitleKey3a;
    private transient boolean resetTitleKey3aSet = false;

    /**
     * The message reset title key to use as a tooltip for this trigger's reset feature.
     * @return (String)handleGetResetTitleKey()
     */
    public final String getResetTitleKey()
    {
        String resetTitleKey3a = this.resetTitleKey3a;
        if (!this.resetTitleKey3aSet)
        {
            // resetTitleKey has no pre constraints
            resetTitleKey3a = handleGetResetTitleKey();
            // resetTitleKey has no post constraints
            this.resetTitleKey3a = resetTitleKey3a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetTitleKey3aSet = true;
            }
        }
        return resetTitleKey3a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getResetNotAllowedTitleKey()
    * @return String
    */
    protected abstract String handleGetResetNotAllowedTitleKey();

    private transient String resetNotAllowedTitleKey4a;
    private transient boolean resetNotAllowedTitleKey4aSet = false;

    /**
     * Returns the message key to use as a tooltip when the user is not allowed to use reset the
     * form behind this trigger.
     * @return (String)handleGetResetNotAllowedTitleKey()
     */
    public final String getResetNotAllowedTitleKey()
    {
        String resetNotAllowedTitleKey4a = this.resetNotAllowedTitleKey4a;
        if (!this.resetNotAllowedTitleKey4aSet)
        {
            // resetNotAllowedTitleKey has no pre constraints
            resetNotAllowedTitleKey4a = handleGetResetNotAllowedTitleKey();
            // resetNotAllowedTitleKey has no post constraints
            this.resetNotAllowedTitleKey4a = resetNotAllowedTitleKey4a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetNotAllowedTitleKey4aSet = true;
            }
        }
        return resetNotAllowedTitleKey4a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getTriggerKey()
    * @return String
    */
    protected abstract String handleGetTriggerKey();

    private transient String triggerKey5a;
    private transient boolean triggerKey5aSet = false;

    /**
     * The message reset key for this trigger.
     * @return (String)handleGetTriggerKey()
     */
    public final String getTriggerKey()
    {
        String triggerKey5a = this.triggerKey5a;
        if (!this.triggerKey5aSet)
        {
            // triggerKey has no pre constraints
            triggerKey5a = handleGetTriggerKey();
            // triggerKey has no post constraints
            this.triggerKey5a = triggerKey5a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.triggerKey5aSet = true;
            }
        }
        return triggerKey5a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getTriggerValue()
    * @return String
    */
    protected abstract String handleGetTriggerValue();

    private transient String triggerValue6a;
    private transient boolean triggerValue6aSet = false;

    /**
     * The resource message value  for this trigger, this would be the button label or hyperlink
     * name.
     * @return (String)handleGetTriggerValue()
     */
    public final String getTriggerValue()
    {
        String triggerValue6a = this.triggerValue6a;
        if (!this.triggerValue6aSet)
        {
            // triggerValue has no pre constraints
            triggerValue6a = handleGetTriggerValue();
            // triggerValue has no post constraints
            this.triggerValue6a = triggerValue6a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.triggerValue6aSet = true;
            }
        }
        return triggerValue6a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getTitleValue()
    * @return String
    */
    protected abstract String handleGetTitleValue();

    private transient String titleValue7a;
    private transient boolean titleValue7aSet = false;

    /**
     * The default resource message value  for this trigger's tooltip.
     * @return (String)handleGetTitleValue()
     */
    public final String getTitleValue()
    {
        String titleValue7a = this.titleValue7a;
        if (!this.titleValue7aSet)
        {
            // titleValue has no pre constraints
            titleValue7a = handleGetTitleValue();
            // titleValue has no post constraints
            this.titleValue7a = titleValue7a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.titleValue7aSet = true;
            }
        }
        return titleValue7a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getResetTitleValue()
    * @return String
    */
    protected abstract String handleGetResetTitleValue();

    private transient String resetTitleValue8a;
    private transient boolean resetTitleValue8aSet = false;

    /**
     * The tooltip value for this trigger's reset feature.
     * @return (String)handleGetResetTitleValue()
     */
    public final String getResetTitleValue()
    {
        String resetTitleValue8a = this.resetTitleValue8a;
        if (!this.resetTitleValue8aSet)
        {
            // resetTitleValue has no pre constraints
            resetTitleValue8a = handleGetResetTitleValue();
            // resetTitleValue has no post constraints
            this.resetTitleValue8a = resetTitleValue8a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetTitleValue8aSet = true;
            }
        }
        return resetTitleValue8a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getResetNotAllowedTitleValue()
    * @return String
    */
    protected abstract String handleGetResetNotAllowedTitleValue();

    private transient String resetNotAllowedTitleValue9a;
    private transient boolean resetNotAllowedTitleValue9aSet = false;

    /**
     * The message value to use as a tooltip when the user is not allowed to use reset the form
     * behind this trigger.
     * @return (String)handleGetResetNotAllowedTitleValue()
     */
    public final String getResetNotAllowedTitleValue()
    {
        String resetNotAllowedTitleValue9a = this.resetNotAllowedTitleValue9a;
        if (!this.resetNotAllowedTitleValue9aSet)
        {
            // resetNotAllowedTitleValue has no pre constraints
            resetNotAllowedTitleValue9a = handleGetResetNotAllowedTitleValue();
            // resetNotAllowedTitleValue has no post constraints
            this.resetNotAllowedTitleValue9a = resetNotAllowedTitleValue9a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetNotAllowedTitleValue9aSet = true;
            }
        }
        return resetNotAllowedTitleValue9a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getNotAllowedTitleValue()
    * @return String
    */
    protected abstract String handleGetNotAllowedTitleValue();

    private transient String notAllowedTitleValue10a;
    private transient boolean notAllowedTitleValue10aSet = false;

    /**
     * The message value to use as a tooltip when the user is not allowed to use this trigger.
     * @return (String)handleGetNotAllowedTitleValue()
     */
    public final String getNotAllowedTitleValue()
    {
        String notAllowedTitleValue10a = this.notAllowedTitleValue10a;
        if (!this.notAllowedTitleValue10aSet)
        {
            // notAllowedTitleValue has no pre constraints
            notAllowedTitleValue10a = handleGetNotAllowedTitleValue();
            // notAllowedTitleValue has no post constraints
            this.notAllowedTitleValue10a = notAllowedTitleValue10a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.notAllowedTitleValue10aSet = true;
            }
        }
        return notAllowedTitleValue10a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#isActionTrigger()
    * @return boolean
    */
    protected abstract boolean handleIsActionTrigger();

    private transient boolean actionTrigger11a;
    private transient boolean actionTrigger11aSet = false;

    /**
     * True if this trigger is modeled on an action transition. That means, the transition is coming
     * out of an action state with the FrontEndView stereotype. False otherwise.
     * @return (boolean)handleIsActionTrigger()
     */
    public final boolean isActionTrigger()
    {
        boolean actionTrigger11a = this.actionTrigger11a;
        if (!this.actionTrigger11aSet)
        {
            // actionTrigger has no pre constraints
            actionTrigger11a = handleIsActionTrigger();
            // actionTrigger has no post constraints
            this.actionTrigger11a = actionTrigger11a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionTrigger11aSet = true;
            }
        }
        return actionTrigger11a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getResetMessageKey()
    * @return String
    */
    protected abstract String handleGetResetMessageKey();

    private transient String resetMessageKey12a;
    private transient boolean resetMessageKey12aSet = false;

    /**
     * The message key to use for reset button labels.
     * @return (String)handleGetResetMessageKey()
     */
    public final String getResetMessageKey()
    {
        String resetMessageKey12a = this.resetMessageKey12a;
        if (!this.resetMessageKey12aSet)
        {
            // resetMessageKey has no pre constraints
            resetMessageKey12a = handleGetResetMessageKey();
            // resetMessageKey has no post constraints
            this.resetMessageKey12a = resetMessageKey12a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetMessageKey12aSet = true;
            }
        }
        return resetMessageKey12a;
    }

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiTrigger#getResetMessageValue()
    * @return String
    */
    protected abstract String handleGetResetMessageValue();

    private transient String resetMessageValue13a;
    private transient boolean resetMessageValue13aSet = false;

    /**
     * The message value to use for reset button labels.
     * @return (String)handleGetResetMessageValue()
     */
    public final String getResetMessageValue()
    {
        String resetMessageValue13a = this.resetMessageValue13a;
        if (!this.resetMessageValue13aSet)
        {
            // resetMessageValue has no pre constraints
            resetMessageValue13a = handleGetResetMessageValue();
            // resetMessageValue has no post constraints
            this.resetMessageValue13a = resetMessageValue13a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.resetMessageValue13aSet = true;
            }
        }
        return resetMessageValue13a;
    }

    // ------------- associations ------------------

    private transient GuiAction getGuiAction1r;
    private transient boolean getGuiAction1rSet = false;

    /**
     * Returns the trigger that calls this action. Typically this is a button or an hyperlink.
     * @return (GuiAction)handleGetGuiAction()
     */
    public final GuiAction getGuiAction()
    {
        GuiAction getGuiAction1r = this.getGuiAction1r;
        if (!this.getGuiAction1rSet)
        {
            // actionTriggerToDelete has no pre constraints
            Object result = handleGetGuiAction();
            MetafacadeBase shieldedResult = this.shieldedElement(result);
            try
            {
                getGuiAction1r = (GuiAction) shieldedResult;
            }
            catch (ClassCastException ex)
            {
                // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
                GuiTriggerLogic.LOGGER.warn("incorrect metafacade cast for GuiTriggerLogic.getGuiAction GuiAction " + result + ": " + shieldedResult);
            }
            // actionTriggerToDelete has no post constraints
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

    /**
     * @return true
     * @see FrontEndEvent
     */
    public boolean isFrontEndEventMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.EventFacade
     */
    public boolean isEventFacadeMetaType()
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

    // ----------- delegates to FrontEndEvent ------------
    /**
     * The parameters to this event.
     * @see org.andromda.metafacades.uml.EventFacade#getParameters()
     */
    public Collection<ParameterFacade> getParameters()
    {
        return this.getSuperFrontEndEvent().getParameters();
    }

    /**
     * If this event is located on an action state, this will represent that state.
     * @see org.andromda.metafacades.uml.EventFacade#getState()
     */
    public StateFacade getState()
    {
        return this.getSuperFrontEndEvent().getState();
    }

    /**
     * If this event is located on a transition, this represents that transition.
     * @see org.andromda.metafacades.uml.EventFacade#getTransition()
     */
    public TransitionFacade getTransition()
    {
        return this.getSuperFrontEndEvent().getTransition();
    }

    /**
     * The action which triggers the "front-end" event.
     * @see FrontEndEvent#getAction()
     */
    public FrontEndAction getAction()
    {
        return this.getSuperFrontEndEvent().getAction();
    }

    /**
     * The call to the controller for this front-end event (if any).
     * @see FrontEndEvent#getControllerCall()
     */
    public FrontEndControllerOperation getControllerCall()
    {
        return this.getSuperFrontEndEvent().getControllerCall();
    }

    /**
     * Gets all controller operation calls for the front-end event.
     * @see FrontEndEvent#getControllerCalls()
     */
    public List<FrontEndControllerOperation> getControllerCalls()
    {
        return this.getSuperFrontEndEvent().getControllerCalls();
    }

    /**
     * Indicates whether or not this front end event is contained within a FrontEndUseCase.
     * @see FrontEndEvent#isContainedInFrontEndUseCase()
     */
    public boolean isContainedInFrontEndUseCase()
    {
        return this.getSuperFrontEndEvent().isContainedInFrontEndUseCase();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperFrontEndEvent().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperFrontEndEvent().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperFrontEndEvent().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperFrontEndEvent().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperFrontEndEvent().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperFrontEndEvent().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperFrontEndEvent().getDocumentation(indent);
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
        return this.getSuperFrontEndEvent().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperFrontEndEvent().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperFrontEndEvent().getFullyQualifiedName();
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
        return this.getSuperFrontEndEvent().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperFrontEndEvent().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperFrontEndEvent().getId();
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
        return this.getSuperFrontEndEvent().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperFrontEndEvent().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperFrontEndEvent().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperFrontEndEvent().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperFrontEndEvent().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperFrontEndEvent().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperFrontEndEvent().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperFrontEndEvent().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperFrontEndEvent().getPackagePath();
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
        return this.getSuperFrontEndEvent().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperFrontEndEvent().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperFrontEndEvent().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperFrontEndEvent().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperFrontEndEvent().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperFrontEndEvent().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperFrontEndEvent().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperFrontEndEvent().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperFrontEndEvent().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperFrontEndEvent().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperFrontEndEvent().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndEvent().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperFrontEndEvent().hasKeyword(keywordName);
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
        return this.getSuperFrontEndEvent().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperFrontEndEvent().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperFrontEndEvent().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperFrontEndEvent().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperFrontEndEvent().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperFrontEndEvent().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperFrontEndEvent().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperFrontEndEvent().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperFrontEndEvent().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperFrontEndEvent().translateConstraints(kind, translation);
    }

    /**
     * @see MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperFrontEndEvent().initialize();
    }

    /**
     * @return Object getSuperFrontEndEvent().getValidationOwner()
     * @see MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperFrontEndEvent().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperFrontEndEvent().getValidationName()
     * @see MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperFrontEndEvent().getValidationName();
        return name;
    }

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiTrigger::each action trigger must have a name</p>
     * <p><b>Error:</b> Every trigger modeled on a transition going out of a FrontEndView action state must have a name. These triggers are known as action-triggers.</p>
     * <p><b>OCL:</b> context GuiTrigger inv: transition.exitingPage implies name->notEmpty()</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperFrontEndEvent().validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure((Boolean.valueOf(String.valueOf(OCLIntrospector.invoke(contextElement,"transition.exitingPage"))).booleanValue()?OCLCollections.notEmpty(OCLIntrospector.invoke(contextElement,"name")):true));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiTrigger::each action trigger must have a name",
                        "Every trigger modeled on a transition going out of a FrontEndView action state must have a name. These triggers are known as action-triggers."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiTrigger::each action trigger must have a name' ON "
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