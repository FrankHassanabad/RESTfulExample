package rest.frankhassanabad.com.github;

import com.sun.jersey.spi.container.servlet.PerSession;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Shows an example of using a per session annotation.
 * This should only increment the count based on the session
 * and reset to zero when there's a new session.
 * The root of the query parameters REST API is
 * <pre>
 * http://localhost:8080/rest/session
 * </pre>
 */
@PerSession
@Path("session")
public class SessionResource {

    /** Keeps track of the session count */
    private int count = 0;

    /**
     * Returns the number of times the session was
     * accessed through
     * <pre>
     * http://localhost:8080/rest/session
     * </pre>
     * @return The session count.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        return "Current count of session being accessed is:" + count++;
    }
}
