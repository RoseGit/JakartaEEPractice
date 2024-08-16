package com.rose.business;

import java.io.Serializable;

/**
 *User´s model.
 * @author Rose
 */
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String Address;

    /**
     * Default constructor
     */
    public User() {
        firstName = "";
        lastName = "";
        Address = "";
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return Address;
    }

    public void setEmailAddress(String email) {
        this.Address = email;
    }
}
