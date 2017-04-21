package storyboarder;

import com.fasterxml.jackson.annotation.*;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(creatorVisibility = ANY, fieldVisibility = ANY)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Card {
    private int id = Deck.generateID();
    private String name;
    private String description;
    private Category category;

    @JsonCreator
    public Card(@JsonProperty("name") String newName,
                @JsonProperty("description") String newDescription,
                @JsonProperty("category") Category newCategory) {
        setName(newName);
        description = newDescription;
        category = newCategory;
    }

    @Override
    public String toString() {
        return "--Name: " + name + " --ID: " + id + " --Description: " + description + " --Category: " + category.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
