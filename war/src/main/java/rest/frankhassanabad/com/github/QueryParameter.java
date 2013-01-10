package rest.frankhassanabad.com.github;

import javax.ws.rs.*;
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Shows an example of using query parameters.
 * The root of the query parameters REST API is
 * <pre>
 * http://localhost:8080/rest/query
 * </pre>
 *
 * See the methods listed below for the rest of
 * the URI that you will need to construct.
 */
@Path("query")
public class QueryParameter {

    /**
     * Returns a string of the query parameter "param".
     * If the query param is not passed in then this uses
     * as default of "Nothing set in the parameter".
     * Example use is
     * <pre>
     * http://localhost:8080/rest/query/string?param=Some%20Parameter
     * </pre>
     * @param param The parameter from the "?param=" part of the URI
     * @return Echos back the parameter
     */
    @Path("string")
    @GET
    @Produces("text/plain")
    public String getString(@DefaultValue("Nothing set in the parameter") @QueryParam("param") String param) {
        return "The parameter set was: " + param;
    }

    /**
     * Returns a string of the query parameter "param".
     * If the query param is not passed in then this uses
     * as default of "Nothing set in the parameter".
     * Example use is
     * <pre>
     * http://localhost:8080/rest/query/strings?param=Here%20is%20one&param=Here%20is%20two
     * </pre>
     * @param params The parameter from the "?param=" part of the URI
     * @return Echos back the parameter
     */
    @Path("strings")
    @GET
    @Produces("text/plain")
    public String getStrings(@DefaultValue("Nothing set in the parameter") @QueryParam("param") List<String> params) {
        StringBuilder returnString = new StringBuilder("The parameters set were:\n");
        for (String parameter : params) {
            returnString.append(parameter);
            returnString.append("\n");
        }
        return returnString.toString();
    }

    /**
     * Returns a string of the query parameter "color".
     * If the query param is not passed in then this uses
     * a default of white as if you had called in code Color.white.
     * This illustrates similarly to the Jersey guide that you have to
     * sometimes extend an existing class to have a constructor which
     * takes a string.
     * Example use is
     * <pre>
     * http://localhost:8080/rest/query/color?colorParam=yellow
     * </pre>
     * @param colorParam The color parameter from the "?colorParam=" part of the URI
     * @return Echos back the red green and blue of the color choosen.
     */
    @Path("color")
    @GET
    @Produces("text/plain")
    public String getColor(@DefaultValue("white") @QueryParam("colorParam") ColorParam colorParam) {
        Color color = colorParam.getColor();
        return "The rgb of the color passed in is: r:" +
                color.getRed() + "b:" + color.getBlue() + "g:" + color.getGreen();
    }

    /**
     * Example extension class where I had to add a
     * constructor which takes a String so that I could utilize
     * the underlying color class.
     */
    public static class ColorParam {
        /** The color class I'm wrapping */
        private final Color color;

        /**
         * Constructor with a string so that I can use the QueryParam
         * from Jersey
         * @param colorString The color string that should be something
         * such as white, yellow, blue, black, etc..
         */
        public ColorParam(String colorString) {
            color = new Color(getRGB(colorString));
        }

        /**
         * Returns the wrapped color
         * @return The wrapped color
         */
        public Color getColor() {
            return this.color;
        }

        /**
         * Parses the string for the color code.
         * @param s The parameter should be a simple
         * name such as yellow, white, green
         * @return The color code or an exception of 400
         * if the color is not found.
         */
        private static int getRGB(String s) {
            try {
                Field f = Color.class.getField(s);
                return ((Color) f.get(null)).getRGB();
            } catch (Exception e) {
                throw new WebApplicationException(400);
            }
        }
    }

}
