package org.example;

public class Push extends Exercise {

    public Push(String name, int difficulty) {
        super(name, difficulty);
    }
    @Override
    public int calculateEarnings(int reps){
        return reps * difficulty* 2;
    }

    @Override
    public void displayDetails() {
        System.out.println("Push Exercise: " + name + ", Difficulty: " + difficulty);
    }

}
