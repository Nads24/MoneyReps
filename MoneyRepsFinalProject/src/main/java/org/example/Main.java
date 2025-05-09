package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Trainer trainer = new Trainer("CoachAminul", 100);
        Athlete athlete = new Athlete("Yi", 200);

        Map<Integer, Athlete> athletes = new HashMap<>();
        Map<Integer, Trainer> trainers = new HashMap<>();
        athletes.put(athlete.getId(), athlete);
        trainers.put(trainer.getId(), trainer);

        Push push = new Push("Pushup", -2);
        Pull pull = new Pull("Pullup", 3);
        Core core = new Core("Plank", 1);

        trainer.addOrUpdateExercise(push);
        trainer.addOrUpdateExercise(pull);
        trainer.addOrUpdateExercise(core);

        trainer.assignExerciseToAthlete(athlete.getUsername(), push);
        trainer.assignExerciseToAthlete(athlete.getUsername(), pull);
        athlete.assignExercises(List.of(push, pull));

        athlete.logExercise(push, -10); // 10 reps
        athlete.logExercise(pull, 5);  // 5 reps

        System.out.println("--- Trainer Info ---");
        trainer.displayInfo();

        System.out.println("\n--- Athlete Info ---");
        athlete.displayInfo();

        Exercise custom = new Core("Crunches", 2);
        athlete.assignExercises(List.of(custom));
        athlete.logExercise(custom, 8);

        System.out.println("\n--- Updated Athlete Info ---");
        athlete.displayInfo();
    }
}