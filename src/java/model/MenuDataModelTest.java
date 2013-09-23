/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.*;
/**
 *
 * @author Mark
 */
public class MenuDataModelTest implements MenuDataModelStrategy{
    @Override
    public List getMenuItems(){
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
