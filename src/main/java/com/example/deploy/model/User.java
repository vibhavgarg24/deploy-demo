package com.example.deploy.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    private String id;
    private String email;
    private double totalSum;

    public User() {
    }

    public User(String email) {
        this.email = email;
        totalSum = 0;
    }

    public User(String id, String email, double totalSum) {
        this.id = id;
        this.email = email;
        this.totalSum = totalSum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", totalSum=" + totalSum + "]";
    }

}
