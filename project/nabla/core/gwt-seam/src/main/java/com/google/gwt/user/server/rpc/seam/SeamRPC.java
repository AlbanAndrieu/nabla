package com.google.gwt.user.server.rpc.seam;

import com.google.gwt.user.server.rpc.SerializationPolicyProvider;
import com.google.gwt.user.server.rpc.SerializationPolicy;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.impl.ServerSerializationStreamReader;
import com.google.gwt.user.server.rpc.impl.TypeNameObfuscator;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.impl.AbstractSerializationStream;

import java.util.HashMap;
import java.util.Arrays;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * RPC.
 *
 * @author <a href="mailto:sninsky@bgs.sk">Radovan Sninsky</a>
 * @version $Revision $ $Date $
 * @since 1.0, 28.10.2009 22:25:11
 */
public final class SeamRPC
{

    private static final HashMap<String, Class<?>> TYPE_NAMES;

    static
    {
        TYPE_NAMES = new HashMap<String, Class<?>>();
        TYPE_NAMES.put("Z", boolean.class);
        TYPE_NAMES.put("B", byte.class);
        TYPE_NAMES.put("C", char.class);
        TYPE_NAMES.put("D", double.class);
        TYPE_NAMES.put("F", float.class);
        TYPE_NAMES.put("I", int.class);
        TYPE_NAMES.put("J", long.class);
        TYPE_NAMES.put("S", short.class);
    }

    public static SeamRPCRequest decodeRequest(String encodedRequest, Class<?> type, SerializationPolicyProvider serializationPolicyProvider)
    {
        if (encodedRequest == null)
        {
            throw new NullPointerException("encodedRequest cannot be null");
        }

        if (encodedRequest.length() == 0)
        {
            throw new IllegalArgumentException("encodedRequest cannot be empty");
        }

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try
        {
            ServerSerializationStreamReader streamReader = new ServerSerializationStreamReader(classLoader, serializationPolicyProvider);
            streamReader.prepareToRead(encodedRequest);

            // Read the name of the RemoteService interface
            String serviceIntfName = maybeDeobfuscate(streamReader, streamReader.readString());

            // if (type != null) {
            // if (!implementsInterface(type, serviceIntfName)) {
            // // The service does not implement the requested interface
            // throw new IncompatibleRemoteServiceException(
            // "Blocked attempt to access interface '" + serviceIntfName
            // + "', which is not implemented by '" + printTypeName(type)
            // + "'; this is either misconfiguration or a hack attempt");
            // }
            // }

            SerializationPolicy serializationPolicy = streamReader.getSerializationPolicy();
            Class<?> serviceIntf;
            try
            {
                serviceIntf = getClassFromSerializedName(serviceIntfName, classLoader);
                if (!RemoteService.class.isAssignableFrom(serviceIntf))
                {
                    // The requested interface is not a RemoteService interface
                    throw new IncompatibleRemoteServiceException("Blocked attempt to access interface '" + printTypeName(serviceIntf)
                            + "', which doesn't extend RemoteService; this is either misconfiguration or a hack attempt");
                }
            }
            catch (ClassNotFoundException e)
            {
                throw new IncompatibleRemoteServiceException("Could not locate requested interface '" + serviceIntfName + "' in default classloader", e);
            }

            String serviceMethodName = streamReader.readString();

            int paramCount = streamReader.readInt();
            if (paramCount > streamReader.getNumberOfTokens())
            {
                throw new IncompatibleRemoteServiceException("Invalid number of parameters");
            }
            Class<?>[] parameterTypes = new Class[paramCount];

            for (int i = 0; i < parameterTypes.length; i++)
            {
                String paramClassName = maybeDeobfuscate(streamReader, streamReader.readString());
                try
                {
                    parameterTypes[i] = getClassFromSerializedName(paramClassName, classLoader);
                }
                catch (ClassNotFoundException e)
                {
                    throw new IncompatibleRemoteServiceException("Parameter " + i + " of is of an unknown type '" + paramClassName + "'", e);
                }
            }

            try
            {
                Method method = serviceIntf.getMethod(serviceMethodName, parameterTypes);

                Object[] parameterValues = new Object[parameterTypes.length];
                for (int i = 0; i < parameterValues.length; i++)
                {
                    parameterValues[i] = streamReader.deserializeValue(parameterTypes[i]);
                }

                return new SeamRPCRequest(method, parameterValues, parameterTypes, serializationPolicy);
            }
            catch (NoSuchMethodException e)
            {
                throw new IncompatibleRemoteServiceException(formatMethodNotFoundErrorMessage(serviceIntf, serviceMethodName, parameterTypes));
            }
        }
        catch (SerializationException ex)
        {
            throw new IncompatibleRemoteServiceException(ex.getMessage(), ex);
        }
    }

    private static Class<?> getClassFromSerializedName(String serializedName, ClassLoader classLoader) throws ClassNotFoundException
    {
        Class<?> value = TYPE_NAMES.get(serializedName);
        if (value != null)
        {
            return value;
        }

        return Class.forName(serializedName, false, classLoader);
    }

    public static String invokeAndEncodeResponse(Object target, Method serviceMethod, Class<?>[] paramTypes, Object[] args, SerializationPolicy serializationPolicy) throws SerializationException
    {
        if (serviceMethod == null)
        {
            throw new NullPointerException("serviceMethod");
        }

        if (serializationPolicy == null)
        {
            throw new NullPointerException("serializationPolicy");
        }

        String responsePayload;
        try
        {
            GWTToSeamAdapter adapter = GWTToSeamAdapter.instance();

            String serviceIntfName = serviceMethod.getDeclaringClass().getName();

            GWTToSeamAdapter.ReturnedObject returnedObject = adapter.callWebRemoteMethod(serviceIntfName, serviceMethod.getName(), paramTypes, args);

            // Object result = serviceMethod.invoke(target, args);

            responsePayload = RPC.encodeResponseForSuccess(serviceMethod, returnedObject.returnedObject, serializationPolicy);
        }
        catch (IllegalAccessException e)
        {
            SecurityException securityException = new SecurityException(formatIllegalAccessErrorMessage(target, serviceMethod));
            securityException.initCause(e);
            throw securityException;
        }
        catch (IllegalArgumentException e)
        {
            SecurityException securityException = new SecurityException(formatIllegalArgumentErrorMessage(target, serviceMethod, args));
            securityException.initCause(e);
            throw securityException;
        }
        catch (InvocationTargetException e)
        {
            // Try to encode the caught exception
            //
            Throwable cause = e.getCause();

            responsePayload = RPC.encodeResponseForFailure(serviceMethod, cause, serializationPolicy);
        }

        return responsePayload;
    }

    private static String formatMethodNotFoundErrorMessage(Class<?> serviceIntf, String serviceMethodName, Class<?>[] parameterTypes)
    {
        StringBuffer sb = new StringBuffer();

        sb.append("Could not locate requested method '");
        sb.append(serviceMethodName);
        sb.append("(");
        for (int i = 0; i < parameterTypes.length; ++i)
        {
            if (i > 0)
            {
                sb.append(", ");
            }
            sb.append(printTypeName(parameterTypes[i]));
        }
        sb.append(")'");

        sb.append(" in interface '");
        sb.append(printTypeName(serviceIntf));
        sb.append("'");

        return sb.toString();
    }

    private static String formatIllegalAccessErrorMessage(Object target, Method serviceMethod)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Blocked attempt to access inaccessible method '");
        sb.append(getSourceRepresentation(serviceMethod));
        sb.append("'");

        if (target != null)
        {
            sb.append(" on target '");
            sb.append(printTypeName(target.getClass()));
            sb.append("'");
        }

        sb.append("; this is either misconfiguration or a hack attempt");

        return sb.toString();
    }

    private static String formatIllegalArgumentErrorMessage(Object target, Method serviceMethod, Object[] args)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Blocked attempt to invoke method '");
        sb.append(getSourceRepresentation(serviceMethod));
        sb.append("'");

        if (target != null)
        {
            sb.append(" on target '");
            sb.append(printTypeName(target.getClass()));
            sb.append("'");
        }

        sb.append(" with invalid arguments");

        if (args != null && args.length > 0)
        {
            sb.append(Arrays.asList(args));
        }

        return sb.toString();
    }

    private static String getSourceRepresentation(Method method)
    {
        return method.toString().replace('$', '.');
    }

    private static String maybeDeobfuscate(ServerSerializationStreamReader streamReader, String name) throws SerializationException
    {
        int index;
        if (streamReader.hasFlags(AbstractSerializationStream.FLAG_ELIDE_TYPE_NAMES))
        {
            SerializationPolicy serializationPolicy = streamReader.getSerializationPolicy();
            if (!(serializationPolicy instanceof TypeNameObfuscator))
            {
                throw new IncompatibleRemoteServiceException("RPC request was encoded with obfuscated type names, " + "but the SerializationPolicy in use does not implement " + TypeNameObfuscator.class.getName());
            }

            String maybe = ((TypeNameObfuscator) serializationPolicy).getClassNameForTypeId(name);
            if (maybe != null)
            {
                return maybe;
            }
        } else if ((index = name.indexOf('/')) != -1)
        {
            return name.substring(0, index);
        }
        return name;
    }

    private static String printTypeName(Class<?> type)
    {
        // Primitives
        //
        if (type.equals(Integer.TYPE))
        {
            return "int";
        } else if (type.equals(Long.TYPE))
        {
            return "long";
        } else if (type.equals(Short.TYPE))
        {
            return "short";
        } else if (type.equals(Byte.TYPE))
        {
            return "byte";
        } else if (type.equals(Character.TYPE))
        {
            return "char";
        } else if (type.equals(Boolean.TYPE))
        {
            return "boolean";
        } else if (type.equals(Float.TYPE))
        {
            return "float";
        } else if (type.equals(Double.TYPE))
        {
            return "double";
        }

        // Arrays
        //
        if (type.isArray())
        {
            Class<?> componentType = type.getComponentType();
            return printTypeName(componentType) + "[]";
        }

        // Everything else
        //
        return type.getName().replace('$', '.');
    }
}
