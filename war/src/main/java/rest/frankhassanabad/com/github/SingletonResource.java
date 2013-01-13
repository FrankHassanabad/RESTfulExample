package rest.frankhassanabad.com.github;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Shows an example of using a singleton annotation.
 * This should increment the count based on the total time
 * that the end point is accessed.
 * The root of the query parameters REST API is
 * <pre>
 * http://localhost:8080/rest/singleton
 * </pre>
 */
@Singleton
@Path("singleton")
public class SingletonResource {

    /** Keeps track of the singleton count */
    private int count = 0;

    /**
     * Returns the number of times the endpoint was
     * accessed through
     * <pre>
     * http://localhost:8080/rest/singleton
     * </pre>
     * @return The total number of times this endpoint has been accessed.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        return "Current count of singleton being accessed is:" + count++;
    }
}
