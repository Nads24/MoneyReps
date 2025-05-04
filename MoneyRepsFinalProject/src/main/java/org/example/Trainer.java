package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Trainer extends User{
    private List<Exercise> exercises = new ArrayList<>();
    private Map<String, List<Exercise>> assignedExercises = new HashMap<>();

    public Trainer(String name) {
        super(name);
    }

    public void addOrUpdateExercise(Exercise exercise) {
        exercises = exercises.stream()
                .filter(e -> !e.getName().equalsIgnoreCase(exercise.getName()))
                .collect(Collectors.toList());
        exercises.add(exercise);
    }

    public void assignExerciseToAthlete(String athleteName, Exercise exercise) {
        assignedExercises.putIfAbsent(athleteName, new ArrayList<>());
        assignedExercises.get(athleteName).add(exercise);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    @Override
    public void displayInfo() {
        System.out.println("Trainer Username: " + name);
        System.out.println("Exercises Managed:");
        for (Exercise exercise : exercises) {
            exercise.displayDetails();
        }
        System.out.println("\nAssigned Exercises:");
        for (String athlete : assignedExercises.keySet()) {
            System.out.println("To " + athlete + ":");
            for (Exercise e : assignedExercises.get(athlete)) {
                e.displayDetails();
            }
        }
    }
}

