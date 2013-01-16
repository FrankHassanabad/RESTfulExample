package rest.frankhassanabad.com.github;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Example of a singleton resource for in-memory examples of
 * a string resource.
 * For printing all your strings you currently have you would
 * use this URI
 * <pre>
 * http://localhost:8080/rest/resource/strings
 * </pre>
 *
 * To post to this you would post to the URI of
 * <pre>
 * http://localhost:8080/rest/resource/strings/post/single
 * </pre>
 * A simple example of posting would be
 * <pre>
 * Client client = Client.create();
 * WebResource resource = client.resource("http://localhost:8080/rest/resource/strings/post/single");
 * resource.post("A single String with random number of:" + new Random().nextInt());
 * </pre>
 */
@Singleton
@Path("resource/strings")
public class StringPostGetResource {

    /** In memory strings to post into and get from */
    private final Collection<String> strings = new ArrayList<String>();

    /**
     * This is where you post your strings to.  Use the URI of
     * <pre>
     * http://localhost:8080/rest/resource/strings/post/single
     * </pre>
     * @param stringToPost  The string that is posted to this URI
     * @return Return a 201 response which means we accpted it.
     */
    @POST
    @Path("post/single")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response postString(String stringToPost) {
        strings.add(stringToPost);
        return Response.status(201).build();
    }

    /**
     * Returns all the strings that were posted since the
     * server started in textual format separated by a new
     * line character.  You would use this URI to get all
     * the strings that were posted
     * <pre>
     * http://localhost:8080/rest/resource/strings
     * </pre>
     * @return a textual list of strings that were posted.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String printStrings() {
        if (strings.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : strings) {
                stringBuilder.append(string);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        } else {
            return "There are no strings posted yet, size is 0";
        }
    }
}
