package org.example;

public abstract class Exercise implements Reedemable, Comparable<Exercise>{
    protected String name;
    protected int difficulty;

    public Exercise(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public int getDifficulty() {
        return difficulty;
    }
    public abstract void displayDetails();

    @Override
    public int compareTo(Exercise other) {
        return Integer.compare(this.difficulty, other.difficulty);
    }
}
