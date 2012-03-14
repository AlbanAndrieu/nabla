// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.seam.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.cartridges.jsf.metafacades.JSFAction;
import org.andromda.cartridges.jsf.metafacades.JSFForward;
import org.andromda.cartridges.jsf.metafacades.JSFParameter;
import org.andromda.cartridges.jsf.metafacades.JSFView;
import org.andromda.core.common.Introspector;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.MetafacadeFactory;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.ActionFacade;
import org.andromda.metafacades.uml.ConstraintFacade;
import org.andromda.metafacades.uml.DependencyFacade;
import org.andromda.metafacades.uml.EventFacade;
import org.andromda.metafacades.uml.FrontEndAction;
import org.andromda.metafacades.uml.FrontEndExceptionHandler;
import org.andromda.metafacades.uml.FrontEndForward;
import org.andromda.metafacades.uml.FrontEndParameter;
import org.andromda.metafacades.uml.FrontEndUseCase;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
import org.andromda.metafacades.uml.OperationFacade;
import org.andromda.metafacades.uml.PackageFacade;
import org.andromda.metafacades.uml.PartitionFacade;
import org.andromda.metafacades.uml.StateFacade;
import org.andromda.metafacades.uml.StateMachineFacade;
import org.andromda.metafacades.uml.StereotypeFacade;
import org.andromda.metafacades.uml.TaggedValueFacade;
import org.andromda.metafacades.uml.TemplateParameterFacade;
import org.andromda.metafacades.uml.TransitionFacade;
import org.andromda.metafacades.uml.TypeMappings;

/**
 * 
 * MetafacadeLogic for SeamView
 *
 * @see SeamView
 */
public abstract class SeamViewLogic
    extends MetafacadeBase
    implements SeamView
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
    protected SeamViewLogic(Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superJSFView =
           (JSFView)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.cartridges.jsf.metafacades.JSFView",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to SeamView if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.seam.metafacades.SeamView";
        }
        return context;
    }

    private JSFView superJSFView;
    private boolean superJSFViewInitialized = false;

    /**
     * Gets the JSFView parent instance.
     * @return this.superJSFView JSFView
     */
    private JSFView getSuperJSFView()
    {
        if (!this.superJSFViewInitialized)
        {
            ((MetafacadeBase)this.superJSFView).setMetafacadeContext(this.getMetafacadeContext());
            this.superJSFViewInitialized = true;
        }
        return this.superJSFView;
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
            if (this.superJSFViewInitialized)
            {
                ((MetafacadeBase)this.superJSFView).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see SeamView
     */
    public boolean isSeamViewMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see JSFView
     */
    public boolean isJSFViewMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.FrontEndView
     */
    public boolean isFrontEndViewMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.FrontEndActionState
     */
    public boolean isFrontEndActionStateMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.ActionStateFacade
     */
    public boolean isActionStateFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see StateFacade
     */
    public boolean isStateFacadeMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.StateVertexFacade
     */
    public boolean isStateVertexFacadeMetaType()
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

    // ----------- delegates to JSFView ------------
    /**
     * All those forwards that are actions.
     * @see JSFView#getActionForwards()
     */
    public List<JSFAction> getActionForwards()
    {
        return this.getSuperJSFView().getActionForwards();
    }

    /**
     * All variables that have backing value.
     * @see JSFView#getBackingValueVariables()
     */
    public List<JSFParameter> getBackingValueVariables()
    {
        return this.getSuperJSFView().getBackingValueVariables();
    }

    /**
     * A resource message key suited for the page's documentation.
     * @see JSFView#getDocumentationKey()
     */
    public String getDocumentationKey()
    {
        return this.getSuperJSFView().getDocumentationKey();
    }

    /**
     * A resource message value suited for the view's documentation.
     * @see JSFView#getDocumentationValue()
     */
    public String getDocumentationValue()
    {
        return this.getSuperJSFView().getDocumentationValue();
    }

    /**
     * All actions that have forms associated with them.
     * @see JSFView#getFormActions()
     */
    public List<JSFAction> getFormActions()
    {
        return this.getSuperJSFView().getFormActions();
    }

    /**
     * The key that stores the form in which information is passed from one action to another.
     * @see JSFView#getFormKey()
     */
    public String getFormKey()
    {
        return this.getSuperJSFView().getFormKey();
    }

    /**
     * Gets the forwards which can be targgeted from this view.
     * @see JSFView#getForwards()
     */
    public List<JSFForward> getForwards()
    {
        return this.getSuperJSFView().getForwards();
    }

    /**
     * The name that corresponds to the from-outcome in an navigational rule.
     * @see JSFView#getFromOutcome()
     */
    public String getFromOutcome()
    {
        return this.getSuperJSFView().getFromOutcome();
    }

    /**
     * The fully qualified name of this view's form populator.
     * @see JSFView#getFullyQualifiedPopulator()
     */
    public String getFullyQualifiedPopulator()
    {
        return this.getSuperJSFView().getFullyQualifiedPopulator();
    }

    /**
     * The default resource message key for this view.
     * @see JSFView#getMessageKey()
     */
    public String getMessageKey()
    {
        return this.getSuperJSFView().getMessageKey();
    }

    /**
     * A displayable version of this view's name.
     * @see JSFView#getMessageValue()
     */
    public String getMessageValue()
    {
        return this.getSuperJSFView().getMessageValue();
    }

    /**
     * The full path of the view resources (i.e. the JSP page).
     * @see JSFView#getPath()
     */
    public String getPath()
    {
        return this.getSuperJSFView().getPath();
    }

    /**
     * The name of the form populator for this view.
     * @see JSFView#getPopulator()
     */
    public String getPopulator()
    {
        return this.getSuperJSFView().getPopulator();
    }

    /**
     * The path to the form populator.
     * @see JSFView#getPopulatorPath()
     */
    public String getPopulatorPath()
    {
        return this.getSuperJSFView().getPopulatorPath();
    }

    /**
     * A resource message key suited for the view's title.
     * @see JSFView#getTitleKey()
     */
    public String getTitleKey()
    {
        return this.getSuperJSFView().getTitleKey();
    }

    /**
     * A default resource message value suited for the page's title.
     * @see JSFView#getTitleValue()
     */
    public String getTitleValue()
    {
        return this.getSuperJSFView().getTitleValue();
    }

    /**
     * Indicates whether or not this view has the same name as the use case in which it is
     * contained.
     * @see JSFView#isHasNameOfUseCase()
     */
    public boolean isHasNameOfUseCase()
    {
        return this.getSuperJSFView().isHasNameOfUseCase();
    }

    /**
     * 
     * @see JSFView#isNeedsFileUpload()
     */
    public boolean isNeedsFileUpload()
    {
        return this.getSuperJSFView().isNeedsFileUpload();
    }

    /**
     * Indicates whether or not any non-table view variables are present in this view.
     * @see JSFView#isNonTableVariablesPresent()
     */
    public boolean isNonTableVariablesPresent()
    {
        return this.getSuperJSFView().isNonTableVariablesPresent();
    }

    /**
     * Indicates if a populator is required for this view.
     * @see JSFView#isPopulatorRequired()
     */
    public boolean isPopulatorRequired()
    {
        return this.getSuperJSFView().isPopulatorRequired();
    }

    /**
     * Indicates if this view represents a popup.
     * @see JSFView#isPopup()
     */
    public boolean isPopup()
    {
        return this.getSuperJSFView().isPopup();
    }

    /**
     * Indicates whether or not at least one parameter of an outgoing action in this view requires
     * validation.
     * @see JSFView#isValidationRequired()
     */
    public boolean isValidationRequired()
    {
        return this.getSuperJSFView().isValidationRequired();
    }

    /**
     * The entry action for this action state (if any).
     * @see org.andromda.metafacades.uml.ActionStateFacade#getEntry()
     */
    public ActionFacade getEntry()
    {
        return this.getSuperJSFView().getEntry();
    }

    /**
     * The method name representing this action state.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getActionMethodName()
     */
    public String getActionMethodName()
    {
        return this.getSuperJSFView().getActionMethodName();
    }

    /**
     * The actions that pass through this action state.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getContainerActions()
     */
    public List<FrontEndAction> getContainerActions()
    {
        return this.getSuperJSFView().getContainerActions();
    }

    /**
     * All calls deferred to the controller by this action state.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getControllerCalls()
     */
    public List<OperationFacade> getControllerCalls()
    {
        return this.getSuperJSFView().getControllerCalls();
    }

    /**
     * All exceptions modelled on this action state.
     * @see org.andromda.metafacades.uml.FrontEndActionState#getExceptions()
     */
    public List<FrontEndExceptionHandler> getExceptions()
    {
        return this.getSuperJSFView().getExceptions();
    }

    /**
     * The next transition, there can be only one transition going out of an action state, otherwise
     * decision points should be used (triggers are not supported at the server-side).
     * @see org.andromda.metafacades.uml.FrontEndActionState#getForward()
     */
    public FrontEndForward getForward()
    {
        return this.getSuperJSFView().getForward();
    }

    /**
     * True if this element is contained in a FrontEndUseCase.
     * @see org.andromda.metafacades.uml.FrontEndActionState#isContainedInFrontEndUseCase()
     */
    public boolean isContainedInFrontEndUseCase()
    {
        return this.getSuperJSFView().isContainedInFrontEndUseCase();
    }

    /**
     * Indicates whether or not this front end action state is server side. Pages, for example, are
     * also action states but they return control to the client.
     * @see org.andromda.metafacades.uml.FrontEndActionState#isServerSide()
     */
    public boolean isServerSide()
    {
        return this.getSuperJSFView().isServerSide();
    }

    /**
     * All actions that can be triggered on this view.
     * @see org.andromda.metafacades.uml.FrontEndView#getActions()
     */
    public List<FrontEndAction> getActions()
    {
        return this.getSuperJSFView().getActions();
    }

    /**
     * All parameters for each action going out of this view.
     * @see org.andromda.metafacades.uml.FrontEndView#getAllActionParameters()
     */
    public List<FrontEndParameter> getAllActionParameters()
    {
        return this.getSuperJSFView().getAllActionParameters();
    }

    /**
     * All fields from all forms on the given view.
     * @see org.andromda.metafacades.uml.FrontEndView#getAllFormFields()
     */
    public List<FrontEndParameter> getAllFormFields()
    {
        return this.getSuperJSFView().getAllFormFields();
    }

    /**
     * All tables belonging to the front end view.
     * @see org.andromda.metafacades.uml.FrontEndView#getTables()
     */
    public List<FrontEndParameter> getTables()
    {
        return this.getSuperJSFView().getTables();
    }

    /**
     * The use-case of which this view is a member.
     * @see org.andromda.metafacades.uml.FrontEndView#getUseCase()
     */
    public FrontEndUseCase getUseCase()
    {
        return this.getSuperJSFView().getUseCase();
    }

    /**
     * All those variables that will be present as variables in the target view. These are the
     * trigger parameters on the incoming transitions.
     * @see org.andromda.metafacades.uml.FrontEndView#getVariables()
     */
    public List<FrontEndParameter> getVariables()
    {
        return this.getSuperJSFView().getVariables();
    }

    /**
     * True if this element carries the FrontEndView stereotype.
     * @see org.andromda.metafacades.uml.FrontEndView#isFrontEndView()
     */
    public boolean isFrontEndView()
    {
        return this.getSuperJSFView().isFrontEndView();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperJSFView().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperJSFView().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection findTaggedValues(String tagName)
    {
        return this.getSuperJSFView().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperJSFView().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperJSFView().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection getConstraints(String kind)
    {
        return this.getSuperJSFView().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperJSFView().getDocumentation(indent);
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
        return this.getSuperJSFView().getDocumentation(indent, lineLength);
    }

    /**
     * 
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperJSFView().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperJSFView().getFullyQualifiedName();
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
        return this.getSuperJSFView().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperJSFView().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperJSFView().getId();
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
        return this.getSuperJSFView().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperJSFView().getLabel();
    }

    /**
     * The language mappings that have been set for this model elemnt.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperJSFView().getLanguageMappings();
    }

    /**
     * 
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperJSFView().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperJSFView().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperJSFView().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperJSFView().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperJSFView().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperJSFView().getPackagePath();
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
        return this.getSuperJSFView().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperJSFView().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperJSFView().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperJSFView().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperJSFView().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperJSFView().getStereotypes();
    }

    /**
     * 
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperJSFView().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperJSFView().getTargetDependencies();
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperJSFView().getTemplateParameter(parameterName);
    }

    /**
     * 
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperJSFView().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperJSFView().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperJSFView().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperJSFView().hasKeyword(keywordName);
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
        return this.getSuperJSFView().hasStereotype(stereotypeName);
    }

    /**
     * 
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperJSFView().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperJSFView().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperJSFView().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperJSFView().isReservedWord();
    }

    /**
     * 
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperJSFView().isTemplateParametersPresent();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperJSFView().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperJSFView().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperJSFView().translateConstraints(kind, translation);
    }

    /**
     * Events to which is being deferred in this action state.
     * @see StateFacade#getDeferrableEvents()
     */
    public Collection<EventFacade> getDeferrableEvents()
    {
        return this.getSuperJSFView().getDeferrableEvents();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.StateVertexFacade#getContainer()
     */
    public StateFacade getContainer()
    {
        return this.getSuperJSFView().getContainer();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.StateVertexFacade#getIncomings()
     */
    public Collection<TransitionFacade> getIncomings()
    {
        return this.getSuperJSFView().getIncomings();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.StateVertexFacade#getOutgoings()
     */
    public Collection<TransitionFacade> getOutgoings()
    {
        return this.getSuperJSFView().getOutgoings();
    }

    /**
     * The partition (if any) to which this vertex belongs.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getPartition()
     */
    public PartitionFacade getPartition()
    {
        return this.getSuperJSFView().getPartition();
    }

    /**
     * 
     * @see org.andromda.metafacades.uml.StateVertexFacade#getStateMachine()
     */
    public StateMachineFacade getStateMachine()
    {
        return this.getSuperJSFView().getStateMachine();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperJSFView().initialize();
    }

    /**
     * @return Object getSuperJSFView().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperJSFView().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperJSFView().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperJSFView().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperJSFView().validateInvariants(validationMessages);
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