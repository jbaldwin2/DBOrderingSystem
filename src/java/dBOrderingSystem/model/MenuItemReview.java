package dBOrderingSystem.model;

import java.util.*;

/**
 * This class is an abstraction of a real beer expert that can make
 * recommendations about beer products based on a itemName preference.
 * 
 * @author  Textbook, with modifications by Jim Lombardo
 * @version 1.02
 */
public class MenuItemReview {
    
    /**
     * Retrieves the beer recommendations.
     * 
     * @param itemName - the itemName preference for beer. NOTE: the itemName is
     * is validated in any way and a String is required.
     * @return a collection of beer products that are appropriate
     * for the preferred beer itemName
     */
    public List getRecommends(String itemName) {
        List recommends = new ArrayList();
        
        if (itemName.equals("Fries")) {
             recommends.add("Steak cut");
             recommends.add("Sweet potato");
             
        } else if (itemName.equals("Steak")) {
            recommends.add("Ribeye");
            recommends.add("NY Strip");
            
        }  else if (itemName.equals("Salad")) {
            recommends.add("Ceaser");
            recommends.add("Cobb");
            
        } else {
            recommends.add("Jail Pale Ale");
            recommends.add("Gout Stout");
        }

        return recommends;
    }
}
