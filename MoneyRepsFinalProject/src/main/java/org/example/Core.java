package org.example;

public class Core extends Exercise {

    public Core(String name, int difficulty) {
        super(name, difficulty);
    }

    /**
     * Calculates the earnings (points) based on the number of reps and difficulty.
     * (Uses a formula)
     *
     * @param reps the number of repetitions performed
     * @return the calculated earnings in points
     */
    @Override
    public int calculateEarnings(int reps) {
        return reps * difficulty;
    }

    /**
     * Displays details of the core exercise, including name and difficulty.
     */
    @Override
    public void displayDetails() {
        System.out.println("Core Exercise: " + name + ", Difficulty: " + difficulty);
    }

}
