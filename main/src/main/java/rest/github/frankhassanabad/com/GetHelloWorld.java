package rest.github.frankhassanabad.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

/**
 * This is a client which will get the HelloWorld
 * resource and print it out through system out.
 */
public class GetHelloWorld {

    /**
     * Main method for the client
     * @param args None are used
     */
    public static void main(String[] args) {
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/rest/helloworld");
        String helloWorldResponse = resource.accept(
                MediaType.TEXT_PLAIN).
                get(String.class);
        System.out.println(helloWorldResponse);
    }

}
