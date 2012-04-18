// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.OperationFacade;

/**
 * Represents an operation in an entity EJB bean POJO.
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3OperationFacade
    extends OperationFacade
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3OperationFacadeMetaType();

    /**
     * The method call for the implementation operation.
     * @return String
     */
    public String getImplementationCall();

    /**
     * The name of the operation used within the entity implementation.
     * @return String
     */
    public String getImplementationName();

    /**
     * The signature for the implementation operation.
     * @return String
     */
    public String getImplementationSignature();

    /**
     * True/false on whether or not this operation is an EJB business operation.  This returns true
     * if the operation is not one of the following:
     * Create Method
     * Finder or Query Method
     * Select Method
     * @return boolean
     */
    public boolean isBusinessOperation();

    /**
     * Returns true if the operation has the <<CreateMethod>> stereotype.
     * @return boolean
     */
    public boolean isCreateMethod();

    /**
     * Returns true if the operation is a finder or query operation.
     * @return boolean
     */
    public boolean isFinderMethod();

    /**
     * Returns true if this operation is marked with any of the lifecycle callback stereotypes like
     * PrePersist, PostPersist, PreRemove, PostRemove, PreUpdate, PostUpdate or PostLoad.
     * @return boolean
     */
    public boolean isLifecycleCallback();

    /**
     * Returns true if the associated operation has the <<PostLoad>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPostLoad();

    /**
     * Returns true if the associated operation has the <<PostPersist>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPostPersist();

    /**
     * Returns true if the associated operation has the <<PostRemove>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPostRemove();

    /**
     * Returns true if the associated operation has the <<PostUpdate>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPostUpdate();

    /**
     * Returns true if the associated operation has the <<PrePersist>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPrePersist();

    /**
     * Returns true if the associated operation has the <<PreRemove>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPreRemove();

    /**
     * Returns true if the associated operation has the <<PreUpdate>> stereotype.
     * NOTE: The method signature must return void and have no args.
     * @return boolean
     */
    public boolean isPreUpdate();

    /**
     * True/false on whether or not this operation represents a select method.
     * @return boolean
     */
    public boolean isSelectMethod();
}