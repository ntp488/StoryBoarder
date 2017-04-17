package storyboarder;

/**
 * Created by Nathan on 4/15/2017.
 */
public class Card {
    private Category category;
    private String name, description;

    public void SetCategory(Category newCategory) {
        category = newCategory;
    }

    public void SetName(String newName){
        name = newName;
    }

    public void SetDescription(String newDescription) {
        description = newDescription;
    }
}
