package storyboarder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(creatorVisibility = ANY, fieldVisibility = ANY)
public class Property {
    private String name;
    private PropertyType type;

    public enum PropertyType {
        Number,
    }

    @JsonCreator
    public Property(@JsonProperty("name") String newName,
                    @JsonProperty("type") PropertyType newType) {
        name = newName;
        type = newType;
    }

    @Override
    public String toString() {
        return "--Name: " + name + " --Type: " + type;
    }
}
