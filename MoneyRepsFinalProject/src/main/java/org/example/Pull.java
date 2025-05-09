package org.example;

public class Pull extends Exercise {

    public Pull(String name, int difficulty) {
        super(name, difficulty);
    }

    /**
     * Calculates the earnings (points) based on the number of reps and difficulty.
     * (Uses a formula)
     * @param reps the number of repetitions performed
     * @return the calculated earnings in points
     */
    @Override
    public int calculateEarnings(int reps) {
        return reps * difficulty * 3;
    }
    /**
     * Display specific details about the exercises
     */
    @Override
    public void displayDetails() {
        System.out.println("Pull Exercise: " + name + ", Difficulty: " + difficulty);
    }

    @Override
    public int compareTo(Exercise o) {
        return 0;
    }
}
