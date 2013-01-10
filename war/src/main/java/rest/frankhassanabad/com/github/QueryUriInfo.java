package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

/**
 * Shows an example of using query and path parameters
 * utilizing the UriInfo with the Context annotation.
 * The root of the query parameters REST API is
 * <pre>
 * http://localhost:8080/rest/queryUri
 * </pre>
 *
 * I never use the pathParam defined below.
 *
 * See the methods listed below for the rest of
 * the URI that you will need to construct.
 * @see QueryParameter
 */
@Path("queryUri/{pathParam}")
public class QueryUriInfo {

    /**
     * Shows how to generically retrieve path parameters as well as
     * query parameters.
     * An example would be this which has both path parameters and query
     * parameters
     * <pre>
     * http://localhost:8080/rest/queryUri/madeUpPath?hello=world&another=param
     * </pre>
     * @param ui The UriInfo which has the path parameters and the query parameters
     * @return A string listing the contents of both
     */
    @GET
    public String getUriInfo(@Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("queryParams:");
        stringBuilder.append(queryParams.toString());
        stringBuilder.append("\n    ");
        stringBuilder.append("pathParams:");
        stringBuilder.append(pathParams.toString());
        return stringBuilder.toString();
    }

}
