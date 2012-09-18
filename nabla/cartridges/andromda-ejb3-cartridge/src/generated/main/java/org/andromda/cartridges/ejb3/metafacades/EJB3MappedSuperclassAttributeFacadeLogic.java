// license-header java merge-point
//
// Attention: generated code (by MetafacadeLogic.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.core.metafacade.ModelValidationMessage;

/**
 * 
 * MetafacadeLogic for EJB3MappedSuperclassAttributeFacade
 *
 * @see EJB3MappedSuperclassAttributeFacade
 */
public abstract class EJB3MappedSuperclassAttributeFacadeLogic
    extends EJB3EntityAttributeFacadeLogicImpl
    implements EJB3MappedSuperclassAttributeFacade
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
    protected EJB3MappedSuperclassAttributeFacadeLogic(final Object metaObjectIn, String context)
    {
        super(metaObjectIn, getContext(context));
        this.metaObject = metaObjectIn;
    }

    /**
     * Gets the context for this metafacade logic instance.
     * @param context String. Set to EJB3MappedSuperclassAttributeFacade if null
     * @return context String
     */
    private static String getContext(String context)
    {
        if (context == null)
        {
            context = "org.andromda.cartridges.ejb3.metafacades.EJB3MappedSuperclassAttributeFacade";
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
     * @see EJB3MappedSuperclassAttributeFacade
     */
    public boolean isEJB3MappedSuperclassAttributeFacadeMetaType()
    {
        return true;
    }

    /**
     * @param validationMessages Collection<ModelValidationMessage>
     * @see EJB3EntityAttributeFacadeLogicImpl#validateInvariants(Collection validationMessages)
     */
    @Override
    public void validateInvariants(Collection<ModelValidationMessage> validationMessages)
    {
        super.validateInvariants(validationMessages);
    }
}