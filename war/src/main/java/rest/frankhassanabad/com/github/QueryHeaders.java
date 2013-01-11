package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Map;

/**
 * Shows an example of getting the http header information
 * and cookies.
 * The root of the query parameters REST API is
 * <pre>
 * http://localhost:8080/rest/queryHeader
 * </pre>
 *
 * I never use the pathParam defined below.
 *
 * See the methods listed below for the rest of
 * the URI that you will need to construct.
 */
@Path("queryHeader")
public class QueryHeaders {

    /**
     * Shows how to generically retrieve http header information
     * and cookies.
     * An example would be this which has both path parameters and query
     * parameters
     * <pre>
     * http://localhost:8080/rest/queryHeader
     * </pre>
     * @param httpHeaders The http headers which has the header information
     * and cookie information
     * @return A string listing the contents of the header information and
     * the cookie information
     */
    @GET
    public String getHeaderAndCookieInfo(@Context HttpHeaders httpHeaders) {
        MultivaluedMap<String, String> headers = httpHeaders.getRequestHeaders();
        Map<String, Cookie> cookies = httpHeaders.getCookies();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("headers:");
        stringBuilder.append(headers.toString());
        stringBuilder.append("\n    ");
        stringBuilder.append("cookies:");
        stringBuilder.append(cookies.toString());
        return stringBuilder.toString();
    }

}
