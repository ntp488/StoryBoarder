package storyboarder;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * Created by Nathan on 4/15/2017.
 */
@JsonAutoDetect(creatorVisibility = ANY, fieldVisibility = ANY)
public class Category {
    private String name;
    private ArrayList<Property> properties;
    private ArrayList<Card> cards;

    @JsonCreator
    public Category(@JsonProperty("name") String categoryName){
        name = categoryName;
        properties = new ArrayList<>();
        cards = new ArrayList<>();
    }

    public void AddProperty(Property property) {
        properties.add(property);
    }

    public void AddCard(Card newCard) {
        cards.add(newCard);
    }

    public String GetName() {
        return name;
    }

    public void SetName(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        String categoryAsString;
        categoryAsString = "Category: " + name + "\n";
        categoryAsString += "   Properties: \n";
        for (Property prop : properties) {
            categoryAsString += "       " + prop.toString() + "\n";
        }
        categoryAsString += "   Cards: \n";
        if (cards != null) {
            for (Card card : cards) {
                categoryAsString += "       " + card.toString() + "\n";
            }
        }
        return categoryAsString;
    }
}
