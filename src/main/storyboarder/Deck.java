package storyboarder;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private String name;
    private ArrayList<Category> categories;
    private static ArrayList ids;
    private static Random random = new Random();
    private boolean hasChanged;

    //TODO: move default deck creation to test class
    public Deck() {
        setName("DefaultName");
        setCategories(new ArrayList<>());
        ids = new ArrayList();
        Category people = new Category("Person");
        people.addProperty(new Property("Health", Property.PropertyType.Number));
        Card person = new Card("Zack", "A real jerk..", people);
        people.addCard(person);

        Category places = new Category("Place");
        places.addProperty(new Property("Zipcode", Property.PropertyType.Number));
        Card place = new Card("Wall-mart", "Where you go for all the things.", places);
        places.addCard(place);

        Category things = new Category("Things");
        things.addProperty(new Property("Weight", Property.PropertyType.Number));
        Card thing = new Card("Rock", "Really more like a pebble.", things);
        things.addCard(thing);

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

    public static int generateID() {
        int temp = random.nextInt(2147483646);
        while (ids.contains(temp)) {
            temp = random.nextInt(2147483646);
        }
        return temp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
}
