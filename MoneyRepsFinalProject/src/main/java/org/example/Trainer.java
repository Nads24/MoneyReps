package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Trainer extends User {
    private List<Exercise> exercises = new ArrayList<>();
    private Map<String, List<Exercise>> assignedExercises = new HashMap<>();

    public Trainer(String username, int id) {
        super(username);
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

    public void displayInfo() {
        System.out.println("Trainer: " + username + " (ID: " + id + ")");
        System.out.println("Exercises Managed:");
        exercises.forEach(Exercise::displayDetails);
        System.out.println("Assigned Exercises:");
        for (Map.Entry<String, List<Exercise>> entry : assignedExercises.entrySet()) {
            System.out.println("To " + entry.getKey() + ":");
            entry.getValue().forEach(Exercise::displayDetails);
        }
    }
}