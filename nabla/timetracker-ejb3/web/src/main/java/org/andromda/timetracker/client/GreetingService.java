package org.andromda.timetracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("../seam/resource/gwt2")
public interface GreetingService extends RemoteService {
    String greetServer(String name) throws IllegalArgumentException;
}
