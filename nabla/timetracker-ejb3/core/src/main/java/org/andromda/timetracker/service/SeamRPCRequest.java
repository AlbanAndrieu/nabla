package org.andromda.timetracker.service;

import java.lang.reflect.Method;

import com.google.gwt.user.server.rpc.SerializationPolicy;

public class SeamRPCRequest
{
    private final java.lang.reflect.Method method;
    private final java.lang.Object[] parameters;
    private final Class[] parameterTypes;
    private final com.google.gwt.user.server.rpc.SerializationPolicy serializationPolicy;

    public SeamRPCRequest(Method method, Object[] parameters,
            Class[] parameterTypes, SerializationPolicy serializationPolicy) {
        this.method = method;
        this.parameters = parameters;
        this.parameterTypes = parameterTypes;
        this.serializationPolicy = serializationPolicy;
    }

    public Method getMethod()
    {
        return method;
    }

    public Object[] getParameters()
    {
        return parameters;
    }

    public Class[] getParameterTypes()
    {
        return parameterTypes;
    }

    public SerializationPolicy getSerializationPolicy()
    {
        return serializationPolicy;
    }
}
