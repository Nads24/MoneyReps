# MoneyReps

**MoneyReps** is a command-line Java application that tracks workout reps and rewards users with money based on the difficulty of each exercise. It's designed for fitness enthusiasts and trainers who want a gamified, performance-based tracking system.

---

## Features

- **Athlete Functions**
  - Log exercises and reps completed
  - Earn money based on reps × difficulty
  - View total earnings and workout history

- **Trainer Functions**
  - Add and manage exercises (Push, Pull, Core)
  - Assign workouts to athletes
  - View athlete performance and earnings

- **Exercise Types**
  - Push
  - Pull
  - Core

- **Object-Oriented Design**
  - Inheritance for user types and exercises
  - Interfaces for exercise earnings logic
  - Comparators for sorting athlete performance

---

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── moneyreps/
│               ├── MainMenu.java
│               ├── User.java
│               ├── Athlete.java
│               ├── Trainer.java
│               ├── Exercise.java
│               ├── Push.java
│               ├── Pull.java
│               ├── Core.java
│               ├── WorkoutLog.java
│               ├── Payable.java
│               └── comparators/
│                   ├── EarningsComparator.java
│                   └── RepCountComparator.java
```

---

## Technologies

- Java 17
- Maven
- TextIO (for console I/O)

---

## License

This project is for educational purposes only.
