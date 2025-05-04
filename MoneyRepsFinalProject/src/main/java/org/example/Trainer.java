package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer extends User{
    private List<Exercise> exercises = new ArrayList<>();

    public Trainer(String name) {
        super(name);
    }
    public void addOrUpdateExercise(Exercise exercise){
        exercises = exercises.stream()
                .filter(e -> !e.getName().equalsIgnoreCase(exercise.getName()))
                .collect(Collectors.toList());
        exercises.add(exercise);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    @Override
    public void displayInfo(){
        System.out.println("Trainer Username: " + name);
        System.out.println("Exercises Managed:");
        for (Exercise exercise : exercises){
            exercise.displayDetails();
        }

    }
}

