package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

/**
 * Exposes the security scheme of the container if there is
 * one.
 * Use this through
 * <pre>
 * http://localhost:8080/rest/security
 * </pre>
 * and
 * <pre>
 * http://localhost:8080/rest/security/principal
 * </pre>
 */
@Path("security")
public class Security {

    /** Injects the security context */
    private @Context SecurityContext securityContext;

    /**
     * Returns a string of the authentication scheme if
     * there is one through
     * <pre>
     * http://localhost:8080/rest/security
     * </pre>
     * @return The authentication scheme.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getSecurity() {
        if (securityContext.getAuthenticationScheme() != null) {
            return securityContext.getAuthenticationScheme();
        } else {
            return "No Authentication Scheme";
        }
    }

    /**
     * Returns a string of the principal if there is one through
     * <pre>
     * http://localhost:8080/rest/security/principal
     * </pre>
     * @return The authentication scheme.
     */
    @GET
    @Path("principal")
    @Produces(MediaType.TEXT_PLAIN)
    public String getAuth() {
        Principal principal = securityContext.getUserPrincipal();
        if (principal != null) {
            return principal.getName();
        } else {
            return "Security principle is null";
        }
    }
}
