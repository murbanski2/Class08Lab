/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mark
 */
public class OrderModel {
    private List menu;
    private String[] choices;
    private static final double TAX_RATE = 0.05;
    private static final double TIP_RATE = 0.20;

    public OrderModel(List menu, String[] choices) {
        this.menu = menu;
        this.choices = choices;
    }

    public double getTotal() {
        double total = 0;
        for(String s: choices) {
            int i = Integer.parseInt(s);
            MenuItem item = (MenuItem)menu.get(i);
            total += item.getPrice();
        }
        return total;
    }
    
    public double getTax() {
        
        return getTotal() * TAX_RATE;
    }
    
    public double getTip() {
        return getTotal() * TIP_RATE;
    }
    
    
    public List getMenu() {
        return menu;
    }

    public void setMenu(List menu) {
        this.menu = menu;
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.menu);
        hash = 37 * hash + Arrays.deepHashCode(this.choices);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderModel other = (OrderModel) obj;
        if (!Objects.equals(this.menu, other.menu)) {
            return false;
        }
        if (!Arrays.deepEquals(this.choices, other.choices)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "menu=" + menu + ", choices=" + choices + '}';
    }
    
    
    
}
