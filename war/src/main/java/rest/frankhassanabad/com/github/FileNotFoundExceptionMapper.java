package rest.frankhassanabad.com.github;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.io.FileNotFoundException;

/**
 * Maps in the exception of {@link FileNotFoundException} as a 404
 * Exception for Jersey.
 */
@Provider
public class FileNotFoundExceptionMapper implements ExceptionMapper<FileNotFoundException> {

    /**
     * Method to do the mapping
     * @param exception The exception
     * @return Returns a 404 for this mapping
     */
    public Response toResponse(FileNotFoundException exception) {
        return Response.status(404).entity(exception.getMessage()).type("text/plain").build();
    }
}
