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
 */
@Path("/users/{username}")
public class UserNameParameter {
    @GET
    @Produces("text/plain")
    public String getUser(@PathParam("username") String userName) {
        return "UserName entered was:" + userName;
    }
}

