// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * Captures a view of a physical system. It is an abstraction of the physical system, with a certain
 * purpose. This purpose determines what is to be included in the model and what is irrelevant. Thus
 * the model completely describes those aspects of the physical system that are relevant to the
 * purpose of the model, at the appropriate level of detail. May be a UML2 model or package.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface ModelFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isModelFacadeMetaType();

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
     * Finds the ActivityGraph with the Name.
     * @param name String
     * @return ActivityGraphFacade
     */
    public ActivityGraphFacade findActivityGraphByName(String name);

    /**
     * Finds the ActivityGraph with the Name and Stereotype.
     * @param name String
     * @param stereotypeName String
     * @return ActivityGraphFacade
     */
    public ActivityGraphFacade findActivityGraphByNameAndStereotype(String name, String stereotypeName);

    /**
     * Return the Class belonging to this model with the tagged value or hyperlink.
     * @param tag String
     * @param value String
     * @return ClassifierFacade
     */
    public ClassifierFacade findClassWithTaggedValueOrHyperlink(String tag, String value);

    /**
     * Finds the FinalState with the Name or Hyperlink.
     * @param useCase UseCaseFacade
     * @return Collection<FinalStateFacade>
     */
    public Collection<FinalStateFacade> findFinalStatesWithNameOrHyperlink(UseCaseFacade useCase);

    /**
     * Finds the UseCase with the Name.
     * @param name String
     * @return UseCaseFacade
     */
    public UseCaseFacade findUseCaseByName(String name);

    /**
     * Finds the UseGraph with the Name and Stereotype.
     * @param name String
     * @param stereotypeName String
     * @return UseCaseFacade
     */
    public UseCaseFacade findUseCaseWithNameAndStereotype(String name, String stereotypeName);

    /**
     * Return the UseCase belonging to this model with the tagged value or hyperlink.
     * @param tag String
     * @param value String
     * @return UseCaseFacade
     */
    public UseCaseFacade findUseCaseWithTaggedValueOrHyperlink(String tag, String value);

    /**
     * Return all ActionStates belonging to this model.
     * @return Collection<ActionStateFacade>
     */
    public Collection<ActionStateFacade> getAllActionStates();

    /**
     * Finds all ActionStates with the Stereotype.
     * @param activityGraph ActivityGraphFacade
     * @param stereotypeName String
     * @return Collection<ActionStateFacade>
     */
    public Collection<ActionStateFacade> getAllActionStatesWithStereotype(ActivityGraphFacade activityGraph, String stereotypeName);

    /**
     * Return all Actors belonging to this model.
     * @return Collection<ActorFacade>
     */
    public Collection<ActorFacade> getAllActors();

    /**
     * Return all Classes and Datatypes belonging to this model.
     * @return Collection<ClassifierFacade>
     */
    public Collection<ClassifierFacade> getAllClasses();

    /**
     * All object flow states in this model.
     * @return Collection<ObjectFlowStateFacade>
     */
    public Collection<ObjectFlowStateFacade> getAllObjectFlowStates();

    /**
     * All transitions present in the activity graphs contained by this model.
     * @return Collection<TransitionFacade>
     */
    public Collection<TransitionFacade> getAllTransitions();

    /**
     * Return all UseCases belonging to this model.
     * @return Collection<UseCaseFacade>
     */
    public Collection<UseCaseFacade> getAllUseCases();

    /**
     * Return the root package belonging to this model. In UML2, the top level element may be either
     * a package or a model.
     * @return PackageFacade
     */
    public PackageFacade getRootPackage();
}