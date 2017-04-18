package storyboarder;

/**
 * Created by Nathan on 4/17/2017.
 */
public class Property {
    private String name;

    public enum PropertyType {
        Number,
    }

    public Property() {

    }

    @Override
    public String toString() {
        return name;
    }
}
