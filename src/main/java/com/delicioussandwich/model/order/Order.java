package com.delicioussandwich.model.order;

import com.delicioussandwich.model.abstractclass.MenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * This a Customer order, containing the choice of food from the menu
 */
public class Order {
    private List<MenuItem> items;
    private Customer customer;

    //Constructor
    public Order(){
        this.items = new ArrayList<>();
    }

    //Getters and Setters
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public void addItem(MenuItem item){
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    /**
     * This lets us take out the first match we find in our list
     * @param itemName the item you want to remove from order
     */
    public void removeItemByName(String itemName){
        for(int i=0; i< items.size(); i++){
            if (items.get(i).getName().equalsIgnoreCase(itemName)){
                items.remove(i);
                break;
            }
        }
    }

    public double calcTotal(){
        double totalPrice = 0.0;
        for (MenuItem item: items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    /**
     *
     * @return a order summary toString
     */
    public String getSummary(){
        String summary = "--- Order Summary ---\n";
        if(customer != null){
            summary += "Customer: " + customer.toString() + "\n";
        }
        int count = 1;
        for (MenuItem item: items){
            summary += count + ". " + item.toString() + "\n";
            count++;
        }
        summary += "Total: $" + String.format("%.2f", calcTotal());
        return summary;
    }


}
