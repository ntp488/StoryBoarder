package storyboarder;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(creatorVisibility = ANY, fieldVisibility = ANY)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Category {
    private int id = Deck.GenerateID();
    private String name;
    private ArrayList<Property> properties;
    private ArrayList<Card> cards;

    @JsonCreator
    public Category(@JsonProperty("name") String categoryName){
        name = categoryName;
        properties = new ArrayList<>();
        SetCards(new ArrayList<>());
    }

    public void AddProperty(Property property) {
        properties.add(property);
    }

    public void AddCard(Card newCard) {
        GetCards().add(newCard);
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
        categoryAsString = "Category: " + name + "\n" + "ID: " + id + "\n";
        categoryAsString += "   Properties: \n";
        for (Property prop : properties) {
            categoryAsString += "       " + prop.toString() + "\n";
        }
        categoryAsString += "   Cards: \n";
        if (GetCards() != null) {
            for (Card card : GetCards()) {
                categoryAsString += "       " + card.toString() + "\n";
            }
        }
        return categoryAsString;
    }

    public ArrayList<Card> GetCards() {
        return cards;
    }

    public void SetCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
