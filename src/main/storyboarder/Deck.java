package storyboarder;

import java.util.ArrayList;

/**
 * Created by Nathan on 4/17/2017.
 */
public class Deck {
    private String name;
    private ArrayList<Category> categories;

    //TODO: move default deck creation to test class
    public Deck() {
        name = "DefaultName";
        categories = new ArrayList<>();
        Category people = new Category("Person");
        people.AddProperty(new Property("Health", Property.PropertyType.Number));
        Card person = new Card("Zack", "A real jerk..", people.GetName());
        people.AddCard(person);

        Category places = new Category("Place");
        places.AddProperty(new Property("Zipcode", Property.PropertyType.Number));
        Card place = new Card("Wall-mart", "Where you go for all the things.", places.GetName());
        places.AddCard(place);

        Category things = new Category("Things");
        things.AddProperty(new Property("Weight", Property.PropertyType.Number));
        Card thing = new Card("Rock", "Really more like a pebble.", things.GetName());
        things.AddCard(thing);

        categories.add(people);//person
        categories.add(places);//place
        categories.add(things);//thing
    }

    @Override
    public String toString() {
        String deckAsString;
        deckAsString = "Deck: " + name + "\n";
        for (Category cat : categories) {
            deckAsString += cat.toString();
        }
        return deckAsString;
    }

}
