/*
 * Copyright (c) 2002-2004, Nabla
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Nabla' nor 'Alban' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package org.andromda.cartridges.ejb3.metafacades;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;
import org.andromda.cartridges.ejb3.EJB3Globals;
import org.andromda.cartridges.ejb3.EJB3Profile;
import org.andromda.metafacades.uml.EntityAttribute;
import org.andromda.metafacades.uml.ModelElementFacade;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.andromda.metafacades.uml.UMLMetafacadeProperties;

/**
 * MetafacadeLogic implementation for org.andromda.cartridges.ejb3.metafacades.EJB3ManageableEntityFacade.
 * 
 * @see EJB3ManageableEntityFacade
 */
public class EJB3ManageableEntityFacadeLogicImpl extends EJB3ManageableEntityFacadeLogic
{
    private static final long  serialVersionUID                     = 34L;
    /**
     * The property which stores the pattern defining the manageable create exception name.
     */
    public static final String CREATE_EXCEPTION_NAME_PATTERN        = "manageableCreateExceptionNamePattern";

    /**
     * The property which stores the pattern defining the manageable read exception name.
     */
    public static final String READ_EXCEPTION_NAME_PATTERN          = "manageableReadExceptionNamePattern";

    /**
     * The property which stores the pattern defining the manageable update exception name.
     */
    public static final String UPDATE_EXCEPTION_NAME_PATTERN        = "manageableUpdateExceptionNamePattern";

    /**
     * The property which stores the pattern defining the manageable delete exception name.
     */
    public static final String DELETE_EXCEPTION_NAME_PATTERN        = "manageableDeleteExceptionNamePattern";

    /**
     * The property that stores the JNDI name prefix.
     */
    public static final String SERVICE_JNDI_NAME_PREFIX             = "jndiNamePrefix";

    /**
     * The property that stores the manageable service base name pattern
     */
    public static final String MANAGEABLE_SERVICE_BASE_NAME_PATTERN = "manageableServiceBaseNamePattern";

    /**
     * Constructor
     * 
     * @param metaObject
     * @param context
     */
    public EJB3ManageableEntityFacadeLogicImpl(final Object metaObject, final String context)
    {
        super(metaObject, context);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableServiceCreateExceptionName()
     */
    @Override
    protected String handleGetManageableServiceCreateExceptionName()
    {
        String exceptionNamePattern = (String) this.getConfiguredProperty(CREATE_EXCEPTION_NAME_PATTERN);

        return MessageFormat.format(exceptionNamePattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetFullyQualifiedManageableServiceCreateExceptionName()
     */
    @Override
    protected String handleGetFullyQualifiedManageableServiceCreateExceptionName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getManageablePackageName(), this.getManageableServiceCreateExceptionName(), null);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableServiceReadExceptionName()
     */
    @Override
    protected String handleGetManageableServiceReadExceptionName()
    {
        String exceptionNamePattern = (String) this.getConfiguredProperty(READ_EXCEPTION_NAME_PATTERN);

        return MessageFormat.format(exceptionNamePattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetFullyQualifiedManageableServiceReadExceptionName()
     */
    @Override
    protected String handleGetFullyQualifiedManageableServiceReadExceptionName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getManageablePackageName(), this.getManageableServiceReadExceptionName(), null);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableServiceUpdateExceptionName()
     */
    @Override
    protected String handleGetManageableServiceUpdateExceptionName()
    {
        String exceptionNamePattern = (String) this.getConfiguredProperty(UPDATE_EXCEPTION_NAME_PATTERN);

        return MessageFormat.format(exceptionNamePattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetFullyQualifiedManageableServiceUpdateExceptionName()
     */
    @Override
    protected String handleGetFullyQualifiedManageableServiceUpdateExceptionName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getManageablePackageName(), this.getManageableServiceUpdateExceptionName(), null);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableServiceDeleteExceptionName()
     */
    @Override
    protected String handleGetManageableServiceDeleteExceptionName()
    {
        String exceptionNamePattern = (String) this.getConfiguredProperty(DELETE_EXCEPTION_NAME_PATTERN);

        return MessageFormat.format(exceptionNamePattern, StringUtils.trimToEmpty(this.getName()));
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetFullyQualifiedManageableServiceDeleteExceptionName()
     */
    @Override
    protected String handleGetFullyQualifiedManageableServiceDeleteExceptionName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getManageablePackageName(), this.getManageableServiceDeleteExceptionName(), null);
    }

    /**
     * @return getConfiguredProperty(EJB3Globals.PERSISTENCE_CONTEXT_UNIT_NAME)
     * @see EJB3EntityFacadeLogic#handleGetDefaultPersistenceContextUnitName()
     */
    protected String handleGetDefaultPersistenceContextUnitName()
    {
        return StringUtils.trimToEmpty(ObjectUtils.toString(this.getConfiguredProperty(EJB3Globals.PERSISTENCE_CONTEXT_UNIT_NAME)));
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetJndiNamePrefix()
     */
    @Override
    protected String handleGetJndiNamePrefix()
    {
        return this.isConfiguredProperty(SERVICE_JNDI_NAME_PREFIX) ? ObjectUtils.toString(this.getConfiguredProperty(SERVICE_JNDI_NAME_PREFIX)) : null;
    }

    /**
     * @see EJB3SessionFacadeLogic#handleGetJndiNameRemote()
     */
    /*
     * @Override
     * protected String handleGetJndiNameRemote()
     * {
     * String jndiName = (String)this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_SESSION_JNDI_NAME_REMOTE);
     * if (StringUtils.isNotBlank(jndiName))
     * {
     * jndiName = this.getJndiNamePrefix() + "/" + jndiName;
     * }
     * return jndiName;
     * }
     */

    /**
     * @see EJB3SessionFacadeLogic#handleGetJndiNameLocal()
     */
    /*
     * @Override
     * protected String handleGetJndiNameLocal()
     * {
     * String jndiName = (String)this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_SESSION_JNDI_NAME_Local);
     * if (StringUtils.isNotBlank(jndiName))
     * {
     * jndiName = this.getJndiNamePrefix() + "/" + jndiName;
     * }
     * return jndiName;
     * }
     */

    /**
     * @see EJB3SessionFacade#isStateful()
     */
    /*
     * @Override
     * protected boolean handleIsStateful()
     * {
     * boolean isStateful = false;
     * String sessionType = (String)this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_SESSION_TYPE);
     * if (StringUtils.isBlank(sessionType))
     * {
     * isStateful = !isStateless();
     * }
     * else
     * {
     * isStateful = sessionType.equalsIgnoreCase(EJB3Globals.SERVICE_TYPE_STATEFUL);
     * }
     * return isStateful;
     * }
     */

    /**
     * @see EJB3SessionFacade#isStateless()
     */
    // @Override
    // protected boolean handleIsStateless()
    /*
     * protected boolean isStateless()
     * {
     * boolean isStateless = false;
     * String sessionType = (String)this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_SESSION_TYPE);
     * if (StringUtils.isBlank(sessionType))
     * {
     * isStateless =
     * this.getAllInstanceAttributes() == null ||
     * this.filterSeamAttributes(this.getAllInstanceAttributes()).isEmpty();
     * }
     * else
     * {
     * isStateless = sessionType.equalsIgnoreCase(EJB3Globals.SERVICE_TYPE_STATELESS);
     * }
     * return isStateless;
     * }
     */

    /**
     * @see EJB3SessionFacade#getType()
     */
    /*
     * @Override
     * protected String handleGetType()
     * {
     * String sessionType = (String)this.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_SESSION_TYPE);
     * if (StringUtils.isBlank(sessionType))
     * {
     * sessionType = "Stateful";
     * if (this.isStateless())
     * {
     * sessionType = "Stateless";
     * }
     * }
     * return sessionType;
     * }
     */

    /**
     * @see EJB3SessionFacade#getViewType()
     */
    /*
     * @Override
     * protected String handleGetViewType()
     * {
     * String viewType = EJB3MetafacadeUtils.getViewType(this,
     * String.valueOf(this.getConfiguredProperty(SERVICE_DEFAULT_VIEW_TYPE)));
     */
    /**
     * Check all session bean operations.
     * If session view type is remote, check for operations with view type local and return both.
     * If session view type is local, check for operations with view type remote and return both.
     * Otherwise session view type is both, return both.
     * NOTE: do not invoke viewType on EJB3SessionOperationFacade to avoid cyclic dependency and throwing
     * StackOverFlowError.
     */
    /*
     * if (viewType.equalsIgnoreCase(EJB3Globals.VIEW_TYPE_LOCAL))
     * {
     * boolean operationWithRemoteViewExists =
     * CollectionUtils.exists(
     * this.getBusinessOperations(),
     * new Predicate()
     * {
     * public boolean evaluate(Object object)
     * {
     * EJB3SessionOperationFacade operation = (EJB3SessionOperationFacade)object;
     * String operationViewType =
     * String.valueOf(operation.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_VIEWTYPE));
     * if (operationViewType.equalsIgnoreCase(EJB3Globals.VIEW_TYPE_REMOTE) ||
     * operationViewType.equalsIgnoreCase(EJB3Globals.VIEW_TYPE_BOTH))
     * {
     * return true;
     * }
     * else
     * {
     * return false;
     * }
     * }
     * });
     * viewType = (operationWithRemoteViewExists ? EJB3Globals.VIEW_TYPE_BOTH : viewType);
     * }
     * else if (viewType.equalsIgnoreCase(EJB3Globals.VIEW_TYPE_REMOTE))
     * {
     * boolean operationWithLocalViewExists =
     * CollectionUtils.exists(
     * this.getBusinessOperations(),
     * new Predicate()
     * {
     * public boolean evaluate(Object object)
     * {
     * EJB3SessionOperationFacade operation = (EJB3SessionOperationFacade)object;
     * String operationViewType =
     * String.valueOf(operation.findTaggedValue(EJB3Profile.TAGGEDVALUE_EJB_VIEWTYPE));
     * if (operationViewType.equalsIgnoreCase(EJB3Globals.VIEW_TYPE_LOCAL) ||
     * operationViewType.equalsIgnoreCase(EJB3Globals.VIEW_TYPE_BOTH))
     * {
     * return true;
     * }
     * else
     * {
     * return false;
     * }
     * }
     * });
     * viewType = (operationWithLocalViewExists ? EJB3Globals.VIEW_TYPE_BOTH : viewType);
     * }
     * return viewType;
     * }
     */

    /**
     * @see EJB3SessionFacadeLogic#handleIsViewTypeLocal()
     */
    /*
     * @Override
     * protected boolean handleIsViewTypeLocal()
     * {
     * boolean isLocal = false;
     * if (this.getViewType().equalsIgnoreCase(EJB3Globals.VIEW_TYPE_LOCAL) || this.isViewTypeBoth() ||
     * this.isSeamComponent())
     * {
     * isLocal = true;
     * }
     * return isLocal;
     * }
     */

    /**
     * @see EJB3SessionFacadeLogic#handleIsViewTypeRemote()
     */
    /*
     * @Override
     * protected boolean handleIsViewTypeRemote()
     * {
     * boolean isRemote = false;
     * if (this.getViewType().equalsIgnoreCase(EJB3Globals.VIEW_TYPE_REMOTE) || this.isViewTypeBoth())
     * {
     * isRemote = true;
     * }
     * return isRemote;
     * }
     */

    /**
     * @see EJB3SessionFacadeLogic#handleIsViewTypeBoth()
     */
    /*
     * @Override
     * protected boolean handleIsViewTypeBoth()
     * {
     * boolean isBoth = false;
     * if (this.getViewType().equalsIgnoreCase(EJB3Globals.VIEW_TYPE_BOTH))
     * {
     * isBoth = true;
     * }
     * return isBoth;
     * }
     */

    /**
     * @see EJB3SessionFacadeLogic#handleIsViewTypeStrictlyLocal()
     */
    /*
     * @Override
     * protected boolean handleIsViewTypeStrictlyLocal()
     * {
     * boolean isViewTypeStrictlyLocal = false;
     * String viewType = EJB3MetafacadeUtils.getViewType(this,
     * String.valueOf(this.getConfiguredProperty(SERVICE_DEFAULT_VIEW_TYPE)));
     * if (StringUtils.equalsIgnoreCase(viewType, EJB3Globals.VIEW_TYPE_LOCAL) ||
     * StringUtils.equalsIgnoreCase(viewType, EJB3Globals.VIEW_TYPE_BOTH))
     * {
     * isViewTypeStrictlyLocal = true;
     * }
     * return isViewTypeStrictlyLocal;
     * }
     */

    /**
     * @see EJB3SessionFacadeLogic#handleIsViewTypeStrictlyRemote()
     */
    /*
     * @Override
     * protected boolean handleIsViewTypeStrictlyRemote()
     * {
     * boolean isViewTypeStrictlyRemote = false;
     * String viewType = EJB3MetafacadeUtils.getViewType(this,
     * String.valueOf(this.getConfiguredProperty(SERVICE_DEFAULT_VIEW_TYPE)));
     * if (StringUtils.equalsIgnoreCase(viewType, EJB3Globals.VIEW_TYPE_REMOTE) ||
     * StringUtils.equalsIgnoreCase(viewType, EJB3Globals.VIEW_TYPE_BOTH))
     * {
     * isViewTypeStrictlyRemote = true;
     * }
     * return isViewTypeStrictlyRemote;
     * }
     */

    /**
     * @see EJB3SessionFacadeLogic#handleIsViewTypeStrictlyBoth()
     */
    /*
     * @Override
     * protected boolean handleIsViewTypeStrictlyBoth()
     * {
     * boolean isViewTypeStrictlyBoth = false;
     * String viewType = EJB3MetafacadeUtils.getViewType(this,
     * String.valueOf(this.getConfiguredProperty(SERVICE_DEFAULT_VIEW_TYPE)));
     * if (StringUtils.equalsIgnoreCase(viewType, EJB3Globals.VIEW_TYPE_BOTH))
     * {
     * isViewTypeStrictlyBoth = true;
     * }
     * return isViewTypeStrictlyBoth;
     * }
     */

    /**
     * @see EJB3SessionFacade#getHomeInterfaceName()
     */
    /*
     * @Override
     * protected String handleGetHomeInterfaceName()
     * {
     * return EJB3MetafacadeUtils.getHomeInterfaceName(this);
     * }
     */

    /**
     * @see EJB3SessionFacade#getTransactionType()
     */
    /*
     * @Override
     * protected String handleGetTransactionType()
     * {
     * return EJB3MetafacadeUtils.getTransactionType(this, null);
     * }
     */

    /**
     * @return the configured property denoting the character sequence to use for the separation of namespaces
     */
    private String getNamespaceProperty()
    {
        return (String) getConfiguredProperty(UMLMetafacadeProperties.NAMESPACE_SEPARATOR);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetDaoReferenceName()
     */
    protected String handleGetDaoReferenceName()
    {
        return StringUtils.uncapitalize(getName()) + "Dao";
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableDaoName()
     */
    protected String handleGetManageableDaoName()
    {
        return getName() + "ManageableDao";
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetFullyQualifiedManageableDaoName()
     */
    protected String handleGetFullyQualifiedManageableDaoName()
    {
        return getManageablePackageName() + getNamespaceProperty() + getManageableDaoName();
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableDaoFullPath()
     */
    protected String handleGetManageableDaoFullPath()
    {
        return StringUtils.replace(this.getFullyQualifiedManageableDaoName(), getNamespaceProperty(), "/");
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableDaoBaseName()
     */
    protected String handleGetManageableDaoBaseName()
    {
        return getManageableDaoName() + "Base";
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetFullyQualifiedManageableDaoBaseName()
     */
    protected String handleGetFullyQualifiedManageableDaoBaseName()
    {
        return getManageablePackageName() + getNamespaceProperty() + getManageableDaoBaseName();
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableDaoBaseFullPath()
     */
    protected String handleGetManageableDaoBaseFullPath()
    {
        return StringUtils.replace(this.getFullyQualifiedManageableDaoBaseName(), this.getNamespaceProperty(), "/");
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableServiceBaseName()
     */
    @Override
    protected String handleGetManageableServiceBaseName()
    {
        String exceptionNamePattern = (String) this.getConfiguredProperty(MANAGEABLE_SERVICE_BASE_NAME_PATTERN);

        return MessageFormat.format(exceptionNamePattern, StringUtils.trimToEmpty(this.getManageableServiceName()));
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetFullyQualifiedManageableServiceBaseName()
     */
    @Override
    protected String handleGetFullyQualifiedManageableServiceBaseName()
    {
        return EJB3MetafacadeUtils.getFullyQualifiedName(this.getManageablePackageName(), this.getManageableServiceBaseName(), null);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableServiceBaseFullPath()
     */
    protected String handleGetManageableServiceBaseFullPath()
    {
        return StringUtils.replace(this.getFullyQualifiedManageableServiceBaseName(), this.getNamespaceProperty(), "/");
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableValueObjectFullPath()
     */
    protected String handleGetManageableValueObjectFullPath()
    {
        return StringUtils.replace(this.getFullyQualifiedManageableValueObjectName(), this.getNamespaceProperty(), "/");
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableValueObjectClassName()
     */
    protected String handleGetManageableValueObjectClassName()
    {
        return getName() + this.getConfiguredProperty(EJB3Globals.CRUD_VALUE_OBJECT_SUFFIX);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetFullyQualifiedManageableValueObjectName()
     */
    protected String handleGetFullyQualifiedManageableValueObjectName()
    {
        return getManageablePackageName() + getNamespaceProperty() + getManageableValueObjectClassName();
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#handleGetManageableRolesAllowed()
     */
    @Override
    protected String handleGetManageableRolesAllowed()
    {
        StringBuilder rolesAllowed = null;
        String[] roles = StringUtils.split(StringUtils.trimToEmpty(ObjectUtils.toString(this.getConfiguredProperty(EJB3Globals.MANAGEABLE_ROLES_ALLOWED))), ',');
        String separator = "";

        for (int i = 0; i < roles.length; i++)
        {
            if (rolesAllowed == null)
            {
                rolesAllowed = new StringBuilder();
            }
            rolesAllowed.append(separator);
            rolesAllowed.append('"');
            rolesAllowed.append(roles[i]);
            rolesAllowed.append('"');
            separator = ", ";
        }
        return rolesAllowed != null ? rolesAllowed.toString() : null;
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#getIdentifier()
     * Override the implementation in EJB3EntityFacade as UML2 models cannot retrieve the identifier via the
     * super EJB3EntityFacade.
     */
    @Override
    public EJB3EntityAttributeFacade getIdentifier()
    {

        return (EJB3EntityAttributeFacade) super.getIdentifiers().iterator().next();

    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#getAllInstanceAttributes()
     * Override the implementation in EJB3EntityFacade as UML2 models will not get an
     * EJB3ManageableEntityAttributeFacade when retrieving the attributes.
     */
    @Override
    public List getAllInstanceAttributes()
    {
        return EJB3MetafacadeUtils.getAllInstanceAttributes(this);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#getInheritedInstanceAttributes()
     * Override the implementation in EJB3EntityFacade as UML2 models will not get an
     * EJB3ManageableEntityAttributeFacade when retrieving the attributes.
     */
    @Override
    public List getInheritedInstanceAttributes()
    {
        return EJB3MetafacadeUtils.getInheritedInstanceAttributes(this);
    }

    /**
     * @see EJB3ManageableEntityFacadeLogic#getInstanceAttributes(boolean, boolean)
     * Override the implementation in EJB3EntityFacade as UML2 models will not get an
     * EJB3ManageableEntityAttributeFacade when retrieving the attributes.
     */
    @Override
    public Collection getInstanceAttributes(final boolean follow, final boolean withIdentifiers)
    {
        final Collection attributes = this.getAttributes(follow, withIdentifiers);
        CollectionUtils.filter(attributes, new Predicate()
        {
            public boolean evaluate(final Object object)
            {
                boolean valid = true;
                if (object instanceof EntityAttribute)
                {
                    valid = !((EntityAttribute) object).isStatic();
                }
                return valid;
            }
        });
        return attributes;
    }
}
