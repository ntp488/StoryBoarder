package storyboarder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * Created by Nathan on 4/15/2017.
 */
@JsonAutoDetect(creatorVisibility = ANY, fieldVisibility = ANY)
public class Card {
    private String name;
    private String description;
    private String category;

    @JsonCreator
    public Card(@JsonProperty("name") String newName,
                @JsonProperty("description") String newDescription,
                @JsonProperty("category") String categoryName) {
        name = newName;
        description = newDescription;
        category = categoryName;
    }

    @Override
    public String toString() {
        return "--Name: " + name + " --Description: " + description + " --Category: " + category;
    }
}
