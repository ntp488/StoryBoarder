package storyboarder;

import com.fasterxml.jackson.annotation.*;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(creatorVisibility = ANY, fieldVisibility = ANY)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Card {
    private int id = Deck.GenerateID();
    private String name;
    private String description;
    private Category category;

    @JsonCreator
    public Card(@JsonProperty("name") String newName,
                @JsonProperty("description") String newDescription,
                @JsonProperty("category") Category newCategory) {
        SetName(newName);
        description = newDescription;
        category = newCategory;
    }

    @Override
    public String toString() {
        return "--Name: " + GetName() + " --ID: " + id + " --Description: " + description + " --Category: " + category.GetName();
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }
}
