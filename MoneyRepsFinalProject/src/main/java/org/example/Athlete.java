package org.example;

import java.util.ArrayList;
import java.util.List;

public class Athlete extends User {
    private int totalEarnings = 0;
    private List<WorkoutLog> workoutHistory = new ArrayList<>();
    private List<Exercise> assignedExercises = new ArrayList<>();

    public Athlete(String username, int id) {
        super(username, id);
    }

    public void logExercise(Exercise exercise, int reps) {
        int earned = exercise.calculateEarnings(reps);
        totalEarnings += earned;
        workoutHistory.add(new WorkoutLog(exercise.getName(), reps, earned));
    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public void assignExercises(List<Exercise> exercises) {
        assignedExercises.addAll(exercises);
    }

    public List<Exercise> getAssignedExercises() {
        return assignedExercises;
    }

    public void displayInfo() {
        System.out.println("Athlete: " + username + " (ID: " + id + ")");
        System.out.println("Total Earnings: " + totalEarnings + " points");
        System.out.println("Workout History:");
        System.out.println("Assigned Exercises:");
            assignedExercises.forEach(Exercise::displayDetails);
        workoutHistory.forEach(log -> System.out.println(log.getExerciseName() + ": " + log.getReps() + " reps, " + log.getEarnings() + " points"));
    }
}


