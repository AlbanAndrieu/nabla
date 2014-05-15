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
import org.andromda.metafacades.uml.FrontEndPseudostate;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.andromda.metafacades.uml.ModelFacade;
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
 * Encapsulates a pseudostate and provides specific Gui services. This pseudostate can be a decision
 * point, junction or initial state.
 * MetafacadeLogic for GuiPseudostate
 *
 * @see GuiPseudostate
 */
public abstract class GuiPseudostateLogic
    extends MetafacadeBase
    implements GuiPseudostate
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
    protected GuiPseudostateLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.superFrontEndPseudostate =
           (FrontEndPseudostate)
            MetafacadeFactory.getInstance().createFacadeImpl(
                    "org.andromda.metafacades.uml.FrontEndPseudostate",
                    metaObjectIn,
                    getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiPseudostate if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiPseudostate";
        }
        return context;
    }

    private FrontEndPseudostate superFrontEndPseudostate;
    private boolean superFrontEndPseudostateInitialized = false;

    /**
     * Gets the FrontEndPseudostate parent instance.
     * @return this.superFrontEndPseudostate FrontEndPseudostate
     */
    private FrontEndPseudostate getSuperFrontEndPseudostate()
    {
        if (!this.superFrontEndPseudostateInitialized)
        {
            ((MetafacadeBase)this.superFrontEndPseudostate).setMetafacadeContext(this.getMetafacadeContext());
            this.superFrontEndPseudostateInitialized = true;
        }
        return this.superFrontEndPseudostate;
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
            if (this.superFrontEndPseudostateInitialized)
            {
                ((MetafacadeBase)this.superFrontEndPseudostate).resetMetafacadeContext(context);
            }
        }
    }

    /**
     * @return boolean true always
     * @see GuiPseudostate
     */
    public boolean isGuiPseudostateMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiPseudostate#getActionMethodName()
    * @return String
    */
    protected abstract String handleGetActionMethodName();

    private transient String actionMethodName1a;
    private transient boolean actionMethodName1aSet = false;

    /**
     * The method name that delegates transitions from this state.
     * @return (String)handleGetActionMethodName()
     */
    public final String getActionMethodName()
    {
        String actionMethodName1a = this.actionMethodName1a;
        if (!this.actionMethodName1aSet)
        {
            // actionMethodName has no pre constraints
            actionMethodName1a = handleGetActionMethodName();
            // actionMethodName has no post constraints
            this.actionMethodName1a = actionMethodName1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.actionMethodName1aSet = true;
            }
        }
        return actionMethodName1a;
    }

    /**
     * @return true
     * @see FrontEndPseudostate
     */
    public boolean isFrontEndPseudostateMetaType()
    {
        return true;
    }

    /**
     * @return true
     * @see org.andromda.metafacades.uml.PseudostateFacade
     */
    public boolean isPseudostateFacadeMetaType()
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

    // ----------- delegates to FrontEndPseudostate ------------
    /**
     * The actions that pass through this pseudo state.
     * @see FrontEndPseudostate#getContainerActions()
     */
    public List<FrontEndAction> getContainerActions()
    {
        return this.getSuperFrontEndPseudostate().getContainerActions();
    }

    /**
     * Indicates if this "front-end" pseudo date is contained within a "front-end" use case.
     * @see FrontEndPseudostate#isContainedInFrontEndUseCase()
     */
    public boolean isContainedInFrontEndUseCase()
    {
        return this.getSuperFrontEndPseudostate().isContainedInFrontEndUseCase();
    }

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @see ModelElementFacade#copyTaggedValues(ModelElementFacade element)
     */
    public void copyTaggedValues(ModelElementFacade element)
    {
        this.getSuperFrontEndPseudostate().copyTaggedValues(element);
    }

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @see ModelElementFacade#findTaggedValue(String tagName)
     */
    public Object findTaggedValue(String tagName)
    {
        return this.getSuperFrontEndPseudostate().findTaggedValue(tagName);
    }

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @see ModelElementFacade#findTaggedValues(String tagName)
     */
    public Collection<Object> findTaggedValues(String tagName)
    {
        return this.getSuperFrontEndPseudostate().findTaggedValues(tagName);
    }

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @see ModelElementFacade#getBindedFullyQualifiedName(ModelElementFacade bindedElement)
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement)
    {
        return this.getSuperFrontEndPseudostate().getBindedFullyQualifiedName(bindedElement);
    }

    /**
     * Gets all constraints belonging to the model element.
     * @see ModelElementFacade#getConstraints()
     */
    public Collection<ConstraintFacade> getConstraints()
    {
        return this.getSuperFrontEndPseudostate().getConstraints();
    }

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @see ModelElementFacade#getConstraints(String kind)
     */
    public Collection<ConstraintFacade> getConstraints(String kind)
    {
        return this.getSuperFrontEndPseudostate().getConstraints(kind);
    }

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @see ModelElementFacade#getDocumentation(String indent)
     */
    public String getDocumentation(String indent)
    {
        return this.getSuperFrontEndPseudostate().getDocumentation(indent);
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
        return this.getSuperFrontEndPseudostate().getDocumentation(indent, lineLength);
    }

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @see ModelElementFacade#getDocumentation(String indent, int lineLength, boolean htmlStyle)
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle)
    {
        return this.getSuperFrontEndPseudostate().getDocumentation(indent, lineLength, htmlStyle);
    }

    /**
     * The fully qualified name of this model element.
     * @see ModelElementFacade#getFullyQualifiedName()
     */
    public String getFullyQualifiedName()
    {
        return this.getSuperFrontEndPseudostate().getFullyQualifiedName();
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
        return this.getSuperFrontEndPseudostate().getFullyQualifiedName(modelName);
    }

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @see ModelElementFacade#getFullyQualifiedNamePath()
     */
    public String getFullyQualifiedNamePath()
    {
        return this.getSuperFrontEndPseudostate().getFullyQualifiedNamePath();
    }

    /**
     * Gets the unique identifier of the underlying model element.
     * @see ModelElementFacade#getId()
     */
    public String getId()
    {
        return this.getSuperFrontEndPseudostate().getId();
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
        return this.getSuperFrontEndPseudostate().getKeywords();
    }

    /**
     * UML2: Retrieves a localized label for this named element.
     * @see ModelElementFacade#getLabel()
     */
    public String getLabel()
    {
        return this.getSuperFrontEndPseudostate().getLabel();
    }

    /**
     * The language mappings that have been set for this model element.
     * @see ModelElementFacade#getLanguageMappings()
     */
    public TypeMappings getLanguageMappings()
    {
        return this.getSuperFrontEndPseudostate().getLanguageMappings();
    }

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @see ModelElementFacade#getModel()
     */
    public ModelFacade getModel()
    {
        return this.getSuperFrontEndPseudostate().getModel();
    }

    /**
     * The name of the model element.
     * @see ModelElementFacade#getName()
     */
    public String getName()
    {
        return this.getSuperFrontEndPseudostate().getName();
    }

    /**
     * Gets the package to which this model element belongs.
     * @see ModelElementFacade#getPackage()
     */
    public ModelElementFacade getPackage()
    {
        return this.getSuperFrontEndPseudostate().getPackage();
    }

    /**
     * The name of this model element's package.
     * @see ModelElementFacade#getPackageName()
     */
    public String getPackageName()
    {
        return this.getSuperFrontEndPseudostate().getPackageName();
    }

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @see ModelElementFacade#getPackageName(boolean modelName)
     */
    public String getPackageName(boolean modelName)
    {
        return this.getSuperFrontEndPseudostate().getPackageName(modelName);
    }

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @see ModelElementFacade#getPackagePath()
     */
    public String getPackagePath()
    {
        return this.getSuperFrontEndPseudostate().getPackagePath();
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
        return this.getSuperFrontEndPseudostate().getQualifiedName();
    }

    /**
     * Gets the root package for the model element.
     * @see ModelElementFacade#getRootPackage()
     */
    public PackageFacade getRootPackage()
    {
        return this.getSuperFrontEndPseudostate().getRootPackage();
    }

    /**
     * Gets the dependencies for which this model element is the source.
     * @see ModelElementFacade#getSourceDependencies()
     */
    public Collection<DependencyFacade> getSourceDependencies()
    {
        return this.getSuperFrontEndPseudostate().getSourceDependencies();
    }

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @see ModelElementFacade#getStateMachineContext()
     */
    public StateMachineFacade getStateMachineContext()
    {
        return this.getSuperFrontEndPseudostate().getStateMachineContext();
    }

    /**
     * The collection of ALL stereotype names for this model element.
     * @see ModelElementFacade#getStereotypeNames()
     */
    public Collection<String> getStereotypeNames()
    {
        return this.getSuperFrontEndPseudostate().getStereotypeNames();
    }

    /**
     * Gets all stereotypes for this model element.
     * @see ModelElementFacade#getStereotypes()
     */
    public Collection<StereotypeFacade> getStereotypes()
    {
        return this.getSuperFrontEndPseudostate().getStereotypes();
    }

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @see ModelElementFacade#getTaggedValues()
     */
    public Collection<TaggedValueFacade> getTaggedValues()
    {
        return this.getSuperFrontEndPseudostate().getTaggedValues();
    }

    /**
     * Gets the dependencies for which this model element is the target.
     * @see ModelElementFacade#getTargetDependencies()
     */
    public Collection<DependencyFacade> getTargetDependencies()
    {
        return this.getSuperFrontEndPseudostate().getTargetDependencies();
    }

    /**
     * Get the template parameters for this model element.
     * @see ModelElementFacade#getTemplateParameter(String parameterName)
     */
    public Object getTemplateParameter(String parameterName)
    {
        return this.getSuperFrontEndPseudostate().getTemplateParameter(parameterName);
    }

    /**
     * Get the template parameter for this model element having the parameterName.
     * @see ModelElementFacade#getTemplateParameters()
     */
    public Collection<TemplateParameterFacade> getTemplateParameters()
    {
        return this.getSuperFrontEndPseudostate().getTemplateParameters();
    }

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @see ModelElementFacade#getVisibility()
     */
    public String getVisibility()
    {
        return this.getSuperFrontEndPseudostate().getVisibility();
    }

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @see ModelElementFacade#hasExactStereotype(String stereotypeName)
     */
    public boolean hasExactStereotype(String stereotypeName)
    {
        return this.getSuperFrontEndPseudostate().hasExactStereotype(stereotypeName);
    }

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @see ModelElementFacade#hasKeyword(String keywordName)
     */
    public boolean hasKeyword(String keywordName)
    {
        return this.getSuperFrontEndPseudostate().hasKeyword(keywordName);
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
        return this.getSuperFrontEndPseudostate().hasStereotype(stereotypeName);
    }

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @see ModelElementFacade#isBindingDependenciesPresent()
     */
    public boolean isBindingDependenciesPresent()
    {
        return this.getSuperFrontEndPseudostate().isBindingDependenciesPresent();
    }

    /**
     * Indicates if any constraints are present on this model element.
     * @see ModelElementFacade#isConstraintsPresent()
     */
    public boolean isConstraintsPresent()
    {
        return this.getSuperFrontEndPseudostate().isConstraintsPresent();
    }

    /**
     * Indicates if any documentation is present on this model element.
     * @see ModelElementFacade#isDocumentationPresent()
     */
    public boolean isDocumentationPresent()
    {
        return this.getSuperFrontEndPseudostate().isDocumentationPresent();
    }

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @see ModelElementFacade#isReservedWord()
     */
    public boolean isReservedWord()
    {
        return this.getSuperFrontEndPseudostate().isReservedWord();
    }

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @see ModelElementFacade#isTemplateParametersPresent()
     */
    public boolean isTemplateParametersPresent()
    {
        return this.getSuperFrontEndPseudostate().isTemplateParametersPresent();
    }

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @see ModelElementFacade#isValidIdentifierName()
     */
    public boolean isValidIdentifierName()
    {
        return this.getSuperFrontEndPseudostate().isValidIdentifierName();
    }

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @see ModelElementFacade#translateConstraint(String name, String translation)
     */
    public String translateConstraint(String name, String translation)
    {
        return this.getSuperFrontEndPseudostate().translateConstraint(name, translation);
    }

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @see ModelElementFacade#translateConstraints(String translation)
     */
    public String[] translateConstraints(String translation)
    {
        return this.getSuperFrontEndPseudostate().translateConstraints(translation);
    }

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @see ModelElementFacade#translateConstraints(String kind, String translation)
     */
    public String[] translateConstraints(String kind, String translation)
    {
        return this.getSuperFrontEndPseudostate().translateConstraints(kind, translation);
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.choice
     * @see org.andromda.metafacades.uml.PseudostateFacade#isChoice()
     */
    public boolean isChoice()
    {
        return this.getSuperFrontEndPseudostate().isChoice();
    }

    /**
     * Denotes this pseudostate to be either a join or a fork with a single outgoing transition and
     * more than one incoming transition.
     * @see org.andromda.metafacades.uml.PseudostateFacade#isCollect()
     */
    public boolean isCollect()
    {
        return this.getSuperFrontEndPseudostate().isCollect();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.decisionPoint
     * @see org.andromda.metafacades.uml.PseudostateFacade#isDecisionPoint()
     */
    public boolean isDecisionPoint()
    {
        return this.getSuperFrontEndPseudostate().isDecisionPoint();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.deepHistory
     * @see org.andromda.metafacades.uml.PseudostateFacade#isDeepHistory()
     */
    public boolean isDeepHistory()
    {
        return this.getSuperFrontEndPseudostate().isDeepHistory();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.fork
     * @see org.andromda.metafacades.uml.PseudostateFacade#isFork()
     */
    public boolean isFork()
    {
        return this.getSuperFrontEndPseudostate().isFork();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.initialState
     * @see org.andromda.metafacades.uml.PseudostateFacade#isInitialState()
     */
    public boolean isInitialState()
    {
        return this.getSuperFrontEndPseudostate().isInitialState();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.join
     * @see org.andromda.metafacades.uml.PseudostateFacade#isJoin()
     */
    public boolean isJoin()
    {
        return this.getSuperFrontEndPseudostate().isJoin();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.junction
     * @see org.andromda.metafacades.uml.PseudostateFacade#isJunction()
     */
    public boolean isJunction()
    {
        return this.getSuperFrontEndPseudostate().isJunction();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.mergePoint
     * @see org.andromda.metafacades.uml.PseudostateFacade#isMergePoint()
     */
    public boolean isMergePoint()
    {
        return this.getSuperFrontEndPseudostate().isMergePoint();
    }

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.PseudostateFacade.shallowHistory
     * @see org.andromda.metafacades.uml.PseudostateFacade#isShallowHistory()
     */
    public boolean isShallowHistory()
    {
        return this.getSuperFrontEndPseudostate().isShallowHistory();
    }

    /**
     * Denotes this pseudostate to be either a join or a fork with a single incoming transition and
     * more than one outgoing transition.
     * @see org.andromda.metafacades.uml.PseudostateFacade#isSplit()
     */
    public boolean isSplit()
    {
        return this.getSuperFrontEndPseudostate().isSplit();
    }

    /**
     * Models a situation during which some (usually implicit) invariant condition holds. The states
     * of protocol state machines are exposed to the users of their context classifiers. A protocol
     * state represents an exposed stable situation of its context classifier: when an instance of
     * the classifier is not processing any operation, users of this instance can always know its
     * state configuration.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getContainer()
     */
    public StateFacade getContainer()
    {
        return this.getSuperFrontEndPseudostate().getContainer();
    }

    /**
     * A directed relationship between a source vertex and a target vertex. It may be part of a
     * compound transition, which takes the state machine from one state configuration to another,
     * representing the complete response of the state machine to an occurrence of an event of a
     * particular type.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getIncomings()
     */
    public Collection<TransitionFacade> getIncomings()
    {
        return this.getSuperFrontEndPseudostate().getIncomings();
    }

    /**
     * A directed relationship between a source vertex and a target vertex. It may be part of a
     * compound transition, which takes the state machine from one state configuration to another,
     * representing the complete response of the state machine to an occurrence of an event of a
     * particular type.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getOutgoings()
     */
    public Collection<TransitionFacade> getOutgoings()
    {
        return this.getSuperFrontEndPseudostate().getOutgoings();
    }

    /**
     * The partition (if any) to which this vertex belongs.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getPartition()
     */
    public PartitionFacade getPartition()
    {
        return this.getSuperFrontEndPseudostate().getPartition();
    }

    /**
     * State machines can be used to express the behavior of part of a system. Behavior is modeled
     * as a traversal of a graph of state nodes interconnected by one or more joined transition arcs
     * that are triggered by the dispatching of series of (event) occurrences. During this
     * traversal, the state machine executes a series of activities associated with various elements
     * of the state machine.
     * @see org.andromda.metafacades.uml.StateVertexFacade#getStateMachine()
     */
    public StateMachineFacade getStateMachine()
    {
        return this.getSuperFrontEndPseudostate().getStateMachine();
    }

    /**
     * @see org.andromda.core.metafacade.MetafacadeBase#initialize()
     */
    @Override
    public void initialize()
    {
        this.getSuperFrontEndPseudostate().initialize();
    }

    /**
     * @return Object getSuperFrontEndPseudostate().getValidationOwner()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationOwner()
     */
    @Override
    public Object getValidationOwner()
    {
        Object owner = this.getSuperFrontEndPseudostate().getValidationOwner();
        return owner;
    }

    /**
     * @return String getSuperFrontEndPseudostate().getValidationName()
     * @see org.andromda.core.metafacade.MetafacadeBase#getValidationName()
     */
    @Override
    public String getValidationName()
    {
        String name = this.getSuperFrontEndPseudostate().getValidationName();
        return name;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see org.andromda.core.metafacade.MetafacadeBase#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        this.getSuperFrontEndPseudostate().validateInvariants(validationMessages);
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