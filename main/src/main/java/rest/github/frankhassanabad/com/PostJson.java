package rest.github.frankhassanabad.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

import javax.ws.rs.core.MediaType;
import java.util.Random;

/**
 * Simple client to post a JSON object ot a service.
 * This uses the service of
 * <pre>
 * http://localhost:8080/rest/resource/json/post/single
 * </pre>
 * This has two examples.  One shows a string directly
 * being posted and the other shows the object being
 * posted to where the object is turned into a string
 * behind the scenes.
 */
public class PostJson {

    /**
     * Main method for the client
     * @param args None are used
     */
    public static void main(String[] args) {

        //Showing how to post using a direct JSON string
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource resource = client.resource("http://localhost:8080/rest/resource/json/post/single");
        ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,
                "{\"stringAttribute\":\"Changing this string attribute to " +
                "something else\",\"integerAttribue\":0,\"doubleAttribute\":1.5}");
        int status = response.getStatus();
        System.out.println("status:" + status);


        //Now let's do the same exact thing but only this time using the POJO object instead.

        //Create our JSON object for serialization
        Random random = new Random();
        JsonObject jsonObject = new JsonObject();
        jsonObject.setDoubleAttribute(random.nextDouble());
        jsonObject.setIntegerAttribue(random.nextInt());
        jsonObject.setStringAttribute("Serialization object using a custom string that I am utilizing");

        //Post it and report status from the server
        response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonObject);
        status = response.getStatus();
        System.out.println("status:" + status);
    }
}
