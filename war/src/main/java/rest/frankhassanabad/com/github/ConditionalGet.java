package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.*;
import java.math.BigInteger;
import java.net.URI;
import java.security.MessageDigest;
import java.util.Date;

/**
 * TODO
 * This doesn't operate.  This is a work in progress
 */
@Path("conditionalGet")
public class ConditionalGet {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getConditional(@Context Request request, @Context UriInfo ui) {
        EntityTag tag = computeEntityTag(ui.getRequestUri());
        if (request.getMethod().equals("GET")) {
            Response.ResponseBuilder responseBuilder = request.evaluatePreconditions(new Date());
            if (responseBuilder != null) {
                throw new WebApplicationException(responseBuilder.build());
            }
            responseBuilder = Response.ok();
            responseBuilder.expires(new Date(System.currentTimeMillis() + 30000));
            CacheControl cacheControl = new CacheControl();
            responseBuilder.cacheControl(cacheControl);
            responseBuilder.type(MediaType.TEXT_PLAIN);
            responseBuilder.entity("The getConditional called");
            return responseBuilder.build();
        } else {
            throw new WebApplicationException();
        }
    }

    private EntityTag computeEntityTag(URI u) {
        return new EntityTag(computeDigest(u.getRawPath() + u.getRawQuery()));
    }

    private String computeDigest(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            byte[] digest = md.digest(content.getBytes());
            BigInteger bi = new BigInteger(digest);
            return bi.toString(16);
        } catch (Exception e) {
            return "";
        }
    }

}
