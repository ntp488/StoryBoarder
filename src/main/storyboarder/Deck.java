package storyboarder;

import java.util.ArrayList;

/**
 * Created by Nathan on 4/17/2017.
 */
public class Deck {
    private String name;
    private ArrayList<Category> categories;

    public Deck() {
        name = "DefaultName";
        categories = new ArrayList<>();
        Category people = new Category("Person");
        people.AddProperty(new Property());
        people.AddCard(new Card());
        Category places = new Category("Place");
        places.AddCard(new Card());
        places.AddProperty(new Property());
        Category things = new Category("Things");
        things.AddCard(new Card());
        things.AddProperty(new Property());
        categories.add(people);//person
        categories.add(places);//place
        categories.add(things);//thing
    }

    public String GetName() {
        return name;
    }

    public void SetCategories(ArrayList<Category> categoriesList) {
        categories = categoriesList;
    }

    public ArrayList<Category> GetCategories() {
        return categories;
    }

    public void AddCategory(Category newCategory) {
        categories.add(newCategory);
    }

    public void RemoveCategory(Category categoryToRemove) {
        categories.remove(categoryToRemove);
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
