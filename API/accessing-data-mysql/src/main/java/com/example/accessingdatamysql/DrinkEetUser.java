package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Make table out of class
public class DrinkEetUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer UserID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Password;

    public Integer getId() {
        return UserID;
    }

    public void setId(Integer id) {
        this.UserID = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
