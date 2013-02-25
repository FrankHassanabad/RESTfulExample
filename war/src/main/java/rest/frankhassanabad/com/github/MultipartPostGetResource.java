package rest.frankhassanabad.com.github;

import com.sun.jersey.multipart.FormDataParam;
import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Example of a singleton resource for in-memory examples of
 * a JSON multi-part resource.
 * For printing your multi-part objects you currently have you would
 * use this URI
 * <pre>
 * http://localhost:8080/rest/resource/multipart
 * </pre>
 *
 * To post to this you would post to the URI of
 * <pre>
 * http://localhost:8080/rest/resource/multipart/post/strings
 * </pre>
 * A simple example of posting would be
 * <pre>
 * Client client = Client.create();
 * WebResource resource = client.resource("http://localhost:8080/rest/resource/multipart/post/strings");
 * //Create our two body parts and form
 * FormDataBodyPart string1bodyPart = new FormDataBodyPart("string_1", "My String 1", MediaType.TEXT_PLAIN_TYPE);
 * FormDataBodyPart string2bodyPart = new FormDataBodyPart("string_2", "My String 2", MediaType.TEXT_PLAIN_TYPE);
 * MultiPart formpart = new FormDataMultiPart().bodyPart(string1bodyPart).bodyPart(string2bodyPart);
 *
 * //Post them
 * ClientResponse response = resource.type(MediaType.MULTIPART_FORM_DATA).post(ClientResponse.class, formpart);
 * int status = response.getStatus();
 * System.out.println("status:" + status);
 * </pre>
 */
@Path("resource/multipart")
@Singleton
public class MultipartPostGetResource {

    /** String resource #1 for our form data post */
    String string1 = "";
    /** String resource #2 for our form data post */
    String string2 = "";

    /**
     * Post the JSON object where the string is automatically
     * serialized by Jersey into a JsonObject.
     * @param postObject The JSON object serialized for us into
     * our json object.
     * @return Return a 201 response which means we accepted it.
     */

    /**
     * Post the multi-part message form with our keys being
     * string_1 and string_2 within our multi-part form.
     * @param string1 The string_1 within our form data.
     * @param string2 The string_2 within our form data.
     * @return OK (201) That we created it.
     */
    @POST
    @Path("/post/strings")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response postMultiPartMessage(
            @FormDataParam("string_1") String string1,
            @FormDataParam("string_2") String string2) {
        this.string1 = string1;
        this.string2 = string2;
        return Response.status(201).build();
    }

    /**
     * This is a GET URI to see the two strings currently in memory.
     * You would go to
     * <pre>
     * http://localhost:8080/rest/resource/multipart
     * </pre>
     * to see the two strings in memory
     * @return The two strings in memory as plain text.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getStrings() {
        return "String1:" + string1 + " String2:" + string2;
    }
}
