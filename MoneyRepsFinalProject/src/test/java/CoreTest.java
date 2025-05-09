import org.example.Core;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoreTest {
    private Core core;

    @Test
    void calculateEarnings_basic() {
        assertEquals(10, core.calculateEarnings(10));
    }

    @Test
    void calculateEarnings_zeroReps() {
        assertEquals(0, core.calculateEarnings(0));
    }

    @Test
    void calculateEarnings_negativeReps() {
        assertEquals(-10, core.calculateEarnings(-10));
    }
}
