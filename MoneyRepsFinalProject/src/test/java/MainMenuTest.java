package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainMenuTest {

    @Test
    void testTrainerAssignsAndAthleteLogsExercises() {
        Trainer trainer = new Trainer("CoachAminul", 100);
        Athlete athlete = new Athlete("Yi", 200);

        Push push = new Push("Pushup", 2); // 10 reps → 10 * 2 * 2 = 40
        Pull pull = new Pull("Pullup", 3); // 5 reps → 5 * 3 * 3 = 45
        Core core = new Core("Plank", 1);  // added later


        trainer.addOrUpdateExercise(push);
        trainer.addOrUpdateExercise(pull);
        trainer.assignExerciseToAthlete(athlete.getUsername(), push);
        trainer.assignExerciseToAthlete(athlete.getUsername(), pull);
        athlete.assignExercises(List.of(push, pull));

        athlete.logExercise(push, 10);// 10 * 2 = 20
        athlete.logExercise(pull, 5);// 5 *3 = 15

        assertEquals(35, athlete.getTotalEarnings());

        Exercise custom = new Core("Crunches", 2); // 8 * 2 = 16
        athlete.assignExercises(List.of(custom));
        athlete.logExercise(custom, 8);

        // 35 + 16 = 51
        assertEquals(51, athlete.getTotalEarnings());
    }
}
