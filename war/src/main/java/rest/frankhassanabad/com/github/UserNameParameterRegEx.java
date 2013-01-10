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
 * This differs from {@link UserNameParameter} in that
 * the username variable will only match user names that
 * begin with one upper or lower case letter and zero or more
 * alpha numeric characters and the underscore character. If a
 * user name does not match that a 404 (Not Found) response
 * will occur.
 */
@Path("/usersRegEx/{username: [a-zA-Z][a-zA-Z_0-9]*}")
public class UserNameParameterRegEx {
    @GET
    @Produces("text/plain")
    public String getUser(@PathParam("username") String userName) {
        return "UserNameRegEx entered was:" + userName;
    }
}

