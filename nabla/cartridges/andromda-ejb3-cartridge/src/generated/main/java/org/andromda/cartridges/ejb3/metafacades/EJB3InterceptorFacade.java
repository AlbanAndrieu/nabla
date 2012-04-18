// license-header java merge-point
//
// Attention: generated code (by Metafacade.vsl) - do not modify!
//
package org.andromda.cartridges.ejb3.metafacades;

import java.util.Collection;
import org.andromda.metafacades.uml.Service;

/**
 * 
 *
 * Metafacade interface to be used by AndroMDA cartridges.
 */
public interface EJB3InterceptorFacade
    extends Service
{
    /**
     * Indicates the metafacade type (used for metafacade mappings).
     *
     * @return boolean always <code>true</code>
     */
    public boolean isEJB3InterceptorFacadeMetaType();

    /**
     * Returns the fully qualified interceptor class name.
     * @return String
     */
    public String getFullyQualifiedInterceptorName();

    /**
     * Returns the interceptor class name.
     * @return String
     */
    public String getInterceptorName();

    /**
     * Returns the Collection of target elements from this interceptor class where  the target class
     * has a stereotype of Interceptor.
     * @return Collection
     */
    public Collection getInterceptorReferences();

    /**
     * Returns true if this interceptor is a default interceptor.
     * @return boolean
     */
    public boolean isDefaultInterceptor();
}