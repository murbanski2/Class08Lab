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
        menu.add(new MenuItem(1, "Hamburger", 5.99));
        menu.add(new MenuItem(2, "Cheeseburger", 6.99));
        menu.add(new MenuItem(3, "Muffaletta", 7.99));
        menu.add(new MenuItem(4, "Club Sandwich", 7.99));
        menu.add(new MenuItem(5, "French Fries", 1.99));
        menu.add(new MenuItem(6, "Onion Rings", 2.99));
        menu.add(new MenuItem(7, "Soup", 1.99));
        menu.add(new MenuItem(8, "Cold Beverage", 1.99));
        menu.add(new MenuItem(9, "Hot Beverage", 1.99));

        return menu;
    }
    

}
