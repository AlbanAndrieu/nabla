package org.andromda.timetracker.server;

import org.andromda.timetracker.client.GreetingService;
import org.andromda.timetracker.shared.FieldVerifier;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.remoting.WebRemote;

/**
 * The server side implementation of the RPC service.
 */
@Name("org.andromda.timetracker.client.GreetingService")
public class GreetingServiceImpl implements GreetingService
{

    @Override
    @WebRemote
    public String greetServer(String input) throws IllegalArgumentException
    {
        // Verify that the input is valid.
        if (!FieldVerifier.isValidName(input))
        {
            // If the input is not valid, throw an IllegalArgumentException back to
            // the client.
            throw new IllegalArgumentException("Name must be at least 4 characters long");
        }

        // Escape data from the client to avoid cross-site script vulnerabilities.
        input = escapeHtml(input);

        return "Hello, " + input + "!<br><br>I am running JBoss" + ".<br><br>It looks like you are using:<br> A BROWSER";
    }

    /**
     * Escape an html string. Escaping data received from the client helps to
     * prevent cross-site script vulnerabilities.
     * 
     * @param html the html string to escape
     * @return the escaped string
     */
    private String escapeHtml(String html)
    {
        if (html == null)
        {
            return null;
        }
        return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}
