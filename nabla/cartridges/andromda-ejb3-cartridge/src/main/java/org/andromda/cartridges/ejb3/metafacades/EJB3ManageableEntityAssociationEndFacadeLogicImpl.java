package org.andromda.cartridges.ejb3.metafacades;

import org.andromda.metafacades.uml.ClassifierFacade;
import org.andromda.utils.StringUtilsHelper;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityAssociationEndFacade.
 *
 * @see EJB3ManageableEntityAssociationEndFacade
 */
public class EJB3ManageableEntityAssociationEndFacadeLogicImpl
    extends EJB3ManageableEntityAssociationEndFacadeLogic
{
    private static final long serialVersionUID = 34L;
    /**
     * Public constructor for SpringManageableEntityAssociationEndLogicImpl
     * @param metaObject
     * @param context
     * @see EJB3ManageableEntityAssociationEnd
     */
    public EJB3ManageableEntityAssociationEndFacadeLogicImpl(final Object metaObject, final String context)
    {
        super (metaObject, context);
    }
    
    /**
     * @return StringUtilsHelper.lowerCamelCaseName(this.getName()) + "Dao"
     * @see EJB3ManageableEntityAssociationEnd#getDaoName()
     */
    protected String handleGetDaoName()
    {
        return StringUtilsHelper.lowerCamelCaseName(this.getName()) + "Dao";
    }

    /**
     * @return getType().getBeanName(false)
     * @see EJB3ManageableEntityAssociationEnd#getDaoReferenceName()
     */
    protected String handleGetDaoReferenceName()
    {
        String referenceName = null;

        final ClassifierFacade type = this.getType();
        if (type instanceof EJB3EntityFacade)
        {
            final EJB3EntityFacade entity = (EJB3EntityFacade)type;
            referenceName = entity.getBeanName(false);
        }

        return referenceName;
    }

    /**
     * @return getGetterName() + "Dao"
     * @see EJB3ManageableEntityAssociationEnd#getDaoGetterName()
     */
    protected String handleGetDaoGetterName()
    {
        return this.getGetterName() + "Dao";
    }

    /**
     * @return getSetterName() + "Dao"
     * @see EJB3ManageableEntityAssociationEnd#getDaoSetterName()
     */
    protected String handleGetDaoSetterName()
    {
        return this.getSetterName() + "Dao";
    }
        
}
