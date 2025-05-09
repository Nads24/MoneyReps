import org.example.Core;
import org.example.Exercise;
import org.example.Push;
import org.example.Trainer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrainerTest {
    private Trainer trainer;
    private Push push;
    private Core core;


    @Test
    void addOrUpdateExercise_newExercise() {
        trainer.addOrUpdateExercise(push);
        assertEquals(1, trainer.getExercises().size());
    }

    @Test
    void addOrUpdateExercise_replaceExercise() {
        trainer.addOrUpdateExercise(push);
        trainer.addOrUpdateExercise(new Push("Pushup", 5));
        assertEquals(1, trainer.getExercises().size());
        assertEquals(5, trainer.getExercises().get(0).getDifficulty());
    }

    @Test
    void addOrUpdateExercise_multipleUnique() {
        trainer.addOrUpdateExercise(push);
        trainer.addOrUpdateExercise(core);
        assertEquals(2, trainer.getExercises().size());
    }

    @Test
    void assignExerciseToAthlete_basic() {
        trainer.assignExerciseToAthlete("Sam", push);
        List<Exercise> assigned = trainer.getAssignedExercisesForAthlete("Sam");
        assertEquals(1, assigned.size());
    }

    @Test
    void assignExerciseToAthlete_multiple() {
        trainer.assignExerciseToAthlete("Sam", push);
        trainer.assignExerciseToAthlete("Sam", core);
        List<Exercise> assigned = trainer.getAssignedExercisesForAthlete("Sam");
        assertEquals(2, assigned.size());
    }

    @Test
    void assignExerciseToAthlete_noExercises() {
        List<Exercise> assigned = trainer.getAssignedExercisesForAthlete("Unknown");
        assertTrue(assigned.isEmpty());
    }
}