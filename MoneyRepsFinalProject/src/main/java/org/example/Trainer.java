package org.example;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends User{
    private List<Exercise> exercises = new ArrayList<>();

    public Trainer(String name, int age) {
        super(name, age);
    }
    public void addOrUpdateExercise(Exercise exercise){

    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    @Override
    public void displayInfo(){

    }
}
