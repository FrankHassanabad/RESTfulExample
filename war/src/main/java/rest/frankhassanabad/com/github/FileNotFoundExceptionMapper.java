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
    public Response toResponse(FileNotFoundException ex) {
        return Response.status(404).entity(ex.getMessage()).type("text/plain").build();
    }
}
