package com.rose.business;

import java.io.Serializable;

/**
 * User´s model.
 *
 * @author rose
 */
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;

    /**
     * Default constructor
     */
    public User() {
        firstName = "";
        lastName = "";
        email = "";
    }

    /**
     * Initialize objets for User
     *
     * @param firstName
     * @param lastName
     * @param email
     */
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Returns the value of the first name attribute.
     *
     * @return The value of first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the first name attribute.
     *
     * @param firstName The new value for the first name attribute.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the value of the last name attribute.
     *
     * @return The value of last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the last name attribute.
     *
     * @param lastName The new value for the last name attribute.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the value of the email attribute.
     *
     * @return The value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email attribute.
     *
     * @param email The new value for the email attribute.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
