package com.rose.business;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Cart model
 *
 * @author Rose
 */
public class Cart implements Serializable {

    private ArrayList<LineItem> items;

    /**
     * Default constructor
     */
    public Cart() {
        items = new ArrayList<LineItem>();
    }

    /**
     * Get all items in the cart
     *
     * @return all items in the cart
     */
    public ArrayList<LineItem> getItems() {
        return items;
    }

    /**
     * Gets the number of items in the cart
     *
     * @return the number of items in the cart
     */
    public int getCount() {
        return items.size();
    }

    /**
     * Allows you to add an item to the cart
     *
     * @param item @see {@link LineItem}
     */
    public void addItem(LineItem item) {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (LineItem cartItem : items) {
            if (cartItem.getProduct().getCode().equals(code)) {
                cartItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    /**
     * Delete an item from the cart.
     *
     * @param item @see {@link LineItem}
     */
    public void removeItem(LineItem item) {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
}
