package com.google.web.bindery.requestfactory.server;

import org.jboss.seam.Component;

import com.google.web.bindery.requestfactory.shared.ServiceLocator;

/**
 * A SeamComponentServiceLocator provides instances of a component.
 * 
 * <br/>
 * First define a RequestContex which is using the SeamComponentServiceLocator class as locator.
 * <pre><code>
 * {@literal  @}Service(value = EmployeeRequestService.class, locator = SeamComponentServiceLocator.class)
 * public interface EmployeeRequest extends RequestContext {
 *	  Request<Integer> countEmployees();
 * }
 * </code></pre>
 * 
 * And here a service implementation of the above RequestContext.
 * <pre><code>
 * {@literal  @}Name("employeeRequestService")
 * public class EmployeeRequestService {
 * 
 *   {@literal  @}In(create=true)
 *   EmployeeList employeeList;
 *   
 *   public Integer countEmployees() {
 *     return employeeList.getFullResultList().size();
 *   }
 * }
 * </code></pre>
 * 
 * @author Florian Sauter
 */
public class SeamComponentServiceLocator implements ServiceLocator
{

    @Override
    public Object getInstance(Class<?> clazz)
    {
        Object instantiatedClass = Component.getInstance(clazz);
        if (instantiatedClass == null)
        {
            throw new NullPointerException("Could not instantiate " + clazz.getSimpleName());
        }
        return instantiatedClass;
    }

}
