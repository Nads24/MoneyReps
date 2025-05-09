import org.example.Core;
import org.example.Exercise;
import org.example.Push;
import org.example.Trainer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainerTest {

    @Test
    void testAddOrUpdateExercise() {
        Trainer trainer = new Trainer("Coach Aminul", 100);
        Push push = new Push("Pushup", 2);
        Core core = new Core("Plank", 1);

        trainer.addOrUpdateExercise(push);
        assertEquals(1, trainer.getExercises().size());

        trainer.addOrUpdateExercise(new Push("Pushup", 3));
        assertEquals(1, trainer.getExercises().size());
        assertEquals(3, trainer.getExercises().get(0).getDifficulty());

        trainer.addOrUpdateExercise(core);
        assertEquals(2, trainer.getExercises().size());
    }

    @Test
    void testAssignExerciseToAthlete() {
        Trainer trainer = new Trainer("Coach Aminul", 100);
        Push push = new Push("Pushup", 2);
        Core core = new Core("Plank", 1);

        trainer.assignExerciseToAthlete("Yi", push);
        trainer.assignExerciseToAthlete("Yi", core);
        List<Exercise> list = trainer.getAssignedExercisesForAthlete("Yi");
        assertEquals(2, list.size());
    }
}
