package com.gwtplatform.dispatch.server.seam;

import com.google.gwt.user.server.rpc.seam.GWTService;

/**
 * The dispatch configuration of GWT Seam.
 * 
 * @author Florian Sauter
 */
public interface DispatchConfiguration
{

    public static final String DEFAULT_ENDPOINT = "seam/resource/" + GWTService.DEFAULT_RESOURCE_PATH;
    public static final String COMPONENT_NAME   = "gwtpDispatchConfiguration";

    void configureHandlers(HandlerRegistry handlerRegistry);
}
