import org.example.Athlete;
import org.example.Core;
import org.example.Push;
import org.example.WorkoutLog;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AthleteTest {
    private Athlete athlete;
    private Push push;
    private Core core;


    @Test
    void logExercise_single() {
        athlete.logExercise(push, 5);
        assertEquals(20, athlete.getTotalEarnings());
    }

    @Test
    void logExercise_multiple() {
        athlete.logExercise(push, 5);
        athlete.logExercise(core, 5);
        assertEquals(25, athlete.getTotalEarnings());
    }

    @Test
    void logExercise_zeroReps() {
        athlete.logExercise(core, 0);
        assertEquals(0, athlete.getTotalEarnings());
    }

    @Test
    void assignExercises_basic() {
        athlete.assignExercises(List.of(push));
        assertEquals(1, athlete.getAssignedExercises().size());
    }

    @Test
    void assignExercises_multiple() {
        athlete.assignExercises(List.of(push, core));
        assertEquals(2, athlete.getAssignedExercises().size());
    }

    @Test
    void assignExercises_empty() {
        athlete.assignExercises(List.of());
        assertEquals(0, athlete.getAssignedExercises().size());
    }
}

class WorkoutLogTest {
    @Test
    void testLogDetails_basic() {
        WorkoutLog log = new WorkoutLog("Situps", 15, 30);
        assertEquals("Situps", log.getExerciseName());
        assertEquals(15, log.getReps());
        assertEquals(30, log.getEarnings());
    }

    @Test
    void testLogDetails_zeroValues() {
        WorkoutLog log = new WorkoutLog("Plank", 0, 0);
        assertEquals(0, log.getReps());
        assertEquals(0, log.getEarnings());
    }

    @Test
    void testLogDetails_negativeEarnings() {
        WorkoutLog log = new WorkoutLog("Burpees", 10, -5);
        assertEquals(-5, log.getEarnings());
    }
}