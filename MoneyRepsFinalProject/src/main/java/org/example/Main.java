package org.example;

import java.util.*;

public class Main{
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Athlete> athletes = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MoneyReps Main Menu ---");
            System.out.print("Enter name (or 'exit' to quit): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) break;

            System.out.print("Are you an Athlete (A) or Trainer (T)? ");
            String role = scanner.nextLine();

            if (role.equalsIgnoreCase("A")) {
                Athlete athlete = athletes.computeIfAbsent(name, Athlete::new);
                runAthleteSession(athlete);
            } else if (role.equalsIgnoreCase("T")) {
                Trainer trainer = new Trainer(name);
                runTrainerSession(trainer);
            } else {
                System.out.println("Invalid role. Try again.");
            }
        }
    }

    private static void runAthleteSession(Athlete athlete) {
        List<Exercise> availableExercises = new ArrayList<>(Arrays.asList(
                new Push("Standard Pushup", 2),
                new Pull("Wide Pullup", 3),
                new Core("Plank", 1)
        ));

        boolean running = true;
        while (running) {
            System.out.println("\n--- Athlete Menu ---");
            System.out.println("1. Log Exercise");
            System.out.println("2. View Athlete Info");
            System.out.println("3. Add New Exercise");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\nChoose an exercise:");
                    for (int i = 0; i < availableExercises.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        availableExercises.get(i).displayDetails();
                    }
                    System.out.print("Enter your choice: ");
                    int exChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (exChoice > 0 && exChoice <= availableExercises.size()) {
                        Exercise selected = availableExercises.get(exChoice - 1);
                        System.out.print("Enter number of reps: ");
                        int reps = scanner.nextInt();
                        scanner.nextLine();
                        athlete.logExercise(selected, reps);
                        System.out.println("Logged " + reps + " reps of " + selected.getName());
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 2:
                    athlete.displayInfo();
                    break;
                case 3:
                    System.out.print("Enter exercise name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter difficulty (1-5): ");
                    int diff = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Type (Push/Pull/Core): ");
                    String type = scanner.nextLine();
                    Exercise newEx;
                    switch (type.toLowerCase()) {
                        case "push": newEx = new Push(name, diff); break;
                        case "pull": newEx = new Pull(name, diff); break;
                        case "core": newEx = new Core(name, diff); break;
                        default: System.out.println("Invalid type."); continue;
                    }
                    availableExercises.add(newEx);
                    System.out.println("Exercise added.");
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void runTrainerSession(Trainer trainer) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Trainer Menu ---");
            System.out.println("1. View Trainer Info");
            System.out.println("2. Add or Update Exercise");
            System.out.println("3. Assign Exercise to Athlete");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    trainer.displayInfo();
                    break;
                case 2:
                    System.out.print("Enter exercise name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter difficulty (1-5): ");
                    int diff = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Type (Push/Pull/Core): ");
                    String type = scanner.nextLine();
                    Exercise newEx;
                    switch (type.toLowerCase()) {
                        case "push": newEx = new Push(name, diff); break;
                        case "pull": newEx = new Pull(name, diff); break;
                        case "core": newEx = new Core(name, diff); break;
                        default: System.out.println("Invalid type."); continue;
                    }
                    trainer.addOrUpdateExercise(newEx);
                    System.out.println("Exercise added/updated.");
                    break;
                case 3:
                    System.out.print("Enter athlete username to assign to: ");
                    String athleteName = scanner.nextLine();
                    Athlete athlete = athletes.get(athleteName);
                    if (athlete == null) {
                        System.out.println("Athlete not found.");
                        break;
                    }
                    List<Exercise> trainerExs = trainer.getExercises();
                    if (trainerExs.isEmpty()) {
                        System.out.println("No exercises to assign.");
                        break;
                    }
                    for (int i = 0; i < trainerExs.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        trainerExs.get(i).displayDetails();
                    }
                    System.out.print("Enter exercise number to assign: ");
                    int exIdx = scanner.nextInt();
                    scanner.nextLine();
                    if (exIdx > 0 && exIdx <= trainerExs.size()) {
                        trainer.assignExerciseToAthlete(athleteName, trainerExs.get(exIdx - 1));
                        System.out.println("Exercise assigned to " + athleteName);
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

}
