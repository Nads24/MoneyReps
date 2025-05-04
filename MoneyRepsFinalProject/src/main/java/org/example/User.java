package org.example;

public abstract class User {
    protected  int id;
    protected String username;

    public User(String username, int id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public abstract void displayInfo();
}