package rest.github.frankhassanabad.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

/**
 * This is a client which will get the HelloWorld
 * resource and print it out through system out.
 * This uses the URI resource of
 * <pre>
 * http://localhost:8080/rest/helloworld
 * </pre>
 * to get its hello world string
 * See from the war file the class of
 * HelloWorldResource
 */
public class GetHelloWorld {

    /**
     * Main method for the client
     * @param args None are used
     */
    public static void main(String[] args) {

        //Simple straight forward way to get the hello world response
        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/rest/helloworld");
        String helloWorldResponse = resource.accept(
                MediaType.TEXT_PLAIN).
                get(String.class);
        System.out.println(helloWorldResponse);

        //A lower level way of getting the hello world response in which
        //you can iterate over headers and all kinds of other goodies from
        //the request
        ClientResponse response = resource.get(ClientResponse.class);
        String helloWorldResponseLowLevel = response.getEntity(String.class);
        System.out.println(helloWorldResponseLowLevel);
        System.out.println("Headers returned from the server are:");
        MultivaluedMap<String, String> headers = response.getHeaders();
        for (String header : headers.keySet()) {
            List<String> values = headers.get(header);
            for (String value : values) {
                System.out.println("    " + header + ":" + value);
            }
        }
    }

}
