package org.example;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<Integer, Athlete> athletes = new HashMap<>();
    private static final Map<Integer, Trainer> trainers = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nEnter username (or type 'exit'): ");
            String username = scanner.nextLine();
            if (username.equalsIgnoreCase("exit")) break;

            System.out.print("Enter your ID: ");
            String idInput = scanner.nextLine();
            int id;
            try {
                id = Integer.parseInt(idInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID.");
                continue;
            }

            User user = null;
            if (athletes.containsKey(id) && athletes.get(id).getUsername().equalsIgnoreCase(username)) {
                user = athletes.get(id);
            } else if (trainers.containsKey(id) && trainers.get(id).getUsername().equalsIgnoreCase(username)) {
                user = trainers.get(id);
            }

            if (user == null) {
                System.out.print("Username not found. Register as Trainer (T) or Athlete (A): ");
                String role = scanner.nextLine();
                if (role.equalsIgnoreCase("T")) {
                    Trainer newTrainer = new Trainer(username, id);
                    trainers.put(id, newTrainer);
                    user = newTrainer;
                } else if (role.equalsIgnoreCase("A")) {
                    Athlete newAthlete = new Athlete(username, id);
                    athletes.put(id, newAthlete);
                    user = newAthlete;
                } else {
                    System.out.println("Invalid role.");
                    continue;
                }
            }

            System.out.println("Welcome back, " + user.getUsername() + "! Your ID is " + user.getId());

            if (user instanceof Trainer) runTrainer((Trainer) user);
            else if (user instanceof Athlete) runAthlete((Athlete) user);
        }
    }

    private static void runAthlete(Athlete athlete) {
        List<Exercise> customExercises = new ArrayList<>(List.of(
                new Push("Standard Pushup", 2),
                new Pull("Wide Pullup", 3),
                new Core("Plank", 1)
        ));

        while (true) {
            System.out.println("\n--- Athlete Menu ---");
            System.out.println("1. Log Exercise");
            System.out.println("2. View Info");
            System.out.println("3. Add Exercise");
            System.out.println("4. Logout");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                for (int i = 0; i < customExercises.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    customExercises.get(i).displayDetails();
                }
                System.out.print("Select exercise: ");
                int idx = Integer.parseInt(scanner.nextLine());
                if (idx < 1 || idx > customExercises.size()) {
                    System.out.println("Invalid."); continue;
                }
                System.out.print("Reps: ");
                int reps = Integer.parseInt(scanner.nextLine());
                athlete.logExercise(customExercises.get(idx - 1), reps);
            } else if (choice == 2) {
                athlete.displayInfo();
            } else if (choice == 3) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Difficulty (1-5): ");
                int difficulty = Integer.parseInt(scanner.nextLine());
                System.out.print("Type (Push/Pull/Core): ");
                String type = scanner.nextLine().toLowerCase();
                Exercise ex = switch (type) {
                    case "push" -> new Push(name, difficulty);
                    case "pull" -> new Pull(name, difficulty);
                    case "core" -> new Core(name, difficulty);
                    default -> null;
                };
                if (ex != null) {
                    customExercises.add(ex);
                    System.out.println("Exercise added.");
                } else System.out.println("Invalid type.");
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private static void runTrainer(Trainer trainer) {
        while (true) {
            System.out.println("\n--- Trainer Menu ---");
            System.out.println("1. View Info");
            System.out.println("2. Add Exercise");
            System.out.println("3. Assign Exercise");
            System.out.println("4. Logout");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice == 1) {
                trainer.displayInfo();
            } else if (choice == 2) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Difficulty (1-5): ");
                int difficulty = Integer.parseInt(scanner.nextLine());
                System.out.print("Type (Push/Pull/Core): ");
                String type = scanner.nextLine().toLowerCase();
                Exercise ex = switch (type) {
                    case "push" -> new Push(name, difficulty);
                    case "pull" -> new Pull(name, difficulty);
                    case "core" -> new Core(name, difficulty);
                    default -> null;
                };
                if (ex != null) {
                    trainer.addOrUpdateExercise(ex);
                    System.out.println("Exercise added/updated.");
                } else System.out.println("Invalid type.");
            } else if (choice == 3) {
                System.out.print("Athlete name: ");
                String name = scanner.nextLine();
                Athlete athlete = null;
                for (Athlete a : athletes.values()) {
                    if (a.getUsername().equalsIgnoreCase(name)) {
                        athlete = a;
                        break;
                    }
                }
                if (athlete == null) {
                    System.out.println("Athlete not found.");
                    continue;
                }
                List<Exercise> exs = trainer.getExercises();
                if (exs.isEmpty()) {
                    System.out.println("No exercises to assign.");
                    continue;
                }
                for (int i = 0; i < exs.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    exs.get(i).displayDetails();
                }
                System.out.print("Select exercise: ");
                int idx = Integer.parseInt(scanner.nextLine());
                if (idx < 1 || idx > exs.size()) {
                    System.out.println("Invalid.");
                    continue;
                }
                trainer.assignExerciseToAthlete(name, exs.get(idx - 1));
                System.out.println("Assigned.");
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
