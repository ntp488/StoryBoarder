package storyboarder;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Nathan on 4/15/2017.
 */
public class Card {
    private String name;
    private String description;
    private String category;

    public Card(String categoryName) {
        name = "DefaultCardName";
        description = "Default description.";
        category = categoryName;
    }

    public void SetCategory(Category newCategory) {
        //category = newCategory;
    }

    public void SetName(String newName){
        name = newName;
    }

    public void SetDescription(String newDescription) {
        description = newDescription;
    }

    @Override
    public String toString() {
        return name;
    }
}
