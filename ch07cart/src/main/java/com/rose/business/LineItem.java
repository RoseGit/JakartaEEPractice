package com.rose.business;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 * Line Item model 
 * @author Rose
 */
public class LineItem implements Serializable{

    private Product product;
    private int quantity;

    /**
     * Default constructor 
     */
    public LineItem() {
    }

    /**
     * Set the product 
     * @param p @see {@link Product}
     */
    public void setProduct(Product p) {
        product = p;
    }

    /**
     * Get the product
     * @return The product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the quantity
     * @param quantity quantity product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get quantity product
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get Total price
     * @return total price for the product 
     */
    public double getTotal() {
        double total = product.getPrice() * quantity;
        return total;
    }

    /**
     * The format from total
     * @return The format from total
     */
    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}
