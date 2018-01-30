package com.example.arturmusayelyan.customviewexample.model;

/**
 * Created by artur.musayelyan on 30/01/2018.
 */

public class Student {
    private String name;
    private String id;
    private String count;

    public Student() {
    }

    public Student(String name, String id, String count) {
        this.name = name;
        this.id = id;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + count;
    }
}
