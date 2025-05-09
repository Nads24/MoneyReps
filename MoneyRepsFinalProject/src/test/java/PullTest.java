import org.example.Pull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PullTest {
    private Pull pull;

    @Test
    void calculateEarnings_basic() {
        assertEquals(45, pull.calculateEarnings(5));
    }

    @Test
    void calculateEarnings_zeroReps() {
        assertEquals(0, pull.calculateEarnings(0));
    }

    @Test
    void calculateEarnings_negativeReps() {
        assertEquals(-45, pull.calculateEarnings(-5));
    }
}