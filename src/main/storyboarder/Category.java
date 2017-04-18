package storyboarder;

import java.util.ArrayList;

/**
 * Created by Nathan on 4/15/2017.
 */
public class Category {
    private String name;
    private ArrayList<Property> properties;
    private ArrayList<Card> cards;

    public Category(String categoryName){
        name = categoryName;
        properties = new ArrayList<>();
        cards = new ArrayList<>();
    }

    public Category() {
        name = "DefaultCategoryName";
        properties = new ArrayList<>();
        cards = new ArrayList<>();
    }

    public void SetProperties(ArrayList<Property> propertyList){
        properties = propertyList;
    }

    public void AddProperty(Property property) {
        properties.add(property);
    }

    public void RemoveProperty(Property propertyToRemove) {
        properties.remove(propertyToRemove);
    }

    public void SetCards(ArrayList<Card> cardList) {
        cards = cardList;
    }

    public ArrayList<Card> GetCards() {
        return cards;
    }

    public void AddCard(Card newCard) {
        cards.add(newCard);
    }

    public void RemoveCard(Card cardToRemove) {
        cards.remove(cardToRemove);
    }

    public String GetName() {
        return name;
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
