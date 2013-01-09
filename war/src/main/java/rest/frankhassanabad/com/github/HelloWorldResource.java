package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Point your browser to http://localhost:8080/rest/helloworld
 * and this will return
 * <pre>
 * Hello World! (From within the rest service)
 * </pre>
 */
@Path("/helloworld")
public class HelloWorldResource {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World! (From within the rest service)";
    }
}

