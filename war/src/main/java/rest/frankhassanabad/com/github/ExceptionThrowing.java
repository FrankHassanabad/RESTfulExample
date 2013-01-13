package rest.frankhassanabad.com.github;

import com.sun.jersey.api.Responses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;

/**
 * Point your browser to http://localhost:8080/rest/exception
 * and this will throw a custom 404 Exception
 */
@Path("exception")
public class ExceptionThrowing {

    /**
     * Method for throwing a custom 404 (Not Found) Exception
     * <pre>
     * http://localhost:8080/rest/exception
     * </pre>
     * @return Nothing, since this immediately throws an exception
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getException() {
        throw new NotFoundException("This is a custom 404 (Not Found) Exception");
    }

    /**
     * Method for throwing a custom 404 (Not Found) Exception which is
     * mapped to FileNotFoundException.
     * <pre>
     * http://localhost:8080/rest/exception/mapper
     * </pre>
     * @return Nothing, since this immediately throws an exception
     * @see FileNotFoundExceptionMapper
     */
    @GET
    @Path("mapper")
    @Produces(MediaType.TEXT_PLAIN)
    public String getExceptionMapper() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    /**
     * Custom extension of the Web application exception which throws
     * a 404 (Not Found) exception
     */
    public class NotFoundException extends WebApplicationException {

        /**
         * Create a HTTP 404 (Not Found) exception.
         */
        public NotFoundException() {
            super(Responses.notFound().build());
        }

        /**
         * Create a HTTP 404 (Not Found) exception.
         * @param message the String that is the entity of the 404 response.
         */
        public NotFoundException(String message) {
            super(Response.status(Responses.NOT_FOUND).
                    entity(message).type("text/plain").build());
        }
    }
}

