package org.example;

public class WorkoutLog {
    private String exerciseName;
    private int reps;
    private int earnings;

    public WorkoutLog(String exerciseName, int reps, int earnings) {
        this.exerciseName = exerciseName;
        this.reps = reps;
        this.earnings = earnings;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getEarnings() {
        return earnings;
    }

    public void setEarnings(int earnings) {
        this.earnings = earnings;
    }
}
