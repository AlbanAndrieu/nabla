package com.google.web.bindery.requestfactory.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.seam.servlet.ContextualHttpServletRequest;

import com.google.web.bindery.requestfactory.server.RequestFactoryServlet;

/**
 * Handles GWT RequestFactory JSON requests and enables seam context.
 * 
 * <p>To get started add the following code to your resources/WEB-INF/web.xml :</p>
 *
 * <pre><code>
 *  &lt;servlet&gt;
 *    &lt;servlet-name&gt;requestFactoryServlet&lt;/servlet-name&gt;
 *    &lt;servlet-class&gt;com.google.web.bindery.requestfactory.server.SeamRequestFactoryServlet&lt;/servlet-class&gt;
 *  &lt;/servlet&gt;
 *
 *  &lt;servlet-mapping&gt;
 *    &lt;servlet-name&gt;requestFactoryServlet&lt;/servlet-name&gt;
 *    &lt;url-pattern&gt;/gwtRequest&lt;/url-pattern&gt;
 *  &lt;/servlet-mapping&gt;
 * </code></pre>
 * 
 * @author Florian Sauter
 */
public class SeamRequestFactoryServlet extends RequestFactoryServlet
{

    private static final long serialVersionUID = 2843238850372093620L;

    @Override
    protected void service(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        new ContextualHttpServletRequest(request)
        {
            @Override
            public void process() throws Exception
            {
                doWork(request, response);
            }
        }.run();
    }

    private void doWork(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        super.service(request, response);
    }
}
