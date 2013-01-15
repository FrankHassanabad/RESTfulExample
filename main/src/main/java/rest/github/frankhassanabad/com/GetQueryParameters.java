package rest.github.frankhassanabad.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * This sends multiple query parameters
 * through the resource URI of
 * <pre>
 * http://localhost:8080/rest/query/strings
 * </pre>
 * See from the war file the class of
 * QueryParameter
 */
public class GetQueryParameters {

    /**
     * Main method for the client
     * @param args None are used
     */
    public static void main(String[] args) {

        Client client = Client.create();
        WebResource resource = client.resource("http://localhost:8080/rest/query/strings");
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("param", "Here is one parameter");
        params.add("param", "Here is two parameters");
        String helloWorldResponse = resource.queryParams(params).accept(
                MediaType.TEXT_PLAIN).
                get(String.class);
        System.out.println(helloWorldResponse);
    }
}
