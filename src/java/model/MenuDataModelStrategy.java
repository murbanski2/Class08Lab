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
public interface MenuDataModelStrategy {
    public abstract List getMenuItems();
}
