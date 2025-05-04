package org.example;

public class Pull extends Exercise{

    public Pull(String name, int difficulty) {
        super(name, difficulty);
    }
    @Override
    public int calculateEarnings(int reps){
        return reps * difficulty * 3;
    }

    @Override
    public void displayDetails() {
        System.out.println("Pull Exercise: " + name + ", Difficulty: " + difficulty);
    }

    @Override
    public int compareTo(Exercise o) {
        return 0;
    }
}
