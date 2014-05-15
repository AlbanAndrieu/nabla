// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.gui.metafacades;

import java.util.Collection;
import java.util.List;
import org.andromda.core.metafacade.MetafacadeBase;
import org.andromda.core.metafacade.ModelValidationMessage;
import org.andromda.metafacades.uml.Entity;
import org.andromda.translation.ocl.validation.OCLIntrospector;
import org.andromda.translation.ocl.validation.OCLResultEnsurer;
import org.apache.log4j.Logger;

/**
 * A Validable entity handles Validable stereotype. Its a particular Manageable entity in the way it
 * carries some of the Manageable use cases, overrides some others, and defines specific ones.
 * MetafacadeLogic for GuiValidableEntity
 *
 * @see GuiValidableEntity
 */
public abstract class GuiValidableEntityLogic
    extends GuiManageableEntityLogicImpl
    implements GuiValidableEntity
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
    protected GuiValidableEntityLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * The logger instance.
     */
    private static final Logger LOGGER = Logger.getLogger(GuiValidableEntityLogic.class);

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to GuiValidableEntity if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.gui.metafacades.GuiValidableEntity";
        }
        return context;
    }

    /** Reset context only for non-root metafacades
     * @param context
     */
    @Override
    public void resetMetafacadeContext(String context)
    {
        if (!this.contextRoot) // reset context only for non-root metafacades
        {
            context = getContext(context);  // to have same value as in original constructor call
            setMetafacadeContext (context);
        }
    }

    /**
     * @return boolean true always
     * @see GuiValidableEntity
     */
    public boolean isGuiValidableEntityMetaType()
    {
        return true;
    }

    // --------------- attributes ---------------------

   /**
    * @see org.andromda.cartridges.gui.metafacades.GuiValidableEntity#getValidationNameSuffix()
    * @return String
    */
    protected abstract String handleGetValidationNameSuffix();

    private transient String validationNameSuffix1a;
    private transient boolean validationNameSuffix1aSet = false;

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.validationNameSuffix
     * @return (String)handleGetValidationNameSuffix()
     */
    public final String getValidationNameSuffix()
    {
        String validationNameSuffix1a = this.validationNameSuffix1a;
        if (!this.validationNameSuffix1aSet)
        {
            // validationNameSuffix has no pre constraints
            validationNameSuffix1a = handleGetValidationNameSuffix();
            // validationNameSuffix has no post constraints
            this.validationNameSuffix1a = validationNameSuffix1a;
            if (isMetafacadePropertyCachingEnabled())
            {
                this.validationNameSuffix1aSet = true;
            }
        }
        return validationNameSuffix1a;
    }

    // ---------------- business methods ----------------------

    /**
     * Method to be implemented in descendants
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.eachValidableObjectReferenceIsValid
     * @return boolean
     */
    protected abstract boolean handleEachValidableObjectReferenceIsValid();

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.eachValidableObjectReferenceIsValid
     * @return handleEachValidableObjectReferenceIsValid()
     */
    public boolean eachValidableObjectReferenceIsValid()
    {
        // eachValidableObjectReferenceIsValid has no pre constraints
        boolean returnValue = handleEachValidableObjectReferenceIsValid();
        // eachValidableObjectReferenceIsValid has no post constraints
        return returnValue;
    }

    /**
     * Method to be implemented in descendants
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.getIdentifierForValidableObjectReference
     * @param businessObjectName
     * @return String
     */
    protected abstract String handleGetIdentifierForValidableObjectReference(String businessObjectName);

    /**
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.getIdentifierForValidableObjectReference
     * @param businessObjectName String
     * TODO: Model Documentation for
     * org.andromda.cartridges.gui.metafacades.GuiValidableEntity.getIdentifierForValidableObjectReference(businessObjectName)
     * @return handleGetIdentifierForValidableObjectReference(businessObjectName)
     */
    public String getIdentifierForValidableObjectReference(String businessObjectName)
    {
        // getIdentifierForValidableObjectReference has no pre constraints
        String returnValue = handleGetIdentifierForValidableObjectReference(businessObjectName);
        // getIdentifierForValidableObjectReference has no post constraints
        return returnValue;
    }

    // ------------- associations ------------------

    /**
     * A Validable entity handles Validable stereotype. Its a particular Manageable entity in the
     * way it
     * carries some of the Manageable use cases, overrides some others, and defines specific ones.
     * @return (List<Entity>)handleGetValidableObjectReferences()
     */
    public final List<Entity> getValidableObjectReferences()
    {
        List<Entity> getValidableObjectReferences1r = null;
        // guiValidableEntity has no pre constraints
        List result = handleGetValidableObjectReferences();
        List shieldedResult = this.shieldedElements(result);
        try
        {
            getValidableObjectReferences1r = (List<Entity>) shieldedResult;
        }
        catch (ClassCastException ex)
        {
            // Bad things happen if the metafacade type mapping in metafacades.xml is wrong - Warn
            GuiValidableEntityLogic.LOGGER.warn("incorrect metafacade cast for GuiValidableEntityLogic.getValidableObjectReferences List<Entity> " + result + ": " + shieldedResult);
        }
        // guiValidableEntity has no post constraints
        return getValidableObjectReferences1r;
    }

    /**
     * UML Specific type is returned in Collection, transformed by shieldedElements to AndroMDA Metafacade type
     * @return  List
     */
    protected abstract List handleGetValidableObjectReferences();

    /**
     * <p><b>Constraint:</b> org::andromda::cartridges::gui::metafacades::GuiValidableEntity::Each Validable Object reference must be valid</p>
     * <p><b>Error:</b> Each validable object reference (dependency) must have a correct discriminator name. It must be the name of an attribute or an association end of the source entity.The target element (Entity) must also have a dedicated Value Object.</p>
     * <p><b>OCL:</b> context GuiManageableEntity
inv: eachValidableObjectReferenceIsValid()</p>
     * @param validationMessages Collection<ModelValidationMessage>
     * @see GuiManageableEntityLogicImpl#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        super.validateInvariants(validationMessages);
        try
        {
            final Object contextElement = this.THIS();
            boolean constraintValid = OCLResultEnsurer.ensure(OCLIntrospector.invoke(contextElement,"eachValidableObjectReferenceIsValid()"));
            if (!constraintValid)
            {
                validationMessages.add(
                    new ModelValidationMessage(
                        (MetafacadeBase)contextElement ,
                        "org::andromda::cartridges::gui::metafacades::GuiValidableEntity::Each Validable Object reference must be valid",
                        "Each validable object reference (dependency) must have a correct discriminator name. It must be the name of an attribute or an association end of the source entity.The target element (Entity) must also have a dedicated Value Object."));
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
            logger.error("Error validating constraint 'org::andromda::cartridges::gui::metafacades::GuiValidableEntity::Each Validable Object reference must be valid' ON "
                + this.THIS().toString() + ": " + th.getMessage(), th);
        }
    }
}