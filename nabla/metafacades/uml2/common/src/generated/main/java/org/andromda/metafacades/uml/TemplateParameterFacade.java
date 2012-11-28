// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * Represents a UML template parameter. Exposes a parameterable element as a formal template
 * parameter of a template. Only UML2 TemplateParameter inherits from ModelElement, so the UML14
 * implementation cannot extend ModelElement. UML14 TemplateParameter.parameter inherits from
 * Parameter.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface TemplateParameterFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isTemplateParameterFacadeMetaType();

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
     * UML2 only: Returns the list of classifiers (Classes) which constrain the parameter type.
     * Results in <? extends ConstrainingClassifier> declaration.
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getConstrainingClassifiers();

    /**
     * Return the default element for the template parameter
     * @return ModelElementFacade
     */
    public ModelElementFacade getDefaultElement();

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
     * TODO: Model Documentation for
     * org.andromda.metafacades.uml.TemplateParameterFacade.getDocumentation
     * @param indent String
     * @param lineLength int
     * @param htmlStyle boolean
     * @return String
     */
    public String getDocumentation(String indent, int lineLength, boolean htmlStyle);

    /**
     * Return the fully qualified name of the template parameter: package + class + parameter name
     * @return String
     */
    public String getFullyQualifiedName();

    /**
     * get + capitalized parameter name
     * @return String
     */
    public String getGetterName();

    /**
     * The type of the template parameter.
     * @return String
     */
    public String getGetterSetterTypeName();

    /**
     * TODO: Model Documentation for org.andromda.metafacades.uml.TemplateParameterFacade.name
     * @return String
     */
    public String getName();

    /**
     * The ModelElement that owns this parameter. For UML14, the classifier package. For UML2, the
     * Classifier.
     * @return ModelElementFacade
     */
    public ModelElementFacade getOwner();

    /**
     * Returns the parameter value for the template parameter. In andromda, parameter and template
     * parameter functionality are combined for simplicity.
     * @return ModelElementFacade
     */
    public ModelElementFacade getParameter();

    /**
     * set + capitalized parameter name
     * @return String
     */
    public String getSetterName();

    /**
     * TemplateParameter may be of type Classifier, PackageableElement,
     * Operation or Property. Generally a Class parameter has a name and a type of Classifier.
     * @return ClassifierFacade
     */
    public ClassifierFacade getType();
}