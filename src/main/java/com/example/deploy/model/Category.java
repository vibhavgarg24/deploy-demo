package com.example.deploy.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
public class Category {

    private String id;
    private String userId;
    private String name;
    private double sum;

    public Category() {
    }

    public Category(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.sum = 0;
    }

    public Category(String id, String userId, String name, double sum) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", userId=" + userId + ", name=" + name + ", sum=" + sum + "]";
    }

}
