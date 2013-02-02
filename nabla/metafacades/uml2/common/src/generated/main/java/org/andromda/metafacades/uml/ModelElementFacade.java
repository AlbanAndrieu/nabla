// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * Represents a model element. It may be an Element or NamedElement. A named element is an element
 * in a model that may have a name. An element is a constituent of a model. As such, it has the
 * capability of owning other elements.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isModelElementFacadeMetaType();

    /**
     * Provides any required initialization of the metafacade.
     */
    void initialize();

    /**
     * Gets the metafacade that acts as the <code>owner</code> of this metafacade.
     * (for example: an operation is an owner of its parameters, etc). This is used
     * by AndroMDA's validation framework to provide more context as to where the
     * error has occurred.
     * @return Object the Validation Owner
     */
    public Object getValidationOwner();

    /**
     * Gets the name of the metafacade used within validation messages.  This provides
     * the full name of the metafacade.
     * @return String the Validation Name
     */
    public String getValidationName();

    /**
     * Performs validation of any invariants found on this model element
     * and stores the messages within the <code>validationMessages</code>
     * collection.
     *
     * @param validationMessages the collection of messages to which additional
     *        validation messages will be added if invariants are broken.
     */
    void validateInvariants(Collection<ModelValidationMessage> validationMessages);

    /**
     * Copies all tagged values from the given ModelElementFacade to this model element facade.
     * @param element ModelElementFacade
     */
    public void copyTaggedValues(ModelElementFacade element);

    /**
     * Finds the tagged value with the specified 'tagName'. In case there are more values the first
     * one found will be returned.
     * @param tagName String
     * @return Object
     */
    public Object findTaggedValue(String tagName);

    /**
     * Returns all the values for the tagged value with the specified name. The returned collection
     * will contains only String instances, or will be empty. Never null.
     * @param tagName String
     * @return Collection<Object>
     */
    public Collection<Object> findTaggedValues(String tagName);

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element. The templates parameter will
     * be replaced by the correct one given the binding relation of the parameter to this element.
     * @param bindedElement ModelElementFacade
     * @return String
     */
    public String getBindedFullyQualifiedName(ModelElementFacade bindedElement);

    /**
     * Gets all constraints belonging to the model element.
     * @return Collection<ConstraintFacade>
     */
    public Collection<ConstraintFacade> getConstraints();

    /**
     * Returns the constraints of the argument kind that have been placed onto this model. Typical
     * kinds are "inv", "pre" and "post". Other kinds are possible.
     * @param kind String
     * @return Collection<ConstraintFacade>
     */
    public Collection<ConstraintFacade> getConstraints(String kind);

    /**
     * Gets the documentation for the model element, The indent argument is prefixed to each line.
     * By default this method wraps lines after 64 characters.
     * This method is equivalent to <code>getDocumentation(indent, 64)</code>.
     * @param indent String
     * @return String
     */
    public String getDocumentation(String indent);

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. By default paragraphs are returned as HTML.
     * This method is equivalent to <code>getDocumentation(indent, lineLength, true)</code>.
     * @param indent String
     * @param lineLength int
     * @return String
     */
    public String getDocumentation(String indent, int lineLength);

    /**
     * This method returns the documentation for this model element, with the lines wrapped after
     * the specified number of characters, values of less than 1 will indicate no line wrapping is
     * required. HTML style determines if HTML Escaping is applied.
     * @param indent String
     * @param lineLength int
     * @param htmlStyle boolean
     * @return String
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle);

    /**
     * The fully qualified name of this model element.
     * @return String
     */
    public String getFullyQualifiedName();

    /**
     * Returns the fully qualified name of the model element. The fully qualified name includes
     * complete package qualified name of the underlying model element.  If modelName is true, then
     * the original name of the model element (the name contained within the model) will be the name
     * returned, otherwise a name from a language mapping will be returned.
     * @param modelName boolean
     * @return String
     */
    public String getFullyQualifiedName(boolean modelName);

    /**
     * Returns the fully qualified name as a path, the returned value always starts with out a slash
     * '/'.
     * @return String
     */
    public String getFullyQualifiedNamePath();

    /**
     * Gets the unique identifier of the underlying model element.
     * @return String
     */
    public String getId();

    /**
     * UML2: Retrieves the keywords for this element. Used to modify implementation properties which
     * are not represented by other properties, i.e. native, transient, volatile, synchronized,
     * (added annotations) override, deprecated. Can also be used to suppress compiler warnings:
     * (added annotations) unchecked, fallthrough, path, serial, finally, all. Annotations require
     * JDK5 compiler level.
     * @return Collection<String>
     */
    public Collection<String> getKeywords();

    /**
     * UML2: Retrieves a localized label for this named element.
     * @return String
     */
    public String getLabel();

    /**
     * The language mappings that have been set for this model element.
     * @return TypeMappings
     */
    public TypeMappings getLanguageMappings();

    /**
     * Return the model containing this model element (multiple models may be loaded and processed
     * at the same time).
     * @return ModelFacade
     */
    public ModelFacade getModel();

    /**
     * The name of the model element.
     * @return String
     */
    public String getName();

    /**
     * Gets the package to which this model element belongs.
     * @return ModelElementFacade
     */
    public ModelElementFacade getPackage();

    /**
     * The name of this model element's package.
     * @return String
     */
    public String getPackageName();

    /**
     * Gets the package name (optionally providing the ability to retrieve the model name and not
     * the mapped name).
     * @param modelName boolean
     * @return String
     */
    public String getPackageName(boolean modelName);

    /**
     * Returns the package as a path, the returned value always starts with out a slash '/'.
     * @return String
     */
    public String getPackagePath();

    /**
     * UML2: Returns the value of the 'Qualified Name' attribute. A name which allows the
     * NamedElement to be identified within a hierarchy of nested Namespaces. It is constructed from
     * the names of the containing namespaces starting at the root of the hierarchy and ending with
     * the name of the NamedElement itself.
     * @return String
     */
    public String getQualifiedName();

    /**
     * Gets the root package for the model element.
     * @return PackageFacade
     */
    public PackageFacade getRootPackage();

    /**
     * Gets the dependencies for which this model element is the source.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getSourceDependencies();

    /**
     * If this model element is the context of an activity graph, this represents that activity
     * graph.
     * @return StateMachineFacade
     */
    public StateMachineFacade getStateMachineContext();

    /**
     * The collection of ALL stereotype names for this model element.
     * @return Collection<String>
     */
    public Collection<String> getStereotypeNames();

    /**
     * Gets all stereotypes for this model element.
     * @return Collection<StereotypeFacade>
     */
    public Collection<StereotypeFacade> getStereotypes();

    /**
     * Return the TaggedValues associated with this model element, under all stereotypes.
     * @return Collection<TaggedValueFacade>
     */
    public Collection<TaggedValueFacade> getTaggedValues();

    /**
     * Gets the dependencies for which this model element is the target.
     * @return Collection<DependencyFacade>
     */
    public Collection<DependencyFacade> getTargetDependencies();

    /**
     * Get the template parameters for this model element.
     * @param parameterName String
     * @return Object
     */
    public Object getTemplateParameter(String parameterName);

    /**
     * Get the template parameter for this model element having the parameterName.
     * @return Collection<TemplateParameterFacade>
     */
    public Collection<TemplateParameterFacade> getTemplateParameters();

    /**
     * The visibility (i.e. public, private, protected or package) of the model element, will
     * attempt a lookup for these values in the language mappings (if any).
     * @return String
     */
    public String getVisibility();

    /**
     * Returns true if the model element has the exact stereotype (meaning no stereotype inheritance
     * is taken into account when searching for the stereotype), false otherwise.
     * @param stereotypeName String
     * @return boolean
     */
    public boolean hasExactStereotype(String stereotypeName);

    /**
     * Does the UML Element contain the named Keyword? Keywords can be separated by space, comma,
     * pipe, semicolon, or << >>
     * @param keywordName String
     * @return boolean
     */
    public boolean hasKeyword(String keywordName);

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
     * @param stereotypeName String
     * @return boolean
     */
    public boolean hasStereotype(String stereotypeName);

    /**
     * True if there are target dependencies from this element that are instances of BindingFacade.
     * Deprecated in UML2: Use TemplateBinding parameters instead of dependencies.
     * @return boolean
     */
    public boolean isBindingDependenciesPresent();

    /**
     * Indicates if any constraints are present on this model element.
     * @return boolean
     */
    public boolean isConstraintsPresent();

    /**
     * Indicates if any documentation is present on this model element.
     * @return boolean
     */
    public boolean isDocumentationPresent();

    /**
     * True if this element name is a reserved word in Java, C#, ANSI or ISO C, C++, JavaScript.
     * @return boolean
     */
    public boolean isReservedWord();

    /**
     * True is there are template parameters on this model element. For UML2, applies to Class,
     * Operation, Property, and Parameter.
     * @return boolean
     */
    public boolean isTemplateParametersPresent();

    /**
     * True if this element name is a valid identifier name in Java, C#, ANSI or ISO C, C++,
     * JavaScript. Contains no spaces, special characters etc. Constraint always applied on
     * Enumerations and Interfaces, optionally applies on other model elements.
     * @return boolean
     */
    public boolean isValidIdentifierName();

    /**
     * Searches for the constraint with the specified 'name' on this model element, and if found
     * translates it using the specified 'translation' from a translation library discovered by the
     * framework.
     * @param name String
     * @param translation String
     * @return String
     */
    public String translateConstraint(String name, String translation);

    /**
     * Translates all constraints belonging to this model element with the given 'translation'.
     * @param translation String
     * @return String[]
     */
    public String[] translateConstraints(String translation);

    /**
     * Translates the constraints of the specified 'kind' belonging to this model element.
     * @param kind String
     * @param translation String
     * @return String[]
     */
    public String[] translateConstraints(String kind, String translation);
}