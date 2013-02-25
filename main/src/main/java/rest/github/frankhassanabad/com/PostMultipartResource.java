package rest.github.frankhassanabad.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.MultiPart;

import javax.ws.rs.core.MediaType;

/**
 * Simple client to post a multi-part object to a service.
 * This uses the service of
 * <pre>
 * http://localhost:8080/rest/resource/multipart/post/strings
 * </pre>
 * This posts the multi-part message which is just two strings
 * with the known names of "string_1" and "string_2".
 */
public class PostMultipartResource {

    /**
     * Main method for the client
     * @param args None are used
     */
    public static void main(String[] args) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/rest/resource/multipart/post/strings");
        FormDataBodyPart string1bodyPart = new FormDataBodyPart("string_1", "My String 1", MediaType.TEXT_PLAIN_TYPE);
        FormDataBodyPart string2bodyPart = new FormDataBodyPart("string_2", "My String 2", MediaType.TEXT_PLAIN_TYPE);
        MultiPart formpart = new FormDataMultiPart().bodyPart(string1bodyPart).bodyPart(string2bodyPart);
        ClientResponse response = resource.type(MediaType.MULTIPART_FORM_DATA).post(ClientResponse.class, formpart);
        int status = response.getStatus();
        System.out.println("status:" + status);
    }

}
