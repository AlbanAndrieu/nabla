package com.google.gwt.user.server.rpc.seam;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.seam.core.ConversationPropagation;
import org.jboss.seam.log.LogProvider;
import org.jboss.seam.log.Logging;
import org.jboss.seam.servlet.ContextualHttpServletRequest;
import org.jboss.seam.web.AbstractResource;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCServletUtils;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.server.rpc.SerializationPolicy;
import com.google.gwt.user.server.rpc.SerializationPolicyLoader;
import com.google.gwt.user.server.rpc.SerializationPolicyProvider;
import com.google.gwt.user.server.rpc.impl.ServerSerializationStreamReader;
import com.google.gwt.user.server.rpc.impl.ServerSerializationStreamWriter;

/**
 * Abstract base class for GWT 1.5 integration.
 *
 * @author Shane Bryzak
 */
public abstract class GWTService extends AbstractResource implements SerializationPolicyProvider
{

    public static final String                     DEFAULT_RESOURCE_PATH    = "gwtRpc";

    protected static final LogProvider             log                      = Logging.getLogProvider(GWTService.class);

    /**
     * A cache of moduleBaseURL and serialization policy strong name to
     * {@link SerializationPolicy}.
     */
    private final Map<String, SerializationPolicy> serializationPolicyCache = new HashMap<String, SerializationPolicy>();

    @Override
    public String getResourcePath()
    {
        return "/" + DEFAULT_RESOURCE_PATH;
    }

    protected abstract ServerSerializationStreamReader getStreamReader();

    protected abstract ServerSerializationStreamWriter getStreamWriter();

    protected abstract String createResponse(ServerSerializationStreamWriter stream, Class<?> responseType, Object responseObj, boolean isException);

    // private final Set knownImplementedInterfaces = new HashSet();
    private final ThreadLocal<HttpServletRequest>  perThreadRequest  = new ThreadLocal<HttpServletRequest>();

    private final ThreadLocal<HttpServletResponse> perThreadResponse = new ThreadLocal<HttpServletResponse>();

    /**
     * This is called internally.
     *
     * @see RemoteServiceServlet#doPost
     */
    @Override
    public final void getResource(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            // Store the request & response objects in thread-local storage.
            perThreadRequest.set(request);
            perThreadResponse.set(response);

            new ContextualHttpServletRequest(request)
            {
                @Override
                public void process() throws Exception
                {

                    try
                    {
                        // Read the request fully.
                        //
                        String requestPayload = RemoteServiceServlet_readContent(request);

                        RemoteServiceServlet_onBeforeRequestDeserialized(requestPayload);

                        // Invoke the core dispatching logic, which returns the
                        // serialized result
                        String responsePayload = processCall(requestPayload);

                        RemoteServiceServlet_onAfterResponseSerialized(responsePayload);

                        // Write the response.
                        //
                        RemoteServiceServlet_writeResponse(request, response, responsePayload);
                    }
                    catch (Throwable e)
                    {
                        RemoteServiceServlet_doUnexpectedFailure(e);
                    }
                }

                @Override
                protected void restoreConversationId()
                {
                    ConversationPropagation.instance().setConversationId(GWTService.this.perThreadRequest.get().getParameter("conversationId"));
                }

                @Override
                protected void handleConversationPropagation()
                {
                }
            }.run();
        }
        finally
        {
            perThreadRequest.remove();
            perThreadResponse.remove();
        }
    }

    public String processCall(String payload) throws SerializationException
    {
        try
        {
            SeamRPCRequest rpcRequest = SeamRPC.decodeRequest(payload, this.getClass(), this);

            return SeamRPC.invokeAndEncodeResponse(this, rpcRequest.getMethod(), rpcRequest.getParameterTypes(), rpcRequest.getParameters(), rpcRequest.getSerializationPolicy());
        }
        catch (IncompatibleRemoteServiceException ex)
        {
            getServletContext().log("An IncompatibleRemoteServiceException was thrown while processing this call.", ex);
            return RPC.encodeResponseForFailure(null, ex);
        }
    }

    protected final HttpServletRequest getThreadLocalRequest()
    {
        return perThreadRequest.get();
    }

    protected final HttpServletResponse getThreadLocalResponse()
    {
        return perThreadResponse.get();
    }

    protected void RemoteServiceServlet_onAfterResponseSerialized(String serializedResponse)
    {
    }

    protected void RemoteServiceServlet_onBeforeRequestDeserialized(String serializedRequest)
    {
    }

    protected String RemoteServiceServlet_readContent(HttpServletRequest request) throws ServletException, IOException
    {
        return RPCServletUtils.readContent(request, "text/x-gwt-rpc", "UTF-8");
    }

    public final SerializationPolicy getSerializationPolicy(String moduleBaseURL, String strongName)
    {
        SerializationPolicy serializationPolicy = getCachedSerializationPolicy(moduleBaseURL, strongName);
        if (serializationPolicy != null)
        {
            return serializationPolicy;
        }

        serializationPolicy = doGetSerializationPolicy(getThreadLocalRequest(), moduleBaseURL, strongName);

        if (serializationPolicy == null)
        {
            // Failed to get the requested serialization policy; use the default
            getServletContext().log(
                    "WARNING: Failed to get the SerializationPolicy '" + strongName + "' for module '" + moduleBaseURL
                            + "'; a legacy, 1.3.3 compatible, serialization policy will be used.  You may experience SerializationExceptions as a result.");
            serializationPolicy = RPC.getDefaultSerializationPolicy();
        }

        // This could cache null or an actual instance. Either way we will not
        // attempt to lookup the policy again.
        putCachedSerializationPolicy(moduleBaseURL, strongName, serializationPolicy);

        return serializationPolicy;
    }

    private SerializationPolicy getCachedSerializationPolicy(String moduleBaseURL, String strongName)
    {
        synchronized (serializationPolicyCache)
        {
            return serializationPolicyCache.get(moduleBaseURL + strongName);
        }
    }

    private void putCachedSerializationPolicy(String moduleBaseURL, String strongName, SerializationPolicy serializationPolicy)
    {
        synchronized (serializationPolicyCache)
        {
            serializationPolicyCache.put(moduleBaseURL + strongName, serializationPolicy);
        }
    }

    protected SerializationPolicy doGetSerializationPolicy(HttpServletRequest request, String moduleBaseURL, String strongName)
    {
        // The request can tell you the path of the web app relative to the
        // container root.
        String contextPath = request.getContextPath();

        String modulePath = null;
        if (moduleBaseURL != null)
        {
            try
            {
                modulePath = new URL(moduleBaseURL).getPath();
            }
            catch (MalformedURLException ex)
            {
                // log the information, we will default
                getServletContext().log("Malformed moduleBaseURL: " + moduleBaseURL, ex);
            }
        }

        SerializationPolicy serializationPolicy = null;

        /*
         * Check that the module path must be in the same web app as the servlet
         * itself. If you need to implement a scheme different than this, override
         * this method.
         */
        if (modulePath == null || !modulePath.startsWith(contextPath))
        {
            String message = "ERROR: The module path requested, " + modulePath + ", is not in the same web application as this servlet, " + contextPath
                    + ".  Your module may not be properly configured or your client and server code maybe out of date.";
            getServletContext().log(message);
        } else
        {
            // Strip off the context path from the module base URL. It should be a
            // strict prefix.
            String contextRelativePath = modulePath.substring(contextPath.length());

            String serializationPolicyFilePath = SerializationPolicyLoader.getSerializationPolicyFileName(contextRelativePath + strongName);

            // Open the RPC resource file read its contents.
            InputStream is = getServletContext().getResourceAsStream(serializationPolicyFilePath);
            try
            {
                if (is != null)
                {
                    try
                    {
                        serializationPolicy = SerializationPolicyLoader.loadFromStream(is, null);
                    }
                    catch (ParseException e)
                    {
                        getServletContext().log("ERROR: Failed to parse the policy file '" + serializationPolicyFilePath + "'", e);
                    }
                    catch (IOException e)
                    {
                        getServletContext().log("ERROR: Could not read the policy file '" + serializationPolicyFilePath + "'", e);
                    }
                } else
                {
                    String message = "ERROR: The serialization policy file '" + serializationPolicyFilePath + "' was not found; did you forget to include it in this deployment?";
                    getServletContext().log(message);
                }
            }
            finally
            {
                if (is != null)
                {
                    try
                    {
                        is.close();
                    }
                    catch (IOException e)
                    {
                        // Ignore this error
                    }
                }
            }
        }

        return serializationPolicy;
    }

    private void RemoteServiceServlet_writeResponse(HttpServletRequest request, HttpServletResponse response, String responsePayload) throws IOException
    {
        boolean gzipEncode = RPCServletUtils.acceptsGzipEncoding(request) && shouldCompressResponse(request, response, responsePayload);

        RPCServletUtils.writeResponse(getServletContext(), response, responsePayload, gzipEncode);
    }

    protected void RemoteServiceServlet_doUnexpectedFailure(Throwable e)
    {
        ServletContext servletContext = getServletContext();
        RPCServletUtils.writeResponseForUnexpectedFailure(servletContext, getThreadLocalResponse(), e);
    }

    protected boolean shouldCompressResponse(HttpServletRequest request, HttpServletResponse response, String responsePayload)
    {
        return RPCServletUtils.exceedsUncompressedContentLengthLimit(responsePayload);
    }
}
