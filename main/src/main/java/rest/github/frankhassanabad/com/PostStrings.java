package rest.github.frankhassanabad.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.xml.ws.Response;
import java.util.Random;

/**
 * Simple client to post a string and a random number
 * to the service.  This uses the service of
 * <pre>
 * http://localhost:8080/rest/resource/strings/post/single
 * </pre>
 * See ths class of StringPostGetResource from the
 * RestfulExample war file
 */
public class PostStrings {

    /**
     * Main method for the client
     * @param args None are used
     */
    public static void main(String[] args) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/rest/resource/strings/post/single");
        //Post the string typical without a care in the world about the return code.
        resource.post("A single String with random number of:" + new Random().nextInt());

        //Now post the string and return the status code which should be 201 for success
        ClientResponse response = resource.post(ClientResponse.class, "A single String with random number of:" + new Random().nextInt());
        int status = response.getStatus();
        System.out.println("Return status code is:" + status);
    }
}
