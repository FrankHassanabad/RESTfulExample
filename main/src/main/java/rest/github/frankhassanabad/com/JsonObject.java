package rest.github.frankhassanabad.com;

/**
 * Json POJO that is serialized back and
 * forth as an example.
 */
public class JsonObject {

    /**
     * Example string attribute
     */
    private String stringAttribute;

    /**
     * Example integer attribute
     */
    private int integerAttribue;

    /**
     * Example double attribute
     */
    private double doubleAttribute;

    /**
     * Default constructor
     */
    public JsonObject() {

    }

    /**
     * Copy constructor
     * @param copy The copy we're drawing from
     */
    public JsonObject(JsonObject copy) {
        this.stringAttribute = copy.stringAttribute;
        this.integerAttribue = copy.integerAttribue;
        this.doubleAttribute = copy.doubleAttribute;
    }

    /**
     * Return ths string attribute
     * @return The string attribute
     */
    public String getStringAttribute() {
        return stringAttribute;
    }

    /**
     * Set the string attribute
     * @param stringAttribute The string attirbute to set
     */
    public void setStringAttribute(String stringAttribute) {
        this.stringAttribute = stringAttribute;
    }

    /**
     * Return the integer attribute
     * @return The integer attribute
     */
    public int getIntegerAttribue() {
        return integerAttribue;
    }

    /**
     * Set the integer attribute
     * @param integerAttribue The integer attribute to set
     */
    public void setIntegerAttribue(int integerAttribue) {
        this.integerAttribue = integerAttribue;
    }

    /**
     * Return the double of the attribute
     * @return The double to return
     */
    public double getDoubleAttribute() {
        return doubleAttribute;
    }

    /**
     * Set the double attribute
     * @param doubleAttribute The double to set
     */
    public void setDoubleAttribute(double doubleAttribute) {
        this.doubleAttribute = doubleAttribute;
    }

    /**
     * Nice pretty toString to display the object
     * @return The string of the object and its internal representation
     */
    @Override
    public String toString() {
        return "JSonObject [\nstringAttribute:" + stringAttribute + "\nintegerAttribue:" + integerAttribue +
                "\ndoubleAttribute:" + doubleAttribute + "\n]";
    }
}
