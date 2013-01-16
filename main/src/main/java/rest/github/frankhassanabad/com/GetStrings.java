package rest.github.frankhassanabad.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * Simple client to get a string message from
 * a service. This uses the service of
 * <pre>
 * http://localhost:8080/rest/resource/strings
 * </pre>
 * See ths class of StringPostGetResource from the
 * RestfulExample war file
 */
public class GetStrings {

    /**
     * Main method for the client
     * @param args None are used
     */
    public static void main(String[] args) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/rest/resource/strings");
        String strings = resource.get(String.class);
        System.out.println(strings);

    }
}
