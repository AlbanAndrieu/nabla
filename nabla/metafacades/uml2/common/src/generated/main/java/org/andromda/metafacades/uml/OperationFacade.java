// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.metafacades.uml;

import java.util.Collection;

/**
 * A behavioral feature of a classifier that specifies the name, type, parameters, and constraints
 * for invoking an associated behavior. May invoke both the execution of method behaviors as well as
 * other behavioral responses.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface OperationFacade
    extends ModelElementFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isOperationFacadeMetaType();

    /**
     * Finds the parameter on this operation having the given name, if no parameter is found, null
     * is returned instead.
     * @param name String
     * @return ParameterFacade
     */
    public ParameterFacade findParameter(String name);

    /**
     * Searches the given feature for the specified tag.
     * If the follow boolean is set to true then the search will continue from the class operation
     * to the class itself and then up the class hierarchy.
     * @param name String
     * @param follow boolean
     * @return Object
     */
    public Object findTaggedValue(String name, boolean follow);

    /**
     * A comma separated list of all argument names.
     * @return String
     */
    public String getArgumentNames();

    /**
     * 
     * @return String
     */
    public String getArgumentTypeNames();

    /**
     * 
     * @return Collection<ParameterFacade>
     */
    public Collection<ParameterFacade> getArguments();

    /**
     * 
     * @return String
     */
    public String getCall();

    /**
     * Returns the concurrency modifier for this operation (i.e. concurrent, guarded or sequential)
     * of the model element, will attempt a lookup for these values in the language mappings (if
     * any).
     * @return String
     */
    public String getConcurrency();

    /**
     * A comma separated list containing all exceptions that this operation throws.  Exceptions are
     * determined through dependencies that have the target element stereotyped as <<Exception>>.
     * @return String
     */
    public String getExceptionList();

    /**
     * Returns a comma separated list of exceptions appended to the comma separated list of fully
     * qualified 'initialException' classes passed in to this method.
     * @param initialExceptions String
     * @return String
     */
    public String getExceptionList(String initialExceptions);

    /**
     * A collection of all exceptions thrown by this operation.
     * @return Collection<ModelElementFacade>
     */
    public Collection<ModelElementFacade> getExceptions();

    /**
     * Return Type with multiplicity taken into account. UML14 does not allow multiplicity *.
     * @return String
     */
    public String getGetterSetterReturnTypeName();

    /**
     * the lower value for the multiplicity
     * -only applicable for UML2
     * @return int
     */
    public int getLower();

    /**
     * Returns the operation method body determined from UML sequence diagrams or other UML sources.
     * @return String
     */
    public String getMethodBody();

    /**
     * The operation this operation overrides, null if this operation is not overriding.
     * @return OperationFacade
     */
    public OperationFacade getOverriddenOperation();

    /**
     * Gets the owner of this operation
     * @return ClassifierFacade
     */
    public ClassifierFacade getOwner();

    /**
     * 
     * @return Collection<ParameterFacade>
     */
    public Collection<ParameterFacade> getParameters();

    /**
     * The name of the operation that handles postcondition constraints.
     * @return String
     */
    public String getPostconditionName();

    /**
     * The postcondition constraints belonging to this operation.
     * @return Collection<ConstraintFacade>
     */
    public Collection<ConstraintFacade> getPostconditions();

    /**
     * The call to the precondition operation.
     * @return String
     */
    public String getPreconditionCall();

    /**
     * The name of the operation that handles precondition constraints.
     * @return String
     */
    public String getPreconditionName();

    /**
     * The signature of the precondition operation.
     * @return String
     */
    public String getPreconditionSignature();

    /**
     * The precondition constraints belonging to this operation.
     * @return Collection<ConstraintFacade>
     */
    public Collection<ConstraintFacade> getPreconditions();

    /**
     * (UML2 Only). Get the actual return parameter (which may have stereotypes etc).
     * @return ParameterFacade
     */
    public ParameterFacade getReturnParameter();

    /**
     * 
     * @return ClassifierFacade
     */
    public ClassifierFacade getReturnType();

    /**
     * 
     * @return String
     */
    public String getSignature();

    /**
     * Returns the signature of the operation and optionally appends the argument names (if
     * withArgumentNames is true), otherwise returns the signature with just the types alone in the
     * signature.
     * @param withArgumentNames boolean
     * @return String
     */
    public String getSignature(boolean withArgumentNames);

    /**
     * Returns the signature of the operation and optionally appends the given 'argumentModifier' to
     * each argument.
     * @param argumentModifier String
     * @return String
     */
    public String getSignature(String argumentModifier);

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation.
     * @return String
     */
    public String getTypedArgumentList();

    /**
     * A comma-separated parameter list  (type and name of each parameter) of an operation with an
     * optional modifier (i.e final) before each parameter.
     * @param modifier String
     * @return String
     */
    public String getTypedArgumentList(String modifier);

    /**
     * the upper value for the multiplicity (will be -1 for *)
     * - only applicable for UML2
     * @return int
     */
    public int getUpper();

    /**
     * 
     * @return boolean
     */
    public boolean isAbstract();

    /**
     * True if the operation has (i.e. throws any exceptions) false otherwise.
     * @return boolean
     */
    public boolean isExceptionsPresent();

    /**
     * IsLeaf property in the operation. If true, operation is final, cannot be extended or
     * implemented by a descendant. Default=false.
     * @return boolean
     */
    public boolean isLeaf();

    /**
     * UML2 only. If the return type parameter multiplicity>1 OR the operation multiplicity>1.
     * Default=false.
     * @return boolean
     */
    public boolean isMany();

    /**
     * UML2 only: If isMany (Collection type returned), is the type unique within the collection. 
     * Unique+Ordered determines CollectionType implementation of return result. Default=false.
     * @return boolean
     */
    public boolean isOrdered();

    /**
     * True if this operation overrides an operation defined in an ancestor class. An operation
     * overrides when the names of the operations as well as the types of the arguments are equal.
     * The return type may be different and is, as well as any exceptions, ignored.
     * @return boolean
     */
    public boolean isOverriding();

    /**
     * Whether any postcondition constraints are present on this operation.
     * @return boolean
     */
    public boolean isPostconditionsPresent();

    /**
     * Whether any precondition constraints are present on this operation.
     * @return boolean
     */
    public boolean isPreconditionsPresent();

    /**
     * Indicates whether or not this operation is a query operation.
     * @return boolean
     */
    public boolean isQuery();

    /**
     * True/false depending on whether or not the operation has a return type or not (i.e. a return
     * type of something other than void).
     * @return boolean
     */
    public boolean isReturnTypePresent();

    /**
     * 
     * @return boolean
     */
    public boolean isStatic();

    /**
     * UML2 only: for Collection return type, is the type unique within the collection.
     * Unique+Ordered determines the returned CollectionType. Default=false.
     * @return boolean
     */
    public boolean isUnique();
}