package rest.frankhassanabad.com.github;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This tests out the parameters feature of Jersey and
 * REST.
 * Point your browser to http://localhost:8080/usersRegEx/someName
 * and this will return
 * <pre>
 * UserName entered was:someName
 * </pre>
 * If you point your browser to a different user name like
 * http://localhost:8080/usersRegEx/someOtherName
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

    /**
     * Called with the url of http://localhost:8080/users/{userName}
     * @param userName The userName from the URL if it matches the regex
     * @return The string from {userName} so that you can see it
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("username") String userName) {
        return "UserNameRegEx entered was:" + userName;
    }
}

