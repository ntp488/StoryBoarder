package storyboarder;

import java.util.ArrayList;

/**
 * Created by Nathan on 4/15/2017.
 */
public class Category {
    private ArrayList<Property> properties;

    public Category(ArrayList<Property> propertyList){
        properties = propertyList;
    }

    public void SetProperties(ArrayList<Property> propertyList){
        properties = propertyList;
    }

    public void AddProperty(Property property) {
        properties.add(property);
    }

    public void RemoveProperty(int index) {
        properties.remove(index);
    }

    @Override
    public String toString() {
        //TODO: define method for parsing Categories and writing to file, then write this code
        return "";
    }
}
