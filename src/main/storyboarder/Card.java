package storyboarder;

import com.fasterxml.jackson.annotation.*;
import java.util.Random;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * Created by Nathan on 4/15/2017.
 */
@JsonAutoDetect(creatorVisibility = ANY, fieldVisibility = ANY)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Card {
    private int id = new Random().nextInt(2147483646);
    private String name;
    private String description;
    private Category category;

    //TODO: create better method of assigning ID property to ensure no duplicates.
    @JsonCreator
    public Card(@JsonProperty("name") String newName,
                @JsonProperty("description") String newDescription,
                @JsonProperty("category") Category newCategory) {
        name = newName;
        description = newDescription;
        category = newCategory;
    }

    @Override
    public String toString() {
        return "--Name: " + name + " --Description: " + description + " --Category: " + category.GetName();
    }
}
