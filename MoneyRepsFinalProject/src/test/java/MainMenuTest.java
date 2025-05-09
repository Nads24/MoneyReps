import org.example.Athlete;
import org.example.Push;
import org.example.Trainer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainMenuTest {

    @Test
    void testTrainerAndAthleteRegistration() {
        Trainer t = new Trainer("TrainerOne", 100100);
        Athlete a = new Athlete("AthleteOne", 200200);
        assertEquals("TrainerOne", t.getUsername());
        assertEquals("AthleteOne", a.getUsername());
    }

    @Test
    void testExerciseAssignmentBetweenUsers() {
        Trainer t = new Trainer("TrainerOne", 100100);
        Athlete a = new Athlete("AthleteOne", 200200);
        Push push = new Push("Pushup", 2);
        t.assignExerciseToAthlete(a.getUsername(), push);
        a.assignExercises(t.getAssignedExercisesForAthlete(a.getUsername()));
        assertEquals(1, a.getAssignedExercises().size());
    }

    @Test
    void testLoginRecognitionLogic() {
        Trainer t = new Trainer("LogTester", 303303);
        assertEquals("LogTester", t.getUsername());
        assertEquals(303303, t.getId());
    }
}
