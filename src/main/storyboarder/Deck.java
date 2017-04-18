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
        categories.add(new Category("Person"));//person
        categories.add(new Category("Place"));//place
        categories.add(new Category("Thing"));//thing

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

}
