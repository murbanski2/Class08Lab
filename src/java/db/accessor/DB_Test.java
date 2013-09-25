/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db.accessor;
import model.*;
import java.util.*;
/**
 *
 * @author Mark
 */
public class DB_Test implements DBTestAccessor{
/**
 * List getAllRecords() gives a list of MenuItem objects.
 * 
 * @return 
 */
    @Override
    public List getAllRecords() {
        List menu = new ArrayList();
        menu.add(new MenuItem("Hamburger", 5.99));
        menu.add(new MenuItem("Cheeseburger", 6.99));
        menu.add(new MenuItem("Muffaletta", 7.99));
        menu.add(new MenuItem("Club Sandwich", 7.99));
        menu.add(new MenuItem("French Fries", 1.99));
        menu.add(new MenuItem("Onion Rings", 2.99));
        menu.add(new MenuItem("Soup", 1.99));
        menu.add(new MenuItem("Cold Beverage", 1.99));
        menu.add(new MenuItem("Hot Beverage", 1.99));

        return menu;
    }
    

}
