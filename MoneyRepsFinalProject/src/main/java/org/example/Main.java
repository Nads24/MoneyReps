package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main{
private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
    System.out.println("Welcome to MoneyReps!");
    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    System.out.print("Are you an Athlete (A) or Trainer (T)? ");
    String role = scanner.nextLine();

    if (role.equalsIgnoreCase("A")) {
        Athlete athlete = new Athlete(username);
        List<Exercise> availableExercises = new ArrayList<>(Arrays.asList(
                new Push("Push ups", 2),
                new Pull("Pull ups", 3),
                new Core("Planks", 1)
        ));

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Log Exercise");
            System.out.println("2. View Athlete Info");
            System.out.println("3. Add New Exercise");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (mainChoice == 1) {
                System.out.println("\nChoose an exercise:");
                for (int i = 0; i < availableExercises.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    availableExercises.get(i).displayDetails();
                }
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                if (choice > 0 && choice <= availableExercises.size()) {
                    Exercise selectedExercise = availableExercises.get(choice - 1);
                    System.out.print("Enter number of reps: ");
                    int reps = scanner.nextInt();
                    athlete.logExercice(selectedExercise, reps);
                    System.out.println("Logged " + reps + " reps of " + selectedExercise.getName());
                } else {
                    System.out.println("Invalid choice. Try again.");
                }

            } else if (mainChoice == 2) {
                athlete.displayInfo();

            } else if (mainChoice == 3) {
                System.out.print("Enter exercise name: ");
                String exName = scanner.nextLine();
                System.out.print("Enter difficulty level (1-5): ");
                int difficulty = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Type (Push/Pull/Core): ");
                String type = scanner.nextLine();

                Exercise newEx;
                switch (type.toLowerCase()) {
                    case "push":
                        newEx = new Push(exName, difficulty);
                        break;
                    case "pull":
                        newEx = new Pull(exName, difficulty);
                        break;
                    case "core":
                        newEx = new Core(exName, difficulty);
                        break;
                    default:
                        System.out.println("Invalid type. Exercise not added.");
                        continue;
                }
                availableExercises.add(newEx);
                System.out.println("Exercise added successfully.");

            } else if (mainChoice == 4) {
                running = false;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

    } else if (role.equalsIgnoreCase("T")) {
        Trainer trainer = new Trainer(username);
        Exercise pushup = new Push("Standard Pushup", 2);
        trainer.addOrUpdateExercise(pushup);

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. View Trainer Info");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int trainerChoice = scanner.nextInt();

            if (trainerChoice == 1) {
                trainer.displayInfo();
            } else if (trainerChoice == 2) {
                running = false;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

    } else {
        System.out.println("Invalid role entered.");
    }
}

}
