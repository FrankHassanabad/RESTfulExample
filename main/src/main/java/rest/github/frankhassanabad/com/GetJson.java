package rest.github.frankhassanabad.com;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

import javax.ws.rs.core.MediaType;
import java.util.Random;

/**
 * Simple client to get a Json message and
 * serialize it into a POJO object from
 * a service. This uses the service of
 * <pre>
 * http://localhost:8080/rest/resource/json
 * </pre>
 * See ths class of JsonPostGetResource from the
 * RestfulExample war file
 */
public class GetJson {

    /**
     * Main method for the client
     * @param args None are used
     */
    public static void main(String[] args) {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);
        WebResource resource = client.resource("http://localhost:8080/rest/resource/json");
        resource.accept(MediaType.APPLICATION_JSON);
        JsonObject jsonObject = resource.get(JsonObject.class);
        System.out.println(jsonObject.toString());

    }
}
