package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * This tests out the parameters feature of Jersey and
 * REST.
 * Point your browser to http://localhost:8080/users/someName
 * and this will return
 * <pre>
 * UserName entered was:someName
 * </pre>
 * If you point your browser to a different user name like
 * http://localhost:8080/users/someOtherName
 * You will get
 * <pre>
 * UserName entered was:someOtherName
 * </pre>
 *
 * This differs from {@link UserNameParameter} in that this
 * only accepts regular expressions that are alpha or numeric.
 */
@Path("/usersRegEx/{username: [a-zA-Z][a-zA-Z_0-9]*}")
public class UserNameParameterRegEx {
    @GET
    @Produces("text/plain")
    public String getUser(@PathParam("username") String userName) {
        // Return some cliched textual content
        return "UserNameRegEx entered was:" + userName;
    }
}

