package storyboarder;

import com.fasterxml.jackson.annotation.*;
import java.util.ArrayList;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(creatorVisibility = ANY, fieldVisibility = ANY)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Category {
    private int id = Deck.generateID();
    private String name;
    private ArrayList<Property> properties;
    private ArrayList<Card> cards;

    @JsonCreator
    public Category(@JsonProperty("name") String categoryName){
        name = categoryName;
        properties = new ArrayList<>();
        setCards(new ArrayList<>());
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void addCard(Card newCard) {
        getCards().add(newCard);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
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
        if (getCards() != null) {
            for (Card card : getCards()) {
                categoryAsString += "       " + card.toString() + "\n";
            }
        }
        return categoryAsString;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
