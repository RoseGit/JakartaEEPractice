package com.rose.business;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 * Product model
 *
 * @author Rose
 */
public class Product implements Serializable {

    private String code;
    private String description;
    private double price;

    /**
     * Default constructor
     */
    public Product() {
        code = "";
        description = "";
        price = 0;
    }

    /**
     * Set the code product
     *
     * @param code the code product
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get the code product
     *
     * @return The code product
     */
    public String getCode() {
        return code;
    }

    /**
     * Set description product.
     *
     * @param description The product description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the description code
     *
     * @return The description code
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the product price
     *
     * @param price The product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the product price
     *
     * @return The product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * The price format
     *
     * @return The price format
     */
    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
}
