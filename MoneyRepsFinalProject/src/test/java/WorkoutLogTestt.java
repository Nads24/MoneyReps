import org.example.WorkoutLog;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WorkoutLogTestt {
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

