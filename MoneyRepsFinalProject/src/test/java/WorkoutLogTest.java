import org.example.WorkoutLog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkoutLogTest {
    @Test
    void testWorkoutLogProperties() {
        WorkoutLog log = new WorkoutLog("Situps", 15, 30);
        assertEquals("Situps", log.getExerciseName());
        assertEquals(15, log.getReps());
        assertEquals(30, log.getEarnings());
    }

    @Test
    void testWorkoutLogZeroValues() {
        WorkoutLog log = new WorkoutLog("Plank", 0, 0);
        assertEquals(0, log.getReps());
        assertEquals(0, log.getEarnings());
    }

}