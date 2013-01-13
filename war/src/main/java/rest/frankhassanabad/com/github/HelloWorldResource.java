package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Point your browser to http://localhost:8080/rest/helloworld
 * and this will return
 * <pre>
 * Hello World! (From within the rest service)
 * </pre>
 */
@Path("/helloworld")
public class HelloWorldResource {

    /**
     * The Java method will process HTTP GET requests from
     * the URL  http://localhost:8080/rest/helloworld
     * The Java method will produce content identified by the MIME Media
     * type "text/plain"
     * @return A Hello World string
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World! (From within the rest service)";
    }
}

