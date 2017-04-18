package storyboarder;

import java.util.ArrayList;

/**
 * Created by Nathan on 4/15/2017.
 */
public class Category {
    private ArrayList<Property> properties;
    private ArrayList<Card> cards;
    private String name;

    public Category(String categoryName){
        name = categoryName;
        properties = new ArrayList<>();
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

    @Override
    public String toString() {
        //TODO: define method for parsing Categories and writing to file, then write this code
        return "";
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
}
