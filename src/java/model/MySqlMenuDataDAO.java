/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.accessor.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mark
 */
public class MySqlMenuDataDAO implements IMenuDataDAO {

    String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost:3306/restaurant";
    String USER_NAME = "root";
    String PASSWORD = "admin";
    String TABLE = "menu";
    String KEY = "item_id";

    @Override
    public List getMenuItems() {
        List<Map> rawData = new ArrayList<>();
        List<MenuItem> menu = new ArrayList<>();

        DBAccessor db = new DB_MySql();

        try {
            db.openConnection(DRIVER_CLASS_NAME, URL,
                    USER_NAME, PASSWORD);
            String sql = "select item_id, name, price from restaurant.menu";
            rawData = db.findRecords(sql, true);
            for (Map m : rawData) {
                String strId = m.get("item_id").toString();
                int id = Integer.parseInt(strId);
                String name = m.get("name").toString();
                String strPrice = m.get("price").toString();
                double price = Double.parseDouble(strPrice);
                menu.add(new MenuItem(id, name, price));
            }

        } catch (Exception e) {
            System.out.println("Exception in getMenuItems()");
        } finally {
            return menu;
        }
    }

    public List getSelectedMenuItems(String[] choices) {
        List<MenuItem> menu = new ArrayList<>();

        try {
            for (String s : choices) {
                int i = Integer.parseInt(s);
                MenuItem item = getMenuItemByID(i);
                menu.add(item);
            }
        } catch (Exception e) {
            System.out.println("Exception in getSelectedMenuItems()");
        } finally {
            return menu;
        }
    }

    public MenuItem getMenuItemByID(int id) {
        List<Map> rawData = new ArrayList<>();
        MenuItem item = new MenuItem(0, "", 0.0);
        DBAccessor db = new DB_MySql();
        Map rec;

        try {
            db.openConnection(DRIVER_CLASS_NAME, URL,
                    USER_NAME, PASSWORD);
            rec = db.getRecordByID(TABLE, KEY, id, true);

            String strId = rec.get("item_id").toString();
            id = Integer.parseInt(strId);
            String name = rec.get("name").toString();
            String strPrice = rec.get("price").toString();
            double price = Double.parseDouble(strPrice);

            item = new MenuItem(id, name, price);

        } catch (Exception e) {
            System.out.println("Exception in getMenuItems()");
        } finally {
            return item;
        }
    }

    public int deleteMenuItem(int id) {
        DBAccessor db = new DB_MySql();
        int itemsDeleted = 0;

        try {
            db.openConnection(DRIVER_CLASS_NAME, URL,
                    USER_NAME, PASSWORD);
            itemsDeleted = db.deleteRecords(TABLE, "ID", id, true);
        } catch (SQLException e1) {
            //throw new DataAccessException(e1.getMessage(), e1);
            System.out.println("deleteMenuItem: " + e1);

        } catch (Exception e2) {
            //throw new DataAccessException(e2.getMessage(), e2);
            System.out.println("deleteMenuItem: " + e2);
        } finally {
            return itemsDeleted;
        }

    }

    public static void main(String[] args) {
        MySqlMenuDataDAO data = new MySqlMenuDataDAO();
        //Get a menu item by id, where id = 4
        int id = 4;
        MenuItem item = data.getMenuItemByID(id);
        System.out.println(item);
        System.out.println("");

        //Get all menu items
        List<MenuItem> menu = data.getMenuItems();
        Iterator it = menu.iterator();

        while (it.hasNext()) {
            item = (MenuItem) it.next();
            System.out.println(item);
        }
        System.out.println("");

        //Get menu items 1, 4, 7, 9
        String[] choices = {"1", "4", "7", "9"};
        menu = data.getSelectedMenuItems(choices);

        for (MenuItem mi : menu) {
            System.out.println(mi);
        }
    }
}
