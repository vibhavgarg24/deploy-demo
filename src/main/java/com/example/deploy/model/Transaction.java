package com.example.deploy.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "txn")
public class Transaction {

    private String id;
    private String catId;
    private String userId;
    private double amount;
    private long timestamp;
    private String label;

    public Transaction() {
    }

    public Transaction(String catId, String userId, double amount, long timestamp, String label) {
        this.catId = catId;
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.label = label;
    }

    public Transaction(String id, String catId, String userId, double amount, long timestamp, String label) {
        this.id = id;
        this.catId = catId;
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", catId=" + catId + ", userId=" + userId + ", amount=" + amount
                + ", timestamp=" + timestamp + ", label=" + label + "]";
    }

}
