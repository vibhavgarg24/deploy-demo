package com.example.deploy.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "test")
public class Test {

    private String id;
    private int key;
    private int value;

    public Test() {
    }

    public Test(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Test(String id, int key, int value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Test [id=" + id + ", key=" + key + ", value=" + value + "]";
    }

}
