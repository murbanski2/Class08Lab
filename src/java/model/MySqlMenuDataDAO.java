/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.accessor.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mark
 */
public class MySqlMenuDataDAO implements IMenuDataDAO {

    @Override
    public List getMenuItems() {
        List<Map> rawData = new ArrayList<>();
        List<MenuItem> menu = new ArrayList<>();

        DBAccessor db = new DB_MySql();
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/restaurant";
        String userName = "root";
        String password = "admin";

        try {
            db.openConnection(driverClassName, url,
                    userName, password);

            rawData = db.findRecords("select id, name, price from menu", true);
            for (Map m : rawData) {
                int id = Integer.parseInt(m.get("id").toString());
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
}
