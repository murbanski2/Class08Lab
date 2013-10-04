/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mark
 */
public class OrderModel {

    private List<MenuItem> chosenMenuItems;
    private String[] choices;
    private static final double TAX_RATE = 0.05;
    private static final double TIP_RATE = 0.20;
    private static final String TWO_DECIMAL_FORMAT = "#.##";

    public OrderModel(String[] choices) {
        //this.chosenMenuItems = chosenMenuItems;
        this.choices = choices;
        setChosenMenuItemsFromChoices();
    }

    public double getTotal() {
        double total = 0;
        for (MenuItem m : chosenMenuItems) {
            total += m.getPrice();
        }
        return roundTwoDecimals(total);
    }

    public double getTax() {
        double tax = getTotal() * TAX_RATE;
        return roundTwoDecimals(tax);
    }

    public double getTip() {
        double tip = getTotal() * TIP_RATE;
        return roundTwoDecimals(tip);
    }

    public List getChosenMenuItems() {
        return chosenMenuItems;
    }

    public void setChosenMenuItems(List chosenMenuItems) {
        this.chosenMenuItems = chosenMenuItems;
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
        hash = 37 * hash + Objects.hashCode(this.chosenMenuItems);
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
        if (!Objects.equals(this.chosenMenuItems, other.chosenMenuItems)) {
            return false;
        }
        if (!Arrays.deepEquals(this.choices, other.choices)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderModel{" + "menu=" + chosenMenuItems + ", choices=" + choices + '}';
    }

    private void setChosenMenuItemsFromChoices() {
        IMenuDataDAO data = new MySqlMenuDataDAO();
        if (choices != null) {
            chosenMenuItems = data.getSelectedMenuItems(choices);
        }
    }

    private double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat(TWO_DECIMAL_FORMAT);
        return Double.valueOf(twoDForm.format(d));
    }
}
