package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 * Shows a simple example of class level injection of
 * the uriInfo through the annotation of {@link Context}.
 * Use this URI to display the absolute and pah of the
 * uri.
 * <pre>
 * http://localhost:8080/rest/uriInjection
 * </pre>
 */
@Path("uriInjection")
public class UriInjection {

    /**
     * The injected uriInfo.
     */
    @Context
    UriInfo uriInfo;

    /**
     * Returns the URI info of absolute and relative path.
     * <pre>
     * http://localhost:8080/rest/uriInjection
     * </pre>
     *
     * @return The URI info of absolute and relative path.
     */
    @GET
    @Produces("text/plain")
    public String getUriInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append("Absolute path:" + uriInfo.getAbsolutePath() + "\n");
        builder.append("path:" + uriInfo.getPath());
        return builder.toString();
    }

    /**
     * Builds a custom Uri and returns that for an example.  The
     * {a} is a variable which is filled by "segment" and the {value}
     * and is another variable which is filled by "value".  Through
     * <pre>
     * http://localhost:8080/rest/uriInjection/custom
     * </pre>
     * You will get back
     * <pre>
     * http://localhost/segment?name=value
     * </pre>
     * @return Returns a custom built URI of "http://localhost/segment?name=value"
     */
    @Path("custom")
    @GET
    @Produces("text/plain")
    public String getCustomBuiltUriInfo() {
        return UriBuilder.fromUri("http://localhost/").
                path("{a}").
                queryParam("name", "{value}").
                build("segment", "value").toASCIIString();
    }
}
