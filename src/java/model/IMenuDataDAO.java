/**
 * This is the interface between Menu Data implementations and the Menu Controller.
 * 
 */
package model;

import java.util.List;

/**
 *
 * @author Mark
 */
public interface IMenuDataDAO {
    public abstract List getMenuItems();
    public abstract List getSelectedMenuItems(String[] choices);
    public abstract MenuItem getMenuItemByID(int id);
}
