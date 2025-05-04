package org.example;

import java.util.ArrayList;
import java.util.List;

public class Athlete extends User {
    private int totalEarnings = 0;
    private List<WorkoutLog> workoutHistory = new ArrayList<>();

    public Athlete(String name) {
        super(name);
    }
    public void logExercice(Exercise exercise, int reps){
        int earned = exercise.calculateEarnings(reps);
        totalEarnings += earned;
        workoutHistory.add(new WorkoutLog(exercise.getName(), reps, earned));
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public List<WorkoutLog> getWorkoutHistory() {
        return workoutHistory;
    }

    @Override
    public void displayInfo(){
        System.out.println("Athlete Username: " + name);
        System.out.println("Total Earnings: " + totalEarnings + " points");
        System.out.println("Workout History:");
        for (WorkoutLog log : workoutHistory) {
            System.out.println(log.getExerciseName() + ": " + log.getReps() + " reps, " + log.getEarnings() + " points");
        }
    }


}

