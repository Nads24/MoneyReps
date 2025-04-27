package org.example;

import java.util.ArrayList;
import java.util.List;

public class Athlete extends User {
    private int totalEarnings = 0;
    private List<WorkoutLog> workoutHistory = new ArrayList<>();

    public Athlete(String name, int age) {
        super(name, age);
    }
    public void logExercice(Exercise exercise, int reps){

    }

    public int getTotalEarnings() {
        return totalEarnings;
    }

    public List<WorkoutLog> getWorkoutHistory() {
        return workoutHistory;
    }

    @Override
    public void displayInfo(){

    }


}

