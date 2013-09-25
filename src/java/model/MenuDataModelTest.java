/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import db.accessor.*;
import java.util.*;
/**
 *
 * @author Mark
 */
public class MenuDataModelTest implements IMenuDataDAO{
    @Override
    public List getMenuItems(){
        DBTestAccessor db = new DB_Test();
        List menu = new ArrayList();
        
        menu = db.getAllRecords();
        return menu;
    }
    

}
