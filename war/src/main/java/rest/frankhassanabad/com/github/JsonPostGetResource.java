package rest.frankhassanabad.com.github;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Example of a singleton resource for in-memory examples of
 * a JSON resource.
 * For printing your json object you currently have you would
 * use this URI
 * <pre>
 * http://localhost:8080/rest/resource/json
 * </pre>
 *
 * To post to this you would post to the URI of
 * <pre>
 * http://localhost:8080/rest/resource/json/post/single
 * </pre>
 * A simple example of posting would be
 * <pre>
 * //Create our JSON object for serialization
 * Random random = new Random();
 * JsonObject jsonObject = new JsonObject();
 * jsonObject.setDoubleAttribute(random.nextDouble());
 * jsonObject.setIntegerAttribute(random.nextInt());
 * jsonObject.setStringAttribute("Serialization object using a custom string that I am utilizing");
 *
 * //Post it
 * response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonObject);
 * status = response.getStatus();
 * </pre>
 */
@Path("resource/json")
@Singleton
public class JsonPostGetResource {

    /**
     * Our internal json object we hold onto.
     */
    private JsonObject jsonObject;

    /**
     * Default constructor where we create a default
     * JSON object to begin with for the get calls.
     */
    public JsonPostGetResource() {
        jsonObject = new JsonObject();
        jsonObject.setStringAttribute("Setting this string attribute to this");
        jsonObject.setIntegerAttribue(0);
        jsonObject.setDoubleAttribute(1.5);
    }

    /**
     * Return the JSON object where it is automatically
     * serialized by Jersey into a string.  You would go
     * to this URI
     * <pre>
     * http://localhost:8080/rest/resource/json
     * </pre>
     * to see the object in memory
     * @return The JSON object where it will be serialized
     * automatically for us.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonObject getJsonObject() {
        return jsonObject;
    }

    /**
     * Post the JSON object where the string is automatically
     * serialized by Jersey into a JsonObject.
     * @param postObject The JSON object serialized for us into
     * our json object.
     * @return Return a 201 response which means we created it.
     */
    @POST
    @Path("/post/single")
    public Response setJsonObject(JsonObject postObject) {
        jsonObject = new JsonObject(postObject);
        return Response.status(201).build();
    }

}
