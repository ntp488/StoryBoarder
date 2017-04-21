package storyboarder;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private String name;
    private ArrayList<Category> categories;
    private static ArrayList ids;
    private static Random random = new Random();

    //TODO: move default deck creation to test class
    public Deck() {
        SetName("DefaultName");
        SetCategories(new ArrayList<>());
        ids = new ArrayList();
        Category people = new Category("Person");
        people.AddProperty(new Property("Health", Property.PropertyType.Number));
        Card person = new Card("Zack", "A real jerk..", people);
        people.AddCard(person);

        Category places = new Category("Place");
        places.AddProperty(new Property("Zipcode", Property.PropertyType.Number));
        Card place = new Card("Wall-mart", "Where you go for all the things.", places);
        places.AddCard(place);

        Category things = new Category("Things");
        things.AddProperty(new Property("Weight", Property.PropertyType.Number));
        Card thing = new Card("Rock", "Really more like a pebble.", things);
        things.AddCard(thing);

        GetCategories().add(people);//person
        GetCategories().add(places);//place
        GetCategories().add(things);//thing
    }

    @Override
    public String toString() {
        String deckAsString;
        deckAsString = "Deck: " + GetName() + "\n";
        for (Category cat : GetCategories()) {
            deckAsString += cat.toString();
        }
        return deckAsString;
    }

    public static int GenerateID() {
        int temp = random.nextInt(2147483646);
        while (ids.contains(temp)) {
            temp = random.nextInt(2147483646);
        }
        return temp;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public ArrayList<Category> GetCategories() {
        return categories;
    }

    public void SetCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
