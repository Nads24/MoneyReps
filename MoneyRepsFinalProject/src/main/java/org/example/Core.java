package org.example;

public class Core extends Exercise {

    public Core(String name, int difficulty) {
        super(name, difficulty);
    }

    @Override
    public int calculateEarnings(int reps) {
        return reps * difficulty * 1;
    }

    @Override
    public void displayDetails() {
        System.out.println("Core Exercise: " + name + ", Difficulty: " + difficulty);
    }

}
