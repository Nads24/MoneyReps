package org.example;

public abstract class User {
    protected int id;
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

    /**
     * Abstract method for displaying user-specific information.
     * Must be implemented by subclasses such as Athlete or Trainer.
     */
    public abstract void displayInfo();
}